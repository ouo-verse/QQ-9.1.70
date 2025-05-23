package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.bean.u;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<u> f89173i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final v f89174m = new v();

    public MutableLiveData<u> L1() {
        return this.f89173i;
    }

    public v M1() {
        return this.f89174m;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSPersonalUrgeViewModel";
    }
}
