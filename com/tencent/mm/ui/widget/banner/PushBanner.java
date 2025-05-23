package com.tencent.mm.ui.widget.banner;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.WindowManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.ep.a;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u0001:\u0002LMB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0007\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010)\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010%\u001a\u0004\b\u0003\u0010&\"\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u0016\u0010/\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.R\"\u00103\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\b\u001d\u00101\"\u0004\b\u0007\u00102R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00100R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u0010<\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b\u0007\u0010:\"\u0004\b\u0007\u0010;R$\u0010C\u001a\u0004\u0018\u00010=8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b*\u0010@\"\u0004\bA\u0010BR\u001a\u0010I\u001a\u00020D8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mm/ui/widget/banner/PushBanner;", "", "Landroid/view/MotionEvent;", "e", "Landroid/view/WindowManager$LayoutParams;", "lp", "", "a", "", "y", "", "Landroid/content/Context;", "context", "showBanner", "", "quickHide", "dismissBanner", "isShowing", "getLayoutId", "g", "Landroid/animation/Animator;", "onDisappearAnimator", "Landroid/view/ViewManager;", "Landroid/view/ViewManager;", "f", "()Landroid/view/ViewManager;", "(Landroid/view/ViewManager;)V", "windowManager", "Landroid/view/View;", "b", "Landroid/view/View;", "c", "()Landroid/view/View;", "setFloatView", "(Landroid/view/View;)V", "floatView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "getCustomView", "setCustomView", "customView", "Z", "fling", "I", "()I", "(I)V", "cardHeight", "viewDownY", h.F, UserInfo.SEX_FEMALE, "fingerDownY", "i", "Landroid/animation/Animator;", "()Landroid/animation/Animator;", "(Landroid/animation/Animator;)V", "animator", "Landroid/view/GestureDetector;", "j", "Landroid/view/GestureDetector;", "()Landroid/view/GestureDetector;", "setFloatWindowGestureDetector", "(Landroid/view/GestureDetector;)V", "floatWindowGestureDetector", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "k", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "getGestureDetectorListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "gestureDetectorListener", "<init>", "()V", "Companion", "WindowManagerProxy", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class PushBanner {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public ViewManager windowManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View floatView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ViewGroup rootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View customView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean fling;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int cardHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int viewDownY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public float fingerDownY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Animator animator;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public GestureDetector floatWindowGestureDetector;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final GestureDetector.SimpleOnGestureListener gestureDetectorListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$gestureDetectorListener$1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
            boolean z16;
            final WindowManager.LayoutParams layoutParams;
            int a16;
            float f16;
            Intrinsics.checkNotNullParameter(e26, "e2");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onFling: ");
            z16 = PushBanner.this.fling;
            sb5.append(z16);
            sb5.append(TokenParser.SP);
            sb5.append(velocityY);
            n.c("PushBanner", sb5.toString(), new Object[0]);
            if (velocityY < 0.0f) {
                PushBanner.this.fling = true;
                final View floatView = PushBanner.this.getFloatView();
                if (floatView != null) {
                    final PushBanner pushBanner = PushBanner.this;
                    ViewGroup.LayoutParams layoutParams2 = floatView.getLayoutParams();
                    if (layoutParams2 instanceof WindowManager.LayoutParams) {
                        layoutParams = (WindowManager.LayoutParams) layoutParams2;
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams != null) {
                        a16 = pushBanner.a(e26.getRawY());
                        f16 = pushBanner.fingerDownY;
                        ValueAnimator ofInt = ValueAnimator.ofInt(a16, -((int) (f16 + floatView.getHeight())));
                        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$gestureDetectorListener$1$onFling$1$1$1$1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(@NotNull Animator animation) {
                                Intrinsics.checkNotNullParameter(animation, "animation");
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(@NotNull Animator animation) {
                                Intrinsics.checkNotNullParameter(animation, "animation");
                                PushBanner.this.dismissBanner(true);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(@NotNull Animator animation) {
                                Intrinsics.checkNotNullParameter(animation, "animation");
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(@NotNull Animator animation) {
                                Intrinsics.checkNotNullParameter(animation, "animation");
                            }
                        });
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$gestureDetectorListener$1$onFling$1$1$1$2
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(@NotNull ValueAnimator animator) {
                                Intrinsics.checkNotNullParameter(animator, "animator");
                                WindowManager.LayoutParams layoutParams3 = layoutParams;
                                Object animatedValue = animator.getAnimatedValue();
                                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                                layoutParams3.y = ((Integer) animatedValue).intValue();
                                ViewManager windowManager = pushBanner.getWindowManager();
                                if (windowManager != null) {
                                    windowManager.updateViewLayout(floatView, layoutParams);
                                }
                            }
                        });
                        ofInt.setDuration(300L);
                        ofInt.start();
                    }
                }
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            WindowManager.LayoutParams layoutParams;
            int a16;
            int i3;
            Intrinsics.checkNotNullParameter(e26, "e2");
            n.c("PushBanner", "onScroll, distanceY: " + distanceY, new Object[0]);
            if (Math.abs(distanceY) <= 2.0f) {
                return false;
            }
            View floatView = PushBanner.this.getFloatView();
            if (floatView != null) {
                PushBanner pushBanner = PushBanner.this;
                ViewGroup.LayoutParams layoutParams2 = floatView.getLayoutParams();
                if (layoutParams2 instanceof WindowManager.LayoutParams) {
                    layoutParams = (WindowManager.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    a16 = pushBanner.a(e26.getRawY());
                    i3 = pushBanner.viewDownY;
                    layoutParams.y = Math.min(a16, i3);
                    ViewManager windowManager = pushBanner.getWindowManager();
                    if (windowManager != null) {
                        windowManager.updateViewLayout(floatView, layoutParams);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            n.c("PushBanner", "onSingleTapConfirmed: ", new Object[0]);
            return true;
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mm/ui/widget/banner/PushBanner$WindowManagerProxy;", "Landroid/view/ViewManager;", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "updateViewLayout", "removeView", "Landroid/view/WindowManager;", "a", "Landroid/view/WindowManager;", "windowManager", "<init>", "(Landroid/view/WindowManager;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class WindowManagerProxy implements ViewManager {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final WindowManager windowManager;

        public WindowManagerProxy(@NotNull WindowManager windowManager) {
            Intrinsics.checkNotNullParameter(windowManager, "windowManager");
            this.windowManager = windowManager;
        }

        @Override // android.view.ViewManager
        public void addView(@Nullable View view, @Nullable ViewGroup.LayoutParams params) {
            n.c("PushBanner", "addView() called with: view = " + view + ", params = " + params, new Object[0]);
            try {
                this.windowManager.addView(view, params);
            } catch (Exception e16) {
                n.b("PushBanner", "addView: ", e16);
            }
        }

        @Override // android.view.ViewManager
        public void removeView(@Nullable View view) {
            n.c("PushBanner", "removeView() called with: view = " + view, new Object[0]);
            try {
                this.windowManager.removeView(view);
            } catch (Exception e16) {
                n.b("PushBanner", "updateViewLayout: ", e16);
            }
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(@Nullable View view, @Nullable ViewGroup.LayoutParams params) {
            try {
                this.windowManager.updateViewLayout(view, params);
            } catch (Exception e16) {
                n.b("PushBanner", "updateViewLayout: ", e16);
            }
        }
    }

    public static /* synthetic */ void dismissBanner$default(PushBanner pushBanner, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        pushBanner.dismissBanner(z16);
    }

    public final void a(ViewManager viewManager) {
        this.windowManager = viewManager;
    }

    /* renamed from: b, reason: from getter */
    public final int getCardHeight() {
        return this.cardHeight;
    }

    /* renamed from: c, reason: from getter */
    public final View getFloatView() {
        return this.floatView;
    }

    /* renamed from: d, reason: from getter */
    public final GestureDetector getFloatWindowGestureDetector() {
        return this.floatWindowGestureDetector;
    }

    public void dismissBanner(boolean quickHide) {
        ViewGroup viewGroup;
        final View view = this.floatView;
        if (view != null) {
            if (quickHide) {
                View view2 = this.customView;
                if (view2 != null && (viewGroup = this.rootView) != null) {
                    viewGroup.removeView(view2);
                    this.customView = null;
                }
                ViewManager viewManager = this.windowManager;
                if (viewManager != null) {
                    viewManager.removeView(view);
                }
                this.windowManager = null;
                return;
            }
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            Animator onDisappearAnimator = onDisappearAnimator();
            onDisappearAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$dismissBanner$1$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    view.setVisibility(8);
                    if (this.getCustomView() != null && this.getRootView() != null) {
                        ViewGroup rootView = this.getRootView();
                        if (rootView != null) {
                            rootView.removeView(this.getCustomView());
                        }
                        this.setCustomView(null);
                    }
                    ViewManager windowManager = this.getWindowManager();
                    if (windowManager != null) {
                        windowManager.removeView(view);
                    }
                    this.a((ViewManager) null);
                    this.a((Animator) null);
                }
            });
            onDisappearAnimator.setDuration(200L);
            onDisappearAnimator.start();
            this.animator = onDisappearAnimator;
        }
    }

    /* renamed from: e, reason: from getter */
    public final ViewGroup getRootView() {
        return this.rootView;
    }

    /* renamed from: f, reason: from getter */
    public final ViewManager getWindowManager() {
        return this.windowManager;
    }

    public void g() {
        n.c("PushBanner", "initView: ", new Object[0]);
        final View view = this.floatView;
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$initView$1$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent event) {
                    int action = event.getAction();
                    if (action != 0) {
                        if (action == 1 || action == 3) {
                            PushBanner pushBanner = PushBanner.this;
                            Intrinsics.checkNotNullExpressionValue(event, "event");
                            pushBanner.a(event);
                        }
                    } else {
                        PushBanner pushBanner2 = PushBanner.this;
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                        pushBanner2.a(event, (WindowManager.LayoutParams) layoutParams);
                    }
                    GestureDetector floatWindowGestureDetector = PushBanner.this.getFloatWindowGestureDetector();
                    if (floatWindowGestureDetector != null) {
                        return floatWindowGestureDetector.onTouchEvent(event);
                    }
                    return false;
                }
            });
        }
    }

    @Nullable
    public final View getCustomView() {
        return this.customView;
    }

    public int getLayoutId() {
        return R.layout.fsf;
    }

    public boolean isShowing() {
        boolean z16;
        View view = this.floatView;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    @NotNull
    public Animator onDisappearAnimator() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, -this.cardHeight);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$onDisappearAnimator$1$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(@NotNull ValueAnimator animator) {
                WindowManager.LayoutParams layoutParams;
                Intrinsics.checkNotNullParameter(animator, "animator");
                View floatView = PushBanner.this.getFloatView();
                if (floatView != null) {
                    PushBanner pushBanner = PushBanner.this;
                    ViewGroup.LayoutParams layoutParams2 = floatView.getLayoutParams();
                    if (layoutParams2 instanceof WindowManager.LayoutParams) {
                        layoutParams = (WindowManager.LayoutParams) layoutParams2;
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams != null) {
                        Object animatedValue = animator.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                        layoutParams.y = ((Integer) animatedValue).intValue();
                        ViewManager windowManager = pushBanner.getWindowManager();
                        if (windowManager != null) {
                            windowManager.updateViewLayout(floatView, layoutParams);
                        }
                    }
                }
            }
        });
        ofInt.setDuration(200L);
        ofInt.start();
        Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(0, -cardHeight).ap\u2026        start()\n        }");
        return ofInt;
    }

    public final void setCustomView(@Nullable View view) {
        this.customView = view;
    }

    public final void showBanner(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.windowManager == null) {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            this.windowManager = new WindowManagerProxy((WindowManager) systemService);
        }
        if (this.floatView == null) {
            this.floatWindowGestureDetector = new GestureDetector(context, this.gestureDetectorListener);
            View view = null;
            View inflate = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) null, false);
            this.floatView = inflate;
            if (inflate != null) {
                view = inflate.findViewById(R.id.f166025e55);
            }
            this.rootView = (ViewGroup) view;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            i3 = 2038;
        } else {
            i3 = 2002;
        }
        layoutParams.type = i3;
        layoutParams.flags = 2621992;
        layoutParams.format = -3;
        layoutParams.packageName = context.getPackageName();
        layoutParams.gravity = 49;
        layoutParams.width = -1;
        layoutParams.height = -2;
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setElevation(a.a(context, 10.0f));
            View view2 = this.customView;
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent != null) {
                    Intrinsics.checkNotNullExpressionValue(parent, "parent");
                    ((ViewGroup) parent).removeView(this.customView);
                }
                viewGroup.addView(this.customView);
            }
        }
        g();
        final View view3 = this.floatView;
        if (view3 != null) {
            view3.setVisibility(4);
            ViewManager viewManager = this.windowManager;
            if (viewManager != null) {
                viewManager.addView(view3, layoutParams);
            }
            view3.post(new Runnable() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$showBanner$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    n.c("PushBanner", "show banner!!", new Object[0]);
                    PushBanner.this.a(view3.getMeasuredHeight());
                    Animator animator = PushBanner.this.getAnimator();
                    if (animator != null) {
                        animator.cancel();
                    }
                    PushBanner pushBanner = PushBanner.this;
                    ValueAnimator ofInt = ValueAnimator.ofInt(-pushBanner.getCardHeight(), 0);
                    final PushBanner pushBanner2 = PushBanner.this;
                    final View view4 = view3;
                    final View floatView = pushBanner2.getFloatView();
                    if (floatView != null) {
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$showBanner$2$1$1$1$1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(@NotNull ValueAnimator animator2) {
                                WindowManager.LayoutParams layoutParams2;
                                Intrinsics.checkNotNullParameter(animator2, "animator");
                                ViewGroup.LayoutParams layoutParams3 = floatView.getLayoutParams();
                                if (layoutParams3 instanceof WindowManager.LayoutParams) {
                                    layoutParams2 = (WindowManager.LayoutParams) layoutParams3;
                                } else {
                                    layoutParams2 = null;
                                }
                                if (layoutParams2 != null) {
                                    PushBanner pushBanner3 = pushBanner2;
                                    View view5 = floatView;
                                    Object animatedValue = animator2.getAnimatedValue();
                                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                                    layoutParams2.y = ((Integer) animatedValue).intValue();
                                    ViewManager windowManager = pushBanner3.getWindowManager();
                                    if (windowManager != null) {
                                        windowManager.updateViewLayout(view5, layoutParams2);
                                    }
                                }
                            }
                        });
                    }
                    ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$showBanner$2$1$1$2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(@NotNull Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            super.onAnimationEnd(animation);
                            pushBanner2.a((Animator) null);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(@NotNull Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            super.onAnimationStart(animation);
                            view4.setVisibility(0);
                        }
                    });
                    ofInt.setDuration(200L);
                    ofInt.start();
                    pushBanner.a(ofInt);
                }
            });
        }
        new Handler() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$showBanner$handler$1
            @Override // android.os.Handler
            public void handleMessage(@NotNull Message msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                PushBanner.dismissBanner$default(PushBanner.this, false, 1, null);
                super.handleMessage(msg2);
            }
        }.sendEmptyMessageDelayed(0, 8000L);
    }

    public final void a(int i3) {
        this.cardHeight = i3;
    }

    /* renamed from: a, reason: from getter */
    public final Animator getAnimator() {
        return this.animator;
    }

    public final void a(Animator animator) {
        this.animator = animator;
    }

    public final void a(MotionEvent e16, WindowManager.LayoutParams lp5) {
        n.c("PushBanner", "onDown: ", new Object[0]);
        this.fingerDownY = e16.getRawY();
        this.viewDownY = lp5.y;
    }

    public final void a(MotionEvent e16) {
        final int a16 = a(e16.getRawY());
        n.c("PushBanner", "onDragFinish: " + a16, new Object[0]);
        if (!this.fling && a(e16.getRawY()) <= this.viewDownY) {
            ValueAnimator ofInt = ValueAnimator.ofInt(a(e16.getRawY()), this.viewDownY);
            final View view = this.floatView;
            if (view != null) {
                ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$onDragFinish$1$1$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NotNull Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        int i3 = a16;
                        if (i3 < 0) {
                            Math.abs(i3);
                            ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                        }
                    }
                });
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.banner.PushBanner$onDragFinish$1$1$2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(@NotNull ValueAnimator animator) {
                        WindowManager.LayoutParams layoutParams;
                        Intrinsics.checkNotNullParameter(animator, "animator");
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        if (layoutParams2 instanceof WindowManager.LayoutParams) {
                            layoutParams = (WindowManager.LayoutParams) layoutParams2;
                        } else {
                            layoutParams = null;
                        }
                        if (layoutParams != null) {
                            PushBanner pushBanner = this;
                            View view2 = view;
                            Object animatedValue = animator.getAnimatedValue();
                            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                            layoutParams.y = ((Integer) animatedValue).intValue();
                            ViewManager windowManager = pushBanner.getWindowManager();
                            if (windowManager != null) {
                                windowManager.updateViewLayout(view2, layoutParams);
                            }
                        }
                    }
                });
            }
            ofInt.setDuration(300L);
            ofInt.start();
            return;
        }
        this.fling = false;
    }

    public final int a(float y16) {
        return this.viewDownY + ((int) (y16 - this.fingerDownY));
    }
}
