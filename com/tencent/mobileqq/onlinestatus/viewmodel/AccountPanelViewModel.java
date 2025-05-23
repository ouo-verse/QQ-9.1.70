package com.tencent.mobileqq.onlinestatus.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.api.IDirectLoginService;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.manager.k;
import com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository;
import com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.ai;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class AccountPanelViewModel extends com.tencent.mobileqq.mvvm.c<AccountPanelRepository> {
    private MutableLiveData<Boolean> C;
    private MutableLiveData<Integer> D;
    private MutableLiveData<String> E;
    private MutableLiveData<String> F;
    private MutableLiveData<List<Object>> G;
    private MutableLiveData<com.tencent.mobileqq.onlinestatus.model.j> H;
    private MutableLiveData<com.tencent.mobileqq.onlinestatus.model.g> I;
    private MutableLiveData<SimpleAccount> J;
    private MutableLiveData<Boolean> K;
    private MutableLiveData<Boolean> L;
    private MutableLiveData<Boolean> M;
    private MutableLiveData<Boolean> N;
    private final MutableLiveData<com.tencent.mobileqq.onlinestatus.model.e> P;
    private final MutableLiveData<au> Q;
    private long R;
    private y.d S;
    private String T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f256847a0;

    /* renamed from: b0, reason: collision with root package name */
    private OnlineStatusShareHelper f256848b0;

    /* renamed from: i, reason: collision with root package name */
    public Handler f256849i;

    /* renamed from: m, reason: collision with root package name */
    private SimpleAccount f256850m;

    public AccountPanelViewModel(AccountPanelRepository accountPanelRepository) {
        super(accountPanelRepository);
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        this.I = new MutableLiveData<>();
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>();
        this.L = new MutableLiveData<>();
        this.M = new MutableLiveData<>();
        this.N = new MutableLiveData<>();
        this.P = new MutableLiveData<>();
        this.Q = new MutableLiveData<>();
        this.R = -1L;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = true;
        this.Y = true;
        this.Z = 0;
        this.f256847a0 = true;
        this.f256849i = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G2(au auVar) {
        com.tencent.mobileqq.onlinestatus.model.g value = this.I.getValue();
        if (value == null) {
            return true;
        }
        if (auVar == null) {
            return false;
        }
        if (auVar.f255494g != value.f256022a || auVar.f255489b != value.f256023b) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I2(long j3) {
        if (j3 == 1080) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(int i3) {
        this.K.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2() {
        List<SimpleAccount> allAccounts;
        String currentUin;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        List<ISubAccountApi.f> allSubAccountInfo = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAllSubAccountInfo();
        ArrayList arrayList2 = new ArrayList();
        if (allSubAccountInfo != null && allSubAccountInfo.size() > 0) {
            for (ISubAccountApi.f fVar : allSubAccountInfo) {
                if (fVar != null && !TextUtils.isEmpty(fVar.a())) {
                    arrayList.add(fVar);
                    arrayList2.add(fVar.a());
                }
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            allAccounts = null;
        } else {
            allAccounts = peekAppRuntime.getApplication().getAllAccounts();
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (allAccounts != null) {
            arrayList3.addAll(allAccounts);
        }
        if (arrayList3.size() > 0) {
            Iterator it = arrayList3.iterator();
            if (peekAppRuntime == null) {
                currentUin = "";
            } else {
                currentUin = peekAppRuntime.getCurrentUin();
            }
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (arrayList2.size() >= 7) {
                    QLog.d("AccountPanelViewModel", 1, "add account exceed the limit");
                    break;
                }
                SimpleAccount simpleAccount = (SimpleAccount) it.next();
                if (!TextUtils.isEmpty(simpleAccount.getUin()) && !simpleAccount.getUin().equals(currentUin)) {
                    Iterator it5 = arrayList2.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            if (simpleAccount.getUin().equals((String) it5.next())) {
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        arrayList.add(simpleAccount);
                        arrayList4.add(simpleAccount.getUin());
                    }
                }
            }
        } else {
            QLog.d("AccountPanelViewModel", 1, "localAccountList is empty");
        }
        this.G.postValue(arrayList);
        QLog.d("AccountPanelViewModel", 1, "updateAccountList subAccountUinList:" + arrayList2 + ", localAccountUinList:" + arrayList4);
    }

    private void a3(AppInterface appInterface, String str, String str2) {
        QLog.d("AccountPanelViewModel", 2, str + str2);
        ReportController.o(appInterface, "dc00898", "", "", "0X800BDED", "0X800BDED", 0, 0, str2, "0", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t2(AppInterface appInterface) {
        int size = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAllSubAccountInfo().size();
        List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
        if (allAccounts != null && allAccounts.size() > 0) {
            size++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, "getRequestNum: " + size);
        }
        return size;
    }

    public MutableLiveData<Boolean> A2() {
        return this.K;
    }

    public void B2(QBaseActivity qBaseActivity, AppInterface appInterface) {
        if (Utils.F()) {
            QQToast.makeText(qBaseActivity, R.string.c6a, 0).show();
            return;
        }
        if (((IPwdSetUtilApi) QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(qBaseActivity)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("IS_ADD_ACCOUNT", true);
        intent.putExtra("key_login_page_title", qBaseActivity.getString(R.string.f199974qv));
        intent.putExtra("key_login_page_entrance", 3);
        intent.putExtra("loginFragmentType", 5);
        ai.a(qBaseActivity, intent, RouterConstants.UI_ROUTER_LOGIN);
        ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(appInterface, qBaseActivity);
        ReportController.o(appInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
        bv.a("0X800AF3B");
    }

    public void C2(ISubAccountApi.f fVar, AppInterface appInterface, QBaseActivity qBaseActivity) {
        String str;
        if (fVar != null) {
            List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
            ArrayList<SimpleAccount> arrayList = new ArrayList();
            if (allAccounts != null) {
                arrayList.addAll(allAccounts);
            }
            if (arrayList.size() > 0) {
                for (SimpleAccount simpleAccount : arrayList) {
                    if (TextUtils.equals(simpleAccount.getUin(), fVar.a())) {
                        break;
                    }
                }
            }
        }
        simpleAccount = null;
        if (simpleAccount != null) {
            D2(qBaseActivity, simpleAccount, MobileQQ.sMobileQQ.peekAppRuntime());
            str = simpleAccount.getUin();
        } else if (fVar != null) {
            qBaseActivity.sendBroadcast(new Intent("before_account_change"));
            Intent intent = new Intent();
            intent.putExtra("subAccount", fVar.a());
            qBaseActivity.startActivity(intent);
            ai.a(qBaseActivity, intent, RouterConstants.UI_ROUTER_SUBACCOUNT_UG);
            str = fVar.a();
        } else {
            str = "";
        }
        ReportController.o(appInterface, "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, str, "", "", "");
        ReportController.o(appInterface, "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        bv.a("0X800AF3A");
        a3(appInterface, "handleSubAccountClick AccountPanelViewModel-subAccountClick ", "1");
    }

    public void D2(QBaseActivity qBaseActivity, final SimpleAccount simpleAccount, final AppRuntime appRuntime) {
        ISubAccountApi.g unreadCount = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getUnreadCount(simpleAccount.getUin());
        if (unreadCount.a() > 0 && !unreadCount.isShowRedDot()) {
            this.f256850m = simpleAccount;
        } else {
            i3(qBaseActivity, simpleAccount);
        }
        if (unreadCount.a() > 0) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.1
                @Override // java.lang.Runnable
                public void run() {
                    ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).setReaded(simpleAccount.getUin(), 7000);
                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanOneSubAccountMessageUnread((AppInterface) appRuntime, false, null, simpleAccount.getUin());
                }
            });
        }
    }

    public void E2(QBaseActivity qBaseActivity, SimpleAccount simpleAccount, AppInterface appInterface) {
        String str;
        F2(qBaseActivity, simpleAccount, appInterface);
        if (simpleAccount != null) {
            str = simpleAccount.getUin();
        } else {
            str = "";
        }
        ReportController.o(appInterface, "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, str, "", "", "");
        ReportController.o(appInterface, "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
        bv.a("0X800AF3A");
        a3(appInterface, "handleThirdAccountClick AccountPanelViewModel-thirdAccountClick ", "2");
    }

    public boolean F2(QBaseActivity qBaseActivity, SimpleAccount simpleAccount, AppRuntime appRuntime) {
        if (simpleAccount != null && ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanThirdQQUnreadMsgNum((AppInterface) appRuntime, simpleAccount)) {
            i3(qBaseActivity, simpleAccount);
            return true;
        }
        return false;
    }

    public void H2() {
        ((AccountPanelRepository) this.mRepository).G();
    }

    public void L2() {
        y.d dVar = this.S;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void M2(Activity activity) {
        if (u.a().b()) {
            return;
        }
        if (this.f256848b0 == null) {
            OnlineStatusShareHelper onlineStatusShareHelper = new OnlineStatusShareHelper(activity);
            onlineStatusShareHelper.P(new OnlineStatusShareHelper.b() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.b
                @Override // com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper.b
                public final void a(int i3) {
                    AccountPanelViewModel.this.J2(i3);
                }
            });
            this.f256848b0 = onlineStatusShareHelper;
        }
        this.f256848b0.W(this.I.getValue());
    }

    public void N2(final boolean z16, final AppInterface appInterface, final AppRuntime.Status status) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                if (z16) {
                    au N = af.C().N();
                    long M = af.C().M(appInterface);
                    if (AccountPanelViewModel.this.R == 1000 && M == 1000) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (z17 && AccountPanelViewModel.this.Y) {
                        QQToast.makeText(MobileQQ.sMobileQQ, 2, MobileQQ.sMobileQQ.getResources().getString(R.string.f69, af.C().P(M, status)), 1).show();
                        if (QLog.isColorLevel()) {
                            QLog.d("AccountPanelViewModel", 2, "Show toast in account panel mAccountObserver");
                        }
                    }
                    AccountPanelViewModel.this.l3();
                    ((k) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)).B(AccountPanelViewModel.this.R, M);
                    if (N.B != 0 && AccountPanelViewModel.this.G2(N)) {
                        AccountPanelViewModel.this.Q.setValue(N);
                    }
                    AccountPanelViewModel.this.K.setValue(Boolean.TRUE);
                    AccountPanelViewModel.this.R = M;
                    return;
                }
                AccountPanelViewModel.this.K.setValue(Boolean.TRUE);
                QQToast.makeText(MobileQQ.sMobileQQ, 1, R.string.f65, 1).show();
            }
        });
    }

    public void O2(AppRuntime.Status status, long j3) {
        au I = af.C().I(status, j3);
        if (I.B != 0 && G2(I)) {
            this.Q.setValue(I);
        }
        this.K.setValue(Boolean.TRUE);
        this.R = j3;
    }

    public void P2(boolean z16, Bundle bundle) {
        int i3;
        if (this.Y && bundle != null) {
            boolean z17 = bundle.getBoolean("param_need_switch_online_status", false);
            if (z16) {
                k3(AppRuntime.Status.online, bundle.getInt("StatusId", 0), false);
                if (!z17) {
                    QQToast.makeText(MobileQQ.sMobileQQ, 2, R.string.zpo, 1).show();
                    this.K.setValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            if (z17) {
                i3 = R.string.f65;
            } else {
                i3 = R.string.zpp;
            }
            QQToast.makeText(MobileQQ.sMobileQQ, 1, i3, 1).show();
            this.K.setValue(Boolean.TRUE);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(this.Y));
        }
    }

    public void Q2(boolean z16, Bundle bundle, AppInterface appInterface) {
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(appInterface);
        if (z16 && onlineStatus == AppRuntime.Status.online && M == 1030) {
            U2(onlineStatus);
            this.K.setValue(Boolean.TRUE);
        }
    }

    public void R2(boolean z16, Bundle bundle) {
        int i3;
        if (!this.Y) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelViewModel", 2, "onSetExtInfo: no needShowOnlineStatusToast ");
                return;
            }
            return;
        }
        boolean z17 = bundle.getBoolean("from_register", false);
        boolean z18 = bundle.getBoolean("from_modify", false);
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, "onSetExtInfo: invoked. ", " isFromRegister: ", Boolean.valueOf(z17), " isFromModify=", Boolean.valueOf(z18));
        }
        if (z16) {
            int i16 = bundle.getInt("StatusId");
            k3(AppRuntime.Status.online, i16, false);
            if (z18) {
                QQToast.makeText(MobileQQ.sMobileQQ, 2, R.string.zpo, 1).show();
                this.K.setValue(Boolean.TRUE);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelViewModel", 2, "onSetExtInfo: invoked. ", " statusId: ", Integer.valueOf(i16));
                return;
            }
            return;
        }
        if (z17) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelViewModel", 2, "onSetExtInfo: invoked. isFromRegister ");
            }
        } else {
            if (z18) {
                i3 = R.string.zpp;
            } else {
                i3 = R.string.f65;
            }
            QQToast.makeText(MobileQQ.sMobileQQ, 1, i3, 1).show();
            this.K.setValue(Boolean.TRUE);
        }
    }

    public void S2(final boolean z16, Bundle bundle, AppRuntime.Status status, final AppInterface appInterface) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.4
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    au N = af.C().N();
                    long M = af.C().M(appInterface);
                    if (!AccountPanelViewModel.this.X) {
                        AccountPanelViewModel.this.X = true;
                        if (M == 40001) {
                            AutoStatusHintFragment.ph(MobileQQ.sMobileQQ);
                        }
                    }
                    ((k) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)).B(AccountPanelViewModel.this.R, M);
                    if (N.B != 0 && AccountPanelViewModel.this.G2(N)) {
                        AccountPanelViewModel.this.Q.setValue(N);
                    }
                    MutableLiveData mutableLiveData = AccountPanelViewModel.this.K;
                    Boolean bool = Boolean.TRUE;
                    mutableLiveData.setValue(bool);
                    if (AccountPanelViewModel.this.I2(M)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AccountPanelViewModel", 2, "onSetOnlineStatus update olympic status");
                        }
                        AccountPanelViewModel.this.L.setValue(bool);
                    }
                    AccountPanelViewModel.this.R = M;
                    AccountPanelViewModel.this.N.setValue(bool);
                    if (AccountPanelViewModel.this.f256847a0) {
                        AccountPanelViewModel.this.r2();
                        return;
                    }
                    return;
                }
                AccountPanelViewModel.this.K.setValue(Boolean.TRUE);
                AccountPanelViewModel.this.N.setValue(Boolean.FALSE);
                QQToast.makeText(MobileQQ.sMobileQQ, 1, R.string.f65, 1).show();
            }
        });
    }

    public void T2(boolean z16, Bundle bundle) {
        if (z16) {
            com.tencent.mobileqq.onlinestatus.model.g value = this.I.getValue();
            k3(value.f256022a, value.f256023b, false);
        }
    }

    public void U2(AppRuntime.Status status) {
        y.d dVar = this.S;
        if (dVar != null) {
            dVar.b(status);
        }
    }

    public void V2(boolean z16, String str, String str2) {
        if (!TextUtils.isEmpty(str) && this.f256850m != null) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("AccountPanel onSubAccountMsgNumConfirm isSuccess=");
                sb5.append(z16);
                sb5.append(" subUin=");
                sb5.append(str);
                sb5.append(" set need2ConfirmMsgNum=");
                sb5.append(!z16);
                sb5.append(" nextAction=");
                sb5.append(str2);
                QLog.d("AccountPanelViewModel", 2, sb5.toString());
            }
            if (OnlineStatusToggleUtils.e() && QLog.isDevelopLevel()) {
                QLog.i("AccountPanelViewModel", 1, "switchAccount " + QLog.getStackTraceString(new Throwable()));
            }
            if (str.equals(this.f256850m.getUin())) {
                this.J.setValue(this.f256850m);
            }
            this.f256850m = null;
        }
    }

    public void W2(pc2.a aVar) {
        MutableLiveData<Boolean> mutableLiveData = this.K;
        Boolean bool = Boolean.TRUE;
        mutableLiveData.setValue(bool);
        this.M.setValue(bool);
    }

    public void Y2(boolean z16) {
        ((AccountPanelRepository) this.mRepository).O(z16);
    }

    public void b3() {
        p2().setValue(Boolean.FALSE);
        y2().setValue(null);
        k2().setValue(null);
        o2().setValue(null);
        m2().setValue(null);
        j2().setValue(null);
        x2().setValue(null);
        l2().setValue(null);
        y2().setValue(null);
        A2().setValue(null);
        u2().setValue(null);
        q2().setValue(null);
        v2().setValue(null);
        s2().setValue(null);
        n2().setValue(null);
    }

    public void c3(boolean z16) {
        this.X = z16;
    }

    public void d3(long j3) {
        this.R = j3;
    }

    public void e3(boolean z16) {
        this.Y = z16;
    }

    public void f2() {
        ((AccountPanelRepository) this.mRepository).u();
    }

    public void f3(y.d dVar) {
        this.S = dVar;
    }

    public void g2(com.tencent.mobileqq.mvvm.d dVar) {
        p2().removeObservers(dVar);
        k2().removeObservers(dVar);
        o2().removeObservers(dVar);
        m2().removeObservers(dVar);
        j2().removeObservers(dVar);
        x2().removeObservers(dVar);
        l2().removeObservers(dVar);
        y2().removeObservers(dVar);
        A2().removeObservers(dVar);
        u2().removeObservers(dVar);
        q2().removeObservers(dVar);
        v2().removeObservers(dVar);
        s2().removeObservers(dVar);
        n2().removeObservers(dVar);
        f3(null);
    }

    public void g3(String str) {
        this.T = str;
    }

    public void h2(boolean z16) {
        ((AccountPanelRepository) this.mRepository).x();
        OnlineStatusShareHelper onlineStatusShareHelper = this.f256848b0;
        if (onlineStatusShareHelper != null) {
            onlineStatusShareHelper.K();
            this.f256848b0 = null;
        }
    }

    public void h3(boolean z16) {
        this.f256847a0 = z16;
    }

    public void i2(final QBaseActivity qBaseActivity, final AppInterface appInterface) {
        this.f256849i.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                if (qBaseActivity != null && appInterface != null) {
                    AccountPanelViewModel.this.V = true;
                    AccountPanelViewModel.this.W = false;
                    AccountPanelViewModel accountPanelViewModel = AccountPanelViewModel.this;
                    accountPanelViewModel.U = accountPanelViewModel.t2(appInterface);
                    ISubAccountApi iSubAccountApi = (ISubAccountApi) QRoute.api(ISubAccountApi.class);
                    iSubAccountApi.startAllSubMessageAccountMsg(false);
                    iSubAccountApi.startGetThirdQQUnreadNum(false);
                }
            }
        });
    }

    public void i3(QBaseActivity qBaseActivity, SimpleAccount simpleAccount) {
        if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
            QQToast.makeText(qBaseActivity, qBaseActivity.getString(R.string.b3j), 0).show(qBaseActivity.getTitleBarHeight());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, "switchAccount toAccount=" + simpleAccount);
        }
        this.T = simpleAccount.getUin();
        if (simpleAccount.isLogined()) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginStart(17, 8, simpleAccount.getUin());
        }
        qBaseActivity.sendBroadcast(new Intent("before_account_change"));
        ((IDirectLoginService) QRoute.api(IDirectLoginService.class)).switchAccount(simpleAccount.getUin(), null);
        if (OnlineStatusToggleUtils.e() && QLog.isDevelopLevel()) {
            QLog.i("AccountPanelViewModel", 1, "switchAccount real " + QLog.getStackTraceString(new Throwable()));
        }
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(simpleAccount.getUin(), (byte) 0);
        ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), qBaseActivity);
        com.tencent.mobileqq.onlinestatus.utils.b.a();
    }

    public MutableLiveData<List<Object>> j2() {
        return this.G;
    }

    public void j3(AppRuntime.Status status, long j3, boolean z16, DiyStatusEmoInfo diyStatusEmoInfo) {
        if (status != null) {
            this.I.setValue(new com.tencent.mobileqq.onlinestatus.model.g(status, j3));
            if (z16) {
                ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateDiyOnlineStatus(status, j3, diyStatusEmoInfo);
            }
            U2(status);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, String.format("switchOnlineStatus %s", status));
        }
    }

    public MutableLiveData<Integer> k2() {
        return this.D;
    }

    public void k3(AppRuntime.Status status, long j3, boolean z16) {
        if (status != null) {
            this.I.setValue(new com.tencent.mobileqq.onlinestatus.model.g(status, j3));
            if (z16) {
                ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(status, j3);
            }
            U2(status);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, String.format("switchOnlineStatus %s", status));
        }
    }

    public MutableLiveData<com.tencent.mobileqq.onlinestatus.model.g> l2() {
        return this.I;
    }

    public void l3() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.c
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelViewModel.this.K2();
            }
        }, 16, null, true);
    }

    public MutableLiveData<String> m2() {
        return this.F;
    }

    public void m3(boolean z16, String str, boolean z17) {
        if (this.V) {
            if (z16) {
                this.W = true;
            }
            int i3 = this.U;
            if (i3 > 0) {
                this.U = i3 - 1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelViewModel", 2, " mRequestNum=", Integer.valueOf(this.U), " subAccountMsgComing=", Boolean.valueOf(z17));
            }
            if (this.U == 0) {
                this.V = false;
                if (this.W) {
                    l3();
                    return;
                }
                return;
            }
            return;
        }
        if (z16) {
            this.H.setValue(new com.tencent.mobileqq.onlinestatus.model.j(z16, str, z17));
        }
    }

    public MutableLiveData<au> n2() {
        return this.Q;
    }

    public void n3(int i3) {
        if (i3 != this.Z) {
            this.Z = i3;
            ((AccountPanelRepository) this.mRepository).D();
        }
    }

    public MutableLiveData<String> o2() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Handler handler = this.f256849i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public MutableLiveData<Boolean> p2() {
        return this.C;
    }

    public MutableLiveData<Boolean> q2() {
        return this.M;
    }

    public void r2() {
        if (this.f256847a0) {
            ((AccountPanelRepository) this.mRepository).D();
        } else {
            ((AccountPanelRepository) this.mRepository).C();
        }
    }

    public MutableLiveData<com.tencent.mobileqq.onlinestatus.model.e> s2() {
        return this.P;
    }

    public MutableLiveData<Boolean> u2() {
        return this.L;
    }

    public MutableLiveData<Boolean> v2() {
        return this.N;
    }

    public int w2() {
        return this.Z;
    }

    public MutableLiveData<com.tencent.mobileqq.onlinestatus.model.j> x2() {
        return this.H;
    }

    public MutableLiveData<SimpleAccount> y2() {
        return this.J;
    }

    public String z2() {
        return this.T;
    }
}
