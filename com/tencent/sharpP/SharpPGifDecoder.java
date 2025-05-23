package com.tencent.sharpP;

import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sharpP.SharpPDecoderWrapper;
import java.io.File;

/* loaded from: classes25.dex */
public class SharpPGifDecoder {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SharpPGifDecoder";
    private static final boolean USE_BITMAP_BUFFER = true;
    private int LOOP_COUNT;
    private Bitmap.Config mAcceptableConfig;
    private Bitmap mBitmapBuffer;
    private NewGifDecoder.GifFrame mCurFrame;
    private int mCurLoop;
    private SharpPDecoderHelper mDecoder;
    private int mDstHeight;
    private int mDstWidth;
    private File mFile;
    private long mHDec;
    private int mNextFrameIndex;
    private int maxFrameIndex;

    public SharpPGifDecoder(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mNextFrameIndex = 0;
        this.maxFrameIndex = -1;
        this.LOOP_COUNT = 0;
        this.mCurLoop = 0;
        this.mDecoder = new SharpPDecoderHelper(str);
        this.mDstWidth = i3;
        this.mDstHeight = i16;
        this.mFile = new File(str);
        init();
    }

    private synchronized void init() {
        if (this.mDecoder.parseHeader() == 0) {
            this.mHDec = this.mDecoder.createDecoder();
            this.maxFrameIndex = this.mDecoder.getFeatureInfo().getFrameCount();
            if (this.mDecoder.getFeatureInfo().getImageMode() == 4) {
                ImageManagerEnv.getLogger().d(TAG, "gif: emMode_AnimationWithAlpha");
                this.mAcceptableConfig = Bitmap.Config.ARGB_8888;
            }
        }
        if (this.mAcceptableConfig == null) {
            ImageManagerEnv.getLogger().d(TAG, "gif: emMode_Animation");
            this.mAcceptableConfig = Bitmap.Config.RGB_565;
        }
    }

    int calculateDelayTime(int i3) {
        if (i3 <= 1) {
            return 100;
        }
        return i3;
    }

    public synchronized int close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        ImageManagerEnv.getLogger().d(TAG, "close");
        this.mNextFrameIndex = 0;
        long j3 = this.mHDec;
        if (j3 == 0) {
            ImageManagerEnv.getLogger().w(TAG, "SharpPGifDecoder.close():mHDec=0");
            return -1;
        }
        this.mDecoder.closeDecoder(j3);
        this.mHDec = 0L;
        return 0;
    }

    public Bitmap.Config getAcceptableBitmapConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Bitmap.Config) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mAcceptableConfig;
    }

    public int getAllocationByteCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mDecoder.getAllocationByteCount();
    }

    public int getCurFrameDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        NewGifDecoder.GifFrame gifFrame = this.mCurFrame;
        if (gifFrame != null) {
            return (int) gifFrame.delay;
        }
        return 200;
    }

    public int getCurFrameIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mNextFrameIndex;
    }

    public int getCurrentLoop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mCurLoop;
    }

    public int getDstHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mDstHeight;
    }

    public int getDstWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mDstWidth;
    }

    public int getFrameCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (this.maxFrameIndex == -1) {
            init();
        }
        return this.maxFrameIndex;
    }

    public int getLoopCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.LOOP_COUNT;
    }

    public long getSourceLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.mFile.length();
    }

    public synchronized NewGifDecoder.GifFrame next(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (NewGifDecoder.GifFrame) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        }
        this.mBitmapBuffer = bitmap;
        return next();
    }

    public synchronized boolean reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        this.mNextFrameIndex = 0;
        return true;
    }

    public Bitmap seekToFrame(int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) bitmap);
        }
        setCurFrameIndex(i3);
        next();
        NewGifDecoder.GifFrame gifFrame = this.mCurFrame;
        if (gifFrame != null) {
            return gifFrame.image;
        }
        return bitmap;
    }

    public synchronized void setCurFrameIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            if (i3 >= 0 && i3 <= 65535) {
                this.mNextFrameIndex = i3;
                return;
            }
            throw new IllegalArgumentException("curFrameIndex is out of range <0, 65535>");
        }
    }

    public void setLoopCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            if (i3 >= 0 && i3 <= 65535) {
                this.LOOP_COUNT = i3;
                return;
            }
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5 A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0014, B:13:0x001c, B:14:0x001f, B:16:0x002e, B:19:0x005e, B:21:0x0064, B:24:0x0079, B:26:0x007d, B:29:0x0082, B:30:0x00bf, B:32:0x00c5, B:34:0x00ce, B:35:0x0103, B:38:0x00e1, B:39:0x00a6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0014, B:13:0x001c, B:14:0x001f, B:16:0x002e, B:19:0x005e, B:21:0x0064, B:24:0x0079, B:26:0x007d, B:29:0x0082, B:30:0x00bf, B:32:0x00c5, B:34:0x00ce, B:35:0x0103, B:38:0x00e1, B:39:0x00a6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e1 A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0014, B:13:0x001c, B:14:0x001f, B:16:0x002e, B:19:0x005e, B:21:0x0064, B:24:0x0079, B:26:0x007d, B:29:0x0082, B:30:0x00bf, B:32:0x00c5, B:34:0x00ce, B:35:0x0103, B:38:0x00e1, B:39:0x00a6), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized NewGifDecoder.GifFrame next() {
        Bitmap decodeSharpP2GifFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (NewGifDecoder.GifFrame) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mHDec == 0) {
            init();
        }
        SharpPDecoderWrapper.WriteableInteger writeableInteger = new SharpPDecoderWrapper.WriteableInteger(0);
        if (!this.mFile.exists()) {
            ImageManagerEnv.getLogger().e(TAG, "gif file " + this.mFile.getAbsolutePath() + " doesn't exist.");
            return this.mCurFrame;
        }
        long j3 = this.mHDec;
        if (j3 == 0) {
            ImageManagerEnv.getLogger().e(TAG, "gif mHDec is 0,createDecoder error.");
            return this.mCurFrame;
        }
        int i3 = this.LOOP_COUNT;
        if (i3 != 0 && this.mCurLoop >= i3) {
            ImageManagerEnv.getLogger().w(TAG, "loop over,loopCount:" + this.LOOP_COUNT);
            decodeSharpP2GifFrame = null;
            if (this.mNextFrameIndex == this.maxFrameIndex) {
                this.mNextFrameIndex = 0;
                this.mCurLoop++;
            }
            if (decodeSharpP2GifFrame == null) {
                this.mCurFrame = new NewGifDecoder.GifFrame(decodeSharpP2GifFrame, calculateDelayTime(writeableInteger.realInt.intValue()));
            } else {
                ImageManagerEnv.getLogger().e(TAG, "decode error:frameIndex=" + this.mNextFrameIndex);
            }
            return this.mCurFrame;
        }
        decodeSharpP2GifFrame = this.mDecoder.decodeSharpP2GifFrame(j3, this.mNextFrameIndex, this.mDstWidth, this.mDstHeight, writeableInteger, this.mBitmapBuffer);
        this.mNextFrameIndex++;
        if (this.mNextFrameIndex == this.maxFrameIndex) {
        }
        if (decodeSharpP2GifFrame == null) {
        }
        return this.mCurFrame;
    }

    public SharpPGifDecoder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.mNextFrameIndex = 0;
        this.maxFrameIndex = -1;
        this.LOOP_COUNT = 0;
        this.mCurLoop = 0;
        this.mDecoder = new SharpPDecoderHelper(str);
        this.mFile = new File(str);
        init();
        this.mDstWidth = this.mDecoder.getFeatureInfo().getWidth();
        this.mDstHeight = this.mDecoder.getFeatureInfo().getHeight();
    }
}
