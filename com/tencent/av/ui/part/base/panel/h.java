package com.tencent.av.ui.part.base.panel;

import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.r;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends e {
    public h(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3, View view) {
        ControlUIObserver.b bVar = new ControlUIObserver.b(view, 2);
        bVar.f74773g = -1;
        QLog.w(this.f76368d, 1, "onClick_VirtualBackground, mEffectBtnID[" + bVar.f74773g + "], seq[" + j3 + "]");
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.X0(j3, 4, true);
        }
        A9(j3, m.e.f76025l);
        AVUtil.r("0X800ADA9", AVUtil.h(), 0, "", "", "", "");
    }

    public void D9(long j3) {
        rw.a x95 = x9(m.e.f76025l, j3);
        if (x95 == null) {
            return;
        }
        boolean D = j.D();
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16.N) {
            x95.k(true);
            x95.i(false);
            x95.n(false);
        } else {
            x95.n(false);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f76368d, 2, "updateBtn_VirtualBackground, visible[false], enable[false], enableAE[" + D + "], localHasVideo[" + f16.N + "]");
        }
    }
}
