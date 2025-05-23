package com.tencent.luggage.wxa.h7;

import com.tencent.luggage.wxa.a6.e;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.w;
import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.v6.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends e {
    public static final a N = new a(null);
    public com.tencent.luggage.wxa.a6.d M;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull b service) {
        super(service);
        Intrinsics.checkNotNullParameter(service, "service");
    }

    @Override // com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public void T() {
        super.T();
        com.tencent.luggage.wxa.a6.d dVar = this.M;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // com.tencent.luggage.wxa.a6.e, com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public boolean a(String str, JSONObject jSONObject) {
        Intrinsics.areEqual("WXAUDIO", str);
        return super.a(str, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.a6.e, com.tencent.luggage.wxa.r4.c
    public String d0() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("var openInvokeHandlerJsBinding = true;");
        sb5.append(super.d0());
        com.tencent.luggage.wxa.a6.d dVar = this.M;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNodeInstaller");
            dVar = null;
        }
        sb5.append(dVar.a());
        return sb5.toString();
    }

    @Override // com.tencent.luggage.wxa.a6.e, com.tencent.luggage.wxa.r4.f
    public Map q() {
        return new h().a();
    }

    @Override // com.tencent.luggage.wxa.a6.e, com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public j v() {
        boolean z16;
        q i3;
        String h16;
        b bVar = (b) t();
        if (bVar != null && (i3 = bVar.i()) != null && (h16 = i3.h("delayedServiceCodeCache")) != null) {
            z16 = Boolean.parseBoolean(h16);
        } else {
            z16 = false;
        }
        d.a aVar = new d.a();
        aVar.f122185a = com.tencent.luggage.wxa.q5.c.f137855a.a();
        aVar.f122188d = null;
        aVar.f122190f = "1";
        aVar.f122191g = true;
        aVar.f122192h = true;
        aVar.f122193i = true;
        aVar.f122194j = false;
        aVar.f122199o = new WeakReference(t());
        aVar.f122198n = z16;
        w wVar = new w(aVar);
        com.tencent.luggage.wxa.a6.d dVar = new com.tencent.luggage.wxa.a6.d();
        this.M = dVar;
        com.tencent.luggage.wxa.xd.d t16 = t();
        Intrinsics.checkNotNull(t16);
        dVar.a((l) t16, wVar, e.a.Service);
        return wVar;
    }
}
