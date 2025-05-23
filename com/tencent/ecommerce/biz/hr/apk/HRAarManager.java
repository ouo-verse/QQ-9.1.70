package com.tencent.ecommerce.biz.hr.apk;

import cg0.a;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.config.service.b;
import com.tencent.ecommerce.base.offline.api.IECOfflineManager;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ<\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J*\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u0002R\u0014\u0010\u001a\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/apk/HRAarManager;", "", "", "pageName", "offlineFilePath", "Ljava/io/File;", "pageAarFile", "newestOfflineVersion", "Lkotlin/Function1;", "", "resultCallback", "d", "version", "e", "a", "g", "", "needMatchVersion", "j", "i", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "callback", "f", "k", h.F, "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "soOfflineCallback", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRAarManager {

    /* renamed from: b, reason: collision with root package name */
    public static final HRAarManager f102531b = new HRAarManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECOfflineManager.OfflineStrongCallback soOfflineCallback = new IECOfflineManager.OfflineStrongCallback(null, new Function1<IECOfflineManager.OfflineDownloadState, Unit>() { // from class: com.tencent.ecommerce.biz.hr.apk.HRAarManager$soOfflineCallback$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
            invoke2(offlineDownloadState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
            a.b("HRAarManager", "update aar offline state: " + offlineDownloadState);
        }
    });

    HRAarManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a() {
        return QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getExternalApplicationContext().getFilesDir().getAbsolutePath() + "/qqecommerce";
    }

    private final void d(final String pageName, final String offlineFilePath, final File pageAarFile, final String newestOfflineVersion, final Function1<? super String, Unit> resultCallback) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.apk.HRAarManager$copyOfflineAarFile2DataDir$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    HRAarManager.f102531b.g();
                    FilesKt__UtilsKt.copyTo$default(new File(offlineFilePath), pageAarFile, true, 0, 4, null);
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.apk.HRAarManager$copyOfflineAarFile2DataDir$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IECLocalConfig.a.j(ECLocalConfig.f100650f, "aar_version_" + pageName, newestOfflineVersion, null, 4, null);
                            HRAarManager$copyOfflineAarFile2DataDir$1 hRAarManager$copyOfflineAarFile2DataDir$1 = HRAarManager$copyOfflineAarFile2DataDir$1.this;
                            resultCallback.invoke(pageAarFile.getAbsolutePath());
                        }
                    });
                } catch (Throwable th5) {
                    a.a("HRAarManager", "HRAarManager", "copy aar file error: " + th5);
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.apk.HRAarManager$copyOfflineAarFile2DataDir$1.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            resultCallback.invoke("");
                        }
                    });
                    if (pageAarFile.exists()) {
                        pageAarFile.delete();
                    }
                }
            }
        });
    }

    private final void e(final String pageName, final String version) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.apk.HRAarManager$deleteOldAarFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String a16;
                StringBuilder sb5 = new StringBuilder();
                a16 = HRAarManager.f102531b.a();
                sb5.append(a16);
                sb5.append('/');
                sb5.append(pageName);
                sb5.append(util.base64_pad_url);
                sb5.append(version);
                sb5.append(".apk");
                File file = new File(sb5.toString());
                String absolutePath = file.getAbsolutePath();
                if (file.exists()) {
                    file.delete();
                    a.b("HRAarManager", "delete old aar file: " + absolutePath);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        File file = new File(a());
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public final void f(IECOfflineManager.OfflineStrongCallback callback) {
        IECOfflineManager offlineManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOfflineManager();
        if (offlineManager != null) {
            offlineManager.downloadOffline("5053", callback);
        }
    }

    public final String h() {
        String bidVersion;
        IECOfflineManager offlineManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOfflineManager();
        return (offlineManager == null || (bidVersion = offlineManager.getBidVersion("5053")) == null) ? "" : bidVersion;
    }

    public final void i(String offlineFilePath, String pageName, Function1<? super String, Unit> resultCallback) {
        String h16 = h();
        String string = ECLocalConfig.f100650f.getString("aar_version_" + pageName, "", Boolean.FALSE);
        File file = new File(a() + '/' + pageName + util.base64_pad_url + h16 + ".apk");
        if (!Intrinsics.areEqual(h16, string)) {
            a.b("HRAarManager", "aar version not same, " + h16 + ", " + string);
            d(pageName, offlineFilePath, file, h16, resultCallback);
            e(pageName, string);
            return;
        }
        if (file.exists()) {
            a.b("HRAarManager", "aar version same, " + h16);
            resultCallback.invoke(file.getAbsolutePath());
            return;
        }
        a.b("HRAarManager", "aar version same, but file not exist, try create: " + h16 + ", " + string);
        d(pageName, offlineFilePath, file, h16, resultCallback);
    }

    public final String j(String pageName, boolean needMatchVersion) {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        IECOfflineManager offlineManager = qQEcommerceSdk.getGlobalInternalSdk().getOfflineManager();
        File file = null;
        String loadOffline = offlineManager != null ? offlineManager.loadOffline("5053", "kuikly_config.json") : null;
        if (loadOffline == null) {
            return "";
        }
        if (!(loadOffline.length() > 0)) {
            return "";
        }
        String optString = new JSONObject(loadOffline).optString("appVersion");
        boolean z16 = ((Number) b.f100655b.b(100168, "needMatchVersion", 0)).intValue() == 1;
        String appVersion = qQEcommerceSdk.getGlobalInternalSdk().getRuntime().appVersion();
        boolean areEqual = Intrinsics.areEqual(appVersion, optString);
        a.b("HRAarManager", "needMatchVersion: " + needMatchVersion + ", needMatchVersionFromConfig: " + z16 + ", versionMatch: " + areEqual);
        if (needMatchVersion && z16 && !areEqual) {
            IECOfflineManager offlineManager2 = qQEcommerceSdk.getGlobalInternalSdk().getOfflineManager();
            if (offlineManager2 != null) {
                offlineManager2.deleteOffline("5053");
            }
            a.f("HRAarManager", "kr version not match, delete offline, host version: " + appVersion + ", app version: " + optString);
            return "";
        }
        IECOfflineManager offlineManager3 = qQEcommerceSdk.getGlobalInternalSdk().getOfflineManager();
        if (offlineManager3 != null) {
            file = offlineManager3.getOfflineFile("5053", pageName + ".apk");
        }
        if (file == null || !file.exists()) {
            return "";
        }
        return file.getAbsolutePath();
    }

    public final void k() {
        IECOfflineManager offlineManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOfflineManager();
        if (offlineManager != null) {
            offlineManager.downloadOffline("5053", soOfflineCallback);
        }
    }
}
