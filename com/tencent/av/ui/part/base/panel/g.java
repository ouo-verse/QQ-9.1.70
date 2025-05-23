package com.tencent.av.ui.part.base.panel;

import android.content.Intent;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends e {
    public g(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3) {
        if (r.h0() == null) {
            return;
        }
        DataReport.T(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", n.e().f().f73035i == 1 ? 1 : 2, n.e().f().f73043k == 1 ? 1 : 3, "", "", "", "");
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://zb.vip.qq.com/v2/pages/funcallMall");
        getContext().startActivity(intent);
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.X0(j3, 0, true);
        }
        SessionInfo f16 = n.e().f();
        if (f16 == null || f16.f73067q != 1044) {
            return;
        }
        DataReport.T(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
    }

    public void D9(long j3) {
        rw.a x95 = x9(m.e.f76017d, j3);
        if (x95 == null || r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (!f16.I2 && !f16.J2 && !f16.f73102y2) {
            x95.i(true);
            x95.k(false);
        } else {
            x95.i(false);
            x95.k(true);
        }
        x95.n(true);
    }
}
