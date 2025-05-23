package com.tencent.mobileqq.zplan.room.impl.jni;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zplan.room.impl.jni.QQMeetingTrtc;
import com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingTrtcImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import gk3.b;
import kk3.b;
import kk3.c;
import kk3.i;
import kk3.k;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;
import t74.h;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QQMeetingTrtc implements c {
    public static final String MEETING_MUTE_KEY_BUS = "MUTE_KEY_BUS";
    public static final String MEETING_MUTE_KEY_MEDIA_FOCUS = "MUTE_KEY_MEDIA_FOCUS";
    public static final String MEETING_MUTE_KEY_PROGRESS_BACKGROUND = "MUTE_KEY_PROGRESS_BARGROUND";
    private static final String TAG = "QQMeetingTrtc_java_JNI";
    private static i activityLifeCallback = new AnonymousClass2();
    private static boolean isUEListening = false;
    private static String jumpScheme = "";
    private static int mapId;
    private static b meetingTrtcImpl;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.room.impl.jni.QQMeetingTrtc$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    class AnonymousClass2 extends i {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b() {
            if (QQMeetingTrtc.meetingTrtcImpl == null || QQMeetingTrtc.meetingTrtcImpl.isKeepAlive() || Foreground.getActivityCount() != 0) {
                return;
            }
            QQMeetingTrtc.meetingTrtcImpl.setAllRemoteAudioStreamMuteStatusByKey(QQMeetingTrtc.MEETING_MUTE_KEY_PROGRESS_BACKGROUND, true);
        }

        @Override // kk3.i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (QQMeetingTrtc.meetingTrtcImpl == null || !QQMeetingTrtc.meetingTrtcImpl.isKeepAlive()) {
                return;
            }
            if (!QQMeetingTrtc.meetingTrtcImpl.isInMeeting()) {
                QLog.i(QQMeetingTrtc.TAG, 1, "not in meeting,just return");
                return;
            }
            if (!pk3.a.a(BaseApplication.context)) {
                QLog.i(QQMeetingTrtc.TAG, 1, "donot have floating permission,just return");
                return;
            }
            if (((f) k74.i.f(f.class)).isFloat()) {
                QLog.i(QQMeetingTrtc.TAG, 1, "floatingView is already showing,just return");
            } else if (QQMeetingTrtc.meetingTrtcImpl.isAppForeground()) {
                QLog.i(QQMeetingTrtc.TAG, 1, "QQ is foreground");
                QQMeetingTrtc.showFloatingView();
            } else {
                QLog.i(QQMeetingTrtc.TAG, 1, "QQ is background,start delay check");
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.room.impl.jni.QQMeetingTrtc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QQMeetingTrtc.meetingTrtcImpl.isAppForeground()) {
                            QLog.i(QQMeetingTrtc.TAG, 1, "QQ is foreground after 1000ms");
                            QQMeetingTrtc.showFloatingView();
                        } else {
                            QLog.i(QQMeetingTrtc.TAG, 1, "QQ is background after 1000ms");
                        }
                    }
                }, 1000L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (QQMeetingTrtc.meetingTrtcImpl == null || QQMeetingTrtc.meetingTrtcImpl.isKeepAlive()) {
                return;
            }
            QQMeetingTrtc.meetingTrtcImpl.setAllRemoteAudioStreamMuteStatusByKey(QQMeetingTrtc.MEETING_MUTE_KEY_PROGRESS_BACKGROUND, false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.room.impl.jni.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQMeetingTrtc.AnonymousClass2.b();
                }
            }, 1000L);
        }
    }

    public QQMeetingTrtc() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: constructor");
        Foreground.addActivityLifeCallback(activityLifeCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showFloatingView() {
        String str;
        if (!TextUtils.isEmpty(jumpScheme)) {
            str = jumpScheme;
        } else {
            str = "mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&sceneType=7&pageData=%7B%22needDownload%22%3Afalse%2C%22mapId%22%3A" + mapId + "%2C%22openDetailNotReady%22%3Atrue%7D&sceneData=%7B%22SceneType%22%3A%221%22%7D";
        }
        QLog.i(TAG, 1, "will show floatingView\uff0cmapId == " + mapId + ",scheme == " + str);
        ((f) k74.i.f(f.class)).notifyShowFloatWindow(mapId, str, true, 4);
    }

    public void enableAudioEarMonitoring(boolean z16) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: enableAudioEarMonitoring , enable == " + z16);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.enableAudioEarMonitoring(z16);
    }

    public native void onAudioStartedCallback(int i3, String str);

    @Override // kk3.c
    public void onAudioStartedCallbackWrapper(int i3, String str) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: onAudioStartedCallbackWrapper result:" + i3 + "  errorMsg:" + str);
        onAudioStartedCallback(i3, str);
    }

    public native void onRoleSwitchedCallback(int i3, String str);

    @Override // kk3.c
    public void onRoleSwitchedCallbackWrapper(int i3, String str) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: onRoleSwitchedCallbackWrapper result:" + i3 + "  errorMsg:" + str);
        onRoleSwitchedCallback(i3, str);
    }

    public native void onRoomEventCallback(String str);

    @Override // kk3.c
    public void onRoomEventCallbackWrapper(String str) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: onRoomEventCallbackWrapper isUEListening:" + isUEListening);
        if (isUEListening) {
            onRoomEventCallback(str);
        }
    }

    public native void onRoomJoinCallback(int i3, String str);

    @Override // kk3.c
    public void onRoomJoinCallbackWrapper(int i3, String str) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: onRoomJoinCallbackWrapper result:" + i3 + "  errorMsg:" + str);
        onRoomJoinCallback(i3, str);
    }

    public native void onStartScreenCaptureCallback(int i3, String str);

    @Override // kk3.c
    public void onStartScreenCaptureCallbackWrapper(int i3, String str) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: onStartScreenCaptureCallbackWrapper result:" + i3 + "  errorMsg:" + str);
        onStartScreenCaptureCallback(i3, str);
    }

    public void registerRoomEventDelegate() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: registerRoomEventDelegate ");
        isUEListening = true;
    }

    public void setAllRemoteAudioStreamMuteStatus(boolean z16) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: setAllRemoteAudioStreamMuteStatus , mute == " + z16);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.setRemoteAudioStreamMuteStatus(z16);
    }

    public void setAudioCaptureVolume(int i3) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: setAudioCaptureVolume , volume == " + i3);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.setAudioCaptureVolume(i3);
    }

    public void setAudioPlayoutVolume(int i3) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: setAudioPlayoutVolume , volume == " + i3);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.setAudioPlayoutVolume(i3);
    }

    public void setAudioRoute(boolean z16) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: setAudioRoute useSpeakerphone:" + z16);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.setAudioRoute(z16);
    }

    public void setLocalAudioMute(boolean z16) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: setLocalAudioMute mute==" + z16);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.setLocalAudioMute(z16);
    }

    public void setRemoteAudioStreamMuteStatus(boolean z16) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: setRemoteAudioStreamMuteStatus , mute == " + z16);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.setRemoteAudioStreamMuteStatus(z16);
    }

    public void switchRole(boolean z16) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: switchRole , anchor == " + z16);
        b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.switchRole(z16);
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f335210a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f335211b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f335212c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f335213d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f335214e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f335215f;

        a(int i3, String str, String str2, String str3, boolean z16, boolean z17) {
            this.f335210a = i3;
            this.f335211b = str;
            this.f335212c = str2;
            this.f335213d = str3;
            this.f335214e = z16;
            this.f335215f = z17;
        }

        @Override // gk3.b.a
        public void a(boolean z16, ErrorMessage errorMessage) {
            if (!z16 && !h.b()) {
                QQMeetingTrtc.this.onRoomJoinCallbackWrapper(-2, "Permission Disallow");
            } else {
                QQMeetingTrtc.meetingTrtcImpl.enterTrtcRoom(this.f335210a, this.f335211b, this.f335212c, this.f335213d, this.f335214e, this.f335215f);
            }
        }
    }

    public void enterTrtcRoom(int i3, String str, String str2, String str3, String str4) {
        QLog.i(TAG, 1, "QQMeetingTrtc :: enterTrtcRoom , userId == " + str + ", roomId == " + str3 + "\uff0centerRoomConfigJson == " + str4);
        try {
            JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(str4) ? "{}" : str4);
            boolean optBoolean = jSONObject.optBoolean("keepAlive", false);
            boolean optBoolean2 = jSONObject.optBoolean("isAnchor", true);
            boolean optBoolean3 = jSONObject.optBoolean("focusResume", false);
            mapId = jSONObject.optInt("mapId", AdMetricID.Click.SUCCESS);
            jumpScheme = jSONObject.optString("jumpScheme", "");
            kk3.b bVar = meetingTrtcImpl;
            if (bVar == null) {
                fetTrtcImpl(optBoolean);
            } else if (optBoolean != bVar.isKeepAlive()) {
                meetingTrtcImpl.leaveRoom();
                fetTrtcImpl(optBoolean);
            }
            ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).h(new a(i3, str, str2, str3, optBoolean2, optBoolean3));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "QQMeetingTrtc :: enterTrtcRoom " + e16.getMessage(), e16);
            onRoomJoinCallbackWrapper(-3, "param error :" + e16.getMessage());
        }
    }

    public int getCurrentAudioDevice() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: getCurrentAudioDevice ");
        kk3.b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return 0;
        }
        return bVar.getCurrentAudioDevice();
    }

    public void leaveRoom() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: leaveRoom");
        kk3.b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.leaveRoom();
    }

    public void startLocalAudio() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: startLocalAudio ");
        kk3.b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.startLocalAudio();
    }

    public void startScreenCapture() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: startScreenCapture");
        kk3.b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.startScreenCapture();
    }

    public void stopLocalAudio() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: stopLocalAudio ");
        kk3.b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.stopLocalAudio();
    }

    public void stopScreenCapture() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: stopScreenCapture");
        kk3.b bVar = meetingTrtcImpl;
        if (bVar == null) {
            return;
        }
        bVar.stopScreenCapture();
    }

    public void unRegisterRoomEventDelegate() {
        QLog.i(TAG, 1, "QQMeetingTrtc :: unRegisterRoomEventDelegate ");
        isUEListening = false;
    }

    private void fetTrtcImpl(boolean z16) {
        if (z16) {
            meetingTrtcImpl = new k();
            return;
        }
        QQMeetingTrtcImpl qQMeetingTrtcImpl = new QQMeetingTrtcImpl();
        meetingTrtcImpl = qQMeetingTrtcImpl;
        qQMeetingTrtcImpl.setMeetingTrtcListener(this);
    }
}
