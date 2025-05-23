package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<String> f92843i = new MutableLiveData<>();

    public MutableLiveData<String> L1() {
        return this.f92843i;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QCirclePersonalHomeMaterialGuideViewModel";
    }
}
