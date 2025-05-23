package com.tencent.mtt.hippy.runtime.builtins;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends e {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mtt.hippy.runtime.b f337608a;

    /* renamed from: b, reason: collision with root package name */
    private final String f337609b = "message";

    /* renamed from: c, reason: collision with root package name */
    private final String f337610c = "stack";

    /* renamed from: d, reason: collision with root package name */
    private final String f337611d = "type";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum a {
        Error,
        EvalError,
        RangeError,
        ReferenceError,
        SyntaxError,
        TypeError,
        URIError,
        AggregateError
    }

    public c(a aVar, String str, String str2) {
        a("message", str);
        a("stack", str2);
        a("type", aVar);
    }

    public a a() {
        return (a) a("type");
    }

    public String b() {
        return (String) a("message");
    }

    public String c() {
        if (!b("stack")) {
            a("stack", a("message") + "\n" + this.f337608a.toString());
        }
        return (String) a("stack");
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c clone() throws CloneNotSupportedException {
        c cVar = (c) super.clone();
        if (cVar.f337608a != null) {
            cVar.f337608a = this.f337608a.clone();
        }
        return cVar;
    }
}
