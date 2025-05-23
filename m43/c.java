package m43;

import android.os.Build;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lm43/c;", "", "", "d", "", "startTime", "e", "c", "", "a", "step", "", "g", "b", QCircleDaTongConstant.ElementParamValue.PERMISSION, "f", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f416147a = new c();

    c() {
    }

    private final boolean d() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102819", false);
        QLog.d("OppoStepHelper", 2, "isInOppoSystemWhiteList: " + isSwitchOn);
        return isSwitchOn;
    }

    private final boolean e(long startTime) {
        if (startTime > SSOHttpUtils.d() && startTime < SSOHttpUtils.c()) {
            return true;
        }
        return false;
    }

    public final int a() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int decodeInt = from.decodeInt("honor_step_cache_data_key", 0);
        if (!e(from.decodeLong("honor_step_cache_date_key", 0L))) {
            return 0;
        }
        return decodeInt;
    }

    public final boolean b() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool("oppo_heytap_step_permission", false);
    }

    public final boolean c() {
        boolean contains$default;
        boolean z16;
        boolean contains$default2;
        boolean contains$default3;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "OPPO", false, 2, (Object) null);
        if (!contains$default) {
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) BRAND, (CharSequence) "OPPO", false, 2, (Object) null);
            if (!contains$default2) {
                String MODEL = DeviceInfoMonitor.getModel();
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "OPPO", false, 2, (Object) null);
                if (!contains$default3) {
                    z16 = false;
                    QLog.d("OppoStepHelper", 2, "isInOppoSystemWhiteList: " + MANUFACTURER + " " + Build.BRAND + " " + DeviceInfoMonitor.getModel());
                    if (!z16 && d()) {
                        return true;
                    }
                }
            }
        }
        z16 = true;
        QLog.d("OppoStepHelper", 2, "isInOppoSystemWhiteList: " + MANUFACTURER + " " + Build.BRAND + " " + DeviceInfoMonitor.getModel());
        return !z16 ? false : false;
    }

    public final void f(boolean permission) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool("oppo_heytap_step_permission", permission);
    }

    public final void g(int step) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt("honor_step_cache_data_key", step);
        from.encodeLong("honor_step_cache_date_key", NetConnInfoCenter.getServerTimeMillis());
    }
}
