package com.tencent.open.base;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BspatchUtil {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f340957a = "com.tencent.open.base.BspatchUtil";

    /* renamed from: b, reason: collision with root package name */
    protected static boolean f340958b = false;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("bspatch");
            f340958b = true;
        } catch (Throwable th5) {
            f.c(f340957a, "load bspatch error : " + th5.toString());
            f340958b = false;
        }
    }

    public static boolean a(String str, String str2, String str3) {
        f.e(f340957a, "srcFile = " + str + "\npatchFile = " + str2 + "\ndstFile = " + str3 + "\nisSupport = " + String.valueOf(f340958b));
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && f340958b) {
            try {
                return bspatch(str, str3, str2);
            } catch (Throwable th5) {
                f.c(f340957a, "patch error : " + th5.toString());
            }
        }
        return false;
    }

    protected static native boolean bspatch(String str, String str2, String str3);
}
