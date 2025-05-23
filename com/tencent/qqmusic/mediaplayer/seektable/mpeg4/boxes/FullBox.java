package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class FullBox extends Box {
    int flags;
    int version;

    public int getFlags() {
        return this.flags;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        super.parse(parsable, box);
        byte[] bArr = new byte[4];
        parsable.readBytes(bArr, 0, 4);
        this.version = bArr[0] & 255;
        this.flags = ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }
}
