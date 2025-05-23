package org.apache.httpcore.util;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TextUtils {
    public static boolean containsBlanks(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (Character.isWhitespace(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (!Character.isWhitespace(charSequence.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        return false;
    }
}
