package com.tencent.mobileqq.anim.aio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.tencwebrtc.PeerConnectionFactory;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R*\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R*\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/AIOTransitionAnimationSwitch;", "", "", "b", "Z", "useNewAIOTransitionAnimationInit", "Lcom/tencent/mobileqq/anim/aio/AIOTransitionAnimationSwitch$SwitchState;", "value", "c", "Lcom/tencent/mobileqq/anim/aio/AIOTransitionAnimationSwitch$SwitchState;", "()Lcom/tencent/mobileqq/anim/aio/AIOTransitionAnimationSwitch$SwitchState;", "setUseNewAIOTransitionAnimation", "(Lcom/tencent/mobileqq/anim/aio/AIOTransitionAnimationSwitch$SwitchState;)V", "useNewAIOTransitionAnimation", "d", "useDecelerateInterpolatorInit", "e", "a", "()Z", "setUseDecelerateInterpolator", "(Z)V", "useDecelerateInterpolator", "<init>", "()V", "SwitchState", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTransitionAnimationSwitch {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOTransitionAnimationSwitch f194307a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean useNewAIOTransitionAnimationInit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SwitchState useNewAIOTransitionAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean useDecelerateInterpolatorInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean useDecelerateInterpolator;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/AIOTransitionAnimationSwitch$SwitchState;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NotSet", PeerConnectionFactory.TRIAL_ENABLED, "Disabled", "qqui_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class SwitchState {
        private static final /* synthetic */ SwitchState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SwitchState Disabled;
        public static final SwitchState Enabled;
        public static final SwitchState NotSet;
        private final int value;

        private static final /* synthetic */ SwitchState[] $values() {
            return new SwitchState[]{NotSet, Enabled, Disabled};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36826);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            NotSet = new SwitchState("NotSet", 0, 0);
            Enabled = new SwitchState(PeerConnectionFactory.TRIAL_ENABLED, 1, 1);
            Disabled = new SwitchState("Disabled", 2, 2);
            $VALUES = $values();
        }

        SwitchState(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static SwitchState valueOf(String str) {
            return (SwitchState) Enum.valueOf(SwitchState.class, str);
        }

        public static SwitchState[] values() {
            return (SwitchState[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f194307a = new AIOTransitionAnimationSwitch();
            useNewAIOTransitionAnimation = SwitchState.NotSet;
        }
    }

    AIOTransitionAnimationSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!useDecelerateInterpolatorInit) {
            useDecelerateInterpolatorInit = true;
            useDecelerateInterpolator = QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeBool("KEY_AIO_TRANSITION_USE_DECELERATE_INTERPOLATOR", false);
        }
        return useDecelerateInterpolator;
    }

    @NotNull
    public final SwitchState b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SwitchState) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!useNewAIOTransitionAnimationInit) {
            useNewAIOTransitionAnimationInit = true;
            useNewAIOTransitionAnimation = SwitchState.values()[QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeInt("KEY_USE_NEW_AIO_TRANSITION_ANIMATION_2", SwitchState.NotSet.getValue())];
        }
        return useNewAIOTransitionAnimation;
    }
}
