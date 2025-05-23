package com.tencent.adelie.av.qav;

import android.content.Context;
import au.f;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.ui.funchat.record.i;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.channel.d;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends MultiOperatorImpl implements f {

    /* renamed from: p, reason: collision with root package name */
    private i[] f61376p;

    /* renamed from: q, reason: collision with root package name */
    private AsyncExitTask f61377q;

    public void O() {
        QQGAudioCtrl qQGAudioCtrl;
        com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", "startAudioRecv mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m || (qQGAudioCtrl = this.f342381c) == null) {
            return;
        }
        qQGAudioCtrl.startAudioRecv();
    }

    public void P() {
        QQGAudioCtrl qQGAudioCtrl;
        com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", "stopAudioRecv mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m || (qQGAudioCtrl = this.f342381c) == null) {
            return;
        }
        qQGAudioCtrl.stopAudioRecv();
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.a
    public synchronized int e(com.tencent.qav.a aVar) {
        int e16;
        e16 = super.e(aVar);
        if (e16 == 0) {
            AsyncExitTask.f();
        }
        return e16;
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.a
    public synchronized void exitRoom() {
        com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", "exitRoom");
        this.f342373j = null;
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            map.clear();
        }
        au.a.b();
        if (this.f342381c != null) {
            if (this.f61377q == null) {
                this.f61377q = new AsyncExitTask();
            }
            int e16 = this.f61377q.e(m());
            F();
            this.f342375l = false;
            this.f342376m = true;
            if (e16 == 261) {
                QLog.e("MultiOperatorImplForAdelie", 1, "exitRoom REASON_61: cost long time.");
            }
        }
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.b
    public synchronized void l() {
        super.l();
        this.f61376p = null;
        this.f61377q = null;
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaSwitchVideoResult(int i3, long j3, long j16, int i16) {
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 15, Integer.valueOf(i3));
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGeneralRawChannelData(long j3, int i3, int i16, long j16, byte[] bArr) {
        com.tencent.qav.log.a.d("MultiOperatorImplForAdelie", "onGeneralRawChannelData groupId=" + j3 + ", relationType=" + i3 + ", multiAVType=" + i16 + ", msgType=" + j16 + ", detail.size=" + bArr.length);
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 23, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), bArr);
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onMAVMemberInOrOut(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int... iArr) {
        if (this.f342373j == null) {
            return;
        }
        if (i3 != 70) {
            if (i3 == 71) {
                com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", String.format("onMemberOut uin=%s groupId=%s", aVUserInfo.account, Long.valueOf(j3)));
                QavDef$MultiUserInfo G = G(Long.parseLong(aVUserInfo.account));
                if (G != null) {
                    C(G);
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", String.format("onMemberIn uin=%s groupId=%s", aVUserInfo.account, Long.valueOf(j3)));
        boolean z16 = Long.parseLong(aVUserInfo.account) == this.f342380b;
        if (z16) {
            F();
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 1, new Object[0]);
        }
        QavDef$MultiUserInfo u16 = u(Long.parseLong(aVUserInfo.account));
        if (u16 == null && !z16) {
            u16 = new QavDef$MultiUserInfo();
            u16.mUin = Long.parseLong(aVUserInfo.account);
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
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onMultiVideoChatMembersInfoChange(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        String str = strArr[0];
        if (i3 != 42 && i3 != 43) {
            switch (i3) {
                case 72:
                    com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 9, str, Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
                    break;
                case 73:
                    com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 10, str, Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
                    break;
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                    break;
                default:
                    com.tencent.qav.log.a.d("MultiOperatorImplForAdelie", "onMultiVideoChatMembersInfoChange, error. type[" + i3 + "], id[" + j3 + "], type[" + i16 + "], user[" + str + "]");
                    break;
            }
            return;
        }
        boolean z16 = i3 == 42;
        QavDef$MultiUserInfo u16 = u(Long.parseLong(str));
        if (u16 != null) {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 6, u16, Boolean.valueOf(z16), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onRemoteVideoDataComeIn(int i3, String str, int i16) {
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 13, str, Integer.valueOf(i16));
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onSelfAudioVolumeChange(long j3) {
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 8, Integer.valueOf((int) j3));
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onVideoSrcChange(int i3, int i16, long j3, long j16) {
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 13, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16));
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl
    protected void s(int i3, boolean z16) {
        com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", Integer.valueOf(i3), Boolean.valueOf(this.f342375l), Boolean.valueOf(z16)));
        if (i3 == 2) {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 16, Boolean.valueOf(z16));
        } else if (i3 == 1) {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 17, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemberMicChanged(String str, int i3, int i16, boolean z16) {
        boolean z17 = !z16;
        com.tencent.qav.log.a.a("MultiOperatorImplForAdelie", String.format("onMemberMicChanged uin=%s available=%s", str, Boolean.valueOf(z17)));
        QavDef$MultiUserInfo u16 = u(Long.parseLong(str));
        if (u16 != null) {
            u16.mMicOn = !z16;
            A(u16, z17);
        }
    }

    @Override // au.f
    public void f(int i3, i iVar) {
        if (i3 >= 2) {
            return;
        }
        if (this.f61376p == null) {
            this.f61376p = new i[2];
        }
        synchronized (b.class) {
            this.f61376p[i3] = iVar;
        }
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.av.gaudio.b
    public void h(byte[] bArr, int i3, int i16, int i17, int i18) {
        i iVar;
        i iVar2;
        if (i18 == 100) {
            synchronized (b.class) {
                i[] iVarArr = this.f61376p;
                if (iVarArr != null && (iVar2 = iVarArr[0]) != null) {
                    iVar2.onReceiveAudioFrame(bArr, i18, bArr.length);
                }
            }
            return;
        }
        if (i18 == 3 || i18 == 0 || i18 == 1 || i18 == 2 || i18 == 8) {
            synchronized (b.class) {
                i[] iVarArr2 = this.f61376p;
                if (iVarArr2 != null && (iVar = iVarArr2[1]) != null) {
                    iVar.onReceiveAudioFrame(bArr, i18, bArr.length);
                }
            }
        }
    }

    public b(Context context, long j3, d dVar, boolean z16) {
        super(context, j3, dVar, z16, -1, -1, false);
        this.f61376p = null;
        this.f61377q = null;
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOffStageResult(int i3, long j3, long j16, int i16) {
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 12, Boolean.valueOf(i3 == 93), Long.valueOf(j16), Integer.valueOf(i16));
    }

    @Override // com.tencent.qav.controller.multi.b, com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOnStageResult(int i3, long j3, long j16, int i16) {
        com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 11, Boolean.valueOf(i3 == 90 && j3 == 3), Long.valueOf(j16), Integer.valueOf(i16));
    }
}
