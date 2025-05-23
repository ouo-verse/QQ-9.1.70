package com.tencent.turingfd.sdk.xq;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IteApkInfoResp extends Cygnus {
    public static final int SL_HIGH = 1;
    public static final int SL_LOW = 3;
    public static final int SL_MID = 2;
    public static final int SL_SAFE = 0;
    public static final int SL_UNKNOW = 4;

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    long getErrorCode();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    String getFileMd5();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    String getFileName();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    String getFileSha1();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    String getHandleUrl();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    String getPkgName();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    int getRiskCategory();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    String getRiskTips();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    int getSafeLevel();

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    boolean isSucceed();
}
