package kk3;

import androidx.lifecycle.LiveData;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b0\u00101J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\u001a\u0010)\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010,\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010-\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010/\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u00062"}, d2 = {"Lkk3/k;", "Lkk3/b;", "Lkk3/c;", "", "sdkAppId", "", "userId", "userSign", "roomId", "", "isAnchor", "focusResume", "", "enterTrtcRoom", "leaveRoom", "enable", "enableAudioEarMonitoring", "anchor", "switchRole", "useSpeakerphone", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "startScreenCapture", "stopScreenCapture", "startLocalAudio", "stopLocalAudio", "mute", "setLocalAudioMute", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioCaptureVolume", "setAudioPlayoutVolume", "key", "setAllRemoteAudioStreamMuteStatusByKey", "setRemoteAudioStreamMuteStatus", "getCurrentAudioDevice", "isKeepAlive", "Landroidx/lifecycle/LiveData;", "getIsInMeetingLiveData", "isInMeeting", "isAppForeground", "result", "errorMsg", "onRoomJoinCallbackWrapper", "ret", "onStartScreenCaptureCallbackWrapper", "onRoleSwitchedCallbackWrapper", "onAudioStartedCallbackWrapper", "eventInfo", "onRoomEventCallbackWrapper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k implements b, c {
    @Override // kk3.b
    public void enableAudioEarMonitoring(boolean enable) {
        ((b) k74.i.INSTANCE.a(b.class)).enableAudioEarMonitoring(enable);
    }

    @Override // kk3.b
    public void enterTrtcRoom(int sdkAppId, String userId, String userSign, String roomId, boolean isAnchor, boolean focusResume) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userSign, "userSign");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        ((b) k74.i.INSTANCE.a(b.class)).enterTrtcRoom(sdkAppId, userId, userSign, roomId, isAnchor, focusResume);
    }

    @Override // kk3.b
    public int getCurrentAudioDevice() {
        return ((b) k74.i.INSTANCE.a(b.class)).getCurrentAudioDevice();
    }

    @Override // kk3.b
    public LiveData<Boolean> getIsInMeetingLiveData() {
        return null;
    }

    @Override // kk3.b
    public boolean isAppForeground() {
        return ((b) k74.i.INSTANCE.a(b.class)).isAppForeground();
    }

    @Override // kk3.b
    public boolean isInMeeting() {
        return ((b) k74.i.INSTANCE.a(b.class)).isInMeeting();
    }

    @Override // kk3.b
    public boolean isKeepAlive() {
        return true;
    }

    @Override // kk3.b
    public void leaveRoom() {
        ((b) k74.i.INSTANCE.a(b.class)).leaveRoom();
    }

    @Override // kk3.c
    public void onAudioStartedCallbackWrapper(int result, String errorMsg) {
        ((c) k74.i.INSTANCE.a(c.class)).onAudioStartedCallbackWrapper(result, errorMsg);
    }

    @Override // kk3.c
    public void onRoleSwitchedCallbackWrapper(int result, String errorMsg) {
        ((c) k74.i.INSTANCE.a(c.class)).onRoleSwitchedCallbackWrapper(result, errorMsg);
    }

    @Override // kk3.c
    public void onRoomEventCallbackWrapper(String eventInfo) {
        ((c) k74.i.INSTANCE.a(c.class)).onRoomEventCallbackWrapper(eventInfo);
    }

    @Override // kk3.c
    public void onRoomJoinCallbackWrapper(int result, String errorMsg) {
        ((c) k74.i.INSTANCE.a(c.class)).onRoomJoinCallbackWrapper(result, errorMsg);
    }

    @Override // kk3.c
    public void onStartScreenCaptureCallbackWrapper(int ret, String errorMsg) {
        ((c) k74.i.INSTANCE.a(c.class)).onStartScreenCaptureCallbackWrapper(ret, errorMsg);
    }

    @Override // kk3.b
    public void setAllRemoteAudioStreamMuteStatusByKey(String key, boolean mute) {
        Intrinsics.checkNotNullParameter(key, "key");
        ((b) k74.i.INSTANCE.a(b.class)).setAllRemoteAudioStreamMuteStatusByKey(key, mute);
    }

    @Override // kk3.b
    public void setAudioCaptureVolume(int volume) {
        ((b) k74.i.INSTANCE.a(b.class)).setAudioCaptureVolume(volume);
    }

    @Override // kk3.b
    public void setAudioPlayoutVolume(int volume) {
        ((b) k74.i.INSTANCE.a(b.class)).setAudioPlayoutVolume(volume);
    }

    @Override // kk3.b
    public void setAudioRoute(boolean useSpeakerphone) {
        ((b) k74.i.INSTANCE.a(b.class)).setAudioRoute(useSpeakerphone);
    }

    @Override // kk3.b
    public void setLocalAudioMute(boolean mute) {
        ((b) k74.i.INSTANCE.a(b.class)).setLocalAudioMute(mute);
    }

    @Override // kk3.b
    public void setRemoteAudioStreamMuteStatus(boolean mute) {
        ((b) k74.i.INSTANCE.a(b.class)).setRemoteAudioStreamMuteStatus(mute);
    }

    @Override // kk3.b
    public void startLocalAudio() {
        ((b) k74.i.INSTANCE.a(b.class)).startLocalAudio();
    }

    @Override // kk3.b
    public void startScreenCapture() {
        ((b) k74.i.INSTANCE.a(b.class)).startScreenCapture();
    }

    @Override // kk3.b
    public void stopLocalAudio() {
        ((b) k74.i.INSTANCE.a(b.class)).stopLocalAudio();
    }

    @Override // kk3.b
    public void stopScreenCapture() {
        ((b) k74.i.INSTANCE.a(b.class)).stopScreenCapture();
    }

    @Override // kk3.b
    public void switchRole(boolean anchor) {
        ((b) k74.i.INSTANCE.a(b.class)).switchRole(anchor);
    }
}
