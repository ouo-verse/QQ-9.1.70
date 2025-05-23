package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.cx;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB%\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/p;", "", "", "g", "c", "", "progress", "i", tl.h.F, "d", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "thumbCoverContainer", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "progressText", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxProgressBar;", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxProgressBar;", "progressBar", "", "Z", "thumbCoverContainerEndState", "<init>", "(Landroid/view/ViewGroup;Landroid/widget/TextView;Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxProgressBar;)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ViewGroup thumbCoverContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView progressText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QFSRectBoxProgressBar progressBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean thumbCoverContainerEndState;

    public p(@Nullable ViewGroup viewGroup, @Nullable TextView textView, @Nullable QFSRectBoxProgressBar qFSRectBoxProgressBar) {
        this.thumbCoverContainer = viewGroup;
        this.progressText = textView;
        this.progressBar = qFSRectBoxProgressBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSRectBoxProgressBar qFSRectBoxProgressBar = this$0.progressBar;
        if (qFSRectBoxProgressBar != null) {
            qFSRectBoxProgressBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ViewGroup.MarginLayoutParams layoutParams, int i3, ViewGroup it, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(layoutParams, "$layoutParams");
        Intrinsics.checkNotNullParameter(it, "$it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        layoutParams.leftMargin = i3 + ((int) ((Float) animatedValue).floatValue());
        it.setLayoutParams(layoutParams);
    }

    public final void c() {
        QFSRectBoxProgressBar qFSRectBoxProgressBar = this.progressBar;
        if (qFSRectBoxProgressBar != null) {
            qFSRectBoxProgressBar.setVisibility(8);
        }
    }

    public final void d() {
        final ViewGroup viewGroup = this.thumbCoverContainer;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.n
                @Override // java.lang.Runnable
                public final void run() {
                    p.e(p.this);
                }
            }, 250L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.progressBar, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat.setDuration(250L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, cx.a(-8.0f));
            ofFloat2.setDuration(250L);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            final int i3 = marginLayoutParams.leftMargin;
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.o
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    p.f(marginLayoutParams, i3, viewGroup, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat2, ofFloat);
            animatorSet.start();
        }
    }

    public final void g() {
        QFSRectBoxProgressBar qFSRectBoxProgressBar = this.progressBar;
        if (qFSRectBoxProgressBar != null) {
            qFSRectBoxProgressBar.setVisibility(0);
        }
    }

    public final void h() {
        if (this.thumbCoverContainerEndState) {
            return;
        }
        QFSRectBoxProgressBar qFSRectBoxProgressBar = this.progressBar;
        if (qFSRectBoxProgressBar != null) {
            qFSRectBoxProgressBar.setVisibility(8);
        }
        ViewGroup viewGroup = this.thumbCoverContainer;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin += cx.a(-8.0f);
            viewGroup.setLayoutParams(marginLayoutParams);
            this.thumbCoverContainerEndState = true;
        }
    }

    public final void i(int progress) {
        TextView textView = this.progressText;
        if (textView != null) {
            textView.setText(String.valueOf(progress));
        }
        QFSRectBoxProgressBar qFSRectBoxProgressBar = this.progressBar;
        if (qFSRectBoxProgressBar != null) {
            qFSRectBoxProgressBar.setProgress(progress);
        }
    }
}
