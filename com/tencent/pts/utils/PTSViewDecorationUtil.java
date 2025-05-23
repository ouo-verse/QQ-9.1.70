package com.tencent.pts.utils;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.PTSNodeStyleConstant;

/* loaded from: classes22.dex */
public final class PTSViewDecorationUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSViewDecorationUtil";
    private static RectF oval;

    /* loaded from: classes22.dex */
    public static final class RoundedCorner {
        static IPatchRedirector $redirector_;
        private Paint borderPaint;
        private float[] borderRadii;
        private float borderWidth;
        private boolean hasSetOutline;
        private Paint paint;
        private Path path;
        private float[] radii;
        private RectF rectF;
        private View view;
        private Xfermode xfermode;

        public RoundedCorner(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.radii = new float[8];
            this.borderWidth = 0.0f;
            this.borderRadii = new float[4];
            this.hasSetOutline = false;
            this.view = view;
            init();
        }

        private boolean hasRoundedCorner() {
            for (float f16 : this.radii) {
                if (f16 > 0.0f) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasSameCorner() {
            float[] fArr = this.radii;
            float f16 = fArr[0];
            for (float f17 : fArr) {
                if (Float.compare(f17, f16) != 0) {
                    return false;
                }
            }
            return true;
        }

        private void init() {
            this.path = new Path();
            this.rectF = new RectF();
            this.paint = new Paint(5);
            this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
            Paint paint = new Paint(1);
            this.borderPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
        }

        private boolean shouldClipPath() {
            if (hasRoundedCorner() && !this.hasSetOutline && Build.VERSION.SDK_INT >= 28) {
                return true;
            }
            return false;
        }

        public void clipPath(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
                return;
            }
            if (shouldClipPath()) {
                this.path.reset();
                View view = this.view;
                this.rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
                this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
                canvas.clipPath(this.path);
            }
        }

        public void drawBorder(Canvas canvas) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
                return;
            }
            if (this.borderWidth > 0.0f && canvas != null && (view = this.view) != null) {
                int width = view.getWidth();
                int height = this.view.getHeight();
                Paint paint = this.borderPaint;
                float f16 = this.borderWidth;
                float[] fArr = this.borderRadii;
                PTSViewDecorationUtil.drawBorderImp(canvas, paint, width, height, f16, fArr[0], fArr[1], fArr[2], fArr[3]);
            }
        }

        public void drawCorner(Canvas canvas, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas, i3);
                return;
            }
            if (hasRoundedCorner() && !this.hasSetOutline && !shouldClipPath()) {
                this.path.reset();
                View view = this.view;
                this.rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
                this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
                this.paint.setXfermode(this.xfermode);
                canvas.drawPath(this.path, this.paint);
                this.paint.setXfermode(null);
                canvas.restoreToCount(i3);
            }
        }

        public int getSaveCount(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas)).intValue();
            }
            if (hasRoundedCorner() && !this.hasSetOutline && !shouldClipPath()) {
                return canvas.saveLayer(null, null, 31);
            }
            return -1;
        }

        public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSNodeInfo);
                return;
            }
            if (pTSNodeInfo == null) {
                return;
            }
            PTSNodeStyle style = pTSNodeInfo.getStyle();
            this.borderRadii = style.getBorderRadii();
            for (int i3 = 0; i3 < 4; i3++) {
                float[] fArr = this.radii;
                int i16 = i3 * 2;
                float[] fArr2 = this.borderRadii;
                fArr[i16] = fArr2[i3];
                fArr[i16 + 1] = fArr2[i3];
            }
            View view = this.view;
            if (hasRoundedCorner() && hasSameCorner()) {
                view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoundedCorner.this);
                        }
                    }

                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view2, Outline outline) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, (Object) outline);
                        } else {
                            outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), RoundedCorner.this.radii[0]);
                        }
                    }
                });
                view.setClipToOutline(true);
                this.hasSetOutline = true;
            }
            this.borderWidth = style.getBorderWidth();
            String string = PTSValueConvertUtil.getString(style.get(PTSNodeStyleConstant.BORDER_COLOR));
            float f16 = this.borderWidth;
            if (f16 > 0.0f) {
                this.borderPaint.setStrokeWidth(PTSDeviceUtil.dp2px(f16));
                this.borderPaint.setColor(PTSValueConvertUtil.getColor(string));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            oval = new RectF();
        }
    }

    PTSViewDecorationUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void drawBorderImp(Canvas canvas, Paint paint, int i3, int i16, float f16, float f17, float f18, float f19, float f26) {
        float f27;
        float f28;
        float f29;
        float f36;
        float f37;
        float f38;
        if (canvas != null && paint != null) {
            float max = Math.max(0.0f, f16);
            float max2 = Math.max(0.0f, f17);
            float max3 = Math.max(0.0f, f18);
            float max4 = Math.max(0.0f, f19);
            float max5 = Math.max(0.0f, f26);
            float f39 = max / 2.0f;
            if (max2 > 0.0f) {
                f27 = max2 + f39;
            } else {
                f27 = 0.0f;
            }
            float f46 = i16;
            if (max5 > 0.0f) {
                f46 = (f46 - max5) - f39;
            }
            canvas.drawLine(f39, Math.max(0.0f, f27), f39, Math.max(0.0f, f46), paint);
            if (max2 > 0.0f) {
                f28 = max2 + f39;
            } else {
                f28 = max;
            }
            float f47 = i3;
            if (max3 > 0.0f) {
                f29 = (f47 - max3) - f39;
            } else {
                f29 = f47 - max;
            }
            canvas.drawLine(Math.max(0.0f, f28), f39, Math.max(0.0f, f29), f39, paint);
            if (max3 > 0.0f) {
                f36 = max3 + f39;
            } else {
                f36 = 0.0f;
            }
            float f48 = i16;
            if (max4 > 0.0f) {
                f48 = (f48 - max4) - f39;
            }
            float f49 = i3;
            float f56 = f49 - f39;
            canvas.drawLine(f56, Math.max(0.0f, f36), f56, Math.max(0.0f, f48), paint);
            if (max5 > 0.0f) {
                f37 = max5 + f39;
            } else {
                f37 = max;
            }
            if (max4 > 0.0f) {
                f38 = (f49 - max4) - f39;
            } else {
                f38 = f49 - max;
            }
            float f57 = i16;
            float f58 = f57 - f39;
            canvas.drawLine(Math.max(0.0f, f37), f58, Math.max(0.0f, f38), f58, paint);
            if (max2 > 0.0f) {
                float f59 = max2 * 2.0f;
                oval.set(0.0f, 0.0f, f59, f59);
                oval.offset(f39, f39);
                canvas.drawArc(oval, 180.0f, 90.0f, false, paint);
            }
            if (max3 > 0.0f) {
                float f65 = max3 * 2.0f;
                oval.set(f49 - f65, 0.0f, f49, f65);
                oval.offset(-f39, f39);
                canvas.drawArc(oval, 270.0f, 90.0f, false, paint);
            }
            if (max4 > 0.0f) {
                float f66 = max4 * 2.0f;
                oval.set(f49 - f66, f57 - f66, f49, f57);
                float f67 = -f39;
                oval.offset(f67, f67);
                canvas.drawArc(oval, 0.0f, 90.0f, false, paint);
            }
            if (max5 > 0.0f) {
                float f68 = max5 * 2.0f;
                oval.set(0.0f, f57 - f68, f68, f57);
                oval.offset(f39, -f39);
                canvas.drawArc(oval, 90.0f, 90.0f, false, paint);
            }
        }
    }
}
