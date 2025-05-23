package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HttpException extends Exception {
    private static final int FIRST_VALID_CHAR = 32;
    private static final long serialVersionUID = -5437299376222011036L;

    public HttpException() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String clean(String str) {
        char[] charArray = str.toCharArray();
        int i3 = 0;
        while (i3 < charArray.length && charArray[i3] >= ' ') {
            i3++;
        }
        if (i3 == charArray.length) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(charArray.length * 2);
        for (int i16 = 0; i16 < charArray.length; i16++) {
            char c16 = charArray[i16];
            if (c16 < ' ') {
                sb5.append("[0x");
                String hexString = Integer.toHexString(i16);
                if (hexString.length() == 1) {
                    sb5.append("0");
                }
                sb5.append(hexString);
                sb5.append("]");
            } else {
                sb5.append(c16);
            }
        }
        return sb5.toString();
    }

    public HttpException(String str) {
        super(clean(str));
    }

    public HttpException(String str, Throwable th5) {
        super(clean(str));
        initCause(th5);
    }
}
