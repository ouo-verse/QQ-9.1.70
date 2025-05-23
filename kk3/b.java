package kk3;

import androidx.lifecycle.LiveData;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingTrtcImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u000bH&J\b\u0010\u0016\u001a\u00020\u000bH&J\b\u0010\u0017\u001a\u00020\u000bH&J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH&J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002H&J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002H&J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\bH&J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH&J\b\u0010 \u001a\u00020\u0002H&J\b\u0010!\u001a\u00020\bH&J\u0010\u0010#\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\"H&J\b\u0010$\u001a\u00020\bH&J\b\u0010%\u001a\u00020\bH&\u00a8\u0006&"}, d2 = {"Lkk3/b;", "", "", "sdkAppId", "", "userId", "userSign", "roomId", "", "isAnchor", "focusResume", "", "enterTrtcRoom", "leaveRoom", "enable", "enableAudioEarMonitoring", "anchor", "switchRole", "useSpeakerphone", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "startScreenCapture", "stopScreenCapture", "startLocalAudio", "stopLocalAudio", "mute", "setLocalAudioMute", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioCaptureVolume", "setAudioPlayoutVolume", "key", "setAllRemoteAudioStreamMuteStatusByKey", "setRemoteAudioStreamMuteStatus", "getCurrentAudioDevice", "isKeepAlive", "Landroidx/lifecycle/LiveData;", "getIsInMeetingLiveData", "isInMeeting", "isAppForeground", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = QQMeetingTrtcImpl.class)
/* loaded from: classes38.dex */
public interface b {
    void enableAudioEarMonitoring(boolean enable);

    void enterTrtcRoom(int sdkAppId, String userId, String userSign, String roomId, boolean isAnchor, boolean focusResume);

    int getCurrentAudioDevice();

    LiveData<Boolean> getIsInMeetingLiveData();

    boolean isAppForeground();

    boolean isInMeeting();

    boolean isKeepAlive();

    void leaveRoom();

    void setAllRemoteAudioStreamMuteStatusByKey(String key, boolean mute);

    void setAudioCaptureVolume(int volume);

    void setAudioPlayoutVolume(int volume);

    void setAudioRoute(boolean useSpeakerphone);

    void setLocalAudioMute(boolean mute);

    void setRemoteAudioStreamMuteStatus(boolean mute);

    void startLocalAudio();

    void startScreenCapture();

    void stopLocalAudio();

    void stopScreenCapture();

    void switchRole(boolean anchor);
}
