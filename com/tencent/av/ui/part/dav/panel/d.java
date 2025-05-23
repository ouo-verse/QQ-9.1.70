package com.tencent.av.ui.part.dav.panel;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.fragment.NTBaseVideoFragment;
import com.tencent.av.ui.fragment.NTMultiVideoBaseFragment;
import com.tencent.av.ui.fragment.NTMultiVideoGroupFragment;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.panel.e;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.at;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends e {
    public d(QavPanel qavPanel) {
        super(qavPanel);
    }

    private void D9() {
        if (this.f76370f == null || QAVHrMeeting.l(n.e().f())) {
            return;
        }
        int Rl = getPartHost() instanceof NTMultiVideoGroupFragment ? ((NTMultiVideoGroupFragment) getPartHost()).Rl() : 0;
        if (Rl != 0) {
            QQToast.makeText(this.f76370f.getContext(), this.f76370f.getResources().getString(Rl), 1).show();
        } else {
            cw.e.n(nw.b.b(), 1032);
        }
    }

    public boolean C9() {
        Context context = getContext();
        if (context == null) {
            return true;
        }
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (QLog.isDevelopLevel()) {
                QLog.e(this.f76368d, 2, "isKeyguardLocked = " + keyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + keyguardManager.isKeyguardSecure());
            }
            if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                if (keyguardManager.isKeyguardSecure()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f76368d, 2, "isKeyguardLocked() = " + e16);
            }
            return QQUtils.k(context);
        }
    }

    public void E9(long j3, boolean z16) {
        SmallScreenActivityPlugin f36;
        VideoAppInterface b16 = nw.b.b();
        if (z16) {
            cw.e.o(b16, 1032, R.string.f171235dd2);
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.AddContactsToDiscuss");
            intent.putExtra("discussUin", Long.toString(r.h0().X()));
            intent.putExtra("notAcceptUserList", r.h0().o0());
            intent.putExtra("notAcceptPhoneList", n.e().f().f73096x0);
            intent.putExtra("selectNotAcceptFlag", false);
            intent.setPackage(b16.getApplication().getPackageName());
            b16.getApp().sendBroadcast(intent);
            r.h0().d3(1);
            if (SmallScreenUtils.w()) {
                Context context = getContext();
                if ((context instanceof AVActivity) && (f36 = ((AVActivity) context).f3()) != null) {
                    f36.c();
                }
            }
        }
        A9(j3, m.e.f76016c);
    }

    public void F9(long j3) {
        SmallScreenActivityPlugin f36;
        if (!H9(j3)) {
            cp.c.d(false);
            D9();
            if (getPartHost() instanceof NTBaseVideoFragment) {
                ((NTBaseVideoFragment) getPartHost()).lk(j3, 33554431);
            }
        } else {
            cp.c.d(true);
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.AddMembersToGroup");
            intent.setPackage(nw.b.b().getApplication().getPackageName());
            r.h0().g0();
            SessionInfo f16 = n.e().f();
            long b16 = f16.b();
            int a16 = f16.a();
            intent.putExtra(AudienceReportConst.ROOM_ID, b16);
            intent.putExtra("room_create_time", a16);
            intent.putExtra("uin", Long.toString(r.h0().X()));
            at.f(intent, j3);
            intent.putParcelableArrayListExtra("memberlist", r.h0().Z());
            com.tencent.av.utils.e.n("ACTION_ADD_MEMBERS_TO_GROUP", intent.getExtras(), true);
            nw.b.b().getApp().sendBroadcast(intent);
            r.h0().d3(1);
            if (SmallScreenUtils.w() && (f36 = ((AVActivity) getActivity()).f3()) != null) {
                f36.c();
            }
        }
        A9(j3, m.e.f76016c);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean H9(long j3) {
        boolean z16;
        SessionInfo f16;
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            QLog.d(this.f76368d, 1, "updateBtnInviteMember error : mQavPanel is null");
            return false;
        }
        rw.a M = qavPanel.M(m.e.f76016c);
        if (M == null) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_InviteMember, null, seq[" + j3 + "]");
            }
            return false;
        }
        if (r.h0() == null) {
            return false;
        }
        SessionInfo f17 = n.e().f();
        char c16 = '\b';
        if (f17.f73067q != 1044 && !f17.f73098x2 && !f17.f73102y2) {
            if (f17.f73035i == 1 && (f17.I2 || f17.J2)) {
                QLog.d(this.f76368d, 1, "updateBtn_InviteMember, in small home enable is false, seq[" + j3 + "]");
                z16 = false;
            } else {
                z16 = true;
            }
            int i3 = f17.f73035i;
            if (i3 == 3 || i3 == 4) {
                if (QAVHrMeeting.l(f17)) {
                    if (com.tencent.av.utils.e.j()) {
                        QLog.w(this.f76368d, 1, "updateBtn_InviteMember, isHrConf, seq[" + j3 + "]");
                    }
                } else if (getPartHost() instanceof NTMultiVideoBaseFragment) {
                    if (((NTMultiVideoBaseFragment) getPartHost()).cl()) {
                        QLog.w(this.f76368d, 1, "updateBtn_InviteMember, isFull, seq[" + j3 + "]");
                        z16 = false;
                        c16 = 0;
                        f16 = n.e().f();
                        if (f16.f73035i != 2) {
                            if (!f16.z()) {
                                M.i(false);
                                M.k(true);
                            } else {
                                M.i(true);
                                M.k(!z16);
                                M.n(c16 == 0);
                            }
                        } else {
                            M.n(c16 == 0);
                            M.i(z16);
                            M.k(!z16);
                        }
                        return z16;
                    }
                    if (f17.f73063p == 17) {
                        z16 = false;
                    }
                }
            }
            if (C9()) {
                if (com.tencent.av.utils.e.j()) {
                    QLog.w(this.f76368d, 1, "updateBtn_InviteMember, isKeyguardLock, seq[" + j3 + "]");
                }
                z16 = false;
                c16 = 0;
                f16 = n.e().f();
                if (f16.f73035i != 2) {
                }
                return z16;
            }
            c16 = 0;
            f16 = n.e().f();
            if (f16.f73035i != 2) {
            }
            return z16;
        }
        z16 = false;
        f16 = n.e().f();
        if (f16.f73035i != 2) {
        }
        return z16;
    }

    public void G9(long j3, boolean z16) {
        SmallScreenActivityPlugin f36;
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "onClick_InviteMember.");
        }
        if (r.h0() != null) {
            DataReport.a();
        }
        Activity activity = getActivity();
        VideoUtil.m(activity, b16, z16);
        if (SmallScreenUtils.w() && (activity instanceof AVActivity) && (f36 = ((AVActivity) activity).f3()) != null) {
            f36.c();
        }
        if (z16) {
            ReportController.o(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
        } else {
            A9(j3, m.e.f76016c);
        }
    }
}
