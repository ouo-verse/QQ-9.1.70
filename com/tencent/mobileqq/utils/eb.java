package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class eb {
    public static Set<String> a(SharedPreferences sharedPreferences, String str, Set<String> set) {
        return d(sharedPreferences.getString(str, ""), set);
    }

    public static SharedPreferences.Editor b(SharedPreferences.Editor editor, String str, Set<String> set) {
        return c(editor, str, set.toArray());
    }

    public static SharedPreferences.Editor c(SharedPreferences.Editor editor, String str, Object[] objArr) {
        String str2 = "";
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                str2 = (str2 + obj.toString()) + " ";
            }
            editor.putString(str, str2);
        } else {
            editor.putString(str, "");
        }
        return editor;
    }

    private static Set<String> d(String str, Set<String> set) {
        if (str != null && str.length() > 0) {
            String[] split = str.split(" ");
            set = new HashSet<>();
            for (String str2 : split) {
                if (str2 != null && str2.length() > 0) {
                    set.add(str2);
                }
            }
        }
        return set;
    }
}
