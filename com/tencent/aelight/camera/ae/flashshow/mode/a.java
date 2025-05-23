package com.tencent.aelight.camera.ae.flashshow.mode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    public final MutableLiveData<LSCaptureModeChangingEvent> f64352i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    public final MutableLiveData<LSCaptureMode[]> f64353m = new MutableLiveData<>();
    public final MutableLiveData<Boolean> C = new MutableLiveData<>();

    public boolean L1() {
        return this.f64352i.getValue() != null && this.f64352i.getValue().f64350b == LSCaptureMode.PLAY;
    }
}
