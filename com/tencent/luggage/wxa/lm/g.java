package com.tencent.luggage.wxa.lm;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmini.minigame.action.OperateCustomButton;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f133622a = "MicroMsg.Audio.AudioPlayerCoreService";

    /* renamed from: b, reason: collision with root package name */
    private static g f133623b;

    g() {
        c();
    }

    private void a() {
        i.o().v();
    }

    public static synchronized void b() {
        synchronized (g.class) {
            if (f133623b != null) {
                return;
            }
            w.d(f133622a, OperateCustomButton.OPERATE_CREATE);
            f133623b = new g();
        }
    }

    private void c() {
        i.n();
    }

    public static g d() {
        return f133623b;
    }

    public static synchronized void e() {
        synchronized (g.class) {
            w.d(f133622a, "release");
            f133623b.a();
            f133623b = null;
        }
    }
}
