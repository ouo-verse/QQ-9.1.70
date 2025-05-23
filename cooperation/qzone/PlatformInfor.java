package cooperation.qzone;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.QQDeviceInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import kotlin.text.Typography;

/* loaded from: classes28.dex */
public class PlatformInfor {
    private static final String BUSI_ID = "52b7f2";
    public static final String DEFAULT_MODE = "default";
    public static final String ELDER_MODE = "elderly";
    private static final String NAME_2G = "2g";
    private static final String NAME_3G = "3g";
    private static final String NAME_4G = "4g";
    private static final String NAME_5G = "5g";
    private static final String NAME_WIFI = "wifi";
    private static final int NOT_INIT = -1;
    public static final String SIMPLE_MODE = "concise";
    public static final String STUDY_MODE = "teenager";
    private static final String TAG = "PlatformInfor";
    private static PlatformInfor instance = null;
    private static Object lock = new Object();
    private static String versionName = "";
    private Context mContext;
    private String mDeviceId;
    private String mDeviceInfo = null;
    private String mDeviceInfoRemoveAndroidId = null;
    private final boolean mEnableUsePrivacyField = QzoneConfig.enableUsePrivacyField();
    private final boolean mGetSharpPSupportResultFromCache;
    private String mImsi;
    private String mMacAddress;
    private int mSupportSharpP;
    private TelephonyManager mTelephonyMgr;

    PlatformInfor() {
        this.mTelephonyMgr = null;
        this.mGetSharpPSupportResultFromCache = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_GET_SHARPP_SUPPORT_RESULT_FROM_CACHE, 1) == 1;
        this.mSupportSharpP = -1;
        BaseApplication context = BaseApplication.getContext();
        this.mContext = context;
        this.mTelephonyMgr = (TelephonyManager) context.getSystemService("phone");
        try {
            versionName = InstalledAppListMonitor.getPackageInfo(this.mContext.getPackageManager(), this.mContext.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static PlatformInfor g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new PlatformInfor();
                }
            }
        }
        return instance;
    }

    private String getAndroidID() {
        if (!this.mEnableUsePrivacyField) {
            return o.c();
        }
        return ah.e();
    }

    public static String getDeviceName() {
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            return cu.d("ro.product.marketname");
        }
        return model;
    }

    private String getDynamicDeviceInfo(StringBuilder sb5) {
        if (sb5 != null) {
            if (this.mGetSharpPSupportResultFromCache) {
                sb5.append("sharpP=");
                sb5.append(isSupportSharpPFromCache());
                sb5.append(Typography.amp);
            } else {
                sb5.append("sharpP=");
                sb5.append(isSupportSharpP(this.mContext));
                sb5.append(Typography.amp);
            }
            sb5.append("n=");
            sb5.append(getNetworkType());
            sb5.append(Typography.amp);
            sb5.append("support_xsj_live=");
            sb5.append(true);
            sb5.append(Typography.amp);
            String clientMode = getClientMode();
            sb5.append("client_mod=");
            sb5.append(clientMode);
            return sb5.toString();
        }
        return "";
    }

    private StringBuilder getFixedDeviceInfo() {
        int i3;
        String str;
        String str2 = "";
        String str3 = this.mDeviceInfo;
        if (str3 != null && str3.length() > 0) {
            try {
                str = o.b();
                try {
                    str2 = o.c();
                } catch (Exception e16) {
                    e = e16;
                    QZLog.e(TAG, "getFixedDeviceInfo... exception:", e);
                    if (this.mDeviceInfo.contains("&qimei=&")) {
                        this.mDeviceInfo.replace("&qimei=&", "&qimei=" + o.b() + ContainerUtils.FIELD_DELIMITER);
                    }
                    if (this.mDeviceInfo.contains("&qimei36=&")) {
                        this.mDeviceInfo.replace("&qimei36=&", "&qimei36=" + o.c() + ContainerUtils.FIELD_DELIMITER);
                    }
                    return new StringBuilder(this.mDeviceInfo);
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
            if (this.mDeviceInfo.contains("&qimei=&") && !TextUtils.isEmpty(str)) {
                this.mDeviceInfo.replace("&qimei=&", "&qimei=" + o.b() + ContainerUtils.FIELD_DELIMITER);
            }
            if (this.mDeviceInfo.contains("&qimei36=&") && !TextUtils.isEmpty(str2)) {
                this.mDeviceInfo.replace("&qimei36=&", "&qimei36=" + o.c() + ContainerUtils.FIELD_DELIMITER);
            }
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("i=");
            sb5.append(getIMEI());
            sb5.append(Typography.amp);
            sb5.append("imsi=");
            sb5.append(getIMSI());
            sb5.append(Typography.amp);
            sb5.append("mac=");
            sb5.append(getLocalMacAddress());
            sb5.append(Typography.amp);
            sb5.append("m=");
            sb5.append(getDeviceName());
            sb5.append(Typography.amp);
            sb5.append("o=");
            sb5.append(Build.VERSION.RELEASE);
            sb5.append(Typography.amp);
            sb5.append("a=");
            sb5.append(Build.VERSION.SDK_INT);
            sb5.append(Typography.amp);
            sb5.append("sd=");
            sb5.append("0");
            sb5.append(Typography.amp);
            sb5.append("c64=");
            sb5.append("1");
            sb5.append(Typography.amp);
            try {
                sb5.append("sc=");
                if (Environment.getExternalStorageState().equals("mounted")) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                sb5.append(Typography.amp);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                sb5.append("p=");
                sb5.append(displayMetrics.widthPixels);
                sb5.append('*');
                sb5.append(displayMetrics.heightPixels);
                sb5.append(Typography.amp);
                sb5.append("aid=");
                sb5.append(getAndroidID());
                sb5.append(Typography.amp);
            } catch (Exception e18) {
                QZLog.e(TAG, "getFixedDeviceInfo... exception:", e18);
            }
            sb5.append("f=");
            sb5.append(Build.MANUFACTURER);
            sb5.append(Typography.amp);
            sb5.append("mm=");
            sb5.append(m.c() / 1048576);
            sb5.append(Typography.amp);
            sb5.append("cf=");
            sb5.append(ah.l());
            sb5.append(Typography.amp);
            sb5.append("cc=");
            sb5.append(ah.n());
            sb5.append(Typography.amp);
            sb5.append("qimei=");
            sb5.append(o.b());
            sb5.append(Typography.amp);
            sb5.append("qimei36=");
            sb5.append(o.c());
            sb5.append(Typography.amp);
            this.mDeviceInfo = sb5.toString();
        }
        return new StringBuilder(this.mDeviceInfo);
    }

    private StringBuilder getFixedDeviceInfoRemoveAndroidId() {
        int i3;
        String str;
        String str2 = "";
        String str3 = this.mDeviceInfoRemoveAndroidId;
        if (str3 != null && str3.length() > 0) {
            try {
                str = o.b();
                try {
                    str2 = o.c();
                } catch (Exception e16) {
                    e = e16;
                    QZLog.e(TAG, "getFixedDeviceInfo... exception:", e);
                    if (this.mDeviceInfoRemoveAndroidId.contains("&qimei=&")) {
                        this.mDeviceInfoRemoveAndroidId.replace("&qimei=&", "&qimei=" + o.b() + ContainerUtils.FIELD_DELIMITER);
                    }
                    if (this.mDeviceInfoRemoveAndroidId.contains("&qimei36=&")) {
                        this.mDeviceInfoRemoveAndroidId.replace("&qimei36=&", "&qimei36=" + o.c() + ContainerUtils.FIELD_DELIMITER);
                    }
                    return new StringBuilder(this.mDeviceInfoRemoveAndroidId);
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
            if (this.mDeviceInfoRemoveAndroidId.contains("&qimei=&") && !TextUtils.isEmpty(str)) {
                this.mDeviceInfoRemoveAndroidId.replace("&qimei=&", "&qimei=" + o.b() + ContainerUtils.FIELD_DELIMITER);
            }
            if (this.mDeviceInfoRemoveAndroidId.contains("&qimei36=&") && !TextUtils.isEmpty(str2)) {
                this.mDeviceInfoRemoveAndroidId.replace("&qimei36=&", "&qimei36=" + o.c() + ContainerUtils.FIELD_DELIMITER);
            }
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("i=");
            sb5.append(getIMEI());
            sb5.append(Typography.amp);
            sb5.append("imsi=");
            sb5.append(getIMSI());
            sb5.append(Typography.amp);
            sb5.append("mac=");
            sb5.append(getLocalMacAddress());
            sb5.append(Typography.amp);
            sb5.append("m=");
            sb5.append(getDeviceName());
            sb5.append(Typography.amp);
            sb5.append("o=");
            sb5.append(Build.VERSION.RELEASE);
            sb5.append(Typography.amp);
            sb5.append("a=");
            sb5.append(Build.VERSION.SDK_INT);
            sb5.append(Typography.amp);
            sb5.append("sd=");
            sb5.append("0");
            sb5.append(Typography.amp);
            sb5.append("c64=");
            sb5.append("1");
            sb5.append(Typography.amp);
            try {
                sb5.append("sc=");
                if (Environment.getExternalStorageState().equals("mounted")) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                sb5.append(Typography.amp);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                sb5.append("p=");
                sb5.append(displayMetrics.widthPixels);
                sb5.append('*');
                sb5.append(displayMetrics.heightPixels);
                sb5.append(Typography.amp);
                sb5.append("aid=");
                sb5.append(o.c());
                sb5.append(Typography.amp);
            } catch (Exception e18) {
                QZLog.e(TAG, "getFixedDeviceInfo... exception:", e18);
            }
            sb5.append("f=");
            sb5.append(Build.MANUFACTURER);
            sb5.append(Typography.amp);
            sb5.append("mm=");
            sb5.append(m.c() / 1048576);
            sb5.append(Typography.amp);
            sb5.append("cf=");
            sb5.append(ah.l());
            sb5.append(Typography.amp);
            sb5.append("cc=");
            sb5.append(ah.n());
            sb5.append(Typography.amp);
            sb5.append("qimei=");
            sb5.append(o.b());
            sb5.append(Typography.amp);
            sb5.append("qimei36=");
            sb5.append(o.c());
            sb5.append(Typography.amp);
            this.mDeviceInfoRemoveAndroidId = sb5.toString();
        }
        return new StringBuilder(this.mDeviceInfoRemoveAndroidId);
    }

    private void getVersion() {
        try {
            versionName = InstalledAppListMonitor.getPackageInfo(this.mContext.getPackageManager(), this.mContext.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private int isSupportSharpP(final Context context) {
        int i3 = this.mSupportSharpP;
        if (i3 == -1) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: cooperation.qzone.PlatformInfor.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SHARPP_GATE, 1) != 1) {
                        PlatformInfor.this.mSupportSharpP = 0;
                    } else {
                        PlatformInfor.this.mSupportSharpP = ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).isSupportSharpP(context);
                    }
                }
            });
            return 0;
        }
        return i3;
    }

    private int isSupportSharpPFromCache() {
        if (this.mSupportSharpP == -1) {
            this.mSupportSharpP = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_SUPPORT_SHARPP, false) ? 1 : 0;
        }
        return this.mSupportSharpP;
    }

    public String getAPNString() {
        String apn = NetworkState.getAPN();
        if (apn == null) {
            return "";
        }
        return apn;
    }

    public String getClientMode() {
        if (SimpleUIUtil.isNowElderMode()) {
            return ELDER_MODE;
        }
        if (QQTheme.isNowSimpleUI()) {
            return SIMPLE_MODE;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return "default";
    }

    public String getDeviceInfoRemoveAndroidId() {
        return getDynamicDeviceInfo(getFixedDeviceInfoRemoveAndroidId());
    }

    public String getDeviceInfor() {
        return getDynamicDeviceInfo(getFixedDeviceInfo());
    }

    @Deprecated
    public String getIMEI() {
        if (!this.mEnableUsePrivacyField) {
            return o.c();
        }
        if (TextUtils.isEmpty(this.mDeviceId)) {
            this.mDeviceId = QQDeviceInfo.getIMEI(BUSI_ID);
        }
        return this.mDeviceId;
    }

    @Deprecated
    public String getIMSI() {
        if (!this.mEnableUsePrivacyField) {
            return o.c();
        }
        if (TextUtils.isEmpty(this.mImsi)) {
            this.mImsi = QQDeviceInfo.getIMSI(BUSI_ID);
        }
        return this.mImsi;
    }

    public String getLocalMacAddress() {
        return GlobalUtil.DEFAULT_MAC_ADDRESS;
    }

    public String getMachineInfor() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MANUFACTURER=" + Build.MANUFACTURER + ",SDK=" + Build.VERSION.SDK_INT + ",board=" + Build.BOARD);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(",device=");
        sb5.append(Build.DEVICE);
        stringBuffer.append(sb5.toString());
        stringBuffer.append(",brand=" + Build.BRAND);
        stringBuffer.append(",display=" + Build.DISPLAY);
        stringBuffer.append(",model=" + DeviceInfoMonitor.getModel());
        stringBuffer.append(MttLoader.QQBROWSER_PARAMS_PD + Build.PRODUCT);
        return stringBuffer.toString();
    }

    public String getNetworkType() {
        int networkType = NetworkState.getNetworkType();
        if (networkType != 1) {
            if (networkType != 2) {
                if (networkType != 3) {
                    if (networkType != 4) {
                        if (networkType != 5) {
                            return "wan";
                        }
                        return "5g";
                    }
                    return "4g";
                }
                return "3g";
            }
            return "2g";
        }
        return "wifi";
    }

    public String getSimpleDeviceInfor() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return "m=" + DeviceInfoMonitor.getModel() + Typography.amp + "o=" + Build.VERSION.RELEASE + Typography.amp + "a=" + Build.VERSION.SDK_INT + Typography.amp + "p=" + displayMetrics.widthPixels + '*' + displayMetrics.heightPixels + Typography.amp + "f=" + Build.MANUFACTURER + Typography.amp + "mm=" + (m.c() / 1048576) + Typography.amp + "cf=" + ah.l() + Typography.amp + "cc=" + ah.n() + Typography.amp + "qqversion=" + AppSetting.f99551k;
    }

    public String getVersionName() {
        String str = versionName;
        if (str == null || str.length() == 0) {
            getVersion();
        }
        return versionName;
    }
}
