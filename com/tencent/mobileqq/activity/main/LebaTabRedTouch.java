package com.tencent.mobileqq.activity.main;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.ILebaPlugin;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LebaTabRedTouch {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f183353b;

    /* renamed from: a, reason: collision with root package name */
    public SplashActivity f183354a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements DrawerFrame.d {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                LebaTabRedTouch.c();
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void c(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void e(int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f183357a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f183358b;

        b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f183357a = i3;
                this.f183358b = i16 > 0;
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f183357a == bVar.f183357a && this.f183358b == bVar.f183358b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return (this.f183357a * 31) + (this.f183358b ? 1 : 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

        void onFinish();
    }

    public LebaTabRedTouch(SplashActivity splashActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) splashActivity);
        } else {
            this.f183354a = splashActivity;
        }
    }

    public static void c() {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
        f183353b = null;
    }

    public static void d() {
        String str;
        b bVar = f183353b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doQZoneRedPointClickReport: ");
        if (bVar == null) {
            str = "null";
        } else {
            str = bVar.f183357a + " " + bVar.f183358b;
        }
        sb5.append(str);
        QLog.i("MainAssistObserver.LebaTabRedTouch", 4, sb5.toString());
        if (bVar != null && bVar.f183357a <= 0 && bVar.f183358b) {
            LpReportInfo_pf00064.allReport(637, 21, 2);
        } else {
            LpReportInfo_pf00064.allReport(637, 22, 2);
        }
    }

    public static void e(int i3, int i16) {
        b bVar = new b(i3, i16);
        if (bVar.equals(f183353b)) {
            return;
        }
        f183353b = bVar;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !com.tencent.mobileqq.service.report.b.i(qBaseActivity)) {
            com.tencent.mobileqq.service.report.b.e(QBaseActivity.sTopActivity, false);
        }
        if (!QQTheme.isNowSimpleUI()) {
            return;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "doQZoneRedPointExposeReport: " + bVar.f183357a + " " + bVar.f183358b);
        if (bVar.f183357a > 0) {
            LpReportInfo_pf00064.allReport(637, 22, 1);
        } else if (bVar.f183358b) {
            LpReportInfo_pf00064.allReport(637, 21, 1);
        } else {
            LpReportInfo_pf00064.allReport(637, 23, 1);
        }
    }

    private int g(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, int i3) {
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 5) {
            return Integer.parseInt(redTypeInfo.red_content.get());
        }
        return i3;
    }

    private BusinessInfoCheckUpdate.RedTypeInfo k(QQAppInterface qQAppInterface, Set<Long> set, ILebaHelperService iLebaHelperService) {
        List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet = ((IRedTouchManager) this.f183354a.app.getRuntimeService(IRedTouchManager.class, "")).requestAppInfoListByAppSet(0);
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = null;
        if (requestAppInfoListByAppSet == null || requestAppInfoListByAppSet.size() == 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("getRedTouchInfoForLeba:redpoint path List:");
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = null;
        for (int i3 = 0; i3 < requestAppInfoListByAppSet.size(); i3++) {
            BusinessInfoCheckUpdate.AppInfo appInfo = requestAppInfoListByAppSet.get(i3);
            sb5.append(", for ");
            sb5.append(appInfo.path.get());
            if (appInfo.mission_level.get() != 0) {
                sb5.append(" mission_level ");
                sb5.append(appInfo.mission_level.get());
            } else if (999999 != appInfo.uiAppId.get() && !appInfo.path.get().contains(".")) {
                if (1130 == appInfo.uiAppId.get()) {
                    sb5.append(" exclude kandian ");
                } else {
                    boolean z16 = true;
                    if (appInfo.iNewFlag.get() == 1 && appInfo.exposure_max.get() > 0) {
                        if (iLebaHelperService == null || !iLebaHelperService.needShowRedDot(qQAppInterface, appInfo.uiAppId.get(), set)) {
                            z16 = false;
                        }
                        if (!z16) {
                            sb5.append(" !needShowRedDot");
                        } else {
                            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = appInfo.red_display_info.tab_display_info.get();
                            if (appInfo.uiAppId.get() == 100510 && redTypeInfo3.red_type.get() == 5) {
                                sb5.append(" !nearby");
                            } else {
                                if (redTypeInfo2 == null || redTypeInfo2.red_priority.get() < redTypeInfo3.red_priority.get()) {
                                    redTypeInfo2 = redTypeInfo3;
                                }
                                sb5.append(" show ");
                                if (redTypeInfo3.red_type.get() == 5) {
                                    redTypeInfo = m(redTypeInfo, appInfo, redTypeInfo3, "getRedTouchInfoForLeba, content=");
                                } else if (redTypeInfo2 == null || redTypeInfo2.red_priority.get() < redTypeInfo3.red_priority.get()) {
                                    redTypeInfo2 = redTypeInfo3;
                                }
                            }
                        }
                    } else {
                        sb5.append(" isNewFlag exposure_max error");
                        sb5.append(appInfo.iNewFlag.get());
                        sb5.append(appInfo.exposure_max.get());
                    }
                }
            } else {
                sb5.append(" second ");
            }
        }
        if (redTypeInfo != null) {
            return redTypeInfo;
        }
        if (redTypeInfo2 != null) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "getRedTouchInfoForLeba result != nullpathList = " + sb5.toString());
        } else {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "getRedTouchInfoForLeba result = nullpathList = " + sb5.toString());
        }
        return redTypeInfo2;
    }

    private BusinessInfoCheckUpdate.RedTypeInfo m(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2, String str) {
        if (redTypeInfo == null) {
            return redTypeInfo2;
        }
        try {
            if (QLog.isDevelopLevel()) {
                QLog.e("MainAssistObserver.LebaTabRedTouch", 4, str + redTypeInfo.red_content.get() + ", path=" + appInfo.path.get() + ",redTypeInfoContent=" + redTypeInfo2.red_content.get());
            }
            redTypeInfo.red_content.set((Integer.parseInt(redTypeInfo.red_content.get()) + Integer.parseInt(redTypeInfo2.red_content.get())) + "");
            return redTypeInfo;
        } catch (NumberFormatException e16) {
            QLog.e("MainAssistObserver.LebaTabRedTouch", 1, "error getRedTypeInfo " + e16);
            return redTypeInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BusinessInfoCheckUpdate.RedTypeInfo n(int i3) {
        Object obj;
        String str = null;
        if (p()) {
            return j(null);
        }
        QLog.d("MainAssistObserver.LebaTabRedTouch", 2, "getRedTypeInfoNew from: " + i3);
        ILebaHelperService iLebaHelperService = (ILebaHelperService) this.f183354a.app.getRuntimeService(ILebaHelperService.class, "");
        BusinessInfoCheckUpdate.RedTypeInfo k3 = k(this.f183354a.app, f(iLebaHelperService), iLebaHelperService);
        RedTypeInfo tabRedTypeInfo = ((ILebaPlugin) QRoute.api(ILebaPlugin.class)).getTabRedTypeInfo();
        int g16 = g(k3, 0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getRedTypeInfoNew ret: ");
        if (tabRedTypeInfo != null) {
            str = tabRedTypeInfo.getRedType() + "," + tabRedTypeInfo.getRedContent();
        }
        sb5.append(str);
        sb5.append(" numRedTouch: ");
        sb5.append(g16);
        QLog.d("MainAssistObserver.LebaTabRedTouch", 2, sb5.toString());
        if (g16 > 0) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            if (tabRedTypeInfo != null && tabRedTypeInfo.getRedType() == 5) {
                g16 += Integer.parseInt(tabRedTypeInfo.getRedContent());
            }
            redTypeInfo.red_type.set(5);
            redTypeInfo.red_content.set(String.valueOf(g16));
            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
            return redTypeInfo;
        }
        if (tabRedTypeInfo != null) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo2.red_type.set(tabRedTypeInfo.getRedType());
            redTypeInfo2.red_content.set(tabRedTypeInfo.getRedContent());
            redTypeInfo2.red_desc.set(tabRedTypeInfo.getRedDesc());
            return redTypeInfo2;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("getRedTypeInfoNew redTypeInfo: ");
        if (k3 == null) {
            obj = "null";
        } else {
            obj = k3.red_type;
        }
        sb6.append(obj);
        QLog.d("MainAssistObserver.LebaTabRedTouch", 2, sb6.toString());
        return k3;
    }

    private int o() {
        QQAppInterface qQAppInterface;
        SplashActivity splashActivity = this.f183354a;
        int i3 = 0;
        if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
            QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
            if (qZoneManagerImp != null) {
                int j3 = qZoneManagerImp.j(2) + qZoneManagerImp.j(3);
                if (QZoneIntimateEntranceManager.u()) {
                    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "is frame moment switch open, show moment active dot");
                    j3 += qZoneManagerImp.j(67);
                }
                if (!SimpleUIUtil.isNowElderMode()) {
                    j3 += r(qZoneManagerImp);
                }
                if (!QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime())) {
                    j3 += s(qZoneManagerImp);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + qZoneManagerImp.j(2) + " TYPE_VISITOR:" + qZoneManagerImp.j(3) + " TYPE INTIMATE: " + qZoneManagerImp.j(74));
                }
                i3 = j3;
            }
            QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + i3);
        }
        return i3;
    }

    private int r(QZoneManagerImp qZoneManagerImp) {
        if (qZoneManagerImp == null) {
            return 0;
        }
        int j3 = qZoneManagerImp.j(74);
        QZoneCountInfo k3 = qZoneManagerImp.k(74);
        if (j3 > 0 && k3 != null) {
            ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).saveRedCountInfo(74, k3);
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "intimateUnreadCnt is " + j3);
        return j3;
    }

    private int s(QZoneManagerImp qZoneManagerImp) {
        QZoneCountInfo k3;
        if (qZoneManagerImp == null || (k3 = qZoneManagerImp.k(1028)) == null || !((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).isValidPublishPlusIconRedDot(k3)) {
            return 0;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "show publish icon count info");
        return 1;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f183354a = null;
        }
    }

    public Set<Long> f(ILebaHelperService iLebaHelperService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this, (Object) iLebaHelperService);
        }
        HashSet hashSet = new HashSet();
        List<n> lebaShowList = iLebaHelperService.getLebaShowList();
        if (lebaShowList != null && !lebaShowList.isEmpty()) {
            for (n nVar : lebaShowList) {
                if (nVar != null && nVar.f240505b != null) {
                    hashSet.add(Long.valueOf(nVar.f240504a));
                }
            }
        }
        return hashSet;
    }

    public int h() {
        QQAppInterface qQAppInterface;
        QZoneManagerImp qZoneManagerImp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        SplashActivity splashActivity = this.f183354a;
        if (splashActivity == null || (qQAppInterface = splashActivity.app) == null || (qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER)) == null) {
            return 0;
        }
        int j3 = qZoneManagerImp.j(1) + qZoneManagerImp.j(73);
        if (QZoneIntimateEntranceManager.u()) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "is frame moment switch open, show moment passive dot");
            j3 += qZoneManagerImp.j(66);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + qZoneManagerImp.j(1));
        }
        return j3;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(this.f183354a.app);
    }

    public BusinessInfoCheckUpdate.RedTypeInfo j(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) redTypeInfo);
        }
        int h16 = h();
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "getQzoneRedType qzonMsgCount=" + h16);
        if (h16 > 0) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo2.red_type.set(5);
            redTypeInfo2.red_content.set(String.valueOf(h16));
            redTypeInfo2.red_desc.set("{'cn':'#FF0000'}");
            e(h16, 0);
            return redTypeInfo2;
        }
        int o16 = o();
        if (o16 > 0) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo3.red_type.set(0);
            redTypeInfo3.red_content.set("");
            redTypeInfo3.red_desc.set("");
            e(h16, o16);
            QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "getQzoneRedType hasReddot;qzoneNewCnt=" + o16);
            return redTypeInfo3;
        }
        return redTypeInfo;
    }

    public Runnable l(int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Runnable) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) cVar);
        }
        return new Runnable(i3, cVar) { // from class: com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f183355d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f183356e;

            {
                this.f183355d = i3;
                this.f183356e = cVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, LebaTabRedTouch.this, Integer.valueOf(i3), cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    try {
                        try {
                            this.f183356e.a(LebaTabRedTouch.this.n(this.f183355d));
                            cVar2 = this.f183356e;
                            if (cVar2 == null) {
                                return;
                            }
                        } catch (Exception e16) {
                            QLog.e("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify Exception was thrown when update red point.", e16);
                            cVar2 = this.f183356e;
                            if (cVar2 == null) {
                                return;
                            }
                        }
                        cVar2.onFinish();
                        return;
                    } catch (Throwable th5) {
                        c cVar3 = this.f183356e;
                        if (cVar3 != null) {
                            cVar3.onFinish();
                        }
                        throw th5;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!q()) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "isOnlyShowQzone is no eModel");
            return false;
        }
        if (QzoneFrame.isShowOldQZoneFrame()) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone isShowOldQZoneFrame");
            return true;
        }
        String i3 = i();
        if (QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B.equals(i3)) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "isOnlyShowQzone exp b");
            return false;
        }
        if (QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C.equals(i3)) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "isOnlyShowQzone exp c");
            return false;
        }
        if (AppSetting.t(this.f183354a) && SimpleUIUtil.isNowElderMode()) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone splitViewMode and elderMode");
            return false;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone true");
        return true;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return SimpleUIUtil.getSimpleUISwitch();
    }
}
