package com.tencent.open.appcommon;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    protected static volatile b f340644c;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f340645a = true;

    /* renamed from: b, reason: collision with root package name */
    protected List<a> f340646b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
    }

    public static b a() {
        if (f340644c == null) {
            f340644c = new b();
        }
        return f340644c;
    }

    public boolean b() {
        return this.f340645a;
    }

    protected void c(boolean z16) {
        int size;
        a[] aVarArr;
        synchronized (this.f340646b) {
            size = this.f340646b.size();
            aVarArr = new a[size];
            this.f340646b.toArray(aVarArr);
        }
        if (size <= 0) {
            return;
        }
        a aVar = aVarArr[0];
        throw null;
    }

    public synchronized void d(boolean z16) {
        this.f340645a = z16;
        c(z16);
    }
}
