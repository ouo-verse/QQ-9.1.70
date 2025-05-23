package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Ftyp extends Box {

    @Nullable
    int[] compatibleBrands;
    int majorBrand;
    int minorVersion;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        super.parse(parsable, box);
        this.majorBrand = parsable.readInt();
        this.minorVersion = parsable.readInt();
        int available = ((int) parsable.available()) / 4;
        if (available > 0) {
            this.compatibleBrands = parsable.readIntArray(available);
        }
    }
}
