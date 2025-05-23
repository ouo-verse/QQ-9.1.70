package com.tencent.luggage.wxa.nd;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f135637a;

    /* renamed from: b, reason: collision with root package name */
    public int f135638b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f135639c;

    /* renamed from: d, reason: collision with root package name */
    public Map f135640d;

    /* renamed from: e, reason: collision with root package name */
    public Map f135641e;

    /* renamed from: f, reason: collision with root package name */
    public f f135642f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.od.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.md.c f135643a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.od.c f135644b;

        public a(com.tencent.luggage.wxa.md.c cVar, com.tencent.luggage.wxa.od.c cVar2) {
            this.f135643a = cVar;
            this.f135644b = cVar2;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.od.c cVar = this.f135644b;
            if (cVar != null) {
                cVar.a(eVar);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e eVar) {
            String a16 = eVar.f137498a.a("SID");
            com.tencent.luggage.wxa.pd.c cVar = new com.tencent.luggage.wxa.pd.c();
            com.tencent.luggage.wxa.pd.b bVar = eVar.f137498a;
            cVar.f137493a = bVar.a("SID");
            cVar.f137494b = bVar.a("TIMEOUT");
            cVar.f137495c = this.f135643a;
            e.this.f135640d.put(a16, cVar);
            com.tencent.luggage.wxa.od.c cVar2 = this.f135644b;
            if (cVar2 != null) {
                cVar2.a(cVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.od.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.md.c f135646a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.od.c f135647b;

        public b(com.tencent.luggage.wxa.md.c cVar, com.tencent.luggage.wxa.od.c cVar2) {
            this.f135646a = cVar;
            this.f135647b = cVar2;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.od.c cVar = this.f135647b;
            if (cVar != null) {
                cVar.a(eVar);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e eVar) {
            String a16 = eVar.f137498a.a("SID");
            com.tencent.luggage.wxa.pd.c cVar = new com.tencent.luggage.wxa.pd.c();
            com.tencent.luggage.wxa.pd.b bVar = eVar.f137498a;
            cVar.f137493a = bVar.a("SID");
            cVar.f137494b = bVar.a("TIMEOUT");
            cVar.f137495c = this.f135646a;
            e.this.f135641e.put(a16, cVar);
            com.tencent.luggage.wxa.od.c cVar2 = this.f135647b;
            if (cVar2 != null) {
                cVar2.a(cVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.od.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.pd.c f135649a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.od.a f135650b;

        public c(com.tencent.luggage.wxa.pd.c cVar, com.tencent.luggage.wxa.od.a aVar) {
            this.f135649a = cVar;
            this.f135650b = aVar;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.od.a aVar = this.f135650b;
            if (aVar != null) {
                aVar.a(eVar);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e eVar) {
            e.this.f135640d.remove(this.f135649a.f137493a);
            com.tencent.luggage.wxa.od.a aVar = this.f135650b;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.od.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.pd.c f135652a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.od.a f135653b;

        public d(com.tencent.luggage.wxa.pd.c cVar, com.tencent.luggage.wxa.od.a aVar) {
            this.f135652a = cVar;
            this.f135653b = aVar;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.od.a aVar = this.f135653b;
            if (aVar != null) {
                aVar.a(eVar);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e eVar) {
            e.this.f135641e.remove(this.f135652a.f137493a);
            com.tencent.luggage.wxa.od.a aVar = this.f135653b;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.nd.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6510e implements f {
        public C6510e() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:4:0x0003, B:14:0x0056, B:16:0x005a, B:17:0x005e, B:20:0x0060, B:22:0x003b, B:23:0x0048, B:24:0x001e, B:27:0x0029), top: B:3:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0048 A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:4:0x0003, B:14:0x0056, B:16:0x005a, B:17:0x005e, B:20:0x0060, B:22:0x003b, B:23:0x0048, B:24:0x001e, B:27:0x0029), top: B:3:0x0003 }] */
        @Override // com.tencent.luggage.wxa.nd.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(com.tencent.luggage.wxa.pd.d dVar) {
            char c16;
            com.tencent.luggage.wxa.pd.c cVar;
            com.tencent.luggage.wxa.od.b bVar;
            synchronized (f.class) {
                String a16 = dVar.f137498a.a("SID");
                String str = dVar.f137496c;
                int hashCode = str.hashCode();
                if (hashCode != -2006516997) {
                    if (hashCode == -1725405015 && str.equals("rdcEvent")) {
                        c16 = 1;
                        if (c16 == 0) {
                            if (c16 != 1) {
                                cVar = null;
                            } else {
                                cVar = (com.tencent.luggage.wxa.pd.c) e.this.f135641e.get(a16);
                            }
                        } else {
                            cVar = (com.tencent.luggage.wxa.pd.c) e.this.f135640d.get(a16);
                        }
                        if (cVar != null || (bVar = cVar.f137495c) == null) {
                            return true;
                        }
                        return bVar.a(dVar);
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                    if (cVar != null) {
                    }
                    return true;
                }
                if (str.equals("avtEvent")) {
                    c16 = 0;
                    if (c16 == 0) {
                    }
                    if (cVar != null) {
                    }
                    return true;
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
                if (cVar != null) {
                }
                return true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        boolean a(com.tencent.luggage.wxa.pd.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static e f135656a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e d() {
        return g.f135656a;
    }

    public boolean c() {
        this.f135639c = true;
        com.tencent.luggage.wxa.nd.f a16 = com.tencent.luggage.wxa.nd.f.a();
        a16.a(this.f135642f);
        a16.d();
        this.f135637a = a16.b();
        this.f135638b = a16.c();
        return true;
    }

    public e() {
        this.f135639c = false;
        this.f135642f = new C6510e();
        this.f135640d = new HashMap();
        this.f135641e = new HashMap();
    }

    public void a(com.tencent.luggage.wxa.md.c cVar, com.tencent.luggage.wxa.od.c cVar2) {
        a();
        com.tencent.luggage.wxa.md.f b16 = cVar.b();
        if (b16 != null) {
            k.d().a(new com.tencent.luggage.wxa.ld.m(i.a(cVar.c().f134422b, cVar.c().f134423c, b16.f134463e), a("/upnp/cb/AVTransport")), new a(cVar, cVar2));
        } else if (cVar2 != null) {
            cVar2.a((com.tencent.luggage.wxa.pd.e) null);
        }
    }

    public boolean b() {
        this.f135639c = false;
        com.tencent.luggage.wxa.nd.f a16 = com.tencent.luggage.wxa.nd.f.a();
        a16.a((f) null);
        a16.e();
        this.f135640d.clear();
        this.f135641e.clear();
        return true;
    }

    public void b(com.tencent.luggage.wxa.md.c cVar, com.tencent.luggage.wxa.od.c cVar2) {
        a();
        com.tencent.luggage.wxa.md.f f16 = cVar.f();
        if (f16 != null) {
            k.d().a(new com.tencent.luggage.wxa.ld.m(i.a(cVar.c().f134422b, cVar.c().f134423c, f16.f134463e), a("/upnp/cb/RenderControl")), new b(cVar, cVar2));
        } else if (cVar2 != null) {
            cVar2.a((com.tencent.luggage.wxa.pd.e) null);
        }
    }

    public void a(com.tencent.luggage.wxa.md.c cVar, com.tencent.luggage.wxa.od.a aVar) {
        a();
        com.tencent.luggage.wxa.md.f b16 = cVar.b();
        com.tencent.luggage.wxa.pd.c a16 = cVar.a();
        if (b16 != null && a16 != null && a16.f137493a != null) {
            k.d().a(new com.tencent.luggage.wxa.ld.n(i.a(cVar.c().f134422b, cVar.c().f134423c, b16.f134463e), a16.f137493a), new c(a16, aVar));
        } else if (aVar != null) {
            aVar.a(null);
        }
    }

    public void b(com.tencent.luggage.wxa.md.c cVar, com.tencent.luggage.wxa.od.a aVar) {
        a();
        com.tencent.luggage.wxa.md.f f16 = cVar.f();
        com.tencent.luggage.wxa.pd.c e16 = cVar.e();
        if (f16 != null && e16 != null && e16.f137493a != null) {
            k.d().a(new com.tencent.luggage.wxa.ld.n(i.a(cVar.c().f134422b, cVar.c().f134423c, f16.f134463e), e16.f137493a), new d(e16, aVar));
        } else if (aVar != null) {
            aVar.a(null);
        }
    }

    public final String a(String str) {
        return "http://" + this.f135637a + ":" + this.f135638b + str;
    }

    public final void a() {
        if (this.f135639c) {
            return;
        }
        Log.w("MRSubscriptionManager", "checkEnable: MRSubscriptionManager is not enable!");
    }
}
