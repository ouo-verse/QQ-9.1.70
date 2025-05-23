package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.BaseViewModel;

/* compiled from: P */
/* loaded from: classes21.dex */
public class p extends BaseViewModel {
    private final MutableLiveData<Boolean> C;
    private final MutableLiveData<String> D;
    private boolean E;

    /* renamed from: i, reason: collision with root package name */
    private final MediatorLiveData<Boolean> f324834i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f324835m;

    public p() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.TRUE);
        this.f324835m = mutableLiveData;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.f324834i = mediatorLiveData;
        this.C = new MutableLiveData<>(Boolean.FALSE);
        this.E = true;
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                p.this.R1((Boolean) obj);
            }
        });
        this.D = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(Boolean bool) {
        X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(e93.a aVar) {
        if (aVar == null) {
            return;
        }
        if (((aVar instanceof e93.d) && !((e93.d) aVar).a().isEmpty()) || (aVar instanceof e93.b)) {
            this.C.setValue(Boolean.TRUE);
        } else if (aVar instanceof e93.f) {
            this.C.setValue(Boolean.valueOf(!((e93.f) aVar).c().isEmpty()));
        } else if (aVar instanceof e93.h) {
            this.C.setValue(Boolean.valueOf(!((e93.h) aVar).a().isEmpty()));
        }
        X1();
    }

    private void X1() {
        boolean z16;
        if (this.f324835m.getValue() != null && this.C.getValue() != null) {
            MediatorLiveData<Boolean> mediatorLiveData = this.f324834i;
            if (this.f324835m.getValue().booleanValue() && !this.C.getValue().booleanValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            mediatorLiveData.postValue(Boolean.valueOf(z16));
        }
    }

    public void N1(String str) {
        this.D.setValue(str);
    }

    public boolean O1() {
        return this.E;
    }

    public LiveData<Boolean> P1() {
        return this.f324834i;
    }

    public LiveData<String> Q1() {
        return this.D;
    }

    public void T1(LiveData<e93.a> liveData) {
        this.f324834i.removeSource(liveData);
        this.f324834i.addSource(liveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                p.this.S1((e93.a) obj);
            }
        });
    }

    public void U1(boolean z16) {
        this.E = z16;
    }

    public void W1(boolean z16) {
        this.f324835m.setValue(Boolean.valueOf(z16));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "WinkMediaPickerUIStateViewModel";
    }
}
