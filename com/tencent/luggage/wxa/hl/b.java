package com.tencent.luggage.wxa.hl;

import com.tencent.luggage.wxa.tn.w;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static CodingErrorAction f127246a = CodingErrorAction.REPORT;

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e16) {
            w.b("MicroMsg.AppBrandNetWork.Charsetfunctions", e16.toString());
            return new byte[0];
        }
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e16) {
            w.b("MicroMsg.AppBrandNetWork.Charsetfunctions", e16.toString());
            return new byte[0];
        }
    }

    public static String a(byte[] bArr, int i3, int i16) {
        try {
            return new String(bArr, i3, i16, "ASCII");
        } catch (UnsupportedEncodingException e16) {
            w.b("MicroMsg.AppBrandNetWork.Charsetfunctions", e16.toString());
            return "";
        }
    }

    public static String a(ByteBuffer byteBuffer) {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(f127246a);
        newDecoder.onUnmappableCharacter(f127246a);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e16) {
            throw new com.tencent.luggage.wxa.el.b(1007, e16);
        }
    }
}
