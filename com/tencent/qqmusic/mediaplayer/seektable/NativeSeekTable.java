package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeSeekTable implements SeekTable {
    private final BaseDecoder nativeDecoder;

    public NativeSeekTable(BaseDecoder baseDecoder) {
        this.nativeDecoder = baseDecoder;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j3) {
        return this.nativeDecoder.getBytePositionOfTime(j3);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) throws IOException, InvalidBoxException {
    }
}
