package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
class NtrtcSessionCallbackImplWrapper implements NtrtcSessionCallback {
    static IPatchRedirector $redirector_;
    private NtrtcSessionCallback mBusiCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NtrtcSessionCallbackImplWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mBusiCallback = null;
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onAnotherTerminalHaveProcessedInvitation(String str, boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, z16, j3, j16) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isAccept;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ long val$roomId;
                final /* synthetic */ long val$serverTimestamp;

                {
                    this.val$peerUin = str;
                    this.val$isAccept = z16;
                    this.val$roomId = j3;
                    this.val$serverTimestamp = j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onAnotherTerminalHaveProcessedInvitation(this.val$peerUin, this.val$isAccept, this.val$roomId, this.val$serverTimestamp);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onAvsdkHaveAutoAcceptedInvitation(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$accountType;
                final /* synthetic */ String val$peerUin;

                {
                    this.val$peerUin = str;
                    this.val$accountType = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onAvsdkHaveAutoAcceptedInvitation(this.val$peerUin, this.val$accountType);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onChannelReadyResult(String str, int i3, long j3, boolean z16, boolean z17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), str2);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3, j3, z16, z17, str2) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isSwitchTerminal;
                final /* synthetic */ boolean val$peerSwitchTerminal;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$retCode;
                final /* synthetic */ long val$roomId;
                final /* synthetic */ String val$traceId;

                {
                    this.val$peerUin = str;
                    this.val$retCode = i3;
                    this.val$roomId = j3;
                    this.val$isSwitchTerminal = z16;
                    this.val$peerSwitchTerminal = z17;
                    this.val$traceId = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onChannelReadyResult(this.val$peerUin, this.val$retCode, this.val$roomId, this.val$isSwitchTerminal, this.val$peerSwitchTerminal, this.val$traceId);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onCloseSession(String str, int i3, long j3, byte[] bArr, int i16, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr, Integer.valueOf(i16), str2, Boolean.valueOf(z16));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3, j3, bArr, i16, str2, z16) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.10
                static IPatchRedirector $redirector_;
                final /* synthetic */ byte[] val$buffer;
                final /* synthetic */ long val$errCode;
                final /* synthetic */ boolean val$isUserEventExited;
                final /* synthetic */ int val$operationCode;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$reason;
                final /* synthetic */ String val$traceId;

                {
                    this.val$peerUin = str;
                    this.val$reason = i3;
                    this.val$errCode = j3;
                    this.val$buffer = bArr;
                    this.val$operationCode = i16;
                    this.val$traceId = str2;
                    this.val$isUserEventExited = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr, Integer.valueOf(i16), str2, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onCloseSession(this.val$peerUin, this.val$reason, this.val$errCode, this.val$buffer, this.val$operationCode, this.val$traceId, this.val$isUserEventExited);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onInvitationReached(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3, i16, str2) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$peerState;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$subState;
                final /* synthetic */ String val$subStateWording;

                {
                    this.val$peerUin = str;
                    this.val$peerState = i3;
                    this.val$subState = i16;
                    this.val$subStateWording = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onInvitationReached(this.val$peerUin, this.val$peerState, this.val$subState, this.val$subStateWording);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onNotifyAnotherTerminalChatingState(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, j3, i3) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.11
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ long val$roomId;
                final /* synthetic */ int val$type;

                {
                    this.val$peerUin = str;
                    this.val$roomId = j3;
                    this.val$type = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Long.valueOf(j3), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onNotifyAnotherTerminalChatingState(this.val$peerUin, this.val$roomId, this.val$type);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onPeerSwitchTerminal(String str, boolean z16, int i3, int i16, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str2);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, z16, i3, i16, j3, str2) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isSuccess;
                final /* synthetic */ int val$peerSdkVersion;
                final /* synthetic */ int val$peerTerminalType;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ long val$roomId;
                final /* synthetic */ String val$traceId;

                {
                    this.val$peerUin = str;
                    this.val$isSuccess = z16;
                    this.val$peerTerminalType = i3;
                    this.val$peerSdkVersion = i16;
                    this.val$roomId = j3;
                    this.val$traceId = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onPeerSwitchTerminal(this.val$peerUin, this.val$isSuccess, this.val$peerTerminalType, this.val$peerSdkVersion, this.val$roomId, this.val$traceId);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onPeerSwitchToMulti(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$peerUin;

                {
                    this.val$peerUin = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcSessionCallbackImplWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onPeerSwitchToMulti(this.val$peerUin);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onPeerSwitchToScreenShare(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$peerUin;

                {
                    this.val$peerUin = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcSessionCallbackImplWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onPeerSwitchToScreenShare(this.val$peerUin);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onProcessInvitationResult(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, i3, str2) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ int val$retCode;
                final /* synthetic */ String val$traceId;

                {
                    this.val$peerUin = str;
                    this.val$retCode = i3;
                    this.val$traceId = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Integer.valueOf(i3), str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onProcessInvitationResult(this.val$peerUin, this.val$retCode, this.val$traceId);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onRecvInvitation(String str, boolean z16, int i3, long j3, long j16, int i16, int i17, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), bArr, bArr2);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(str, z16, i3, j3, j16, i16, i17, bArr, bArr2) { // from class: com.tencent.avcore.jni.dav.NtrtcSessionCallbackImplWrapper.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$bindID;
                final /* synthetic */ int val$bindType;
                final /* synthetic */ byte[] val$commonParam;
                final /* synthetic */ long val$extraUin;
                final /* synthetic */ boolean val$onlyAudio;
                final /* synthetic */ String val$peerUin;
                final /* synthetic */ byte[] val$sign;
                final /* synthetic */ int val$subServiceType;
                final /* synthetic */ int val$uinType;

                {
                    this.val$peerUin = str;
                    this.val$onlyAudio = z16;
                    this.val$uinType = i3;
                    this.val$extraUin = j3;
                    this.val$bindID = j16;
                    this.val$bindType = i16;
                    this.val$subServiceType = i17;
                    this.val$sign = bArr;
                    this.val$commonParam = bArr2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtrtcSessionCallbackImplWrapper.this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), bArr, bArr2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcSessionCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcSessionCallbackImplWrapper.this.mBusiCallback.onRecvInvitation(this.val$peerUin, this.val$onlyAudio, this.val$uinType, this.val$extraUin, this.val$bindID, this.val$bindType, this.val$subServiceType, this.val$sign, this.val$commonParam);
                    }
                }
            });
        }
    }

    public void setBusiCallback(NtrtcSessionCallback ntrtcSessionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcSessionCallback);
        } else {
            this.mBusiCallback = ntrtcSessionCallback;
        }
    }
}
