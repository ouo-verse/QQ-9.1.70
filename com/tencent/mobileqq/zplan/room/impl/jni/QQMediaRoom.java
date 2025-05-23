package com.tencent.mobileqq.zplan.room.impl.jni;

import com.tencent.qphone.base.util.QLog;
import iv4.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lv4.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QQMediaRoom {
    private static final String TAG = "QQMediaRoom_java";
    private volatile boolean isUEListening = false;
    private final gk3.c zPlanRoomCommonListener = new e();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements com.tencent.mobileqq.zootopia.api.e<lv4.b> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(lv4.b bVar) {
            QQMediaRoom.this.doWhenJoinRoom();
            QQMediaRoom.this.onRoomCreateCallback(0, "", bVar.f415637a.f408821a.f408820a.f408810a);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            QQMediaRoom.this.onRoomCreateCallback(i3, str, "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements com.tencent.mobileqq.zootopia.api.e<h> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(h hVar) {
            QQMediaRoom.this.doWhenJoinRoom();
            QQMediaRoom.this.onRoomJoinCallback(0, "");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            QQMediaRoom.this.onRoomJoinCallback(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements com.tencent.mobileqq.zootopia.api.e<Boolean> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                QQMediaRoom.this.onRoleSwitchedCallback(0, "switchRole success");
            } else {
                QQMediaRoom.this.onRoleSwitchedCallback(-1, "switchRole failed");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            QQMediaRoom.this.onRoleSwitchedCallback(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class d implements com.tencent.mobileqq.zootopia.api.e<Boolean> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                QQMediaRoom.this.onAudioStartedCallback(0, "startLocalAudio success");
            } else {
                QQMediaRoom.this.onAudioStartedCallback(-1, "startLocalAudio failed");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            QQMediaRoom.this.onAudioStartedCallback(i3, str);
        }
    }

    public QQMediaRoom() {
        QLog.i(TAG, 1, "QQMediaRoom :: constructor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildEventInfo(Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("EventType", 1);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("UserIds", jSONArray);
            jSONObject.put("EventContent", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWhenJoinRoom() {
        vb3.a aVar = vb3.a.f441346a;
        String N0 = ((gk3.a) aVar.a(gk3.a.class)).N0();
        QLog.i(TAG, 1, "doWhenJoinRoom - " + N0);
        ((gk3.a) aVar.a(gk3.a.class)).C(N0, this.zPlanRoomCommonListener);
    }

    public void createRoom(String str, String str2, int i3) {
        QLog.i(TAG, 1, "QQMediaRoom :: createRoom , userId == " + str + ", componentId == " + str2);
        ((gk3.a) vb3.a.f441346a.a(gk3.a.class)).P0(str, str2, i3, new a());
    }

    public void joinRoom(String str, String str2) {
        QLog.i(TAG, 1, "QQMediaRoom :: joinRoom , userId == " + str + ", roomId == " + str2);
        ((gk3.a) vb3.a.f441346a.a(gk3.a.class)).e(str2, str, null, new b());
    }

    public native void onAudioStartedCallback(int i3, String str);

    public native void onRoleSwitchedCallback(int i3, String str);

    public native void onRoomCreateCallback(int i3, String str, String str2);

    public native void onRoomEventCallback(String str);

    public native void onRoomJoinCallback(int i3, String str);

    public void registerRoomEventDelegate() {
        QLog.i(TAG, 1, "QQMediaRoom :: registerRoomEventDelegate ");
        this.isUEListening = true;
    }

    public void setAllRemoteAudioStreamMuteStatus(boolean z16) {
        QLog.i(TAG, 1, "QQMediaRoom :: setAllRemoteAudioStreamMuteStatus , mute == " + z16);
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).g(((gk3.a) aVar.a(gk3.a.class)).N0()).e(z16);
    }

    public void setAudioCaptureVolume(int i3) {
        QLog.i(TAG, 1, "QQMediaRoom :: setAudioCaptureVolume , volume == " + i3);
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).g(((gk3.a) aVar.a(gk3.a.class)).N0()).a(i3);
    }

    public void setAudioPlayoutVolume(int i3) {
        QLog.i(TAG, 1, "QQMediaRoom :: setAudioPlayoutVolume , volume == " + i3);
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).g(((gk3.a) aVar.a(gk3.a.class)).N0()).d(i3);
    }

    public void startLocalAudio() {
        QLog.i(TAG, 1, "QQMediaRoom :: startLocalAudio ");
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).g(((gk3.a) aVar.a(gk3.a.class)).N0()).b(true, new d());
    }

    public void switchRole(int i3) {
        QLog.i(TAG, 1, "QQMediaRoom :: switchRole , roleType == " + i3);
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).g(((gk3.a) aVar.a(gk3.a.class)).N0()).c(i3, new c());
    }

    public void destroyRoom() {
        QLog.i(TAG, 1, "QQMediaRoom :: destroyRoom ");
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).O(((gk3.a) aVar.a(gk3.a.class)).N0(), null);
    }

    public void leaveRoom() {
        QLog.i(TAG, 1, "QQMediaRoom :: leaveRoom ");
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).K0(((gk3.a) aVar.a(gk3.a.class)).N0(), null);
    }

    public void stopLocalAudio() {
        QLog.i(TAG, 1, "QQMediaRoom :: stopLocalAudio ");
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.a) aVar.a(gk3.a.class)).g(((gk3.a) aVar.a(gk3.a.class)).N0()).b(false, null);
    }

    public void unRegisterRoomEventDelegate() {
        QLog.i(TAG, 1, "QQMediaRoom :: unRegisterRoomEventDelegate ");
        this.isUEListening = false;
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class e implements gk3.c {
        e() {
        }

        @Override // gk3.c
        public void b(Map<String, Integer> map) {
            String buildEventInfo = QQMediaRoom.this.buildEventInfo(map);
            QLog.i(QQMediaRoom.TAG, 1, "QQMediaRoom :: ZPlanRoomCommonListener , eventInfo == " + buildEventInfo + ", isUEListening= " + QQMediaRoom.this.isUEListening);
            if (QQMediaRoom.this.isUEListening) {
                QQMediaRoom.this.onRoomEventCallback(buildEventInfo);
            }
        }

        @Override // gk3.c
        public void c(String str) {
            QLog.i(QQMediaRoom.TAG, 1, "QQMediaRoom :: ZPlanRoomCommonListener , onExitRoom " + str + ", isUEListening= " + QQMediaRoom.this.isUEListening);
        }

        @Override // gk3.c
        public void a(List<k> list) {
        }
    }
}
