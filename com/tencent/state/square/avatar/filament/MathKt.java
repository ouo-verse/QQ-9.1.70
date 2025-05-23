package com.tencent.state.square.avatar.filament;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u001a\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b\u00a8\u0006\u0014"}, d2 = {"composeMatrix", "Lcom/tencent/state/square/avatar/filament/Mat44F;", "translation", "Lcom/tencent/state/square/avatar/filament/Vec3F;", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/state/square/avatar/filament/QuatF;", "scale", "convertFovFromVerticalToHorizontal", "", "fovInDegree", "width", "height", "convertUE4MatToLightSDK", "ue4Mat", "eulerZYXToQuaternion", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, "toRadius", "degrees", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MathKt {
    public static final Mat44F composeMatrix(Vec3F translation, QuatF rotation, Vec3F scale) {
        Intrinsics.checkNotNullParameter(translation, "translation");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(scale, "scale");
        float x16 = translation.getX();
        float y16 = translation.getY();
        float z16 = translation.getZ();
        float x17 = rotation.getX();
        float y17 = rotation.getY();
        float z17 = rotation.getZ();
        float w3 = rotation.getW();
        float x18 = scale.getX();
        float y18 = scale.getY();
        float z18 = scale.getZ();
        float f16 = 1;
        float f17 = 2;
        float f18 = f17 * y17;
        float f19 = f18 * y17;
        float f26 = f17 * z17;
        float f27 = f26 * z17;
        float f28 = f17 * x17;
        float f29 = y17 * f28;
        float f36 = f26 * w3;
        float f37 = f28 * z17;
        float f38 = f18 * w3;
        float f39 = (f29 - f36) * x18;
        float f46 = f16 - (x17 * f28);
        float f47 = f18 * z17;
        float f48 = f28 * w3;
        return new Mat44F(((f16 - f19) - f27) * x18, (f29 + f36) * y18, (f37 - f38) * z18, 0.0f, f39, (f46 - f27) * y18, (f47 + f48) * z18, 0.0f, x18 * (f37 + f38), y18 * (f47 - f48), (f46 - f19) * z18, 0.0f, x16, y16, z16, 1.0f);
    }

    public static final float toRadius(float f16) {
        return (float) ((f16 * 3.141592653589793d) / 180.0f);
    }

    public static final Mat44F convertUE4MatToLightSDK(Mat44F ue4Mat) {
        Intrinsics.checkNotNullParameter(ue4Mat, "ue4Mat");
        Mat44F times = Mat44F.INSTANCE.scaling(100.0f).times(new Mat44F(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f));
        return times.inverse().times(ue4Mat).times(times);
    }

    public static final QuatF eulerZYXToQuaternion(float f16, float f17, float f18) {
        double d16 = f16 / 2.0f;
        float sin = (float) Math.sin(d16);
        float cos = (float) Math.cos(d16);
        double d17 = f17 / 2.0f;
        float sin2 = (float) Math.sin(d17);
        float cos2 = (float) Math.cos(d17);
        double d18 = f18 / 2.0f;
        float sin3 = (float) Math.sin(d18);
        float cos3 = (float) Math.cos(d18);
        float f19 = cos * cos2;
        return new QuatF(((-sin) * sin2 * cos3) + (f19 * sin3), (sin * sin3 * cos2) + (sin2 * cos * cos3), ((sin * cos2) * cos3) - ((sin2 * sin3) * cos), (sin * sin2 * sin3) + (f19 * cos3));
    }

    public static final float convertFovFromVerticalToHorizontal(float f16, float f17, float f18) {
        double d16 = f17 / f18;
        double d17 = 180.0f;
        return (float) (((2.0f * Math.atan((Math.tan(((f16 / 2.0f) * 3.141592653589793d) / d17) * d16) / d16)) * d17) / 3.141592653589793d);
    }
}
