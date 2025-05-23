package com.tencent.luggage.wxa.zd;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f146499a = false;

    public static void a(com.tencent.luggage.wxa.xd.d dVar) {
        new o().setContext(dVar).dispatch();
        w.d("MicroMsg.Audio.AudioInterruptionEventDispatcher", "dispatchInterruptionBegin");
        f146499a = true;
    }

    public static void b(com.tencent.luggage.wxa.xd.d dVar) {
        if (!f146499a) {
            return;
        }
        f146499a = false;
        new p().setContext(dVar).dispatch();
        w.d("MicroMsg.Audio.AudioInterruptionEventDispatcher", "dispatchInterruptionEnd");
    }
}
