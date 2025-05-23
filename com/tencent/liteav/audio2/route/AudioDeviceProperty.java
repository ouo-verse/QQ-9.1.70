package com.tencent.liteav.audio2.route;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.liteav.audio2.route.a;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.Iterator;

@JNINamespace("liteav::audio")
/* loaded from: classes7.dex */
public class AudioDeviceProperty implements a.InterfaceC5950a {
    private static final String TAG = "AudioDeviceProperty";
    private AudioDeviceCallback mAudioDeviceCallback;
    private boolean mAudioDeviceCallbackAvailable = false;
    private a mAudioEventBroadcastReceiver;
    private final AudioManager mAudioManager;
    private b mBluetoothHeadsetListener;
    private final Context mContext;
    private long mNativeAudioDeviceProperty;

    /* loaded from: classes7.dex */
    public static class UsbAudioDeviceInfo {

        /* renamed from: a, reason: collision with root package name */
        public String f118866a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f118867b = "";

        public String getName() {
            return this.f118866a;
        }

        public String getVidPid() {
            return this.f118867b;
        }
    }

    public AudioDeviceProperty(long j3) {
        this.mNativeAudioDeviceProperty = j3;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mContext = applicationContext;
        this.mAudioManager = (AudioManager) applicationContext.getSystemService("audio");
    }

    private void buildAudioDeviceCallback() {
        if (this.mAudioDeviceCallback != null) {
            return;
        }
        this.mAudioDeviceCallback = new AudioDeviceCallback() { // from class: com.tencent.liteav.audio2.route.AudioDeviceProperty.1
            @Override // android.media.AudioDeviceCallback
            public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                if (audioDeviceInfoArr.length != 0) {
                    AudioDeviceProperty.this.mAudioDeviceCallbackAvailable = true;
                    for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                        Log.i(AudioDeviceProperty.TAG, "added device type is " + audioDeviceInfo.getType() + " sink: " + audioDeviceInfo.isSink() + " product name: " + ((Object) audioDeviceInfo.getProductName()), new Object[0]);
                        if (audioDeviceInfo.getType() == 8 && LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                            AudioDeviceProperty.nativeNotifyBluetoothConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, true);
                        } else if (audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 22) {
                            AudioDeviceProperty.nativeNotifyUsbConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, audioDeviceInfo.getProductName().toString(), AudioDeviceProperty.this.isUsbHeadsetAvailable());
                        } else if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4) {
                            AudioDeviceProperty.nativeNotifyWiredHeadsetConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, true);
                        }
                    }
                }
            }

            @Override // android.media.AudioDeviceCallback
            public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                if (audioDeviceInfoArr.length == 0) {
                    return;
                }
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    Log.i(AudioDeviceProperty.TAG, "removed device type is " + audioDeviceInfo.getType() + " sink: " + audioDeviceInfo.isSink() + " product name: " + ((Object) audioDeviceInfo.getProductName()), new Object[0]);
                    if (audioDeviceInfo.getType() == 8 && LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                        AudioDeviceProperty.nativeNotifyBluetoothConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, false);
                    } else if (audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 22) {
                        AudioDeviceProperty.nativeNotifyUsbConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, audioDeviceInfo.getProductName().toString(), AudioDeviceProperty.this.isUsbHeadsetAvailable());
                    } else if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4) {
                        AudioDeviceProperty.nativeNotifyWiredHeadsetConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, false);
                    }
                }
            }
        };
    }

    public static boolean isUsbHeadsetDevice(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        for (int i3 = 0; i3 < usbDevice.getInterfaceCount(); i3++) {
            try {
                if (usbDevice.getInterface(i3).getInterfaceClass() == 1) {
                    return true;
                }
            } catch (Throwable th5) {
                Log.e(TAG, "Get interface exception " + th5.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyBluetoothConnectionChangedFromJava(long j3, boolean z16);

    private static native void nativeNotifyBluetoothScoConnectedFromJava(long j3, boolean z16);

    private static native void nativeNotifySystemVolumeChangedFromJava(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyUsbConnectionChangedFromJava(long j3, String str, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyWiredHeadsetConnectionChangedFromJava(long j3, boolean z16);

    private void registerAudioDeviceCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 23) {
            return;
        }
        if (this.mAudioDeviceCallback == null) {
            buildAudioDeviceCallback();
        }
        AudioDeviceCallback audioDeviceCallback = this.mAudioDeviceCallback;
        if (audioDeviceCallback == null) {
            return;
        }
        try {
            this.mAudioManager.registerAudioDeviceCallback(audioDeviceCallback, null);
            Log.i(TAG, "register audio device callback", new Object[0]);
        } catch (Throwable th5) {
            Log.e(TAG, "registerAudioDeviceCallback exception " + th5.getMessage(), new Object[0]);
        }
    }

    private void unregisterAudioDeviceCallback() {
        AudioDeviceCallback audioDeviceCallback;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 23 || (audioDeviceCallback = this.mAudioDeviceCallback) == null) {
            return;
        }
        try {
            this.mAudioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
            Log.i(TAG, "unregister audio device callback", new Object[0]);
        } catch (Throwable th5) {
            Log.e(TAG, "unregisterAudioDeviceCallback exception " + th5.getMessage(), new Object[0]);
        }
    }

    public UsbAudioDeviceInfo GetUsbAudioDeviceInfo(String str) {
        UsbManager usbManager;
        UsbAudioDeviceInfo usbAudioDeviceInfo = new UsbAudioDeviceInfo();
        try {
            usbManager = (UsbManager) this.mContext.getSystemService("usb");
        } catch (Throwable th5) {
            Log.i(TAG, "getDeviceList exception " + th5.getMessage(), new Object[0]);
        }
        if (usbManager != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                if (str.contains(usbDevice.getProductName()) || isUsbHeadsetDevice(usbDevice)) {
                    usbAudioDeviceInfo.f118866a = usbDevice.getProductName();
                    usbAudioDeviceInfo.f118867b = String.valueOf(usbDevice.getVendorId()) + usbDevice.getProductId();
                }
            }
            return usbAudioDeviceInfo;
        }
        return usbAudioDeviceInfo;
    }

    public boolean checkBluetoothPermission() {
        return b.a(this.mContext);
    }

    public int getMode() {
        try {
            return this.mAudioManager.getMode();
        } catch (Throwable th5) {
            Log.i(TAG, "Get mode exception " + th5.getMessage(), new Object[0]);
            return 0;
        }
    }

    public int getSystemVolume() {
        int i3;
        try {
            if (this.mAudioManager.getMode() == 0) {
                i3 = 3;
            } else {
                i3 = 0;
            }
            int streamMaxVolume = this.mAudioManager.getStreamMaxVolume(i3);
            if (streamMaxVolume <= 0) {
                return -1;
            }
            return (int) ((SystemMethodProxy.getStreamVolume(this.mAudioManager, i3) / streamMaxVolume) * 100.0f);
        } catch (Throwable th5) {
            Log.e(TAG, "getStreamVolume exception " + th5.getMessage(), new Object[0]);
            return -1;
        }
    }

    public boolean isBluetoothHeadsetConnected() {
        b bVar = this.mBluetoothHeadsetListener;
        if (bVar == null) {
            Log.e(TAG, "mBluetoothHeadsetListener is null", new Object[0]);
            return false;
        }
        return bVar.a();
    }

    public boolean isBluetoothScoConnected() {
        try {
            new IntentFilter();
            Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
            if (registerReceiver == null) {
                return false;
            }
            if (registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0) != 1) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            Log.i(TAG, "isBluetoothScoConnected exception " + th5.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isBluetoothScoOn() {
        try {
            return this.mAudioManager.isBluetoothScoOn();
        } catch (Throwable th5) {
            Log.i(TAG, "isBluetoothScoOn exception " + th5.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isSpeakerphoneOn() {
        try {
            return this.mAudioManager.isSpeakerphoneOn();
        } catch (Throwable th5) {
            Log.i(TAG, "isSpeakerphoneOn exception " + th5.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isUsbHeadsetAvailable() {
        UsbManager usbManager;
        try {
            usbManager = (UsbManager) this.mContext.getSystemService("usb");
        } catch (Throwable th5) {
            Log.i(TAG, "getDeviceList exception " + th5.getMessage(), new Object[0]);
        }
        if (usbManager == null) {
            return false;
        }
        Iterator<UsbDevice> it = usbManager.getDeviceList().values().iterator();
        while (it.hasNext()) {
            if (isUsbHeadsetDevice(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean isWiredHeadsetOn() {
        try {
            return this.mAudioManager.isWiredHeadsetOn();
        } catch (Throwable th5) {
            Log.i(TAG, "isWiredHeadsetOn exception " + th5.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC5950a
    public void onBluetoothConnectionChanged(boolean z16) {
        nativeNotifyBluetoothConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z16);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC5950a
    public void onBluetoothScoConnected(boolean z16) {
        nativeNotifyBluetoothScoConnectedFromJava(this.mNativeAudioDeviceProperty, z16);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC5950a
    public void onSystemVolumeChanged() {
        nativeNotifySystemVolumeChangedFromJava(this.mNativeAudioDeviceProperty);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC5950a
    public void onUsbConnectionChanged(String str, boolean z16) {
        if (this.mAudioDeviceCallbackAvailable) {
            return;
        }
        nativeNotifyUsbConnectionChangedFromJava(this.mNativeAudioDeviceProperty, str, z16);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC5950a
    public void onWiredHeadsetConnectionChanged(boolean z16) {
        if (this.mAudioDeviceCallbackAvailable) {
            return;
        }
        nativeNotifyWiredHeadsetConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z16);
    }

    public void setBluetoothScoOn(boolean z16) {
        try {
            this.mAudioManager.setBluetoothScoOn(z16);
            Log.i(TAG, "setBluetoothScoOn ".concat(String.valueOf(z16)), new Object[0]);
        } catch (Throwable th5) {
            Log.i(TAG, "setBluetoothScoOn exception " + th5.getMessage(), new Object[0]);
        }
    }

    public void setSpeakerphoneOn(boolean z16) {
        try {
            this.mAudioManager.setSpeakerphoneOn(z16);
            Log.i(TAG, "setSpeakerphoneOn ".concat(String.valueOf(z16)), new Object[0]);
        } catch (Throwable th5) {
            Log.i(TAG, "setSpeakerphoneOn exception " + th5.getMessage(), new Object[0]);
        }
    }

    public void setVoip(boolean z16) {
        int i3;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        try {
            this.mAudioManager.setMode(i3);
            Log.i(TAG, "setMode ".concat(String.valueOf(i3)), new Object[0]);
        } catch (Throwable th5) {
            Log.i(TAG, "Set mode exception " + th5.getMessage(), new Object[0]);
        }
    }

    public void setWiredHeadsetOn(boolean z16) {
        try {
            this.mAudioManager.setWiredHeadsetOn(z16);
            Log.i(TAG, "setWiredHeadsetOn ".concat(String.valueOf(z16)), new Object[0]);
        } catch (Throwable th5) {
            Log.i(TAG, "setWiredHeadsetOn exception " + th5.getMessage(), new Object[0]);
        }
    }

    public void start() {
        registerAudioDeviceCallback();
        a aVar = new a(this.mContext, this);
        this.mAudioEventBroadcastReceiver = aVar;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            aVar.f118868a.registerReceiver(aVar, intentFilter);
        } catch (Throwable unused) {
            Log.e("AudioEventBroadcastReceiver", "register broadcast exception", new Object[0]);
        }
        this.mBluetoothHeadsetListener = new b(this.mContext);
    }

    public void startBluetoothSco() {
        try {
            this.mAudioManager.startBluetoothSco();
            Log.i(TAG, "startBluetoothSco", new Object[0]);
        } catch (Throwable th5) {
            Log.i(TAG, "startBluetoothSco exception " + th5.getMessage(), new Object[0]);
        }
    }

    public void stop() {
        Context context;
        a aVar = this.mAudioEventBroadcastReceiver;
        if (aVar != null && (context = aVar.f118868a) != null) {
            try {
                context.unregisterReceiver(aVar);
            } catch (Exception unused) {
            }
        }
        this.mAudioEventBroadcastReceiver = null;
        b bVar = this.mBluetoothHeadsetListener;
        if (bVar != null) {
            synchronized (bVar.f118872c) {
                if (bVar.f118870a != null && bVar.f118871b != null) {
                    bVar.b();
                    bVar.f118871b = null;
                }
            }
        }
        this.mBluetoothHeadsetListener = null;
        unregisterAudioDeviceCallback();
    }

    public void stopBluetoothSco() {
        try {
            this.mAudioManager.stopBluetoothSco();
            Log.i(TAG, "stopBluetoothSco", new Object[0]);
        } catch (Throwable th5) {
            Log.i(TAG, "stopBluetoothSco exception " + th5.getMessage(), new Object[0]);
        }
    }
}
