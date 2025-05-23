package com.tencent.luggage.wxa.l4;

import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.oe.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J;\u0010\u000f\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JK\u0010\u000f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/luggage/wxa/l4/e;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/oe/i;", "", "U", "id", "", "c", "", "X", "PARAM", "RET", "params", "Lcom/tencent/luggage/wxa/ka/r;", "invoke", "a", "(Ljava/lang/Object;Lcom/tencent/luggage/wxa/ka/r;)Ljava/lang/Object;", "Lcom/tencent/luggage/wxa/ka/f;", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "(Ljava/lang/Object;Lcom/tencent/luggage/wxa/ka/f;Lcom/tencent/luggage/wxa/ka/i;)V", "<init>", "()V", "luggage-wechat-full-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.eo.d implements i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Lcom/tencent/luggage/wxa/va/a;", "a", "(Lcom/tencent/luggage/wxa/va/e;)Lcom/tencent/luggage/wxa/va/a;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final a f133028a = new a();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.a invoke(com.tencent.luggage.wxa.va.e eVar) {
            boolean X = g.f133035b.X();
            w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "invoke, isScanningTooFrequently, isTooFrequently: " + X);
            return new com.tencent.luggage.wxa.va.a(X);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Lcom/tencent/luggage/wxa/va/b;", "a", "(Lcom/tencent/luggage/wxa/va/e;)Lcom/tencent/luggage/wxa/va/b;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final b f133029a = new b();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.b invoke(com.tencent.luggage.wxa.va.e eVar) {
            int U = g.f133035b.U();
            w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "invoke, recordScanStart, id: " + U);
            return new com.tencent.luggage.wxa.va.b(U);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/va/b;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/va/b;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class c<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final c f133030a = new c();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.b bVar, com.tencent.luggage.wxa.ka.i iVar) {
            int i3 = bVar != null ? bVar.f143313a : -1;
            w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "invoke, recordScanStop, id: " + i3);
            g.f133035b.c(i3);
            if (iVar != null) {
                iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.ka.i {

        /* renamed from: a, reason: collision with root package name */
        public static final d f133031a = new d();

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(com.tencent.luggage.wxa.va.e eVar) {
            w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "onCallback, recordScanStop");
        }
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public int U() {
        int i3;
        com.tencent.luggage.wxa.va.b bVar = (com.tencent.luggage.wxa.va.b) a((Object) null, b.f133029a);
        if (bVar != null) {
            i3 = bVar.f143313a;
        } else {
            i3 = -1;
        }
        w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStart#Agent, id: " + i3);
        return i3;
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public boolean X() {
        boolean z16;
        com.tencent.luggage.wxa.va.a aVar = (com.tencent.luggage.wxa.va.a) a((Object) null, a.f133028a);
        if (aVar != null) {
            z16 = aVar.f143312a;
        } else {
            z16 = false;
        }
        w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "isScanningTooFrequently#Agent, isTooFrequently: " + z16);
        return z16;
    }

    public final Object a(Object params, r invoke) {
        com.tencent.luggage.wxa.er.a.b(com.tencent.luggage.wxa.sa.b.a(invoke.getClass()));
        return com.tencent.luggage.wxa.qa.f.a(z.a(), params, invoke.getClass());
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public void c(int id5) {
        a(new com.tencent.luggage.wxa.va.b(id5), c.f133030a, d.f133031a);
    }

    public final void a(Object params, com.tencent.luggage.wxa.ka.f invoke, com.tencent.luggage.wxa.ka.i callback) {
        com.tencent.luggage.wxa.er.a.b(com.tencent.luggage.wxa.sa.b.a(invoke.getClass()));
        com.tencent.luggage.wxa.qa.f.a(z.a(), params, invoke.getClass(), callback);
    }
}
