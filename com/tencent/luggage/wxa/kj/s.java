package com.tencent.luggage.wxa.kj;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final AppBrandSimpleImageLoader.n f132408a = new AppBrandSimpleImageLoader.g();

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tk.h f132409b = new com.tencent.luggage.wxa.tk.h();

    public static Bitmap a(com.tencent.luggage.wxa.ic.g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        String b16 = com.tencent.luggage.wxa.rc.m.b(str);
        if (com.tencent.luggage.wxa.tn.w0.c(b16)) {
            return null;
        }
        String str2 = (gVar.hashCode() + 35) + b16;
        f132409b.b(gVar, str2);
        AppBrandSimpleImageLoader.n nVar = f132408a;
        Bitmap bitmap = nVar.get(str2);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        InputStream d16 = com.tencent.luggage.wxa.mc.k0.d(gVar, b16);
        if (d16 != null) {
            try {
                try {
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", e16);
                }
                if (d16.available() > 0) {
                    Bitmap a16 = com.tencent.luggage.wxa.tn.d.a(d16);
                    if (a16 != null && !a16.isRecycled()) {
                        nVar.a(str2, a16);
                        return a16;
                    }
                    return null;
                }
            } finally {
                com.tencent.luggage.wxa.tn.w0.a((Closeable) d16);
            }
        }
        if (d16 != null) {
        }
        return null;
    }

    public static void a(com.tencent.luggage.wxa.ic.g gVar) {
        Set b16;
        if (gVar == null || (b16 = f132409b.b(gVar)) == null) {
            return;
        }
        Iterator it = b16.iterator();
        while (it.hasNext()) {
            f132408a.remove((String) it.next());
        }
    }
}
