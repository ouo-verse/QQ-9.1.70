package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.j;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface Markable {
    public static final int MARK_CENTER = 1;
    public static final int MARK_LEFT_BOTTOM = 5;
    public static final int MARK_LEFT_TOP = 2;
    public static final int MARK_RIGHT_BOTTOM = 4;
    public static final int MARK_RIGHT_CENTER = 6;
    public static final int MARK_RIGHT_TOP = 3;
    public static final int MARK_SCALE_TYPE_CENTER = 1;
    public static final int MARK_SCALE_TYPE_CENTER_CROP = 2;
    public static final int MARK_SCALE_TYPE_CENTER_INSIDE = 3;
    public static final int MARK_SCALE_TYPE_FIT_CENTER = 4;
    public static final int MARK_SCALE_TYPE_FIT_END = 6;
    public static final int MARK_SCALE_TYPE_FIT_START = 5;
    public static final int MARK_SCALE_TYPE_FIT_XY = 7;
    public static final int MARK_SCALE_TYPE_MATRIX = 8;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class Marker implements Markable {
        static final int MARK_SCALE_TYPE_INVALID = 0;
        Context mContext;
        Matrix mDrawMatrix;
        Drawable mMarker;
        OnMarkerClickListener mMarkerClickListener;
        Markable mMarkerClickListenerCallback;
        int mMarkerHeight;
        boolean mMarkerOrPositionChanged;
        int mMarkerPaddingX;
        int mMarkerPaddingXOffset;
        int mMarkerPaddingY;
        int mMarkerPaddingYOffset;
        int mMarkerPosition;
        boolean mMarkerPressed;
        int mMarkerScaleType;
        boolean mMarkerVisible;
        boolean mMarkerVisibleWhenSelected;
        int mMarkerWidth;
        Matrix mMatrix;
        RectF mTempDst;
        RectF mTempSrc;
        View mView;

        public Marker(View view) {
            this(view, null);
        }

        public void draw(Canvas canvas) {
            if (this.mMarkerOrPositionChanged) {
                updateMarkerLayout();
                this.mMarkerOrPositionChanged = false;
            }
            if (isMarkerAvailable()) {
                int saveCount = canvas.getSaveCount();
                canvas.save();
                int currentMarkerPaddingX = getCurrentMarkerPaddingX();
                int currentMarkerPaddingY = getCurrentMarkerPaddingY();
                if (currentMarkerPaddingX != 0 || currentMarkerPaddingY != 0) {
                    canvas.translate(currentMarkerPaddingX, currentMarkerPaddingY);
                }
                Matrix matrix = this.mDrawMatrix;
                if (matrix != null) {
                    canvas.concat(matrix);
                }
                this.mMarker.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        }

        int getCurrentMarkerPaddingX() {
            return this.mMarkerPaddingX + this.mMarkerPaddingXOffset;
        }

        int getCurrentMarkerPaddingY() {
            return this.mMarkerPaddingY + this.mMarkerPaddingYOffset;
        }

        int getMarkerHeight() {
            int i3 = this.mMarkerHeight;
            return i3 > 0 ? i3 : this.mMarker.getIntrinsicHeight();
        }

        int getMarkerWidth() {
            int i3 = this.mMarkerWidth;
            return i3 > 0 ? i3 : this.mMarker.getIntrinsicWidth();
        }

        boolean isMarkerAvailable() {
            return isMarkerVisible() && this.mMarker != null;
        }

        boolean isMarkerTouched(MotionEvent motionEvent) {
            if (!isMarkerAvailable() || this.mMarkerClickListener == null) {
                return false;
            }
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int currentMarkerPaddingX = getCurrentMarkerPaddingX();
            int markerWidth = getMarkerWidth() + currentMarkerPaddingX;
            int currentMarkerPaddingY = getCurrentMarkerPaddingY();
            return x16 >= currentMarkerPaddingX && x16 <= markerWidth && y16 >= currentMarkerPaddingY && y16 <= getMarkerHeight() + currentMarkerPaddingY;
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public boolean isMarkerVisible() {
            return this.mMarkerVisible || (this.mMarkerVisibleWhenSelected && this.mView.isSelected());
        }

        void notifyMarkerClick() {
            OnMarkerClickListener onMarkerClickListener = this.mMarkerClickListener;
            if (onMarkerClickListener != null) {
                Markable markable = this.mMarkerClickListenerCallback;
                if (markable == null) {
                    markable = this;
                }
                onMarkerClickListener.onClick(markable);
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (isMarkerTouched(motionEvent)) {
                if (action == 0) {
                    this.mMarkerPressed = true;
                    return true;
                }
                if (action == 1 && this.mMarkerPressed) {
                    notifyMarkerClick();
                    this.mMarkerPressed = false;
                    return true;
                }
            }
            if (action == 1 || action == 3) {
                this.mMarkerPressed = false;
            }
            return false;
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarker(Drawable drawable) {
            if (this.mMarker == drawable) {
                return;
            }
            this.mMarker = drawable;
            this.mMarkerOrPositionChanged = true;
            this.mView.invalidate();
        }

        protected void setMarkerClickListenerCallback(Markable markable) {
            this.mMarkerClickListenerCallback = markable;
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerPaddingOffset(int i3, int i16) {
            if (this.mMarkerPaddingXOffset == i3 && this.mMarkerPaddingYOffset == i16) {
                return;
            }
            this.mMarkerPaddingXOffset = i3;
            this.mMarkerPaddingYOffset = i16;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerPosition(int i3) {
            if (this.mMarkerPosition == i3) {
                return;
            }
            this.mMarkerPosition = i3;
            this.mMarkerOrPositionChanged = true;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerScaleType(int i3) {
            if (this.mMarkerScaleType == i3 || i3 < 1 || i3 > 8) {
                return;
            }
            this.mMarkerScaleType = i3;
            this.mMarkerOrPositionChanged = true;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerSize(int i3, int i16) {
            if (this.mMarkerWidth == i3 && this.mMarkerHeight == i16) {
                return;
            }
            this.mMarkerWidth = i3;
            this.mMarkerHeight = i16;
            this.mMarkerOrPositionChanged = true;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerVisible(boolean z16) {
            if (this.mMarkerVisible == z16) {
                return;
            }
            this.mMarkerVisible = z16;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerVisibleWhenSelected(boolean z16) {
            if (this.mMarkerVisibleWhenSelected == z16) {
                return;
            }
            this.mMarkerVisibleWhenSelected = z16;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
            this.mMarkerClickListener = onMarkerClickListener;
        }

        void updateDrawMatrix() {
            Drawable drawable;
            float f16;
            float f17;
            if (this.mView == null || (drawable = this.mMarker) == null) {
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.mMarker.getIntrinsicHeight();
            int markerWidth = getMarkerWidth();
            int markerHeight = getMarkerHeight();
            if (markerWidth <= 0 || markerHeight <= 0 || markerWidth > this.mView.getWidth() || markerHeight > this.mView.getHeight()) {
                markerWidth = this.mView.getWidth();
                markerHeight = this.mView.getHeight();
            }
            boolean z16 = (intrinsicWidth < 0 || markerWidth == intrinsicWidth) && (intrinsicHeight < 0 || markerHeight == intrinsicHeight);
            if (intrinsicWidth > 0 && intrinsicHeight > 0 && 7 != this.mMarkerScaleType) {
                this.mMarker.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                int i3 = this.mMarkerScaleType;
                if (8 == i3) {
                    if (this.mMatrix.isIdentity()) {
                        this.mDrawMatrix = null;
                        return;
                    } else {
                        this.mDrawMatrix = this.mMatrix;
                        return;
                    }
                }
                if (z16) {
                    this.mDrawMatrix = null;
                    return;
                }
                if (1 == i3) {
                    Matrix matrix = this.mMatrix;
                    this.mDrawMatrix = matrix;
                    matrix.setTranslate((int) (((markerWidth - intrinsicWidth) * 0.5f) + 0.5f), (int) (((markerHeight - intrinsicHeight) * 0.5f) + 0.5f));
                    return;
                }
                float f18 = 0.0f;
                if (2 != i3) {
                    if (3 == i3) {
                        this.mDrawMatrix = this.mMatrix;
                        float min = (intrinsicWidth > markerWidth || intrinsicHeight > markerHeight) ? Math.min(markerWidth / intrinsicWidth, markerHeight / intrinsicHeight) : 1.0f;
                        this.mDrawMatrix.setScale(min, min);
                        this.mDrawMatrix.postTranslate((int) (((markerWidth - (intrinsicWidth * min)) * 0.5f) + 0.5f), (int) (((markerHeight - (intrinsicHeight * min)) * 0.5f) + 0.5f));
                        return;
                    }
                    this.mTempSrc.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                    this.mTempDst.set(0.0f, 0.0f, markerWidth, markerHeight);
                    Matrix matrix2 = this.mMatrix;
                    this.mDrawMatrix = matrix2;
                    matrix2.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mMarkerScaleType));
                    return;
                }
                Matrix matrix3 = this.mMatrix;
                this.mDrawMatrix = matrix3;
                if (intrinsicWidth * markerHeight > markerWidth * intrinsicHeight) {
                    f17 = markerHeight / intrinsicHeight;
                    float f19 = (markerWidth - (intrinsicWidth * f17)) * 0.5f;
                    f16 = 0.0f;
                    f18 = f19;
                } else {
                    float f26 = markerWidth / intrinsicWidth;
                    f16 = (markerHeight - (intrinsicHeight * f26)) * 0.5f;
                    f17 = f26;
                }
                matrix3.setScale(f17, f17);
                this.mDrawMatrix.postTranslate((int) (f18 + 0.5f), (int) (f16 + 0.5f));
                return;
            }
            this.mMarker.setBounds(0, 0, markerWidth, markerHeight);
            this.mDrawMatrix = null;
        }

        public void updateMarkerLayout() {
            if (this.mMarker == null) {
                return;
            }
            int width = this.mView.getWidth();
            int height = this.mView.getHeight();
            int markerWidth = getMarkerWidth();
            int markerHeight = getMarkerHeight();
            if ((markerWidth > width || markerHeight > height) && this.mMarkerScaleType != 0) {
                this.mMarkerPaddingX = 0;
                this.mMarkerPaddingY = 0;
            } else {
                this.mMarkerPaddingX = getMarkerPaddingX(width, markerWidth, this.mMarkerPosition);
                this.mMarkerPaddingY = getMarkerPaddingY(height, markerHeight, this.mMarkerPosition);
            }
            if (this.mMarkerScaleType == 0) {
                this.mMarker.setBounds(0, 0, markerWidth, markerHeight);
            } else {
                updateDrawMatrix();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Marker(View view, AttributeSet attributeSet) {
            this.mMatrix = new Matrix();
            this.mTempSrc = new RectF();
            this.mTempDst = new RectF();
            this.mMarkerPosition = 1;
            this.mMarkerWidth = -1;
            this.mMarkerHeight = -1;
            this.mMarkerScaleType = 0;
            this.mView = view;
            this.mContext = view.getContext();
            if (view instanceof Markable) {
                setMarkerClickListenerCallback((Markable) view);
            }
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, (int[]) j.L(1645));
            Drawable drawable = obtainStyledAttributes.getDrawable(((Integer) j.L(1646)).intValue());
            boolean z16 = obtainStyledAttributes.getBoolean(((Integer) j.L(1654)).intValue(), false);
            boolean z17 = obtainStyledAttributes.getBoolean(((Integer) j.L(1647)).intValue(), false);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(((Integer) j.L(1648)).intValue(), -1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(((Integer) j.L(1649)).intValue(), -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(((Integer) j.L(1650)).intValue(), 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(((Integer) j.L(1651)).intValue(), 0);
            int i3 = obtainStyledAttributes.getInt(((Integer) j.L(1652)).intValue(), 1);
            int i16 = obtainStyledAttributes.getInt(((Integer) j.L(1653)).intValue(), 0);
            setMarker(drawable);
            setMarkerVisible(z16);
            setMarkerVisibleWhenSelected(z17);
            setMarkerSize(dimensionPixelSize, dimensionPixelSize2);
            setMarkerPaddingOffset(dimensionPixelOffset, dimensionPixelOffset2);
            setMarkerPosition(i3);
            setMarkerScaleType(i16);
            obtainStyledAttributes.recycle();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void getMarkerSize(int[] iArr) {
            int i3;
            int i16;
            if (iArr != null && iArr.length >= 2) {
                if (this.mMarker != null) {
                    i3 = getMarkerWidth();
                    i16 = getMarkerHeight();
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                iArr[0] = i3;
                iArr[1] = i16;
                return;
            }
            throw new IllegalArgumentException("location must be an array of two integers");
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarkerMatrix(Matrix matrix) {
            if (matrix != null && matrix.isIdentity()) {
                matrix = null;
            }
            if ((matrix != null || this.mMatrix.isIdentity()) && (matrix == null || this.mMatrix.equals(matrix))) {
                return;
            }
            this.mMatrix.set(matrix);
            this.mMarkerOrPositionChanged = true;
            this.mView.invalidate();
        }

        @Override // com.qzone.module.feedcomponent.view.Markable
        public void setMarker(int i3) {
            setMarker(this.mContext.getResources().getDrawable(i3));
        }

        Matrix.ScaleToFit scaleTypeToScaleToFit(int i3) {
            if (i3 == 4) {
                return Matrix.ScaleToFit.CENTER;
            }
            if (i3 == 5) {
                return Matrix.ScaleToFit.START;
            }
            if (i3 != 6) {
                return Matrix.ScaleToFit.CENTER;
            }
            return Matrix.ScaleToFit.END;
        }

        static int getMarkerPaddingX(int i3, int i16, int i17) {
            if (i17 == 2) {
                return 0;
            }
            if (i17 != 3 && i17 != 4) {
                if (i17 == 5) {
                    return 0;
                }
                if (i17 != 6) {
                    return (i3 - i16) / 2;
                }
            }
            return i3 - i16;
        }

        static int getMarkerPaddingY(int i3, int i16, int i17) {
            if (i17 == 2 || i17 == 3) {
                return 0;
            }
            if (i17 == 4 || i17 == 5) {
                return i3 - i16;
            }
            if (i17 != 6) {
                return (i3 - i16) / 2;
            }
            return (i3 - i16) / 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnMarkerClickListener {
        void onClick(Markable markable);
    }

    void getMarkerSize(int[] iArr);

    boolean isMarkerVisible();

    void setMarker(int i3);

    void setMarker(Drawable drawable);

    void setMarkerMatrix(Matrix matrix);

    void setMarkerPaddingOffset(int i3, int i16);

    void setMarkerPosition(int i3);

    void setMarkerScaleType(int i3);

    void setMarkerSize(int i3, int i16);

    void setMarkerVisible(boolean z16);

    void setMarkerVisibleWhenSelected(boolean z16);

    void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);
}
