package com.tencent.state;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0016\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J(\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/SquareViewAnimator;", "Lcom/tencent/state/ISquareAnimator;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "animationSet", "Landroid/view/animation/AnimationSet;", "pivotX", "", "pivotY", c.f123400v, "duration", "", "listener", "Lcom/tencent/state/AnimListener;", "pivot", "scale", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "fromScaleX", "fromScaleY", "setUpdateListener", "update", "Lkotlin/Function0;", "", "start", CanvasView.ACTION_TRANSLATE, "translateX", "", "translateY", "fromXDelta", "toXDelta", "fromYDelta", "toYDelta", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquareViewAnimator implements ISquareAnimator {
    private final AnimationSet animationSet;
    private float pivotX;
    private float pivotY;
    private final View view;

    public SquareViewAnimator(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new LinearInterpolator());
        Unit unit = Unit.INSTANCE;
        this.animationSet = animationSet;
        this.pivotX = view.getPivotX();
        this.pivotY = view.getPivotY();
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator alpha(float alpha) {
        this.animationSet.addAnimation(new AlphaAnimation(this.view.getAlpha(), alpha));
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator duration(long duration) {
        this.animationSet.setDuration(duration);
        this.animationSet.setFillAfter(true);
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator listener(AnimListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.animationSet.setAnimationListener(listener);
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator pivot(float pivotX, float pivotY) {
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator scale(float scaleX, float scaleY, float fromScaleX, float fromScaleY) {
        this.animationSet.addAnimation(new ScaleAnimation(fromScaleX, scaleX, fromScaleY, scaleY, 0, this.pivotX, 0, this.pivotY));
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator setUpdateListener(Function0<Unit> update) {
        Intrinsics.checkNotNullParameter(update, "update");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.state.ISquareAnimator
    public void start() {
        this.view.startAnimation(this.animationSet);
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator translate(int translateX, int translateY) {
        this.animationSet.addAnimation(new TranslateAnimation(this.view.getTranslationX(), translateX, this.view.getTranslationY(), translateY));
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator translate(int fromXDelta, int toXDelta, int fromYDelta, int toYDelta) {
        this.animationSet.addAnimation(new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta));
        return this;
    }
}
