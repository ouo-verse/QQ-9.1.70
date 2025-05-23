package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ad;
import com.tencent.avcore.jni.dav.NtrtcRoomCallback;
import com.tencent.mobileqq.debug.api.IQQDebugApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.light.avatar.AvatarAIInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j implements NtrtcRoomCallback {

    /* renamed from: b, reason: collision with root package name */
    private static String f73840b = "NtrtcRoomCallbackImpl";

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.av.utils.o f73841a = new com.tencent.av.utils.o("SuperAvatar", 2000);

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onCommonTips(String str) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onCommonTips. tips[" + str + "]");
        if (!TextUtils.isEmpty(str)) {
            VideoAppInterface.N().k0(new Object[]{526, str});
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onCustomCommand(String str, long j3, long j16, long j17) {
        if (QLog.isColorLevel()) {
            QLog.d(f73840b, 2, "NtrtcRoomCallbackImpl. onCustomCommand. cmd[" + j3 + "], param1[" + j16 + "], param2[" + j17 + "]");
        }
        if (j3 == 200) {
            if (j16 == 1) {
                VideoSocketReconnectReporter.a();
            } else if (j16 == 2) {
                VideoSocketReconnectReporter.b(j17);
            }
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onGroundGlassSwitch(int i3) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onGroundGlassSwitch. state[" + i3 + "]");
        VideoAppInterface.N().k0(new Object[]{42, Integer.valueOf(i3)});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onGroundGlassWaitTime(int i3) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onGroundGlassWaitTime. time[" + i3 + "]");
        VideoAppInterface.N().k0(new Object[]{43, Integer.valueOf(i3)});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onNetLevelChanged(int i3, String str) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onNetLevelChanged. levelInfo[" + i3 + "], tips[" + str + "]");
        VideoAppInterface.N().k0(new Object[]{41, Integer.valueOf(i3), str});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onNotifyBusinessCheckNetworkState() {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onNotifyBusinessCheckNetworkState.");
        r.h0().i();
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerEnableAudio(String str, boolean z16) {
        String str2 = f73840b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("NtrtcRoomCallbackImpl. onPeerEnableAudio. peerUin[");
        sb5.append(str);
        sb5.append("], enable[");
        sb5.append(z16);
        sb5.append("], old enable[");
        sb5.append(!n.e().f().L);
        sb5.append("]");
        QLog.i(str2, 1, sb5.toString());
        if (z16) {
            if (r.h0().v0() && n.e().f().L) {
                n.e().f().L = false;
                VideoAppInterface.N().k0(new Object[]{18});
                return;
            }
            return;
        }
        if (!n.e().f().L) {
            n.e().f().L = true;
            VideoAppInterface.N().k0(new Object[]{17});
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerEnableVideo(String str, boolean z16) {
        SessionInfo f16 = n.e().f();
        long d16 = com.tencent.av.utils.e.d();
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onPeerEnableVideo. peerUin[" + str + "], enable[" + z16 + "], old enable[" + f16.O + "], isOnlyAudio[" + f16.M0 + "]");
        if (z16) {
            if (!TextUtils.isEmpty(str) && str.equals(VideoAppInterface.N().getCurrentAccountUin())) {
                return;
            }
            if (f16.f73039j == 1 && !r.h0().e()) {
                if (QLog.isColorLevel()) {
                    QLog.d(f73840b, 2, "onResumeVideo !canAVShift()");
                    return;
                }
                return;
            } else {
                if (!f16.O) {
                    f16.k0(d16, true);
                    VideoAppInterface.N().k0(new Object[]{16, Long.valueOf(d16)});
                    DataReport.z();
                    if (f16.f73035i == 1) {
                        f16.p0(d16, "onResumeVideo", 2);
                        f16.M0 = false;
                        return;
                    }
                    return;
                }
                return;
            }
        }
        r.h0().J1(str);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerMidiaFileOrVirtualCameraStateChanged(int i3, String str) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onPeerMidiaFileOrVirtualCameraStateChanged. state[" + i3 + "], tips[" + str + "]");
        if (i3 == 0) {
            n.e().f().K0 = false;
        } else if (i3 == 1) {
            n.e().f().K0 = true;
        } else if (i3 == 100) {
            n.e().f().L0 = false;
        } else if (i3 == 101) {
            n.e().f().L0 = true;
        } else {
            n.e().f().K0 = false;
            n.e().f().L0 = false;
        }
        VideoAppInterface.N().k0(new Object[]{27, str});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerStateInfo(String str, int i3) {
        if (!n.e().f().f73081t1) {
            if (QLog.isColorLevel()) {
                QLog.w(f73840b, 2, "not start StartByTerminalSwitch but receive onPeerStateInfo message");
                return;
            }
            return;
        }
        int i16 = 1048575 & i3;
        int i17 = (i3 >> 20) & 1;
        int i18 = (i3 >> 21) & 1;
        if (n.e().f().f73093w1 && n.e().f().f73035i == 1 && r.h0().e()) {
            if (QLog.isColorLevel()) {
                QLog.d(f73840b, 2, "switch start frome video entry, open camera");
            }
            i17 = 1;
        }
        n.e().f().f73104z0 = i16;
        if (QLog.isColorLevel()) {
            QLog.d(f73840b, 2, "NtrtcRoomCallbackImpl. onPeerStateInfo. time:" + i16 + ", isCamreOpen:" + i17 + ", isMicOpen:" + i18);
        }
        VideoAppInterface.N().k0(new Object[]{34, Integer.valueOf(i17), Integer.valueOf(i18)});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerSwitchAV(String str, int i3) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onPeerSwitchAV. peerUin[" + str + "], switchAVType[" + i3 + "]");
        if (n.e() != null && n.e().f() != null && n.e().f().f73091w != null && n.e().f().f73091w.equals(str) && i3 == 1) {
            n.e().f().M0 = false;
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onPeerSysPhoneCalling(boolean z16) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onPeerSysPhoneCalling. isCalling[" + z16 + "]");
        n.e().f().N0 = z16;
        if (z16) {
            DataReport.Q();
        }
        if (ad.h(VideoAppInterface.N().getApp())) {
            return;
        }
        r.h0().K1(false, z16);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onRecvFunChatMsg(String str, int i3, byte[] bArr) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onRecvFunChatMsg. type[" + i3 + "]");
        r.h0().G0().handleFunChatMsg((long) i3, bArr, str);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onRecvSuperAvatarInfo(byte[] bArr, long j3) {
        this.f73841a.c(System.currentTimeMillis(), 0L);
        AvatarAIInfo a16 = com.tencent.av.opengl.effects.b.a(bArr);
        if (a16 != null) {
            if (r.h0().J0() != null) {
                r.h0().J0().p(false, a16, j3);
            }
            if (r.h0().H() != null) {
                r.h0().H().y(false, a16);
            }
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onRecvTransferMsg(byte[] bArr) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onRecvTransferMsg. data[" + bArr + "]");
        VideoAppInterface.N().k0(new Object[]{122, r.h0().G0().receiveTransferMsg(bArr)});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onStateInfo(String str) {
        if (str != null && str.length() != 0) {
            if (com.tencent.av.utils.e.j()) {
                ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).checkVideoDecoderFrameCostTimes(str);
            }
            QLog.isColorLevel();
            if (com.tencent.av.utils.e.f77110b) {
                VideoAppInterface.N().k0(new Object[]{19, str});
            }
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcRoomCallback
    public void onSuperAvatarInputFpsChanged(int i3) {
        QLog.i(f73840b, 1, "NtrtcRoomCallbackImpl. onSuperAvatarInputFpsChanged. fps[" + i3 + "]");
        if (!n.e().f().f73098x2) {
            return;
        }
        n.e().f().D2 = i3;
        r.h0().G3();
    }
}
