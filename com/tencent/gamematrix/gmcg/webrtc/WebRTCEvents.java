package com.tencent.gamematrix.gmcg.webrtc;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface WebRTCEvents {
    public static final int MSG_VIRTUAL_GAMEPAD_CONNECTED = 2;
    public static final int MSG_VIRTUAL_GAMEPAD_DISCONNECTED = 4;
    public static final int MSG_VIRTUAL_GAMEPAD_NONE = 0;
    public static final int MSG_VIRTUAL_GAMEPAD_PARAMS = 1;
    public static final int MSG_VIRTUAL_GAMEPAD_QUALITY = 3;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum ConnectStateDisplay {
        STATE_BEGIN,
        STATE_SESSIONID_RECIEVED,
        STATE_SEND_USERCONFIG,
        STATE_CLIENTCONFIG_RECIEVED,
        STATE_SEND_OFFER,
        STATE_SEND_ICE,
        STATE_ANSWER_RECIEVED,
        STATE_ICE_RECIEVED;

        private static ConnectStateDisplay[] vals = values();

        public boolean hasNext() {
            if (ordinal() < vals.length - 1) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            if (ordinal() <= 0) {
                return false;
            }
            return true;
        }

        public ConnectStateDisplay next() {
            return vals[(ordinal() + 1) % vals.length];
        }

        public ConnectStateDisplay previous() {
            return vals[(ordinal() - 1) % vals.length];
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum ConnectionState {
        STATE_BEGIN,
        STATE_OFFER_ANSWERED,
        STATE_ICE_RECEIVED,
        STATE_ICE_COMPLETED,
        STATE_WEBRTC_CONNECTED,
        STATE_FIRST_FRAME_RENDERED,
        STATE_WEBRTC_TIMEOUT,
        STATE_WEBRTC_STUTTER
    }

    void OnEventDataReport(int i3, int i16, Map<String, String> map);

    void onClientConnectionMsgData(int i3, int i16, String str, String str2, int i17);

    void onCumulativeDelayedInformationReport(ByteBuffer byteBuffer, int i3);

    void onDecodeErrCodeReport(boolean z16, int i3, int i16, String str);

    void onEventBeforeConnected(String str, String str2, boolean z16);

    void onEventChannelAck(String str);

    void onEventChannelData(String str);

    void onEventClipBoardDataRecved(String str);

    void onEventCodecTypeReported(VideoCodecType videoCodecType);

    void onEventConnectFailed(ConnectionState connectionState, String str);

    void onEventConnectFailed(ConnectionState connectionState, String str, String str2);

    void onEventConnectStatus(ConnectStateDisplay connectStateDisplay);

    void onEventConnected(String str, String str2, boolean z16);

    void onEventConnecting(String str, String str2, boolean z16);

    void onEventDataChannelConnected();

    void onEventDataChannelConnected(String str);

    void onEventDataChannelDisconnected(String str);

    void onEventDisconnect();

    void onEventFinishInput();

    void onEventFirstFrameRendered();

    void onEventGalleryOpen();

    void onEventGpsSwitched(boolean z16);

    void onEventNetworkCarrier(String str, String str2);

    void onEventNetworkCarrierMismatch(String[] strArr, String str, @Nullable String str2);

    void onEventOfferCreated(String str);

    void onEventPriviledgeNotification(String str);

    void onEventReportPerfValueDelivered(ReportPerfValue reportPerfValue);

    void onEventSamplePerfValueDelivered(PerfValue perfValue);

    void onEventSessionConnClose(int i3);

    void onEventSessionError(int i3);

    void onEventSessionIdReceived(String str);

    void onEventSessionInfo(String str);

    void onEventSocketIoError(Object obj);

    void onEventStart();

    void onEventStartInput();

    void onEventStutter(ConnectionState connectionState);

    void onEventVoiceSwitched(boolean z16);

    void onGateReconnect();

    void onVirtualGamepadMsgData(int i3, int i16, int i17, int i18);

    void onVirtualGamepadMsgData(int i3, int i16, String str);

    void onWebrtcStartUpProcess(String str, boolean z16);
}
