package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.GamepadPerfInfo;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVPlaySession;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDGamepadPerf;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDDeviceManage {
    private static final String ACTION_USB_PERMISSION = "com.tencent.gamereva.USB_PERMISSION";
    private static final String TAG = "usbdevice ";
    private static boolean mIsRegisterUsbBroadcast;
    private static volatile HIDDeviceManage sHIDDeviceManage;
    private Context mContext;
    private HIDUsbMessage mHIDUsbMessage;
    private HIDUsbInputReader mInputReader;
    private boolean mIsRequestPerm;
    private HIDDeviceUSB mMFGamepadDevice;
    private IHIDDeviceManageListener mTVInputManager;
    private UsbManager mUsbManager;
    private final BroadcastReceiver mUsbBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDeviceManage.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
                HIDDeviceManage.this.handleUsbDeviceAttached((UsbDevice) intent.getParcelableExtra("device"));
            } else if (action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
                HIDDeviceManage.this.handleUsbDeviceDetached((UsbDevice) intent.getParcelableExtra("device"));
            } else if (action.equals(HIDDeviceManage.ACTION_USB_PERMISSION)) {
                synchronized (this) {
                    HIDDeviceManage.this.handleUsbDevicePermission((UsbDevice) intent.getParcelableExtra("device"), intent.getBooleanExtra(QCircleDaTongConstant.ElementParamValue.PERMISSION, false));
                }
            }
        }
    };
    private boolean mSensorFlag = true;

    public HIDDeviceManage(Context context) {
        this.mContext = context;
        mIsRegisterUsbBroadcast = false;
        this.mIsRequestPerm = false;
        this.mInputReader = null;
        this.mMFGamepadDevice = null;
        this.mHIDUsbMessage = new HIDUsbMessage(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUsbDeviceAttached(UsbDevice usbDevice) {
        boolean z16;
        CGLog.d("usbdevice usb device attached!!");
        if (GlobalConfig.getInstance().isUseGamepadPrivateEvent() && usbDevice != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("usbdevice usb device attached!! manager is=");
            if (this.mTVInputManager != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" isopened=");
            sb5.append(GlobalConfig.IsOpenMFGamepad);
            sb5.append(" pid=");
            sb5.append(usbDevice.getProductId());
            sb5.append(" vid=");
            sb5.append(usbDevice.getVendorId());
            CGLog.d(sb5.toString());
            if (this.mTVInputManager != null && !GlobalConfig.IsOpenMFGamepad && InputUtils.isMFGamepadDevice(usbDevice.getVendorId(), usbDevice.getProductId())) {
                if (hasUsbPermission(usbDevice)) {
                    openUsbDevice(usbDevice);
                } else {
                    requestUsbPermission(usbDevice);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUsbDeviceDetached(UsbDevice usbDevice) {
        CGLog.d("usbdevice usb device detached!!");
        if (usbDevice != null && closeUsbDevice(usbDevice)) {
            GlobalConfig.IsOpenMFGamepad = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUsbDevicePermission(UsbDevice usbDevice, boolean z16) {
        if (z16) {
            CGLog.d("usbdevice permission granted for the device " + usbDevice.getDeviceName());
            if (InputUtils.isMFGamepadDevice(usbDevice.getVendorId(), usbDevice.getProductId())) {
                openUsbDevice(usbDevice);
            }
        } else {
            TVInputManager tVInputManager = TVInputManager.getInstance();
            if (tVInputManager != null) {
                tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.PermissionDenied.getErrorCode(), ITVPlaySession.GamepadReportStatus.PermissionDenied.getStatus());
            }
            CGLog.d("usbdevice permission denied for the device " + usbDevice.getDeviceName());
        }
        this.mIsRequestPerm = false;
        IHIDDeviceManageListener iHIDDeviceManageListener = this.mTVInputManager;
        if (iHIDDeviceManageListener != null) {
            iHIDDeviceManageListener.onUsbDevicePermissionResult(usbDevice, z16);
        }
    }

    private void openInputReader() {
        HIDUsbInputReader hIDUsbInputReader = this.mInputReader;
        if (hIDUsbInputReader != null) {
            hIDUsbInputReader.read(this, this.mMFGamepadDevice);
        }
    }

    private void startInputReader() {
        stopInputReader();
        if (this.mInputReader == null) {
            this.mInputReader = new HIDUsbInputReader();
        }
        this.mInputReader.start(this, this.mMFGamepadDevice);
    }

    private void stopInputReader() {
        HIDUsbInputReader hIDUsbInputReader = this.mInputReader;
        if (hIDUsbInputReader != null) {
            hIDUsbInputReader.stop();
            this.mInputReader = null;
        }
    }

    public void asynQueryGamepadOnlineState(int i3) {
        HIDUsbInputReader hIDUsbInputReader = this.mInputReader;
        if (hIDUsbInputReader != null) {
            hIDUsbInputReader.asynQueryGamepadOnlineState(i3);
        }
    }

    public void closeMFGamepad() {
        HashMap<String, UsbDevice> hashMap;
        UsbManager usbManager = this.mUsbManager;
        Iterator<UsbDevice> it = null;
        if (usbManager != null) {
            hashMap = usbManager.getDeviceList();
        } else {
            hashMap = null;
        }
        if (hashMap != null && hashMap.values() != null) {
            it = hashMap.values().iterator();
        }
        while (it != null && it.hasNext()) {
            UsbDevice next = it.next();
            if (next != null && InputUtils.isMFGamepadController(next)) {
                CGLog.i("usbdevice  close usb device id=" + next.getDeviceId() + " name=" + next.getDeviceName() + " res=" + closeUsbDevice(next));
            }
        }
    }

    public boolean closeUsbDevice(UsbDevice usbDevice) {
        boolean z16;
        HIDDeviceUSB hIDDeviceUSB;
        CGLog.d("usbdevice close usb device~");
        if (usbDevice != null && (hIDDeviceUSB = this.mMFGamepadDevice) != null && hIDDeviceUSB.getUsbDevice() != null && usbDevice.getProductId() == this.mMFGamepadDevice.getProductId() && usbDevice.getVendorId() == this.mMFGamepadDevice.getVendorId() && usbDevice.getDeviceId() == this.mMFGamepadDevice.getUsbDevice().getDeviceId()) {
            stopInputReader();
            this.mMFGamepadDevice.disconnect();
            this.mMFGamepadDevice = null;
            z16 = true;
        } else {
            z16 = false;
        }
        HIDGamepadPerf.getInstance().stop();
        return z16;
    }

    public UsbDevice getMFGamepadUsbDevice() {
        try {
            for (UsbDevice usbDevice : this.mUsbManager.getDeviceList().values()) {
                if (usbDevice != null) {
                    CGLog.d("usbdevice next deviceid=" + usbDevice.getDeviceId());
                    if (InputUtils.isMFGamepadController(usbDevice)) {
                        CGLog.d("usbdevice find target device deviceid=" + usbDevice.getDeviceId());
                        return usbDevice;
                    }
                }
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public UsbManager getUsbManager() {
        return this.mUsbManager;
    }

    public boolean hasUsbPermission(UsbDevice usbDevice) {
        UsbManager usbManager = this.mUsbManager;
        if (usbManager != null) {
            return usbManager.hasPermission(usbDevice);
        }
        return false;
    }

    public boolean isSensorEnabled() {
        return this.mSensorFlag;
    }

    public void notifyEvent(int i3, int i16, int i17, String str) {
        IHIDDeviceManageListener iHIDDeviceManageListener = this.mTVInputManager;
        if (iHIDDeviceManageListener != null) {
            iHIDDeviceManageListener.onHIDEventNotify(i3, i16, i17, str);
        }
    }

    public void onGamepadPerfUpdate(GamepadPerfInfo gamepadPerfInfo) {
        IHIDDeviceManageListener iHIDDeviceManageListener = this.mTVInputManager;
        if (iHIDDeviceManageListener != null) {
            iHIDDeviceManageListener.onGamepadPerfUpdate(gamepadPerfInfo);
        }
    }

    public boolean openMFGamepad() {
        UsbDevice mFGamepadUsbDevice = getMFGamepadUsbDevice();
        if (mFGamepadUsbDevice != null && openUsbDevice(mFGamepadUsbDevice)) {
            return true;
        }
        return false;
    }

    public boolean openUsbDevice(UsbDevice usbDevice) {
        CGLog.i("usbdevice open usb device!");
        HIDGamepadPerf.getInstance().setHIDDeviceManager(this);
        HIDGamepadPerf.getInstance().start();
        if (usbDevice != null) {
            HIDDeviceUSB hIDDeviceUSB = new HIDDeviceUSB(this, usbDevice);
            if (hIDDeviceUSB.connect()) {
                this.mMFGamepadDevice = hIDDeviceUSB;
                startInputReader();
                asynQueryGamepadOnlineState(-4096);
                return true;
            }
            HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.OpenConnectFailed;
            TVInputManager tVInputManager = TVInputManager.getInstance();
            if (tVInputManager != null) {
                tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.OpenConnectFailed.getErrorCode(), ITVPlaySession.GamepadReportStatus.OpenConnectFailed.getStatus());
            }
            CGLog.i("usbdevice open usb device failed!");
        }
        return false;
    }

    public void processHidUsbData(byte[] bArr, int i3) {
        if (this.mTVInputManager != null) {
            this.mHIDUsbMessage.handleHidUsbData(bArr, i3);
        }
    }

    public void reOpenUsbDevice() {
        HIDGamepadPerf.getInstance().setHIDDeviceManager(this);
        HIDGamepadPerf.getInstance().start();
        HIDDeviceUSB hIDDeviceUSB = this.mMFGamepadDevice;
        if (hIDDeviceUSB != null) {
            hIDDeviceUSB.disconnect();
            if (this.mMFGamepadDevice.connect()) {
                CGLog.i("usbdevice device reconnected successfully~");
                openInputReader();
                asynQueryGamepadOnlineState(-4096);
            } else {
                HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.ReConnectFailed;
                TVInputManager tVInputManager = TVInputManager.getInstance();
                if (tVInputManager != null) {
                    tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.ReConnectFailed.getErrorCode(), ITVPlaySession.GamepadReportStatus.ReConnectFailed.getStatus());
                }
                CGLog.i("usbdevice device reconnection failed!");
            }
        }
    }

    public void registerTVInputManagerListener(IHIDDeviceManageListener iHIDDeviceManageListener) {
        this.mTVInputManager = iHIDDeviceManageListener;
    }

    public boolean registerUsbBroadcast() {
        if (mIsRegisterUsbBroadcast) {
            return true;
        }
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        mIsRegisterUsbBroadcast = true;
        this.mUsbManager = (UsbManager) context.getSystemService("usb");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction(ACTION_USB_PERMISSION);
        this.mContext.registerReceiver(this.mUsbBroadcastReceiver, intentFilter);
        CGLog.i("usbdevice register broadcast");
        return true;
    }

    public boolean requestUsbPermission(UsbDevice usbDevice) {
        if (this.mIsRequestPerm) {
            CGLog.i("usbdevice  requesting permission !!");
            return true;
        }
        if (this.mUsbManager == null) {
            return false;
        }
        CGLog.d("usbdevice start requesting permission");
        this.mIsRequestPerm = true;
        this.mUsbManager.requestPermission(usbDevice, PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_USB_PERMISSION), 0));
        return true;
    }

    public void switchSensor(boolean z16) {
        this.mSensorFlag = z16;
    }

    public void unregisterTVInputManagerListener() {
        this.mTVInputManager = null;
    }

    public void unregisterUsbBroadcast() {
        BroadcastReceiver broadcastReceiver;
        if (mIsRegisterUsbBroadcast) {
            Context context = this.mContext;
            if (context != null && (broadcastReceiver = this.mUsbBroadcastReceiver) != null) {
                context.unregisterReceiver(broadcastReceiver);
                mIsRegisterUsbBroadcast = false;
            }
            CGLog.i("usbdevice unregister broadcast");
        }
    }
}
