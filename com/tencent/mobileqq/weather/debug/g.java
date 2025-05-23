package com.tencent.mobileqq.weather.debug;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import cooperation.qzone.api.QZoneContant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/weather/debug/g;", "", "Landroid/content/Context;", "a", "", "isSwitchOn", "", "g", "c", "f", "b", h.F, "d", "i", "e", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f313380a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(QZoneContant.REQUEST_CODE_INTIMATE_SPACE_PUNCH_SHARE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f313380a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Context a() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_weather_brief_warning_debug_switch", false);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_weather_main_page_native_switch", false);
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_weather_retain_dialog_freq_debug_switch", false);
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_weather_tianshu_data_debug_switch", false);
    }

    public final void f(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_weather_brief_warning_debug_switch", isSwitchOn);
    }

    public final void g(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_weather_main_page_native_switch", isSwitchOn);
    }

    public final void h(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_weather_retain_dialog_freq_debug_switch", isSwitchOn);
    }

    public final void i(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_weather_tianshu_data_debug_switch", isSwitchOn);
    }
}
