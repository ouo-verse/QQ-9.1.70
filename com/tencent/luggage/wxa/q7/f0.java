package com.tencent.luggage.wxa.q7;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f137962a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f137963b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static String f137964c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f137965d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f137966e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f137967f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f137968g = null;

    /* renamed from: h, reason: collision with root package name */
    public static com.tencent.luggage.wxaapi.u f137969h = new com.tencent.luggage.wxaapi.u();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ia.b {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:277:0x0522, code lost:
        
            if (r21.equals("getInstalledApplications") == false) goto L274;
         */
        /* JADX WARN: Removed duplicated region for block: B:213:0x03fc  */
        @Override // com.tencent.luggage.wxa.ia.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object a(String str, String str2, String str3, String str4, String str5, Object obj, Object[] objArr) {
            PhoneStateListener phoneStateListener;
            char c16;
            boolean z16;
            if (obj == null) {
                return null;
            }
            String[] strArr = {"ip", "pm list package"};
            boolean[] zArr = new boolean[1];
            char c17 = 2;
            int i3 = 0;
            if (obj.getClass().getCanonicalName().equals("java.lang.Runtime") && "exec".equals(str4)) {
                Runtime runtime = (Runtime) obj;
                String trim = ((String) objArr[0]).trim();
                int i16 = 0;
                while (true) {
                    if (i16 >= 2) {
                        z16 = false;
                        break;
                    }
                    if (trim.equals(strArr[i16])) {
                        z16 = true;
                        break;
                    }
                    i16++;
                }
                if (!z16) {
                    try {
                        RuntimeMonitor.exec(runtime, (String) objArr[0]);
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            Object a16 = f0.f137969h.a(str4, str5, obj, objArr, zArr);
            if (zArr[0]) {
                return a16;
            }
            com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.WxaSensitiveApiInvokeHolder", "hook call %s.%s dec %s handled %b", obj.getClass().getCanonicalName(), str4, str5, Boolean.valueOf(zArr[0]));
            Context applicationContext = com.tencent.luggage.wxa.tn.z.c().getApplicationContext();
            String canonicalName = obj.getClass().getCanonicalName();
            canonicalName.hashCode();
            if (canonicalName.equals("android.bluetooth.BluetoothAdapter")) {
                BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) obj;
                str4.hashCode();
                if (!str4.equals("startLeScan")) {
                    if (str4.equals("startDiscovery")) {
                        if (f0.c(applicationContext)) {
                            return Boolean.valueOf(LocationMonitor.startDiscovery(bluetoothAdapter));
                        }
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                        return Boolean.FALSE;
                    }
                    throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                }
                if (!f0.c(applicationContext)) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                } else if (objArr != null) {
                    if (objArr.length == 1) {
                        return Boolean.valueOf(LocationMonitor.startLeScan(bluetoothAdapter, (BluetoothAdapter.LeScanCallback) objArr[0]));
                    }
                    if (objArr.length == 2) {
                        return Boolean.valueOf(LocationMonitor.startLeScan(bluetoothAdapter, (UUID[]) objArr[0], (BluetoothAdapter.LeScanCallback) objArr[1]));
                    }
                }
                return Boolean.FALSE;
            }
            if (!canonicalName.equals("java.net.NetworkInterface")) {
                char c18 = '\uffff';
                if (!canonicalName.equals("android.content.pm.PackageManager")) {
                    if (canonicalName.equals("android.bluetooth.le.BluetoothLeScanner")) {
                        str4.hashCode();
                        if (str4.equals("startScan")) {
                            BluetoothLeScanner bluetoothLeScanner = (BluetoothLeScanner) obj;
                            if (!f0.c(applicationContext)) {
                                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                            } else if (objArr != null) {
                                if (objArr.length == 1) {
                                    LocationMonitor.startScan(bluetoothLeScanner, (ScanCallback) objArr[0]);
                                } else if (objArr.length == 3) {
                                    Object obj2 = objArr[2];
                                    if (obj2 instanceof PendingIntent) {
                                        LocationMonitor.startScan(bluetoothLeScanner, (List<ScanFilter>) objArr[0], (ScanSettings) objArr[1], (PendingIntent) obj2);
                                    } else {
                                        LocationMonitor.startScan(bluetoothLeScanner, (List<ScanFilter>) objArr[0], (ScanSettings) objArr[1], (ScanCallback) obj2);
                                    }
                                }
                            }
                            return 3;
                        }
                        throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                    }
                    if (canonicalName.equals("android.hardware.SystemSensorManager")) {
                        SensorManager sensorManager = (SensorManager) applicationContext.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                        str4.hashCode();
                        if (str4.equals("getDefaultSensor")) {
                            return SensorMonitor.getDefaultSensor(sensorManager, ((Integer) objArr[0]).intValue());
                        }
                        throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                    }
                    if (canonicalName.equals("android.telephony.TelephonyManager")) {
                        TelephonyManager telephonyManager = (TelephonyManager) obj;
                        str4.hashCode();
                        switch (str4.hashCode()) {
                            case -2105682274:
                                if (str4.equals("getSimSerialNumber")) {
                                    c18 = 0;
                                    break;
                                }
                                break;
                            case -1384328005:
                                if (str4.equals("getAllCellInfo")) {
                                    c18 = 1;
                                    break;
                                }
                                break;
                            case -1107875961:
                                if (str4.equals("getDeviceId")) {
                                    c18 = 2;
                                    break;
                                }
                                break;
                            case -1102508601:
                                if (str4.equals("listen")) {
                                    c18 = 3;
                                    break;
                                }
                                break;
                            case -75445954:
                                if (str4.equals("getImei")) {
                                    c18 = 4;
                                    break;
                                }
                                break;
                            case -75334359:
                                if (str4.equals("getMeid")) {
                                    c16 = 5;
                                    c18 = c16;
                                    break;
                                }
                                break;
                            case 702848429:
                                if (str4.equals("getCellLocation")) {
                                    c16 = 6;
                                    c18 = c16;
                                    break;
                                }
                                break;
                            case 964598576:
                                if (str4.equals("getLine1Number")) {
                                    c16 = 7;
                                    c18 = c16;
                                    break;
                                }
                                break;
                            case 1954344473:
                                if (str4.equals("getSubscriberId")) {
                                    c16 = '\b';
                                    c18 = c16;
                                    break;
                                }
                                break;
                        }
                        switch (c18) {
                            case 0:
                                if (f0.d(applicationContext)) {
                                    try {
                                        return DeviceInfoMonitor.getSimSerialNumber(telephonyManager);
                                    } catch (SecurityException unused) {
                                        com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                        break;
                                    }
                                } else {
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    break;
                                }
                            case 1:
                                if (f0.c(applicationContext)) {
                                    return LocationMonitor.getAllCellInfo(telephonyManager);
                                }
                                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                break;
                            case 2:
                                if (Build.VERSION.SDK_INT < 29 && f0.d(applicationContext)) {
                                    return DeviceInfoMonitor.getDeviceId(telephonyManager);
                                }
                                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                break;
                                break;
                            case 3:
                                if (Build.VERSION.SDK_INT >= 31 && com.tencent.luggage.wxa.tn.z.c().getApplicationInfo().targetSdkVersion >= 31) {
                                    com.tencent.luggage.wxa.tn.w.f("Luggage.WXA.WxaSensitiveApiInvokeHolder", "Illegal ams call: ${innerClassName}#${innerMethodName}");
                                    return null;
                                }
                                if (objArr != null) {
                                    if (objArr.length >= 1) {
                                        Object obj3 = objArr[0];
                                        if (obj3 instanceof PhoneStateListener) {
                                            phoneStateListener = (PhoneStateListener) obj3;
                                            if (objArr.length >= 2) {
                                                Object obj4 = objArr[1];
                                                if (obj4 instanceof Integer) {
                                                    i3 = ((Integer) obj4).intValue();
                                                }
                                            }
                                        }
                                    }
                                    phoneStateListener = null;
                                    if (objArr.length >= 2) {
                                    }
                                } else {
                                    phoneStateListener = null;
                                }
                                LocationMonitor.listen(telephonyManager, phoneStateListener, i3);
                                break;
                            case 4:
                                if (Build.VERSION.SDK_INT >= 29 || !f0.d(applicationContext)) {
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    break;
                                } else if (objArr != null) {
                                    if (objArr.length == 0) {
                                        if (f0.f137965d == null) {
                                            String unused2 = f0.f137965d = DeviceInfoMonitor.getImei(telephonyManager);
                                        }
                                        return f0.f137965d;
                                    }
                                    if (objArr.length == 1) {
                                        if (f0.f137966e == null) {
                                            String unused3 = f0.f137966e = DeviceInfoMonitor.getImei(telephonyManager, ((Integer) objArr[0]).intValue());
                                        }
                                        return f0.f137966e;
                                    }
                                }
                                break;
                            case 5:
                                if (Build.VERSION.SDK_INT >= 29 || !f0.d(applicationContext)) {
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    break;
                                } else if (objArr != null) {
                                    if (objArr.length == 0) {
                                        if (f0.f137967f == null) {
                                            String unused4 = f0.f137967f = DeviceInfoMonitor.getMeid(telephonyManager);
                                        }
                                        return f0.f137967f;
                                    }
                                    if (objArr.length == 1) {
                                        if (f0.f137968g == null) {
                                            String unused5 = f0.f137968g = DeviceInfoMonitor.getMeid(telephonyManager, ((Integer) objArr[0]).intValue());
                                        }
                                        return f0.f137968g;
                                    }
                                }
                                break;
                            case 6:
                                if (f0.c(applicationContext)) {
                                    return LocationMonitor.getCellLocation(telephonyManager);
                                }
                                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                break;
                            case 7:
                                if (f0.d(applicationContext)) {
                                    return DeviceInfoMonitor.getLine1Number(telephonyManager);
                                }
                                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                break;
                            case '\b':
                                if (Build.VERSION.SDK_INT < 29 && f0.d(applicationContext)) {
                                    if (f0.f137964c == null) {
                                        String unused6 = f0.f137964c = DeviceInfoMonitor.getSubscriberId(telephonyManager);
                                    }
                                    return f0.f137964c;
                                }
                                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                break;
                                break;
                            default:
                                throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                        }
                    } else if (!canonicalName.equals("android.app.ApplicationPackageManager")) {
                        if (canonicalName.equals("android.net.wifi.WifiManager")) {
                            WifiManager wifiManager = (WifiManager) obj;
                            str4.hashCode();
                            switch (str4.hashCode()) {
                                case -2129330689:
                                    if (str4.equals("startScan")) {
                                        c18 = 0;
                                        break;
                                    }
                                    break;
                                case -1437827709:
                                    if (str4.equals("getScanResults")) {
                                        c18 = 1;
                                        break;
                                    }
                                    break;
                                case -703033767:
                                    if (str4.equals("getConfiguredNetworks")) {
                                        c18 = 2;
                                        break;
                                    }
                                    break;
                                case 977831330:
                                    if (str4.equals("getConnectionInfo")) {
                                        c18 = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (c18) {
                                case 0:
                                    if (f0.c(applicationContext)) {
                                        return Boolean.valueOf(NetworkMonitor.startScan(wifiManager));
                                    }
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    return Boolean.FALSE;
                                case 1:
                                    if (f0.c(applicationContext)) {
                                        return NetworkMonitor.getScanResults(wifiManager);
                                    }
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    break;
                                case 2:
                                    if (f0.c(applicationContext)) {
                                        return NetworkMonitor.getConfigureNetworks(wifiManager);
                                    }
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    break;
                                case 3:
                                    if (f0.c(applicationContext)) {
                                        return LocationMonitor.getConnectionInfo(wifiManager);
                                    }
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaSensitiveApiInvokeHolder", String.format("no permission granted call %s from %s#%s", str4, str, str2));
                                    break;
                                default:
                                    throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                            }
                        } else {
                            if (canonicalName.equals("android.net.wifi.WifiInfo")) {
                                WifiInfo wifiInfo = (WifiInfo) obj;
                                str4.hashCode();
                                if (str4.equals("getMacAddress")) {
                                    return NetworkMonitor.getMacAddress(wifiInfo);
                                }
                                throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                            }
                            if (canonicalName.equals("java.lang.Runtime")) {
                                Runtime runtime2 = (Runtime) obj;
                                str4.hashCode();
                                if (str4.equals("exec")) {
                                    try {
                                        return RuntimeMonitor.exec(runtime2, (String) objArr[0]);
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                } else {
                                    throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                                }
                            } else {
                                throw new IllegalArgumentException(String.format("not implemented class [%s]", obj.getClass().getCanonicalName()));
                            }
                        }
                    }
                    return null;
                }
                PackageManager packageManager = applicationContext.getPackageManager();
                str4.hashCode();
                switch (str4.hashCode()) {
                    case -150905391:
                        if (str4.equals("getInstalledPackages")) {
                            c17 = 0;
                            break;
                        }
                        c17 = '\uffff';
                        break;
                    case 1374193809:
                        if (str4.equals("queryIntentActivities")) {
                            c17 = 1;
                            break;
                        }
                        c17 = '\uffff';
                        break;
                    case 1600494599:
                        break;
                    default:
                        c17 = '\uffff';
                        break;
                }
                switch (c17) {
                    case 0:
                        return InstalledAppListMonitor.getInstalledPackages(packageManager, ((Integer) objArr[0]).intValue());
                    case 1:
                        return InstalledAppListMonitor.queryIntentActivities(packageManager, (Intent) objArr[0], ((Integer) objArr[1]).intValue());
                    case 2:
                        return InstalledAppListMonitor.getInstalledApplications(packageManager, ((Integer) objArr[0]).intValue());
                    default:
                        throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
                }
            }
            NetworkInterface networkInterface = (NetworkInterface) obj;
            str4.hashCode();
            if (str4.equals("getHardwareAddress")) {
                try {
                    return NetworkMonitor.getHardwareAddress(networkInterface);
                } catch (SocketException e18) {
                    e18.printStackTrace();
                    return "";
                }
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str4));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.ia.b {
        @Override // com.tencent.luggage.wxa.ia.b
        public Object a(String str, String str2, String str3, String str4, String str5, Object obj, Object[] objArr) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.WxaSensitiveApiInvokeHolder", "onHook %s#%s methodName\uff1a%s methodDec\uff1a%s", str, str2, str4, str5);
            str4.hashCode();
            if (str4.equals("updateWiFiInfo")) {
                com.tencent.luggage.wxa.tn.w.f("Luggage.WXA.WxaSensitiveApiInvokeHolder", "updateWiFiInfo ignore");
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s] [%s]", str4, str5));
        }
    }

    public static void g() {
        try {
            JSONArray optJSONArray = new JSONObject(com.tencent.luggage.wxa.tk.c.b("hellDelList.json")).optJSONArray("delList");
            int i3 = 0;
            while (true) {
                Objects.requireNonNull(optJSONArray);
                if (i3 < optJSONArray.length()) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("method");
                    int i16 = 0;
                    while (true) {
                        Objects.requireNonNull(optJSONArray2);
                        if (i16 >= optJSONArray2.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i16);
                        if (jSONObject2.optInt("opCode", 182) == 184) {
                            arrayList2.add(new Pair(jSONObject2.optString("name"), jSONObject2.optString("desc")));
                        } else {
                            arrayList.add(new Pair(jSONObject2.optString("name"), jSONObject2.optString("desc")));
                        }
                        i16++;
                    }
                    String optString = jSONObject.optString(Constants.Service.CLASS);
                    if (!arrayList.isEmpty()) {
                        f137962a.put(optString, arrayList);
                    }
                    if (!arrayList2.isEmpty()) {
                        f137963b.put(optString, arrayList2);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        } catch (NullPointerException | JSONException e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.WxaSensitiveApiInvokeHolder", e16, "parser failed", new Object[0]);
        }
    }

    public static void h() {
        g();
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.WxaSensitiveApiInvokeHolder", "startMonitor: start monitor");
        com.tencent.luggage.wxa.fa.a.a().a(f137962a, new a());
        com.tencent.luggage.wxa.fa.a.a().a(f137963b, new b());
    }

    public static boolean c(Context context) {
        return Build.VERSION.SDK_INT < 29 || context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean d(Context context) {
        return context.checkCallingOrSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0;
    }

    public static void a(com.tencent.luggage.wxaapi.u uVar) {
        if (uVar != null) {
            f137969h = uVar;
        }
    }
}
