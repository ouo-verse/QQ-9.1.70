package com.tencent.ams.fusion.widget.twist;

import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RingShapeLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwistAnimatorViewHelper {
    static IPatchRedirector $redirector_ = null;
    private static final float TRIANGLE_RADIUS_DP = 2.0f;

    public TwistAnimatorViewHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static RingShapeLayer createRingBgLayer(float f16, float f17, float f18, float f19) {
        RingShapeLayer strokeCap = new RingShapeLayer(f17, f18, f16, -1, f19).setStrokeCap(Paint.Cap.BUTT);
        strokeCap.postAlpha(153);
        strokeCap.setStartAngle(-45.0f);
        strokeCap.setSweepAngle(-90.0f);
        strokeCap.postProgress(100.0f);
        strokeCap.setAnimator(new KeepAnimator(strokeCap));
        return strokeCap;
    }

    public static RingShapeLayer createRingProgressLayer(float f16, int i3, float f17, float f18, float f19) {
        float f26;
        float f27 = 90.0f;
        if (i3 == 0) {
            f26 = -135.0f;
        } else if (i3 == 2) {
            f26 = -90.0f;
        } else {
            f26 = -45.0f;
            f27 = -90.0f;
        }
        RingShapeLayer strokeCap = new RingShapeLayer(f17, f18, f16, -1, f19).setStrokeCap(Paint.Cap.ROUND);
        strokeCap.setStartAngle(f26);
        strokeCap.setSweepAngle(f27);
        strokeCap.setAnimator(new ProgressAnimator(strokeCap, 0.0f, 0.0f));
        return strokeCap;
    }

    public static PathShapeLayer createTriangleLayer(int i3, float f16, float f17, float f18, float f19) {
        Path path = new Path();
        float radians = (float) Math.toRadians(-135.0d);
        if (i3 == 0) {
            radians = (float) Math.toRadians(-45.0d);
        }
        double d16 = f17;
        float f26 = f19 / 2.0f;
        double d17 = f16 - f26;
        double d18 = radians;
        float cos = (float) ((Math.cos(d18) * d17) + d16);
        double d19 = f18;
        float sin = (float) ((d17 * Math.sin(d18)) + d19);
        double d26 = f16 + f26;
        float cos2 = (float) (d16 + (Math.cos(d18) * d26));
        float sin2 = (float) (d19 + (d26 * Math.sin(d18)));
        path.moveTo(cos, sin);
        path.lineTo(cos2, sin2);
        path.lineTo(cos2, sin);
        path.close();
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, null, Paint.Style.FILL);
        pathShapeLayer.setColor(-1);
        pathShapeLayer.postAlpha(153);
        pathShapeLayer.setPathEffect(new CornerPathEffect(Utils.dp2px(2.0f)));
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }
}
