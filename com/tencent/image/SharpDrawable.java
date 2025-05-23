package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import com.tencent.image.sharp.SharpImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SharpDrawable extends Drawable implements AnimationCallback {
    static IPatchRedirector $redirector_ = null;
    public static final byte[] SHARPP_PRECODE;
    private static final String TAG = "SharpImage_able";
    private int chatWindowHeight;
    private long drawCounts;
    private Rect drawRect;
    private OnFreshListener freshListener;
    private int mApngHeight;
    private int mApngWidth;
    private final Rect mDstRect;
    private SharpState mSharpState;
    private int mTargetDensity;
    boolean mUseAnimation;
    private boolean reCalculateRects;
    private boolean useRect;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnFreshListener {
        void decodeFrame(int i3, long j3);

        void refresh(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnPlayRepeatListener {
        void onPlayRepeat(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class SharpState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        SharpImage mSharpImage;
        int mTargetDensity;

        public SharpState(SharpImage sharpImage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sharpImage);
                return;
            }
            this.mGravity = 119;
            this.mTargetDensity = 160;
            this.mPaint = new Paint(6);
            this.mSharpImage = sharpImage;
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
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SharpDrawable(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new SharpDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11413);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            SHARPP_PRECODE = new byte[]{83, 72, 65, 82, 80, 80};
        }
    }

    public SharpDrawable(File file, Resources resources) throws IOException {
        this(file, resources, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) resources);
    }

    private void computeImageSize() {
        this.mApngWidth = this.mSharpState.mSharpImage.getScaledWidth(this.mTargetDensity);
        this.mApngHeight = this.mSharpState.mSharpImage.getScaledHeight(this.mTargetDensity);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0025 -> B:14:0x0053). Please report as a decompilation issue!!! */
    public static boolean isSharpP(File file) {
        boolean z16 = false;
        if (file != null) {
            BufferedInputStream bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2 = null;
            BufferedInputStream bufferedInputStream3 = null;
            bufferedInputStream = null;
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
                bufferedInputStream = bufferedInputStream;
            }
            try {
                try {
                    BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(file), 10);
                    try {
                        byte[] bArr = new byte[6];
                        if (bufferedInputStream4.read(bArr, 0, 6) != -1) {
                            z16 = Arrays.equals(bArr, SHARPP_PRECODE);
                        }
                        bufferedInputStream4.close();
                        bufferedInputStream = bArr;
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        bufferedInputStream2 = bufferedInputStream4;
                        e.printStackTrace();
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                            bufferedInputStream = bufferedInputStream2;
                        }
                        return z16;
                    } catch (IOException e18) {
                        e = e18;
                        bufferedInputStream3 = bufferedInputStream4;
                        e.printStackTrace();
                        bufferedInputStream = bufferedInputStream3;
                        if (bufferedInputStream3 != null) {
                            bufferedInputStream3.close();
                            bufferedInputStream = bufferedInputStream3;
                        }
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream4;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                } catch (IOException e27) {
                    e = e27;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return z16;
    }

    public void decodeFrame(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        OnFreshListener onFreshListener = this.freshListener;
        if (onFreshListener != null) {
            onFreshListener.decodeFrame(i3, j3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        Rect rect = null;
        if (this.reCalculateRects) {
            if (this.useRect) {
                SharpImage sharpImage = this.mSharpState.mSharpImage;
                int i3 = sharpImage.mWidth;
                int i16 = sharpImage.mHeight;
                if (i16 > 0 && i3 > 0) {
                    Rect bounds = getBounds();
                    if (this.chatWindowHeight < bounds.height()) {
                        this.chatWindowHeight = bounds.height();
                    }
                    if (this.chatWindowHeight / bounds.width() >= i16 / i3) {
                        int width = bounds.width() * i16;
                        int i17 = this.chatWindowHeight;
                        int i18 = width / i17;
                        int i19 = (int) ((i3 - i18) * 0.5d);
                        if (i17 > bounds.height()) {
                            i16 = (i16 * bounds.height()) / this.chatWindowHeight;
                        }
                        this.drawRect = new Rect(i19, 0, i18 + i19, i16);
                    } else {
                        int width2 = (int) ((i16 - ((this.chatWindowHeight * i3) / bounds.width())) * 0.5d);
                        this.drawRect = new Rect(0, width2, i3, ((bounds.height() * i3) / bounds.width()) + width2);
                    }
                } else {
                    this.drawRect = null;
                }
            }
            Gravity.apply(this.mSharpState.mGravity, this.mApngWidth, this.mApngHeight, getBounds(), this.mDstRect);
            this.reCalculateRects = false;
        }
        this.drawCounts++;
        SharpState sharpState = this.mSharpState;
        SharpImage sharpImage2 = sharpState.mSharpImage;
        if (this.useRect) {
            rect = this.drawRect;
        }
        sharpImage2.draw(canvas, rect, this.mDstRect, sharpState.mPaint, this.mUseAnimation);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mSharpState;
    }

    public long getDrawCounts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.drawCounts;
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mSharpState.mGravity;
    }

    public SharpImage getImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SharpImage) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mSharpState.mSharpImage;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mApngHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.mApngWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.image.AnimationCallback
    public void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) rect);
        } else {
            super.onBoundsChange(rect);
            this.reCalculateRects = true;
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        SharpImage image = getImage();
        if (image != null) {
            image.pause();
        }
    }

    public void refresh(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        OnFreshListener onFreshListener = this.freshListener;
        if (onFreshListener != null) {
            onFreshListener.refresh(i3, i16);
        }
    }

    public void removeOnPlayRepeatListener(OnPlayRepeatListener onPlayRepeatListener) {
        SharpImage sharpImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        SharpState sharpState = this.mSharpState;
        if (sharpState != null && (sharpImage = sharpState.mSharpImage) != null) {
            sharpImage.removeOnPlayRepeatListener(onPlayRepeatListener);
        }
    }

    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        SharpImage image = getImage();
        if (image != null) {
            image.replay();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        SharpImage image = getImage();
        if (image != null) {
            image.resume();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.mSharpState.mPaint.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) colorFilter);
        } else {
            this.mSharpState.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mSharpState.mPaint.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.mSharpState.mPaint.setFilterBitmap(z16);
        }
    }

    public void setFreshListener(OnFreshListener onFreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onFreshListener);
        } else {
            this.freshListener = onFreshListener;
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mSharpState.mGravity = i3;
            this.reCalculateRects = true;
        }
    }

    public void setLoopCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        SharpImage image = getImage();
        if (image != null) {
            image.setLoopCount(i3);
        }
    }

    public void setOnPlayRepeatListener(OnPlayRepeatListener onPlayRepeatListener) {
        SharpImage sharpImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        SharpState sharpState = this.mSharpState;
        if (sharpState != null && (sharpImage = sharpState.mSharpImage) != null) {
            sharpImage.setOnPlayRepeatListener(onPlayRepeatListener);
        }
    }

    public void setSharpFile(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) file);
            return;
        }
        SharpImage image = getImage();
        if (image != null) {
            URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new Runnable(image, file) { // from class: com.tencent.image.SharpDrawable.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ File val$file;
                final /* synthetic */ SharpImage val$sharpImage;

                {
                    this.val$sharpImage = image;
                    this.val$file = file;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SharpDrawable.this, image, file);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        this.val$sharpImage.setSharpFile(this.val$file);
                    } catch (IOException e16) {
                        URLDrawable.depImp.mLog.e(SharpDrawable.TAG, 4, "", e16);
                    }
                }
            }, null, true);
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, obj);
        } else if (obj != null) {
            this.useRect = ((Bundle) obj).getBoolean("key_use_rect", false);
            this.reCalculateRects = true;
        }
    }

    public SharpDrawable(File file, Resources resources, boolean z16) throws IOException {
        this(new SharpImage(file, z16), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, file, resources, Boolean.valueOf(z16));
    }

    public SharpDrawable(SharpImage sharpImage) {
        this(sharpImage, (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) sharpImage);
    }

    public SharpDrawable(SharpImage sharpImage, Resources resources) {
        this(new SharpState(sharpImage), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sharpImage, (Object) resources);
        } else {
            this.mSharpState.mTargetDensity = this.mTargetDensity;
        }
    }

    public SharpDrawable(SharpState sharpState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sharpState, (Object) resources);
            return;
        }
        this.mDstRect = new Rect();
        this.mUseAnimation = true;
        this.reCalculateRects = true;
        this.mTargetDensity = 160;
        this.mSharpState = sharpState;
        sharpState.mSharpImage.addCallBack(this);
        SharpImage sharpImage = sharpState.mSharpImage;
        if (sharpImage.mGetResetLoop) {
            sharpImage.mCurrentSharpLoop = 0;
        }
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = sharpState.mTargetDensity;
        }
        computeImageSize();
    }
}
