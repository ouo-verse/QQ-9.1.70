package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class Hex implements BinaryEncoder, BinaryDecoder {
    public Hex() {
        throw new RuntimeException("Stub!");
    }

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    public static char[] encodeHex(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    protected static int toDigit(char c16, int i3) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }
}
