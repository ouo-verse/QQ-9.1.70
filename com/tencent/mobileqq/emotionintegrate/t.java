package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/t;", "", "", "c", "a", "b", "e", "d", "f", "g", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f205295a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f205295a = new t();
        }
    }

    t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("aio_album_gif_emotion_download_8983_887534777", Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026d_8983_887534777\", false)");
        return isSwitchOn.booleanValue();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emotion_detail_fix_bug_8983_114577103", Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026ug_8983_114577103\", true)");
        return isSwitchOn.booleanValue();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emotion_download_disable_8980_887036489", Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026le_8980_887036489\", true)");
        return isSwitchOn.booleanValue();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        Boolean switchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emoticon_show_commercial_when_scroll_121207799", Boolean.FALSE);
        QLog.i("EmotionSwitchHelper", 1, "emoticon_show_commercial_when_scroll_121207799:" + switchOn);
        Intrinsics.checkNotNullExpressionValue(switchOn, "switchOn");
        return switchOn.booleanValue();
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Boolean switchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emoticon_show_commercial_116147289", Boolean.TRUE);
        QLog.i("EmotionSwitchHelper", 1, "emoticon_show_commercial_116147289:" + switchOn);
        Intrinsics.checkNotNullExpressionValue(switchOn, "switchOn");
        return switchOn.booleanValue();
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        Boolean switchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emoticon_show_ocr_info_121284393", Boolean.TRUE);
        QLog.i("EmotionSwitchHelper", 1, "emoticon_show_ocr_info_121284393:" + switchOn);
        Intrinsics.checkNotNullExpressionValue(switchOn, "switchOn");
        return switchOn.booleanValue();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emoticon_skip_clear_field_121207121", Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026r_field_121207121\", true)");
        return isSwitchOn.booleanValue();
    }
}
