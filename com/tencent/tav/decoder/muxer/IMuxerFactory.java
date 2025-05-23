package com.tencent.tav.decoder.muxer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public class IMuxerFactory {
    private static DefaultMediaMuxerCreator defaultMuxerCreator = new DefaultMediaMuxerCreator();
    private static MediaMuxerCreator muxerCreator = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class DefaultMediaMuxerCreator implements MediaMuxerCreator {
        DefaultMediaMuxerCreator() {
        }

        @Override // com.tencent.tav.decoder.muxer.IMuxerFactory.MediaMuxerCreator
        public IMediaMuxer createMediaMuxer(@NonNull String str, int i3) throws IOException {
            return new DefaultMediaMuxer(str, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface MediaMuxerCreator {
        IMediaMuxer createMediaMuxer(@NonNull String str, int i3) throws IOException;
    }

    public static IMediaMuxer createMediaMuxer(@NonNull String str, int i3) throws IOException {
        MediaMuxerCreator mediaMuxerCreator = muxerCreator;
        if (mediaMuxerCreator == null) {
            return defaultMuxerCreator.createMediaMuxer(str, i3);
        }
        return mediaMuxerCreator.createMediaMuxer(str, i3);
    }

    public static void setMuxerCreator(MediaMuxerCreator mediaMuxerCreator) {
        muxerCreator = mediaMuxerCreator;
    }
}
