package bs1;

import android.os.Build;
import android.util.DisplayMetrics;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lbs1/a;", "", "", "b", "f", "", "e", "", "d", "c", UserInfo.SEX_FEMALE, "displayDensity", "contextDisplayDensity", "Landroid/util/DisplayMetrics;", "Landroid/util/DisplayMetrics;", "fontMetrics", "displayMetrics", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29031a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float displayDensity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final float contextDisplayDensity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DisplayMetrics fontMetrics;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DisplayMetrics displayMetrics;

    static {
        a aVar = new a();
        f29031a = aVar;
        displayDensity = aVar.d();
        contextDisplayDensity = aVar.c();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(FontSettingManager.customMetrics);
        fontMetrics = displayMetrics2;
        DisplayMetrics displayMetrics3 = new DisplayMetrics();
        displayMetrics3.setTo(ch.i().getResources().getDisplayMetrics());
        displayMetrics = displayMetrics3;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.LeftBarItemDensityChangeValidator", 2, "init()");
        }
    }

    a() {
    }

    @JvmStatic
    public static final void b() {
        boolean z16;
        a aVar = f29031a;
        boolean z17 = false;
        if (aVar.d() == displayDensity) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (aVar.c() == contextDisplayDensity) {
                z17 = true;
            }
            if (z17) {
                return;
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "\u68c0\u6d4b\u53d1\u73b0 density \u88ab\u5f02\u5e38\u4fee\u6539! " + aVar.e();
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.MF.Lt.LeftBarItemDensityChangeValidator", 1, (String) it.next(), null);
        }
        f29031a.f();
    }

    private final float c() {
        return ch.i().getResources().getDisplayMetrics().density;
    }

    private final float d() {
        float f16 = FontSettingManager.customMetrics.density;
        if (f16 <= 0.0f) {
            return ch.i().getResources().getDisplayMetrics().density;
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String trimIndent;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            density: " + contextDisplayDensity + "  --  " + d() + "\n            font: " + fontMetrics + " -- " + FontSettingManager.customMetrics + "\n            display: " + displayMetrics + " -- " + ch.i().getResources().getDisplayMetrics() + "\n        ");
        return trimIndent;
    }

    private final void f() {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("DensityMsg", fontMetrics.density + "-" + FontSettingManager.customMetrics.density + APLogFileUtil.SEPARATOR_LOG + contextDisplayDensity + "--" + d()), TuplesKt.to("Uin", ch.g()), TuplesKt.to("OsInfo", String.valueOf(ah.K())), TuplesKt.to(QCircleVideoDeviceInfoUtils.STRATEGY_DEVICE_MODEL, ah.s()), TuplesKt.to("DeviceOS", ah.t()), TuplesKt.to("Sdkversion", String.valueOf(Build.VERSION.SDK_INT)));
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#density_error", hashMapOf);
    }
}
