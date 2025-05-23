package com.tencent.luggage.wxa.w7;

import android.content.Context;
import com.tencent.luggage.wxa.ca.b;
import com.tencent.luggage.wxa.ca.i;
import com.tencent.luggage.wxa.eo.c;
import com.tencent.luggage.wxa.eo.d;
import com.tencent.luggage.wxa.eo.f;
import com.tencent.luggage.wxa.eo.h;
import com.tencent.luggage.wxa.so.g;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends f {

    /* renamed from: f, reason: collision with root package name */
    public static final g f144104f = new C6867a();

    /* renamed from: e, reason: collision with root package name */
    public final Context f144105e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6867a extends g {
        @Override // com.tencent.luggage.wxa.so.g
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements b.C6103b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fo.a f144106a;

        public b(com.tencent.luggage.wxa.fo.a aVar) {
            this.f144106a = aVar;
        }

        @Override // com.tencent.luggage.wxa.ca.b.C6103b.a
        public boolean a(i iVar) {
            return iVar.a(this.f144106a);
        }
    }

    public /* synthetic */ a(C6867a c6867a) {
        this();
    }

    public static f a() {
        return (f) f144104f.b();
    }

    public a() {
        this.f144105e = z.c();
    }

    @Override // com.tencent.luggage.wxa.eo.f
    public c a(Class cls) {
        Iterable a16 = com.tencent.luggage.wxa.ca.b.a(cls).a();
        ArrayList arrayList = new ArrayList();
        Iterator it = a16.iterator();
        while (it.hasNext()) {
            arrayList.add((i) it.next());
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() <= 1) {
                return (c) ((i) arrayList.get(0)).get();
            }
            throw new h("More than one FeatureService implement '" + cls.getName() + "' on current process: " + arrayList);
        }
        throw new h("No FeatureService with api class '" + cls.getName() + "' register on current process.");
    }

    @Override // com.tencent.luggage.wxa.eo.f
    public Iterable a(com.tencent.luggage.wxa.fo.a aVar) {
        return new b.C6103b(com.tencent.luggage.wxa.ca.b.a(d.class).a(), new b(aVar));
    }
}
