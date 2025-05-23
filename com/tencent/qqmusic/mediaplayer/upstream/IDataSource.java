package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IDataSource extends Closeable {
    AudioFormat.AudioType getAudioType() throws IOException;

    long getSize() throws IOException;

    void open() throws IOException;

    int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException;
}
