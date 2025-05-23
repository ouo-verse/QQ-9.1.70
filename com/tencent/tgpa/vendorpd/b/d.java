package com.tencent.tgpa.vendorpd.b;

import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    public static File a(String str) {
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public static String b(File file) {
        if (file != null) {
            return file.getName();
        }
        return null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return b(a(str));
    }

    public static boolean a(File file) {
        return file != null && file.exists();
    }

    public static boolean b(String str) {
        return a(a(str));
    }
}
