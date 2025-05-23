package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
class NtrtcAudioCallbackImplWrapper implements NtrtcAudioCallback {
    static IPatchRedirector $redirector_;
    private NtrtcAudioCallback mBusiCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NtrtcAudioCallbackImplWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mBusiCallback = null;
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onAudioEngineInstanceIsOccupied() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable() { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onAudioEngineInstanceIsOccupied();
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onAudioEngineStartResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$retCode;

                {
                    this.val$retCode = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onAudioEngineStartResult(this.val$retCode);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onMicStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$state;

                {
                    this.val$state = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onMicStateChanged(this.val$state);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onMicZeroEnergy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable() { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onMicZeroEnergy();
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onPlayerStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$state;

                {
                    this.val$state = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onPlayerStateChanged(this.val$state);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onRecordData(int i3, byte[] bArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16));
            return;
        }
        NtrtcAudioCallback ntrtcAudioCallback = this.mBusiCallback;
        if (ntrtcAudioCallback == null) {
            return;
        }
        ntrtcAudioCallback.onRecordData(i3, bArr, i16);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onRecvDataState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$state;

                {
                    this.val$state = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onRecvDataState(this.val$state);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onSelfSpeakingWhenMicClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable() { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onSelfSpeakingWhenMicClosed();
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onUpdateSelfSpeakingEnergy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcAudioCallbackImplWrapper.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$energyValue;

                {
                    this.val$energyValue = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcAudioCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcAudioCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcAudioCallbackImplWrapper.this.mBusiCallback.onUpdateSelfSpeakingEnergy(this.val$energyValue);
                    }
                }
            });
        }
    }

    public void setBusiCallback(NtrtcAudioCallback ntrtcAudioCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcAudioCallback);
        } else {
            this.mBusiCallback = ntrtcAudioCallback;
        }
    }
}
