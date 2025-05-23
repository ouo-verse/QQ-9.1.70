package com.tencent.luggage.wxa.v1;

import com.tencent.luggage.wxa.x1.f;
import com.tencent.luggage.wxa.x1.g;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.yi.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements r.f {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.yi.r.f
        public boolean a(String str) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.yi.r.f
        public boolean b(String str) {
            return false;
        }
    }

    public Map a() {
        HashSet hashSet = new HashSet();
        hashSet.add(new f());
        hashSet.add(new g());
        hashSet.add(new com.tencent.luggage.wxa.x1.e());
        hashSet.add(new com.tencent.luggage.wxa.v1.a());
        hashSet.add(new b());
        hashSet.add(new d());
        hashSet.add(new e());
        hashSet.add(new com.tencent.luggage.wxa.y1.c());
        hashSet.add(new com.tencent.luggage.wxa.nf.f(com.tencent.luggage.wxa.nf.f.f135779i, new a()));
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            hashMap.put(oVar.getName(), oVar);
        }
        return hashMap;
    }
}
