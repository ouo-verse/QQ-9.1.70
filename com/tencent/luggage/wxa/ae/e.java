package com.tencent.luggage.wxa.ae;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.uk.k implements g, d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f121060a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f121061b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f121062c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f1 f121063d;

        public a(com.tencent.luggage.wxa.xd.d dVar, k kVar, e eVar, f1 f1Var) {
            this.f121060a = dVar;
            this.f121061b = kVar;
            this.f121062c = eVar;
            this.f121063d = f1Var;
        }

        @Override // com.tencent.luggage.wxa.ae.e.b
        public void a() {
            w.d("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", e.this.h());
            if (!this.f121060a.isRunning()) {
                w.b("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", this.f121061b.getName());
                this.f121062c.b();
            } else {
                this.f121061b.b(this.f121063d, new com.tencent.luggage.wxa.ae.a(this.f121062c));
            }
        }

        public String toString() {
            return hashCode() + "|" + this.f121061b.getName();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final d f121065a = (d) com.tencent.luggage.wxa.uk.o.a("MicroMsg.AppBrandAuthJsApiQueue", d.class);
    }

    public e(com.tencent.luggage.wxa.ic.g gVar) {
        this(gVar == null ? null : gVar.getAppId());
    }

    public static d a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar == null) {
            return c.f121065a;
        }
        if (dVar instanceof com.tencent.luggage.wxa.ic.d) {
            e g16 = ((com.tencent.luggage.wxa.c5.e) ((com.tencent.luggage.wxa.ic.d) dVar).getRuntime()).g();
            return g16 != null ? g16 : c.f121065a;
        }
        if (!(dVar instanceof com.tencent.luggage.wxa.ae.c)) {
            return c.f121065a;
        }
        return ((com.tencent.luggage.wxa.ae.c) dVar).g();
    }

    @Override // com.tencent.luggage.wxa.uk.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean c(b bVar) {
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e(String str) {
        super(r0.toString(), Looper.getMainLooper());
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MicroMsg.AppBrandAuthJsApiQueue");
        if (TextUtils.isEmpty(str)) {
            str2 = "|DUMMY";
        } else {
            str2 = "|" + str;
        }
        sb5.append(str2);
    }

    @Override // com.tencent.luggage.wxa.ae.g
    public void b() {
        p();
    }

    @Override // com.tencent.luggage.wxa.ae.d
    public void a() {
        super.k();
    }

    @Override // com.tencent.luggage.wxa.uk.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(b bVar) {
        w.a(h(), "about to executeTask %s", bVar.toString());
        bVar.a();
    }

    @Override // com.tencent.luggage.wxa.ae.d
    public void a(k kVar, f1 f1Var) {
        com.tencent.luggage.wxa.xd.d f16 = f1Var.f();
        JSONObject e16 = f1Var.e();
        w.d("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", kVar.getName(), Integer.valueOf(f1Var.d()), f16.getAppId());
        try {
            e16.put("queueLength", o());
        } catch (JSONException unused) {
        }
        super.a((Object) new a(f16, kVar, this, f1Var));
    }
}
