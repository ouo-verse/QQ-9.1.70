package com.tencent.mobileqq.qqlive.api.impl.room.avchatroom;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.av.AVChatRoomListener;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.api.impl.room.LiveAudienceTPPlayerRoomImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAVChatRoomModule;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudienceAVChatRoom;
import com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveAudienceAVChatRoomImpl extends LiveAudienceTPPlayerRoomImpl implements ILiveAudienceAVChatRoom {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LiveAudienceAVChatRoomImpl";
    private final IAegisLogApi aegisLogger;
    private TRTCAVChatRoomModule avChatModule;
    private final List<AVChatRoomListener> tRTCRoomListeners;
    private ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType type;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.api.impl.room.avchatroom.LiveAudienceAVChatRoomImpl$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mobileqq$qqlive$api$room$avchatroom$ILiveAudiencePlayerLiveTypeSwitcher$PlayerLiveType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61072);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.values().length];
            $SwitchMap$com$tencent$mobileqq$qqlive$api$room$avchatroom$ILiveAudiencePlayerLiveTypeSwitcher$PlayerLiveType = iArr;
            try {
                iArr[ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.LIVE_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qqlive$api$room$avchatroom$ILiveAudiencePlayerLiveTypeSwitcher$PlayerLiveType[ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.LIVE_AV_CHAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public LiveAudienceAVChatRoomImpl(AudienceRoomConfig audienceRoomConfig) {
        super(audienceRoomConfig);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) audienceRoomConfig);
            return;
        }
        this.aegisLogger = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.type = ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.LIVE_NORMAL;
        this.tRTCRoomListeners = new CopyOnWriteArrayList();
    }

    private void logE(String str) {
        this.aegisLogger.e(TAG, str);
    }

    private void logI(String str) {
        this.aegisLogger.i(TAG, str);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void addAVChatRoomListener(AVChatRoomListener aVChatRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVChatRoomListener);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            this.tRTCRoomListeners.add(aVChatRoomListener);
        } else {
            tRTCAVChatRoomModule.addAVChatRoomListener(aVChatRoomListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher
    public void closeAVChatModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.avChatModule == null) {
            logE("closeAVChatModule fail! avChatModule is null!");
            return;
        }
        Iterator<AVChatRoomListener> it = this.tRTCRoomListeners.iterator();
        while (it.hasNext()) {
            this.avChatModule.removeAVChatRoomListener(it.next());
        }
        this.tRTCRoomListeners.clear();
        this.avChatModule.exitTRTCRoom();
        this.avChatModule.release();
        this.avChatModule = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void closeCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("closeCamera fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.closeCamera();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void closeMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("closeMic fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.closeMic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher
    public void closeSuperPlayerModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.playModule == null) {
            logE("closeSuperPlayerModule fail! playModule is null!");
        } else {
            logI("closeSuperPlayerModule");
            this.playModule.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.LiveAudienceTPPlayerRoomImpl, com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.destroy();
        logI("destroy avChatModule:" + this.avChatModule);
        if (this.avChatModule != null) {
            closeAVChatModule();
        }
        this.type = ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.LIVE_NORMAL;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void enableBitmapUploader(boolean z16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), bitmap);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("enableBitmapUploader fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.enableBitmapUploader(z16, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher
    public ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType getPlayerLiveType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public boolean isCameraOpened() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("isCameraOpened fail! avChatModule is null!");
            return false;
        }
        return tRTCAVChatRoomModule.isCameraOpened();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public boolean isMicOpened() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("isMicOpened fail! avChatModule is null!");
            return false;
        }
        return tRTCAVChatRoomModule.isMicOpened();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher
    public void openAVChatModule(Context context, String str, QQLiveRoomParams qQLiveRoomParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, qQLiveRoomParams);
            return;
        }
        BaseAnchorInfo anchorInfo = getAnchorInfo();
        if (anchorInfo == null) {
            logE("openAVChatModule fail! anchorInfo is null!");
            return;
        }
        long anchorUid = anchorInfo.getAnchorUid();
        if (anchorUid == 0) {
            logE("openAVChatModule fail! anchorUserId is 0!");
            return;
        }
        logI("openAVChatModule context:" + context + " appId:" + str + " params:" + qQLiveRoomParams);
        if (this.avChatModule == null) {
            this.avChatModule = new TRTCAVChatRoomModule(this.liveSDK, getRoomInfo(), anchorUid);
        }
        Iterator<AVChatRoomListener> it = this.tRTCRoomListeners.iterator();
        while (it.hasNext()) {
            this.avChatModule.addAVChatRoomListener(it.next());
        }
        this.avChatModule.enterTRTCRoom(context, str, qQLiveRoomParams);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void openCamera(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewGroup);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("openCamera fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.openCamera(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void openMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("openMic fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.openMic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher
    public void openSuperPlayerModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.playModule == null) {
            logE("openSuperPlayerModule fail! playModule is null!");
            return;
        }
        logI("openSuperPlayerModule playModule:" + this.playModule + " url:" + this.playModule.getPlayUrl());
        this.playModule.replay();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void removeAVChatRoomListener(AVChatRoomListener aVChatRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVChatRoomListener);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("removeAVChatRoomListener fail! avChatModule is null!");
            this.tRTCRoomListeners.remove(aVChatRoomListener);
        } else {
            tRTCAVChatRoomModule.removeAVChatRoomListener(aVChatRoomListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("sendSEIMsg fail! avChatModule is null!");
            return false;
        }
        return tRTCAVChatRoomModule.sendSEIMsg(bArr, i3);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void setBeautyPreProcess(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("setBeautyPreProcess fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.setBeautyPreProcess(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void setPreview(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) viewGroup);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("setPreview fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.setPreview(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) qQLiveRenderParams);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("setRemoteVideoParam fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.setRemoteVideoParam(str, qQLiveRenderParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void startPublish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("startPublish fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.startPublish();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void startRemoteAudio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("startRemoteAudio fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.startRemoteAudio(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void startRemoteVideo(String str, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) viewGroup);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("startRemoteVideo fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.startRemoteVideo(str, viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopAllRemoteAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("stopAllRemoteAudio fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.stopAllRemoteAudio();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopAllRemoteVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("stopAllRemoteVideo fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.stopAllRemoteVideo();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopPublish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("stopPublish fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.stopPublish();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopRemoteAudio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("stopRemoteAudio fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.stopRemoteAudio(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void stopRemoteVideo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("stopRemoteVideo fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.stopRemoteVideo(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("switchCamera fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.switchCamera();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher
    public void switchPlayerLiveType(ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType playerLiveType, Context context, String str, QQLiveRoomParams qQLiveRoomParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, playerLiveType, context, str, qQLiveRoomParams);
            return;
        }
        logI("switchPlayerLiveType type:" + playerLiveType + " cur:" + this.type);
        if (this.type == playerLiveType) {
            return;
        }
        this.type = playerLiveType;
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$mobileqq$qqlive$api$room$avchatroom$ILiveAudiencePlayerLiveTypeSwitcher$PlayerLiveType[playerLiveType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                closeSuperPlayerModule();
                openAVChatModule(context, str, qQLiveRoomParams);
                return;
            }
            return;
        }
        closeAVChatModule();
        openSuperPlayerModule();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAVChatAbility
    public void updateMediaConfig(LiveMediaConfig liveMediaConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) liveMediaConfig);
            return;
        }
        TRTCAVChatRoomModule tRTCAVChatRoomModule = this.avChatModule;
        if (tRTCAVChatRoomModule == null) {
            logE("updateMediaConfig fail! avChatModule is null!");
        } else {
            tRTCAVChatRoomModule.updateMediaConfig(liveMediaConfig);
        }
    }
}
