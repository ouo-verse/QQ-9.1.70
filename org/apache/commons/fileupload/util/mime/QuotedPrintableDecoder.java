package org.apache.commons.fileupload.util.mime;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes29.dex */
final class QuotedPrintableDecoder {
    private static final int UPPER_NIBBLE_SHIFT = 4;

    QuotedPrintableDecoder() {
    }

    public static int decode(byte[] bArr, OutputStream outputStream) throws IOException {
        int i3 = 0;
        int length = bArr.length + 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i3 + 1;
            int i18 = bArr[i3];
            if (i18 == 95) {
                outputStream.write(32);
            } else if (i18 == 61) {
                int i19 = i17 + 1;
                if (i19 < length) {
                    byte b16 = bArr[i17];
                    int i26 = i19 + 1;
                    byte b17 = bArr[i19];
                    if (b16 == 13) {
                        if (b17 != 10) {
                            throw new IOException("Invalid quoted printable encoding; CR must be followed by LF");
                        }
                    } else {
                        outputStream.write(hexToBinary(b17) | (hexToBinary(b16) << 4));
                        i16++;
                    }
                    i3 = i26;
                } else {
                    throw new IOException("Invalid quoted printable encoding; truncated escape sequence");
                }
            } else {
                outputStream.write(i18);
                i16++;
            }
            i3 = i17;
        }
        return i16;
    }

    private static int hexToBinary(byte b16) throws IOException {
        int digit = Character.digit((char) b16, 16);
        if (digit != -1) {
            return digit;
        }
        throw new IOException("Invalid quoted printable encoding: not a valid hex digit: " + ((int) b16));
    }
}
