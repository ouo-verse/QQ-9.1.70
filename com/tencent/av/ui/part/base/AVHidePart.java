package com.tencent.av.ui.part.base;

import android.content.Context;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.q;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class AVHidePart extends com.tencent.av.ui.part.base.panel.e {
    public AVHidePart(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(boolean z16) {
        if (r.h0() == null) {
            QLog.e("AVHidePart", 1, "video controller is null");
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16 != null && f16.f73067q == 1044) {
            DataReport.T(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d("AVHidePart", 1, "onClick HIDE ");
        r.h0().L3("backgroundReason", "3");
        q.a.f74207a = "3";
        DataReport.d();
        if (f16 == null || !f16.I2) {
            return;
        }
        r.h0().J2(true);
        f16.H2 = true;
        QAVControllerForZplan.p().R(f16.I0);
    }

    public void D9(final long j3) {
        SmallScreenActivityPlugin f36;
        SessionInfo f16 = n.e().f();
        nw.b.b().k0(new Object[]{28, f16.f73091w, Boolean.FALSE});
        if (!SmallScreenUtils.w() && f16.f73035i == 2 && f16.N) {
            B9(R.string.daw, 1, getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (f16.w() || f16.x()) {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.AVHidePart.1
                @Override // java.lang.Runnable
                public void run() {
                    if (r.h0() != null) {
                        r.h0().r(n.e().f().f73091w, 233);
                        r.h0().j2(233);
                        r.h0().q(n.e().f().f73091w, 9);
                        QLog.d("AVHidePart", 1, "exit when onBackPressed");
                        nw.b.b().u(j3, 1008);
                    }
                }
            }, 150L);
        }
        if (SmallScreenUtils.w()) {
            Context context = getContext();
            if (!(context instanceof AVActivity) || (f36 = ((AVActivity) context).f3()) == null) {
                return;
            }
            f36.d();
        }
    }

    public void E9() {
        SmallScreenActivityPlugin f36;
        if (r.h0() == null) {
            return;
        }
        if (!SmallScreenUtils.w()) {
            if (n.e().f().N) {
                super.B9(R.string.daw, 1, getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        } else {
            Context context = getContext();
            if (!(context instanceof AVActivity) || (f36 = ((AVActivity) context).f3()) == null) {
                return;
            }
            f36.d();
        }
    }

    public boolean F9() {
        SmallScreenActivityPlugin f36;
        nw.b.b().k0(new Object[]{28, n.e().f().f73091w, Boolean.FALSE});
        if (!SmallScreenUtils.w()) {
            if (n.e().f().f73035i == 4 && n.e().f().N) {
                super.B9(R.string.daw, 1, getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        } else {
            Context context = getContext();
            if ((context instanceof AVActivity) && (f36 = ((AVActivity) context).f3()) != null) {
                f36.d();
            }
        }
        return false;
    }

    public void G9() {
        QLog.d("AVHidePart", 1, "avideo onClick QavPanel.ViewID.HIDE");
        F9();
        ReportController.o(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
        SessionInfo f16 = n.e().f();
        if (f16.N) {
            ReportController.o(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
        }
        if (f16.I2) {
            r.h0().J2(true);
            f16.H2 = true;
            QAVControllerForZplan.p().R(f16.I0);
        }
    }

    public void H9() {
        SmallScreenActivityPlugin f36;
        QLog.d("AVHidePart", 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (n.e().f().f73035i == 4) {
            DataReport.L(n.e().f().O, n.e().f().N, 10);
            if (!SmallScreenUtils.w() && n.e().f().N) {
                B9(R.string.daw, 1, getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
        if (SmallScreenUtils.w() && (f36 = ((AVActivity) getActivity()).f3()) != null) {
            f36.d();
        }
        if (n.e().f().I2) {
            r.h0().J2(true);
            n.e().f().H2 = true;
            QAVControllerForZplan.p().R(n.e().f().I0);
        }
        AVUtil.r("0X800592E", AVUtil.h(), 2, "", "", "", "");
    }
}
