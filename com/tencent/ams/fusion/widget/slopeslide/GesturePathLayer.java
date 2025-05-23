package com.tencent.ams.fusion.widget.slopeslide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class GesturePathLayer extends PathShapeLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GesturePathLayer";
    private boolean mCheckGestureMatchWhenTouchDown;
    private final Context mContext;
    private float mDownX;
    private float mDownY;
    private boolean mEnableShowStroke;
    private Paint mGesturePaint;
    private Path mGesturePath;
    private GestureResultListener mGestureResultListener;
    private int[] mGestureSlideDirections;
    private Rect mHotAreaRect;
    private boolean mIsInHotArea;
    private boolean mJudged;
    private boolean mMatched;
    private float mSlideAngleThreshold;
    private float mSlideThreshold;
    private int mStrokeColor;
    private float mStrokeWidth;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DirectionDistance {
        static IPatchRedirector $redirector_;

        @SlideGestureViewHelper.SlideDirection
        int direction;
        float distance;

        DirectionDistance(int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16));
            } else {
                this.direction = i3;
                this.distance = f16;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface GestureResultListener {
        void onGestureMatchFinish(boolean z16, int i3, float f16, float f17, float f18, float f19, int i16);

        void onGestureMatchProgress(float f16, float f17, float f18, float f19, int i3);

        void onGestureMatchStart(float f16, float f17);

        void onGestureMatchSuccess(float f16, float f17, float f18);
    }

    public GesturePathLayer(Context context, Rect rect, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, rect, Float.valueOf(f16));
            return;
        }
        this.mSlideAngleThreshold = 90.0f;
        this.mStrokeColor = -1;
        this.mEnableShowStroke = true;
        this.mGestureSlideDirections = new int[]{2};
        this.mCheckGestureMatchWhenTouchDown = true;
        this.mContext = context;
        this.mHotAreaRect = rect;
        this.mSlideThreshold = f16;
        setAnimator(new KeepAnimator(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0035, code lost:
    
        if (r12 < 0.0f) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r10 = r10 + 180.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0044, code lost:
    
        if (r11 < 0.0f) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r10 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        r10 = r7 + 180.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
    
        if (r12 >= 0.0f) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
    
        if (r11 >= 0.0f) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private double calculateSlideAngle(int i3, float f16, float f17) {
        double degrees;
        double d16;
        double d17 = 0.0d;
        if (f17 == 0.0f && f16 == 0.0f) {
            return 0.0d;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        Logger.w(TAG, "unsupport slide direction.");
                        d16 = 0.0d;
                    } else {
                        d16 = -Math.toDegrees(Math.atan(f16 / f17));
                    }
                } else {
                    degrees = Math.toDegrees(Math.atan(f17 / f16));
                }
            } else {
                d16 = -Math.toDegrees(Math.atan(f16 / f17));
            }
        } else {
            degrees = Math.toDegrees(Math.atan(f17 / f16));
        }
        if (d16 > 180.0d) {
            d16 -= 360.0d;
        }
        if (Math.abs(d16) != 0.0d) {
            d17 = d16;
        }
        if (Math.abs(d17) == 180.0d) {
            return 180.0d;
        }
        return d17;
    }

    @NonNull
    private DirectionDistance calculateSlideDistance(float f16, float f17) {
        int[] iArr = this.mGestureSlideDirections;
        float f18 = 0.0f;
        int i3 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i16 = 0;
            while (i3 < length) {
                int i17 = iArr[i3];
                float calculateSlideDistance = calculateSlideDistance(i17, f16, f17);
                if (calculateSlideDistance > f18) {
                    i16 = i17;
                    f18 = calculateSlideDistance;
                }
                i3++;
            }
            i3 = i16;
        }
        return new DirectionDistance(i3, f18);
    }

    private boolean inRect(float f16, float f17, Rect rect) {
        if (rect == null || f16 < rect.left || f16 > rect.right || f17 < rect.top || f17 > rect.bottom) {
            return false;
        }
        return true;
    }

    private void matchGesture(float f16, float f17) {
        if (!this.mJudged) {
            this.mJudged = true;
            float f18 = f16 - this.mDownX;
            float f19 = f17 - this.mDownY;
            DirectionDistance calculateSlideDistance = calculateSlideDistance(f18, f19);
            float calculateSlideAngle = (float) calculateSlideAngle(calculateSlideDistance.direction, f18, f19);
            float f26 = calculateSlideDistance.distance;
            com.tencent.ams.fusion.widget.animatorview.Logger.d(TAG, "processEvent, distance:" + f26 + ", angle:" + calculateSlideAngle);
            if (f26 >= this.mSlideThreshold && Math.abs(calculateSlideAngle) <= this.mSlideAngleThreshold) {
                com.tencent.ams.fusion.widget.animatorview.Logger.d(TAG, "processEvent, success");
                this.mMatched = true;
                Path path = this.mGesturePath;
                if (path != null) {
                    path.reset();
                }
                GestureResultListener gestureResultListener = this.mGestureResultListener;
                if (gestureResultListener != null) {
                    gestureResultListener.onGestureMatchFinish(true, 0, f16, f17, calculateSlideAngle, f26, calculateSlideDistance.direction);
                    this.mGestureResultListener.onGestureMatchSuccess(f16, f17, calculateSlideAngle);
                }
            }
        }
    }

    private void progressGesture(float f16, float f17) {
        float f18 = f16 - this.mDownX;
        float f19 = f17 - this.mDownY;
        DirectionDistance calculateSlideDistance = calculateSlideDistance(f18, f19);
        float calculateSlideAngle = (float) calculateSlideAngle(calculateSlideDistance.direction, f18, f19);
        float f26 = calculateSlideDistance.distance;
        GestureResultListener gestureResultListener = this.mGestureResultListener;
        if (gestureResultListener != null) {
            gestureResultListener.onGestureMatchProgress(f16, f17, calculateSlideAngle, f26, calculateSlideDistance.direction);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        Paint paint;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Path path = this.mGesturePath;
        if (path != null && (paint = this.mGesturePaint) != null && this.mEnableShowStroke) {
            canvas.drawPath(path, paint);
        }
    }

    public boolean processEvent(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent == null || this.mHotAreaRect == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    if (!inRect(x16, y16, this.mHotAreaRect)) {
                        matchGesture(x16, y16);
                        return false;
                    }
                    progressGesture(x16, y16);
                    Path path = this.mGesturePath;
                    if (path != null && !this.mJudged) {
                        path.lineTo(x16, y16);
                    }
                    return true;
                }
            }
            Path path2 = this.mGesturePath;
            if (path2 != null) {
                path2.reset();
            }
            float x17 = motionEvent.getX();
            float y17 = motionEvent.getY();
            matchGesture(x17, y17);
            if (!this.mMatched && this.mGestureResultListener != null) {
                if (this.mIsInHotArea) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                DirectionDistance calculateSlideDistance = calculateSlideDistance(x17 - this.mDownX, y17 - this.mDownY);
                this.mGestureResultListener.onGestureMatchFinish(false, i3, x17, y17, (float) calculateSlideAngle(calculateSlideDistance.direction, x17 - this.mDownX, y17 - this.mDownY), calculateSlideDistance.distance, calculateSlideDistance.direction);
            }
            reset();
            return true;
        }
        this.mDownX = motionEvent.getX();
        float y18 = motionEvent.getY();
        this.mDownY = y18;
        this.mIsInHotArea = inRect(this.mDownX, y18, this.mHotAreaRect);
        GestureResultListener gestureResultListener = this.mGestureResultListener;
        if (gestureResultListener != null) {
            gestureResultListener.onGestureMatchStart(this.mDownX, this.mDownY);
        }
        if (!this.mIsInHotArea && this.mCheckGestureMatchWhenTouchDown) {
            com.tencent.ams.fusion.widget.animatorview.Logger.d(TAG, "processEvent, not in hot area. x=" + this.mDownX + ", y=" + this.mDownY + ", mHotAreaRect=" + this.mHotAreaRect);
            GestureResultListener gestureResultListener2 = this.mGestureResultListener;
            if (gestureResultListener2 != null) {
                gestureResultListener2.onGestureMatchFinish(false, 3, this.mDownX, this.mDownY, 0.0f, 0.0f, 0);
            }
            return false;
        }
        this.mJudged = false;
        if (this.mGesturePath == null) {
            this.mGesturePath = new Path();
        }
        if (this.mGesturePaint == null) {
            Paint paint = new Paint();
            this.mGesturePaint = paint;
            paint.setAntiAlias(true);
            this.mGesturePaint.setColor(this.mStrokeColor);
            this.mGesturePaint.setStyle(Paint.Style.STROKE);
            this.mGesturePaint.setStrokeJoin(Paint.Join.ROUND);
            this.mGesturePaint.setStrokeCap(Paint.Cap.ROUND);
            this.mGesturePaint.setStrokeWidth(this.mStrokeWidth);
            this.mGesturePaint.setDither(true);
        }
        this.mGesturePath.moveTo(this.mDownX, this.mDownY);
        return true;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.ams.fusion.widget.animatorview.Logger.i(TAG, "reset");
        this.mJudged = false;
        this.mMatched = false;
        this.mGesturePath = null;
    }

    public void setCheckGestureMatchWhenTouchDown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        com.tencent.ams.fusion.widget.animatorview.Logger.i(TAG, "setCheckGestureMatchWhenTouchDown: " + z16);
        this.mCheckGestureMatchWhenTouchDown = z16;
    }

    public void setEnableShowStroke(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mEnableShowStroke = z16;
        }
    }

    public void setGestureResultListener(GestureResultListener gestureResultListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gestureResultListener);
        } else {
            this.mGestureResultListener = gestureResultListener;
        }
    }

    public void setHotAreaRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rect);
        } else {
            this.mHotAreaRect = rect;
        }
    }

    public void setSlideAngleThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.mSlideAngleThreshold = f16;
        }
    }

    public void setSlideDirection(@SlideGestureViewHelper.SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mGestureSlideDirections = new int[]{i3};
        }
    }

    public void setSlideDirections(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iArr);
        } else {
            this.mGestureSlideDirections = iArr;
        }
    }

    public void setSlideThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mSlideThreshold = f16;
        }
    }

    public void setStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mStrokeColor = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer
    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.mStrokeWidth = f16;
        }
    }

    private float calculateSlideDistance(int i3, float f16, float f17) {
        if (i3 == 1) {
            return -f16;
        }
        if (i3 == 2) {
            return -f17;
        }
        if (i3 == 3) {
            return f16;
        }
        if (i3 == 4) {
            return f17;
        }
        Logger.w(TAG, "unsupport slide direction.");
        return 0.0f;
    }
}
