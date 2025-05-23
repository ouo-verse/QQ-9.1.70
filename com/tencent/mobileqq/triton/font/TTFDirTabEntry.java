package com.tencent.mobileqq.triton.font;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TTFDirTabEntry {
    private long length;
    private long offset;
    private final byte[] tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTFDirTabEntry() {
        this.tag = new byte[4];
    }

    public long getLength() {
        return this.length;
    }

    public long getOffset() {
        return this.offset;
    }

    public byte[] getTag() {
        return this.tag;
    }

    public String getTagString() {
        try {
            return new String(this.tag, "ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return toString();
        }
    }

    public String read(FontFileReader fontFileReader) throws IOException {
        this.tag[0] = fontFileReader.readTTFByte();
        this.tag[1] = fontFileReader.readTTFByte();
        this.tag[2] = fontFileReader.readTTFByte();
        this.tag[3] = fontFileReader.readTTFByte();
        fontFileReader.skip(4L);
        this.offset = fontFileReader.readTTFULong();
        this.length = fontFileReader.readTTFULong();
        return new String(this.tag, "ISO-8859-1");
    }

    public String toString() {
        return "Read dir tab [" + ((int) this.tag[0]) + " " + ((int) this.tag[1]) + " " + ((int) this.tag[2]) + " " + ((int) this.tag[3]) + "] offset: " + this.offset + " bytesToUpload: " + this.length + " name: " + this.tag;
    }

    public TTFDirTabEntry(long j3, long j16) {
        this.tag = new byte[4];
        this.offset = j3;
        this.length = j16;
    }
}
