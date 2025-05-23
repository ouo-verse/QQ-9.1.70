package com.tencent.hippy.qq.update.qarchive.tools.zip;

import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class Simple8BitZipEncoding implements ZipEncoding {
    private final char[] highChars;
    private final List<Simple8BitChar> reverseMapping;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Simple8BitChar implements Comparable<Simple8BitChar> {
        public final byte code;
        public final char unicode;

        Simple8BitChar(byte b16, char c16) {
            this.code = b16;
            this.unicode = c16;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Simple8BitChar)) {
                return false;
            }
            Simple8BitChar simple8BitChar = (Simple8BitChar) obj;
            if (this.unicode != simple8BitChar.unicode || this.code != simple8BitChar.code) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.unicode;
        }

        public String toString() {
            return RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString('\uffff' & this.unicode) + "->0x" + Integer.toHexString(this.code & 255);
        }

        @Override // java.lang.Comparable
        public int compareTo(Simple8BitChar simple8BitChar) {
            return this.unicode - simple8BitChar.unicode;
        }
    }

    public Simple8BitZipEncoding(char[] cArr) {
        char[] cArr2 = (char[]) cArr.clone();
        this.highChars = cArr2;
        ArrayList arrayList = new ArrayList(cArr2.length);
        byte b16 = Byte.MAX_VALUE;
        int i3 = 0;
        while (true) {
            char[] cArr3 = this.highChars;
            if (i3 < cArr3.length) {
                b16 = (byte) (b16 + 1);
                arrayList.add(new Simple8BitChar(b16, cArr3[i3]));
                i3++;
            } else {
                Collections.sort(arrayList);
                this.reverseMapping = Collections.unmodifiableList(arrayList);
                return;
            }
        }
    }

    private Simple8BitChar encodeHighChar(char c16) {
        int size = this.reverseMapping.size();
        int i3 = 0;
        while (size > i3) {
            int i16 = ((size - i3) / 2) + i3;
            Simple8BitChar simple8BitChar = this.reverseMapping.get(i16);
            char c17 = simple8BitChar.unicode;
            if (c17 == c16) {
                return simple8BitChar;
            }
            if (c17 < c16) {
                i3 = i16 + 1;
            } else {
                size = i16;
            }
        }
        if (i3 >= this.reverseMapping.size()) {
            return null;
        }
        Simple8BitChar simple8BitChar2 = this.reverseMapping.get(i3);
        if (simple8BitChar2.unicode != c16) {
            return null;
        }
        return simple8BitChar2;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
    public boolean canEncode(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!canEncodeChar(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public boolean canEncodeChar(char c16) {
        if ((c16 >= 0 && c16 < '\u0080') || encodeHighChar(c16) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
    public String decode(byte[] bArr) throws IOException {
        char[] cArr = new char[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            cArr[i3] = decodeByte(bArr[i3]);
        }
        return new String(cArr);
    }

    public char decodeByte(byte b16) {
        if (b16 >= 0) {
            return (char) b16;
        }
        return this.highChars[b16 + 128];
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
    public ByteBuffer encode(String str) {
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 6 + ((str.length() + 1) / 2));
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (allocate.remaining() < 6) {
                allocate = ZipEncodingHelper.growBuffer(allocate, allocate.position() + 6);
            }
            if (!pushEncodedChar(allocate, charAt)) {
                ZipEncodingHelper.appendSurrogate(allocate, charAt);
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }

    public boolean pushEncodedChar(ByteBuffer byteBuffer, char c16) {
        if (c16 >= 0 && c16 < '\u0080') {
            byteBuffer.put((byte) c16);
            return true;
        }
        Simple8BitChar encodeHighChar = encodeHighChar(c16);
        if (encodeHighChar == null) {
            return false;
        }
        byteBuffer.put(encodeHighChar.code);
        return true;
    }
}
