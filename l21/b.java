package l21;

import com.tencent.luggage.wxa.ei.q;

/* compiled from: P */
/* loaded from: classes8.dex */
public final /* synthetic */ class b {
    public static void a(q qVar, Runnable runnable) {
        if (qVar.g()) {
            runnable.run();
        } else {
            qVar.a(runnable);
        }
    }
}
