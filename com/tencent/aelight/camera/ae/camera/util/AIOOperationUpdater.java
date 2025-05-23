package com.tencent.aelight.camera.ae.camera.util;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AIOOperationUpdater {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<OPERATION_ENUM> f63444a;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<OPERATION_ENUM, k> f63446c;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<OPERATION_ENUM, i> f63445b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<OPERATION_ENUM, j> f63447d = new HashMap<>();

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

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.i
        public boolean a() {
            if (AIOOperationUpdater.this.f63444a != null) {
                CopyOnWriteArrayList copyOnWriteArrayList = AIOOperationUpdater.this.f63444a;
                OPERATION_ENUM operation_enum = OPERATION_ENUM.MATERIAL_OPERATION;
                if (copyOnWriteArrayList.contains(operation_enum) && AIOOperationUpdater.this.f63444a.indexOf(operation_enum) != 0) {
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

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.h
        public boolean c(AEFilterProcessTex aEFilterProcessTex, k kVar) {
            aEFilterProcessTex.b0(kVar.f63458a, kVar.f63459b, kVar.f63460c);
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

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.h
        public boolean c(AEFilterProcessTex aEFilterProcessTex, k kVar) {
            aEFilterProcessTex.c0(kVar.f63458a, kVar.f63459b);
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

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.h
        public boolean c(AEFilterProcessTex aEFilterProcessTex, k kVar) {
            aEFilterProcessTex.d0(kVar.f63458a, kVar.f63459b);
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

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.h
        public boolean c(AEFilterProcessTex aEFilterProcessTex, k kVar) {
            aEFilterProcessTex.V0(kVar.f63458a);
            aEFilterProcessTex.U0(kVar.f63461d);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements i {

        /* renamed from: a, reason: collision with root package name */
        private OPERATION_ENUM f63454a;

        public g(OPERATION_ENUM operation_enum) {
            this.f63454a = operation_enum;
        }

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.i
        public boolean a() {
            if (AIOOperationUpdater.this.f63444a == null || !AIOOperationUpdater.this.f63444a.contains(this.f63454a)) {
                return true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = AIOOperationUpdater.this.f63444a;
            OPERATION_ENUM operation_enum = OPERATION_ENUM.MATERIAL_OPERATION;
            if (copyOnWriteArrayList.contains(operation_enum)) {
                return AIOOperationUpdater.this.f63444a.indexOf(operation_enum) > AIOOperationUpdater.this.f63444a.indexOf(this.f63454a);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private abstract class h implements j {

        /* renamed from: a, reason: collision with root package name */
        private OPERATION_ENUM f63456a;

        public h(OPERATION_ENUM operation_enum) {
            this.f63456a = operation_enum;
        }

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.j
        public boolean a(AEFilterProcessTex aEFilterProcessTex) {
            k b16 = b();
            if (aEFilterProcessTex == null || b16 == null) {
                return false;
            }
            return c(aEFilterProcessTex, b16);
        }

        public k b() {
            if (AIOOperationUpdater.this.f63446c != null) {
                return (k) AIOOperationUpdater.this.f63446c.get(this.f63456a);
            }
            return null;
        }

        public abstract boolean c(AEFilterProcessTex aEFilterProcessTex, k kVar);
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
        boolean a(AEFilterProcessTex aEFilterProcessTex);
    }

    public AIOOperationUpdater() {
        e();
        f();
    }

    private void c() {
        if (this.f63444a == null) {
            this.f63444a = new CopyOnWriteArrayList<>();
        }
    }

    private void e() {
        HashMap<OPERATION_ENUM, i> hashMap = this.f63445b;
        OPERATION_ENUM operation_enum = OPERATION_ENUM.LIPS_OPERATION;
        hashMap.put(operation_enum, new g(operation_enum));
        HashMap<OPERATION_ENUM, i> hashMap2 = this.f63445b;
        OPERATION_ENUM operation_enum2 = OPERATION_ENUM.SOFT_OPERATION;
        hashMap2.put(operation_enum2, new g(operation_enum2));
        HashMap<OPERATION_ENUM, i> hashMap3 = this.f63445b;
        OPERATION_ENUM operation_enum3 = OPERATION_ENUM.MULTIPLY_OPERATION;
        hashMap3.put(operation_enum3, new g(operation_enum3));
        HashMap<OPERATION_ENUM, i> hashMap4 = this.f63445b;
        OPERATION_ENUM operation_enum4 = OPERATION_ENUM.FILTER_LUT;
        hashMap4.put(operation_enum4, new g(operation_enum4));
        this.f63445b.put(OPERATION_ENUM.MATERIAL_OPERATION, new a());
    }

    private void f() {
        HashMap<OPERATION_ENUM, j> hashMap = this.f63447d;
        OPERATION_ENUM operation_enum = OPERATION_ENUM.LIPS_OPERATION;
        hashMap.put(operation_enum, new b(operation_enum));
        HashMap<OPERATION_ENUM, j> hashMap2 = this.f63447d;
        OPERATION_ENUM operation_enum2 = OPERATION_ENUM.MULTIPLY_OPERATION;
        hashMap2.put(operation_enum2, new c(operation_enum2));
        HashMap<OPERATION_ENUM, j> hashMap3 = this.f63447d;
        OPERATION_ENUM operation_enum3 = OPERATION_ENUM.SOFT_OPERATION;
        hashMap3.put(operation_enum3, new d(operation_enum3));
        HashMap<OPERATION_ENUM, j> hashMap4 = this.f63447d;
        OPERATION_ENUM operation_enum4 = OPERATION_ENUM.FILTER_LUT;
        hashMap4.put(operation_enum4, new e(operation_enum4));
        this.f63447d.put(OPERATION_ENUM.MATERIAL_OPERATION, new f());
    }

    public boolean g() {
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList = this.f63444a;
        return copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0;
    }

    public boolean h(OPERATION_ENUM operation_enum) {
        i iVar;
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList = this.f63444a;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.contains(operation_enum) || (iVar = this.f63445b.get(operation_enum)) == null) {
            return true;
        }
        return iVar.a();
    }

    public void i(OPERATION_ENUM operation_enum) {
        c();
        if (this.f63444a.contains(operation_enum)) {
            this.f63444a.remove(operation_enum);
        }
        this.f63444a.add(operation_enum);
    }

    public void j(String str, float f16) {
        c();
        OPERATION_ENUM operation_enum = OPERATION_ENUM.FILTER_LUT;
        i(operation_enum);
        l(operation_enum, new k(str, f16, 0));
    }

    public void k(OPERATION_ENUM operation_enum) {
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList = this.f63444a;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.contains(operation_enum)) {
            return;
        }
        ms.a.f("AIOOperationUpdater", "recovered-\uff1a" + operation_enum);
        this.f63444a.remove(operation_enum);
    }

    public void l(OPERATION_ENUM operation_enum, k kVar) {
        if (this.f63446c == null) {
            this.f63446c = new HashMap<>();
        }
        this.f63446c.put(operation_enum, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements j {
        f() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.j
        public boolean a(AEFilterProcessTex aEFilterProcessTex) {
            if (aEFilterProcessTex == null) {
                return false;
            }
            aEFilterProcessTex.k0();
            return true;
        }
    }

    public void d(AEFilterProcessTex aEFilterProcessTex) {
        CopyOnWriteArrayList<OPERATION_ENUM> copyOnWriteArrayList;
        if (aEFilterProcessTex == null || (copyOnWriteArrayList = this.f63444a) == null || copyOnWriteArrayList.size() == 0) {
            return;
        }
        Iterator<OPERATION_ENUM> it = this.f63444a.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            OPERATION_ENUM next = it.next();
            if (h(next)) {
                j jVar = this.f63447d.get(next);
                if (jVar == null || !jVar.a(aEFilterProcessTex)) {
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
        public String f63458a;

        /* renamed from: b, reason: collision with root package name */
        public int f63459b;

        /* renamed from: c, reason: collision with root package name */
        public int f63460c;

        /* renamed from: d, reason: collision with root package name */
        private float f63461d;

        public k(String str, int i3, int i16) {
            this.f63458a = str;
            this.f63459b = i3;
            this.f63460c = i16;
        }

        public k(String str, float f16, int i3) {
            this.f63458a = str;
            this.f63461d = f16;
            this.f63460c = i3;
        }
    }
}
