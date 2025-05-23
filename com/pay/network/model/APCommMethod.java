package com.pay.network.model;

import java.util.List;

/* loaded from: classes2.dex */
public class APCommMethod {
    public static void transformStrToList(String str, List<String> list) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        list.clear();
        if (indexOf != -1 && indexOf2 != -1 && indexOf2 > indexOf) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() != 0) {
                for (String str2 : substring.split(",")) {
                    list.add(str2);
                }
            }
        }
    }

    public static void transformStrToMpInfoList(String str, List<String> list, List<String> list2) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (indexOf != -1 && indexOf2 != -1 && indexOf2 > indexOf) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() == 0) {
                list.clear();
                list2.clear();
                return;
            }
            String[] split = substring.split(",");
            int length = split.length;
            if (length > 0 && length % 2 == 0) {
                list.clear();
                list2.clear();
                for (int i3 = 0; i3 < length / 2; i3++) {
                    int i16 = i3 * 2;
                    String str2 = split[i16];
                    String str3 = split[i16 + 1];
                    list.add(str2);
                    list2.add(str3);
                }
            }
        }
    }
}
