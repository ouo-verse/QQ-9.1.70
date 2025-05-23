package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AnimatingBall implements HippyTKDRefreshAnimation {
    public static final int BALL_COUNT = 3;
    public static final int BALL_MARGIN_H = ImmersiveUtils.dpToPx(12.0f);
    public static final int BALL_MARING_V;
    public static final int BALL_SIZE;
    public static final int CONTENT_HEIGHT;
    static final int INITIAL_Y;
    static final int MSG_END = 0;
    static final int MSG_START = 0;
    static final String TAG = "AnimatingBall";
    static int TARGET_Y;
    float mAlpha;
    long mAlphaDuration;
    Interpolator mAlphaInterpolator;
    float[] mAlphaValues;
    int mBallColor;
    int mBallIndex;
    int mBallInitialColor;
    float mBallSize;
    HippyTKDInvalidateCallback mCb;
    int mEndAnimationY;
    float mInitialY;
    int mOffsetX;
    float mOffsetY;
    Handler mRefreshHandler;
    int mRefreshStartDelay;
    float mScale;
    long mScaleDuration;
    Interpolator mScaleInterpolator;
    float[] mScaleValues;
    int mStartAnimationY;
    Paint sPaint;
    boolean mRefreshing = false;
    long mRefreshStartTime = -1;

    static {
        int dpToPx = ImmersiveUtils.dpToPx(18.0f);
        BALL_MARING_V = dpToPx;
        CONTENT_HEIGHT = ImmersiveUtils.dpToPx(36.0f);
        BALL_SIZE = ImmersiveUtils.dpToPx(3.0f);
        INITIAL_Y = -ImmersiveUtils.dpToPx(40.0f);
        TARGET_Y = -dpToPx;
    }

    public AnimatingBall(HippyTKDInvalidateCallback hippyTKDInvalidateCallback, int i3) {
        this.mRefreshStartDelay = 0;
        this.mEndAnimationY = 0;
        this.mCb = hippyTKDInvalidateCallback;
        this.mBallIndex = i3;
        this.mOffsetX = BALL_SIZE + (BALL_MARGIN_H * i3);
        if (this.sPaint == null) {
            Paint paint = new Paint();
            this.sPaint = paint;
            paint.setAntiAlias(true);
            this.sPaint.setDither(true);
        }
        reset();
        this.mRefreshHandler = new Handler() { // from class: com.tencent.hippy.qq.view.tkd.listview.AnimatingBall.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i16 = message.what;
                if (i16 != 0 && i16 == 0) {
                    AnimatingBall animatingBall = AnimatingBall.this;
                    animatingBall.mRefreshing = false;
                    animatingBall.mRefreshStartTime = -1L;
                    animatingBall.mCb.postInvalidate();
                }
            }
        };
        this.mAlphaInterpolator = new LinearInterpolator();
        this.mScaleInterpolator = new CurvedInterpolator(2);
        this.mAlphaDuration = 800L;
        this.mScaleDuration = 800L;
        this.mAlphaValues = new float[]{0.2f, 1.0f, 0.2f};
        this.mScaleValues = new float[]{1.0f, 1.8f, 1.0f};
        this.mRefreshStartDelay = i3 * 240;
        float dpToPx = INITIAL_Y + ((3 - i3) * ImmersiveUtils.dpToPx(8.0f));
        this.mInitialY = dpToPx;
        this.mOffsetY = dpToPx;
        int abs = Math.abs(TARGET_Y);
        if (i3 == 0) {
            this.mStartAnimationY = 0;
        } else {
            this.mStartAnimationY = (((CONTENT_HEIGHT - abs) / 2) * (i3 - 1)) + abs;
        }
        this.mEndAnimationY = abs + (((CONTENT_HEIGHT - abs) / 2) * i3);
        Log.d(TAG, "index=" + i3 + ",mStart=" + this.mStartAnimationY + ",mEnd=" + this.mEndAnimationY);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshAnimation
    public void animateRefresh() {
        this.mRefreshing = true;
        this.mRefreshStartTime = System.currentTimeMillis();
        this.mCb.postInvalidate();
    }

    void calculateTransforms(long j3) {
        float f16;
        float f17;
        float f18;
        int i3;
        int i16;
        if (this.mRefreshStartTime == -1) {
            return;
        }
        int length = this.mAlphaValues.length;
        int length2 = this.mScaleValues.length;
        float f19 = 0.0f;
        int i17 = 0;
        for (int i18 = 1; i17 < length && i18 < length; i18++) {
            float[] fArr = this.mAlphaValues;
            f19 += Math.abs(fArr[i17] - fArr[i18]);
            i17++;
        }
        float f26 = 0.0f;
        int i19 = 0;
        for (int i26 = 1; i19 < length2 && i26 < length2; i26++) {
            float[] fArr2 = this.mScaleValues;
            f26 += Math.abs(fArr2[i19] - fArr2[i26]);
            i19++;
        }
        long j16 = this.mRefreshStartDelay;
        long j17 = this.mAlphaDuration;
        if (j17 != 0) {
            f16 = ((float) ((j3 - (this.mRefreshStartTime + j16)) % j17)) / ((float) j17);
        } else {
            f16 = 0.0f;
        }
        if (f16 >= 0.0f && f16 < 1.0f) {
            float interpolation = this.mAlphaInterpolator.getInterpolation(f16) * f19;
            int i27 = 0;
            int i28 = 1;
            while (true) {
                if (i27 >= length || i28 >= length) {
                    break;
                }
                float[] fArr3 = this.mAlphaValues;
                float abs = Math.abs(fArr3[i27] - fArr3[i28]);
                if (interpolation <= abs) {
                    float[] fArr4 = this.mAlphaValues;
                    float f27 = fArr4[i27];
                    if (f27 > fArr4[i28]) {
                        i16 = -1;
                    } else {
                        i16 = 1;
                    }
                    setAlpha(f27 + (i16 * interpolation));
                } else {
                    interpolation -= abs;
                    i27++;
                    i28++;
                }
            }
        }
        long j18 = this.mScaleDuration;
        if (j18 != 0) {
            f18 = ((float) ((j3 - (this.mRefreshStartTime + j16)) % j18)) / ((float) j18);
            f17 = 0.0f;
        } else {
            f17 = 0.0f;
            f18 = 0.0f;
        }
        if (f18 >= f17 && f18 < 1.0f) {
            float interpolation2 = this.mScaleInterpolator.getInterpolation(f18) * f26;
            int i29 = 0;
            for (int i36 = 1; i29 < length2 && i36 < length2; i36++) {
                float[] fArr5 = this.mScaleValues;
                float abs2 = Math.abs(fArr5[i29] - fArr5[i36]);
                if (interpolation2 <= abs2) {
                    float[] fArr6 = this.mScaleValues;
                    float f28 = fArr6[i29];
                    if (f28 > fArr6[i36]) {
                        i3 = -1;
                    } else {
                        i3 = 1;
                    }
                    setScale(f28 + (i3 * interpolation2));
                    return;
                }
                interpolation2 -= abs2;
                i29++;
            }
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshAnimation
    public void draw(Canvas canvas, int i3, int i16, int i17) {
        boolean z16;
        float f16;
        if (i16 != Integer.MAX_VALUE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            onScroll(i3);
        }
        calculateTransforms(System.currentTimeMillis());
        canvas.save();
        this.sPaint.setColor(this.mBallColor);
        float f17 = i17 + this.mOffsetX;
        if (!z16) {
            f16 = this.mOffsetY - i3;
        } else {
            f16 = i16;
        }
        canvas.drawCircle(f17, f16, this.mBallSize, this.sPaint);
        canvas.restore();
        if (this.mRefreshing && this.mRefreshStartTime != -1) {
            this.mCb.postInvalidate();
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public float getScale() {
        return this.mScale;
    }

    public void onScroll(int i3) {
        int i16;
        int i17 = -i3;
        int i18 = this.mStartAnimationY;
        if (i17 > i18 && i17 < (i16 = this.mEndAnimationY)) {
            float f16 = (i17 - i18) / (i16 - i18);
            float f17 = this.mInitialY;
            this.mOffsetY = f17 + ((TARGET_Y - f17) * f16);
        } else if (i17 <= i18) {
            this.mOffsetY = this.mInitialY;
        } else {
            this.mOffsetY = TARGET_Y;
        }
    }

    public void reset() {
        setOffsetY(INITIAL_Y);
        setAlpha(1.0f);
        setScale(1.0f);
    }

    public void setAlpha(float f16) {
        this.mAlpha = f16;
        this.mBallColor = Color.argb((int) (Color.alpha(this.mBallInitialColor) * f16), Color.red(this.mBallInitialColor), Color.green(this.mBallInitialColor), Color.blue(this.mBallInitialColor));
    }

    public void setInitialColor(int i3) {
        this.mBallInitialColor = i3;
        reset();
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshAnimation
    public void setInvalidateCallback(HippyTKDInvalidateCallback hippyTKDInvalidateCallback) {
        this.mCb = hippyTKDInvalidateCallback;
    }

    public void setOffsetY(float f16) {
        this.mOffsetY = f16;
    }

    public void setScale(float f16) {
        this.mScale = f16;
        this.mBallSize = f16 * BALL_SIZE;
    }

    public void setTargetY(int i3, int i16) {
        TARGET_Y = i3;
        int abs = Math.abs(i3);
        if (i16 == 0) {
            this.mStartAnimationY = 0;
        } else {
            this.mStartAnimationY = (((CONTENT_HEIGHT - abs) / 2) * (i16 - 1)) + abs;
        }
        this.mEndAnimationY = abs + (((CONTENT_HEIGHT - abs) / 2) * i16);
        Log.d(TAG, "index=" + i16 + ",mStart=" + this.mStartAnimationY + ",mEnd=" + this.mEndAnimationY);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshAnimation
    public void stopAllAnimators() {
        setAlpha(1.0f);
        setScale(1.0f);
        this.mRefreshing = false;
        this.mRefreshStartTime = -1L;
        this.mCb.postInvalidate();
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshAnimation
    public void onSkinChange() {
    }
}
