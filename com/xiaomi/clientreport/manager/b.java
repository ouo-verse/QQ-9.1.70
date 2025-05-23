package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.push.g;
import jz4.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static void a(Context context, kz4.a aVar, lz4.a aVar2, lz4.b bVar) {
        c.z("init in  pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        a.c(context).m(aVar, aVar2, bVar);
        if (g.k(context)) {
            c.z("init in process\u3000start scheduleJob");
            a.c(context).g();
        }
    }

    public static void b(Context context, kz4.b bVar) {
        if (bVar != null) {
            a.c(context).n(bVar);
        }
    }

    public static void c(Context context, kz4.c cVar) {
        if (cVar != null) {
            a.c(context).o(cVar);
        }
    }

    public static void d(Context context, kz4.a aVar) {
        if (aVar == null) {
            return;
        }
        a.c(context).p(aVar.g(), aVar.h(), aVar.c(), aVar.e());
    }
}
