package com.tencent.mobileqq.zplan.room.impl.meeting;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.avbiz.IModule;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.zplan.room.impl.jni.QQMeetingTrtc;
import com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingHeadsetStatusManager;
import com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingTrtcImpl;
import com.tencent.mobileqq.zplan.room.impl.trtc.ZPlanTRTCRoomParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import gk3.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kk3.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t74.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001S\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J8\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\u0010\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000100H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0016R\u0014\u00104\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00107R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00105R$\u0010?\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010\u00040\u00040=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR0\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130Oj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013`P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\"\u0010V\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl;", "Lkk3/b;", "", "resetMeetingStatus", "", "mute", "setAllRemoteAudioStreamMuteStatusReally", "registerHeadsetStatusListener", "unregisterHeadsetStatusListener", "notifyAudioRouteChange", "", AdMetricTag.EVENT_NAME, "", "errCode", "eventMsg", "sendEvent", "eventCode", "buildEventInfo", "", "", "memberMicLevelMap", "sdkAppId", "userId", "userSign", "roomId", "isAnchor", "focusResume", "enterTrtcRoom", "leaveRoom", "enable", "enableAudioEarMonitoring", "anchor", "switchRole", "useSpeakerphone", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "startScreenCapture", "stopScreenCapture", "startLocalAudio", "stopLocalAudio", "setLocalAudioMute", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioCaptureVolume", "setAudioPlayoutVolume", "key", "setAllRemoteAudioStreamMuteStatusByKey", "setRemoteAudioStreamMuteStatus", "getCurrentAudioDevice", "isKeepAlive", "Landroidx/lifecycle/LiveData;", "getIsInMeetingLiveData", "isInMeeting", "isAppForeground", "TAG", "Ljava/lang/String;", "isUEListening", "Z", "selfMicSwitch", "", "muteStatusKeyMap", "Ljava/util/Map;", "selfUserId", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "isMeeting", "Landroidx/lifecycle/MutableLiveData;", "Lkk3/c;", "meetingTrtcListener", "Lkk3/c;", "getMeetingTrtcListener", "()Lkk3/c;", "setMeetingTrtcListener", "(Lkk3/c;)V", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager;", "headSetManager", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager;", "getHeadSetManager", "()Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager;", "setHeadSetManager", "(Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lastAudioMemberMicLevelMap", "Ljava/util/HashMap;", "com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$a", "audioFocusListener", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$a;", "lastTimeUserVoiceVolume", "J", "getLastTimeUserVoiceVolume", "()J", "setLastTimeUserVoiceVolume", "(J)V", "Lcom/tencent/trtc/TRTCCloudListener;", "trtcListener", "Lcom/tencent/trtc/TRTCCloudListener;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQMeetingTrtcImpl implements kk3.b {
    private QQMeetingHeadsetStatusManager headSetManager;
    private volatile boolean isUEListening;
    private long lastTimeUserVoiceVolume;
    private volatile boolean selfMicSwitch;
    private String selfUserId;
    private final String TAG = "QQMeetingTrtcImpl_java";
    private final Map<String, Boolean> muteStatusKeyMap = new LinkedHashMap();
    private MutableLiveData<Boolean> isMeeting = new MutableLiveData<>(Boolean.FALSE);
    private final HashMap<String, Integer> lastAudioMemberMicLevelMap = new HashMap<>();
    private kk3.c meetingTrtcListener = new k();
    private final a audioFocusListener = new a();
    private final TRTCCloudListener trtcListener = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$a", "Lcom/tencent/avbiz/IModule$FocusChangeListener;", "", "onFocusLoss", "onFocusGain", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements IModule.FocusChangeListener {
        a() {
        }

        @Override // com.tencent.avbiz.IModule.FocusChangeListener
        public void onFocusGain() {
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "audio onFocusGain");
            QQMeetingTrtcImpl.this.setAllRemoteAudioStreamMuteStatusByKey(QQMeetingTrtc.MEETING_MUTE_KEY_MEDIA_FOCUS, false);
            QQMeetingTrtcImpl.this.sendEvent("onAudioFocusChanged", 2L, "");
        }

        @Override // com.tencent.avbiz.IModule.FocusChangeListener
        public void onFocusLoss() {
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "audio onFocusLoss");
            QQMeetingTrtcImpl.this.setAllRemoteAudioStreamMuteStatusByKey(QQMeetingTrtc.MEETING_MUTE_KEY_MEDIA_FOCUS, true);
            QQMeetingTrtcImpl.this.sendEvent("onAudioFocusChanged", 1L, "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$b", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f335235b;

        b(String str) {
            this.f335235b = str;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            kk3.c meetingTrtcListener;
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "QQMeetingTrtc :: enterTrtcRoom , isSuccess == " + isSuccess + ", errorMessage == " + errorMessage);
            if (isSuccess) {
                QQMeetingTrtcImpl.this.selfUserId = this.f335235b;
                ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).z(QQMeetingTrtcImpl.this.audioFocusListener);
                if (!(errorMessage != null && errorMessage.getErrorCode() == 99999) || (meetingTrtcListener = QQMeetingTrtcImpl.this.getMeetingTrtcListener()) == null) {
                    return;
                }
                meetingTrtcListener.onRoomJoinCallbackWrapper(0, "already in room ");
                return;
            }
            kk3.c meetingTrtcListener2 = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
            if (meetingTrtcListener2 != null) {
                meetingTrtcListener2.onRoomJoinCallbackWrapper(-1, "not complete");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$c", "Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingHeadsetStatusManager$a;", "", "isPlugged", "", "onHeadsetPlug", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements QQMeetingHeadsetStatusManager.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingHeadsetStatusManager.a
        public void onHeadsetPlug(boolean isPlugged) {
            QQMeetingTrtcImpl.this.notifyAudioRouteChange();
        }
    }

    private final String buildEventInfo(String eventName, long eventCode, String eventMsg) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("EventType", 2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("EventName", eventName);
            jSONObject2.put("EventCode", eventCode);
            if (eventMsg == null) {
                eventMsg = "";
            }
            jSONObject2.put("EventMsg", eventMsg);
            jSONObject.put("EventContent", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "eventInfoJson.toString()");
            return jSONObject3;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAudioRouteChange() {
        sendEvent("onAudioRouteChanged", getCurrentAudioDevice(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerHeadsetStatusListener() {
        QQMeetingHeadsetStatusManager qQMeetingHeadsetStatusManager;
        if (this.headSetManager == null) {
            this.headSetManager = new QQMeetingHeadsetStatusManager();
        }
        QQMeetingHeadsetStatusManager qQMeetingHeadsetStatusManager2 = this.headSetManager;
        boolean z16 = false;
        if (qQMeetingHeadsetStatusManager2 != null && !qQMeetingHeadsetStatusManager2.getIsRegister()) {
            z16 = true;
        }
        if (!z16 || (qQMeetingHeadsetStatusManager = this.headSetManager) == null) {
            return;
        }
        qQMeetingHeadsetStatusManager.k(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetMeetingStatus() {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: resetMeetingStatus");
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.b) aVar.a(gk3.b.class)).m0(this.trtcListener);
        ((gk3.b) aVar.a(gk3.b.class)).f0(this.audioFocusListener);
        unregisterHeadsetStatusListener();
        this.selfMicSwitch = false;
        this.isUEListening = false;
        this.muteStatusKeyMap.clear();
        this.isMeeting.postValue(Boolean.FALSE);
        this.selfUserId = null;
        this.lastAudioMemberMicLevelMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(String eventName, long errCode, String eventMsg) {
        String buildEventInfo = buildEventInfo(eventName, errCode, eventMsg);
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: " + eventName + " , eventInfo == " + buildEventInfo + ", isUEListening= " + this.isUEListening);
        kk3.c cVar = this.meetingTrtcListener;
        if (cVar != null) {
            cVar.onRoomEventCallbackWrapper(buildEventInfo);
        }
    }

    private final void setAllRemoteAudioStreamMuteStatusReally(boolean mute) {
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.b) aVar.a(gk3.b.class)).muteAllRemoteAudio(mute);
        if (mute) {
            ((gk3.b) aVar.a(gk3.b.class)).v0(true, null);
            String str = this.selfUserId;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.selfUserId;
            sendEvent("onUserAudioAvailable", 0L, str2 != null ? str2 : "");
            return;
        }
        if (this.selfMicSwitch) {
            ((gk3.b) aVar.a(gk3.b.class)).v0(false, null);
            String str3 = this.selfUserId;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            String str4 = this.selfUserId;
            sendEvent("onUserAudioAvailable", 1L, str4 != null ? str4 : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScreenCapture$lambda$0(QQMeetingTrtcImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).k(new e());
    }

    private final void unregisterHeadsetStatusListener() {
        QQMeetingHeadsetStatusManager qQMeetingHeadsetStatusManager = this.headSetManager;
        if (qQMeetingHeadsetStatusManager != null) {
            qQMeetingHeadsetStatusManager.m();
        }
    }

    @Override // kk3.b
    public void enableAudioEarMonitoring(boolean enable) {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: enableAudioEarMonitoring , enable == " + enable);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).enableAudioEarMonitoring(enable);
    }

    @Override // kk3.b
    public void enterTrtcRoom(int sdkAppId, String userId, String userSign, String roomId, boolean isAnchor, boolean focusResume) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userSign, "userSign");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: enterTrtcRoom , userId == " + userId + ", roomId == " + roomId);
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.b) aVar.a(gk3.b.class)).s(this.trtcListener);
        ((gk3.b) aVar.a(gk3.b.class)).y(sdkAppId, userSign, new ZPlanTRTCRoomParam(userId, roomId, true, 0), new b(userId));
    }

    @Override // kk3.b
    public int getCurrentAudioDevice() {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: getCurrentAudioDeviceMethod ");
        boolean f16 = com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext());
        boolean c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext());
        if (f16 || c16) {
            return 2;
        }
        return ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).getCurOutputDevice();
    }

    public final QQMeetingHeadsetStatusManager getHeadSetManager() {
        return this.headSetManager;
    }

    @Override // kk3.b
    public LiveData<Boolean> getIsInMeetingLiveData() {
        return this.isMeeting;
    }

    public final long getLastTimeUserVoiceVolume() {
        return this.lastTimeUserVoiceVolume;
    }

    public final kk3.c getMeetingTrtcListener() {
        return this.meetingTrtcListener;
    }

    @Override // kk3.b
    public boolean isAppForeground() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            return guardManager.isApplicationForeground();
        }
        return false;
    }

    @Override // kk3.b
    public boolean isInMeeting() {
        Boolean value = this.isMeeting.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    @Override // kk3.b
    public boolean isKeepAlive() {
        return false;
    }

    @Override // kk3.b
    public void leaveRoom() {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: leaveRoom ");
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).exitRoom();
    }

    @Override // kk3.b
    public void setAllRemoteAudioStreamMuteStatusByKey(String key, boolean mute) {
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: setAllRemoteAudioStreamMuteStatus ,key == " + key + "  mute == " + mute);
        this.muteStatusKeyMap.put(key, Boolean.valueOf(mute));
        Iterator<Map.Entry<String, Boolean>> it = this.muteStatusKeyMap.entrySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                z16 = true;
            }
        }
        setAllRemoteAudioStreamMuteStatusReally(z16);
    }

    @Override // kk3.b
    public void setAudioCaptureVolume(int volume) {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: setAudioCaptureVolume , volume == " + volume);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).z0(volume, null);
    }

    @Override // kk3.b
    public void setAudioPlayoutVolume(int volume) {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: setAudioPlayoutVolume , volume == " + volume);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).setAudioPlayoutVolume(volume);
    }

    @Override // kk3.b
    public void setAudioRoute(boolean useSpeakerphone) {
        boolean f16 = com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext());
        boolean c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext());
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: setAudioRoute wiredHeadsetConnected:" + f16 + " btHeadsetConnect:" + c16);
        if (f16 || c16) {
            return;
        }
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).setAudioRoute(useSpeakerphone);
        notifyAudioRouteChange();
    }

    public final void setHeadSetManager(QQMeetingHeadsetStatusManager qQMeetingHeadsetStatusManager) {
        this.headSetManager = qQMeetingHeadsetStatusManager;
    }

    public final void setLastTimeUserVoiceVolume(long j3) {
        this.lastTimeUserVoiceVolume = j3;
    }

    @Override // kk3.b
    public void setLocalAudioMute(boolean mute) {
        boolean z16 = true;
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: setLocalAudioMute mute==" + mute);
        b.C10383b.b((gk3.b) vb3.a.f441346a.a(gk3.b.class), mute, null, 2, null);
        this.selfMicSwitch = mute ^ true;
        String str = this.selfUserId;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        long j3 = mute ? 0L : 1L;
        String str2 = this.selfUserId;
        if (str2 == null) {
            str2 = "";
        }
        sendEvent("onUserAudioAvailable", j3, str2);
    }

    public final void setMeetingTrtcListener(kk3.c cVar) {
        this.meetingTrtcListener = cVar;
    }

    @Override // kk3.b
    public void setRemoteAudioStreamMuteStatus(boolean mute) {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: setRemoteAudioStreamMuteStatus , mute == " + mute);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).muteAllRemoteAudio(mute);
    }

    @Override // kk3.b
    public void startLocalAudio() {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: startLocalAudio ");
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).v(true, new d());
    }

    @Override // kk3.b
    public void startScreenCapture() {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: startScreenCapture ");
        MeetingScreenCaptureFloatView.INSTANCE.g(new Runnable() { // from class: kk3.l
            @Override // java.lang.Runnable
            public final void run() {
                QQMeetingTrtcImpl.startScreenCapture$lambda$0(QQMeetingTrtcImpl.this);
            }
        });
    }

    @Override // kk3.b
    public void stopLocalAudio() {
        boolean z16 = true;
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: stopLocalAudio ");
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).stopLocalAudio();
        this.selfMicSwitch = false;
        String str = this.selfUserId;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        String str2 = this.selfUserId;
        if (str2 == null) {
            str2 = "";
        }
        sendEvent("onUserAudioAvailable", 0L, str2);
    }

    @Override // kk3.b
    public void stopScreenCapture() {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: stopScreenCapture");
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).stopScreenCapture();
        MeetingScreenCaptureFloatView.INSTANCE.e();
    }

    @Override // kk3.b
    public void switchRole(boolean anchor) {
        QLog.i(this.TAG, 1, "QQMeetingTrtc :: switchRole , anchor == " + anchor);
        if (anchor) {
            ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).h(new f(anchor, this));
            return;
        }
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).switchRole(anchor);
        kk3.c cVar = this.meetingTrtcListener;
        if (cVar != null) {
            cVar.onRoleSwitchedCallbackWrapper(0, "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$d", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements b.a {
        d() {
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                boolean z16 = true;
                QQMeetingTrtcImpl.this.selfMicSwitch = true;
                kk3.c meetingTrtcListener = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
                if (meetingTrtcListener != null) {
                    meetingTrtcListener.onAudioStartedCallbackWrapper(0, "startLocalAudio success");
                }
                String str = QQMeetingTrtcImpl.this.selfUserId;
                if (str != null && str.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                QQMeetingTrtcImpl qQMeetingTrtcImpl = QQMeetingTrtcImpl.this;
                String str2 = qQMeetingTrtcImpl.selfUserId;
                if (str2 == null) {
                    str2 = "";
                }
                qQMeetingTrtcImpl.sendEvent("onUserAudioAvailable", 1L, str2);
                return;
            }
            kk3.c meetingTrtcListener2 = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
            if (meetingTrtcListener2 != null) {
                meetingTrtcListener2.onAudioStartedCallbackWrapper(-1, "startLocalAudio failed");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$e", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements b.a {
        e() {
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                kk3.c meetingTrtcListener = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
                if (meetingTrtcListener != null) {
                    meetingTrtcListener.onStartScreenCaptureCallbackWrapper(0, "onStartScreenCaptureResult success ");
                    return;
                }
                return;
            }
            MeetingScreenCaptureFloatView.INSTANCE.e();
            kk3.c meetingTrtcListener2 = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
            if (meetingTrtcListener2 != null) {
                meetingTrtcListener2.onStartScreenCaptureCallbackWrapper(-3, "onStartScreenCaptureResult not success data:" + errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$f", "Lgk3/b$a;", "", "allow", "Lcom/tencent/sqshow/zootopia/data/a;", NotificationCompat.CATEGORY_ERROR, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f335239a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQMeetingTrtcImpl f335240b;

        f(boolean z16, QQMeetingTrtcImpl qQMeetingTrtcImpl) {
            this.f335239a = z16;
            this.f335240b = qQMeetingTrtcImpl;
        }

        @Override // gk3.b.a
        public void a(boolean allow, ErrorMessage err) {
            if (!allow && !h.b()) {
                kk3.c meetingTrtcListener = this.f335240b.getMeetingTrtcListener();
                if (meetingTrtcListener != null) {
                    meetingTrtcListener.onRoleSwitchedCallbackWrapper(-1, "Permission Disallow");
                    return;
                }
                return;
            }
            ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).switchRole(this.f335239a);
            kk3.c meetingTrtcListener2 = this.f335240b.getMeetingTrtcListener();
            if (meetingTrtcListener2 != null) {
                meetingTrtcListener2.onRoleSwitchedCallbackWrapper(0, "");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J(\u0010 \u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J$\u0010#\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016\u00a8\u0006("}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingTrtcImpl$g", "Lcom/tencent/trtc/TRTCCloudListener;", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "Lkotlin/collections/ArrayList;", "userVolumes", "", "totalVolume", "", "onUserVoiceVolume", "errCode", "", "storagePath", "onLocalRecordBegin", "errMsg", "onSwitchRole", "onMicDidReady", "userId", "onRemoteUserEnterRoom", "reason", "onRemoteUserLeaveRoom", "onScreenCaptureStarted", "onScreenCaptureStopped", "", "available", "onUserAudioAvailable", "onFirstAudioFrame", "onUserVideoAvailable", "onUserSubStreamAvailable", "streamType", "width", "height", "onFirstVideoFrame", "Landroid/os/Bundle;", "extraInfo", "onError", "", "result", "onEnterRoom", "onExitRoom", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g extends TRTCCloudListener {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M(QQMeetingTrtcImpl this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.resetMeetingStatus();
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onError(int errCode, String errMsg, Bundle extraInfo) {
            QLog.e(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onError, errCode= " + errCode + ", errMsg= " + errMsg + ", extraInfo= " + extraInfo);
            QQMeetingTrtcImpl.this.sendEvent("onError", (long) errCode, errMsg);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onExitRoom(int reason) {
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "QQMeetingTrtc :: ZPlanRoomCommonListener , onExitRoom " + reason + ", isUEListening= " + QQMeetingTrtcImpl.this.isUEListening);
            ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).destroy();
            QQMeetingTrtcImpl.this.sendEvent("onExitRoom", (long) reason, "");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQMeetingTrtcImpl qQMeetingTrtcImpl = QQMeetingTrtcImpl.this;
            uIHandlerV2.post(new Runnable() { // from class: kk3.m
                @Override // java.lang.Runnable
                public final void run() {
                    QQMeetingTrtcImpl.g.M(QQMeetingTrtcImpl.this);
                }
            });
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onFirstAudioFrame(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            super.onFirstAudioFrame(userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onFirstVideoFrame(String userId, int streamType, int width, int height) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onFirstVideoFrame, userId=" + userId + ", streamType= " + streamType);
            QQMeetingTrtcImpl.this.sendEvent("onFirstVideoFrame", 0L, userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onLocalRecordBegin(int errCode, String storagePath) {
            QQMeetingTrtcImpl.this.sendEvent("onLocalRecordBegin", errCode, storagePath);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onMicDidReady() {
            QQMeetingTrtcImpl.this.sendEvent("onMicDidReady", 0L, "");
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserEnterRoom(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            QQMeetingTrtcImpl.this.sendEvent("onRemoteUserEnterRoom", 0L, userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserLeaveRoom(String userId, int reason) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            QQMeetingTrtcImpl.this.sendEvent("onRemoteUserLeaveRoom", reason, userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onScreenCaptureStarted() {
            QQMeetingTrtcImpl.this.sendEvent("onScreenCaptureStarted", 0L, "");
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onScreenCaptureStopped(int reason) {
            QQMeetingTrtcImpl.this.sendEvent("onScreenCaptureStopped", reason, "");
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onSwitchRole(int errCode, String errMsg) {
            QQMeetingTrtcImpl.this.sendEvent("onSwitchRole", errCode, errMsg);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserAudioAvailable(String userId, boolean available) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onUserAudioAvailable, userId=" + userId + ", available= " + available);
            QQMeetingTrtcImpl.this.sendEvent("onUserAudioAvailable", available ? 1L : 0L, userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserSubStreamAvailable(String userId, boolean available) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onUserSubStreamAvailable, userId=" + userId + ", available= " + available);
            QQMeetingTrtcImpl.this.sendEvent("onUserSubStreamAvailable", available ? 1L : 0L, userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVideoAvailable(String userId, boolean available) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onUserVideoAvailable, userId=" + userId + ", available= " + available);
            QQMeetingTrtcImpl.this.sendEvent("onUserVideoAvailable", available ? 1L : 0L, userId);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> userVolumes, int totalVolume) {
            Intrinsics.checkNotNullParameter(userVolumes, "userVolumes");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - QQMeetingTrtcImpl.this.getLastTimeUserVoiceVolume() < 1000) {
                return;
            }
            QQMeetingTrtcImpl.this.setLastTimeUserVoiceVolume(currentTimeMillis);
            HashMap hashMap = new HashMap();
            Iterator<TRTCCloudDef.TRTCVolumeInfo> it = userVolumes.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                TRTCCloudDef.TRTCVolumeInfo userVolumes2 = it.next();
                Intrinsics.checkNotNullExpressionValue(userVolumes2, "userVolumes");
                TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = userVolumes2;
                if (tRTCVolumeInfo.volume > 0) {
                    String str = tRTCVolumeInfo.userId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.userId");
                    hashMap.put(str, Integer.valueOf(tRTCVolumeInfo.volume));
                    Integer num = (Integer) QQMeetingTrtcImpl.this.lastAudioMemberMicLevelMap.get(tRTCVolumeInfo.userId);
                    if (num == null || tRTCVolumeInfo.volume != num.intValue()) {
                        z16 = true;
                    }
                }
            }
            if (hashMap.size() != QQMeetingTrtcImpl.this.lastAudioMemberMicLevelMap.size()) {
                z16 = true;
            }
            if (z16) {
                QQMeetingTrtcImpl.this.lastAudioMemberMicLevelMap.clear();
                QQMeetingTrtcImpl.this.lastAudioMemberMicLevelMap.putAll(hashMap);
                String buildEventInfo = QQMeetingTrtcImpl.this.buildEventInfo(hashMap);
                QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "QQMeetingTrtc :: ZPlanRoomCommonListener , eventInfo == " + buildEventInfo + ", isUEListening= " + QQMeetingTrtcImpl.this.isUEListening);
                kk3.c meetingTrtcListener = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
                if (meetingTrtcListener != null) {
                    meetingTrtcListener.onRoomEventCallbackWrapper(buildEventInfo);
                }
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onEnterRoom(long result) {
            if (result > 0) {
                QLog.i(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onEnterRoom success, costTime= " + result);
            } else {
                QLog.e(QQMeetingTrtcImpl.this.TAG, 1, "trtcListener#onEnterRoom error, result= " + result);
            }
            QQMeetingTrtcImpl.this.isMeeting.postValue(Boolean.TRUE);
            QQMeetingTrtcImpl.this.registerHeadsetStatusListener();
            kk3.c meetingTrtcListener = QQMeetingTrtcImpl.this.getMeetingTrtcListener();
            if (meetingTrtcListener != null) {
                meetingTrtcListener.onRoomJoinCallbackWrapper(result >= 0 ? 0 : -1, "");
            }
            QQMeetingTrtcImpl.this.sendEvent("onEnterRoom", result, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildEventInfo(Map<String, Integer> memberMicLevelMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("EventType", 1);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = memberMicLevelMap.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("EventName", "onUserVoiceVolume");
            jSONObject2.put("UserIds", jSONArray);
            jSONObject.put("EventContent", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "eventInfoJson.toString()");
            return jSONObject3;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
