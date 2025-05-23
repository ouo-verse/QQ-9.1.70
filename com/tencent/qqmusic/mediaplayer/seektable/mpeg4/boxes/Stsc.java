package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Stsc extends FullBox {
    int entryCount;
    int[] firstChunk;
    int[] sampleDescIndex;
    int[] samplesPerChunk;

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getFirstChunk() {
        return this.firstChunk;
    }

    public int[] getSampleDescIndex() {
        return this.sampleDescIndex;
    }

    public int[] getSamplesPerChunk() {
        return this.samplesPerChunk;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        super.parse(parsable, box);
        int readInt = parsable.readInt();
        this.entryCount = readInt;
        int[] iArr = new int[readInt];
        this.firstChunk = iArr;
        int[] iArr2 = new int[readInt];
        this.samplesPerChunk = iArr2;
        int[] iArr3 = new int[readInt];
        this.sampleDescIndex = iArr3;
        parsable.readIntArrayInterleaved(readInt, iArr, iArr2, iArr3);
    }
}
