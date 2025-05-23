package com.tencent.luggage.wxa.q3;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@com.tencent.luggage.wxa.na.a
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b!\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019JJ\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0010\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&J#\u0010\u0011\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0096\u0002R\u0014\u0010\u0017\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/luggage/wxa/q3/c;", "Lcom/tencent/luggage/wxa/ka/e;", "Lcom/tencent/luggage/wxa/q3/e;", "Lcom/tencent/luggage/wxa/q3/f;", "Lcom/tencent/luggage/wxa/hn/t8;", "RESP", "", "cmdId", "", "url", "Lcom/tencent/luggage/wxa/n3/w;", DKEngine.GlobalKey.NET_WORK_TYPE, "Lcom/tencent/luggage/wxa/fn/b;", "req", "Ljava/lang/Class;", "respClazz", "Lcom/tencent/luggage/wxa/xo/d;", "a", "data", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "()Ljava/lang/String;", "TAG", "<init>", "()V", "luggage-standalone-addon-loginsession_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class c implements com.tencent.luggage.wxa.ka.e<e, f> {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f137821b;

        public a(i iVar) {
            this.f137821b = iVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(t8 t8Var) {
            if (t8Var == null) {
                w.b(c.this.a(), "resp is null, return");
                i iVar = this.f137821b;
                if (iVar != null) {
                    f fVar = new f(0, 0, null, null, 15, null);
                    fVar.a(-1);
                    fVar.a("resp is null, return");
                    iVar.a(fVar);
                    return;
                }
                return;
            }
            i iVar2 = this.f137821b;
            if (iVar2 != null) {
                f fVar2 = new f(0, 0, null, null, 15, null);
                fVar2.a(t8Var);
                fVar2.a(0);
                fVar2.a("");
                iVar2.a(fVar2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f137822a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f137823b;

        public b(i iVar, c cVar) {
            this.f137822a = iVar;
            this.f137823b = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof com.tencent.luggage.wxa.bj.a) {
                i iVar = this.f137822a;
                if (iVar != null) {
                    f fVar = new f(0, 0, null, null, 15, null);
                    com.tencent.luggage.wxa.bj.a aVar = (com.tencent.luggage.wxa.bj.a) obj;
                    fVar.b(aVar.f122898a.ordinal());
                    fVar.a(aVar.f122899b);
                    fVar.a(aVar.f122900c);
                    iVar.a(fVar);
                    return;
                }
                return;
            }
            if (obj instanceof String) {
                str = (String) obj;
            } else if (obj instanceof Exception) {
                str = ((Exception) obj).getMessage();
            } else {
                str = VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR;
            }
            w.b(this.f137823b.a(), "invoke fail " + str);
            i iVar2 = this.f137822a;
            if (iVar2 != null) {
                f fVar2 = new f(0, 0, null, null, 15, null);
                fVar2.a(-1);
                fVar2.a(String.valueOf(str));
                iVar2.a(fVar2);
            }
        }
    }

    public abstract com.tencent.luggage.wxa.xo.d a(int cmdId, String url, com.tencent.luggage.wxa.n3.w networkType, com.tencent.luggage.wxa.fn.b req, Class respClazz);

    public abstract String a();

    @Override // com.tencent.luggage.wxa.ka.f
    public void a(e data, i callback) {
        if (data == null) {
            w.b(a(), "data is null, return");
            if (callback != null) {
                f fVar = new f(0, 0, null, null, 15, null);
                fVar.a(-1);
                fVar.a("invalid data");
                callback.a(fVar);
                return;
            }
            return;
        }
        Class<?> cls = Class.forName(data.d());
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<com.tencent.mm.protocal.protobuf.ResponseProtoBuf>");
        a(data.a(), data.e(), data.b(), data.c(), cls).a(new a(callback)).a(new b(callback, this));
    }
}
