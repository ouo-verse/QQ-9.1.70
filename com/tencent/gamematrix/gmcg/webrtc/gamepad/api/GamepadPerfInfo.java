package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDGamepadPerf;

/* loaded from: classes6.dex */
public class GamepadPerfInfo {
    public static final int MSG_MAX_INDEX = 5;
    public int nThreadPriority;
    public int nUnknownTypeMessage;
    public int nReadData = 0;
    public int nRecvData = 0;
    public int nProcessMessage = 0;
    public int nProcessKeyMessage = 0;
    public int nProcessSensorMessage = 0;
    public int[] nSGameMessage = new int[5];
    public int[] nPubgMessage = new int[5];
    public int[] nInvalidMessage = new int[5];
    public int nHidKeyEvent = 0;
    public int nKeyEvent = 0;
    public int nPacketNumber = 0;
    public int nReconnected = 0;
    public HIDGamepadPerf.GamepadStatus eGamepadStatus = HIDGamepadPerf.GamepadStatus.None;
    public int nPacketLost = 0;
    public int nDongleRSSI = 0;
    public int nDongleLinkPacket = 0;
    public int nRcRSSI = 0;
    public int nRcACK = 0;
    public int nScanLink = 0;
    public int nDoubleLink = 0;
    public int nGenericJoystickEvent = 0;
}
