package com.tencent.mobileqq.aio.helper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0002J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/h;", "", "", "configID", "debugID", "", "defaultConfig", "defaultDebug", "qmmkvFileName", "d", "a", "b", "c", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f189065a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47146);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f189065a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ boolean e(h hVar, String str, String str2, boolean z16, boolean z17, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        boolean z18 = z16;
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            str3 = "common_mmkv_configurations";
        }
        return hVar.d(str, str2, z18, z19, str3);
    }

    public final boolean a(@NotNull String debugID, boolean defaultDebug, @NotNull String qmmkvFileName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, debugID, Boolean.valueOf(defaultDebug), qmmkvFileName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(debugID, "debugID");
        Intrinsics.checkNotNullParameter(qmmkvFileName, "qmmkvFileName");
        return QMMKV.from(MobileQQ.sMobileQQ, qmmkvFileName).decodeBool(debugID, defaultDebug);
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return e(this, "105964", "ai_emotion_make_same_switch", false, false, null, 28, null);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106145", false);
        QLog.i("AIOFeatureToggleHelper", 1, "remoteSwitchMenuRelatedEmotionOffline:" + isSwitchOn);
        return isSwitchOn;
    }

    public final boolean d(@NotNull String configID, @NotNull String debugID, boolean defaultConfig, boolean defaultDebug, @NotNull String qmmkvFileName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, configID, debugID, Boolean.valueOf(defaultConfig), Boolean.valueOf(defaultDebug), qmmkvFileName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configID, "configID");
        Intrinsics.checkNotNullParameter(debugID, "debugID");
        Intrinsics.checkNotNullParameter(qmmkvFileName, "qmmkvFileName");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(configID, defaultConfig);
        QLog.e("AIOFeatureToggleHelper", 2, "[" + configID + "][" + debugID + "] config isSwitchOn= " + isSwitchOn);
        if (debugID.length() <= 0) {
            z16 = false;
        }
        if (z16 && !isSwitchOn && !com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            boolean a16 = a(debugID, defaultDebug, qmmkvFileName);
            QLog.e("AIOFeatureToggleHelper", 2, "[" + configID + "][" + debugID + "] debug isSwitchOn= " + a16);
            return a16;
        }
        return isSwitchOn;
    }
}
