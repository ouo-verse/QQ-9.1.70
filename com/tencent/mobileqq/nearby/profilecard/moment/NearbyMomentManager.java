package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.moment.b;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import u92.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyMomentManager implements Manager, c {

    /* renamed from: d, reason: collision with root package name */
    private List<b> f253019d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    protected DecimalFormat f253020e = new DecimalFormat("#.##");

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f253021f;

    /* renamed from: h, reason: collision with root package name */
    private String f253022h;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.nearby.profilecard.moment.a f253033a;

        a(com.tencent.mobileqq.nearby.profilecard.moment.a aVar) {
            this.f253033a = aVar;
        }

        @Override // com.tencent.mobileqq.nearby.profilecard.moment.b.c
        public void onResult(boolean z16, String str) {
            NearbyMomentManager.this.j(str);
            com.tencent.mobileqq.nearby.profilecard.moment.a aVar = this.f253033a;
            if (aVar != null) {
                aVar.onResult(z16, str);
            }
        }
    }

    public NearbyMomentManager(QQAppInterface qQAppInterface) {
        this.f253021f = qQAppInterface;
    }

    @Override // u92.c
    public synchronized void a(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.8
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NearbyMomentManager.this.f253019d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).c(str);
                }
            }
        });
    }

    @Override // u92.c
    public synchronized void b(final String str, final long j3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NearbyMomentManager.this.f253019d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(str, j3);
                }
            }
        });
    }

    @Override // u92.c
    public synchronized void d(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NearbyMomentManager.this.f253019d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).e(str);
                }
            }
        });
    }

    @Override // u92.c
    public synchronized void e(final String str, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.7
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NearbyMomentManager.this.f253019d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).f(str, i3);
                }
            }
        });
    }

    @Override // u92.c
    public void f(String str) {
        this.f253022h = str;
    }

    @Override // u92.c
    public synchronized void g(final String str, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NearbyMomentManager.this.f253019d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).d(str, i3);
                }
            }
        });
    }

    public synchronized void j(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NearbyMomentManager.this.f253019d.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).b(str);
                    NearbyMomentManager.this.f253022h = null;
                }
            }
        });
    }

    @Override // mqq.manager.Manager
    public synchronized void onDestroy() {
        this.f253019d.clear();
    }

    @Override // u92.c
    public void c(String str, long j3, int i3, com.tencent.mobileqq.nearby.profilecard.moment.a aVar) {
        if (i3 == 6) {
            i3 = 10;
        }
        com.tencent.mobileqq.nearby.profilecard.moment.b.a(this.f253021f, str, j3, i3, new a(aVar));
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class b {
        void b(String str) {
        }

        void c(String str) {
        }

        void e(String str) {
        }

        void a(String str, long j3) {
        }

        void d(String str, long j3) {
        }

        void f(String str, long j3) {
        }
    }
}
