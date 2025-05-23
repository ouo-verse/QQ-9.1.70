package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f76660a = Arrays.asList("Xiaomi;2307BRPDCC");

    public static void a(String str, int i3) {
        r(str, h(), 0, String.valueOf(i3), "", "", "");
    }

    public static void c(int i3) {
        r("0X800BC0E", h(), 0, String.valueOf(i3), "", "", "");
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 35) {
            QLog.e("AVUtil", 1, "fixInputMethodMemoryLeak, android 15 ignore");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i3]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        return;
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i("AVUtil", 2, "fixInputMethodMemoryLeak, exception [" + th5.getMessage() + "]");
                }
            }
        }
    }

    public static void e(Activity activity) {
        if (activity == null || !"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.AVUtil.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                Activity activity2 = (Activity) WeakReference.this.get();
                if (activity2 == null) {
                    return;
                }
                try {
                    Class<?> cls = Class.forName("android.rms.iaware.FastgrabConfigReader");
                    Field declaredField = cls.getDeclaredField("mFastgrabConfigReader");
                    i3 = 1;
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(cls);
                    Field declaredField2 = cls.getDeclaredField("mContext");
                    declaredField2.setAccessible(true);
                    if (declaredField2.get(obj) == activity2) {
                        declaredField2.set(obj, null);
                    } else {
                        i3 = 2;
                    }
                } catch (ClassNotFoundException unused) {
                    i3 = 3;
                } catch (IllegalAccessException unused2) {
                    i3 = 5;
                } catch (NoSuchFieldException unused3) {
                    i3 = 4;
                } catch (Throwable unused4) {
                    i3 = 6;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AVUtil", 2, "fixMemoryLeakForHuaWei, ret[" + i3 + "]");
                }
            }
        }, 16, null, true);
    }

    public static int f(int i3) {
        if (i3 == 2) {
            return 1004;
        }
        return 1000;
    }

    public static int g(int i3) {
        if (i3 == 3000) {
            return 1004;
        }
        if (i3 == 1) {
            return 1000;
        }
        return 0;
    }

    public static int h() {
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16 == null) {
            return 2;
        }
        int i3 = f16.f73035i;
        int i16 = 3;
        if (i3 != 3) {
            i16 = 4;
            if (i3 != 4) {
                i16 = 1;
                if (i3 != 1) {
                    return 2;
                }
            }
        }
        return i16;
    }

    public static int i(int i3) {
        if (i3 == 3000) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 0) {
            return 3;
        }
        return 0;
    }

    public static boolean j(String str) {
        boolean z16;
        String str2 = AppConstants.QQSETTING_AVCALL_NOTIFY_KEY + str;
        SharedPreferences h16 = vu.a.h("set_sp_mp" + str, 4);
        boolean contains = h16.contains(str2);
        if (contains) {
            z16 = h16.getBoolean(AppConstants.QQSETTING_AVCALL_NOTIFY_KEY + str, true);
        } else {
            z16 = h16.getBoolean(AppConstants.QQSETTING_AVCALL_NOTIFY_KEY, true);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVUtil", 2, "isAVNotifyEnable, av_enable[" + z16 + "], isNewKeyExist[" + contains + "]");
        }
        return z16;
    }

    public static boolean k(String str) {
        boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext());
        if (areNotificationsEnabled) {
            return j(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVUtil", 2, "isAllowAVNotify, system_enable[false]");
            return areNotificationsEnabled;
        }
        return areNotificationsEnabled;
    }

    public static boolean l() {
        String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel();
        Iterator<String> it = f76660a.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                QLog.i("AVUtil", 2, "isDeviceHasPhysicalMuteBtn: phone has physical mute btn");
                return true;
            }
        }
        return false;
    }

    public static boolean m(int i3) {
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    public static boolean n(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean o(int i3) {
        if (i3 == 1 || i3 == 3000) {
            return true;
        }
        return false;
    }

    public static boolean p() {
        boolean z16;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 28) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "isUseCompatMode [" + z16 + "], SDK_INT[" + i3 + "]");
        }
        return z16;
    }

    public static long q(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            e16.fillInStackTrace();
            return 0L;
        }
    }

    public static void r(final String str, final int i3, final int i16, final String str2, final String str3, String str4, String str5) {
        final String str6;
        final String str7;
        if (str4 != null && str4.length() > 128) {
            str6 = "";
        } else {
            str6 = str4;
        }
        if (str5 != null && str5.length() > 128) {
            str7 = "";
        } else {
            str7 = str5;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.AVUtil.1
            @Override // java.lang.Runnable
            public void run() {
                String str8 = str;
                ReportController.o(null, "dc00898", "", "", str8, str8, i3, i16, str2, str3, str6, str7);
            }
        }, 16, null, true);
        if (QLog.isColorLevel()) {
            QLog.i("AVUtil", 2, "report tag[" + str + "], from[" + i3 + "], r2[" + str2 + "]");
        }
    }

    public static void s(String str, boolean z16) {
        SharedPreferences.Editor edit = vu.a.h("set_sp_mp" + str, 4).edit();
        edit.putBoolean(AppConstants.QQSETTING_AVCALL_NOTIFY_KEY + str, z16);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.i("AVUtil", 2, "saveAllowAVNotify, isAllow[" + z16 + "]");
        }
    }

    public static boolean t(Window window, boolean z16) {
        int isSupporImmersive = ImmersiveUtils.isSupporImmersive();
        boolean z17 = false;
        if (isSupporImmersive == 1) {
            if (z16) {
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024);
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(67108864);
                window.setStatusBarColor(0);
            } else {
                window.clearFlags(67108864);
            }
            z17 = true;
        } else if (e.e(25) == 1) {
            e.x("\u4f7f\u7528\u4e86index_disable_immersive");
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(ImmersiveUtils.TAG, 1, "setImmersive, result[" + z17 + "], isSupporImmersive[" + isSupporImmersive + "], SystemUiVisibility[0x" + Integer.toHexString(window.getDecorView().getSystemUiVisibility()) + "], flags[0x" + Integer.toHexString(window.getAttributes().flags) + "]");
        }
        return z17;
    }

    public static void u(Window window) {
        try {
            window.addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
        } catch (IllegalAccessException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Could not access FLAG_NEEDS_MENU_KEY", e16);
            }
        } catch (NoSuchFieldException unused) {
        }
    }

    public static void b(Intent intent) {
    }
}
