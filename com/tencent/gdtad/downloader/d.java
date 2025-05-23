package com.tencent.gdtad.downloader;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.AdReporterOfDeeplink;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.gdtad.basics.config.AdAppInstallConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000fR\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/gdtad/downloader/d;", "", "Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "params", "Lcom/tencent/ad/tangram/util/AdClickUtil$Result;", "result", "", "l", "", "packageName", "Lcom/tencent/gdtad/downloader/d$a;", "e", "c", "b", "k", "", "g", "i", tl.h.F, "", "d", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "appData", "<init>", "()V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f109172a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, a> appData = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/gdtad/downloader/d$a;", "", "Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "a", "Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "()Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "setParams", "(Lcom/tencent/ad/tangram/util/AdClickUtil$Params;)V", "params", "Lcom/tencent/ad/tangram/util/AdClickUtil$Result;", "b", "Lcom/tencent/ad/tangram/util/AdClickUtil$Result;", "()Lcom/tencent/ad/tangram/util/AdClickUtil$Result;", "setResult", "(Lcom/tencent/ad/tangram/util/AdClickUtil$Result;)V", "result", "<init>", "(Lcom/tencent/ad/tangram/util/AdClickUtil$Params;Lcom/tencent/ad/tangram/util/AdClickUtil$Result;)V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private AdClickUtil.Params params;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private AdClickUtil.Result result;

        public a(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
            this.params = params;
            this.result = result;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final AdClickUtil.Params getParams() {
            return this.params;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final AdClickUtil.Result getResult() {
            return this.result;
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AdClickUtil.Params params) {
        String str;
        Intrinsics.checkNotNullParameter(params, "$params");
        Ad ad5 = params.f61334ad;
        if (ad5 != null) {
            str = ad5.getAppDeeplink(params.clickLocationParams);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            AdReporterOfDeeplink.report(params, AdClickUtil.handleAppWithDeeplink(params, 1, true), true);
        } else {
            AdClickUtil.handleApp(params, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(AdClickUtil.Params params, AdClickUtil.Result result) {
        String str;
        int i3;
        int i16;
        int i17;
        if (params == null) {
            return;
        }
        if (params.isValidForApp()) {
            AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, 286);
        }
        if (result != null) {
            Ad ad5 = params.f61334ad;
            Integer num = null;
            if (ad5 != null) {
                str = ad5.getAppMarketDeeplink();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Ad ad6 = params.f61334ad;
                if (ad6 != null) {
                    num = Integer.valueOf(ad6.getAppMarketJumpType());
                }
                if (num != null) {
                    i3 = 1;
                    if (num.intValue() == 1 && result.action == 8) {
                        i17 = sdk_event_log.SdkEventDimension.EVENT_APP_INSTALL_SUCCESS_FROM_APP_MARKET;
                        i16 = i17;
                        if (i16 != Integer.MIN_VALUE) {
                            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
                            reportBiz.download_scene = i3;
                            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), i16, params.f61334ad, reportBiz, null);
                            return;
                        }
                        return;
                    }
                }
                if (num != null && num.intValue() == 2) {
                    i17 = sdk_event_log.SdkEventDimension.EVENT_APP_INSTALL_SUCCESS_FROM_APP_MARKET_BY_XIJING;
                    i3 = 3;
                    i16 = i17;
                    if (i16 != Integer.MIN_VALUE) {
                    }
                } else {
                    i3 = 0;
                    i16 = Integer.MIN_VALUE;
                    if (i16 != Integer.MIN_VALUE) {
                    }
                }
            }
        }
    }

    public final void b(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
        String str;
        Ad ad5;
        String appPackageName;
        Ad ad6;
        if (!h(params)) {
            QLog.e("AdAppInstallerHelper", 1, "observe error");
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[1];
        if (params != null && (ad6 = params.f61334ad) != null) {
            str = ad6.getAppPackageName();
        } else {
            str = null;
        }
        objArr[0] = str;
        String format = String.format("addAppData %s", Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.i("AdAppInstallerHelper", 1, format);
        if (params != null && (ad5 = params.f61334ad) != null && (appPackageName = ad5.getAppPackageName()) != null) {
            appData.put(appPackageName, new a(params, result));
        }
    }

    public final void c() {
        Activity activity;
        WeakReference<Activity> weakReference;
        if (!f()) {
            return;
        }
        for (Map.Entry<String, a> entry : appData.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            AdClickUtil.Params params = value.getParams();
            if (params != null && (weakReference = params.activity) != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (AdAppUtil.isInstalled(activity, key)) {
                k(key);
                l(value.getParams(), value.getResult());
                QLog.d("AdAppInstallerHelper", 1, "checkAppInstallStatusAndReport, is installed:" + key);
            }
        }
    }

    public final int d() {
        km0.a aVar = (km0.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(AdAppInstallConfigParser.INSTANCE.a());
        if (aVar == null) {
            return 30;
        }
        return aVar.getBackgroundDuration();
    }

    @Nullable
    public final a e(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        a aVar = appData.get(packageName);
        if (aVar == null) {
            aVar = null;
        }
        return aVar;
    }

    public final boolean f() {
        km0.a aVar = (km0.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(AdAppInstallConfigParser.INSTANCE.a());
        if (aVar == null) {
            return true;
        }
        return aVar.getIsNeedSupplementaryReport();
    }

    public final boolean g() {
        return appData.isEmpty();
    }

    public final boolean h(@Nullable AdClickUtil.Params params) {
        boolean z16;
        Activity activity;
        Ad ad5;
        WeakReference<Activity> weakReference;
        if (params != null) {
            z16 = params.isValidForApp();
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        String str = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null && (ad5 = params.f61334ad) != null) {
            str = ad5.getAppPackageName();
        }
        return !AdAppUtil.isInstalled(activity, str);
    }

    public final void i(@NotNull String packageName) {
        final AdClickUtil.Params params;
        String str;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        a e16 = e(packageName);
        if (e16 != null && (params = e16.getParams()) != null) {
            AdClickUtil.Result result = e16.getResult();
            k(packageName);
            l(params, result);
            if (params.isValidForApp()) {
                AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.gdtad.downloader.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.j(AdClickUtil.Params.this);
                    }
                }, 0, 1000L);
            }
            Ad ad5 = params.f61334ad;
            if (ad5 != null) {
                str = ad5.getAppPackageName();
            } else {
                str = null;
            }
            QLog.d("AdAppInstallerHelper", 1, "[onPackageAdded] success, packagename: " + str);
        }
    }

    public final void k(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        appData.remove(packageName);
    }
}
