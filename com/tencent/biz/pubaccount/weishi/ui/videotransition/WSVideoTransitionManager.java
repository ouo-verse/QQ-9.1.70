package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.ui.videotransition.WSAnimConfig;
import com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0002!\u000fB\u0007\u00a2\u0006\u0004\b%\u0010&J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J*\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J&\u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionManager;", "", "Landroid/widget/ImageView;", "coverViewForAnim", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/graphics/RectF;", "startAnimRect", "endAnimRect", "", "g", "ivCoverForAnim", "smallElementRect", "bigElementRect", "Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSAnimConfig;", "b", "", "rootHeight", "startScale", "d", "c", "Landroid/content/Context;", "context", "", "e", "Landroid/view/ViewGroup;", "Landroid/graphics/drawable/Drawable;", "drawable", "f", h.F, "Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionManager$b;", "onExitAnimEndListener", "i", "a", "Landroid/view/ViewGroup;", "coverContainerForAnim", "Landroid/widget/ImageView;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVideoTransitionManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ViewGroup coverContainerForAnim;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCoverForAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionManager$b;", "", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void a();
    }

    private final float c(RectF endAnimRect, float rootHeight) {
        float e16 = rootHeight - c.f81667a.e();
        if (endAnimRect.height() / endAnimRect.width() > 1.5555556f) {
            return 0.0f;
        }
        return (e16 - endAnimRect.height()) / 2;
    }

    private final float d(RectF startAnimRect, RectF endAnimRect, float rootHeight, float startScale) {
        float e16 = rootHeight - c.f81667a.e();
        if (endAnimRect.height() / endAnimRect.width() > 1.5555556f) {
            return (endAnimRect.height() - (startAnimRect.height() / startScale)) / 2;
        }
        return (e16 - (startAnimRect.height() / startScale)) / 2;
    }

    private final int e(Context context) {
        Window window;
        View decorView;
        Drawable background;
        Integer num = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (background = decorView.getBackground()) != null) {
            num = Integer.valueOf(background.getAlpha());
        }
        if (num == null || num.intValue() == 0) {
            return 127;
        }
        return num.intValue();
    }

    public final void f(ViewGroup rootView, Drawable drawable, RectF startAnimRect, RectF endAnimRect) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(endAnimRect, "endAnimRect");
        ImageView imageView = new ImageView(rootView.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        imageView.setImageDrawable(drawable);
        g(imageView, rootView, startAnimRect, endAnimRect);
        FrameLayout frameLayout = new FrameLayout(rootView.getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        marginLayoutParams.bottomMargin = c.f81667a.e();
        frameLayout.setLayoutParams(marginLayoutParams);
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.addView(imageView);
        rootView.addView(frameLayout);
        this.ivCoverForAnim = imageView;
        this.coverContainerForAnim = frameLayout;
    }

    public final void h(final View rootView, RectF startAnimRect, RectF endAnimRect) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(startAnimRect, "startAnimRect");
        Intrinsics.checkNotNullParameter(endAnimRect, "endAnimRect");
        final WSAnimConfig b16 = b(rootView, this.ivCoverForAnim, startAnimRect, endAnimRect);
        WSVideoTransitionAnimator.n(WSVideoTransitionAnimator.f81645a, b16, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager$startEnterAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WSVideoTransitionReporter.f81655a.p(true);
                WSVideoTransitionAnimator wSVideoTransitionAnimator = WSVideoTransitionAnimator.f81645a;
                wSVideoTransitionAnimator.j(rootView, b16.d(1));
                wSVideoTransitionAnimator.k(rootView, b16.d(2), b16.d(3));
            }
        }, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager$startEnterAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewGroup viewGroup;
                viewGroup = WSVideoTransitionManager.this.coverContainerForAnim;
                if (viewGroup != null) {
                    WSVideoTransitionAnimator.f81645a.c(viewGroup, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager$startEnterAnim$2$1$onAnimEndListener$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            WSVideoTransitionReporter.f81655a.k(true);
                        }
                    });
                }
            }
        }, false, 8, null);
    }

    public final void i(ViewGroup rootView, RectF startAnimRect, RectF endAnimRect, final b onExitAnimEndListener) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(startAnimRect, "startAnimRect");
        Intrinsics.checkNotNullParameter(endAnimRect, "endAnimRect");
        Intrinsics.checkNotNullParameter(onExitAnimEndListener, "onExitAnimEndListener");
        WSAnimConfig b16 = b(rootView, this.ivCoverForAnim, endAnimRect, startAnimRect);
        WSVideoTransitionAnimator wSVideoTransitionAnimator = WSVideoTransitionAnimator.f81645a;
        wSVideoTransitionAnimator.m(b16, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager$startExitAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewGroup viewGroup;
                WSVideoTransitionReporter.f81655a.p(false);
                viewGroup = WSVideoTransitionManager.this.coverContainerForAnim;
                if (viewGroup == null) {
                    return;
                }
                viewGroup.setVisibility(0);
            }
        }, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager$startExitAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WSVideoTransitionManager.b.this.a();
                WSVideoTransitionReporter.f81655a.k(false);
            }
        }, true);
        wSVideoTransitionAnimator.o(rootView.getContext(), e(rootView.getContext()), 0);
    }

    private final void g(ImageView coverViewForAnim, View rootView, RectF startAnimRect, RectF endAnimRect) {
        if (startAnimRect == null) {
            return;
        }
        WSAnimConfig b16 = b(rootView, coverViewForAnim, startAnimRect, endAnimRect);
        WSVideoTransitionAnimator.f81645a.i(coverViewForAnim, rootView.getMeasuredWidth(), b16.d(4), (int) b16.d(6));
    }

    private final WSAnimConfig b(View rootView, ImageView ivCoverForAnim, RectF smallElementRect, RectF bigElementRect) {
        int measuredHeight = rootView.getMeasuredHeight();
        float width = smallElementRect.width() / bigElementRect.width();
        float scaleX = rootView.getScaleX();
        float width2 = smallElementRect.width() / smallElementRect.height();
        float width3 = bigElementRect.width() / bigElementRect.height();
        float f16 = measuredHeight;
        float d16 = d(smallElementRect, bigElementRect, f16, width);
        float f17 = 1 - width;
        float f18 = 2;
        return new WSAnimConfig.a().c(rootView).b(ivCoverForAnim).d(1, width, scaleX).d(2, smallElementRect.left - ((bigElementRect.width() * f17) / f18), rootView.getTranslationX()).d(3, (smallElementRect.top - ((f17 * f16) / f18)) - (d16 * width), rootView.getTranslationY()).d(4, width2, width3).d(6, d16, c(bigElementRect, f16)).d(7, d16, 0.0f).d(5, bigElementRect.width() / width2, f16).a();
    }
}
