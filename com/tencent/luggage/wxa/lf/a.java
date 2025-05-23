package com.tencent.luggage.wxa.lf;

import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wb.a;
import com.tencent.luggage.wxa.xo.e;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements a.InterfaceC6874a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f133339a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f133340b = new ConcurrentHashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6434a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f133341a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.b f133342b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.wb.a f133343c;

        public C6434a(a.c cVar, a.b bVar, com.tencent.luggage.wxa.wb.a aVar) {
            this.f133341a = cVar;
            this.f133342b = bVar;
            this.f133343c = aVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(t8 t8Var) {
            if (t8Var != null) {
                try {
                    this.f133341a.b().a(t8Var.b());
                    a.b bVar = this.f133342b;
                    if (bVar != null) {
                        bVar.a(0, 0, null, this.f133343c);
                        return;
                    }
                    return;
                } catch (IOException e16) {
                    w.b("Luggage.WXA.FULL.CompatNetSceneDispatcherDefaultAdapter", "onTerminate uri=" + this.f133341a.getUri() + ", parse responseProtoBuf get e=" + e16);
                    a.b bVar2 = this.f133342b;
                    if (bVar2 != null) {
                        bVar2.a(5, 0, null, this.f133343c);
                        return;
                    }
                    return;
                }
            }
            w.b("Luggage.WXA.FULL.CompatNetSceneDispatcherDefaultAdapter", "onTerminate null response, uri=" + this.f133341a.getUri());
            a.b bVar3 = this.f133342b;
            if (bVar3 != null) {
                bVar3.a(4, -1, null, this.f133343c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.b f133344a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.wb.a f133345b;

        public b(a.b bVar, com.tencent.luggage.wxa.wb.a aVar) {
            this.f133344a = bVar;
            this.f133345b = aVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            a.b bVar = this.f133344a;
            if (bVar != null) {
                bVar.a(1, -1, str, this.f133345b);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.wb.a.InterfaceC6874a
    public int a(a.c rr5, a.b bVar, com.tencent.luggage.wxa.wb.a scene) {
        Intrinsics.checkNotNullParameter(rr5, "rr");
        Intrinsics.checkNotNullParameter(scene, "scene");
        com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
        if (cVar == null) {
            return -1;
        }
        cVar.b(rr5.getUri(), scene instanceof com.tencent.luggage.wxa.tb.a ? (String) f133340b.get(((com.tencent.luggage.wxa.tb.a) scene).b()) : null, rr5.a(), rr5.b().getClass()).a(new C6434a(rr5, bVar, scene)).a(new b(bVar, scene));
        return 0;
    }

    public final void a(String wxaUsername, String appid) {
        Intrinsics.checkNotNullParameter(wxaUsername, "wxaUsername");
        Intrinsics.checkNotNullParameter(appid, "appid");
        f133340b.put(wxaUsername, appid);
    }
}
