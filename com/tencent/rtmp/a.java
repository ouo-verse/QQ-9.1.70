package com.tencent.rtmp;

import android.view.Surface;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface a {
    void callExperimentalAPI(String str);

    void enableAudioVolumeEvaluation(int i3);

    boolean enableHardwareDecode(boolean z16);

    long getCurrentRenderPts();

    boolean isPlaying();

    void pause();

    void resume();

    void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener);

    void setAudioRoute(int i3);

    void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener);

    void setConfig(TXLivePlayConfig tXLivePlayConfig);

    void setMute(boolean z16);

    void setPlayListener(ITXLivePlayListener iTXLivePlayListener);

    void setPlayerView(TXCloudVideoView tXCloudVideoView);

    void setRenderMode(int i3);

    void setRenderRotation(int i3);

    void setSurface(Surface surface);

    void setSurfaceSize(int i3, int i16);

    void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener);

    void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener);

    int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj);

    void setVolume(int i3);

    void showDebugView(boolean z16);

    void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener);

    int startLivePlay(String str, int i3);

    int startRecord(int i3);

    int stopPlay(boolean z16);

    int stopRecord();

    int switchStream(String str);
}
