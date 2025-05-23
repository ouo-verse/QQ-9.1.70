package com.tencent.turingcam;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YaDRx {
    public static String a(String str) {
        int indexOf;
        String[] split = str.split(" ", 3);
        if (split.length <= 2 || !"rwxp".equals(split[1]) || (indexOf = split[2].indexOf(47)) == -1) {
            return null;
        }
        String trim = split[2].substring(indexOf).trim();
        if (trim.startsWith("/data/")) {
            return null;
        }
        return split[1] + ";" + trim;
    }
}
