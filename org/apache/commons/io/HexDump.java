package org.apache.commons.io;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    private static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    public static void dump(byte[] bArr, long j3, OutputStream outputStream, int i3) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i3 < 0 || i3 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i3 + " into array of length " + bArr.length);
        }
        if (outputStream != null) {
            long j16 = j3 + i3;
            StringBuilder sb5 = new StringBuilder(74);
            while (i3 < bArr.length) {
                int length = bArr.length - i3;
                if (length > 16) {
                    length = 16;
                }
                dump(sb5, j16).append(TokenParser.SP);
                for (int i16 = 0; i16 < 16; i16++) {
                    if (i16 < length) {
                        dump(sb5, bArr[i16 + i3]);
                    } else {
                        sb5.append("  ");
                    }
                    sb5.append(TokenParser.SP);
                }
                for (int i17 = 0; i17 < length; i17++) {
                    byte b16 = bArr[i17 + i3];
                    if (b16 >= 32 && b16 < Byte.MAX_VALUE) {
                        sb5.append((char) b16);
                    } else {
                        sb5.append('.');
                    }
                }
                sb5.append(EOL);
                outputStream.write(sb5.toString().getBytes(Charset.defaultCharset()));
                outputStream.flush();
                sb5.setLength(0);
                j16 += length;
                i3 += 16;
            }
            return;
        }
        throw new IllegalArgumentException("cannot write to nullstream");
    }

    private static StringBuilder dump(StringBuilder sb5, long j3) {
        for (int i3 = 0; i3 < 8; i3++) {
            sb5.append(_hexcodes[((int) (j3 >> _shifts[i3])) & 15]);
        }
        return sb5;
    }

    private static StringBuilder dump(StringBuilder sb5, byte b16) {
        for (int i3 = 0; i3 < 2; i3++) {
            sb5.append(_hexcodes[(b16 >> _shifts[i3 + 6]) & 15]);
        }
        return sb5;
    }
}
