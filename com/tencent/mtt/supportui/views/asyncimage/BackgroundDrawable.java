package com.tencent.mtt.supportui.views.asyncimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import com.tencent.mtt.supportui.utils.CommonTool;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class BackgroundDrawable extends BaseDrawable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String gradientAngleDesc;
    private int[] gradientColors;
    private Paint gradientPaint;
    private float[] gradientPositions;
    private int[] mBorderColorArray;
    private float[] mBorderRadiusArray;
    private float[] mBorderWidthArray;
    private Path mPathForBorderRadius;
    private Path mPathWithBorder;
    private Paint mShadowPaint;
    protected RectF mShadowRect;
    private RectF mTempRectForBorderRadius;
    private int mBorderStyle = 0;
    private DashPathEffect mDashPathEffect = null;
    private DashPathEffect mDotPathEffect = new DashPathEffect(new float[]{2.0f, 2.0f}, 0.0f);
    private int mBackgroundColor = 0;
    private boolean mNeedUpdateBorderPath = false;
    private int gradientAngle = Integer.MAX_VALUE;
    protected float mShadowOpacity = 0.8f;
    protected int mShadowColor = -7829368;
    private Bitmap mCanvasBitmap = null;
    private Canvas mBitmapCanvas = null;
    private Paint mBitmapPaint = null;
    private final Paint mPaint = new Paint(1);

    private void calculateStartEndPoint(PointF pointF, PointF pointF2, int i3) {
        RectF rectF;
        if (checkSpecialAngle(pointF, pointF2)) {
            return;
        }
        int i16 = this.gradientAngle;
        int i17 = i16 % 90;
        if ((i16 > 90 && i16 < 180) || (i16 > 270 && i16 < 360)) {
            i17 = 90 - i17;
        }
        if (i17 == i3) {
            rectF = this.mRect;
            pointF2.x = rectF.right;
            pointF2.y = rectF.top;
            pointF.x = rectF.left;
        } else if (i17 < i3) {
            float tan = (float) ((Math.tan(Math.toRadians(i17)) * this.mRect.height()) / 2.0d);
            pointF2.x = this.mRect.centerX() + tan;
            RectF rectF2 = this.mRect;
            pointF2.y = rectF2.top;
            pointF.x = rectF2.centerX() - tan;
            rectF = this.mRect;
        } else {
            float tan2 = (float) ((Math.tan(Math.toRadians(90 - i17)) * this.mRect.width()) / 2.0d);
            RectF rectF3 = this.mRect;
            pointF2.x = rectF3.right;
            pointF2.y = rectF3.centerY() - tan2;
            RectF rectF4 = this.mRect;
            pointF.x = rectF4.left;
            pointF.y = rectF4.centerY() + tan2;
            correctPointWithOriginDegree(pointF, pointF2);
        }
        pointF.y = rectF.bottom;
        correctPointWithOriginDegree(pointF, pointF2);
    }

    private void calculategradientAngle(int i3) {
        int i16;
        if (this.gradientAngleDesc.equals("totopright")) {
            i16 = 90 - i3;
        } else if (this.gradientAngleDesc.equals("tobottomright")) {
            i16 = i3 + 90;
        } else if (this.gradientAngleDesc.equals("tobottomleft")) {
            i16 = 270 - i3;
        } else if (this.gradientAngleDesc.equals("totopleft")) {
            i16 = i3 + 270;
        } else {
            try {
                this.gradientAngle = Math.round(Float.parseFloat(this.gradientAngleDesc)) % 360;
                return;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return;
            }
        }
        this.gradientAngle = i16;
    }

    private boolean checkSpecialAngle(PointF pointF, PointF pointF2) {
        float f16;
        RectF rectF;
        float f17;
        int i3 = this.gradientAngle;
        if (i3 != 0) {
            if (i3 != 90) {
                if (i3 != 180) {
                    if (i3 != 270) {
                        return false;
                    }
                    RectF rectF2 = this.mRect;
                    pointF2.x = rectF2.left;
                    pointF2.y = rectF2.centerY();
                    rectF = this.mRect;
                    f17 = rectF.right;
                } else {
                    pointF2.x = this.mRect.centerX();
                    RectF rectF3 = this.mRect;
                    pointF2.y = rectF3.bottom;
                    pointF.x = rectF3.centerX();
                    f16 = this.mRect.top;
                }
            } else {
                RectF rectF4 = this.mRect;
                pointF2.x = rectF4.right;
                pointF2.y = rectF4.centerY();
                rectF = this.mRect;
                f17 = rectF.left;
            }
            pointF.x = f17;
            f16 = rectF.centerY();
        } else {
            pointF2.x = this.mRect.centerX();
            RectF rectF5 = this.mRect;
            pointF2.y = rectF5.top;
            pointF.x = rectF5.centerX();
            f16 = this.mRect.bottom;
        }
        pointF.y = f16;
        return true;
    }

    private void correctPointWithOriginDegree(PointF pointF, PointF pointF2) {
        int i3 = this.gradientAngle;
        if (i3 > 90 && i3 < 180) {
            float f16 = this.mRect.bottom;
            pointF.y = f16 - pointF.y;
            pointF2.y = f16 - pointF2.y;
            return;
        }
        if (i3 > 180 && i3 < 270) {
            PointF pointF3 = new PointF(pointF.x, pointF.y);
            pointF.x = pointF2.x;
            pointF.y = pointF2.y;
            pointF2.x = pointF3.x;
            pointF2.y = pointF3.y;
            return;
        }
        if (i3 > 270 && i3 < 360) {
            RectF rectF = this.mRect;
            float f17 = rectF.left;
            float f18 = rectF.right;
            pointF2.x = f17 + (f18 - pointF2.x);
            pointF.x = f18 - pointF.x;
        }
    }

    private void drawBG(Canvas canvas) {
        RectF rectF;
        Paint paint;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        if (initGradientPaint()) {
            rectF = this.mRect;
            paint = this.gradientPaint;
        } else {
            this.mPaint.setColor(this.mBackgroundColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            rectF = this.mRect;
            paint = this.mPaint;
        }
        canvas.drawRect(rectF, paint);
        if (CommonTool.hasPositiveItem(this.mBorderWidthArray)) {
            RectF rectF2 = this.mRect;
            int round = Math.round(this.mBorderWidthArray[1]);
            if (round == 0) {
                float f16 = this.mBorderWidthArray[0];
                if (f16 > 0.0f) {
                    round = Math.round(f16);
                }
            }
            int round2 = Math.round(this.mBorderWidthArray[2]);
            if (round2 == 0) {
                float f17 = this.mBorderWidthArray[0];
                if (f17 > 0.0f) {
                    round2 = Math.round(f17);
                }
            }
            int round3 = Math.round(this.mBorderWidthArray[3]);
            if (round3 == 0) {
                float f18 = this.mBorderWidthArray[0];
                if (f18 > 0.0f) {
                    round3 = Math.round(f18);
                }
            }
            int round4 = Math.round(this.mBorderWidthArray[4]);
            if (round4 == 0) {
                float f19 = this.mBorderWidthArray[0];
                if (f19 > 0.0f) {
                    round4 = Math.round(f19);
                }
            }
            int[] iArr = this.mBorderColorArray;
            if (iArr == null) {
                i3 = 0;
            } else {
                i3 = iArr[1];
            }
            if (i3 == 0 && iArr != null && (i29 = iArr[0]) != 0) {
                i3 = i29;
            }
            if (iArr == null) {
                i16 = 0;
            } else {
                i16 = iArr[2];
            }
            if (i16 == 0 && iArr != null && (i28 = iArr[0]) != 0) {
                i16 = i28;
            }
            if (iArr == null) {
                i17 = 0;
            } else {
                i17 = iArr[3];
            }
            if (i17 == 0 && iArr != null && (i27 = iArr[0]) != 0) {
                i17 = i27;
            }
            if (iArr == null) {
                i18 = 0;
            } else {
                i18 = iArr[4];
            }
            if (i18 == 0 && iArr != null && (i26 = iArr[0]) != 0) {
                i18 = i26;
            }
            float f26 = rectF2.top;
            float f27 = rectF2.left;
            float width = rectF2.width();
            float height = rectF2.height();
            this.mPaint.setAntiAlias(false);
            if (this.mPathWithBorder == null) {
                this.mPathWithBorder = new Path();
            }
            if (round > 0 && i3 != 0) {
                this.mPaint.setColor(i3);
                this.mPathWithBorder.reset();
                this.mPathWithBorder.moveTo(f27, f26);
                float f28 = round + f27;
                this.mPathWithBorder.lineTo(f28, round2 + f26);
                float f29 = f26 + height;
                i19 = i18;
                this.mPathWithBorder.lineTo(f28, f29 - round4);
                this.mPathWithBorder.lineTo(f27, f29);
                this.mPathWithBorder.lineTo(f27, f26);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            } else {
                i19 = i18;
            }
            if (round2 > 0 && i16 != 0) {
                this.mPaint.setColor(i16);
                this.mPathWithBorder.reset();
                this.mPathWithBorder.moveTo(f27, f26);
                float f36 = round2 + f26;
                this.mPathWithBorder.lineTo(round + f27, f36);
                float f37 = f27 + width;
                this.mPathWithBorder.lineTo(f37 - round3, f36);
                this.mPathWithBorder.lineTo(f37, f26);
                this.mPathWithBorder.lineTo(f27, f26);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            }
            if (round3 > 0 && i17 != 0) {
                this.mPaint.setColor(i17);
                this.mPathWithBorder.reset();
                float f38 = f27 + width;
                this.mPathWithBorder.moveTo(f38, f26);
                float f39 = f26 + height;
                this.mPathWithBorder.lineTo(f38, f39);
                float f46 = f38 - round3;
                this.mPathWithBorder.lineTo(f46, f39 - round4);
                this.mPathWithBorder.lineTo(f46, round2 + f26);
                this.mPathWithBorder.lineTo(f38, f26);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            }
            if (round4 > 0 && i19 != 0) {
                this.mPaint.setColor(i19);
                this.mPathWithBorder.reset();
                float f47 = f26 + height;
                this.mPathWithBorder.moveTo(f27, f47);
                float f48 = width + f27;
                this.mPathWithBorder.lineTo(f48, f47);
                float f49 = f47 - round4;
                this.mPathWithBorder.lineTo(f48 - round3, f49);
                this.mPathWithBorder.lineTo(round + f27, f49);
                this.mPathWithBorder.lineTo(f27, f47);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            }
            this.mPaint.setAntiAlias(true);
        }
    }

    private void drawBGShadow(Canvas canvas) {
        int round;
        float f16 = 0.0f;
        if (this.mShadowRadius != 0.0f) {
            float f17 = this.mShadowOpacity;
            if (f17 > 0.0f) {
                if (f17 >= 1.0f) {
                    round = 255;
                } else {
                    round = Math.round(f17 * 255.0f);
                }
                float[] fArr = this.mBorderRadiusArray;
                if (fArr != null && fArr.length > 0) {
                    int i3 = 0;
                    while (true) {
                        float[] fArr2 = this.mBorderRadiusArray;
                        if (i3 >= fArr2.length) {
                            break;
                        }
                        float f18 = fArr2[i3];
                        if (f18 > f16) {
                            f16 = f18;
                        }
                        i3++;
                    }
                }
                if (this.mShadowPaint == null) {
                    this.mShadowPaint = new Paint();
                }
                this.mShadowPaint.setColor(0);
                this.mShadowPaint.setAntiAlias(true);
                this.mShadowPaint.setAlpha(round);
                this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mShadowOffsetX, this.mShadowOffsetY, this.mShadowColor);
                canvas.drawRoundRect(this.mShadowRect, f16, f16, this.mShadowPaint);
            }
        }
    }

    private void drawBGWithRadius(Canvas canvas) {
        Path path;
        Paint paint;
        int[] iArr;
        int i3;
        updatePath();
        if (initGradientPaint()) {
            path = this.mPathForBorderRadius;
            paint = this.gradientPaint;
        } else {
            this.mPaint.setColor(this.mBackgroundColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            path = this.mPathForBorderRadius;
            paint = this.mPaint;
        }
        canvas.drawPath(path, paint);
        if (CommonTool.hasPositiveItem(this.mBorderWidthArray) && this.mBorderWidthArray[0] > 0.0f && (iArr = this.mBorderColorArray) != null) {
            int i16 = iArr[0];
            if (i16 == 0) {
                int i17 = iArr[1];
                int i18 = iArr[2];
                if (i17 != i18 || i18 != (i3 = iArr[3]) || i3 != iArr[4]) {
                    drawBGWithRadiusWithSingleColor(canvas);
                    return;
                }
            }
            if (i16 == 0) {
                i16 = iArr[1];
            }
            if (i16 == 0) {
                return;
            }
            this.mPaint.setColor(i16);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidthArray[0]);
            canvas.drawPath(this.mPathForBorderRadius, this.mPaint);
        }
    }

    private void drawBGWithRadiusWithSingleColor(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        if (CommonTool.hasPositiveItem(this.mBorderWidthArray)) {
            RectF rectF = this.mRect;
            int round = Math.round(this.mBorderWidthArray[0]);
            int[] iArr = this.mBorderColorArray;
            if (iArr == null) {
                i3 = 0;
            } else {
                i3 = iArr[1];
            }
            if (i3 == 0 && iArr != null && (i29 = iArr[0]) != 0) {
                i3 = i29;
            }
            if (iArr == null) {
                i16 = 0;
            } else {
                i16 = iArr[2];
            }
            if (i16 == 0 && iArr != null && (i28 = iArr[0]) != 0) {
                i16 = i28;
            }
            if (iArr == null) {
                i17 = 0;
            } else {
                i17 = iArr[3];
            }
            if (i17 == 0 && iArr != null && (i27 = iArr[0]) != 0) {
                i17 = i27;
            }
            if (iArr == null) {
                i18 = 0;
            } else {
                i18 = iArr[4];
            }
            if (i18 == 0 && iArr != null && (i26 = iArr[0]) != 0) {
                i18 = i26;
            }
            float[] fArr = this.mBorderRadiusArray;
            float f16 = fArr[1];
            if (f16 == 0.0f) {
                float f17 = fArr[0];
                if (f17 > 0.0f) {
                    f16 = f17;
                }
            }
            float f18 = fArr[2];
            if (f18 == 0.0f) {
                float f19 = fArr[0];
                if (f19 > 0.0f) {
                    f18 = f19;
                }
            }
            float f26 = fArr[3];
            if (f26 == 0.0f) {
                float f27 = fArr[0];
                if (f27 > 0.0f) {
                    f26 = f27;
                }
            }
            float f28 = fArr[4];
            if (f28 == 0.0f) {
                float f29 = fArr[0];
                if (f29 > 0.0f) {
                    f28 = f29;
                }
            }
            float f36 = rectF.top;
            float f37 = rectF.left;
            float f38 = rectF.bottom;
            float f39 = rectF.right;
            rectF.width();
            rectF.height();
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(round);
            this.mPaint.setStyle(Paint.Style.STROKE);
            if (this.mPathWithBorder == null) {
                this.mPathWithBorder = new Path();
            }
            int i36 = round / 2;
            if (i3 != 0) {
                this.mPaint.setColor(i3);
                this.mPathWithBorder.reset();
                float f46 = i36;
                float f47 = f37 + f46;
                i19 = i18;
                this.mPathWithBorder.moveTo(f47, f36 + f16);
                this.mPathWithBorder.lineTo(f47, f38 - f28);
                float f48 = f16 * 2.0f;
                this.mPathWithBorder.addArc(f47, f36 + f46, (f37 + f48) - f46, (f36 + f48) - f46, -180.0f, 45.0f);
                float f49 = f28 * 2.0f;
                this.mPathWithBorder.addArc(f47, (f38 - f49) + f46, (f37 + f49) - f46, f38 - f46, 135.0f, 45.0f);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            } else {
                i19 = i18;
            }
            if (i16 != 0) {
                this.mPaint.setColor(i16);
                this.mPathWithBorder.reset();
                float f56 = i36;
                float f57 = f36 + f56;
                this.mPathWithBorder.moveTo(f37 + f16, f57);
                this.mPathWithBorder.lineTo(f39 - f18, f57);
                float f58 = f16 * 2.0f;
                this.mPathWithBorder.addArc(f37 + f56, f57, (f37 + f58) - f56, (f58 + f36) - f56, -135.0f, 45.0f);
                float f59 = f18 * 2.0f;
                this.mPathWithBorder.addArc((f39 - f59) + f56, f57, f39 - f56, (f59 + f36) - f56, -90.0f, 45.0f);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            }
            if (i17 != 0) {
                this.mPaint.setColor(i17);
                this.mPathWithBorder.reset();
                float f65 = i36;
                float f66 = f39 - f65;
                this.mPathWithBorder.moveTo(f66, f36 + f18);
                this.mPathWithBorder.lineTo(f66, f38 - f26);
                float f67 = f26 * 2.0f;
                this.mPathWithBorder.addArc((f39 - f67) + f65, (f38 - f67) + f65, f66, f38 - f65, 0.0f, 45.0f);
                float f68 = f18 * 2.0f;
                this.mPathWithBorder.addArc((f39 - f68) + f65, f36 + f65, f66, (f36 + f68) - f65, -45.0f, 45.0f);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            }
            if (i19 != 0) {
                this.mPaint.setColor(i19);
                this.mPathWithBorder.reset();
                float f69 = i36;
                float f75 = f38 - f69;
                this.mPathWithBorder.moveTo(f37 + f28, f75);
                this.mPathWithBorder.lineTo(f39 - f26, f75);
                float f76 = f26 * 2.0f;
                this.mPathWithBorder.addArc((f39 - f76) + f69, (f38 - f76) + f69, f39 - f69, f75, 45.0f, 45.0f);
                float f77 = f28 * 2.0f;
                this.mPathWithBorder.addArc(f37 + f69, (f38 - f77) + f69, (f37 + f77) - f69, f75, 90.0f, 45.0f);
                canvas.drawPath(this.mPathWithBorder, this.mPaint);
            }
            this.mPaint.setAntiAlias(true);
        }
    }

    private int getOppositeAngle() {
        return (int) Math.round(Math.toDegrees(Math.atan(this.mRect.width() / this.mRect.height())));
    }

    private boolean initGradientPaint() {
        int[] iArr;
        if (TextUtils.isEmpty(this.gradientAngleDesc)) {
            return false;
        }
        int oppositeAngle = getOppositeAngle();
        calculategradientAngle(oppositeAngle);
        if (this.gradientAngle != Integer.MAX_VALUE && (iArr = this.gradientColors) != null && iArr.length >= 2) {
            float[] fArr = this.gradientPositions;
            if (fArr != null && iArr.length != fArr.length) {
                this.gradientPositions = null;
            }
            if (this.gradientPaint == null) {
                this.gradientPaint = new Paint();
            }
            this.gradientPaint.setStyle(Paint.Style.FILL);
            PointF pointF = new PointF();
            PointF pointF2 = new PointF();
            calculateStartEndPoint(pointF, pointF2, oppositeAngle);
            try {
                this.gradientPaint.setShader(new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP));
                return true;
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private void updatePath() {
        float f16;
        if (this.mPathForBorderRadius == null) {
            this.mPathForBorderRadius = new Path();
            this.mTempRectForBorderRadius = new RectF();
        }
        if (!this.mNeedUpdateBorderPath) {
            return;
        }
        this.mNeedUpdateBorderPath = false;
        this.mPathForBorderRadius.reset();
        this.mTempRectForBorderRadius.set(this.mRect);
        float[] fArr = this.mBorderWidthArray;
        if (fArr == null) {
            f16 = 0.0f;
        } else {
            f16 = fArr[0];
        }
        if (f16 > 1.0f) {
            float f17 = f16 * 0.5f;
            this.mTempRectForBorderRadius.inset(f17, f17);
        }
        float[] fArr2 = this.mBorderRadiusArray;
        float f18 = fArr2[1];
        if (f18 == 0.0f) {
            float f19 = fArr2[0];
            if (f19 > 0.0f) {
                f18 = f19;
            }
        }
        float f26 = fArr2[2];
        if (f26 == 0.0f) {
            float f27 = fArr2[0];
            if (f27 > 0.0f) {
                f26 = f27;
            }
        }
        float f28 = fArr2[3];
        if (f28 == 0.0f) {
            float f29 = fArr2[0];
            if (f29 > 0.0f) {
                f28 = f29;
            }
        }
        float f36 = fArr2[4];
        if (f36 == 0.0f) {
            float f37 = fArr2[0];
            if (f37 > 0.0f) {
                f36 = f37;
            }
        }
        this.mPathForBorderRadius.addRoundRect(this.mTempRectForBorderRadius, new float[]{f18, f18, f26, f26, f28, f28, f36, f36}, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        DashPathEffect dashPathEffect;
        if (canvas.getWidth() != 0 && canvas.getHeight() != 0) {
            boolean hasPositiveItem = CommonTool.hasPositiveItem(this.mBorderRadiusArray);
            int i3 = this.mBorderStyle;
            if (i3 == 1) {
                if (this.mDashPathEffect == null) {
                    this.mDashPathEffect = new DashPathEffect(new float[]{8.0f, 4.0f}, 0.0f);
                }
                paint = this.mPaint;
                dashPathEffect = this.mDashPathEffect;
            } else if (i3 == 2) {
                if (this.mDotPathEffect == null) {
                    this.mDotPathEffect = new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f);
                }
                paint = this.mPaint;
                dashPathEffect = this.mDotPathEffect;
            } else {
                paint = this.mPaint;
                dashPathEffect = null;
            }
            paint.setPathEffect(dashPathEffect);
            drawBGShadow(canvas);
            if (!hasPositiveItem) {
                drawBG(canvas);
            } else {
                drawBGWithRadius(canvas);
            }
        }
    }

    public Bitmap generateBitmap(int i3, int i16) {
        return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
    }

    public float[] getBorderRadiusArray() {
        return this.mBorderRadiusArray;
    }

    public float[] getBorderWidthArray() {
        return this.mBorderWidthArray;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public float getShadowOffsetX() {
        return this.mShadowOffsetX;
    }

    public float getShadowOffsetY() {
        return this.mShadowOffsetY;
    }

    public float getShadowRadius() {
        return this.mShadowRadius;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdateBorderPath = true;
    }

    public void setBackgroundColor(int i3) {
        this.mBackgroundColor = i3;
        invalidateSelf();
    }

    public void setBorderColor(int i3, int i16) {
        if (this.mBorderColorArray == null) {
            this.mBorderColorArray = new int[5];
        }
        this.mBorderColorArray[i16] = i3;
        invalidateSelf();
    }

    public void setBorderRadius(float f16, int i3) {
        if (this.mBorderRadiusArray == null) {
            this.mBorderRadiusArray = new float[5];
        }
        this.mBorderRadiusArray[i3] = f16;
        this.mNeedUpdateBorderPath = true;
        invalidateSelf();
    }

    public void setBorderStyle(int i3) {
        if (i3 < 0 || i3 > 2) {
            i3 = 0;
        }
        this.mBorderStyle = i3;
        invalidateSelf();
    }

    public void setBorderWidth(float f16, int i3) {
        if (this.mBorderWidthArray == null) {
            this.mBorderWidthArray = new float[5];
        }
        this.mBorderWidthArray[i3] = f16;
        this.mNeedUpdateBorderPath = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
        float f16 = this.mShadowRadius;
        float f17 = this.mShadowOffsetX;
        float f18 = this.mShadowOffsetY;
        this.mShadowRect = new RectF((i3 + f16) - f17, (i16 + f16) - f18, (i17 - f16) - f17, (i18 - f16) - f18);
        updateContentRegion();
    }

    public void setGradientAngle(String str) {
        this.gradientAngleDesc = str;
    }

    public void setGradientColors(ArrayList<Integer> arrayList) {
        int size;
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        if (size > 0) {
            this.gradientColors = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                this.gradientColors[i3] = arrayList.get(i3).intValue();
            }
            return;
        }
        this.gradientColors = null;
    }

    public void setGradientPositions(ArrayList<Float> arrayList) {
        int size;
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        if (size > 0) {
            this.gradientPositions = new float[size];
            int i3 = 0;
            float f16 = 0.0f;
            for (int i16 = 0; i16 < size; i16++) {
                float floatValue = arrayList.get(i16).floatValue();
                if (i16 == 0) {
                    this.gradientPositions[i16] = floatValue;
                } else if (floatValue > 0.0f || i3 >= i16) {
                    if (floatValue > 0.0f && i3 < i16 - 1) {
                        float f17 = (floatValue - f16) / (i16 - i3);
                        for (int i17 = i3 + 1; i17 < i16; i17++) {
                            this.gradientPositions[i17] = ((i17 - i3) * f17) + f16;
                        }
                    }
                    this.gradientPositions[i16] = floatValue;
                    i3 = i16;
                }
                f16 = floatValue;
            }
            return;
        }
        this.gradientPositions = null;
    }

    public void setShadowColor(int i3) {
        this.mShadowColor = i3;
        invalidateSelf();
    }

    public void setShadowOpacity(float f16) {
        this.mShadowOpacity = f16;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
