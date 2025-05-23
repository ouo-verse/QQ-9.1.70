package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.tj.b;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends com.tencent.luggage.wxa.ej.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ej.c f126773a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f126774b;

        public a(com.tencent.luggage.wxa.ej.c cVar, String str) {
            this.f126773a = cVar;
            this.f126774b = str;
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public /* synthetic */ void a(String str) {
            e41.a.a(this, str);
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void onCancel() {
            k.this.a(this.f126773a, 3);
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void a() {
            k.this.a(this.f126773a, 1);
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void a(int i3, String str) {
            w.b("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], errno[%d], errMsg[%s]", this.f126774b, Integer.valueOf(i3), str);
            k.this.a(this.f126773a, 2);
        }
    }

    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 1;
    }

    @Override // com.tencent.luggage.wxa.ej.b
    public void a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        String optString = hVar.optString("apiName");
        com.tencent.luggage.wxa.ic.l a16 = cVar.a();
        if (com.tencent.luggage.wxa.tj.b.a(a16.getAppId(), optString)) {
            a(cVar, 1);
        } else {
            com.tencent.luggage.wxa.tj.b.a(new com.tencent.luggage.wxa.tj.e(a16, optString), new a(cVar, optString));
        }
    }

    public final void a(com.tencent.luggage.wxa.ej.c cVar, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(i3));
        cVar.b(hashMap);
    }
}
