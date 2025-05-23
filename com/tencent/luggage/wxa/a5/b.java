package com.tencent.luggage.wxa.a5;

import android.os.Parcelable;
import com.tencent.luggage.wxa.c5.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f120843a;

    public b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f120843a = appId;
    }

    public abstract void a(e eVar);

    public abstract String b();
}
