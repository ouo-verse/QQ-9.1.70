package com.tencent.mobileqq.base;

import androidx.annotation.AnimRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/base/FragmentAnimation;", "", "openEnterAnimation", "", "openExitAnimation", "closeEnterAnimation", "closeExitAnimation", "(Ljava/lang/String;IIIII)V", "getCloseEnterAnimation", "()I", "getCloseExitAnimation", "getOpenEnterAnimation", "getOpenExitAnimation", "DEFAULT", "PULL_UP", "SCALE_SELF", "IN_NONE_OUT_DEFAULT", "FAKE_IN_OUT_TOOL", "FAKE_IN_OUT_PREVIEW", "IN_DEFAULT_OUT_NONE", "NONE", "qqpay-ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class FragmentAnimation {
    private static final /* synthetic */ FragmentAnimation[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final FragmentAnimation DEFAULT;
    public static final FragmentAnimation FAKE_IN_OUT_PREVIEW;
    public static final FragmentAnimation FAKE_IN_OUT_TOOL;
    public static final FragmentAnimation IN_DEFAULT_OUT_NONE;
    public static final FragmentAnimation IN_NONE_OUT_DEFAULT;
    public static final FragmentAnimation NONE;
    public static final FragmentAnimation PULL_UP;
    public static final FragmentAnimation SCALE_SELF;
    private final int closeEnterAnimation;
    private final int closeExitAnimation;
    private final int openEnterAnimation;
    private final int openExitAnimation;

    private static final /* synthetic */ FragmentAnimation[] $values() {
        return new FragmentAnimation[]{DEFAULT, PULL_UP, SCALE_SELF, IN_NONE_OUT_DEFAULT, FAKE_IN_OUT_TOOL, FAKE_IN_OUT_PREVIEW, IN_DEFAULT_OUT_NONE, NONE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27462);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        DEFAULT = new FragmentAnimation("DEFAULT", 0, R.anim.activity_new, R.anim.activity_out, R.anim.activity_back, R.anim.activity_finish);
        PULL_UP = new FragmentAnimation("PULL_UP", 1, R.anim.f154424l, R.anim.f154425m, R.anim.f154425m, R.anim.f154423k);
        SCALE_SELF = new FragmentAnimation("SCALE_SELF", 2, R.anim.f154451a0, 0, 0, R.anim.f154452a1);
        IN_NONE_OUT_DEFAULT = new FragmentAnimation("IN_NONE_OUT_DEFAULT", 3, 0, 0, R.anim.activity_back, R.anim.activity_finish);
        FAKE_IN_OUT_TOOL = new FragmentAnimation("FAKE_IN_OUT_TOOL", 4, R.anim.f154548b2, R.anim.f154550b4, R.anim.activity_back, R.anim.activity_finish);
        FAKE_IN_OUT_PREVIEW = new FragmentAnimation("FAKE_IN_OUT_PREVIEW", 5, R.anim.activity_new, R.anim.activity_out, R.anim.f154548b2, R.anim.activity_finish);
        IN_DEFAULT_OUT_NONE = new FragmentAnimation("IN_DEFAULT_OUT_NONE", 6, R.anim.activity_new, R.anim.activity_out, 0, 0);
        NONE = new FragmentAnimation("NONE", 7, 0, 0, 0, 0);
        $VALUES = $values();
    }

    FragmentAnimation(@AnimRes String str, @AnimRes int i3, @AnimRes int i16, @AnimRes int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.openEnterAnimation = i16;
        this.openExitAnimation = i17;
        this.closeEnterAnimation = i18;
        this.closeExitAnimation = i19;
    }

    public static FragmentAnimation valueOf(String str) {
        return (FragmentAnimation) Enum.valueOf(FragmentAnimation.class, str);
    }

    public static FragmentAnimation[] values() {
        return (FragmentAnimation[]) $VALUES.clone();
    }

    public final int getCloseEnterAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.closeEnterAnimation;
    }

    public final int getCloseExitAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.closeExitAnimation;
    }

    public final int getOpenEnterAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.openEnterAnimation;
    }

    public final int getOpenExitAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.openExitAnimation;
    }
}
