package com.tencent.tav.decoder.muxer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public class MediaMuxerFactory {
    private static DefaultMediaMuxerCreator defaultMuxerCreator = new DefaultMediaMuxerCreator();
    private static MediaMuxerCreator muxerCreator = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class DefaultMediaMuxerCreator implements MediaMuxerCreator {
        DefaultMediaMuxerCreator() {
        }

        @Override // com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator
        public IMediaMuxer createMediaMuxer(@NonNull String str, int i3) throws IOException {
            return new DefaultMediaMuxer(str, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface MediaMuxerCreator {
        IMediaMuxer createMediaMuxer(@NonNull String str, int i3) throws IOException;
    }

    public static MediaMuxerCreator getMuxerCreator() {
        MediaMuxerCreator mediaMuxerCreator = muxerCreator;
        if (mediaMuxerCreator == null) {
            return defaultMuxerCreator;
        }
        return mediaMuxerCreator;
    }

    public static void setMuxerCreator(MediaMuxerCreator mediaMuxerCreator) {
        muxerCreator = mediaMuxerCreator;
    }
}
