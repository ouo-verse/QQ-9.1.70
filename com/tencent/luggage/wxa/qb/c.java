package com.tencent.luggage.wxa.qb;

import com.tencent.luggage.wxa.p9.b;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public static boolean a(String str, b bVar) {
            return c.a(str, bVar);
        }

        public static boolean b(String str) {
            if (c.f(str)) {
                return c.k(str);
            }
            if (!c.g(str)) {
                return c.j(str);
            }
            return true;
        }

        public static boolean a(String str) {
            return c.i(str);
        }

        public static boolean a(String str, int i3) {
            return c.a(str, i3);
        }
    }

    public static String a(String str, String str2) {
        w.d("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", str, str2);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 10;
        aVar.f137432c = str;
        aVar.f137431b = str2;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137428b.f137431b;
    }

    public static boolean b(b bVar) {
        w.a("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", bVar.f138564a);
        com.tencent.luggage.wxa.p9.b bVar2 = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar2.f137428b;
        aVar.f137430a = 0;
        aVar.f137431b = bVar.f138564a;
        aVar.f137434e = bVar;
        com.tencent.luggage.wxa.lm.b.a(bVar2);
        return bVar2.f137429c.f137437a;
    }

    public static b c(String str) {
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 16;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137428b.f137434e;
    }

    public static d d(String str) {
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 6;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137439c;
    }

    public static boolean e(String str) {
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 7;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static boolean f(String str) {
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 13;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static boolean g(String str) {
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 17;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static void h(String str) {
        w.d("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 12;
        aVar.f137432c = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
    }

    public static boolean i(String str) {
        w.a("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 2;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static boolean j(String str) {
        w.d("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 3;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static boolean k(String str) {
        w.d("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 14;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static boolean a(b bVar) {
        w.d("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", bVar.f138564a, bVar.f138565b);
        com.tencent.luggage.wxa.p9.b bVar2 = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar2.f137428b;
        aVar.f137430a = 18;
        aVar.f137431b = bVar.f138564a;
        aVar.f137434e = bVar;
        com.tencent.luggage.wxa.lm.b.a(bVar2);
        return bVar2.f137429c.f137437a;
    }

    public static boolean b(String str) {
        w.d("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 5;
        aVar.f137431b = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static e b() {
        return com.tencent.luggage.wxa.lm.b.a();
    }

    public static boolean a(com.tencent.luggage.wxa.qb.a aVar) {
        w.d("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", Boolean.valueOf(aVar.f138561a));
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar2 = bVar.f137428b;
        aVar2.f137430a = 19;
        aVar2.f137436g = aVar;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static com.tencent.luggage.wxa.qb.a a() {
        w.d("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        bVar.f137428b.f137430a = 20;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137440d;
    }

    public static boolean a(String str, b bVar) {
        w.a("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar2 = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar2.f137428b;
        aVar.f137430a = 1;
        aVar.f137431b = str;
        aVar.f137434e = bVar;
        com.tencent.luggage.wxa.lm.b.a(bVar2);
        return bVar2.f137429c.f137437a;
    }

    public static boolean a(String str, int i3) {
        w.d("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", str, Integer.valueOf(i3));
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 4;
        aVar.f137431b = str;
        aVar.f137433d = i3;
        com.tencent.luggage.wxa.lm.b.a(bVar);
        return bVar.f137429c.f137437a;
    }

    public static void a(String str) {
        w.d("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", str);
        com.tencent.luggage.wxa.p9.b bVar = new com.tencent.luggage.wxa.p9.b();
        b.a aVar = bVar.f137428b;
        aVar.f137430a = 9;
        aVar.f137432c = str;
        com.tencent.luggage.wxa.lm.b.a(bVar);
    }
}
