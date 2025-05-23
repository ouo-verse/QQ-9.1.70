package com.tencent.gamematrix.gmcg.webrtc;

import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface ConnectionClient {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface SignalEvent {
        void onAnswerReceived(JSONObject jSONObject);

        void onChannelAck(String str);

        void onChannelData(String str);

        void onClientConfigReceived(JSONObject jSONObject);

        void onClientCountReceived(int i3);

        void onConnected(boolean z16);

        void onGateReconnect();

        void onIceCandidateReceived(JSONObject jSONObject);

        void onNetworkCarrier(Object... objArr);

        void onSessionConnClose(int i3);

        void onSessionError(int i3);

        void onSessionIdReceived(String str);

        void onSessionInfo(String str);
    }

    void close();

    void connect(String str);

    void sendChannelAck(String str);

    void sendChannelData(String str);

    void sendIceCandidate(String str, String str2, int i3);

    void sendKickMyself();

    void sendKickUser(String[] strArr);

    void sendOffer(String str, String str2);

    void sendPerfData(ArrayList<String> arrayList, int i3, int i16, int i17, int i18);

    void sendSdkInfo(JSONObject jSONObject);

    void sendStartBoard(String str, String str2, String str3, String str4);

    void sendUserConfig(UserConfig userConfig);
}
