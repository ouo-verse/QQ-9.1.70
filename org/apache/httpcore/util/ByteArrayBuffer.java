package org.apache.httpcore.util;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ByteArrayBuffer implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;
    private byte[] buffer;
    private int len;

    public ByteArrayBuffer(int i3) {
        Args.notNegative(i3, "Buffer capacity");
        this.buffer = new byte[i3];
    }

    private void expand(int i3) {
        byte[] bArr = new byte[Math.max(this.buffer.length << 1, i3)];
        System.arraycopy(this.buffer, 0, bArr, 0, this.len);
        this.buffer = bArr;
    }

    public void append(byte[] bArr, int i3, int i16) {
        int i17;
        if (bArr == null) {
            return;
        }
        if (i3 < 0 || i3 > bArr.length || i16 < 0 || (i17 = i3 + i16) < 0 || i17 > bArr.length) {
            throw new IndexOutOfBoundsException("off: " + i3 + " len: " + i16 + " b.length: " + bArr.length);
        }
        if (i16 == 0) {
            return;
        }
        int i18 = this.len + i16;
        if (i18 > this.buffer.length) {
            expand(i18);
        }
        System.arraycopy(bArr, i3, this.buffer, this.len, i16);
        this.len = i18;
    }

    public byte[] buffer() {
        return this.buffer;
    }

    public int byteAt(int i3) {
        return this.buffer[i3];
    }

    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.len = 0;
    }

    public void ensureCapacity(int i3) {
        if (i3 <= 0) {
            return;
        }
        int length = this.buffer.length;
        int i16 = this.len;
        if (i3 > length - i16) {
            expand(i16 + i3);
        }
    }

    public int indexOf(byte b16, int i3, int i16) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i17 = this.len;
        if (i16 > i17) {
            i16 = i17;
        }
        if (i3 > i16) {
            return -1;
        }
        while (i3 < i16) {
            if (this.buffer[i3] == b16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.len == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.len == this.buffer.length) {
            return true;
        }
        return false;
    }

    public int length() {
        return this.len;
    }

    public void setLength(int i3) {
        if (i3 >= 0 && i3 <= this.buffer.length) {
            this.len = i3;
            return;
        }
        throw new IndexOutOfBoundsException("len: " + i3 + " < 0 or > buffer len: " + this.buffer.length);
    }

    public byte[] toByteArray() {
        int i3 = this.len;
        byte[] bArr = new byte[i3];
        if (i3 > 0) {
            System.arraycopy(this.buffer, 0, bArr, 0, i3);
        }
        return bArr;
    }

    public int indexOf(byte b16) {
        return indexOf(b16, 0, this.len);
    }

    public void append(int i3) {
        int i16 = this.len + 1;
        if (i16 > this.buffer.length) {
            expand(i16);
        }
        this.buffer[this.len] = (byte) i3;
        this.len = i16;
    }

    public void append(char[] cArr, int i3, int i16) {
        int i17;
        if (cArr == null) {
            return;
        }
        if (i3 < 0 || i3 > cArr.length || i16 < 0 || (i17 = i3 + i16) < 0 || i17 > cArr.length) {
            throw new IndexOutOfBoundsException("off: " + i3 + " len: " + i16 + " b.length: " + cArr.length);
        }
        if (i16 == 0) {
            return;
        }
        int i18 = this.len;
        int i19 = i16 + i18;
        if (i19 > this.buffer.length) {
            expand(i19);
        }
        while (i18 < i19) {
            char c16 = cArr[i3];
            if ((c16 >= ' ' && c16 <= '~') || ((c16 >= '\u00a0' && c16 <= '\u00ff') || c16 == '\t')) {
                this.buffer[i18] = (byte) c16;
            } else {
                this.buffer[i18] = 63;
            }
            i3++;
            i18++;
        }
        this.len = i19;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i3, int i16) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer(), i3, i16);
    }
}
