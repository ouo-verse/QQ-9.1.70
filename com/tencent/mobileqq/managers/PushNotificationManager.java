package com.tencent.mobileqq.managers;

import android.text.TextUtils;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.config.business.ax;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;

/* loaded from: classes15.dex */
public class PushNotificationManager implements Manager {
    static IPatchRedirector $redirector_;
    public static int D;
    public static int E;
    public static int F;
    private List<Long> C;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f243666d;

    /* renamed from: e, reason: collision with root package name */
    private int f243667e;

    /* renamed from: f, reason: collision with root package name */
    private long f243668f;

    /* renamed from: h, reason: collision with root package name */
    private EntityManager f243669h;

    /* renamed from: i, reason: collision with root package name */
    private ax f243670i;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f243671m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        D = 1;
        E = 1;
        F = 2;
    }

    public PushNotificationManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243667e = -1;
        this.f243668f = 0L;
        this.f243671m = Boolean.TRUE;
        this.C = null;
        this.f243666d = qQAppInterface;
        this.f243669h = qQAppInterface.getEntityManagerFactory().createEntityManager();
        ThreadManagerV2.executeOnSubThread(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.managers.PushNotificationManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f243672d;

            {
                this.f243672d = qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PushNotificationManager.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                PushNotificationManager.this.f243670i = (ax) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101126");
                MsgNotifyPushDialog.Y(this.f243672d);
            }
        });
        this.f243671m = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("push_notification_graytip_887224637", true));
    }

    private void b(AIOSession aIOSession, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        int e16 = aIOSession.c().e();
        if (e16 == 2) {
            return;
        }
        if (e16 != 1) {
            str = "";
            str2 = str;
        } else {
            str = d().b();
            str2 = d().a();
        }
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            str2 = "";
            str3 = str2;
            str4 = str;
        } else {
            str4 = str.substring(0, indexOf);
            str3 = str.substring(indexOf + str2.length());
        }
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(this.f243666d, new LocalGrayTip.LocalGrayTipBuilder(aIOSession.c().j(), aIOSession.c().e(), 2701L, 1, true, false, null).g(str4, 1).h(str2, new com.tencent.mobileqq.managers.PushNotification.a(), 3).g(str3, 1).m(), null);
        ReportController.o(null, "dc00898", "", "", "0X8009ACE", "0X8009ACE", i3, i3, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("PushNotificationManager", 2, "add gray tip =" + str + " fromType=" + i3);
        }
    }

    private boolean c(AIOSession aIOSession) {
        if (aIOSession == null) {
            return false;
        }
        if (aIOSession.c().e() != 2) {
            return true;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(aIOSession.c().j());
        if (troopInfoFromCache == null || f(troopInfoFromCache.dwGroupClassExt)) {
            return false;
        }
        return true;
    }

    private int e() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (this.f243667e >= 0 && valueOf.longValue() - this.f243668f < 86400000) {
            if (QLog.isColorLevel()) {
                QLog.d("PushNotificationManager", 2, "mTodayHadShowCount=" + this.f243667e + " mTodayZeroTimeMillis=" + this.f243668f);
            }
        } else {
            if (this.f243668f == 0) {
                this.f243668f = ea.O0(this.f243666d.getApplication(), this.f243666d.getAccount());
            }
            if (valueOf.longValue() - this.f243668f > 86400000) {
                this.f243668f = en.v(valueOf.longValue());
                ea.d3(this.f243666d.getApplication(), this.f243666d.getAccount(), this.f243668f);
                ea.e3(this.f243666d.getApplication(), this.f243666d.getAccount(), 0);
                this.f243667e = 0;
                if (QLog.isColorLevel()) {
                    QLog.d("PushNotificationManager", 2, "Today First Query, mTodayHadShowCount=" + this.f243667e + " mTodayZeroTimeMillis=" + this.f243668f);
                }
            } else {
                this.f243667e = ea.P0(this.f243666d.getApplication(), this.f243666d.getAccount());
                if (QLog.isColorLevel()) {
                    QLog.d("PushNotificationManager", 2, "Query, mTodayHadShowCount=" + this.f243667e + " mTodayZeroTimeMillis=" + this.f243668f);
                }
            }
        }
        return this.f243667e;
    }

    private boolean f(long j3) {
        if (this.C == null) {
            this.C = new ArrayList();
            try {
                for (String str : ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("push_notification_no_show_in_qun", "32").split(",")) {
                    this.C.add(Long.valueOf(Long.parseLong(str)));
                }
            } catch (Exception e16) {
                QLog.e("PushNotificationManager", 1, "isCanNotShowInQunList exception:" + e16);
            }
        }
        return this.C.contains(Long.valueOf(j3));
    }

    private boolean g(AIOSession aIOSession) {
        String str = "";
        int e16 = aIOSession.c().e();
        if (e16 == 1) {
            str = aIOSession.c().j();
        } else if (e16 == 2) {
            str = aIOSession.c().j();
        }
        String str2 = str;
        String currentUid = this.f243666d.getCurrentUid();
        if (TextUtils.isEmpty(currentUid)) {
            currentUid = this.f243666d.getCurrentUin();
        }
        String str3 = currentUid;
        if (QLog.isColorLevel() && TextUtils.isEmpty(str2)) {
            QLog.d("PushNotificationManager", 2, "sessionInfo.curType=" + e16 + " uid==null");
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushNotificationManager", 2, "uin=" + str2 + "mApp.getAccount()=" + this.f243666d.getAccount());
        }
        synchronized (this) {
            List<? extends Entity> query = this.f243669h.query(PushSwitchGrayTipsInfo.class, true, "uin=? and toUin=?", new String[]{str3, str2}, null, null, null, null);
            if (query != null && query.size() != 0) {
                PushSwitchGrayTipsInfo pushSwitchGrayTipsInfo = (PushSwitchGrayTipsInfo) query.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("PushNotificationManager", 2, "pushSwitchGrayTipsInfo.lastShowTime=" + pushSwitchGrayTipsInfo.lastShowTime + " mTodayZeroTimeMillis=" + this.f243668f);
                }
                long j3 = pushSwitchGrayTipsInfo.lastShowTime;
                long j16 = this.f243668f;
                if (j3 >= j16) {
                    return false;
                }
                pushSwitchGrayTipsInfo.lastShowTime = j16;
                pushSwitchGrayTipsInfo.showCount++;
                this.f243669h.update(pushSwitchGrayTipsInfo);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PushNotificationManager", 2, "result == null || result.size() == 0");
            }
            this.f243669h.persistOrReplace(new PushSwitchGrayTipsInfo(str3, str2, e16, this.f243668f, 1));
            return true;
        }
    }

    private void j(AIOSession aIOSession, int i3) {
        this.f243667e++;
        ea.e3(this.f243666d.getApplication(), this.f243666d.getAccount(), this.f243667e);
        com.tencent.mobileqq.app.msgnotify.a.f196345a.s();
        b(aIOSession, i3);
    }

    private void k(AIOSession aIOSession, int i3) {
        if (com.tencent.mobileqq.app.msgnotify.a.f196345a.c()) {
            j(aIOSession, i3);
        }
    }

    private void l(AIOSession aIOSession, int i3) {
        if (d().d()) {
            if (e() >= d().c()) {
                if (QLog.isColorLevel()) {
                    QLog.d("PushNotificationManager", 2, "getmTodayHadShowCount > showCount");
                }
            } else if (g(aIOSession)) {
                j(aIOSession, i3);
            }
        }
    }

    public ax d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ax) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f243670i == null) {
            ax axVar = new ax();
            this.f243670i = axVar;
            axVar.f(false);
            if (QLog.isColorLevel()) {
                QLog.d("PushNotificationManager", 2, "pushNotificationBean=null, general new bean");
            }
        }
        return this.f243670i;
    }

    public void h(AIOSession aIOSession, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aIOSession, i3);
            return;
        }
        if (!this.f243671m.booleanValue()) {
            QLog.d("PushNotificationManager", 1, "judgeAndAddGrayTips switch off");
            return;
        }
        if (aIOSession == null) {
            QLog.d("PushNotificationManager", 1, "sessionInfo is null");
            return;
        }
        com.tencent.mobileqq.app.msgnotify.a aVar = com.tencent.mobileqq.app.msgnotify.a.f196345a;
        if (!aVar.n()) {
            if (!c(aIOSession)) {
                QLog.d("PushNotificationManager", 1, "judgeAndAddGrayTips can not show, aio:" + aIOSession);
                return;
            }
            if (aVar.f()) {
                k(aIOSession, i3);
                return;
            } else {
                l(aIOSession, i3);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushNotificationManager", 2, "isNotificationEnabled=" + QQAppInterface.isNotificationEnabled());
        }
    }

    public void i(ax axVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) axVar);
        } else {
            this.f243670i = axVar;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f243667e = -1;
            this.f243668f = 0L;
        }
    }
}
