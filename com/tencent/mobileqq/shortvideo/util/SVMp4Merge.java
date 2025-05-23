package com.tencent.mobileqq.shortvideo.util;

import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SVMp4Merge {

    /* renamed from: a, reason: collision with root package name */
    public static int f288242a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static int f288243b;

    public static int a(List<String> list, String str) {
        StringBuilder sb5 = new StringBuilder();
        int size = list.size();
        int i3 = -1;
        if (size <= 1) {
            return -1;
        }
        int i16 = size - 1;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            sb5.append(list.get(i18));
            if (i18 != i16) {
                sb5.append('#');
            }
            File file = new File(list.get(i18));
            if (file.exists()) {
                i17 += (int) file.length();
            }
        }
        if (i17 <= 0) {
            return -1;
        }
        try {
            nativeSetDropStrategy(f288242a, f288243b);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        try {
            i3 = nativeMergeMp4(sb5.toString().getBytes(), str, size, i17);
        } catch (UnsatisfiedLinkError e17) {
            e17.printStackTrace();
        }
        File file2 = new File(str);
        if (file2.exists() && i3 < 0) {
            file2.delete();
        }
        return i3;
    }

    private static native int nativeMergeMp4(byte[] bArr, String str, int i3, int i16);

    private static native void nativeSetDropStrategy(int i3, int i16);
}
