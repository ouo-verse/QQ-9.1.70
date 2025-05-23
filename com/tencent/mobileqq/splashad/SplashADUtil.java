package com.tencent.mobileqq.splashad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SplashADUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f288714a;

    /* renamed from: b, reason: collision with root package name */
    public static long f288715b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288714a = 0L;
            f288715b = 0L;
        }
    }

    public static void A() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        from.encodeInt(q(), from.decodeInt(q(), 0) + 1);
    }

    public static void B() {
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.splashad.SplashADUtil.2
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
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SplashADUtil.D(2);
                    SplashADUtil.A();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 200L);
    }

    public static void C() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        String g16 = g(2);
        from.encodeInt(g16, from.decodeInt(g16, 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(int i3) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        from.encodeInt(o(i3), from.decodeInt(o(i3), 0) + 1);
    }

    public static void E(int i3, boolean z16) {
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.splashad.SplashADUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f288716d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f288717e;

            {
                this.f288716d = z16;
                this.f288717e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
                if (!this.f288716d && (i16 = this.f288717e) == 2) {
                    from.encodeInt(SplashADUtil.m(this.f288717e), from.decodeInt(SplashADUtil.m(i16), 0) + 1);
                }
                int i17 = this.f288717e;
                if (i17 == 1) {
                    SplashADUtil.D(i17);
                    ArrayList<Integer> splashAdPriority = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashAdPriority();
                    if (splashAdPriority.size() > 2 && splashAdPriority.get(1).intValue() == 1) {
                        SplashEmptyReportHelper.f288736a.d(!this.f288716d, false, 1001);
                    }
                }
                int i18 = this.f288717e;
                if (i18 == 2) {
                    SplashADUtil.D(i18);
                    SplashADUtil.C();
                }
                SplashADUtil.A();
            }
        }, 200L);
    }

    public static GradientDrawable d(String str, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(Math.max(i3, 0));
        gradientDrawable.setColor(r(str));
        return gradientDrawable;
    }

    public static Bitmap e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            return com.tencent.mobileqq.util.j.d(str, options);
        } catch (OutOfMemoryError e16) {
            QLog.e("SplashAD", 1, e16.toString());
            return null;
        }
    }

    private static int f() {
        return ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAMSNormalSplashLimit();
    }

    private static String g(int i3) {
        String str = i(BaseApplicationImpl.getApplication()) + p();
        if (i3 == 2) {
            return str + "amsNormalSplashShow";
        }
        return str + "splashShow";
    }

    public static int h() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        int i3 = 0;
        for (int i16 = -6; i16 <= 0; i16++) {
            int decodeInt = from.decodeInt(k(i16), 0);
            i3 += decodeInt;
            QLog.d("SplashAD", 1, "getLastWeekSplashShowTime dayOffset:", Integer.valueOf(i16), ", dailyCount:", Integer.valueOf(decodeInt));
        }
        return i3;
    }

    public static long i(Context context) {
        if (f288714a == 0) {
            f288714a = cooperation.vip.ad.i.g().getLong("splash_ad_uin_long", 0L);
        }
        return f288714a;
    }

    public static String j(int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, i3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return String.valueOf(calendar.getTimeInMillis());
    }

    public static String k(int i3) {
        return i(BaseApplicationImpl.getApplication()) + j(i3) + "splashShow";
    }

    private static int l(int i3) {
        if (i3 == 2) {
            return ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAMSHotSplashLimit();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m(int i3) {
        String str = i(BaseApplicationImpl.getApplication()) + p();
        if (i3 == 2) {
            return str + "amsHotSplashLimitDay";
        }
        return str + "splashShow";
    }

    private static int n(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return 0;
            }
            return ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAMSSplashLimit();
        }
        return ((IGdtAPI) QRoute.api(IGdtAPI.class)).getTianShuSplashLimit();
    }

    private static String o(int i3) {
        String str = i(BaseApplicationImpl.getApplication()) + p();
        if (i3 != 1) {
            if (i3 != 2) {
                return str + "splashShow";
            }
            return str + "amsSplashShow";
        }
        return str + "tianshuSplashShow";
    }

    public static String p() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return String.valueOf(calendar.getTimeInMillis());
    }

    public static String q() {
        return i(BaseApplicationImpl.getApplication()) + p() + "splashShow";
    }

    public static int r(String str) {
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("SplashAD", 1, "  getValidTextColor error color = " + str, e16);
            return -16777216;
        }
    }

    public static boolean s() {
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeInt(q(), 0);
        int splashDailyLimit = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashDailyLimit();
        int splashWeeklyLimit = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashWeeklyLimit();
        QLog.d("SplashAD", 1, "splash today show time is " + decodeInt + ", mc daily limit is " + splashDailyLimit);
        if (splashWeeklyLimit < 0) {
            if (decodeInt < splashDailyLimit) {
                return false;
            }
            return true;
        }
        int h16 = h();
        QLog.d("SplashAD", 1, "splash last week show time is " + h16 + ", mc weekly limit is " + splashWeeklyLimit);
        if (decodeInt < splashDailyLimit && h16 < splashWeeklyLimit) {
            return false;
        }
        return true;
    }

    public static boolean t() {
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeInt(o(2), 0);
        int n3 = n(2);
        QLog.d("SplashAD", 1, "AmsSplashExceedLimit total show time is " + decodeInt + " mc limit is " + n3);
        if (decodeInt < n3) {
            return false;
        }
        return true;
    }

    private static boolean u(int i3, boolean z16) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        if (!z16 && i3 == 2) {
            int decodeInt = from.decodeInt(m(i3), 0);
            int l3 = l(i3);
            QLog.d("SplashAD", 1, "bizType: " + i3 + ", hot splash show time is " + decodeInt + " mc limit is " + l3);
            if (decodeInt >= l3) {
                SplashEmptyReportHelper.f288736a.d(true, false, 1002);
                return true;
            }
        }
        if (i3 == 2) {
            int decodeInt2 = from.decodeInt(g(i3), 0);
            int f16 = f();
            QLog.d("SplashAD", 1, "bizType: " + i3 + ", normal splash show time is " + decodeInt2 + " total mc limit is " + f16);
            if (decodeInt2 >= f16) {
                SplashEmptyReportHelper.f288736a.d(!z16, false, 1002);
                return true;
            }
        }
        if (i3 == 2 || i3 == 1) {
            int decodeInt3 = from.decodeInt(o(i3), 0);
            int n3 = n(i3);
            QLog.d("SplashAD", 1, "bizType: " + i3 + ", splash show time is " + decodeInt3 + " total mc limit is " + n3);
            if (decodeInt3 >= n3) {
                if (i3 == 2) {
                    SplashEmptyReportHelper.f288736a.d(!z16, false, 1002);
                }
                return true;
            }
        }
        return s();
    }

    public static boolean v(Activity activity) {
        boolean z16;
        Intent intent = activity.getIntent();
        Set<String> categories = intent.getCategories();
        String action = intent.getAction();
        QLog.i("SplashAD", 1, "categories " + categories + " action " + action);
        if (categories != null && categories.contains("android.intent.category.LAUNCHER") && action != null && action.equals("android.intent.action.MAIN")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && categories == null && TextUtils.isEmpty(action)) {
            z16 = true;
        }
        QLog.e("SplashAD", 1, "fromLaucher " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(long j3) {
        cooperation.vip.ad.i.g().putLong("splash_ad_uin_long", j3);
    }

    public static boolean x(int i3, boolean z16) {
        if (i3 == 4) {
            return false;
        }
        return u(i3, z16);
    }

    public static void y(Context context) {
        z(context, 0L);
    }

    public static void z(Context context, final long j3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.splashad.a
            @Override // java.lang.Runnable
            public final void run() {
                SplashADUtil.w(j3);
            }
        });
        f288714a = j3;
    }
}
