package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.os.Bundle;
import com.tencent.mobileqq.groupvideo.bridgeengine.GroupLiveTRTCStatistics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends TRTCCloudListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private GroupLiveTRTCCloudListener f213721a;

    public a(GroupLiveTRTCCloudListener groupLiveTRTCCloudListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupLiveTRTCCloudListener);
        } else {
            this.f213721a = groupLiveTRTCCloudListener;
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioRouteChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onAudioRouteChanged(i3, i16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onCameraDidReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onCameraDidReady();
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionLost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionRecovery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onEnterRoom(j3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onError(i3, str, bundle);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onExitRoom(i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstAudioFrame(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onFirstAudioFrame(str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onFirstVideoFrame(str, i3, i16, i17);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMicDidReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onMicDidReady();
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMissCustomCmdMsg(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) tRTCQuality, (Object) arrayList);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvCustomCmdMsg(String str, int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvSEIMsg(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) bArr);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteAudioStatusUpdated(String str, int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onRemoteAudioStatusUpdated(str, i3, i16, bundle);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onRemoteUserEnterRoom(str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onRemoteUserLeaveRoom(str, i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteVideoStatusUpdated(String str, int i3, int i16, int i17, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onRemoteVideoStatusUpdated(str, i3, i16, i17, bundle);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalAudioFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onSendFirstLocalAudioFrame();
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalVideoFrame(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onSendFirstLocalVideoFrame(i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSpeedTestResult(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) tRTCSpeedTestResult);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(TRTCStatistics tRTCStatistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) tRTCStatistics);
            return;
        }
        if (this.f213721a != null) {
            GroupLiveTRTCStatistics groupLiveTRTCStatistics = new GroupLiveTRTCStatistics();
            groupLiveTRTCStatistics.appCpu = tRTCStatistics.appCpu;
            groupLiveTRTCStatistics.systemCpu = tRTCStatistics.systemCpu;
            groupLiveTRTCStatistics.upLoss = tRTCStatistics.upLoss;
            groupLiveTRTCStatistics.downLoss = tRTCStatistics.downLoss;
            groupLiveTRTCStatistics.rtt = tRTCStatistics.rtt;
            groupLiveTRTCStatistics.gatewayRtt = tRTCStatistics.gatewayRtt;
            groupLiveTRTCStatistics.sendBytes = tRTCStatistics.sendBytes;
            groupLiveTRTCStatistics.receiveBytes = tRTCStatistics.receiveBytes;
            ArrayList<TRTCStatistics.TRTCLocalStatistics> arrayList = tRTCStatistics.localArray;
            if (arrayList != null && arrayList.size() > 0) {
                groupLiveTRTCStatistics.localArray = new ArrayList<>();
                for (int i3 = 0; i3 < tRTCStatistics.localArray.size(); i3++) {
                    GroupLiveTRTCStatistics.GroupLiveTRTCLocalStatistics groupLiveTRTCLocalStatistics = new GroupLiveTRTCStatistics.GroupLiveTRTCLocalStatistics();
                    groupLiveTRTCLocalStatistics.width = tRTCStatistics.localArray.get(i3).width;
                    groupLiveTRTCLocalStatistics.height = tRTCStatistics.localArray.get(i3).height;
                    groupLiveTRTCLocalStatistics.frameRate = tRTCStatistics.localArray.get(i3).frameRate;
                    groupLiveTRTCLocalStatistics.videoBitrate = tRTCStatistics.localArray.get(i3).videoBitrate;
                    groupLiveTRTCLocalStatistics.audioSampleRate = tRTCStatistics.localArray.get(i3).audioSampleRate;
                    groupLiveTRTCLocalStatistics.audioBitrate = tRTCStatistics.localArray.get(i3).audioBitrate;
                    groupLiveTRTCLocalStatistics.streamType = tRTCStatistics.localArray.get(i3).streamType;
                    groupLiveTRTCLocalStatistics.audioCaptureState = tRTCStatistics.localArray.get(i3).audioCaptureState;
                    groupLiveTRTCStatistics.localArray.add(groupLiveTRTCLocalStatistics);
                }
            }
            ArrayList<TRTCStatistics.TRTCRemoteStatistics> arrayList2 = tRTCStatistics.remoteArray;
            if (arrayList2 != null && arrayList2.size() > 0) {
                groupLiveTRTCStatistics.remoteArray = new ArrayList<>();
                for (int i16 = 0; i16 < tRTCStatistics.remoteArray.size(); i16++) {
                    GroupLiveTRTCStatistics.GroupLiveTRTCRemoteStatistics groupLiveTRTCRemoteStatistics = new GroupLiveTRTCStatistics.GroupLiveTRTCRemoteStatistics();
                    groupLiveTRTCRemoteStatistics.userId = tRTCStatistics.remoteArray.get(i16).userId;
                    groupLiveTRTCRemoteStatistics.audioPacketLoss = tRTCStatistics.remoteArray.get(i16).audioPacketLoss;
                    groupLiveTRTCRemoteStatistics.videoPacketLoss = tRTCStatistics.remoteArray.get(i16).videoPacketLoss;
                    groupLiveTRTCRemoteStatistics.width = tRTCStatistics.remoteArray.get(i16).width;
                    groupLiveTRTCRemoteStatistics.height = tRTCStatistics.remoteArray.get(i16).height;
                    groupLiveTRTCRemoteStatistics.frameRate = tRTCStatistics.remoteArray.get(i16).frameRate;
                    groupLiveTRTCRemoteStatistics.videoBitrate = tRTCStatistics.remoteArray.get(i16).videoBitrate;
                    groupLiveTRTCRemoteStatistics.audioSampleRate = tRTCStatistics.remoteArray.get(i16).audioSampleRate;
                    groupLiveTRTCRemoteStatistics.audioBitrate = tRTCStatistics.remoteArray.get(i16).audioBitrate;
                    groupLiveTRTCRemoteStatistics.jitterBufferDelay = tRTCStatistics.remoteArray.get(i16).jitterBufferDelay;
                    groupLiveTRTCRemoteStatistics.point2PointDelay = tRTCStatistics.remoteArray.get(i16).point2PointDelay;
                    groupLiveTRTCRemoteStatistics.audioTotalBlockTime = tRTCStatistics.remoteArray.get(i16).audioTotalBlockTime;
                    groupLiveTRTCRemoteStatistics.audioBlockRate = tRTCStatistics.remoteArray.get(i16).audioBlockRate;
                    groupLiveTRTCRemoteStatistics.videoTotalBlockTime = tRTCStatistics.remoteArray.get(i16).videoTotalBlockTime;
                    groupLiveTRTCRemoteStatistics.videoBlockRate = tRTCStatistics.remoteArray.get(i16).videoBlockRate;
                    groupLiveTRTCRemoteStatistics.finalLoss = tRTCStatistics.remoteArray.get(i16).finalLoss;
                    groupLiveTRTCRemoteStatistics.streamType = tRTCStatistics.remoteArray.get(i16).streamType;
                    groupLiveTRTCStatistics.remoteArray.add(groupLiveTRTCRemoteStatistics);
                }
            }
            this.f213721a.onStatistics(groupLiveTRTCStatistics);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRole(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onSwitchRole(i3, str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRoom(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onSwitchRoom(i3, str);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onTryToReconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16));
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onUserAudioAvailable(str, z16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserSubStreamAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onUserSubStreamAvailable(str, z16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onUserVideoAvailable(str, z16);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoSizeChanged(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onUserVideoSizeChanged(str, i3, i16, i17);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) arrayList, i3);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onUserVoiceVolume(i3);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle);
            return;
        }
        GroupLiveTRTCCloudListener groupLiveTRTCCloudListener = this.f213721a;
        if (groupLiveTRTCCloudListener != null) {
            groupLiveTRTCCloudListener.onWarning(i3, str, bundle);
        }
    }
}
