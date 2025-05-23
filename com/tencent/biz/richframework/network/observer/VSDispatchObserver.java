package com.tencent.biz.richframework.network.observer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.util.StringUtils;
import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSDispatchObserver {
    private static final int FROM_MSG_NULL_CODE = -100002;
    private static final String NETWORK_ERROR_HINT = "\u7f51\u7edc\u9519\u8bef";
    private static final int SEQ_UNDEFINED = -1;
    public static final int TIMEOUT_CODE = -100001;
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, OnVSRspCallBack>> mCallBackCollectMap = new ConcurrentHashMap<>();
    private Handler mMainHandler;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnVSRspCallBack<T> {
        void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, T t16);
    }

    private void dispatchServerRsp(final boolean z16, final BaseRequest baseRequest, final long j3, final OnVSRspCallBack onVSRspCallBack, final long j16, final String str, final byte[] bArr, final Object obj) {
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.5
            @Override // java.lang.Runnable
            public void run() {
                if (z16 && baseRequest.isSuccessRetCode(j16) && baseRequest.isEnableCache()) {
                    VSDispatchObserver.this.saveCache(baseRequest, bArr);
                }
                VSDispatchObserver.this.doOnReceiveCallBack(baseRequest, onVSRspCallBack, j16, str, z16, obj);
                if (VSNetworkHelper.getInstance().isValidLog(baseRequest.getCmdName())) {
                    RFWLog.d(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j16 + " | retMessage:" + str + " | busiBuff size:" + bArr.length + " | final dispatch costTime:" + (System.currentTimeMillis() - j3));
                }
            }
        };
        if (baseRequest.isMessageQueueHighProperty()) {
            getMainThreadHandler().postAtFrontOfQueue(runnable);
        } else {
            getMainThreadHandler().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnReceiveCallBack(BaseRequest baseRequest, OnVSRspCallBack onVSRspCallBack, long j3, String str, boolean z16, Object obj) {
        if ((!z16 || j3 != 0) && baseRequest.isNeedRetry(j3) && baseRequest.getRetryCount() > 0) {
            baseRequest.setEnableCache(false);
            baseRequest.setRetryCount(baseRequest.getRetryCount() - 1);
            VSNetworkHelper.getInstance().sendRequest(baseRequest, onVSRspCallBack);
            RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: Start Retry Request: CmdName:" + baseRequest.getCmdName() + " | ReTry TraceId:" + baseRequest.getTraceId() + " | ReTry SeqId:" + baseRequest.getCurrentSeq());
            return;
        }
        Object[] proceedResponseInterceptor = baseRequest.proceedResponseInterceptor(baseRequest, z16, j3, str, obj);
        onVSRspCallBack.onReceive((BaseRequest) proceedResponseInterceptor[0], ((Boolean) proceedResponseInterceptor[1]).booleanValue(), ((Long) proceedResponseInterceptor[2]).longValue(), (String) proceedResponseInterceptor[3], proceedResponseInterceptor[4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseResponse(int i3, boolean z16, final BaseRequest baseRequest, byte[] bArr) {
        ConcurrentHashMap<Integer, OnVSRspCallBack> concurrentHashMap = this.mCallBackCollectMap.get(Integer.valueOf(i3));
        if (concurrentHashMap == null) {
            RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: onReceive: cmdCallback has All Removed");
            return;
        }
        if (baseRequest == null) {
            RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: onReceive: request is null");
            return;
        }
        final OnVSRspCallBack remove = concurrentHashMap.remove(Integer.valueOf(baseRequest.getCurrentSeq()));
        if (remove == null) {
            RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: onReceive: CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | cmdCallback SeqId:" + baseRequest.getCurrentSeq() + " onVSRspCallBack is Null or removed");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (bArr != null && bArr.length > 0) {
            try {
                Object[] parseResponseHeadInfo = baseRequest.parseResponseHeadInfo(bArr);
                final long longValue = ((Long) parseResponseHeadInfo[0]).longValue();
                final String str = (String) parseResponseHeadInfo[1];
                byte[] bArr2 = (byte[]) parseResponseHeadInfo[2];
                Object decode = baseRequest.decode(bArr2);
                if (decode == null) {
                    getMainThreadHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.2
                        @Override // java.lang.Runnable
                        public void run() {
                            VSDispatchObserver.this.doOnReceiveCallBack(baseRequest, remove, longValue, str, false, null);
                            RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - currentTimeMillis) + " | errorMsg: inform BaseRequest finalRsp is empty.");
                        }
                    });
                    return;
                } else {
                    dispatchServerRsp(z16, baseRequest, currentTimeMillis, remove, longValue, str, bArr2, decode);
                    return;
                }
            } catch (Exception | OutOfMemoryError e16) {
                getMainThreadHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        VSDispatchObserver.this.doOnReceiveCallBack(baseRequest, remove, -100001L, "\u7f51\u7edc\u9519\u8bef", false, null);
                        RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: ParseException: CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | errorMsg: inform BaseRequest result code fail | final dispatch costTime:" + (System.currentTimeMillis() - currentTimeMillis) + " | exception:" + e16);
                    }
                });
                return;
            }
        }
        getMainThreadHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.4
            @Override // java.lang.Runnable
            public void run() {
                VSDispatchObserver.this.doOnReceiveCallBack(baseRequest, remove, WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT, "\u7f51\u7edc\u9519\u8bef", false, null);
                RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: ParseException: CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - currentTimeMillis) + " | errorMsg:BaseRequest or FromServiceMsg is null!");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCache(final BaseRequest baseRequest, final byte[] bArr) {
        if (StringUtils.isEmpty(baseRequest.getRequestKey())) {
            RFWLog.w(VSNetworkHelper.CACHE_TAG, RFWLog.USR, "requestKey is empty");
        } else {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String requestKey = baseRequest.getRequestKey();
                        RFWLog.d(VSNetworkHelper.CACHE_TAG, RFWLog.USR, baseRequest.getCmdName() + " saveCache CacheKey:" + requestKey);
                        CacheHelper.fileCache().setStream(requestKey, new ByteArrayInputStream(bArr));
                        RFWLog.i(VSNetworkHelper.CACHE_TAG, RFWLog.USR, baseRequest.getCmdName() + " saveCache success");
                    } catch (Exception e16) {
                        RFWLog.w(VSNetworkHelper.CACHE_TAG, RFWLog.USR, e16.toString());
                    }
                }
            });
        }
    }

    public void cancelAllRequest(Context context) {
        cancelRequest(context, -1);
    }

    public void cancelRequest(Context context, int i3) {
        if (context == null) {
            return;
        }
        if (i3 == -1 && context == RFWApplication.getApplication()) {
            RFWLog.w(VSNetworkHelper.TAG, RFWLog.USR, "[cancelRequest] return: seq is undefined, and context is application");
            return;
        }
        if (this.mCallBackCollectMap.get(Integer.valueOf(context.hashCode())) != null) {
            ConcurrentHashMap<Integer, OnVSRspCallBack> concurrentHashMap = this.mCallBackCollectMap.get(Integer.valueOf(context.hashCode()));
            if (concurrentHashMap != null && i3 == -1) {
                concurrentHashMap.clear();
                RFWLog.i(VSNetworkHelper.TAG, RFWLog.USR, String.format("cancel Request Context Success contextHashcode:%d, seq:%d", Integer.valueOf(context.hashCode()), Integer.valueOf(i3)));
            } else if (concurrentHashMap != null && concurrentHashMap.remove(Integer.valueOf(i3)) != null) {
                RFWLog.i(VSNetworkHelper.TAG, RFWLog.USR, String.format("cancel Request Seq Success contextHashcode:%d, seq:%d", Integer.valueOf(context.hashCode()), Integer.valueOf(i3)));
            } else {
                RFWLog.w(VSNetworkHelper.TAG, RFWLog.USR, String.format("cancel Request failed not found request callback contextHashcode:%d, seq:%d", Integer.valueOf(context.hashCode()), Integer.valueOf(i3)));
            }
        }
    }

    public Handler getMainThreadHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }

    public void onReceive(final int i3, final boolean z16, final BaseRequest baseRequest, final byte[] bArr) {
        final long currentTimeMillis = System.currentTimeMillis() - baseRequest.getSendTimeStamp();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.1
            @Override // java.lang.Runnable
            public void run() {
                if (VSNetworkHelper.getInstance().isValidLog(baseRequest.getCmdName())) {
                    RFWLog.i(VSNetworkHelper.TAG, RFWLog.USR, "onReceive Info:CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | seqNum:" + baseRequest.getCurrentSeq() + " | network cost:" + currentTimeMillis);
                }
                if (z16) {
                    VSNetworkSpeedHelper.collectNetWorkSucceed(baseRequest, currentTimeMillis);
                } else {
                    VSNetworkSpeedHelper.collectNetWorkError(baseRequest);
                }
                VSDispatchObserver.this.parseResponse(i3, z16, baseRequest, bArr);
            }
        });
    }

    public synchronized void release() {
        Iterator<Integer> it = this.mCallBackCollectMap.keySet().iterator();
        while (it.hasNext()) {
            ConcurrentHashMap<Integer, OnVSRspCallBack> concurrentHashMap = this.mCallBackCollectMap.get(Integer.valueOf(it.next().intValue()));
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        }
    }

    public void sendCacheToTargetCallBack(BaseRequest baseRequest, Object obj) {
        sendCacheToTargetCallBack(baseRequest, 0, VSNetworkHelper.ERROR_CACHE_PREFIX, obj);
    }

    public void setCallBack(BaseRequest baseRequest, OnVSRspCallBack onVSRspCallBack) {
        ConcurrentHashMap<Integer, OnVSRspCallBack> concurrentHashMap = this.mCallBackCollectMap.get(Integer.valueOf(baseRequest.getContextHashCode()));
        if (concurrentHashMap == null) {
            synchronized (this) {
                concurrentHashMap = this.mCallBackCollectMap.get(Integer.valueOf(baseRequest.getContextHashCode()));
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.mCallBackCollectMap.put(Integer.valueOf(baseRequest.getContextHashCode()), concurrentHashMap);
                }
            }
        }
        try {
            concurrentHashMap.put(Integer.valueOf(baseRequest.getNewSeq()), onVSRspCallBack);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (!RFWApplication.isDebug()) {
                RFWLog.e(VSNetworkHelper.TAG, RFWLog.USR, "setCallBack exception occur!" + e16.toString());
                return;
            }
            throw new RuntimeException(e16);
        }
    }

    public void sendCacheToTargetCallBack(final BaseRequest baseRequest, final int i3, final String str, final Object obj) {
        getMainThreadHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.network.observer.VSDispatchObserver.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) VSDispatchObserver.this.mCallBackCollectMap.get(Integer.valueOf(baseRequest.getContextHashCode()));
                    int currentSeq = baseRequest.getCurrentSeq();
                    if (concurrentHashMap != null) {
                        if (concurrentHashMap.get(Integer.valueOf(currentSeq)) == null) {
                            RFWLog.d(VSNetworkHelper.CACHE_TAG, RFWLog.USR, String.format("VSDispatchObserver: onReceive:CmdName:%s Seq:%d CallBack is Null or has Removed", baseRequest.getCmdName(), Integer.valueOf(baseRequest.getCurrentSeq())));
                            return;
                        } else {
                            ((OnVSRspCallBack) concurrentHashMap.get(Integer.valueOf(currentSeq))).onReceive(baseRequest, true, i3, str, obj);
                            return;
                        }
                    }
                    RFWLog.d(VSNetworkHelper.CACHE_TAG, RFWLog.USR, "VSDispatchObserver: onReceive: current context callbacks has all removed");
                } catch (Exception e16) {
                    RFWLog.w(VSNetworkHelper.CACHE_TAG, RFWLog.USR, e16.toString());
                }
            }
        });
    }
}
