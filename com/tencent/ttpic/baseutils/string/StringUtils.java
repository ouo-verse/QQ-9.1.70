package com.tencent.ttpic.baseutils.string;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StringUtils {
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence.equals(charSequence2)) {
            return true;
        }
        return false;
    }

    public static String removeEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("\\[em\\].*?\\[/em\\]", "");
    }

    public static String removeNoisyChar(String str) {
        return str.replaceAll("[/~!@#$%^&*\\(\\)_+\\{\\}:<>?\\[\\],./;'`\\-=\\|\uff0f\uff5e\uff01\uff20\uff03\uff04\uff05\uff3e\uff06\uff0a\uff08\uff09\uff3f\uff0b\uff5b\uff5d\uff1a\uff1c\uff1e\uff1f\uff3b\uff3d\uff0c\u3002\uff0e\uff0f\uff1b\uff07`\uff0d\uff1d\uff5c\u3001]+", "");
    }

    public static String removeUTF8Emoji(String str) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < str.length(); i3++) {
            int type = Character.getType(str.charAt(i3));
            if (type == 19 || type == 28) {
                hashSet.add(Character.valueOf(str.charAt(i3)));
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            str = str.replace(String.valueOf((Character) it.next()), "");
        }
        return str;
    }
}
