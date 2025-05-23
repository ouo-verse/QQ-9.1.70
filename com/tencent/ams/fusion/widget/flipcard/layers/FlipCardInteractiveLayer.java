package com.tencent.ams.fusion.widget.flipcard.layers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.CircleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardAnimationHelper;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardInteractiveLayer extends GroupLayer {
    static IPatchRedirector $redirector_;

    public FlipCardInteractiveLayer(Context context, float f16, float f17, int i3, int i16, FlipCardInfo flipCardInfo) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), flipCardInfo);
            return;
        }
        setX(f16);
        setY(f17);
        setWidth(i3);
        setHeight(i16);
        addLayer(createBackgroundLayer(flipCardInfo));
        addLayer(createProgressLayer(f16, f17));
        addLayer(createIconLayer(context, flipCardInfo));
    }

    private AnimatorLayer createBackgroundLayer(FlipCardInfo flipCardInfo) {
        float width = getWidth() / 2.0f;
        CircleShapeLayer circleShapeLayer = new CircleShapeLayer(getX() + width, getY() + width, width, 1459617792);
        circleShapeLayer.setAnimator(new KeepAnimator(circleShapeLayer));
        return circleShapeLayer;
    }

    private AnimatorLayer createIconLayer(Context context, FlipCardInfo flipCardInfo) {
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
        int relativeSize375 = Utils.getRelativeSize375(context, 9);
        int i3 = relativeSize375 * 2;
        int width = getWidth() - i3;
        int height = getHeight() - i3;
        boolean isFlipMode = FlipCardAnimationHelper.isFlipMode(flipCardInfo);
        String str = FlipCardAnimationHelper.INTERACTIVE_ROTATION;
        if (!isFlipMode) {
            if (FlipCardAnimationHelper.isSlideMode(flipCardInfo)) {
                str = FlipCardAnimationHelper.INTERACTIVE_SLIDE;
            } else if (FlipCardAnimationHelper.isClickMode(flipCardInfo)) {
                str = FlipCardAnimationHelper.INTERACTIVE_CLICK;
            }
        }
        flipCardBitmapLayer.setBitmap(Utils.bitmapFromBase64StringSafe(str, width, height));
        flipCardBitmapLayer.setWidth(width);
        flipCardBitmapLayer.setHeight(height);
        float f16 = relativeSize375;
        flipCardBitmapLayer.setX(f16);
        flipCardBitmapLayer.setY(f16);
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private Path createMaskPath() {
        float width = getWidth() / 2.0f;
        float x16 = getX() + width;
        float y16 = getY() + width;
        Path path = new Path();
        path.addCircle(x16, y16, width, Path.Direction.CW);
        path.close();
        return path;
    }

    private AnimatorLayer createProgressLayer(float f16, float f17) {
        Path path = new Path();
        int width = getWidth();
        int height = getHeight();
        path.addRect(new RectF(0.0f, 0.0f, 0.0f, height), Path.Direction.CW);
        path.close();
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, f16, f17, width, height, new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{1308622847, 452984831}, (float[]) null, Shader.TileMode.MIRROR), new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{452984831, 1308622847}, (float[]) null, Shader.TileMode.MIRROR), createMaskPath()) { // from class: com.tencent.ams.fusion.widget.flipcard.layers.FlipCardInteractiveLayer.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LinearGradient val$gradientLeft;
            final /* synthetic */ LinearGradient val$gradientRight;
            final /* synthetic */ int val$height;
            final /* synthetic */ Path val$maskPath;
            final /* synthetic */ int val$width;
            final /* synthetic */ float val$x;
            final /* synthetic */ float val$y;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(path);
                this.val$x = f16;
                this.val$y = f17;
                this.val$width = width;
                this.val$height = height;
                this.val$gradientLeft = r11;
                this.val$gradientRight = r12;
                this.val$maskPath = r13;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FlipCardInteractiveLayer.this, path, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(width), Integer.valueOf(height), r11, r12, r13);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer
            public void drawPath(Canvas canvas) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
                    return;
                }
                canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
                canvas.clipPath(this.val$maskPath, Region.Op.INTERSECT);
                super.drawPath(canvas);
                canvas.restore();
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
            public void postProgress(float f18) {
                RectF rectF;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Float.valueOf(f18));
                    return;
                }
                Path path2 = this.mPath;
                if (path2 != null) {
                    path2.rewind();
                    if (f18 > 0.0f) {
                        float f19 = this.val$x;
                        rectF = new RectF(f19, this.val$y, Math.abs(this.val$width * f18) + f19, this.val$y + this.val$height);
                        setShader(this.val$gradientLeft);
                    } else {
                        float abs = this.val$x + (this.val$width * (1.0f - Math.abs(f18)));
                        float f26 = this.val$y;
                        rectF = new RectF(abs, f26, this.val$x + this.val$width, this.val$height + f26);
                        setShader(this.val$gradientRight);
                    }
                    path2.addRect(rectF, Path.Direction.CW);
                    path2.close();
                }
            }
        };
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }
}
