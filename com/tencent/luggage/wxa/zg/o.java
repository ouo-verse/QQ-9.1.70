package com.tencent.luggage.wxa.zg;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class o implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final o f146703a = new o();

    @Override // com.tencent.luggage.wxa.zg.l
    public int a(com.tencent.luggage.wxa.mg.i iVar, Uri uri) {
        if (uri != null) {
            com.tencent.luggage.wxa.xg.d dVar = com.tencent.luggage.wxa.xg.d.f144917a;
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            if (dVar.a(uri2)) {
                return 2;
            }
        }
        return 3;
    }
}
