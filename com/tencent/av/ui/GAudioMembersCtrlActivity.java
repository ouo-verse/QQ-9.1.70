package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AVUtil;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GAudioMembersCtrlActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private TextView f74783a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f74784b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f74785c0;

    /* renamed from: d0, reason: collision with root package name */
    private PinnedDividerListView f74786d0;

    /* renamed from: e0, reason: collision with root package name */
    VideoAppInterface f74787e0;

    /* renamed from: f0, reason: collision with root package name */
    j f74788f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<com.tencent.av.e> f74789g0;

    /* renamed from: i0, reason: collision with root package name */
    private Dialog f74791i0;

    /* renamed from: h0, reason: collision with root package name */
    long f74790h0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    private Runnable f74792j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f74793k0 = true;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f74794l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    boolean f74795m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private View.OnTouchListener f74796n0 = new a();

    /* renamed from: o0, reason: collision with root package name */
    private InviteMemberObserver f74797o0 = new InviteMemberObserver() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.2
        @Override // com.tencent.av.app.InviteMemberObserver
        protected void c(long j3, long j16, ArrayList<com.tencent.av.e> arrayList) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GAudioMembersCtrlActivity.this.f74789g0 != null && GAudioMembersCtrlActivity.this.f74789g0.size() != 0) {
                        GAudioMembersCtrlActivity.this.V2();
                    } else {
                        QLog.d("GAudioMembersCtrlActivity", 1, "mInviteMemberInfoChange null");
                    }
                }
            });
        }
    };

    /* renamed from: p0, reason: collision with root package name */
    private GAudioUIObserver f74798p0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.7
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void F(long j3, long j16, boolean z16, boolean z17) {
            super.F(j3, j16, z16, z17);
            GAudioMembersCtrlActivity gAudioMembersCtrlActivity = GAudioMembersCtrlActivity.this;
            if (gAudioMembersCtrlActivity.f74790h0 != j3) {
                if (QLog.isColorLevel()) {
                    QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + j3 + " ,mGroupId = " + GAudioMembersCtrlActivity.this.f74790h0 + " ,isQQUser = " + z17);
                    return;
                }
                return;
            }
            gAudioMembersCtrlActivity.c3(j16, 0, z16, 70);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void G(long j3, long j16, boolean z16, boolean z17) {
            if (GAudioMembersCtrlActivity.this.f74790h0 != j3) {
                if (QLog.isColorLevel()) {
                    QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + j3 + " ,mGroupId = " + GAudioMembersCtrlActivity.this.f74790h0 + " ,isQQUser = " + z16);
                    return;
                }
                return;
            }
            super.G(j3, j16, z16, z17);
            GAudioMembersCtrlActivity.this.c3(j16, 1, true, 71);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void I(long j3, boolean z16, boolean z17, int i3) {
            int i16;
            super.I(j3, z16, z17, i3);
            if (z16) {
                i16 = 42;
            } else {
                i16 = 43;
            }
            GAudioMembersCtrlActivity.this.c3(j3, 2, z17, i16);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void P(long j3, boolean z16) {
            GAudioMembersCtrlActivity.this.f74788f0.g(j3, z16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void R() {
            super.R();
            if (QLog.isColorLevel()) {
                QLog.d("GAudioMembersCtrlActivity", 2, "onUpdatePstnInfo --> Start");
            }
            GAudioMembersCtrlActivity.super.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.7.1
                @Override // java.lang.Runnable
                public void run() {
                    GAudioMembersCtrlActivity.this.V2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void i(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("GAudioMembersCtrlActivity", 2, "onDestroyUI");
            }
            GAudioMembersCtrlActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void p(final long j3, final int i3, final int i16, final boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioMemberMicChanged-->uin=" + j3 + ",isMicOff=" + z16);
            }
            GAudioMembersCtrlActivity.super.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.7.3
                @Override // java.lang.Runnable
                public void run() {
                    GAudioMembersCtrlActivity.this.f74788f0.j(j3, i3, i16, z16);
                }
            });
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void r(long j3, boolean z16, boolean z17) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioRoomMicModeChanged-->uin=" + j3 + ",isRoomMicOff=" + z16);
            }
            GAudioMembersCtrlActivity.super.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.7.2
                @Override // java.lang.Runnable
                public void run() {
                    GAudioMembersCtrlActivity.this.b3();
                }
            });
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void s(final ArrayList<AVUserInfo> arrayList) {
            GAudioMembersCtrlActivity.super.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.GAudioMembersCtrlActivity.7.4
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    float f16;
                    String str2;
                    TextPaint paint = new TextView(GAudioMembersCtrlActivity.super.getApplicationContext()).getPaint();
                    String qqStr = HardCodeUtil.qqStr(R.string.mzo);
                    float f17 = GAudioMembersCtrlActivity.super.getResources().getDisplayMetrics().widthPixels;
                    float measureText = paint.measureText(qqStr);
                    StringBuilder sb5 = new StringBuilder();
                    int size = arrayList.size();
                    int i3 = 2;
                    int i16 = 0;
                    if (size == 1) {
                        float c16 = (f17 - com.tencent.mobileqq.util.x.c(GAudioMembersCtrlActivity.super.getApplicationContext(), 60.0f)) - measureText;
                        if (c16 <= 0.0f) {
                            c16 = GAudioMembersCtrlActivity.super.getResources().getDimensionPixelSize(R.dimen.f158942t1);
                        }
                        AVUserInfo aVUserInfo = (AVUserInfo) arrayList.get(0);
                        String U = com.tencent.av.r.h0().U(String.valueOf(aVUserInfo.account), String.valueOf(com.tencent.av.n.e().f().P0), 1);
                        if (TextUtils.isEmpty(U)) {
                            U = String.valueOf(aVUserInfo.account);
                        }
                        com.tencent.av.utils.n.a(sb5, U, paint, c16);
                    } else {
                        float measureText2 = paint.measureText("\u7b4999\u4eba" + qqStr);
                        float measureText3 = paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        float c17 = ((f17 - ((float) com.tencent.mobileqq.util.x.c(GAudioMembersCtrlActivity.super.getApplicationContext(), 60.0f))) - measureText2) - measureText3;
                        if (c17 <= 0.0f) {
                            c17 = GAudioMembersCtrlActivity.super.getResources().getDimensionPixelSize(R.dimen.f158942t1);
                        }
                        float measureText4 = paint.measureText("\u3001");
                        int i17 = 0;
                        boolean z16 = false;
                        while (i17 < i3) {
                            int i18 = i16;
                            while (i18 < size) {
                                AVUserInfo aVUserInfo2 = (AVUserInfo) arrayList.get(i18);
                                str = qqStr;
                                f16 = f17;
                                String U2 = com.tencent.av.r.h0().U(String.valueOf(aVUserInfo2.account), String.valueOf(com.tencent.av.n.e().f().P0), 1);
                                if (TextUtils.isEmpty(U2)) {
                                    U2 = String.valueOf(aVUserInfo2.account);
                                }
                                float b16 = com.tencent.av.utils.n.b(sb5, U2, paint, c17);
                                if (2.0f * measureText4 < b16 && i18 < size - 1) {
                                    sb5.append("\u3001");
                                    i18++;
                                    c17 = b16;
                                    f17 = f16;
                                    qqStr = str;
                                } else {
                                    if (i18 == 0 && b16 == c17 && !TextUtils.isEmpty(U2)) {
                                        com.tencent.av.utils.n.b(sb5, U2, paint, GAudioMembersCtrlActivity.super.getResources().getDimensionPixelSize(R.dimen.f158942t1));
                                    }
                                    if (measureText3 > b16) {
                                        sb5.append("...\u7b49");
                                        sb5.append(size);
                                        sb5.append("\u4eba");
                                    }
                                    c17 = b16;
                                    if (measureText3 < c17 && !z16) {
                                        sb5.delete(0, sb5.length());
                                        c17 = (f16 - com.tencent.mobileqq.util.x.c(GAudioMembersCtrlActivity.super.getApplicationContext(), 60.0f)) - measureText;
                                        i17++;
                                        i16 = 0;
                                        f17 = f16;
                                        qqStr = str;
                                        i3 = 2;
                                        z16 = true;
                                    } else {
                                        str2 = str;
                                        break;
                                    }
                                }
                            }
                            str = qqStr;
                            f16 = f17;
                            if (measureText3 < c17) {
                            }
                            str2 = str;
                            break;
                        }
                    }
                    str2 = qqStr;
                    sb5.append(str2);
                    QQToast.makeText(GAudioMembersCtrlActivity.this, sb5.toString(), 1).show();
                    if (QLog.isColorLevel()) {
                        QLog.d("GAudioMembersCtrlActivity", 2, sb5.toString());
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void x(long j3, long j16, boolean z16) {
            GAudioMembersCtrlActivity.this.finish();
        }
    };

    /* renamed from: q0, reason: collision with root package name */
    private BroadcastReceiver f74799q0 = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class RefreshFaceRunnable implements Runnable {
        RefreshFaceRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = GAudioMembersCtrlActivity.this.f74788f0;
            if (jVar != null) {
                jVar.i();
            }
            GAudioMembersCtrlActivity.this.f74787e0.M().postDelayed(this, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class RefreshUIRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f74812d;

        /* renamed from: e, reason: collision with root package name */
        int f74813e;

        /* renamed from: f, reason: collision with root package name */
        boolean f74814f;

        /* renamed from: h, reason: collision with root package name */
        int f74815h;

        public RefreshUIRunnable(int i3, long j3, boolean z16, int i16) {
            this.f74812d = j3;
            this.f74813e = i3;
            this.f74814f = z16;
            this.f74815h = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            GAudioMembersCtrlActivity.this.U2(this.f74813e, this.f74812d, this.f74814f, this.f74815h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GAudioMembersCtrlActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f74819d;

        d(ActionSheet actionSheet) {
            this.f74819d = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (com.tencent.av.n.e().f().W0) {
                if (com.tencent.av.n.e().f().f73067q == 1) {
                    ReportController.o(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
                } else if (com.tencent.av.n.e().f().f73067q == 3000) {
                    ReportController.o(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
                }
            } else if (com.tencent.av.n.e().f().f73067q == 1) {
                ReportController.o(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
            } else if (com.tencent.av.n.e().f().f73067q == 3000) {
                ReportController.o(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
            }
            boolean z16 = !com.tencent.av.n.e().f().W0;
            com.tencent.av.r.h0().j3(z16);
            com.tencent.av.n.e().f().l0("OnClick", z16);
            GAudioMembersCtrlActivity.this.b3();
            GAudioMembersCtrlActivity.this.T2();
            try {
                this.f74819d.dismiss();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GAudioMembersCtrlActivity.this.T2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(intent.getPackage()) && intent.getPackage().equals(GAudioMembersCtrlActivity.this.f74787e0.getApp().getPackageName())) {
                if (action.equals("tencent.av.v2q.StopVideoChat")) {
                    int intExtra = intent.getIntExtra("stopReason3rd", -1);
                    long longExtra = intent.getLongExtra("groupId", -1L);
                    if (intExtra == 1 && GAudioMembersCtrlActivity.this.f74790h0 == longExtra) {
                        if (QLog.isColorLevel()) {
                            QLog.d("GAudioMembersCtrlActivity", 2, "ACTION_STOP_VIDEO_CHAT");
                        }
                        GAudioMembersCtrlActivity.this.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GAudioMembersCtrlActivity", 2, "receive broadcast from wrong package:" + intent.getPackage() + ",action:" + action);
            }
        }
    }

    private void W2(long j3, boolean z16) {
        j jVar = this.f74788f0;
        if (jVar != null) {
            jVar.d(j3, z16);
        }
    }

    private void Y2(int i3) {
        int i16;
        if (this.f74783a0 != null) {
            if (this.f74793k0) {
                i16 = R.string.mzm;
            } else {
                i16 = R.string.mzl;
            }
            this.f74783a0.setText(String.format(HardCodeUtil.qqStr(i16), Integer.valueOf(i3)));
        }
    }

    private void Z2() {
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
        }
        if (com.tencent.av.r.h0() != null && !this.f74795m0) {
            if (this.f74794l0) {
                this.f74789g0 = com.tencent.av.r.h0().n1(com.tencent.av.r.h0().Y().size(), com.tencent.av.r.h0().u3());
            } else {
                this.f74789g0 = (ArrayList) com.tencent.av.r.h0().B0().clone();
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
        }
        Y2(this.f74789g0.size());
    }

    private void d3() {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
        }
        T2();
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this);
        createMenuSheet.setForceNightMode(true);
        View inflate = super.getLayoutInflater().inflate(R.layout.f168488xm, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.g89);
        textView.setTextColor(Color.parseColor("#909094"));
        inflate.setBackgroundColor(Color.parseColor("#242628"));
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        createMenuSheet.addView(inflate);
        View view = new View(this);
        view.setBackgroundColor(Color.parseColor("#1AFFFFFF"));
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, BaseAIOUtils.f(1.0f, getResources())));
        createMenuSheet.addView(view);
        View inflate2 = super.getLayoutInflater().inflate(R.layout.action_sheet_common_button, (ViewGroup) null);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.action_sheet_button);
        inflate2.setId(0);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(452984831));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(-14408152));
        inflate2.setBackground(stateListDrawable);
        boolean v3 = com.tencent.av.utils.af.v();
        if (com.tencent.av.n.e().f().W0) {
            textView2.setText(super.getString(R.string.dbq));
            textView2.setTextColor(super.getResources().getColor(R.color.action_sheet_button_red));
            if (v3) {
                i16 = R.string.vu6;
            } else {
                i16 = R.string.vu7;
            }
            textView.setText(super.getString(i16));
        } else {
            textView2.setText(super.getString(R.string.dbs));
            textView2.setTextColor(Color.parseColor("#0066CC"));
            if (v3) {
                i3 = R.string.vu8;
            } else {
                i3 = R.string.vu9;
            }
            textView.setText(super.getString(i3));
        }
        createMenuSheet.addView(inflate2);
        createMenuSheet.addCancelButton(super.getResources().getString(R.string.f170647xd));
        inflate2.setOnClickListener(new d(createMenuSheet));
        createMenuSheet.setOnDismissListener(new e());
        createMenuSheet.setCanceledOnTouchOutside(true);
        this.f74791i0 = createMenuSheet;
        try {
            createMenuSheet.show();
        } catch (Exception unused) {
        }
    }

    @TargetApi(14)
    private void initViews() {
        View view;
        RelativeLayout relativeLayout = (RelativeLayout) super.findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            relativeLayout.setFitsSystemWindows(true);
        }
        this.f74783a0 = (TextView) super.findViewById(R.id.ivTitleName);
        this.f74784b0 = super.findViewById(R.id.dsf);
        this.f74786d0 = (PinnedDividerListView) super.findViewById(R.id.f167018k05);
        TextView textView = (TextView) super.findViewById(R.id.ga9);
        this.f74785c0 = textView;
        textView.setOnClickListener(this);
        this.f74785c0.setOnTouchListener(this.f74796n0);
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
        super.findViewById(R.id.jo9).setBackgroundColor(-16777216);
        super.findViewById(R.id.lzi).setBackgroundColor(Color.parseColor("#000000"));
        ((TextView) super.findViewById(R.id.ivTitleBtnLeft)).setBackgroundDrawable(getResources().getDrawable(R.drawable.qui_qav_gaudio_member_btn_back));
        this.f74783a0.setTextColor(Color.parseColor("#A8A8A8"));
        this.f74785c0.setTextColor(Color.parseColor("#A8A8A8"));
        if (this.f74793k0) {
            view = super.getLayoutInflater().inflate(R.layout.f168492xq, (ViewGroup) this.f74786d0, false);
            view.findViewById(R.id.root).setBackgroundColor(Color.parseColor("#080808"));
            ((TextView) view.findViewById(R.id.textView1)).setTextColor(Color.parseColor("#757575"));
        } else {
            View view2 = new View(relativeLayout.getContext());
            view2.setBackgroundColor(Color.parseColor("#080808"));
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.f(12.0f, relativeLayout.getResources())));
            view = view2;
        }
        this.f74786d0.addHeaderView(view);
        if (!this.f74793k0) {
            this.f74785c0.setClickable(false);
            this.f74785c0.setVisibility(8);
        }
        this.f74784b0.setVisibility(0);
        this.f74784b0.setOnTouchListener(new b());
        this.f74784b0.setOnClickListener(new c());
    }

    private void sendIsResumeBroadcast(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "sendIsResumeBroadcast isResume = " + z16);
        }
        SmallScreenUtils.A(BaseApplication.getContext(), z16);
    }

    void T2() {
        Dialog dialog = this.f74791i0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                try {
                    this.f74791i0.dismiss();
                } catch (Exception unused) {
                }
            }
            this.f74791i0 = null;
        }
    }

    @TargetApi(11)
    void U2(int i3, long j3, boolean z16, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "drawUI-->type=" + i3 + " uin=" + j3 + " fresh=" + z16 + " originalType=" + i16);
        }
        if (com.tencent.av.r.h0() != null && !this.f74795m0 && this.f74787e0 != null) {
            if (i3 == 0 || i3 == 1) {
                V2();
            }
            if (i16 == 42) {
                W2(j3, true);
            } else if (i16 == 43) {
                W2(j3, false);
            }
        }
    }

    void V2() {
        Z2();
        j jVar = this.f74788f0;
        if (jVar != null) {
            jVar.e(this.f74789g0);
        }
    }

    void b3() {
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16 != null) {
            if (f16.W0) {
                this.f74785c0.setText(super.getString(R.string.dbq));
            } else {
                this.f74785c0.setText(super.getString(R.string.dbs));
            }
        }
    }

    public void c3(long j3, int i3, boolean z16, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "refreshUI-->uin=" + j3 + " type=" + i3 + " isRefreshTitle=" + z16 + " originalType=" + i16);
        }
        if (j3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("GAudioMembersCtrlActivity", 2, "refreshUI-->uin == 0");
                return;
            }
            return;
        }
        super.runOnUiThread(new RefreshUIRunnable(i3, j3, z16, i16));
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
        }
        super.setTheme(R.style.f173428d2);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        this.isClearCoverLayer = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168490xo);
        String stringExtra = super.getIntent().getStringExtra("discussUin");
        this.f74793k0 = super.getIntent().getBooleanExtra("Owner", true);
        this.f74794l0 = super.getIntent().getBooleanExtra("isInRoom", true);
        int intExtra = super.getIntent().getIntExtra("relationType", 0);
        if (!this.f74794l0) {
            this.f74793k0 = false;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return false;
        }
        AVUtil.t(getWindow(), true);
        ImmersiveUtils.setStatusTextColor(false, getWindow());
        initViews();
        VideoAppInterface videoAppInterface = (VideoAppInterface) super.getAppRuntime();
        this.f74787e0 = videoAppInterface;
        if (videoAppInterface == null) {
            finish();
            return false;
        }
        this.f74795m0 = false;
        this.f74790h0 = com.tencent.av.n.e().f().P0;
        Z2();
        if (intExtra == 0) {
            i3 = com.tencent.av.n.e().f().S0;
        } else {
            i3 = intExtra;
        }
        VideoAppInterface videoAppInterface2 = this.f74787e0;
        PinnedDividerListView pinnedDividerListView = this.f74786d0;
        long j3 = this.f74790h0;
        if (j3 <= 0) {
            j3 = Long.parseLong(stringExtra);
        }
        j jVar = new j(this, videoAppInterface2, pinnedDividerListView, j3, i3, this.f74793k0);
        this.f74788f0 = jVar;
        jVar.e(this.f74789g0);
        b3();
        this.f74787e0.addObserver(this.f74798p0);
        if (this.f74794l0) {
            this.f74787e0.addObserver(this.f74797o0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.av.v2q.StopVideoChat");
        f fVar = new f();
        this.f74799q0 = fVar;
        super.registerReceiver(fVar, intentFilter);
        if (QLog.isColorLevel()) {
            QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate end , cost time : " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        VideoAppInterface videoAppInterface = this.f74787e0;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.f74798p0);
            if (this.f74794l0) {
                this.f74787e0.deleteObserver(this.f74797o0);
            }
            if (this.f74792j0 != null) {
                this.f74787e0.M().removeCallbacks(this.f74792j0);
            }
        }
        this.f74792j0 = null;
        j jVar = this.f74788f0;
        if (jVar != null) {
            jVar.f();
            this.f74788f0 = null;
        }
        ArrayList<com.tencent.av.e> arrayList = this.f74789g0;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f74789g0 = null;
        this.f74787e0 = null;
        this.f74795m0 = true;
        try {
            BroadcastReceiver broadcastReceiver = this.f74799q0;
            if (broadcastReceiver != null) {
                super.unregisterReceiver(broadcastReceiver);
                this.f74799q0 = null;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GAudioMembersCtrlActivity", 2, "", e16);
            }
        }
        this.f74786d0 = null;
        this.f74783a0 = null;
        this.f74784b0 = null;
        this.f74785c0 = null;
        if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, "doOnDestroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        sendIsResumeBroadcast(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (this.f74792j0 == null) {
            this.f74792j0 = new RefreshFaceRunnable();
            this.f74787e0.M().postDelayed(this.f74792j0, 2000L);
        }
        b3();
        sendIsResumeBroadcast(true);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        super.overridePendingTransition(0, R.anim.f154423k);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ga9) {
            d3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
