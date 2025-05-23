package com.tencent.aelight.camera.ae.flashshow.util;

import com.tencent.aelight.camera.ae.flashshow.ac;
import com.tencent.mobileqq.editor.composite.CodecParam;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static k f65118a;

    k() {
    }

    public static k b() {
        if (f65118a == null) {
            synchronized (k.class) {
                if (f65118a == null) {
                    f65118a = new k();
                }
            }
        }
        return f65118a;
    }

    public xp.a a(ac acVar) {
        xp.a aVar = new xp.a();
        aVar.v(acVar.q().b());
        aVar.u(acVar.q().a());
        aVar.r(acVar.t().floatValue());
        aVar.p(acVar.a().intValue());
        CodecParam.mMaxrate = acVar.a().intValue();
        aVar.q(1);
        aVar.o(acVar.f());
        return aVar;
    }
}
