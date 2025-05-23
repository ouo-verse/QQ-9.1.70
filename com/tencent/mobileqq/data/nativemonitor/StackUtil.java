package com.tencent.mobileqq.data.nativemonitor;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StackUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f203161a = new HashSet<String>() { // from class: com.tencent.mobileqq.data.nativemonitor.StackUtil.1
        {
            add("android.");
            add("java.");
            add("dalvik.");
            add("javax.");
            add("junit.");
            add("org.apache.http.");
            add("org.json.");
            add("org.w3c.");
            add("org.xml.");
            add("org.xmlpull.");
            add("UnityEngine.");
            add("com.unity3d.");
            add("androidx.");
            add("kotlin.");
            add("com.android");
            add("libcore.");
            add("com.tencent.mobileqq.nativememorymonitor.library.");
        }
    };

    public static String a(String str, int i3, int i16) {
        if (str == null) {
            return "";
        }
        return b(str.split("\n"), i3, i16);
    }

    private static String b(String[] strArr, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        for (int i17 = i3; i17 < strArr.length && i17 < i3 + i16; i17++) {
            String e16 = e(strArr[i17]);
            if (!d(e16)) {
                sb5.append(e16);
                sb5.append("\n");
            }
        }
        return f(sb5.toString());
    }

    public static String c(StackTraceElement[] stackTraceElementArr, int i3, int i16) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i17 = 0; i17 < stackTraceElementArr.length && i17 < i3 + i16; i17++) {
            if (i17 >= i3) {
                sb5.append(stackTraceElementArr[i17]);
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    private static boolean d(String str) {
        Iterator<String> it = f203161a.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static String e(@NonNull String str) {
        return str.replaceAll("^.*at ", "");
    }

    private static String f(@NonNull String str) {
        return str.replaceAll("\\((.+)\\)", "");
    }
}
