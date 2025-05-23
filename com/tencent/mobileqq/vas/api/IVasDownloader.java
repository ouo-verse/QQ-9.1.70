package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.h;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasDownloader extends QRouteApi, h {
    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ int cancelTask(boolean z16, String str);

    void clearAddressCache();

    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ com.tencent.mobileqq.vip.g getTask(String str);

    void init(AppRuntime appRuntime, DownloadConfig downloadConfig);

    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ void onDestroy();

    @Override // com.tencent.mobileqq.vip.h
    /* synthetic */ void startDownload(com.tencent.mobileqq.vip.g gVar, com.tencent.mobileqq.vip.f fVar, Bundle bundle);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DownloadConfig {
        public boolean useNetChangeNotify;

        public DownloadConfig() {
            this.useNetChangeNotify = false;
        }

        public DownloadConfig(boolean z16) {
            this.useNetChangeNotify = z16;
        }
    }
}
