package com.tencent.mobileqq.applets;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "AppletsObserver";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void onAppletsSettingSwitchChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    protected void onGetAppletsDetail(boolean z16, List<AppletsAccountInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), list);
        }
    }

    protected void onGetAppletsPushUnreadInfo(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, obj);
        }
    }

    protected void onGetAppletsSettingSwitch(boolean z16, List<com.tencent.mobileqq.applets.data.a> list) {
        AppletsFolderManager appletsFolderManager;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetAppletsSettingSwitch:  isSuccess: " + z16);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            appletsFolderManager = (AppletsFolderManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
        } else {
            appletsFolderManager = null;
        }
        if (appletsFolderManager == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        if (list != null && z16 && list.size() > 0) {
            for (com.tencent.mobileqq.applets.data.a aVar : list) {
                List<AppletItem> list2 = aVar.f196768b;
                if (list2 != null && list2.size() > 0 && aVar.f196768b.get(0) != null && aVar.f196768b.get(0).b() == 1) {
                    AppletItem appletItem = aVar.f196768b.get(0);
                    if (appletItem.e() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    b.c(z17);
                    onAppletsSettingSwitchChange(appletItem.e());
                } else {
                    List<AppletItem> list3 = aVar.f196768b;
                    if (list3 != null && list3.size() > 0) {
                        for (AppletItem appletItem2 : aVar.f196768b) {
                            if (appletItem2.b() != 1 && appletItem2.e() != 1) {
                                hashSet.add(String.valueOf(appletItem2.b()));
                            }
                        }
                    }
                }
            }
        }
        appletsFolderManager.B(hashSet);
    }

    protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
        }
    }

    protected void onSetAppletsSettingSwitch(boolean z16, List<AppletItem> list) {
        AppletsFolderManager appletsFolderManager;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSetAppletsSettingSwitch:  isSuccess: " + z16);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            appletsFolderManager = (AppletsFolderManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
        } else {
            appletsFolderManager = null;
        }
        if (appletsFolderManager != null && list != null && z16) {
            for (AppletItem appletItem : list) {
                int e16 = appletItem.e();
                if (appletItem.b() == 1) {
                    if (e16 == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    b.c(z17);
                    onAppletsSettingSwitchChange(e16);
                } else if (e16 == 0) {
                    appletsFolderManager.g(String.valueOf(appletItem.b()));
                } else {
                    appletsFolderManager.t(String.valueOf(appletItem.b()));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 8) {
                        if (i3 == 9) {
                            onGetAppletsPushUnreadInfo(obj);
                            return;
                        }
                        return;
                    }
                    onReceiveAppletsMessageUnreadInfo((Map) obj);
                    return;
                }
                onSetAppletsSettingSwitch(z16, (List) obj);
                return;
            }
            onGetAppletsSettingSwitch(z16, (List) obj);
            return;
        }
        onGetAppletsDetail(z16, (List) obj);
    }
}
