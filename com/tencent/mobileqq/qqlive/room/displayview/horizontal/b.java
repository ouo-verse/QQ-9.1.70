package com.tencent.mobileqq.qqlive.room.displayview.horizontal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001,\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0002\u001d B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002R\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010#R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010(R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", "", "", "k", "i", "Landroid/view/View;", "topView", "bottomView", h.F, "e", "d", "g", "f", "", "withAnim", "t", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$b;", "listener", "o", DomainData.DOMAIN_NAME, "", "topDy", "bottomDy", "p", "j", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Z", "viewExpand", "b", "doToggling", "c", "Landroid/view/View;", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "I", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$b;", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "collapseRunnable", "com/tencent/mobileqq/qqlive/room/displayview/horizontal/b$c", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$c;", "animListener", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"Recycle"})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean viewExpand;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean doToggling;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View topView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int topDy;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int bottomDy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC8369b listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable collapseRunnable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c animListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$a;", "", "", "AUTO_COLLAPSE_ANIM_TIME", "J", "AUTO_COLLAPSE_INTERVAL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.displayview.horizontal.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$b;", "", "", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.displayview.horizontal.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC8369b {
        void a();

        void b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/displayview/horizontal/b$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                b.this.doToggling = false;
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                b.this.doToggling = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                b.this.doToggling = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.handler = new Handler(Looper.getMainLooper());
        this.collapseRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.displayview.horizontal.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(b.this);
            }
        };
        this.animListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        QLog.i("AutoCollapseController", 1, "collapseRunnable, outerIntercept false\uff0cviewExpand " + this$0.viewExpand);
        if (this$0.viewExpand) {
            this$0.d();
        }
    }

    private final void d() {
        if (this.doToggling) {
            return;
        }
        QLog.i("AutoCollapseController", 1, "collapseView");
        this.viewExpand = false;
        g(this.topView, this.bottomView);
        InterfaceC8369b interfaceC8369b = this.listener;
        if (interfaceC8369b != null) {
            interfaceC8369b.a();
        }
    }

    private final void e() {
        if (this.doToggling) {
            return;
        }
        QLog.i("AutoCollapseController", 1, "collapseViewImmediately");
        this.viewExpand = false;
        View view = this.topView;
        if (view != null) {
            view.setTranslationY((-view.getHeight()) - this.topDy);
        }
        View view2 = this.bottomView;
        if (view2 != null) {
            view2.setTranslationY(view2.getHeight() + this.bottomDy);
        }
        InterfaceC8369b interfaceC8369b = this.listener;
        if (interfaceC8369b != null) {
            interfaceC8369b.a();
        }
    }

    private final void f() {
        this.handler.removeCallbacks(this.collapseRunnable);
        this.handler.postDelayed(this.collapseRunnable, 5000L);
    }

    private final void g(View topView, View bottomView) {
        ArrayList arrayList = new ArrayList();
        if (topView != null) {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(topView, "translationY", 0.0f, (-topView.getHeight()) - this.topDy);
            Intrinsics.checkNotNullExpressionValue(anim1, "anim1");
            arrayList.add(anim1);
        }
        if (bottomView != null) {
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(bottomView, "translationY", 0.0f, bottomView.getHeight() + this.bottomDy);
            Intrinsics.checkNotNullExpressionValue(anim2, "anim2");
            arrayList.add(anim2);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(this.animListener);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(150L).start();
    }

    private final void h(View topView, View bottomView) {
        ArrayList arrayList = new ArrayList();
        if (topView != null) {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(topView, "translationY", (-topView.getHeight()) - this.topDy, 0.0f);
            Intrinsics.checkNotNullExpressionValue(anim1, "anim1");
            arrayList.add(anim1);
        }
        if (bottomView != null) {
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(bottomView, "translationY", bottomView.getHeight() + this.bottomDy, 0.0f);
            Intrinsics.checkNotNullExpressionValue(anim2, "anim2");
            arrayList.add(anim2);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(this.animListener);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(150L).start();
    }

    private final void i() {
        if (this.doToggling) {
            return;
        }
        QLog.i("AutoCollapseController", 1, "expandView");
        this.viewExpand = true;
        h(this.topView, this.bottomView);
        InterfaceC8369b interfaceC8369b = this.listener;
        if (interfaceC8369b != null) {
            interfaceC8369b.b();
        }
    }

    private final void k() {
        if (this.doToggling) {
            return;
        }
        QLog.i("AutoCollapseController", 1, "expandViewImmediately");
        this.viewExpand = true;
        View view = this.topView;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        View view2 = this.bottomView;
        if (view2 != null) {
            view2.setTranslationY(0.0f);
        }
        InterfaceC8369b interfaceC8369b = this.listener;
        if (interfaceC8369b != null) {
            interfaceC8369b.b();
        }
    }

    public static /* synthetic */ void q(b bVar, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        bVar.p(i3, i16);
    }

    private final void r(boolean withAnim) {
        QLog.i("AutoCollapseController", 1, "turnCollapseState: " + withAnim);
        this.handler.removeCallbacks(this.collapseRunnable);
        if (withAnim) {
            d();
        } else {
            e();
        }
    }

    private final void s() {
        QLog.i("AutoCollapseController", 1, "turnDelayCollapseState");
        f();
    }

    private final void t(boolean withAnim) {
        QLog.i("AutoCollapseController", 1, "turnExpandState: " + withAnim);
        if (withAnim) {
            i();
        } else {
            k();
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.handler.removeCallbacks(this.collapseRunnable);
            k();
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.viewExpand) {
            r(true);
        } else {
            t(true);
            s();
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.handler.removeCallbacks(this.collapseRunnable);
            this.listener = null;
        }
    }

    public final void n(@Nullable View topView, @Nullable View bottomView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) topView, (Object) bottomView);
            return;
        }
        QLog.i("AutoCollapseController", 1, "setAutoCollapseView");
        this.topView = topView;
        this.bottomView = bottomView;
        this.viewExpand = false;
        r(false);
    }

    public final void o(@Nullable InterfaceC8369b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }

    public final void p(int topDy, int bottomDy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(topDy), Integer.valueOf(bottomDy));
            return;
        }
        this.topDy = topDy;
        this.bottomDy = bottomDy;
        t(false);
        s();
    }
}
