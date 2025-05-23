package b32;

import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a {
    public void onError(int i3, int i16, int i17, String str) {
    }

    public void onInfo(int i3, long j3, long j16, Object obj) {
    }

    @Deprecated
    public void onError(int i3, String str) {
    }

    public void onInfo(a32.c cVar) {
    }

    public void onPause() {
    }

    public void onPlay() {
    }

    public void onPlayCompleted() {
    }

    public void onResume() {
    }

    public void onStartBuffer() {
    }

    public void onStop() {
    }

    public void onStopBuffer() {
    }

    public void onAutoDeInit(String str) {
    }

    public void onAutoRecover(String str) {
    }

    public void onRequestProtocolUpdate(String str) {
    }

    public void onFirstFrameCome(long j3, long j16) {
    }

    public void onStatistics(long j3, long j16) {
    }

    public void onSwitchDefinition(EnterRoomInfo.VideoDefinition videoDefinition, String str) {
    }

    public void onVideoSizeChanged(int i3, int i16) {
    }

    public void onPreparing(StreamType streamType, String str, PlayerConfig playerConfig) {
    }

    public void onUpdateDownloadInfo(long j3, long j16, long j17, long j18) {
    }
}
