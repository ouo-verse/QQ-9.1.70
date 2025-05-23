package com.tencent.mobileqq.account.repository;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.account.bean.DeleteAccount;
import com.tencent.mobileqq.account.bean.QQAccount;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<QQAccount> f174509a;

    /* renamed from: b, reason: collision with root package name */
    private MutableLiveData<List<QQAccount>> f174510b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.loginregister.a f174511c;

    public c(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f174511c = new com.tencent.mobileqq.loginregister.a() { // from class: com.tencent.mobileqq.account.repository.b
                @Override // com.tencent.mobileqq.loginregister.a
                public final void accountChange() {
                    c.this.p();
                }
            };
            s();
        }
    }

    private List<QQAccount> l() {
        QLog.i("AccountListRepository", 2, "build account list by local login and associate");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (simpleAccount != null) {
                    QQAccount m3 = m(simpleAccount);
                    if (!TextUtils.isEmpty(m3.getUin()) && !hashSet.contains(m3.getUin())) {
                        arrayList.add(m3);
                        hashSet.add(m3.getUin());
                    }
                }
            }
        }
        return arrayList;
    }

    private QQAccount m(SimpleAccount simpleAccount) {
        String c16;
        QQAccount qQAccount = new QQAccount();
        qQAccount.setType(1);
        qQAccount.setUin(simpleAccount.getUin());
        qQAccount.setMaskedUin(com.tencent.mobileqq.account.utils.a.b(simpleAccount.getUin()));
        d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(simpleAccount.getUin()), "AccountListRepository");
        if (friendsSimpleInfoWithUid != null && !TextUtils.isEmpty(friendsSimpleInfoWithUid.p())) {
            c16 = friendsSimpleInfoWithUid.p();
        } else {
            c16 = com.tencent.mobileqq.login.account.b.c(qQAccount.getUin());
        }
        if (TextUtils.isEmpty(c16)) {
            c16 = qQAccount.getUin();
        }
        qQAccount.setNickname(c16);
        return qQAccount;
    }

    private void o(List<QQAccount> list) {
        boolean z16;
        if (list == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        List<DeleteAccount> b16 = a.c().b();
        if (b16 != null) {
            for (DeleteAccount deleteAccount : b16) {
                if (!TextUtils.isEmpty(deleteAccount.getUin())) {
                    hashSet.add(deleteAccount.getUin());
                }
                if (!TextUtils.isEmpty(deleteAccount.getId())) {
                    hashSet2.add(deleteAccount.getId());
                }
            }
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            QQAccount qQAccount = list.get(size);
            if (TextUtils.isEmpty(qQAccount.getUin()) || com.tencent.mobileqq.account.utils.a.c(qQAccount.getUin()) == null) {
                boolean z17 = false;
                if (!TextUtils.isEmpty(qQAccount.getUin()) && hashSet.contains(qQAccount.getUin())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!TextUtils.isEmpty(qQAccount.getId()) && hashSet2.contains(qQAccount.getId())) {
                    z17 = true;
                }
                if (z16 || z17) {
                    list.remove(size);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        QLog.d("AccountListRepository", 1, "account list changed!");
        v();
    }

    private void r(List<QQAccount> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (QQAccount qQAccount : list) {
                sb5.append("{type=");
                sb5.append(qQAccount.getType());
                if (!TextUtils.isEmpty(qQAccount.getUin())) {
                    sb5.append(",uin=");
                    sb5.append(StringUtil.getSimpleUinForPrint(qQAccount.getUin()));
                } else {
                    sb5.append(",id=");
                    sb5.append(qQAccount.getId());
                }
                sb5.append("} ");
            }
        }
        QLog.i("AccountListRepository", 2, "fetchAccountListFromCache accounts = " + sb5.toString());
    }

    private void s() {
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).registerAccountListChangeObserver(this.f174511c);
    }

    private void u() {
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).removeAccountListChangeObserver(this.f174511c);
    }

    private void v() {
        List<QQAccount> l3 = l();
        o(l3);
        r(l3);
        if (!com.tencent.mobileqq.account.utils.a.d(this.f174509a, l3)) {
            QLog.i("AccountListRepository", 2, "account list data is not changed, don't post livedata");
            return;
        }
        if (l3.size() > 9) {
            l3 = l3.subList(0, 9);
        }
        this.f174509a = l3;
        MutableLiveData<List<QQAccount>> mutableLiveData = this.f174510b;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(l3);
        }
    }

    public void k(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            a.c().a(str, str2);
            v();
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.i("AccountListRepository", 2, "fetchAccountList");
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            u();
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            MobileQQ.sMobileQQ.peekAppRuntime();
            s();
        }
    }

    public void t(MutableLiveData<List<QQAccount>> mutableLiveData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mutableLiveData);
        } else {
            this.f174510b = mutableLiveData;
        }
    }
}
