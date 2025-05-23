package com.tencent.component.media.image.region;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.region.RegionBitmapDecoder;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RegionDrawable extends Drawable implements RegionBitmapDecoder.OnUpdateCallback {
    private static final int DEFAULT_PAINT_FLAGS = 6;
    public static final String TAG = "RegionDrawable";
    private boolean mApplyGravity;
    private BitmapReference mBitmap;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private final Rect mDstRect;
    private Matrix mExifMatrix;
    private String mImagePath;
    private Handler mMainHandler;
    private boolean mMutated;
    private RegionBitmapDecoder mRegionBitmapDecoder;
    private int mRegionDrawableState;
    private RegionState mRegionState;
    private int mScrollDirection;
    private boolean mShowRegion;
    private int mTargetDensity;
    private Rect mUpdateRect;
    private int orgHeight;
    private int orgWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RegionState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        BitmapReference mBitmap;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        String mPath;
        boolean mRebuildShader;
        int mTargetDensity;
        Shader.TileMode mTileModeX;
        Shader.TileMode mTileModeY;

        RegionState(BitmapReference bitmapReference) {
            this.mGravity = 119;
            this.mPaint = new Paint(6);
            this.mTileModeX = null;
            this.mTileModeY = null;
            this.mTargetDensity = 160;
            this.mBitmap = bitmapReference;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new RegionDrawable(this, null, this.mPath);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new RegionDrawable(this, resources, this.mPath);
        }

        RegionState(RegionState regionState) {
            this(regionState.mBitmap);
            this.mChangingConfigurations = regionState.mChangingConfigurations;
            this.mGravity = regionState.mGravity;
            this.mTileModeX = regionState.mTileModeX;
            this.mTileModeY = regionState.mTileModeY;
            this.mTargetDensity = regionState.mTargetDensity;
            this.mPaint = new Paint(regionState.mPaint);
            this.mRebuildShader = regionState.mRebuildShader;
            this.mAutoMirrored = regionState.mAutoMirrored;
        }
    }

    private void computeBitmapSize() {
        Bitmap bitmap = this.mBitmap.getBitmap();
        if (bitmap == null) {
            this.mBitmapWidth = -1;
            this.mBitmapHeight = -1;
        } else {
            this.mBitmapWidth = bitmap.getScaledWidth(this.mTargetDensity);
            this.mBitmapHeight = bitmap.getScaledHeight(this.mTargetDensity);
        }
    }

    private void initMatrix() {
        if (this.mExifMatrix == null) {
            this.mExifMatrix = new Matrix();
            Rect bounds = getBounds();
            int width = bounds.width();
            int height = bounds.height();
            int rotation = RegionImageUtil.getRotation(this.mImagePath);
            if (rotation != -270) {
                if (rotation != -180) {
                    if (rotation != -90) {
                        if (rotation != 90) {
                            if (rotation != 180) {
                                if (rotation != 270) {
                                    ImageManagerLog.e("RegionDrawable", "initMatrix rotation = " + rotation);
                                    this.mExifMatrix = null;
                                    return;
                                }
                            }
                        }
                    }
                    this.mExifMatrix.postRotate(270.0f);
                    this.mExifMatrix.postTranslate(0.0f, height);
                    return;
                }
                this.mExifMatrix.postRotate(180.0f);
                this.mExifMatrix.postTranslate(width, height);
                return;
            }
            this.mExifMatrix.postRotate(90.0f);
            this.mExifMatrix.postTranslate(width, 0.0f);
        }
    }

    private void processExif(String str) {
        boolean z16;
        int i3;
        int i16;
        if (this.orgWidth != 0 && this.orgHeight != 0) {
            int rotation = RegionImageUtil.getRotation(str);
            if ((rotation > 45 && rotation < 135) || (rotation > 225 && rotation < 315)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = this.orgWidth;
            } else {
                i3 = this.orgHeight;
            }
            if (!z16) {
                i16 = this.orgHeight;
            } else {
                i16 = this.orgWidth;
            }
            this.orgWidth = i3;
            this.orgHeight = i16;
        }
    }

    private void setBitmap(BitmapReference bitmapReference) {
        if (bitmapReference != this.mBitmap) {
            this.mBitmap = bitmapReference;
            if (bitmapReference != null) {
                computeBitmapSize();
            } else {
                this.mBitmapHeight = -1;
                this.mBitmapWidth = -1;
            }
            invalidateSelf();
        }
    }

    private void setOrgSize(int i3, int i16) {
        this.orgWidth = i3;
        this.orgHeight = i16;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        BitmapReference bitmapReference = this.mBitmap;
        if (bitmapReference == null) {
            return;
        }
        Bitmap bitmap = bitmapReference.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            RegionState regionState = this.mRegionState;
            if (regionState.mRebuildShader) {
                Shader.TileMode tileMode = regionState.mTileModeX;
                Shader.TileMode tileMode2 = regionState.mTileModeY;
                if (tileMode == null && tileMode2 == null) {
                    regionState.mPaint.setShader(null);
                } else {
                    Paint paint = regionState.mPaint;
                    if (tileMode == null) {
                        tileMode = Shader.TileMode.CLAMP;
                    }
                    if (tileMode2 == null) {
                        tileMode2 = Shader.TileMode.CLAMP;
                    }
                    paint.setShader(new BitmapShader(bitmap, tileMode, tileMode2));
                }
                regionState.mRebuildShader = false;
                copyBounds(this.mDstRect);
            }
            if (regionState.mPaint.getShader() == null) {
                if (this.mApplyGravity) {
                    Gravity.apply(regionState.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
                    this.mApplyGravity = false;
                }
                canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, regionState.mPaint);
            } else {
                if (this.mApplyGravity) {
                    copyBounds(this.mDstRect);
                    this.mApplyGravity = false;
                }
                canvas.drawRect(this.mDstRect, regionState.mPaint);
            }
            if (this.mShowRegion && this.mRegionBitmapDecoder != null) {
                Matrix matrix = this.mExifMatrix;
                if (matrix != null) {
                    canvas.concat(matrix);
                }
                this.mRegionBitmapDecoder.draw(canvas, regionState.mPaint);
                return;
            }
            return;
        }
        RegionState regionState2 = this.mRegionState;
        if (regionState2 != null && regionState2.mBitmap != null) {
            ImageManagerLog.e("RegionDrawable", "region drawable draw bitmap.isRecycled mRegionState.bitmap = " + this.mRegionState.mBitmap.isRecycled());
            return;
        }
        ImageManagerLog.e("RegionDrawable", "region drawable draw bitmap.isRecycled ");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRegionState.mPaint.getAlpha();
    }

    public BitmapReference getBitmapRef() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mRegionState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        this.mRegionState.mChangingConfigurations = getChangingConfigurations();
        return this.mRegionState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i3 = this.orgHeight;
        if (i3 != 0 && i3 >= this.mBitmap.getHeight()) {
            return this.orgHeight;
        }
        return this.mBitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i3 = this.orgWidth;
        if (i3 != 0 && i3 >= this.mBitmap.getWidth()) {
            return this.orgWidth;
        }
        return this.mBitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        BitmapReference bitmapReference;
        Bitmap bitmap;
        if (this.mRegionState.mGravity != 119 || (bitmapReference = this.mBitmap) == null || (bitmap = bitmapReference.getBitmap()) == null || bitmap.hasAlpha() || this.mRegionState.mPaint.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public int getOrgHeight() {
        return this.orgHeight;
    }

    public int getOrgWidth() {
        return this.orgWidth;
    }

    public void initRegionDrawable(int i3, int i16) {
        setOrgSize(i3, i16);
        processExif(this.mImagePath);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mRegionState = new RegionState(this.mRegionState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        initMatrix();
        this.mApplyGravity = true;
    }

    public void onRecycle() {
        RegionBitmapDecoder regionBitmapDecoder = this.mRegionBitmapDecoder;
        if (regionBitmapDecoder != null) {
            regionBitmapDecoder.recycle();
        }
    }

    @Override // com.tencent.component.media.image.region.RegionBitmapDecoder.OnUpdateCallback
    public void regionRefreshed() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidateSelf();
        } else {
            Handler handler = this.mMainHandler;
            handler.sendMessage(handler.obtainMessage(0));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.mRegionState.mPaint.getAlpha()) {
            this.mRegionState.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRegionState.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void updateRegionRect(RegionDrawableData regionDrawableData) {
        if (!RegionImageUtil.isNeedPieceLoad(this.orgWidth, this.orgHeight)) {
            return;
        }
        boolean z16 = regionDrawableData.mShowRegion;
        if (z16 != this.mShowRegion) {
            if (!z16) {
                this.mUpdateRect.setEmpty();
            }
            this.mShowRegion = regionDrawableData.mShowRegion;
            invalidateSelf();
        }
        if (!regionDrawableData.mShowRegion) {
            return;
        }
        regionDrawableData.mTargetDensity = this.mTargetDensity;
        this.mRegionDrawableState = regionDrawableData.mState;
        this.mRegionBitmapDecoder.updateRegionBitmap(regionDrawableData);
    }

    public RegionDrawable(Resources resources, BitmapReference bitmapReference, String str) {
        this(new RegionState(bitmapReference), resources, str);
        this.mRegionState.mTargetDensity = this.mTargetDensity;
    }

    RegionDrawable(RegionState regionState, Resources resources, String str) {
        this.mDstRect = new Rect();
        this.mUpdateRect = new Rect();
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.component.media.image.region.RegionDrawable.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                RegionDrawable.this.invalidateSelf();
            }
        };
        this.mRegionState = regionState;
        this.mImagePath = str;
        if (str != regionState.mPath) {
            regionState.mPath = str;
        }
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = regionState.mTargetDensity;
        }
        setBitmap(regionState != null ? regionState.mBitmap : null);
        RegionBitmapDecoder regionBitmapDecoder = new RegionBitmapDecoder(str);
        regionBitmapDecoder.setOnUpdateCallback(this);
        this.mRegionBitmapDecoder = regionBitmapDecoder;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
    }
}
