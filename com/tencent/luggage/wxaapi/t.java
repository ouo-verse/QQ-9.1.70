package com.tencent.luggage.wxaapi;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@SuppressLint({"MissingPermission", "NewApi", "HardwareIds"})
/* loaded from: classes9.dex */
public final class t {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c extends ScanCallback {
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i3, ScanResult scanResult) {
            super.onScanResult(i3, scanResult);
        }
    }

    public static void a(Context context) {
        d(context);
        b();
        e(context);
        g(context);
        f(context);
        c(context);
    }

    private static void b() {
        DeviceInfoMonitor.getString(z.c().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        DeviceInfoMonitor.getStringSystem(z.c().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
    }

    private static void c(Context context) {
        BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP)).getAdapter();
        ((Boolean) com.tencent.luggage.wxa.ia.a.a(adapter, "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testBluetooth", "(Landroid/content/Context;)V", "android/bluetooth/BluetoothAdapter", "startDiscovery", "()Z")).booleanValue();
        ((Boolean) com.tencent.luggage.wxa.ia.a.a(adapter, new com.tencent.luggage.wxa.ja.a().a(new a()).a(), "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testBluetooth", "(Landroid/content/Context;)V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
        ((Boolean) com.tencent.luggage.wxa.ia.a.a(adapter, new com.tencent.luggage.wxa.ja.a().a(new b()).a((Object) null).a(), "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testBluetooth", "(Landroid/content/Context;)V", "android/bluetooth/BluetoothAdapter", "startLeScan", "([Ljava/util/UUID;Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
        com.tencent.luggage.wxa.ia.a.a(adapter.getBluetoothLeScanner(), new com.tencent.luggage.wxa.ja.a().a(new c()).a(), "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testBluetooth", "(Landroid/content/Context;)V", "android/bluetooth/le/BluetoothLeScanner", "startScan", "(Landroid/bluetooth/le/ScanCallback;)V");
    }

    private static void d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Iterator it = ((List) com.tencent.luggage.wxa.ia.a.a(packageManager, com.tencent.luggage.wxa.ja.b.a(0, new com.tencent.luggage.wxa.ja.a()).a(), "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testInstalledPkg", "(Landroid/content/Context;)V", "android/content/pm/PackageManager", "getInstalledPackages", "(I)Ljava/util/List;")).iterator();
        while (it.hasNext()) {
            w.d("Luggage.WxaSensitiveApiHookTest", "testInstalledPkg: " + ((PackageInfo) it.next()));
        }
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            com.tencent.luggage.wxa.er.a.a("\"hello\"", new BufferedReader(new InputStreamReader(((Process) com.tencent.luggage.wxa.ia.a.a(Runtime.getRuntime(), new com.tencent.luggage.wxa.ja.a().a("echo \"hello\"").a(), "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testInstalledPkg", "(Landroid/content/Context;)V", "java/lang/Runtime", "exec", "(Ljava/lang/String;)Ljava/lang/Process;")).getInputStream())).readLine());
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:110"));
        w0.a(z.c(), intent, false);
    }

    private static void e(Context context) {
        ArrayList<NetworkInterface> arrayList;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            arrayList = Collections.list(NetworkMonitor.getNetworkInterfaces());
        } catch (SocketException e17) {
            e17.printStackTrace();
            arrayList = null;
        }
        for (NetworkInterface networkInterface : arrayList) {
            if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                byte[] bArr = new byte[0];
                try {
                    bArr = (byte[]) com.tencent.luggage.wxa.ia.a.a(networkInterface, "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testMac", "(Landroid/content/Context;)V", "java/net/NetworkInterface", "getHardwareAddress", "()[B");
                } catch (SocketException e18) {
                    e18.printStackTrace();
                }
                if (bArr != null && bArr.length > 0) {
                    for (byte b16 : bArr) {
                        String.format("%02x:", Byte.valueOf(b16));
                    }
                }
            }
        }
    }

    private static void f(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
    }

    private static void g(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        ((Boolean) com.tencent.luggage.wxa.ia.a.a(wifiManager, "com/tencent/luggage/wxaapi/WxaSensitiveApiHookTest", "testWifiManagerInvoke", "(Landroid/content/Context;)V", "android/net/wifi/WifiManager", "startScan", "()Z")).booleanValue();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements BluetoothAdapter.LeScanCallback {
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements BluetoothAdapter.LeScanCallback {
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
        }
    }
}
