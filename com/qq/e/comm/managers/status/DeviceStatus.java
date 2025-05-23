package com.qq.e.comm.managers.status;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.util.AdFile;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceStatus {
    public static final String EXPERIMENT_ID = "ebid";

    /* renamed from: n, reason: collision with root package name */
    private static final Object f38239n = new Object();

    /* renamed from: a, reason: collision with root package name */
    private String f38240a;

    /* renamed from: b, reason: collision with root package name */
    private String f38241b;

    /* renamed from: c, reason: collision with root package name */
    private int f38242c;

    /* renamed from: d, reason: collision with root package name */
    private String f38243d;

    /* renamed from: e, reason: collision with root package name */
    private String f38244e;

    /* renamed from: f, reason: collision with root package name */
    private String f38245f;

    /* renamed from: g, reason: collision with root package name */
    private String f38246g;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f38247h;

    /* renamed from: i, reason: collision with root package name */
    private volatile String f38248i;

    /* renamed from: j, reason: collision with root package name */
    private volatile float f38249j;

    /* renamed from: k, reason: collision with root package name */
    private Context f38250k;

    /* renamed from: l, reason: collision with root package name */
    private String f38251l;

    /* renamed from: m, reason: collision with root package name */
    private volatile String f38252m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface Carrier {
    }

    public DeviceStatus(Context context) {
        DisplayMetrics displayMetrics;
        int i3;
        this.f38250k = context.getApplicationContext();
        if (context.getResources() == null) {
            displayMetrics = null;
        } else {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        if (getVersion() > 3) {
            i3 = displayMetrics.densityDpi;
        } else {
            i3 = 120;
        }
        this.f38242c = i3;
    }

    private String a() {
        if (GlobalSetting.getTGDeviceInfo() != null && !TextUtils.isEmpty(GlobalSetting.getTGDeviceInfo().getNetWorkType())) {
            return GlobalSetting.getTGDeviceInfo().getNetWorkType();
        }
        Context context = this.f38250k;
        if (context == null) {
            return this.f38245f;
        }
        Object systemService = context.getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            return this.f38245f;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            if (telephonyManager != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(NetworkMonitor.getNetworkType(telephonyManager));
                this.f38245f = sb5.toString();
            }
        } catch (Exception unused) {
        }
        return this.f38245f;
    }

    private NetworkType b() {
        int i3;
        String dataNet = getDataNet();
        try {
            i3 = Integer.parseInt(a());
        } catch (NumberFormatException unused) {
            i3 = 0;
        }
        if (dataNet != null && dataNet.equals("wi")) {
            return NetworkType.WIFI;
        }
        switch (i3) {
            case 1:
            case 2:
            case 16:
                return NetworkType.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 17:
                return NetworkType.NET_3G;
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    private static NetworkType c() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            return NetworkType.UNKNOWN;
        }
        Object obj = 1;
        Object obj2 = 2;
        Object obj3 = 3;
        try {
            obj = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
            obj2 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
            obj3 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
        } catch (Throwable th5) {
            GDTLogger.e("getType", th5);
        }
        Object systemService = appContext.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            return NetworkType.UNKNOWN;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (connectivityManager == null) {
                return NetworkType.UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return NetworkType.UNKNOWN;
            }
            switch (NetworkMonitor.getType(activeNetworkInfo)) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    Object invoke = TelephonyManager.class.getDeclaredMethod("getNetworkClass", Integer.TYPE).invoke(TelephonyManager.class, Integer.valueOf(NetworkMonitor.getSubtype(activeNetworkInfo)));
                    if (invoke.equals(obj)) {
                        return NetworkType.NET_2G;
                    }
                    if (invoke.equals(obj2)) {
                        return NetworkType.NET_3G;
                    }
                    if (invoke.equals(obj3)) {
                        return NetworkType.NET_4G;
                    }
                    return NetworkType.UNKNOWN;
                case 1:
                case 6:
                    return NetworkType.WIFI;
                default:
                    return NetworkType.UNKNOWN;
            }
        } catch (Throwable th6) {
            GDTLogger.e("getType", th6);
            return NetworkType.UNKNOWN;
        }
    }

    private static String d() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(101);
        linkedList.add(102);
        linkedList.add(103);
        linkedList.add(110);
        linkedList.add(111);
        linkedList.add(112);
        linkedList.add(104);
        linkedList.add(115);
        linkedList.add(307);
        linkedList.add(309);
        linkedList.add(310);
        return linkedList.toString();
    }

    public String getBuildModel() {
        if (GlobalSetting.getTGDeviceInfo() != null && !TextUtils.isEmpty(GlobalSetting.getTGDeviceInfo().getBuildModel())) {
            return GlobalSetting.getTGDeviceInfo().getBuildModel();
        }
        if (GlobalSetting.getDeviceInfoSetting() != null && (GlobalSetting.getDeviceInfoSetting().getDeviceInfoValue(117) instanceof String)) {
            String str = (String) GlobalSetting.getDeviceInfoSetting().getDeviceInfoValue(117);
            if (Constants.KEYS.DEVICE_INFO_DEFAULT_VALUE.equals(str)) {
                return "";
            }
            return str;
        }
        if (!TextUtils.isEmpty(this.f38251l)) {
            return this.f38251l;
        }
        if (!a(117, true)) {
            return "";
        }
        String model = DeviceInfoMonitor.getModel();
        this.f38251l = model;
        return model;
    }

    public String getDataNet() {
        NetworkInfo networkInfo;
        String str;
        Context context = this.f38250k;
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            return null;
        }
        try {
            networkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return null;
        }
        int type = NetworkMonitor.getType(networkInfo);
        if (type != 0) {
            if (type != 1) {
                str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            } else {
                str = "wi";
            }
        } else {
            str = "ed";
        }
        this.f38246g = str;
        return str;
    }

    public int getDeviceDensity() {
        return this.f38242c;
    }

    @Deprecated
    public int getDeviceHeight() {
        return 0;
    }

    @Deprecated
    public int getDeviceWidth() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if (com.qq.e.comm.constants.Constants.KEYS.DEVICE_INFO_DEFAULT_VALUE.equals(r0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (com.qq.e.comm.util.StringUtil.isEmpty(null) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDid() {
        String str;
        if (GlobalSetting.getTGDeviceInfo() != null && !TextUtils.isEmpty(GlobalSetting.getTGDeviceInfo().getDeviceId())) {
            str = GlobalSetting.getTGDeviceInfo().getDeviceId();
        } else if (GlobalSetting.getDeviceInfoSetting() != null && (GlobalSetting.getDeviceInfoSetting().getDeviceInfoValue(110) instanceof String)) {
            str = (String) GlobalSetting.getDeviceInfoSetting().getDeviceInfoValue(110);
        } else {
            str = null;
            if (StringUtil.isEmpty(null)) {
                if (a(110, false)) {
                    if (Build.VERSION.SDK_INT < 29) {
                        if (a(this.f38250k, DeviceInfoUtil.PERMISSION_READ_PHONE)) {
                            if (this.f38250k != null) {
                            }
                        }
                    }
                }
                str = "";
            }
        }
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        return Md5Util.encode(str.toLowerCase());
    }

    public String getExperimentIdSync() {
        String str = this.f38252m;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String configDir = FileUtil.getConfigDir();
        if (!TextUtils.isEmpty(configDir) && Looper.getMainLooper() != Looper.myLooper()) {
            AdFile adFile = new AdFile(configDir, EXPERIMENT_ID, "UTF-8", false);
            synchronized (f38239n) {
                if (adFile.open()) {
                    str = adFile.readFully();
                    adFile.close();
                }
            }
            this.f38252m = str;
        }
        return str;
    }

    @Deprecated
    public Map<String, String> getLacAndCeilId() {
        return new HashMap();
    }

    @Deprecated
    public String getLanguage() {
        if (this.f38241b == null) {
            String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            this.f38241b = lowerCase;
            if (lowerCase.length() == 0) {
                this.f38241b = "en";
            }
        }
        return this.f38241b;
    }

    @Deprecated
    public String getLat() {
        return this.f38247h;
    }

    @Deprecated
    public String getLng() {
        return this.f38248i;
    }

    @Deprecated
    public float getLocationAccuracy() {
        return this.f38249j;
    }

    public NetworkType getNetworkType() {
        boolean z16;
        NetworkType networkType;
        boolean z17;
        boolean z18 = false;
        if (GDTADManager.getInstance().getSM() != null) {
            if (GDTADManager.getInstance().getSM().getInteger("reportNetworkType", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (GDTADManager.getInstance().getSM().getInteger("useNewNetworkInterface", 0) == 1) {
                z18 = true;
            }
            boolean z19 = z18;
            z18 = z17;
            z16 = z19;
        } else {
            z16 = false;
        }
        NetworkType networkType2 = null;
        if (z18) {
            networkType = c();
        } else {
            networkType = null;
        }
        if (!z16) {
            networkType2 = b();
        }
        if (z18 && !z16) {
            GDTLogger.d("report two network types oldType: " + networkType2 + " newType: " + networkType);
            a.a(networkType2.getConnValue(), networkType.getConnValue());
        }
        if (z18 && z16) {
            return networkType;
        }
        return networkType2;
    }

    @Deprecated
    public String getOperator() {
        if (GlobalSetting.getTGDeviceInfo() != null && !TextUtils.isEmpty(GlobalSetting.getTGDeviceInfo().getOperator())) {
            return GlobalSetting.getTGDeviceInfo().getOperator();
        }
        Context context = this.f38250k;
        if (context == null) {
            return this.f38244e;
        }
        Object systemService = context.getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            return this.f38244e;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            if (telephonyManager != null) {
                this.f38244e = DeviceInfoMonitor.getNetworkOperator(telephonyManager);
            }
        } catch (Exception unused) {
        }
        return this.f38244e;
    }

    public QQNetworkType getQQNetworkType() {
        NetworkType networkType = getNetworkType();
        QQNetworkType qQNetworkType = QQNetworkType.UNKNOWN;
        if (networkType != NetworkType.UNKNOWN) {
            if (networkType == NetworkType.WIFI) {
                return QQNetworkType.WIFI;
            }
            if (networkType == NetworkType.NET_2G) {
                return QQNetworkType.NET_2G;
            }
            if (networkType == NetworkType.NET_3G) {
                return QQNetworkType.NET_3G;
            }
            if (networkType == NetworkType.NET_4G) {
                return QQNetworkType.NET_4G;
            }
            if (networkType == NetworkType.NET_5G) {
                return QQNetworkType.NET_5G;
            }
            return qQNetworkType;
        }
        return qQNetworkType;
    }

    public String getScreenOrientation() {
        String str;
        Context context = this.f38250k;
        if (context != null && context.getResources() != null && this.f38250k.getResources().getConfiguration() != null) {
            if (this.f38250k.getResources().getConfiguration().orientation == 2) {
                str = "l";
            } else {
                str = "p";
            }
            this.f38243d = str;
            return this.f38243d;
        }
        return this.f38243d;
    }

    @Deprecated
    public String getUid() {
        String str = this.f38240a;
        if (str == null) {
            Context context = this.f38250k;
            if (context == null) {
                return str;
            }
            String string = DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            if (string == null) {
                string = "emulator";
            }
            this.f38240a = Md5Util.encode(string);
        }
        return this.f38240a;
    }

    public int getVersion() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }

    public void writeExperimentIdSync(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String configDir = FileUtil.getConfigDir();
        if (!TextUtils.isEmpty(configDir) && Looper.getMainLooper() != Looper.myLooper() && !str.equals(getExperimentIdSync())) {
            this.f38252m = str;
            synchronized (f38239n) {
                AdFile adFile = new AdFile(configDir, EXPERIMENT_ID, "UTF-8", true);
                if (adFile.open()) {
                    adFile.writeFully(str);
                    adFile.close();
                }
            }
        }
    }

    private static boolean a(int i3) {
        if (GlobalSetting.isAgreePrivacyStrategy()) {
            return false;
        }
        String string = GDTADManager.getInstance().getSM() != null ? GDTADManager.getInstance().getSM().getString(Constants.KEYS.PRIVACY_POLICY_LIST) : "";
        if (TextUtils.isEmpty(string)) {
            string = d();
        } else {
            GDTLogger.d("privacyPolicyList = " + string);
        }
        return string.contains(String.valueOf(i3));
    }

    private static boolean a(int i3, boolean z16) {
        Boolean bool;
        if (GDTADManager.getInstance().getSM() == null || GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.STUB_DEVICE_SWITCH, 0) == 0) {
            return false;
        }
        if ((GlobalSetting.getDeviceInfoSetting() != null && GlobalSetting.getDeviceInfoSetting().getDeviceInfoConfig() != null && GlobalSetting.getDeviceInfoSetting().getDeviceInfoConfig().containsKey(Integer.valueOf(i3)) && (bool = GlobalSetting.getDeviceInfoSetting().getDeviceInfoConfig().get(Integer.valueOf(i3))) != null && !bool.booleanValue()) || a(i3)) {
            return false;
        }
        if (GDTADManager.getInstance().getSM() == null) {
            return z16;
        }
        SM sm5 = GDTADManager.getInstance().getSM();
        StringBuilder sb5 = new StringBuilder(Constants.KEYS.DEVICE_ID_CONFIG);
        sb5.append(i3);
        return sm5.getInteger(sb5.toString(), !z16 ? 1 : 0) == 1;
    }

    private static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (context.getApplicationContext() != null && !TextUtils.isEmpty(str)) {
                    if (context.getApplicationContext().checkCallingOrSelfPermission(str) == 0) {
                        return true;
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e("DeviceStatus: checkPermission " + str + " Throwable.", th5);
            }
        }
        return false;
    }
}
