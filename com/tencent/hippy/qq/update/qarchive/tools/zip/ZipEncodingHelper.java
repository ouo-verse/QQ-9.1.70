package com.tencent.hippy.qq.update.qarchive.tools.zip;

import com.tencent.mobileqq.text.AbsQQText;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class ZipEncodingHelper {
    private static final byte[] HEX_DIGITS;
    static final String UTF8 = "UTF8";
    static final ZipEncoding UTF8_ZIP_ENCODING;
    private static final String UTF_DASH_8 = "utf-8";
    private static final Map<String, SimpleEncodingHolder> simpleEncodings;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class SimpleEncodingHolder {
        private Simple8BitZipEncoding encoding;
        private final char[] highChars;

        SimpleEncodingHolder(char[] cArr) {
            this.highChars = cArr;
        }

        public synchronized Simple8BitZipEncoding getEncoding() {
            if (this.encoding == null) {
                this.encoding = new Simple8BitZipEncoding(this.highChars);
            }
            return this.encoding;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        SimpleEncodingHolder simpleEncodingHolder = new SimpleEncodingHolder(new char[]{'\u00c7', '\u00fc', '\u00e9', '\u00e2', '\u00e4', '\u00e0', '\u00e5', '\u00e7', '\u00ea', '\u00eb', '\u00e8', '\u00ef', '\u00ee', '\u00ec', '\u00c4', '\u00c5', '\u00c9', '\u00e6', '\u00c6', '\u00f4', '\u00f6', '\u00f2', '\u00fb', '\u00f9', '\u00ff', '\u00d6', '\u00dc', Typography.cent, Typography.pound, '\u00a5', '\u20a7', '\u0192', '\u00e1', '\u00ed', '\u00f3', AbsQQText.RF, '\u00f1', '\u00d1', '\u00aa', '\u00ba', '\u00bf', '\u2310', '\u00ac', Typography.half, '\u00bc', '\u00a1', '\u00ab', '\u00bb', '\u2591', '\u2592', '\u2593', '\u2502', '\u2524', '\u2561', '\u2562', '\u2556', '\u2555', '\u2563', '\u2551', '\u2557', '\u255d', '\u255c', '\u255b', '\u2510', '\u2514', '\u2534', '\u252c', '\u251c', '\u2500', '\u253c', '\u255e', '\u255f', '\u255a', '\u2554', '\u2569', '\u2566', '\u2560', '\u2550', '\u256c', '\u2567', '\u2568', '\u2564', '\u2565', '\u2559', '\u2558', '\u2552', '\u2553', '\u256b', '\u256a', '\u2518', '\u250c', '\u2588', '\u2584', '\u258c', '\u2590', '\u2580', '\u03b1', '\u00df', '\u0393', '\u03c0', '\u03a3', '\u03c3', '\u00b5', '\u03c4', '\u03a6', '\u0398', '\u03a9', '\u03b4', '\u221e', '\u03c6', '\u03b5', '\u2229', '\u2261', Typography.plusMinus, Typography.greaterOrEqual, Typography.lessOrEqual, '\u2320', '\u2321', '\u00f7', Typography.almostEqual, Typography.degree, '\u2219', Typography.middleDot, '\u221a', '\u207f', '\u00b2', '\u25a0', Typography.nbsp});
        hashMap.put("CP437", simpleEncodingHolder);
        hashMap.put("Cp437", simpleEncodingHolder);
        hashMap.put("cp437", simpleEncodingHolder);
        hashMap.put("IBM437", simpleEncodingHolder);
        hashMap.put("ibm437", simpleEncodingHolder);
        SimpleEncodingHolder simpleEncodingHolder2 = new SimpleEncodingHolder(new char[]{'\u00c7', '\u00fc', '\u00e9', '\u00e2', '\u00e4', '\u00e0', '\u00e5', '\u00e7', '\u00ea', '\u00eb', '\u00e8', '\u00ef', '\u00ee', '\u00ec', '\u00c4', '\u00c5', '\u00c9', '\u00e6', '\u00c6', '\u00f4', '\u00f6', '\u00f2', '\u00fb', '\u00f9', '\u00ff', '\u00d6', '\u00dc', '\u00f8', Typography.pound, '\u00d8', Typography.times, '\u0192', '\u00e1', '\u00ed', '\u00f3', AbsQQText.RF, '\u00f1', '\u00d1', '\u00aa', '\u00ba', '\u00bf', Typography.registered, '\u00ac', Typography.half, '\u00bc', '\u00a1', '\u00ab', '\u00bb', '\u2591', '\u2592', '\u2593', '\u2502', '\u2524', '\u00c1', '\u00c2', '\u00c0', Typography.copyright, '\u2563', '\u2551', '\u2557', '\u255d', Typography.cent, '\u00a5', '\u2510', '\u2514', '\u2534', '\u252c', '\u251c', '\u2500', '\u253c', '\u00e3', '\u00c3', '\u255a', '\u2554', '\u2569', '\u2566', '\u2560', '\u2550', '\u256c', '\u00a4', '\u00f0', '\u00d0', '\u00ca', '\u00cb', '\u00c8', '\u0131', '\u00cd', '\u00ce', '\u00cf', '\u2518', '\u250c', '\u2588', '\u2584', '\u00a6', '\u00cc', '\u2580', '\u00d3', '\u00df', '\u00d4', '\u00d2', '\u00f5', '\u00d5', '\u00b5', AbsQQText.ENTER_REPLACE, '\u00de', '\u00da', '\u00db', '\u00d9', AbsQQText.HEAD_INDEX_REPLACE, '\u00dd', '\u00af', '\u00b4', '\u00ad', Typography.plusMinus, '\u2017', '\u00be', Typography.paragraph, Typography.section, '\u00f7', '\u00b8', Typography.degree, '\u00a8', Typography.middleDot, '\u00b9', '\u00b3', '\u00b2', '\u25a0', Typography.nbsp});
        hashMap.put("CP850", simpleEncodingHolder2);
        hashMap.put("Cp850", simpleEncodingHolder2);
        hashMap.put("cp850", simpleEncodingHolder2);
        hashMap.put("IBM850", simpleEncodingHolder2);
        hashMap.put("ibm850", simpleEncodingHolder2);
        simpleEncodings = Collections.unmodifiableMap(hashMap);
        HEX_DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        UTF8_ZIP_ENCODING = new FallbackZipEncoding(UTF8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appendSurrogate(ByteBuffer byteBuffer, char c16) {
        byteBuffer.put((byte) 37);
        byteBuffer.put((byte) 85);
        byte[] bArr = HEX_DIGITS;
        byteBuffer.put(bArr[(c16 >> '\f') & 15]);
        byteBuffer.put(bArr[(c16 >> '\b') & 15]);
        byteBuffer.put(bArr[(c16 >> 4) & 15]);
        byteBuffer.put(bArr[c16 & 15]);
    }

    public static ZipEncoding getZipEncoding(String str) {
        if (isUTF8(str)) {
            return UTF8_ZIP_ENCODING;
        }
        if (str == null) {
            return new FallbackZipEncoding();
        }
        SimpleEncodingHolder simpleEncodingHolder = simpleEncodings.get(str);
        if (simpleEncodingHolder != null) {
            return simpleEncodingHolder.getEncoding();
        }
        try {
            return new NioZipEncoding(Charset.forName(str));
        } catch (UnsupportedCharsetException unused) {
            return new FallbackZipEncoding(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer growBuffer(ByteBuffer byteBuffer, int i3) {
        byteBuffer.limit(byteBuffer.position());
        byteBuffer.rewind();
        int capacity = byteBuffer.capacity() * 2;
        if (capacity >= i3) {
            i3 = capacity;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.put(byteBuffer);
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUTF8(String str) {
        if (str == null) {
            str = System.getProperty("file.encoding");
        }
        if (!UTF8.equalsIgnoreCase(str) && !"utf-8".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
