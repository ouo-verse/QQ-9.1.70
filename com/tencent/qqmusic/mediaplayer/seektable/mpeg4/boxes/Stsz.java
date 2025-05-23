package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Stsz extends FullBox {

    @Nullable
    int[] entrySize;
    int sampleCount;
    int sampleSize;

    public int[] getEntrySize() {
        return this.entrySize;
    }

    public int getSampleCount() {
        return this.sampleCount;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        super.parse(parsable, box);
        this.sampleSize = parsable.readInt();
        int readInt = parsable.readInt();
        this.sampleCount = readInt;
        if (this.sampleSize == 0) {
            this.entrySize = parsable.readIntArray(readInt);
        }
        if (this.sampleSize == 0 && this.sampleCount == 0) {
            throw new InvalidBoxException("invalide stsz: both [sample_count] and [sample_size] is 0!");
        }
    }
}
