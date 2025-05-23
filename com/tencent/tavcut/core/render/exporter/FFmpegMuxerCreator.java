package com.tencent.tavcut.core.render.exporter;

import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.DefaultMediaMuxer;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavkit.tavffmpeg.FFmpegMuxer;
import com.tencent.tavkit.tavffmpeg.TAVFFmpegResourceLoader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/FFmpegMuxerCreator;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "<set-?>", "", "muxerName", "getMuxerName", "()Ljava/lang/String;", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "format", "", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class FFmpegMuxerCreator implements MediaMuxerFactory.MediaMuxerCreator {
    private static final String TAG = "FFmpegMuxerCreator";

    @Nullable
    private String muxerName;

    @Override // com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator
    @NotNull
    public synchronized IMediaMuxer createMediaMuxer(@NotNull String path, int format) throws IOException {
        Intrinsics.checkParameterIsNotNull(path, "path");
        TavLogger.i(TAG, "createMediaMuxer() called with: path = [" + path + "], format = [" + format + ']');
        if (TAVFFmpegResourceLoader.isSoLoaded()) {
            try {
                FFmpegMuxer fFmpegMuxer = new FFmpegMuxer(path, "");
                this.muxerName = "fFmpegMuxer";
                return fFmpegMuxer;
            } catch (Exception e16) {
                Logger.e(TAG, "createMediaMuxer: ", e16);
            }
        }
        this.muxerName = "defaultMediaMuxer";
        return new DefaultMediaMuxer(path, format);
    }

    @Nullable
    public final String getMuxerName() {
        return this.muxerName;
    }
}
