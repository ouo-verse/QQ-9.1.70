package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* compiled from: P */
/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private float mCrossfade;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ImageMatrix {

        /* renamed from: m, reason: collision with root package name */
        float[] f26469m = new float[20];
        ColorMatrix mColorMatrix = new ColorMatrix();
        ColorMatrix mTmpColorMatrix = new ColorMatrix();
        float mBrightness = 1.0f;
        float mSaturation = 1.0f;
        float mContrast = 1.0f;
        float mWarmth = 1.0f;

        private void brightness(float f16) {
            float[] fArr = this.f26469m;
            fArr[0] = f16;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f16;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f16;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void saturation(float f16) {
            float f17 = 1.0f - f16;
            float f18 = 0.2999f * f17;
            float f19 = 0.587f * f17;
            float f26 = f17 * 0.114f;
            float[] fArr = this.f26469m;
            fArr[0] = f18 + f16;
            fArr[1] = f19;
            fArr[2] = f26;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f18;
            fArr[6] = f19 + f16;
            fArr[7] = f26;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f18;
            fArr[11] = f19;
            fArr[12] = f26 + f16;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void warmth(float f16) {
            float log;
            float f17;
            float f18;
            if (f16 <= 0.0f) {
                f16 = 0.01f;
            }
            float f19 = (5000.0f / f16) / 100.0f;
            if (f19 > 66.0f) {
                double d16 = f19 - 60.0f;
                f17 = ((float) Math.pow(d16, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d16, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f19)) * 99.4708f) - 161.11957f;
                f17 = 255.0f;
            }
            if (f19 < 66.0f) {
                if (f19 > 19.0f) {
                    f18 = (((float) Math.log(f19 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f18 = 0.0f;
                }
            } else {
                f18 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f17, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f18, 0.0f));
            float log2 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log3 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log2, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max(log3, 0.0f));
            float[] fArr = this.f26469m;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void updateMatrix(ImageView imageView) {
            boolean z16;
            this.mColorMatrix.reset();
            float f16 = this.mSaturation;
            boolean z17 = true;
            if (f16 != 1.0f) {
                saturation(f16);
                this.mColorMatrix.set(this.f26469m);
                z16 = true;
            } else {
                z16 = false;
            }
            float f17 = this.mContrast;
            if (f17 != 1.0f) {
                this.mTmpColorMatrix.setScale(f17, f17, f17, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z16 = true;
            }
            float f18 = this.mWarmth;
            if (f18 != 1.0f) {
                warmth(f18);
                this.mTmpColorMatrix.set(this.f26469m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z16 = true;
            }
            float f19 = this.mBrightness;
            if (f19 != 1.0f) {
                brightness(f19);
                this.mTmpColorMatrix.set(this.f26469m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            } else {
                z17 = z16;
            }
            if (z17) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.mLayers = drawableArr;
                drawableArr[0] = getDrawable();
                this.mLayers[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
                this.mLayer = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    private void setOverlay(boolean z16) {
        this.mOverlay = z16;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setBrightness(float f16) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mBrightness = f16;
        imageMatrix.updateMatrix(this);
    }

    public void setContrast(float f16) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mContrast = f16;
        imageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f16) {
        this.mCrossfade = f16;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    @RequiresApi(21)
    public void setRound(float f16) {
        boolean z16;
        if (Float.isNaN(f16)) {
            this.mRound = f16;
            float f17 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f17);
            return;
        }
        if (this.mRound != f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mRound = f16;
        if (f16 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
                    }
                };
                this.mViewOutlineProvider = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f18 = this.mRound;
            path.addRoundRect(rectF, f18, f18, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z16) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f16) {
        boolean z16;
        if (this.mRoundPercent != f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mRoundPercent = f16;
        if (f16 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.mRoundPercent) / 2.0f);
                    }
                };
                this.mViewOutlineProvider = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z16) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f16) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mSaturation = f16;
        imageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f16) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mWarmth = f16;
        imageMatrix.updateMatrix(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attributeSet);
    }
}
