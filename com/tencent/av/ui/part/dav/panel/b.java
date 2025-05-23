package com.tencent.av.ui.part.dav.panel;

import android.content.Intent;
import android.net.Uri;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.part.base.panel.e;
import com.tencent.av.utils.DataReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends e {
    public b(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(String str) {
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null) {
            return;
        }
        if (r.h0() == null) {
            QLog.e(this.f76368d, 1, "onClickCallPhone video controller is null");
            return;
        }
        int i3 = n.e().f().f73035i;
        QLog.w(this.f76368d, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i3 + "], PhoneNum[" + com.tencent.av.utils.e.f(n.e().f().B) + "]");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(WebView.SCHEME_TEL);
        sb5.append(n.e().f().B);
        aVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(sb5.toString())));
        DataReport.T(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
        r.h0().r(str, 236);
        r.h0().j2(236);
        r.h0().q(str, 0);
    }
}
