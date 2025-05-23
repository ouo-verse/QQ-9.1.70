package com.tencent.qqlive.tvkplayer.tools.utils;

/* loaded from: classes23.dex */
public class TVKLongTextPrinter {
    private static final int WRAP_AT_COLUMN_BY_DEFAULT = 4096;

    /* loaded from: classes23.dex */
    public interface Printer {
        void print(String str);
    }

    public static void print(String str, Printer printer) {
        print(str, 4096, printer);
    }

    public static void print(String str, int i3, Printer printer) {
        if (str == null || i3 <= 0 || printer == null) {
            return;
        }
        int length = str.length() / i3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            int i18 = i17 + i3;
            printer.print(str.substring(i17, i18));
            i16++;
            i17 = i18;
        }
        printer.print(str.substring(i17));
    }
}
