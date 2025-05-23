package com.tencent.mobileqq.vas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb$CustomOnlineStatusMsg;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$FrdCustomOnlineStatusChange;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomOnlineStatusManager {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<WeakReference<Runnable>> f307821a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private int f307822b = 30000;

    /* renamed from: c, reason: collision with root package name */
    private int f307823c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f307824d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final a f307825e = new a();

    /* renamed from: f, reason: collision with root package name */
    HashMap<String, Long> f307826f = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Utils {
        public static String c(String str) {
            String model = DeviceInfoMonitor.getModel();
            String iMEIForMain = MsfSdkUtils.getIMEIForMain(MsfSdkUtils.BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS);
            String imei = MobileInfoUtil.getImei();
            try {
                model = URLEncoder.encode(model, "utf-8");
                iMEIForMain = URLEncoder.encode(iMEIForMain, "utf-8");
                imei = URLEncoder.encode(imei, "utf-8");
            } catch (Exception e16) {
                QLog.e("CustomOnlineStatusManager", 1, "addExtParamsForUrl" + e16.getMessage());
            }
            return str + "&systemName=android&model=" + model + "&msfImei=" + iMEIForMain + "&identifier=" + imei;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(Activity activity, String str) {
            String str2;
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("hide_more_button", true);
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, activity.getString(R.string.close));
            intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, activity.getString(R.string.close));
            intent.putExtra("hide_title_left_arrow", true);
            intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            String url = ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl("custom_online_status");
            if (WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL.equals(str)) {
                url = url + "&src=1";
                str2 = "0X8009F76";
            } else if (QCircleDaTongConstant.ElementParamValue.SETTINGS.equals(str)) {
                url = url + "&src=2";
                str2 = "0X8009F77";
            } else if ("aio".equals(str)) {
                url = url + "&src=3";
                str2 = "0X8009F78";
            } else {
                str2 = "";
            }
            String str3 = str2;
            String c16 = c(url);
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(activity, c16);
            } else {
                VasWebviewUtil.openQQBrowserWithoutAD(activity, c16, 256L, intent, false, 299);
            }
            activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
            if (!TextUtils.isEmpty(str3)) {
                ReportController.o(null, "dc00898", "", "", str3, str3, 0, 0, "", "", "", "");
            }
        }

        public static int e(CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg) {
            if (customOnlineStatusPb$CustomOnlineStatusMsg != null && customOnlineStatusPb$CustomOnlineStatusMsg.uUpdateInterval.get() > 0) {
                return customOnlineStatusPb$CustomOnlineStatusMsg.uUpdateInterval.get();
            }
            return 30000;
        }

        public static String f(CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg) {
            if (customOnlineStatusPb$CustomOnlineStatusMsg == null) {
                return "";
            }
            try {
                if (customOnlineStatusPb$CustomOnlineStatusMsg.uHasCustomInfo.get() == 1) {
                    String str = customOnlineStatusPb$CustomOnlineStatusMsg.sCustomModel.get();
                    if (str != null) {
                        return str;
                    }
                }
            } catch (Exception e16) {
                QLog.d("CustomOnlineStatusManager", 1, e16, new Object[0]);
            }
            return "";
        }

        public static String g(CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg) {
            if (customOnlineStatusPb$CustomOnlineStatusMsg == null) {
                return "";
            }
            try {
                if (customOnlineStatusPb$CustomOnlineStatusMsg.uHasCustomInfo.get() == 1) {
                    String str = customOnlineStatusPb$CustomOnlineStatusMsg.sCustomDesc.get();
                    String str2 = customOnlineStatusPb$CustomOnlineStatusMsg.sCustomModel.get();
                    if (str != null && str2 != null) {
                        return str + str2;
                    }
                }
            } catch (Exception e16) {
                QLog.d("CustomOnlineStatusManager", 1, e16, new Object[0]);
            }
            return "";
        }

        public static int h(CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg) {
            if (customOnlineStatusPb$CustomOnlineStatusMsg != null) {
                return customOnlineStatusPb$CustomOnlineStatusMsg.uHasCustomInfo.get();
            }
            return 0;
        }

        public static void i(SubMsgType0x27$FrdCustomOnlineStatusChange subMsgType0x27$FrdCustomOnlineStatusChange) {
            long j3 = subMsgType0x27$FrdCustomOnlineStatusChange.uint64_uin.get();
            if (QLog.isDevelopLevel()) {
                QLog.d("CustomOnlineStatusManager", 4, "onPush uni = " + subMsgType0x27$FrdCustomOnlineStatusChange.uint64_uin.get());
            }
            if (j3 == BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("CustomOnlineStatusManager", 4, "sync owner");
                }
                l();
            } else if (!TextUtils.isEmpty(String.valueOf(j3))) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("CustomOnlineStatusManager", 4, "sync friend");
                }
                k(String.valueOf(j3));
            }
        }

        public static void j(final Activity activity, final String str) {
            if (activity == null) {
                QLog.e("CustomOnlineStatusManager", 1, "activity == null");
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Utils.d(activity, str);
                    }
                }, 16, null, false);
            }
        }

        private static void k(String str) {
            try {
                ((FriendListHandler) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(str, false);
            } catch (Exception e16) {
                QLog.e("CustomOnlineStatusManager", 1, e16, new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void l() {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            ((VipInfoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).V2(qQAppInterface.getLongAccountUin());
        }

        public static boolean m(int i3) {
            if (i3 == 1) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f307829a = 0;

        /* renamed from: b, reason: collision with root package name */
        String f307830b = "";

        a() {
        }

        private String a() {
            return "CustomOnlineStatusManager-" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        }

        void b() {
            SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), a(), "common_mmkv_configurations");
            this.f307830b = fromSpAdapter.getString("KEY_SELF_ONLINE_STATUS", "");
            this.f307829a = fromSpAdapter.getInt("KEY_SELF_ONLINE_STATUS_TYPE", 0);
        }

        void c() {
            QMMKV.fromSpAdapter(BaseApplication.getContext(), a(), "common_mmkv_configurations").edit().putString("KEY_SELF_ONLINE_STATUS", this.f307830b).putInt("KEY_SELF_ONLINE_STATUS_TYPE", this.f307829a).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final CustomOnlineStatusManager f307832a = new CustomOnlineStatusManager();
    }

    CustomOnlineStatusManager() {
    }

    public static CustomOnlineStatusManager d() {
        return b.f307832a;
    }

    private void f() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.CustomOnlineStatusManager.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = CustomOnlineStatusManager.this.f307821a.iterator();
                while (it.hasNext()) {
                    Runnable runnable = (Runnable) ((WeakReference) it.next()).get();
                    if (runnable == null) {
                        it.remove();
                    } else {
                        runnable.run();
                    }
                }
            }
        });
    }

    public boolean b(String str) {
        Long l3;
        if (str == null || (l3 = this.f307826f.get(str)) == null || Math.abs(System.currentTimeMillis() - l3.longValue()) > this.f307822b) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        int i3 = this.f307823c;
        this.f307823c = 1;
        if (i3 != 1) {
            j();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CustomOnlineStatusManager", 4, "featureEnable = " + this.f307823c);
        }
        if (this.f307823c == 1) {
            return true;
        }
        return false;
    }

    public final String e() {
        if (c()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(this.f307824d - currentTimeMillis) > this.f307822b) {
                this.f307824d = currentTimeMillis;
                if (QLog.isDevelopLevel()) {
                    QLog.d("CustomOnlineStatusManager", 4, "sync owner status");
                }
                Utils.l();
            }
            if (Utils.m(this.f307825e.f307829a)) {
                return this.f307825e.f307830b;
            }
            return "";
        }
        return "";
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        this.f307826f.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public void h(Runnable runnable) {
        this.f307821a.add(new WeakReference<>(runnable));
    }

    public void i() {
        this.f307821a.clear();
    }

    public void j() {
        if (QLog.isDevelopLevel()) {
            QLog.d("CustomOnlineStatusManager", 4, "resetOnEnableToggle");
        }
        this.f307824d = 0L;
        this.f307825e.b();
    }

    public final void k(CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg) {
        this.f307825e.f307829a = Utils.h(customOnlineStatusPb$CustomOnlineStatusMsg);
        this.f307825e.f307830b = Utils.g(customOnlineStatusPb$CustomOnlineStatusMsg);
        this.f307825e.c();
        this.f307822b = Utils.e(customOnlineStatusPb$CustomOnlineStatusMsg);
        f();
    }
}
