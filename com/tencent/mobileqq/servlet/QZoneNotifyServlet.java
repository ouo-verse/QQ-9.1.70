package com.tencent.mobileqq.servlet;

import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.feed_info;
import NS_UNDEAL_COUNT.single_count;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QZoneNotifyServlet extends MSFServlet implements WebEventListener {
    static IPatchRedirector $redirector_;
    public static long C;
    public static long D;
    private static LbsManagerServiceOnLocationChangeListener E;
    public static boolean F;
    private static long G;
    private static long H;
    private static String I;

    /* renamed from: m, reason: collision with root package name */
    private static long f286455m;

    /* renamed from: d, reason: collision with root package name */
    public long f286456d;

    /* renamed from: e, reason: collision with root package name */
    public long f286457e;

    /* renamed from: f, reason: collision with root package name */
    private MqqHandler f286458f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.simpleui.f f286459h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f286460i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.simpleui.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QZoneNotifyServlet.this);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean z16, boolean z17, boolean z18, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
                return;
            }
            if (z16) {
                QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSwitchSimpleUICallback isSuc=" + z16 + ", bChangedTheme=" + z17 + ", bSwitchElsePref=" + z18 + ", statusCode=" + i3);
                QZoneNotifyServlet.f();
                QZoneNotifyServlet.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends LbsManagerServiceOnLocationChangeListener {
        static IPatchRedirector $redirector_;

        b(String str, boolean z16) {
            super(str, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----locate");
            QzoneLbsReporter.reportLocationResult(i3, this.businessId, System.currentTimeMillis() - QZoneNotifyServlet.G);
            if (i3 == 0 && sosoLbsInfo != null) {
                QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onLocationFinish succeed! gps=" + LbsDataV2.convertFromSoso(sosoLbsInfo.mLocation));
            } else {
                QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE]onLocationFinish failed: error in force gps info update..");
            }
            QZoneNotifyServlet.e(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        C = 0L;
        D = 0L;
        F = false;
        H = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LOCATE_INTERVAL, 60000L);
    }

    public QZoneNotifyServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286456d = 180000L;
        this.f286457e = 5000L;
        this.f286460i = new Runnable() { // from class: com.tencent.mobileqq.servlet.QZoneNotifyServlet.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QZoneNotifyServlet.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "QZone scheduled QZoneFeedTimeTask run. currentTime:" + System.currentTimeMillis());
                    }
                    QZoneNotifyServlet.m(4);
                } catch (Throwable th5) {
                    QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "ex: ", th5);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(int i3) {
        if (i3 == 2) {
            H *= 10;
        } else if (i3 == 0) {
            H = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LOCATE_INTERVAL, 60000L);
        } else {
            H *= 2;
        }
    }

    public static void f() {
        if (TextUtils.isEmpty(I)) {
            I = LocalMultiProcConfig.getString(LocalMultiProcConfig.QZONE_CLIENT_MODE, "");
        }
        String clientMode = PlatformInfor.g().getClientMode();
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "checkClientModeChange curClient_mod=" + clientMode + ", preClient_mod=" + I);
        if (!TextUtils.equals(I, clientMode)) {
            m(1);
            I = clientMode;
            LocalMultiProcConfig.putString(LocalMultiProcConfig.QZONE_CLIENT_MODE, clientMode);
        }
    }

    public static LbsDataV2.GpsInfo g(String str) {
        boolean z16;
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(str);
        if (cachedLbsInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QzoneLbsReporter.reportLocationCacheResult(z16, str);
        QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getGpsInfo");
        if (cachedLbsInfo != null) {
            return LbsDataV2.convertFromSoso(cachedLbsInfo.mLocation);
        }
        return null;
    }

    private MqqHandler h() {
        if (this.f286458f == null) {
            synchronized (QZoneNotifyServlet.class) {
                if (this.f286458f == null) {
                    HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("QZONE_UNDEALCOUNT", 0);
                    newFreeHandlerThread.start();
                    this.f286458f = new MqqHandler(newFreeHandlerThread.getLooper());
                }
            }
        }
        return this.f286458f;
    }

    private static void i(String str) {
        if (F && E == null) {
            E = new b(str, false);
            try {
                G = System.currentTimeMillis();
                if (BaseApplication.getContext() != null && BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    QZLog.w(QZLog.TO_DEVICE_TAG, "[QZ_LBS_MODULE]\u5b9a\u4f4d\u6709\u7248\u672c\u6216\u6743\u9650\u9650\u5236");
                }
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("disable_silent_locate_for_in_qzone", true)) {
                    ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(E);
                } else {
                    QLog.e("QZoneRequest", 2, "disable silent locate in QZoneNotifyServlet");
                }
            } catch (Exception e16) {
                QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onCreate startLocation exception " + e16);
            }
        }
    }

    public static void j(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f286455m < H) {
            QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE] mIsGettingLocation = , (now - mLastGetLocationTime) ) = " + ((currentTimeMillis - f286455m) / 1000) + ", so return");
            return;
        }
        f286455m = currentTimeMillis;
        if (E != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.tencent.mobileqq.servlet.QZoneNotifyServlet.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (BaseApplication.getContext() == null || BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            QZoneNotifyServlet.G = System.currentTimeMillis();
                            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(QZoneNotifyServlet.E);
                            return;
                        } catch (Exception e16) {
                            QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "locate exception " + e16);
                            return;
                        }
                    }
                    QZLog.w(QZLog.TO_DEVICE_TAG, "\u5b9a\u4f4d\u6709\u7248\u672c\u6216\u6743\u9650\u9650\u5236");
                }
            });
        }
    }

    private void k() {
        h().removeCallbacks(this.f286460i);
        h().postDelayed(this.f286460i, this.f286456d);
    }

    public static void l() {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "sendFeedThemeChangeAction");
        BaseApplication.getContext().sendBroadcast(new Intent("com.qzone.feed_theme_change"));
    }

    public static void m(int i3) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), QZoneNotifyServlet.class);
        newIntent.setAction("Qzone_Get_NewAndUnread_Count");
        newIntent.putExtra("bNotWorkInBackGround", true);
        newIntent.putExtra("qzone_send_by_time", i3);
        waitAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        RemoteHandleManager.getInstance().addWebEventListener(this);
        if (this.f286459h == null) {
            this.f286459h = new a();
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.f286459h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.Servlet
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        if (E != null) {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(E);
        }
        E = null;
        RemoteHandleManager.getInstance().removeWebEventListener(this);
        if (this.f286458f != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "QZoneNotifyServlet onDestroy" + System.currentTimeMillis());
            }
            this.f286458f.removeCallbacks(this.f286460i);
            this.f286458f.getLooper().quit();
        }
        this.f286458f = null;
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.f286459h);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null || !(appRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        D = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onReceive onReceive: " + D);
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            VasLogReporter.getQzoneVip().reportLow("receive: sucess");
            QZoneUnreadServletLogic.P(intent, fromServiceMsg, qQAppInterface, this);
        } else {
            VasLogReporter.getQzoneVip().reportLow("receive: error");
            QZoneUnreadServletLogic.O(qQAppInterface, intent, fromServiceMsg, this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        AppRuntime appRuntime;
        int i3;
        int i16;
        QQAppInterface qQAppInterface;
        String str;
        int i17;
        ConcurrentHashMap concurrentHashMap;
        int i18;
        int i19;
        String str2;
        int i26;
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap2;
        long j3;
        ArrayList<feed_info> arrayList;
        QQAppInterface qQAppInterface2;
        String str3;
        int i27;
        ConcurrentHashMap concurrentHashMap3;
        QZoneManagerImp qZoneManagerImp;
        List<Integer> list;
        int i28;
        int i29;
        int i36;
        String str4;
        int i37;
        int i38;
        feed_host_info feed_host_infoVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        String str5 = "Q.lebatab.UndealCount.QZoneNotifyServlet";
        if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.begin.");
        }
        if (intent == null || !"Qzone_Get_NewAndUnread_Count".equals(intent.getAction()) || (appRuntime = getAppRuntime()) == null || !(appRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface3 = (QQAppInterface) appRuntime;
        if (!qQAppInterface3.isBackgroundPause) {
            i(QzoneLbsConstant.BUSINESS_ID_QZONE_LITTLE_VIDEO_ENTER);
        }
        int intExtra = intent.getIntExtra("scene", 102);
        int intExtra2 = intent.getIntExtra("qzone_send_by_time", 4);
        if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "QzoneNotifyServlet onSend byTimeType:" + intExtra2 + ",isBackground_Pause:" + qQAppInterface3.isBackgroundPause);
        }
        if (intExtra2 == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "GETFEEDUNREADTYPE_SWITCHTOFORGROUND nowtime: " + currentTimeMillis + ",lastGetFeedTime:" + C + ",lastGetFeedTime:" + C + "difference: " + (currentTimeMillis - C));
            }
            if (currentTimeMillis - C < this.f286457e) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.interval time is not enough,schedule task.byTimeType:2");
                }
                k();
                return;
            }
            i3 = 2;
        } else {
            i3 = 3;
        }
        int i39 = 7;
        int i46 = 6;
        String str6 = "qzone_lastgetfeedtime";
        int i47 = 5;
        int i48 = 1;
        int i49 = i3;
        if ((intExtra2 == 1 || intExtra2 == 4 || intExtra2 == 5 || intExtra2 == 6 || intExtra2 == 7 || intExtra2 == 8) && qQAppInterface3.isBackgroundPause) {
            long j16 = C;
            if (j16 == 0) {
                j16 = LocalMultiProcConfig.getLong("qzone_lastgetfeedtime", 0L);
            }
            if (System.currentTimeMillis() - j16 < QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_lastgetfeedtime", 43200000)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend app.isBackground_Pause: " + qQAppInterface3.isBackgroundPause + " not send request,schedule task");
                }
                k();
                return;
            }
        }
        int i56 = 3;
        if (intExtra2 == 3) {
            i16 = 4;
        } else {
            i16 = i49;
        }
        if (intExtra2 != 1) {
            i48 = i16;
        }
        if (intExtra2 != 4) {
            i56 = i48;
        }
        if (intExtra2 == 2) {
            i56 = 2;
        }
        if (intExtra2 != 5) {
            i47 = i56;
        }
        if (intExtra2 != 6) {
            i46 = i47;
        }
        if (intExtra2 != 7) {
            i39 = i46;
        }
        int i57 = 8;
        if (intExtra2 != 8) {
            i57 = i39;
        }
        int i58 = qQAppInterface3.getApp().getResources().getDisplayMetrics().widthPixels;
        int i59 = qQAppInterface3.getApp().getResources().getDisplayMetrics().heightPixels;
        ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap5 = new ConcurrentHashMap();
        QZoneManagerImp qZoneManagerImp2 = (QZoneManagerImp) qQAppInterface3.getManager(QQManagerFactory.QZONE_MANAGER);
        if (qZoneManagerImp2 != null && (concurrentHashMap2 = qZoneManagerImp2.f286441f) != null) {
            List<Integer> t16 = QZoneUnreadServletLogic.t(concurrentHashMap2);
            int size = t16.size();
            int i65 = 0;
            while (i65 < size) {
                int intValue = t16.get(i65).intValue();
                QZoneCountInfo qZoneCountInfo = qZoneManagerImp2.f286441f.get(Integer.valueOf(intValue));
                if (qZoneCountInfo != null) {
                    list = t16;
                    i28 = size;
                    str4 = str6;
                    single_count single_countVar = new single_count(qZoneCountInfo.uCount, (byte) qZoneCountInfo.iControl);
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<QZoneCountUserInfo> arrayList3 = qZoneCountInfo.friendList;
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        str3 = str5;
                        i38 = intExtra;
                        feed_host_infoVar = new feed_host_info(qZoneCountInfo.friendList.get(0).uin, "", qZoneCountInfo.friendMsg, null, null, null);
                    } else {
                        str3 = str5;
                        i38 = intExtra;
                        feed_host_infoVar = new feed_host_info(0L, "", qZoneCountInfo.friendMsg, null, null, null);
                    }
                    arrayList2.add(feed_host_infoVar);
                    i37 = i38;
                    i27 = i57;
                    i29 = i58;
                    i36 = i59;
                    qQAppInterface2 = qQAppInterface3;
                    concurrentHashMap3 = concurrentHashMap5;
                    qZoneManagerImp = qZoneManagerImp2;
                    concurrentHashMap4.put(Integer.valueOf(intValue), new count_info(single_countVar, arrayList2, qZoneCountInfo.trace_info, qZoneCountInfo.countId, qZoneCountInfo.iconUrl, qZoneCountInfo.strShowMsg, qZoneCountInfo.reportValue, qZoneCountInfo.cTime, qZoneCountInfo.iShowLevel, qZoneCountInfo.actPageAttach, qZoneCountInfo.tianshuTrans, qZoneCountInfo.expireTime, qZoneCountInfo.ext));
                } else {
                    qQAppInterface2 = qQAppInterface3;
                    str3 = str5;
                    i27 = i57;
                    concurrentHashMap3 = concurrentHashMap5;
                    qZoneManagerImp = qZoneManagerImp2;
                    list = t16;
                    i28 = size;
                    i29 = i58;
                    i36 = i59;
                    str4 = str6;
                    i37 = intExtra;
                }
                i65++;
                t16 = list;
                size = i28;
                str6 = str4;
                str5 = str3;
                intExtra = i37;
                i57 = i27;
                i58 = i29;
                i59 = i36;
                qQAppInterface3 = qQAppInterface2;
                concurrentHashMap5 = concurrentHashMap3;
                qZoneManagerImp2 = qZoneManagerImp;
            }
            qQAppInterface = qQAppInterface3;
            str = str5;
            i17 = i57;
            ConcurrentHashMap concurrentHashMap6 = concurrentHashMap5;
            i18 = i58;
            i19 = i59;
            str2 = str6;
            i26 = intExtra;
            QZoneCountInfo qZoneCountInfo2 = qZoneManagerImp2.f286441f.get(56);
            if (qZoneCountInfo2 != null) {
                single_count single_countVar2 = new single_count(qZoneCountInfo2.uCount, (byte) qZoneCountInfo2.iControl);
                ArrayList arrayList4 = new ArrayList();
                ArrayList<QZoneCountUserInfo> arrayList5 = qZoneCountInfo2.friendList;
                if (arrayList5 != null && arrayList5.size() > 0) {
                    Iterator<QZoneCountUserInfo> it = qZoneCountInfo2.friendList.iterator();
                    j3 = 0;
                    while (it.hasNext()) {
                        QZoneCountUserInfo next = it.next();
                        if (next != null) {
                            arrayList4.add(new feed_host_info(next.uin, next.nickName, null, next.vec_feedInfos, null, null));
                            if (j3 == 0 && (arrayList = next.vec_feedInfos) != null && arrayList.size() > 0) {
                                j3 = next.vec_feedInfos.get(0).uOrgFeedTime;
                            }
                        }
                    }
                } else {
                    j3 = 0;
                }
                if (qZoneCountInfo2.hasShow && j3 > 0) {
                    Long valueOf = Long.valueOf(j3);
                    concurrentHashMap = concurrentHashMap6;
                    concurrentHashMap.put(56L, valueOf);
                } else {
                    concurrentHashMap = concurrentHashMap6;
                }
                concurrentHashMap4.put(56, new count_info(single_countVar2, arrayList4, qZoneCountInfo2.trace_info, qZoneCountInfo2.countId, qZoneCountInfo2.iconUrl, qZoneCountInfo2.strShowMsg, qZoneCountInfo2.reportValue, qZoneCountInfo2.cTime, qZoneCountInfo2.iShowLevel, qZoneCountInfo2.actPageAttach, qZoneCountInfo2.tianshuTrans, qZoneCountInfo2.expireTime, qZoneCountInfo2.ext));
            } else {
                concurrentHashMap = concurrentHashMap6;
            }
        } else {
            qQAppInterface = qQAppInterface3;
            str = "Q.lebatab.UndealCount.QZoneNotifyServlet";
            i17 = i57;
            concurrentHashMap = concurrentHashMap5;
            i18 = i58;
            i19 = i59;
            str2 = "qzone_lastgetfeedtime";
            i26 = intExtra;
        }
        String str7 = str2;
        byte[] q16 = QZoneUnreadServletLogic.q(Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue(), null, i18, i19, i17, i26, concurrentHashMap4, LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", qQAppInterface.getLongAccountUin()), concurrentHashMap);
        if (q16 == null) {
            notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
        } else {
            packet.setTimeout(30000L);
            if (QLog.isDevelopLevel()) {
                QLog.d("NavigatorBar.Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "onSend cmd: " + QZoneHelper.CMD_PREFIX_PUBLIC + "getUndealCount iVisitQZoneType: " + i17);
            }
            packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + "getUndealCount");
            packet.putSendData(q16);
            long currentTimeMillis2 = System.currentTimeMillis();
            C = currentTimeMillis2;
            LocalMultiProcConfig.putLong(str7, currentTimeMillis2);
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "onSend send success,send request time: " + C);
            }
        }
        k();
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if (str.equals(RemoteHandleConst.CMD_PRE_GET_PASSIVE_FEEDS) && bundle != null && bundle.containsKey("data")) {
            Bundle bundle2 = bundle.getBundle("data");
            int i3 = bundle2.getInt(RemoteHandleConst.PARAM_PRE_GET_SEQID);
            AppRuntime appRuntime = getAppRuntime();
            if (appRuntime == null || !(appRuntime instanceof QQAppInterface)) {
                return;
            }
            Long valueOf = Long.valueOf(bundle2.getLong(RemoteHandleConst.PARAM_PRE_GET_UNDEALCOUNT, -1L));
            QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onWebEvent undealcount" + valueOf);
            QZoneUnreadServletLogic.c((QQAppInterface) appRuntime, i3, valueOf);
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        if (intent.getAction().equals("Qzone_Refresh_UI")) {
            long longExtra = intent.getLongExtra("notify_type", -1L);
            Bundle bundle = new Bundle();
            bundle.putBoolean(QCircleDaTongConstant.ElementParamValue.NEW, true);
            bundle.putLong("notify_type", longExtra);
            notifyObserver(null, 1000, true, bundle, QZoneObserver.class);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_LEBA_NEW, 2, "qzone redtypeinfo:call notify observer");
                return;
            }
            return;
        }
        super.service(intent);
    }
}
