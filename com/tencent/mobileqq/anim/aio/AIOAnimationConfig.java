package com.tencent.mobileqq.anim.aio;

import com.tencent.mobileqq.anim.aio.AIOTransitionAnimationSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/AIOAnimationConfig;", "", "", "d", "e", "", "c", "b", "Lkotlin/Lazy;", "()J", "newAIOTransitionDuration", "Lcom/tencent/mobileqq/anim/aio/h;", "Lcom/tencent/mobileqq/anim/aio/h;", "_animationParameters", "value", "a", "()Lcom/tencent/mobileqq/anim/aio/h;", "setAnimationParameters", "(Lcom/tencent/mobileqq/anim/aio/h;)V", "animationParameters", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOAnimationConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOAnimationConfig f194304a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy newAIOTransitionDuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static h _animationParameters;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f194304a = new AIOAnimationConfig();
        lazy = LazyKt__LazyJVMKt.lazy(AIOAnimationConfig$newAIOTransitionDuration$2.INSTANCE);
        newAIOTransitionDuration = lazy;
        AIOTransitionAnimationSwitch aIOTransitionAnimationSwitch = AIOTransitionAnimationSwitch.f194307a;
    }

    AIOAnimationConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long b() {
        return ((Number) newAIOTransitionDuration.getValue()).longValue();
    }

    @NotNull
    public final h a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (_animationParameters == null) {
            _animationParameters = new h(c(), 1.5f);
        }
        h hVar = _animationParameters;
        Intrinsics.checkNotNull(hVar);
        return hVar;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return b();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        AIOTransitionAnimationSwitch aIOTransitionAnimationSwitch = AIOTransitionAnimationSwitch.f194307a;
        if (aIOTransitionAnimationSwitch.b() == AIOTransitionAnimationSwitch.SwitchState.NotSet || aIOTransitionAnimationSwitch.b() == AIOTransitionAnimationSwitch.SwitchState.Enabled) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (b() <= 160) {
            return true;
        }
        return false;
    }
}
