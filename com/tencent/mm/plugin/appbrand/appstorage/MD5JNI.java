package com.tencent.mm.plugin.appbrand.appstorage;

import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class MD5JNI {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f151892a = "0123456789abcdef".getBytes(StandardCharsets.US_ASCII);

    public static native int getMD5String(String str, String[] strArr);
}
