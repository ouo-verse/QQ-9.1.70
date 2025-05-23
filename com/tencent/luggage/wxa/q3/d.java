package com.tencent.luggage.wxa.q3;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.n3.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0014\u0010\u0014\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/luggage/wxa/q3/d;", "Lcom/tencent/luggage/wxa/ka/r;", "Lcom/tencent/luggage/wxa/q3/e;", "Lcom/tencent/luggage/wxa/q3/f;", "Lcom/tencent/luggage/wxa/hn/t8;", "RESP", "", "cmdId", "", "url", "Lcom/tencent/luggage/wxa/n3/w;", DKEngine.GlobalKey.NET_WORK_TYPE, "Lcom/tencent/luggage/wxa/fn/b;", "req", "Ljava/lang/Class;", "respClazz", "a", "(ILjava/lang/String;Lcom/tencent/luggage/wxa/n3/w;Lcom/tencent/luggage/wxa/fn/b;Ljava/lang/Class;)Lcom/tencent/luggage/wxa/hn/t8;", "data", "()Ljava/lang/String;", "TAG", "<init>", "()V", "luggage-standalone-addon-loginsession_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class d implements r {
    public abstract t8 a(int cmdId, String url, w networkType, com.tencent.luggage.wxa.fn.b req, Class respClazz);

    @Override // com.tencent.luggage.wxa.ka.r
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f invoke(e data) {
        if (data == null) {
            com.tencent.luggage.wxa.tn.w.b(a(), "request data is null, return");
            f fVar = new f(0, 0, null, null, 15, null);
            fVar.a(-1);
            fVar.a("invalid data");
            return fVar;
        }
        try {
            Class<?> cls = Class.forName(data.d());
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out com.tencent.mm.protocal.protobuf.ResponseProtoBuf>");
            t8 a16 = a(data.a(), data.e(), data.b(), data.c(), cls);
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.b(a(), "realResp is null, return");
                f fVar2 = new f(0, 0, null, null, 15, null);
                fVar2.a(-1);
                fVar2.a("resp is null, return");
                return fVar2;
            }
            f fVar3 = new f(0, 0, null, null, 15, null);
            fVar3.a(a16);
            fVar3.a(0);
            fVar3.a("");
            return fVar3;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b(a(), "invoke fail:[" + e16 + ']');
            f fVar4 = new f(0, 0, null, null, 15, null);
            fVar4.a(-1);
            fVar4.a(String.valueOf(e16.getMessage()));
            return fVar4;
        }
    }

    public abstract String a();
}
