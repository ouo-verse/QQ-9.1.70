package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {

    @Nullable
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createPath() {
        boolean z16;
        T t16;
        T t17;
        T t18 = this.endValue;
        if (t18 != 0 && (t17 = this.startValue) != 0 && ((PointF) t17).equals(((PointF) t18).x, ((PointF) t18).y)) {
            z16 = true;
        } else {
            z16 = false;
        }
        T t19 = this.startValue;
        if (t19 != 0 && (t16 = this.endValue) != 0 && !z16) {
            Keyframe<PointF> keyframe = this.pointKeyFrame;
            this.path = Utils.createPath((PointF) t19, (PointF) t16, keyframe.pathCp1, keyframe.pathCp2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path getPath() {
        return this.path;
    }
}
