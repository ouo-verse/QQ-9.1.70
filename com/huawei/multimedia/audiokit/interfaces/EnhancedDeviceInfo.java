package com.huawei.multimedia.audiokit.interfaces;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EnhancedDeviceInfo {
    private static final int BLUETOOTH_A2DP_FB_RECORDING = 10005;
    private static final String TAG = "HwAudioKit.EnhancedDeviceInfo";
    private static BluetoothAdapter mBluetoothAdapter;
    private static BluetoothDevice mBluetoothDevice;
    private AudioManager mAudioManager = null;
    private Context mContext;
    private int mDeviceType;
    private static final Object LOCK_ISKARAOKE_SUPPORTED = new Object();
    private static final Object LOCK_ISFULLBAND_RECORD_SUPPORTED = new Object();

    public EnhancedDeviceInfo(Context context, int i3) {
        this.mContext = context;
        this.mDeviceType = i3;
    }

    private void createAudioManager() {
        if (this.mAudioManager == null) {
            Object systemService = this.mContext.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                this.mAudioManager = (AudioManager) systemService;
            }
        }
    }

    public static boolean getBluetoothFBEnable(AudioManager audioManager) {
        boolean z16;
        String address;
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        AudioDeviceInfo[] audioDeviceInfoArr = new AudioDeviceInfo[0];
        if (audioManager != null) {
            audioDeviceInfoArr = audioManager.getDevices(2);
        }
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            if (audioDeviceInfo.getType() == 8) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                BluetoothAdapter bluetoothAdapter = mBluetoothAdapter;
                address = audioDeviceInfo.getAddress();
                mBluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            }
        }
        if (mBluetoothDevice == null) {
            return false;
        }
        return isBluetoothFBRecording();
    }

    private static boolean isBluetoothFBRecording() {
        boolean z16 = false;
        try {
            boolean z17 = true;
            Object invoke = BluetoothDevice.class.getMethod("getMetadata", Integer.TYPE).invoke(mBluetoothDevice, 10005);
            if (!(invoke instanceof byte[])) {
                return false;
            }
            byte[] bArr = (byte[]) invoke;
            if (bArr.length <= 0) {
                return false;
            }
            if (bArr[0] == 0) {
                z17 = false;
            }
            try {
                LogUtils.info(TAG, "isBluetoothFBRecording byteArray[0]=" + ((int) bArr[0]));
                return z17;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                z16 = z17;
                LogUtils.error(TAG, "isBluetoothFBRecording Exception");
                return z16;
            } catch (NoSuchMethodException unused2) {
                z16 = z17;
                LogUtils.error(TAG, "No Such Method getMetadata");
                return z16;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused3) {
        } catch (NoSuchMethodException unused4) {
        }
    }

    public boolean isFullbandRecordSupported() {
        boolean z16;
        synchronized (LOCK_ISFULLBAND_RECORD_SUPPORTED) {
            int i3 = this.mDeviceType;
            if (i3 != 3) {
                z16 = false;
                if (i3 != 4) {
                    if (i3 != 8) {
                        if (i3 != 11 && i3 != 22) {
                        }
                    } else {
                        createAudioManager();
                        z16 = getBluetoothFBEnable(this.mAudioManager);
                    }
                }
                LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isFbRecordSupported=" + z16);
            }
            z16 = true;
            LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isFbRecordSupported=" + z16);
        }
        return z16;
    }

    public boolean isKaraokeSupported() {
        boolean z16;
        synchronized (LOCK_ISKARAOKE_SUPPORTED) {
            int i3 = this.mDeviceType;
            if (i3 != 3 && i3 != 4) {
                if (i3 != 8) {
                    if (i3 != 11 && i3 != 22) {
                        z16 = false;
                    }
                } else {
                    createAudioManager();
                    z16 = getBluetoothFBEnable(this.mAudioManager);
                }
                LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isDeviceSupported=" + z16);
            }
            z16 = true;
            LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isDeviceSupported=" + z16);
        }
        return z16;
    }
}
