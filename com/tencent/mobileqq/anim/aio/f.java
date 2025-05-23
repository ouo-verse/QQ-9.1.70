package com.tencent.mobileqq.anim.aio;

import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0007R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/f;", "", "", "i", "", "a", "Landroid/view/animation/Animation;", "animation", "Landroid/content/Context;", "context", "", "g", "Lcom/tencent/mobileqq/anim/aio/a;", "controller", "b", "d", "c", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BaseConstants.BROADCAST_USERSYNC_ENTER, tl.h.F, UserInfo.SEX_FEMALE, "AIO_TRANSLATE_X", "Z", "enableAlphaAnimationForSuperTheme", "f", "()Z", "useNewAIOTransitionAnimation", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f194321a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float AIO_TRANSLATE_X;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableAlphaAnimationForSuperTheme;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f fVar = new f();
        f194321a = fVar;
        AIO_TRANSLATE_X = fVar.a();
        enableAlphaAnimationForSuperTheme = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_use_alpha_transition_for_super_theme_8898", true);
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final float a() {
        return BaseApplication.context.getResources().getDimension(R.dimen.f158288c12) / BaseApplication.context.getResources().getDisplayMetrics().widthPixels;
    }

    private final boolean f() {
        return AIOAnimationConfig.f194304a.d();
    }

    private final void g(Animation animation, Context context) {
        if (!f() && !AIOTransitionAnimationSwitch.f194307a.a()) {
            animation.setInterpolator(BaseApplication.context, R.anim.f154977uk);
            animation.setDuration(context.getResources().getInteger(R.integer.f127024));
        } else {
            h a16 = AIOAnimationConfig.f194304a.a();
            animation.setInterpolator(new DecelerateInterpolator(a16.b()));
            animation.setDuration(a16.a());
        }
    }

    private final boolean i() {
        if (enableAlphaAnimationForSuperTheme && QQTheme.isNowThemeIsSuperTheme()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Animation b(@NotNull Context context, @NotNull a controller) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Animation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) controller);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (f()) {
            f16 = AIO_TRANSLATE_X;
        } else {
            f16 = 1.0f;
        }
        e eVar = new e(controller, null, f16, 0.0f, f(), true);
        f194321a.g(eVar, context);
        return eVar;
    }

    @NotNull
    public final Animation c(@NotNull Context context) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Animation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (f()) {
            f16 = AIO_TRANSLATE_X;
        } else {
            f16 = 1.0f;
        }
        g gVar = new g(0.0f, f16, f(), null, 0, 24, null);
        f194321a.g(gVar, context);
        return gVar;
    }

    @NotNull
    public final Animation d(@NotNull Context context) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Animation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (f()) {
            f16 = 0.0f;
        } else {
            f16 = -1.0f;
        }
        e eVar = new e(null, null, f16, 0.0f, i(), false);
        f194321a.g(eVar, context);
        return eVar;
    }

    @NotNull
    public final Animation e(@NotNull Context context) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Animation) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (f()) {
            f16 = 0.0f;
        } else {
            f16 = -1.0f;
        }
        g gVar = new g(0.0f, f16, i(), null, 0, 24, null);
        f194321a.g(gVar, context);
        return gVar;
    }

    @Deprecated(message = "use QActivityAnimationUtil instead")
    public final void h(@NotNull Activity activity, boolean enter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, Boolean.valueOf(enter));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        AIOAnimationConfig aIOAnimationConfig = AIOAnimationConfig.f194304a;
        if (aIOAnimationConfig.d()) {
            if (enter) {
                if (aIOAnimationConfig.e()) {
                    activity.overridePendingTransition(R.anim.f154447ld, R.anim.f154444la);
                    return;
                } else {
                    activity.overridePendingTransition(R.anim.f154446lc, R.anim.l_);
                    return;
                }
            }
            if (aIOAnimationConfig.e()) {
                activity.overridePendingTransition(R.anim.f154444la, R.anim.f154438l6);
                return;
            } else {
                activity.overridePendingTransition(R.anim.l_, R.anim.f154437l5);
                return;
            }
        }
        if (AIOTransitionAnimationSwitch.f194307a.a()) {
            if (enter) {
                activity.overridePendingTransition(R.anim.f154448le, R.anim.f154450lg);
                return;
            } else {
                activity.overridePendingTransition(R.anim.l3, R.anim.f154439l7);
                return;
            }
        }
        if (enter) {
            activity.overridePendingTransition(R.anim.f154445lb, R.anim.f154449lf);
        } else {
            activity.overridePendingTransition(R.anim.f154435l2, R.anim.f154436l4);
        }
    }
}
