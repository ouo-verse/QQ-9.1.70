package com.tencent.biz.richframework.network.request;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.util.StringUtils;
import com.tencent.biz.richframework.util.GzipUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseRequest implements Serializable {
    public static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);
    public static final int RETRY_LIMIT = 5;
    public static final String TAG = "VSBaseRequest";
    private static final long serialVersionUID = -1;
    protected boolean mEnableTraceReport;
    private boolean mHighProperty;
    private boolean mIsGzipCompressed;
    private String mOverrideTraceId;
    private String mRequestKey;
    private long mSendTimeStamp;
    private int mSeq;
    protected String mTraceId;
    private int mContextHashCode = -1;
    private int mRetryCount = 0;
    private boolean isEnableCache = false;
    private int mResponseSourceType = 1;
    private ArrayList<RequestInterceptor> mRequestInterceptors = new ArrayList<>();

    public static String concactRetCodeAndMsg(long j3, String str) {
        return ", retcode:" + j3 + " | errMsg:" + str;
    }

    public static String generateTraceId() {
        String accountId = VSNetworkHelper.getInstance().getNetworkImpl().getAccountId();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.nanoTime());
        sb5.append(accountId);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    private static String getReqCacheKey(BaseRequest baseRequest) {
        return baseRequest.getCmdName() + VSNetworkHelper.getInstance().getNetworkImpl().getAccountId() + VSNetworkHelper.getInstance().getNetworkImpl().getQUA() + Arrays.toString(baseRequest.getRequestByteKey());
    }

    public static boolean isCacheExist(BaseRequest baseRequest) {
        if (baseRequest != null && baseRequest.getRequestByteData() != null) {
            return CacheHelper.fileCache().cacheExists(getReqCacheKey(baseRequest));
        }
        return false;
    }

    public static void reMoveCache(BaseRequest baseRequest) {
        if (baseRequest != null && baseRequest.getRequestByteData() != null) {
            CacheHelper.fileCache().remove(getReqCacheKey(baseRequest));
        }
    }

    public void addRequestInterceptor(RequestInterceptor requestInterceptor) {
        ArrayList<RequestInterceptor> arrayList = this.mRequestInterceptors;
        if (arrayList != null && !arrayList.contains(requestInterceptor)) {
            this.mRequestInterceptors.add(requestInterceptor);
        }
    }

    public abstract <T> T decode(byte[] bArr);

    protected boolean enableGzipCompress() {
        return false;
    }

    public byte[] encode() {
        byte[] requestByteData = getRequestByteData();
        if (isEnableCache()) {
            this.mRequestKey = getReqCacheKey(this);
        }
        this.mIsGzipCompressed = false;
        if (requestByteData.length > 1024 && enableGzipCompress()) {
            int length = requestByteData.length;
            long currentTimeMillis = System.currentTimeMillis();
            requestByteData = GzipUtil.gzipCompress(requestByteData);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            RFWLog.i(TAG, RFWLog.USR, "CmdName:" + getCmdName() + ",enable gzip succeed, requestBizData length, beforeCompress:" + length + ", afterCompress:" + requestByteData.length + ", costTime:" + currentTimeMillis2);
            this.mIsGzipCompressed = true;
        }
        return getFinalRequestData(requestByteData);
    }

    public void generateSendTimeStamp() {
        this.mSendTimeStamp = System.currentTimeMillis();
    }

    public abstract String getCmdName();

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public int getCurrentSeq() {
        return this.mSeq;
    }

    protected abstract byte[] getFinalRequestData(byte[] bArr);

    @Deprecated
    public int getNewSeq() {
        String str;
        this.mSeq = ATOMIC_INTEGER.getAndIncrement();
        if (StringUtils.isEmpty(this.mOverrideTraceId)) {
            str = generateTraceId();
        } else {
            str = this.mOverrideTraceId;
        }
        this.mTraceId = str;
        return this.mSeq;
    }

    protected abstract byte[] getRequestByteData();

    public byte[] getRequestByteKey() {
        try {
            return getRequestByteData();
        } catch (OutOfMemoryError e16) {
            RFWLog.e(TAG, RFWLog.USR, e16);
            return new byte[0];
        }
    }

    public String getRequestKey() {
        return this.mRequestKey;
    }

    public int getResponseSourceType() {
        return this.mResponseSourceType;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public long getSendTimeStamp() {
        return this.mSendTimeStamp;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public boolean isAsyncCallBack() {
        return true;
    }

    public boolean isEnableCache() {
        return this.isEnableCache;
    }

    public boolean isEnableTraceReport() {
        return this.mEnableTraceReport;
    }

    public boolean isGzipCompressed() {
        return this.mIsGzipCompressed;
    }

    public boolean isMessageQueueHighProperty() {
        return this.mHighProperty;
    }

    public boolean isNeedRetry(long j3) {
        boolean z16;
        if (j3 == -2) {
            z16 = false;
        } else {
            z16 = true;
        }
        RFWLog.d(TAG, RFWLog.USR, "CmdName:", getCmdName(), ",retCode:", Long.valueOf(j3), "isNeedRetry:" + z16);
        return z16;
    }

    public boolean isSuccessRetCode(long j3) {
        if (j3 == 0) {
            return true;
        }
        return false;
    }

    public void overrideTraceId(String str) {
        this.mOverrideTraceId = str;
    }

    public abstract Object[] parseResponseHeadInfo(byte[] bArr);

    public void proceedRequestInterceptor(BaseRequest baseRequest) {
        ArrayList<RequestInterceptor> arrayList = this.mRequestInterceptors;
        if (arrayList != null) {
            Iterator<RequestInterceptor> it = arrayList.iterator();
            while (it.hasNext()) {
                RequestInterceptor next = it.next();
                RFWLog.i(VSNetworkHelper.TAG, RFWLog.USR, "proceedRequestInterceptor");
                next.interceptRequest(baseRequest);
            }
        }
    }

    public Object[] proceedResponseInterceptor(BaseRequest baseRequest, boolean z16, long j3, String str, @Nullable Object obj) {
        Object[] objArr = {baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj};
        ArrayList<RequestInterceptor> arrayList = this.mRequestInterceptors;
        if (arrayList != null) {
            Iterator<RequestInterceptor> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().interceptResponse(objArr);
                RFWLog.i(VSNetworkHelper.TAG, RFWLog.USR, "VSDispatchObserver: proceedResponseInterceptor Request: CmdName:" + baseRequest.getCmdName() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            }
        }
        return objArr;
    }

    public void setContextHashCode(int i3) {
        this.mContextHashCode = i3;
    }

    public void setEnableCache(boolean z16) {
        this.isEnableCache = z16;
    }

    public void setMessageQueueHighProperty(boolean z16) {
        this.mHighProperty = z16;
    }

    public void setRequestResponseType(int i3) {
        this.mResponseSourceType = i3;
        if (i3 == 2) {
            this.isEnableCache = true;
        }
    }

    public void setRetryCount(int i3) {
        if (i3 > 5) {
            i3 = 5;
        }
        this.mRetryCount = i3;
    }

    public void setTraceReportEnable(boolean z16) {
        this.mEnableTraceReport = z16;
    }
}
