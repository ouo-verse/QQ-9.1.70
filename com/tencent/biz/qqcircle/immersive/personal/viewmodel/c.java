package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends BaseViewModel {
    private Runnable C;
    private Runnable D;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.c> f89135i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final v f89136m = new v();

    public com.tencent.biz.qqcircle.immersive.personal.bean.c L1() {
        if (this.f89135i.getValue() == null) {
            return new com.tencent.biz.qqcircle.immersive.personal.bean.c();
        }
        return this.f89135i.getValue();
    }

    public MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.c> M1() {
        return this.f89135i;
    }

    public Runnable N1() {
        return this.D;
    }

    public Runnable O1() {
        return this.C;
    }

    public v P1() {
        return this.f89136m;
    }

    public void Q1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.personal.bean.c L1 = L1();
        if (L1.a() == z16) {
            return;
        }
        L1.b(z16);
        this.f89135i.setValue(L1);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSPersonalFollowViewModel";
    }
}
