package com.tencent.luggage.wxa.y8;

import com.tencent.luggage.wxa.tn.x;
import com.tencent.luggage.wxa.y8.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends x implements b {

    /* renamed from: i, reason: collision with root package name */
    public b.a f145479i;

    public d(int i3) {
        super(i3);
        this.f145479i = null;
    }

    @Override // com.tencent.luggage.wxa.tn.x
    public void a(int i3) {
        super.a(i3);
    }

    @Override // com.tencent.luggage.wxa.tn.x
    public int b(Object obj, Object obj2) {
        return super.b(obj, obj2);
    }

    @Override // com.tencent.luggage.wxa.tn.x
    public Object c(Object obj) {
        return super.c(obj);
    }

    @Override // com.tencent.luggage.wxa.y8.b
    public void clear() {
        a(-1);
    }

    public Object d(Object obj) {
        return get(obj);
    }

    @Override // com.tencent.luggage.wxa.tn.x
    public void a(boolean z16, Object obj, Object obj2, Object obj3) {
        super.a(z16, obj, obj2, obj3);
        b.a aVar = this.f145479i;
        if (aVar != null) {
            aVar.preRemoveCallback(obj, obj2, obj3);
        }
    }

    public d(int i3, b.a aVar) {
        super(i3);
        this.f145479i = aVar;
    }
}
