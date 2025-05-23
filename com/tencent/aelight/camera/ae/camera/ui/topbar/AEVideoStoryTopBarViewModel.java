package com.tencent.aelight.camera.ae.camera.ui.topbar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEVideoStoryTopBarViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Boolean> f63373i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    public final MutableLiveData<Ratio> f63374m = new MutableLiveData<>();
    private MutableLiveData<a> C = new MutableLiveData<>();
    private MutableLiveData<Boolean> D = new MutableLiveData<>();
    private MutableLiveData<Boolean> E = new MutableLiveData<>();
    private final MutableLiveData<Integer> F = new MutableLiveData<>();
    private MutableLiveData<Boolean> G = new MutableLiveData<>();
    private final MutableLiveData<Boolean> H = new MutableLiveData<>(Boolean.FALSE);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public enum Ratio {
        FULL(4) { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio.1
            @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio
            public Ratio next() {
                return Ratio.R_4_3;
            }
        },
        R_1_1(11) { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio.2
            @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio
            public Ratio next() {
                return Ratio.R_4_3;
            }
        },
        R_4_3(43) { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio.3
            @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio
            public Ratio next() {
                return Ratio.R_16_9;
            }
        },
        R_16_9(169) { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio.4
            @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio
            public Ratio next() {
                return Ratio.FULL;
            }
        };

        public final int code;

        Ratio(int i3) {
            this.code = i3;
        }

        public static Ratio fromCode(int i3) {
            for (Ratio ratio : values()) {
                if (ratio.code == i3) {
                    return ratio;
                }
            }
            return null;
        }

        public abstract Ratio next();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f63375a;

        /* renamed from: b, reason: collision with root package name */
        private int f63376b;

        public a(boolean z16, int i3) {
            this.f63375a = z16;
            this.f63376b = i3;
        }

        public int a() {
            return this.f63376b;
        }

        public boolean b() {
            return this.f63375a;
        }
    }

    public MutableLiveData<Boolean> L1() {
        return this.G;
    }

    public MutableLiveData<a> M1() {
        return this.C;
    }

    public MutableLiveData<Boolean> N1() {
        return this.D;
    }

    public MutableLiveData<Boolean> O1() {
        return this.f63373i;
    }

    public MutableLiveData<Boolean> P1() {
        return this.E;
    }

    public LiveData<Boolean> Q1() {
        return this.H;
    }

    public void R1(boolean z16) {
        if (this.H.getValue().booleanValue() == z16) {
            return;
        }
        this.H.postValue(Boolean.valueOf(z16));
    }

    public void S1(boolean z16) {
        this.F.postValue(Integer.valueOf(z16 ? 1 : 2));
    }
}
