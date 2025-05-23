package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.HandlerTimer;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.GamepadPerfInfo;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;

/* loaded from: classes6.dex */
public class HIDGamepadPerf {
    private static final int GamepadPefTimerId = 1;
    public static final int MSG_MAX_INDEX = 5;
    public static String TAG = "GamepadPerf";
    public static GamepadStatus eGamepadStatus;
    public static int nDongleLinkPacket;
    public static int nDongleRSSI;
    public static int nDoubleLink;
    public static int nGenericJoystickEvent;
    public static int nHidKeyEvent;
    public static int[] nInvalidMessage;
    public static int nKeyEvent;
    public static int nLogPackerNumber;
    public static int nPacketLost;
    public static int nPacketNumber;
    public static int nProcessKeyMessage;
    public static int nProcessMessage;
    public static int nProcessSensorMessage;
    public static int[] nPubgMessage;
    public static int nRcACK;
    public static int nRcRSSI;
    public static int nReadData;
    public static int nReconnected;
    public static int nRecvData;
    public static int nScanLink;
    public static int[] nSgameMessage;
    public static int nThreadPriority;
    public static int nUnknownTypeMessage;
    private static volatile HIDGamepadPerf sHIDGamepadPerf;
    private GamepadPerfInfo mGamepadPerfInfo;
    private HIDDeviceManage mHIDDeviceManage;
    private HandlerTimer mHandlerTimer;

    /* loaded from: classes6.dex */
    public enum GamepadStatus {
        None("None"),
        Opened("Opened"),
        OpenFailed("OpenFailed"),
        OpenConnectFailed("OpenConnectFailed"),
        ReConnectFailed("ReConnectFailed"),
        Connected("Connected"),
        ConnectFailed("ConnectFailed"),
        Reading("Reading"),
        Closed("Closed"),
        Exception("Exception"),
        ReadNop("ReadNop"),
        ReadWait("ReadWait"),
        DeviceException("DeviceException"),
        DeviceManagerLost("DeviceManagerLost");

        String name;

        GamepadStatus(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    HIDGamepadPerf() {
        nSgameMessage = new int[5];
        nPubgMessage = new int[5];
        nInvalidMessage = new int[5];
        this.mGamepadPerfInfo = new GamepadPerfInfo();
        reset();
        eGamepadStatus = GamepadStatus.None;
        nPacketNumber = 0;
        nPacketLost = 0;
        nDongleRSSI = 0;
        nDongleLinkPacket = 0;
        nRcRSSI = 0;
        nRcACK = 0;
        nScanLink = 0;
        nDoubleLink = 0;
        this.mHandlerTimer = new HandlerTimer(new HandlerTimer.OnTimerListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.a
            @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.HandlerTimer.OnTimerListener
            public final boolean onTime(int i3) {
                boolean lambda$new$0;
                lambda$new$0 = HIDGamepadPerf.this.lambda$new$0(i3);
                return lambda$new$0;
            }
        });
    }

    public static HIDGamepadPerf getInstance() {
        if (sHIDGamepadPerf == null) {
            synchronized (HIDGamepadPerf.class) {
                if (sHIDGamepadPerf == null) {
                    sHIDGamepadPerf = new HIDGamepadPerf();
                }
            }
        }
        return sHIDGamepadPerf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(int i3) {
        if (i3 == 1) {
            CGLog.i("gamepad perf monitor");
            perf();
        }
        reset();
        start();
        return false;
    }

    void perf() {
        GamepadPerfInfo gamepadPerfInfo = this.mGamepadPerfInfo;
        if (gamepadPerfInfo != null) {
            gamepadPerfInfo.nReadData = nReadData;
            gamepadPerfInfo.nRecvData = nRecvData;
            gamepadPerfInfo.nProcessMessage = nProcessMessage;
            gamepadPerfInfo.nProcessKeyMessage = nProcessKeyMessage;
            gamepadPerfInfo.nProcessSensorMessage = nProcessSensorMessage;
            gamepadPerfInfo.nUnknownTypeMessage = nUnknownTypeMessage;
            for (int i3 = 0; i3 < 5; i3++) {
                GamepadPerfInfo gamepadPerfInfo2 = this.mGamepadPerfInfo;
                gamepadPerfInfo2.nSGameMessage[i3] = nSgameMessage[i3];
                gamepadPerfInfo2.nPubgMessage[i3] = nPubgMessage[i3];
                gamepadPerfInfo2.nInvalidMessage[i3] = nInvalidMessage[i3];
            }
            GamepadPerfInfo gamepadPerfInfo3 = this.mGamepadPerfInfo;
            gamepadPerfInfo3.nHidKeyEvent = nHidKeyEvent;
            gamepadPerfInfo3.nKeyEvent = nKeyEvent;
            gamepadPerfInfo3.nPacketNumber = nPacketNumber;
            gamepadPerfInfo3.nReconnected = nReconnected;
            gamepadPerfInfo3.eGamepadStatus = eGamepadStatus;
            gamepadPerfInfo3.nThreadPriority = nThreadPriority;
            gamepadPerfInfo3.nPacketLost = nPacketLost;
            gamepadPerfInfo3.nDongleRSSI = nDongleRSSI;
            gamepadPerfInfo3.nDongleLinkPacket = nDongleLinkPacket;
            gamepadPerfInfo3.nRcRSSI = nRcRSSI;
            gamepadPerfInfo3.nRcACK = nRcACK;
            gamepadPerfInfo3.nScanLink = nScanLink;
            gamepadPerfInfo3.nDoubleLink = nDoubleLink;
            gamepadPerfInfo3.nGenericJoystickEvent = nGenericJoystickEvent;
            HIDDeviceManage hIDDeviceManage = this.mHIDDeviceManage;
            if (hIDDeviceManage != null) {
                hIDDeviceManage.onGamepadPerfUpdate(gamepadPerfInfo3);
            }
        }
    }

    void reset() {
        nReadData = 0;
        nRecvData = 0;
        nProcessMessage = 0;
        nProcessKeyMessage = 0;
        nProcessSensorMessage = 0;
        nUnknownTypeMessage = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            nSgameMessage[i3] = 0;
            nPubgMessage[i3] = 0;
            nInvalidMessage[i3] = 0;
        }
        nHidKeyEvent = 0;
        nKeyEvent = 0;
        nThreadPriority = 0;
        nDongleRSSI = 0;
        nDongleLinkPacket = 0;
        nRcRSSI = 0;
        nRcACK = 0;
        nScanLink = 0;
        nDoubleLink = 0;
        nGenericJoystickEvent = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHIDDeviceManager(HIDDeviceManage hIDDeviceManage) {
        this.mHIDDeviceManage = hIDDeviceManage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        HandlerTimer handlerTimer;
        if (GlobalConfig.getInstance().isGamepadPerfMonitorEnable() && (handlerTimer = this.mHandlerTimer) != null) {
            handlerTimer.startTimer(1, 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (this.mHandlerTimer != null && GlobalConfig.getInstance().isGamepadPerfMonitorEnable()) {
            this.mHandlerTimer.stopTimer(1);
        }
        eGamepadStatus = GamepadStatus.None;
        nPacketNumber = 0;
        nPacketLost = 0;
    }
}
