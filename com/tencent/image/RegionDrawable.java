package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.tencent.image.RegionBitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RegionDrawable extends Drawable implements RegionBitmap.OnUpdateCallback {
    static IPatchRedirector $redirector_ = null;
    private static final int CACHED_RECT_SCALE = 5;
    private static final int DEFAULT_PAINT_FLAGS = 6;
    public static final String TAG = "RegionDrawable";
    private boolean mApplyGravity;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private final Rect mDstRect;
    private Handler mMainHandler;
    private boolean mMutated;
    private NinePatch mNinePatch;
    private RegionBitmap mRegionBitmap;
    private int mRegionDrawableState;
    private RegionState mRegionState;
    private int mScrollDirection;
    private boolean mShowRegion;
    private int mTargetDensity;
    private Rect mUpdateRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class RegionState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        boolean mAutoMirrored;
        Bitmap mBitmap;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        String mPath;
        boolean mRebuildShader;
        int mTargetDensity;
        Shader.TileMode mTileModeX;
        Shader.TileMode mTileModeY;

        RegionState(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
                return;
            }
            this.mGravity = 119;
            this.mPaint = new Paint(6);
            this.mTileModeX = null;
            this.mTileModeY = null;
            this.mTargetDensity = 160;
            this.mBitmap = bitmap;
        }

        public Bitmap getBitmap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mBitmap;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new RegionDrawable(this, null, this.mPath, 0 == true ? 1 : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new RegionDrawable(this, resources, this.mPath, null) : (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) resources);
        }

        RegionState(RegionState regionState) {
            this(regionState.mBitmap);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) regionState);
                return;
            }
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

    /* synthetic */ RegionDrawable(RegionState regionState, Resources resources, String str, AnonymousClass1 anonymousClass1) {
        this(regionState, resources, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            return;
        }
        iPatchRedirector.redirect((short) 39, this, regionState, resources, str, anonymousClass1);
    }

    private Rect calcCachedArea(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private void setBitmap(Bitmap bitmap) {
        if (bitmap != this.mBitmap) {
            this.mBitmap = bitmap;
            if (bitmap != null) {
                computeBitmapSize();
            } else {
                this.mBitmapHeight = -1;
                this.mBitmapWidth = -1;
            }
            invalidateSelf();
            byte[] ninePatchChunk = this.mBitmap.getNinePatchChunk();
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                this.mNinePatch = new NinePatch(this.mBitmap, ninePatchChunk, null);
            } else {
                this.mNinePatch = null;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RegionBitmap regionBitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) canvas);
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
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
                NinePatch ninePatch = this.mNinePatch;
                if (ninePatch != null) {
                    ninePatch.draw(canvas, this.mDstRect);
                } else if (bitmap.getByteCount() < 100000000) {
                    canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, regionState.mPaint);
                }
            } else {
                if (this.mApplyGravity) {
                    copyBounds(this.mDstRect);
                    this.mApplyGravity = false;
                }
                canvas.drawRect(this.mDstRect, regionState.mPaint);
            }
            if (this.mShowRegion && (regionBitmap = this.mRegionBitmap) != null) {
                regionBitmap.draw(canvas, regionState.mPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.mRegionState.mPaint.getAlpha();
    }

    public final Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return super.getChangingConfigurations() | this.mRegionState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        this.mRegionState.mChangingConfigurations = getChangingConfigurations();
        return this.mRegionState;
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mRegionState.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        if (this.mRegionState.mGravity != 119 || (bitmap = this.mBitmap) == null || bitmap.hasAlpha() || this.mRegionState.mPaint.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public final Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Paint) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mRegionState.mPaint;
    }

    public Shader.TileMode getTileModeX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Shader.TileMode) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mRegionState.mTileModeX;
    }

    public Shader.TileMode getTileModeY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Shader.TileMode) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mRegionState.mTileModeY;
    }

    public boolean hasAntiAlias() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mRegionState.mPaint.isAntiAlias();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, resources, xmlPullParser, attributeSet);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mRegionState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Drawable) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mRegionState = new RegionState(this.mRegionState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) rect);
        } else {
            super.onBoundsChange(rect);
            this.mApplyGravity = true;
        }
    }

    @Override // com.tencent.image.RegionBitmap.OnUpdateCallback
    public void regionRefreshed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidateSelf();
        } else {
            Handler handler = this.mMainHandler;
            handler.sendMessage(handler.obtainMessage(0));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else if (i3 != this.mRegionState.mPaint.getAlpha()) {
            this.mRegionState.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mRegionState.mPaint.setAntiAlias(z16);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        RegionState regionState = this.mRegionState;
        if (regionState.mAutoMirrored != z16) {
            regionState.mAutoMirrored = z16;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) colorFilter);
        } else {
            this.mRegionState.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mRegionState.mPaint.setDither(z16);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mRegionState.mPaint.setFilterBitmap(z16);
            invalidateSelf();
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        RegionState regionState = this.mRegionState;
        if (regionState.mGravity != i3) {
            regionState.mGravity = i3;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            setTargetDensity(canvas.getDensity());
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) tileMode);
        } else {
            setTileModeXY(tileMode, this.mRegionState.mTileModeY);
        }
    }

    public void setTileModeXY(Shader.TileMode tileMode, Shader.TileMode tileMode2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) tileMode, (Object) tileMode2);
            return;
        }
        RegionState regionState = this.mRegionState;
        if (regionState.mTileModeX != tileMode || regionState.mTileModeY != tileMode2) {
            regionState.mTileModeX = tileMode;
            regionState.mTileModeY = tileMode2;
            regionState.mRebuildShader = true;
            invalidateSelf();
        }
    }

    public final void setTileModeY(Shader.TileMode tileMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) tileMode);
        } else {
            setTileModeXY(this.mRegionState.mTileModeX, tileMode);
        }
    }

    public void setXfermode(Xfermode xfermode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) xfermode);
        } else {
            this.mRegionState.mPaint.setXfermode(xfermode);
            invalidateSelf();
        }
    }

    public void updateRegionRect(RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) regionDrawableData);
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
        Rect calcCachedArea = calcCachedArea(regionDrawableData.mImageArea, regionDrawableData.mShowArea);
        if (calcCachedArea.equals(this.mUpdateRect) && this.mRegionDrawableState == regionDrawableData.mState) {
            return;
        }
        this.mUpdateRect.set(calcCachedArea);
        regionDrawableData.mShowArea.set(calcCachedArea);
        regionDrawableData.mTargetDensity = this.mTargetDensity;
        regionDrawableData.mSourceDensity = getBitmap().getDensity();
        this.mRegionDrawableState = regionDrawableData.mState;
        this.mRegionBitmap.updateRegionBitmap(regionDrawableData);
    }

    @Deprecated
    public RegionDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDstRect = new Rect();
        this.mUpdateRect = new Rect();
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.image.RegionDrawable.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegionDrawable.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                } else {
                    RegionDrawable.this.invalidateSelf();
                }
            }
        };
        this.mRegionState = new RegionState((Bitmap) null);
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            setTargetDensity(displayMetrics.densityDpi);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) displayMetrics);
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (this.mTargetDensity != i3) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    @Deprecated
    public RegionDrawable(Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources);
            return;
        }
        this.mDstRect = new Rect();
        this.mUpdateRect = new Rect();
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.image.RegionDrawable.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegionDrawable.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                } else {
                    RegionDrawable.this.invalidateSelf();
                }
            }
        };
        RegionState regionState = new RegionState((Bitmap) null);
        this.mRegionState = regionState;
        regionState.mTargetDensity = this.mTargetDensity;
    }

    @Deprecated
    public RegionDrawable(Bitmap bitmap) {
        this(new RegionState(bitmap), (Resources) null, (String) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
    }

    public RegionDrawable(Resources resources, Bitmap bitmap, String str) {
        this(new RegionState(bitmap), resources, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, resources, bitmap, str);
        } else {
            this.mRegionState.mTargetDensity = this.mTargetDensity;
        }
    }

    RegionDrawable(RegionState regionState, Resources resources, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, regionState, resources, str);
            return;
        }
        this.mDstRect = new Rect();
        this.mUpdateRect = new Rect();
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.image.RegionDrawable.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegionDrawable.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                } else {
                    RegionDrawable.this.invalidateSelf();
                }
            }
        };
        this.mRegionState = regionState;
        if (str != regionState.mPath) {
            regionState.mPath = str;
        }
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = regionState.mTargetDensity;
        }
        setBitmap(regionState.mBitmap);
        RegionBitmap regionBitmap = new RegionBitmap(str);
        regionBitmap.setOnUpdateCallback(this);
        this.mRegionBitmap = regionBitmap;
    }
}
