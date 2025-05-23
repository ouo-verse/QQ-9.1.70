package com.tencent.luggage.wxa.vi;

import android.content.Context;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mo.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f143493a;

    public a(int i3) {
        this.f143493a = i3;
    }

    public abstract void a(Context context, v vVar, h hVar, String str);

    public abstract void a(Context context, v vVar, String str, com.tencent.luggage.wxa.ui.a aVar);

    public boolean a(Context context, v vVar, h hVar, String str, com.tencent.luggage.wxa.ui.a aVar) {
        return false;
    }

    public final void b(Context context, v vVar, h hVar, String str, com.tencent.luggage.wxa.ui.a aVar) {
        if (a(context, vVar, hVar, str, aVar)) {
            return;
        }
        a(context, vVar, hVar, str);
    }

    public final int a() {
        return this.f143493a;
    }
}
