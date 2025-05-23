package com.tencent.input.base.panelcontainer;

import android.animation.ValueAnimator;
import com.tencent.input.base.panelcontainer.PanelFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0006\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/input/base/panelcontainer/DelayStartValueAnimator;", "Landroid/animation/ValueAnimator;", "", tl.h.F, "start", "Lcom/tencent/input/base/panelcontainer/PanelFrameLayout;", "d", "Lcom/tencent/input/base/panelcontainer/PanelFrameLayout;", "e", "()Lcom/tencent/input/base/panelcontainer/PanelFrameLayout;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/mvi/log/b;", "Lcom/tencent/mvi/log/b;", "()Lcom/tencent/mvi/log/b;", "logger", "", "f", "I", "c", "()I", "delayTime", "", "Z", "()Z", "i", "(Z)V", QZoneJsConstants.ACTION_START_ANIMATION, "<init>", "(Lcom/tencent/input/base/panelcontainer/PanelFrameLayout;Lcom/tencent/mvi/log/b;I)V", "a", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class DelayStartValueAnimator extends ValueAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PanelFrameLayout panel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mvi.log.b logger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int delayTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean startAnimation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/input/base/panelcontainer/DelayStartValueAnimator$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.DelayStartValueAnimator$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/input/base/panelcontainer/DelayStartValueAnimator$b", "Lcom/tencent/input/base/panelcontainer/PanelFrameLayout$a;", "", "a", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements PanelFrameLayout.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DelayStartValueAnimator$initDelayRunnable$startAnimation$1 f116776a;

        b(DelayStartValueAnimator$initDelayRunnable$startAnimation$1 delayStartValueAnimator$initDelayRunnable$startAnimation$1) {
            this.f116776a = delayStartValueAnimator$initDelayRunnable$startAnimation$1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) delayStartValueAnimator$initDelayRunnable$startAnimation$1);
            }
        }

        @Override // com.tencent.input.base.panelcontainer.PanelFrameLayout.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f116776a.run();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DelayStartValueAnimator(@NotNull PanelFrameLayout panel, @Nullable com.tencent.mvi.log.b bVar, int i3) {
        Intrinsics.checkNotNullParameter(panel, "panel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, panel, bVar, Integer.valueOf(i3));
            return;
        }
        this.panel = panel;
        this.logger = bVar;
        this.delayTime = i3;
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.input.base.panelcontainer.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DelayStartValueAnimator.b(DelayStartValueAnimator.this, valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DelayStartValueAnimator this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.f()) {
            com.tencent.mvi.log.b d16 = this$0.d();
            if (d16 != null) {
                d16.d("DelayStartValueAnimator", "pause animation");
            }
            this$0.pause();
        }
    }

    private final void h() {
        if (this.delayTime <= 0) {
            this.startAnimation = true;
            return;
        }
        DelayStartValueAnimator$initDelayRunnable$startAnimation$1 delayStartValueAnimator$initDelayRunnable$startAnimation$1 = new DelayStartValueAnimator$initDelayRunnable$startAnimation$1(this, System.currentTimeMillis());
        this.panel.setDispatchDrawListener(new b(delayStartValueAnimator$initDelayRunnable$startAnimation$1));
        this.panel.postDelayed(delayStartValueAnimator$initDelayRunnable$startAnimation$1, 200L);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.delayTime;
    }

    @Nullable
    public final com.tencent.mvi.log.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mvi.log.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.logger;
    }

    @NotNull
    public final PanelFrameLayout e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PanelFrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.panel;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.startAnimation;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.startAnimation = z16;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h();
            super.start();
        }
    }
}
