package com.tencent.biz.richframework.network.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetQUICEvent implements Serializable {
    private static final int BASE_ERROR = 100000;
    public static final int ERROR_DNS_EMPTY = 100002;
    public static final int ERROR_PSK_CODE = 100001;
    public static final int ERROR_QUIC_DATA_UN_ZIP_ERROR = 100003;
    public static final String EVENT_ID_DNS_SUCCESS = "EVENT_ID_DNS_SUCCESS";
    public static final String EVENT_ID_QUIC_DATA_PARSE_ERROR = "EVENT_ID_DATA_PARSE_ERROR";
    public static final String EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS = "EVENT_ID_QUIC_DATA_UN_ZIP_SUCCESS";
    public static final String EVENT_ID_QUIC_DNS_ERROR = "EVENT_ID_QUIC_DNS_ERROR";
    public static final String EVENT_ID_QUIC_HEAD_ERROR = "EVENT_ID_QUIC_REC_HEAD_ERROR";
    public static final String EVENT_ID_QUIC_PSKEY_ERROR = "EVENT_ID_QUIC_PSKEY_ERROR";
    public static final String EVENT_ID_QUIC_PSKEY_SUCCESS = "EVENT_ID_QUIC_PSKEY_SUCCSEE";
    public static final String EVENT_ID_QUIC_REQ_ZIP = "EVENT_ID_QUIC_REQ_ZIP";
    public static final String EVENT_ID_QUIC_SEND_ERROR = "EVENT_ID_QUIC_SEND_ERROR";
    public static final String EVENT_ID_QUIC_SEND_SUCCESS = "EVENT_ID_QUIC_SEND_SUCCESS";
    public static final String EVENT_ID_QUIC_START = "EVENT_ID_QUIC_START";
    public static final String EVENT_ID_QUIC_TO_MSF = "EVENT_ID_QUIC_TO_MSF";
    private static final Map<String, Integer> KEY_TO_LOCAL_CODE;
    private int mCompressType;
    private String mDSNIP;
    private int mErrorCode;
    private final String mEventKey;
    private final long mEventTime = System.currentTimeMillis();
    private String mMsg;
    private long mProtoRspSize;
    private long mPsKeyCosts;
    private long mReqBeforeZipLength;
    private long mReqZipLength;
    private long mReqZipTimeCostMs;
    private long mRspBeforeUnZipLength;
    private long mRspUnZipLength;
    private long mUnZIpCostMs;

    static {
        HashMap hashMap = new HashMap();
        KEY_TO_LOCAL_CODE = hashMap;
        hashMap.put(EVENT_ID_QUIC_PSKEY_ERROR, 100001);
        hashMap.put(EVENT_ID_QUIC_DNS_ERROR, 100002);
        hashMap.put(EVENT_ID_QUIC_DATA_PARSE_ERROR, 100003);
    }

    public VSNetQUICEvent(String str) {
        this.mEventKey = str;
        Map<String, Integer> map = KEY_TO_LOCAL_CODE;
        if (map.containsKey(str)) {
            this.mErrorCode = map.get(str).intValue();
        }
    }

    public int getCompressType() {
        return this.mCompressType;
    }

    public String getDNSIP() {
        return this.mDSNIP;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getEventKey() {
        return this.mEventKey;
    }

    public long getEventTime() {
        return Long.valueOf(this.mEventTime).longValue();
    }

    public String getMsg() {
        return this.mMsg;
    }

    public long getProtoRspSize() {
        return this.mProtoRspSize;
    }

    public long getPsKeyCost() {
        return this.mPsKeyCosts;
    }

    public long getReceiveSize() {
        return this.mRspBeforeUnZipLength;
    }

    public long getReqLength() {
        return this.mReqBeforeZipLength;
    }

    public long getUnZipLength() {
        return this.mRspUnZipLength;
    }

    public long getUnZipTimeCost() {
        return this.mUnZIpCostMs;
    }

    public long getZipReqLength() {
        return this.mReqZipLength;
    }

    public long getZipTimeCost() {
        return this.mReqZipTimeCostMs;
    }

    public VSNetQUICEvent setDNSIP(String str) {
        this.mDSNIP = str;
        return this;
    }

    public VSNetQUICEvent setErrorCode(int i3) {
        this.mErrorCode = i3;
        return this;
    }

    public VSNetQUICEvent setEventMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public VSNetQUICEvent setPsKeyCost(long j3) {
        this.mPsKeyCosts = j3;
        return this;
    }

    public VSNetQUICEvent setReqZipData(long j3, long j16, long j17) {
        this.mReqBeforeZipLength = j3;
        this.mReqZipLength = j16;
        this.mReqZipTimeCostMs = j17;
        return this;
    }

    public VSNetQUICEvent setRspUnZipData(long j3, long j16, long j17, long j18, int i3) {
        this.mProtoRspSize = j3;
        this.mRspBeforeUnZipLength = j16;
        this.mRspUnZipLength = j17;
        this.mUnZIpCostMs = j18;
        this.mCompressType = i3;
        return this;
    }

    public String toString() {
        return "VSNetQUICEvent{mEventKey='" + this.mEventKey + "', mEventTime=" + this.mEventTime + ", mErrorCode=" + this.mErrorCode + ", mMsg='" + this.mMsg + "'}";
    }
}
