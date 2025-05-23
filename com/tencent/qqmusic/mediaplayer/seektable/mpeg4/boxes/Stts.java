package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Stts extends FullBox {
    int entryCount;
    int[] sampleCount;
    int[] sampleDelta;

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getSampleCount() {
        return this.sampleCount;
    }

    public int[] getSampleDelta() {
        return this.sampleDelta;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        super.parse(parsable, box);
        int readInt = parsable.readInt();
        this.entryCount = readInt;
        int[] iArr = new int[readInt];
        this.sampleCount = iArr;
        int[] iArr2 = new int[readInt];
        this.sampleDelta = iArr2;
        parsable.readIntArrayInterleaved(readInt, iArr, iArr2);
    }
}
