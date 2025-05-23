package com.tencent.aelight.camera.ae.flashshow.ui.multicamera;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/o;", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u001e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000bR\u0014\u0010\u001b\u001a\u00020\u001a8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/o$a;", "", "Landroid/widget/TextView;", "animationView", "", "repeatCount", "Lkotlin/Function0;", "", "countFinish", "Landroid/view/animation/AnimationSet;", "a", "Landroid/view/View;", "srcView", "targetView", "animationFinish", "Landroid/view/animation/Animation;", "e", "", "fromOrigin", "Landroid/graphics/Rect;", "sourceRect", "targetRect", "d", "c", "view", "b", "", "COUNT_DOWN_DURATION", "J", "TRANSLATE_DURATION", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.o$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/multicamera/o$a$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public static final class AnimationAnimationListenerC0558a implements Animation.AnimationListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TextView f64931d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f64932e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f64933f;

            AnimationAnimationListenerC0558a(TextView textView, Ref.IntRef intRef, Function0<Unit> function0) {
                this.f64931d = textView;
                this.f64932e = intRef;
                this.f64933f = function0;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                TextView textView = this.f64931d;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Ref.IntRef intRef = this.f64932e;
                int i3 = intRef.element - 1;
                intRef.element = i3;
                if (i3 == 0) {
                    TextView textView = this.f64931d;
                    if (textView != null) {
                        textView.setText("");
                    }
                    this.f64933f.invoke();
                    return;
                }
                if (i3 != 1) {
                    TextView textView2 = this.f64931d;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setText(String.valueOf(i3));
                    return;
                }
                TextView textView3 = this.f64931d;
                if (textView3 == null) {
                    return;
                }
                textView3.setText(String.valueOf(i3));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/multicamera/o$a$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.o$a$b */
        /* loaded from: classes32.dex */
        public static final class b implements Animation.AnimationListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f64934d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f64935e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f64936f;

            b(View view, View view2, Function0<Unit> function0) {
                this.f64934d = view;
                this.f64935e = view2;
                this.f64936f = function0;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f64934d.setVisibility(4);
                this.f64935e.setVisibility(0);
                this.f64936f.invoke();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimationSet a(TextView animationView, int repeatCount, Function0<Unit> countFinish) {
            Intrinsics.checkNotNullParameter(countFinish, "countFinish");
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = repeatCount;
            if (animationView != null) {
                animationView.setText(String.valueOf(repeatCount));
            }
            if (animationView != null) {
                animationView.setVisibility(0);
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setRepeatCount(intRef.element);
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setAnimationListener(new AnimationAnimationListenerC0558a(animationView, intRef, countFinish));
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            if (animationView != null) {
                animationView.startAnimation(animationSet);
            }
            return animationSet;
        }

        public final Rect b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i3 = iArr[0];
            return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
        }

        public final Animation d(boolean fromOrigin, Rect sourceRect, Rect targetRect) {
            Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
            Intrinsics.checkNotNullParameter(targetRect, "targetRect");
            float height = (targetRect.height() * 1.0f) / sourceRect.height();
            boolean z16 = true;
            if ((targetRect.width() * 1.0f) / sourceRect.width() == 1.0f) {
                if (height == 1.0f) {
                    z16 = false;
                }
            }
            if (z16) {
                return c(fromOrigin, sourceRect, targetRect);
            }
            if (fromOrigin) {
                float f16 = 0;
                return new TranslateAnimation(f16, targetRect.left - sourceRect.left, f16, targetRect.top - sourceRect.top);
            }
            float f17 = 0;
            return new TranslateAnimation(-(targetRect.left - sourceRect.left), f17, -(targetRect.top - sourceRect.top), f17);
        }

        public final Animation e(View srcView, View targetView, Function0<Unit> animationFinish) {
            Intrinsics.checkNotNullParameter(srcView, "srcView");
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(animationFinish, "animationFinish");
            Animation d16 = d(true, b(srcView), b(targetView));
            d16.setDuration(500L);
            d16.setAnimationListener(new b(srcView, targetView, animationFinish));
            srcView.startAnimation(d16);
            return d16;
        }

        Companion() {
        }

        public final Animation c(boolean fromOrigin, Rect sourceRect, Rect targetRect) {
            Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
            Intrinsics.checkNotNullParameter(targetRect, "targetRect");
            float width = (targetRect.width() * 1.0f) / sourceRect.width();
            float height = (targetRect.height() * 1.0f) / sourceRect.height();
            if (fromOrigin) {
                float f16 = 1;
                return new ScaleAnimation(1.0f, width, 1.0f, height, ((targetRect.right - sourceRect.left) - (sourceRect.width() * width)) / (f16 - width), ((targetRect.bottom - sourceRect.top) - (sourceRect.height() * height)) / (f16 - height));
            }
            float f17 = 1;
            float f18 = f17 / width;
            float f19 = f17 / height;
            return new ScaleAnimation(f18, 1.0f, f19, 1.0f, (sourceRect.left - targetRect.left) / (f17 - f18), (sourceRect.top - targetRect.top) / (f17 - f19));
        }
    }
}
