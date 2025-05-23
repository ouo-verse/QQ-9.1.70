package com.tencent.state;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H&J,\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u0016\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H&J(\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/ISquareAnimator;", "", c.f123400v, "", "duration", "", "listener", "Lcom/tencent/state/AnimListener;", "pivot", "pivotX", "pivotY", "scale", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "fromScaleX", "fromScaleY", "setUpdateListener", "update", "Lkotlin/Function0;", "", "start", CanvasView.ACTION_TRANSLATE, "translateX", "", "translateY", "fromXDelta", "toXDelta", "fromYDelta", "toYDelta", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface ISquareAnimator {
    ISquareAnimator alpha(float alpha);

    ISquareAnimator duration(long duration);

    ISquareAnimator listener(AnimListener listener);

    ISquareAnimator pivot(float pivotX, float pivotY);

    ISquareAnimator scale(float scaleX, float scaleY, float fromScaleX, float fromScaleY);

    ISquareAnimator setUpdateListener(Function0<Unit> update);

    void start();

    ISquareAnimator translate(int translateX, int translateY);

    ISquareAnimator translate(int fromXDelta, int toXDelta, int fromYDelta, int toYDelta);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ISquareAnimator scale$default(ISquareAnimator iSquareAnimator, float f16, float f17, float f18, float f19, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f18 = -1.0f;
                }
                if ((i3 & 8) != 0) {
                    f19 = -1.0f;
                }
                return iSquareAnimator.scale(f16, f17, f18, f19);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
        }
    }
}
