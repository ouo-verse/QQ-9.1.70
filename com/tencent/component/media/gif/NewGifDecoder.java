package com.tencent.component.media.gif;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface NewGifDecoder {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class GifFrame {
        public long delay;
        public Bitmap image;

        public GifFrame(Bitmap bitmap, long j3) {
            this.image = bitmap;
            this.delay = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Options {
        public Bitmap.Config inPreferredConfig;
        public int inPreferWidth = 0;
        public int inPreferHeight = 0;
    }

    void changeFile(String str);

    GifFrame doRender(Bitmap bitmap);

    Bitmap.Config getAcceptableConfig();

    long getAllocationByteCount();

    String getComment();

    int getCurrentFrameIndex();

    int getCurrentLoop();

    int getCurrentPosition();

    int getDuration();

    int getError();

    int getFrameCount();

    int getFrameDuration(int i3);

    int getHeight();

    int getImageCount();

    int getLoopCount();

    long getSourceLength();

    int getWidth();

    boolean isAnimationCompleted();

    boolean isRecycled();

    GifFrame next(Bitmap bitmap);

    GifFrame nextForGifPlay(Bitmap bitmap, boolean z16);

    void prepareData();

    void recycle();

    boolean reset();

    Bitmap seekToFrame(int i3, Bitmap bitmap);

    GifFrame seekToFrameGetTime(int i3, Bitmap bitmap);

    Bitmap seekToTime(int i3, Bitmap bitmap);

    void setGifInfoHandler(GifInfoHandle gifInfoHandle);

    void setLoopCount(int i3);

    void setSpeed(float f16);

    long start();

    void stop();

    void updateFile(String str);
}
