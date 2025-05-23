package org.light.extDecoder.apng.io;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: classes29.dex */
public class APNGReader extends FilterReader {
    private static ThreadLocal<byte[]> __intBytes = new ThreadLocal<>();

    public APNGReader(Reader reader) {
        super(reader);
    }

    protected static byte[] ensureBytes() {
        byte[] bArr = __intBytes.get();
        if (bArr == null) {
            byte[] bArr2 = new byte[4];
            __intBytes.set(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public boolean matchFourCC(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int readFourCC = readFourCC();
        for (int i3 = 0; i3 < 4; i3++) {
            if (((readFourCC >> (i3 * 8)) & 255) != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public int readFourCC() throws IOException {
        byte[] ensureBytes = ensureBytes();
        read(ensureBytes, 0, 4);
        return ((ensureBytes[3] & 255) << 24) | (ensureBytes[0] & 255) | ((ensureBytes[1] & 255) << 8) | ((ensureBytes[2] & 255) << 16);
    }

    public int readInt() throws IOException {
        byte[] ensureBytes = ensureBytes();
        read(ensureBytes, 0, 4);
        return ((ensureBytes[0] & 255) << 24) | (ensureBytes[3] & 255) | ((ensureBytes[2] & 255) << 8) | ((ensureBytes[1] & 255) << 16);
    }

    public short readShort() throws IOException {
        byte[] ensureBytes = ensureBytes();
        read(ensureBytes, 0, 2);
        return (short) (((ensureBytes[0] & 255) << 8) | (ensureBytes[1] & 255));
    }
}
