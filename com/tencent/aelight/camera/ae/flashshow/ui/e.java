package com.tencent.aelight.camera.ae.flashshow.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.ae.flashshow.ui.ay;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.filter.EffectType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MediatorLiveData<MetaMaterial> f64895i = new MediatorLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private MediatorLiveData<d> f64896m = new MediatorLiveData<>();
    private MutableLiveData<c> C = new MutableLiveData<>();
    private ay D = (ay) com.tencent.aelight.camera.ae.control.a.b(4);
    private AEFlashShowMaterialManager E = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3);
    private yq2.c F = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Observer<MetaMaterial> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(MetaMaterial metaMaterial) {
            e.this.f64896m.postValue(new d(metaMaterial));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f64898a;

        static {
            int[] iArr = new int[EffectType.values().length];
            f64898a = iArr;
            try {
                iArr[EffectType.AI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64898a[EffectType.NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64898a[EffectType.CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<MetaCategory> f64899a;

        /* renamed from: b, reason: collision with root package name */
        public List<MetaMaterial> f64900b;

        public c(ArrayList<MetaCategory> arrayList, List<MetaMaterial> list) {
            this.f64899a = arrayList;
            this.f64900b = list;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public int f64902a;

        /* renamed from: b, reason: collision with root package name */
        public int f64903b;

        /* renamed from: c, reason: collision with root package name */
        public MetaMaterial f64904c;

        public d(MetaMaterial metaMaterial) {
            int R1;
            this.f64902a = 0;
            this.f64903b = 0;
            this.f64904c = metaMaterial;
            try {
                try {
                    int parseInt = Integer.parseInt(com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "filter_sliding_value"));
                    this.f64903b = parseInt;
                    this.f64902a = parseInt;
                    R1 = e.this.R1(metaMaterial);
                    if (R1 <= -100) {
                        return;
                    }
                } catch (NumberFormatException unused) {
                    ms.a.c("AEFlashSHOWFilterViewModel", "\u6ee4\u955c\u9ed8\u8ba4\u503c\u89e3\u6790\u9519\u8bef");
                    R1 = e.this.R1(metaMaterial);
                    if (R1 <= -100) {
                        return;
                    }
                }
                this.f64902a = R1;
            } catch (Throwable th5) {
                int R12 = e.this.R1(metaMaterial);
                if (R12 > -100) {
                    this.f64902a = R12;
                }
                throw th5;
            }
        }
    }

    public e() {
        ay ayVar = this.D;
        if (ayVar != null) {
            ayVar.k(null);
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R1(MetaMaterial metaMaterial) {
        return com.tencent.mobileqq.wink.editor.filter.f.d(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1() {
        Z1(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(Object obj, int i3, Object[] objArr) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.W1();
            }
        });
        ms.a.a("AEFlashSHOWFilterViewModel", "RECEIVE DATA.");
    }

    private void init() {
        this.E.F(false);
        yq2.c cVar = new yq2.c() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.c
            @Override // yq2.c
            public final void notify(Object obj, int i3, Object[] objArr) {
                e.this.X1(obj, i3, objArr);
            }
        };
        this.F = cVar;
        this.E.p(cVar, 116);
        this.f64896m.addSource(this.f64895i, new a());
    }

    public void P1(MetaMaterial metaMaterial) {
        LSFilterProcessTex a16 = com.tencent.aelight.camera.ae.flashshow.filter.b.a();
        if (a16 == null || metaMaterial == null) {
            return;
        }
        String k3 = com.tencent.mobileqq.wink.editor.filter.f.k(metaMaterial);
        a16.A0(false);
        a16.Z0(k3);
    }

    public MutableLiveData<c> Q1() {
        return this.C;
    }

    public d S1(MetaMaterial metaMaterial) {
        return new d(metaMaterial);
    }

    public LiveData<d> T1() {
        return this.f64896m;
    }

    public LiveData<MetaMaterial> U1() {
        return this.f64895i;
    }

    public void Z1(Boolean bool) {
        AEMaterialCategory aEMaterialCategory;
        ArrayList<MetaCategory> arrayList;
        List<AEMaterialCategory> y16 = this.E.y();
        ms.a.f("AEFlashSHOWFilterViewModel", "### updateData: filter list size:" + y16.size() + " ,totalList = " + y16.toString());
        for (AEMaterialCategory aEMaterialCategory2 : y16) {
            ms.a.f("AEFlashSHOWFilterViewModel", "category id:" + aEMaterialCategory2.f69045e + " ,name = " + aEMaterialCategory2.f69047h);
        }
        if (y16.size() == 0 || (arrayList = (aEMaterialCategory = y16.get(0)).D) == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<MetaCategory> it = aEMaterialCategory.D.iterator();
        while (it.hasNext()) {
            MetaCategory next = it.next();
            ArrayList<MetaMaterial> arrayList3 = next.materials;
            if (arrayList3 != null) {
                Iterator<MetaMaterial> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next2 = it5.next();
                    com.tencent.mobileqq.wink.editor.c.o1(next2, next.f30532id);
                    com.tencent.mobileqq.wink.editor.c.p1(next2, next.name);
                    Map<String, String> map = next2.additionalFields;
                    if (map != null && map.get("filter_name") != null) {
                        com.tencent.mobileqq.wink.editor.c.B1(next2, next2.additionalFields.get("filter_name"));
                    } else {
                        com.tencent.mobileqq.wink.editor.c.B1(next2, "\u6ee4\u955c");
                    }
                    com.tencent.mobileqq.wink.editor.filter.f.C(next2, next2.f30533id);
                    if (bool.booleanValue()) {
                        com.tencent.mobileqq.wink.editor.filter.f.t(next2, com.tencent.mobileqq.wink.editor.filter.f.g(next2));
                    }
                }
                for (int i3 = 0; i3 < next.materials.size(); i3++) {
                    if (next.materials.get(i3) != null) {
                        int i16 = b.f64898a[com.tencent.mobileqq.wink.editor.filter.f.e(next.materials.get(i3)).ordinal()];
                        if (i16 == 1) {
                            com.tencent.mobileqq.wink.editor.c.n1(next.materials.get(i3), false);
                            com.tencent.mobileqq.wink.editor.c.G1(next.materials.get(i3), false);
                        } else if (i16 == 2) {
                            com.tencent.mobileqq.wink.editor.c.n1(next.materials.get(i3), false);
                            com.tencent.mobileqq.wink.editor.c.G1(next.materials.get(i3), false);
                        } else if (i16 == 3) {
                            com.tencent.mobileqq.wink.editor.c.n1(next.materials.get(i3), true);
                            com.tencent.mobileqq.wink.editor.c.G1(next.materials.get(i3), true);
                        }
                    }
                }
                arrayList2.addAll(next.materials);
            }
        }
        this.C.postValue(new c(aEMaterialCategory.D, arrayList2));
    }

    public void a2(int i3) {
        if (this.f64895i.getValue() != null) {
            com.tencent.mobileqq.wink.editor.filter.f.t(this.f64895i.getValue(), i3);
            this.D.j(this.f64895i.getValue().f30533id, new ay.FilterData(i3));
        }
    }

    public void b2(int i3, MetaMaterial metaMaterial) {
        this.f64895i.postValue(metaMaterial);
        this.D.k(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.D.k(null);
        this.f64896m.removeSource(this.f64895i);
        yq2.c cVar = this.F;
        if (cVar != null) {
            this.E.d0(cVar);
            this.F = null;
        }
    }
}
