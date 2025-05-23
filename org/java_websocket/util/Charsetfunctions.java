package org.java_websocket.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidEncodingException;

/* compiled from: P */
/* loaded from: classes37.dex */
public class Charsetfunctions {
    private static final CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
    private static final int[] utf8d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 1, 2, 3, 5, 8, 7, 1, 1, 1, 4, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    Charsetfunctions() {
    }

    public static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new InvalidEncodingException(e16);
        }
    }

    public static boolean isValidUTF8(ByteBuffer byteBuffer, int i3) {
        int remaining = byteBuffer.remaining();
        if (remaining < i3) {
            return false;
        }
        int i16 = 0;
        while (i3 < remaining) {
            int[] iArr = utf8d;
            i16 = iArr[(i16 << 4) + 256 + iArr[byteBuffer.get(i3) & 255]];
            if (i16 == 1) {
                return false;
            }
            i3++;
        }
        return true;
    }

    public static String stringAscii(byte[] bArr) {
        return stringAscii(bArr, 0, bArr.length);
    }

    public static String stringUtf8(byte[] bArr) throws InvalidDataException {
        return stringUtf8(ByteBuffer.wrap(bArr));
    }

    public static byte[] utf8Bytes(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e16) {
            throw new InvalidEncodingException(e16);
        }
    }

    public static String stringAscii(byte[] bArr, int i3, int i16) {
        try {
            return new String(bArr, i3, i16, "ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new InvalidEncodingException(e16);
        }
    }

    public static String stringUtf8(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        CodingErrorAction codingErrorAction2 = codingErrorAction;
        newDecoder.onMalformedInput(codingErrorAction2);
        newDecoder.onUnmappableCharacter(codingErrorAction2);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e16) {
            throw new InvalidDataException(1007, e16);
        }
    }

    public static boolean isValidUTF8(ByteBuffer byteBuffer) {
        return isValidUTF8(byteBuffer, 0);
    }
}
