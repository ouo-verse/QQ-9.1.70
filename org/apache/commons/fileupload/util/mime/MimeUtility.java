package org.apache.commons.fileupload.util.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MimeUtility {
    private static final String BASE64_ENCODING_MARKER = "B";
    private static final String ENCODED_TOKEN_FINISHER = "?=";
    private static final String ENCODED_TOKEN_MARKER = "=?";
    private static final String LINEAR_WHITESPACE = " \t\r\n";
    private static final Map<String, String> MIME2JAVA;
    private static final String QUOTEDPRINTABLE_ENCODING_MARKER = "Q";
    private static final String US_ASCII_CHARSET = "US-ASCII";

    static {
        HashMap hashMap = new HashMap();
        MIME2JAVA = hashMap;
        hashMap.put("iso-2022-cn", "ISO2022CN");
        hashMap.put("iso-2022-kr", "ISO2022KR");
        hashMap.put("utf-8", "UTF8");
        hashMap.put("utf8", "UTF8");
        hashMap.put("ja_jp.iso2022-7", "ISO2022JP");
        hashMap.put("ja_jp.eucjp", "EUCJIS");
        hashMap.put("euc-kr", "KSC5601");
        hashMap.put("euckr", "KSC5601");
        hashMap.put("us-ascii", "ISO-8859-1");
        hashMap.put("x-us-ascii", "ISO-8859-1");
    }

    MimeUtility() {
    }

    public static String decodeText(String str) throws UnsupportedEncodingException {
        if (str.indexOf(ENCODED_TOKEN_MARKER) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb5 = new StringBuilder(str.length());
        int i3 = 0;
        boolean z16 = false;
        int i16 = -1;
        int i17 = -1;
        while (i3 < length) {
            if (LINEAR_WHITESPACE.indexOf(str.charAt(i3)) != -1) {
                int i18 = i3;
                while (true) {
                    if (i18 < length) {
                        if (LINEAR_WHITESPACE.indexOf(str.charAt(i18)) != -1) {
                            i18++;
                        } else {
                            i17 = i18;
                            i16 = i3;
                            i3 = i17;
                            break;
                        }
                    } else {
                        int i19 = i18;
                        i16 = i3;
                        i3 = i19;
                        break;
                    }
                }
            } else {
                int i26 = i3;
                while (i26 < length && LINEAR_WHITESPACE.indexOf(str.charAt(i26)) == -1) {
                    i26++;
                }
                String substring = str.substring(i3, i26);
                if (substring.startsWith(ENCODED_TOKEN_MARKER)) {
                    try {
                        String decodeWord = decodeWord(substring);
                        if (!z16 && i16 != -1) {
                            sb5.append(str.substring(i16, i17));
                            i16 = -1;
                        }
                        sb5.append(decodeWord);
                        z16 = true;
                    } catch (ParseException unused) {
                    }
                    i3 = i26;
                }
                if (i16 != -1) {
                    sb5.append(str.substring(i16, i17));
                    i16 = -1;
                }
                sb5.append(substring);
                z16 = false;
                i3 = i26;
            }
        }
        return sb5.toString();
    }

    private static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        if (str.startsWith(ENCODED_TOKEN_MARKER)) {
            int indexOf = str.indexOf(63, 2);
            if (indexOf != -1) {
                String lowerCase = str.substring(2, indexOf).toLowerCase(Locale.ENGLISH);
                int i3 = indexOf + 1;
                int indexOf2 = str.indexOf(63, i3);
                if (indexOf2 != -1) {
                    String substring = str.substring(i3, indexOf2);
                    int i16 = indexOf2 + 1;
                    int indexOf3 = str.indexOf(ENCODED_TOKEN_FINISHER, i16);
                    if (indexOf3 != -1) {
                        String substring2 = str.substring(i16, indexOf3);
                        if (substring2.length() == 0) {
                            return "";
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(substring2.length());
                            byte[] bytes = substring2.getBytes("US-ASCII");
                            if (substring.equals(BASE64_ENCODING_MARKER)) {
                                Base64Decoder.decode(bytes, byteArrayOutputStream);
                            } else if (substring.equals("Q")) {
                                QuotedPrintableDecoder.decode(bytes, byteArrayOutputStream);
                            } else {
                                throw new UnsupportedEncodingException("Unknown RFC 2047 encoding: " + substring);
                            }
                            return new String(byteArrayOutputStream.toByteArray(), javaCharset(lowerCase));
                        } catch (IOException unused) {
                            throw new UnsupportedEncodingException("Invalid RFC 2047 encoding");
                        }
                    }
                    throw new ParseException("Missing encoded text in RFC 2047 encoded-word: " + str);
                }
                throw new ParseException("Missing encoding in RFC 2047 encoded-word: " + str);
            }
            throw new ParseException("Missing charset in RFC 2047 encoded-word: " + str);
        }
        throw new ParseException("Invalid RFC 2047 encoded-word: " + str);
    }

    private static String javaCharset(String str) {
        if (str == null) {
            return null;
        }
        String str2 = MIME2JAVA.get(str.toLowerCase(Locale.ENGLISH));
        if (str2 == null) {
            return str;
        }
        return str2;
    }
}
