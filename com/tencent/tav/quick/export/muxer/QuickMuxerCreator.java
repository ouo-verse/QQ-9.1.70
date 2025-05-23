package com.tencent.tav.quick.export.muxer;

import androidx.annotation.NonNull;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class QuickMuxerCreator implements MediaMuxerFactory.MediaMuxerCreator {
    @Override // com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator
    public IMediaMuxer createMediaMuxer(@NonNull String str, int i3) throws IOException {
        return new QuickMuxer(str, i3);
    }
}
