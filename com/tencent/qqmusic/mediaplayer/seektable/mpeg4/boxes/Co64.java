package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Co64 extends FullBox {
    private long[] chunkOffset;
    private int entryCount;

    public long[] getChunkOffset() {
        return this.chunkOffset;
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        super.parse(parsable, box);
        int readInt = parsable.readInt();
        this.entryCount = readInt;
        this.chunkOffset = parsable.readLongArray(readInt);
    }
}
