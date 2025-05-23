package com.tencent.luggage.wxa.zg;

import android.net.Uri;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f146649a = new h();

    public final l a() {
        boolean a16 = com.tencent.luggage.wxa.xg.f.a();
        w.d("MicroMsg.ExoContentTypeInferer", "inferer#get, useContentInferer: " + a16);
        if (a16) {
            return d.f146629a;
        }
        return o.f146703a;
    }

    public final int a(com.tencent.luggage.wxa.mg.i iVar, Uri uri) {
        return a().a(iVar, uri);
    }
}
