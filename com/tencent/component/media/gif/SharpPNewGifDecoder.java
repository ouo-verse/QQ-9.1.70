package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.sharpP.SharpPGifDecoder;

/* loaded from: classes5.dex */
public class SharpPNewGifDecoder implements NewGifDecoder {
    private static final String TAG = "SharpPNewGifDecoder";
    private SharpPGifDecoder mDecoder;
    private int mCurFrameIndex = 0;
    private boolean isRecycled = false;
    private float speedFactor = 1.0f;
    private Handler mCtrlHandler = new Handler(ImageManagerEnv.g().getDispatcher());

    public SharpPNewGifDecoder(String str, int i3, int i16) {
        this.mDecoder = new SharpPGifDecoder(str, i3, i16);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame doRender(Bitmap bitmap) {
        return null;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public Bitmap.Config getAcceptableConfig() {
        return this.mDecoder.getAcceptableBitmapConfig();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public long getAllocationByteCount() {
        return this.mDecoder.getAllocationByteCount();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public String getComment() {
        return null;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getCurrentFrameIndex() {
        return this.mDecoder.getCurFrameIndex();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getCurrentLoop() {
        return this.mDecoder.getCurrentLoop();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getCurrentPosition() {
        return this.mDecoder.getCurFrameIndex();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getDuration() {
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getError() {
        return 0;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getFrameCount() {
        return this.mDecoder.getFrameCount();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getFrameDuration(int i3) {
        return this.mDecoder.getCurFrameDuration();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getHeight() {
        return this.mDecoder.getDstHeight();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getImageCount() {
        return 0;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getLoopCount() {
        return this.mDecoder.getLoopCount();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public long getSourceLength() {
        return this.mDecoder.getSourceLength();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public int getWidth() {
        return this.mDecoder.getDstWidth();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public boolean isAnimationCompleted() {
        return false;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame next(Bitmap bitmap) {
        NewGifDecoder.GifFrame next = this.mDecoder.next(bitmap);
        if (next != null) {
            next.delay = (int) (((float) next.delay) / this.speedFactor);
            return next;
        }
        return new NewGifDecoder.GifFrame(bitmap, 200L);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame nextForGifPlay(Bitmap bitmap, boolean z16) {
        return null;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void recycle() {
        ImageManagerEnv.getLogger().d(TAG, "recycle");
        this.isRecycled = true;
        this.mDecoder.close();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public boolean reset() {
        this.isRecycled = false;
        this.mCurFrameIndex = 0;
        return this.mDecoder.reset();
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public Bitmap seekToFrame(int i3, Bitmap bitmap) {
        return this.mDecoder.seekToFrame(i3, bitmap);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public NewGifDecoder.GifFrame seekToFrameGetTime(int i3, Bitmap bitmap) {
        return null;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public Bitmap seekToTime(int i3, Bitmap bitmap) {
        return seekToFrame(i3, bitmap);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void setLoopCount(int i3) {
        this.mDecoder.setLoopCount(i3);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void setSpeed(float f16) {
        if (f16 > 0.0f && !Float.isNaN(f16)) {
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            this.speedFactor = f16;
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public long start() {
        this.mCtrlHandler.post(new Runnable() { // from class: com.tencent.component.media.gif.SharpPNewGifDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                SharpPNewGifDecoder.this.mDecoder.setCurFrameIndex(SharpPNewGifDecoder.this.mCurFrameIndex);
                SharpPNewGifDecoder.this.isRecycled = false;
            }
        });
        return 0L;
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void stop() {
        this.mCurFrameIndex = this.mDecoder.getCurFrameIndex();
        this.mDecoder.close();
    }

    public SharpPNewGifDecoder(String str) {
        this.mDecoder = new SharpPGifDecoder(str);
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void prepareData() {
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void changeFile(String str) {
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void setGifInfoHandler(GifInfoHandle gifInfoHandle) {
    }

    @Override // com.tencent.component.media.gif.NewGifDecoder
    public void updateFile(String str) {
    }
}
