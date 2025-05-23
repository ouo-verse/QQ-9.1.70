package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.i;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.observer.b;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TempMsgBoxManagerImpl implements Manager, ITempMsgBoxManager {
    static IPatchRedirector $redirector_ = null;
    public static final String FILTER_SESSION = "_filter_session";
    public static final String FILTER_SESSION_WHITELIST = "_filter_session_whitelist";
    public static final String KEY_MSG_BOX_READ = "key_msg_box_read";
    public static final String MSG_BOX_READ = "_msg_box_read";
    public static final String TAG = "TempMsgBoxManager";
    private AppInterface mApp;
    private final b mFriendListObserver;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TempMsgBoxManagerImpl.this);
            }
        }

        protected void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 59 && z16 && (obj instanceof String)) {
                a((String) obj);
            }
        }
    }

    public TempMsgBoxManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mFriendListObserver = new a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public boolean configContains(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public List<RecentUser> getMsgBoxRecentUsers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        List<RecentUser> recentList = ((IRecentUserProxyService) this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().getRecentList(true, false);
        for (int i3 = 0; i3 < recentList.size(); i3++) {
            RecentUser recentUser = recentList.get(i3);
            if (isBelongToMsgBox(recentUser.uin, recentUser.getType())) {
                arrayList.add(recentUser);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getMsgBoxRecentUsers() called with: outList = [" + arrayList + "]");
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public boolean isBelongToFilterBox(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (!msgBoxSwitch()) {
            return false;
        }
        boolean z16 = this.mApp.getApp().getSharedPreferences(this.mApp.getAccount() + FILTER_SESSION, 0).getBoolean(str, false);
        if (z16 && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "f [" + str + "," + i3 + "]");
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public boolean isBelongToMsgBox(String str, int i3) {
        com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (!msgBoxSwitch()) {
            return false;
        }
        if (isBelongToFilterBox(str, i3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isBelongToMsgBox() called isBelongToFilterBox: uin = [" + str + "], type = [" + i3 + "]");
            }
            return false;
        }
        String str2 = i.c().get(Integer.valueOf(i3));
        if ((str2 != null && (bVar = i.b().get(str2)) != null && bVar.b(this.mApp, i3)) || !configContains(i3)) {
            return false;
        }
        return ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getCallback().d(this.mApp, str, i3);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public boolean isMsgBoxRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean z16 = this.mApp.getApp().getSharedPreferences(this.mApp.getAccount() + MSG_BOX_READ, 0).getBoolean(KEY_MSG_BOX_READ, false);
        QLog.i(TAG, 1, "isMsgBoxRead() boxRead = [" + z16 + "]");
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public boolean msgBoxSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mApp = appInterface;
        appInterface.addObserver(this.mFriendListObserver);
        i.l();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.mApp.removeObserver(this.mFriendListObserver);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public void setMsgBoxRead(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 1, "setMsgBoxRead() called with: read = [" + z16 + "]");
        this.mApp.getApp().getSharedPreferences(this.mApp.getAccount() + MSG_BOX_READ, 0).edit().putBoolean(KEY_MSG_BOX_READ, z16).apply();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
    public void updateIsTop(String str, int i3, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(str, i3);
        if (z16) {
            j3 = System.currentTimeMillis() / 1000;
        } else {
            j3 = 0;
        }
        findRecentUserByUin.showUpTime = j3;
        recentUserCache.saveRecentUser(findRecentUserByUin);
    }

    public TempMsgBoxManagerImpl(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        } else {
            this.mFriendListObserver = new a();
            this.mApp = appInterface;
        }
    }
}
