package com.tencent.luggage.wxa.b9;

import android.text.TextUtils;
import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f122354a;

    public v() {
        this("");
    }

    public v a(t tVar) {
        if (TextUtils.isEmpty(this.f122354a)) {
            a(tVar, tVar.j().getGlobalObject());
        } else {
            V8Object newV8Object = tVar.j().newV8Object();
            tVar.j().add(this.f122354a, newV8Object);
            a(tVar, newV8Object);
            newV8Object.release();
        }
        return this;
    }

    public abstract void a();

    public abstract void a(t tVar, V8Object v8Object);

    public v(String str) {
        this.f122354a = str;
    }
}
