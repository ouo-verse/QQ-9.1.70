package com.tencent.av.ui.fragment.invite.mav;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.e;
import com.tencent.av.gaudio.GInviteTimeOutHelper;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.invite.multi.GaInviteHeadNamePart;
import com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.BaseFragmentActivity;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTGaInviteFragment extends NTGaInviteBaseFragment {
    private GaInviteMemberListPart X;
    private com.tencent.av.ui.part.invite.multi.b Y;
    private com.tencent.av.ui.part.invite.multi.a Z;

    /* renamed from: a0, reason: collision with root package name */
    private GaInviteHeadNamePart f75751a0;
    private com.tencent.av.compat.a M = new com.tencent.av.compat.a();
    private SmallScreenActivityPlugin N = null;
    QAVNotification P = null;
    boolean Q = true;
    SessionInfo R = null;
    int S = -1;
    int T = -1;
    boolean U = false;
    String V = "";
    boolean W = false;

    /* renamed from: b0, reason: collision with root package name */
    private GAudioUIObserver f75752b0 = new a();

    /* renamed from: c0, reason: collision with root package name */
    GAudioUIObserver f75753c0 = new c();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends GAudioUIObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void L(long j3, boolean z16, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(NTGaInviteBaseFragment.L, 2, "onMembersChange");
            }
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (j3 != nTGaInviteFragment.D || z16 || nTGaInviteFragment.getActivity() == null || !((BaseFragmentActivity) NTGaInviteFragment.this.getActivity()).isResume()) {
                return;
            }
            if ((i3 == 10 || i3 == 1) && NTGaInviteFragment.this.X != null) {
                NTGaInviteFragment.this.X.I9(i3);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void S(long j3, ArrayList<e> arrayList, int i3, int i16) {
            if (NTGaInviteFragment.this.X != null) {
                NTGaInviteFragment.this.X.J9(j3, arrayList, i3);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void o() {
            NTGaInviteFragment.this.yh();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            FragmentActivity activity = NTGaInviteFragment.this.getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || i3 == 1) {
                return;
            }
            NTGaInviteFragment.this.Fh(-1040L, 11);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends GAudioUIObserver {
        c() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void A(long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(NTGaInviteBaseFragment.L + LogTag.TAG_GROUP_VEDIO_INVITE, 2, "groupId:" + j3 + ", memUin:" + j16 + ",invitedId:" + str + ", mInviterUin:" + NTGaInviteFragment.this.E + ", mGroupId:" + NTGaInviteFragment.this.D);
            }
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (j16 == nTGaInviteFragment.E && j3 == nTGaInviteFragment.D && nTGaInviteFragment.getActivity() != null) {
                NTGaInviteFragment.this.getActivity().finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void O() {
            super.O();
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (!nTGaInviteFragment.Q || nTGaInviteFragment.f75751a0 == null) {
                return;
            }
            NTGaInviteFragment.this.f75751a0.L9("onServiceConnected");
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void S(long j3, ArrayList<e> arrayList, int i3, int i16) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                if (String.valueOf(it.next().f73701a).equalsIgnoreCase(NTGaInviteFragment.this.G.getAccount()) && NTGaInviteFragment.this.getActivity() != null) {
                    NTGaInviteFragment.this.getActivity().finish();
                }
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void b(long j3) {
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (nTGaInviteFragment.D != j3) {
                nTGaInviteFragment.Eh(-1035L);
            }
            if (NTGaInviteFragment.this.getActivity() != null) {
                NTGaInviteFragment.this.getActivity().finish();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void c(long j3) {
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (nTGaInviteFragment.D != j3 || nTGaInviteFragment.getActivity() == null) {
                return;
            }
            NTGaInviteFragment.this.getActivity().finish();
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void d(long j3, String str) {
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (nTGaInviteFragment.D == j3 && nTGaInviteFragment.V.equals(str) && NTGaInviteFragment.this.getActivity() != null) {
                NTGaInviteFragment.this.getActivity().finish();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            NTGaInviteFragment nTGaInviteFragment = NTGaInviteFragment.this;
            if (nTGaInviteFragment.D == j3 || 0 == j3) {
                nTGaInviteFragment.Gh();
                r.h0().x(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(long j3) {
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar != null) {
            aVar.G9(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(long j3, int i3) {
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar != null) {
            aVar.H9(j3, i3);
        }
    }

    private void Hh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, "sendIsResumeBroadcast isResume = " + z16);
        }
        if (BaseApplication.getContext() == null) {
            return;
        }
        SmallScreenUtils.A(BaseApplication.getContext(), z16);
    }

    void Gh() {
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar != null) {
            aVar.L9();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        QLog.d(NTGaInviteBaseFragment.L, 1, "getContentLayoutId.");
        return m.c.f76001c;
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment, com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public void onBackPressed() {
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, "onBackPressed");
        }
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar == null || aVar.J9()) {
            return;
        }
        r.h0().K3();
        r.h0().L2(true);
        r.h0().K2(false);
        SmallScreenActivityPlugin smallScreenActivityPlugin = this.N;
        if (smallScreenActivityPlugin != null) {
            smallScreenActivityPlugin.d();
            this.N.f(com.tencent.av.utils.e.d(), false);
        }
        if (getActivity() != null) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, SmallScreenUtils.j(n.e().f().D1));
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.f75753c0);
        }
        QAVNotification qAVNotification = this.P;
        if (qAVNotification != null) {
            qAVNotification.f(this.R.f73030h);
            this.P = null;
        }
        if (r.h0() != null) {
            r.h0().f3(false);
        }
        VideoAppInterface videoAppInterface2 = this.G;
        if (videoAppInterface2 != null) {
            videoAppInterface2.deleteObserver(this.f75752b0);
        }
        QLog.d(NTGaInviteBaseFragment.L, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        QLog.d(NTGaInviteBaseFragment.L, 1, "onNewIntent()");
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar != null) {
            aVar.D9(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(NTGaInviteBaseFragment.L, 1, "onPause seq[" + d16 + "]");
        if (this.Z != null) {
            com.tencent.av.ui.part.invite.multi.a.Q9(d16);
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(getContext(), 2, true);
        this.U = false;
        this.M.a(this.G);
        Hh(false);
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar == null || aVar.K9() || BaseApplication.getContext() == null) {
            return;
        }
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 50, 1);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        QLog.d(NTGaInviteBaseFragment.L, 1, "onStop ");
        if (this.P == null) {
            this.P = QAVNotification.l(this.G);
        }
        String valueOf = String.valueOf(this.D);
        Bitmap J = this.G.J(this.C, valueOf, null, true, true);
        this.P.c(this.R.f73030h, this.G.G(AVUtil.f(this.F), Long.toString(this.E), valueOf), J, valueOf, 61, this.C, 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        QLog.d(NTGaInviteBaseFragment.L, 1, "onViewCreatedAfterPartInit");
        super.onViewCreatedAfterPartInit(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        QLog.d(NTGaInviteBaseFragment.L, 1, "onViewCreatedBeforePartInit");
        super.onViewCreatedBeforePartInit(view, bundle);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        com.tencent.av.ui.part.invite.multi.b bVar = this.Y;
        if (bVar != null) {
            bVar.A9(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment, com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public void ph(View view) {
        int id5 = view.getId();
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar != null) {
            aVar.C9(view);
        }
        if (id5 == m.l.f76080z) {
            if (QLog.isColorLevel()) {
                QLog.d(NTGaInviteBaseFragment.L, 2, "HIDE");
            }
            onBackPressed();
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment
    protected void yh() {
        ReportController.o(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
        QAVNotification qAVNotification = this.P;
        if (qAVNotification != null) {
            qAVNotification.f(this.R.f73030h);
        }
        Fh(-1041L, 8);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        QLog.d(NTGaInviteBaseFragment.L, 1, "assembleParts");
        ArrayList arrayList = new ArrayList();
        GaInviteMemberListPart gaInviteMemberListPart = new GaInviteMemberListPart(this.F, this.D, this.E);
        this.X = gaInviteMemberListPart;
        arrayList.add(gaInviteMemberListPart);
        com.tencent.av.ui.part.invite.multi.b bVar = new com.tencent.av.ui.part.invite.multi.b(this.D, this.F, this.C, this.T, this.E);
        this.Y = bVar;
        arrayList.add(bVar);
        com.tencent.av.ui.part.invite.multi.a aVar = new com.tencent.av.ui.part.invite.multi.a(this.D, this.F, this.C, this.T, this.I, this.R);
        this.Z = aVar;
        arrayList.add(aVar);
        GaInviteHeadNamePart gaInviteHeadNamePart = new GaInviteHeadNamePart(this.D, this.F, this.C, this.E, this.I);
        this.f75751a0 = gaInviteHeadNamePart;
        arrayList.add(gaInviteHeadNamePart);
        return arrayList;
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(NTGaInviteBaseFragment.L, 1, "onKeyDown, keyCode[" + i3 + "], seq[" + d16 + "]");
        if (i3 == 4) {
            ReportController.o(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
            return true;
        }
        if ((i3 != 26 && i3 != 25 && i3 != 24) || this.Z == null) {
            return false;
        }
        com.tencent.av.ui.part.invite.multi.a.Q9(d16);
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        String str;
        super.onResume();
        com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
        if (aVar != null) {
            aVar.onResume();
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(getContext(), 2, false);
        QAVNotification qAVNotification = this.P;
        if (qAVNotification != null) {
            qAVNotification.f(this.R.f73030h);
        }
        if (this.U) {
            if (r.g1(getContext())) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.o(null, "CliOper", "", "", "0X8009E92", "0X8009E92", 0, 0, str, "", "", "");
        }
        int i3 = this.F;
        if (!(i3 == 11 || this.G.t(i3, this.D))) {
            QLog.w(NTGaInviteBaseFragment.L, 1, "onResume finish, mGroupId[" + this.D + "]");
            r.h0().m();
            r.h0().A1(this.F, this.D);
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else if (!this.W) {
            this.W = true;
            ChatActivityUtils.m(getActivity(), true, new b());
        }
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(context, 50, 0);
            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(context, false, 50, 1);
            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(context, 50, 2);
        }
        Hh(true);
        r.h0().g2(GaInviteLockActivity.class);
        this.M.b(getActivity(), this.G);
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        GaInviteHeadNamePart gaInviteHeadNamePart;
        super.onViewCreated(view, bundle);
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        }
        QLog.d(NTGaInviteBaseFragment.L, 1, "QAV_COLD_START_COST end: " + System.currentTimeMillis());
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.d(NTGaInviteBaseFragment.L, 1, "onViewCreated hostActivity is null.");
            return;
        }
        AVUtil.t(activity.getWindow(), true);
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9i") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo y55l")) {
            ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        } else {
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        }
        this.Q = false;
        Intent intent = activity.getIntent();
        zh(intent);
        this.V = intent.getStringExtra("inviteId");
        this.S = intent.getIntExtra("memberType", -1);
        boolean booleanExtra = intent.getBooleanExtra("hasGVideoJoined", false);
        this.T = intent.getIntExtra("MultiAVType", -1);
        String uh5 = NTGaInviteBaseFragment.uh(intent);
        long d16 = com.tencent.av.utils.e.d();
        long longExtra = intent.getLongExtra("showHalfScreenTimestamp", 0L);
        String str = NTGaInviteBaseFragment.L;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCreate[");
        sb5.append(uh5);
        sb5.append("], mInviterUin[");
        sb5.append(this.E);
        sb5.append("], mInviteId[");
        sb5.append(this.V);
        sb5.append("], mGroupId[");
        sb5.append(this.D);
        sb5.append("], mMemberType[");
        sb5.append(this.S);
        sb5.append("], mRelationType[");
        sb5.append(this.F);
        sb5.append("], mHasGVideoJoined[");
        sb5.append(booleanExtra);
        sb5.append("], multiAVType[");
        sb5.append(this.T);
        sb5.append("], mMemberList[");
        sb5.append(this.I != null);
        sb5.append("], mApp[");
        sb5.append(this.G != null);
        sb5.append("], showHalfScreenTimestamp[");
        sb5.append(longExtra);
        sb5.append("], seq[");
        sb5.append(d16);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        if (QLog.isColorLevel()) {
            QLog.i(NTGaInviteBaseFragment.L, 2, "onCreate-from: " + intent.getStringExtra("Fromwhere"));
        }
        if (this.G == null) {
            activity.finish();
            return;
        }
        if (r.h0() == null) {
            activity.finish();
            return;
        }
        String b16 = n.b(this.F, String.valueOf(this.D), new int[0]);
        if (n.e().j(b16)) {
            this.R = n.e().i(b16);
        } else {
            this.R = n.e().f();
        }
        if ((this.I == null && this.F == 2) || (this.R.f73043k == 0 && !TextUtils.isEmpty(b16) && b16.equals(r.h0().E0()))) {
            activity.finish();
            return;
        }
        if (this.E != 0 && this.D != 0) {
            long N = r.h0().N();
            if (this.D != N) {
                QLog.w(NTGaInviteBaseFragment.L, 1, "onCreate, id\u4e0d\u4e00\u81f4, currentInviteId[" + N + "], mGroupId[" + this.D + "], seq[" + d16 + "]");
                Eh(d16);
                return;
            }
            if (this.Q && (gaInviteHeadNamePart = this.f75751a0) != null) {
                gaInviteHeadNamePart.L9("onCreate");
            }
            this.G.addObserver(this.f75753c0);
            this.U = true;
            r.h0().d0(this.F, this.D, this.T);
            int currentTimeMillis = longExtra > 0 ? 60000 - ((int) (System.currentTimeMillis() - longExtra)) : 60000;
            startTimer(currentTimeMillis);
            this.R.H2 = intent.getBooleanExtra("isInZplanHome", false);
            this.R.I2 = intent.getBooleanExtra("needNotifyHangupEvent", false);
            if (this.R.H2) {
                QAVControllerForZplan.p().P((GaInviteLockActivity) activity, this.G);
                QAVNotification qAVNotification = this.P;
                if (qAVNotification != null) {
                    qAVNotification.f(this.R.f73030h);
                }
                activity.finish();
            }
            if (!(intent.getBooleanExtra("isInZplanHome", false))) {
                activity.setRequestedOrientation(1);
            }
            if ("onGAudioInvite".equals(NTGaInviteBaseFragment.uh(intent))) {
                GInviteTimeOutHelper.b().c(currentTimeMillis, this.F, this.D);
            }
            activity.overridePendingTransition(R.anim.f154855e4, 0);
            this.G.addObserver(this.f75752b0);
            activity.getWindow().addFlags(524288);
            activity.getWindow().addFlags(128);
            activity.getWindow().addFlags(2097152);
            AVCallCompactHelper A = r.h0().A();
            if (A != null) {
                A.g(getClass().getName(), intent);
            }
            com.tencent.av.ui.part.invite.multi.a aVar = this.Z;
            if (aVar != null) {
                aVar.D9(intent);
            }
            if (AVUtil.p()) {
                if (this.P == null) {
                    this.P = QAVNotification.l(this.G);
                }
                this.P.f(this.R.f73030h);
            }
            this.N = SmallScreenActivityPlugin.a(this.G);
            return;
        }
        activity.finish();
    }
}
