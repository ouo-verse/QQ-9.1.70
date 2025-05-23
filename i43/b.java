package i43;

import android.content.Context;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Li43/b;", "", "Landroid/content/Context;", "a", "", "c", "isSwitchOn", "", "g", "", "d", "step", tl.h.F, "b", "f", "e", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "i", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f407199a = new b();

    b() {
    }

    private final Context a() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public final int b() {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeInt("key_health_debug_get_step_data_friend", 0);
    }

    public final boolean c() {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_health_use_debug_data_switch", false);
    }

    public final int d() {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeInt("key_health_debug_get_step_data_myself", 0);
    }

    public final boolean e() {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_health_debug_open_kuikly_switch", false);
    }

    public final void f(int step) {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeInt("key_health_debug_get_step_data_friend", step);
    }

    public final void g(boolean isSwitchOn) {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_health_use_debug_data_switch", isSwitchOn);
    }

    public final void h(int step) {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeInt("key_health_debug_get_step_data_myself", step);
    }

    public final void i(boolean r36) {
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_health_debug_open_kuikly_switch", r36);
    }
}
