package com.tencent.superplayer.seamless.ipc;

import android.content.Context;
import android.os.RemoteException;
import android.view.Surface;
import androidx.annotation.VisibleForTesting;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.report.ISPReportProvider;
import com.tencent.superplayer.seamless.ipc.c;
import com.tencent.superplayer.seamless.ipc.d;
import com.tencent.superplayer.seamless.ipc.e;
import com.tencent.superplayer.seamless.ipc.f;
import com.tencent.superplayer.seamless.ipc.g;
import com.tencent.superplayer.seamless.ipc.h;
import com.tencent.superplayer.seamless.ipc.i;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
class k implements ISuperPlayer {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.superplayer.seamless.ipc.a f373970d;

    /* renamed from: e, reason: collision with root package name */
    private ISPlayerVideoView f373971e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends h.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnVideoPreparedListener f373972d;

        a(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
            this.f373972d = onVideoPreparedListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.h
        public void onVideoPrepared() throws RemoteException {
            this.f373972d.onVideoPrepared(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b extends c.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnCompletionListener f373974d;

        b(ISuperPlayer.OnCompletionListener onCompletionListener) {
            this.f373974d = onCompletionListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.c
        public void onCompletion() throws RemoteException {
            this.f373974d.onCompletion(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends g.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnSeekCompleteListener f373976d;

        c(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.f373976d = onSeekCompleteListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.g
        public void onSeekComplete() throws RemoteException {
            this.f373976d.onSeekComplete(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d extends e.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnErrorListener f373978d;

        d(ISuperPlayer.OnErrorListener onErrorListener) {
            this.f373978d = onErrorListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.e
        public void onError(int i3, int i16, int i17, String str) throws RemoteException {
            this.f373978d.onError(null, i3, i16, i17, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e extends f.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnInfoListener f373980d;

        e(ISuperPlayer.OnInfoListener onInfoListener) {
            this.f373980d = onInfoListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.f
        public boolean l0(int i3, long j3, long j16, ParcelableVideoSeiInfo parcelableVideoSeiInfo) throws RemoteException {
            this.f373980d.onInfo(null, i3, j3, j16, parcelableVideoSeiInfo);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class f extends i.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnVideoSizeChangedListener f373982d;

        f(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.f373982d = onVideoSizeChangedListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.i
        public void onVideoSizeChanged(int i3, int i16) throws RemoteException {
            this.f373982d.onVideoSizeChanged(null, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class g extends d.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer.OnDefinitionInfoListener f373984d;

        g(ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener) {
            this.f373984d = onDefinitionInfoListener;
        }

        @Override // com.tencent.superplayer.seamless.ipc.d
        public void B3(String str, List<String> list) throws RemoteException {
            this.f373984d.onDefinitionInfoUpdate(null, str, (ArrayList) list);
        }
    }

    public k(com.tencent.superplayer.seamless.ipc.a aVar) {
        this.f373970d = aVar;
    }

    @VisibleForTesting
    String a(String str) {
        return String.format("IRemotePlayer do not support %s method.", str);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(String str, String str2) {
        try {
            this.f373970d.addExtReportData(str, str2);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "addExtReportData fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addSubtitleSource(String str, String str2) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("addSubtitleSource"));
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public /* synthetic */ void bindVideoPlayerInfo(Object obj) {
        we4.a.a(this, obj);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("captureImageInTime"));
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void deselectTrack(int i3, long j3) {
        try {
            this.f373970d.deselectTrack(i3, j3);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "deselectTrack fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public TVKNetVideoInfo getCurTVKNetVideoInfo() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getCurTVKNetVideoInfo"));
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getCurrentPlayerState() {
        try {
            this.f373970d.getCurrentPlayerState();
            return 0;
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getCurrentPlayerState fail ", e16);
            return 0;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getCurrentPositionMs() {
        try {
            return this.f373970d.getCurrentPositionMs();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getCurrentPositionMs fail ", e16);
            return 0L;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getDurationMs() {
        try {
            return this.f373970d.getDurationMs();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getDurationMs fail ", e16);
            return 0L;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getFileSizeBytes() {
        try {
            this.f373970d.getFileSizeBytes();
            return 0L;
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getFileSizeBytes fail ", e16);
            return 0L;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public float getMaxVolumeGain() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getMaxVolumeGain"));
        return 1.0f;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public MediaInfo getMediaInfo() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getMediaInfo"));
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getPlayableDurationMs() {
        return 0L;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPProgramInfo[] getProgramInfo() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getProgramInfo"));
        return new TPProgramInfo[0];
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getProperty(String str) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getPropertyLongForTPPlayer"));
        return "";
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPReportProvider getReportProvider() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getReportProvider"));
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getSceneId() {
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getStreamDumpInfo() {
        try {
            return this.f373970d.getStreamDumpInfo();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getStreamDumpInfo fail ", e16);
            return null;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public SuperPlayerVideoInfo getSuperVideoInfo() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getSuperVideoInfo"));
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getToken() {
        try {
            this.f373970d.getToken();
            return null;
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getToken fail ", e16);
            return null;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPTrackInfo[] getTrackInfo() {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("getTrackInfo"));
        return new TPTrackInfo[0];
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoHeight() {
        try {
            return this.f373970d.getVideoHeight();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getVideoHeight fail ", e16);
            return 0;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoRotation() {
        try {
            return this.f373970d.getVideoRotation();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getVideoRotation fail ", e16);
            return 0;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPlayerVideoView getVideoView() {
        return this.f373971e;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoWidth() {
        try {
            return this.f373970d.getVideoWidth();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "getVideoWidth fail ", e16);
            return 0;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isBuffering() {
        try {
            return this.f373970d.isBuffering();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "isBuffering fail ", e16);
            return false;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isLoopBack() {
        try {
            return this.f373970d.isLoopBack();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "isLoopBack fail ", e16);
            return false;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isOutputMute() {
        try {
            return this.f373970d.isOutputMute();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "isOutputMute fail ", e16);
            return false;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPausing() {
        try {
            return this.f373970d.isPausing();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "isPausing fail ", e16);
            return false;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPlaying() {
        try {
            return this.f373970d.isPlaying();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "isPlaying fail ", e16);
            return false;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void onPrePlayViewShow() {
        try {
            this.f373970d.onPrePlayViewShow();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "onPrePlayViewShow fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("onRealTimeInfoChange"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("openMediaPlayer"));
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3, long j16) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("openTVKPlayer"));
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayerByUrl(Context context, String str, String str2, long j3, long j16) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("openTVKPlayerByUrl"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pause() {
        try {
            this.f373970d.pause();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "pause fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pauseDownload() {
        try {
            this.f373970d.pauseDownload();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "pauseDownload fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void release() {
        try {
            this.f373970d.release();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "release fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void reset() {
        try {
            this.f373970d.reset();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "reset fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void resumeDownload() {
        try {
            this.f373970d.resumeDownload();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "resumeDownload fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3) {
        try {
            this.f373970d.seekTo(i3);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "seekTo fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectProgram(int i3, long j3) {
        try {
            this.f373970d.selectProgram(i3, j3);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "selectProgram fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectTrack(int i3, long j3) {
        try {
            this.f373970d.selectTrack(i3, j3);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "selectTrack fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) {
        try {
            this.f373970d.setBusinessDownloadStrategy(i3, i16, i17, i18);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setBusinessDownloadStrategy fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16) {
        try {
            this.f373970d.setLoopback(z16);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setLoopback fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnAudioFrameOutputListener"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener onCaptureImageListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnCaptureImageListener"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCompletionListener(ISuperPlayer.OnCompletionListener onCompletionListener) {
        try {
            this.f373970d.w4(new b(onCompletionListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnCompletionListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener) {
        try {
            this.f373970d.Q(new g(onDefinitionInfoListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnDefinitionInfoListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnErrorListener(ISuperPlayer.OnErrorListener onErrorListener) {
        try {
            this.f373970d.v3(new d(onErrorListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnErrorListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnInfoListener(ISuperPlayer.OnInfoListener onInfoListener) {
        try {
            this.f373970d.E2(new e(onInfoListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnInfoListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnPermissionTimeoutListener(ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnPermissionTimeoutListener"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        try {
            this.f373970d.t3(new c(onSeekCompleteListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnSeekCompleteListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnSubtitleDataListener"));
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnTVKNetVideoInfoListener(ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnTVKNetVideoInfoListener"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener onTVideoNetInfoListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnTVideoNetInfoUpdateListener"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setOnVideoFrameOutputListener"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        try {
            this.f373970d.t4(new a(onVideoPreparedListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnVideoPreparedListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        try {
            this.f373970d.l1(new f(onVideoSizeChangedListener));
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOnVideoSizeChangedListener fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOutputMute(boolean z16) {
        try {
            this.f373970d.setOutputMute(z16);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setOutputMute fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlaySpeedRatio(float f16) {
        try {
            this.f373970d.setPlaySpeedRatio(f16);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setPlaySpeedRatio fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerActive() {
        try {
            this.f373970d.setPlayerActive();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setPlayerActive fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setPlayerOptionalParamList"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setReportContentId(String str) {
        try {
            this.f373970d.setReportContentId(str);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setReportContentId fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setSurface(Surface surface) {
        try {
            this.f373970d.setSurface(surface);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setSurface fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setVolumeGain(float f16) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("setVolumeGain"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setXYaxis(int i3) {
        this.f373971e.setXYaxis(i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void start() {
        try {
            this.f373970d.start();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "start fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void stop() {
        try {
            this.f373970d.stop();
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "stop fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinition(String str, int i3) {
        try {
            this.f373970d.switchDefinition(str, i3);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "switchDefinition fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinitionForUrl(String str, int i3) {
        try {
            this.f373970d.switchDefinitionForUrl(str, i3);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "switchDefinitionForUrl fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerSceneId(int i3) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("updatePlayerSceneId"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("updatePlayerVideoView"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("captureImageInTime"));
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        LogUtil.e("SPIpcSeamlessRemotePlayer", a("openMediaPlayer"));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(Map<String, String> map) {
        try {
            this.f373970d.h3(map);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "addExtReportDataByMap fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3, int i16) {
        try {
            this.f373970d.T1(i3, i16);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "seekToByMode fail ", e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        try {
            this.f373970d.U4(z16, j3, j16);
        } catch (RemoteException e16) {
            LogUtil.e("SPIpcSeamlessRemotePlayer", "setLoopbackOfSectionWithMode fail ", e16);
        }
    }
}
