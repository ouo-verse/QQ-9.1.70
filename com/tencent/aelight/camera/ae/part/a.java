package com.tencent.aelight.camera.ae.part;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<Boolean> f65650i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f65651m = new MutableLiveData<>();
    private MutableLiveData<Boolean> C = new MutableLiveData<>();
    private MutableLiveData<Boolean> D = new MutableLiveData<>();
    private MutableLiveData<Boolean> E = new MutableLiveData<>();
    private MutableLiveData<Boolean> F = new MutableLiveData<>();

    public MutableLiveData<Boolean> L1() {
        return this.C;
    }

    public MutableLiveData<Boolean> M1() {
        return this.f65650i;
    }

    public MutableLiveData<Boolean> N1() {
        return this.E;
    }

    public MutableLiveData<Boolean> O1() {
        return this.F;
    }

    public MutableLiveData<Boolean> P1() {
        return this.f65651m;
    }

    public MutableLiveData<Boolean> Q1() {
        return this.D;
    }

    public boolean R1() {
        if (this.C.getValue() != null) {
            return this.C.getValue().booleanValue();
        }
        return false;
    }

    public boolean S1() {
        if (this.f65651m.getValue() != null) {
            return this.f65651m.getValue().booleanValue();
        }
        return false;
    }
}
