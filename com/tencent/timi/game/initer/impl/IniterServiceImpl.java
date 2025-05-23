package com.tencent.timi.game.initer.impl;

import ag4.h;
import ag4.i;
import android.content.Context;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import fm4.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class IniterServiceImpl implements hi4.b {

    /* renamed from: f, reason: collision with root package name */
    private f f377184f;

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f377179a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f377180b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final Object f377181c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private List<hi4.a> f377182d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f377183e = false;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f377185g = new Runnable() { // from class: com.tencent.timi.game.initer.impl.IniterServiceImpl.1
        @Override // java.lang.Runnable
        public void run() {
            boolean N3 = IniterServiceImpl.N3();
            l.e("IniterServiceImpl", "checkTimiGameRes#run -- needReleaseTg= " + N3);
            if (N3) {
                IniterServiceImpl.this.w();
            }
        }
    };

    static /* bridge */ /* synthetic */ boolean N3() {
        return P3();
    }

    private void O3(hi4.a aVar) {
        Q3(aVar);
    }

    private static boolean P3() {
        boolean m3 = com.tencent.timi.game.room.impl.d.g().m();
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        l.i("IniterServiceImpl", "checkTimiGameRes#checkCouldReleaseTg, - hasRoomList= " + m3 + ", expandHall= " + I0);
        if (!m3 && I0 == null) {
            return true;
        }
        return false;
    }

    @Override // hi4.b
    public void P0(hi4.c cVar) {
        LibraryInitManager.f377186a.h(cVar);
    }

    @Override // hi4.b
    public void Q1(hi4.c cVar) {
        LibraryInitManager.f377186a.i(cVar);
    }

    public void Q3(hi4.a aVar) {
        ArrayList arrayList;
        boolean z16;
        if (this.f377179a.get()) {
            if (aVar != null) {
                aVar.a(true);
            }
            l.h("IniterServiceImpl", 1, "syncEnsureInit already init!");
            return;
        }
        if (this.f377180b.get()) {
            l.h("IniterServiceImpl", 1, "syncEnsureInit already call, initCallback:" + aVar);
            if (aVar == null) {
                return;
            }
            synchronized (this.f377181c) {
                if (this.f377179a.get()) {
                    z16 = true;
                } else {
                    this.f377182d.add(aVar);
                    z16 = false;
                }
            }
            if (z16) {
                aVar.a(true);
            }
            l.h("IniterServiceImpl", 1, "syncEnsureInit already call, alreadyInit:" + z16);
            return;
        }
        this.f377180b.set(true);
        long currentTimeMillis = System.currentTimeMillis();
        l.h("IniterServiceImpl", 1, "syncEnsureInit START");
        eh4.a.a(BaseApplication.getContext());
        a.a();
        LibraryInitManager.f377186a.c();
        com.tencent.timi.game.smoba.impl.config.b.b();
        this.f377184f = new f();
        if (GuardManager.sInstance != null) {
            l.i("IniterServiceImpl", "GuardManager.sInstance.registerCallBack success");
            GuardManager.sInstance.registerCallBack(this.f377184f);
        } else {
            l.i("IniterServiceImpl", "GuardManager.sInstance.registerCallBack error");
        }
        mm4.b.c(BaseApplication.getContext());
        if (vf4.a.d()) {
            TGPAUtil.c(eh4.a.b());
        }
        ((h) mm4.b.b(h.class)).w1(null);
        ((i) mm4.b.b(i.class)).A0(101);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HashMap hashMap = new HashMap();
        hashMap.put("k_cost_time", currentTimeMillis2 + "");
        hashMap.put("k_process_name", MobileQQ.processName + "");
        ((ug4.b) mm4.b.b(ug4.b.class)).e("e_timi_game_init_result", hashMap);
        wg4.a.f445636a.b();
        l.h("IniterServiceImpl", 1, "syncEnsureInit END, curSvrName = " + ServerEnv.b() + " " + currentTimeMillis2 + "ms, process:" + MobileQQ.processName);
        synchronized (this.f377181c) {
            this.f377179a.set(true);
            arrayList = new ArrayList(this.f377182d);
            this.f377182d.clear();
        }
        if (aVar != null) {
            aVar.a(true);
        }
        l.h("IniterServiceImpl", 1, "syncEnsureInit notify hold cb:" + arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((hi4.a) it.next()).a(true);
        }
    }

    @Override // hi4.b
    public void c0(int i3) {
        boolean z16 = this.f377183e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doWhenLaunchYesScenes - ");
        sb5.append(i3);
        sb5.append(", isFirstLaunch = ");
        sb5.append(!z16);
        l.i("IniterServiceImpl", sb5.toString());
        this.f377183e = true;
        if (!z16) {
            l.i("IniterServiceImpl", "first launch scene, refreshRoomRouteAndResume");
            ((g) mm4.b.b(g.class)).U1();
        }
    }

    @Override // hi4.b
    public void d3(hi4.a aVar) {
        O3(aVar);
    }

    @Override // hi4.b
    public boolean t() {
        return LibraryInitManager.f377186a.c();
    }

    @Override // hi4.b
    public void w() {
        l.e("IniterServiceImpl", "destroyTg");
        this.f377183e = false;
        this.f377179a.set(false);
        this.f377180b.set(false);
        ((bo4.d) mm4.b.b(bo4.d.class)).j();
        ((g) mm4.b.b(g.class)).onLogout();
        ((kn4.b) mm4.b.b(kn4.b.class)).logout();
        ((h) mm4.b.b(h.class)).j();
        mm4.b.a();
        YesDataBaseHelper.b();
        if (GuardManager.sInstance != null) {
            l.i("IniterServiceImpl", "GuardManager.sInstance.unregisterCallback success");
            GuardManager.sInstance.unregisterCallback(this.f377184f);
        } else {
            l.i("IniterServiceImpl", "GuardManager.sInstance.unregisterCallback error");
        }
        if (com.tencent.timi.game.smoba.impl.config.b.b() != null) {
            com.tencent.timi.game.smoba.impl.config.b.b().a();
        }
    }

    @Override // hi4.b
    public void x1(String str) {
        String str2;
        boolean P3 = P3();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkTimiGameRes, ");
        sb5.append(str);
        sb5.append(" - ");
        sb5.append(P3);
        if (P3) {
            str2 = ", postRunnable";
        } else {
            str2 = "";
        }
        sb5.append(str2);
        l.i("IniterServiceImpl", sb5.toString());
        if (P3) {
            w.e(this.f377185g);
            w.d(this.f377185g, 5000L);
        }
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
