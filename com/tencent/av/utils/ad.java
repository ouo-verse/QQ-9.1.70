package com.tencent.av.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.tencent.av.utils.api.IAutoRotateDefaultSwitchApi;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    private static int f76938a = 1;

    /* renamed from: b, reason: collision with root package name */
    static Boolean f76939b;

    /* renamed from: c, reason: collision with root package name */
    static Boolean f76940c;

    /* renamed from: d, reason: collision with root package name */
    static Boolean f76941d;

    /* renamed from: e, reason: collision with root package name */
    static Boolean f76942e;

    /* renamed from: f, reason: collision with root package name */
    static Boolean f76943f;

    /* renamed from: g, reason: collision with root package name */
    static Boolean f76944g;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PhoneStateListener f76945a;

        a(PhoneStateListener phoneStateListener) {
            this.f76945a = phoneStateListener;
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int i3) {
            QLog.d("PhoneStatusTools", 1, "[listen1] onCallStateChanged:" + i3);
            PhoneStateListener phoneStateListener = this.f76945a;
            if (phoneStateListener != null) {
                phoneStateListener.onCallStateChanged(i3, null);
            }
        }
    }

    /* compiled from: P */
    @RequiresApi(api = 31)
    /* loaded from: classes3.dex */
    private static abstract class b extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        b() {
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        f76939b = bool;
        f76940c = bool;
        f76941d = bool;
        f76942e = bool;
        f76943f = bool;
        f76944g = bool;
    }

    public static String a(Context context, String str) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException e16) {
            throw e16;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        int i3;
        if (context == null) {
            QLog.e("PhoneStatusTools", 1, "getIsCallingFromDefaultPhone context is null.");
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                i3 = SystemMethodProxy.getCallState(telephonyManager);
            } catch (Throwable unused) {
                i3 = 0;
            }
            if (i3 != 0) {
                return true;
            }
            if (f76939b.booleanValue()) {
                try {
                    if (((Integer) wy2.f.c(telephonyManager, "getCallStateGemini", new Class[]{Integer.TYPE}, new Object[]{0})).intValue() != 0) {
                        return true;
                    }
                } catch (NoSuchMethodException unused2) {
                    f76939b = Boolean.FALSE;
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "1 isCalling NoSuchMethodException[getCallStateGemini]");
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "1 isCalling getCallStateGemini Exception", e16);
                    }
                }
            }
            if (f76940c.booleanValue()) {
                try {
                    if (((Integer) wy2.f.c(telephonyManager, "getCallStateGemini", new Class[]{Integer.TYPE}, new Object[]{1})).intValue() != 0) {
                        return true;
                    }
                } catch (NoSuchMethodException unused3) {
                    f76940c = Boolean.FALSE;
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "2 isCalling NoSuchMethodException[getCallStateGemini]");
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "2 isCalling getCallStateGemini Exception", e17);
                    }
                }
            }
        }
        return false;
    }

    private static boolean c() {
        if (f76943f.booleanValue()) {
            try {
                if (((Integer) wy2.f.d(wy2.f.g("android.telephony.MSimTelephonyManager", "getDefault", null, null), "getCallState", new Object[]{0})).intValue() != 0) {
                    return true;
                }
            } catch (NoSuchMethodException unused) {
                f76943f = Boolean.FALSE;
                if (QLog.isColorLevel()) {
                    QLog.d("PhoneStatusTools", 2, "5 isCalling NoSuchMethodException[getCallState]");
                }
            } catch (Exception unused2) {
            }
        }
        if (f76944g.booleanValue()) {
            try {
                if (((Integer) wy2.f.d(wy2.f.g("android.telephony.MSimTelephonyManager", "getDefault", null, null), "getCallState", new Object[]{1})).intValue() != 0) {
                    return true;
                }
            } catch (NoSuchMethodException unused3) {
                f76944g = Boolean.FALSE;
                if (QLog.isColorLevel()) {
                    QLog.d("PhoneStatusTools", 2, "6 isCalling NoSuchMethodException[getCallState]");
                }
            } catch (Exception unused4) {
            }
        }
        return false;
    }

    private static boolean d(Context context) {
        TelephonyManager telephonyManager;
        int i3;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone2");
        } catch (Exception unused) {
            telephonyManager = null;
        }
        if (telephonyManager != null) {
            try {
                i3 = SystemMethodProxy.getCallState(telephonyManager);
            } catch (Throwable unused2) {
                i3 = 0;
            }
            if (i3 != 0) {
                return true;
            }
            if (f76941d.booleanValue()) {
                try {
                    if (((Integer) wy2.f.d(telephonyManager, "getCallStateGemini", new Object[]{0})).intValue() != 0) {
                        return true;
                    }
                } catch (NoSuchMethodException unused3) {
                    f76941d = Boolean.FALSE;
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "3 isCalling NoSuchMethodException[getCallStateGemini]");
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "3 isCalling getCallStateGemini Exception", e16);
                    }
                }
            }
            if (f76942e.booleanValue()) {
                try {
                    if (((Integer) wy2.f.d(telephonyManager, "getCallStateGemini", new Object[]{1})).intValue() != 0) {
                        return true;
                    }
                } catch (NoSuchMethodException unused4) {
                    f76942e = Boolean.FALSE;
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "4 isCalling NoSuchMethodException[getCallStateGemini]");
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusTools", 2, "4 isCalling getCallStateGemini Exception", e17);
                    }
                }
            }
        }
        return false;
    }

    public static NetworkInfo e(Context context) {
        return AppNetConnInfo.getRecentNetworkInfo();
    }

    public static int f(Context context) {
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        if (systemNetwork == 1) {
            return 0;
        }
        if (systemNetwork == 4) {
            return 1;
        }
        if (systemNetwork == 3) {
            return 2;
        }
        if (systemNetwork == 2) {
            return 3;
        }
        return -1;
    }

    public static boolean g() {
        int i3;
        BaseApplication context = BaseApplication.getContext();
        boolean z16 = false;
        if (context == null) {
            QLog.w("PhoneStatusTools", 2, "isAutoRotateDisabled returns false when context null");
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.w("PhoneStatusTools", 2, "isAutoRotateDisabled returns false when contentResolver null");
            return false;
        }
        int i16 = f76938a;
        boolean enableUseDefaultValue = ((IAutoRotateDefaultSwitchApi) QRoute.api(IAutoRotateDefaultSwitchApi.class)).enableUseDefaultValue();
        try {
            if (enableUseDefaultValue) {
                int defaultValue = ((IAutoRotateDefaultSwitchApi) QRoute.api(IAutoRotateDefaultSwitchApi.class)).getDefaultValue();
                f76938a = defaultValue;
                i3 = Settings.System.getInt(contentResolver, "accelerometer_rotation", defaultValue);
            } else {
                i3 = Settings.System.getInt(contentResolver, "accelerometer_rotation");
            }
            i16 = i3;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i16 != 1) {
            z16 = true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PhoneStatusTools", 1, "isAutoRotateDisabled ret=" + z16 + " res=" + i16 + " enableUseDefault=" + enableUseDefaultValue + " DEFAULT_ACCELEROMETER_ROTATION_VALUE=" + f76938a);
        }
        return z16;
    }

    public static boolean h(Context context) {
        if (context == null) {
            QLog.w("PhoneStatusTools", 1, "isCalling, context\u4e3anull");
            return false;
        }
        boolean b16 = b(context);
        if (!b16) {
            b16 = d(context);
        }
        if (!b16) {
            b16 = c();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusTools", 2, "isCalling: " + b16);
        }
        return b16;
    }

    public static boolean i() {
        String model = DeviceInfoMonitor.getModel();
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && model.equalsIgnoreCase("SM-T230")) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        String model = DeviceInfoMonitor.getModel();
        if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER)) {
            return false;
        }
        if (!"SM-T805C".equalsIgnoreCase(model) && !"SM-T800".equalsIgnoreCase(model)) {
            return false;
        }
        return true;
    }

    public static boolean k() {
        String str = Build.MANUFACTURER;
        String model = DeviceInfoMonitor.getModel();
        if (str.equalsIgnoreCase("ZTE") && model.equalsIgnoreCase("ZTE U950")) {
            return true;
        }
        return false;
    }

    public static boolean l(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null && SystemMethodProxy.getStreamVolume(audioManager, 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean m(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null || audioManager.getRingerMode() != 2) {
            return false;
        }
        return true;
    }

    public static boolean n(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null && audioManager.getRingerMode() == 0) {
            return true;
        }
        return false;
    }

    public static boolean o(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null && audioManager.getRingerMode() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean p(Context context) {
        double d16;
        boolean z16;
        if (i()) {
            return false;
        }
        if (j() || a(context, "ro.qq.istablet").equalsIgnoreCase("true") || a(context, "ro.lenovo.device").equalsIgnoreCase("tablet")) {
            return true;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d16 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d16 = 0.0d;
        }
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0) {
            z16 = false;
            if (QLog.isColorLevel()) {
                QLog.d("PhoneStatusTools", 2, "device size : " + d16 + ", hasTelephone : " + z16);
            }
            if (d16 > 6.5d || z16) {
                return false;
            }
            return true;
        }
        z16 = true;
        if (QLog.isColorLevel()) {
        }
        if (d16 > 6.5d) {
        }
        return false;
    }

    public static boolean q(Context context) {
        NetworkInfo e16 = e(context);
        if (e16 == null || NetworkMonitor.getType(e16) != 1) {
            return false;
        }
        return true;
    }

    public static void r(Context context, PhoneStateListener phoneStateListener, int i3) {
        Executor mainExecutor;
        TelephonyManager telephonyManager;
        try {
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager2 != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 31) {
                        if (ContextCompat.checkSelfPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) {
                            if (i3 == 32) {
                                a aVar = new a(phoneStateListener);
                                mainExecutor = context.getMainExecutor();
                                telephonyManager2.registerTelephonyCallback(mainExecutor, aVar);
                                QLog.d("PhoneStatusTools", 1, "[listen1] registerTelephonyCallback");
                            } else {
                                QLog.d("PhoneStatusTools", 1, "[listen1] unregisterTelephonyCallback");
                            }
                        } else {
                            QLog.d("PhoneStatusTools", 1, "[listen1] has no READ_PHONE_STATE permission.");
                        }
                    } else {
                        LocationMonitor.listen(telephonyManager2, phoneStateListener, i3);
                    }
                    Class cls = Integer.TYPE;
                    wy2.f.c(telephonyManager2, "listenGemini", new Class[]{cls, PhoneStateListener.class, cls}, new Object[]{0, phoneStateListener, Integer.valueOf(i3)});
                    wy2.f.c(telephonyManager2, "listenGemini", new Class[]{cls, PhoneStateListener.class, cls}, new Object[]{1, phoneStateListener, Integer.valueOf(i3)});
                } catch (Exception e16) {
                    QLog.e("PhoneStatusTools", 1, "1 listen Exception", e16);
                }
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone2");
            } catch (Exception unused) {
                telephonyManager = null;
            }
            if (telephonyManager != null) {
                try {
                    Class cls2 = Integer.TYPE;
                    wy2.f.c(telephonyManager, "listen", new Class[]{PhoneStateListener.class, cls2}, new Object[]{phoneStateListener, Integer.valueOf(i3)});
                    wy2.f.c(telephonyManager, "listenGemini", new Class[]{cls2, PhoneStateListener.class, cls2}, new Object[]{0, phoneStateListener, Integer.valueOf(i3)});
                    wy2.f.c(telephonyManager, "listenGemini", new Class[]{cls2, PhoneStateListener.class, cls2}, new Object[]{1, phoneStateListener, Integer.valueOf(i3)});
                } catch (Exception e17) {
                    QLog.e("PhoneStatusTools", 1, "2 listen Exception", e17);
                }
            }
            try {
                wy2.f.c(wy2.f.g("android.telephony.MSimTelephonyManager", "getDefault", null, null), "listen", new Class[]{PhoneStateListener.class, Integer.TYPE}, new Object[]{phoneStateListener, Integer.valueOf(i3)});
            } catch (Exception e18) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("PhoneStatusTools", 1, "3 listen Exception", e18);
                }
            }
        } catch (Exception e19) {
            QLog.e("PhoneStatusTools", 1, "listen Exception: ", e19);
        }
    }
}
