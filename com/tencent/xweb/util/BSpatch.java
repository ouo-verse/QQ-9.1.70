package com.tencent.xweb.util;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BSpatch {

    /* renamed from: a, reason: collision with root package name */
    public static BSpatch f385140a;

    static {
        System.loadLibrary("bspatch_utils");
        f385140a = null;
    }

    public native int nativeDoPatch(String str, String str2, String str3);
}
