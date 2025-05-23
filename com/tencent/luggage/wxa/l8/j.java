package com.tencent.luggage.wxa.l8;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f133225a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final Collection f133226b = new LinkedHashSet();

    public final void a(c interrupter) {
        Intrinsics.checkNotNullParameter(interrupter, "interrupter");
        f133226b.add(interrupter);
    }

    public final void b(c cVar) {
        TypeIntrinsics.asMutableCollection(f133226b).remove(cVar);
    }

    public final void a(boolean z16) {
        Iterator it = f133226b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(z16);
        }
    }
}
