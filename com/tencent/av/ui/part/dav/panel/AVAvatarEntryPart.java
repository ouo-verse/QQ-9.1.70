package com.tencent.av.ui.part.dav.panel;

import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.panel.e;
import com.tencent.av.utils.DataReport;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;
import mw.h;

/* loaded from: classes32.dex */
public class AVAvatarEntryPart extends e {

    /* renamed from: h, reason: collision with root package name */
    private long f76372h;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DataReport.T(null, "dc00898", "", "", "0X800C437", "0X800C437", 0, 0, "", "", "", "");
            AVAvatarEntryPart.this.K9(true);
            DataReport.T(null, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "4", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements QQPermissionCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f76377d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f76378e;

        b(boolean z16, long j3) {
            this.f76377d = z16;
            this.f76378e = j3;
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            h hVar;
            QLog.w("AVAvatarEntryPart", 1, "switchZplanAvatar, deny, seq[" + this.f76378e + "]");
            if (AVAvatarEntryPart.this.getContext() == null || (hVar = (h) RFWIocAbilityProvider.g().getIocInterface(h.class, AVAvatarEntryPart.this.getPartRootView(), null)) == null) {
                return;
            }
            hVar.N8(this.f76378e, AVAvatarEntryPart.this.getContext().getString(R.string.f17754349), AVAvatarEntryPart.this.getContext().getString(R.string.del));
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            QLog.w("AVAvatarEntryPart", 1, "switchZplanAvatar, grant");
            if (r.h0() != null) {
                r.h0().u2(this.f76377d, 640, 480, "");
            }
        }
    }

    public AVAvatarEntryPart(QavPanel qavPanel) {
        super(qavPanel);
        this.f76372h = -1L;
    }

    private boolean D9(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.f76372h + j3) {
            return false;
        }
        this.f76372h = currentTimeMillis;
        return true;
    }

    private void E9() {
        cw.e.c(nw.b.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9(View view, String str) {
        if (getActivity() == null || getActivity().isFinishing() || !((mw.c) RFWIocAbilityProvider.g().getIocInterface(mw.c.class, getPartRootView(), null)).g2(2, view, R.string.f1785336x, 15)) {
            return;
        }
        ea.O2(str, true);
    }

    public void J9() {
        QavPanel qavPanel;
        final View h16;
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null) {
            return;
        }
        final String currentAccountUin = b16.getCurrentAccountUin();
        if (ea.h2(currentAccountUin) || (qavPanel = this.f76370f) == null || (h16 = qavPanel.h1(m.l.H)) == null || h16.getVisibility() != 0) {
            return;
        }
        h16.post(new Runnable() { // from class: com.tencent.av.ui.part.dav.panel.a
            @Override // java.lang.Runnable
            public final void run() {
                AVAvatarEntryPart.this.F9(h16, currentAccountUin);
            }
        });
    }

    public void K9(boolean z16) {
        SessionInfo f16;
        if (r.h0() == null || (f16 = n.e().f()) == null) {
            return;
        }
        if (z16 != f16.f73098x2) {
            r.h0().M0(z16, true);
        }
        if (z16) {
            long d16 = com.tencent.av.utils.e.d();
            b bVar = new b(z16, d16);
            h hVar = (h) RFWIocAbilityProvider.g().getIocInterface(h.class, getPartRootView(), null);
            if (hVar == null || !hVar.f1(d16, QQPermissionConstants.Permission.CAMERA, null, bVar)) {
                return;
            }
            r.h0().u2(z16, 640, 480, "");
            return;
        }
        r.h0().u2(z16, 640, 480, "");
    }

    public void M9() {
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null) {
            return;
        }
        String currentAccountUin = b16.getCurrentAccountUin();
        if (ea.i2(currentAccountUin)) {
            return;
        }
        DataReport.T(null, "dc00898", "", "", "0X800C436", "0X800C436", 0, 0, "", "", "", "");
        cw.e.j(b16, 3029, new a());
        ea.P2(currentAccountUin, true);
    }

    public void G9() {
        String str;
        if (D9(1000L)) {
            if (r.h0() != null) {
                SessionInfo f16 = n.e().f();
                if (f16 != null && !f16.R2) {
                    f16.R2 = true;
                    if (f16.P()) {
                        str = "3";
                    } else {
                        str = "2";
                    }
                    DataReport.T(null, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, str, "", "", "");
                }
                ((mw.c) RFWIocAbilityProvider.g().getIocInterface(mw.c.class, getPartRootView(), null)).Y0(f16 != null && f16.P());
            }
            E9();
            if (AVAvatarResMgr.v().k()) {
                K9(true);
            } else {
                AVAvatarResMgr.v().F(new AVAvatarResMgr.c() { // from class: com.tencent.av.ui.part.dav.panel.AVAvatarEntryPart.1
                    @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
                    public void onRequestFinish(final boolean z16) {
                        QLog.i("AVAvatarEntryPart", 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z16);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.av.ui.part.dav.panel.AVAvatarEntryPart.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str2;
                                SessionInfo f17;
                                if (z16) {
                                    if ((r.h0() == null || (f17 = n.e().f()) == null) ? false : f17.P()) {
                                        str2 = "3";
                                    } else {
                                        str2 = "2";
                                    }
                                    DataReport.T(null, "dc00898", "", "", "0X800C45A", "0X800C45A", 0, 0, str2, "1", "", "");
                                    AVAvatarEntryPart.this.B9(R.string.f1786837b, 1, BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                    return;
                                }
                                AVAvatarEntryPart.this.K9(true);
                            }
                        });
                    }
                }, 3000);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H9() {
        SessionInfo f16;
        AVActivity aVActivity;
        boolean z16;
        String str;
        if (this.f76370f == null || r.h0() == null || (f16 = n.e().f()) == null || (aVActivity = (AVActivity) getActivity()) == null || aVActivity.isDestroyed()) {
            return;
        }
        boolean z17 = true;
        if (!f16.z()) {
            cw.e.n(nw.b.b(), 3030);
        } else if (!f16.f73102y2) {
            cw.e.n(nw.b.b(), 3031);
        } else if (r.h0().U0()) {
            z16 = true;
            if (!z16) {
                str = "1";
            } else {
                str = "2";
            }
            DataReport.T(null, "dc00898", "", "", "0X800C43D", "0X800C43D", 0, 0, str, "", "", "");
            if (z16) {
                return;
            }
            if (aVActivity.s3()) {
                aVActivity.J3(false);
                VideoLayerUI videoLayerUI = aVActivity.J0;
                if (videoLayerUI == null || (!videoLayerUI.Z && f16.f73102y2)) {
                    z17 = false;
                }
                aVActivity.changeAvatarLayout(false, z17);
                return;
            }
            aVActivity.e4();
            aVActivity.changeAvatarLayout(true, false);
            return;
        }
        z16 = false;
        if (!z16) {
        }
        DataReport.T(null, "dc00898", "", "", "0X800C43D", "0X800C43D", 0, 0, str, "", "", "");
        if (z16) {
        }
    }

    public void I9() {
        if (D9(1000L)) {
            K9(false);
        }
    }

    public void L9(long j3) {
        String str;
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isDestroyed() || this.f76370f == null) {
            return;
        }
        if (r.h0() == null) {
            QLog.e("AVAvatarEntryPart", 2, "onVideoClose-->VideoController.getInstance() is null, Why???");
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16 == null) {
            return;
        }
        boolean z16 = f16.f73098x2;
        boolean z17 = f16.z();
        boolean c16 = ax.a.c(nw.b.b());
        boolean z18 = f16.E2 && !z17;
        if (!z16) {
            QavPanel qavPanel = this.f76370f;
            int i3 = m.l.H;
            int P = qavPanel.P(i3);
            this.f76370f.setViewEnable(i3, c16 && !z18);
            this.f76370f.setViewVisibility(i3, (!c16 || z18) ? 8 : 0);
            this.f76370f.setViewVisibility(m.l.f76057c, 0);
            this.f76370f.setViewVisibility(m.l.J, 8);
            J9();
            if (P == 0 || !c16 || z18) {
                return;
            }
            if (f16.P()) {
                str = "2";
            } else {
                str = "1";
            }
            DataReport.T(null, "dc00898", "", "", "0X800C434", "0X800C434", 0, 0, str, "", "", "");
            return;
        }
        QavPanel qavPanel2 = this.f76370f;
        int i16 = m.l.J;
        int P2 = qavPanel2.P(i16);
        this.f76370f.setViewVisibility(m.l.f76057c, 8);
        this.f76370f.setViewVisibility(i16, (!c16 || z18) ? 8 : 0);
        if (P2 == 0 || !c16 || z18) {
            return;
        }
        DataReport.T(null, "dc00898", "", "", "0X800C439", "0X800C439", 0, 0, "", "", "", "");
    }
}
