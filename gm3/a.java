package gm3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.component.core.event.EventCenter;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.qqlive.common.api.AegisLogger;
import e55.c;
import fm3.b;
import g55.ag;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private fm3.b f402427i = new fm3.b();

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f402428m = new MutableLiveData<>(Boolean.FALSE);
    private MutableLiveData<String> C = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: gm3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C10388a implements b.a {
        C10388a() {
        }

        @Override // fm3.b.a
        public void a(int i3, int i16, String str) {
            boolean z16;
            AegisLogger.i("PK_Biz|AcceptInviteViewModel", "refuseInvite result: op=" + i3 + ", retCode=" + i16);
            a aVar = a.this;
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.T1(z16, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ag f402430a;

        b(ag agVar) {
            this.f402430a = agVar;
        }

        @Override // fm3.b.a
        public void a(int i3, int i16, String str) {
            boolean z16;
            a aVar = a.this;
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.T1(z16, str);
            AegisLogger.i("PK_Biz|AcceptInviteViewModel", "acceptInvite result: op=" + i3 + ", retCode=" + i16);
            if (i16 == 0) {
                EventCenter.post(new d.ResponseInviteEvent(2, this.f402430a));
            }
            if (i16 != 0) {
                a.this.Q1(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(boolean z16, String str) {
        this.f402428m.setValue(Boolean.valueOf(z16));
        this.C.setValue(str);
    }

    public void M1() {
        c cVar;
        ag agVar = new ag();
        agVar.f401296b = N1();
        R1();
        this.f402427i.e(new b(agVar));
        e55.a aVar = agVar.f401296b;
        if (aVar != null && (cVar = aVar.f395729a) != null) {
            mm3.a.f417004a.b(cVar.f395735a);
        }
    }

    public e55.a N1() {
        return this.f402427i.c();
    }

    public LiveData<String> O1() {
        return this.C;
    }

    public LiveData<Boolean> P1() {
        return this.f402428m;
    }

    public void Q1(boolean z16) {
        int i3;
        if (z16) {
            i3 = 5;
        } else {
            i3 = 3;
        }
        ag agVar = new ag();
        agVar.f401296b = N1();
        EventCenter.post(new d.ResponseInviteEvent(i3, agVar));
        R1();
        this.f402427i.f(i3, new C10388a());
    }

    public void R1() {
        T1(false, null);
    }

    public void S1(String str, e55.a aVar) {
        this.f402427i.h(str, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f402427i.b();
        this.f402427i = null;
    }
}
