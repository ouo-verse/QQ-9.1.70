package com.tencent.aelight.camera.ae.flashshow.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSOperationUpdater {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<OPERATION_ENUM> f64311a;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<OPERATION_ENUM, k> f64313c;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<OPERATION_ENUM, i> f64312b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<OPERATION_ENUM, j> f64314d = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public enum OPERATION_ENUM {
        LIPS_OPERATION,
        MULTIPLY_OPERATION,
        SOFT_OPERATION,
        MATERIAL_OPERATION,
        FILTER_LUT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements i {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.i
        public boolean a() {
            if (LSOperationUpdater.this.f64311a != null) {
                CopyOnWriteArrayList copyOnWriteArrayList = LSOperationUpdater.this.f64311a;
                OPERATION_ENUM operation_enum = OPERATION_ENUM.MATERIAL_OPERATION;
                if (copyOnWriteArrayList.contains(operation_enum) && LSOperationUpdater.this.f64311a.indexOf(operation_enum) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends h {
        b(OPERATION_ENUM operation_enum) {
            super(operation_enum);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.h
        public boolean c(LSFilterProcessTex lSFilterProcessTex, k kVar) {
            lSFilterProcessTex.c0(kVar.f64325a, kVar.f64326b, kVar.f64327c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends h {
        c(OPERATION_ENUM operation_enum) {
            super(operation_enum);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.h
        public boolean c(LSFilterProcessTex lSFilterProcessTex, k kVar) {
            lSFilterProcessTex.d0(kVar.f64325a, kVar.f64326b);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends h {
        d(OPERATION_ENUM operation_enum) {
            super(operation_enum);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.h
        public boolean c(LSFilterProcessTex lSFilterProcessTex, k kVar) {
            lSFilterProcessTex.e0(kVar.f64325a, kVar.f64326b);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends h {
        e(OPERATION_ENUM operation_enum) {
            super(operation_enum);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.h
        public boolean c(LSFilterProcessTex lSFilterProcessTex, k kVar) {
            lSFilterProcessTex.Z0(kVar.f64325a);
            lSFilterProcessTex.Y0(kVar.f64328d);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements i {

        /* renamed from: a, reason: collision with root package name */
        private OPERATION_ENUM f64321a;

        public g(OPERATION_ENUM operation_enum) {
            this.f64321a = operation_enum;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.i
        public boolean a() {
            if (LSOperationUpdater.this.f64311a == null || !LSOperationUpdater.this.f64311a.contains(this.f64321a)) {
                return true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = LSOperationUpdater.this.f64311a;
            OPERATION_ENUM operation_enum = OPERATION_ENUM.MATERIAL_OPERATION;
            if (copyOnWriteArrayList.contains(operation_enum)) {
                return LSOperationUpdater.this.f64311a.indexOf(operation_enum) > LSOperationUpdater.this.f64311a.indexOf(this.f64321a);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private abstract class h implements j {

        /* renamed from: a, reason: collision with root package name */
        private OPERATION_ENUM f64323a;

        public h(OPERATION_ENUM operation_enum) {
            this.f64323a = operation_enum;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.j
        public boolean a(LSFilterProcessTex lSFilterProcessTex) {
            k b16 = b();
            if (lSFilterProcessTex == null || b16 == null) {
                return false;
            }
            return c(lSFilterProcessTex, b16);
        }

        public k b() {
            if (LSOperationUpdater.this.f64313c != null) {
                return (k) LSOperationUpdater.this.f64313c.get(this.f64323a);
            }
            return null;
        }

        public abstract boolean c(LSFilterProcessTex lSFilterProcessTex, k kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface i {
        boolean a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface j {
        boolean a(LSFilterProcessTex lSFilterProcessTex);
    }

    public LSOperationUpdater() {
        e();
        f();
    }

    private void c() {
        if (this.f64311a == null) {
            this.f64311a = new CopyOnWriteArrayList<>();
        }
    }

    private void e() {
        HashMap<OPERATION_ENUM, i> hashMap = this.f64312b;
        OPERATION_ENUM operation_enum = OPERATION_ENUM.LIPS_OPERATION;
        hashMap.put(operation_enum, new g(operation_enum));
        HashMap<OPERATION_ENUM, i> hashMap2 = this.f64312b;
        OPERATION_ENUM operation_enum2 = OPERATION_ENUM.SOFT_OPERATION;
        hashMap2.put(operation_enum2, new g(operation_enum2));
        HashMap<OPERATION_ENUM, i> hashMap3 = this.f64312b;
        OPERATION_ENUM operation_enum3 = OPERATION_ENUM.MULTIPLY_OPERATION;
        hashMap3.put(operation_enum3, new g(operation_enum3));
        HashMap<OPERATION_ENUM, i> hashMap4 = this.f64312b;
        OPERATION_ENUM operation_enum4 = OPERATION_ENUM.FILTER_LUT;
        hashMap4.put(operation_enum4, new g(operation_enum4));
        this.f64312b.put(OPERATION_ENUM.MATERIAL_OPERATION, new a());
    }

    private void f() {
        HashMap<OPERATION_ENUM, j> hashMap = this.f64314d;
        OPERATION_ENUM operation_enum = OPERATION_ENUM.LIPS_OPERATION;
        hashMap.put(operation_enum, new b(operation_enum));
        HashMap<OPERATION_ENUM, j> hashMap2 = this.f64314d;
        OPERATION_ENUM operation_enum2 = OPERATION_ENUM.MULTIPLY_OPERATION;
        hashMap2.put(operation_enum2, new c(operation_enum2));
        HashMap<OPERATION_ENUM, j> hashMap3 = this.f64314d;
        OPERATION_ENUM operation_enum3 = OPERATION_ENUM.SOFT_OPERATION;
        hashMap3.put(operation_enum3, new d(operation_enum3));
        HashMap<OPERATION_ENUM, j> hashMap4 = this.f64314d;
        OPERATION_ENUM operation_enum4 = OPERATION_ENUM.FILTER_LUT;
        hashMap4.put(operation_enum4, new e(operation_enum4));
        this.f64314d.put(OPERATION_ENUM.MATERIAL_OPERATION, new f());
    }

    public boolean g() {
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList = this.f64311a;
        return copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0;
    }

    public boolean h(OPERATION_ENUM operation_enum) {
        i iVar;
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList = this.f64311a;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.contains(operation_enum) || (iVar = this.f64312b.get(operation_enum)) == null) {
            return true;
        }
        return iVar.a();
    }

    public void i(OPERATION_ENUM operation_enum) {
        c();
        if (this.f64311a.contains(operation_enum)) {
            this.f64311a.remove(operation_enum);
        }
        this.f64311a.add(operation_enum);
    }

    public void j(String str, float f16) {
        c();
        OPERATION_ENUM operation_enum = OPERATION_ENUM.FILTER_LUT;
        i(operation_enum);
        l(operation_enum, new k(str, f16, 0));
    }

    public void k(OPERATION_ENUM operation_enum) {
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList = this.f64311a;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.contains(operation_enum)) {
            return;
        }
        ms.a.f("LSOperationUpdater", "recovered-\uff1a" + operation_enum);
        this.f64311a.remove(operation_enum);
    }

    public void l(OPERATION_ENUM operation_enum, k kVar) {
        if (this.f64313c == null) {
            this.f64313c = new HashMap<>();
        }
        this.f64313c.put(operation_enum, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements j {
        f() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater.j
        public boolean a(LSFilterProcessTex lSFilterProcessTex) {
            if (lSFilterProcessTex == null) {
                return false;
            }
            lSFilterProcessTex.m0();
            return true;
        }
    }

    public void d(LSFilterProcessTex lSFilterProcessTex) {
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList;
        if (lSFilterProcessTex == null || (copyOnWriteArrayList = this.f64311a) == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        Iterator<OPERATION_ENUM> it = this.f64311a.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            OPERATION_ENUM next = it.next();
            if (h(next)) {
                j jVar = this.f64314d.get(next);
                if (jVar == null || !jVar.a(lSFilterProcessTex)) {
                    break;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
        }
        if (arrayList != null) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                k((OPERATION_ENUM) it5.next());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public String f64325a;

        /* renamed from: b, reason: collision with root package name */
        public int f64326b;

        /* renamed from: c, reason: collision with root package name */
        public int f64327c;

        /* renamed from: d, reason: collision with root package name */
        private float f64328d;

        public k(String str, int i3, int i16) {
            this.f64325a = str;
            this.f64326b = i3;
            this.f64327c = i16;
        }

        public k(String str, float f16, int i3) {
            this.f64325a = str;
            this.f64328d = f16;
            this.f64327c = i3;
        }
    }
}
