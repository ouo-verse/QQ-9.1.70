package com.tencent.luggage.wxa.a6;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.se.k;
import com.tencent.luggage.wxa.se.m;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum i {
    INST;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.se.h {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ee.b, com.tencent.luggage.wxa.xd.a
        public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
            f.a();
            super.invoke(dVar, jSONObject, i3, pVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.ue.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.sd.c, com.tencent.luggage.wxa.xd.a
        public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            f.a();
            super.invoke(dVar, jSONObject, i3);
        }
    }

    public List b() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new m());
        linkedList.add(new k());
        linkedList.add(new b());
        linkedList.add(new com.tencent.luggage.wxa.ue.d());
        linkedList.add(new com.tencent.luggage.wxa.ue.c());
        return linkedList;
    }
}
