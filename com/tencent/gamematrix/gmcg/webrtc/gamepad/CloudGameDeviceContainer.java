package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.util.Log;
import android.util.SparseArray;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CloudGameDeviceContainer {
    private SparseArray<CloudGameDevice> mGlobalGameDeviceArray;

    public CloudGameDeviceContainer() {
        if (this.mGlobalGameDeviceArray == null) {
            this.mGlobalGameDeviceArray = new SparseArray<>();
        }
        reset();
    }

    public int addGlobalDeviceId(int i3, int i16) {
        int i17;
        int i18 = 2;
        if (i3 != 2 && i3 != 4 && i3 != 3) {
            return 0;
        }
        int deviceProductId = InputUtils.getDeviceProductId(i16);
        int deviceVendorId = InputUtils.getDeviceVendorId(i16);
        String deviceName = InputUtils.getDeviceName(i16);
        if (deviceProductId == 0 && deviceVendorId == 0 && GlobalConfig.getInstance().isPassProduct0Vendor0()) {
            return 0;
        }
        if ((deviceProductId == 1 && deviceVendorId == 1 && GlobalConfig.getInstance().isPassProduct1Vendor1()) || GlobalConfig.getInstance().getPassDeviceConfig(deviceVendorId, deviceProductId, deviceName) != null || this.mGlobalGameDeviceArray == null) {
            return 0;
        }
        CloudGameDevice cloudGameDevice = new CloudGameDevice();
        if (GlobalConfig.getInstance().isUniqueDeviceByVendorProduct()) {
            i17 = GlobalConfig.getInstance().getNextId();
            cloudGameDevice.m_type = 2;
            i18 = 1;
        } else {
            cloudGameDevice.m_type = 1;
            i17 = i16;
        }
        cloudGameDevice.m_productId = deviceProductId;
        cloudGameDevice.m_vendorId = deviceVendorId;
        cloudGameDevice.m_id = i17;
        cloudGameDevice.appendDeviceId(i16);
        int deviceIdSize = cloudGameDevice.getDeviceIdSize();
        this.mGlobalGameDeviceArray.append(i17, cloudGameDevice);
        CGLog.i("[inputdevice] add id step=" + i18 + " id=" + i17 + " arraySize=" + this.mGlobalGameDeviceArray.size() + " deviceId=" + i16 + " deviceType=" + i3 + " deviceIdSize=" + deviceIdSize);
        return i17;
    }

    public int findGlobalDeviceId(int i3) {
        int deviceProductId = InputUtils.getDeviceProductId(i3);
        int deviceVendorId = InputUtils.getDeviceVendorId(i3);
        for (int i16 = 0; i16 < this.mGlobalGameDeviceArray.size(); i16++) {
            CloudGameDevice valueAt = this.mGlobalGameDeviceArray.valueAt(i16);
            if (valueAt != null) {
                if ((deviceProductId == -1 && deviceVendorId == -1) || GlobalConfig.getInstance().isUniqueDeviceByVendorProduct()) {
                    if (valueAt.isContainDeviceId(i3)) {
                        valueAt.getDeviceIdSize();
                        return valueAt.m_id;
                    }
                } else {
                    int i17 = valueAt.m_id;
                    if (i17 == i3) {
                        valueAt.getDeviceIdSize();
                        return i17;
                    }
                }
            }
        }
        return 0;
    }

    public CloudGameDevice getGlobalGameDevice(int i3) {
        SparseArray<CloudGameDevice> sparseArray = this.mGlobalGameDeviceArray;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public boolean removeGlobalDeviceId(int i3, int i16) {
        CloudGameDevice cloudGameDevice;
        SparseArray<CloudGameDevice> sparseArray = this.mGlobalGameDeviceArray;
        if (sparseArray != null && (cloudGameDevice = sparseArray.get(i3)) != null) {
            int deviceIdSize = cloudGameDevice.getDeviceIdSize();
            cloudGameDevice.removeDeviceId(i16);
            int deviceIdSize2 = cloudGameDevice.getDeviceIdSize();
            if (cloudGameDevice.getDeviceIdSize() == 0) {
                this.mGlobalGameDeviceArray.remove(i3);
                Log.d("inputdevice", "remove id=" + i3 + " array size=" + this.mGlobalGameDeviceArray.size() + " !!!!");
                return true;
            }
            Log.d("inputdevice", "remove deviceId=" + i16 + " oldsize=" + deviceIdSize + " currentSize=" + deviceIdSize2);
        }
        return false;
    }

    public void reset() {
        SparseArray<CloudGameDevice> sparseArray = this.mGlobalGameDeviceArray;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }
}
