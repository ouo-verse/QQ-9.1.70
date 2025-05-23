package org.light;

import org.light.bean.Texture;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ClipSourceFactory {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface AudioReader {
        AudioFrame copyNextFrame();

        AudioFrame copyNextFrameSyncEnable(boolean z16);

        long duration();

        void release();

        void seek(long j3);

        void setVolume(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface VideoReader {
        long duration();

        int height();

        Texture readSample(long j3);

        void release();

        int width();
    }

    AudioReader createAudioReader(String str);

    VideoReader createVideoReader(String str);
}
