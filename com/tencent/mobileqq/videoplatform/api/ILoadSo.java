package com.tencent.mobileqq.videoplatform.api;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface ILoadSo {
    public static final String SONAME_CKEYGENERATORV2 = "ckeygeneratorV2";
    public static final String SONAME_CKGUARD = "ckguard";
    public static final String SONAME_DOWNLOADPROXY = "DownloadProxy";
    public static final String SONAME_TPCORE_MASTER = "TPCore-master";

    boolean isAllSoExist();

    boolean isCkeygeneratorV2Load();

    boolean isCkguardLoad();

    boolean isDownProxyLoad();

    boolean isDownloadSoExist();

    boolean isTPCoreLoad();

    boolean isTpCoreSoExist();

    void loadDownProxyAsync(LoadSoCallback loadSoCallback);

    boolean loadDownProxySync();

    void loadSo(LoadSoCallback loadSoCallback);

    boolean loadTPCoreSync();

    void preloadSo();
}
