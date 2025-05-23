package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
abstract class RFC1522Codec {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RFC1522Codec() {
        throw new RuntimeException("Stub!");
    }

    protected String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    protected abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    protected abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    protected String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    protected abstract String getEncoding();
}
