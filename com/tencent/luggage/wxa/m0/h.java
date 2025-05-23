package com.tencent.luggage.wxa.m0;

import android.net.Uri;
import com.tencent.luggage.wxa.m0.a;
import java.util.Iterator;
import java.util.NavigableSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {
    public static String a(Uri uri) {
        return uri.toString();
    }

    public static String a(com.tencent.luggage.wxa.l0.j jVar) {
        String str = jVar.f132787f;
        return str != null ? str : a(jVar.f132782a);
    }

    public static void a(a aVar, String str) {
        NavigableSet b16 = aVar.b(str);
        if (b16 == null) {
            return;
        }
        Iterator it = b16.iterator();
        while (it.hasNext()) {
            try {
                aVar.b((g) it.next());
            } catch (a.C6454a unused) {
            }
        }
    }
}
