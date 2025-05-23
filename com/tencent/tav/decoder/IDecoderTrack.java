package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IDecoderTrack {
    public static final int FLAG_PLAY = 0;
    public static final int FLAG_SEEK = 1;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface SurfaceCreator {
        Surface createOutputSurface(int i3, int i16, int i17);

        void free(Surface surface);

        void release();

        VideoTexture videoTextureForSurface(Surface surface);
    }

    void asyncReadNextSample(CMTime cMTime);

    void clipRangeAndClearRange(CMTimeRange cMTimeRange);

    CMTime getCurrentSampleTime();

    CMTime getDuration();

    CMTime getFrameDuration();

    int getFrameRate();

    int getTrackId();

    CMSampleBuffer readCurrentSample();

    CMSampleBuffer readSample();

    CMSampleBuffer readSample(CMTime cMTime);

    void release();

    CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17);

    void setDecodeType(IDecoder.DecodeType decodeType);

    void setFrameRate(int i3);

    void setTrackIndex(int i3);

    void setTrackSegments(List<DecoderTrackSegment> list);

    void setVolume(float f16);

    void start();

    void start(SurfaceCreator surfaceCreator);

    void start(SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange);
}
