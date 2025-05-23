package com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qphone.base.util.QLog;
import ee2.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DBMemoryCacheStrategy implements a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f261918a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public static int f261919b = 60000;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f261920c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, fe2.a> f261921d = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBMemoryCacheStrategy$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ge2.a f261922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f261923e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f261924f;
        final /* synthetic */ DBMemoryCacheStrategy this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.f261922d.c(new fe2.a(this.f261923e, this.f261924f, 1));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBMemoryCacheStrategy$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f261925d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f261926e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f261927f;
        final /* synthetic */ DBMemoryCacheStrategy this$0;

        @Override // java.lang.Runnable
        public void run() {
            DBMemoryCacheStrategy.g(this.f261925d, this.f261926e, this.f261927f);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBMemoryCacheStrategy$3, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f261928d;
        final /* synthetic */ DBMemoryCacheStrategy this$0;

        @Override // java.lang.Runnable
        public void run() {
            DBMemoryCacheStrategy.f(this.f261928d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBMemoryCacheStrategy$4, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ge2.a f261929d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f261930e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ge2.a f261931f;
        final /* synthetic */ DBMemoryCacheStrategy this$0;

        @Override // java.lang.Runnable
        public void run() {
            for (fe2.a aVar : this.f261929d.e()) {
                String str = this.f261930e;
                b bVar = aVar.f398368d;
                String str2 = bVar.f396189b;
                String str3 = bVar.f396192e;
                if (str3 == null) {
                    str3 = "";
                }
                aVar.f398366b = he2.b.e(str, str2, str3);
                b bVar2 = aVar.f398368d;
                bVar2.f396192e = he2.b.g(bVar2.f396189b, bVar2.f396192e);
                this.f261931f.d(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(final String str) {
        Context b16 = q.b();
        if (b16 == null) {
            QLog.d("PandoraExEvent.DBMemoryCacheStrategy", 1, "[copyCacheToCurrentAccountDB] context is null");
            return;
        }
        synchronized (f261920c) {
            ge2.a b17 = ge2.a.b(b16, str);
            for (Map.Entry<String, fe2.a> entry : f261921d.entrySet()) {
                fe2.a value = entry.getValue();
                if (value != null) {
                    b17.d(value);
                }
                f261921d.remove(entry.getKey());
            }
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBMemoryCacheStrategy.5
            @Override // java.lang.Runnable
            public void run() {
                DBMemoryCacheStrategy.f(str);
            }
        }, 32, null, false, f261919b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(b bVar, String str, boolean z16) {
        synchronized (f261920c) {
            String str2 = bVar.f396189b;
            String str3 = bVar.f396192e;
            if (str3 == null) {
                str3 = "";
            }
            String e16 = he2.b.e(str, str2, str3);
            HashMap<String, fe2.a> hashMap = f261921d;
            fe2.a aVar = hashMap.get(e16);
            if (aVar == null) {
                fe2.a aVar2 = new fe2.a(bVar, e16, 1);
                b bVar2 = aVar2.f398368d;
                bVar2.f396192e = he2.b.g(bVar2.f396189b, bVar2.f396192e);
                hashMap.put(e16, aVar2);
            } else if (z16) {
                aVar.f398367c++;
            }
        }
    }
}
