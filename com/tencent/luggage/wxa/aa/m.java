package com.tencent.luggage.wxa.aa;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static BitSet f121033a = new BitSet(256);

    /* renamed from: b, reason: collision with root package name */
    public static String f121034b;

    static {
        for (int i3 = 97; i3 <= 122; i3++) {
            f121033a.set(i3);
        }
        for (int i16 = 65; i16 <= 90; i16++) {
            f121033a.set(i16);
        }
        for (int i17 = 48; i17 <= 57; i17++) {
            f121033a.set(i17);
        }
        f121033a.set(45);
        f121033a.set(95);
        f121033a.set(46);
        f121033a.set(42);
        f121034b = (String) AccessController.doPrivileged(new f("file.encoding"));
    }

    public static String a(String str) {
        try {
            return a(str, f121034b);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        BitSet bitSet;
        int i3;
        char charAt;
        StringBuffer stringBuffer = new StringBuffer(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (str2 != null) {
            try {
                Charset forName = Charset.forName(str2);
                int i16 = 0;
                boolean z16 = false;
                while (i16 < str.length()) {
                    char charAt2 = str.charAt(i16);
                    if (f121033a.get(charAt2)) {
                        if (charAt2 == ' ') {
                            z16 = true;
                        }
                        stringBuffer.append(charAt2);
                        i16++;
                    } else {
                        do {
                            charArrayWriter.write(charAt2);
                            if (charAt2 >= '\ud800' && charAt2 <= '\udbff' && (i3 = i16 + 1) < str.length() && (charAt = str.charAt(i3)) >= '\udc00' && charAt <= '\udfff') {
                                charArrayWriter.write(charAt);
                                i16 = i3;
                            }
                            i16++;
                            if (i16 >= str.length()) {
                                break;
                            }
                            bitSet = f121033a;
                            charAt2 = str.charAt(i16);
                        } while (!bitSet.get(charAt2));
                        charArrayWriter.flush();
                        String str3 = new String(charArrayWriter.toCharArray());
                        byte[] a16 = a(str3, forName);
                        if (a16 == null) {
                            a16 = str3.getBytes();
                        }
                        for (int i17 = 0; i17 < a16.length; i17++) {
                            stringBuffer.append('%');
                            char forDigit = Character.forDigit((a16[i17] >> 4) & 15, 16);
                            if (Character.isLetter(forDigit)) {
                                forDigit = (char) (forDigit - ' ');
                            }
                            stringBuffer.append(forDigit);
                            char forDigit2 = Character.forDigit(a16[i17] & RegisterType.DOUBLE_HI, 16);
                            if (Character.isLetter(forDigit2)) {
                                forDigit2 = (char) (forDigit2 - ' ');
                            }
                            stringBuffer.append(forDigit2);
                        }
                        charArrayWriter.reset();
                        z16 = true;
                    }
                }
                return z16 ? stringBuffer.toString() : str;
            } catch (IllegalCharsetNameException unused) {
                throw new UnsupportedEncodingException(str2);
            } catch (UnsupportedCharsetException unused2) {
                throw new UnsupportedEncodingException(str2);
            }
        }
        throw new NullPointerException("charsetName");
    }

    public static byte[] a(String str, Charset charset) {
        return new l().a(str, charset);
    }
}
