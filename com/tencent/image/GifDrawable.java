package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifDrawable extends Drawable implements AnimationCallback {
    static IPatchRedirector $redirector_;
    private boolean mApplyGravity;
    private final Rect mDstRect;
    private int mGifHeight;
    private GifState mGifState;
    private int mGifWidth;
    private int mTargetDensity;
    boolean mUseAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class GifState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        int mChangingConfigurations;
        AbstractGifImage mGif;
        int mGravity;
        Paint mPaint;
        int mTargetDensity;
        boolean stickerPause;

        public GifState(AbstractGifImage abstractGifImage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractGifImage);
                return;
            }
            this.mGravity = 119;
            this.mTargetDensity = 160;
            this.mPaint = new Paint(6);
            this.stickerPause = false;
            this.mGif = abstractGifImage;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new GifDrawable(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public void setStickerPause(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.stickerPause = z16;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? new GifDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 6, (Object) this, (Object) resources);
        }

        public GifState(GifState gifState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gifState);
                return;
            }
            this.mGravity = 119;
            this.mTargetDensity = 160;
            this.mPaint = new Paint(6);
            this.stickerPause = false;
            this.mGif = gifState.mGif;
            this.mChangingConfigurations = gifState.mChangingConfigurations;
            this.mGravity = gifState.mGravity;
            this.mTargetDensity = gifState.mTargetDensity;
            this.mPaint = new Paint(6);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnGIFPlayOnceListener {
        void onPlayOnce();
    }

    public GifDrawable(File file, Resources resources) throws IOException {
        this(file, resources, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) resources);
    }

    private void computeImageSize() {
        this.mGifWidth = this.mGifState.mGif.getScaledWidth(this.mTargetDensity);
        this.mGifHeight = this.mGifState.mGif.getScaledHeight(this.mTargetDensity);
    }

    public static boolean isGifFile(File file) {
        RandomAccessFile randomAccessFile;
        if (file != null && file.exists()) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                byte[] bArr = new byte[3];
                randomAccessFile.read(bArr);
                if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
                    randomAccessFile.close();
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused3) {
                }
                return false;
            } catch (Exception unused4) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused5) {
                    }
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        if (this.mApplyGravity) {
            Gravity.apply(this.mGifState.mGravity, this.mGifWidth, this.mGifHeight, getBounds(), this.mDstRect);
            this.mApplyGravity = false;
        }
        GifState gifState = this.mGifState;
        AbstractGifImage abstractGifImage = gifState.mGif;
        if ((abstractGifImage instanceof NativeGifImage) && gifState.stickerPause) {
            ((NativeGifImage) abstractGifImage).drawFirstFrame(canvas, this.mDstRect, gifState.mPaint);
        } else {
            abstractGifImage.draw(canvas, this.mDstRect, gifState.mPaint, this.mUseAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getByteSize() {
        AbstractGifImage abstractGifImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        GifState gifState = this.mGifState;
        if (gifState != null && (abstractGifImage = gifState.mGif) != null) {
            return abstractGifImage.getByteSize();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mGifState;
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mGifState.mGravity;
    }

    public AbstractGifImage getImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AbstractGifImage) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mGifState.mGif;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mGifHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mGifWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.image.AnimationCallback
    public void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Drawable) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        this.mGifState = new GifState(this.mGifState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rect);
        } else {
            super.onBoundsChange(rect);
            this.mApplyGravity = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mGifState.mPaint.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) colorFilter);
        } else {
            this.mGifState.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.mGifState.mPaint.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mGifState.mPaint.setFilterBitmap(z16);
        }
    }

    public void setGIFPlayOnceListener(OnGIFPlayOnceListener onGIFPlayOnceListener) {
        AbstractGifImage abstractGifImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) onGIFPlayOnceListener);
            return;
        }
        GifState gifState = this.mGifState;
        if (gifState != null && (abstractGifImage = gifState.mGif) != null) {
            abstractGifImage.setGIFPlayOnceListener(onGIFPlayOnceListener);
        }
    }

    public void setGifRefreshDelay(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mGifState.mGif.mRefreshDelay = i3;
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mGifState.mGravity = i3;
            this.mApplyGravity = true;
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        if (i3 != this.mTargetDensity) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            computeImageSize();
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean useAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.mUseAnimation;
    }

    public GifDrawable(File file, Resources resources, boolean z16) throws IOException {
        this(NativeGifFactory.getNativeGifObject(file, z16), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, file, resources, Boolean.valueOf(z16));
    }

    public GifDrawable(AbstractGifImage abstractGifImage) {
        this(abstractGifImage, (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractGifImage);
    }

    public GifDrawable(AbstractGifImage abstractGifImage, Resources resources) {
        this(new GifState(abstractGifImage), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractGifImage, (Object) resources);
        } else {
            this.mGifState.mTargetDensity = this.mTargetDensity;
        }
    }

    public GifDrawable(GifState gifState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gifState, (Object) resources);
            return;
        }
        this.mTargetDensity = 160;
        this.mUseAnimation = true;
        this.mDstRect = new Rect();
        this.mGifState = gifState;
        gifState.mGif.attachDrawable(this);
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = gifState.mTargetDensity;
        }
        computeImageSize();
    }
}
