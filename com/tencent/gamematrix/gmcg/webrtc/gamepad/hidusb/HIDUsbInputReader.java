package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVPlaySession;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDGamepadPerf;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDUsbHandlerThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDUsbInputReader implements HIDUsbHandlerThread.OnUsbHandlerListener {
    private static final int HIDUSB_PACKET_BUFFER_MAX_SIZE = 512;
    private static final int HIDUSB_PACKET_BUFFER_SIZE = 32;
    private static final int MSG_ID_USB_EXCEPTION = 3;
    private static final int MSG_ID_USB_KEEPALIVE = 2;
    private static final int MSG_ID_USB_READ = 1;
    private static final String TAG = "usbdevice ";
    private static final int USB_KEEPALIVE_TIMEOUT_MILLIS = 500;
    private static final int USB_READ_EXCEPTION_RECONNECT_MILLIS = 3000;
    private static final int USB_READ_INTERVAL_MILLIS = 0;
    private static final int USB_READ_TIMEOUT_MILLIS = 1000;
    private static final int USB_RECONNECT_COUNT_MAX = 10;
    private boolean mIsKeepAlive;
    private byte[] mPacketBuffer;
    private int mPacketSize;
    private boolean mReadContinue;
    private int mReConnectedCount = 0;
    private int mPakcetNumber = 0;
    private HIDDeviceManage mHIDDeviceManage = null;
    private HIDDeviceUSB mMFGamepadDevice = null;
    private HIDUsbHandlerThread mInputThread = null;
    private boolean mHasReportConnectFailed = false;
    private boolean mHasReportException = false;
    private boolean mHasReportDeviceException = false;
    private boolean mHasReportDeviceManagerLost = false;

    private void connectIsNullProc() {
        CGLog.e("usbdevice connected failed!");
        HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.ConnectFailed;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null && !this.mHasReportConnectFailed) {
            this.mHasReportConnectFailed = true;
            tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.ConnectFailed.getErrorCode(), ITVPlaySession.GamepadReportStatus.ConnectFailed.getStatus());
        }
    }

    private boolean createHandlerThread() {
        CGLog.d("usbdevice create handler thread!");
        if (this.mInputThread == null) {
            this.mInputThread = new HIDUsbHandlerThread("hidusbloopThread", this);
        }
        this.mInputThread.startHandlerThread();
        CGLog.d("usbdevice handler thread start!");
        return true;
    }

    private void destroyHandlerThread() {
        HIDUsbHandlerThread hIDUsbHandlerThread = this.mInputThread;
        if (hIDUsbHandlerThread != null) {
            hIDUsbHandlerThread.quitSafely();
            this.mInputThread = null;
        }
        CGLog.i("usbdevice thread destroy!");
    }

    private void deviceExceptionProc() {
        HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.DeviceException;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null && !this.mHasReportDeviceException) {
            this.mHasReportDeviceException = true;
            tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.DeviceException.getErrorCode(), ITVPlaySession.GamepadReportStatus.DeviceException.getStatus());
        }
    }

    private void exceptionProc(Exception exc) {
        HIDGamepadPerf.nReconnected++;
        this.mReadContinue = false;
        this.mReConnectedCount++;
        CGLog.e("usbdevice exception in bulktransfer: " + exc);
        HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.Exception;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null && !this.mHasReportException) {
            this.mHasReportException = true;
            tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.Exception.getErrorCode(), ITVPlaySession.GamepadReportStatus.Exception.getStatus());
        }
        HIDUsbHandlerThread hIDUsbHandlerThread = this.mInputThread;
        if (hIDUsbHandlerThread != null && this.mReConnectedCount < 10) {
            hIDUsbHandlerThread.sendMessageDelayed(3, 3000L);
        }
    }

    private void handleKeepAlive() {
        HIDUsbHandlerThread hIDUsbHandlerThread;
        if (this.mIsKeepAlive) {
            this.mMFGamepadDevice.getConnection().sendKeepAlive();
            if (this.mReadContinue && (hIDUsbHandlerThread = this.mInputThread) != null) {
                hIDUsbHandlerThread.sendMessageDelayed(2, 500L);
            }
        }
    }

    private void handleReadData() {
        HIDUsbHandlerThread hIDUsbHandlerThread;
        HIDDeviceUSB hIDDeviceUSB = this.mMFGamepadDevice;
        if (hIDDeviceUSB != null && this.mReadContinue) {
            HIDGamepadPerf.nReadData++;
            HIDDeviceUSBConnection connection = hIDDeviceUSB.getConnection();
            if (connection == null) {
                connectIsNullProc();
                return;
            }
            if (this.mPacketBuffer == null && this.mPacketSize == 0) {
                resizePacketBuffer(connection);
            }
            try {
                int readData = connection.readData(this.mPacketBuffer, this.mPacketSize, 1000);
                if (readData == this.mPacketSize) {
                    packetDataProc(readData);
                } else if (readData < 0) {
                    HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.ReadNop;
                }
            } catch (Exception e16) {
                exceptionProc(e16);
            }
            if (this.mReadContinue && (hIDUsbHandlerThread = this.mInputThread) != null) {
                hIDUsbHandlerThread.sendMessageDelayed(1, 0);
                return;
            }
            return;
        }
        deviceExceptionProc();
    }

    private void packetDataProc(int i3) {
        this.mReConnectedCount = 0;
        HIDGamepadPerf.nRecvData++;
        HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.Reading;
        byte[] bArr = this.mPacketBuffer;
        HIDGamepadPerf.nDongleRSSI = bArr[27];
        HIDGamepadPerf.nDongleLinkPacket = bArr[28] & 255;
        HIDGamepadPerf.nRcRSSI = bArr[29];
        HIDGamepadPerf.nRcACK = bArr[30] & 255;
        packetNumberPerfProc();
        HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
        if (hIDDeviceManage != null) {
            hIDDeviceManage.processHidUsbData(this.mPacketBuffer, i3);
            return;
        }
        this.mReadContinue = false;
        HIDGamepadPerf.eGamepadStatus = HIDGamepadPerf.GamepadStatus.DeviceManagerLost;
        TVInputManager tVInputManager = TVInputManager.getInstance();
        if (tVInputManager != null && !this.mHasReportDeviceManagerLost) {
            this.mHasReportDeviceManagerLost = true;
            tVInputManager.reportGamepadStatus(ITVPlaySession.ReportName.CustomGamepad.getName(), ITVPlaySession.ErrorCode.DeviceManagerLost.getErrorCode(), ITVPlaySession.GamepadReportStatus.DeviceManagerLost.getStatus());
        }
    }

    private void packetNumberPerfProc() {
        int i3;
        byte[] bArr = this.mPacketBuffer;
        int i16 = (bArr[23] & 255) | (((bArr[24] & 255) << 8) & 65280);
        if (i16 != 0) {
            HIDGamepadPerf.nPacketNumber = i16;
            HIDGamepadPerf.nLogPackerNumber = i16;
        }
        int i17 = bArr[0] & 255;
        int i18 = bArr[4] & 255;
        if (i17 == 11 && i18 == 5) {
            HIDGamepadPerf.nScanLink = bArr[2] & 255;
            HIDGamepadPerf.nDoubleLink = bArr[1] & 255;
            if (i16 != 0) {
                int i19 = this.mPakcetNumber;
                if (i19 != 0 && (i3 = (i16 - i19) - 1) > 0) {
                    HIDGamepadPerf.nPacketLost += i3;
                    CGLog.d("usbdevice packetlost the key packet number is " + i16 + " lost = " + i3);
                }
                this.mPakcetNumber = i16;
            }
        }
    }

    private void resizePacketBuffer(HIDDeviceUSBConnection hIDDeviceUSBConnection) {
        this.mPacketSize = hIDDeviceUSBConnection.getMaxPacketSize();
        CGLog.d("usbdevice message packet size = " + this.mPacketSize);
        int i3 = this.mPacketSize;
        if (i3 > 512) {
            this.mPacketSize = 512;
        } else if (i3 <= 0) {
            this.mPacketSize = 32;
        }
        this.mPacketBuffer = new byte[this.mPacketSize];
    }

    private boolean restart(HIDDeviceManage hIDDeviceManage, HIDDeviceUSB hIDDeviceUSB) {
        CGLog.d("usbdevice restart!");
        stop();
        read(hIDDeviceManage, hIDDeviceUSB);
        return true;
    }

    public void asynQueryGamepadOnlineState(int i3) {
        HIDDeviceUSBConnection connection;
        HIDDeviceUSB hIDDeviceUSB = this.mMFGamepadDevice;
        if (hIDDeviceUSB == null || (connection = hIDDeviceUSB.getConnection()) == null) {
            return;
        }
        try {
            connection.sendDataToDevice(new byte[]{6, (byte) (i3 & 255), (byte) ((i3 >> 8) & 255), 0, 0, 3, 10, 7}, 1000);
        } catch (Exception e16) {
            exceptionProc(e16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDUsbHandlerThread.OnUsbHandlerListener
    public boolean onMsg(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && this.mHIDDeviceManage != null) {
                    CGLog.d("usbdevice exception reconnect!");
                    this.mHIDDeviceManage.reOpenUsbDevice();
                    return false;
                }
                return false;
            }
            handleKeepAlive();
            return false;
        }
        handleReadData();
        return false;
    }

    public boolean read(HIDDeviceManage hIDDeviceManage, HIDDeviceUSB hIDDeviceUSB) {
        CGLog.d("usbdevice read!");
        this.mHIDDeviceManage = hIDDeviceManage;
        this.mMFGamepadDevice = hIDDeviceUSB;
        createHandlerThread();
        startReadMessage();
        return true;
    }

    public boolean start(HIDDeviceManage hIDDeviceManage, HIDDeviceUSB hIDDeviceUSB) {
        CGLog.d("usbdevice start!");
        restart(hIDDeviceManage, hIDDeviceUSB);
        return true;
    }

    boolean startReadMessage() {
        this.mReadContinue = true;
        this.mIsKeepAlive = false;
        this.mPacketSize = 0;
        this.mPacketBuffer = null;
        this.mPakcetNumber = 0;
        CGLog.d("usbdevice start reading message!!");
        HIDGamepadPerf.nThreadPriority = Thread.currentThread().getPriority();
        this.mInputThread.sendMessageDelayed(1, 0L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        stopReadMessage();
        destroyHandlerThread();
    }

    void stopReadMessage() {
        this.mReadContinue = false;
        this.mIsKeepAlive = false;
        this.mPacketSize = 0;
        this.mPacketBuffer = null;
        this.mPakcetNumber = 0;
        HIDGamepadPerf.nReconnected = 0;
    }
}
