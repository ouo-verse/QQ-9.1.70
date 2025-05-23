package com.tencent.now.pkgame.pkgame.pktimer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.now.pkgame.pkgame.pklib.model.e;
import g55.at;
import g55.av;
import java.text.SimpleDateFormat;
import java.util.Date;
import mo3.d;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends d {
    private Context C;
    private Subscription D;
    protected MutableLiveData<String> E = new MutableLiveData<>();
    protected MutableLiveData<Boolean> F = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private String f339037m;

    private String U1(long j3) {
        return (j3 / 1000) + ReportConstant.COSTREPORT_PREFIX;
    }

    private String X1() {
        if (TextUtils.isEmpty(this.f339037m)) {
            this.f339037m = this.C.getString(R.string.f174792wt);
        }
        return this.f339037m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(e eVar, Long l3) {
        LogUtil.i("PkTimerViewModel", "\u65f6\u95f4: " + l3 + ", pkGameInfoRsp: " + eVar.l().b(), new Object[0]);
        at atVar = eVar.l().b().f401379b;
        if (atVar == null) {
            return;
        }
        this.E.setValue(b2(atVar, l3.longValue(), "mm:ss"));
    }

    private void e2() {
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        Subscription subscription = this.D;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // mo3.d
    public void M1() {
        super.M1();
        e2();
    }

    @Override // mo3.d
    public void O1() {
        super.O1();
        e2();
    }

    @Override // mo3.d
    @SuppressLint({"CheckResult"})
    public void R1(final e eVar) {
        super.R1(eVar);
        this.D = eVar.m().a().subscribe(new Action1() { // from class: com.tencent.now.pkgame.pkgame.pktimer.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                b.this.d2(eVar, (Long) obj);
            }
        });
    }

    public String T1(long j3, String str) {
        String X1 = X1();
        if (j3 >= 0) {
            return Z1(j3, str);
        }
        return X1;
    }

    public LiveData<String> W1() {
        return this.E;
    }

    public String Z1(long j3, String str) {
        return new SimpleDateFormat(str).format(new Date(j3));
    }

    public LiveData<Boolean> a2() {
        return this.F;
    }

    public String b2(at atVar, long j3, String str) {
        boolean z16;
        av avVar = atVar.f401334j;
        long j16 = avVar.f401343b;
        long j17 = avVar.f401342a;
        if (j16 > j17) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j18 = j16 - j17;
        if (j3 > 30000) {
            this.F.setValue(Boolean.FALSE);
            return T1(j3, str);
        }
        long j19 = 0;
        if (j3 >= 0 && j3 <= 30000) {
            this.F.setValue(Boolean.TRUE);
            return U1(j3);
        }
        if (z16 && j3 < 0) {
            long j26 = j3 + (j18 * 1000);
            if (j26 >= 0) {
                j19 = j26;
            }
            this.F.setValue(Boolean.FALSE);
            return T1(j19, str);
        }
        return X1();
    }

    public void c2(Context context) {
        this.C = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        e2();
    }
}
