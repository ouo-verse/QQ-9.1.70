package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.gm.a;
import com.tencent.luggage.wxa.k0.d;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class M4aAudioFormatJni {
    static {
        d.a(g.a(a.class));
        throw null;
    }

    public static native void closeM4aFile();

    public static native int createM4aFile(String str, int i3, int i16, int i17);

    public static native int writeAudioBuff(byte[] bArr, int i3);
}
