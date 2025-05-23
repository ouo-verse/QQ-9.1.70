package com.tencent.biz.pubaccount.weishi.net.common;

import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class g<Rsp extends JceStruct> {
    private static final String DEFAULT_COMMAND_PREFIX = "QzoneNewService.";
    public static final long TIME_OUT = 30000;
    public static final String TIME_OUT_KEY = "timeout";
    private static final String WS_PREFIX = "WeishiGZH.";
    public static Map<Integer, Map<String, String>> pageTypeExtMap = new HashMap();
    private String mCmd;
    private String mCommandPrefix;
    private final c mCompressInfo;
    public boolean mIsFirst;
    private boolean mIsGzipCompress;
    public boolean mIsRefresh;
    private boolean mIsRemoveWns;
    private long mLoginUserId;
    private final long mPkgId;
    protected int mReqScene;
    public String mRequestId;
    protected String mRequestSubId;
    private int mRetryCode;
    private int mRetryCount;
    private final k mTimeRecord;
    public long mTimeout;
    private final String onlyCmd;
    protected HashMap<Object, Object> params;
    public JceStruct req;
    public long reqSize;
    public int requestId;
    public long respSize;
    public JceStruct rsp;

    public g(String str) {
        this(WS_PREFIX, str);
    }

    public void addParameter(Object obj, Object obj2) {
        this.params.put(obj, obj2);
    }

    public boolean canRequestRetry() {
        return false;
    }

    public byte[] encode() {
        byte[] a16 = h.a(this);
        getTimeRecord().u();
        return a16;
    }

    public String getCmdString() {
        return this.mCommandPrefix + this.mCmd;
    }

    public c getCompressInfo() {
        return this.mCompressInfo;
    }

    public String getExpABTestDataStr() {
        String f16;
        return (!isHeaderNeedExpABTestData() || (f16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().f()) == null) ? "" : f16;
    }

    public long getLoginUserId() {
        return this.mLoginUserId;
    }

    public String getOnlyCmd() {
        return this.onlyCmd;
    }

    public Object getParameter(Object obj) {
        return this.params.get(obj);
    }

    public JceStruct getReq() {
        return this.req;
    }

    public String getReqUniKey() {
        return "st" + getOnlyCmd() + "Req";
    }

    public String getRequestCmd() {
        return this.mCmd;
    }

    public long getRequestPkgId() {
        return this.mPkgId;
    }

    public int getRequestRetryCount() {
        return this.mRetryCount;
    }

    public int getRequestScene() {
        return this.mReqScene;
    }

    public String getRequestSubId() {
        return this.mRequestSubId;
    }

    public int getRetryCode() {
        return this.mRetryCode;
    }

    public abstract Class<Rsp> getRspClass();

    public String getRspUinKey() {
        return "st" + getOnlyCmd() + "Rsp";
    }

    public k getTimeRecord() {
        return this.mTimeRecord;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public boolean isGzipCompress() {
        return this.mIsGzipCompress;
    }

    public boolean isHeaderNeedExpABTestData() {
        return true;
    }

    public boolean isNeedLaunchCalculator() {
        return false;
    }

    public boolean isRefresh() {
        return this.mIsRefresh;
    }

    public boolean isRemoveWns() {
        return this.mIsRemoveWns;
    }

    public boolean isReportPerformance() {
        return true;
    }

    public boolean isShouldStartQQAuth() {
        return true;
    }

    protected boolean needClientRetry() {
        return false;
    }

    public void setCmdString(String str) {
        this.mCmd = str;
    }

    public void setCommandPrefix(String str) {
        this.mCommandPrefix = str;
    }

    public void setGzipCompress(boolean z16) {
        this.mIsGzipCompress = z16;
    }

    public void setLoginUserId(long j3) {
        this.mLoginUserId = j3;
    }

    public void setRemoveWns(boolean z16) {
        this.mIsRemoveWns = z16;
    }

    public void setRequestRetryCount(int i3) {
        this.mRetryCount = i3;
    }

    public void setRetryCode(int i3) {
        this.mRetryCode = i3;
    }

    public g(String str, int i3) {
        this(WS_PREFIX, str);
        this.mReqScene = i3;
    }

    public g(JceStruct jceStruct, String str) {
        this(WS_PREFIX, str);
        this.req = jceStruct;
    }

    public g(String str, String str2) {
        this.params = new HashMap<>();
        this.mCommandPrefix = DEFAULT_COMMAND_PREFIX;
        this.mTimeout = 30000L;
        this.mLoginUserId = 0L;
        this.requestId = 100000;
        this.onlyCmd = str2;
        this.mCmd = str + str2;
        this.mPkgId = System.currentTimeMillis();
        this.mTimeRecord = new k(getRequestCmd());
        this.mCompressInfo = new c();
        getTimeRecord().t();
        setLoginUserId(bb.o());
        this.mTimeout = o00.d.f421669a.c();
    }

    public void onBuildHeaderMapExt(Map<String, String> map) {
    }
}
