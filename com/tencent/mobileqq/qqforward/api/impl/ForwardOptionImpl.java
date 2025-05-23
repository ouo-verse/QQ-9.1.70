package com.tencent.mobileqq.qqforward.api.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqforward.api.RecentUserBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ForwardOptionImpl implements IForwardOption {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ForwardOption";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f264386a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqforward.api.RecentContactListener f264387b;

        a(AppRuntime appRuntime, com.tencent.mobileqq.qqforward.api.RecentContactListener recentContactListener) {
            this.f264386a = appRuntime;
            this.f264387b = recentContactListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardOptionImpl.this, appRuntime, recentContactListener);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NonNull List<RecentUser> list) {
            String g16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                if (list != null) {
                    TroopManager troopManager = null;
                    for (RecentUser recentUser : list) {
                        int i3 = recentUser.type;
                        RecentUserBean recentUserBean = new RecentUserBean();
                        if (i3 == 1) {
                            g16 = recentUser.displayName;
                            if (troopManager == null) {
                                try {
                                    troopManager = (TroopManager) this.f264386a.getManager(QQManagerFactory.TROOP_MANAGER);
                                } catch (Exception e16) {
                                    QLog.e(ForwardOptionImpl.TAG, 1, "get troop name failed:", e16);
                                }
                            }
                            g16 = troopManager.k(recentUser.uin).getTroopDisplayName();
                            recentUserBean.setTroopUin(recentUser.troopUin);
                        } else {
                            g16 = ac.g(this.f264386a, recentUser.uin, true);
                        }
                        recentUserBean.setUin(recentUser.uin);
                        recentUserBean.setDisplayName(g16);
                        recentUserBean.setType(recentUser.type);
                        arrayList.add(recentUserBean);
                    }
                } else {
                    QLog.e(ForwardOptionImpl.TAG, 1, "getForwardRecentList error, recentUsers is null");
                }
            } catch (Exception e17) {
                QLog.e(ForwardOptionImpl.TAG, 1, "getForwardRecentList:" + e17.getMessage());
            }
            if (this.f264387b != null) {
                QLog.i(ForwardOptionImpl.TAG, 1, "getForwardRecentList success, result.size = " + arrayList.size());
                this.f264387b.onResult(arrayList);
            }
        }
    }

    public ForwardOptionImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqforward.api.IForwardOption
    public void getForwardRecentList(com.tencent.mobileqq.qqforward.api.RecentContactListener recentContactListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recentContactListener);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof BaseQQAppInterface)) {
            ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(peekAppRuntime, new a(peekAppRuntime, recentContactListener), false);
        } else {
            QLog.e(TAG, 1, "getForwardRecentList error, appRuntime is null");
        }
    }

    @Override // com.tencent.mobileqq.qqforward.api.IForwardOption
    public void startForwardActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            ForwardBaseOption.startForwardActivityForResult(activity, intent, i3);
        } else {
            iPatchRedirector.redirect((short) 2, this, activity, intent, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqforward.api.IForwardOption
    public void startForwardActivityForResult(Activity activity, Intent intent, Class<?> cls, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            ForwardBaseOption.startForwardActivityForResult(activity, intent, cls, i3);
        } else {
            iPatchRedirector.redirect((short) 3, this, activity, intent, cls, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqforward.api.IForwardOption
    public void startForwardActivityForResult(Activity activity, Intent intent, Class<?> cls, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            ForwardBaseOption.startForwardActivityForResult(activity, intent, cls, i3, i16, str);
        } else {
            iPatchRedirector.redirect((short) 4, this, activity, intent, cls, Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
    }
}
