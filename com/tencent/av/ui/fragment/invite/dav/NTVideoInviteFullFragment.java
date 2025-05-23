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
import com.tencent.av.ui.part.invite.AVInviteHidePart;
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
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.aj;
import com.tencent.av.utils.e;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzonestatus.QAVBackPressedBeforeEnterQZoneEvent;
import com.tencent.mobileqq.qzonestatus.QAVChangeToSmallScreenEvent;
import com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTVideoInviteFullFragment extends VideoInviteBaseFragment implements SimpleEventReceiver {
    private com.tencent.av.ui.part.invite.c A0;
    private j B0;
    private g C0;
    private k D0;
    private f E0;
    private com.tencent.av.ui.part.invite.b F0;
    private d G0;

    /* renamed from: v0, reason: collision with root package name */
    private l f75699v0;

    /* renamed from: w0, reason: collision with root package name */
    private VideoRefuseMsgReplyPart f75700w0;

    /* renamed from: x0, reason: collision with root package name */
    private h f75701x0;

    /* renamed from: y0, reason: collision with root package name */
    private com.tencent.av.ui.part.invite.a f75702y0;

    /* renamed from: z0, reason: collision with root package name */
    private AVInviteHidePart f75703z0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.d f75704a;

        a(b.d dVar) {
            this.f75704a = dVar;
        }

        @Override // com.tencent.av.ui.part.invite.b.d
        public void onAnimationEnd() {
            this.f75704a.onAnimationEnd();
            n.e().f().G1 = false;
            n.e().f().F1 = false;
        }

        @Override // com.tencent.av.ui.part.invite.b.d
        public void onAnimationStart() {
            this.f75704a.onAnimationStart();
        }
    }

    private void gi() {
        QZoneVideoContactsFeedHelper.f(this.E, this.G, getActivity());
        QZoneVideoContactsFeedHelper.c(this.E, this.G, getActivity());
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Ch(boolean z16) {
        l lVar = this.f75699v0;
        if (lVar != null) {
            lVar.x9(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Lh(Context context, String str, Intent intent) {
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(str)) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra != null) {
                TraeHelper.n0(this.E);
                if (stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    if (this.I) {
                        hi("0X8004399");
                    } else {
                        hi("0X80043F8");
                    }
                    r.h0().L3("backgroundReason", "1");
                    q.a.f74207a = "1";
                    return;
                }
                return;
            }
            return;
        }
        if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(str)) {
            r.h0().L3("backgroundReason", "4");
            q.a.f74207a = "4";
            this.K = true;
            xh("ACTION_SCREEN_OFF");
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Oh(int i3) {
        k kVar = this.D0;
        if (kVar != null) {
            kVar.z9(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Vh(String str) {
        g gVar = this.C0;
        if (gVar != null) {
            gVar.A9(str);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Xh(b.d dVar) {
        com.tencent.av.ui.part.invite.b bVar = this.F0;
        if (bVar != null) {
            bVar.Q9(dVar);
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void Yh(b.d dVar) {
        com.tencent.av.ui.part.invite.b bVar = this.F0;
        if (bVar == null) {
            return;
        }
        bVar.R9(new a(dVar));
        n.e().f().G1 = true;
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void di(VideoAppInterface videoAppInterface, int i3, String str, String str2, Bitmap bitmap) {
        g gVar = this.C0;
        if (gVar != null) {
            gVar.B9(videoAppInterface, i3, str, str2, bitmap);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QAVChangeToSmallScreenEvent.class);
        arrayList.add(QAVBackPressedBeforeEnterQZoneEvent.class);
        return arrayList;
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
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QAVChangeToSmallScreenEvent) {
            QLog.d("NTVideoInviteFullFragment", 1, "change to small screen mode");
            fi(true);
        } else if (simpleBaseEvent instanceof QAVBackPressedBeforeEnterQZoneEvent) {
            onBackPressed();
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.d("NTVideoInviteFullFragment", 1, "onViewCreated.");
        SimpleEventBus.getInstance().registerReceiver(this);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        aj.a(activity);
        activity.getWindow().addFlags(2097152);
        activity.getWindow().addFlags(128);
        activity.getWindow().clearFlags(524288);
        activity.getWindow().clearFlags(1024);
        ReportController.o(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", this.I ? 1 : 2, n.e().f().f73043k == 2 ? 2 : 3, "", "", "", "");
        if (this.I) {
            gi();
            hi("0X8004396");
        } else {
            hi("0X80043F4");
        }
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        refreshUI();
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        QavPanel qavPanel = (QavPanel) view.findViewById(R.id.f166587gb4);
        qavPanel.addView(LayoutInflater.from(getContext()).inflate(m.a.f75994e, (ViewGroup) qavPanel, false));
        QLog.d("NTVideoInviteFullFragment", 1, "onViewCreatedBeforePartInit.");
    }

    public NTVideoInviteFullFragment() {
        super(false);
    }

    private void hi(String str) {
        ReportController.o(null, "CliOper", "", "", str, str, 0, 0, Integer.toString(this.L), Integer.toString(this.f75716c0), Integer.toString(this.f75717d0), "");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        QLog.d("NTVideoInviteFullFragment", 1, "assembleParts");
        ArrayList arrayList = new ArrayList();
        l lVar = new l();
        this.f75699v0 = lVar;
        arrayList.add(lVar);
        VideoRefuseMsgReplyPart videoRefuseMsgReplyPart = new VideoRefuseMsgReplyPart(false);
        this.f75700w0 = videoRefuseMsgReplyPart;
        arrayList.add(videoRefuseMsgReplyPart);
        h hVar = new h(false);
        this.f75701x0 = hVar;
        arrayList.add(hVar);
        com.tencent.av.ui.part.invite.a aVar = new com.tencent.av.ui.part.invite.a(false);
        this.f75702y0 = aVar;
        arrayList.add(aVar);
        AVInviteHidePart aVInviteHidePart = new AVInviteHidePart();
        this.f75703z0 = aVInviteHidePart;
        arrayList.add(aVInviteHidePart);
        com.tencent.av.ui.part.invite.c cVar = new com.tencent.av.ui.part.invite.c(false);
        this.A0 = cVar;
        arrayList.add(cVar);
        j jVar = new j();
        this.B0 = jVar;
        arrayList.add(jVar);
        g gVar = new g(false);
        this.C0 = gVar;
        arrayList.add(gVar);
        if (VipFunCallUtil.ifUseKuikly()) {
            f fVar = new f();
            this.E0 = fVar;
            arrayList.add(fVar);
        } else {
            k kVar = new k();
            this.D0 = kVar;
            arrayList.add(kVar);
        }
        com.tencent.av.ui.part.invite.b bVar = new com.tencent.av.ui.part.invite.b(false);
        this.F0 = bVar;
        arrayList.add(bVar);
        d dVar = new d();
        this.G0 = dVar;
        arrayList.add(dVar);
        arrayList.add(new i());
        return arrayList;
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public void ci(VideoAppInterface videoAppInterface, int i3, String str, String str2, String str3) {
        QLog.d("NTVideoInviteFullFragment", 1, "updateAvatar...");
        QavUpdateAvatarViewHelper.f().i(videoAppInterface, new ew.a(i3, str, str2, false), videoAppInterface.J(i3, str, TextUtils.isEmpty(str3) ? str2 : str3, false, false), this.f75699v0);
    }

    public void fi(boolean z16) {
        QLog.d("NTVideoInviteFullFragment", 1, "onClick HIDE ");
        if (r.h0() != null) {
            r.h0().L3("backgroundReason", "3");
        }
        if (QZoneVideoContactsFeedHelper.g(z16)) {
            return;
        }
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        QLog.d("NTVideoInviteFullFragment", 1, "getContentLayoutId.");
        return m.c.f75999a;
    }

    @Override // com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.I) {
                hi("0X800439A");
            } else {
                hi("0X80043F9");
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }
}
