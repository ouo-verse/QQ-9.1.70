package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Paint;
import java.util.ArrayList;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LyricDataUtil {
    public static String[] wrap(String str, Paint paint, int i3, int i16) {
        return wrap(str, paint, i3, i16, 99999);
    }

    public static String[] wrap(String str, Paint paint, int i3, int i16, int i17) {
        String str2;
        if (i3 <= 0 || i16 <= 0) {
            return new String[]{str};
        }
        if (((int) paint.measureText(str)) <= i3) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        char c16 = TokenParser.SP;
        int i18 = i3;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i27 < charArray.length) {
            char c17 = charArray[i27];
            boolean z16 = c17 == '\r' && i27 < charArray.length - 1 && charArray[i27 + 1] == '\n';
            if (c17 == '\n' || i27 == charArray.length - 1 || z16) {
                int i28 = i19 + 1;
                if (i27 == charArray.length - 1) {
                    str2 = new String(charArray, i26, (i27 + 1) - i26);
                } else {
                    str2 = new String(charArray, i26, i27 - i26);
                }
                int measureText = (int) paint.measureText(str2);
                if (measureText <= i18) {
                    arrayList.add(str2);
                } else {
                    wrap(str2, paint, measureText, i18, i16, arrayList);
                }
                if (z16) {
                    i27++;
                }
                i26 = i27 + 1;
                i18 = i16;
                i19 = i28;
            }
            i27++;
            c16 = c17;
        }
        if (i19 > 1 && c16 == '\n') {
            arrayList.add("");
        }
        int i29 = i17;
        if (i29 < 1) {
            i29 = 1;
        }
        while (arrayList.size() > i29) {
            arrayList.remove(arrayList.size() - 1);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void wrap(String str, Paint paint, int i3, int i16, int i17, ArrayList<String> arrayList) {
        char[] charArray = str.toCharArray();
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        while (i18 < charArray.length) {
            char c16 = charArray[i18];
            i26 += (int) paint.measureText(c16 + "");
            if (c16 == '\n') {
                arrayList.add(new String(charArray, i19, i18 - i19));
                i18++;
                i26 = 0;
                i16 = i17;
                i28 = -1;
                i19 = i18;
            } else if (i26 > i16 && i18 > 0) {
                if (c16 == ' ' || c16 == '\t') {
                    arrayList.add(new String(charArray, i19, i18 - i19));
                    i18++;
                    i26 = 0;
                    i28 = -1;
                } else if (i28 == -1) {
                    if (i18 > i19 + 1) {
                        i18--;
                    }
                    arrayList.add(new String(charArray, i19, i18 - i19));
                    i26 = 0;
                } else {
                    i26 -= i27;
                    arrayList.add(new String(charArray, i19, i28 - i19));
                    i19 = i28 + 1;
                    i28 = -1;
                    i16 = i17;
                }
                i19 = i18;
                i16 = i17;
            } else if (c16 == ' ' || c16 == '\t' || Character.isSpaceChar(c16)) {
                i28 = i18;
                i27 = i26;
            }
            i18++;
        }
        arrayList.add(new String(charArray, i19, charArray.length - i19));
    }
}
