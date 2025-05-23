package com.tencent.state.square.media;

import java.nio.ByteBuffer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/media/IMediaExtractor;", "", "advance", "", "getSampleTime", "", "readSampleData", "", "buffer", "Ljava/nio/ByteBuffer;", "offset", "release", "", "seekTo", "timeUs", "selectVideoTrack", "Lcom/tencent/state/square/media/VideoInfo;", "source", "Lcom/tencent/state/square/media/MediaSource;", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMediaExtractor {
    boolean advance();

    long getSampleTime();

    int readSampleData(ByteBuffer buffer, int offset);

    void release();

    void seekTo(long timeUs);

    VideoInfo selectVideoTrack(MediaSource source);
}
