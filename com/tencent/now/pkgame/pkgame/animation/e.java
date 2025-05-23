package com.tencent.now.pkgame.pkgame.animation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import org.jetbrains.annotations.NotNull;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends mo3.d {
    private boolean C = false;
    private boolean D = false;
    private boolean E = DeviceInfoUtils.isHighPerfDevice();
    private MutableLiveData<mo3.a<Boolean>> F = new MutableLiveData<>();
    private MutableLiveData<mo3.a<Boolean>> G = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private Subscription f338956m;

    private boolean W1(long j3) {
        if (j3 <= 30000 && j3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(Long l3) {
        if (!this.C) {
            this.F.setValue(new mo3.a<>(Boolean.TRUE));
            this.C = true;
        }
        if (this.E && W1(l3.longValue()) && f.f338957a.b() && !this.D) {
            QLog.i("AnimationViewModel", 1, "count: " + l3 + ", start play apng.");
            this.D = true;
            this.G.setValue(new mo3.a<>(Boolean.TRUE));
        }
        if (l3.longValue() <= 0 && this.D) {
            this.D = false;
            this.G.setValue(new mo3.a<>(Boolean.FALSE));
        }
    }

    private void Z1() {
        this.C = false;
        this.D = false;
        MutableLiveData<mo3.a<Boolean>> mutableLiveData = this.G;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(new mo3.a<>(bool));
        this.F.setValue(new mo3.a<>(bool));
        Subscription subscription = this.f338956m;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // mo3.d
    public void M1() {
        super.M1();
        Z1();
    }

    @Override // mo3.d
    public void N1(com.tencent.now.pkgame.pkgame.pklib.state.a aVar) {
        super.N1(aVar);
    }

    @Override // mo3.d
    public void O1() {
        super.O1();
        Z1();
    }

    @Override // mo3.d
    public void R1(@NotNull com.tencent.now.pkgame.pkgame.pklib.model.e eVar) {
        super.R1(eVar);
        QLog.i("AnimationViewModel", 1, "needShowPkFireAnim:" + this.E);
        this.f338956m = eVar.m().a().subscribe(new Action1() { // from class: com.tencent.now.pkgame.pkgame.animation.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                e.this.X1((Long) obj);
            }
        });
    }

    public LiveData<mo3.a<Boolean>> T1() {
        return this.G;
    }

    public LiveData<mo3.a<Boolean>> U1() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Z1();
    }
}
