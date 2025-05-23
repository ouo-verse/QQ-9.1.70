package com.tencent.luggage.wxa.s3;

import com.tencent.luggage.wxa.n3.l;
import com.tencent.luggage.wxa.n3.o;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.n3.y;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final C6701a f140004c = new C6701a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f140005a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final b f140006b = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6701a {
        public C6701a() {
        }

        public /* synthetic */ C6701a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public final void b(t.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f140005a.remove(callback);
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public final boolean a(t.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f140005a.add(callback);
        t k3 = k();
        if (k3 == null) {
            return false;
        }
        k3.c(this.f140006b);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements t.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(int i3, int i16, com.tencent.luggage.wxa.n3.a aVar) {
            a aVar2 = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar2.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(i3, i16, aVar);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void onLoginComplete(int i3) {
            w.d("Luggage.BaseActivateDevice", "onLogicComplete errCode:" + i3 + ", ");
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).onLoginComplete(i3);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void onLogoutComplete(int i3) {
            w.d("Luggage.BaseActivateDevice", "onLogoutComplete errCode:" + i3);
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).onLogoutComplete(i3);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(y cmd) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(cmd);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(int i3, o result) {
            Intrinsics.checkNotNullParameter(result, "result");
            w.d("Luggage.BaseActivateDevice", "onGetLoginQrCodeComplete: " + i3);
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(i3, result);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public void a(int i3, int i16, byte[] resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(i3, i16, resp);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public void a(byte[] body) {
            Intrinsics.checkNotNullParameter(body, "body");
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(body);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(int i3, l lVar) {
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(i3, lVar);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(int i3, com.tencent.luggage.wxa.n3.d dVar) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCdnUploadCompleted(taskId:");
            sb5.append(i3);
            sb5.append(", errCode:");
            sb5.append(dVar != null ? Integer.valueOf(dVar.a()) : null);
            sb5.append(", fileKey:");
            sb5.append(dVar != null ? dVar.c() : null);
            sb5.append(')');
            w.d("Luggage.BaseActivateDevice", sb5.toString());
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(i3, dVar);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(int i3, com.tencent.luggage.wxa.n3.c cVar) {
            a aVar = a.this;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f140005a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((t.a) it.next()).a(i3, cVar);
            }
        }
    }
}
