package com.tencent.luggage.wxaapi;

/* loaded from: classes9.dex */
public interface WxaPrefetchApi {

    /* loaded from: classes9.dex */
    public enum WxaPrefetchResult {
        Unknown,
        Fail_SvrConnectFail,
        Fail_SvrRetFail,
        Fail_SvrRetListEmpty,
        Fail_PkgDownloadFail,
        Success_AllPkgDownloaded,
        Success_NoNeedGetCode,
        Success_AllPkgDownloadedPrevious
    }

    /* loaded from: classes9.dex */
    public interface a {
    }
}
