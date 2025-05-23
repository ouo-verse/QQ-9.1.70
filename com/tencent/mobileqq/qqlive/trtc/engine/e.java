package com.tencent.mobileqq.qqlive.trtc.engine;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e extends TRTCCloudListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ITRTCRoomListener f273321a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.video.source.screen.b f273322b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.video.source.screen.d f273323c;

    /* renamed from: d, reason: collision with root package name */
    private ITRTCRemoteListener f273324d;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean L(int i3) {
        if (i3 != -7001 && i3 != -1309 && i3 != -1308) {
            return false;
        }
        return true;
    }

    public void M(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) iTRTCRemoteListener);
        } else {
            this.f273324d = iTRTCRemoteListener;
        }
    }

    public void N(ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) iTRTCRoomListener);
        } else {
            this.f273321a = iTRTCRoomListener;
        }
    }

    public void O(com.tencent.mobileqq.qqlive.trtc.video.source.screen.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bVar);
        } else {
            this.f273322b = bVar;
        }
    }

    public void P(com.tencent.mobileqq.qqlive.trtc.video.source.screen.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) dVar);
        } else {
            this.f273323c = dVar;
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioRouteChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onAudioRouteChanged(i3, i16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onCameraDidReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.onCameraDidReady();
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectOtherRoom(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, Integer.valueOf(i3), str2);
            return;
        }
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onConnectOtherRoom(str, i3, str2);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionLost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEvent(1002, 0, null, null);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionRecovery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEvent(1004, 0, null, null);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onDisConnectOtherRoom(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3, (Object) str);
            return;
        }
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onDisConnectOtherRoom(i3, str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEnterRoom(j3, null);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
            return;
        }
        if (this.f273322b != null && L(i3)) {
            this.f273322b.k(i3, str, bundle);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEvent(1000, i3, str, bundle);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onExitRoom(i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstAudioFrame(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onFirstAudioFrame(str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onFirstVideoFrame(str, i3, i16, i17);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMicDidReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.onMicDidReady();
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) tRTCQuality, (Object) arrayList);
            return;
        }
        if (this.f273324d != null) {
            ArrayList<QQLiveQuality> arrayList2 = new ArrayList<>();
            Iterator<TRTCCloudDef.TRTCQuality> it = arrayList.iterator();
            while (it.hasNext()) {
                TRTCCloudDef.TRTCQuality next = it.next();
                arrayList2.add(new QQLiveQuality(next.userId, next.quality));
            }
            this.f273324d.onNetworkQuality(new QQLiveQuality(tRTCQuality.userId, tRTCQuality.quality), arrayList2);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvSEIMsg(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        super.onRecvSEIMsg(str, bArr);
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onUserSei(str, bArr);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onRemoteUserEnterRoom(str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onRemoteUserLeaveRoom(str, i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCapturePaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.b bVar = this.f273322b;
        if (bVar == null) {
            return;
        }
        bVar.m(0);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCaptureResumed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.b bVar = this.f273322b;
        if (bVar == null) {
            return;
        }
        bVar.h(0);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCaptureStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.b bVar = this.f273322b;
        if (bVar == null) {
            return;
        }
        bVar.onScreenCaptureStarted();
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCaptureStopped(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.b bVar = this.f273322b;
        if (bVar == null) {
            return;
        }
        bVar.onScreenCaptureStopped(i3);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalAudioFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onFirstLocalAudioFrameSent();
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalVideoFrame(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onFirstLocalVideoFrameSent(i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, tRTCSpeedTestResult, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onSpeedTest(tRTCSpeedTestResult, i3, i16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(TRTCStatistics tRTCStatistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) tRTCStatistics);
            return;
        }
        if (this.f273321a != null) {
            StatisticData statisticData = new StatisticData();
            statisticData.appCpu = tRTCStatistics.appCpu;
            statisticData.downLoss = tRTCStatistics.downLoss;
            statisticData.rtt = tRTCStatistics.rtt;
            statisticData.upLoss = tRTCStatistics.upLoss;
            statisticData.sendBytes = tRTCStatistics.sendBytes;
            statisticData.receiveBytes = tRTCStatistics.receiveBytes;
            statisticData.localArray = new ArrayList<>();
            Iterator<TRTCStatistics.TRTCLocalStatistics> it = tRTCStatistics.localArray.iterator();
            while (it.hasNext()) {
                TRTCStatistics.TRTCLocalStatistics next = it.next();
                StatisticData.LocalStatisticsData localStatisticsData = new StatisticData.LocalStatisticsData();
                localStatisticsData.audioBitrate = next.audioBitrate;
                localStatisticsData.width = next.width;
                localStatisticsData.height = next.height;
                localStatisticsData.frameRate = next.frameRate;
                localStatisticsData.videoBitrate = next.videoBitrate;
                localStatisticsData.audioSampleRate = next.audioSampleRate;
                localStatisticsData.audioCaptureState = next.audioCaptureState;
                localStatisticsData.streamType = next.streamType;
                statisticData.localArray.add(localStatisticsData);
            }
            com.tencent.mobileqq.qqlive.trtc.video.source.screen.d dVar = this.f273323c;
            if (dVar != null) {
                dVar.a(statisticData);
            }
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRoom(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onSwitchRoom(i3, str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onTryToReconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEvent(1003, 0, null, null);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, Boolean.valueOf(z16));
            return;
        }
        super.onUserAudioAvailable(str, z16);
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onUserAudioAvailable(str, z16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserSubStreamAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
        } else {
            super.onUserSubStreamAvailable(str, z16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, Boolean.valueOf(z16));
            return;
        }
        super.onUserVideoAvailable(str, z16);
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            iTRTCRemoteListener.onUserVideoAvailable(str, z16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) arrayList, i3);
            return;
        }
        super.onUserVoiceVolume(arrayList, i3);
        ITRTCRemoteListener iTRTCRemoteListener = this.f273324d;
        if (iTRTCRemoteListener != null) {
            ArrayList<RemoteUserAudioInfo> arrayList2 = new ArrayList<>();
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<TRTCCloudDef.TRTCVolumeInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    TRTCCloudDef.TRTCVolumeInfo next = it.next();
                    RemoteUserAudioInfo remoteUserAudioInfo = new RemoteUserAudioInfo();
                    remoteUserAudioInfo.userId = next.userId;
                    remoteUserAudioInfo.volume = next.volume;
                    arrayList2.add(remoteUserAudioInfo);
                }
            }
            iTRTCRemoteListener.onUserVoiceVolume(arrayList2, i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle);
            return;
        }
        ITRTCRoomListener iTRTCRoomListener = this.f273321a;
        if (iTRTCRoomListener != null) {
            iTRTCRoomListener.onEvent(1001, i3, str, bundle);
        }
    }
}
