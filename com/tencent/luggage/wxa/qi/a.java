package com.tencent.luggage.wxa.qi;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a {
    AUTO(0),
    MIC(1),
    CAMCORDER(5),
    VOICE_RECOGNITION(6),
    VOICE_COMMUNICATION(7),
    UNPROCESSED(9);


    /* renamed from: a, reason: collision with root package name */
    public int f138827a;

    a(int i3) {
        this.f138827a = i3;
    }

    public static a a(String str, a aVar) {
        a aVar2;
        if (str == null || str.length() <= 0) {
            return aVar;
        }
        try {
            aVar2 = valueOf(str);
        } catch (Exception unused) {
            aVar2 = null;
        }
        return aVar2 != null ? aVar2 : aVar;
    }
}
