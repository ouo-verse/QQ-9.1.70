package com.tencent.av.ui.fragment.invite.mav;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.invite.multi.GaInviteHeadNamePart;
import com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart;
import com.tencent.av.ui.part.invite.multi.IncomingCallAcceptRefusePart;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.i;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.cp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.List;
import mqq.app.BaseFragmentActivity;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTMultiIncomingCallsFragment extends NTGaInviteBaseFragment {

    /* renamed from: m0, reason: collision with root package name */
    private static boolean f75757m0 = false;
    boolean W;

    /* renamed from: f0, reason: collision with root package name */
    private GaInviteMemberListPart f75763f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.av.ui.part.invite.multi.d f75764g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.av.ui.part.invite.multi.b f75765h0;

    /* renamed from: i0, reason: collision with root package name */
    private GaInviteHeadNamePart f75766i0;

    /* renamed from: j0, reason: collision with root package name */
    private IncomingCallAcceptRefusePart f75767j0;
    com.tencent.av.utils.f M = null;
    Bitmap N = null;
    String P = null;
    String Q = null;
    SessionInfo R = null;
    boolean S = false;
    boolean T = false;
    int U = 0;
    int V = -1;
    long[] X = null;
    String Y = "";
    String Z = "";

    /* renamed from: a0, reason: collision with root package name */
    int f75758a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f75759b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private GAudioUIObserver f75760c0 = new a();

    /* renamed from: d0, reason: collision with root package name */
    private boolean f75761d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private BroadcastReceiver f75762e0 = new b();

    /* renamed from: k0, reason: collision with root package name */
    GAudioUIObserver f75768k0 = new f();

    /* renamed from: l0, reason: collision with root package name */
    VideoObserver f75769l0 = new g();

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
            NTMultiIncomingCallsFragment nTMultiIncomingCallsFragment = NTMultiIncomingCallsFragment.this;
            if (j3 != nTMultiIncomingCallsFragment.D || z16) {
                return;
            }
            if ((i3 == 10 || i3 == 1) && nTMultiIncomingCallsFragment.getActivity() != null && ((BaseFragmentActivity) NTMultiIncomingCallsFragment.this.getActivity()).isResume() && NTMultiIncomingCallsFragment.this.f75763f0 != null) {
                NTMultiIncomingCallsFragment.this.f75763f0.I9(i3);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void S(long j3, ArrayList<com.tencent.av.e> arrayList, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d(NTGaInviteBaseFragment.L, 2, "onUserListALLUpdate");
            }
            NTMultiIncomingCallsFragment.this.Kh(j3, arrayList, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION")) {
                NTMultiIncomingCallsFragment.this.Eh(QQAudioHelper.b(), "BroadcastReceiver_qzone", NTMultiIncomingCallsFragment.this.getActivity() == null ? null : NTMultiIncomingCallsFragment.this.getActivity().getIntent(), n.e().f());
                NTMultiIncomingCallsFragment.this.G.k0(new Object[]{67, Long.valueOf(NTMultiIncomingCallsFragment.this.D), 3});
                NTMultiIncomingCallsFragment.this.Ih("BroadcastReceiver_qzone");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements IncomingCallAcceptRefusePart.c {
        c() {
        }

        @Override // com.tencent.av.ui.part.invite.multi.IncomingCallAcceptRefusePart.c
        public void a(String str) {
            NTMultiIncomingCallsFragment.this.Ih(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f75773d;

        d(long j3) {
            this.f75773d = j3;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            NTMultiIncomingCallsFragment.this.Lh(this.f75773d, "onClickCancel", true, null, -1);
            NTMultiIncomingCallsFragment.this.Ih("onClickCancel");
            cp.c.c(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            NTMultiIncomingCallsFragment.this.Ih("onDismiss");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class f extends GAudioUIObserver {
        f() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void A(long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(NTGaInviteBaseFragment.L + LogTag.TAG_GROUP_VEDIO_INVITE, 2, "groupId:" + j3 + ", memUin:" + j16 + ",invitedId:" + str + ", mInviterUin:" + NTMultiIncomingCallsFragment.this.E + ", mGroupId:" + NTMultiIncomingCallsFragment.this.D);
            }
            NTMultiIncomingCallsFragment nTMultiIncomingCallsFragment = NTMultiIncomingCallsFragment.this;
            if (j16 == nTMultiIncomingCallsFragment.E && j3 == nTMultiIncomingCallsFragment.D && nTMultiIncomingCallsFragment.getActivity() != null) {
                NTMultiIncomingCallsFragment.this.getActivity().finish();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void b(long j3) {
            NTMultiIncomingCallsFragment.this.Ih("notifyCloseAllGroupVideoInviteMsgBox");
            if (NTMultiIncomingCallsFragment.this.getActivity() != null) {
                NTMultiIncomingCallsFragment.this.getActivity().finish();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void c(long j3) {
            NTMultiIncomingCallsFragment nTMultiIncomingCallsFragment = NTMultiIncomingCallsFragment.this;
            if (nTMultiIncomingCallsFragment.D == j3) {
                nTMultiIncomingCallsFragment.Ih("notifyCloseGroupVideoInviteMsgBox");
                if (NTMultiIncomingCallsFragment.this.getActivity() != null) {
                    NTMultiIncomingCallsFragment.this.getActivity().finish();
                }
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void d(long j3, String str) {
            NTMultiIncomingCallsFragment nTMultiIncomingCallsFragment = NTMultiIncomingCallsFragment.this;
            if (nTMultiIncomingCallsFragment.D == j3 && nTMultiIncomingCallsFragment.Y.equals(str) && NTMultiIncomingCallsFragment.this.getActivity() != null) {
                NTMultiIncomingCallsFragment.this.getActivity().finish();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            long b16 = QQAudioHelper.b();
            QLog.w(NTGaInviteBaseFragment.L, 1, "onDestroyInviteUI, groupId[" + j3 + "], reason[" + i3 + "], mIsDoubleVideoMeeting[" + NTMultiIncomingCallsFragment.this.S + "], mPeerUin[" + NTMultiIncomingCallsFragment.this.P + "], mGroupId[" + NTMultiIncomingCallsFragment.this.D + "], seq[" + b16 + "]");
            NTMultiIncomingCallsFragment nTMultiIncomingCallsFragment = NTMultiIncomingCallsFragment.this;
            if (nTMultiIncomingCallsFragment.S) {
                if (TextUtils.equals(nTMultiIncomingCallsFragment.P, String.valueOf(j3))) {
                    NTMultiIncomingCallsFragment.this.Ih("onDestroyInviteUI_DoubleVideoMeeting");
                    NTMultiIncomingCallsFragment.this.Gh(b16, i3);
                    return;
                }
                return;
            }
            if (nTMultiIncomingCallsFragment.D == j3 || 0 == j3) {
                nTMultiIncomingCallsFragment.Ih("onDestroyInviteUI");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class g extends VideoObserver {
        g() {
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            QLog.w(NTGaInviteBaseFragment.L, 1, "VideoObserver_onClose, reason[" + i3 + "], peerUin[" + str + "], mPeerUin[" + NTMultiIncomingCallsFragment.this.P + "], seq[" + j3 + "]");
            if (TextUtils.equals(NTMultiIncomingCallsFragment.this.P, str)) {
                NTMultiIncomingCallsFragment.this.Ih("VideoObserver_onClose");
                NTMultiIncomingCallsFragment.this.Gh(j3, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void h(String str, boolean z16) {
            QLog.w(NTGaInviteBaseFragment.L, 1, "VideoObserver_onDestroyUI, peerUin[" + str + "], isQuit[" + z16 + "], mPeerUin[" + NTMultiIncomingCallsFragment.this.P + "]");
            if (TextUtils.equals(NTMultiIncomingCallsFragment.this.P, str)) {
                NTMultiIncomingCallsFragment.this.Ih("VideoObserver_onDestroyUI");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(long j3, String str, Intent intent, SessionInfo sessionInfo) {
        IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = this.f75767j0;
        if (incomingCallAcceptRefusePart != null) {
            incomingCallAcceptRefusePart.A9(j3, str, intent, sessionInfo);
        }
    }

    private void Jh(long j3, Intent intent, SessionInfo sessionInfo) {
        IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = this.f75767j0;
        if (incomingCallAcceptRefusePart != null) {
            incomingCallAcceptRefusePart.B9(j3, intent, sessionInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(long j3, ArrayList<com.tencent.av.e> arrayList, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, "handleMemberListUpdate");
        }
        GaInviteMemberListPart gaInviteMemberListPart = this.f75763f0;
        if (gaInviteMemberListPart != null) {
            gaInviteMemberListPart.J9(j3, arrayList, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(long j3, String str, boolean z16, SessionInfo sessionInfo, int i3) {
        IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = this.f75767j0;
        if (incomingCallAcceptRefusePart != null) {
            incomingCallAcceptRefusePart.D9(j3, str, z16, sessionInfo, i3);
        }
    }

    private void Mh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, "sendIsResumeBroadcast isResume = " + z16);
        }
        SmallScreenUtils.A(BaseApplication.getContext(), z16);
    }

    public static boolean isShowing() {
        return f75757m0;
    }

    void Gh(long j3, int i3) {
        String str;
        if (r.h0() == null || getActivity() == null || getActivity().isDestroyed()) {
            return;
        }
        QLog.w(NTGaInviteBaseFragment.L, 1, "closeSession, reason[" + i3 + "], seq[" + j3 + "]");
        long g16 = i.g(this.P);
        if (this.S) {
            if (i3 == 1) {
                r.h0().o(j3, g16, 7);
                return;
            } else {
                if (i3 == 2) {
                    r.h0().o(j3, g16, 2);
                    return;
                }
                return;
            }
        }
        SessionInfo sessionInfo = this.R;
        if (sessionInfo == null) {
            str = this.P;
        } else {
            str = sessionInfo.f73091w;
        }
        r.h0().r(str, 241);
        r.h0().j2(241);
    }

    void Hh() {
        com.tencent.av.utils.f fVar = this.M;
        if (fVar != null) {
            try {
                fVar.dismiss();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.M = null;
        }
    }

    void Ih(String str) {
        QLog.w(NTGaInviteBaseFragment.L, 1, "destroyUI[" + str + "]");
        Hh();
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        GaInviteMemberListPart gaInviteMemberListPart;
        QLog.d(NTGaInviteBaseFragment.L, 1, "assembleParts mUinType=" + this.C);
        ArrayList arrayList = new ArrayList();
        if (NTGaInviteBaseFragment.xh(this.C) && (gaInviteMemberListPart = this.f75763f0) != null) {
            arrayList.add(gaInviteMemberListPart);
        }
        com.tencent.av.ui.part.invite.multi.d dVar = new com.tencent.av.ui.part.invite.multi.d(this.R);
        this.f75764g0 = dVar;
        arrayList.add(dVar);
        com.tencent.av.ui.part.invite.multi.b bVar = this.f75765h0;
        if (bVar != null) {
            arrayList.add(bVar);
        }
        GaInviteHeadNamePart gaInviteHeadNamePart = this.f75766i0;
        if (gaInviteHeadNamePart != null) {
            arrayList.add(gaInviteHeadNamePart);
        }
        IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = this.f75767j0;
        if (incomingCallAcceptRefusePart != null) {
            arrayList.add(incomingCallAcceptRefusePart);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        QLog.d(NTGaInviteBaseFragment.L, 1, "getContentLayoutId.");
        return m.c.f76002d;
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f75757m0 = false;
        QLog.d(NTGaInviteBaseFragment.L, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Hh();
        this.N = null;
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.f75769l0);
            this.G.deleteObserver(this.f75768k0);
            this.G.deleteObserver(this.f75760c0);
        }
        try {
            if (this.f75761d0) {
                if (getActivity() != null) {
                    getActivity().unregisterReceiver(this.f75762e0);
                }
                this.f75761d0 = false;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = this.f75767j0;
        if ((incomingCallAcceptRefusePart != null && incomingCallAcceptRefusePart.E9()) || i3 != 4) {
            return false;
        }
        com.tencent.av.ui.part.invite.multi.c.a(2);
        Lh(QQAudioHelper.b(), "onKeyDown", true, null, -1);
        Ih("onKeyDown");
        return true;
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, "onNewIntent");
        }
        Fh(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.d(NTGaInviteBaseFragment.L, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(getContext(), 2, true);
        Mh(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        f75757m0 = true;
        QLog.d(NTGaInviteBaseFragment.L, 1, "onResume");
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(getContext(), 2, false);
        Mh(true);
        com.tencent.av.ui.part.invite.multi.c.a(0);
        if (r.h0() != null) {
            r.h0().X1(this.P);
            r.h0().g2(MultiIncomingCallsActivity.class);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QLog.d(NTGaInviteBaseFragment.L, 1, "onStart");
        com.tencent.av.ui.part.invite.multi.d dVar = this.f75764g0;
        if (dVar != null) {
            dVar.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        QLog.d(NTGaInviteBaseFragment.L, 1, DKHippyEvent.EVENT_STOP);
        com.tencent.av.ui.part.invite.multi.d dVar = this.f75764g0;
        if (dVar != null) {
            dVar.A9(this.C, this.D, this.F, this.E, this.P, this.Q, this.H, this.T, this.S);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        long b16 = QQAudioHelper.b();
        QLog.w(NTGaInviteBaseFragment.L, 1, "onViewCreated, seq[" + b16 + "]");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.d(NTGaInviteBaseFragment.L, 1, "onViewCreated hostActivity is null.");
            return;
        }
        super.onViewCreated(view, bundle);
        activity.getWindow().setBackgroundDrawableResource(R.drawable.f162601b70);
        activity.getWindow().addFlags(128);
        AVCallCompactHelper A = r.h0().A();
        if (A == null || !A.e(activity)) {
            if (TraeHelper.I() != null) {
                TraeHelper.I().k0(b16);
            }
            zh(activity.getIntent());
            AVCallCompactHelper A2 = r.h0().A();
            if (A2 != null) {
                A2.g(getClass().getName(), activity.getIntent());
            }
            if (this.G != null) {
                if (!wh()) {
                    this.G.addObserver(this.f75769l0);
                }
                this.G.addObserver(this.f75768k0);
                if (wh()) {
                    this.G.addObserver(this.f75760c0);
                }
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
            try {
                activity.registerReceiver(this.f75762e0, intentFilter);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.f75761d0 = true;
            startTimer(wh() ? 30000 : 60000);
            SessionInfo sessionInfo = this.R;
            if (sessionInfo == null || !sessionInfo.H2) {
                return;
            }
            onBackPressed();
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment
    public void yh() {
        com.tencent.av.ui.part.invite.multi.d dVar = this.f75764g0;
        if (dVar != null) {
            dVar.z9();
        }
        com.tencent.av.ui.part.invite.multi.c.a(2);
        Lh(QQAudioHelper.b(), "onInviteTimeOut", true, n.e().f(), 8);
        Ih("onInviteTimeOut");
    }

    @Override // com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment
    public void zh(Intent intent) {
        long b16 = QQAudioHelper.b();
        this.F = 3;
        super.zh(intent);
        if (intent == null) {
            return;
        }
        this.P = intent.getStringExtra("peerUin");
        this.Q = intent.getStringExtra("extraUin");
        this.S = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        this.V = intent.getIntExtra("memberType", -1);
        this.W = intent.getBooleanExtra("hasGVideoJoined", false);
        this.T = intent.getBooleanExtra("isAudioMode", false);
        this.U = intent.getIntExtra("bindType", 0);
        this.f75759b0 = intent.getIntExtra("inviteScene", 0) == 2;
        String b17 = n.b(3, this.P, new int[0]);
        if (this.S) {
            b17 = n.b(100, this.P, new int[0]);
            this.T = false;
        }
        if (wh()) {
            int intExtra = intent.getIntExtra("MultiAVType", -1);
            this.f75758a0 = intExtra;
            this.T = intExtra != 2;
            this.Y = intent.getStringExtra("inviteId");
            b17 = n.b(this.F, String.valueOf(this.D), new int[0]);
            this.X = intent.getLongArrayExtra("memberList");
            int f16 = AVUtil.f(this.F);
            this.H = this.G.G(f16, String.valueOf(this.E), String.valueOf(this.D));
            this.N = this.G.J(f16, String.valueOf(this.E), this.Q, true, true);
        } else {
            String stringExtra = intent.getStringExtra("traceId");
            this.Z = stringExtra;
            RtcNodeReportReceiverHelper.v(stringExtra);
            this.H = this.G.G(this.C, this.P, this.Q);
            this.N = this.G.J(this.C, this.P, this.Q, true, true);
        }
        SessionInfo i3 = n.e().i(b17);
        this.R = i3;
        if (i3 == null) {
            Ih("processIntent_fail");
            return;
        }
        if (!Fh(intent)) {
            Nh(b16, intent);
        }
        this.R.H2 = intent.getBooleanExtra("isInZplanHome", false);
        this.R.I2 = intent.getBooleanExtra("needNotifyHangupEvent", false);
    }

    void Nh(long j3, Intent intent) {
        ViewStub viewStub;
        Hh();
        this.M = new com.tencent.av.utils.f(getContext(), false);
        View inflate = LayoutInflater.from(getContext()).inflate(m.c.f76002d, (ViewGroup) null);
        if (NTGaInviteBaseFragment.xh(this.C)) {
            if (this.f75763f0 == null) {
                this.f75763f0 = new GaInviteMemberListPart(this.F, this.D, this.E);
            }
            this.f75763f0.L9(inflate);
        }
        if (this.f75765h0 == null) {
            this.f75765h0 = new com.tencent.av.ui.part.invite.multi.b(true, this.D, this.F, this.C, this.f75758a0, this.E, this.T, this.S, this.f75759b0);
        }
        this.f75765h0.C9(inflate);
        if (this.f75766i0 == null) {
            this.f75766i0 = new GaInviteHeadNamePart(true, this.D, this.F, this.C, this.E, this.I, this.X, this.H, this.N);
        }
        this.f75766i0.O9(inflate);
        if (this.f75767j0 == null) {
            IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = new IncomingCallAcceptRefusePart(this.R, this.C, this.T, this.S, this.P, this.H, this.Q, this.F, this.D, this.X, this.Z);
            this.f75767j0 = incomingCallAcceptRefusePart;
            incomingCallAcceptRefusePart.H9(new c());
        }
        this.f75767j0.I9(inflate);
        if (wh()) {
            viewStub = (ViewStub) inflate.findViewById(R.id.gal);
        } else {
            viewStub = (ViewStub) inflate.findViewById(R.id.g7v);
        }
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.M.setCanceledOnTouchOutside(false);
        this.M.N(inflate, false);
        this.M.setOnCancelListener(new d(j3));
        this.M.setOnDismissListener(new e());
        this.M.show();
        if (QLog.isColorLevel()) {
            QLog.d(NTGaInviteBaseFragment.L, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", this.P, this.Q, Boolean.valueOf(this.S), Integer.valueOf(this.C), Integer.valueOf(this.F), Integer.valueOf(this.V), Boolean.valueOf(this.W), Boolean.valueOf(this.T), Integer.valueOf(this.U)));
        }
        TraeHelper.I().g0(j3, this.G, R.raw.qav_gaudio_join, null, 0, null);
    }

    public boolean Fh(Intent intent) {
        boolean z16 = false;
        if (intent == null) {
            return false;
        }
        long b16 = QQAudioHelper.b();
        String action = intent.getAction();
        if ("com.tencent.qav.notify.accept".equals(action)) {
            String stringExtra = intent.getStringExtra(ServiceConst.PARA_SESSION_ID);
            SessionInfo sessionInfo = this.R;
            String str = sessionInfo == null ? null : sessionInfo.f73030h;
            if (TextUtils.equals(stringExtra, str)) {
                Jh(b16, intent, n.e().f());
                z16 = true;
            } else if (QLog.isColorLevel()) {
                QLog.i(NTGaInviteBaseFragment.L, 2, "checkParamAndDoAction coming[" + stringExtra + "], cur[" + str + "]");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(NTGaInviteBaseFragment.L, 2, "checkParamAndDoAction action[" + action + "], seq[" + b16 + "]");
        }
        return z16;
    }
}
