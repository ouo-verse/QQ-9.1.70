package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.luggage.wxa.qi.g;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class Mp3EncodeJni {
    static {
        g.a().loadLibrary("mp3lame", Mp3EncodeJni.class.getClassLoader());
    }

    public static native void close();

    public static native int encode(short[] sArr, short[] sArr2, int i3, byte[] bArr);

    public static native int flush(byte[] bArr);

    public static native int getVersion();

    public static native int init(int i3, int i16, int i17, int i18, int i19);
}
