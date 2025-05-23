package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profile.util.b;
import com.tencent.mobileqq.profilecard.utils.ProfileCardShareBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardShareCardOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;
    boolean C;
    DiscussionHandler D;
    AbsShareMsg E;
    AbsStructMsg F;
    private String G;
    private String H;
    private int I;
    private String J;
    private String K;
    private String L;
    private int M;
    private String N;
    private int P;
    private String Q;
    private String R;
    private boolean S;
    private com.tencent.mobileqq.troop.troopmanager.api.b T;
    private com.tencent.qidian.controller.a U;
    private com.tencent.mobileqq.discussion.observer.a V;

    /* renamed from: d, reason: collision with root package name */
    private int f210878d;

    /* renamed from: e, reason: collision with root package name */
    private String f210879e;

    /* renamed from: f, reason: collision with root package name */
    private String f210880f;

    /* renamed from: h, reason: collision with root package name */
    private String f210881h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f210882i;

    /* renamed from: m, reason: collision with root package name */
    private String f210883m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements b.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardShareCardOption.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.util.b.e
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            ForwardShareCardOption.this.mExtraData.putAll(com.tencent.mobileqq.profile.util.b.k(ForwardShareCardOption.this.mActivity, str).getExtras());
            ForwardShareCardOption.this.mExtraData.putBoolean("is_ark_display_share", true);
            ForwardShareCardOption.this.E();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.troop.troopmanager.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardShareCardOption.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        public void onTroopShareLink(boolean z16, com.tencent.mobileqq.troop.troopshare.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
            }
            ForwardShareCardOption.this.hideProgressDialog();
            if (ForwardShareCardOption.this.f210878d != -1) {
                if (z16 && aVar.f301554b == 0) {
                    ForwardShareCardOption.this.f210881h = aVar.f301557e;
                    if (aVar.f301555c) {
                        ForwardShareCardOption.this.f210879e = aVar.f301556d;
                        if (ForwardShareCardOption.this.f210878d != 0) {
                            return;
                        }
                    } else {
                        ForwardShareCardOption.this.f210880f = aVar.f301556d;
                        if (ForwardShareCardOption.this.f210878d != 1) {
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + ForwardShareCardOption.this.f210879e + " mTroopNotNeedVefifyLink=" + ForwardShareCardOption.this.f210880f);
                    }
                    String str = aVar.f301553a;
                    if (str != null && str.equals(ForwardShareCardOption.this.G)) {
                        ForwardShareCardOption.this.Q();
                    }
                } else {
                    if (aVar.f301555c && ForwardShareCardOption.this.f210878d != 0) {
                        return;
                    }
                    if (!aVar.f301555c && ForwardShareCardOption.this.f210878d != 1) {
                        return;
                    }
                    Activity activity = ForwardShareCardOption.this.mActivity;
                    QQToast.makeText(activity, 1, activity.getString(R.string.bj6), 0).show(((BaseActivity) ForwardShareCardOption.this.mActivity).getTitleBarHeight());
                }
            }
            ForwardShareCardOption.this.f210878d = -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends com.tencent.qidian.controller.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardShareCardOption.this);
            }
        }

        @Override // com.tencent.qidian.controller.a
        protected void l(boolean z16, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            ForwardShareCardOption.this.hideProgressDialog();
            if (ForwardShareCardOption.this.f210878d != -1) {
                if (z16 && hashMap != null) {
                    String str = (String) hashMap.get("uin");
                    String str2 = (String) hashMap.get("url");
                    ForwardShareCardOption.this.f210879e = str2;
                    ForwardShareCardOption.this.f210880f = str2;
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + ForwardShareCardOption.this.f210879e + " mTroopNotNeedVefifyLink=" + ForwardShareCardOption.this.f210880f);
                    }
                    if (str != null && str.equals(ForwardShareCardOption.this.G)) {
                        ForwardShareCardOption.this.Q();
                    }
                } else {
                    Activity activity = ForwardShareCardOption.this.mActivity;
                    QQToast.makeText(activity, 1, activity.getString(R.string.bj6), 0).show(((BaseActivity) ForwardShareCardOption.this.mActivity).getTitleBarHeight());
                }
                ForwardShareCardOption.this.f210878d = -1;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardShareCardOption.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void n(boolean z16, int i3, long j3, String str, String str2, long j16) {
            String qqStr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str, str2, Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShareCardOption", 2, "onGetFlyTicket: " + z16 + " sigUrl=" + str);
            }
            if (!z16) {
                ForwardShareCardOption.this.hideProgressDialog();
                if (i3 != 1) {
                    if (i3 != 2) {
                        qqStr = HardCodeUtil.qqStr(R.string.mqt);
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.mqz);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f172012mr0);
                }
                ForwardShareCardOption.this.f210883m = null;
                ForwardShareCardOption.this.f210882i = false;
                QQToast.makeText(ForwardShareCardOption.this.mActivity, 1, qqStr, 0).show(((BaseActivity) ForwardShareCardOption.this.mActivity).getTitleBarHeight());
                return;
            }
            if (ForwardShareCardOption.this.G != null && Long.parseLong(ForwardShareCardOption.this.G) == j16) {
                if (ForwardShareCardOption.this.f210882i) {
                    ForwardShareCardOption.this.f210883m = str;
                    ForwardShareCardOption forwardShareCardOption = ForwardShareCardOption.this;
                    forwardShareCardOption.F(forwardShareCardOption.G, true);
                }
                ForwardShareCardOption.this.f210882i = false;
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void u(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + z16 + ", " + str + "]");
            }
            if (ForwardShareCardOption.this.G != null && ForwardShareCardOption.this.G.equals(str)) {
                ForwardShareCardOption forwardShareCardOption = ForwardShareCardOption.this;
                forwardShareCardOption.F(forwardShareCardOption.G, false);
            }
        }
    }

    public ForwardShareCardOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210878d = -1;
        this.f210882i = false;
        this.S = false;
        this.T = new b();
        this.U = new c();
        this.V = new d();
    }

    private static com.tencent.mobileqq.structmsg.a A(String str) {
        com.tencent.mobileqq.structmsg.view.ag agVar = new com.tencent.mobileqq.structmsg.view.ag();
        agVar.C(1);
        agVar.s(str);
        return agVar;
    }

    private void B(boolean z16) {
        if (com.tencent.mobileqq.troop.utils.k.l(MobileQQ.sMobileQQ.peekAppRuntime(), this.N)) {
            M(this.N);
            return;
        }
        if (com.tencent.mobileqq.profile.util.b.m()) {
            this.S = true;
            int i3 = this.P;
            if (i3 != 0) {
                if (i3 != 1006) {
                    if (i3 != 1024) {
                        if (i3 != 56938) {
                            return;
                        }
                    } else {
                        K(this.N, this.Q);
                        return;
                    }
                }
                I(this.N, this.Q, z16);
                return;
            }
            G(this.N, this.Q);
            return;
        }
        int i16 = this.P;
        if (i16 != 0) {
            if (i16 != 1006) {
                if (i16 != 1024) {
                    if (i16 != 56938) {
                        return;
                    }
                } else {
                    L(this.N, this.Q);
                    return;
                }
            }
            J(this.N, this.Q, z16);
            return;
        }
        H(this.N, this.Q);
    }

    private void C(CardOCRInfo cardOCRInfo) {
        if (cardOCRInfo == null) {
            return;
        }
        AbsShareMsg.a aVar = new AbsShareMsg.a(StructMsgForGeneralShare.class);
        String str = "";
        if (cardOCRInfo.f200892d == null) {
            cardOCRInfo.f200892d = "";
        }
        List<String> list = cardOCRInfo.f200895h;
        if (list != null && list.size() > 0) {
            String str2 = cardOCRInfo.f200895h.get(0);
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        String str3 = "url=" + cardOCRInfo.f200893e + ";name=" + cardOCRInfo.f200892d + ";phone=" + str;
        AbsShareMsg a16 = aVar.g(73).d(this.mActivity.getString(R.string.f_d, cardOCRInfo.f200892d)).f(2).b("shareBusinessCard", "", str3, str3, str3).e(this.mActivity.getResources().getString(R.string.hip)).a();
        com.tencent.mobileqq.structmsg.view.ag agVar = new com.tencent.mobileqq.structmsg.view.ag();
        agVar.C(1);
        agVar.s(this.mActivity.getString(R.string.f_a));
        com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
        uVar.C(3);
        uVar.m(new com.tencent.mobileqq.structmsg.view.c(cardOCRInfo.f200893e + "/?02"));
        uVar.m(new StructMsgItemTitle(cardOCRInfo.f200892d));
        uVar.m(new ap(str));
        a16.addItem(agVar);
        a16.addItem(uVar);
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 5);
        bundle.putString("image_url", cardOCRInfo.f200893e);
        BusinessCardUtils.d(cardOCRInfo.f200893e);
        this.F = com.tencent.mobileqq.structmsg.i.d(((StructMsgForImageShare) com.tencent.mobileqq.structmsg.i.e(bundle)).getBytes());
        this.mExtraData.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        buildConfirmDialog();
    }

    private void D(ProfileCardShareBean profileCardShareBean) {
        com.tencent.mobileqq.profile.util.b.d(this.app, profileCardShareBean, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            buildConfirmDialog();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardShareCardOption.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardShareCardOption.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ForwardShareCardOption.this.buildConfirmDialog();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, boolean z16) {
        hideProgressDialog();
        QQToast.makeText(this.mActivity, -1, HardCodeUtil.qqStr(R.string.f172014mr2), 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private void G(String str, String str2) {
        String str3 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + str;
        D(new ProfileCardShareBean(Long.parseLong(str), str3, str3, "AppCmd://OpenContactInfo/?uin=" + str, false));
    }

    private void H(String str, String str2) {
        AbsShareMsg.a aVar = new AbsShareMsg.a(StructMsgForGeneralShare.class);
        String str3 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + str;
        String str4 = "AppCmd://OpenContactInfo/?uin=" + str;
        String G = com.tencent.mobileqq.utils.ac.G(this.app, str);
        if (!TextUtils.isEmpty(G)) {
            str2 = G;
        }
        AbsShareMsg a16 = aVar.g(14).f(2).f(1).d(HardCodeUtil.qqStr(R.string.mqs) + str2).b("plugin", "", str4, str3, str3).e(this.mActivity.getResources().getString(R.string.gzb)).a();
        com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
        uVar.C(1);
        uVar.m(new com.tencent.mobileqq.structmsg.view.c(str3));
        uVar.m(new StructMsgItemTitle(str2));
        uVar.m(new ap(HardCodeUtil.qqStr(R.string.mpv) + str));
        a16.addItem(A(HardCodeUtil.qqStr(R.string.mq5)));
        a16.addItem(uVar);
        this.mExtraData.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        this.E = a16;
        buildConfirmDialog();
    }

    private void I(String str, String str2, boolean z16) {
        this.C = true;
        D(N(this.app, str, str2, z16));
    }

    private void J(String str, String str2, boolean z16) {
        this.C = true;
        AbsShareMsg O = O(this.app, this.mActivity, str, str2, z16);
        this.mExtraData.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, O.getBytes());
        this.E = O;
        buildConfirmDialog();
    }

    private void K(String str, String str2) {
        if (!QidianManager.P(this.app, str)) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ForwardOption.ForwardShareCardOption");
        if (friendsSimpleInfoWithUid == null) {
            return;
        }
        D(new ProfileCardShareBean(Long.parseLong(str), "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + str + "&version=1&cspecialflag=" + friendsSimpleInfoWithUid.e(), "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + str + "&cspecialflag=" + friendsSimpleInfoWithUid.e(), "", false));
    }

    private void L(String str, String str2) {
        if (!QidianManager.P(this.app, str)) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ForwardOption.ForwardShareCardOption");
        if (friendsSimpleInfoWithUid != null) {
            AbsShareMsg.a aVar = new AbsShareMsg.a(StructMsgForGeneralShare.class);
            String str3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + str + "&cspecialflag=" + friendsSimpleInfoWithUid.e();
            String str4 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + str + "&version=1&cspecialflag=" + friendsSimpleInfoWithUid.e();
            String str5 = "https://share.mp.qq.com/cgi/share.php?uin=" + str + "&account_flag=-7&jumptype=1&card_type=crm&cspecialflag=" + friendsSimpleInfoWithUid.e();
            String str6 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + str;
            String v3 = QidianManager.v(this.app, str);
            if (!TextUtils.isEmpty(v3)) {
                str2 = v3;
            }
            AbsShareMsg a16 = aVar.g(14).f(2).f(1).d(HardCodeUtil.qqStr(R.string.mqu) + str2).b("plugin", str5, "", str3, str4).e(this.mActivity.getResources().getString(R.string.gzb)).a();
            com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
            uVar.C(1);
            uVar.m(new com.tencent.mobileqq.structmsg.view.c(str6));
            uVar.m(new StructMsgItemTitle(str2));
            uVar.m(new ap(HardCodeUtil.qqStr(R.string.mr6) + QidianManager.w(this.app, str)));
            a16.addItem(A(HardCodeUtil.qqStr(R.string.mqy)));
            a16.addItem(uVar);
            this.mExtraData.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
            this.E = a16;
            buildConfirmDialog();
        }
    }

    private void M(final String str) {
        if (!NetworkUtil.isNetSupport(this.mActivity)) {
            Activity activity = this.mActivity;
            QQToast.makeText(activity, activity.getString(R.string.b3j), 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            showProgressDialog(R.string.cpr);
            com.tencent.mobileqq.troop.utils.k.g(MobileQQ.sMobileQQ.peekAppRuntime(), str, new com.tencent.mobileqq.troop.api.a() { // from class: com.tencent.mobileqq.forward.y
                @Override // com.tencent.mobileqq.troop.api.a
                public final void onResult(String str2) {
                    ForwardShareCardOption.this.T(str, str2);
                }
            });
        }
    }

    public static final ProfileCardShareBean N(QQAppInterface qQAppInterface, String str, String str2, boolean z16) {
        String trim;
        String str3;
        if (str2 == null) {
            trim = "";
        } else {
            trim = str2.trim();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=");
        sb5.append(URLEncoder.encode(trim));
        if (z16) {
            str3 = "";
        } else {
            str3 = "&headtext=" + URLEncoder.encode(com.tencent.mobileqq.utils.ac.L(trim));
        }
        sb5.append(str3);
        sb5.append("&version=1&uin=");
        sb5.append(str);
        sb5.append("");
        String sb6 = sb5.toString();
        return new ProfileCardShareBean(str, sb6, sb6, "AppCmd://OpenContactInfo/?uin=", true);
    }

    public static final AbsShareMsg O(QQAppInterface qQAppInterface, Activity activity, String str, String str2, boolean z16) {
        String trim;
        String str3;
        String str4;
        int i3;
        AbsShareMsg.a aVar = new AbsShareMsg.a(StructMsgForGeneralShare.class);
        if (str2 == null) {
            trim = "";
        } else {
            trim = str2.trim();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=");
        sb5.append(URLEncoder.encode(trim));
        if (z16) {
            str3 = "";
        } else {
            str3 = "&headtext=" + URLEncoder.encode(com.tencent.mobileqq.utils.ac.L(trim));
        }
        sb5.append(str3);
        sb5.append("&version=1&uin=");
        sb5.append(str);
        sb5.append("");
        String sb6 = sb5.toString();
        AbsShareMsg a16 = aVar.g(84).f(2).d(HardCodeUtil.qqStr(R.string.mqa) + trim).b("plugin", "", "AppCmd://OpenContactInfo/?uin=", sb6, sb6).e(activity.getResources().getString(R.string.gzf)).a();
        com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
        uVar.C(1);
        uVar.m(new com.tencent.mobileqq.structmsg.view.c(sb6));
        uVar.m(new StructMsgItemTitle(trim));
        if (str.startsWith("+86")) {
            str4 = str.substring(3, str.length());
        } else {
            str4 = str;
        }
        if (z16) {
            i3 = R.string.mqx;
        } else {
            i3 = R.string.mqf;
        }
        String qqStr = HardCodeUtil.qqStr(i3);
        ap apVar = new ap(qqStr + str4);
        apVar.C(qqStr + str);
        uVar.m(apVar);
        a16.addItem(A(HardCodeUtil.qqStr(R.string.f172016mr4)));
        a16.addItem(uVar);
        return a16;
    }

    private void P() {
        this.S = true;
        this.mExtraData.putAll(((ITroopShareApi) QRoute.api(ITroopShareApi.class)).parseArkJson(this.f210881h).getExtras());
        this.mExtraData.putBoolean("is_ark_display_share", true);
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        String str;
        if (!TextUtils.isEmpty(this.f210881h)) {
            P();
            return;
        }
        this.S = false;
        String str2 = this.H;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.G;
        }
        String str3 = ((ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.G, 0) + "100";
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(15).d(this.mActivity.getString(R.string.gzi) + str2).j(this.f210879e).a();
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
        String string = this.mActivity.getString(R.string.hjq);
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (str = this.G) != null) {
            TroopInfo k3 = troopManager.k(str);
            if (k3 != null) {
                if (!TextUtils.isEmpty(k3.mRichFingerMemo)) {
                    string = k3.mRichFingerMemo;
                    if (QLog.isColorLevel()) {
                        QLog.e("ForwardOption.ForwardShareCardOption", 2, "summary=" + string);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
            }
        }
        c16.p(str3, str2, string, 1);
        a16.addItem(A(HardCodeUtil.qqStr(R.string.f172009mq3)));
        a16.addItem(c16);
        this.mExtraData.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        this.E = a16;
        if (QLog.isColorLevel()) {
            QLog.i("ForwardOption.ForwardShareCardOption", 2, "createTroopCardMsg.mMsgServiceID:" + a16.mMsgServiceID + " mMsgBrief:" + a16.mMsgBrief + " mContentTitle:" + a16.mContentTitle + " mContentSummary:" + a16.mContentSummary + " mMsgUrl:" + a16.mMsgUrl + " coverUrl:" + str3 + " mSourceName:" + a16.mSourceName);
        }
        buildConfirmDialog();
    }

    private View R() {
        if (this.E != null) {
            new RelativeLayout.LayoutParams(-1, -2).setMargins(BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
            }
            return this.E.getPreDialogView(this.mActivity, null);
        }
        return new View(this.mActivity);
    }

    private View S(String str, Drawable drawable) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f167855jm, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.kfb);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dic);
        textView.setText(str);
        imageView.setImageDrawable(drawable);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(String str, String str2) {
        hideProgressDialog();
        if (str2 != null && !str2.isEmpty()) {
            this.S = true;
            this.mExtraData.putAll(com.tencent.mobileqq.troop.utils.k.c(this.mActivity, str, str2));
            this.mExtraData.putBoolean("is_ark_display_share", true);
            E();
            return;
        }
        QLog.e("ForwardOption.ForwardShareCardOption", 1, "fetchRobotShareInfo failed fetch arkInfo");
    }

    private void U() {
        boolean z16;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            Activity activity = this.mActivity;
            QQToast.makeText(activity, activity.getString(R.string.b3j), 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            if (QLog.isColorLevel()) {
                QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
            }
            this.f210878d = -1;
        }
        showProgressDialog(R.string.cpr);
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager.V(this.G)) {
            ((QidianHandler) this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).M2(this.G, troopManager.B(this.G).troopowneruin);
            return;
        }
        com.tencent.mobileqq.troop.troopmanager.api.a aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
        String str = this.G;
        if (this.f210878d == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.w(str, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        AbsStructMsg absStructMsg = this.F;
        if (absStructMsg != null) {
            qQCustomDialog.addView(absStructMsg.getPreDialogView(this.mActivity, null));
            return true;
        }
        if (this.E != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
            }
            qQCustomDialog.addView(this.E.getPreDialogView(this.mActivity, null), layoutParams);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        int selfBindState = ((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
        if (selfBindState >= 9 || (this.M == 23 && (selfBindState == 1 || selfBindState == 2 || selfBindState == 6 || selfBindState == 7 || selfBindState == 3))) {
            this.mForwardAbilities.add(e.U3);
        }
        this.mForwardAbilities.add(e.Y3);
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + selfBindState + ", type=" + this.M);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
    
        if (r1 != 56938) goto L37;
     */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bundle);
            return;
        }
        if (hf0.a.a("ForwardOption.ForwardShareCardOption") || !handleDialog()) {
            return;
        }
        this.E = null;
        this.P = bundle.getInt("uintype");
        this.N = bundle.getString("uin");
        this.Q = bundle.getString("uinname");
        this.R = bundle.getString("troop_uin");
        CardOCRInfo cardOCRInfo = (CardOCRInfo) bundle.getParcelable("business_card_ocr");
        boolean z16 = bundle.getBoolean(AppConstants.Key.BIND_CONTACT, true);
        this.mExtraData.putString("uin", this.J);
        this.mExtraData.putInt("uintype", this.I);
        this.mExtraData.putString("troop_uin", this.L);
        this.mExtraData.putString("uinname", this.K);
        int i16 = this.P;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 30) {
                    if (i16 != 1006 && i16 != 1024) {
                        if (i16 == 3000) {
                            this.G = this.N;
                            this.H = this.Q;
                            this.f210882i = true;
                            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                                Activity activity = this.mActivity;
                                QQToast.makeText(activity, activity.getString(R.string.b3j), 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                return;
                            } else {
                                this.D.Y2(Long.parseLong(this.N), true);
                                showProgressDialog(R.string.cpr);
                            }
                        }
                    }
                } else {
                    this.G = null;
                    this.H = null;
                    C(cardOCRInfo);
                }
            } else {
                this.G = this.N;
                this.H = this.Q;
                this.f210878d = 0;
                U();
            }
            this.mExtraData.putInt("key_forward_ability_type", i3);
        }
        this.G = null;
        this.H = null;
        B(z16);
        this.mExtraData.putInt("key_forward_ability_type", i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        View S;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        int i3 = this.P;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 30) {
                    if (i3 != 1006) {
                        if (i3 != 1024) {
                            if (i3 != 3000) {
                                if (i3 != 56938) {
                                    S = R();
                                }
                            } else {
                                S = S(String.format("[%s]%s", HardCodeUtil.qqStr(R.string.mqr), this.Q), FaceDrawable.getFaceDrawable(this.app, 101, this.N));
                            }
                        } else {
                            S = R();
                        }
                    }
                    S = S(String.format("[%s]%s", HardCodeUtil.qqStr(R.string.mr7), this.Q), FaceDrawable.getFaceDrawable(this.app, 11, this.N));
                } else {
                    AbsStructMsg absStructMsg = this.F;
                    if (absStructMsg != null) {
                        S = absStructMsg.getPreDialogView(this.mActivity, null);
                    } else {
                        S = null;
                    }
                }
            } else {
                S = S(String.format("[%s]%s", HardCodeUtil.qqStr(R.string.mqd), this.Q), FaceDrawable.getFaceDrawable(this.app, 4, this.N));
            }
        } else {
            S = S(String.format("[%s]%s", HardCodeUtil.qqStr(R.string.mqi), this.Q), FaceDrawable.getFaceDrawable(this.app, 1, this.N));
        }
        if (S == null) {
            return new View(this.mActivity);
        }
        return S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.forwardOnCancel();
        if (this.C) {
            ReportController.o(this.app, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
        super.forwardOnConfirm();
        if (this.C) {
            ReportController.o(this.app, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!TextUtils.isEmpty(this.K)) {
            return this.K;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mActivity.getString(R.string.hiq);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.troopmanager.api.b bVar = this.T;
        if (bVar != null) {
            this.app.removeObserver(bVar);
        }
        com.tencent.mobileqq.discussion.observer.a aVar = this.V;
        if (aVar != null) {
            this.app.removeObserver(aVar);
        }
        com.tencent.qidian.controller.a aVar2 = this.U;
        if (aVar2 != null) {
            this.app.removeObserver(aVar2);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.app.addObserver(this.T);
        this.app.addObserver(this.V);
        this.app.addObserver(this.U);
        this.D = (DiscussionHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        this.J = this.mIntent.getStringExtra("curent_aio_uin");
        this.K = this.mIntent.getStringExtra("curent_aio_uinname");
        this.I = this.mIntent.getIntExtra("curent_aio_uin_type", 0);
        this.L = this.mIntent.getStringExtra("curent_aio_troop_uin");
        this.M = this.mIntent.getIntExtra("forward_type", -1);
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void processSaveInstanceBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        this.mExtraData.putString("uin", this.N);
        this.mExtraData.putInt("uintype", this.P);
        this.mExtraData.putString("troop_uin", this.R);
        this.mExtraData.putString("uinname", this.Q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return !this.S;
    }
}
