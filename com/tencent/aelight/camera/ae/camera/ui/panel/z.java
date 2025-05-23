package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.ttpic.facedetect.GenderType;

/* compiled from: P */
/* loaded from: classes32.dex */
public class z extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Integer> f63239i = new MutableLiveData<>(Integer.valueOf(GenderType.DEFAULT.value));

    public MutableLiveData<Integer> L1() {
        return this.f63239i;
    }
}
