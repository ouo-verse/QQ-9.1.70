package com.tencent.mobileqq.equipmentlock;

import QQService.DeviceItemDes;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.l;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.servlet.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x51.SubMsgType0x51$DevInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EquipmentLockImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    private static byte[] f205329v;

    /* renamed from: w, reason: collision with root package name */
    private static EquipmentLockImpl f205330w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f205331x;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Handler> f205332a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f205333b;

    /* renamed from: c, reason: collision with root package name */
    private int f205334c;

    /* renamed from: d, reason: collision with root package name */
    private String f205335d;

    /* renamed from: e, reason: collision with root package name */
    private String f205336e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f205337f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f205338g;

    /* renamed from: h, reason: collision with root package name */
    private String f205339h;

    /* renamed from: i, reason: collision with root package name */
    String f205340i;

    /* renamed from: j, reason: collision with root package name */
    String f205341j;

    /* renamed from: k, reason: collision with root package name */
    String f205342k;

    /* renamed from: l, reason: collision with root package name */
    boolean f205343l;

    /* renamed from: m, reason: collision with root package name */
    String f205344m;

    /* renamed from: n, reason: collision with root package name */
    int f205345n;

    /* renamed from: o, reason: collision with root package name */
    String f205346o;

    /* renamed from: p, reason: collision with root package name */
    String f205347p;

    /* renamed from: q, reason: collision with root package name */
    boolean f205348q;

    /* renamed from: r, reason: collision with root package name */
    Runnable f205349r;

    /* renamed from: s, reason: collision with root package name */
    private a f205350s;

    /* renamed from: t, reason: collision with root package name */
    private l f205351t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.antiphing.b> f205352u;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f205353a;

        /* renamed from: b, reason: collision with root package name */
        boolean f205354b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f205353a = false;
                this.f205354b = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        f205329v = new byte[0];
        f205330w = null;
        f205331x = false;
    }

    public EquipmentLockImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205332a = new HashMap();
        this.f205333b = true;
        this.f205334c = -1;
        this.f205335d = null;
        this.f205336e = null;
        this.f205337f = true;
        this.f205338g = false;
        this.f205339h = "Manually";
        this.f205340i = null;
        this.f205341j = null;
        this.f205342k = null;
        this.f205343l = false;
        this.f205344m = null;
        this.f205345n = 0;
        this.f205346o = null;
        this.f205347p = null;
        this.f205348q = false;
        this.f205349r = new Runnable() { // from class: com.tencent.mobileqq.equipmentlock.EquipmentLockImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EquipmentLockImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("DevLock", 2, "notification runnable run.");
                }
                EquipmentLockImpl.this.h();
            }
        };
        this.f205350s = null;
        this.f205351t = null;
        this.f205352u = null;
    }

    private void E(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("open_success", str);
        QQBeaconReport.report(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "devlock_verify_open_when_background", hashMap);
    }

    private void F(String str, String str2, String str3, String str4, boolean z16, int i3, String str5, String str6) {
        this.f205340i = str;
        this.f205341j = str2;
        this.f205342k = str3;
        this.f205344m = str4;
        this.f205343l = z16;
        this.f205345n = i3;
        this.f205347p = str5;
        this.f205346o = str6;
    }

    private void K(Intent intent, String str) {
        BaseApplication context = BaseApplication.getContext();
        NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle(context.getString(R.string.azz)).setContentText(str).setAutoCancel(true).setSmallIcon(R.drawable.qfile_dataline_pc_recent).setTicker(context.getString(R.string.azz)).setWhen(System.currentTimeMillis());
        Bitmap g16 = j.g(context.getResources(), R.drawable.qfile_dataline_pc_recent);
        if (g16 != null) {
            when.setLargeIcon(g16);
        }
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 276);
        when.setContentIntent(PendingIntent.getActivity(context, 0, intent, 201326592));
        if (Build.VERSION.SDK_INT >= 26) {
            when.setChannelId(QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
        }
        Notification build = when.build();
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager == null) {
            QLog.w("DevLock", 1, "showQuickVerifyNotification QQNotificationManager is null");
            return;
        }
        qQNotificationManager.cancel("EquipmentLockImpl", 276);
        f205331x = true;
        qQNotificationManager.notify("EquipmentLockImpl", 276, build);
        ThreadManager.getUIHandler().removeCallbacks(this.f205349r);
        ThreadManager.getUIHandler().postDelayed(this.f205349r, 120000L);
        QLog.w("DevLock", 1, "showQuickVerifyNotification");
    }

    private void L(Intent intent) {
        try {
            BaseApplication.getContext().startActivity(intent);
        } catch (Exception e16) {
            QLog.e("DevLock", 1, "startQuickVerifyActivity exception: ", e16);
        }
    }

    private a M(final Runnable runnable) {
        final a aVar = new a();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.equipmentlock.f
            @Override // java.lang.Runnable
            public final void run() {
                EquipmentLockImpl.y(EquipmentLockImpl.a.this, runnable);
            }
        }, 16, null, false, 1000L);
        return aVar;
    }

    private void k() {
        this.f205340i = null;
        this.f205341j = null;
        this.f205342k = null;
        this.f205344m = null;
        this.f205343l = false;
        this.f205345n = 0;
        this.f205346o = null;
        this.f205347p = null;
    }

    public static EquipmentLockImpl o() {
        if (f205330w == null) {
            synchronized (f205329v) {
                if (f205330w == null) {
                    f205330w = new EquipmentLockImpl();
                }
            }
        }
        return f205330w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z16, int i3, String str6, String str7) {
        QLog.w("DevLock", 1, "startQuickVerifyActivity timeout when in background");
        E(false);
        K(intent, str);
        F(str2, str3, str4, str5, z16, i3, str6, str7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(a aVar, Runnable runnable) {
        if (!aVar.f205354b) {
            aVar.f205353a = true;
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        a aVar = this.f205350s;
        if (aVar != null && !aVar.f205353a && !aVar.f205354b) {
            QLog.i("DevLock", 1, "startQuickVerifyActivity success when in background");
            this.f205350s.f205354b = true;
            this.f205350s = null;
            E(true);
        }
    }

    public void A(ArrayList<com.tencent.mobileqq.antiphing.b> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) arrayList);
        } else {
            this.f205352u = arrayList;
        }
    }

    public ArrayList<com.tencent.mobileqq.antiphing.b> B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f205352u;
    }

    public void C(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        if (TextUtils.isEmpty(str) && appRuntime != null) {
            str = appRuntime.getCurrentAccountUin();
        }
        ReportController.o(appRuntime, "P_CliOper", "Safe_DeviceLock", str, "UserBehavior", this.f205339h, 0, i3, "", "", "", "");
    }

    public void D(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        if (TextUtils.isEmpty(str) && appRuntime != null) {
            str = appRuntime.getCurrentAccountUin();
        }
        ReportController.o(appRuntime, "dc00899", "Safe_DeviceLock", str, "H5UserBehavior", "H5_Manually", 0, i3, "", "", "", "");
    }

    public void G(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.f205338g = z16;
        }
    }

    public int H(AppRuntime appRuntime, Context context, String str, boolean z16) {
        SharedPreferences sharedPreferences;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, this, appRuntime, context, str, Boolean.valueOf(z16))).intValue();
        }
        if (context == null || appRuntime == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences("devlock_sharedpref", 0)) == null) {
            return -1;
        }
        String account = appRuntime.getAccount();
        if (z16) {
            sharedPreferences.edit().putInt("devlock_status" + str, 0).commit();
            if (str.equalsIgnoreCase(account)) {
                this.f205334c = 0;
            }
        } else {
            sharedPreferences.edit().putInt("devlock_status" + str, 1).commit();
            if (str.equalsIgnoreCase(account)) {
                this.f205334c = 1;
            }
        }
        return 0;
    }

    public int I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        this.f205336e = str;
        return 0;
    }

    public void J(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            this.f205339h = str;
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f205351t == null) {
            this.f205351t = new l() { // from class: com.tencent.mobileqq.equipmentlock.e
                @Override // com.tencent.mobileqq.loginregister.l
                public final void a() {
                    EquipmentLockImpl.this.z();
                }
            };
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).addDevLockVerifyListener(this.f205351t);
        }
    }

    public boolean O(AppRuntime appRuntime, ArrayList<com.tencent.mobileqq.antiphing.b> arrayList) {
        String str;
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime, (Object) arrayList)).booleanValue();
        }
        if (appRuntime != null && arrayList != null) {
            long parseLong = Long.parseLong(appRuntime.getAccount());
            int f16 = AppSetting.f();
            appRuntime.getApplication();
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                str = context.getPackageName();
            } else {
                str = null;
            }
            if (str == null || str.length() < 1) {
                str = "com.tencent.mobileqq";
            }
            String str2 = str;
            if ((appRuntime instanceof AppInterface) && (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) != null) {
                friendListHandler.updateTrustDeviceList(parseLong, f16, str2, 1000, arrayList);
                return true;
            }
        }
        return false;
    }

    public int d(AppRuntime appRuntime, String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, appRuntime, str, hVar)).intValue();
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            return ((ILoginServletService) appRuntime.getRuntimeService(ILoginServletService.class, "all")).askDevLockSms(str, hVar);
        }
        return -1;
    }

    public int e(AppRuntime appRuntime, String str, String str2, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, appRuntime, str, str2, bArr, hVar)).intValue();
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            return ((ILoginServletService) appRuntime.getRuntimeService(ILoginServletService.class, "all")).checkDevLockSms(str, AppSetting.f(), str2, bArr, hVar);
        }
        return -1;
    }

    public int f(AppRuntime appRuntime, String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, appRuntime, str, hVar)).intValue();
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            return ((ILoginServletService) appRuntime.getRuntimeService(ILoginServletService.class, "all")).checkDevLockStatus(str, AppSetting.f(), hVar);
        }
        return -1;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        ArrayList<com.tencent.mobileqq.antiphing.b> arrayList = this.f205352u;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        BaseApplication.getContext();
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            try {
                ThreadManager.getUIHandler().removeCallbacks(this.f205349r);
                qQNotificationManager.cancel("EquipmentLockImpl", 276);
                f205331x = false;
            } catch (Throwable unused) {
            }
            k();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f205340i == null) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.setClass(context, ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getDevLockQuickVerifyCls());
        intent.putExtra("appid", this.f205345n);
        intent.putExtra("deviceName", this.f205346o);
        intent.putExtra("autoRenewTips", this.f205347p);
        intent.putExtra("qrcode", this.f205340i);
        intent.putExtra("appName", this.f205344m);
        intent.putExtra("supportAutoLogin", this.f205343l);
        intent.addFlags(268435456);
        context.startActivity(intent);
        k();
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f205352u = null;
        }
    }

    public boolean l(AppRuntime appRuntime, String str, DeviceItemDes deviceItemDes, boolean z16, long j3, byte[] bArr) {
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, appRuntime, str, deviceItemDes, Boolean.valueOf(z16), Long.valueOf(j3), bArr)).booleanValue();
        }
        if (appRuntime == null || !(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        ArrayList<DeviceItemDes> arrayList = new ArrayList<>();
        arrayList.add(deviceItemDes);
        friendListHandler.delAuthDev(str, arrayList, z16, j3, bArr);
        return true;
    }

    public boolean m(AppRuntime appRuntime, String str, DeviceItemDes deviceItemDes, byte[] bArr) {
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, appRuntime, str, deviceItemDes, bArr)).booleanValue();
        }
        if (appRuntime == null || !(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        ArrayList<DeviceItemDes> arrayList = new ArrayList<>();
        arrayList.add(deviceItemDes);
        friendListHandler.delHistoryDev(str, arrayList, bArr);
        return true;
    }

    public boolean n(AppRuntime appRuntime, String str, long j3) {
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, appRuntime, str, Long.valueOf(j3))).booleanValue();
        }
        if (appRuntime == null || !(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        friendListHandler.getAuthLoginAndOnlineDevList(j3, str, 0L);
        return true;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return this.f205338g;
    }

    public boolean q(AppRuntime appRuntime, String str, long j3) {
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, appRuntime, str, Long.valueOf(j3))).booleanValue();
        }
        if (!(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        friendListHandler.getLoginDevList(j3, str, 0L);
        return true;
    }

    public boolean r(AppRuntime appRuntime, String str, long j3) {
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, appRuntime, str, Long.valueOf(j3))).booleanValue();
        }
        if (!(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        friendListHandler.getRecentLoginAndOnlineDevList(j3, str, 0L);
        return true;
    }

    public boolean s(AppRuntime appRuntime) {
        String str;
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime == null) {
            return false;
        }
        long parseLong = Long.parseLong(appRuntime.getAccount());
        int f16 = AppSetting.f();
        appRuntime.getApplication();
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = null;
        }
        if (str == null || str.length() < 1) {
            str = "com.tencent.mobileqq";
        }
        if (!(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        friendListHandler.getRecommandAuthDeviceList(parseLong, str, f16);
        return true;
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f205336e;
    }

    public void u(AppRuntime appRuntime, String str, String str2, String str3, String str4, boolean z16, int i3, String str5, SubMsgType0x51$DevInfo subMsgType0x51$DevInfo) {
        boolean z17;
        String str6;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, str2, str3, str4, Boolean.valueOf(z16), Integer.valueOf(i3), str5, subMsgType0x51$DevInfo);
            return;
        }
        if (appRuntime == null) {
            return;
        }
        if (!appRuntime.isBackgroundPause && !appRuntime.isBackgroundStop) {
            z17 = false;
        } else {
            z17 = true;
        }
        QLog.d("DevLock", 1, "handleQuickloginPush isInBackground=" + z17 + " app.isBackground_Pause=" + appRuntime.isBackgroundPause + " app.isBackground_Stop=" + appRuntime.isBackgroundStop + "supportAutoLogin = " + z16);
        if (subMsgType0x51$DevInfo != null && subMsgType0x51$DevInfo.dev_name.has() && subMsgType0x51$DevInfo.dev_type.has()) {
            str6 = new String(subMsgType0x51$DevInfo.dev_type.get().toByteArray(), StandardCharsets.UTF_8);
            str7 = new String(subMsgType0x51$DevInfo.dev_name.get().toByteArray(), StandardCharsets.UTF_8);
            QLog.d("EquipmentLockImpl", 1, "DevType = " + str6 + "DevName = " + str7);
        } else {
            str6 = "";
            str7 = "";
        }
        BaseApplication context = BaseApplication.getContext();
        if (z17) {
            String string = context.getString(R.string.azz);
            String string2 = context.getString(R.string.azz);
            Bitmap g16 = j.g(context.getResources(), R.drawable.qfile_dataline_pc_recent);
            NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle(string2).setContentText(str2 + "\n" + str3).setAutoCancel(true).setSmallIcon(R.drawable.qfile_dataline_pc_recent).setTicker(string).setWhen(System.currentTimeMillis());
            if (g16 != null) {
                when.setLargeIcon(g16);
            } else {
                when.setLargeIcon(j.g(context.getResources(), R.drawable.qfile_dataline_pc_recent));
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setClass(context, ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getDevLockQuickVerifyCls());
            intent.putExtra("appid", i3);
            intent.putExtra("deviceName", str7);
            intent.putExtra("deviceType", str6);
            intent.putExtra("autoRenewTips", str5);
            intent.putExtra("qrcode", str);
            intent.putExtra("appName", str4);
            intent.putExtra("supportAutoLogin", z16);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 276);
            when.setContentIntent(PendingIntent.getActivity(context, 0, intent, 201326592));
            if (Build.VERSION.SDK_INT >= 26) {
                when.setChannelId(QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
            }
            Notification build = when.build();
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel("EquipmentLockImpl", 276);
                f205331x = true;
                qQNotificationManager.notify("EquipmentLockImpl", 276, build);
                this.f205340i = str;
                this.f205341j = str2;
                this.f205342k = str3;
                this.f205344m = str4;
                this.f205343l = z16;
                this.f205345n = i3;
                this.f205347p = str5;
                this.f205346o = str7;
                ThreadManager.getUIHandler().removeCallbacks(this.f205349r);
                ThreadManager.getUIHandler().postDelayed(this.f205349r, 120000L);
                return;
            }
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(context, ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getDevLockQuickVerifyCls());
        intent2.putExtra("appid", i3);
        intent2.putExtra("deviceName", str7);
        intent2.putExtra("deviceType", str6);
        intent2.putExtra("autoRenewTips", str5);
        intent2.putExtra("qrcode", str);
        intent2.putExtra("appName", str4);
        intent2.putExtra("supportAutoLogin", z16);
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }

    public void v(AppRuntime appRuntime, final String str, final String str2, final String str3, final String str4, final boolean z16, final int i3, final String str5, SubMsgType0x51$DevInfo subMsgType0x51$DevInfo) {
        String str6;
        final String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, str2, str3, str4, Boolean.valueOf(z16), Integer.valueOf(i3), str5, subMsgType0x51$DevInfo);
            return;
        }
        if (appRuntime.isBackgroundPause || appRuntime.isBackgroundStop) {
            z17 = true;
        }
        QLog.d("DevLock", 1, "handleQuickLoginPushNew isInBackground=" + z17 + " app.isBackground_Pause=" + appRuntime.isBackgroundPause + " app.isBackground_Stop=" + appRuntime.isBackgroundStop + "supportAutoLogin = " + z16);
        if (subMsgType0x51$DevInfo != null && subMsgType0x51$DevInfo.dev_name.has() && subMsgType0x51$DevInfo.dev_type.has()) {
            str6 = new String(subMsgType0x51$DevInfo.dev_type.get().toByteArray(), StandardCharsets.UTF_8);
            String str8 = new String(subMsgType0x51$DevInfo.dev_name.get().toByteArray(), StandardCharsets.UTF_8);
            QLog.d("EquipmentLockImpl", 1, "DevType = " + str6 + "DevName = " + str8);
            str7 = str8;
        } else {
            str6 = "";
            str7 = "";
        }
        final String str9 = str2 + "\n" + str3;
        BaseApplication context = BaseApplication.getContext();
        final Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getDevLockQuickVerifyCls());
        intent.putExtra("appid", i3);
        intent.putExtra("deviceName", str7);
        intent.putExtra("deviceType", str6);
        intent.putExtra("autoRenewTips", str5);
        intent.putExtra("qrcode", str);
        intent.putExtra("appName", str4);
        intent.putExtra("supportAutoLogin", z16);
        k();
        if (z17) {
            a aVar = this.f205350s;
            if (aVar != null) {
                aVar.f205354b = true;
            }
            this.f205350s = M(new Runnable() { // from class: com.tencent.mobileqq.equipmentlock.d
                @Override // java.lang.Runnable
                public final void run() {
                    EquipmentLockImpl.this.x(intent, str9, str, str2, str3, str4, z16, i3, str5, str7);
                }
            });
            N();
            L(intent);
            return;
        }
        L(intent);
    }

    public boolean w(AppRuntime appRuntime, long j3, byte b16, byte[] bArr, int i3) {
        FriendListHandler friendListHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, appRuntime, Long.valueOf(j3), Byte.valueOf(b16), bArr, Integer.valueOf(i3))).booleanValue();
        }
        if (appRuntime == null || !(appRuntime instanceof AppInterface) || (friendListHandler = (FriendListHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return false;
        }
        friendListHandler.kickOutDev(j3, b16, bArr, i3);
        return true;
    }
}
