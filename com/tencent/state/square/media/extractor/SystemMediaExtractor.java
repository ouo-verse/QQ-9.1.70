package com.tencent.state.square.media.extractor;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.media.IMediaExtractor;
import com.tencent.state.square.media.ISquarePlayerKt;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.media.VideoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/media/extractor/SystemMediaExtractor;", "Lcom/tencent/state/square/media/IMediaExtractor;", "()V", "extractor", "Landroid/media/MediaExtractor;", "future", "Lcom/tencent/state/square/media/extractor/MediaFuture;", "advance", "", "getSampleTime", "", "readSampleData", "", "buffer", "Ljava/nio/ByteBuffer;", "offset", "release", "", "seekTo", "timeUs", "selectVideoTrack", "Lcom/tencent/state/square/media/VideoInfo;", "source", "Lcom/tencent/state/square/media/MediaSource;", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SystemMediaExtractor implements IMediaExtractor {
    private static final String TAG = "Square_SystemMediaExtractor";
    private MediaExtractor extractor;
    private MediaFuture future;

    @Override // com.tencent.state.square.media.IMediaExtractor
    public boolean advance() {
        MediaExtractor mediaExtractor = this.extractor;
        if (mediaExtractor != null) {
            return mediaExtractor.advance();
        }
        return false;
    }

    @Override // com.tencent.state.square.media.IMediaExtractor
    public long getSampleTime() {
        MediaExtractor mediaExtractor = this.extractor;
        if (mediaExtractor != null) {
            return mediaExtractor.getSampleTime();
        }
        return 0L;
    }

    @Override // com.tencent.state.square.media.IMediaExtractor
    public int readSampleData(ByteBuffer buffer, int offset) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        MediaExtractor mediaExtractor = this.extractor;
        if (mediaExtractor != null) {
            return mediaExtractor.readSampleData(buffer, offset);
        }
        return -1;
    }

    @Override // com.tencent.state.square.media.IMediaExtractor
    public void release() {
        MediaExtractor mediaExtractor = this.extractor;
        this.extractor = null;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
        MediaFuture mediaFuture = this.future;
        if (mediaFuture != null) {
            mediaFuture.cancel();
        }
        this.future = null;
    }

    @Override // com.tencent.state.square.media.IMediaExtractor
    public void seekTo(long timeUs) {
        MediaExtractor mediaExtractor = this.extractor;
        if (mediaExtractor != null) {
            mediaExtractor.seekTo(timeUs, 2);
        }
    }

    @Override // com.tencent.state.square.media.IMediaExtractor
    public VideoInfo selectVideoTrack(MediaSource source) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(source, "source");
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.extractor = mediaExtractor;
        try {
            MediaFuture dataSourceWithDownload = ExtractorExtensionsKt.setDataSourceWithDownload(mediaExtractor, source);
            this.future = dataSourceWithDownload;
            if (!Intrinsics.areEqual(dataSourceWithDownload != null ? dataSourceWithDownload.getIsSuccess() : null, Boolean.TRUE)) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "MediaExtractor.setDataSource failed, source=" + source, null, 4, null);
                return null;
            }
            this.future = null;
            int trackCount = mediaExtractor.getTrackCount();
            VideoInfo videoInfo = new VideoInfo();
            int i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                SquareBaseKt.getSquareLog().i(TAG, "MediaExtractor.setDataSource track i: " + i3 + ", mime:" + string + ", format=" + trackFormat);
                if (string != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null);
                    if (startsWith$default) {
                        mediaExtractor.selectTrack(i3);
                        ISquarePlayerKt.fill(videoInfo, trackFormat);
                        break;
                    }
                }
                i3++;
            }
            return videoInfo;
        } catch (IOException e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "MediaExtractor.setDataSource error: " + e16.getMessage() + ", source=" + source, null, 4, null);
            return null;
        }
    }
}
