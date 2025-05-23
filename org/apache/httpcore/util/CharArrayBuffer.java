package org.apache.httpcore.util;

import java.io.Serializable;
import java.nio.CharBuffer;
import org.apache.httpcore.protocol.HTTP;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CharArrayBuffer implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int i3) {
        Args.notNegative(i3, "Buffer capacity");
        this.buffer = new char[i3];
    }

    private void expand(int i3) {
        char[] cArr = new char[Math.max(this.buffer.length << 1, i3)];
        System.arraycopy(this.buffer, 0, cArr, 0, this.len);
        this.buffer = cArr;
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
        int i18 = this.len + i16;
        if (i18 > this.buffer.length) {
            expand(i18);
        }
        System.arraycopy(cArr, i3, this.buffer, this.len, i16);
        this.len = i18;
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.buffer[i3];
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

    public int indexOf(int i3, int i16, int i17) {
        if (i16 < 0) {
            i16 = 0;
        }
        int i18 = this.len;
        if (i17 > i18) {
            i17 = i18;
        }
        if (i16 > i17) {
            return -1;
        }
        while (i16 < i17) {
            if (this.buffer[i16] == i3) {
                return i16;
            }
            i16++;
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

    @Override // java.lang.CharSequence
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

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        if (i3 >= 0) {
            if (i16 <= this.len) {
                if (i3 <= i16) {
                    return CharBuffer.wrap(this.buffer, i3, i16);
                }
                throw new IndexOutOfBoundsException("beginIndex: " + i3 + " > endIndex: " + i16);
            }
            throw new IndexOutOfBoundsException("endIndex: " + i16 + " > length: " + this.len);
        }
        throw new IndexOutOfBoundsException("Negative beginIndex: " + i3);
    }

    public String substring(int i3, int i16) {
        if (i3 >= 0) {
            if (i16 <= this.len) {
                if (i3 <= i16) {
                    return new String(this.buffer, i3, i16 - i3);
                }
                throw new IndexOutOfBoundsException("beginIndex: " + i3 + " > endIndex: " + i16);
            }
            throw new IndexOutOfBoundsException("endIndex: " + i16 + " > length: " + this.len);
        }
        throw new IndexOutOfBoundsException("Negative beginIndex: " + i3);
    }

    public String substringTrimmed(int i3, int i16) {
        if (i3 >= 0) {
            if (i16 <= this.len) {
                if (i3 <= i16) {
                    while (i3 < i16 && HTTP.isWhitespace(this.buffer[i3])) {
                        i3++;
                    }
                    while (i16 > i3 && HTTP.isWhitespace(this.buffer[i16 - 1])) {
                        i16--;
                    }
                    return new String(this.buffer, i3, i16 - i3);
                }
                throw new IndexOutOfBoundsException("beginIndex: " + i3 + " > endIndex: " + i16);
            }
            throw new IndexOutOfBoundsException("endIndex: " + i16 + " > length: " + this.len);
        }
        throw new IndexOutOfBoundsException("Negative beginIndex: " + i3);
    }

    public char[] toCharArray() {
        int i3 = this.len;
        char[] cArr = new char[i3];
        if (i3 > 0) {
            System.arraycopy(this.buffer, 0, cArr, 0, i3);
        }
        return cArr;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }

    public int indexOf(int i3) {
        return indexOf(i3, 0, this.len);
    }

    public void append(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i3 = this.len + length;
        if (i3 > this.buffer.length) {
            expand(i3);
        }
        str.getChars(0, length, this.buffer, this.len);
        this.len = i3;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i3, int i16) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, i3, i16);
    }

    public void append(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, 0, charArrayBuffer.len);
    }

    public void append(char c16) {
        int i3 = this.len + 1;
        if (i3 > this.buffer.length) {
            expand(i3);
        }
        this.buffer[this.len] = c16;
        this.len = i3;
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
        int i18 = this.len;
        int i19 = i16 + i18;
        if (i19 > this.buffer.length) {
            expand(i19);
        }
        while (i18 < i19) {
            this.buffer[i18] = (char) (bArr[i3] & 255);
            i3++;
            i18++;
        }
        this.len = i19;
    }

    public void append(ByteArrayBuffer byteArrayBuffer, int i3, int i16) {
        if (byteArrayBuffer == null) {
            return;
        }
        append(byteArrayBuffer.buffer(), i3, i16);
    }

    public void append(Object obj) {
        append(String.valueOf(obj));
    }
}
