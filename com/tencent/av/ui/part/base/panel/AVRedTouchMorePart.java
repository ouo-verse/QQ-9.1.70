package com.tencent.av.ui.part.base.panel;

import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.af;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mw.j;
import mw.k;

/* loaded from: classes32.dex */
public class AVRedTouchMorePart extends e {

    /* renamed from: h, reason: collision with root package name */
    public RedTouch f76320h;

    public AVRedTouchMorePart(QavPanel qavPanel) {
        super(qavPanel);
        this.f76320h = null;
    }

    private void G9() {
        AVActivity aVActivity;
        final View findViewById;
        final VideoAppInterface b16 = nw.b.b();
        if (b16 == null || (findViewById = (aVActivity = (AVActivity) getActivity()).findViewById(m.l.A)) == null || this.f76320h != null || aVActivity.isDestroyed()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVRedTouchMorePart.1
            @Override // java.lang.Runnable
            public void run() {
                AVRedTouchMorePart aVRedTouchMorePart = AVRedTouchMorePart.this;
                if (aVRedTouchMorePart.f76320h != null) {
                    return;
                }
                aVRedTouchMorePart.f76320h = yv.a.h(b16, findViewById, 1);
                AVRedTouchMorePart.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVRedTouchMorePart.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RedTouch redTouch;
                        if (findViewById.getVisibility() != 8 || (redTouch = AVRedTouchMorePart.this.f76320h) == null) {
                            return;
                        }
                        redTouch.setVisibility(8);
                    }
                });
            }
        }, 16, null, true);
    }

    public void D9(long j3, int i3) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null && qavPanel.v0(i3)) {
            this.f76370f.X0(j3, 0, true);
        } else {
            k kVar = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, getPartRootView(), null);
            kVar.updateBtn(j3, 33554431);
            QavPanel qavPanel2 = this.f76370f;
            if (qavPanel2 != null) {
                qavPanel2.X0(j3, i3, true);
            }
            kVar.updateBtn(j3, 65536);
            ((mw.b) RFWIocAbilityProvider.g().getIocInterface(mw.b.class, getPartRootView(), null)).z4();
        }
        if (((IDoodleApi) QRoute.api(IDoodleApi.class)).isDoodleShow(j3, getActivity())) {
            ((IDoodleApi) QRoute.api(IDoodleApi.class)).hideDoodle(j3, getActivity());
        }
    }

    public void E9() {
        if (this.f76320h == null) {
            G9();
        }
    }

    public void F9(boolean z16) {
        RedTouch redTouch = this.f76320h;
        if (redTouch != null) {
            redTouch.setVisibility(z16 ? 0 : 8);
        }
    }

    public void H9(long j3) {
        int i3;
        int i16;
        if (r.h0() == null || this.f76370f == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16.f73035i != 1 || f16.z()) {
            i3 = 0;
        } else {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_More, !isConnected, seq[" + j3 + "]");
            }
            i3 = 8;
        }
        if (f16.f73060o0 && ((i16 = f16.f73046k2) == 2 || i16 == 1)) {
            i3 = 8;
        }
        QavPanel qavPanel = this.f76370f;
        int i17 = m.l.A;
        int P = qavPanel.P(i17);
        int i18 = af.x() ? 8 : i3;
        this.f76370f.setViewVisibility(i17, i18);
        AVActivity aVActivity = (AVActivity) getActivity();
        if (P != i18 && aVActivity != null) {
            F9(i18 == 0);
            aVActivity.F3(j3, i17, i18);
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.d(this.f76368d, 1, "updateBtn_More, show[" + i18 + "], lastvisibility[" + P + "], seq[" + j3 + "]");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        G9();
    }

    public void C9(long j3, View view) {
        D9(j3, 6);
        ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null)).resetToolBarTimer(j3);
        ((AVActivity) getActivity()).R2(j3);
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.A();
        }
        if (this.f76320h != null) {
            yv.a.b(nw.b.b(), this.f76320h, 1);
            this.f76320h = null;
        }
    }
}
