package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\tR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/app/utils/c;", "", "", "a", "", "reuslt", "deviceWidth", "defaultDeviceWidth", "defaultDpi", "", "b", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Z", "reported", "d", "paramsInited", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f196649a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> reportParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean reported;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean paramsInited;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f196649a = new c();
            reportParams = new HashMap<>();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("report_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - decodeLong >= 86400000) {
            from.encodeLong("report_time", currentTimeMillis);
            return true;
        }
        return false;
    }

    public final void b(@NotNull String reuslt, @NotNull String deviceWidth, @NotNull String defaultDeviceWidth, @NotNull String defaultDpi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, reuslt, deviceWidth, defaultDeviceWidth, defaultDpi);
            return;
        }
        Intrinsics.checkNotNullParameter(reuslt, "reuslt");
        Intrinsics.checkNotNullParameter(deviceWidth, "deviceWidth");
        Intrinsics.checkNotNullParameter(defaultDeviceWidth, "defaultDeviceWidth");
        Intrinsics.checkNotNullParameter(defaultDpi, "defaultDpi");
        if (reported || paramsInited) {
            return;
        }
        paramsInited = true;
        HashMap<String, String> hashMap = reportParams;
        hashMap.put("adjust_result", reuslt);
        hashMap.put("device_width", deviceWidth);
        hashMap.put("default_device_width", defaultDeviceWidth);
        hashMap.put("default_densitydpi", defaultDpi);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (reported) {
            return;
        }
        reported = true;
        if (a()) {
            com.tencent.mobileqq.beacon.a.c("", "global_density_adjust", reportParams);
        }
        PropertiesUtils.tryPrintLog();
        GlobalDisplayMetricsManager.tryPrintLog();
    }
}
