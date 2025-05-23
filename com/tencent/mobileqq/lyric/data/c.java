package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(String str, Paint paint, int i3, int i16, int i17, ArrayList<String> arrayList) {
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
                if (c16 != ' ' && c16 != '\t') {
                    if (i28 == -1) {
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
                } else {
                    arrayList.add(new String(charArray, i19, i18 - i19));
                    i18++;
                    i26 = 0;
                    i28 = -1;
                }
                i19 = i18;
                i16 = i17;
            } else if (c16 == ' ' || c16 == '\t') {
                i28 = i18;
                i27 = i26;
            }
            i18++;
        }
        arrayList.add(new String(charArray, i19, charArray.length - i19));
    }

    public static String[] b(String str, Paint paint, int i3, int i16) {
        return c(str, paint, i3, i16, 99999);
    }

    public static String[] c(String str, Paint paint, int i3, int i16, int i17) {
        boolean z16;
        String str2;
        if (i3 > 0 && i16 > 0) {
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
                if (c17 == '\r' && i27 < charArray.length - 1 && charArray[i27 + 1] == '\n') {
                    z16 = true;
                } else {
                    z16 = false;
                }
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
                        a(str2, paint, measureText, i18, i16, arrayList);
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
            if (i19 > 1 && (c16 == '\n' || c16 == '\n')) {
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
        return new String[]{str};
    }
}
