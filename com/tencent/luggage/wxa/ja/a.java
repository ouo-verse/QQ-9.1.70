package com.tencent.luggage.wxa.ja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public List f130926a = new ArrayList();

    public void a(int i3) {
        a(Integer.valueOf(i3));
    }

    public a a(Object obj) {
        this.f130926a.add(obj);
        return this;
    }

    public Object[] a() {
        Collections.reverse(this.f130926a);
        return this.f130926a.toArray();
    }
}
