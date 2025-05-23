package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.Keep;
import com.tencent.mobileqq.groupvideo.bridgeengine.GroupLiveTRTCCloudListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.util.Arrays;
import mqq.app.MobileQQ;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class TrtcSdkService implements ITrtcSdkService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TrtcSdkServiceInQQForGroupLive";
    private boolean mIsInited;
    private GroupLiveTRTCCloudListener.GroupLiveTRTCVideoRenderListener mLocalRenderListener;
    private GroupLiveTRTCCloudListener.GroupLiveTRTCVideoRenderListener mRemoteRenderListener;
    private TRTCCloud mTRTCCloud;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements TRTCCloudListener.TRTCVideoRenderListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TrtcSdkService.this);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
        public void onRenderVideoFrame(String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), tRTCVideoFrame);
            } else {
                TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
                TrtcSdkService.this.mLocalRenderListener.onRenderVideoFrame(str, i3, new GroupLiveTRTCVideoFrame(tRTCVideoFrame.pixelFormat, tRTCVideoFrame.bufferType, new GroupLiveTRTCTexture(tRTCTexture.textureId, tRTCTexture.eglContext10, tRTCTexture.eglContext14), tRTCVideoFrame.data, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.timestamp, tRTCVideoFrame.rotation));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements TRTCCloudListener.TRTCVideoRenderListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TrtcSdkService.this);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
        public void onRenderVideoFrame(String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), tRTCVideoFrame);
            } else {
                TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
                TrtcSdkService.this.mRemoteRenderListener.onRenderVideoFrame(str, i3, new GroupLiveTRTCVideoFrame(tRTCVideoFrame.pixelFormat, tRTCVideoFrame.bufferType, new GroupLiveTRTCTexture(tRTCTexture.textureId, tRTCTexture.eglContext10, tRTCTexture.eglContext14), tRTCVideoFrame.data, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.timestamp, tRTCVideoFrame.rotation));
            }
        }
    }

    public TrtcSdkService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mRemoteRenderListener = null;
        this.mLocalRenderListener = null;
        this.mIsInited = false;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void enableCustomVideoCapture(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QLog.i(TAG, 1, "enableCustomVideoCapture. streamType: " + i3 + ", enable: " + z16);
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.enableCustomVideoCapture(i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int enableEncSmallVideoStream(boolean z16, GroupLiveTRTCVideoEncParam groupLiveTRTCVideoEncParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), groupLiveTRTCVideoEncParam)).intValue();
        }
        QLog.i(TAG, 1, "enableEncSmallVideoStream enable: " + z16 + ", smallVideoEncParam videoResolution: " + groupLiveTRTCVideoEncParam.videoResolution + ", videoResolutionMode: " + groupLiveTRTCVideoEncParam.videoResolutionMode + ", videoFps: " + groupLiveTRTCVideoEncParam.videoFps + ", videoBitrate: " + groupLiveTRTCVideoEncParam.videoBitrate + ", minVideoBitrate: " + groupLiveTRTCVideoEncParam.minVideoBitrate + ", enableAdjustRes: " + groupLiveTRTCVideoEncParam.enableAdjustRes);
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
            tRTCVideoEncParam.videoResolution = groupLiveTRTCVideoEncParam.videoResolution;
            tRTCVideoEncParam.videoResolutionMode = groupLiveTRTCVideoEncParam.videoResolutionMode;
            tRTCVideoEncParam.videoFps = groupLiveTRTCVideoEncParam.videoFps;
            tRTCVideoEncParam.videoBitrate = groupLiveTRTCVideoEncParam.videoBitrate;
            tRTCVideoEncParam.minVideoBitrate = groupLiveTRTCVideoEncParam.minVideoBitrate;
            tRTCVideoEncParam.enableAdjustRes = groupLiveTRTCVideoEncParam.enableAdjustRes;
            return this.mTRTCCloud.enableEncSmallVideoStream(z16, tRTCVideoEncParam);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void enableMixExternalAudioFrame(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        QLog.i(TAG, 1, "enableMixExternalAudioFrame. enablePublish[" + z16 + "], enablePlayout[" + z17 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.enableMixExternalAudioFrame(z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void enterRoom(GroupLiveTRTCParams groupLiveTRTCParams, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupLiveTRTCParams, i3);
            return;
        }
        QLog.i(TAG, 1, "enterRoom. sdkAppId[" + groupLiveTRTCParams.sdkAppId + "], userId[" + groupLiveTRTCParams.userId + "], userSig[" + groupLiveTRTCParams.userSig + "], roomId[" + groupLiveTRTCParams.roomId + "], strRoomId[" + groupLiveTRTCParams.strRoomId + "], role[" + groupLiveTRTCParams.role + "], streamId[" + groupLiveTRTCParams.streamId + "], userDefineRecordId[" + groupLiveTRTCParams.userDefineRecordId + "], privateMapKey[" + groupLiveTRTCParams.privateMapKey + "], businessInfo[" + groupLiveTRTCParams.businessInfo + "], scene[" + i3 + "]");
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
            tRTCParams.sdkAppId = groupLiveTRTCParams.sdkAppId;
            tRTCParams.userId = groupLiveTRTCParams.userId;
            tRTCParams.userSig = groupLiveTRTCParams.userSig;
            tRTCParams.roomId = groupLiveTRTCParams.roomId;
            tRTCParams.strRoomId = groupLiveTRTCParams.strRoomId;
            tRTCParams.role = groupLiveTRTCParams.role;
            tRTCParams.streamId = groupLiveTRTCParams.streamId;
            tRTCParams.userDefineRecordId = groupLiveTRTCParams.userDefineRecordId;
            tRTCParams.privateMapKey = groupLiveTRTCParams.privateMapKey;
            tRTCParams.businessInfo = groupLiveTRTCParams.businessInfo;
            this.mTRTCCloud.enterRoom(tRTCParams, i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void exitRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "exitRoom");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.exitRoom();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int getAudioCaptureVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            return tRTCCloud.getAudioCaptureVolume();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int getAudioPlayoutVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            return tRTCCloud.getAudioPlayoutVolume();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public boolean init(GroupLiveTRTCCloudListener groupLiveTRTCCloudListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupLiveTRTCCloudListener)).booleanValue();
        }
        if (this.mIsInited) {
            return true;
        }
        QLog.i(TAG, 1, "init start. listener: " + groupLiveTRTCCloudListener);
        String loadSync = SoLoad.loadSync(SoLoad.BIZ_TRTC_GROUP_LIVE, SoLoadConstants.SONAME_TRTC);
        if (loadSync != null) {
            QLog.i(TAG, 1, "init. load trtc_entry_64 successfully. continue to load others. other library path: " + loadSync + ", file list: " + Arrays.toString(new File(loadSync).list()));
            TXLiveBase.setLibraryPath(loadSync);
            TRTCCloud sharedInstance = TRTCCloud.sharedInstance(MobileQQ.sMobileQQ);
            this.mTRTCCloud = sharedInstance;
            sharedInstance.setListener(new com.tencent.mobileqq.groupvideo.bridgeengine.a(groupLiveTRTCCloudListener));
            this.mIsInited = true;
            QLog.i(TAG, 1, "init successfully. sdk version: " + TRTCCloud.getSDKVersion());
        } else {
            this.mIsInited = false;
            QLog.e(TAG, 1, "init failed. realJniPath == null.");
        }
        return this.mIsInited;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int mixExternalAudioFrame(GroupLiveTRTCAudioFrame groupLiveTRTCAudioFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) groupLiveTRTCAudioFrame)).intValue();
        }
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = groupLiveTRTCAudioFrame.data;
            tRTCAudioFrame.sampleRate = groupLiveTRTCAudioFrame.sampleRate;
            tRTCAudioFrame.channel = groupLiveTRTCAudioFrame.channel;
            tRTCAudioFrame.timestamp = groupLiveTRTCAudioFrame.timestamp;
            tRTCAudioFrame.extraData = groupLiveTRTCAudioFrame.extraData;
            return this.mTRTCCloud.mixExternalAudioFrame(tRTCAudioFrame);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void muteAllRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 1, "muteAllRemoteAudio. mute[" + z16 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteAllRemoteAudio(z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void muteAllRemoteVideoStreams(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 1, "muteAllRemoteVideoStreams. mute: " + z16);
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteAllRemoteVideoStreams(z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void muteLocalAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 1, "muteLocalAudio. mute[" + z16 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalAudio(z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void muteLocalVideo(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QLog.i(TAG, 1, "muteLocalVideo. streamType: " + i3 + ", mute: " + z16);
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalVideo(i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void muteRemoteAudio(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, Boolean.valueOf(z16));
            return;
        }
        QLog.i(TAG, 1, "muteRemoteAudio. userId[" + str + "], mute[" + z16 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteRemoteAudio(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void muteRemoteVideoStream(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QLog.i(TAG, 1, "muteRemoteVideoStream. userId: " + str + ", streamType: " + i3 + ", mute: " + z16);
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteRemoteVideoStream(str, i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void sendCustomVideoData(int i3, GroupLiveTRTCVideoFrame groupLiveTRTCVideoFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3, (Object) groupLiveTRTCVideoFrame);
            return;
        }
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
            tRTCVideoFrame.pixelFormat = groupLiveTRTCVideoFrame.pixelFormat;
            tRTCVideoFrame.bufferType = groupLiveTRTCVideoFrame.bufferType;
            TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
            tRTCVideoFrame.texture = tRTCTexture;
            GroupLiveTRTCTexture groupLiveTRTCTexture = groupLiveTRTCVideoFrame.texture;
            tRTCTexture.textureId = groupLiveTRTCTexture.textureId;
            tRTCTexture.eglContext10 = groupLiveTRTCTexture.eglContext10;
            tRTCTexture.eglContext14 = groupLiveTRTCTexture.eglContext14;
            tRTCVideoFrame.data = groupLiveTRTCVideoFrame.data;
            tRTCVideoFrame.buffer = groupLiveTRTCVideoFrame.buffer;
            tRTCVideoFrame.width = groupLiveTRTCVideoFrame.width;
            tRTCVideoFrame.height = groupLiveTRTCVideoFrame.height;
            tRTCVideoFrame.timestamp = groupLiveTRTCVideoFrame.timestamp;
            tRTCVideoFrame.rotation = groupLiveTRTCVideoFrame.rotation;
            this.mTRTCCloud.sendCustomVideoData(i3, tRTCVideoFrame);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setAudioCaptureVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        QLog.i(TAG, 1, "setAudioCaptureVolume. volume[" + i3 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioCaptureVolume(i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setAudioPlayoutVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        QLog.i(TAG, 1, "setAudioPlayoutVolume. volume[" + i3 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioPlayoutVolume(i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setAudioRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        QLog.i(TAG, 1, "setAudioRoute. route[" + i3 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioRoute(i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setDefaultStreamRecvMode(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        QLog.i(TAG, 1, "setDefaultStreamRecvMode. autoRecvAudio[" + z16 + "], autoRecvVideo[" + z17 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setDefaultStreamRecvMode(z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setLocalRenderParams(GroupLiveTRTCRenderParams groupLiveTRTCRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) groupLiveTRTCRenderParams);
            return;
        }
        QLog.i(TAG, 1, "setLocalRenderParams param rotation: " + groupLiveTRTCRenderParams.rotation + ", fillMode: " + groupLiveTRTCRenderParams.fillMode + ", mirrorType: " + groupLiveTRTCRenderParams.mirrorType);
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
            tRTCRenderParams.rotation = groupLiveTRTCRenderParams.rotation;
            tRTCRenderParams.fillMode = groupLiveTRTCRenderParams.fillMode;
            tRTCRenderParams.mirrorType = groupLiveTRTCRenderParams.mirrorType;
            this.mTRTCCloud.setLocalRenderParams(tRTCRenderParams);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int setLocalVideoRenderListener(int i3, int i16, GroupLiveTRTCCloudListener.GroupLiveTRTCVideoRenderListener groupLiveTRTCVideoRenderListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, this, Integer.valueOf(i3), Integer.valueOf(i16), groupLiveTRTCVideoRenderListener)).intValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setLocalVideoRenderListener. pixelFormat: ");
        sb5.append(i3);
        sb5.append(", bufferType: ");
        sb5.append(i16);
        sb5.append(", listener: ");
        if (groupLiveTRTCVideoRenderListener != null) {
            z16 = true;
        }
        sb5.append(z16);
        QLog.i(TAG, 1, sb5.toString());
        if (groupLiveTRTCVideoRenderListener == null) {
            return -1;
        }
        this.mLocalRenderListener = groupLiveTRTCVideoRenderListener;
        if (this.mTRTCCloud == null) {
            return -1;
        }
        return this.mTRTCCloud.setLocalVideoRenderListener(i3, i16, new a());
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setMixExternalAudioVolume(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i(TAG, 1, "setMixExternalAudioVolume. publishVolume[" + i3 + "], playoutVolume[" + i16 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setMixExternalAudioVolume(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setNetworkQosParam(GroupLiveTRTCNetworkQosParam groupLiveTRTCNetworkQosParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) groupLiveTRTCNetworkQosParam);
            return;
        }
        QLog.i(TAG, 1, "setNetworkQosParam param preference: " + groupLiveTRTCNetworkQosParam.preference + ", controlMode: " + groupLiveTRTCNetworkQosParam.controlMode);
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
            tRTCNetworkQosParam.preference = groupLiveTRTCNetworkQosParam.preference;
            tRTCNetworkQosParam.controlMode = groupLiveTRTCNetworkQosParam.controlMode;
            this.mTRTCCloud.setNetworkQosParam(tRTCNetworkQosParam);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setRemoteAudioVolume(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, i3);
            return;
        }
        QLog.i(TAG, 1, "setRemoteAudioVolume. userId[" + str + "], volume[" + i3 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setRemoteAudioVolume(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setRemoteRenderParams(String str, int i3, GroupLiveTRTCRenderParams groupLiveTRTCRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), groupLiveTRTCRenderParams);
            return;
        }
        QLog.i(TAG, 1, "setRemoteRenderParams userId: " + str + ", streamType: " + i3 + ", param rotation: " + groupLiveTRTCRenderParams.rotation + ", fillMode: " + groupLiveTRTCRenderParams.fillMode + ", mirrorType: " + groupLiveTRTCRenderParams.mirrorType);
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
            tRTCRenderParams.rotation = groupLiveTRTCRenderParams.rotation;
            tRTCRenderParams.fillMode = groupLiveTRTCRenderParams.fillMode;
            tRTCRenderParams.mirrorType = groupLiveTRTCRenderParams.mirrorType;
            this.mTRTCCloud.setRemoteRenderParams(str, i3, tRTCRenderParams);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int setRemoteVideoRenderListener(String str, int i3, int i16, GroupLiveTRTCCloudListener.GroupLiveTRTCVideoRenderListener groupLiveTRTCVideoRenderListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, this, str, Integer.valueOf(i3), Integer.valueOf(i16), groupLiveTRTCVideoRenderListener)).intValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setRemoteVideoRenderListener. userId: ");
        sb5.append(str);
        sb5.append(", pixelFormat: ");
        sb5.append(i3);
        sb5.append(", bufferType: ");
        sb5.append(i16);
        sb5.append(", listener: ");
        if (groupLiveTRTCVideoRenderListener != null) {
            z16 = true;
        }
        sb5.append(z16);
        QLog.i(TAG, 1, sb5.toString());
        if (groupLiveTRTCVideoRenderListener == null) {
            return -1;
        }
        this.mRemoteRenderListener = groupLiveTRTCVideoRenderListener;
        if (this.mTRTCCloud == null) {
            return -1;
        }
        return this.mTRTCCloud.setRemoteVideoRenderListener(str, i3, i16, new b());
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public int setRemoteVideoStreamType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, i3)).intValue();
        }
        QLog.i(TAG, 1, "setRemoteVideoStreamType userId: " + str + ", streamType: " + i3);
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            return tRTCCloud.setRemoteVideoStreamType(str, i3);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void setVideoEncoderParam(GroupLiveTRTCVideoEncParam groupLiveTRTCVideoEncParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) groupLiveTRTCVideoEncParam);
            return;
        }
        QLog.i(TAG, 1, "setVideoEncoderParam param videoResolution: " + groupLiveTRTCVideoEncParam.videoResolution + ", videoResolutionMode: " + groupLiveTRTCVideoEncParam.videoResolutionMode + ", videoFps: " + groupLiveTRTCVideoEncParam.videoFps + ", videoBitrate: " + groupLiveTRTCVideoEncParam.videoBitrate + ", minVideoBitrate: " + groupLiveTRTCVideoEncParam.minVideoBitrate + ", enableAdjustRes: " + groupLiveTRTCVideoEncParam.enableAdjustRes);
        if (this.mTRTCCloud != null) {
            TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
            tRTCVideoEncParam.videoResolution = groupLiveTRTCVideoEncParam.videoResolution;
            tRTCVideoEncParam.videoResolutionMode = groupLiveTRTCVideoEncParam.videoResolutionMode;
            tRTCVideoEncParam.videoFps = groupLiveTRTCVideoEncParam.videoFps;
            tRTCVideoEncParam.videoBitrate = groupLiveTRTCVideoEncParam.videoBitrate;
            tRTCVideoEncParam.minVideoBitrate = groupLiveTRTCVideoEncParam.minVideoBitrate;
            tRTCVideoEncParam.enableAdjustRes = groupLiveTRTCVideoEncParam.enableAdjustRes;
            this.mTRTCCloud.setVideoEncoderParam(tRTCVideoEncParam);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void startLocalAudio(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        QLog.i(TAG, 1, "startLocalAudio. quality[" + i3 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.startLocalAudio(i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void startLocalPreview(boolean z16, Context context, TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), context, textureView);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startLocalPreview. frontCamera");
        sb5.append(z16);
        sb5.append(", context: ");
        if (context == null) {
            z17 = true;
        }
        sb5.append(z17);
        sb5.append(", view: ");
        sb5.append(textureView);
        QLog.i(TAG, 1, sb5.toString());
        if (this.mTRTCCloud != null && context != null) {
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(context);
            tXCloudVideoView.addVideoView(textureView);
            this.mTRTCCloud.startLocalPreview(z16, tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void startRemoteView(String str, int i3, Context context, TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), context, textureView);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startRemoteView. userId: ");
        sb5.append(str);
        sb5.append(", streamType: ");
        sb5.append(i3);
        sb5.append(", context: ");
        if (context == null) {
            z16 = true;
        }
        sb5.append(z16);
        sb5.append(", view: ");
        sb5.append(textureView);
        QLog.i(TAG, 1, sb5.toString());
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            if (context == null) {
                tRTCCloud.startRemoteView(str, i3, null);
                return;
            }
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(context);
            tXCloudVideoView.addVideoView(textureView);
            this.mTRTCCloud.startRemoteView(str, i3, tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void stopAllRemoteView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "stopAllRemoteView. ");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.stopAllRemoteView();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void stopLocalAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "stopLocalAudio");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.stopLocalAudio();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void stopLocalPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "stopLocalPreview.");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.stopLocalPreview();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void stopRemoteView(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
            return;
        }
        QLog.i(TAG, 1, "stopRemoteView. userId: " + str + ", streamType: " + i3);
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.stopRemoteView(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void switchRole(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        QLog.i(TAG, 1, "switchRole. role[" + i3 + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.switchRole(i3);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void uninit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.mIsInited) {
            return;
        }
        QLog.i(TAG, 1, "uninit.");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setListener(null);
            this.mTRTCCloud = null;
            TRTCCloud.destroySharedInstance();
        }
        this.mIsInited = false;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void updateLocalView(Context context, TextureView textureView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) textureView);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateLocalView. context: ");
        if (context == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", view: ");
        sb5.append(textureView);
        QLog.i(TAG, 1, sb5.toString());
        if (this.mTRTCCloud != null && context != null) {
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(context);
            tXCloudVideoView.addVideoView(textureView);
            this.mTRTCCloud.updateLocalView(tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void updateRemoteView(String str, int i3, Context context, TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), context, textureView);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateRemoteView. userId: ");
        sb5.append(str);
        sb5.append(", streamType: ");
        sb5.append(i3);
        sb5.append(", context: ");
        if (context == null) {
            z16 = true;
        }
        sb5.append(z16);
        sb5.append(", view: ");
        sb5.append(textureView);
        QLog.i(TAG, 1, sb5.toString());
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            if (context == null) {
                tRTCCloud.updateRemoteView(str, i3, null);
                return;
            }
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(context);
            tXCloudVideoView.addVideoView(textureView);
            this.mTRTCCloud.updateRemoteView(str, i3, tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITrtcSdkService
    public void switchRole(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        QLog.i(TAG, 1, "switchRole. role[" + i3 + "], privateMapKey[" + str + "]");
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.switchRole(i3, str);
        }
    }
}
