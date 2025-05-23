package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u00010\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0003\u001b\u001e B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010%R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b;", "", "", "l", "j", "Landroid/view/View;", "topView", "bottomView", "i", "f", "d", tl.h.F, "g", "", "withAnim", "u", "t", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$b;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "r", "k", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "a", "Z", "viewExpand", "b", "doToggling", "c", "Landroid/view/View;", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$b;", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$c;", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$c;", "getInterceptListener", "()Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$c;", "p", "(Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$c;)V", "interceptListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "collapseRunnable", "com/tencent/mobileqq/icgame/room/displayview/horizontal/b$d", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$d;", "animListener", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"Recycle"})
/* loaded from: classes15.dex */
public final class b {

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

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC7928b listener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c interceptListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable collapseRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.a
        @Override // java.lang.Runnable
        public final void run() {
            b.c(b.this);
        }
    };

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d animListener = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$b;", "", "", "a", "b", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.room.displayview.horizontal.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7928b {
        void a();

        void b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$c;", "", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface c {
        boolean a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/horizontal/b$d", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            b.this.doToggling = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            b.this.doToggling = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            b.this.doToggling = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.interceptListener;
        if (cVar != null) {
            z16 = cVar.a();
        } else {
            z16 = false;
        }
        QLog.i("ICGameAutoCollapseController", 1, "collapseRunnable, outerIntercept " + z16 + "\uff0cviewExpand " + this$0.viewExpand);
        if (!z16 && this$0.viewExpand) {
            this$0.d();
        }
    }

    private final void d() {
        if (this.doToggling) {
            return;
        }
        QLog.i("ICGameAutoCollapseController", 1, "collapseView");
        this.viewExpand = false;
        h(this.topView, this.bottomView);
        InterfaceC7928b interfaceC7928b = this.listener;
        if (interfaceC7928b != null) {
            interfaceC7928b.a();
        }
    }

    private final void f() {
        if (this.doToggling) {
            return;
        }
        QLog.i("ICGameAutoCollapseController", 1, "collapseViewImmediately");
        this.viewExpand = false;
        View view = this.topView;
        if (view != null) {
            view.setTranslationY(-view.getHeight());
        }
        View view2 = this.bottomView;
        if (view2 != null) {
            view2.setTranslationY(-view2.getHeight());
        }
        InterfaceC7928b interfaceC7928b = this.listener;
        if (interfaceC7928b != null) {
            interfaceC7928b.a();
        }
    }

    private final void g() {
        this.handler.removeCallbacks(this.collapseRunnable);
        this.handler.postDelayed(this.collapseRunnable, 5000L);
    }

    private final void h(View topView, View bottomView) {
        ArrayList arrayList = new ArrayList();
        if (topView != null) {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(topView, "translationY", 0.0f, -topView.getHeight());
            Intrinsics.checkNotNullExpressionValue(anim1, "anim1");
            arrayList.add(anim1);
        }
        if (bottomView != null) {
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(bottomView, "translationY", 0.0f, bottomView.getHeight());
            Intrinsics.checkNotNullExpressionValue(anim2, "anim2");
            arrayList.add(anim2);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(this.animListener);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(150L).start();
    }

    private final void i(View topView, View bottomView) {
        ArrayList arrayList = new ArrayList();
        if (topView != null) {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(topView, "translationY", -topView.getHeight(), 0.0f);
            Intrinsics.checkNotNullExpressionValue(anim1, "anim1");
            arrayList.add(anim1);
        }
        if (bottomView != null) {
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(bottomView, "translationY", bottomView.getHeight(), 0.0f);
            Intrinsics.checkNotNullExpressionValue(anim2, "anim2");
            arrayList.add(anim2);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(this.animListener);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(150L).start();
    }

    private final void j() {
        if (this.doToggling) {
            return;
        }
        QLog.i("ICGameAutoCollapseController", 1, "expandView");
        this.viewExpand = true;
        i(this.topView, this.bottomView);
        InterfaceC7928b interfaceC7928b = this.listener;
        if (interfaceC7928b != null) {
            interfaceC7928b.b();
        }
    }

    private final void l() {
        if (this.doToggling) {
            return;
        }
        QLog.i("ICGameAutoCollapseController", 1, "expandViewImmediately");
        this.viewExpand = true;
        View view = this.topView;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        View view2 = this.bottomView;
        if (view2 != null) {
            view2.setTranslationY(0.0f);
        }
        InterfaceC7928b interfaceC7928b = this.listener;
        if (interfaceC7928b != null) {
            interfaceC7928b.b();
        }
    }

    private final void s(boolean withAnim) {
        QLog.i("ICGameAutoCollapseController", 1, "turnCollapseState: " + withAnim);
        this.handler.removeCallbacks(this.collapseRunnable);
        if (withAnim) {
            d();
        } else {
            f();
        }
    }

    private final void t() {
        QLog.i("ICGameAutoCollapseController", 1, "turnDelayCollapseState");
        g();
    }

    private final void u(boolean withAnim) {
        QLog.i("ICGameAutoCollapseController", 1, "turnExpandState: " + withAnim);
        if (withAnim) {
            j();
        } else {
            l();
        }
    }

    public final void e() {
        this.handler.removeCallbacks(this.collapseRunnable);
        f();
    }

    public final void k() {
        this.handler.removeCallbacks(this.collapseRunnable);
        l();
    }

    public final void m() {
        if (this.viewExpand) {
            s(true);
        } else {
            u(true);
            t();
        }
    }

    public final void n() {
        this.handler.removeCallbacks(this.collapseRunnable);
        this.listener = null;
    }

    public final void o(@Nullable View topView, @Nullable View bottomView) {
        QLog.i("ICGameAutoCollapseController", 1, "setAutoCollapseView");
        this.topView = topView;
        this.bottomView = bottomView;
        this.viewExpand = false;
        s(false);
    }

    public final void p(@Nullable c cVar) {
        this.interceptListener = cVar;
    }

    public final void q(@Nullable InterfaceC7928b listener) {
        this.listener = listener;
    }

    public final void r() {
        u(false);
        t();
    }
}
