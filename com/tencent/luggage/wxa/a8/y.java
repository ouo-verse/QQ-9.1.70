package com.tencent.luggage.wxa.a8;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y {
    public static void a(int i3, x xVar) {
        switch (i3) {
            case 0:
                xVar.j();
                return;
            case 1:
                xVar.b();
                return;
            case 2:
                xVar.b();
                xVar.a(true);
                return;
            case 3:
                xVar.b();
                xVar.a(false);
                return;
            case 4:
                xVar.onPause();
                return;
            case 5:
                xVar.a();
                return;
            case 6:
                xVar.onStop();
                return;
            case 7:
                xVar.f();
                return;
            default:
                return;
        }
    }
}
