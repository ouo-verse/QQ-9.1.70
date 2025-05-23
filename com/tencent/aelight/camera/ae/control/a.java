package com.tencent.aelight.camera.ae.control;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.ay;
import com.tencent.aelight.camera.ae.play.AEPlayShowMaterialManager;
import hd0.c;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f63491a = new b[5];

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Integer, Object> f63492b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0549a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f63493a = new a();
    }

    a() {
    }

    public static b b(int i3) {
        return C0549a.f63493a.d(i3);
    }

    public static a c() {
        return C0549a.f63493a;
    }

    public b d(int i3) {
        Object obj;
        b[] bVarArr = this.f63491a;
        b bVar = bVarArr[i3];
        if (bVar != null) {
            return bVar;
        }
        synchronized (bVarArr) {
            if (!this.f63492b.containsKey(Integer.valueOf(i3))) {
                this.f63492b.put(Integer.valueOf(i3), new Object());
            }
            obj = this.f63492b.get(Integer.valueOf(i3));
        }
        synchronized (obj) {
            b bVar2 = this.f63491a[i3];
            if (bVar2 != null) {
                return bVar2;
            }
            if (i3 == 1) {
                bVar2 = new AEMaterialManager();
            } else if (i3 == 2) {
                bVar2 = new AEPlayShowMaterialManager();
            } else if (i3 == 3) {
                bVar2 = new AEFlashShowMaterialManager();
            } else if (i3 == 4) {
                bVar2 = new ay();
            }
            this.f63491a[i3] = bVar2;
            if (bVar2 != null) {
                bVar2.onInit();
                c.l("AEQIMManager", "onInit manager : %s", bVar2);
            }
            return bVar2;
        }
    }

    public void a() {
        Object obj;
        int i3 = 0;
        while (true) {
            b[] bVarArr = this.f63491a;
            if (i3 >= bVarArr.length) {
                return;
            }
            synchronized (bVarArr) {
                if (!this.f63492b.containsKey(Integer.valueOf(i3))) {
                    this.f63492b.put(Integer.valueOf(i3), new Object());
                }
                obj = this.f63492b.get(Integer.valueOf(i3));
            }
            synchronized (obj) {
                b bVar = this.f63491a[i3];
                if (bVar != null) {
                    c.l("AEQIMManager", "destroy manager : %s", bVar);
                    bVar.onDestroy();
                }
                this.f63491a[i3] = null;
            }
            i3++;
        }
    }
}
