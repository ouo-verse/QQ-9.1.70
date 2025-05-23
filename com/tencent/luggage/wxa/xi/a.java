package com.tencent.luggage.wxa.xi;

import com.tencent.luggage.wxa.mc.g0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xi.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC6911a {
        void a(String str, c cVar, b bVar, boolean z16);

        void commit();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(g0 g0Var);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(e eVar);

        void a(List list);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d implements a {
        @Override // com.tencent.luggage.wxa.xi.a
        public String a(String str) {
            return ModulePkgInfo.MAIN_MODULE_NAME;
        }

        @Override // com.tencent.luggage.wxa.xi.a
        public boolean b() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.xi.a
        public void a(String str, c cVar, b bVar, boolean z16) {
            a(str, cVar);
        }

        @Override // com.tencent.luggage.wxa.xi.a
        public void a(String str, c cVar) {
            if (cVar != null) {
                cVar.a(e.OK);
            }
        }

        @Override // com.tencent.luggage.wxa.xi.a
        public InterfaceC6911a a() {
            return new C6912a();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xi.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6912a implements InterfaceC6911a {
            public C6912a() {
            }

            @Override // com.tencent.luggage.wxa.xi.a.InterfaceC6911a
            public void a(String str, c cVar, b bVar, boolean z16) {
                d.this.a(str, cVar, bVar, z16);
            }

            @Override // com.tencent.luggage.wxa.xi.a.InterfaceC6911a
            public void commit() {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum e {
        OK,
        FAIL,
        CANCEL,
        MODULE_NOT_FOUND
    }

    InterfaceC6911a a();

    String a(String str);

    void a(String str, c cVar);

    void a(String str, c cVar, b bVar, boolean z16);

    boolean b();
}
