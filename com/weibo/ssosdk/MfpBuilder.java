package com.weibo.ssosdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MfpBuilder {
    public static final String AID_TAG = "weibo_aid_value";
    private static final String TAG = "MfpBuilder";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class BatteryInfo {
        private Intent batteryInfoIntent;

        private int getHealth() {
            return this.batteryInfoIntent.getIntExtra(WidgetCacheConstellationData.HEALTH, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getLevel() {
            return this.batteryInfoIntent.getIntExtra("level", 0);
        }

        private int getPlugged() {
            return this.batteryInfoIntent.getIntExtra("plugged", 0);
        }

        private boolean getPresent() {
            return this.batteryInfoIntent.getBooleanExtra("present", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getScale() {
            return this.batteryInfoIntent.getIntExtra("scale", 0);
        }

        private int getStatus() {
            return this.batteryInfoIntent.getIntExtra("status", 0);
        }

        private String getTechnology() {
            return this.batteryInfoIntent.getStringExtra("technology");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTemperature() {
            return this.batteryInfoIntent.getIntExtra("temperature", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getVoltage() {
            return this.batteryInfoIntent.getIntExtra("voltage", 0);
        }

        BatteryInfo(Context context) {
            this.batteryInfoIntent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    private static String bytesToString(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                sb5.append(String.format("%02X:", Byte.valueOf(b16)));
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            return sb5.toString();
        }
        return null;
    }

    private static String genMfpString(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String os5 = getOS();
            if (!TextUtils.isEmpty(os5)) {
                jSONObject.put("os", os5);
            }
            String imei = getImei(context);
            if (!TextUtils.isEmpty(imei)) {
                jSONObject.put("imei", imei);
            }
            String meid = getMeid(context);
            if (!TextUtils.isEmpty(meid)) {
                jSONObject.put("meid", meid);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put(MobileInfoUtil.IMSI, imsi);
            }
            String mac = getMac(context);
            if (!TextUtils.isEmpty(mac)) {
                jSONObject.put("mac", mac);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put("iccid", iccid);
            }
            String serialNo = getSerialNo();
            if (!TextUtils.isEmpty(serialNo)) {
                jSONObject.put(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, serialNo);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put("androidid", androidId);
            }
            String cpu = getCpu();
            if (!TextUtils.isEmpty(cpu)) {
                jSONObject.put("cpu", cpu);
            }
            String model = getModel();
            if (!TextUtils.isEmpty(model)) {
                jSONObject.put("model", model);
            }
            String sdSize = getSdSize();
            if (!TextUtils.isEmpty(sdSize)) {
                jSONObject.put("sdcard", sdSize);
            }
            String resolution = getResolution(context);
            if (!TextUtils.isEmpty(resolution)) {
                jSONObject.put("resolution", resolution);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put(TPDownloadProxyEnum.USER_SSID, ssid);
            }
            String wifiBssid = getWifiBssid(context);
            if (!TextUtils.isEmpty(wifiBssid)) {
                jSONObject.put("bssid", wifiBssid);
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                jSONObject.put("deviceName", deviceName);
            }
            String connectType = getConnectType(context);
            if (!TextUtils.isEmpty(connectType)) {
                jSONObject.put("connecttype", connectType);
            }
            try {
                str = generateUAAid(context);
            } catch (Exception e16) {
                e16.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("ua", str);
            }
            double batteryCapacity = getBatteryCapacity(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(batteryCapacity));
            jSONObject.put("batterycurrentcapacity", String.valueOf(batteryCapacity));
            BatteryInfo batteryInfo = new BatteryInfo(context);
            jSONObject.put("batterycurrentvoltage", batteryInfo.getVoltage());
            jSONObject.put("batterycurrenttemperature", batteryInfo.getTemperature());
            jSONObject.put("batterycurrentcapacity", (batteryCapacity * batteryInfo.getLevel()) / batteryInfo.getScale());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static String generateUAAid(Context context) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName) && packageName.contains("com.sina.weibo")) {
            str = "weibo";
        } else {
            str = "ssosdk";
        }
        sb5.append(Build.MANUFACTURER);
        sb5.append("-");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("__");
        sb5.append(str);
        sb5.append("__");
        try {
            sb5.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb5.append("unknown");
        }
        sb5.append("__android__android");
        sb5.append(Build.VERSION.RELEASE);
        return sb5.toString();
    }

    private static String getAndroidId(Context context) {
        try {
            return DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Exception unused) {
            return "";
        }
    }

    private static double getBatteryCapacity(Context context) {
        Object obj;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (Exception unused2) {
            return 0.0d;
        }
    }

    private static String getConnectType(Context context) {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                    switch (NetworkMonitor.getSubtype(activeNetworkInfo)) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                    }
                } else if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    str = "wifi";
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return DeviceInfoMonitor.getSimSerialNumber((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getImei(Context context) {
        try {
            return DeviceInfoMonitor.getDeviceId((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return DeviceInfoMonitor.getSubscriberId((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getMac(Context context) {
        return getMacAddr();
    }

    private static String getMacAddr() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkMonitor.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = NetworkMonitor.getHardwareAddress(networkInterface);
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb5 = new StringBuilder();
                    for (byte b16 : hardwareAddress) {
                        sb5.append(String.format("%02X:", Byte.valueOf(b16)));
                    }
                    if (sb5.length() > 0) {
                        sb5.deleteCharAt(sb5.length() - 1);
                    }
                    return sb5.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getMeid(Context context) {
        try {
            return DeviceInfoMonitor.getDeviceId((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMfp(Context context) {
        try {
            return new String(genMfpString(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static String getModel() {
        try {
            return DeviceInfoMonitor.getModel();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getOS() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    private static PublicKey getPublicKey(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
    }

    private static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSerialNo() {
        if (Build.VERSION.SDK_INT >= 26) {
            return getSerialNoForO();
        }
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return "";
        }
    }

    @TargetApi(26)
    private static String getSerialNoForO() {
        try {
            return DeviceInfoMonitor.getSerialByMethod();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) context.getApplicationContext().getSystemService("wifi"));
            if (connectionInfo != null) {
                return NetworkMonitor.getSSID(connectionInfo);
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getWifiBssid(Context context) {
        try {
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) context.getApplicationContext().getSystemService("wifi"));
            if (connectionInfo != null) {
                return NetworkMonitor.getBSSID(connectionInfo);
            }
            return "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    private static int splite(byte[] bArr, int i3, int i16) {
        if (i3 >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i3, i16);
    }

    private static void LogD(String str) {
    }

    private static void LogE(String str) {
    }

    public static void init(Context context) {
    }
}
