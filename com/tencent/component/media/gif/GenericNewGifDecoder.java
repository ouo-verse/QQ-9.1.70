package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GenericNewGifDecoder implements NewGifDecoder {
    private static final String TAG = "GenericNewGifDecoder";
    private NewGifDecoder.GifFrame mCurFrame;
    private GifInfoHandle mNativeInfoHandle;

    public GenericNewGifDecoder(GifInfoHandle gifInfoHandle) {
        this.mNativeInfoHandle = gifInfoHandle;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void changeFile(String str) {
        this.mNativeInfoHandle.changeFile(str);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame doRender(Bitmap bitmap) {
        try {
            NewGifDecoder.GifFrame gifFrame = new NewGifDecoder.GifFrame(bitmap, this.mNativeInfoHandle.doRender(bitmap));
            this.mCurFrame = gifFrame;
            return gifFrame;
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerEnv.getLogger().w(TAG, "catch an exception:", Log.getStackTraceString(e16));
            return new NewGifDecoder.GifFrame(bitmap, -1L);
        }
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public Bitmap.Config getAcceptableConfig() {
        int preferConfig = this.mNativeInfoHandle.getPreferConfig();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (preferConfig != 1) {
            if (preferConfig != 4) {
                if (preferConfig != 7) {
                    if (preferConfig == 8) {
                        config = Bitmap.Config.ALPHA_8;
                    }
                } else {
                    config = Bitmap.Config.ARGB_4444;
                }
            } else {
                config = Bitmap.Config.RGB_565;
            }
        }
        ImageManagerEnv.getLogger().d(TAG, "index GifInfoHandle: preferBmpFormat--" + preferConfig);
        return config;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public long getAllocationByteCount() {
        return this.mNativeInfoHandle.getAllocationByteCount();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public String getComment() {
        return this.mNativeInfoHandle.getComment();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getCurrentFrameIndex() {
        return this.mNativeInfoHandle.getCurrentFrameIndex();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getCurrentLoop() {
        return this.mNativeInfoHandle.getCurrentLoop();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getCurrentPosition() {
        return this.mNativeInfoHandle.getCurrentPosition();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getDuration() {
        return this.mNativeInfoHandle.getDuration();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getError() {
        return this.mNativeInfoHandle.getNativeErrorCode();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getFrameCount() {
        return this.mNativeInfoHandle.frameCount;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getFrameDuration(int i3) {
        return this.mNativeInfoHandle.getFrameDuration(i3);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getHeight() {
        return this.mNativeInfoHandle.height;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getImageCount() {
        return this.mNativeInfoHandle.getImageCount();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getLoopCount() {
        return this.mNativeInfoHandle.getLoopCount();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public long getSourceLength() {
        return this.mNativeInfoHandle.getSourceLength();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getWidth() {
        return this.mNativeInfoHandle.width;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public boolean isAnimationCompleted() {
        return this.mNativeInfoHandle.isAnimationCompleted();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public boolean isRecycled() {
        GifInfoHandle gifInfoHandle = this.mNativeInfoHandle;
        if (gifInfoHandle != null) {
            return gifInfoHandle.isRecycled();
        }
        return true;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame next(Bitmap bitmap) {
        NewGifDecoder.GifFrame gifFrame = new NewGifDecoder.GifFrame(bitmap, this.mNativeInfoHandle.renderFrame(bitmap));
        this.mCurFrame = gifFrame;
        return gifFrame;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame nextForGifPlay(Bitmap bitmap, boolean z16) {
        NewGifDecoder.GifFrame gifFrame = new NewGifDecoder.GifFrame(bitmap, this.mNativeInfoHandle.renderFrameForGifPlay(bitmap, z16));
        this.mCurFrame = gifFrame;
        return gifFrame;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void prepareData() {
        try {
            this.mNativeInfoHandle.prepareData();
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerEnv.getLogger().w(TAG, "catch an exception:", Log.getStackTraceString(e16));
        }
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void recycle() {
        this.mNativeInfoHandle.recycle();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public boolean reset() {
        try {
            return this.mNativeInfoHandle.reset();
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerEnv.getLogger().w(TAG, "reset failed,catch an exception:", Log.getStackTraceString(e16));
            return false;
        }
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public Bitmap seekToFrame(int i3, Bitmap bitmap) {
        this.mNativeInfoHandle.seekToFrame(i3, bitmap);
        return bitmap;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame seekToFrameGetTime(int i3, Bitmap bitmap) {
        NewGifDecoder.GifFrame gifFrame = new NewGifDecoder.GifFrame(bitmap, this.mNativeInfoHandle.seekToFrameGetTime(i3, bitmap));
        this.mCurFrame = gifFrame;
        return gifFrame;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public Bitmap seekToTime(int i3, Bitmap bitmap) {
        this.mNativeInfoHandle.seekToTime(i3, bitmap);
        return bitmap;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void setGifInfoHandler(GifInfoHandle gifInfoHandle) {
        this.mNativeInfoHandle = gifInfoHandle;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void setLoopCount(int i3) {
        this.mNativeInfoHandle.setLoopCount(i3);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void setSpeed(float f16) {
        this.mNativeInfoHandle.setSpeedFactor(f16);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public long start() {
        return this.mNativeInfoHandle.restoreRemainder();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void stop() {
        this.mNativeInfoHandle.saveRemainder();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void updateFile(String str) {
        this.mNativeInfoHandle.updateFile(str);
    }
}
