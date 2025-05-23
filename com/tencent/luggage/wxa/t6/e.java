package com.tencent.luggage.wxa.t6;

import android.app.Application;
import com.tencent.luggage.wxa.ka.p;
import com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCContainerService0;
import com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCContainerService1;
import com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCContainerService2;
import com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCContainerService3;
import com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCContainerService4;
import com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCMainService;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f140872a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f140873b = {WxaIPCContainerService0.class, WxaIPCContainerService1.class, WxaIPCContainerService2.class, WxaIPCContainerService3.class, WxaIPCContainerService4.class};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements p.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f140874a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.t6.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6740a extends com.tencent.luggage.wxa.la.a {
            @Override // com.tencent.luggage.wxa.la.a, com.tencent.luggage.wxa.la.d
            public void a(com.tencent.luggage.wxa.la.f fVar) {
                super.a(fVar);
                if (fVar != null) {
                    fVar.a(new com.tencent.luggage.wxa.q3.a());
                }
            }

            @Override // com.tencent.luggage.wxa.la.d
            public void b(com.tencent.luggage.wxa.la.e eVar) {
                if (eVar != null) {
                    eVar.a(z.h(), WxaIPCMainService.class);
                }
                Class[] clsArr = e.f140873b;
                int length = clsArr.length;
                int i3 = 0;
                int i16 = 0;
                while (i3 < length) {
                    Class cls = clsArr[i3];
                    int i17 = i16 + 1;
                    if (eVar != null) {
                        eVar.a(z.h() + ":wxa_container" + i16, cls);
                    }
                    i3++;
                    i16 = i17;
                }
            }
        }

        public a(Application application) {
            this.f140874a = application;
        }

        @Override // com.tencent.luggage.wxa.ka.p.d
        public com.tencent.luggage.wxa.la.d a() {
            return new C6740a();
        }

        @Override // com.tencent.luggage.wxa.ka.p.d
        public Application b() {
            return this.f140874a;
        }

        @Override // com.tencent.luggage.wxa.ka.p.d
        public com.tencent.luggage.wxa.la.c c() {
            return null;
        }
    }

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        p.a(new a(application));
    }
}
