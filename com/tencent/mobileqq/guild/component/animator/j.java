package com.tencent.mobileqq.guild.component.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.guild.component.animator.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003\t$'\u0018\u00002\u00020\u0001:\u0003\n\u000e\u0015B\u0011\b\u0000\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/j;", "", "", "g", "p", tl.h.F, "i", "", "l", "com/tencent/mobileqq/guild/component/animator/j$d", "a", "Lcom/tencent/mobileqq/guild/component/animator/j$d;", "onTouchListener", "Lcom/tencent/mobileqq/guild/component/animator/j$a;", "b", "Lcom/tencent/mobileqq/guild/component/animator/j$a;", "getAnimatorProvider$qqguild_component_release", "()Lcom/tencent/mobileqq/guild/component/animator/j$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/guild/component/animator/j$a;)V", "animatorProvider", "c", "Z", "j", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "ignoreTouchEventWhenAnimating", "d", "pressDownAnimating", "e", "pressUpAnimating", "Lcom/tencent/mobileqq/guild/component/animator/j$b;", "f", "Lcom/tencent/mobileqq/guild/component/animator/j$b;", "delayPressEvent", "com/tencent/mobileqq/guild/component/animator/j$e", "Lcom/tencent/mobileqq/guild/component/animator/j$e;", "pressDownEndAction", "com/tencent/mobileqq/guild/component/animator/j$f", "Lcom/tencent/mobileqq/guild/component/animator/j$f;", "pressUpEndAction", "Lcom/tencent/mobileqq/guild/component/animator/j$c;", "pressableAnimatorListener", "Lcom/tencent/mobileqq/guild/component/animator/j$c;", "k", "()Lcom/tencent/mobileqq/guild/component/animator/j$c;", "o", "(Lcom/tencent/mobileqq/guild/component/animator/j$c;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d onTouchListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a animatorProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean ignoreTouchEventWhenAnimating;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean pressDownAnimating;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean pressUpAnimating;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b delayPressEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e pressDownEndAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f pressUpEndAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/j$a;", "", "Landroid/view/ViewPropertyAnimator;", "a", "b", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/view/animation/DecelerateInterpolator;", "Landroid/view/animation/DecelerateInterpolator;", "pressDownInterpolator", "c", "pressUpInterpolator", "<init>", "(Landroid/view/View;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final DecelerateInterpolator pressDownInterpolator;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final DecelerateInterpolator pressUpInterpolator;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.pressDownInterpolator = new DecelerateInterpolator();
            this.pressUpInterpolator = new DecelerateInterpolator();
        }

        @NotNull
        public ViewPropertyAnimator a() {
            ViewPropertyAnimator animate = this.view.animate();
            animate.setDuration(150L);
            animate.scaleX(0.9f);
            animate.scaleY(0.9f);
            animate.setInterpolator(this.pressDownInterpolator);
            Intrinsics.checkNotNullExpressionValue(animate, "view.animate().apply {\n \u2026nterpolator\n            }");
            return animate;
        }

        @NotNull
        public ViewPropertyAnimator b() {
            ViewPropertyAnimator animate = this.view.animate();
            animate.setDuration(250L);
            animate.scaleX(1.0f);
            animate.scaleY(1.0f);
            animate.setInterpolator(this.pressUpInterpolator);
            Intrinsics.checkNotNullExpressionValue(animate, "view.animate().apply {\n \u2026nterpolator\n            }");
            return animate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u000f\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/j$b;", "", "", "d", "", "a", "Z", "b", "()Z", "f", "(Z)V", "pressDown", "c", "g", "pressUp", "e", "cancelled", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean pressDown;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean pressUp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean cancelled;

        /* renamed from: a, reason: from getter */
        public final boolean getCancelled() {
            return this.cancelled;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getPressDown() {
            return this.pressDown;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getPressUp() {
            return this.pressUp;
        }

        public final void d() {
            this.pressDown = false;
            this.pressUp = false;
            this.cancelled = false;
        }

        public final void e(boolean z16) {
            this.cancelled = z16;
        }

        public final void f(boolean z16) {
            this.pressDown = z16;
        }

        public final void g(boolean z16) {
            this.pressUp = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/j$c;", "", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0017R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/guild/component/animator/j$d", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "", "b", "view", "", "c", "Landroid/view/MotionEvent;", "event", "onTouch", "", "d", "Ljava/lang/String;", "TAG", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "actionDownTask", "f", "Z", "invalidTouchMotion", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Runnable actionDownTask;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String TAG = "PressableViewAnimator.onTouch";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean invalidTouchMotion = true;

        d() {
        }

        private final void b(View v3) {
            Runnable runnable = this.actionDownTask;
            if (runnable != null) {
                v3.removeCallbacks(runnable);
            }
        }

        private final boolean c(View view) {
            ViewParent parent = view.getParent();
            while (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
                parent = viewGroup.getParent();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(j this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.delayPressEvent.f(true);
            this$0.g();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        
            if (r0 != 6) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
        
            if (r11 == false) goto L44;
         */
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            if (v3.isEnabled() && v3.isClickable()) {
                int actionMasked = event.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked != 5) {
                                }
                            } else {
                                C11734b c11734b = C11734b.f433780a;
                                String str = this.TAG;
                                if (QLog.isDebugVersion()) {
                                    QLog.d("Guild.component." + str, 2, "action_cancel " + v3, (Throwable) null);
                                }
                                if (this.invalidTouchMotion) {
                                    return false;
                                }
                                b(v3);
                                j.this.delayPressEvent.g(true);
                                j.this.delayPressEvent.e(true);
                                j.this.p();
                            }
                        } else if (!this.invalidTouchMotion && !j.this.delayPressEvent.getCancelled()) {
                            float width = v3.getWidth();
                            float x16 = event.getX();
                            if (0.0f <= x16 && x16 <= width) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                float height = v3.getHeight();
                                float y16 = event.getY();
                                if (0.0f <= y16 && y16 <= height) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                            }
                            C11734b c11734b2 = C11734b.f433780a;
                            String str2 = this.TAG;
                            if (QLog.isDebugVersion()) {
                                QLog.d("Guild.component." + str2, 2, "action_move, out of " + v3, (Throwable) null);
                            }
                            b(v3);
                            j.this.delayPressEvent.e(true);
                        }
                    }
                    C11734b c11734b3 = C11734b.f433780a;
                    String str3 = this.TAG;
                    if (QLog.isDebugVersion()) {
                        QLog.d("Guild.component." + str3, 2, "action_up " + v3, (Throwable) null);
                    }
                    if (this.invalidTouchMotion) {
                        return false;
                    }
                    j.this.delayPressEvent.g(true);
                    b(v3);
                    if (!j.this.delayPressEvent.getPressDown()) {
                        j.this.delayPressEvent.f(true);
                        j.this.g();
                    }
                    j.this.p();
                }
                C11734b c11734b4 = C11734b.f433780a;
                String str4 = this.TAG;
                if (QLog.isDebugVersion()) {
                    QLog.d("Guild.component." + str4, 2, "action_down " + v3, (Throwable) null);
                }
                if (j.this.getIgnoreTouchEventWhenAnimating() && j.this.l()) {
                    String str5 = this.TAG;
                    if (QLog.isDebugVersion()) {
                        QLog.d("Guild.component." + str5, 2, "ignore action_down " + v3, (Throwable) null);
                    }
                    this.invalidTouchMotion = true;
                    return false;
                }
                this.invalidTouchMotion = false;
                j.this.i();
                if (c(v3)) {
                    if (this.actionDownTask == null) {
                        final j jVar = j.this;
                        this.actionDownTask = new Runnable() { // from class: com.tencent.mobileqq.guild.component.animator.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                j.d.d(j.this);
                            }
                        };
                    }
                    v3.postDelayed(this.actionDownTask, ViewConfiguration.getTapTimeout());
                } else {
                    j.this.delayPressEvent.f(true);
                    j.this.g();
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/component/animator/j$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            j.this.k();
            j.this.pressDownAnimating = false;
            j.this.p();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/component/animator/j$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            j.this.k();
            j.this.pressUpAnimating = false;
        }
    }

    public j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        d dVar = new d();
        this.onTouchListener = dVar;
        this.animatorProvider = new a(view);
        this.delayPressEvent = new b();
        this.pressDownEndAction = new e();
        this.pressUpEndAction = new f();
        view.setClickable(true);
        view.setOnTouchListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.pressDownAnimating = true;
        this.animatorProvider.a();
        this.animatorProvider.a().setListener(this.pressDownEndAction).start();
    }

    private final void h() {
        this.pressUpAnimating = true;
        this.animatorProvider.b().setListener(this.pressUpEndAction).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        this.delayPressEvent.d();
        this.animatorProvider.a().cancel();
        this.animatorProvider.b().cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (!this.pressDownAnimating && this.delayPressEvent.getPressDown() && this.delayPressEvent.getPressUp()) {
            h();
            this.delayPressEvent.d();
        }
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIgnoreTouchEventWhenAnimating() {
        return this.ignoreTouchEventWhenAnimating;
    }

    @Nullable
    public final c k() {
        return null;
    }

    public final boolean l() {
        if (!this.pressDownAnimating && !this.pressUpAnimating) {
            return false;
        }
        return true;
    }

    public final void m(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.animatorProvider = aVar;
    }

    public final void n(boolean z16) {
        this.ignoreTouchEventWhenAnimating = z16;
    }

    public final void o(@Nullable c cVar) {
    }
}
