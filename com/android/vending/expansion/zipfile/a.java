package com.android.vending.expansion.zipfile;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes.dex */
public class a {
    static String[] a(Context context, int i3, int i16) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/obb/" + packageName);
            if (file.exists()) {
                if (i3 > 0) {
                    String str = file + File.separator + "main." + i3 + "." + packageName + ".obb";
                    if (new File(str).isFile()) {
                        vector.add(str);
                    }
                }
                if (i16 > 0) {
                    String str2 = file + File.separator + "patch." + i3 + "." + packageName + ".obb";
                    if (new File(str2).isFile()) {
                        vector.add(str2);
                    }
                }
            }
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public static b b(Context context, int i3, int i16) throws IOException {
        return c(a(context, i3, i16));
    }

    public static b c(String[] strArr) throws IOException {
        b bVar = null;
        for (String str : strArr) {
            if (bVar == null) {
                bVar = new b(str);
            } else {
                bVar.a(str);
            }
        }
        return bVar;
    }
}
