package com.tencent.luggage.wxa.kj;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w {
    public static String a(String str) {
        int indexOf = str.indexOf("<page>");
        int indexOf2 = str.indexOf("</page>");
        if (indexOf != -1 && indexOf2 != (-indexOf)) {
            return str.substring(indexOf + 6, indexOf2);
        }
        return "";
    }

    public static String b(String str) {
        String str2;
        int i3 = 0;
        String str3 = "";
        while (true) {
            int indexOf = str.indexOf("<script>", i3);
            int indexOf2 = str.indexOf("</script>", i3);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                break;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            if (i3 <= 0) {
                str2 = "";
            } else {
                str2 = ";";
            }
            sb5.append(str2);
            sb5.append(str.substring(indexOf + 8, indexOf2));
            str3 = sb5.toString();
            i3 = indexOf2 + 9;
        }
        return str3;
    }

    public static String c(String str) {
        int indexOf = str.indexOf("<style>");
        int indexOf2 = str.indexOf("</style>");
        if (indexOf != -1 && indexOf2 != (-indexOf)) {
            return str.substring(indexOf + 7, indexOf2);
        }
        return "";
    }
}
