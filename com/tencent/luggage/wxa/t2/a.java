package com.tencent.luggage.wxa.t2;

import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.t2.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import com.tencent.luggage.wxa.xd.i;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.xd.a implements com.tencent.luggage.wxa.xd.b {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6732a implements c.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f1 f140836a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f140837b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f140838c;

        public C6732a(f1 f1Var, i iVar, int i3) {
            this.f140836a = f1Var;
            this.f140837b = iVar;
            this.f140838c = i3;
        }

        @Override // com.tencent.luggage.wxa.t2.c.b
        public void a(int i3, String str) {
            w.d("Luggage.BaseLoginJsApi", "%s.invoke: login result errCode:%d errMsg:%s", a.this.getName(), Integer.valueOf(i3), str);
            if (i3 == 0) {
                a.this.b(this.f140836a);
                return;
            }
            this.f140837b.a(this.f140838c, a.this.makeReturnJson("fail:" + str));
        }
    }

    public boolean a(JSONObject jSONObject) {
        return false;
    }

    public abstract void b(f1 f1Var);

    public abstract boolean b(JSONObject jSONObject);

    public void a(f1 f1Var) {
        i iVar = (i) f1Var.f();
        JSONObject e16 = f1Var.e();
        f1Var.g();
        int d16 = f1Var.d();
        if (!l.f136139a.c() && !a(e16)) {
            c a16 = ((d) com.tencent.luggage.wxa.h1.e.a(d.class)).a(iVar, e16);
            if (a16 == null) {
                w.b("Luggage.BaseLoginJsApi", "%s.invoke: loginLogic is null, return", getName());
                iVar.a(d16, makeReturnJson("fail:not supported"));
                return;
            }
            if (!(a16.a(getName(), iVar, e16) && b(e16))) {
                w.b("Luggage.BaseLoginJsApi", "%s.invoke: canLogin:false return", getName());
                iVar.a(d16, makeReturnJson("fail:not login"));
                return;
            } else {
                w.d("Luggage.BaseLoginJsApi", "invoke loginLogic, api=%s, callbackId=%s", getName(), Integer.valueOf(d16));
                a16.a(iVar, new C6732a(f1Var, iVar, d16));
                return;
            }
        }
        b(f1Var);
    }
}
