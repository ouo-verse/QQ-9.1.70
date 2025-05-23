package com.tencent.biz.map.poi;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<Boolean> f78770i = new MutableLiveData<>(Boolean.FALSE);

    public MutableLiveData<Boolean> L1() {
        return this.f78770i;
    }

    public void M1(boolean z16) {
        this.f78770i.setValue(Boolean.valueOf(z16));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "TitleViewModel";
    }
}
