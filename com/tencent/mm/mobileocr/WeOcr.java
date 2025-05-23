package com.tencent.mm.mobileocr;

import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeOcr {
    public static native long nInit(String str, String str2, String str3);

    public static native String nProcess(long j3, Buffer buffer, int i3, int i16);

    public static native void nRelease(long j3);
}
