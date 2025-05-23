package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPreviewView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0013B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u001c\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPreviewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "C0", "A0", "D0", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "d", "Landroid/animation/ValueAnimator;", "alphaAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverPreviewView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ValueAnimator alphaAnim;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverPreviewView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setAlpha(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: k40.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSPersonalCoverPreviewView.B0(QFSPersonalCoverPreviewView.this, valueAnimator);
            }
        });
        this.alphaAnim = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(QFSPersonalCoverPreviewView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
    }

    private final void C0() {
        if (this.alphaAnim.isRunning()) {
            this.alphaAnim.end();
        }
    }

    public void A0() {
        C0();
        this.alphaAnim.start();
    }

    public void D0() {
        C0();
        this.alphaAnim.reverse();
    }
}
