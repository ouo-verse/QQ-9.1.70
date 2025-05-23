package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.mobileqq.groupvideo.bridgeengine.RegistAudioDataCompleteCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends MultiOperatorImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    private static final String f213729r;

    /* renamed from: p, reason: collision with root package name */
    private boolean f213730p;

    /* renamed from: q, reason: collision with root package name */
    private RegistAudioDataCompleteCallback f213731q;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25076);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        f213729r = com.tencent.mobileqq.groupvideo.config.a.a() + "GroupVideoMultiOperator";
    }

    public b(Context context, long j3, com.tencent.qav.channel.d dVar) {
        super(context, j3, dVar, false, 0, 3, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3), dVar);
        } else {
            this.f213730p = false;
        }
    }

    public String O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.getAVGQuality();
        }
        return "";
    }

    public int P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.getVideoAbilityLevel();
        }
        return 0;
    }

    public boolean Q() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        String str = f213729r;
        com.tencent.qav.log.a.a(str, "goOffStage mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m) {
            return false;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            i3 = qQGAudioCtrl.nativeStopVideoSend();
        } else {
            i3 = -1;
        }
        com.tencent.qav.log.a.d(str, "goOffStage, ret[" + i3 + "]");
        if (i3 == -1) {
            return false;
        }
        return true;
    }

    public boolean R() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String str = f213729r;
        com.tencent.qav.log.a.a(str, "goOnStage mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m) {
            return false;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            i3 = qQGAudioCtrl.startVideoSend();
        } else {
            i3 = 0;
        }
        com.tencent.qav.log.a.d(str, "goOnStage, ret[" + i3 + "]");
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    public int S(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.registerAudioDataCallback(i3, z16);
        }
        return -1;
    }

    public void T(RegistAudioDataCompleteCallback registAudioDataCompleteCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) registAudioDataCompleteCallback);
            return;
        }
        this.f213731q = registAudioDataCompleteCallback;
        if (registAudioDataCompleteCallback == null) {
            W(1);
            W(3);
        } else {
            S(1, true);
            S(3, true);
        }
    }

    public int U(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Float.valueOf(f16))).intValue();
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.setAudioDataVolume(i3, f16);
        }
        return -1;
    }

    public int V(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.setAudioDataFormat(i3, i16, i17, i18);
        }
        return -1;
    }

    public int W(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, i3)).intValue();
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.unregisterAudioDataCallback(i3);
        }
        return -1;
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.a
    public synchronized int e(com.tencent.qav.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).intValue();
        }
        this.f213730p = false;
        return super.e(aVar);
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.av.gaudio.b
    public void h(byte[] bArr, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        QLog.i(f213729r, 4, "onAudioProcess " + i3 + ", " + i16 + ", " + i17 + ", " + i18);
        RegistAudioDataCompleteCallback registAudioDataCompleteCallback = this.f213731q;
        if (registAudioDataCompleteCallback != null) {
            registAudioDataCompleteCallback.onComplete(bArr, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onEnterSuc(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onEnterSuc(j3, i3, i16);
        this.f213730p = true;
        F();
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 1, new Object[0]);
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemberMicChanged(String str, int i3, int i16, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        boolean z17 = !z16;
        com.tencent.qav.log.a.a(f213729r, String.format("onMemberMicChanged uin=%s available=%s", str, Boolean.valueOf(z17)));
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(f213729r, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j3 = 0;
        }
        QavDef$MultiUserInfo u16 = u(j3);
        if (u16 != null) {
            u16.mMicOn = !z16;
            A(u16, z17);
        }
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOffStageResult(int i3, long j3, long j16, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
            return;
        }
        if (i3 == 93) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 12, Boolean.valueOf(z16), Long.valueOf(j16), Integer.valueOf(i16));
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOnStageResult(int i3, long j3, long j16, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
            return;
        }
        if (i3 == 90 && j3 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 11, Boolean.valueOf(z16), Long.valueOf(j16), Integer.valueOf(i16));
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaSwitchVideoResult(int i3, long j3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
        } else {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 15, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onInitAIDenoiseStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.onInitAIDenoiseStatus();
        com.tencent.qav.log.a.a(f213729r, "onInitAIDenoiseStatus");
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 19, new Object[0]);
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onMAVMemberInOrOut(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int... iArr) {
        long j17;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, aVUserInfo, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), iArr);
            return;
        }
        if (this.f342373j == null) {
            return;
        }
        try {
            j17 = Long.parseLong(aVUserInfo.account);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(f213729r, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j17 = 0;
        }
        if (i3 == 70) {
            com.tencent.qav.log.a.a(f213729r, String.format("onMemberIn uin=%s groupId=%s", aVUserInfo.account, Long.valueOf(j3)));
            if (j17 == this.f342380b) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !this.f213730p) {
                this.f213730p = true;
                F();
                com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 1, new Object[0]);
            }
            QavDef$MultiUserInfo u16 = u(j17);
            if (u16 == null && !z16) {
                u16 = new QavDef$MultiUserInfo();
                u16.mUin = j17;
                u16.mMicOn = true;
                D(u16);
            } else if (z16) {
                u16 = new QavDef$MultiUserInfo();
                com.tencent.qav.a aVar = this.f342373j;
                u16.mUin = aVar.f342347e;
                u16.mOpenId = aVar.f342348f;
                u16.mMicOn = true;
                D(u16);
            }
            B(u16);
            return;
        }
        if (i3 == 71) {
            com.tencent.qav.log.a.a(f213729r, String.format("onMemberOut uin=%s groupId=%s", aVUserInfo.account, Long.valueOf(j3)));
            QavDef$MultiUserInfo G = G(j17);
            if (G != null) {
                C(G);
            }
        }
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onMultiVideoChatMembersInfoChange(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18) {
        long j17;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), strArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (strArr != null && strArr.length != 0) {
            try {
                j17 = Long.parseLong(strArr[0]);
            } catch (NumberFormatException e16) {
                com.tencent.qav.log.a.c(f213729r, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                j17 = 0;
            }
            int i19 = 42;
            if (i3 != 42) {
                if (i3 != 43) {
                    switch (i3) {
                        case 72:
                            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 9, Long.valueOf(j17), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
                            return;
                        case 73:
                            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 10, Long.valueOf(j17), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
                            return;
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 22, Long.valueOf(j3), strArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18));
                            QLog.e(f213729r, 1, "onMultiVideoChatMembersInfoChange id:" + i3 + ", uinList:" + Arrays.toString(strArr));
                            return;
                        default:
                            com.tencent.qav.log.a.d(f213729r, "onMultiVideoChatMembersInfoChange, error. type[" + i3 + "], id[" + j3 + "], type[" + i16 + "], user[" + j17 + "]");
                            return;
                    }
                }
                i19 = 42;
            }
            if (i3 == i19) {
                z16 = true;
            } else {
                z16 = false;
            }
            QavDef$MultiUserInfo u16 = u(j17);
            if (u16 != null) {
                com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 6, u16, Boolean.valueOf(z16), Integer.valueOf(i18));
            }
        }
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onOpenMicFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.onOpenMicFail();
        com.tencent.qav.log.a.a(f213729r, "onOpenMicFail");
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 20, new Object[0]);
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onRemoteVideoDataComeIn(int i3, String str, int i16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(f213729r, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j3 = 0;
        }
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 13, Long.valueOf(j3), Integer.valueOf(i16));
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onSelfAudioVolumeChange(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 8, Integer.valueOf((int) j3));
        }
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onSetMicBySelf(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, j3);
            return;
        }
        super.onSetMicBySelf(j3);
        com.tencent.qav.log.a.a(f213729r, "onSetMicBySelf" + j3);
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 21, Long.valueOf(j3));
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onVideoSrcChange(int i3, int i16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16));
        } else {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 14, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl
    protected void s(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        com.tencent.qav.log.a.a(f213729r, String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", Integer.valueOf(i3), Boolean.valueOf(this.f342375l), Boolean.valueOf(z16)));
        if (i3 == 2) {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 16, Boolean.valueOf(z16));
        } else if (i3 == 1) {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 17, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.a
    public void setAudioRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        try {
        } catch (Exception e16) {
            com.tencent.qav.log.a.c(f213729r, "setAudioRoute fail.", e16);
        }
        if (i3 == 0) {
            this.f342369f.stopBluetoothSco();
            this.f342369f.setBluetoothScoOn(false);
            this.f342369f.setSpeakerphoneOn(false);
            this.f342372i = i3;
        } else if (i3 == 1) {
            this.f342369f.stopBluetoothSco();
            this.f342369f.setBluetoothScoOn(false);
            this.f342369f.setSpeakerphoneOn(true);
            this.f342372i = i3;
        } else {
            if (i3 == 2) {
                this.f342369f.startBluetoothSco();
                this.f342369f.setBluetoothScoOn(true);
                this.f342369f.setSpeakerphoneOn(false);
                this.f342372i = i3;
            }
            this.f342369f.setMode(0);
        }
        this.f342369f.setMode(0);
    }
}
