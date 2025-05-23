package com.tencent.luggage.wxa.pe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.tn.v;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.lang.reflect.Method;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a(int i3) {
        return (i3 & 32) > 0;
    }

    public static boolean b(int i3) {
        return (i3 & 16) > 0;
    }

    public static boolean c(int i3) {
        return (i3 & 2) > 0;
    }

    public static boolean d(int i3) {
        return (i3 & 8) > 0;
    }

    public static boolean e(int i3) {
        return (i3 & 4) > 0;
    }

    public static synchronized BluetoothManager f() {
        BluetoothManager bluetoothManager;
        synchronized (c.class) {
            bluetoothManager = (BluetoothManager) z.c().getSystemService(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP);
        }
        return bluetoothManager;
    }

    public static boolean g() {
        return z.c().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean a(String str) {
        return ContextCompat.checkSelfPermission(z.c(), str) == 0;
    }

    public static boolean b() {
        boolean a16 = v.a();
        boolean b16 = v.b();
        a.c("MicroMsg.Ble.BleHelper", "isGPSEnable " + a16 + ", isNetworkEnable:" + b16, new Object[0]);
        return a16 || b16;
    }

    public static boolean c() {
        return a("android.permission.ACCESS_FINE_LOCATION") || a("android.permission.ACCESS_COARSE_LOCATION");
    }

    public static boolean d() {
        return !com.tencent.luggage.wxa.aa.a.a(18) && g();
    }

    public static synchronized BluetoothAdapter e() {
        synchronized (c.class) {
            BluetoothManager f16 = f();
            if (f16 != null) {
                return f16.getAdapter();
            }
            a.b("MicroMsg.Ble.BleHelper", "BluetoothManager is null err", new Object[0]);
            return null;
        }
    }

    public static boolean a() {
        if (e() == null) {
            return false;
        }
        return e().isEnabled();
    }

    public static boolean b(String str) {
        try {
            UUID.fromString(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return bArr;
        }
        a.b("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
        return new byte[0];
    }

    public static boolean a(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            return false;
        }
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
