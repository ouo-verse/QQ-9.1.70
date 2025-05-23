package com.tencent.opentelemetry.api.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class OtelEncodingUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String ALPHABET = "0123456789abcdef";
    static final int BYTE_BASE16 = 2;
    private static final byte[] DECODING;
    private static final char[] ENCODING;
    static final int LONG_BASE16 = 16;
    static final int LONG_BYTES = 8;
    private static final int NUM_ASCII_CHARACTERS = 128;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ENCODING = buildEncodingArray();
            DECODING = buildDecodingArray();
        }
    }

    OtelEncodingUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static byte[] buildDecodingArray() {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i3 = 0; i3 < 16; i3++) {
            bArr[ALPHABET.charAt(i3)] = (byte) i3;
        }
        return bArr;
    }

    private static char[] buildEncodingArray() {
        char[] cArr = new char[512];
        for (int i3 = 0; i3 < 256; i3++) {
            cArr[i3] = ALPHABET.charAt(i3 >>> 4);
            cArr[i3 | 256] = ALPHABET.charAt(i3 & 15);
        }
        return cArr;
    }

    public static byte byteFromBase16(char c16, char c17) {
        byte[] bArr;
        byte b16;
        byte b17;
        if (c16 < '\u0080' && (b16 = (bArr = DECODING)[c16]) != -1) {
            if (c17 < '\u0080' && (b17 = bArr[c17]) != -1) {
                return (byte) (b17 | (b16 << 4));
            }
            throw new IllegalArgumentException("invalid character " + c17);
        }
        throw new IllegalArgumentException("invalid character " + c16);
    }

    public static void byteToBase16(byte b16, char[] cArr, int i3) {
        int i16 = b16 & 255;
        char[] cArr2 = ENCODING;
        cArr[i3] = cArr2[i16];
        cArr[i3 + 1] = cArr2[i16 | 256];
    }

    public static byte[] bytesFromBase16(CharSequence charSequence, int i3) {
        byte[] bArr = new byte[i3 / 2];
        for (int i16 = 0; i16 < i3; i16 += 2) {
            bArr[i16 / 2] = byteFromBase16(charSequence.charAt(i16), charSequence.charAt(i16 + 1));
        }
        return bArr;
    }

    public static void bytesToBase16(byte[] bArr, char[] cArr, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            byteToBase16(bArr[i16], cArr, i16 * 2);
        }
    }

    public static boolean isValidBase16Character(char c16) {
        if (('0' <= c16 && c16 <= '9') || ('a' <= c16 && c16 <= 'f')) {
            return true;
        }
        return false;
    }

    public static boolean isValidBase16String(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (!isValidBase16Character(charSequence.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static long longFromBase16String(CharSequence charSequence, int i3) {
        return (byteFromBase16(charSequence.charAt(i3 + 14), charSequence.charAt(i3 + 15)) & 255) | ((byteFromBase16(charSequence.charAt(i3), charSequence.charAt(i3 + 1)) & 255) << 56) | ((byteFromBase16(charSequence.charAt(i3 + 2), charSequence.charAt(i3 + 3)) & 255) << 48) | ((byteFromBase16(charSequence.charAt(i3 + 4), charSequence.charAt(i3 + 5)) & 255) << 40) | ((byteFromBase16(charSequence.charAt(i3 + 6), charSequence.charAt(i3 + 7)) & 255) << 32) | ((byteFromBase16(charSequence.charAt(i3 + 8), charSequence.charAt(i3 + 9)) & 255) << 24) | ((byteFromBase16(charSequence.charAt(i3 + 10), charSequence.charAt(i3 + 11)) & 255) << 16) | ((byteFromBase16(charSequence.charAt(i3 + 12), charSequence.charAt(i3 + 13)) & 255) << 8);
    }

    public static void longToBase16String(long j3, char[] cArr, int i3) {
        byteToBase16((byte) ((j3 >> 56) & 255), cArr, i3);
        byteToBase16((byte) ((j3 >> 48) & 255), cArr, i3 + 2);
        byteToBase16((byte) ((j3 >> 40) & 255), cArr, i3 + 4);
        byteToBase16((byte) ((j3 >> 32) & 255), cArr, i3 + 6);
        byteToBase16((byte) ((j3 >> 24) & 255), cArr, i3 + 8);
        byteToBase16((byte) ((j3 >> 16) & 255), cArr, i3 + 10);
        byteToBase16((byte) ((j3 >> 8) & 255), cArr, i3 + 12);
        byteToBase16((byte) (j3 & 255), cArr, i3 + 14);
    }
}
