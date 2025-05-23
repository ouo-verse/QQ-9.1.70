package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.WireParseException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DNSInput {
    private final ByteBuffer byteBuffer;
    private final int limit;
    private final int offset;
    private int savedEnd;
    private int savedPos;

    public DNSInput(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    private void require(int i3) throws WireParseException {
        if (i3 <= remaining()) {
        } else {
            throw new WireParseException("end of input");
        }
    }

    public void clearActive() {
        this.byteBuffer.limit(this.limit);
    }

    public int current() {
        return this.byteBuffer.position() - this.offset;
    }

    public void jump(int i3) {
        int i16 = this.offset;
        if (i3 + i16 < this.limit) {
            this.byteBuffer.position(i16 + i3);
            this.byteBuffer.limit(this.limit);
            return;
        }
        throw new IllegalArgumentException("cannot jump past end of input");
    }

    public void readByteArray(byte[] bArr, int i3, int i16) throws WireParseException {
        require(i16);
        this.byteBuffer.get(bArr, i3, i16);
    }

    public byte[] readCountedString() throws WireParseException {
        return readByteArray(readU8());
    }

    public int readU16() throws WireParseException {
        require(2);
        return this.byteBuffer.getShort() & 65535;
    }

    public long readU32() throws WireParseException {
        require(4);
        return this.byteBuffer.getInt() & 4294967295L;
    }

    public int readU8() throws WireParseException {
        require(1);
        return this.byteBuffer.get() & 255;
    }

    public int remaining() {
        return this.byteBuffer.remaining();
    }

    public void restore() {
        int i3 = this.savedPos;
        if (i3 >= 0) {
            this.byteBuffer.position(i3);
            this.byteBuffer.limit(this.savedEnd);
            this.savedPos = -1;
            this.savedEnd = -1;
            return;
        }
        throw new IllegalStateException("no previous state");
    }

    public void restoreActive(int i3) {
        int i16 = this.offset;
        if (i3 + i16 <= this.limit) {
            this.byteBuffer.limit(i3 + i16);
            return;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
    }

    public void save() {
        this.savedPos = this.byteBuffer.position();
        this.savedEnd = this.byteBuffer.limit();
    }

    public int saveActive() {
        return this.byteBuffer.limit() - this.offset;
    }

    public void setActive(int i3) {
        if (i3 <= this.limit - this.byteBuffer.position()) {
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.limit(byteBuffer.position() + i3);
            return;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
    }

    public DNSInput(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.offset = byteBuffer.position();
        this.limit = byteBuffer.limit();
        this.savedPos = -1;
        this.savedEnd = -1;
    }

    public byte[] readByteArray(int i3) throws WireParseException {
        require(i3);
        byte[] bArr = new byte[i3];
        this.byteBuffer.get(bArr, 0, i3);
        return bArr;
    }

    public byte[] readByteArray() {
        int remaining = remaining();
        byte[] bArr = new byte[remaining];
        this.byteBuffer.get(bArr, 0, remaining);
        return bArr;
    }
}
