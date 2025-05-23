package com.tencent.icgame.game.initer.impl;

import android.content.Context;
import com.tencent.icgame.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IniterServiceImpl implements ev0.b {

    /* renamed from: f, reason: collision with root package name */
    private f f115062f;

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f115057a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f115058b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final Object f115059c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private List<ev0.a> f115060d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f115061e = false;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f115063g = new Runnable() { // from class: com.tencent.icgame.game.initer.impl.IniterServiceImpl.1
        @Override // java.lang.Runnable
        public void run() {
            boolean N3 = IniterServiceImpl.N3();
            g.d("ICGameIniterServiceImpl", "checkTimiGameRes#run -- needReleaseTg= " + N3);
            if (N3) {
                IniterServiceImpl.this.w();
            }
        }
    };

    static /* bridge */ /* synthetic */ boolean N3() {
        return P3();
    }

    private void O3(ev0.a aVar) {
        Q3(aVar);
    }

    private static boolean P3() {
        return true;
    }

    @Override // ev0.b
    public void A2(ev0.c cVar) {
        LibraryInitManager.f115064a.i(cVar);
    }

    public void Q3(ev0.a aVar) {
        ArrayList arrayList;
        boolean z16;
        if (this.f115057a.get()) {
            if (aVar != null) {
                aVar.a(true);
            }
            g.g("ICGameIniterServiceImpl", 1, "syncEnsureInit already init!");
            return;
        }
        if (this.f115058b.get()) {
            g.g("ICGameIniterServiceImpl", 1, "syncEnsureInit already call, initCallback:" + aVar);
            if (aVar == null) {
                return;
            }
            synchronized (this.f115059c) {
                if (this.f115057a.get()) {
                    z16 = true;
                } else {
                    this.f115060d.add(aVar);
                    z16 = false;
                }
            }
            if (z16) {
                aVar.a(true);
            }
            g.g("ICGameIniterServiceImpl", 1, "syncEnsureInit already call, alreadyInit:" + z16);
            return;
        }
        this.f115058b.set(true);
        long currentTimeMillis = System.currentTimeMillis();
        g.g("ICGameIniterServiceImpl", 1, "syncEnsureInit START");
        tu0.a.a(BaseApplication.getContext());
        a.a();
        LibraryInitManager.f115064a.c();
        this.f115062f = new f();
        if (GuardManager.sInstance != null) {
            g.h("ICGameIniterServiceImpl", "GuardManager.sInstance.registerCallBack success");
            GuardManager.sInstance.registerCallBack(this.f115062f);
        } else {
            g.h("ICGameIniterServiceImpl", "GuardManager.sInstance.registerCallBack error");
        }
        qx0.a.c(BaseApplication.getContext());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HashMap hashMap = new HashMap();
        hashMap.put("k_cost_time", currentTimeMillis2 + "");
        hashMap.put("k_process_name", MobileQQ.processName + "");
        ((ru0.b) qx0.a.b(ru0.b.class)).e("e_timi_game_init_result", hashMap);
        g.g("ICGameIniterServiceImpl", 1, "syncEnsureInit END, curSvrName = " + ServerEnv.b() + " " + currentTimeMillis2 + "ms, process:" + MobileQQ.processName);
        synchronized (this.f115059c) {
            this.f115057a.set(true);
            arrayList = new ArrayList(this.f115060d);
            this.f115060d.clear();
        }
        if (aVar != null) {
            aVar.a(true);
        }
        g.g("ICGameIniterServiceImpl", 1, "syncEnsureInit notify hold cb:" + arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ev0.a) it.next()).a(true);
        }
    }

    @Override // ev0.b
    public void l3(ev0.c cVar) {
        LibraryInitManager.f115064a.h(cVar);
    }

    @Override // ev0.b
    public boolean t() {
        return LibraryInitManager.f115064a.c();
    }

    @Override // ev0.b
    public void v3(ev0.a aVar) {
        O3(aVar);
    }

    @Override // ev0.b
    public void w() {
        g.d("ICGameIniterServiceImpl", "destroyTg");
        this.f115061e = false;
        this.f115057a.set(false);
        this.f115058b.set(false);
        ((ey0.d) qx0.a.b(ey0.d.class)).j();
        ((sx0.b) qx0.a.b(sx0.b.class)).logout();
        qx0.a.a();
        YesDataBaseHelper.b();
        if (GuardManager.sInstance != null) {
            g.h("ICGameIniterServiceImpl", "GuardManager.sInstance.unregisterCallback success");
            GuardManager.sInstance.unregisterCallback(this.f115062f);
        } else {
            g.h("ICGameIniterServiceImpl", "GuardManager.sInstance.unregisterCallback error");
        }
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
