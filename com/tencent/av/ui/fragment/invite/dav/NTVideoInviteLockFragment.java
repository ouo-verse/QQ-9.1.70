package com.tencent.av.ui.fragment.invite.dav;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.n;
import com.tencent.av.q;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.invite.VideoRefuseMsgReplyPart;
import com.tencent.av.ui.part.invite.b;
import com.tencent.av.ui.part.invite.d;
import com.tencent.av.ui.part.invite.f;
import com.tencent.av.ui.part.invite.g;
import com.tencent.av.ui.part.invite.h;
import com.tencent.av.ui.part.invite.i;
import com.tencent.av.ui.part.invite.j;
import com.tencent.av.ui.part.invite.k;
import com.tencent.av.ui.part.invite.l;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.aj;
import com.tencent.av.utils.e;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.biz.richframework.part.Part;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTVideoInviteLockFragment extends VideoInviteBaseFragment {
    private j A0;
    private g B0;
    private k C0;
    private f D0;
    private com.tencent.av.ui.part.invite.b E0;
    private d F0;

    /* renamed from: v0, reason: collision with root package name */
    private l f75706v0;

    /* renamed from: w0, reason: collision with root package name */
    private VideoRefuseMsgReplyPart f75707w0;

    /* renamed from: x0, reason: collision with root package name */
    private h f75708x0;

    /* renamed from: y0, reason: collision with root package name */
    private com.tencent.av.ui.part.invite.a f75709y0;

    /* renamed from: z0, reason: collision with root package name */
    private com.tencent.av.ui.part.invite.c f75710z0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.d f75711a;

        a(b.d dVar) {
            this.f75711a = dVar;
        }

        @Override // com.tencent.av.ui.part.invite.b.d
        public void onAnimationEnd() {
            this.f75711a.onAnimationEnd();
            n.e().f().G1 = false;
            n.e().f().F1 = false;
        }

        @Override // com.tencent.av.ui.part.invite.b.d
        public void onAnimationStart() {
            this.f75711a.onAnimationStart();
        }
    }

    private void fi() {
        QZoneVideoContactsFeedHelper.f(this.E, this.G, getActivity());
        QZoneVideoContactsFeedHelper.c(this.E, this.G, getActivity());
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Ch(boolean z16) {
        l lVar = this.f75706v0;
        if (lVar != null) {
            lVar.x9(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Lh(Context context, String str, Intent intent) {
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(str)) {
            return;
        }
        if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(str)) {
            long d16 = e.d();
            if (QLog.isColorLevel()) {
                QLog.w("NTVideoInviteLockFragment", 2, "ACTION_SCREEN_OFF, seq[" + d16 + "]");
            }
            r.h0().L3("backgroundReason", "4");
            q.a.f74207a = "4";
            if (ad.m(getContext())) {
                ai(d16);
                if (TraeHelper.I() != null && !r.h0().W0()) {
                    TraeHelper.I().m0();
                }
            }
            VideoAppInterface videoAppInterface = this.E;
            boolean k3 = AVUtil.k(videoAppInterface == null ? null : videoAppInterface.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
                QLog.w("NTVideoInviteLockFragment", 1, "ACTION_SCREEN_OFF avCallBtnState[" + k3 + "], seq[" + d16 + "]");
            }
            if (k3) {
                TraeHelper.j0(this.E, false, d16);
            }
            if (this.I) {
                gi("0X8004208");
                return;
            } else {
                gi("0X8004209");
                return;
            }
        }
        if (IECScreenReceiver.ACTION_SCREEN_ON.equals(str)) {
            long d17 = e.d();
            if (QLog.isColorLevel()) {
                QLog.w("NTVideoInviteLockFragment", 2, "ACTION_SCREEN_ON, seq[" + d17 + "]");
            }
            if (this.I && !this.f75715b0) {
                TraeHelper.I().i0(TraeConstants.VOICE_CALL_CONFIG);
            } else {
                TraeHelper.I().i0(TraeConstants.VIDEO_CALL_CONFIG);
            }
            Nh(d17);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Oh(int i3) {
        k kVar = this.C0;
        if (kVar != null) {
            kVar.z9(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Vh(String str) {
        g gVar = this.B0;
        if (gVar != null) {
            gVar.A9(str);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Xh(b.d dVar) {
        com.tencent.av.ui.part.invite.b bVar = this.E0;
        if (bVar != null) {
            bVar.Q9(dVar);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Yh(b.d dVar) {
        com.tencent.av.ui.part.invite.b bVar = this.E0;
        if (bVar == null) {
            return;
        }
        bVar.R9(new a(dVar));
        n.e().f().G1 = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        QLog.d("NTVideoInviteLockFragment", 1, "assembleParts");
        ArrayList arrayList = new ArrayList();
        l lVar = new l();
        this.f75706v0 = lVar;
        arrayList.add(lVar);
        VideoRefuseMsgReplyPart videoRefuseMsgReplyPart = new VideoRefuseMsgReplyPart(true);
        this.f75707w0 = videoRefuseMsgReplyPart;
        arrayList.add(videoRefuseMsgReplyPart);
        h hVar = new h(true);
        this.f75708x0 = hVar;
        arrayList.add(hVar);
        com.tencent.av.ui.part.invite.a aVar = new com.tencent.av.ui.part.invite.a(true);
        this.f75709y0 = aVar;
        arrayList.add(aVar);
        com.tencent.av.ui.part.invite.c cVar = new com.tencent.av.ui.part.invite.c(true);
        this.f75710z0 = cVar;
        arrayList.add(cVar);
        j jVar = new j();
        this.A0 = jVar;
        arrayList.add(jVar);
        g gVar = new g(true);
        this.B0 = gVar;
        arrayList.add(gVar);
        if (VipFunCallUtil.ifUseKuikly()) {
            f fVar = new f();
            this.D0 = fVar;
            arrayList.add(fVar);
        } else {
            k kVar = new k();
            this.C0 = kVar;
            arrayList.add(kVar);
        }
        com.tencent.av.ui.part.invite.b bVar = new com.tencent.av.ui.part.invite.b(true);
        this.E0 = bVar;
        arrayList.add(bVar);
        d dVar = new d();
        this.F0 = dVar;
        arrayList.add(dVar);
        arrayList.add(new i());
        return arrayList;
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void di(VideoAppInterface videoAppInterface, int i3, String str, String str2, Bitmap bitmap) {
        g gVar = this.B0;
        if (gVar != null) {
            gVar.B9(videoAppInterface, i3, str, str2, bitmap);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void onBackPressed() {
        SessionInfo sessionInfo;
        if (Gh() || this.V.M1().getValue().booleanValue()) {
            return;
        }
        if (r.h0() != null && !n.e().f().H2) {
            r.h0().K3();
        }
        q.a.f74207a = "3";
        SmallScreenActivityPlugin.a(this.E).d();
        this.W = false;
        if (r.h0() != null) {
            sessionInfo = n.e().f();
            r.h0().L2(true);
            r.h0().K2(false);
        } else {
            sessionInfo = null;
        }
        SmallScreenActivityPlugin.a(this.E).f(e.d(), this.W);
        if (getActivity() != null) {
            getActivity().finish();
            if (sessionInfo != null) {
                getActivity().overridePendingTransition(0, SmallScreenUtils.j(sessionInfo.D1));
            }
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.d("NTVideoInviteLockFragment", 1, "onViewCreated.");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        aj.a(activity);
        activity.getWindow().addFlags(524288);
        activity.getWindow().addFlags(128);
        activity.getWindow().addFlags(1024);
        if (!this.K) {
            activity.getWindow().addFlags(2097152);
        }
        ReportController.o(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", this.I ? 1 : 2, n.e().f().f73043k == 2 ? 2 : 3, "", "", "", "");
        if (this.I) {
            fi();
            gi("0X8004396");
        } else {
            gi("0X80043F4");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        refreshUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        QavPanel qavPanel = (QavPanel) view.findViewById(R.id.f166587gb4);
        qavPanel.addView(LayoutInflater.from(getContext()).inflate(m.a.f75995f, (ViewGroup) qavPanel, false));
        QLog.d("NTVideoInviteLockFragment", 1, "onViewCreatedBeforePartInit.");
    }

    public NTVideoInviteLockFragment() {
        super(true);
    }

    private void gi(String str) {
        ReportController.o(null, "CliOper", "", "", str, str, 0, 0, Integer.toString(this.L), Integer.toString(this.f75716c0), Integer.toString(this.f75717d0), "");
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void ci(VideoAppInterface videoAppInterface, int i3, String str, String str2, String str3) {
        QLog.d("NTVideoInviteLockFragment", 1, "updateAvatar...");
        QavUpdateAvatarViewHelper.f().i(videoAppInterface, new ew.a(i3, str, str2, false), videoAppInterface.J(i3, str, TextUtils.isEmpty(str3) ? str2 : str3, false, false), this.f75706v0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        QLog.d("NTVideoInviteLockFragment", 1, "getContentLayoutId.");
        return m.c.f76000b;
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        super.onKeyDown(i3, keyEvent);
        if (i3 != 4) {
            return true;
        }
        if (this.I) {
            ReportController.o(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.L), Integer.toString(this.f75716c0), Integer.toString(this.f75717d0), "");
            return true;
        }
        ReportController.o(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.L), Integer.toString(this.f75716c0), Integer.toString(this.f75717d0), "");
        return true;
    }
}
