package com.tencent.mobileqq.vasgift.mvvm.business;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.qqgift.data.service.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report;
import com.tencent.mobileqq.vasgift.countdown.CountDownController;
import com.tencent.mobileqq.vasgift.countdown.CountDownInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import sh2.c;

/* loaded from: classes20.dex */
public class QQGiftPanelViewModel extends com.tencent.mobileqq.vasgift.mvvm.business.a {

    /* renamed from: l0, reason: collision with root package name */
    public static ViewModelProvider.Factory f311639l0 = new d();
    private nh2.c F;
    private final MutableLiveData<com.tencent.mobileqq.vasgift.mvvm.business.f<List<List<com.tencent.mobileqq.qqgift.data.service.d>>>> G;
    private final MutableLiveData<String> H;
    private final MutableLiveData<Long> I;
    private final MutableLiveData<com.tencent.mobileqq.qqgift.mvvm.business.data.b> J;
    private final MutableLiveData<List<com.tencent.mobileqq.qqgift.mvvm.business.data.c>> K;
    private final MutableLiveData<Integer> L;
    private final MutableLiveData<Pair<Integer, Integer>> M;
    private volatile long N;
    private int P;
    private c.f Q;
    private c.d R;
    private Map<String, String> S;
    private com.tencent.mobileqq.vasgift.business.dt.a T;
    private com.tencent.mobileqq.qqgift.mvvm.business.data.a U;
    private VasGift04586Report V;
    private com.tencent.mobileqq.qqgift.data.service.a W;
    private long X;
    private int Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f311640a0;

    /* renamed from: b0, reason: collision with root package name */
    public com.tencent.mobileqq.qqgift.data.service.d f311641b0;

    /* renamed from: c0, reason: collision with root package name */
    public com.tencent.mobileqq.qqgift.data.service.d f311642c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f311643d0;

    /* renamed from: e0, reason: collision with root package name */
    private e.a f311644e0;

    /* renamed from: f0, reason: collision with root package name */
    private List<com.tencent.mobileqq.qqgift.data.service.e> f311645f0;

    /* renamed from: g0, reason: collision with root package name */
    private List<com.tencent.mobileqq.qqgift.data.service.e> f311646g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f311647h0;

    /* renamed from: i0, reason: collision with root package name */
    private View.OnClickListener f311648i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f311649j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f311650k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QQGiftPanelViewModel qQGiftPanelViewModel = QQGiftPanelViewModel.this;
            qQGiftPanelViewModel.u2(qQGiftPanelViewModel.g3(), true);
            if (QQGiftPanelViewModel.this.V != null) {
                QQGiftPanelViewModel.this.V.j0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements rh2.d {
        b() {
        }

        @Override // rh2.d
        public void g(int i3, String str, long j3) {
            QQGiftPanelViewModel.this.I.postValue(Long.valueOf(j3));
        }

        @Override // rh2.d
        public void onCancel() {
            QQGiftPanelViewModel.this.I.postValue(-1L);
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            QLog.e("QQGiftPanelViewModel", 1, "refreshFreeCoinBalance, getFreeCoinBalance, onFailed, errCode=" + i3 + ", errMsg" + str);
        }
    }

    /* loaded from: classes20.dex */
    class d implements ViewModelProvider.Factory {
        d() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new QQGiftPanelViewModel(new com.tencent.mobileqq.vasgift.mvvm.business.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements rh2.g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f311654d;

        e(long j3) {
            this.f311654d = j3;
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            QQGiftPanelViewModel.this.u3(null);
        }

        @Override // rh2.g
        public void onReceive(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
            int size;
            QQGiftPanelViewModel.this.u3(list);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[refreshGiftList] onReceive:");
                if (list == null) {
                    size = 0;
                } else {
                    size = list.size();
                }
                sb5.append(size);
                sb5.append(",cost:");
                sb5.append(System.currentTimeMillis() - this.f311654d);
                QLog.i("QQGiftPanelViewModel", 2, sb5.toString());
            }
            VasPerfReportUtils.report(VasPerfReportUtils.WHILE_GET_LIST, VasPerfReportUtils.WITHIN_SDK, String.valueOf(QQGiftPanelViewModel.this.F.getSDKConfig().f264972a), "network", System.currentTimeMillis() - this.f311654d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class i implements rh2.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f311660d;

        i(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            this.f311660d = dVar;
        }

        @Override // rh2.f
        public void f(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            if (dVar != null) {
                com.tencent.mobileqq.qqgift.data.service.d dVar2 = this.f311660d;
                dVar2.K = dVar.K;
                dVar2.M = dVar.M;
            }
            QQGiftPanelViewModel.this.n1(true, this.f311660d, 0, "");
        }

        @Override // rh2.b
        public void i(List<String> list, int i3) {
            if (QQGiftPanelViewModel.this.Q instanceof c.InterfaceC11228c) {
                if (i3 == -11008) {
                    QQGiftPanelViewModel.this.u2(true, true);
                }
                ((c.InterfaceC11228c) QQGiftPanelViewModel.this.Q).H0(true, this.f311660d, i3, list);
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            QQGiftPanelViewModel.this.n1(false, this.f311660d, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class j implements rh2.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f311662d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f311663e;

        j(int i3, com.tencent.mobileqq.qqgift.data.service.d dVar) {
            this.f311662d = i3;
            this.f311663e = dVar;
        }

        @Override // rh2.f
        public void f(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            QQGiftPanelViewModel.this.Y += this.f311662d;
            com.tencent.mobileqq.qqgift.data.service.d dVar2 = this.f311663e;
            dVar2.I = this.f311662d;
            QQGiftPanelViewModel.this.n1(true, dVar2, 0, "");
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            com.tencent.mobileqq.qqgift.data.service.d dVar = this.f311663e;
            dVar.I = this.f311662d;
            QQGiftPanelViewModel.this.n1(false, dVar, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class k implements IQQGiftRechargeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f311665a;

        k(boolean z16) {
            this.f311665a = z16;
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public Map<String, String> a() {
            HashMap hashMap = new HashMap();
            if (QQGiftPanelViewModel.this.U != null && !TextUtils.isEmpty(QQGiftPanelViewModel.this.U.f264945l) && !TextUtils.isEmpty(QQGiftPanelViewModel.this.U.f264944k)) {
                hashMap.put("main_recharge_id", QQGiftPanelViewModel.this.U.f264944k);
                hashMap.put("sub_recharge_id", QQGiftPanelViewModel.this.U.f264945l);
                return hashMap;
            }
            if (QQGiftPanelViewModel.this.T != null) {
                return QQGiftPanelViewModel.this.T.h();
            }
            return hashMap;
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public void b(boolean z16, int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGiftPanelViewModel", 2, "[onRechargeBack] success:" + z16 + ", errCode:" + i3 + ", errMsg:" + str);
            }
            if (z16) {
                QQGiftPanelViewModel.this.w3();
                if (this.f311665a) {
                    QQGiftPanelViewModel.this.W3();
                }
            }
            VasLogReporter.getVasGift().report("doOnRecharge back success:" + z16 + ", errCode:" + i3 + ", errMsg:" + str, VasLogReportProxy.LEVEL.HIGHEST);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f311667d;

        l(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            this.f311667d = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QQGiftPanelViewModel.this.M1(this.f311667d, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class m implements DialogInterface.OnClickListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public QQGiftPanelViewModel(com.tencent.mobileqq.vasgift.mvvm.business.b bVar) {
        super(bVar);
        this.G = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        this.I = new MutableLiveData<>();
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>();
        this.L = new MutableLiveData<>();
        this.M = new MutableLiveData<>();
        this.P = -1;
        this.Q = new f43.a(this, null);
        this.Y = 0;
        this.f311643d0 = 0;
        this.f311644e0 = null;
        this.f311645f0 = new ArrayList();
        this.f311647h0 = -1;
        this.f311649j0 = VasNormalToggle.VAS_GIFT_DATA_BUG.isEnable(true);
        this.f311650k0 = VasNormalToggle.VAS_GIFT_COMBO_SEND_BUG.isEnable(true);
    }

    private void E3(List<List<com.tencent.mobileqq.qqgift.data.service.d>> list) {
        Iterator<List<com.tencent.mobileqq.qqgift.data.service.d>> it = list.iterator();
        while (it.hasNext()) {
            Iterator<com.tencent.mobileqq.qqgift.data.service.d> it5 = it.next().iterator();
            while (it5.hasNext()) {
                it5.next().N = false;
            }
        }
    }

    private void F3(List<List<com.tencent.mobileqq.qqgift.data.service.d>> list) {
        Iterator<List<com.tencent.mobileqq.qqgift.data.service.d>> it = list.iterator();
        while (it.hasNext()) {
            Iterator<com.tencent.mobileqq.qqgift.data.service.d> it5 = it.next().iterator();
            while (it5.hasNext()) {
                it5.next().E = false;
            }
        }
    }

    private int J2() {
        int i3;
        if (this.f311643d0 == 0) {
            if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.getContext())) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            this.f311643d0 = i3;
        }
        return this.f311643d0 * 2;
    }

    private int M2() {
        List<com.tencent.mobileqq.qqgift.data.service.e> list = this.f311645f0;
        if (list != null) {
            Iterator<com.tencent.mobileqq.qqgift.data.service.e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.qqgift.data.service.e next = it.next();
                if (next.f264894a.equals("PACKAGE_TAB_ID")) {
                    List<com.tencent.mobileqq.qqgift.data.service.d> list2 = next.f264898e;
                    if (list2 != null) {
                        return list2.size();
                    }
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T3(long j3, long j16) {
        String str;
        this.Z = j3;
        this.f311640a0 = j16;
        MutableLiveData<String> mutableLiveData = this.H;
        if (j3 <= 0 && j16 <= 0) {
            str = BaseApplication.getContext().getString(R.string.f209975gv);
        } else {
            str = j3 + "";
        }
        mutableLiveData.postValue(str);
        this.C.postValue(Long.valueOf(j3));
        this.f311670i.postValue(Long.valueOf(j16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W3() {
        com.tencent.mobileqq.qqgift.data.service.d z26 = z2(this.P);
        if (z26 == null) {
            return;
        }
        DialogUtil.createNoTitleDialog(this.f311671m.get(), this.f311671m.get().getString(R.string.f209985gw, z26.f264876e), R.string.f209995gx, R.string.f210005gy, new l(z26), new m()).show();
    }

    private boolean X3() {
        if (this.F.getSDKConfig().f264972a == 10012) {
            return true;
        }
        return false;
    }

    private void Y2(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        nh2.c cVar = this.F;
        if (cVar != null && cVar.getSDKConfig() != null && !this.F.getSDKConfig().f264981j) {
            Iterator<com.tencent.mobileqq.qqgift.data.service.e> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.qqgift.data.service.e next = it.next();
                if (next != null && TextUtils.equals(next.f264894a, "PACKAGE_TAB_ID")) {
                    it.remove();
                    return;
                }
            }
        }
    }

    private List<List<com.tencent.mobileqq.qqgift.data.service.d>> Y3(List<com.tencent.mobileqq.qqgift.data.service.e> list, boolean z16) {
        boolean z17;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (com.tencent.mobileqq.qqgift.data.service.e eVar : list) {
                List<com.tencent.mobileqq.qqgift.data.service.d> list2 = eVar.f264898e;
                if (list2 != null && !list2.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 1; i3 <= eVar.f264898e.size(); i3++) {
                        com.tencent.mobileqq.qqgift.data.service.d dVar = eVar.f264898e.get(i3 - 1);
                        if (z16) {
                            if (i3 == 1) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            dVar.E = z17;
                        }
                        arrayList2.add(dVar);
                        if (i3 % J2() == 0) {
                            arrayList.add(arrayList2);
                            arrayList2 = new ArrayList();
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        arrayList.add(arrayList2);
                    }
                } else {
                    arrayList.add(new ArrayList());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z3(List<com.tencent.mobileqq.qqgift.data.service.d> list, List<com.tencent.mobileqq.qqgift.data.service.d> list2) {
        boolean z16;
        boolean z17 = false;
        for (com.tencent.mobileqq.qqgift.data.service.d dVar : list) {
            for (com.tencent.mobileqq.qqgift.data.service.d dVar2 : list2) {
                if (dVar2.f264874d == dVar.f264874d && (z16 = dVar2.f264875d0) == dVar.f264875d0) {
                    dVar.f264876e = dVar2.f264876e;
                    dVar.f264878f = dVar2.f264878f;
                    dVar.Q = dVar2.Q;
                    dVar.R = dVar2.R;
                    dVar.W = dVar2.W;
                    dVar.Z = dVar2.Z;
                    dVar.Y = dVar2.Y;
                    dVar.X = dVar2.X;
                    dVar.T = dVar2.T;
                    dVar.C = dVar2.C;
                    dVar.G = dVar2.G;
                    dVar.f264881h = dVar2.f264881h;
                    dVar.F = dVar2.F;
                    dVar.f264883i = dVar2.f264883i;
                    dVar.f264871a0 = dVar2.f264871a0;
                    dVar.f264872b0 = dVar2.f264872b0;
                    dVar.V = dVar2.V;
                    dVar.U = dVar2.U;
                    dVar.S = dVar2.S;
                    dVar.f264875d0 = z16;
                    dVar.f264877e0 = dVar2.f264877e0;
                    dVar.f264879f0 = dVar2.f264879f0;
                    z17 = true;
                }
            }
        }
        return z17;
    }

    private void a3(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        nh2.c cVar = this.F;
        if (cVar != null && cVar.getSDKConfig() != null && this.F.getSDKConfig().f264982k) {
            Iterator<com.tencent.mobileqq.qqgift.data.service.e> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.qqgift.data.service.e next = it.next();
                if (next != null && TextUtils.equals(next.f264894a, "WELFARE_TAB_ID")) {
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a4(com.tencent.mobileqq.qqgift.data.service.e eVar) {
        boolean z16;
        if (G2().getValue() != null && eVar != null && this.f311645f0 != null) {
            this.f311644e0 = eVar.f264899f;
            int i3 = 0;
            while (true) {
                if (i3 < this.f311645f0.size()) {
                    if (this.f311645f0.get(i3).f264894a.equals("PACKAGE_TAB_ID")) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            List<com.tencent.mobileqq.qqgift.data.service.d> list = eVar.f264898e;
            if (list != null && !list.isEmpty()) {
                if (this.f311641b0 != null) {
                    for (com.tencent.mobileqq.qqgift.data.service.d dVar : eVar.f264898e) {
                        int i16 = dVar.f264874d;
                        com.tencent.mobileqq.qqgift.data.service.d dVar2 = this.f311641b0;
                        if (i16 == dVar2.f264874d && dVar2.f264875d0) {
                            dVar.E = true;
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                    eVar.f264898e.get(0).E = true;
                }
            }
            if (i3 != -1) {
                this.f311645f0.set(i3, eVar);
            } else {
                this.f311645f0.add(eVar);
            }
            v3(this.f311645f0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b3(long j3) {
        if (this.N > j3) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGiftPanelViewModel", 2, "[isBalanceSeqValid] mRefreshBalanceSeq" + this.N + ",seq:" + j3 + ",just abort");
                return false;
            }
            return false;
        }
        this.N = j3;
        return true;
    }

    private void b4(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        int i3;
        int i16;
        if (this.G.getValue() != null && this.G.getValue().a() != null) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.G.getValue().a();
            int i17 = 0;
            int i18 = 0;
            loop0: while (true) {
                if (i18 < a16.size()) {
                    i3 = 0;
                    while (i3 < a16.get(i18).size()) {
                        if (a16.get(i18).get(i3) == dVar) {
                            i17 = i18;
                            break loop0;
                        }
                        i3++;
                    }
                    i18++;
                } else {
                    i3 = 0;
                    break;
                }
            }
            if (this.K.getValue() != null) {
                List<com.tencent.mobileqq.qqgift.mvvm.business.data.c> value = this.K.getValue();
                if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.getContext())) {
                    i16 = 10;
                } else {
                    i16 = 8;
                }
                Iterator<com.tencent.mobileqq.qqgift.mvvm.business.data.c> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.qqgift.mvvm.business.data.c next = it.next();
                    int i19 = next.f264968e;
                    if (i17 >= i19 && i17 <= next.f264969f) {
                        next.f264967d = ((i17 - i19) * i16) + i3;
                        break;
                    }
                }
                this.K.postValue(value);
            }
        }
    }

    private boolean d3(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        CountDownInfo countDownInfo;
        CountDownController c16 = e43.a.d().c(this.F.getSDKConfig().f264972a + "");
        if (c16 != null && dVar != null) {
            countDownInfo = c16.m().get(dVar.f264874d + "");
        } else {
            countDownInfo = null;
        }
        if (countDownInfo != null) {
            return true;
        }
        return false;
    }

    private boolean f3() {
        int i3;
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.f311641b0;
        int i16 = dVar.f264878f;
        long j3 = i16;
        long j16 = this.f311640a0;
        if (j3 > j16) {
            long j17 = i16;
            long j18 = this.Z;
            if (j17 > j18) {
                if (j16 != 0 && j18 != 0) {
                    i3 = -11009;
                } else {
                    i3 = -11008;
                }
                S1(false, dVar, i3, BaseApplication.getContext().getString(R.string.f209905go));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g3() {
        if (this.F.getSDKConfig().f264972a != 10010 && this.F.getSDKConfig().f264972a != 10012) {
            return false;
        }
        return true;
    }

    private boolean h3(int i3) {
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.f311641b0;
        if (dVar.f264875d0 && dVar.f264877e0 < i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q3, reason: merged with bridge method [inline-methods] */
    public void k3(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j3) {
        if (dVar == null) {
            QLog.e("QQGiftPanelViewModel", 1, "send_combo: send_error, giftData is null!!");
            return;
        }
        if (dVar.f264875d0) {
            if (h3(i16)) {
                n3(dVar, i3, i16);
                return;
            }
        } else if (f3()) {
            n3(dVar, i3, i16);
            return;
        }
        if (e3()) {
            dVar = dVar.clone();
        }
        com.tencent.mobileqq.qqgift.data.service.d dVar2 = dVar;
        this.V.e0(dVar2, V2(), i16);
        dVar2.H = j3;
        dVar2.J = i16;
        dVar2.D = 1;
        if (dVar2.f264875d0) {
            com.tencent.mobileqq.vasgift.utils.e.f312015a.c(dVar2.f264874d);
        }
        this.F.a().B(this.f311671m.get(), dVar2, i3, i16, new j(i3, dVar2));
    }

    private void r2(boolean z16) {
        if (this.F.g().q().equals(IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_PANEL)) {
            String str = this.F.getSDKConfig().f264972a + "";
            if (z16) {
                e43.a.d().g(str);
            } else {
                e43.a.d().f(str);
            }
        }
    }

    private void r3() {
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.f311641b0;
        this.F.a().X(this.f311671m.get(), dVar.f264874d, dVar.F, 1, new i(dVar));
    }

    private void s2() {
        if (this.X == 0) {
            this.X = System.currentTimeMillis();
        }
        this.X++;
    }

    private void t2(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        String str;
        int i3;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            for (com.tencent.mobileqq.qqgift.data.service.e eVar : list) {
                com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.c();
                cVar.f264964a = eVar.f264894a;
                cVar.f264965b = eVar.f264895b;
                if (eVar.f264897d) {
                    str = eVar.f264896c;
                } else {
                    str = "";
                }
                cVar.f264966c = str;
                List<com.tencent.mobileqq.qqgift.data.service.d> list2 = eVar.f264898e;
                if (list2 != null && !list2.isEmpty()) {
                    if (eVar.f264898e.size() % J2() == 0) {
                        i3 = eVar.f264898e.size() / J2();
                    } else {
                        i3 = (eVar.f264898e.size() / J2()) + 1;
                    }
                } else {
                    i3 = 1;
                }
                cVar.f264968e = i16;
                cVar.f264969f = (i16 + i3) - 1;
                arrayList.add(cVar);
                i16 += i3;
            }
            this.K.postValue(arrayList);
        }
    }

    private void t3(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (i3() && this.F.getSDKConfig() != null && e43.a.e(dVar)) {
            CountDownController c16 = e43.a.d().c(this.F.getSDKConfig().f264972a + "");
            if (c16 != null) {
                c16.w(dVar.f264874d, dVar.G.f264891d);
                if (QLog.isColorLevel()) {
                    QLog.i("QQGiftPanelViewModel", 2, "[processFreeGift] " + dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        v3(list, true);
    }

    private void v3(List<com.tencent.mobileqq.qqgift.data.service.e> list, boolean z16) {
        List<List<com.tencent.mobileqq.qqgift.data.service.d>> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            a3(list);
            Y2(list);
            arrayList = Y3(list, z16);
            t2(list);
            this.f311645f0 = list;
        }
        this.G.postValue(new com.tencent.mobileqq.vasgift.mvvm.business.f<>(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3() {
        if (!i3()) {
            return;
        }
        this.F.a().F(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3() {
        List<com.tencent.mobileqq.qqgift.data.service.d> list;
        if (this.G.getValue() == null) {
            return;
        }
        List<List<com.tencent.mobileqq.qqgift.data.service.d>> Y3 = Y3(this.f311645f0, false);
        int y26 = y2();
        if (y26 != -1 && y26 < Y3.size() && (list = Y3.get(y26)) != null && !list.isEmpty()) {
            com.tencent.mobileqq.qqgift.data.service.d dVar = list.get(0);
            if (StringUtil.isEmpty(dVar.f264876e) && dVar.f264878f == 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.tencent.mobileqq.qqgift.data.service.d> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(String.valueOf(it.next().f264874d)));
                }
                D3(arrayList);
            }
        }
    }

    private void y3() {
        if (!i3()) {
            return;
        }
        if (F2() != null && F2().a()) {
            this.F.a().L(new b());
        } else {
            QLog.e("QQGiftPanelViewModel", 1, "refreshFreeCoinBalance, Free coin is not enable.");
        }
    }

    private com.tencent.mobileqq.qqgift.data.service.d z2(int i3) {
        try {
            Iterator<List<com.tencent.mobileqq.qqgift.data.service.d>> it = G2().getValue().a().iterator();
            while (it.hasNext()) {
                for (com.tencent.mobileqq.qqgift.data.service.d dVar : it.next()) {
                    if (dVar.f264874d == i3) {
                        return dVar;
                    }
                }
            }
            return null;
        } catch (NullPointerException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void z3() {
        List<com.tencent.mobileqq.qqgift.data.service.e> j3;
        if (!i3()) {
            return;
        }
        List<com.tencent.mobileqq.qqgift.data.service.e> list = this.f311646g0;
        if (list != null && !list.isEmpty()) {
            j3 = this.f311646g0;
        } else {
            j3 = ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).j(this.F);
        }
        if (j3 != null && j3.size() > 0) {
            u3(j3);
            QLog.i("QQGiftPanelViewModel", 2, "[refreshGiftList] use cacheList");
            VasPerfReportUtils.report(VasPerfReportUtils.WHILE_GET_LIST, VasPerfReportUtils.WITHIN_SDK, String.valueOf(this.F.getSDKConfig().f264972a), "cache", 0L);
        } else {
            ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).k(this.F, this.W, new e(System.currentTimeMillis()));
        }
    }

    public c.f A2(c.f fVar) {
        return new f43.a(this, fVar);
    }

    public void A3(List<Long> list) {
        if (!i3()) {
            return;
        }
        ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).n(this.F, list, new f());
    }

    public com.tencent.mobileqq.vasgift.business.dt.a B2() {
        return this.T;
    }

    public Map<String, String> C2() {
        return this.S;
    }

    public void C3() {
        if (i3() && ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).o(this.F)) {
            ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).m(this.F, new g());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean D() {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.D();
            return false;
        }
        return false;
    }

    public com.tencent.mobileqq.qqgift.mvvm.business.data.a D2() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar = this.U;
        if (aVar != null) {
            aVar.f264952s = M2();
        }
        return this.U;
    }

    public void D3(List<Long> list) {
        if (i3() && ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).o(this.F)) {
            ((com.tencent.mobileqq.vasgift.mvvm.business.b) this.mRepository).l(this.F, list, new h(list));
        }
    }

    public MutableLiveData<Long> E2() {
        return this.I;
    }

    public com.tencent.mobileqq.qqgift.data.service.f F2() {
        return this.F.a().W();
    }

    public MutableLiveData<com.tencent.mobileqq.vasgift.mvvm.business.f<List<List<com.tencent.mobileqq.qqgift.data.service.d>>>> G2() {
        return this.G;
    }

    public void G3() {
        if (this.G.getValue() == null) {
            return;
        }
        List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.G.getValue().a();
        E3(a16);
        this.G.setValue(new com.tencent.mobileqq.vasgift.mvvm.business.f<>(a16));
    }

    public nh2.c H2() {
        return this.F;
    }

    public void H3(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (dVar != this.f311641b0 && this.G.getValue() != null && this.G.getValue().a() != null) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.G.getValue().a();
            F3(a16);
            dVar.E = true;
            this.G.setValue(new com.tencent.mobileqq.vasgift.mvvm.business.f<>(a16));
            u0(dVar, -1);
        }
    }

    public long I2() {
        return this.X;
    }

    public void I3(VasGift04586Report vasGift04586Report) {
        this.V = vasGift04586Report;
    }

    public void J3(c.d dVar) {
        this.R = dVar;
    }

    public MutableLiveData<Long> K2() {
        return this.f311670i;
    }

    public void K3(int i3) {
        this.f311647h0 = i3;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void L1() {
        r2(false);
    }

    public e.a L2() {
        return this.f311644e0;
    }

    public void L3(Map<String, String> map) {
        this.S = map;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void M1(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        this.T.n(dVar, i3);
        this.V.t0(dVar, i3);
        if (dVar.E) {
            if (dVar.f264881h == 6) {
                com.tencent.mobileqq.qqgift.webview.e.a(dVar.f264882h0);
            } else {
                O(dVar, i3);
            }
        } else {
            this.M.setValue(new Pair<>(-2, 0));
            H3(dVar);
            b4(dVar);
        }
        VasLogReporter.getVasGift().report("doOnPanelItemClick:" + dVar, VasLogReportProxy.LEVEL.HIGHEST);
    }

    public void M3(com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar) {
        this.U = aVar;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void N1(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        this.T.n(dVar, i3);
        this.V.t0(dVar, i3);
        if (dVar.E) {
            if (this.F.getSDKConfig().f264972a != 10011 && this.F.getSDKConfig().f264972a != 10008 && this.F.getSDKConfig().f264972a != 10015) {
                O(dVar, i3);
            }
        } else {
            H3(dVar);
            b4(dVar);
            this.M.setValue(new Pair<>(-2, 0));
        }
        VasLogReporter.getVasGift().report("doOnPanelItemClick:" + dVar, VasLogReportProxy.LEVEL.HIGHEST);
    }

    public MutableLiveData<com.tencent.mobileqq.qqgift.mvvm.business.data.b> N2() {
        return this.J;
    }

    public void N3(com.tencent.mobileqq.vasgift.business.dt.a aVar) {
        this.T = aVar;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean O(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.O(dVar, i3);
            return false;
        }
        return false;
    }

    public MutableLiveData<String> O2() {
        return this.H;
    }

    public void O3(View.OnClickListener onClickListener) {
        this.f311648i0 = onClickListener;
    }

    public com.tencent.mobileqq.qqgift.data.service.d P2() {
        return this.f311641b0;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void Q1() {
        refresh();
        r2(true);
    }

    public int Q2() {
        return this.P;
    }

    public void Q3(nh2.c cVar) {
        this.F = cVar;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void R1() {
        u2(false, false);
    }

    public MutableLiveData<Integer> R2() {
        return this.L;
    }

    public void R3(c.f fVar) {
        this.Q = fVar;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void S1(boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, String str) {
        WeakReference<Activity> weakReference;
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftPanelViewModel", 2, "[doOnSendGiftCallback] isSuccess:" + z16 + ",data:" + dVar + ",errCode:" + i3);
        }
        w3();
        y3();
        if (!z16) {
            if (i3 != -11008 && i3 != 20003 && i3 != -11009) {
                if (TextUtils.isEmpty(str)) {
                    str = BaseApplication.getContext().getString(R.string.f209915gp);
                }
                QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
                return;
            }
            com.tencent.mobileqq.vasgift.business.dt.a aVar = this.T;
            if (aVar != null) {
                aVar.c(false, this.f311641b0, "\u4f59\u989d\u4e0d\u8db3");
            }
            VasGift04586Report vasGift04586Report = this.V;
            if (vasGift04586Report != null) {
                vasGift04586Report.g0(false, this.f311641b0, i3, "");
                this.V.i0();
            }
            if (dVar.f264881h != 2) {
                if (i3 == -11009 && (weakReference = this.f311671m) != null && weakReference.get() != null) {
                    IVasTempApi.INSTANCE.get().showNotEnoughExplainDialog(this.f311671m.get(), new a(), new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel.11
                        @Override // java.lang.Runnable
                        public void run() {
                            QQGiftPanelViewModel qQGiftPanelViewModel = QQGiftPanelViewModel.this;
                            qQGiftPanelViewModel.u2(qQGiftPanelViewModel.g3(), true);
                        }
                    });
                } else {
                    u2(g3(), true);
                }
            }
        }
    }

    public MutableLiveData<Pair<Integer, Integer>> S2() {
        return this.M;
    }

    public void S3(com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar) {
        this.J.postValue(bVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a
    public void T1(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        int i16;
        if (!i3()) {
            return;
        }
        if (e43.a.e(dVar) && d3(dVar)) {
            return;
        }
        if (this.f311641b0.f264875d0) {
            int b16 = com.tencent.mobileqq.vasgift.utils.e.f312015a.b(dVar.f264874d);
            if (QLog.isColorLevel()) {
                QLog.i("QQGiftPanelViewModel", 1, "giftId: " + dVar.f264874d + ",giftName: " + dVar.f264876e + ", curWaitNums: " + b16);
            }
            if (h3(b16 + 1)) {
                return;
            }
        } else if (f3()) {
            return;
        }
        t3(dVar);
        if (!c3(dVar) && X3()) {
            r3();
            return;
        }
        s2();
        if (c3(dVar) && (this.F.getSDKConfig() == null || !this.F.getSDKConfig().f264979h)) {
            List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = this.G.getValue().a();
            E3(a16);
            dVar.N = true;
            this.G.setValue(new com.tencent.mobileqq.vasgift.mvvm.business.f<>(a16));
            com.tencent.mobileqq.vasgift.mvvm.business.c.f311815e = true;
            int i17 = dVar.f264878f;
            if (i17 > 0) {
                i16 = (int) ((this.Z / i17) + (this.f311640a0 / i17));
            } else {
                i16 = Integer.MAX_VALUE;
            }
            if (dVar.f264875d0) {
                i16 = Long.valueOf(dVar.f264877e0).intValue();
            }
            this.M.setValue(new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        com.tencent.mobileqq.vasgift.business.dt.a aVar = this.T;
        if (aVar != null) {
            aVar.a(dVar);
        }
        VasGift04586Report vasGift04586Report = this.V;
        if (vasGift04586Report != null) {
            vasGift04586Report.C0(dVar);
        }
        boolean c36 = c3(dVar);
        this.f311642c0 = this.f311641b0.clone();
        m3(c36 ? 1 : 0);
        k3(this.f311641b0, c36 ? 1 : 0, c36 ? 1 : 0, this.X);
        this.Q.o1(this.f311641b0, c36 ? 1 : 0, c36 ? 1 : 0);
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftPanelViewModel", 2, "[onSendGiftClick] mSelectedGiftID:" + this.P);
        }
    }

    public com.tencent.mobileqq.qqgift.data.service.e T2(int i3) {
        List<com.tencent.mobileqq.qqgift.data.service.e> list;
        String str = "";
        if (this.K.getValue() != null) {
            for (com.tencent.mobileqq.qqgift.mvvm.business.data.c cVar : this.K.getValue()) {
                if (i3 >= cVar.f264968e && i3 <= cVar.f264969f) {
                    str = cVar.f264964a;
                }
            }
        }
        if (!TextUtils.isEmpty(str) && (list = this.f311645f0) != null) {
            for (com.tencent.mobileqq.qqgift.data.service.e eVar : list) {
                if (str.equals(eVar.f264894a)) {
                    return eVar;
                }
            }
            return null;
        }
        return null;
    }

    public MutableLiveData<List<com.tencent.mobileqq.qqgift.mvvm.business.data.c>> U2() {
        return this.K;
    }

    public void U3(com.tencent.mobileqq.qqgift.data.service.a aVar) {
        this.W = aVar;
    }

    public int V2() {
        return this.Y;
    }

    public void V3(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        this.f311646g0 = list;
    }

    public boolean W2(View view) {
        View.OnClickListener onClickListener = this.f311648i0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
            return true;
        }
        return false;
    }

    public boolean c3(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (this.F.getSDKConfig().f264972a != 10011 && this.F.getSDKConfig().f264972a != 10008) {
            if (dVar.F != 0 || dVar.f264883i != 0) {
                return false;
            }
            return true;
        }
        if (dVar.F != 0) {
            return false;
        }
        int i3 = dVar.f264883i;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            return false;
        }
        return true;
    }

    public boolean e3() {
        nh2.c cVar = this.F;
        if (cVar == null || cVar.getSDKConfig() == null) {
            return false;
        }
        int i3 = this.F.getSDKConfig().f264972a;
        if (i3 != 10016 && i3 != 10006) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean f() {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.f();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean h0(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.h0(dVar, i3);
            return false;
        }
        return false;
    }

    public boolean i3() {
        if (this.F != null) {
            return true;
        }
        return false;
    }

    public void m3(int i3) {
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.f311641b0;
        if (dVar != null) {
            dVar.H = this.X;
            dVar.J = i3;
        }
        if (i3 >= 3) {
            r(dVar, 0);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean n1(boolean z16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, String str) {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.n1(z16, dVar, i3, str);
        }
        com.tencent.mobileqq.vasgift.business.dt.a aVar = this.T;
        if (aVar != null) {
            aVar.c(z16, dVar, String.valueOf(i3));
        }
        if (!c3(dVar) && dVar.f264875d0) {
            C3();
            return false;
        }
        return false;
    }

    public void n3(final com.tencent.mobileqq.qqgift.data.service.d dVar, final int i3, final int i16) {
        if (VasToggle.BUG_110903221.isEnable(true)) {
            final long j3 = this.X;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.e
                @Override // java.lang.Runnable
                public final void run() {
                    QQGiftPanelViewModel.this.j3(dVar, i3, i16, j3);
                }
            }, 16, null, false, 1500L);
        } else {
            j3(dVar, i3, i16, this.X);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public void o1(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16) {
        super.o1(dVar, i3, i16);
    }

    /* renamed from: o3, reason: merged with bridge method [inline-methods] */
    public void j3(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j3) {
        String str;
        this.Y = 0;
        this.F.a().w(dVar, 1, j3, i3, i16);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("send_combo:  OverSend , ");
            if (dVar != null) {
                str = dVar.f264876e;
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append(i3);
            sb5.append(",");
            sb5.append(i16);
            QLog.d("QQGiftPanelViewModel", 1, sb5.toString());
        }
        c.d dVar2 = this.R;
        if (dVar2 != null) {
            dVar2.c(dVar, i3, i16, j3);
        }
    }

    public void p3(final int i3, final int i16, boolean z16) {
        com.tencent.mobileqq.qqgift.data.service.d clone;
        if (this.f311649j0) {
            if (!this.f311650k0 || (clone = this.f311642c0) == null) {
                clone = this.f311641b0.clone();
            }
            final com.tencent.mobileqq.qqgift.data.service.d dVar = clone;
            long j3 = dVar.H;
            if (j3 == 0) {
                j3 = this.X;
                QLog.e("QQGiftPanelViewModel", 1, "seq error , giftId: " + dVar.f264874d + ", giftName: " + dVar.f264876e + ",allComboCnt " + i16);
            }
            final long j16 = j3;
            if (z16) {
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGiftPanelViewModel.this.k3(dVar, i3, i16, j16);
                    }
                }, 16, null, false, com.tencent.mobileqq.vasgift.utils.i.b());
                return;
            } else {
                k3(dVar, i3, i16, j16);
                return;
            }
        }
        k3(this.f311641b0, i3, i16, this.X);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean r(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.r(dVar, i3);
            return false;
        }
        return false;
    }

    public void refresh() {
        z3();
        w3();
        y3();
    }

    public void s3(com.tencent.mobileqq.qqgift.data.service.d dVar, View view) {
        this.T.e(dVar, view);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean t() {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.t();
        }
        K3(-1);
        return false;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean u0(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.u0(dVar, i3);
        }
        this.E.postValue(dVar);
        if (dVar == null) {
            return false;
        }
        this.P = dVar.f264874d;
        this.f311641b0 = dVar;
        com.tencent.mobileqq.vasgift.business.dt.a aVar = this.T;
        if (aVar != null) {
            aVar.a(dVar);
        }
        VasGift04586Report vasGift04586Report = this.V;
        if (vasGift04586Report != null) {
            vasGift04586Report.C0(dVar);
        }
        return false;
    }

    public void u2(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftPanelViewModel", 2, "[onRechargeClick] ");
        }
        if (!i3()) {
            return;
        }
        this.F.f().I(this.f311671m.get(), 1, z17, new k(z16));
        VasLogReporter.getVasGift().report("doOnRechargeClick", VasLogReportProxy.LEVEL.HIGHEST);
    }

    public VasGift04586Report v2() {
        return this.V;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.a, sh2.c.f
    public boolean w(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        c.f fVar = this.Q;
        if (fVar != null) {
            fVar.w(dVar, i3);
            return false;
        }
        return false;
    }

    public String w2() {
        return this.F.a().b();
    }

    public long x2() {
        return this.Z;
    }

    public int y2() {
        return this.f311647h0;
    }

    public void P3(c.a aVar) {
    }

    public void l3(long j3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements rh2.a {
        c() {
        }

        @Override // rh2.a
        public void h(long j3, long j16, long j17, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGiftPanelViewModel", 2, "[refreshBalance] " + j3 + ",seq:" + j17);
            }
            if (QQGiftPanelViewModel.this.b3(j17)) {
                QQGiftPanelViewModel.this.T3(j3, j16);
                QQGiftPanelViewModel.this.F.f().d(j3, j16);
                QQGiftPanelViewModel.this.D.postValue(Integer.valueOf(i3));
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
        }
    }

    /* loaded from: classes20.dex */
    class f implements rh2.e {
        f() {
        }

        @Override // rh2.e
        public void onReceive(List<com.tencent.mobileqq.qqgift.data.service.d> list) {
            if (QQGiftPanelViewModel.this.G2().getValue() != null && list != null && !list.isEmpty()) {
                List<List<com.tencent.mobileqq.qqgift.data.service.d>> a16 = QQGiftPanelViewModel.this.G2().getValue().a();
                boolean z16 = false;
                if (a16 != null && !a16.isEmpty()) {
                    Iterator<List<com.tencent.mobileqq.qqgift.data.service.d>> it = a16.iterator();
                    while (it.hasNext()) {
                        if (QQGiftPanelViewModel.this.Z3(it.next(), list)) {
                            z16 = true;
                        }
                    }
                }
                if (z16) {
                    QQGiftPanelViewModel.this.G.postValue(new com.tencent.mobileqq.vasgift.mvvm.business.f(a16));
                }
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class g implements rh2.g {
        g() {
        }

        @Override // rh2.g
        public void onReceive(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
            if (list != null && !list.isEmpty()) {
                QQGiftPanelViewModel.this.a4(list.get(0));
                QQGiftPanelViewModel.this.x3();
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class h implements rh2.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f311658d;

        h(List list) {
            this.f311658d = list;
        }

        @Override // rh2.e
        public void onReceive(List<com.tencent.mobileqq.qqgift.data.service.d> list) {
            if (QQGiftPanelViewModel.this.G2().getValue() != null && list != null && !list.isEmpty()) {
                List a16 = QQGiftPanelViewModel.this.G2().getValue().a();
                boolean z16 = false;
                if (a16 != null && !a16.isEmpty()) {
                    if (this.f311658d.size() != list.size()) {
                        Iterator<com.tencent.mobileqq.qqgift.data.service.d> it = list.iterator();
                        while (it.hasNext()) {
                            this.f311658d.remove(Long.valueOf(String.valueOf(it.next().f264874d)));
                        }
                        if (!this.f311658d.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            List list2 = (List) a16.get(a16.size() - 1);
                            for (Long l3 : this.f311658d) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= list2.size()) {
                                        break;
                                    }
                                    if (((com.tencent.mobileqq.qqgift.data.service.d) list2.get(i3)).f264874d - l3.longValue() == 0) {
                                        arrayList.add((com.tencent.mobileqq.qqgift.data.service.d) list2.get(i3));
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                list2.removeAll(arrayList);
                                a16.set(a16.size() - 1, list2);
                                z16 = true;
                            }
                        }
                    }
                    Iterator it5 = a16.iterator();
                    while (it5.hasNext()) {
                        if (QQGiftPanelViewModel.this.Z3((List) it5.next(), list)) {
                            z16 = true;
                        }
                    }
                }
                if (z16) {
                    QQGiftPanelViewModel.this.G.postValue(new com.tencent.mobileqq.vasgift.mvvm.business.f(a16));
                }
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
        }
    }
}
