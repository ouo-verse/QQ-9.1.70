package com.qzone.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.activities.base.BaseActivity;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneCustomToast {

    /* renamed from: j, reason: collision with root package name */
    private static View f60453j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f60454k;

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f60460a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager.LayoutParams f60461b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f60462c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f60463d;

    /* renamed from: e, reason: collision with root package name */
    private long f60464e;

    /* renamed from: f, reason: collision with root package name */
    private View f60465f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f60466g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f60467h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f60452i = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_USERHOME_DYNAMIC_SETTING_URL, "https://h5.qzone.qq.com/specialcare/setting?_wv=3&uin={uin}&hostuin={hostuin}&isstar={isstar}");

    /* renamed from: l, reason: collision with root package name */
    public static final String f60455l = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewDoNotMissAnyMood", "\u5df2\u5173\u6ce8\u3002\u4e0d\u60f3\u9519\u8fc7TA\u7684\u4efb\u4f55\u52a8\u6001\uff1f");

    /* renamed from: m, reason: collision with root package name */
    public static final String f60456m = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewSpecialFollowGuide", "\u8bbe\u7f6e\u7279\u522b\u5173\u6ce8\uff0c\u4e0d\u9519\u8fc7TA\u7684\u4efb\u4f55\u52a8\u6001");

    /* renamed from: n, reason: collision with root package name */
    private static Runnable f60457n = new Runnable() { // from class: com.qzone.widget.QZoneCustomToast.2
        @Override // java.lang.Runnable
        public void run() {
            QZoneCustomToast.a();
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private static boolean f60458o = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f60459p = false;

    QZoneCustomToast(String str, long j3, long j16, boolean z16) {
        this.f60467h = false;
        d();
        this.f60467h = !z16;
        if (this.f60463d) {
            this.f60465f.setOnTouchListener(new a());
            ((TextView) this.f60465f.findViewById(R.id.izz)).setText(str);
            ImageView imageView = this.f60466g;
            if (imageView != null) {
                if (!z16) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            this.f60464e = j16;
        }
    }

    public static void a() {
        if (f60454k) {
            try {
                ThreadManager.getUIHandler().removeCallbacks(f60457n);
                BaseApplication context = BaseApplication.getContext();
                if (context != null) {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    View view = f60453j;
                    if (view != null) {
                        windowManager.removeView(view);
                    }
                    f60454k = false;
                }
            } catch (Exception e16) {
                QZLog.e("QZoneCustomToast", "cancel() catch an exception.", e16);
            }
        }
    }

    private static int b() {
        try {
            return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return (int) ((Resources.getSystem().getDisplayMetrics().density * 44.0f) + 0.5d);
        }
    }

    private void d() {
        if (this.f60463d) {
            return;
        }
        try {
            Activity topActivity = BaseActivity.getTopActivity();
            if (topActivity == null) {
                return;
            }
            this.f60462c = LayoutInflater.from(topActivity);
            this.f60460a = (WindowManager) topActivity.getSystemService("window");
            View inflate = this.f60462c.inflate(R.layout.brf, (ViewGroup) null);
            this.f60465f = inflate;
            this.f60466g = (ImageView) inflate.findViewById(R.id.izy);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f60461b = layoutParams;
            layoutParams.height = ViewUtils.dpToPx(44.0f);
            WindowManager.LayoutParams layoutParams2 = this.f60461b;
            layoutParams2.width = -1;
            layoutParams2.format = -3;
            this.f60465f.getAnimation();
            layoutParams2.windowAnimations = -1;
            WindowManager.LayoutParams layoutParams3 = this.f60461b;
            layoutParams3.flags = 262184;
            layoutParams3.gravity = 49;
            layoutParams3.y = c(topActivity);
            this.f60461b.type = 2;
            this.f60463d = true;
        } catch (Exception e16) {
            QZLog.e("QZoneCustomToast", "initUI() catch an exception.", e16);
            this.f60463d = false;
        }
    }

    private static boolean e() {
        if (f60458o) {
            return f60459p;
        }
        f60459p = false;
        if (!TextUtils.isEmpty(DeviceInfoMonitor.getModel())) {
            f60458o = true;
            String str = Build.MANUFACTURER;
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("I9500");
            }
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("N7108");
            }
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("x3t");
            }
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("MI 2");
            }
            if ("oppo".equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("r2017");
            }
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("m351");
            }
            if ("HUAWEI".equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("H30-T00");
            }
            if ("Lenovo".equalsIgnoreCase(str)) {
                DeviceInfoMonitor.getModel().contains("S968T");
            }
        }
        return f60459p;
    }

    private void f() {
        if (this.f60463d) {
            if (f60454k) {
                a();
            }
            try {
                this.f60460a.addView(this.f60465f, this.f60461b);
                f60453j = this.f60465f;
                f60454k = true;
                ThreadManager.getUIHandler().postDelayed(f60457n, this.f60464e);
                if (this.f60467h) {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_SPECIAL_FOLLOW_TOAST, 1, 2);
                }
                LpReportInfo_pf00064.allReport(308, 83, 1);
            } catch (Exception e16) {
                QZLog.e("QZoneCustomToast", "show() catch an exception.", e16);
            }
        }
    }

    public static void g(String str, long j3, long j16, boolean z16) {
        try {
            if (!TextUtils.isEmpty(str) && j3 > 0 && j16 >= 0) {
                new QZoneCustomToast(str, j3, j16, z16).f();
            }
        } catch (Exception e16) {
            QZLog.e("QZoneCustomToast", "showToast() catch an exception.", e16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 0) {
                return false;
            }
            QZoneCustomToast.a();
            return true;
        }
    }

    private static int c(Context context) {
        int dimensionPixelSize;
        int dpToPx;
        if (context == null || context.getResources() == null) {
            return 0;
        }
        Resources resources = context.getResources();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("the brand of phone is ");
        String str = Build.BRAND;
        sb5.append(str);
        QZLog.d("QZoneCustomToast", 2, sb5.toString());
        if ("oppo".equalsIgnoreCase(str) && !TextUtils.isEmpty(DeviceInfoMonitor.getModel()) && DeviceInfoMonitor.getModel().contains("R9")) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.title_bar_height);
            dpToPx = ViewUtils.dpToPx(7.0f);
        } else {
            String str2 = Build.MANUFACTURER;
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str2) || "Oppo".equalsIgnoreCase(str2)) {
                DeviceInfoMonitor.getModel().contains("MI NOTE LTE");
            }
            if ("HUAWEI".equalsIgnoreCase(str2)) {
                DeviceInfoMonitor.getModel().contains("H30-U10");
            }
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str2) && DeviceInfoMonitor.getModel().contains("MI 5")) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.title_bar_height);
                dpToPx = ViewUtils.dpToPx(5.0f);
            } else {
                if (e()) {
                    return b();
                }
                return resources.getDimensionPixelSize(R.dimen.title_bar_height);
            }
        }
        return dimensionPixelSize + dpToPx;
    }
}
