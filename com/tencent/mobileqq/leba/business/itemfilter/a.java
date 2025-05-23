package com.tencent.mobileqq.leba.business.itemfilter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.leba.business.c;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b() {
        return ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).shouldHideSmallHomeEntry();
    }

    private boolean c(n nVar) {
        LebaPluginInfo lebaPluginInfo = nVar.f240505b;
        if (lebaPluginInfo == null) {
            return false;
        }
        if (777 == lebaPluginInfo.uiResId) {
            QLog.d("LebaSpecificListFilterImpl", 1, "filter Gray is true, no show, " + nVar.f240505b.uiResId);
            return true;
        }
        if (!nVar.f240505b.getChannelName(AppSetting.g().toLowerCase())) {
            return false;
        }
        QLog.d("LebaSpecificListFilterImpl", 1, "filter Channel Plugin is true, no show, " + nVar.f240505b.uiResId);
        return true;
    }

    @Override // com.tencent.mobileqq.leba.business.c
    public boolean a(n nVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar)).booleanValue();
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (nVar.f240505b.uiResId == 905) {
            return true;
        }
        if ((b() && nVar.f240505b.uiResId == 4040) || c(nVar)) {
            return true;
        }
        if (nVar.f240505b.uiResId == 6282) {
            if (runtime instanceof QQAppInterface) {
                z16 = ((QQAppInterface) runtime).getNowLiveManager().c();
            } else {
                z16 = false;
            }
            if (!z16) {
                return true;
            }
        }
        if (!(runtime instanceof QQAppInterface) || !d((QQAppInterface) runtime, nVar.f240505b.uiResId)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.LEBA_MGR, 2, "getLebaMgrList, " + nVar.f240505b.uiResId + " is filtered");
        }
        return true;
    }

    public boolean d(QQAppInterface qQAppInterface, long j3) {
        boolean matchFriendEntrance;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, qQAppInterface, Long.valueOf(j3))).booleanValue();
        }
        if (qQAppInterface == null) {
            return true;
        }
        QLog.d("LebaSpecificListFilterImpl", 2, "filterPlugin " + j3);
        if (7720 == j3) {
            matchFriendEntrance = ((e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).W(qQAppInterface);
        } else {
            if (7759 == j3) {
                ConfessConfig h16 = ((ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).h();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("filterPlugin config: ");
                if (h16 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(h16.f202075s);
                }
                sb5.append(valueOf);
                QLog.d("LebaSpecificListFilterImpl", 2, sb5.toString());
                if (h16 != null && h16.f202075s >= 1) {
                    return false;
                }
            } else if (7719 != j3) {
                if (4050 == j3) {
                    matchFriendEntrance = ((INearbyProEntryService) qQAppInterface.getRuntimeService(INearbyProEntryService.class, "")).isShowNearbyProEntry();
                } else {
                    if (4038 != j3) {
                        return false;
                    }
                    matchFriendEntrance = ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getMatchFriendEntrance(qQAppInterface);
                    QLog.i("LebaSpecificListFilterImpl", 1, "PLUGIN_MATCH_FRIEND canShow:" + matchFriendEntrance);
                }
            }
            return true;
        }
        return !matchFriendEntrance;
    }
}
