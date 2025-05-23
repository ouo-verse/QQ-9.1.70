package com.tencent.biz.richframework.network;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.ResponseSourceType;
import com.tencent.biz.richframework.network.request.VSRequestStrategy;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetworkHelper {
    public static final String CACHE_TAG = "VSNetworkHelper| Protocol Cache";
    private static final int DELAY_NETWORK_UNAVAILABLE = 200;
    public static final String ERROR_CACHE_PREFIX = "_VSNetworkHelperCache";
    public static final String ERROR_TIMEOUT_PREFIX = "_VSNetworkHelperTimeOut";
    public static final String TAG = "VSNetworkHelper";
    private static final VSDispatchObserver mDispatchObserver = new VSDispatchObserver();
    private static volatile VSNetworkHelper sInstance;
    private volatile VSBaseNetwork mNetworkImpl;
    private final OnReceivedCall mReceivedCall = new OnReceivedCall();
    private VSRequestStrategy mVSRequestStrategy;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class OnReceivedCall {
        public void onReceived(BaseRequest baseRequest, boolean z16, byte[] bArr) {
            VSNetworkHelper.getDispatchObserver().onReceive(baseRequest.getContextHashCode(), z16, baseRequest, bArr);
        }
    }

    VSNetworkHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRealSendRequest(BaseRequest baseRequest) {
        if (baseRequest.getResponseSourceType() == 2 || getVSRequestStrategy().isForbiddenRequest(baseRequest)) {
            return false;
        }
        return true;
    }

    public static VSDispatchObserver getDispatchObserver() {
        return mDispatchObserver;
    }

    public static VSNetworkHelper getInstance() {
        if (sInstance == null) {
            synchronized (VSNetworkHelper.class) {
                if (sInstance == null) {
                    sInstance = new VSNetworkHelper();
                }
            }
        }
        return sInstance;
    }

    @NonNull
    private VSBaseNetwork initNetWork() {
        if (this.mNetworkImpl == null) {
            synchronized (VSNetworkHelper.class) {
                if (this.mNetworkImpl == null) {
                    this.mNetworkImpl = (VSBaseNetwork) RFWDelegate.getDelegate(VSBaseNetwork.class, true);
                    this.mNetworkImpl.onInit();
                }
            }
        }
        return this.mNetworkImpl;
    }

    public static boolean isProtocolCache(String str) {
        if (str != null) {
            return str.startsWith(ERROR_CACHE_PREFIX);
        }
        return false;
    }

    public static boolean isTimeOutRetCode(int i3) {
        if (i3 == -100001) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onInterceptSendRequest(final int i3, final BaseRequest baseRequest) {
        if (baseRequest.getRetryCount() <= 0 && !RFWNetworkUtils.isNetworkAvailable(RFWApplication.getApplication())) {
            responseCache(baseRequest);
            getDispatchObserver().getMainThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.richframework.network.VSNetworkHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    VSNetworkHelper.getDispatchObserver().onReceive(i3, false, baseRequest, null);
                }
            }, 200L);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printRequest(int i3, BaseRequest baseRequest) {
        if (RFWLog.isColorLevel()) {
            RFWLog.i(TAG, RFWLog.USR, "VSNetworkHelper: sendRequest: success, onSend Info: contextHashCode:" + i3 + ",| CmdName:" + baseRequest.getCmdName() + ",| TraceId:" + baseRequest.getTraceId() + ",| seq:" + baseRequest.getCurrentSeq() + ",|responseType:" + ResponseSourceType.convertToHumanText(baseRequest.getResponseSourceType()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responseCache(BaseRequest baseRequest) {
        InputStream inputStream;
        if (getVSRequestStrategy().forbiddenCache(baseRequest)) {
            getDispatchObserver().sendCacheToTargetCallBack(baseRequest, getVSRequestStrategy().getErrorCode(baseRequest), getVSRequestStrategy().getErrorMsg(baseRequest), baseRequest.decode(new byte[0]));
            RFWLog.d(CACHE_TAG, RFWLog.USR, "response cache forbidden because of requestStrategy, CmdName:" + baseRequest.getCmdName() + " Seq:" + baseRequest.getCurrentSeq());
            return;
        }
        if (baseRequest.isEnableCache()) {
            RFWLog.d(CACHE_TAG, RFWLog.USR, "start to response cache,CmdName:" + baseRequest.getCmdName() + " Seq:" + baseRequest.getCurrentSeq());
            String requestKey = baseRequest.getRequestKey();
            if (TextUtils.isEmpty(requestKey)) {
                RFWLog.e(CACHE_TAG, RFWLog.USR, "empty cacheKey");
                return;
            }
            Cache.CacheInputStream stream = CacheHelper.fileCache().getStream(requestKey);
            if (stream != null) {
                inputStream = stream.getInputStream();
            } else {
                inputStream = null;
            }
            try {
                try {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (stream != null && inputStream != null) {
                            getDispatchObserver().sendCacheToTargetCallBack(baseRequest, baseRequest.decode(RFWIOUtil.convertInputStream2ByteArray(inputStream)));
                            RFWLog.d(CACHE_TAG, RFWLog.USR, "send Cache Success costTime:" + (System.currentTimeMillis() - currentTimeMillis) + ",CmdName:" + baseRequest.getCmdName() + " Seq:" + baseRequest.getCurrentSeq());
                            stream.close();
                            inputStream.close();
                            return;
                        }
                        RFWLog.d(CACHE_TAG, RFWLog.USR, "cache not found or bundle deserialized failed,CmdName:" + baseRequest.getCmdName() + " Seq:" + baseRequest.getCurrentSeq());
                        if (baseRequest.getResponseSourceType() == 2) {
                            getDispatchObserver().sendCacheToTargetCallBack(baseRequest, null);
                        }
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e17) {
                        RFWLog.w(CACHE_TAG, RFWLog.USR, e17.toString());
                        if (stream != null) {
                            stream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            } catch (Throwable th5) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        throw th5;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th5;
            }
        }
    }

    public void cancelRequest(Context context) {
        if (context != null) {
            RFWLog.i(TAG, RFWLog.CLR, "VSNetworkHelper: cancelRequest\uff1asuccess, contextHashCode:" + context.hashCode());
            getDispatchObserver().cancelAllRequest(context);
        }
    }

    @NonNull
    public synchronized VSBaseNetwork getNetworkImpl() {
        if (this.mNetworkImpl == null) {
            this.mNetworkImpl = initNetWork();
        } else if (this.mNetworkImpl.needReinitialize()) {
            getDispatchObserver().release();
            this.mNetworkImpl.onRelease();
            this.mNetworkImpl = null;
            this.mNetworkImpl = initNetWork();
        }
        return this.mNetworkImpl;
    }

    public OnReceivedCall getReceivedCall() {
        return this.mReceivedCall;
    }

    public VSRequestStrategy getVSRequestStrategy() {
        if (this.mVSRequestStrategy == null) {
            this.mVSRequestStrategy = new VSRequestStrategy();
        }
        return this.mVSRequestStrategy;
    }

    public boolean isValidLog(String str) {
        return getNetworkImpl().isValidLog(str);
    }

    public int sendRequest(BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        return sendRequest((Context) null, baseRequest, onVSRspCallBack);
    }

    public int sendRequest(Context context, BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        if (context == null) {
            context = RFWApplication.getApplication();
        }
        return sendRequest(context != null ? context.hashCode() : -1, baseRequest, (VSDispatchObserver.OnVSRspCallBack<?>) onVSRspCallBack);
    }

    public void cancelRequest(Context context, int i3) {
        if (context != null) {
            RFWLog.i(TAG, RFWLog.CLR, "VSNetworkHelper: cancelRequest\uff1asuccess, contextHashCode:" + context.hashCode());
            getDispatchObserver().cancelRequest(context, i3);
        }
    }

    public int sendRequest(final int i3, final BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack<?> onVSRspCallBack) {
        if (baseRequest == null) {
            return 0;
        }
        baseRequest.setContextHashCode(i3);
        getDispatchObserver().setCallBack(baseRequest, onVSRspCallBack);
        baseRequest.generateSendTimeStamp();
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.richframework.network.VSNetworkHelper.1
            @Override // java.lang.Runnable
            public void run() {
                BaseRequest baseRequest2 = baseRequest;
                baseRequest2.proceedRequestInterceptor(baseRequest2);
                byte[] encode = baseRequest.encode();
                if (VSNetworkHelper.this.onInterceptSendRequest(i3, baseRequest)) {
                    RFWLog.i(VSNetworkHelper.TAG, RFWLog.USR, "onInterceptSendRequest return");
                    return;
                }
                if (VSNetworkHelper.this.canRealSendRequest(baseRequest)) {
                    try {
                        VSNetworkHelper.this.getNetworkImpl().sendRequest(baseRequest, encode, VSNetworkHelper.this.getReceivedCall());
                    } catch (Exception e16) {
                        RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "sendRequest error" + e16.getMessage(), e16);
                        VSNetworkHelper.getDispatchObserver().onReceive(i3, false, baseRequest, null);
                    }
                }
                VSNetworkHelper.this.responseCache(baseRequest);
                if (VSNetworkHelper.this.isValidLog(baseRequest.getCmdName())) {
                    VSNetworkHelper.this.printRequest(i3, baseRequest);
                }
            }
        });
        return baseRequest.getCurrentSeq();
    }
}
