package com.tencent.mobileqq.nearbypro.map.poi;

import androidx.lifecycle.MutableLiveData;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f extends com.tencent.biz.subscribe.part.a {

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f253589m = new MutableLiveData<>(Boolean.FALSE);

    public MutableLiveData<Boolean> L1() {
        return this.f253589m;
    }

    public void M1(boolean z16) {
        this.f253589m.setValue(Boolean.valueOf(z16));
    }
}
