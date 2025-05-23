package com.tencent.avcore.jni.audiodevice;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BluetoothHelper implements BluetoothProfile.ServiceListener {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    Runnable BluetoothConnectionRunnable;
    private final Object lock;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothHeadset mBluetoothHeadset;
    private volatile int mBluetoothState;
    private DeviceConfigManager mDeviceConfigManager;
    private boolean mIsInOnBluetoothConnected;
    private IStateChangeListener mStateChangeListener;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface BluetoothState {
        public static final int HEADSET_AVAILABLE = 2;
        public static final int HEADSET_UNAVAILABLE = 1;
        public static final int SCO_CONNECTED = 5;
        public static final int SCO_CONNECTING = 4;
        public static final int SCO_DISCONNECTING = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IStateChangeListener {
        void onBluetoothPluginStateChange(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            TAG = BluetoothHelper.class.getSimpleName();
        }
    }

    public BluetoothHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mBluetoothAdapter = null;
        this.mBluetoothHeadset = null;
        this.mStateChangeListener = null;
        this.mDeviceConfigManager = DeviceConfigManager.getInstance();
        this.lock = new Object();
        this.mIsInOnBluetoothConnected = false;
        this.mBluetoothState = 1;
        this.BluetoothConnectionRunnable = new Runnable() { // from class: com.tencent.avcore.jni.audiodevice.BluetoothHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BluetoothHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    BluetoothHelper.this.onBluetoothConnected();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addAction(IntentFilter intentFilter) {
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    }

    static String getBTAdapterConnectionState(int i3) {
        String str;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        str = "unknown";
                    } else {
                        str = "STATE_DISCONNECTING";
                    }
                } else {
                    str = "STATE_CONNECTED";
                }
            } else {
                str = "STATE_CONNECTING";
            }
        } else {
            str = "STATE_DISCONNECTED";
        }
        return str + "[" + i3 + "]";
    }

    static String getSCOAudioState(int i3) {
        String str;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        str = "unknown";
                    } else {
                        str = "SCO_AUDIO_STATE_CONNECTING";
                    }
                } else {
                    str = "SCO_AUDIO_STATE_CONNECTED";
                }
            } else {
                str = "SCO_AUDIO_STATE_DISCONNECTED";
            }
        } else {
            str = "SCO_AUDIO_STATE_ERROR";
        }
        return str + "[" + i3 + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBluetoothConnected() {
        List<BluetoothDevice> connectedDevices;
        DeviceConfigManager deviceConfigManager;
        synchronized (this.lock) {
            BluetoothHeadset bluetoothHeadset = this.mBluetoothHeadset;
            if (bluetoothHeadset == null) {
                return;
            }
            this.mIsInOnBluetoothConnected = true;
            if (bluetoothHeadset != null) {
                try {
                    connectedDevices = bluetoothHeadset.getConnectedDevices();
                } catch (Exception e16) {
                    AVCoreLog.e(TAG, "onBluetoothConnected failed. exception: " + e16.getMessage());
                }
                if (connectedDevices == null && !connectedDevices.isEmpty()) {
                    if (bluetoothHeadset != null && this.mDeviceConfigManager != null) {
                        String str = "";
                        String str2 = "";
                        for (int i3 = 0; i3 < connectedDevices.size(); i3++) {
                            BluetoothDevice bluetoothDevice = connectedDevices.get(i3);
                            int connectionState = bluetoothHeadset.getConnectionState(bluetoothDevice);
                            str = str + bluetoothDevice.getName() + ",";
                            str2 = str2 + connectionState + ",";
                        }
                        BluetoothDevice bluetoothDevice2 = connectedDevices.get(0);
                        int connectionState2 = bluetoothHeadset.getConnectionState(bluetoothDevice2);
                        AVCoreLog.i(TAG, "onBluetoothConnected successfully. device name: " + bluetoothDevice2.getName() + ", connection state: " + connectionState2 + ", device name list: " + str + ", connection state list: " + str2);
                        if (connectionState2 == 2) {
                            this.mDeviceConfigManager.setBlueToothDevName(bluetoothDevice2.getName());
                        }
                    }
                } else {
                    AVCoreLog.e(TAG, "onBluetoothConnected failed. devices == null || devices.isEmpty().");
                    setBluetoothState(1);
                }
                deviceConfigManager = this.mDeviceConfigManager;
                if (deviceConfigManager != null) {
                    if (!TextUtils.isEmpty(deviceConfigManager.getBlueToothDevName()) && isConnected()) {
                        this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET, true);
                        setBluetoothState(2);
                        this.mStateChangeListener.onBluetoothPluginStateChange(true);
                    } else {
                        this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET, false);
                    }
                }
                this.mIsInOnBluetoothConnected = false;
            }
            connectedDevices = null;
            if (connectedDevices == null) {
            }
            AVCoreLog.e(TAG, "onBluetoothConnected failed. devices == null || devices.isEmpty().");
            setBluetoothState(1);
            deviceConfigManager = this.mDeviceConfigManager;
            if (deviceConfigManager != null) {
            }
            this.mIsInOnBluetoothConnected = false;
        }
    }

    public BluetoothHeadset getBluetoothHeadset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (BluetoothHeadset) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mBluetoothHeadset;
    }

    public int getBluetoothState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mBluetoothState;
    }

    public boolean init(Context context, IStateChangeListener iStateChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iStateChangeListener)).booleanValue();
        }
        String str = TAG;
        AVCoreLog.i(str, "init.");
        if (context != null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.mBluetoothAdapter = defaultAdapter;
            if (defaultAdapter != null) {
                this.mStateChangeListener = iStateChangeListener;
                if (iStateChangeListener != null) {
                    if (this.mBluetoothHeadset == null && !defaultAdapter.getProfileProxy(context, this, 1)) {
                        AVCoreLog.e(str, "init failed, getProfileProxy failed.");
                        return false;
                    }
                    this.mIsInOnBluetoothConnected = false;
                    return true;
                }
            }
        }
        AVCoreLog.e(str, "init failed. mContext[" + context + "], mBluetoothAdapter[" + this.mBluetoothAdapter + "], mStateChangeListener[" + this.mStateChangeListener + "]");
        return false;
    }

    public boolean isConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        BluetoothHeadset bluetoothHeadset = this.mBluetoothHeadset;
        if (bluetoothHeadset == null) {
            return false;
        }
        try {
            List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
            if (connectedDevices == null) {
                return false;
            }
            if (connectedDevices.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            AVCoreLog.e(TAG, "isConnected exception[" + e16.getMessage() + "]");
            return false;
        }
    }

    public void onReceive(Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        String str2 = "unknown";
        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String str3 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive. BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED[");
            sb5.append(getBTAdapterConnectionState(intExtra));
            sb5.append(" <- ");
            sb5.append(getBTAdapterConnectionState(intExtra2));
            sb5.append("], device[");
            if (bluetoothDevice == null) {
                str = "unknown";
            } else {
                str = bluetoothDevice.getName();
            }
            sb5.append(str);
            sb5.append("]");
            AVCoreLog.i(str3, sb5.toString());
            if (intExtra == 2) {
                this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET, true);
                DeviceConfigManager deviceConfigManager = this.mDeviceConfigManager;
                if (bluetoothDevice != null) {
                    str2 = bluetoothDevice.getName();
                }
                deviceConfigManager.setBlueToothDevName(str2);
                return;
            }
            if (intExtra == 0) {
                this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET, false);
                return;
            }
            return;
        }
        if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
            AVCoreLog.i(TAG, "onReceive. BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED[" + intExtra3 + "]");
            if (intExtra3 == 12) {
                setBluetoothState(5);
                return;
            } else {
                if (intExtra3 == 10) {
                    setBluetoothState(3);
                    return;
                }
                return;
            }
        }
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice2 != null) {
                str2 = bluetoothDevice2.getName();
            }
            AVCoreLog.i(TAG, "onReceive. BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED[" + intExtra4 + "], device[" + str2 + "]");
            if (intExtra4 != 0) {
                if (intExtra4 == 2) {
                    setBluetoothState(2);
                    this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET, true);
                    new BaseThread(this.BluetoothConnectionRunnable).start();
                    return;
                }
                return;
            }
            if (this.mDeviceConfigManager.getBlueToothDevName().equals(str2)) {
                setBluetoothState(1);
                this.mDeviceConfigManager.setVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET, false);
                return;
            }
            return;
        }
        if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
            int intExtra5 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            int intExtra6 = intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
            BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            boolean visible = this.mDeviceConfigManager.getVisible(TraeConstants.DEVICE_BLUETOOTH_HEADSET);
            String str4 = TAG;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onReceive. AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED[");
            sb6.append(getSCOAudioState(intExtra5));
            sb6.append(" <- ");
            sb6.append(getSCOAudioState(intExtra6));
            sb6.append("], device[");
            if (bluetoothDevice3 != null) {
                str2 = bluetoothDevice3.getName();
            }
            sb6.append(str2);
            sb6.append("] , visible[");
            sb6.append(visible);
            sb6.append("]");
            AVCoreLog.i(str4, sb6.toString());
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i3, BluetoothProfile bluetoothProfile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bluetoothProfile);
            return;
        }
        AVCoreLog.i(TAG, "onServiceConnected. profile: " + i3 + ", old BluetoothHeadset: " + this.mBluetoothHeadset + ", new BluetoothHeadset: " + bluetoothProfile);
        if (i3 == 1) {
            BluetoothHeadset bluetoothHeadset = this.mBluetoothHeadset;
            if (bluetoothHeadset != null && bluetoothHeadset != bluetoothProfile) {
                this.mBluetoothAdapter.closeProfileProxy(1, bluetoothHeadset);
                this.mBluetoothHeadset = null;
            }
            this.mBluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
            new BaseThread(this.BluetoothConnectionRunnable).start();
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        AVCoreLog.i(TAG, "onServiceDisconnected.");
        if (i3 == 1) {
            if (isConnected()) {
                this.mStateChangeListener.onBluetoothPluginStateChange(false);
            }
            synchronized (this.lock) {
                if (this.mBluetoothHeadset != null) {
                    setBluetoothState(1);
                    this.mBluetoothHeadset = null;
                }
            }
        }
    }

    public void release() {
        BluetoothHeadset bluetoothHeadset;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AVCoreLog.i(TAG, "release.");
        synchronized (this.lock) {
            if (this.mIsInOnBluetoothConnected) {
                int i3 = 0;
                while (this.mIsInOnBluetoothConnected && i3 < 2000) {
                    try {
                        LockMethodProxy.sleep(10);
                        i3 += 10;
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            bluetoothHeadset = this.mBluetoothHeadset;
            this.mBluetoothHeadset = null;
        }
        try {
            BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
            if (bluetoothAdapter != null && bluetoothHeadset != null) {
                bluetoothAdapter.closeProfileProxy(1, bluetoothHeadset);
            }
        } catch (Exception e17) {
            AVCoreLog.e(TAG, " release failed. exception: " + e17.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setBluetoothConnectionDevice() {
        List<BluetoothDevice> connectedDevices;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BluetoothHeadset bluetoothHeadset = this.mBluetoothHeadset;
        if (bluetoothHeadset != null) {
            try {
                connectedDevices = bluetoothHeadset.getConnectedDevices();
            } catch (Exception e16) {
                AVCoreLog.e(TAG, "setBluetoothConnectionDevice run exception[" + e16.getMessage() + "]");
            }
            if (connectedDevices != null) {
                return;
            }
            if (connectedDevices.isEmpty()) {
                AVCoreLog.e(TAG, "setBluetoothConnectionDevice failed. devices is empty.");
                return;
            }
            for (int i3 = 0; i3 < connectedDevices.size(); i3++) {
                BluetoothDevice bluetoothDevice = connectedDevices.get(i3);
                int connectionState = this.mBluetoothHeadset.getConnectionState(bluetoothDevice);
                boolean isAudioConnected = this.mBluetoothHeadset.isAudioConnected(bluetoothDevice);
                AVCoreLog.i(TAG, "setBluetoothConnectionDevice, device name[" + bluetoothDevice.getName() + "], connection state[" + connectionState + "], isAudioConnected[" + isAudioConnected + "]");
                if (connectionState == 2) {
                    this.mDeviceConfigManager.setBlueToothDevName(bluetoothDevice.getName());
                    return;
                }
            }
            return;
        }
        connectedDevices = null;
        if (connectedDevices != null) {
        }
    }

    public void setBluetoothState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        AVCoreLog.i(TAG, "setBluetoothState. old state: " + this.mBluetoothState + ", new state: " + i3);
        this.mBluetoothState = i3;
    }
}
