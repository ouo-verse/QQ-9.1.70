package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.DataReport;
import com.tencent.avcore.jni.dav.NtrtcVideoCallback;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k implements NtrtcVideoCallback {

    /* renamed from: a, reason: collision with root package name */
    private static String f73842a = "NtrtcVideoCallbackImpl";

    @Override // com.tencent.avcore.jni.dav.NtrtcVideoCallback
    public void onRecvFirstFrame() {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        QLog.i(f73842a, 1, "NtrtcVideoCallbackImpl. onRecvFirstFrame. peerUin[" + f16.f73091w + "], extraUin[" + f16.f73103z + "], remoteHasVideo[" + f16.O + "], seq[" + d16 + "]");
        if (f16.f73039j == 1 && !r.h0().e()) {
            AVCoreLog.printAllUserLog(f73842a, "onNeedShowPeerVideo, !canAVShift()");
            return;
        }
        if (!f16.O) {
            f16.k0(d16, true);
            VideoAppInterface.N().k0(new Object[]{16, Long.valueOf(d16)});
            VideoAppInterface.N().k0(new Object[]{29});
            DataReport.z();
            if (f16.f73035i == 1) {
                f16.p0(d16, "onNeedShowPeerVideo", 2);
                f16.M0 = false;
            }
        } else {
            VideoAppInterface.N().k0(new Object[]{29});
        }
        if (!f16.N && !f16.O) {
            r.h0().w2(1);
        } else {
            r.h0().w2(2);
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcVideoCallback
    public void onRequestUpdateCamera(int i3) {
        QLog.i(f73842a, 1, "NtrtcVideoCallbackImpl. onRequestUpdateCamera. fps[" + i3 + "]");
        r.h0().y1(i3);
    }
}
