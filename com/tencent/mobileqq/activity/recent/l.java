package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.debug.api.IQQDebugApi;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.recommend.api.ITroopFindNewEntranceApi;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.PopupMenuDialog;
import cooperation.ilive.manager.ILiveDbManagerApi;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final int[] T;
    public static final int[] U;
    private static final int[] V;
    private static final int[] W;
    private static final int[] X;
    private static final int[] Y;
    private static final int[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final int[] f185655a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final int[] f185656b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final int[] f185657c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final int[] f185658d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final int[] f185659e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final int[] f185660f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final int[] f185661g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final int[] f185662h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final int[] f185663i0;
    private boolean C;
    private boolean D;
    private TextView E;
    private ImageView F;
    public boolean G;
    public boolean H;
    PopupMenuDialog I;
    private List<PopupMenuDialog.MenuItem> J;
    private int K;
    private boolean L;
    private boolean M;
    private RedTouch N;
    private RedTouch P;
    public boolean Q;
    private boolean R;
    private QQProgressDialog S;

    /* renamed from: d, reason: collision with root package name */
    public BaseActivity f185664d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f185665e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185666f;

    /* renamed from: h, reason: collision with root package name */
    private String f185667h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f185668i;

    /* renamed from: m, reason: collision with root package name */
    private String f185669m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements PopupMenuDialog.OnClickActionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
        public void onClickAction(PopupMenuDialog.MenuItem menuItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) menuItem);
                return;
            }
            int i3 = menuItem.f384641id;
            if (i3 == R.string.fbx) {
                l.this.j();
                return;
            }
            if (i3 == R.string.adp) {
                l.this.i(false);
                l.this.I("qq_clck", 3);
                return;
            }
            if (i3 == R.string.conversation_options_saoyisao) {
                l.this.n();
                l.this.I("qq_clck", 4);
                return;
            }
            if (i3 == R.string.adx) {
                l.this.k();
                l.this.I("qq_clck", 5);
                return;
            }
            if (i3 == R.string.ae6) {
                l.this.m();
                return;
            }
            if (i3 == R.string.adu) {
                l.this.u(8);
                l.this.I("qq_clck", 6);
                ReportController.o(l.this.f185664d.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "jiahao.fukuan.click", 0, 0, "", "", "", "");
                return;
            }
            if (i3 == R.string.conversation_options_multichat) {
                l.this.l();
                l.this.I("qq_clck", 1);
                return;
            }
            if (i3 == R.string.adw) {
                l.this.r();
                return;
            }
            if (i3 == R.string.conversation_options_mini_app) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).handleMiniAppMoreClick(l.this.f185664d);
                ReportController.o(l.this.f185664d.app, "dc00898", "", "", "0X8009CB9", "0X8009CB9", 0, 0, "", "", "", "");
                return;
            }
            if (i3 == R.string.imk) {
                l.this.s();
                return;
            }
            if (i3 == R.string.f2044652z) {
                l.this.t();
                return;
            }
            if (i3 == R.string.wh6) {
                l.this.G();
                return;
            }
            if (i3 == R.string.zoq) {
                com.tencent.mobileqq.alpha.a.c();
                return;
            }
            if (i3 == R.string.zop) {
                if (menuItem.itemView != null) {
                    IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                    l lVar = l.this;
                    iGuildMainFrameApi.doOpenCreateGuild(lVar.f185664d, menuItem.itemView, lVar.K);
                } else {
                    IGuildMainFrameApi iGuildMainFrameApi2 = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                    l lVar2 = l.this;
                    iGuildMainFrameApi2.doOpenCreateGuild(lVar2.f185664d, lVar2.I.getContentView(), l.this.K);
                }
                l.this.I("qq_clck", 2);
                return;
            }
            if (i3 == R.string.zon) {
                l.this.i(true);
                l.this.I("qq_clck", 7);
            } else if (i3 == R.string.zoo) {
                QPublicFragmentActivity.start(l.this.f185664d, new Intent(), RecommendTroopFragment.class);
                l.this.I("qq_clck", 8);
            } else if (QQAudioHelper.f()) {
                ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).onDebugMenuEvent(menuItem, l.this.f185664d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements PopupMenuDialog.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.widget.PopupMenuDialog.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                l.this.K();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements com.tencent.mobileqq.qroute.route.o {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                QLog.i("RecentOptPopBar", 2, "start QrcodeHbGuiderActivity onSuccess");
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("RecentOptPopBar", 2, "start QrcodeHbGuiderActivity onSuccess");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69162);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        T = new int[]{R.string.adp, TokenResUtils.getTokenRes(R.drawable.conversation_options_addmember, R.drawable.qui_add_friend), R.color.qui_common_text_primary};
        U = new int[]{R.string.conversation_options_saoyisao, TokenResUtils.getTokenRes(R.drawable.conversation_options_qr, R.drawable.qui_scan), R.color.qui_common_text_primary};
        V = new int[]{R.string.adx, TokenResUtils.getTokenRes(R.drawable.conversation_facetoface_qr, R.drawable.qui_face_to_face_transmit), R.color.qui_common_text_primary};
        W = new int[]{R.string.adu, TokenResUtils.getTokenRes(R.drawable.conversation_options_charge_icon, R.drawable.qui_receive_payment), R.color.qui_common_text_primary};
        X = new int[]{R.string.ae6, TokenResUtils.getTokenRes(R.drawable.conversation_options_camera, R.drawable.qui_camera_aio_oversized), R.color.qui_common_text_primary};
        Y = new int[]{R.string.conversation_options_multichat, TokenResUtils.getTokenRes(R.drawable.conversation_options_multichat, R.drawable.qui_group_building), R.color.qui_common_text_primary};
        Z = new int[]{R.string.adw, TokenResUtils.getTokenRes(R.drawable.cji, R.drawable.qui_luckymoney), R.color.qui_common_text_primary};
        f185655a0 = new int[]{R.string.f170797ae0, TokenResUtils.getTokenRes(R.drawable.cjm, R.drawable.qui_more), R.color.qui_common_text_primary};
        f185656b0 = new int[]{R.string.conversation_options_mini_app, TokenResUtils.getTokenRes(R.drawable.conversation_options_mini_app, R.drawable.qui_game), R.color.qui_common_text_primary};
        f185657c0 = new int[]{R.string.f2044652z, TokenResUtils.getTokenRes(R.drawable.conversation_options_qq_live, R.drawable.qui_super_member_live), R.color.qui_common_text_primary};
        f185658d0 = new int[]{R.string.imk, TokenResUtils.getTokenRes(R.drawable.conversation_options_limit_chat, R.drawable.qui_jieban), R.color.qui_common_text_primary};
        f185659e0 = new int[]{R.string.wh6, TokenResUtils.getTokenRes(R.drawable.conversation_options_av_game, R.drawable.qui_party_together), R.color.qui_common_text_primary};
        f185660f0 = new int[]{R.string.zoq, TokenResUtils.getTokenRes(R.drawable.conversation_options_limit_chat, R.drawable.qui_jieban), R.color.qui_common_text_primary};
        f185661g0 = new int[]{R.string.zop, TokenResUtils.getTokenRes(R.drawable.qui_channel, R.drawable.qui_channel), R.color.qui_common_text_primary};
        f185662h0 = new int[]{R.string.zon, TokenResUtils.getTokenRes(R.drawable.conversation_options_addmember, R.drawable.qui_add_friend), R.color.qui_common_text_primary};
        f185663i0 = new int[]{R.string.zoo, TokenResUtils.getTokenRes(R.drawable.qui_group, R.drawable.qui_group), R.color.qui_common_text_primary};
    }

    public l(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivity);
            return;
        }
        this.f185665e = false;
        this.f185666f = false;
        this.f185667h = "";
        this.f185668i = false;
        this.C = false;
        this.D = false;
        this.E = null;
        this.F = null;
        this.H = false;
        this.K = 1;
        this.L = false;
        this.M = StudyModeManager.w();
        this.N = null;
        this.P = null;
        this.Q = false;
        this.R = false;
        this.S = null;
        this.f185664d = baseActivity;
    }

    private boolean A() {
        boolean z16;
        String iliveDrawerData = ((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).getIliveDrawerData(ILiveDbManagerApi.KEY_DRAWER_PLUS_TEXT);
        String str = this.f185669m;
        if (str != null && !str.equals(iliveDrawerData)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).isAnchorShowEntrance() != this.f185668i || z16) {
            return true;
        }
        return false;
    }

    public static void F(Intent intent, FrameHelperActivity frameHelperActivity) {
        if (intent != null && frameHelperActivity != null && (frameHelperActivity.getBaseActivity() instanceof SplashActivity)) {
            SplashActivity splashActivity = (SplashActivity) frameHelperActivity.getBaseActivity();
            if (intent.getBooleanExtra("open_leba_tab_fragment", false)) {
                splashActivity.openMainFragment(intent);
            } else if (intent.getBooleanExtra("open_chatfragment", false)) {
                RecentUtil.z0(splashActivity, intent);
            }
        }
    }

    private void H() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IWebProcessManagerService) peekAppRuntime.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, int i3) {
        HashMap hashMap = new HashMap(q());
        hashMap.put("qq_pgid", "pg_bas_msglist");
        hashMap.put("qq_eid", "em_group_plus_panel");
        hashMap.put("dt_pgid", "pg_bas_msglist");
        hashMap.put("dt_eid", "em_group_plus_panel");
        hashMap.put("eid", "em_group_plus_panel");
        hashMap.put("click_type", Integer.valueOf(i3));
        VideoReport.reportEvent(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f185664d.app.getRuntimeService(IRedTouchManager.class, "");
        iRedTouchManager.onRedTouchItemClick(iRedTouchManager.getAppInfoByPath("140101"), null);
    }

    private void e(com.tencent.mobileqq.activity.recent.config.optpopbar.a aVar) {
        boolean y16 = y();
        boolean z16 = true;
        QLog.d("RecentOptPopBar", 1, "liveBizSwitch: " + y16 + " isQQLiveSwitch: " + aVar.j());
        if (!y16 || !aVar.j() || z(BaseApplication.getContext())) {
            z16 = false;
        }
        this.f185668i = z16;
        if (z16) {
            PopupMenuDialog.MenuItem f16 = f(f185657c0);
            String iliveDrawerData = ((ILiveDbManagerApi) QRoute.api(ILiveDbManagerApi.class)).getIliveDrawerData(ILiveDbManagerApi.KEY_DRAWER_PLUS_TEXT);
            if (this.f185664d.getResources() != null) {
                TextUtils.isEmpty(this.f185664d.getResources().getString(R.string.f2044652z));
            }
            if (TextUtils.isEmpty(iliveDrawerData)) {
                iliveDrawerData = "\u53d1\u8d77\u76f4\u64ad";
            }
            f16.title = iliveDrawerData;
            this.f185669m = iliveDrawerData;
            this.J.add(f16);
        }
    }

    public static boolean g(QBaseActivity qBaseActivity) {
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            return false;
        }
        if (qBaseActivity.isInMultiWindow()) {
            QQToast.makeText(qBaseActivity, HardCodeUtil.qqStr(R.string.sv7), 0).show();
            return false;
        }
        return true;
    }

    public static void o(QBaseActivity qBaseActivity, long j3, long j16, int i3) {
        if (!g(qBaseActivity)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("from", "Conversation");
        intent.putExtra("from_+", true);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, qBaseActivity.getString(R.string.button_back));
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, qBaseActivity.getString(R.string.button_back));
        intent.putExtra("start_time", System.currentTimeMillis());
        intent.putExtra("key_entrance_type", 1);
        Bundle bundle = new Bundle();
        bundle.putLong("PromotionType", j3);
        bundle.putLong("RecoglizeMask", j16);
        bundle.putString("H5Source", String.valueOf(i3));
        intent.putExtra("web_invoke_params", bundle);
        intent.putExtra("preload_process", true);
        intent.setFlags(67108864);
        RouteUtils.startActivity(qBaseActivity, intent, "/qrscan/scanner");
    }

    private HashMap<String, String> q() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dt_pgid", "pg_bas_msglist");
        hashMap.put("pgid", "pg_bas_msglist");
        hashMap.put("home_uin", this.f185664d.getCurrentAccountUin());
        hashMap.put("uid", this.f185664d.app.getCurrentUid());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Intent intent = new Intent();
        intent.putExtra("source", 1);
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).jumpToQQLivePrepareFragment(this.f185664d, true, intent);
    }

    private void v(com.tencent.mobileqq.activity.recent.config.optpopbar.a aVar) {
        if ((this.D && !((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.f185664d.getCurrentAccountUin(), IQWalletPreferenceApi.KEY_F2F_REDPACK_ENTRY, false)) || (!this.D && ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.f185664d.getCurrentAccountUin(), IQWalletPreferenceApi.KEY_F2F_REDPACK_ENTRY, false))) {
            x(aVar);
        }
        if (((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).isShowF2FRedpackEntryColor(this.f185664d.getCurrentAccountUin())) {
            TextView textView = this.E;
            if (textView != null) {
                textView.setTextColor(textView.getResources().getColor(R.color.f157011hh));
            }
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.cji);
                return;
            }
            return;
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setTextColor(textView2.getResources().getColor(R.color.skin_black));
        }
        ImageView imageView2 = this.F;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.cjj);
        }
    }

    private void w() {
        if (this.N == null || this.P == null) {
            LinearLayout linearLayout = (LinearLayout) this.I.getContentView().findViewById(R.id.content);
            for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
                try {
                    View childAt = linearLayout.getChildAt(i3);
                    if (((PopupMenuDialog.MenuItem) childAt.getTag()).f384641id == R.string.adp) {
                        this.N = new RedTouch(this.f185664d, (TextView) childAt.findViewById(R.id.jjk)).setGravity(21).applyTo();
                    } else if (((PopupMenuDialog.MenuItem) childAt.getTag()).f384641id == R.string.conversation_options_saoyisao) {
                        this.P = new RedTouch(this.f185664d, childAt.findViewById(R.id.jjk)).setGravity(21).applyTo();
                    } else if (((PopupMenuDialog.MenuItem) childAt.getTag()).f384641id == R.string.adw) {
                        this.E = (TextView) childAt.findViewById(R.id.jjk);
                        this.F = (ImageView) childAt.findViewById(R.id.di9);
                        if (((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).isShowF2FRedpackEntryColor(this.f185664d.getCurrentAccountUin())) {
                            TextView textView = this.E;
                            textView.setTextColor(textView.getResources().getColor(R.color.f157011hh));
                            this.F.setImageResource(R.drawable.cji);
                        } else {
                            TextView textView2 = this.E;
                            textView2.setTextColor(textView2.getResources().getColor(R.color.skin_black));
                            this.F.setImageResource(R.drawable.cjj);
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (this.N != null) {
            this.N.parseRedTouch(((IRedTouchManager) this.f185664d.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("101210.101211"));
        }
        if (this.P != null) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f185664d.app.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("140101");
            this.P.parseRedTouch(appInfoByPath);
            iRedTouchManager.onRedTouchItemExposure(appInfoByPath, null);
            iRedTouchManager.checkMsgExpire();
        }
    }

    private boolean z(Context context) {
        if (context == null) {
            return false;
        }
        if (!com.tencent.qqlive.common.screen.a.d(context) && !com.tencent.qqlive.common.screen.a.g(context) && !com.tencent.qqlive.common.screen.a.h(context)) {
            return false;
        }
        return true;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) this.f185664d.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("140101");
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0 && appInfoByPath.exposure_max.get() > 0 && appInfoByPath.red_display_info.get() != null && appInfoByPath.red_display_info.red_type_info.get().size() > 0) {
            QLog.i("RecentOptPopBar", 1, "needsExposeRedTouchUpward: QRScanner exposing");
            return true;
        }
        return false;
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        PopupMenuDialog popupMenuDialog = this.I;
        if (popupMenuDialog != null) {
            popupMenuDialog.onPause();
        }
    }

    protected void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            ReportController.o(this.f185664d.app, "dc00898", "", "", "0X800B010", "0X800B010", 0, 0, "", "", "", "");
        }
    }

    public void J(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
            return;
        }
        HashMap hashMap = new HashMap(q());
        hashMap.put("cur_pg", q());
        hashMap.put("dt_eid", "em_group_plus_btn");
        hashMap.put("eid", "em_group_plus_btn");
        VideoReport.reportEvent("clck", hashMap);
        HashMap hashMap2 = new HashMap(q());
        hashMap2.put("qq_pgid", "pg_bas_msglist");
        hashMap2.put("qq_eid", "em_group_plus_panel");
        hashMap2.put("dt_pgid", "pg_bas_msglist");
        hashMap2.put("dt_eid", "em_group_plus_panel");
        hashMap2.put("eid", "em_group_plus_panel");
        VideoReport.reportEvent("qq_imp", hashMap2);
    }

    public void L(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.K = i3;
        }
    }

    public void M(View view, int i3, int i16) {
        String limitChatOnPlusName;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.activity.recent.config.optpopbar.a aVar = (com.tencent.mobileqq.activity.recent.config.optpopbar.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101223");
        if (aVar != null && !com.tencent.mobileqq.activity.recent.config.optpopbar.a.c(aVar)) {
            PopupMenuDialog popupMenuDialog = this.I;
            if (popupMenuDialog != null && popupMenuDialog.mNeedRebuild) {
                if (popupMenuDialog.isShowing()) {
                    this.I.dismiss();
                }
                this.I = null;
            }
            if (this.I == null) {
                x(aVar);
                if (this.I == null) {
                    return;
                }
            } else {
                if (this.M != StudyModeManager.w()) {
                    this.G = true;
                    this.M = StudyModeManager.w();
                }
                if (this.f185666f && (limitChatOnPlusName = ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).getLimitChatOnPlusName(this.f185664d.app)) != null && (str = this.f185667h) != null && !limitChatOnPlusName.equals(str)) {
                    this.G = true;
                }
                if (A()) {
                    this.G = true;
                }
                if ((this.f185666f && !((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.f185664d.app)) || (!this.f185666f && ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.f185664d.app))) {
                    this.G = true;
                }
                boolean B = B();
                boolean z16 = this.C;
                if ((z16 && !B) || (!z16 && B)) {
                    this.G = true;
                }
                if (this.G) {
                    x(aVar);
                    this.G = false;
                }
                if (C()) {
                    v(aVar);
                }
            }
            this.I.showAsDropDown(view, i3, i16);
            w();
            ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplication.getContext(), "peak_preload_plus_panel");
            H();
            if (this.f185666f) {
                ReportController.o(this.f185664d.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
            }
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        List<PopupMenuDialog.MenuItem> list = this.J;
        if (list != null && list.size() != 0) {
            this.I = PopupMenuDialog.conversationPlusBuild(this.f185664d, this.J, new a(), new b());
            if (this.L) {
                for (PopupMenuDialog.MenuItem menuItem : this.J) {
                    if (menuItem.title.equals(this.f185664d.getResources().getString(R.string.zop))) {
                        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).reportCreateGuild(menuItem.itemView, this.K);
                        return;
                    }
                }
            }
        }
    }

    public PopupMenuDialog.MenuItem f(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PopupMenuDialog.MenuItem) iPatchRedirector.redirect((short) 7, (Object) this, (Object) iArr);
        }
        PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
        menuItem.f384641id = iArr[0];
        menuItem.title = this.f185664d.getResources().getString(iArr[0]);
        menuItem.contentDescription = this.f185664d.getResources().getString(iArr[0]);
        menuItem.iconId = iArr[1];
        if (PopupMenuDialog.is8973RecentOptPopBarTokenEnable() && iArr.length >= 3) {
            menuItem.titleColorRes = iArr[2];
        }
        return menuItem;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (isShowing()) {
            this.I.dismiss();
        }
    }

    protected void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.LeftViewText.LEFTVIEWTEXT, this.f185664d.getString(R.string.button_back));
        bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.f185664d.getString(R.string.button_back));
        bundle.putBoolean("newEntrance", z16);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(this.f185664d, 2, 4, LaunchMode.standard, bundle);
        ReportController.o(this.f185664d.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
        try {
            ((IRedTouchManager) this.f185664d.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101210.101211");
        } catch (Exception unused) {
        }
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        PopupMenuDialog popupMenuDialog = this.I;
        if (popupMenuDialog != null && popupMenuDialog.isShowing()) {
            return true;
        }
        return false;
    }

    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            QQProxyForQlink.P(this.f185664d, 8, null);
            ReportController.o(this.f185664d.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
        }
    }

    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        ((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).launchCreatePage(this.f185664d);
        ReportController.o(this.f185664d.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
        ReportController.o(this.f185664d.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
    }

    protected void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        ReportController.o(this.f185664d.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
        id0.a.n("plus_shoot", "clk_entry", 0, 0, "", "", "", "");
        id0.a.n("plus_shoot", "exp_shoot", 0, 0, "", "", "", "");
    }

    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        o(this.f185664d, 0L, 0L, 0);
        ReportController.o(this.f185664d.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f185664d.app.getRuntimeService(IRedTouchManager.class, "");
        iRedTouchManager.onRedTouchItemClick(iRedTouchManager.getAppInfoByPath("140101"), null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            this.I.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public MiniAppConfBean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MiniAppConfBean) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return MiniAppConfProcessor.j();
    }

    protected void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f185664d, "/qwallet/redpacket/qrcodeHb");
        activityURIRequest.extra().putString("appInfo", "");
        QRoute.startUri(activityURIRequest, new c());
        ReportController.o(this.f185664d.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "jiahao.hongbao.click", 0, 0, "", "", "", "");
    }

    protected void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        BaseActivity baseActivity = this.f185664d;
        if (baseActivity != null && baseActivity.app != null) {
            IExpandEntrance iExpandEntrance = (IExpandEntrance) QRoute.api(IExpandEntrance.class);
            BaseActivity baseActivity2 = this.f185664d;
            iExpandEntrance.enterExpandLimitMatch(baseActivity2, baseActivity2.app, 6);
            ExtendFriendReport.a().m(4);
            ReportController.o(this.f185664d.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
            return;
        }
        QLog.e("RecentOptPopBar", 2, "activity or app is null");
    }

    protected void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        Intent intent = new Intent(this.f185664d, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + i3 + "&entry=2"));
        this.f185664d.startActivityForResult(intent, -1);
        ReportController.o(this.f185664d.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
    }

    public void x(com.tencent.mobileqq.activity.recent.config.optpopbar.a aVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.J = new ArrayList();
        if (aVar.d()) {
            this.J.add(f(Y));
        }
        boolean booleanValue = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSimpleGuildMode().booleanValue();
        boolean z26 = true;
        if (aVar.e() && booleanValue) {
            this.L = true;
            this.J.add(f(f185661g0));
        }
        if (aVar.b()) {
            if (((ITroopFindNewEntranceApi) QRoute.api(ITroopFindNewEntranceApi.class)).canShowNewEntrance()) {
                this.J.add(f(f185662h0));
                if (!StudyModeManager.w()) {
                    this.J.add(f(f185663i0));
                }
            } else {
                this.J.add(f(T));
            }
        }
        if (((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.f185664d.app) && aVar.h()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f185666f = z16;
        if (z16) {
            PopupMenuDialog.MenuItem f16 = f(f185658d0);
            String limitChatOnPlusName = ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).getLimitChatOnPlusName(this.f185664d.app);
            this.f185667h = limitChatOnPlusName;
            if (!TextUtils.isEmpty(limitChatOnPlusName)) {
                String str = this.f185667h;
                f16.title = str;
                f16.contentDescription = str;
            }
            this.J.add(f16);
        }
        if (B() && aVar.g()) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.C = z17;
        if (z17) {
            this.J.add(f(f185659e0));
        }
        if (aVar.l()) {
            this.J.add(f(U));
        }
        if (aVar.f() && QQProxyForQlink.t()) {
            this.J.add(f(V));
        }
        if (aVar.m()) {
            this.J.add(f(W));
        }
        MiniAppConfBean p16 = p();
        if (p16 != null && p16.e()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && aVar.i()) {
            this.J.add(f(f185656b0));
        }
        if (((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.f185664d.getCurrentAccountUin(), IQWalletPreferenceApi.KEY_F2F_REDPACK_ENTRY, false) && C()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19 || !aVar.k()) {
            z26 = false;
        }
        this.D = z26;
        if (z26) {
            this.J.add(f(Z));
            ReportController.o(this.f185664d.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "hongbaocaidan.show", 0, 0, "", "", "", "");
        }
        e(aVar);
        if (com.tencent.mobileqq.alpha.a.e()) {
            this.J.add(f(f185660f0));
        }
        if (QQAudioHelper.f()) {
            ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).addDebugMenu(this.f185664d, this.J);
        }
        this.N = null;
        this.P = null;
        N();
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return VasToggle.QQLIVE_ENTRANCE.isEnable(false);
    }
}
