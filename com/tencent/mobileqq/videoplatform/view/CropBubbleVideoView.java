package com.tencent.mobileqq.videoplatform.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CropBubbleVideoView extends BaseVideoView {
    static IPatchRedirector $redirector_ = null;
    private static final float[] DEFAULT_EDGE_CORDS;
    private static final String TAG = "CropBubbleVideoView";

    /* renamed from: ax, reason: collision with root package name */
    private static final float f312681ax;

    /* renamed from: ay, reason: collision with root package name */
    private static final float f312682ay;

    /* renamed from: bx, reason: collision with root package name */
    private static final float f312683bx;
    private static final float by;

    /* renamed from: cx, reason: collision with root package name */
    private static final float f312684cx;

    /* renamed from: cy, reason: collision with root package name */
    private static final float f312685cy;

    /* renamed from: mx, reason: collision with root package name */
    private static final float f312686mx;

    /* renamed from: my, reason: collision with root package name */
    private static final float f312687my;

    /* renamed from: nx, reason: collision with root package name */
    private static final float f312688nx;

    /* renamed from: ny, reason: collision with root package name */
    private static final float f312689ny;
    private Path mCropPath;
    private boolean mDrawTri;
    public boolean mIsSend;
    private float mRectRadius;
    public float triWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15851);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        float[] fArr = {7.0f, 9.0f, 0.0f, 6.0f, 2.5f, 9.0f, 5.5f, 15.0f, 0.5f, 13.0f};
        DEFAULT_EDGE_CORDS = fArr;
        f312681ax = fArr[0];
        f312682ay = fArr[1];
        f312683bx = fArr[2];
        by = fArr[3];
        f312686mx = fArr[4];
        f312687my = fArr[5];
        f312684cx = fArr[6];
        f312685cy = fArr[7];
        f312688nx = fArr[8];
        f312689ny = fArr[9];
    }

    public CropBubbleVideoView(Context context, long j3, VideoPlayParam videoPlayParam, boolean z16) {
        super(context, j3, videoPlayParam, null, null, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3), videoPlayParam, Boolean.valueOf(z16));
            return;
        }
        this.triWidth = Math.abs(f312683bx - f312684cx);
        this.mRectRadius = 15.0f;
        this.mDrawTri = true;
        this.mIsSend = z16;
    }

    private void buildCropShape(boolean z16, int i3, int i16, Resources resources, float f16) {
        Path path = this.mCropPath;
        if (path != null) {
            path.reset();
        } else {
            this.mCropPath = new Path();
        }
        RectF rectF = new RectF();
        float dp2px = dp2px(this.triWidth, resources);
        if (this.mDrawTri) {
            if (z16) {
                rectF.set(0.0f, 0.0f, i3 - dp2px, i16);
            } else {
                rectF.set(dp2px, 0.0f, i3, i16);
            }
        } else {
            rectF.set(0.0f, 0.0f, i3, i16);
        }
        float dp2px2 = dp2px(by, resources);
        float[] fArr = new float[8];
        Arrays.fill(fArr, dp2px(f16, resources));
        if (z16) {
            this.mCropPath.addRoundRect(rectF, fArr, Path.Direction.CW);
            if (this.mDrawTri) {
                this.mCropPath.moveTo(i3 - dp2px(f312681ax, resources), dp2px(f312682ay, resources));
                this.mCropPath.quadTo(i3 - dp2px(f312686mx, resources), dp2px(f312687my, resources), i3 - dp2px(f312683bx, resources), dp2px2);
                this.mCropPath.quadTo(i3 - dp2px(f312688nx, resources), dp2px(f312689ny, resources), i3 - dp2px(f312684cx, resources), dp2px(f312685cy, resources));
            }
        } else {
            this.mCropPath.addRoundRect(rectF, fArr, Path.Direction.CCW);
            if (this.mDrawTri) {
                this.mCropPath.moveTo(dp2px(f312681ax, resources), dp2px(f312682ay, resources));
                this.mCropPath.quadTo(dp2px(f312686mx, resources), dp2px(f312687my, resources), f312683bx, dp2px2);
                this.mCropPath.quadTo(dp2px(f312688nx, resources), dp2px(f312689ny, resources), dp2px(f312684cx, resources), dp2px(f312685cy, resources));
            }
        }
        this.mCropPath.close();
    }

    public static int dp2px(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        buildCropShape(this.mIsSend, getWidth(), getHeight(), this.mContext.getResources(), this.mRectRadius);
        Path path = this.mCropPath;
        if (path != null) {
            canvas.clipPath(path);
        }
        super.dispatchDraw(canvas);
    }

    public float getTriaWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.triWidth;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onAttachedToWindow();
            setLayerType(2, null);
        }
    }

    public void setDrawTri(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mDrawTri = z16;
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mRectRadius = f16;
        }
    }
}
