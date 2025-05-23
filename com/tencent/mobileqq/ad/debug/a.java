package com.tencent.mobileqq.ad.debug;

import android.content.Context;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/a;", "", "Landroid/content/Context;", "a", "", "isSwitchOn", "", "u", "j", "t", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "o", "d", "", "value", DomainData.DOMAIN_NAME, "c", "p", "e", "r", "g", ReportConstant.COSTREPORT_PREFIX, tl.h.F, "rewardType", "w", "l", "debugFreq", "v", "k", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f186830a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44667);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f186830a = new a();
        }
    }

    a() {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_gdtmv_debug_bottom_click_mode_switch", false);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeInt("key_gdtmv_debug_bottom_click_mode_value", 0);
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_gdtmv_debug_end_card_click_mode_switch", false);
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeInt("key_gdtmv_debug_end_card_click_mode_value", 0);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_gdtmv_debug_style_switch", false);
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeInt("key_gdtmv_debug_style_value", 1);
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_gdtmv_debug_none_button_switch", false);
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_gdtmv_debug_render_type_native_switch", false);
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_gdt_video_view_volume_on_switch", false);
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeBool("key_qq_shop_mask_ad_without_freq_debug", false);
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeInt("key_vas_reward_ad_reward_type", 0);
    }

    public final void m(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_gdtmv_debug_bottom_click_mode_switch", isSwitchOn);
    }

    public final void n(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, value);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeInt("key_gdtmv_debug_bottom_click_mode_value", value);
    }

    public final void o(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_gdtmv_debug_end_card_click_mode_switch", isSwitchOn);
    }

    public final void p(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, value);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeInt("key_gdtmv_debug_end_card_click_mode_value", value);
    }

    public final void q(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_gdtmv_debug_style_switch", isSwitchOn);
    }

    public final void r(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, value);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeInt("key_gdtmv_debug_style_value", value);
    }

    public final void s(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_gdtmv_debug_none_button_switch", isSwitchOn);
    }

    public final void t(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_gdtmv_debug_render_type_native_switch", isSwitchOn);
    }

    public final void u(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_gdt_video_view_volume_on_switch", isSwitchOn);
    }

    public final void v(boolean debugFreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, debugFreq);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeBool("key_qq_shop_mask_ad_without_freq_debug", debugFreq);
    }

    public final void w(int rewardType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, rewardType);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(a(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeInt("key_vas_reward_ad_reward_type", rewardType);
    }
}
