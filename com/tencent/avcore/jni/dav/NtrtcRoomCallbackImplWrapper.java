package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
class NtrtcRoomCallbackImplWrapper implements NtrtcRoomCallback {
    static IPatchRedirector $redirector_;
    private NtrtcRoomCallback mBusiCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NtrtcRoomCallbackImplWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mBusiCallback = null;
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onCommonTips(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.15
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$tips;

                {
                    this.val$tips = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onCommonTips(this.val$tips);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onCustomCommand(String str, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, j3, j16, j17) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.14
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$cmd;
                final /* synthetic */ long val$param1;
                final /* synthetic */ long val$param2;
                final /* synthetic */ String val$peerUin;

                {
                    this.val$peerUin = str;
                    this.val$cmd = j3;
                    this.val$param1 = j16;
                    this.val$param2 = j17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onCustomCommand(this.val$peerUin, this.val$cmd, this.val$param1, this.val$param2);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onGroundGlassSwitch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.11
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$state;

                {
                    this.val$state = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onGroundGlassSwitch(this.val$state);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onGroundGlassWaitTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.12
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$time;

                {
                    this.val$time = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onGroundGlassWaitTime(this.val$time);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onNetLevelChanged(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3, str) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$levelInfo;
                final /* synthetic */ String val$tips;

                {
                    this.val$levelInfo = i3;
                    this.val$tips = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onNetLevelChanged(this.val$levelInfo, this.val$tips);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onNotifyBusinessCheckNetworkState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable() { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onNotifyBusinessCheckNetworkState();
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerEnableAudio(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, z16) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$enable;
                final /* synthetic */ String val$peerUin;

                {
                    this.val$peerUin = str;
                    this.val$enable = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, str, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onPeerEnableAudio(this.val$peerUin, this.val$enable);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerEnableVideo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, z16) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$enable;
                final /* synthetic */ String val$peerUin;

                {
                    this.val$peerUin = str;
                    this.val$enable = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, str, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onPeerEnableVideo(this.val$peerUin, this.val$enable);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerMidiaFileOrVirtualCameraStateChanged(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3, str) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$state;
                final /* synthetic */ String val$tips;

                {
                    this.val$state = i3;
                    this.val$tips = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onPeerMidiaFileOrVirtualCameraStateChanged(this.val$state, this.val$tips);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerStateInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$stateInfo;

                {
                    this.val$peerUin = str;
                    this.val$stateInfo = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onPeerStateInfo(this.val$peerUin, this.val$stateInfo);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerSwitchAV(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$switch_av_type;

                {
                    this.val$peerUin = str;
                    this.val$switch_av_type = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onPeerSwitchAV(this.val$peerUin, this.val$switch_av_type);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerSysPhoneCalling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(z16) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isCalling;

                {
                    this.val$isCalling = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onPeerSysPhoneCalling(this.val$isCalling);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onRecvFunChatMsg(String str, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), bArr);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3, bArr) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.10
                static IPatchRedirector $redirector_;
                final /* synthetic */ byte[] val$buf;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$type;

                {
                    this.val$peerUin = str;
                    this.val$type = i3;
                    this.val$buf = bArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, str, Integer.valueOf(i3), bArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onRecvFunChatMsg(this.val$peerUin, this.val$type, this.val$buf);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onRecvSuperAvatarInfo(byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, bArr, Long.valueOf(j3));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(bArr, j3) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.16
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$frameTime;
                final /* synthetic */ byte[] val$infoBuf;

                {
                    this.val$infoBuf = bArr;
                    this.val$frameTime = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcRoomCallbackImplWrapper.this, bArr, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onRecvSuperAvatarInfo(this.val$infoBuf, this.val$frameTime);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onRecvTransferMsg(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(bArr) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ byte[] val$data;

                {
                    this.val$data = bArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this, (Object) bArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onRecvTransferMsg(this.val$data);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onStateInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$stateInfo;

                {
                    this.val$stateInfo = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onStateInfo(this.val$stateInfo);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onSuperAvatarInputFpsChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcRoomCallbackImplWrapper.17
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$fps;

                {
                    this.val$fps = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcRoomCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcRoomCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcRoomCallbackImplWrapper.this.mBusiCallback.onSuperAvatarInputFpsChanged(this.val$fps);
                    }
                }
            });
        }
    }

    public void setBusiCallback(NtrtcRoomCallback ntrtcRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcRoomCallback);
        } else {
            this.mBusiCallback = ntrtcRoomCallback;
        }
    }
}
