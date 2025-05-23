package com.tencent.mobileqq.reminder.util;

import Wallet.AcsMsg;
import Wallet.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService;
import com.tencent.mobileqq.reminder.view.b;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f281105a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<com.tencent.mobileqq.reminder.view.b> f281106b;

    /* renamed from: c, reason: collision with root package name */
    private static long f281107c;

    /* renamed from: d, reason: collision with root package name */
    private static final Runnable f281108d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements b.InterfaceC8509b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.reminder.view.b f281109a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Wallet.a f281110b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f281111c;

        a(com.tencent.mobileqq.reminder.view.b bVar, Wallet.a aVar, Activity activity) {
            this.f281109a = bVar;
            this.f281110b = aVar;
            this.f281111c = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, aVar, activity);
            }
        }

        @Override // com.tencent.mobileqq.reminder.view.b.InterfaceC8509b
        public void onClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            a.InterfaceC0000a interfaceC0000a = this.f281110b.f25156o;
            if (interfaceC0000a != null) {
                interfaceC0000a.onClick();
            }
            Wallet.a aVar = this.f281110b;
            String str = aVar.f25149h;
            QQReminderUtil.C(str, this.f281111c, aVar.f25147f);
            QQReminderUtil.k(this.f281109a);
            Wallet.a aVar2 = this.f281110b;
            int i3 = aVar2.f25154m;
            if (i3 == 0) {
                QQReminderUtil.G(102, aVar2.f25152k, aVar2.f25153l);
                QQReminderUtil.F(this.f281110b, "907239", "20", (System.currentTimeMillis() - QQReminderUtil.f281107c) + "");
            } else if (i3 == 1) {
                QQReminderUtil.H(aVar2, "914118", "20");
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQReminderUtil", 2, "[onClick] mClickUrl:" + str + ",mSchema:" + this.f281110b.f25150i);
            }
        }

        @Override // com.tencent.mobileqq.reminder.view.b.InterfaceC8509b
        public void onClose() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQReminderUtil.k(this.f281109a);
            a.InterfaceC0000a interfaceC0000a = this.f281110b.f25156o;
            if (interfaceC0000a != null) {
                interfaceC0000a.onClose();
            }
            Wallet.a aVar = this.f281110b;
            if (aVar.f25154m == 0) {
                QQReminderUtil.G(122, aVar.f25152k, aVar.f25153l);
                QQReminderUtil.F(this.f281110b, "907240", "20", (System.currentTimeMillis() - QQReminderUtil.f281107c) + "");
            }
        }

        @Override // com.tencent.mobileqq.reminder.view.b.InterfaceC8509b
        public void onFlingUp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QQReminderUtil.k(this.f281109a);
            a.InterfaceC0000a interfaceC0000a = this.f281110b.f25156o;
            if (interfaceC0000a != null) {
                interfaceC0000a.onFlingUp();
            }
            Wallet.a aVar = this.f281110b;
            if (aVar.f25154m == 0) {
                QQReminderUtil.G(122, aVar.f25152k, aVar.f25153l);
                QQReminderUtil.F(this.f281110b, "907240", "20", (System.currentTimeMillis() - QQReminderUtil.f281107c) + "");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32585);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f281106b = new WeakReference<>(null);
            f281108d = new Runnable() { // from class: com.tencent.mobileqq.reminder.util.QQReminderUtil.2
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
                    } else {
                        QQReminderUtil.j();
                    }
                }
            };
        }
    }

    private static void A(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Activity activity, Wallet.a aVar) {
        if (activity == null) {
            QLog.e("QQReminderUtil", 1, "doShowReminderDialog activity == null");
            return;
        }
        com.tencent.mobileqq.reminder.view.b bVar = new com.tencent.mobileqq.reminder.view.b(activity, R.style.azs);
        bVar.setContentView(R.layout.hcg);
        bVar.setCanceledOnTouchOutside(false);
        bVar.Z(aVar.f25142a);
        bVar.Y(aVar.f25143b);
        bVar.R(aVar.f25144c);
        bVar.S(aVar.f25145d);
        if (!TextUtils.isEmpty(aVar.f25146e)) {
            bVar.W(aVar.f25146e);
        } else {
            bVar.U(aVar.f25148g);
        }
        bVar.X(new a(bVar, aVar, activity));
        v(activity, bVar.getWindow());
        bVar.show();
        f281106b = new WeakReference<>(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(String str, Activity activity, Intent intent) {
        if (intent != null) {
            activity.startActivity(intent);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (HttpUtil.isValidUrl(str)) {
                Intent intent2 = new Intent();
                intent2.putExtra("url", str);
                RouteUtils.startActivity(activity, intent2, RouterConstants.UI_ROUTE_BROWSER);
            } else if (str.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                Intent intent3 = new Intent();
                intent3.setData(Uri.parse(str));
                RouteUtils.startActivity(activity, intent3, RouterConstants.UI_ROUTER_JUMP);
            }
        }
    }

    public static void D(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (str.startsWith("http")) {
                A(context, str);
            } else {
                u(context, str);
            }
        }
    }

    public static void E(AcsMsg acsMsg) {
        ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).removeMessageRecord(acsMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Wallet.a aVar, String str, String str2, String str3) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setExt(11, "4").setExt(12, WadlProxyConsts.PAGE_ID_GAMECENTER).setOperModule("9081").setExt(1, "908101").setOperId(str).setExt(4, str2).setExt(46, str3).setExt(2, aVar.f25152k).setExt(7, aVar.f25149h).setExt(8, aVar.f25142a).setExt(9, aVar.f25143b).setExt(10, aVar.f25144c).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(int i3, String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IQQReminderOfTianshuService) peekAppRuntime.getRuntimeService(IQQReminderOfTianshuService.class, ProcessConstant.MULTI)).report2Tianshu(i3, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(Wallet.a aVar, String str, String str2) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9385").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(1, "938503").setExt(4, str2).setExt(2, aVar.f25155n.getString(WadlProxyConsts.KEY_MATERIAL, "")).setGameAppId(aVar.f25155n.getString(WadlReportBuilder.TableElem.GAME_APPID, "")).report();
    }

    public static void I(AcsMsg acsMsg) {
        ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).setAlarmNotifaction(acsMsg);
    }

    public static void J(Activity activity, Wallet.a aVar) {
        try {
            if (!x(aVar)) {
                QLog.i("QQReminderUtil", 1, "[showReminderDialog] reminderInfoValid:" + aVar);
                return;
            }
            if (!h()) {
                return;
            }
            if (w()) {
                QLog.i("QQReminderUtil", 1, "[showReminderDialog] is in notification time");
                return;
            }
            j();
            m(activity, aVar);
            g(aVar.f25151j);
            int i3 = aVar.f25154m;
            if (i3 == 0) {
                G(101, aVar.f25152k, aVar.f25153l);
                F(aVar, "907238", "8", "0");
            } else if (i3 == 1) {
                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914117").setOperModule("9385").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(1, "938503").setExt(4, "8").setExt(2, aVar.f25155n.getString(WadlProxyConsts.KEY_MATERIAL, "")).setExt(8, GameCenterUtil.getUrlParameter(aVar.f25149h, Utils.KEY_BUSINESS_ID)).setAdId("1294").setExt(25, GameCenterUtil.getUrlParameter(aVar.f25149h, WinkDaTongReportConstant.ElementParamKey.ADID)).setGameAppId(aVar.f25155n.getString(WadlReportBuilder.TableElem.GAME_APPID, "")).report();
            }
            f281107c = System.currentTimeMillis();
        } catch (Exception e16) {
            QLog.e("QQReminderUtil", 1, "reminderDialog Dialog show error ", e16);
        }
    }

    private static void g(long j3) {
        if (j3 == 0) {
            j3 = 7;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(f281108d, j3 * 1000);
    }

    public static boolean h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        boolean readValue = SettingCloneUtil.readValue((Context) peekAppRuntime.getApplication(), peekAppRuntime.getCurrentAccountUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
        boolean readValue2 = SettingCloneUtil.readValue((Context) peekAppRuntime.getApplication(), peekAppRuntime.getCurrentAccountUin(), (String) null, AppConstants.TOP_MSG_NOTIFICATION_KEY, true);
        if (QLog.isColorLevel()) {
            QLog.d("QQReminderUtil", 2, "[canShowTopNewMsg] canShowNewMsg:" + readValue + ",canShowTopMsg:" + readValue2);
        }
        if (readValue && readValue2) {
            return true;
        }
        return false;
    }

    public static void i(AcsMsg acsMsg) {
        ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).cancelAlarmNotifaction(acsMsg);
    }

    public static void j() {
        k(f281106b.get());
    }

    public static void k(com.tencent.mobileqq.reminder.view.b bVar) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(f281108d);
        if (bVar != null) {
            l(bVar);
        } else {
            l(f281106b.get());
        }
    }

    private static void l(com.tencent.mobileqq.reminder.view.b bVar) {
        if (bVar != null) {
            try {
                if (bVar.isShowing()) {
                    if ((bVar.getContext() instanceof Activity) && ((Activity) bVar.getContext()).isFinishing()) {
                        return;
                    }
                    bVar.cancel();
                }
            } catch (Exception e16) {
                QLog.e("QQReminderUtil", 1, e16, new Object[0]);
            }
        }
    }

    private static void m(final Activity activity, final Wallet.a aVar) {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.reminder.util.l
            @Override // java.lang.Runnable
            public final void run() {
                QQReminderUtil.B(activity, aVar);
            }
        });
    }

    public static int n(long j3) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(j3);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static String o(long j3, String str) {
        try {
            return new SimpleDateFormat(str, Locale.SIMPLIFIED_CHINESE).format(new Date(j3));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String p(AcsMsg acsMsg) {
        if (acsMsg == null) {
            return null;
        }
        if (acsMsg.type == 0) {
            return acsMsg.msg_id;
        }
        return acsMsg.msg_id + "-" + acsMsg.sub_time;
    }

    public static String q(AppRuntime appRuntime) {
        if (!TextUtils.isEmpty(f281105a)) {
            return f281105a;
        }
        try {
            Context applicationContext = appRuntime.getApplicationContext();
            f281105a = InstalledAppListMonitor.getPackageInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            f281105a = "getVersionException";
        }
        return f281105a;
    }

    private static Calendar r(long j3) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(j3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static long s(long j3) {
        return r(j3).getTimeInMillis();
    }

    public static long t(long j3, int i3) {
        Calendar r16 = r(j3);
        r16.add(6, i3);
        return r16.getTimeInMillis();
    }

    private static void u(Context context, String str) {
        ax c16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof BaseQQAppInterface) && (c16 = bi.c((BaseQQAppInterface) peekAppRuntime, context, str)) != null) {
            c16.b();
        }
    }

    private static void v(Activity activity, Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        attributes.gravity = 48;
        attributes.width = point.x;
        attributes.flags = 8;
        window.setAttributes(attributes);
        window.setFlags(1024, 1024);
    }

    public static boolean w() {
        long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong("notification_show_time", 0L);
        if (decodeLong > 0 && Math.abs(System.currentTimeMillis() - decodeLong) < 10000) {
            return true;
        }
        return false;
    }

    private static boolean x(Wallet.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f25143b) && !TextUtils.isEmpty(aVar.f25144c) && (!TextUtils.isEmpty(aVar.f25149h) || aVar.f25147f != null)) {
            return true;
        }
        return false;
    }

    private static boolean y(long j3, String str) {
        Date date = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.SIMPLIFIED_CHINESE);
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date(NetConnInfoCenter.getServerTimeMillis())))) {
            return true;
        }
        return false;
    }

    public static boolean z(long j3) {
        return y(j3, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }
}
