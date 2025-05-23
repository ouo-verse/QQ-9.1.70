package com.tencent.av.ui.part.base.panel;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends e implements mw.b {
    public a(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void D9(long j3, boolean z16) {
        boolean z17;
        QLog.w("new_AVAIDenoisePart", 1, "onClick_AIDenoise, seq[" + j3 + "]");
        if (z16) {
            z17 = !ea.l2();
            C9(z17);
            ea.L2(z17);
        } else {
            z17 = !ea.k2();
            C9(z17);
            ea.K2(z17);
        }
        if (r.h0() != null) {
            r.h0().v(z17);
            DataReport.b(z17);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E9(long j3) {
        String string;
        SessionInfo f16;
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            QLog.e("new_AVAIDenoisePart", 1, "updateBtn_AIDenoise error: mQavPanel is null");
            return;
        }
        rw.a M = qavPanel.M(m.e.f76027n);
        if (M == null) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w("new_AVAIDenoisePart", 1, "updateBtn_AIDenoise null, seq[" + j3 + "]");
                return;
            }
            return;
        }
        boolean r26 = ea.r2();
        if (r.h0() == null) {
            return;
        }
        Resources resources = getContext().getResources();
        int i3 = n.e().f().f73035i;
        int i16 = R.drawable.n6g;
        int i17 = R.drawable.n6f;
        if (i3 != 1 && n.e().f().f73035i != 2) {
            if (n.e().f().f73035i != 3 && n.e().f().f73035i != 4) {
                string = "";
                M.l(i17);
                M.j(string);
                f16 = n.e().f();
                if (f16.f73035i != 2) {
                    if (!f16.z()) {
                        M.i(false);
                        M.k(true);
                        return;
                    } else {
                        M.i(true);
                        M.k(false);
                        M.n(r26);
                        return;
                    }
                }
                M.n(r26);
                return;
            }
            if (!ea.l2()) {
                i16 = R.drawable.n6f;
            }
            if (ea.l2()) {
                string = resources.getString(R.string.f1780335k);
            } else {
                string = resources.getString(R.string.f17791359);
            }
        } else {
            if (!ea.k2()) {
                i16 = R.drawable.n6f;
            }
            if (ea.k2()) {
                string = resources.getString(R.string.f1780335k);
            } else {
                string = resources.getString(R.string.f17791359);
            }
        }
        i17 = i16;
        M.l(i17);
        M.j(string);
        f16 = n.e().f();
        if (f16.f73035i != 2) {
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.b.class);
    }

    @Override // com.tencent.av.ui.part.base.panel.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.b.class);
    }

    @Override // mw.b
    public void z4() {
        String string;
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            QLog.e("new_AVAIDenoisePart", 1, "setAIDenoiseBtnStatus error: mQavPanel is null");
            return;
        }
        rw.a M = qavPanel.M(m.e.f76027n);
        if (M == null) {
            return;
        }
        View O = this.f76370f.O(M);
        if (r.h0() == null || O == null) {
            return;
        }
        Resources resources = getContext().getResources();
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            if (n.e().f().f73035i != 3 && n.e().f().f73035i != 4) {
                string = "";
            } else if (ea.l2()) {
                string = resources.getString(R.string.f1780335k);
            } else {
                string = resources.getString(R.string.f17791359);
            }
        } else if (ea.k2()) {
            string = resources.getString(R.string.f1780335k);
        } else {
            string = resources.getString(R.string.f17791359);
        }
        O.setContentDescription(string);
        M.j(string);
    }

    private void C9(boolean z16) {
        String string;
        String string2;
        rw.a M;
        int i3 = z16 ? 1073 : 1074;
        if (getContext() == null) {
            return;
        }
        Resources resources = getContext().getResources();
        if (z16) {
            string = resources.getString(R.string.f1780435l);
        } else {
            string = resources.getString(R.string.f1779235_);
        }
        if (z16) {
            string2 = resources.getString(R.string.f1780335k);
        } else {
            string2 = resources.getString(R.string.f17791359);
        }
        cw.e.g(nw.b.b(), i3, 3000L);
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null || (M = qavPanel.M(m.e.f76027n)) == null) {
            return;
        }
        M.j(string2);
        View O = this.f76370f.O(M);
        if (O != null) {
            O.setContentDescription(string2);
            ba.setAccText(O, string);
        }
    }
}
