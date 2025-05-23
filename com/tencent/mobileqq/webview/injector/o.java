package com.tencent.mobileqq.webview.injector;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.webview.swift.injector.t;
import com.tencent.mobileqq.webview.swift.injector.u;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes35.dex */
public class o implements com.tencent.mobileqq.webview.swift.injector.s {

    /* renamed from: a, reason: collision with root package name */
    private volatile WeakReference<t> f313979a;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.mobileqq.thirdsig.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f313980a;

        a(u uVar) {
            this.f313980a = uVar;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void a(com.tencent.mobileqq.thirdsig.api.g gVar) {
            u uVar = this.f313980a;
            if (uVar != null) {
                uVar.onSuccess(HexUtil.bytes2HexStr(gVar.a()));
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void onFail(int i3, String str) {
            u uVar = this.f313980a;
            if (uVar != null) {
                uVar.onFail(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements com.tencent.mobileqq.thirdsig.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f313982a;

        b(u uVar) {
            this.f313982a = uVar;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void a(com.tencent.mobileqq.thirdsig.api.g gVar) {
            u uVar = this.f313982a;
            if (uVar != null) {
                uVar.onSuccess(new String(gVar.a()));
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void onFail(int i3, String str) {
            u uVar = this.f313982a;
            if (uVar != null) {
                uVar.onFail(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements com.tencent.mobileqq.thirdsig.api.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.webview.swift.injector.g f313984a;

        c(com.tencent.mobileqq.webview.swift.injector.g gVar) {
            this.f313984a = gVar;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.c
        public void onFail(int i3, String str) {
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f313984a;
            if (gVar != null) {
                gVar.onFail(str + ":" + i3);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.c
        public void onSuccess(ArrayList<com.tencent.mobileqq.thirdsig.api.f> arrayList) {
            if (this.f313984a != null) {
                HashMap hashMap = new HashMap(arrayList.size());
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    try {
                        hashMap.put(arrayList.get(i3).a(), new String(arrayList.get(i3).b()));
                    } catch (Exception e16) {
                        QLog.e("ThirdSigFetcherInjector", 1, "getPt4Token exception: " + e16.getMessage(), e16);
                    }
                }
                this.f313984a.onSuccess(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(long j3) {
        t tVar = this.f313979a.get();
        if (tVar != null) {
            tVar.onChange(j3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.s
    public void a(AppRuntime appRuntime, t tVar) {
        QLog.d("ThirdSigFetcherInjector", 1, "addOnSigChangeListener");
        this.f313979a = new WeakReference<>(tVar);
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).addOnSigChangeListener(new com.tencent.mobileqq.thirdsig.api.e() { // from class: com.tencent.mobileqq.webview.injector.n
            @Override // com.tencent.mobileqq.thirdsig.api.e
            public final void onChange(long j3) {
                o.this.f(j3);
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.s
    public void b(AppRuntime appRuntime, int i3, ArrayList<String> arrayList, com.tencent.mobileqq.webview.swift.injector.g gVar) {
        if (appRuntime == null) {
            return;
        }
        QLog.d("ThirdSigFetcherInjector", 1, "getPt4Token");
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getPt4Token(appRuntime.getLongAccountUin(), i3, arrayList, new c(gVar));
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.s
    public void c(AppRuntime appRuntime, int i3, u uVar) {
        if (appRuntime == null) {
            return;
        }
        QLog.d("ThirdSigFetcherInjector", 1, "getStWeb");
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getStWeb(appRuntime.getLongAccountUin(), 0, i3, new a(uVar));
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.s
    public void d(AppRuntime appRuntime, int i3, u uVar) {
        if (appRuntime == null) {
            return;
        }
        QLog.d("ThirdSigFetcherInjector", 1, "getSuperKey");
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getSuperKey(appRuntime.getLongAccountUin(), i3, new b(uVar));
    }
}
