package com.tencent.av.ui.part.dav.panel;

import android.view.View;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.panel.e;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends e {
    public c(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3, View view) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null && (qavPanel.v0(1) || this.f76370f.v0(6))) {
            this.f76370f.X0(j3, 0, true);
        }
        if (!((IDoodleApi) QRoute.api(IDoodleApi.class)).isDoodleUsable()) {
            if (((IDoodleApi) QRoute.api(IDoodleApi.class)).getUnableTipResId() != 0) {
                B9(((IDoodleApi) QRoute.api(IDoodleApi.class)).getUnableTipResId(), 0, getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            return;
        }
        ((IDoodleApi) QRoute.api(IDoodleApi.class)).showDoodle(j3, getActivity());
        AVUtil.r("0X800BC0D", AVUtil.h(), 0, "", "", "", "");
    }

    public void D9(long j3) {
        rw.a x95 = x9(m.e.f76026m, j3);
        if (x95 == null || r.h0() == null) {
            return;
        }
        boolean z16 = n.e().f().N;
        x95.i(z16);
        x95.n(z16);
        if (z16) {
            x95.k(!((IDoodleApi) QRoute.api(IDoodleApi.class)).isDoodleUsable());
        }
    }
}
