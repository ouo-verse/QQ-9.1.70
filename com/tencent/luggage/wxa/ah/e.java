package com.tencent.luggage.wxa.ah;

import com.tencent.luggage.wxa.m0.f;
import com.tencent.luggage.wxa.m0.l;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends d {

    /* renamed from: f, reason: collision with root package name */
    public static final e f121422f = new e();

    @Override // com.tencent.luggage.wxa.ah.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l a(File cacheDir, f evictor) {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(evictor, "evictor");
        return l.f134006f.a(cacheDir, evictor);
    }

    @Override // com.tencent.luggage.wxa.ah.d
    public String j() {
        return "appbrand";
    }
}
