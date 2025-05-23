package com.tencent.liteav.audio2.route;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b implements BluetoothProfile.ServiceListener {

    /* renamed from: a, reason: collision with root package name */
    final BluetoothAdapter f118870a;

    /* renamed from: b, reason: collision with root package name */
    BluetoothProfile f118871b = null;

    /* renamed from: c, reason: collision with root package name */
    final Object f118872c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Context f118873d;

    /* renamed from: e, reason: collision with root package name */
    private AudioManager f118874e;

    public b(Context context) {
        this.f118873d = context;
        BluetoothAdapter c16 = c();
        this.f118870a = c16;
        if (c16 != null) {
            try {
                c16.getProfileProxy(context, this, 1);
            } catch (Throwable th5) {
                Log.w("BluetoothHeadsetListener", "Get profile proxy exception " + th5.getMessage(), new Object[0]);
            }
        } else {
            Log.i("BluetoothHeadsetListener", "Bluetooth adapter is null", new Object[0]);
        }
        this.f118874e = (AudioManager) this.f118873d.getSystemService("audio");
    }

    private static BluetoothAdapter c() {
        try {
            return BluetoothAdapter.getDefaultAdapter();
        } catch (Throwable th5) {
            Log.w("BluetoothHeadsetListener", "Get default adapter exception " + th5.getMessage(), new Object[0]);
            return null;
        }
    }

    private List<BluetoothDevice> d() {
        try {
            return this.f118871b.getConnectedDevices();
        } catch (Throwable th5) {
            Log.w("BluetoothHeadsetListener", "Get connected devices exception " + th5.getMessage(), new Object[0]);
            return null;
        }
    }

    private boolean e() {
        try {
            return this.f118870a.isEnabled();
        } catch (Throwable th5) {
            Log.w("BluetoothHeadsetListener", "Get bluetooth adapter status exception " + th5.getMessage(), new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
    
        if (r2.size() > 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        boolean z16;
        if (this.f118870a == null || !e()) {
            return false;
        }
        synchronized (this.f118872c) {
            if (this.f118871b == null) {
                try {
                    Log.i("BluetoothHeadsetListener", "mBluetoothHeadsetProfile is null ,wait for 1000ms", new Object[0]);
                    this.f118872c.wait(1000L);
                } catch (Throwable th5) {
                    Log.w("BluetoothHeadsetListener", "Wait exception " + th5.getMessage(), new Object[0]);
                }
                if (this.f118871b == null) {
                    Log.i("BluetoothHeadsetListener", "mBluetoothHeadsetProfile is still null", new Object[0]);
                } else {
                    Log.i("BluetoothHeadsetListener", "mBluetoothHeadsetProfile service is connected now", new Object[0]);
                }
            }
            try {
                z16 = true;
            } catch (Throwable th6) {
                Log.e("BluetoothHeadsetListener", "get connected bluetooth devices failed." + th6.getMessage(), new Object[0]);
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                for (AudioDeviceInfo audioDeviceInfo : this.f118874e.getDevices(2)) {
                    if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                        break;
                    }
                }
                z16 = false;
            } else {
                if (a(this.f118873d)) {
                    List<BluetoothDevice> d16 = d();
                    if (d16 != null) {
                    }
                }
                z16 = false;
            }
        }
        Log.i("BluetoothHeadsetListener", "find bluetooth device ".concat(String.valueOf(z16)), new Object[0]);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        try {
            this.f118870a.closeProfileProxy(1, this.f118871b);
        } catch (Throwable th5) {
            Log.w("BluetoothHeadsetListener", "Close profile proxy exception " + th5.getMessage(), new Object[0]);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int i3, BluetoothProfile bluetoothProfile) {
        BluetoothProfile bluetoothProfile2;
        if (i3 != 1) {
            return;
        }
        synchronized (this.f118872c) {
            if (this.f118870a != null && (bluetoothProfile2 = this.f118871b) != null) {
                Log.i("BluetoothHeadsetListener", "Bluetooth Headset proxy changed from %s to %s", bluetoothProfile2, bluetoothProfile);
                b();
            }
            this.f118871b = bluetoothProfile;
            this.f118872c.notifyAll();
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int i3) {
        if (i3 != 1) {
            return;
        }
        synchronized (this.f118872c) {
            if (this.f118870a != null && this.f118871b != null) {
                b();
                this.f118871b = null;
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null || LiteavSystemInfo.getSystemOSVersionInt() < 31) {
            return true;
        }
        try {
            return context.checkPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th5) {
            Log.w("BluetoothHeadsetListener", "checkPermission exception " + th5.getMessage(), new Object[0]);
            return true;
        }
    }
}
