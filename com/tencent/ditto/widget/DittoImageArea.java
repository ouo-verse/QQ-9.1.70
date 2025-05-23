package com.tencent.ditto.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoImageArea extends DittoArea {

    @DittoJsonElement("\u5360\u4f4d\u56fe\u8d44\u6e90id")
    public static final String RESOURCE_ID = "resource_id";
    public static final String SCALE_TYPE = "scale_type";
    private static final String TAG = "DittoImageArea";
    Paint circleBorderPaint;
    private boolean mDrawCircleBorder;
    private Matrix mDrawMatrix;
    private Drawable mDrawable;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private int mHeight;
    private int mLevel;
    private final Matrix mMatrix;
    private int mResourceId;
    private ImageView.ScaleType mScaleType;
    private RectF mTempDst;
    private RectF mTempSrc;
    private int mWidth;
    private static final ImageView.ScaleType[] sScaleTypeArray = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private static final Matrix.ScaleToFit[] sS2FArray = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};

    public DittoImageArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mMatrix = new Matrix();
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        this.mScaleType = ImageView.ScaleType.FIT_XY;
        this.mDrawCircleBorder = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.circleBorderPaint = new Paint(1);
        if (this.mTempSrc == null) {
            this.mTempSrc = new RectF();
        }
        if (this.mTempDst == null) {
            this.mTempDst = new RectF();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0070 A[Catch: all -> 0x014c, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x0008, B:11:0x0010, B:13:0x001a, B:15:0x0024, B:19:0x002c, B:25:0x005d, B:28:0x0065, B:30:0x0070, B:32:0x0078, B:35:0x007c, B:37:0x0084, B:38:0x0088, B:40:0x008e, B:41:0x00a3, B:43:0x00a8, B:45:0x00b2, B:46:0x00c7, B:47:0x00bd, B:48:0x00d7, B:50:0x00db, B:54:0x00f0, B:55:0x00e6, B:56:0x010b, B:58:0x010f, B:59:0x011e, B:61:0x0122, B:62:0x0131, B:63:0x012c, B:64:0x0119, B:65:0x0143), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void configureBounds() {
        boolean z16;
        ImageView.ScaleType scaleType;
        float min;
        float f16;
        float f17;
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return;
        }
        this.mDrawMatrix = null;
        if (drawable.getBounds() != null && ((this.mDrawable.getBounds().right > 0 || this.mDrawable.getBounds().bottom > 0) && this.mScaleType == ImageView.ScaleType.FIT_XY)) {
            return;
        }
        int i3 = this.mDrawableWidth;
        int i16 = this.mDrawableHeight;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if ((i3 >= 0 && width != i3) || (i16 >= 0 && height != i16)) {
            z16 = false;
            if (i3 > 0 && i16 > 0 && this.mScaleType != ImageView.ScaleType.FIT_XY) {
                this.mDrawable.setBounds(0, 0, i3, i16);
                scaleType = this.mScaleType;
                if (scaleType != ImageView.ScaleType.MATRIX) {
                    if (this.mMatrix.isIdentity()) {
                        this.mDrawMatrix = null;
                    } else {
                        this.mDrawMatrix = this.mMatrix;
                    }
                } else if (z16) {
                    this.mDrawMatrix = null;
                } else if (scaleType == ImageView.ScaleType.CENTER) {
                    Matrix matrix = this.mMatrix;
                    this.mDrawMatrix = matrix;
                    matrix.setTranslate((int) (((width - i3) * 0.5f) + 0.5f), (int) (((height - i16) * 0.5f) + 0.5f));
                } else {
                    float f18 = 0.0f;
                    if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                        Matrix matrix2 = this.mMatrix;
                        this.mDrawMatrix = matrix2;
                        if (i3 * height > width * i16) {
                            f17 = height / i16;
                            float f19 = (width - (i3 * f17)) * 0.5f;
                            f16 = 0.0f;
                            f18 = f19;
                        } else {
                            float f26 = width / i3;
                            f16 = (height - (i16 * f26)) * 0.5f;
                            f17 = f26;
                        }
                        matrix2.setScale(f17, f17);
                        this.mDrawMatrix.postTranslate((int) (f18 + 0.5f), (int) (f16 + 0.5f));
                    } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                        this.mDrawMatrix = this.mMatrix;
                        if (i3 <= width && i16 <= height) {
                            min = 1.0f;
                        } else {
                            min = Math.min(width / i3, height / i16);
                        }
                        this.mDrawMatrix.setScale(min, min);
                        this.mDrawMatrix.postTranslate((int) (((width - (i3 * min)) * 0.5f) + 0.5f), (int) (((height - (i16 * min)) * 0.5f) + 0.5f));
                    } else {
                        RectF rectF = this.mTempSrc;
                        if (rectF == null) {
                            this.mTempSrc = new RectF(0.0f, 0.0f, i3, i16);
                        } else {
                            rectF.set(0.0f, 0.0f, i3, i16);
                        }
                        RectF rectF2 = this.mTempDst;
                        if (rectF2 == null) {
                            this.mTempDst = new RectF(0.0f, 0.0f, width, height);
                        } else {
                            rectF2.set(0.0f, 0.0f, width, height);
                        }
                        Matrix matrix3 = this.mMatrix;
                        this.mDrawMatrix = matrix3;
                        matrix3.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mScaleType));
                    }
                }
            }
            this.mDrawable.setBounds(0, 0, width, height);
            this.mDrawMatrix = null;
        }
        z16 = true;
        if (i3 > 0) {
            this.mDrawable.setBounds(0, 0, i3, i16);
            scaleType = this.mScaleType;
            if (scaleType != ImageView.ScaleType.MATRIX) {
            }
        }
        this.mDrawable.setBounds(0, 0, width, height);
        this.mDrawMatrix = null;
    }

    private void resizeFromDrawable() {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth < 0) {
            intrinsicWidth = this.mDrawableWidth;
        }
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        if (intrinsicHeight < 0) {
            intrinsicHeight = this.mDrawableHeight;
        }
        if (intrinsicWidth != this.mDrawableWidth || intrinsicHeight != this.mDrawableHeight) {
            this.mDrawableWidth = intrinsicWidth;
            this.mDrawableHeight = intrinsicHeight;
            requestLayout();
        }
    }

    private void resolveUri() {
        Drawable drawable;
        Resources resources;
        if (this.mDrawable == null && this.mResourceId != 0) {
            try {
                resources = getContext().getResources();
            } catch (Exception e16) {
                Log.w(TAG, "Unable to find resource: " + this.mResourceId, e16);
                drawable = null;
            }
            if (resources == null) {
                return;
            }
            drawable = resources.getDrawable(this.mResourceId);
            updateDrawable(drawable);
        }
    }

    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return sS2FArray[ImageView.ScaleType.FIT_XY.ordinal() - 1];
        }
        return sS2FArray[scaleType.ordinal() - 1];
    }

    private void setDrawableVisible(boolean z16) {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setVisible(z16, false);
        }
    }

    private void updateDrawable(Drawable drawable) {
        boolean z16;
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable.isStateful();
            drawable.setLevel(this.mLevel);
            if (getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            drawable.setVisible(z16, true);
            this.mDrawableWidth = drawable.getIntrinsicWidth();
            this.mDrawableHeight = drawable.getIntrinsicHeight();
            this.mDrawable = drawable;
            configureBounds();
            return;
        }
        this.mDrawableHeight = -1;
        this.mDrawableWidth = -1;
    }

    public void clearDrawable() {
        this.mDrawable = null;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mDrawable;
        if (drawable != null && this.mDrawableWidth != 0 && this.mDrawableHeight != 0) {
            try {
                drawable.setAlpha((int) getAlpha());
                if (this.mDrawCircleBorder && this.borderWidth != 0) {
                    this.circleBorderPaint.setColor(this.borderColor);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.circleBorderPaint);
                    if (this.mDrawableWidth <= 0 || this.mDrawableHeight <= 0 || this.mScaleType == ImageView.ScaleType.FIT_XY) {
                        Drawable drawable2 = this.mDrawable;
                        int i3 = this.borderWidth;
                        drawable2.setBounds(i3, i3, getWidth() - (this.borderWidth * 2), getHeight() - (this.borderWidth * 2));
                    }
                } else if (this.mDrawableWidth <= 0 || this.mDrawableHeight <= 0 || this.mScaleType == ImageView.ScaleType.FIT_XY) {
                    this.mDrawable.setBounds(0, 0, getWidth(), getHeight());
                }
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                if (this.mDrawMatrix == null && paddingLeft == 0 && paddingTop == 0) {
                    this.mDrawable.draw(canvas);
                    return;
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.translate(paddingLeft, paddingTop);
                Matrix matrix = this.mDrawMatrix;
                if (matrix != null) {
                    canvas.concat(matrix);
                }
                this.mDrawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            } finally {
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        configureBounds();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        Drawable drawable;
        int i17;
        int max;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        resolveUri();
        int i18 = 0;
        if (mode != 1073741824) {
            if (this.mDrawable == null) {
                this.mDrawableWidth = -1;
                max = 0;
            } else {
                max = Math.max(1, this.mDrawableWidth) + getPaddingLeft() + getPaddingRight();
            }
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, max);
            } else {
                size = max;
            }
        }
        if (mode2 != 1073741824) {
            if (this.mDrawable == null) {
                this.mDrawableHeight = -1;
            } else {
                i18 = getPaddingBottom() + Math.max(1, this.mDrawableHeight) + getPaddingTop();
            }
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(size2, i18);
            } else {
                size2 = i18;
            }
        }
        if (mode != 1073741824 && mode2 == 1073741824) {
            size = (int) (((this.mDrawableWidth * 1.0f) / this.mDrawableHeight) * size2);
        } else if (mode2 != 1073741824 && mode == 1073741824) {
            size2 = (int) (((this.mDrawableHeight * 1.0f) / this.mDrawableWidth) * size);
        }
        if ((mode != 1073741824 || mode2 != 1073741824) && (drawable = this.mDrawable) != null && drawable.getBounds().width() > 0 && this.mDrawable.getBounds().height() > 0 && size > 0 && size2 > 0) {
            float width = (this.mDrawable.getBounds().width() * 1.0f) / this.mDrawable.getBounds().height();
            float f16 = size;
            float f17 = size2;
            float f18 = (1.0f * f16) / f17;
            if (f18 > width) {
                size = (int) (width * f17);
            } else if (f18 < width && width > 0.0f) {
                size2 = (int) (f16 / width);
            }
        }
        int i19 = this.mWidth;
        if (i19 != 0 && (i17 = this.mHeight) != 0) {
            setMeasuredDimension(i19, i17);
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    public void onRecycled() {
        this.clickListener = null;
        this.longClickListener = null;
    }

    public void setDimens(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
    }

    public void setDrawCircleBorder(boolean z16) {
        this.mDrawCircleBorder = z16;
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
    }

    public void setImageDrawable(Drawable drawable) {
        this.mResourceId = 0;
        int i3 = this.mDrawableWidth;
        int i16 = this.mDrawableHeight;
        updateDrawable(drawable);
        if (i3 != this.mDrawableWidth || i16 != this.mDrawableHeight) {
            requestLayout();
        }
    }

    public void setImageResource(int i3) {
        if (this.mResourceId == i3) {
            return;
        }
        updateDrawable(null);
        this.mResourceId = i3;
        int i16 = this.mDrawableWidth;
        int i17 = this.mDrawableHeight;
        resolveUri();
        if (i16 != this.mDrawableWidth || i17 != this.mDrawableHeight) {
            requestLayout();
        }
        invalidate();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        super.setLayoutAttr(layoutAttrSet);
        if (layoutAttrSet.hasAttr(SCALE_TYPE)) {
            String attr = layoutAttrSet.getAttr(SCALE_TYPE, "fitXY");
            if ("fitXY".equals(attr)) {
                setScaleType(ImageView.ScaleType.FIT_XY);
            } else if ("fitStart".equals(attr)) {
                setScaleType(ImageView.ScaleType.FIT_START);
            } else if ("fitCenter".equals(attr)) {
                setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if ("fitEnd".equals(attr)) {
                setScaleType(ImageView.ScaleType.FIT_END);
            } else if ("center".equals(attr)) {
                setScaleType(ImageView.ScaleType.CENTER);
            } else if ("centerCrop".equals(attr)) {
                setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else if ("centerInside".equals(attr)) {
                setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        }
        if (layoutAttrSet.hasAttr(RESOURCE_ID)) {
            setImageResource(layoutAttrSet.getResourceId(RESOURCE_ID));
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        scaleType.getClass();
        if (this.mScaleType == scaleType) {
            return;
        }
        this.mScaleType = scaleType;
        requestLayout();
        invalidate();
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }
}
