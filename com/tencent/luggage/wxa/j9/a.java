package com.tencent.luggage.wxa.j9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static boolean a(int i3, int i16, int i17) {
        return d(i3) && b(i16) && a(i17);
    }

    public static boolean b(int i3) {
        if (i3 <= 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", Integer.valueOf(i3));
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean c(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static boolean d(int i3) {
        if (i3 <= 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", Integer.valueOf(i3));
            return false;
        }
        if (i3 == 44100) {
            return true;
        }
        return false;
    }

    public static boolean a(int i3) {
        if (i3 <= 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", Integer.valueOf(i3));
        }
        return i3 == 2;
    }
}
