package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.avcore.jni.data.DavCommonParamParser;
import com.tencent.avcore.jni.dav.NtrtcSession;
import com.tencent.avcore.jni.dav.NtrtcSessionCallback;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcSessionCallbackImpl implements NtrtcSessionCallback {

    /* renamed from: a, reason: collision with root package name */
    private static String f72832a = "NtrtcSessionCallbackImpl";

    private void b(String str, String str2) {
        boolean z16;
        n.e().f().n0("onAcceptedVideo", 3);
        SessionInfo f16 = n.e().f();
        String r16 = f16.r("onReceivePeerRelaySvrInfo");
        boolean z17 = true;
        if (com.tencent.avcore.rtc.node.report.utils.c.a(str2) && !str2.equalsIgnoreCase(r16)) {
            if (!f16.G) {
                com.tencent.avcore.rtc.node.report.utils.b.f(!f16.f73087v, r16, str2);
            } else {
                RtcNodeReportReceiverHelper.f(r16, str2);
            }
            f16.v0("onReceivePeerRelaySvrInfo", str2);
            z16 = true;
        } else {
            str2 = r16;
            z16 = false;
        }
        if (!f16.G) {
            if (!z16 || f16.f73087v) {
                z17 = false;
            }
            com.tencent.avcore.rtc.node.report.utils.b.h(z17, str2);
            return;
        }
        RtcNodeReportReceiverHelper.h(str2);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onAnotherTerminalHaveProcessedInvitation(String str, boolean z16, long j3, long j16) {
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onAnotherTerminalHaveProcessedInvitation. peerUin[" + str + "], isAccept[" + z16 + "], roomId[" + j3 + "], serverTimestamp[" + j16 + "]");
        if (z16) {
            r.h0().s3(true);
            r.h0().r(str, 206);
            r.h0().j2(206);
            r.h0().q(str, 7);
            return;
        }
        r.h0().r(str, 207);
        r.h0().j2(207);
        r.h0().q(str, 7);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onAvsdkHaveAutoAcceptedInvitation(final String str, int i3) {
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onAvsdkHaveAutoAcceptedInvitation. peerUin[" + str + "], accountType[" + i3 + "]");
        if (r.h0().D() != null) {
            r.h0().D().post(new Runnable() { // from class: com.tencent.av.NtrtcSessionCallbackImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    SessionInfo f16 = n.e().f();
                    if (!f16.D() && r.h0().G0() != null && TextUtils.equals(str, f16.f73091w)) {
                        long b16 = f16.b();
                        long chatRoomId = r.h0().G0().getChatRoomId(f16.f73091w);
                        QLog.i(NtrtcSessionCallbackImpl.f72832a, 1, "onAvsdkHaveAutoAcceptedInvitation, from[" + b16 + "], to[" + chatRoomId + "]");
                        f16.d(chatRoomId);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onChannelReadyResult(String str, int i3, long j3, boolean z16, boolean z17, String str2) {
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onChannelReadyResult. peerUin[" + str + "], retCode[" + i3 + "], roomId[" + j3 + "], isSwitchTerminal[" + z16 + "], peerSwitchTerminal[" + z17 + "], traceId[" + str2 + "]");
        if (i3 != 0) {
            if (n.e().g(str) != null && !TextUtils.isEmpty(str2)) {
                com.tencent.avcore.rtc.node.report.utils.b.c(i3, str2);
                return;
            }
            return;
        }
        if (z16) {
            r.h0().Q1(str, j3);
            return;
        }
        b(str, str2);
        if (com.tencent.av.utils.d.d()) {
            com.tencent.av.utils.d.c().j(r.h0().G0(), null);
        }
        r.h0().v1(str, j3);
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onCloseSession(String str, int i3, long j3, byte[] bArr, int i16, String str2, boolean z16) {
        boolean z17;
        String str3 = f72832a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("NtrtcSessionCallbackImpl. onCloseSession. peerUin[");
        sb5.append(str);
        sb5.append("], reason[");
        sb5.append(i3);
        sb5.append("], errCode[");
        sb5.append(j3);
        sb5.append("], buffer[");
        if (bArr != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("], operationCode[");
        sb5.append(i16);
        sb5.append("], traceId[");
        sb5.append(str2);
        sb5.append("], isUserEventExited[");
        sb5.append(z16);
        sb5.append("]");
        QLog.i(str3, 1, sb5.toString());
        com.tencent.av.business.manager.report.a.c(i3, j3, 0L, String.valueOf(i16));
        if (i3 == 13) {
            VideoAppInterface.N().k0(new Object[]{20});
        } else {
            r.h0().x1(str, i3, j3, bArr, i16, str2);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onInvitationReached(String str, int i3, int i16, String str2) {
        int i17;
        final long d16 = com.tencent.av.utils.e.d();
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onInvitationReached. peerUin[" + str + "], peerState[" + i3 + "], subState[" + i16 + "], subStateWording[" + str2 + "], old subState[" + n.e().f().f73076s0 + "], mStartRing[" + r.h0().D0() + "], seq[" + d16 + "]");
        n.e().f().f73080t0 = null;
        if (n.e().f() != null) {
            if (0 == n.e().f().f73076s0) {
                if (i16 != 0) {
                    if (1 == i16) {
                        n.e().f().f73076s0 = 1L;
                        if (!TextUtils.isEmpty(str2)) {
                            n.e().f().f73080t0 = str2;
                            if (QLog.isColorLevel()) {
                                i17 = 2;
                                QLog.d(f72832a, 2, "onInviteReached :" + n.e().f().f73080t0);
                            } else {
                                i17 = 2;
                            }
                            if (VideoAppInterface.N() != null) {
                                VideoAppInterface N = VideoAppInterface.N();
                                Object[] objArr = new Object[i17];
                                objArr[0] = 400;
                                objArr[1] = n.e().f().f73080t0;
                                N.k0(objArr);
                            }
                        }
                    } else if (2 == i16) {
                        n.e().f().f73076s0 = 2L;
                        if (!TextUtils.isEmpty(str2)) {
                            n.e().f().f73080t0 = str2;
                            return;
                        }
                        return;
                    }
                }
            } else if (1 == n.e().f().f73076s0) {
                if (i16 == 0) {
                    n.e().f().f73076s0 = 0L;
                    return;
                } else {
                    if (1 == i16) {
                        return;
                    }
                    if (2 == i16) {
                        n.e().f().f73076s0 = 0L;
                        r.h0().P1(d16);
                        return;
                    }
                }
            }
        }
        if (n.e().f() != null && n.e().f().z()) {
            QLog.w(f72832a, 1, "onInviteReached, isConnected");
            return;
        }
        int i18 = 524288 & i3;
        if (i18 > 0 && r.h0().O0()) {
            if (QLog.isColorLevel()) {
                QLog.d(f72832a, 2, "onInviteReached :has get phone state");
                return;
            }
            return;
        }
        if (i18 == 0) {
            r.h0().i3(true);
        }
        n.e().f().f73008c0 = 0;
        if ((65536 & i3) > 0) {
            int i19 = 262144 & i3;
            n.e().f().Z = 131072 & i3;
            n.e().f().f73000a0 = i19;
            if (QLog.isColorLevel()) {
                QLog.d(f72832a, 2, "onInviteReached pcOnLine:" + n.e().f().Z + " # phoneOnLine = " + n.e().f().f73000a0);
            }
            if ((1048576 & i3) > 0 && i19 > 0) {
                if ((i3 & 65535 & 1) > 0) {
                    n.e().f().f73008c0 = 1;
                }
                if (r.h0().D0() != null) {
                    if (VideoAppInterface.N() != null) {
                        VideoAppInterface.N().M().removeCallbacks(r.h0().D0());
                    }
                    r.h0().m3(null);
                }
                if (VideoAppInterface.N() != null) {
                    if (n.e().f() != null && n.e().f().f73076s0 == 1 && !TextUtils.isEmpty(n.e().f().f73080t0)) {
                        VideoAppInterface.N().k0(new Object[]{30, str, n.e().f().f73080t0});
                    } else {
                        VideoAppInterface.N().k0(new Object[]{30, str});
                    }
                }
                if (!n.e().f().f73081t1) {
                    r.h0().z3(d16);
                }
            } else {
                int i26 = i3 & 65535;
                if ((i26 & 2) > 0) {
                    n.e().f().f73008c0 = 2;
                } else if ((i26 & 4) > 0) {
                    n.e().f().f73008c0 = 3;
                    DataReport.T(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
                } else if ((i26 & 8) > 0) {
                    n.e().f().f73008c0 = 4;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f72832a, 2, "onInviteReached low 16bit value is" + i26);
                }
            }
            n.e().f().W = true;
            return;
        }
        n.e().f().Z = 0;
        n.e().f().f73000a0 = 0;
        if (QLog.isColorLevel()) {
            QLog.d(f72832a, 2, "pc and phone both not online");
        }
        if (r.h0().D0() != null) {
            if (VideoAppInterface.N() != null) {
                VideoAppInterface.N().M().removeCallbacks(r.h0().D0());
            }
            r.h0().m3(null);
        }
        r.h0().F2(true);
        n.e().f().W = false;
        r.h0().r(n.e().f().f73091w, 210);
        r.h0().j2(210);
        r.h0().e3(new Runnable() { // from class: com.tencent.av.NtrtcSessionCallbackImpl.1
            @Override // java.lang.Runnable
            public void run() {
                r.h0().w1(d16, n.e().f().f73091w, 12, false);
            }
        });
        if (r.h0().p0() != null && VideoAppInterface.N() != null) {
            VideoAppInterface.N().M().postDelayed(r.h0().p0(), 2000L);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onNotifyAnotherTerminalChatingState(String str, long j3, int i3) {
        int i16;
        long d16 = com.tencent.av.utils.e.d();
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onNotifyAnotherTerminalChatingState. peerUin[" + str + "], roomId[" + j3 + "], type[" + i3 + "]");
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            if (i3 != 1) {
                if (i3 != 2) {
                    i16 = 0;
                } else {
                    i16 = 1;
                }
            } else {
                i16 = 2;
            }
            SessionInfo i17 = n.e().i(n.b(3, str, new int[0]));
            if (i17 != null) {
                i17.p0(d16, "onNotifyAnotherTerminalChatingState", i16);
            }
            if (i16 != 0 && !TextUtils.isEmpty(n.e().f().f73091w) && (!n.e().f().f73091w.equals(str) || n.e().f().f73035i == 0)) {
                NtrtcSession.getInstance().sendQueryRoomInfoRequest(j3, Long.valueOf(str).longValue());
                QLog.d(f72832a, 1, "onNotifyAnotherTerminalChatingState sendQueryRoomInfoRequest");
            }
            if (r.h0() != null) {
                r.h0().v2(0, str, j3, i16);
            }
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onPeerSwitchTerminal(String str, boolean z16, int i3, int i16, long j3, String str2) {
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onPeerSwitchTerminal. peerUin[" + str + "], isSuccess[" + z16 + "], peerTerminalType[" + i3 + "], peerSdkVersion[" + i16 + "], roomId[" + j3 + "], traceId[" + str2 + "]");
        if (!z16) {
            r.h0().j("onPeerSwitchTerminalFail", n.e().f());
            if (VideoAppInterface.N() != null) {
                VideoAppInterface.N().k0(new Object[]{33, str, Boolean.FALSE});
                return;
            }
            return;
        }
        if (VideoAppInterface.N() != null) {
            VideoAppInterface.N().k0(new Object[]{33, str, Boolean.TRUE});
        }
        n.e().f().f73085u1 = true;
        SessionInfo d16 = n.e().d(str);
        if (d16 != null) {
            d16.h0(i16);
            d16.i0(i3);
            d16.d(j3);
        }
        r.h0().j("onPeerSwitchTerminal", n.e().f());
        if (VideoAppInterface.N() != null && d16 != null && d16.f73102y2 && ax.a.c(VideoAppInterface.N())) {
            VideoAppInterface.N().k0(new Object[]{530, d16.f73091w, Boolean.FALSE, "", 2});
        }
        if (VideoAppInterface.N() != null && d16 != null) {
            String r16 = d16.r("onPeerSwitchTerminal");
            if (com.tencent.avcore.rtc.node.report.utils.c.a(str2) && !str2.equalsIgnoreCase(r16)) {
                d16.v0("onPeerSwitchTerminal", str2);
                if (d16.G) {
                    RtcNodeReportReceiverHelper.g(r16, str2);
                } else {
                    d16.I = true;
                    com.tencent.avcore.rtc.node.report.utils.b.g(r16, str2);
                }
            }
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onPeerSwitchToMulti(String str) {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onPeerSwitchToMulti. peerUin[" + str + "]");
        int i3 = f16.f73035i;
        if (i3 == 3 || i3 == 4 || TextUtils.isEmpty(str) || !str.equalsIgnoreCase(f16.f73091w)) {
            return;
        }
        r.h0().r3(true);
        if (!f16.G()) {
            r.h0().V1(d16, R.raw.qav_gaudio_join, 1, null);
        }
        f16.u0("onPeerSwitchToMulti", AVUtil.i(f16.f73067q));
        f16.P0 = 0L;
        f16.t0("onPeerSwitchToMulti", 11);
        VideoAppInterface.N().k0(new Object[]{101, Long.valueOf(d16)});
        r.h0().t3();
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onPeerSwitchToScreenShare(String str) {
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onPeerSwitchToScreenShare. peerUin[" + str + "]");
        ScreenShareCtrl y06 = r.h0().y0();
        if (y06 != null) {
            y06.h(str);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onProcessInvitationResult(String str, int i3, String str2) {
        QLog.i(f72832a, 1, "NtrtcSessionCallbackImpl. onProcessInvitationResult. peerUin[" + str + "], retCode[" + i3 + "], traceId[" + str2 + "]");
        if (i3 != 0) {
            RtcNodeReportReceiverHelper.d(i3 + 4, str2);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcSessionCallback
    public void onRecvInvitation(String str, boolean z16, int i3, long j3, long j16, int i16, int i17, byte[] bArr, byte[] bArr2) {
        boolean z17;
        int i18;
        String str2 = f72832a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("NtrtcSessionCallbackImpl. onRecvInvitation. peerUin[");
        sb5.append(str);
        sb5.append("], onlyAudio[");
        sb5.append(z16);
        sb5.append("], uinType[");
        sb5.append(i3);
        sb5.append("], extraUin[");
        sb5.append(j3);
        sb5.append("], bindID[");
        sb5.append(j16);
        sb5.append("], bindType[");
        sb5.append(i16);
        sb5.append("], subServiceType[");
        sb5.append(i17);
        sb5.append("], sign[");
        boolean z18 = false;
        if (bArr != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("], commonParam[");
        if (bArr2 != null) {
            z18 = true;
        }
        sb5.append(z18);
        sb5.append("]");
        QLog.i(str2, 1, sb5.toString());
        if (i17 == 3124) {
            i18 = 26;
        } else {
            i18 = i3;
        }
        String str3 = null;
        if (i18 != 0 && i18 != 12 && i18 != 19 && i18 != 27 && i18 != 29) {
            switch (i18) {
                case 8:
                case 9:
                    str3 = String.valueOf(j3);
                    break;
            }
        }
        r.h0().M1(i18, str, str3, bArr, z16, Long.toString(j16), i16, i17, DavCommonParamParser.parseBufferToCommonParam(bArr2));
    }
}
