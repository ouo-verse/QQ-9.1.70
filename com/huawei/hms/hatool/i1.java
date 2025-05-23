package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    private String f37133a;

    /* renamed from: b, reason: collision with root package name */
    private String f37134b;

    /* renamed from: c, reason: collision with root package name */
    private String f37135c;

    /* renamed from: d, reason: collision with root package name */
    private String f37136d;

    /* renamed from: e, reason: collision with root package name */
    private long f37137e;

    public i1(String str, String str2, String str3, String str4, long j3) {
        this.f37133a = str;
        this.f37134b = str2;
        this.f37135c = str3;
        this.f37136d = str4;
        this.f37137e = j3;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f37135c);
        b1Var.d(this.f37134b);
        b1Var.a(this.f37136d);
        b1Var.c(String.valueOf(this.f37137e));
        if ("oper".equals(this.f37134b) && z.i(this.f37133a, "oper")) {
            p0 a16 = y.a().a(this.f37133a, this.f37137e);
            String a17 = a16.a();
            Boolean valueOf = Boolean.valueOf(a16.b());
            b1Var.f(a17);
            b1Var.e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f37133a, this.f37134b, q0.g(), arrayList, replace).a();
    }
}
