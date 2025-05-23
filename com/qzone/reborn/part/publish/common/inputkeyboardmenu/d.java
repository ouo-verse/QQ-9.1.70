package com.qzone.reborn.part.publish.common.inputkeyboardmenu;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends BaseViewModel {

    /* renamed from: m, reason: collision with root package name */
    private static final String f58597m = "d";

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Integer> f58598i = new MutableLiveData<>(0);

    public MutableLiveData<Integer> L1() {
        return this.f58598i;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return f58597m;
    }
}
