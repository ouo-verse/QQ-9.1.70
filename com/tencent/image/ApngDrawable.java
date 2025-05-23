package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApngDrawable extends Drawable implements AnimationCallback {
    static IPatchRedirector $redirector_ = null;
    private static final byte[] SIGNATURE;
    private static final String TAG = "ApngImage_able";
    private int chatWindowHeight;
    private Rect drawRect;
    private int mApngHeight;
    private ApngState mApngState;
    private int mApngWidth;
    private final Rect mDstRect;
    private int mTargetDensity;
    boolean mUseAnimation;
    private boolean reCalculateRects;
    private boolean useRect;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ApngState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        ApngImage mApng;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        int mTargetDensity;

        public ApngState(ApngImage apngImage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) apngImage);
                return;
            }
            this.mGravity = 119;
            this.mTargetDensity = 160;
            this.mPaint = new Paint(6);
            this.mApng = apngImage;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ApngDrawable(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new ApngDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnPlayRepeatListener {
        void onPlayRepeat(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7151);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        }
    }

    public ApngDrawable(File file, Resources resources) throws IOException {
        this(file, resources, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) resources);
    }

    private void computeImageSize() {
        this.mApngWidth = this.mApngState.mApng.getScaledWidth(this.mTargetDensity);
        this.mApngHeight = this.mApngState.mApng.getScaledHeight(this.mTargetDensity);
    }

    public static boolean isApngFile(File file) throws IOException {
        if (file == null) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[SIGNATURE.length];
        try {
            randomAccessFile.read(bArr);
            randomAccessFile.close();
            int i3 = 0;
            while (true) {
                byte[] bArr2 = SIGNATURE;
                if (i3 < bArr2.length) {
                    if (bArr[i3] != bArr2[i3]) {
                        return false;
                    }
                    i3++;
                } else {
                    return true;
                }
            }
        } catch (Throwable th5) {
            randomAccessFile.close();
            throw th5;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        QLog.isColorLevel();
        Rect rect = null;
        if (this.reCalculateRects) {
            if (this.useRect) {
                ApngImage apngImage = this.mApngState.mApng;
                int i3 = apngImage.width;
                int i16 = apngImage.height;
                if (i16 > 0 && i3 > 0) {
                    Rect bounds = getBounds();
                    int height = bounds.height();
                    int width = bounds.width();
                    if (width == 0) {
                        this.drawRect = null;
                    } else {
                        if (this.chatWindowHeight < height) {
                            this.chatWindowHeight = height;
                        }
                        int i17 = this.chatWindowHeight;
                        if (i17 / width >= i16 / i3) {
                            int i18 = (width * i16) / i17;
                            int i19 = (int) ((i3 - i18) * 0.5d);
                            if (i17 > bounds.height()) {
                                i16 = (i16 * height) / this.chatWindowHeight;
                            }
                            this.drawRect = new Rect(i19, 0, i18 + i19, i16);
                        } else {
                            int i26 = (int) ((i16 - ((i17 * i3) / width)) * 0.5d);
                            this.drawRect = new Rect(0, i26, i3, ((height * i3) / width) + i26);
                        }
                    }
                } else {
                    this.drawRect = null;
                }
            }
            Gravity.apply(this.mApngState.mGravity, this.mApngWidth, this.mApngHeight, getBounds(), this.mDstRect);
            this.reCalculateRects = false;
        }
        ApngState apngState = this.mApngState;
        ApngImage apngImage2 = apngState.mApng;
        if (this.useRect) {
            rect = this.drawRect;
        }
        apngImage2.draw(canvas, rect, this.mDstRect, apngState.mPaint, this.mUseAnimation);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mApngState;
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mApngState.mGravity;
    }

    public ApngImage getImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ApngImage) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mApngState.mApng;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mApngHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mApngWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.image.AnimationCallback
    public void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rect);
            return;
        }
        super.onBoundsChange(rect);
        this.reCalculateRects = true;
        this.chatWindowHeight = 0;
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        ApngImage image = getImage();
        if (image != null) {
            image.pause();
        }
    }

    public void pauseIfNoReferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ApngImage image = getImage();
        if (image != null) {
            image.pauseIfNoReferences();
        }
    }

    public void removeOnPlayRepeatListener(OnPlayRepeatListener onPlayRepeatListener) {
        ApngImage apngImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        ApngState apngState = this.mApngState;
        if (apngState != null && (apngImage = apngState.mApng) != null) {
            apngImage.removeOnPlayRepeatListener(onPlayRepeatListener);
        }
    }

    public void repaly() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ApngImage image = getImage();
        if (image != null) {
            image.replay();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ApngImage image = getImage();
        if (image != null) {
            image.resume();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mApngState.mPaint.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) colorFilter);
        } else {
            this.mApngState.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.mApngState.mPaint.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.mApngState.mPaint.setFilterBitmap(z16);
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mApngState.mGravity = i3;
            this.reCalculateRects = true;
        }
    }

    public void setOnPlayRepeatListener(OnPlayRepeatListener onPlayRepeatListener) {
        ApngImage apngImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        ApngState apngState = this.mApngState;
        if (apngState != null && (apngImage = apngState.mApng) != null) {
            apngImage.setOnPlayRepeatListener(onPlayRepeatListener);
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
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

    public void setUseRect(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, obj);
        } else if (obj != null) {
            this.useRect = ((Bundle) obj).getBoolean("key_use_rect", false);
            this.reCalculateRects = true;
        }
    }

    public ApngDrawable(File file, Resources resources, boolean z16) throws IOException {
        this(new ApngImage(file, z16), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, file, resources, Boolean.valueOf(z16));
    }

    public ApngDrawable(ApngImage apngImage) {
        this(apngImage, (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) apngImage);
    }

    public ApngDrawable(ApngImage apngImage, Resources resources) {
        this(new ApngState(apngImage), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) apngImage, (Object) resources);
        } else {
            this.mApngState.mTargetDensity = this.mTargetDensity;
        }
    }

    public ApngDrawable(ApngState apngState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) apngState, (Object) resources);
            return;
        }
        this.mDstRect = new Rect();
        this.mUseAnimation = true;
        this.reCalculateRects = true;
        this.mTargetDensity = 160;
        this.mApngState = apngState;
        apngState.mApng.addCallBack(this);
        ApngImage apngImage = apngState.mApng;
        if (apngImage.mGetResetLoop) {
            apngImage.currentApngLoop = 0;
        }
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = apngState.mTargetDensity;
        }
        computeImageSize();
    }
}
