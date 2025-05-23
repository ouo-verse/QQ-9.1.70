package com.tencent.superplayer.api;

import android.graphics.Bitmap;

/* loaded from: classes26.dex */
public interface ISPlayerImageGenerator {

    /* loaded from: classes26.dex */
    public static class ImageGeneratorParams {
        public int width = 0;
        public int height = 0;
        public long requestedTimeMsToleranceBefore = 0;
        public long requestedTimeMsToleranceAfter = 0;
    }

    /* loaded from: classes26.dex */
    public interface Listener {
        void onCaptureVideoFailed(int i3);

        void onCaptureVideoSuccess(Bitmap bitmap);
    }

    void generateImageAsyncAtTime(long j3, ImageGeneratorParams imageGeneratorParams, Listener listener);

    void release();
}
