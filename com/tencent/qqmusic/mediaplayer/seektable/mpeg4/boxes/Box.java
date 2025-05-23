package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class Box implements IMpeg4Box {
    private long largeSize;
    private int size;
    private byte[] type;
    private byte[] userType;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public final long getSize() {
        long j3 = this.largeSize;
        if (j3 != 0) {
            return j3;
        }
        return this.size;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public final String getType() {
        return new String(this.type, Charset.defaultCharset());
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
    public void parse(Parsable parsable, Box box) throws IOException, InvalidBoxException {
        if (box == null) {
            this.size = parsable.readInt();
            byte[] bArr = new byte[4];
            this.type = bArr;
            parsable.readBytes(bArr, 0, 4);
            int i3 = this.size;
            if (i3 == 1) {
                long readLong = parsable.readLong();
                this.largeSize = readLong;
                if (readLong == 0) {
                    throw new InvalidBoxException("invalid [" + getType() + "]: largeSize is 0!");
                }
            } else if (i3 == 0) {
                this.largeSize = parsable.available();
            } else if (i3 < 8) {
                throw new InvalidBoxException("invalid [" + getType() + "]: size is less than 8!");
            }
            if (Arrays.equals(this.type, "uuid".getBytes())) {
                byte[] bArr2 = new byte[16];
                this.userType = bArr2;
                parsable.readBytes(bArr2, 0, 16);
                return;
            }
            return;
        }
        this.size = box.size;
        this.type = box.type;
        this.largeSize = box.largeSize;
        this.userType = box.userType;
    }
}
