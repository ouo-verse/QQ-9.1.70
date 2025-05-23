package com.tencent.avcore.jni.audiodevice;

import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceConfigManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG;
    public static final String UNKNOWN_BLUETOOTH_NAME = "unknown";
    private static volatile DeviceConfigManager sInstance;
    private String mBlueToothDevName;
    private String mConnectedDevice;
    private String mConnectingDevice;
    private ConcurrentHashMap<String, DeviceConfig> mDeviceConfigMap;
    private String mPrevConnectedDevice;
    private volatile boolean mVisibleUpdate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13663);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            TAG = DeviceConfigManager.class.getSimpleName();
            sInstance = null;
        }
    }

    DeviceConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDeviceConfigMap = new ConcurrentHashMap<>();
        this.mPrevConnectedDevice = TraeConstants.DEVICE_NONE;
        this.mConnectedDevice = TraeConstants.DEVICE_NONE;
        this.mConnectingDevice = TraeConstants.DEVICE_NONE;
        this.mBlueToothDevName = "unknown";
        this.mVisibleUpdate = false;
    }

    private void addConfig(String str, int i3) {
        if (!checkDeviceName(str)) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "addConfig, invalid deviceName[" + str + "]");
                return;
            }
            return;
        }
        if (this.mDeviceConfigMap.containsKey(str)) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(TAG, "addConfig, already exist deviceName[" + str + "]");
                return;
            }
            return;
        }
        DeviceConfig deviceConfig = new DeviceConfig(null);
        deviceConfig.deviceName = str;
        deviceConfig.priority = i3;
        this.mDeviceConfigMap.put(str, deviceConfig);
        this.mVisibleUpdate = true;
    }

    public static boolean checkDeviceName(String str) {
        if (!TraeConstants.DEVICE_SPEAKERPHONE.equals(str) && !TraeConstants.DEVICE_EARPHONE.equals(str) && !TraeConstants.DEVICE_WIRED_HEADSET.equals(str) && !TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str)) {
            return false;
        }
        return true;
    }

    public static DeviceConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (DeviceConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new DeviceConfigManager();
                }
            }
        }
        return sInstance;
    }

    private void logDevices() {
        boolean z16;
        int i3;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "logDevices, mConnectedDevice[" + getConnectedDevice() + "] mConnectingDevice[" + getConnectingDevice() + "] mPrevConnectedDevice[" + getPrevConnectedDevice() + "] AHPDevice[" + getVisibleHighestPriorityDevice(null) + "] deviceNumber[" + getDeviceNumber() + "] availableNumber[" + getVisibleDeviceList().size() + "]");
            for (Map.Entry<String, DeviceConfig> entry : this.mDeviceConfigMap.entrySet()) {
                String str = TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("logDevices, devName[");
                sb5.append(entry.getKey());
                sb5.append("] visible[");
                if (entry.getValue() != null && entry.getValue().visible) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("] priority[");
                if (entry.getValue() != null) {
                    i3 = entry.getValue().priority;
                } else {
                    i3 = -1;
                }
                sb5.append(i3);
                sb5.append("]");
                AVCoreLog.e(str, sb5.toString());
            }
        }
    }

    public void clearConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "clearConfig");
        }
        this.mDeviceConfigMap.clear();
        this.mPrevConnectedDevice = TraeConstants.DEVICE_NONE;
        this.mConnectedDevice = TraeConstants.DEVICE_NONE;
        this.mConnectingDevice = TraeConstants.DEVICE_NONE;
        this.mBlueToothDevName = "unknown";
        this.mVisibleUpdate = false;
    }

    public String getBlueToothDevName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mBlueToothDevName;
    }

    public String getConnectedDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(this.mConnectedDevice);
        if (deviceConfig != null && deviceConfig.visible) {
            return this.mConnectedDevice;
        }
        return TraeConstants.DEVICE_NONE;
    }

    public String getConnectingDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(this.mConnectingDevice);
        if (deviceConfig != null && deviceConfig.visible) {
            return this.mConnectingDevice;
        }
        return TraeConstants.DEVICE_NONE;
    }

    public String getDeviceName(int i3) {
        DeviceConfig deviceConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        Iterator<Map.Entry<String, DeviceConfig>> it = this.mDeviceConfigMap.entrySet().iterator();
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, DeviceConfig> next = it.next();
                if (i16 == i3) {
                    deviceConfig = next.getValue();
                    break;
                }
                i16++;
            } else {
                deviceConfig = null;
                break;
            }
        }
        if (deviceConfig != null) {
            return deviceConfig.deviceName;
        }
        return TraeConstants.DEVICE_NONE;
    }

    public int getDeviceNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mDeviceConfigMap.size();
    }

    public String getPrevConnectedDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(this.mPrevConnectedDevice);
        if (deviceConfig != null && deviceConfig.visible) {
            return this.mPrevConnectedDevice;
        }
        return TraeConstants.DEVICE_NONE;
    }

    public int getPriority(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(str);
        if (deviceConfig != null) {
            return deviceConfig.priority;
        }
        return -1;
    }

    public boolean getVisible(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(str);
        if (deviceConfig != null && deviceConfig.visible) {
            return true;
        }
        return false;
    }

    public ArrayList<String> getVisibleDeviceList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, DeviceConfig>> it = this.mDeviceConfigMap.entrySet().iterator();
        while (it.hasNext()) {
            DeviceConfig value = it.next().getValue();
            if (value != null && value.visible) {
                arrayList.add(value.deviceName);
            }
        }
        return arrayList;
    }

    public String getVisibleHighestPriorityDevice(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        Iterator<Map.Entry<String, DeviceConfig>> it = this.mDeviceConfigMap.entrySet().iterator();
        DeviceConfig deviceConfig = null;
        while (it.hasNext()) {
            DeviceConfig value = it.next().getValue();
            if (value != null && value.visible && !value.deviceName.equalsIgnoreCase(str) && (deviceConfig == null || value.priority >= deviceConfig.priority)) {
                deviceConfig = value;
            }
        }
        if (deviceConfig != null) {
            return deviceConfig.deviceName;
        }
        return TraeConstants.DEVICE_SPEAKERPHONE;
    }

    public boolean getVisibleUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mVisibleUpdate;
    }

    public boolean init(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "init, configs[" + str + "]");
        }
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace("\n", "").replace("\r", "");
            if (!TextUtils.isEmpty(replace)) {
                if (!replace.contains(";")) {
                    replace = replace + ";";
                }
                String[] split = replace.split(";");
                if (split.length == 0) {
                    return false;
                }
                for (int i3 = 0; i3 < split.length; i3++) {
                    addConfig(split[i3], i3);
                }
                logDevices();
                return true;
            }
        }
        return false;
    }

    public boolean isDeviceChangeable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        String connectingDevice = getConnectingDevice();
        if (connectingDevice != null && !connectingDevice.equals(TraeConstants.DEVICE_NONE) && !connectingDevice.equals("")) {
            return false;
        }
        return true;
    }

    public void resetConnectingDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            AVCoreLog.i(TAG, "resetConnectingDevice");
            this.mConnectingDevice = TraeConstants.DEVICE_NONE;
        }
    }

    public void resetVisibleUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mVisibleUpdate = false;
        }
    }

    public void setBlueToothDevName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        this.mBlueToothDevName = str;
    }

    public void setConnectedDevice(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(str);
        if (deviceConfig != null && deviceConfig.visible) {
            if (!this.mConnectedDevice.equalsIgnoreCase(str)) {
                this.mPrevConnectedDevice = this.mConnectedDevice;
            }
            this.mConnectedDevice = str;
            this.mConnectingDevice = TraeConstants.DEVICE_NONE;
        }
    }

    public void setConnectingDevice(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(str);
        if (deviceConfig != null && deviceConfig.visible) {
            this.mConnectingDevice = str;
        }
    }

    public boolean setVisible(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        DeviceConfig deviceConfig = this.mDeviceConfigMap.get(str);
        if (deviceConfig == null) {
            return false;
        }
        deviceConfig.visible = z16;
        this.mVisibleUpdate = true;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "setVisible, deviceName[" + str + "] visible[" + z16 + "]");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class DeviceConfig {
        static IPatchRedirector $redirector_;
        public String deviceName;
        public int priority;
        public boolean visible;

        DeviceConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.deviceName = "";
            this.visible = false;
            this.priority = 0;
        }

        /* synthetic */ DeviceConfig(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }
}
