package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class a {
    public static boolean a(char c16) {
        if (c16 >= 'A' && c16 <= 'Z') {
            return true;
        }
        return false;
    }

    public static String b(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            if (a(str.charAt(i3))) {
                char[] charArray = str.toCharArray();
                while (i3 < length) {
                    char c16 = charArray[i3];
                    if (a(c16)) {
                        charArray[i3] = (char) (c16 ^ TokenParser.SP);
                    }
                    i3++;
                }
                return String.valueOf(charArray);
            }
            i3++;
        }
        return str;
    }
}
