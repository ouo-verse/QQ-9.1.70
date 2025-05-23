package com.tencent.luggage.wxa.l1;

import android.content.Context;
import com.tencent.luggage.wxa.l1.a;
import com.tencent.luggage.wxa.re.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.l1.a {

    /* renamed from: k0, reason: collision with root package name */
    public List f132913k0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements j.d {
        @Override // com.tencent.luggage.wxa.re.j.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.l1.a a(Context context) {
            return new b(context);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l1.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6415b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f132914a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f132915b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.re.c f132916c;

        public RunnableC6415b(com.tencent.luggage.wxa.xd.d dVar, d dVar2, com.tencent.luggage.wxa.re.c cVar) {
            this.f132914a = dVar;
            this.f132915b = dVar2;
            this.f132916c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.f132863b0 == null) {
                bVar.f132863b0 = new com.tencent.luggage.wxa.l1.c(this.f132914a);
            }
            int i3 = this.f132915b.e().x;
            int i16 = this.f132915b.e().y;
            int a16 = b.this.f132863b0.a(this.f132915b, i3, i16);
            if (a16 < 0) {
                this.f132916c.a(String.format("illegal state:%d", Integer.valueOf(a16)), -1, -1, -1);
            } else {
                this.f132916c.a(null, a16, i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends a.i {
        public c() {
            super();
        }

        @Override // com.tencent.luggage.wxa.l1.a.i
        public com.tencent.luggage.wxa.n1.b d() {
            return new com.tencent.luggage.wxa.n1.b();
        }
    }

    public b(Context context) {
        super(context);
        com.tencent.luggage.wxa.k.e.a(context.getApplicationContext());
    }

    public static void u() {
        j.a(new a());
    }

    @Override // com.tencent.luggage.wxa.re.e
    public float a(float f16) {
        return 0.0f;
    }

    @Override // com.tencent.luggage.wxa.l1.a
    public void j() {
        List list = this.f132913k0;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f132913k0.clear();
    }

    @Override // com.tencent.luggage.wxa.l1.a
    public d a(Context context, int i3, int i16) {
        return new e(context);
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        com.tencent.luggage.wxa.re.c operateCallBack = getOperateCallBack();
        if (operateCallBack == null) {
            return;
        }
        d recordView = getRecordView();
        if (recordView == null) {
            w.f("MicroMsg.AppBrandCameraViewLU", "listenFrameChange recordView null");
            operateCallBack.a("camera illegal state", -1, -1, -1);
            return;
        }
        RunnableC6415b runnableC6415b = new RunnableC6415b(dVar, recordView, operateCallBack);
        if (!this.f132865c0) {
            if (this.f132913k0 == null) {
                this.f132913k0 = new ArrayList();
            }
            this.f132913k0.add(runnableC6415b);
            return;
        }
        runnableC6415b.run();
    }

    @Override // com.tencent.luggage.wxa.l1.a
    public a.g a(String str) {
        if (!w0.c(str) && str.equals("scanCode") && com.tencent.luggage.wxa.y3.a.f145414a.a()) {
            return new c();
        }
        return super.a(str);
    }
}
