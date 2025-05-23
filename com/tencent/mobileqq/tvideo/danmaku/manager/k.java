package com.tencent.mobileqq.tvideo.danmaku.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.TextureView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import tz3.i;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.rfw.barrage.core.d f304393a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f304394b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f304395c = new AtomicBoolean(true);

    /* renamed from: d, reason: collision with root package name */
    private long f304396d;

    /* renamed from: e, reason: collision with root package name */
    private tx2.a f304397e;

    /* renamed from: f, reason: collision with root package name */
    private tz3.i f304398f;

    /* renamed from: g, reason: collision with root package name */
    private h70.a f304399g;

    /* renamed from: h, reason: collision with root package name */
    private c f304400h;

    /* renamed from: i, reason: collision with root package name */
    private a f304401i;

    /* renamed from: j, reason: collision with root package name */
    private sx2.d f304402j;

    /* renamed from: k, reason: collision with root package name */
    private sx2.a f304403k;

    /* renamed from: l, reason: collision with root package name */
    private b f304404l;

    /* renamed from: m, reason: collision with root package name */
    private tz3.k f304405m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.rfw.barrage.data.a f304406n;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class a implements tz3.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<k> f304407a;

        public a(k kVar) {
            this.f304407a = new WeakReference<>(kVar);
        }

        @Override // tz3.c
        public void a(com.tencent.rfw.barrage.data.a aVar) {
            k kVar;
            WeakReference<k> weakReference = this.f304407a;
            if (weakReference == null) {
                kVar = null;
            } else {
                kVar = weakReference.get();
            }
            if (kVar != null) {
                kVar.T(aVar);
            } else {
                QLog.d("QDM-TVideoBarrageManager", 1, "[onFirstExposure] model should not be null.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class c implements tz3.d {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<k> f304409a;

        public c(k kVar) {
            this.f304409a = new WeakReference<>(kVar);
        }

        @Override // tz3.d
        public long a() {
            k kVar;
            WeakReference<k> weakReference = this.f304409a;
            if (weakReference == null) {
                kVar = null;
            } else {
                kVar = weakReference.get();
            }
            if (kVar != null) {
                long B = kVar.B();
                if (B == 0) {
                    return 1L;
                }
                return B;
            }
            QLog.d("QDM-TVideoBarrageManager", 1, "[getPlayTime] manager should not be null.");
            return 0L;
        }
    }

    public k(Context context, TextureView textureView) {
        tz3.k l3 = tz3.i.l();
        this.f304405m = l3;
        l3.A(0.0f);
        this.f304405m.s(20.0f);
        this.f304405m.t(20.0f);
        this.f304405m.r(E());
        Y();
        this.f304400h = new c(this);
        this.f304401i = new a(this);
        i.b o16 = tz3.i.o();
        o16.p(this.f304400h);
        o16.o(-10);
        o16.k(new sx2.b(context));
        o16.n(this.f304401i);
        sx2.d dVar = new sx2.d();
        this.f304402j = dVar;
        o16.q(dVar);
        sx2.a aVar = new sx2.a();
        this.f304403k = aVar;
        o16.m(aVar);
        this.f304398f = o16.l();
        com.tencent.rfw.barrage.core.d dVar2 = new com.tencent.rfw.barrage.core.d(textureView, this.f304398f);
        this.f304393a = dVar2;
        dVar2.A0(new o70.a().e());
        dVar2.z0(F());
        b bVar = new b(this);
        this.f304404l = bVar;
        dVar2.y0(bVar);
        QLog.d("QDM-TVideoBarrageManager", 1, "[QFSBarrageManager] configuration: " + context.getResources().getConfiguration().orientation);
        tz3.j.c(new n70.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long B() {
        return this.f304396d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(com.tencent.rfw.barrage.data.a aVar, vz3.h hVar, vz3.e eVar) {
        String hVar2;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, "[handleClickEvent] barrage should not be null.");
            return;
        }
        FeedCloudMeta$StBarrage z16 = z(aVar);
        if (z16 != null && z16.postUser != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleClickEvent] touchPoint: ");
            if (hVar == null) {
                hVar2 = "null";
            } else {
                hVar2 = hVar.toString();
            }
            sb5.append(hVar2);
            QLog.d("QDM-TVideoBarrageManager", 1, n(sb5.toString()));
            l0(false);
            aVar.h0(true);
            this.f304406n = aVar;
            l0(true);
            R(aVar, hVar);
            V();
            return;
        }
        QLog.w("QDM-TVideoBarrageManager", 1, "[handleClickEvent] current click barrage pb data.");
    }

    private boolean D(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage2) {
        if (feedCloudMeta$StBarrage != null && feedCloudMeta$StBarrage2 != null) {
            return TextUtils.equals(feedCloudMeta$StBarrage.f398446id.get(), feedCloudMeta$StBarrage2.f398446id.get());
        }
        return false;
    }

    private boolean E() {
        return false;
    }

    private boolean F() {
        return uq3.c.N5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(List list, List list2) {
        this.f304397e.a(list);
        S(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(List list) {
        if (this.f304393a == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[notifyBarrageFakeConvert] barrage manager should not be null"));
            return;
        }
        a0(true);
        n0(list);
        this.f304393a.C0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar == null) {
            return;
        }
        dVar.f0();
        this.f304393a.C0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(List list) {
        I(list);
        a0(true);
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar != null) {
            dVar.F0(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(List list) {
        if (this.f304393a == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[restart] barrage manager should not be null."));
            return;
        }
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(w(list));
        u();
        this.f304396d = 33L;
        k0(33L);
        this.f304393a.n0(33L, new sz3.c() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.f
            @Override // sz3.c
            public final void a() {
                k.this.M(copyOnWriteArrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(boolean z16) {
        i0(z16);
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar != null) {
            dVar.D0(null);
            this.f304393a.B0(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(List list, long j3, final boolean z16) {
        sx2.c b16;
        if (this.f304393a == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, "[seek] seek barrage manager should not be null, hashcode: " + hashCode());
            return;
        }
        I(list);
        sx2.d dVar = this.f304402j;
        if (dVar == null) {
            b16 = null;
        } else {
            b16 = dVar.b();
        }
        if (b16 != null) {
            b16.F();
        }
        this.f304393a.u0(j3, new sz3.e() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.i
            @Override // sz3.e
            public final void a() {
                k.this.O(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(final long j3, final boolean z16, final List list) {
        if (this.f304393a == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, "[seek] seek barrage manager should not be null, hashcode: " + hashCode());
            return;
        }
        u();
        this.f304393a.s(new sz3.b() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.g
            @Override // sz3.b
            public final void a() {
                k.this.P(list, j3, z16);
            }
        });
    }

    private void R(com.tencent.rfw.barrage.data.a aVar, vz3.h hVar) {
        QLog.e("QDM-TVideoBarrageManager", 1, "[notifyBarrageClick] barrage click listener should not be null.");
    }

    private void S(final List<com.tencent.rfw.barrage.data.a> list) {
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[notifyBarrageFakeConvert] barrage manager should not be null."));
        } else {
            dVar.p0(new sz3.d() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.j
                @Override // sz3.d
                public final void a() {
                    k.this.K(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(com.tencent.rfw.barrage.data.a aVar) {
        Object l3;
        if (aVar == null) {
            l3 = null;
        } else {
            l3 = aVar.l();
        }
        if (!(l3 instanceof m70.a)) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[notifyFirstExposure] current data not is barrage holder type, notify fail."));
            return;
        }
        m70.a aVar2 = (m70.a) l3;
        h70.a aVar3 = this.f304399g;
        if (aVar3 == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[notifyFirstExposure] barrage export listener should not be null."));
        } else {
            aVar3.a(aVar2.a());
        }
    }

    private void Y() {
        float f16;
        int i3;
        boolean isPortrait = ScreenUtils.isPortrait();
        Size e16 = l.e(isPortrait);
        this.f304405m.D(e16.getWidth());
        this.f304405m.C(e16.getHeight());
        this.f304405m.F(isPortrait);
        tz3.k kVar = this.f304405m;
        if (isPortrait) {
            f16 = 12.0f;
        } else {
            f16 = 18.0f;
        }
        kVar.E(f16);
        this.f304405m.A(5.0f);
        tz3.k kVar2 = this.f304405m;
        int i16 = 3;
        if (isPortrait) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        kVar2.B(i3);
        tz3.k kVar3 = this.f304405m;
        if (isPortrait) {
            i16 = 130;
        }
        kVar3.G(i16);
    }

    private void i0(boolean z16) {
        if (this.f304393a == null) {
            return;
        }
        QLog.d("QDM-TVideoBarrageManager", 1, n("[tryBarrageResume] isPause: " + z16));
        if (z16) {
            this.f304393a.f0();
        } else {
            this.f304393a.o0();
            a0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void I(List<com.tencent.rfw.barrage.data.a> list) {
        if (this.f304393a == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[updateBarrageRenderNodeSource] barrage manager should not be null."));
            return;
        }
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[updateBarrageRenderNodeSource] barrages is empty,update barrage list fail."));
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                com.tencent.rfw.barrage.data.a aVar = (com.tencent.rfw.barrage.data.a) RFSafeListUtils.get(list, i3);
                this.f304393a.o(aVar);
                this.f304393a.n(aVar);
            } catch (Throwable th5) {
                QLog.e("QDM-TVideoBarrageManager", 1, n("[updateBarrageRenderNodeSource] count: " + RFSafeListUtils.getSize(list)), th5);
                return;
            }
        }
        QLog.d("QDM-TVideoBarrageManager", 1, n("[updateBarrageRenderNodeSource] update barrage size: " + RFSafeListUtils.getSize(list)));
    }

    private void k0(long j3) {
        com.tencent.rfw.barrage.data.a aVar = this.f304406n;
        if (aVar != null && aVar.N()) {
            com.tencent.rfw.barrage.data.a aVar2 = this.f304406n;
            this.f304406n.u0(aVar2.B(aVar2.t()) + j3);
        }
    }

    private String n(String str) {
        return str + " | hashcode: " + hashCode();
    }

    private void n0(List<com.tencent.rfw.barrage.data.a> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[notifyBarrageFakeConvert] fake barrages is empty, update to render source fail."));
            return;
        }
        if (this.f304393a == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[updateFakeBarrageToTextureQueue] barrage manager should not be null."));
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.rfw.barrage.data.a aVar = (com.tencent.rfw.barrage.data.a) RFSafeListUtils.get(list, i3);
            Object l3 = aVar.l();
            if (!(l3 instanceof m70.a)) {
                return;
            }
            QLog.d("QDM-TVideoBarrageManager", 1, n("[updateFakeBarrageToTextureQueue] newBarrage: " + ((m70.a) l3)));
            this.f304393a.o(aVar);
            this.f304393a.p(aVar);
        }
    }

    private void r(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.f304397e != null) {
            return;
        }
        this.f304397e = new tx2.a(new com.tencent.rfw.barrage.core.c(this.f304398f), feedCloudMeta$StFeed);
    }

    private void u() {
        sx2.c b16;
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar != null) {
            dVar.u();
        }
        sx2.d dVar2 = this.f304402j;
        if (dVar2 == null) {
            b16 = null;
        } else {
            b16 = dVar2.b();
        }
        if (b16 != null) {
            b16.C();
        }
    }

    private void v(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (!D(feedCloudMeta$StBarrage, z(this.f304406n))) {
            QLog.d("QDM-TVideoBarrageManager", 1, "[removeBarrage] current delete & click barrage not equals, handler fail.");
        } else {
            this.f304406n.m0(true);
            V();
        }
    }

    private List<com.tencent.rfw.barrage.data.a> w(List<com.tencent.rfw.barrage.data.a> list) {
        com.tencent.rfw.barrage.data.a aVar = this.f304406n;
        if (aVar != null && aVar.N()) {
            FeedCloudMeta$StBarrage z16 = z(this.f304406n);
            if (z16 == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (com.tencent.rfw.barrage.data.a aVar2 : list) {
                FeedCloudMeta$StBarrage z17 = z(aVar2);
                if (z17 == null) {
                    return null;
                }
                if (!D(z16, z17)) {
                    arrayList.add(aVar2);
                }
            }
            return arrayList;
        }
        return list;
    }

    private com.tencent.rfw.barrage.data.a x(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        sx2.c b16;
        sx2.d dVar = this.f304402j;
        if (dVar == null) {
            b16 = null;
        } else {
            b16 = dVar.b();
        }
        if (b16 == null) {
            return null;
        }
        return b16.q(feedCloudMeta$StBarrage);
    }

    private m70.a y(com.tencent.rfw.barrage.data.a aVar) {
        Object l3;
        if (aVar == null) {
            l3 = null;
        } else {
            l3 = aVar.l();
        }
        if (!(l3 instanceof m70.a)) {
            return null;
        }
        return (m70.a) l3;
    }

    private FeedCloudMeta$StBarrage z(com.tencent.rfw.barrage.data.a aVar) {
        m70.a y16 = y(aVar);
        if (y16 == null) {
            return null;
        }
        return y16.a();
    }

    public List<FeedCloudMeta$StBarrage> A() {
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[getCurrentDataSource] barrage data factory should not be null."));
            return null;
        }
        List<FeedCloudMeta$StBarrage> e16 = aVar.e();
        if (e16 != null && !e16.isEmpty()) {
            return new ArrayList(e16);
        }
        return new ArrayList();
    }

    public boolean G(long j3, long j16) {
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            return false;
        }
        return aVar.g(j3, j16);
    }

    public void U() {
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[pause] barrage manager should not be null."));
        } else {
            dVar.f0();
        }
    }

    public void V() {
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar == null || dVar.V()) {
            return;
        }
        this.f304393a.C0(new sz3.d() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.h
            @Override // sz3.d
            public final void a() {
                k.this.L();
            }
        });
        this.f304393a.o0();
    }

    public void W() {
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar != null) {
            dVar.k0();
            this.f304393a.B0(null);
            this.f304393a.D0(null);
            this.f304393a.C0(null);
            this.f304393a.F0(null);
            this.f304393a.E0(null);
        }
    }

    public void X(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, "[removeBarrage] barrage data factory should not be null.");
            return;
        }
        aVar.h(feedCloudMeta$StBarrage);
        if (this.f304406n == null) {
            this.f304406n = x(feedCloudMeta$StBarrage);
        }
        if (this.f304406n != null) {
            v(feedCloudMeta$StBarrage);
        }
    }

    public void Z() {
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[resetDataSource] barrage data factory should not be null."));
        } else {
            aVar.i();
        }
    }

    public void a0(boolean z16) {
        QLog.d("QDM-TVideoBarrageManager", 1, n("[resetStartPlaying] isStartPlaying: " + z16));
        this.f304394b.set(z16);
    }

    public void b0(List<FeedCloudMeta$StBarrage> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.f304393a == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[restart] barrage manager should not be null."));
        } else {
            if (this.f304397e == null) {
                QLog.d("QDM-TVideoBarrageManager", 1, n("[restart] barrage data factory should not be null."));
                return;
            }
            a0(false);
            QLog.e("QDM-TVideoBarrageManager", 1, n("[restart] barrage restart."));
            this.f304397e.m(list, new k70.a() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.a
                @Override // k70.a
                public final void a(List list2) {
                    k.this.N(list2);
                }
            });
        }
    }

    public void c0() {
        com.tencent.rfw.barrage.core.d dVar = this.f304393a;
        if (dVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[resume] barrage manager should not be null."));
        } else {
            dVar.o0();
            a0(true);
        }
    }

    public void d0(final long j3, final boolean z16) {
        if (this.f304393a == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[seek] barrage manager should not be null."));
            return;
        }
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[seek] barrage data factory should not be null."));
            return;
        }
        this.f304396d = j3;
        long j16 = j3 - 10000;
        if (j16 < 0) {
            j16 = 0;
        }
        this.f304397e.m(aVar.f(j16), new k70.a() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.e
            @Override // k70.a
            public final void a(List list) {
                k.this.Q(j3, z16, list);
            }
        });
        QLog.d("QDM-TVideoBarrageManager", 1, n("[seek] seek position: " + j3 + " | isPause: " + z16));
    }

    public void e0(boolean z16) {
        sx2.c b16;
        sx2.d dVar = this.f304402j;
        if (dVar == null || (b16 = dVar.b()) == null) {
            return;
        }
        b16.E(z16);
    }

    public void f0(List<FeedCloudMeta$StBarrage> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed, float f16) {
        r(feedCloudMeta$StFeed);
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[setDataSource] barrage data factory should not be null."));
            return;
        }
        aVar.k(f16);
        QLog.d("QDM-TVideoBarrageManager", 1, n("[setDataSource] barrage data, count: " + RFSafeListUtils.getSize(list)));
        this.f304397e.j(list);
    }

    public void g0(h70.a aVar) {
        this.f304399g = aVar;
    }

    public void h0(float f16) {
        sx2.c b16;
        this.f304393a.u();
        sx2.d dVar = this.f304402j;
        if (dVar == null) {
            b16 = null;
        } else {
            b16 = dVar.b();
        }
        if (b16 != null) {
            b16.G(f16);
        }
        tx2.a aVar = this.f304397e;
        if (aVar != null) {
            aVar.k(f16);
        }
    }

    public void l0(boolean z16) {
        String str;
        long j3;
        QLog.d("QDM-TVideoBarrageManager", 1, "[updateCurrentClickState] isClicked: " + z16);
        com.tencent.rfw.barrage.data.a aVar = this.f304406n;
        String str2 = "";
        if (aVar == null) {
            str = "";
        } else {
            aVar.h0(z16);
            FeedCloudMeta$StBarrage z17 = z(this.f304406n);
            if (z17 == null) {
                str = "";
            } else {
                str = z17.f398446id.get();
            }
            com.tencent.rfw.barrage.data.a aVar2 = this.f304406n;
            if (z17 == null) {
                j3 = 0;
            } else {
                j3 = z17.feedPlayTime.get();
            }
            aVar2.A0(j3);
        }
        if (z16) {
            str2 = str;
        }
        j70.a.c(str2);
    }

    public void m0(String str, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        sx2.c b16;
        tx2.a aVar = this.f304397e;
        if (aVar != null) {
            aVar.l(str, feedCloudMeta$StBarrage);
        }
        sx2.d dVar = this.f304402j;
        if (dVar == null) {
            b16 = null;
        } else {
            b16 = dVar.b();
        }
        if (b16 != null) {
            b16.L(str, feedCloudMeta$StBarrage);
        }
    }

    public synchronized void o(List<FeedCloudMeta$StBarrage> list) {
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[appendDataToLastSource(List<StBarrage> barrages)] barrage data factory should not be null."));
        } else {
            aVar.m(list, new k70.a() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.c
                @Override // k70.a
                public final void a(List list2) {
                    k.this.I(list2);
                }
            });
        }
    }

    public void o0(long j3, long j16) {
        if (!this.f304394b.get()) {
            return;
        }
        this.f304396d = j3;
    }

    public synchronized void p(List<FeedCloudMeta$StBarrage> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        r(feedCloudMeta$StFeed);
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[appendDataToLastSource(List<StBarrage> barrages, StFeed feed)] barrage data factory should not be null."));
            return;
        }
        List<FeedCloudMeta$StBarrage> a16 = aVar.a(list);
        if (RFSafeListUtils.isEmpty(a16)) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[appendDataToLastSource(List<StBarrage> barrages, StFeed feed)] current filter barrage list result is empty."));
        } else {
            this.f304397e.m(a16, new k70.a() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.d
                @Override // k70.a
                public final void a(List list2) {
                    k.this.H(list2);
                }
            });
        }
    }

    public void p0(boolean z16) {
        if (this.f304395c.get() == z16) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[updateScreenConfig] current vertical equality, flow end."));
            return;
        }
        if (this.f304405m == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[updateScreenConfig] window config should not be null."));
        } else {
            Y();
        }
        if (this.f304393a == null) {
            QLog.e("QDM-TVideoBarrageManager", 1, n("[updateScreenConfig] barrage manager should not be null."));
        } else {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[updateScreenConfig] isVertical: " + z16));
            this.f304393a.b0();
        }
        this.f304395c.set(z16);
    }

    public void q(final List<FeedCloudMeta$StBarrage> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        r(feedCloudMeta$StFeed);
        tx2.a aVar = this.f304397e;
        if (aVar == null) {
            QLog.d("QDM-TVideoBarrageManager", 1, n("[appendFakeDataToSource] barrage data factory should not be null."));
        } else {
            aVar.b(list, new k70.a() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.b
                @Override // k70.a
                public final void a(List list2) {
                    k.this.J(list, list2);
                }
            });
        }
    }

    public void s() {
        sx2.c b16;
        sx2.d dVar = this.f304402j;
        if (dVar == null || (b16 = dVar.b()) == null) {
            return;
        }
        b16.c();
    }

    public void t() {
        sx2.c b16;
        sx2.d dVar = this.f304402j;
        if (dVar == null || (b16 = dVar.b()) == null) {
            return;
        }
        b16.o();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class b implements sz3.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<k> f304408a;

        public b(k kVar) {
            this.f304408a = new WeakReference<>(kVar);
        }

        @Override // sz3.a
        public void d(com.tencent.rfw.barrage.data.a aVar, vz3.h hVar, vz3.e eVar) {
            k kVar;
            WeakReference<k> weakReference = this.f304408a;
            if (weakReference == null) {
                kVar = null;
            } else {
                kVar = weakReference.get();
            }
            if (kVar != null) {
                kVar.C(aVar, hVar, eVar);
            }
        }

        @Override // sz3.a
        public void a() {
        }

        @Override // sz3.a
        public void b(boolean z16) {
        }

        @Override // sz3.a
        public void c(List<com.tencent.rfw.barrage.data.a> list) {
        }
    }
}
