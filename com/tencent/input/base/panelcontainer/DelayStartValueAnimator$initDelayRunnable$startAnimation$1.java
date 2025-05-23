package com.tencent.input.base.panelcontainer;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/input/base/panelcontainer/DelayStartValueAnimator$initDelayRunnable$startAnimation$1", "Ljava/lang/Runnable;", TencentLocation.RUN_MODE, "", "input-base_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class DelayStartValueAnimator$initDelayRunnable$startAnimation$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f116777d;
    final /* synthetic */ DelayStartValueAnimator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelayStartValueAnimator$initDelayRunnable$startAnimation$1(DelayStartValueAnimator delayStartValueAnimator, long j3) {
        this.this$0 = delayStartValueAnimator;
        this.f116777d = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, delayStartValueAnimator, Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DelayStartValueAnimator this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mvi.log.b d16 = this$0.d();
        if (d16 != null) {
            d16.i("DelayStartValueAnimator", "mark start animation, delay=" + (System.currentTimeMillis() - j3) + "ms");
        }
        this$0.i(true);
        if (this$0.isPaused()) {
            com.tencent.mvi.log.b d17 = this$0.d();
            if (d17 != null) {
                d17.d("DelayStartValueAnimator", "resume animation");
            }
            this$0.resume();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.this$0.e().removeCallbacks(this);
        this.this$0.e().setDispatchDrawListener(null);
        com.tencent.mvi.log.b d16 = this.this$0.d();
        if (d16 != null) {
            d16.d("DelayStartValueAnimator", "on dispatch draw or timeout, delay=" + (System.currentTimeMillis() - this.f116777d) + "ms");
        }
        PanelFrameLayout e16 = this.this$0.e();
        final DelayStartValueAnimator delayStartValueAnimator = this.this$0;
        final long j3 = this.f116777d;
        e16.postDelayed(new Runnable() { // from class: com.tencent.input.base.panelcontainer.b
            @Override // java.lang.Runnable
            public final void run() {
                DelayStartValueAnimator$initDelayRunnable$startAnimation$1.b(DelayStartValueAnimator.this, j3);
            }
        }, this.this$0.c());
    }
}
