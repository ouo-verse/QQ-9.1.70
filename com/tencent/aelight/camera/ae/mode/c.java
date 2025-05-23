package com.tencent.aelight.camera.ae.mode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends ViewModel {
    private boolean D;

    /* renamed from: i, reason: collision with root package name */
    public final MutableLiveData<AECaptureModeChangingEvent> f65622i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    public final MutableLiveData<AECaptureMode[]> f65623m = new MutableLiveData<>();
    public final MutableLiveData<Boolean> C = new MutableLiveData<>();

    public boolean L1() {
        return this.f65622i.getValue() != null && this.f65622i.getValue().f65599b == AECaptureMode.ARCAKE;
    }

    public boolean M1() {
        return this.D;
    }

    public boolean N1() {
        return this.f65622i.getValue() != null && this.f65622i.getValue().f65599b == AECaptureMode.GIF;
    }

    public boolean O1() {
        return this.f65622i.getValue() != null && this.f65622i.getValue().f65599b == AECaptureMode.NORMAL;
    }

    public boolean P1() {
        return this.f65622i.getValue() != null && this.f65622i.getValue().f65599b == AECaptureMode.PLAY;
    }
}
