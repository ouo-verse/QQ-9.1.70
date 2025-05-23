package com.tencent.ams.fusion.widget.tma;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceBlowLayer extends PathShapeLayer {
    static IPatchRedirector $redirector_ = null;
    private static final int ALPHA_ANIM_DURATION = 400;
    private static final int ARC_RADIUS = 5;
    private static final int INTERVAL_ANIM_DURATION = 560;
    private static final int LINE_ANIM_DURATION = 720;
    private static final int LINE_DISTANCE = 21;
    private static final int MARGIN_LR = 7;
    private static final int MARGIN_TOP = 3;
    private static final int MID_LINE_DISTANCE = 17;
    private boolean drawLineFinish;
    private boolean isClear;
    private Point mArcEndPoint;
    private final Context mContext;
    private int mLeftEndAngel;
    private Point mLeftEndPoint;
    private LinearGradient mLeftLg;
    private RectF mLeftRect;
    private Point mLeftStartPoint;
    private Point mMidEndPoint;
    private LinearGradient mMidLg;
    private Path mMidPath;
    private Point mMidStartPoint;
    private int mRightEndAngel;
    private LinearGradient mRightLg;
    private Path mRightPath;
    private RectF mRightRect;

    public VoiceBlowLayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mLeftEndAngel = 0;
        this.mRightEndAngel = 0;
        this.mContext = context;
    }

    private void changePoint(float f16) {
        Point point;
        Point point2;
        float f17 = f16 / 0.7f;
        int relativeSize375 = (int) (Utils.getRelativeSize375(this.mContext, 21) * f17);
        int relativeSize3752 = (int) (Utils.getRelativeSize375(this.mContext, 17) * f17);
        if (f17 >= 1.0f) {
            float f18 = (f17 - 1.0f) / 0.3f;
            if (this.mRightEndAngel < 270 && f18 < 1.0f) {
                int i3 = (int) (f18 * 270.0f);
                this.mRightEndAngel = i3;
                this.mLeftEndAngel = -i3;
                return;
            }
            return;
        }
        Point point3 = this.mLeftEndPoint;
        if (point3 != null && (point2 = this.mLeftStartPoint) != null) {
            point3.y = point2.y - relativeSize375;
        }
        Point point4 = this.mMidEndPoint;
        if (point4 != null && (point = this.mMidStartPoint) != null) {
            point4.y = point.y - relativeSize3752;
        }
    }

    private Animator createAlphaAnimatorStep2() {
        AlphaAnimator alphaAnimator = new AlphaAnimator(this, 1.0f, 0.0f);
        alphaAnimator.setDuration(400L);
        alphaAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        return alphaAnimator;
    }

    private Animator createBlowCloudAnimator() {
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this, createDrawLineAnimatorStep1(), createAlphaAnimatorStep2(), createKeepAnimatorStep3());
        sequentialAnimator.setRepeatCount(0);
        sequentialAnimator.setRepeatMode(1);
        return sequentialAnimator;
    }

    private Animator createDrawLineAnimatorStep1() {
        ProgressAnimator progressAnimator = new ProgressAnimator(this, 0.0f, 1.0f);
        progressAnimator.setDuration(720L);
        progressAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        return progressAnimator;
    }

    private Animator createKeepAnimatorStep3() {
        KeepAnimator keepAnimator = new KeepAnimator(this);
        keepAnimator.setDuration(560L);
        return keepAnimator;
    }

    private void resetPath() {
        Point point;
        Point point2;
        this.mAlpha = 255;
        this.mPaint.setAlpha(255);
        Point point3 = this.mLeftEndPoint;
        if (point3 != null && (point2 = this.mLeftStartPoint) != null) {
            point3.set(point2.x, point2.y);
        }
        Point point4 = this.mMidEndPoint;
        if (point4 != null && (point = this.mMidStartPoint) != null) {
            point4.set(point.x, point.y);
        }
        this.drawLineFinish = false;
        Path path = this.mPath;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.mMidPath;
        if (path2 != null) {
            path2.reset();
        }
        Path path3 = this.mRightPath;
        if (path3 != null) {
            path3.reset();
        }
        this.mRightEndAngel = 0;
        this.mLeftEndAngel = 0;
    }

    private void setPaint(Paint paint, LinearGradient linearGradient) {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(8.0f);
        paint.setShader(linearGradient);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.isClear = true;
            super.clear();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        Point point;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Path path = this.mPath;
        if (path != null && this.mMidPath != null && this.mRightPath != null && this.mLeftEndPoint != null && (point = this.mLeftStartPoint) != null && this.mMidStartPoint != null && this.mMidEndPoint != null && !this.isClear) {
            path.moveTo(point.x, point.y);
            Path path2 = this.mPath;
            Point point2 = this.mLeftEndPoint;
            path2.lineTo(point2.x, point2.y);
            this.mPaint.setShader(this.mLeftLg);
            this.mPath.addArc(this.mLeftRect, 0.0f, this.mLeftEndAngel);
            canvas.drawPath(this.mPath, this.mPaint);
            Path path3 = this.mMidPath;
            Point point3 = this.mMidStartPoint;
            path3.moveTo(point3.x, point3.y);
            Path path4 = this.mMidPath;
            Point point4 = this.mMidEndPoint;
            path4.lineTo(point4.x, point4.y);
            this.mPaint.setShader(this.mMidLg);
            canvas.drawPath(this.mMidPath, this.mPaint);
            this.mRightPath.moveTo(this.mLeftStartPoint.x + (Utils.getRelativeSize375(this.mContext, 7) * 2), this.mLeftStartPoint.y + Utils.getRelativeSize375(this.mContext, 3));
            this.mRightPath.lineTo(this.mLeftEndPoint.x + (Utils.getRelativeSize375(this.mContext, 7) * 2), this.mLeftEndPoint.y + Utils.getRelativeSize375(this.mContext, 3));
            this.mRightPath.addArc(this.mRightRect, 180.0f, this.mRightEndAngel);
            this.mPaint.setShader(this.mRightLg);
            canvas.drawPath(this.mRightPath, this.mPaint);
            this.mPaint.setShader(this.mLeftLg);
        }
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mPath = new Path();
        this.mRightPath = new Path();
        this.mMidPath = new Path();
        if (this.mLeftStartPoint == null) {
            Point point = new Point();
            this.mLeftStartPoint = point;
            point.set((getWidth() / 2) - Utils.getRelativeSize375(this.mContext, 7), (int) getY());
        }
        if (this.mLeftEndPoint == null) {
            Point point2 = new Point();
            this.mLeftEndPoint = point2;
            Point point3 = this.mLeftStartPoint;
            point2.set(point3.x, point3.y);
        }
        if (this.mArcEndPoint == null) {
            Point point4 = new Point();
            this.mArcEndPoint = point4;
            Point point5 = this.mLeftStartPoint;
            point4.set(point5.x, point5.y - Utils.getRelativeSize375(this.mContext, 21));
        }
        if (this.mMidStartPoint == null) {
            this.mMidStartPoint = new Point(this.mLeftStartPoint.x + Utils.getRelativeSize375(this.mContext, 7), this.mLeftStartPoint.y - 5);
        }
        if (this.mMidEndPoint == null) {
            Point point6 = this.mMidStartPoint;
            this.mMidEndPoint = new Point(point6.x, point6.y);
        }
        if (this.mRightRect == null) {
            int relativeSize375 = Utils.getRelativeSize375(this.mContext, 5) * 2;
            this.mRightRect = new RectF(this.mArcEndPoint.x + (Utils.getRelativeSize375(this.mContext, 7) * 2), (this.mArcEndPoint.y - r1) + Utils.getRelativeSize375(this.mContext, 3), this.mArcEndPoint.x + (Utils.getRelativeSize375(this.mContext, 7) * 2) + relativeSize375, this.mArcEndPoint.y + r1 + Utils.getRelativeSize375(this.mContext, 3));
            Point point7 = this.mArcEndPoint;
            int i3 = point7.x;
            int i16 = point7.y;
            this.mLeftRect = new RectF(i3 - relativeSize375, i16 - r1, i3, i16 + r1);
        }
        if (this.mLeftLg == null) {
            Point point8 = this.mLeftStartPoint;
            float f16 = point8.x;
            float f17 = point8.y;
            Point point9 = this.mArcEndPoint;
            this.mLeftLg = new LinearGradient(f16, f17, point9.x, point9.y + 5, 0, -1, Shader.TileMode.CLAMP);
            Point point10 = this.mMidEndPoint;
            int i17 = point10.x;
            this.mMidLg = new LinearGradient(i17, point10.y, i17, r6 - Utils.getRelativeSize375(this.mContext, 17), 0, -1, Shader.TileMode.CLAMP);
            this.mRightLg = new LinearGradient(this.mLeftStartPoint.x + (Utils.getRelativeSize375(this.mContext, 7) * 2), this.mLeftStartPoint.y + Utils.getRelativeSize375(this.mContext, 3), this.mArcEndPoint.x + (Utils.getRelativeSize375(this.mContext, 7) * 2), this.mArcEndPoint.y + 5 + Utils.getRelativeSize375(this.mContext, 3), 0, -1, Shader.TileMode.CLAMP);
        }
        setPaint(this.mPaint, this.mLeftLg);
        setAnimator(createBlowCloudAnimator());
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        super.postProgress(f16);
        if (f16 >= 1.0f) {
            this.drawLineFinish = true;
            return;
        }
        if (this.drawLineFinish) {
            resetPath();
        }
        changePoint(f16);
    }
}
