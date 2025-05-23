package com.tencent.luggage.wxa.zd;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.wxa.ei.x;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum c {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f146495a = new SparseArray(2);

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f146496b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements x.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.qb.e f146497a;

        public a(com.tencent.luggage.wxa.qb.e eVar) {
            this.f146497a = eVar;
        }

        @Override // com.tencent.luggage.wxa.ei.x.a
        public void a(String str) {
            w.d("MicroMsg.AudioInstanceContext", "onRevoked url:%s", str);
            com.tencent.luggage.wxa.qb.e eVar = this.f146497a;
            if (eVar != null) {
                eVar.b(str);
            }
        }
    }

    c() {
    }

    public boolean b(String str) {
        return this.f146496b.containsKey(str);
    }

    public com.tencent.luggage.wxa.ee.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        synchronized (this.f146495a) {
            int indexOfKey = this.f146495a.indexOfKey(hashCode);
            if (indexOfKey < 0) {
                return null;
            }
            com.tencent.luggage.wxa.ee.a aVar = (com.tencent.luggage.wxa.ee.a) this.f146495a.valueAt(indexOfKey);
            this.f146495a.removeAt(indexOfKey);
            return aVar;
        }
    }

    public com.tencent.luggage.wxa.ee.a a(String str) {
        int hashCode = str.hashCode();
        synchronized (this.f146495a) {
            int indexOfKey = this.f146495a.indexOfKey(hashCode);
            if (indexOfKey >= 0) {
                return (com.tencent.luggage.wxa.ee.a) this.f146495a.valueAt(indexOfKey);
            }
            com.tencent.luggage.wxa.ee.a aVar = new com.tencent.luggage.wxa.ee.a();
            this.f146495a.put(hashCode, aVar);
            return aVar;
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str, com.tencent.luggage.wxa.qb.e eVar) {
        w.d("MicroMsg.AudioInstanceContext", "registerIBufferURLManager");
        x m3 = ((com.tencent.luggage.wxa.ei.l) dVar.getJsRuntime().a(com.tencent.luggage.wxa.ei.l.class)).m();
        if (m3 != null) {
            a aVar = new a(eVar);
            m3.a(aVar);
            this.f146496b.put(str, aVar);
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        w.d("MicroMsg.AudioInstanceContext", "removeBufferURLManager");
        x.a aVar = (x.a) this.f146496b.remove(str);
        x m3 = ((com.tencent.luggage.wxa.ei.l) dVar.getJsRuntime().a(com.tencent.luggage.wxa.ei.l.class)).m();
        if (aVar == null || m3 == null) {
            return;
        }
        m3.b(aVar);
    }
}
