package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface INativeDataSource {
    AudioFormat.AudioType getAudioType() throws IOException;

    long getNativeInstance();
}
