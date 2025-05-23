package com.tencent.ams.fusion.widget.flipcard;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationYAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.ig.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardBackLayer extends PathShapeLayer {
    static IPatchRedirector $redirector_ = null;
    private static final float RADIUS;
    private static final String TAG = "FlipCardBackLayer";
    private final float mFinalHeight;
    private final float mFinalWidth;
    private final float mInitialHeight;
    private final float mInitialWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            RADIUS = Utils.dp2px(20.0f);
        }
    }

    public FlipCardBackLayer(Context context, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        setWidth(i3);
        setHeight(i16);
        this.mInitialWidth = Utils.getRelativeSize375(context, 327);
        this.mInitialHeight = Utils.getRelativeSize375(context, 130);
        this.mFinalWidth = Utils.getRelativeSize375(context, FilterEnum.MIC_PTU_TRANS_XINXIAN);
        this.mFinalHeight = Utils.getRelativeSize375(context, l.CTRL_INDEX);
        setPath(createPath(1.0f, 1.0f));
        setColor(16777215);
        setAnimator(new KeepAnimator(this));
        setCenterX(i3 / 2.0f);
        setCenterY(i16 / 2.0f);
    }

    private Path createPath(float f16, float f17) {
        new Path();
        return createPathWithSize(this.mInitialWidth * f16, this.mInitialHeight * f17);
    }

    private Path createPathWithSize(float f16, float f17) {
        Path path = new Path();
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float f18 = f16 / 2.0f;
        float f19 = f17 / 2.0f;
        RectF rectF = new RectF(width - f18, height - f19, width + f18, height + f19);
        float f26 = RADIUS;
        path.addRoundRect(rectF, new float[]{f26, f26, f26, f26, f26, f26, f26, f26}, Path.Direction.CW);
        path.close();
        return path;
    }

    public Animator createFlipAnimator(boolean z16) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Animator) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        ScaleAnimator scaleAnimator = new ScaleAnimator(this, 1.0f, this.mFinalWidth / this.mInitialWidth, 1.0f, this.mFinalHeight / this.mInitialHeight);
        scaleAnimator.setDuration(400L);
        RotationYAnimator rotationYAnimator = new RotationYAnimator(this);
        if (z16) {
            f16 = 90.0f;
        } else {
            f16 = -90.0f;
        }
        rotationYAnimator.setRotationDegrees(f16, 0.0f);
        rotationYAnimator.setLocation(0.0f, 0.0f, -25.0f);
        rotationYAnimator.setDuration(400L);
        GroupAnimator groupAnimator = new GroupAnimator(this, scaleAnimator, rotationYAnimator);
        groupAnimator.setDuration(400L);
        groupAnimator.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        return groupAnimator;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            setPath(createPath(f16, f17));
            super.postScale(f16, f17);
        }
    }
}
