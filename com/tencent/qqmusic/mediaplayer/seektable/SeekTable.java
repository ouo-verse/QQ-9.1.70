package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface SeekTable {
    void parse(IDataSource iDataSource) throws IOException, InvalidBoxException;

    long seek(long j3);
}
