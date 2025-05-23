package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.av.utils.ba;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.groupvideo.api.IGroupVideoHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.BaseActivity;

/* loaded from: classes3.dex */
public class MultiVideoEnterPageActivity extends BaseActivity {
    long G;
    int I;
    int J;
    int K;
    int L;
    String P;

    /* renamed from: c0, reason: collision with root package name */
    private QQPermission f74925c0;

    /* renamed from: e0, reason: collision with root package name */
    private QavUpdateAvatarViewHelper f74929e0;

    /* renamed from: e, reason: collision with root package name */
    o f74928e = new o();

    /* renamed from: f, reason: collision with root package name */
    MultiVideoEnterPageMembersControlUI[] f74930f = null;

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f74933h = null;

    /* renamed from: i, reason: collision with root package name */
    RelativeLayout f74935i = null;

    /* renamed from: m, reason: collision with root package name */
    MultiMembersAudioUI f74939m = null;
    ProgressBar C = null;
    TextView D = null;
    String E = null;
    String F = null;
    long[] H = null;
    int M = 0;
    int N = 0;
    VideoAppInterface Q = null;
    TimeoutRunnable R = null;
    Runnable S = null;
    Runnable T = null;
    Runnable U = null;
    boolean V = false;
    int W = 0;
    int X = 0;
    int Y = 0;
    long Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    boolean f74923a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    boolean f74924b0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f74927d0 = true;

    /* renamed from: f0, reason: collision with root package name */
    private String f74931f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    com.tencent.av.utils.y f74932g0 = new f();

    /* renamed from: h0, reason: collision with root package name */
    GAudioUIObserver f74934h0 = new j();

    /* renamed from: i0, reason: collision with root package name */
    VideoObserver f74936i0 = new p();

    /* renamed from: j0, reason: collision with root package name */
    final int f74937j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    final int f74938k0 = 1;

    /* renamed from: d, reason: collision with root package name */
    final String f74926d = "MultiVideoEnterPageActivity_" + QQAudioHelper.b();

    /* loaded from: classes3.dex */
    class RefreshDisplayNameRunnable implements Runnable {
        RefreshDisplayNameRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            int i3 = multiVideoEnterPageActivity.W + 1;
            multiVideoEnterPageActivity.W = i3;
            if (multiVideoEnterPageActivity.U != null) {
                if (i3 < 3) {
                    multiVideoEnterPageActivity.Q.M().postDelayed(MultiVideoEnterPageActivity.this.U, 1000L);
                } else {
                    multiVideoEnterPageActivity.Q.M().removeCallbacks(MultiVideoEnterPageActivity.this.U);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class RefreshFaceRunnable implements Runnable {
        RefreshFaceRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr = MultiVideoEnterPageActivity.this.f74930f;
            if (multiVideoEnterPageMembersControlUIArr != null) {
                for (MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI : multiVideoEnterPageMembersControlUIArr) {
                    multiVideoEnterPageMembersControlUI.l();
                }
            }
            MultiMembersAudioUI multiMembersAudioUI = MultiVideoEnterPageActivity.this.f74939m;
            if (multiMembersAudioUI != null) {
                multiMembersAudioUI.o();
            }
            MultiVideoEnterPageActivity.this.Q.M().postDelayed(this, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class RemoveTipsRunnale implements Runnable {
        RemoveTipsRunnale() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(MultiVideoEnterPageActivity.this.f74926d, 2, "RemoveTipsRunnale Run");
            }
            MultiVideoEnterPageActivity.this.H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class TimeoutRunnable implements Runnable {
        TimeoutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.w(MultiVideoEnterPageActivity.this.f74926d, 1, "TimeoutRunnable, mHaveMoreRoom[" + MultiVideoEnterPageActivity.this.V + "]");
            }
            QQToast.makeText(MultiVideoEnterPageActivity.this, R.string.dff, 1).show(MultiVideoEnterPageActivity.super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            if (!multiVideoEnterPageActivity.V) {
                multiVideoEnterPageActivity.r0();
                MultiVideoEnterPageActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DataReport.Y(false, false);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f74941d;

        b(int i3) {
            this.f74941d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            MultiVideoEnterPageActivity.this.s0(this.f74941d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f74947a;

        /* loaded from: classes3.dex */
        class a implements DialogInterface.OnDismissListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnClickListener onClickListener = d.this.f74947a;
                if (onClickListener != null) {
                    onClickListener.onClick(null, 1);
                }
            }
        }

        d(DialogInterface.OnClickListener onClickListener) {
            this.f74947a = onClickListener;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            DialogInterface.OnClickListener onClickListener = this.f74947a;
            if (onClickListener != null) {
                onClickListener.onClick(null, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            DialogInterface.OnClickListener onClickListener = this.f74947a;
            if (onClickListener != null) {
                onClickListener.onClick(null, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
            permissionRequestDialog.setOnDismissListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements ew.b {
        e() {
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            View findViewById = MultiVideoEnterPageActivity.this.findViewById(R.id.f166580m13);
            if (findViewById != null) {
                findViewById.setBackground(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_video", 0, 0, MultiVideoEnterPageActivity.this.E, "", "", "");
            MultiVideoEnterPageActivity.this.B0(2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cp.c.b();
            ReportController.o(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_call", 0, 0, MultiVideoEnterPageActivity.this.E, "", "", "");
            MultiVideoEnterPageActivity.this.B0(10);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MultiVideoEnterPageActivity.this.q0(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes3.dex */
    class j extends GAudioUIObserver {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void L(long j3, boolean z16, int i3) {
            if (MultiVideoEnterPageActivity.this.w0()) {
                return;
            }
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            if (j3 == multiVideoEnterPageActivity.G) {
                if (z16) {
                    multiVideoEnterPageActivity.x0(i3);
                } else if ((i3 == 10 || i3 == 1) && MultiVideoEnterPageActivity.super.isResume()) {
                    MultiVideoEnterPageActivity.this.u0(i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void R() {
            if (!MultiVideoEnterPageActivity.this.w0() && !MultiVideoEnterPageActivity.this.V) {
                super.R();
                ArrayList<com.tencent.av.e> B0 = com.tencent.av.r.h0().B0();
                MultiVideoEnterPageActivity.this.f74939m.m(com.tencent.av.r.h0().n1(B0.size(), B0));
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void S(long j3, ArrayList<com.tencent.av.e> arrayList, int i3, int i16) {
            if (MultiVideoEnterPageActivity.this.w0()) {
                return;
            }
            MultiVideoEnterPageActivity.this.v0(j3, arrayList, i3, i16);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void e(int i3) {
            if (MultiVideoEnterPageActivity.this.w0()) {
                return;
            }
            MultiVideoEnterPageActivity.this.I0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f74956d;

        k(View view) {
            this.f74956d = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (MultiVideoEnterPageActivity.this.w0()) {
                return;
            }
            this.f74956d.setEnabled(false);
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            com.tencent.av.r h06 = com.tencent.av.r.h0();
            MultiVideoEnterPageActivity multiVideoEnterPageActivity2 = MultiVideoEnterPageActivity.this;
            multiVideoEnterPageActivity.Z = h06.c0(multiVideoEnterPageActivity2.K, multiVideoEnterPageActivity2.N, multiVideoEnterPageActivity2.G);
            QLog.w(MultiVideoEnterPageActivity.this.f74926d, 1, "kickOutUsers begin, mGAudioRoomId[" + MultiVideoEnterPageActivity.this.Z + "]");
            com.tencent.av.r h07 = com.tencent.av.r.h0();
            MultiVideoEnterPageActivity multiVideoEnterPageActivity3 = MultiVideoEnterPageActivity.this;
            h07.m1(1, multiVideoEnterPageActivity3.K, multiVideoEnterPageActivity3.N, multiVideoEnterPageActivity3.G);
            ReportController.o(null, "CliOper", "", "", "0X8009E2A", "0X8009E2A", 0, 0, "", "", "", "");
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l implements DialogInterface.OnClickListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m implements ChatActivityUtils.t {
        m() {
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.t
        public void a(int i3, int i16) {
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            multiVideoEnterPageActivity.X = i3;
            multiVideoEnterPageActivity.Y = i16;
            multiVideoEnterPageActivity.B0(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        int f74960d;

        public n(int i3) {
            this.f74960d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16 = this.f74960d;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (QLog.isColorLevel()) {
                        QLog.e(MultiVideoEnterPageActivity.this.f74926d, 2, "DialogInterfaceOnClickListener-->Wrong type.mode=" + this.f74960d);
                    }
                    dialogInterface.dismiss();
                    return;
                }
                dialogInterface.dismiss();
                return;
            }
            MultiVideoEnterPageActivity.this.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            MultiVideoEnterPageActivity.this.sendBroadcast(new Intent("tencent.video.v2g.match_friend.exit_voice_chat"));
            dialogInterface.dismiss();
            com.tencent.av.r.h0().a2(com.tencent.av.n.e().f().S0, com.tencent.av.n.e().f().P0, 81);
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            multiVideoEnterPageActivity.s0(multiVideoEnterPageActivity.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        QUIButton f74962a = null;

        /* renamed from: b, reason: collision with root package name */
        QUIButton f74963b = null;

        /* renamed from: c, reason: collision with root package name */
        RelativeLayout f74964c = null;

        /* renamed from: d, reason: collision with root package name */
        TextView f74965d = null;

        /* renamed from: e, reason: collision with root package name */
        LinearLayout f74966e = null;

        o() {
        }

        void a() {
            this.f74964c = null;
            this.f74965d = null;
            this.f74962a = null;
            this.f74963b = null;
            this.f74966e = null;
        }

        void b(Activity activity) {
            this.f74964c = (RelativeLayout) activity.findViewById(R.id.gau);
            this.f74965d = (TextView) activity.findViewById(R.id.g7s);
            this.f74962a = (QUIButton) activity.findViewById(R.id.g8h);
            this.f74963b = (QUIButton) activity.findViewById(R.id.g8a);
            this.f74966e = (LinearLayout) activity.findViewById(R.id.g8f);
        }

        void c(int i3) {
            RelativeLayout relativeLayout = this.f74964c;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(i3);
            }
            TextView textView = this.f74965d;
            if (textView != null) {
                textView.setVisibility(i3);
            }
            LinearLayout linearLayout = this.f74966e;
            if (linearLayout != null) {
                linearLayout.setVisibility(i3);
            }
            QUIButton qUIButton = this.f74962a;
            if (qUIButton != null) {
                qUIButton.setVisibility(i3);
            }
            QUIButton qUIButton2 = this.f74963b;
            if (qUIButton2 != null && i3 != 0) {
                qUIButton2.setVisibility(i3);
            }
        }
    }

    /* loaded from: classes3.dex */
    class p extends VideoObserver {
        p() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void j(long j3) {
            super.j(j3);
            if (QLog.isColorLevel()) {
                QLog.d(MultiVideoEnterPageActivity.this.f74926d, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:" + j3 + ", mRelationId = " + MultiVideoEnterPageActivity.this.G);
            }
            if (j3 != 0 && j3 == MultiVideoEnterPageActivity.this.G) {
                if (QLog.isColorLevel()) {
                    QLog.d(MultiVideoEnterPageActivity.this.f74926d, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
                }
                MultiVideoEnterPageActivity.this.finish();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void q(boolean z16, long j3, int i3, int i16, int i17, String str) {
            MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI;
            if (com.tencent.av.r.h0() != null) {
                MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
                if (multiVideoEnterPageActivity.Q != null && !multiVideoEnterPageActivity.isDestroyed()) {
                    MultiVideoEnterPageActivity multiVideoEnterPageActivity2 = MultiVideoEnterPageActivity.this;
                    if (j3 != multiVideoEnterPageActivity2.G) {
                        QLog.w(multiVideoEnterPageActivity2.f74926d, 1, "onKickOutResult, ignore");
                        return;
                    }
                    if (z16) {
                        com.tencent.av.r.h0().l0().n(MultiVideoEnterPageActivity.this.Q.getLongAccountUin(), j3, MultiVideoEnterPageActivity.this.Z);
                        MultiVideoEnterPageActivity.this.x0(i16);
                        return;
                    }
                    if (i17 == -5) {
                        if (multiVideoEnterPageActivity2.V) {
                            MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr = multiVideoEnterPageActivity2.f74930f;
                            if (multiVideoEnterPageMembersControlUIArr != null && multiVideoEnterPageMembersControlUIArr.length > 1 && (multiVideoEnterPageMembersControlUI = multiVideoEnterPageMembersControlUIArr[1]) != null) {
                                multiVideoEnterPageMembersControlUI.R.setVisibility(8);
                            }
                        } else {
                            multiVideoEnterPageActivity2.f74928e.f74963b.setVisibility(8);
                        }
                        QQToast.makeText(MultiVideoEnterPageActivity.this, R.string.bos, 1).show(MultiVideoEnterPageActivity.super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        return;
                    }
                    QQToast.makeText(multiVideoEnterPageActivity2, R.string.bor, 1).show(MultiVideoEnterPageActivity.super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return;
                }
            }
            QLog.w(MultiVideoEnterPageActivity.this.f74926d, 1, "onKickOutResult, empty");
        }
    }

    private void C0(int i3, String str) {
        boolean z16;
        if (i3 == 3000 && QAVHrMeeting.n(this.Q.F(this.E))) {
            ChatActivityUtils.s.h(this.f74926d, this.E, new m());
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            B0(10);
        }
    }

    private void F0() {
        VideoAppInterface videoAppInterface = this.Q;
        if (videoAppInterface.F) {
            videoAppInterface.F = false;
        }
    }

    private void J0() {
        String currentAccountUin = this.Q.getCurrentAccountUin();
        ArrayList<com.tencent.av.e> B0 = com.tencent.av.r.h0().B0();
        if (!B0.isEmpty()) {
            currentAccountUin = String.valueOf(B0.get(0).f73701a);
        }
        if (currentAccountUin == this.f74931f0) {
            return;
        }
        this.f74931f0 = currentAccountUin;
        ew.a aVar = new ew.a(1000, currentAccountUin, null, false);
        QavUpdateAvatarViewHelper qavUpdateAvatarViewHelper = new QavUpdateAvatarViewHelper();
        this.f74929e0 = qavUpdateAvatarViewHelper;
        qavUpdateAvatarViewHelper.i(this.Q, aVar, null, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p0(Activity activity, QQPermission qQPermission, DialogInterface.OnClickListener onClickListener, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        ArrayList arrayList;
        if (AppSetting.m() >= 31 && Build.VERSION.SDK_INT >= 31) {
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z16) {
                z27 = com.tencent.av.utils.ai.g(activity);
                z26 = com.tencent.av.utils.ai.i(activity);
                arrayList = new ArrayList();
                if (!z17) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_SCAN);
                }
                if (!z18) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_CONNECT);
                }
                if (!z19) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
                }
                QLog.d(this.f74926d, 1, "checkBluetoothPermission checkScanResult=" + z17 + " checkConnectResult=" + z18 + " checkAdvertiseResult=" + z19 + " size=" + arrayList.size() + " request=" + z16 + " hasRequestBluetooth=" + z26 + " hasBluetoothDevice=" + z27, new Throwable());
                if (!z16 && arrayList.size() > 0 && qQPermission != null && !z26 && z27) {
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    com.tencent.av.utils.ai.k(activity);
                    qQPermission.requestPermissions(strArr, 2, new d(onClickListener));
                    return false;
                }
                if (z16 && onClickListener != null) {
                    onClickListener.onClick(null, 1);
                }
                if (arrayList.size() > 0) {
                    return true;
                }
                return false;
            }
            z26 = true;
        } else {
            z17 = true;
            z18 = true;
            z19 = true;
            z26 = true;
        }
        z27 = false;
        arrayList = new ArrayList();
        if (!z17) {
        }
        if (!z18) {
        }
        if (!z19) {
        }
        QLog.d(this.f74926d, 1, "checkBluetoothPermission checkScanResult=" + z17 + " checkConnectResult=" + z18 + " checkAdvertiseResult=" + z19 + " size=" + arrayList.size() + " request=" + z16 + " hasRequestBluetooth=" + z26 + " hasBluetoothDevice=" + z27, new Throwable());
        if (!z16) {
        }
        if (z16) {
            onClickListener.onClick(null, 1);
        }
        if (arrayList.size() > 0) {
        }
    }

    private boolean t0(int i3) {
        boolean z16;
        if (this.f74925c0 == null) {
            this.f74925c0 = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AV, QQPermissionConstants.Business.SCENE.QQ_AV_ROOM));
        }
        if (this.f74925c0.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean p06 = p0(this, null, null, false);
        if (z16) {
            QLog.d(this.f74926d, 1, "[CheckPermission] audio_record has granted. checkBluetoothResult=" + p06 + " isFirstRequestBluetoothPermission=" + this.f74927d0);
            if (p06 || !this.f74927d0) {
                return true;
            }
            p0(this, this.f74925c0, new b(i3), true);
            this.f74927d0 = false;
            return false;
        }
        if (VideoUtil.c(this)) {
            c cVar = new c(i3);
            QLog.d(this.f74926d, 1, "[CheckPermission] request RECORD_AUDIO permission.");
            this.f74925c0.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, cVar);
        } else {
            QLog.d(this.f74926d, 1, "[CheckPermission] cannot request permission.");
        }
        return false;
    }

    private boolean z0() {
        if (!this.Q.b0()) {
            return false;
        }
        DataReport.Y(false, true);
        if (QLog.isColorLevel()) {
            QLog.d(this.f74926d, 2, "startMultipVideo phone is calling!");
        }
        DialogUtil.createCustomDialog(this, 230, getResources().getString(R.string.dfp), getResources().getString(R.string.d_m), R.string.cancel, R.string.f171151ok, new a(), (DialogInterface.OnClickListener) null).show();
        return true;
    }

    void A0(int i3) {
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, R.string.cgc, 1).show(super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (com.tencent.av.n.e().f().f73043k > 0 && com.tencent.av.n.e().f().f73043k < 7) {
            QQToast.makeText(this, R.string.dkm, 1).show(super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        QLog.w(this.f74926d, 1, "onClickEnterMultiVideoChat, mRelationId[" + this.G + "], mGAudioInRoom[" + com.tencent.av.r.h0().W0() + "], mGAudioGroupId[" + com.tencent.av.r.h0().X() + "], mHaveMoreRoom[" + this.V + "], avtype[" + i3 + "], currentAvtype[" + this.N + "]");
        if ((com.tencent.av.r.h0().W0() && this.G != com.tencent.av.r.h0().X()) || this.Q.L()) {
            E0();
        } else if (t0(i3)) {
            s0(i3);
        }
    }

    void B0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f74926d, 2, "onEnterButtonClick --> AVType = " + i3);
        }
        A0(i3);
        int i16 = this.J;
        if (i16 == 1) {
            if (i3 == 10) {
                ReportController.o(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
                return;
            } else {
                ReportController.o(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i16 == 3000) {
            if (this.M <= 0) {
                ReportController.o(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
            }
        }
    }

    public void BtnOnClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.g8a) {
            q0(view);
            return;
        }
        if (id5 == R.id.g8h) {
            if (z0()) {
                return;
            }
            cp.c.b();
            C0(this.J, this.F);
            return;
        }
        if (id5 == R.id.g_y) {
            F0();
            int i3 = this.J;
            if (i3 == 1) {
                if (this.N == 10) {
                    ReportController.o(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
                }
            } else if (i3 == 3000) {
                ReportController.o(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
            }
            finish();
            super.overridePendingTransition(0, R.anim.f154833da);
        }
    }

    boolean D0() {
        Intent intent = super.getIntent();
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "processExtraData-->can not get intent");
            }
            return false;
        }
        QQAudioHelper.m(this.f74926d + ".processExtraData", intent.getExtras(), true);
        this.f74923a0 = intent.getBooleanExtra("openClass", false);
        this.H = intent.getLongArrayExtra("DiscussUinList");
        this.P = intent.getStringExtra("creator_nick");
        int intExtra = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        this.I = intExtra;
        if (intExtra != 3 && intExtra != 4) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "processExtraData-->get the wrong sessionType,Type=" + this.I);
            }
            return false;
        }
        int intExtra2 = intent.getIntExtra("Type", -1);
        this.L = intExtra2;
        if (intExtra2 != 3) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "processExtraData-->get the wrong GAudioStatus,Type=" + this.L);
            }
            return false;
        }
        this.F = intent.getStringExtra("uin");
        String stringExtra = intent.getStringExtra("GroupId");
        this.E = stringExtra;
        if (stringExtra == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "processExtraData-->can not get the groupuin");
            }
            return false;
        }
        long longValue = Long.valueOf(stringExtra).longValue();
        this.G = longValue;
        if (longValue == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "processExtraData-->can not get the groupuin");
            }
            return false;
        }
        int intExtra3 = intent.getIntExtra("MultiAVType", 0);
        if (QLog.isColorLevel()) {
            QLog.d(this.f74926d, 2, "Get Intent AVType : " + intExtra3);
        }
        this.N = intExtra3;
        int intExtra4 = intent.getIntExtra("uinType", -1);
        this.J = intExtra4;
        if (intExtra4 == 3000) {
            this.K = 2;
        } else if (intExtra4 == 1) {
            this.K = 1;
        } else {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "processExtraData-->can not get uin Type.");
            }
            return false;
        }
        this.V = intent.getBooleanExtra("flag", false);
        return true;
    }

    void E0() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f74926d, 2, "quitGAudioChatDialog");
        }
        n nVar = new n(0);
        n nVar2 = new n(1);
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).showCustomDialog(this, 230, null, super.getResources().getString(R.string.dbj), R.string.icb, R.string.d_d, nVar, nVar2);
    }

    void G0(boolean z16) {
        Bundle bundleExtra;
        MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI;
        if (this.J != 1) {
            return;
        }
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putString("uin", String.valueOf(this.G));
            bundleExtra = this.Q.s0(6, 0, 0, bundle, null);
        } else {
            bundleExtra = getIntent().getBundleExtra("groupInfo");
        }
        if (bundleExtra == null) {
            QLog.w(this.f74926d, 1, "setCloseBtn, rsp is null");
            return;
        }
        boolean z17 = bundleExtra.getBoolean("isAdmin");
        boolean z18 = bundleExtra.getBoolean("isOwner");
        if (1 == QQAudioHelper.c(7)) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.oc8));
            z18 = true;
        }
        if (!z17 && !z18) {
            ViewGroup.LayoutParams layoutParams = this.f74928e.f74963b.getLayoutParams();
            layoutParams.width = ba.getScreenWidth(this) - (BaseAIOUtils.f(16.0f, getResources()) * 2);
            this.f74928e.f74963b.setVisibility(8);
            this.f74928e.f74962a.setLayoutParams(layoutParams);
            return;
        }
        if (this.V) {
            MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr = this.f74930f;
            if (multiVideoEnterPageMembersControlUIArr != null && multiVideoEnterPageMembersControlUIArr.length > 1 && (multiVideoEnterPageMembersControlUI = multiVideoEnterPageMembersControlUIArr[1]) != null) {
                multiVideoEnterPageMembersControlUI.R.setVisibility(0);
                return;
            }
            return;
        }
        int screenWidth = ((ba.getScreenWidth(this) - (BaseAIOUtils.f(16.0f, getResources()) * 2)) - BaseAIOUtils.f(8.0f, getResources())) / 2;
        ViewGroup.LayoutParams layoutParams2 = this.f74928e.f74963b.getLayoutParams();
        layoutParams2.width = screenWidth;
        this.f74928e.f74963b.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f74928e.f74962a.getLayoutParams();
        layoutParams3.width = screenWidth;
        this.f74928e.f74962a.setLayoutParams(layoutParams3);
        this.f74928e.f74963b.setOnTouchListener(new ba.a());
        this.f74928e.f74963b.setVisibility(0);
    }

    void H0() {
        int systemNetwork = NetworkUtil.getSystemNetwork(this);
        if (NetworkUtil.isBluetoothSharedNetwork(this)) {
            systemNetwork = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.e(this.f74926d, 2, "setNetTips,netinfo=" + systemNetwork);
        }
        MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr = this.f74930f;
        if (multiVideoEnterPageMembersControlUIArr != null) {
            for (MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI : multiVideoEnterPageMembersControlUIArr) {
                multiVideoEnterPageMembersControlUI.T.setVisibility(8);
            }
        }
        this.C.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void I0(int i3) {
        int i16;
        MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr;
        if (QLog.isColorLevel()) {
            QLog.d(this.f74926d, 2, "setNetTips-->type=" + i3);
        }
        if (this.S == null) {
            this.S = new RemoveTipsRunnale();
        }
        VideoAppInterface videoAppInterface = this.Q;
        if (videoAppInterface != null && videoAppInterface.M() != null) {
            this.Q.M().post(this.S);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        i16 = R.string.dly;
                    }
                } else {
                    i16 = R.string.f171267dm0;
                }
                multiVideoEnterPageMembersControlUIArr = this.f74930f;
                if (multiVideoEnterPageMembersControlUIArr != null) {
                    for (MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI : multiVideoEnterPageMembersControlUIArr) {
                        if (i16 != -1) {
                            multiVideoEnterPageMembersControlUI.S.setText(i16);
                            multiVideoEnterPageMembersControlUI.T.setVisibility(0);
                        }
                    }
                }
                if (i16 == -1) {
                    this.D.setText(i16);
                    this.C.setVisibility(0);
                    return;
                }
                return;
            }
            this.Q.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.MultiVideoEnterPageActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    if (NetworkUtil.getSystemNetwork(MultiVideoEnterPageActivity.this) == 0) {
                        MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
                        if (!multiVideoEnterPageActivity.V) {
                            multiVideoEnterPageActivity.finish();
                            MultiVideoEnterPageActivity.super.overridePendingTransition(0, R.anim.f154833da);
                            if (com.tencent.av.r.h0() != null) {
                                com.tencent.av.r h06 = com.tencent.av.r.h0();
                                MultiVideoEnterPageActivity multiVideoEnterPageActivity2 = MultiVideoEnterPageActivity.this;
                                h06.B1(multiVideoEnterPageActivity2.K, multiVideoEnterPageActivity2.G, 22, 0);
                            }
                        }
                    }
                }
            }, 1000L);
            i16 = -1;
            multiVideoEnterPageMembersControlUIArr = this.f74930f;
            if (multiVideoEnterPageMembersControlUIArr != null) {
            }
            if (i16 == -1) {
            }
        }
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        F0();
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.requestWindowFeature(1);
        super.onCreate(bundle);
        super.setContentView(m.k.f76053a);
        super.getWindow().addFlags(524288);
        super.getWindow().addFlags(2097152);
        super.getWindow().addFlags(128);
        AVUtil.t(getWindow(), true);
        ImmersiveUtils.setStatusTextColor(false, getWindow());
        AVUtil.u(super.getWindow());
        VideoAppInterface videoAppInterface = (VideoAppInterface) super.getAppRuntime();
        this.Q = videoAppInterface;
        if (videoAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "onCreate-->can not get the VideoAppInterface");
            }
            finish();
            return;
        }
        if (com.tencent.av.r.h0() == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "onCreate-->can not get the VideoController");
            }
            finish();
            return;
        }
        this.Q.addObserver(this.f74934h0);
        this.Q.addObserver(this.f74936i0);
        if (!D0()) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74926d, 2, "can not processExtraData");
            }
            finish();
            return;
        }
        this.R = new TimeoutRunnable();
        this.Q.M().postDelayed(this.R, 15000L);
        y0();
        ReportController.o(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.E, "", "", "");
        if (this.U == null) {
            this.U = new RefreshDisplayNameRunnable();
        }
        this.Q.M().post(this.U);
        cp.c.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.Q.deleteObserver(this.f74934h0);
        this.Q.deleteObserver(this.f74936i0);
        this.Q.M().removeCallbacks(this.R);
        this.Q.M().removeCallbacks(this.S);
        this.Q.M().removeCallbacks(this.T);
        this.Q.M().removeCallbacks(this.U);
        if (com.tencent.av.r.h0() != null) {
            com.tencent.av.r.h0().f3(false);
        }
        this.U = null;
        this.T = null;
        this.S = null;
        this.R = null;
        this.f74928e.a();
        AVUtil.d(this);
        this.D = null;
        this.C = null;
        this.f74939m = null;
        QavUpdateAvatarViewHelper qavUpdateAvatarViewHelper = this.f74929e0;
        if (qavUpdateAvatarViewHelper != null) {
            qavUpdateAvatarViewHelper.d(this.Q.getCurrentAccountUin());
            this.f74929e0 = null;
        }
        this.f74931f0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.tencent.av.r.h0() != null) {
            u0(this.N);
        }
        if (this.T == null) {
            this.T = new RefreshFaceRunnable();
        } else {
            this.Q.M().removeCallbacks(this.T);
        }
        this.Q.M().postDelayed(this.T, 2000L);
    }

    void q0(View view) {
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, R.string.cgc, 1).show(super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", String.valueOf(this.G));
        Bundle s06 = this.Q.s0(6, 0, 0, bundle, null);
        if (s06 == null) {
            QLog.w(this.f74926d, 1, "closeGAudio, rsp is null");
            view.setVisibility(8);
            return;
        }
        boolean z16 = s06.getBoolean("isAdmin");
        boolean z17 = s06.getBoolean("isOwner");
        if (1 == QQAudioHelper.c(7)) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.f172210oc3));
            z17 = true;
        }
        if (!z16 && !z17) {
            QLog.w(this.f74926d, 1, "closeGAudio, \u6ca1\u6709\u6743\u9650");
            view.setVisibility(8);
            QQToast.makeText(super.getApplicationContext(), R.string.bot, 1).show();
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8009E29", "0X8009E29", 0, 0, "", "", "", "");
            ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).showCustomDialog(this, 230, getResources().getString(R.string.db5), getResources().getString(R.string.boq), R.string.d_2, R.string.idk, new k(view), new l());
        }
    }

    void r0() {
        Intent intent = new Intent();
        intent.setAction("tencent.av.v2q.MultiVideo");
        intent.putExtra("type", 25);
        intent.putExtra("relationId", this.G);
        intent.putExtra("openClass", this.f74923a0);
        intent.putExtra("relationType", this.K);
        intent.putExtra("MultiAVType", this.N);
        intent.putExtra("reason", 5);
        intent.putExtra("from", "MultiVideoEnterPageActivity");
        intent.setPackage(this.Q.getApp().getPackageName());
        super.sendBroadcast(intent);
    }

    @TargetApi(9)
    void s0(int i3) {
        Intent intent;
        if (i3 == 0) {
            i3 = com.tencent.av.n.e().f().f73063p;
        }
        if (this.J == 3000 && !this.V) {
            i3 = 1;
        }
        if (i3 == 2) {
            intent = new Intent(this, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(IGroupVideoHelper.API_ENTER_GROUP_VIDEO));
        } else {
            intent = new Intent(this, (Class<?>) AVActivity.class);
        }
        intent.addFlags(262144);
        intent.addFlags(268435456);
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("GroupId", String.valueOf(this.G));
        intent.putExtra("Type", 1);
        intent.putExtra("DiscussUinList", this.H);
        intent.putExtra("MultiAVType", i3);
        intent.putExtra("uin", String.valueOf(this.G));
        intent.putExtra("uinType", this.J);
        intent.putExtra("ConfAppID", this.X);
        intent.putExtra("MeetingConfID", this.Y);
        super.startActivity(intent);
        finish();
        if (com.tencent.av.r.h0() != null) {
            com.tencent.av.r.h0().B2(com.tencent.av.n.b(this.K, String.valueOf(this.G), new int[0]), this.I, false, false, false);
        }
        if (i3 == 2 && com.tencent.av.r.h0() != null) {
            com.tencent.av.r.h0().x(1010);
        }
    }

    void u0(int i3) {
        if (this.V) {
            com.tencent.av.r.h0().d0(this.K, this.G, 10);
            com.tencent.av.r.h0().d0(this.K, this.G, 2);
        } else if (!com.tencent.av.r.h0().d0(this.K, this.G, i3)) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.oc5), 1).show(super.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            finish();
        }
    }

    void v0(long j3, ArrayList<com.tencent.av.e> arrayList, int i3, int i16) {
        MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr;
        if (arrayList == null) {
            QLog.w(this.f74926d, 1, "onUserListALLUpdate, simpleData is null, flag[" + this.V + "]");
            if (!this.V) {
                r0();
                finish();
                return;
            }
            return;
        }
        if (i3 != 2 && i3 != 10 && i3 != 12) {
            this.M = i16;
        } else {
            this.M = arrayList.size();
        }
        if (this.M == 0) {
            if (this.V) {
                MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr2 = this.f74930f;
                if (multiVideoEnterPageMembersControlUIArr2 != null && multiVideoEnterPageMembersControlUIArr2.length == 2) {
                    if (i3 == 2) {
                        multiVideoEnterPageMembersControlUIArr2[0].S.setVisibility(0);
                        this.f74930f[0].S.setText(R.string.dfi);
                        this.f74930f[0].T.setVisibility(8);
                    } else if (i3 == 10) {
                        multiVideoEnterPageMembersControlUIArr2[1].S.setVisibility(0);
                        this.f74930f[1].S.setText(R.string.dfj);
                        this.f74930f[1].T.setVisibility(8);
                    }
                    this.f74928e.f74962a.setText(R.string.dc7);
                    return;
                }
                return;
            }
            r0();
            finish();
            return;
        }
        if (i3 == 10 && (multiVideoEnterPageMembersControlUIArr = this.f74930f) != null && multiVideoEnterPageMembersControlUIArr.length > 1) {
            multiVideoEnterPageMembersControlUIArr[1].T.setVisibility(0);
            this.f74930f[1].setVisibility(0);
            this.f74930f[1].j(arrayList);
            if (this.V) {
                this.f74930f[1].S.setVisibility(8);
                this.f74930f[1].T.setVisibility(8);
                MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI = this.f74930f[0];
                if (multiVideoEnterPageMembersControlUI != null) {
                    multiVideoEnterPageMembersControlUI.U.setVisibility(0);
                }
            }
            G0(true);
        } else {
            MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr3 = this.f74930f;
            if (multiVideoEnterPageMembersControlUIArr3 != null && multiVideoEnterPageMembersControlUIArr3.length > 0) {
                multiVideoEnterPageMembersControlUIArr3[0].T.setVisibility(0);
                this.f74930f[0].setVisibility(0);
                this.f74930f[0].j(arrayList);
                if (this.V) {
                    this.f74930f[0].S.setVisibility(8);
                    this.f74930f[0].T.setVisibility(8);
                }
            }
        }
        this.C.setVisibility(0);
        this.f74939m.setVisibility(0);
        this.f74939m.m(com.tencent.av.r.h0().n1(arrayList.size(), arrayList));
        this.f74928e.f74965d.setText(String.format(super.getResources().getString(R.string.dfg), Integer.valueOf(this.M)));
        H0();
        J0();
        this.Q.M().removeCallbacks(this.R);
    }

    public boolean w0() {
        if (super.isDestroyed() || isFinishing()) {
            return true;
        }
        return false;
    }

    void x0(int i3) {
        if (this.V) {
            MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr = this.f74930f;
            if (multiVideoEnterPageMembersControlUIArr != null && multiVideoEnterPageMembersControlUIArr.length == 2 && i3 == 10) {
                multiVideoEnterPageMembersControlUIArr[1].setVisibility(4);
                MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI = this.f74930f[0];
                if (multiVideoEnterPageMembersControlUI != null) {
                    multiVideoEnterPageMembersControlUI.U.setVisibility(8);
                }
                r0();
                return;
            }
            return;
        }
        r0();
        finish();
    }

    void y0() {
        if (ThemeUtil.isInNightMode(this.Q) && this.f74924b0) {
            findViewById(R.id.f166580m13).setBackgroundColor(Color.parseColor("#181818"));
            Drawable drawable = getResources().getDrawable(R.drawable.heb);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f74935i = (RelativeLayout) findViewById(R.id.f30270nw);
        this.D = (TextView) findViewById(R.id.g8g);
        MultiMembersAudioUI multiMembersAudioUI = (MultiMembersAudioUI) findViewById(R.id.bxr);
        this.f74939m = multiMembersAudioUI;
        multiMembersAudioUI.setIsEnterpage(true);
        this.f74939m.i(this.G, this.K, true);
        this.f74939m.setOnItemClickListener(this.f74932g0);
        J0();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.g8e);
        this.C = progressBar;
        progressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
        this.C.setVisibility(0);
        this.f74933h = (LinearLayout) super.findViewById(R.id.bxq);
        this.f74928e.b(this);
        if (ThemeUtil.isInNightMode(this.Q) && this.f74924b0) {
            this.f74928e.f74965d.setTextColor(Color.parseColor("#757575"));
            this.D.setTextColor(Color.parseColor("#A8A8A8"));
            this.f74928e.f74963b.setTextColor(Color.parseColor("#737373"));
            this.f74928e.f74963b.setBackgroundDrawable(getResources().getDrawable(R.drawable.hec));
            this.f74928e.f74962a.setTextColor(Color.parseColor("#FFFFFF"));
            this.f74928e.f74962a.setBackgroundDrawable(getResources().getDrawable(R.drawable.hed));
        }
        if (com.tencent.av.r.h0() != null) {
            if (this.V) {
                this.f74928e.c(4);
                MultiVideoEnterPageMembersControlUI[] multiVideoEnterPageMembersControlUIArr = new MultiVideoEnterPageMembersControlUI[2];
                this.f74930f = multiVideoEnterPageMembersControlUIArr;
                multiVideoEnterPageMembersControlUIArr[0] = new MultiVideoEnterPageMembersControlUI(this);
                this.f74933h.addView(this.f74930f[0], new LinearLayout.LayoutParams(-1, -1, 1.0f));
                this.f74930f[0].i(this.G, this.K, true);
                this.f74930f[0].o(MultiVideoEnterPageMembersControlUI.V);
                MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI = this.f74930f[0];
                multiVideoEnterPageMembersControlUI.J = true;
                multiVideoEnterPageMembersControlUI.U.setVisibility(0);
                this.f74930f[0].setLowHeightMode();
                this.f74930f[0].Q.setOnClickListener(new g());
                this.f74930f[1] = new MultiVideoEnterPageMembersControlUI(this);
                this.f74933h.addView(this.f74930f[1], new LinearLayout.LayoutParams(-1, -1, 1.0f));
                this.f74930f[1].i(this.G, this.K, true);
                this.f74930f[1].o(MultiVideoEnterPageMembersControlUI.W);
                MultiVideoEnterPageMembersControlUI multiVideoEnterPageMembersControlUI2 = this.f74930f[1];
                multiVideoEnterPageMembersControlUI2.J = true;
                multiVideoEnterPageMembersControlUI2.Q.setOnClickListener(new h());
                this.f74930f[1].R.setOnClickListener(new i());
            } else {
                this.f74928e.c(0);
                this.f74928e.f74962a.setOnTouchListener(new ba.a());
            }
            G0(false);
            if (this.J == 1 && this.N == 2) {
                ba.setAccText(this.f74928e.f74962a, getResources().getString(R.string.bou), this.N);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements com.tencent.av.utils.y {
        f() {
        }

        private void c() {
            boolean z16;
            if (!com.tencent.av.n.e().f().f73037i1 && !com.tencent.av.n.e().f().f73041j1) {
                z16 = false;
            } else {
                z16 = true;
            }
            long j3 = com.tencent.av.n.e().f().P0;
            if (j3 <= 0) {
                j3 = MultiVideoEnterPageActivity.this.G;
            }
            VideoMsgTools.y(MultiVideoEnterPageActivity.this, String.valueOf(j3), z16, false, MultiVideoEnterPageActivity.this.K);
        }

        @Override // com.tencent.av.utils.y
        public void b(long j3, int i3, int i16, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(MultiVideoEnterPageActivity.this.f74926d, 2, "MultiVideoMembersClickListener , Uin = " + j3 + " , videoScr = " + i3 + " , isNeedRequest " + z16 + " , positon = " + i16);
            }
            if (i16 == 7 && z16) {
                c();
            }
        }

        @Override // com.tencent.av.utils.y
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f74943a;

        /* loaded from: classes3.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                c cVar = c.this;
                MultiVideoEnterPageActivity.this.s0(cVar.f74943a);
            }
        }

        c(int i3) {
            this.f74943a = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.d(MultiVideoEnterPageActivity.this.f74926d, 1, "[CheckPermission] onAllGranted.");
            MultiVideoEnterPageActivity multiVideoEnterPageActivity = MultiVideoEnterPageActivity.this;
            multiVideoEnterPageActivity.p0(multiVideoEnterPageActivity, multiVideoEnterPageActivity.f74925c0, new a(), true);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            QLog.d(MultiVideoEnterPageActivity.this.f74926d, 1, "[CheckPermission] onDeniedWithoutShowDlg.");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            QLog.d(MultiVideoEnterPageActivity.this.f74926d, 1, "[CheckPermission] onDialogShow.");
            super.onDialogShow(permissionRequestDialog, list);
            permissionRequestDialog.setOnDismissListener(new b());
        }

        /* loaded from: classes3.dex */
        class b implements DialogInterface.OnDismissListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }
    }
}
