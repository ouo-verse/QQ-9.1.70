package com.tencent.comic;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.data.BoodoHippyConfig;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.f;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.hippy.VipComicMainHippyFragment;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.StringBuilderUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VipComicJumpActivity extends QIphoneTitleBarActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    public WeakReferenceHandler f99171a0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f99179i0;

    /* renamed from: j0, reason: collision with root package name */
    TextView f99180j0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f99182l0;

    /* renamed from: b0, reason: collision with root package name */
    BroadcastReceiver f99172b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    long f99173c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    long f99174d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    long f99175e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    boolean f99176f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    volatile boolean f99177g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    boolean f99178h0 = false;

    /* renamed from: k0, reason: collision with root package name */
    c f99181k0 = null;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static abstract class PluginCheckJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<AppRuntime> f99190d;

        PluginCheckJob(AppRuntime appRuntime) {
            this.f99190d = new WeakReference<>(appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements BoodoHippyBirdge.ICheckPluginListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f99191a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f99192b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f99193c;

        a(f fVar, Activity activity, c cVar) {
            this.f99191a = fVar;
            this.f99192b = activity;
            this.f99193c = cVar;
        }

        @Override // com.tencent.comic.hippy.BoodoHippyBirdge.ICheckPluginListener
        public void onResult(int i3, String str) {
            QLog.i("VipComicJumpActivity", 1, "checkBoodoPlugin retCode:" + i3 + " msg:" + str);
            VipComicJumpActivity.s3(i3, this.f99191a, this.f99192b, this.f99193c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f99194a;

        /* renamed from: b, reason: collision with root package name */
        String f99195b;

        /* renamed from: c, reason: collision with root package name */
        String f99196c;

        /* renamed from: d, reason: collision with root package name */
        int f99197d;

        /* renamed from: e, reason: collision with root package name */
        int f99198e;

        /* renamed from: f, reason: collision with root package name */
        String f99199f = "";

        /* renamed from: g, reason: collision with root package name */
        int f99200g;

        /* renamed from: h, reason: collision with root package name */
        String f99201h;

        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {
        Bundle D;
        g E;

        /* renamed from: o, reason: collision with root package name */
        boolean f99216o;

        /* renamed from: a, reason: collision with root package name */
        public long f99202a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f99203b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f99204c = 0;

        /* renamed from: d, reason: collision with root package name */
        String f99205d = "";

        /* renamed from: e, reason: collision with root package name */
        String f99206e = "";

        /* renamed from: f, reason: collision with root package name */
        String f99207f = null;

        /* renamed from: g, reason: collision with root package name */
        String f99208g = null;

        /* renamed from: h, reason: collision with root package name */
        String f99209h = "com.qqcomic.activity.VipComicMainTabActivity";

        /* renamed from: i, reason: collision with root package name */
        String f99210i = "";

        /* renamed from: j, reason: collision with root package name */
        b f99211j = null;

        /* renamed from: k, reason: collision with root package name */
        String f99212k = null;

        /* renamed from: l, reason: collision with root package name */
        String f99213l = null;

        /* renamed from: m, reason: collision with root package name */
        String f99214m = null;

        /* renamed from: n, reason: collision with root package name */
        boolean f99215n = false;

        /* renamed from: p, reason: collision with root package name */
        boolean f99217p = false;

        /* renamed from: q, reason: collision with root package name */
        boolean f99218q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f99219r = true;

        /* renamed from: s, reason: collision with root package name */
        boolean f99220s = false;

        /* renamed from: t, reason: collision with root package name */
        Intent f99221t = new Intent();

        /* renamed from: u, reason: collision with root package name */
        boolean f99222u = false;

        /* renamed from: v, reason: collision with root package name */
        HashMap<String, Boolean> f99223v = new HashMap<>();

        /* renamed from: w, reason: collision with root package name */
        boolean f99224w = false;

        /* renamed from: x, reason: collision with root package name */
        String f99225x = "";

        /* renamed from: y, reason: collision with root package name */
        String f99226y = "";

        /* renamed from: z, reason: collision with root package name */
        String f99227z = "";
        String A = "";
        boolean B = false;
        String C = "";

        boolean a(String str) {
            return this.f99223v.get(str) != null && this.f99223v.get(str).booleanValue();
        }

        void b(String str, boolean z16) {
            this.f99223v.put(str, Boolean.valueOf(z16));
        }

        public String toString() {
            return "ComicParam{clickTime=" + this.f99202a + ", startTime=" + this.f99203b + ", sourceFrom=" + this.f99204c + ", extUrlParam='" + this.f99207f + "', jumpConponentName='" + this.f99209h + "', jumpurl='" + this.f99210i + "', comicInfo=" + this.f99211j + ", jumpMainTab='" + this.f99212k + "', jumpSubTab='" + this.f99213l + "', leftViewText='" + this.f99214m + "', returnDetail=" + this.f99215n + ", returnToHome=" + this.f99216o + ", returnHomeFromDetail=" + this.f99217p + ", isPlayerLocked=" + this.f99218q + ", needClearTop=" + this.f99219r + ", isFullscreen=" + this.f99220s + ", mIntent=" + this.f99221t + ", mNeedLaunchPlugin=" + this.f99222u + ", mIsTabRedMap=" + this.f99223v + ", mIsNewFlag=" + this.f99224w + ", mRedDotMissionIds='" + this.f99225x + "', mIsJumpActPage=" + this.B + ", mJumpActUrl='" + this.C + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class d implements QQComicPluginBridge.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Handler> f99228a;

        d(Handler handler) {
            this.f99228a = new WeakReference<>(handler);
        }

        @Override // com.tencent.comic.utils.QQComicPluginBridge.a
        public void a(int i3, String str) {
            Handler handler = this.f99228a.get();
            if (handler != null) {
                handler.obtainMessage(1001, i3, 0, str).sendToTarget();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private String f99229a;

        /* renamed from: b, reason: collision with root package name */
        private String f99230b;

        e() {
        }

        private void a(Intent intent) {
            String stringExtra = intent.getStringExtra(PluginStatic.PARAM_EXTRA_INFO);
            this.f99230b = stringExtra;
            if (stringExtra != null && "success".equals(stringExtra)) {
                VipComicJumpActivity vipComicJumpActivity = VipComicJumpActivity.this;
                vipComicJumpActivity.T2(vipComicJumpActivity.f99181k0, 0);
            } else {
                VipComicJumpActivity vipComicJumpActivity2 = VipComicJumpActivity.this;
                vipComicJumpActivity2.T2(vipComicJumpActivity2.f99181k0, -2);
                if (QLog.isColorLevel()) {
                    QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive mExtraInfo: " + this.f99230b);
                }
            }
            VipComicJumpActivity.this.finish();
            if (QLog.isColorLevel()) {
                QLog.d("QQComicDebug", 2, "launch activity finish, leave jump activity.");
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.f99229a = intent.getStringExtra("pluginsdk_pluginLocation");
            String stringExtra = intent.getStringExtra("pluginsdk_launchReceiver");
            String action = intent.getAction();
            if ((!TextUtils.isEmpty(action) && "com.tencent.mobileqq.PreLoadComicProcess".equals(action)) || (stringExtra != null && stringExtra.equals("com.qqcomic.app.VipPreloadComicProcess"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("VipComicJumpActivity", 2, "onReceive getExtras:" + intent.getExtras());
                }
                VipComicJumpActivity.this.d3(intent);
                return;
            }
            String str = this.f99229a;
            if (str == null || !str.equalsIgnoreCase(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive: " + this.f99229a);
            }
            a(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f99232a = true;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f99233b = false;

        /* renamed from: c, reason: collision with root package name */
        public volatile com.tencent.comic.a f99234c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        String f99235a;

        /* renamed from: b, reason: collision with root package name */
        String f99236b;

        /* renamed from: c, reason: collision with root package name */
        String f99237c;

        /* renamed from: d, reason: collision with root package name */
        String f99238d;

        public g(String str, String str2, String str3, String str4) {
            this.f99235a = str;
            this.f99236b = str2;
            this.f99237c = str3;
            this.f99238d = str4;
        }
    }

    private static int A3(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e("VipComicJumpActivity", 1, e16, new Object[0]);
            return 0;
        }
    }

    private static void C3(final String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QQToast.makeText(com.tencent.comic.utils.a.b(), str, 0).show();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.VipComicJumpActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(com.tencent.comic.utils.a.b(), str, 0).show();
                }
            });
        }
    }

    static boolean E3(String str, List<String> list, c cVar) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                jSONObject = new JSONObject(str).optJSONObject("msg");
            } catch (Exception e16) {
                QLog.e("VipComicJumpActivity", 1, "parse red failed", e16);
                jSONObject = null;
            }
            if (jSONObject != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        JSONObject optJSONObject = jSONObject.optJSONObject(it.next());
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("content");
                            if (TextUtils.isEmpty(optString)) {
                                continue;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(optString);
                                boolean equals = "redirect".equals(jSONObject2.optString("type"));
                                cVar.B = equals;
                                if (equals) {
                                    String optString2 = jSONObject2.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                                    if (TextUtils.isEmpty(optString2)) {
                                        cVar.B = false;
                                    } else {
                                        cVar.C = optString2;
                                        return true;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e17) {
                        QLog.e("VipComicJumpActivity", 1, "parse red mission failed", e17);
                    }
                }
            }
        }
        return false;
    }

    public static String J2(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder obtain = StringBuilderUtils.obtain();
        if (!TextUtils.isEmpty(str7)) {
            obtain.append(str7);
        }
        if (!TextUtils.isEmpty(str2) && !str.contains("_wv=")) {
            obtain.append("&_wv=");
            obtain.append(str2);
        }
        if (!TextUtils.isEmpty(str3) && !str.contains("_wwv=")) {
            obtain.append("&_wwv=");
            obtain.append(str3);
        }
        if (!TextUtils.isEmpty(str4) && !str.contains("_cwv=")) {
            obtain.append("&_cwv=");
            obtain.append(str4);
        }
        if (!TextUtils.isEmpty(str5) && !str.contains("_sonic_id=") && !str.contains("_bid=")) {
            obtain.append("&_bid=");
            obtain.append(str5);
        }
        if (!TextUtils.isEmpty(str6) && !str.contains("channel=")) {
            obtain.append("&channel=");
            obtain.append(str6);
        }
        if (obtain.length() > 0 && obtain.charAt(0) == '&') {
            obtain.deleteCharAt(0);
        }
        return com.tencent.comic.utils.h.a(str, obtain.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K2(AppRuntime appRuntime, Activity activity, c cVar) {
        f fVar = new f();
        BoodoHippyBirdge.checkPluginInstall(activity, new a(fVar, activity, cVar));
        if (!j3()) {
            B3(activity, fVar);
            IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) appRuntime.getRuntimeService(IWebProcessManagerService.class, ProcessConstant.MULTI);
            if (iWebProcessManagerService != null) {
                iWebProcessManagerService.startWebProcess(27, null);
            }
        } else {
            try {
                synchronized (fVar) {
                    fVar.wait(300L);
                }
            } catch (InterruptedException e16) {
                QLog.e("VipComicJumpActivity", 1, e16, new Object[0]);
            }
            B3(activity, fVar);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 1, "checkBoodoPlugin showLoadingDialog loadingCondition.mNeedLaunch:", Boolean.valueOf(fVar.f99232a));
        }
    }

    private static boolean L2(AppRuntime appRuntime, Activity activity, c cVar, boolean z16) {
        if (cVar.f99204c == 12 && z16) {
            return M2(appRuntime, activity, cVar) || Q2(activity);
        }
        return false;
    }

    private static boolean M2(final AppRuntime appRuntime, final Activity activity, final c cVar) {
        QLog.i("VipComicJumpActivity", 1, "QQComicConfBean.getHippyConfig().mHippyStatus:" + QQComicConfBean.b().mHippyStatus);
        BoodoHippyConfig W2 = W2();
        if (W2 != null && W2.mHippyStatus == 0) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.comic.VipComicJumpActivity.1
            @Override // java.lang.Runnable
            public void run() {
                VipComicJumpActivity.K2(AppRuntime.this, activity, cVar);
            }
        }, 16, null, false);
        return true;
    }

    private static boolean N2(AppRuntime appRuntime, Activity activity, c cVar) {
        D3(appRuntime, cVar);
        if (M2(appRuntime, activity, cVar)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "handle param parse red touch end");
        }
        if (cVar.B) {
            String a16 = com.tencent.comic.utils.h.a(cVar.C, "returnIndex=true");
            Intent intent = new Intent();
            intent.putExtra("url", a16);
            intent.putExtra("reportSourceFrom", cVar.f99204c);
            intent.putExtra("startOpenPageTime", cVar.f99202a);
            VipComicHelper.f(activity, intent, -1);
            if (QLog.isColorLevel()) {
                QLog.d("VipComicJumpActivity", 2, "jump to comic activity page directly, url=" + a16);
            }
            return true;
        }
        r3(activity, cVar);
        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", cVar.f99204c, 0, String.valueOf(System.currentTimeMillis() - cVar.f99203b));
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "handle param open main tab end");
        }
        return true;
    }

    private static void P2(HashMap<String, String> hashMap, c cVar) {
        String str;
        if (!TextUtils.isEmpty(cVar.f99205d)) {
            str = cVar.f99205d;
        } else if (!TextUtils.isEmpty(cVar.f99227z)) {
            str = "veb_red_" + cVar.f99227z;
        } else if (cVar.f99204c != 1006002) {
            str = cVar.f99206e;
        } else {
            str = "";
        }
        hashMap.put("mod", str);
    }

    private static boolean Q2(Activity activity) {
        boolean z16;
        ComponentName componentName;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("vip_comic_file", 4);
        if (sharedPreferences.getBoolean("restore_flag", false)) {
            String string = sharedPreferences.getString("base_package", "");
            String string2 = sharedPreferences.getString("base_activity", "");
            int i3 = sharedPreferences.getInt("activity_task_id", -1);
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getApplication().getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(100);
            if (runningTasks != null && runningTasks.size() > 0) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z16 = false;
                        break;
                    }
                    ActivityManager.RunningTaskInfo next = it.next();
                    componentName = next.baseActivity;
                    if (componentName.getClassName().equals(string2) && i3 == next.id) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(string, string2));
                    intent.addFlags(269500416);
                    intent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
                    try {
                        activity.startActivity(intent);
                        if (QLog.isColorLevel()) {
                            QLog.d("QQComicDebug", 2, "handle param restore stack end");
                        }
                        return true;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    private static String R2(List<String> list) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 != 0) {
                sb5.append("_");
            }
            sb5.append(list.get(i3));
        }
        return sb5.toString();
    }

    private static String U2(String str) {
        try {
            return "" + new JSONObject(str).optInt("ad_id");
        } catch (Exception e16) {
            QLog.e("VipComicJumpActivity", 1, "getAdId error", e16);
            return "";
        }
    }

    private static BoodoHippyConfig W2() {
        if (MobileQQ.sProcessId == 1) {
            return QQComicConfBean.b();
        }
        return com.tencent.comic.data.f.f99360q;
    }

    private com.tencent.mobileqq.hitrate.b Z2(c cVar, Intent intent) {
        intent.putExtra("reportSourceFrom", cVar.f99204c);
        intent.putExtra("reportProcessExistFlag", this.f99176f0 ? 1 : 0);
        intent.putExtra("reportLebaClick", cVar.f99202a);
        intent.putExtra("reportJumpActivityOnCreate", cVar.f99203b);
        long j3 = cVar.f99203b;
        if (j3 != 0) {
            long j16 = this.f99173c0;
            if (j16 != 0 && j16 > j3) {
                intent.putExtra("reportDownloadTime", j16 - j3);
            }
        }
        long j17 = this.f99174d0;
        if (j17 != 0) {
            long j18 = this.f99173c0;
            if (j18 != 0 && j17 > j18) {
                intent.putExtra("reportInstallTime", j17 - j18);
            }
        }
        intent.putExtra("reportStartPluginTime", System.currentTimeMillis());
        intent.putExtra("isFromJumpActivity", true);
        com.tencent.comic.api.plugin.a b16 = com.tencent.comic.api.plugin.a.b(2);
        if (b16 == null) {
            return null;
        }
        b16.c();
        return b16.f99254h;
    }

    private static String b3(String str) {
        try {
            return new JSONObject(str).optString("msg");
        } catch (Exception e16) {
            QLog.e("VipComicJumpActivity", 1, "getRedPointMsg error", e16);
            return "";
        }
    }

    private static String c3(String str) {
        try {
            return new JSONObject(str).optString("_show_mission");
        } catch (Exception e16) {
            QLog.e("VipComicJumpActivity", 1, "getShowMissionId error", e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(Intent intent) {
        if (intent.getBooleanExtra("from_launch_hippy", false)) {
            finish();
            return;
        }
        if (!this.f99177g0) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicDebug", 2, "do handle launch activity in receiver.");
            }
            this.f99171a0.removeMessages(1000);
            this.f99177g0 = true;
            this.f99178h0 = false;
            l3(this.f99181k0);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "skip handle launch activity in receiver.");
        }
    }

    private static void e3(c cVar, JSONObject jSONObject) {
        cVar.f99209h = jSONObject.optString("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
        cVar.f99204c = jSONObject.optInt("from", 0);
        cVar.f99206e = jSONObject.optString("from");
        cVar.f99205d = jSONObject.optString("mod");
        cVar.f99208g = jSONObject.optString(ISchemeApi.KEY_REFERER);
        cVar.f99219r = !jSONObject.optBoolean("newInstance");
        if (jSONObject.has("url")) {
            String optString = jSONObject.optString("url");
            cVar.f99210i = optString;
            try {
                cVar.f99210i = URLDecoder.decode(optString);
            } catch (Exception unused) {
            }
        }
        if (VipComicHelper.e(cVar.f99210i, cVar.f99221t)) {
            cVar.f99209h = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
        }
        if (jSONObject.has("comic")) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("comic"));
                b bVar = new b();
                cVar.f99211j = bVar;
                bVar.f99194a = jSONObject2.optString("comicID");
                cVar.f99211j.f99195b = jSONObject2.optString("comicSectionID");
                cVar.f99211j.f99196c = jSONObject2.optString("comicPageID");
                cVar.f99211j.f99197d = jSONObject2.optInt("comicPageOffset");
                cVar.f99211j.f99198e = jSONObject2.optInt("type");
                cVar.f99215n = jSONObject2.optBoolean("returnToDetail");
                cVar.f99211j.f99200g = jSONObject2.optInt("player", 2);
                cVar.f99211j.f99201h = jSONObject2.optString("cloudUrl", "");
                cVar.f99211j.f99199f = jSONObject2.optString("url", "");
                cVar.f99216o = jSONObject2.optInt("returnToHome") == 1;
            } catch (JSONException unused2) {
            }
        }
        if (jSONObject.has("maintab")) {
            cVar.f99212k = jSONObject.optString("maintab");
        }
        if (jSONObject.has("subtab")) {
            cVar.f99213l = jSONObject.optString("subtab");
        }
        if (jSONObject.has(AppConstants.LeftViewText.LEFTVIEWTEXT)) {
            cVar.f99214m = jSONObject.optString(AppConstants.LeftViewText.LEFTVIEWTEXT);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONObject g3(Intent intent, c cVar) {
        JSONObject w3;
        int i3;
        cVar.D = intent.getBundleExtra("hippy_bundle");
        cVar.f99202a = intent.getLongExtra("click_start_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        cVar.f99203b = currentTimeMillis;
        if (cVar.f99202a <= 0) {
            cVar.f99202a = currentTimeMillis;
        }
        cVar.f99224w = intent.getBooleanExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, false);
        String stringExtra = intent.getStringExtra("from_leba");
        String stringExtra2 = intent.getStringExtra("from_leba_mgr");
        String stringExtra3 = intent.getStringExtra("cfrom");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("fromleba")) {
            cVar.f99204c = 1006002;
        } else if (stringExtra2 != null && stringExtra2.equalsIgnoreCase("fromlebamgr")) {
            cVar.f99204c = 1006003;
        } else if (!TextUtils.isEmpty(stringExtra3)) {
            cVar.f99204c = Integer.valueOf(stringExtra3).intValue();
        } else {
            w3 = w3(intent, cVar);
            if (QLog.isColorLevel()) {
                QLog.d("VipComicJumpActivity", 2, "getFromInfoFromIntent sourceFrom = " + cVar.f99204c + ", extUrlParam = " + cVar.f99207f);
            }
            i3 = cVar.f99204c;
            if (i3 != 1006002) {
                cVar.f99214m = com.tencent.mobileqq.activity.home.impl.b.f183052o;
            } else if (i3 == 1006003) {
                cVar.f99214m = "\u66f4\u591a";
            }
            return w3;
        }
        w3 = null;
        if (QLog.isColorLevel()) {
        }
        i3 = cVar.f99204c;
        if (i3 != 1006002) {
        }
        return w3;
    }

    public static String getUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String url = IndividuationUrlHelper.getUrl(str);
        if (TextUtils.isEmpty(url)) {
            url = com.tencent.comic.utils.h.c(str);
        }
        return J2(url, str2, str3, str4, str5, str6, str7);
    }

    public static void i3(AppInterface appInterface, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "init plugin before enter start");
        }
        if (appInterface instanceof BaseQQAppInterface) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.comic.VipComicJumpActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    BannerManager.l().N(com.tencent.mobileqq.banner.d.G, 0, Conversation.MSG_COMIC_BAR_HIDE);
                }
            }, 1000L);
            com.tencent.comic.g.c();
            of0.a.a();
            if (z16) {
                ThreadManagerV2.postImmediately(new PluginCheckJob(appInterface) { // from class: com.tencent.comic.VipComicJumpActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AppRuntime appRuntime = this.f99190d.get();
                        if (appRuntime == null) {
                            return;
                        }
                        if (QQComicPluginBridge.e(appRuntime)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQComicDebug", 2, "plugin is installed.");
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQComicDebug", 2, "wait for plugin installation...");
                        }
                        if (!QQComicPluginBridge.b(appRuntime, true, null)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQComicDebug", 2, "plugin install failed.");
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("QQComicDebug", 2, "plugin is installed now.");
                        }
                    }
                }, null, true);
            }
            lb1.a aVar = (lb1.a) appInterface.getBusinessHandler(((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getVipComicMqqHandlerImplClassName());
            if (aVar != null) {
                aVar.O0();
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("doLoadModule", z16);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QQComicIPCModule", "initPluginBeforeEnter", bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "init plugin before enter end");
        }
    }

    private static boolean j3() {
        boolean z16;
        Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) com.tencent.comic.utils.a.b().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            if (it.next().processName.equals("com.tencent.mobileqq:tool")) {
                z16 = true;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "isToolProcessExist: " + z16);
        }
        return z16;
    }

    public static void n3(Activity activity, c cVar) {
        String str;
        Bundle bundle = new Bundle();
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, true);
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, true);
        bundle.putString("processName", "tool");
        String str2 = cVar.f99207f;
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, str2 == null || !str2.contains("hippyurl"));
        bundle.putString("bundleName", HippyQQConstants.ModuleName.QQ_BOODO_COMIC);
        BoodoHippyConfig W2 = W2();
        if (W2 != null && W2.mPreloadModules.contains(HippyQQConstants.ModuleName.QQ_BOODO_COMIC)) {
            bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED, true);
        }
        SerializableMap serializableMap = new SerializableMap();
        HashMap<String, String> hashMap = new HashMap<>();
        if (cVar.f99224w) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("hasRedDot", str);
        hashMap.put("extUrlParam", cVar.f99207f);
        hashMap.put("from", String.valueOf(cVar.f99204c));
        hashMap.put("redId", cVar.f99226y);
        hashMap.put("redpointmsg", cVar.A);
        g gVar = cVar.E;
        if (gVar != null) {
            hashMap.put("lastPageKey", gVar.f99235a);
            hashMap.put("moduleId", cVar.E.f99237c);
            hashMap.put("contentId", cVar.E.f99238d);
        }
        P2(hashMap, cVar);
        serializableMap.wrapMap(hashMap);
        bundle.putSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP, serializableMap);
        if (W2 != null && !TextUtils.isEmpty(W2.mPsKeyHost)) {
            bundle.putString("domain", W2.mPsKeyHost);
        }
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(bundle);
        openHippyInfo.fragmentClass = VipComicMainHippyFragment.class;
        IHippyAccessHelper iHippyAccessHelper = (IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class);
        Context context = activity;
        if (activity == null) {
            context = com.tencent.comic.utils.a.b();
        }
        iHippyAccessHelper.openHippyPage(context, openHippyInfo);
    }

    private void p3(c cVar, boolean z16) {
        if (cVar.f99222u) {
            this.f99171a0.sendEmptyMessage(1000);
        }
        boolean isModuleRunning = QIPCServerHelper.getInstance().isModuleRunning(IQQComicPluginUtil.COMIC_PLUGIN_ID);
        this.f99176f0 = isModuleRunning;
        if (!isModuleRunning) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicDebug", 2, "plugin is not running...");
            }
            if (!z16) {
                SystemClock.sleep(500L);
            }
            QQComicPluginBridge.h(this, null);
            ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", cVar.f99204c, 0, String.valueOf(System.currentTimeMillis() - cVar.f99203b), "1");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "plugin is running...");
        }
    }

    private static void t3(Activity activity, c cVar, ArrayList<WebViewTabBarData> arrayList) {
        String str = cVar.f99212k;
        int Y2 = str != null ? Y2(str, arrayList) : 0;
        WebViewTabBarData webViewTabBarData = arrayList.get(Y2);
        webViewTabBarData.url = com.tencent.comic.utils.h.a(webViewTabBarData.url, "isDefaultTab=1");
        String str2 = cVar.f99213l;
        if (str2 != null) {
            Y2 = A3(str2);
        }
        if (!TextUtils.isEmpty(cVar.f99207f) && Y2 >= 0 && Y2 < arrayList.size()) {
            WebViewTabBarData webViewTabBarData2 = arrayList.get(Y2);
            webViewTabBarData2.url = com.tencent.comic.utils.h.a(webViewTabBarData2.url, "extUrlParam=" + URLEncoder.encode(cVar.f99207f));
        }
        u3(activity, cVar, arrayList, Y2, 0);
    }

    private static void u3(Activity activity, c cVar, ArrayList<WebViewTabBarData> arrayList, int i3, int i16) {
        Intent intent = new Intent();
        intent.putExtra(QQBrowserActivity.TAB_CONFIG_DATA, arrayList);
        intent.putExtra("reportSourceFrom", cVar.f99204c);
        intent.putExtra("startOpenPageTime", cVar.f99202a);
        intent.putExtra("key_maintab", i3);
        intent.putExtra(QQBrowserActivity.TAB_DEFAULT_INDEX, i3);
        intent.putExtra("key_subtab", i16);
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, TextUtils.isEmpty(cVar.f99214m) ? activity.getString(R.string.button_back) : cVar.f99214m);
        int i17 = cVar.f99204c;
        if (i17 == 1006002 || i17 == 1006003) {
            intent.putExtra("individuation_url_type", i17 == 1006002 ? VasWebviewConstants.REPORT_FROM_DYNAMIC : VasWebviewConstants.REPORT_FROM_DYNAMIC_MORE);
        }
        if (cVar.f99219r) {
            intent.setFlags(intent.getFlags() | 67108864 | 268435456);
        }
        VipComicHelper.f(activity, intent, -1);
    }

    private static JSONObject w3(Intent intent, c cVar) {
        JSONObject optJSONObject;
        JSONObject jSONObject = null;
        try {
            String stringExtra = intent.getStringExtra("options");
            if (TextUtils.isEmpty(stringExtra)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(stringExtra);
            try {
                cVar.f99204c = jSONObject2.optInt("from");
                cVar.f99206e = jSONObject2.optString("from");
                cVar.f99205d = jSONObject2.optString("mod");
                cVar.f99207f = jSONObject2.optString("extUrlParam");
                cVar.f99208g = jSONObject2.optString(ISchemeApi.KEY_REFERER);
                if (TextUtils.isEmpty(cVar.f99207f) && (optJSONObject = jSONObject2.optJSONObject("comic")) != null) {
                    cVar.f99207f = optJSONObject.optString("extUrlParam");
                }
                cVar.E = new g(jSONObject2.optString("lastPageKey"), jSONObject2.optString("pageId"), jSONObject2.optString("moduleId", "0"), jSONObject2.optString("contentId", "0"));
                return jSONObject2;
            } catch (Exception e16) {
                e = e16;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static void x3(c cVar, Bundle bundle) {
        int i3 = bundle.getInt("type", -1);
        if (i3 >= 100 && i3 <= 300) {
            cVar.f99209h = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
        } else {
            cVar.f99209h = "com.qqcomic.reader.VipComicReadingActivityV2";
        }
        b bVar = new b();
        cVar.f99211j = bVar;
        bVar.f99194a = bundle.getString(ComicCancelRedPointPopItemData.JSON_KEY_COMIC_ID);
        cVar.f99211j.f99195b = bundle.getString("sectionId");
        cVar.f99211j.f99196c = bundle.getString("pictureId");
        cVar.f99211j.f99197d = bundle.getInt("offset", -1);
        cVar.f99211j.f99198e = bundle.getInt("type", -1);
        cVar.f99211j.f99200g = bundle.getInt("player", 2);
        String str = "";
        cVar.f99211j.f99201h = bundle.getString("cloudUrl", "");
        if ("com.qqcomic.activity.media.VipComicMediaPlayActivity".equals(cVar.f99209h)) {
            cVar.f99215n = false;
            cVar.f99218q = bundle.getBoolean("isPlayerLocked", false);
            boolean z16 = !bundle.getBoolean("supportMiniPlayer", false);
            cVar.f99220s = z16;
            if (!z16) {
                str = "init_player=1&";
            }
            cVar.f99211j.f99199f = getUrl("comicDetailVideo", null, null, "1", "354", null, str + "ADTAG=comic.plugin.fav&id=" + cVar.f99211j.f99194a);
            return;
        }
        cVar.f99216o = bundle.getBoolean("key_return_to_home");
        cVar.f99215n = true;
    }

    private static void z3(Intent intent, c cVar) {
        if (intent.hasExtra("banner_fromBanner") && intent.getBooleanExtra("banner_fromBanner", false)) {
            if (QLog.isColorLevel()) {
                QLog.d("VipComicJumpActivity", 2, "come from AIO Banner!");
            }
            b bVar = cVar.f99211j;
            if (bVar == null || TextUtils.isEmpty(bVar.f99194a)) {
                return;
            }
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(null, "100007", "2", "40040", cVar.f99211j.f99194a, new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        c y36 = y3(getIntent());
        this.f99181k0 = y36;
        if (f3(getAppRuntime(), this, y36)) {
            finish();
            return true;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
        intentFilter.addAction("com.tencent.mobileqq.PreLoadComicProcess");
        this.f99172b0 = new e();
        getApplicationContext().registerReceiver(this.f99172b0, intentFilter);
        if (QLog.isColorLevel()) {
            QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate registerReceiver");
        }
        setContentView(R.layout.f167472di1);
        setTitle("QQ\u52a8\u6f2b");
        this.f99179i0 = (TextView) findViewById(R.id.r_v);
        this.f99180j0 = (TextView) findViewById(R.id.r_w);
        this.f99171a0 = new WeakReferenceHandler(this);
        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", y36.f99204c, 0, String.valueOf(System.currentTimeMillis() - y36.f99203b));
        h3(y36);
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "finish.");
        }
        super.finish();
    }

    public void h3(final c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "init plugin start");
        }
        i3((AppInterface) getAppRuntime(), false);
        ThreadManagerV2.postImmediately(new PluginCheckJob(getAppRuntime()) { // from class: com.tencent.comic.VipComicJumpActivity.7
            @Override // java.lang.Runnable
            public void run() {
                AppRuntime appRuntime = this.f99190d.get();
                if (appRuntime == null) {
                    return;
                }
                if (QQComicPluginBridge.e(appRuntime)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicDebug", 2, "plugin is installed.");
                    }
                    VipComicJumpActivity.this.v3(cVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicDebug", 2, "wait for plugin installation...");
                }
                QQComicPluginBridge.b bVar = new QQComicPluginBridge.b();
                bVar.f99483d = new d(VipComicJumpActivity.this.f99171a0);
                boolean b16 = QQComicPluginBridge.b(appRuntime, true, bVar);
                VipComicJumpActivity vipComicJumpActivity = VipComicJumpActivity.this;
                vipComicJumpActivity.f99173c0 = bVar.f99480a;
                vipComicJumpActivity.f99174d0 = bVar.f99481b;
                if (!b16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicDebug", 2, "plugin install failed.");
                    }
                    VipComicJumpActivity.this.T2(cVar, bVar.f99482c);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicDebug", 2, "plugin is installed now.");
                    }
                    VipComicJumpActivity.this.v3(cVar);
                }
            }
        }, null, true);
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "init plugin end");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (this.f99181k0 == null) {
                    return false;
                }
                if (!this.f99177g0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicDebug", 2, "do handle launch activity.");
                    }
                    this.f99177g0 = true;
                    this.f99178h0 = true;
                    l3(this.f99181k0);
                    ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.f99181k0.f99204c, 0, String.valueOf(System.currentTimeMillis() - this.f99181k0.f99203b), "2");
                } else if (QLog.isColorLevel()) {
                    QLog.d("QQComicDebug", 2, "skip handle launch activity.");
                }
                return true;
            case 1001:
                String str = message.arg1 + "%";
                String valueOf = String.valueOf(message.obj);
                this.f99180j0.setText(str);
                this.f99179i0.setText(valueOf);
                return true;
            case 1002:
                finish();
                return true;
            default:
                return true;
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WeakReferenceHandler weakReferenceHandler = this.f99171a0;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeMessages(1000);
            this.f99171a0.removeMessages(1001);
        }
        this.f99182l0 = true;
        if (this.f99172b0 != null) {
            try {
                getApplicationContext().unregisterReceiver(this.f99172b0);
                if (QLog.isColorLevel()) {
                    QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate unregisterReceiver");
                }
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
            this.f99172b0 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "VipComicJumpActivity onDestroy");
        }
    }

    public static int Y2(String str, List<WebViewTabBarData> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).tag.equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    private static void r3(Activity activity, c cVar) {
        String str;
        ArrayList arrayList = new ArrayList();
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            dimensionPixelSize += ImmersiveUtils.getStatusBarHeight(activity);
        }
        int i3 = (int) ((dimensionPixelSize - 0.5f) / activity.getResources().getDisplayMetrics().density);
        List<f.a> j3 = com.tencent.comic.f.j();
        String str2 = "&redId=" + cVar.f99226y;
        if (j3 != null && !j3.isEmpty()) {
            for (f.a aVar : j3) {
                WebViewTabBarData webViewTabBarData = new WebViewTabBarData();
                String str3 = aVar.f99370e;
                webViewTabBarData.tag = str3;
                webViewTabBarData.tabName = aVar.f99371f;
                if (TextUtils.equals(str3, "index")) {
                    str = "&redDotIds=" + cVar.f99225x;
                } else {
                    str = "";
                }
                webViewTabBarData.url = com.tencent.comic.utils.h.a(aVar.f99372h, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a(aVar.f99370e) + "&_titleBarHeight=" + i3 + str + str2);
                webViewTabBarData.tabIcon = com.tencent.comic.f.h(aVar.f99373i);
                arrayList.add(webViewTabBarData);
            }
        } else {
            WebViewTabBarData webViewTabBarData2 = new WebViewTabBarData();
            webViewTabBarData2.tag = "index";
            webViewTabBarData2.tabName = "\u9996\u9875";
            webViewTabBarData2.url = getUrl("comicIndex", null, IPreloadResource.ABI_64, "5", "", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a("index") + "&_titleBarHeight=" + i3 + "&redDotIds=" + cVar.f99225x + str2);
            WebViewTabBarData webViewTabBarData3 = new WebViewTabBarData();
            webViewTabBarData3.tag = MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV;
            webViewTabBarData3.tabName = "\u6536\u85cf";
            webViewTabBarData3.url = getUrl("comicFav", null, "", "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV) + "&_titleBarHeight=" + i3 + str2);
            WebViewTabBarData webViewTabBarData4 = new WebViewTabBarData();
            webViewTabBarData4.tag = "category";
            webViewTabBarData4.tabName = QzoneConfig.DefaultValue.DEFAULT_LABEL_TEXT;
            webViewTabBarData4.url = getUrl("comicCategory", null, null, "1", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a("category") + "&_titleBarHeight=" + i3 + str2);
            WebViewTabBarData webViewTabBarData5 = new WebViewTabBarData();
            webViewTabBarData5.tag = "more";
            webViewTabBarData5.tabName = "\u793e\u533a";
            webViewTabBarData5.url = getUrl("comicMore", null, null, "1", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a("more") + "&_titleBarHeight=" + i3 + str2);
            WebViewTabBarData webViewTabBarData6 = new WebViewTabBarData();
            webViewTabBarData6.tag = VipFunCallConstants.KEY_GROUP;
            webViewTabBarData6.tabName = "\u90e8\u5c4b";
            webViewTabBarData6.url = getUrl("comicGroup", null, null, "1", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a(VipFunCallConstants.KEY_GROUP) + "&_titleBarHeight=" + i3 + str2);
            arrayList.add(webViewTabBarData2);
            arrayList.add(webViewTabBarData3);
            arrayList.add(webViewTabBarData4);
            arrayList.add(webViewTabBarData5);
            arrayList.add(webViewTabBarData6);
        }
        if (QLog.isColorLevel()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WebViewTabBarData webViewTabBarData7 = (WebViewTabBarData) it.next();
                QLog.d("VipComicJumpActivity", 2, "tabBar:tabKey=" + webViewTabBarData7.tag + ", tabName=" + webViewTabBarData7.tabName + ", tabUrl=" + webViewTabBarData7.url);
            }
        }
        t3(activity, cVar, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s3(int i3, f fVar, Activity activity, c cVar) {
        if (i3 != 0) {
            C3("\u542f\u52a8\u6ce2\u6d1e\u52a8\u6f2b\u5931\u8d25");
            if (fVar.f99234c != null) {
                fVar.f99234c.dismiss();
            }
        } else if (fVar.f99234c == null || (fVar.f99234c != null && !fVar.f99233b)) {
            n3(activity, cVar);
            QLog.i("VipComicJumpActivity", 1, "checkBoodoPlugin launchHippyPage ");
        }
        fVar.f99232a = false;
        synchronized (fVar) {
            fVar.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        com.tencent.mobileqq.qroute.module.e j3 = QRoute.plugin(IQQComicPluginUtil.COMIC_PLUGIN_ID).j();
        int i3 = 0;
        boolean booleanExtra = getIntent().getBooleanExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, false);
        if (this.f99181k0 != null) {
            String str = "1";
            if (j3 == null) {
                IQQComicUtil iQQComicUtil = (IQQComicUtil) QRoute.api(IQQComicUtil.class);
                int i16 = this.f99181k0.f99204c;
                String[] strArr = new String[4];
                strArr[0] = String.valueOf(System.currentTimeMillis() - this.f99181k0.f99203b);
                strArr[1] = "-9999";
                if (!this.f99176f0) {
                    if (this.f99177g0) {
                        i3 = this.f99178h0 ? 2 : 3;
                    } else {
                        i3 = 4;
                    }
                }
                strArr[2] = String.valueOf(i3);
                if (!booleanExtra) {
                    str = "0";
                }
                strArr[3] = str;
                iQQComicUtil.reportClickEventTo644(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", i16, 0, strArr);
            } else {
                IQQComicUtil iQQComicUtil2 = (IQQComicUtil) QRoute.api(IQQComicUtil.class);
                int i17 = this.f99181k0.f99204c;
                String[] strArr2 = new String[4];
                strArr2[0] = String.valueOf(System.currentTimeMillis() - this.f99181k0.f99203b);
                strArr2[1] = String.valueOf(j3.d());
                if (!this.f99176f0) {
                    if (this.f99177g0) {
                        i3 = this.f99178h0 ? 2 : 3;
                    } else {
                        i3 = 4;
                    }
                }
                strArr2[2] = String.valueOf(i3);
                if (!booleanExtra) {
                    str = "0";
                }
                strArr2[3] = str;
                iQQComicUtil2.reportClickEventTo644(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", i17, 0, strArr2);
            }
        }
        return super.onBackEvent();
    }

    private static void B3(final Activity activity, final f fVar) {
        if (fVar != null && fVar.f99232a) {
            Runnable runnable = new Runnable() { // from class: com.tencent.comic.VipComicJumpActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!activity.isFinishing()) {
                        fVar.f99234c = new com.tencent.comic.a(activity, fVar);
                        fVar.f99234c.show();
                        return;
                    }
                    QLog.e("VipComicJumpActivity", 1, "showHippyLoading activity is finish");
                }
            };
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(runnable);
            }
        }
    }

    public void l3(c cVar) {
        if (cVar == null) {
            return;
        }
        if (!cVar.f99222u) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicDebug", 2, "skip launch activity.");
            }
            finish();
        } else {
            S2(this, cVar);
            ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", cVar.f99204c, 0, String.valueOf(System.currentTimeMillis() - cVar.f99203b));
        }
    }

    public static c y3(Intent intent) {
        int i3;
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        JSONObject g36 = g3(intent, cVar);
        Bundle d16 = com.tencent.comic.g.d(null);
        if (d16 != null && ((i3 = cVar.f99204c) == 1006002 || i3 == 19 || i3 == 20)) {
            x3(cVar, d16);
        } else if (g36 != null) {
            e3(cVar, g36);
        }
        if (TextUtils.isEmpty(cVar.f99212k)) {
            cVar.f99212k = VipComicHelper.b();
        }
        z3(intent, cVar);
        return cVar;
    }

    void S2(Activity activity, c cVar) {
        if (activity == null || cVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "call start plugin activity start.");
        }
        if ("com.tencent.hippy.qq.fragment.CommonHippyFragment".equals(cVar.f99209h)) {
            QLog.i("VipComicJumpActivity", 1, "directStartPlugin openHippyPage param:" + cVar);
            return;
        }
        Intent intent = cVar.f99221t;
        intent.putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
        intent.putExtra("startOpenPageTime", cVar.f99202a);
        intent.putExtra(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, this.f99173c0);
        if (!TextUtils.isEmpty(cVar.f99210i)) {
            intent.putExtra("url", cVar.f99210i);
        }
        QLog.i("VipComicJumpActivity", 2, "[directStartPlugin] param.jumpConponentName = " + cVar.f99209h);
        if (cVar.f99211j != null) {
            if (cVar.f99209h.equals("com.qqcomic.reader.VipComicReadingActivityV2")) {
                cVar.f99209h = "com.qqcomic.reader.VipComicReadingActivityV2";
                intent.putExtra("req_comicId", cVar.f99211j.f99194a);
                intent.putExtra("req_sectionId", cVar.f99211j.f99195b);
                intent.putExtra("req_picId", cVar.f99211j.f99196c);
            } else {
                intent.putExtra("key_comic_id", cVar.f99211j.f99194a);
                intent.putExtra("key_section_id", cVar.f99211j.f99195b);
                intent.putExtra("key_pic_id", cVar.f99211j.f99196c);
                intent.putExtra("key_pic_offset_ratio", cVar.f99211j.f99197d);
                intent.putExtra("key_type", cVar.f99211j.f99198e);
                intent.putExtra("key_jump_from_out_plugin", true);
                intent.putExtra("key_return_to_detail", cVar.f99215n);
                intent.putExtra("key_return_to_home", cVar.f99216o);
                intent.putExtra("key_is_player_locked", cVar.f99218q);
                intent.putExtra("key_return_to_home_from_detail", cVar.f99217p);
                intent.putExtra("key_is_fullscreen", cVar.f99220s);
                intent.putExtra("key_video_player_type", cVar.f99211j.f99200g);
                intent.putExtra("key_cloud_url", cVar.f99211j.f99201h);
                if (!TextUtils.isEmpty(cVar.f99211j.f99199f)) {
                    intent.putExtra("url", cVar.f99211j.f99199f);
                }
            }
        }
        intent.putExtra("key_from_out_entry", true);
        intent.putExtra("key_extUrlParam", cVar.f99207f);
        QLog.d("VipComicJumpActivity", 1, "directStartPlugin key_extUrlParam mExtUrlParam:", cVar.f99207f);
        intent.putExtra("key_source_from", cVar.f99204c);
        intent.putExtra("key_referer", cVar.f99208g);
        if (cVar.f99204c != 6) {
            String str = cVar.f99205d;
            if (TextUtils.isEmpty(str)) {
                str = cVar.f99206e;
            }
            intent.putExtra("key_mod", str);
        }
        if (TextUtils.isEmpty(cVar.f99214m)) {
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.button_back));
        } else {
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, cVar.f99214m);
        }
        if (cVar.f99219r) {
            intent.addFlags(67108864);
        }
        QQComicPluginBridge.f(activity, intent, cVar.f99209h, Z2(cVar, intent));
        QLog.d("QQComicDebug", 2, "call start plugin activity end.");
    }

    void v3(c cVar) {
        boolean z16;
        if (cVar == null) {
            return;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:tool".equals(it.next().processName)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if ("com.tencent.hippy.qq.fragment.CommonHippyFragment".equals(cVar.f99209h)) {
            QQComicPluginBridge.h(this, cVar.D);
            this.f99171a0.removeMessages(1002);
            this.f99171a0.sendEmptyMessageDelayed(1002, 10000L);
            ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", cVar.f99204c, 0, String.valueOf(System.currentTimeMillis() - cVar.f99203b), "1");
            return;
        }
        p3(cVar, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void T2(c cVar, int i3) {
        String str;
        String str2;
        long j3;
        String str3;
        long j16;
        String str4;
        if (cVar == null) {
            return;
        }
        this.f99175e0 = System.currentTimeMillis();
        String str5 = "1";
        try {
            AppRuntime appRuntime = getAppRuntime();
            if (appRuntime instanceof AppInterface) {
                int privilegeFlags = ((IVasSingedApi) appRuntime.getRuntimeService(IVasSingedApi.class, "all")).getVipStatus().getPrivilegeFlags(null);
                if ((privilegeFlags & 4) != 0) {
                    str4 = "3";
                } else if ((privilegeFlags & 2) != 0) {
                    str4 = "2";
                }
                str5 = str4;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        String str6 = "0";
        if (this.f99176f0) {
            str = "-1";
        } else {
            long j17 = cVar.f99203b;
            if (j17 != 0) {
                long j18 = this.f99173c0;
                if (j18 != 0 && j18 > j17) {
                    str = (this.f99173c0 - cVar.f99203b) + "";
                }
            }
            str = "0";
        }
        long j19 = this.f99174d0;
        if (j19 != 0) {
            long j26 = this.f99173c0;
            if (j26 != 0 && j19 > j26) {
                str2 = (this.f99174d0 - this.f99173c0) + "";
                j3 = this.f99174d0;
                if (j3 != 0) {
                    long j27 = this.f99175e0;
                    if (j27 != 0 && j27 > j3) {
                        str3 = (this.f99175e0 - this.f99174d0) + "";
                        j16 = cVar.f99203b;
                        if (j16 != 0) {
                            long j28 = this.f99175e0;
                            if (j28 != 0 && j28 > j16) {
                                str6 = (this.f99175e0 - cVar.f99203b) + "";
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("VipComicJumpActivity", 2, "downloadCost:" + str + ", installCost:" + str2 + ", launchCost:" + str3 + ", allCost:" + str6 + ",[startTime-launchTime]=[" + cVar.f99203b + "-" + this.f99175e0 + "]");
                        }
                        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X80052CA", "0X80052CA", cVar.f99204c, i3, str5);
                        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005359", "0X8005359", cVar.f99204c, i3, str, str2, str3, str6);
                    }
                }
                str3 = "0";
                j16 = cVar.f99203b;
                if (j16 != 0) {
                }
                if (QLog.isColorLevel()) {
                }
                ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X80052CA", "0X80052CA", cVar.f99204c, i3, str5);
                ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005359", "0X8005359", cVar.f99204c, i3, str, str2, str3, str6);
            }
        }
        str2 = "0";
        j3 = this.f99174d0;
        if (j3 != 0) {
        }
        str3 = "0";
        j16 = cVar.f99203b;
        if (j16 != 0) {
        }
        if (QLog.isColorLevel()) {
        }
        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X80052CA", "0X80052CA", cVar.f99204c, i3, str5);
        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005359", "0X8005359", cVar.f99204c, i3, str, str2, str3, str6);
    }

    public static Intent V2(AppRuntime appRuntime, c cVar) {
        if (appRuntime == null || cVar == null) {
            return null;
        }
        D3(appRuntime, cVar);
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "[getBackgroundQQComicIntent] handle param parse red touch end");
        }
        ArrayList arrayList = new ArrayList();
        WebViewTabBarData webViewTabBarData = new WebViewTabBarData();
        webViewTabBarData.tag = "\u9996\u9875";
        webViewTabBarData.tabName = "\u9996\u9875";
        webViewTabBarData.url = getUrl("comicIndex", null, IPreloadResource.ABI_64, "5", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a("index"));
        WebViewTabBarData webViewTabBarData2 = new WebViewTabBarData();
        webViewTabBarData2.tag = "\u6536\u85cf";
        webViewTabBarData2.tabName = "\u6536\u85cf";
        webViewTabBarData2.url = getUrl("comicFav", null, null, "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV));
        WebViewTabBarData webViewTabBarData3 = new WebViewTabBarData();
        webViewTabBarData3.tag = QzoneConfig.DefaultValue.DEFAULT_LABEL_TEXT;
        webViewTabBarData3.tabName = QzoneConfig.DefaultValue.DEFAULT_LABEL_TEXT;
        webViewTabBarData3.url = getUrl("comicCategory", null, null, "1", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a("category"));
        WebViewTabBarData webViewTabBarData4 = new WebViewTabBarData();
        webViewTabBarData4.tag = "\u793e\u533a";
        webViewTabBarData4.tabName = "\u793e\u533a";
        webViewTabBarData4.url = getUrl("comicMore", null, null, "1", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a("more"));
        WebViewTabBarData webViewTabBarData5 = new WebViewTabBarData();
        webViewTabBarData5.tag = "\u90e8\u5c4b";
        webViewTabBarData5.tabName = "\u90e8\u5c4b";
        webViewTabBarData5.url = getUrl("comicGroup", null, null, "1", "354", null, "_cfrom=" + cVar.f99204c + "&hasRedDot=" + cVar.a(VipFunCallConstants.KEY_GROUP));
        arrayList.add(webViewTabBarData);
        arrayList.add(webViewTabBarData2);
        arrayList.add(webViewTabBarData3);
        arrayList.add(webViewTabBarData4);
        arrayList.add(webViewTabBarData5);
        Intent intent = new Intent();
        intent.putExtra(QQBrowserActivity.TAB_CONFIG_DATA, arrayList);
        intent.putExtra("reportSourceFrom", cVar.f99204c);
        intent.putExtra("startOpenPageTime", cVar.f99202a);
        intent.setFlags(intent.getFlags() | 67108864 | 268435456);
        intent.putExtra("fragmentStyle", 1);
        intent.putExtra("tabBarStyle", 1);
        intent.putExtra("titleBarStyle", 1);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("isScreenOrientationPortrait", true);
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "[getBackgroundQQComicIntent] finish");
        }
        return intent;
    }

    static void D3(AppRuntime appRuntime, c cVar) {
        IQQComicRedTouchService iQQComicRedTouchService;
        boolean isLebaItemOpen;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Map<String, Object> redAppInfo;
        List<n> list;
        LebaPluginInfo lebaPluginInfo;
        if (appRuntime == null || cVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo start");
        }
        boolean z16 = appRuntime instanceof BaseQQAppInterface;
        if (z16) {
            ILebaHelperService iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI);
            iQQComicRedTouchService = null;
            if (iLebaHelperService != null) {
                list = iLebaHelperService.getLebaMgrList();
            } else {
                QLog.d("VipComicJumpActivity", 1, "updateRedAppInfo lebaHelperService == null");
                list = null;
            }
            if (list != null) {
                for (n nVar : list) {
                    if (nVar != null && (lebaPluginInfo = nVar.f240505b) != null && lebaPluginInfo.uiResId == 1113) {
                        isLebaItemOpen = nVar.d();
                        break;
                    }
                }
            }
            isLebaItemOpen = false;
        } else {
            iQQComicRedTouchService = (IQQComicRedTouchService) appRuntime.getRuntimeService(IQQComicRedTouchService.class, "all");
            if (iQQComicRedTouchService == null) {
                return;
            } else {
                isLebaItemOpen = iQQComicRedTouchService.isLebaItemOpen(1113);
            }
        }
        if (isLebaItemOpen) {
            str6 = String.valueOf(1113);
            str5 = "1113." + BusinessInfoCheckUpdateItem.UIAPPID_QQCOMIC_HOME;
            str = "1113." + BusinessInfoCheckUpdateItem.UIAPPID_QQCOMIC_MORE;
            str2 = "1113." + BusinessInfoCheckUpdateItem.UIAPPID_QQCOMIC_GROUP;
            str3 = "1113." + BusinessInfoCheckUpdateItem.UIAPPID_QQCOMIC_CATEGORY;
            str4 = "1113." + BusinessInfoCheckUpdateItem.UIAPPID_QQCOMIC_FAV;
        } else {
            String str7 = "100600.100001113." + BusinessInfoCheckUpdateItem.UIAPPID_MORE_QQCOMIC_HOME;
            str = "100600.100001113." + BusinessInfoCheckUpdateItem.UIAPPID_MORE_QQCOMIC_MORE;
            str2 = "100600.100001113." + BusinessInfoCheckUpdateItem.UIAPPID_MORE_QQCOMIC_GROUP;
            str3 = "100600.100001113." + BusinessInfoCheckUpdateItem.UIAPPID_MORE_QQCOMIC_CATEGORY;
            str4 = "100600.100001113." + BusinessInfoCheckUpdateItem.UIAPPID_MORE_QQCOMIC_FAV;
            str5 = str7;
            str6 = "100600.100001113";
        }
        if (z16) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "");
            if (iRedTouchManager == null) {
                return;
            }
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(str6);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(str5);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath3 = iRedTouchManager.getAppInfoByPath(str);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath4 = iRedTouchManager.getAppInfoByPath(str2);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath5 = iRedTouchManager.getAppInfoByPath(str3);
            BusinessInfoCheckUpdate.AppInfo appInfoByPath6 = iRedTouchManager.getAppInfoByPath(str4);
            cVar.b("index", (appInfoByPath2 == null || appInfoByPath2.iNewFlag.get() == 0) ? false : true);
            cVar.b(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV, (appInfoByPath6 == null || appInfoByPath6.iNewFlag.get() == 0) ? false : true);
            cVar.b("category", (appInfoByPath5 == null || appInfoByPath5.iNewFlag.get() == 0) ? false : true);
            cVar.b("more", (appInfoByPath3 == null || appInfoByPath3.iNewFlag.get() == 0) ? false : true);
            cVar.b(VipFunCallConstants.KEY_GROUP, (appInfoByPath4 == null || appInfoByPath4.iNewFlag.get() == 0) ? false : true);
            if (appInfoByPath != null && cVar.f99224w) {
                E3(appInfoByPath.buffer.get(), appInfoByPath.missions.get(), cVar);
                cVar.f99225x = R2(appInfoByPath.missions.get());
                cVar.f99226y = c3(appInfoByPath.buffer.get());
                cVar.f99227z = U2(appInfoByPath.buffer.get());
                cVar.A = b3(appInfoByPath.buffer.get());
            }
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str6);
            arrayList.add(str5);
            arrayList.add(str4);
            arrayList.add(str3);
            arrayList.add(str);
            arrayList.add(str2);
            if (iQQComicRedTouchService == null || (redAppInfo = iQQComicRedTouchService.getRedAppInfo(arrayList)) == null) {
                return;
            }
            RedAppInfo redAppInfo2 = (RedAppInfo) redAppInfo.get(str6);
            RedAppInfo redAppInfo3 = (RedAppInfo) redAppInfo.get(str5);
            RedAppInfo redAppInfo4 = (RedAppInfo) redAppInfo.get(str);
            RedAppInfo redAppInfo5 = (RedAppInfo) redAppInfo.get(str2);
            RedAppInfo redAppInfo6 = (RedAppInfo) redAppInfo.get(str3);
            RedAppInfo redAppInfo7 = (RedAppInfo) redAppInfo.get(str4);
            cVar.b("index", (redAppInfo3 == null || redAppInfo3.M() == 0) ? false : true);
            cVar.b(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV, (redAppInfo7 == null || redAppInfo7.M() == 0) ? false : true);
            cVar.b("category", (redAppInfo6 == null || redAppInfo6.M() == 0) ? false : true);
            cVar.b("more", (redAppInfo4 == null || redAppInfo4.M() == 0) ? false : true);
            cVar.b(VipFunCallConstants.KEY_GROUP, (redAppInfo5 == null || redAppInfo5.M() == 0) ? false : true);
            if (redAppInfo2 != null && cVar.f99224w) {
                E3(redAppInfo2.t(), redAppInfo2.z(), cVar);
                cVar.f99225x = R2(redAppInfo2.z());
                cVar.f99226y = c3(redAppInfo2.t());
                cVar.f99227z = U2(redAppInfo2.t());
                cVar.A = b3(redAppInfo2.t());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo end");
        }
    }

    public static boolean f3(AppRuntime appRuntime, Activity activity, c cVar) {
        String str;
        if (appRuntime != null && activity != null && cVar != null) {
            QLog.d("QQComicDebug", 2, "handle param start");
            if (L2(appRuntime, activity, cVar, "com.qqcomic.activity.VipComicMainTabActivity".equals(cVar.f99209h) && cVar.f99212k == null)) {
                return true;
            }
            if ("com.qqcomic.activity.VipComicMainTabActivity".equals(cVar.f99209h)) {
                return N2(appRuntime, activity, cVar);
            }
            if ("com.qqcomic.activity.VipComicTabBrowserActivity".equals(cVar.f99209h)) {
                Intent intent = new Intent();
                intent.putExtra("url", cVar.f99210i);
                intent.putExtra("reportSourceFrom", cVar.f99204c);
                intent.putExtra("startOpenPageTime", cVar.f99202a);
                if (TextUtils.isEmpty(cVar.f99214m)) {
                    str = activity.getString(R.string.button_back);
                } else {
                    str = cVar.f99214m;
                }
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, str);
                VipComicHelper.f(activity, intent, -1);
                ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", cVar.f99204c, 0, String.valueOf(System.currentTimeMillis() - cVar.f99203b));
                QLog.d("QQComicDebug", 2, "handle param open web end");
                return true;
            }
            cVar.f99222u = true;
            QLog.d("QQComicDebug", 2, "handle param end");
        }
        return false;
    }
}
