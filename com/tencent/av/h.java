package com.tencent.av;

import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PerfReporter;
import com.tencent.av.utils.ax;
import com.tencent.avcore.jni.dav.NtrtcAudio;
import com.tencent.avcore.jni.dav.NtrtcAudioCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h implements NtrtcAudioCallback {

    /* renamed from: a, reason: collision with root package name */
    private static String f73838a = "NtrtcAudioCallbackImpl";

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onAudioEngineInstanceIsOccupied() {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onAudioEngineInstanceIsOccupied.");
        if (r.h0().W() != null) {
            r.h0().W().quitRoom(0);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onAudioEngineStartResult(int i3) {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onAudioEngineStartResult. retCode[" + i3 + "]");
        if (i3 == 0) {
            n.e().f().f73101y1 = true;
            if (n.e().f().f73091w != null && n.e().f().f73091w.length() > 0) {
                r.h0().r2(n.e().f().f73091w);
            }
            r.h0().Y2(2048);
            VideoAppInterface.N().k0(new Object[]{38, 2048, Long.valueOf(com.tencent.av.utils.e.d())});
            if (ea.r2()) {
                if ((n.e().f().f73035i == 1 || n.e().f().f73035i == 2) && r.h0().G0() != null) {
                    NtrtcAudio.getInstance().enableAIDenoise(ea.k2());
                }
            }
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onMicStateChanged(int i3) {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onMicStateChanged. state[" + i3 + "]");
        if (i3 == 1) {
            ReportController.o(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, i3, "", "", "", "");
            r.h0().Y2(3);
            VideoAppInterface.N().k0(new Object[]{38, 3, Long.valueOf(com.tencent.av.utils.e.d())});
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onMicZeroEnergy() {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onMicZeroEnergy.");
        r.h0().Y2(4);
        VideoAppInterface.N().k0(new Object[]{38, 4, Long.valueOf(com.tencent.av.utils.e.d())});
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onPlayerStateChanged(int i3) {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onPlayerStateChanged. state[" + i3 + "]");
        if (i3 == 1) {
            ReportController.o(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, i3, "", "", "", "");
            r.h0().Y2(6);
            VideoAppInterface.N().k0(new Object[]{38, 6, Long.valueOf(com.tencent.av.utils.e.d())});
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onRecordData(int i3, byte[] bArr, int i16) {
        if (i3 == 100) {
            if (r.h0().E() != null && r.h0().E()[0] != null) {
                r.h0().E()[0].onReceiveAudioFrame(bArr, i3, i16);
            }
        } else if ((i3 == 3 || i3 == 0 || i3 == 8) && r.h0().E() != null && r.h0().E()[1] != null) {
            r.h0().E()[1].onReceiveAudioFrame(bArr, i3, i16);
        }
        if (com.tencent.av.utils.d.d()) {
            com.tencent.av.utils.d.c().onReceiveAudioFrame(bArr, i3, i16);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onRecvDataState(int i3) {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onRecvDataState. state[" + i3 + "]");
        if (i3 == 0) {
            long d16 = com.tencent.av.utils.e.d();
            PerfReporter.k();
            vv.e b16 = vv.e.b(VideoAppInterface.N());
            b16.d(VideoAppInterface.N().getApp().getApplicationContext(), n.e().f());
            b16.e(VideoAppInterface.N().getApp().getApplicationContext(), n.e().f());
            b16.c(VideoAppInterface.N().getApp().getApplicationContext(), n.e().f());
            if (n.e().f().M0) {
                if (r.h0().G0() != null) {
                    if (-1 == r.h0().G0().switchAudio(n.e().f().f73091w)) {
                        r.h0().M2(false);
                    } else {
                        r.h0().M2(true);
                    }
                }
            } else {
                r.h0().M2(true);
            }
            r.h0().g3(true);
            VideoAppInterface.N().k0(new Object[]{25, Boolean.TRUE, Long.valueOf(d16)});
            if (zv.b.a().f453493c) {
                zv.b.a().f453514n = SystemClock.elapsedRealtime();
                return;
            } else {
                zv.b.a().C = SystemClock.elapsedRealtime();
                return;
            }
        }
        if (i3 == 1) {
            r.h0().g3(true);
            VideoAppInterface.N().k0(new Object[]{24, Boolean.FALSE});
        } else if (i3 == 2) {
            if (!n.e().f().L) {
                VideoAppInterface.N().k0(new Object[]{24, Boolean.TRUE});
            }
            r.h0().g3(false);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onSelfSpeakingWhenMicClosed() {
        QLog.i(f73838a, 1, "NtrtcAudioCallbackImpl. onSelfSpeakingWhenMicClosed.");
        if (VideoAppInterface.N() != null && ax.e()) {
            VideoAppInterface.N().k0(new Object[]{529});
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcAudioCallback
    public void onUpdateSelfSpeakingEnergy(int i3) {
        if (VideoAppInterface.N() == null) {
            return;
        }
        try {
            VideoAppInterface.N().k0(new Object[]{20002, Long.valueOf(i3), 0L, 100L});
        } catch (NullPointerException e16) {
            QLog.d(f73838a, 1, "onUpdateSelfSpeakingEnergy error: " + e16);
        }
    }
}
