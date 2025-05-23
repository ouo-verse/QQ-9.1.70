package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.lbs.LbsManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i implements e {

    /* renamed from: a, reason: collision with root package name */
    public final e[] f94044a = new e[27];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final i f94045a = new i();
    }

    i() {
    }

    private void a(int i3, e eVar) {
        this.f94044a[i3] = eVar;
    }

    public static e c(int i3) {
        try {
            return a.f94045a.e(i3);
        } catch (Throwable th5) {
            hd0.c.l("Q.qqstory.SuperManager", "getAppManager error!", th5);
            return null;
        }
    }

    public static i d() {
        return a.f94045a;
    }

    public void b() {
        synchronized (this.f94044a) {
            int i3 = 0;
            while (true) {
                e[] eVarArr = this.f94044a;
                if (i3 < eVarArr.length) {
                    e eVar = eVarArr[i3];
                    hd0.c.l("Q.qqstory.SuperManager", "destroy manager : %s", eVar);
                    if (eVar != null) {
                        eVar.onDestroy();
                    }
                    this.f94044a[i3] = null;
                    i3++;
                }
            }
        }
    }

    public e e(int i3) {
        e[] eVarArr = this.f94044a;
        e eVar = eVarArr[i3];
        if (eVar == null) {
            synchronized (eVarArr) {
                eVar = this.f94044a[i3];
                if (eVar != null) {
                    return eVar;
                }
                if (i3 != 0) {
                    if (i3 != 20) {
                        if (i3 != 26) {
                            if (i3 != 9) {
                                if (i3 == 10) {
                                    eVar = new h();
                                }
                            } else {
                                eVar = new LbsManager();
                            }
                        } else {
                            eVar = new TrimmableManager();
                        }
                    } else {
                        eVar = new d();
                    }
                } else {
                    eVar = this;
                }
                if (eVar != null) {
                    eVar.onInit();
                    hd0.c.l("Q.qqstory.SuperManager", "onInit manager : %s", eVar);
                }
                a(i3, eVar);
            }
        }
        return eVar;
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onDestroy() {
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onInit() {
    }
}
