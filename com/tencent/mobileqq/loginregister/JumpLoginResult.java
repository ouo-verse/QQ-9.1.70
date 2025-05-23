package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.login.api.ILoginSuccessAnimApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr;
import com.tencent.open.api.IOpenSdkJumpActionStashApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class JumpLoginResult extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Intent f242796a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f242797b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f242798c;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements e72.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f242802a;

        a(Activity activity) {
            this.f242802a = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpLoginResult.this, (Object) activity);
            }
        }

        @Override // e72.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // e72.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                JumpLoginResult.this.x(this.f242802a, false);
                this.f242802a.finish();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // e72.b
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // e72.b
        public void onAnimEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                JumpLoginResult.this.x(this.f242802a, true);
                this.f242802a.finish();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    public JumpLoginResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f242797b = true;
            this.f242798c = new Handler(Looper.getMainLooper());
        }
    }

    private QQAppInterface g(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return (QQAppInterface) appRuntime;
        }
        return null;
    }

    private boolean h(AppRuntime appRuntime, Activity activity, String str) {
        boolean booleanExtra = this.f242796a.getBooleanExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_AUTHORITY, false);
        this.f242797b = true;
        if (booleanExtra) {
            Intent intent = new Intent();
            intent.putExtra("uin", str);
            activity.setResult(-1, intent);
            return true;
        }
        if (!JumpActivity.sIsStartFromWpa && !JumpActivity.sIsStartFromThirdParty) {
            String stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
            if (this.f242796a.getBooleanExtra("isActionSend", false)) {
                activity.setResult(-1);
                return true;
            }
            String stringExtra2 = this.f242796a.getStringExtra("pkg_name");
            if (stringExtra != null && stringExtra.length() > 0) {
                QQAppInterface g16 = g(appRuntime);
                if (g16 == null) {
                    QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
                    return false;
                }
                if (stringExtra.startsWith("mqqguild://guild")) {
                    return false;
                }
                ax c16 = bi.c(g16, activity, stringExtra);
                IOpenSdkCommonChannelJumpActionMgr iOpenSdkCommonChannelJumpActionMgr = (IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class);
                if (iOpenSdkCommonChannelJumpActionMgr.isCommonChannelHandleSwitchOn() && iOpenSdkCommonChannelJumpActionMgr.isCommonChannelJumpAction(c16)) {
                    this.f242796a.putExtra("key_jump_from_open_sdk_common_channel", true);
                    return false;
                }
                if (TextUtils.isEmpty(stringExtra2) && !"web".equals(c16.f(ISchemeApi.KEY_IOS_SRC_TYPE)) && !c16.l() && !c16.m()) {
                    if ("h5".equalsIgnoreCase(c16.f("jump_from")) && c16.n()) {
                        this.f242796a.putExtra("package_from_h5", "pakage_from_h5");
                        this.f242796a.putExtra("jump_action_from_h5", stringExtra);
                        x(activity, false);
                        return true;
                    }
                } else {
                    c16.B(stringExtra2);
                    if (c16.l() || ((IMiniAppService) QRoute.api(IMiniAppService.class)).asyncShareMiniProgram(c16)) {
                        this.f242797b = false;
                    }
                    c16.b();
                    return true;
                }
            }
            return false;
        }
        activity.setResult(-1);
        return true;
    }

    private boolean i(Activity activity) {
        boolean booleanExtra = this.f242796a.getBooleanExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, false);
        if (booleanExtra) {
            Intent intent = new Intent(activity, (Class<?>) ContactSyncJumpActivity.class);
            intent.putExtra("key_req_from_switch_account", true);
            intent.putExtra("key_change", true);
            intent.putExtra("key_orginal_intent", this.f242796a.getParcelableExtra("key_orginal_intent"));
            activity.startActivity(intent);
            activity.moveTaskToBack(true);
            activity.finish();
        }
        return booleanExtra;
    }

    private boolean j(AppRuntime appRuntime, Activity activity) {
        HashMap<String, String> hashMap;
        String stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        if (stringExtra != null && stringExtra.startsWith("mqqapi://forward/url")) {
            QQAppInterface g16 = g(appRuntime);
            if (g16 == null) {
                QLog.e("JumpLoginResult", 1, "handleForwardUrlAction, app is null");
                return false;
            }
            ax c16 = bi.c(g16, activity, stringExtra);
            if (c16 != null && (hashMap = c16.f307441f) != null && hashMap.containsKey("need_jump_after_login") && "1".equals(c16.f307441f.get("need_jump_after_login"))) {
                c16.B(this.f242796a.getStringExtra("pkg_name"));
                c16.b();
                return true;
            }
        }
        return false;
    }

    private boolean l(AppRuntime appRuntime, Activity activity) {
        Bundle bundleExtra = this.f242796a.getBundleExtra("key_params");
        if (this.f242796a.getBooleanExtra("fromGuildOpen", false)) {
            QQAppInterface g16 = g(appRuntime);
            if (g16 == null) {
                QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
                return true;
            }
            String string = bundleExtra.getString("extra_raw_url");
            String string2 = bundleExtra.getString("pkg_name");
            ax c16 = bi.c(g16, activity, string);
            c16.B(string2);
            c16.b();
            return true;
        }
        String stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT_ORIGINAL);
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        }
        if (stringExtra == null || stringExtra.length() <= 0 || !stringExtra.startsWith("mqqguild://guild")) {
            return false;
        }
        QQAppInterface g17 = g(appRuntime);
        if (g17 == null) {
            QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
            return false;
        }
        ax c17 = bi.c(g17, activity, stringExtra);
        c17.B(this.f242796a.getStringExtra("pkg_name"));
        c17.b();
        return true;
    }

    private boolean n(AppRuntime appRuntime, Activity activity) {
        this.f242796a.getBooleanExtra("is_from_king_moment", false);
        String stringExtra = this.f242796a.getStringExtra("king_moment_cover_url");
        this.f242796a.getLongExtra("arg_wang_zhe_app_id", 0L);
        if (QLog.isColorLevel()) {
            QLog.d("KingShareReadInjoyModule", 2, "url is " + stringExtra);
        }
        return false;
    }

    private boolean o(AppRuntime appRuntime, Activity activity) {
        String stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        String stringExtra2 = this.f242796a.getStringExtra("pkg_name");
        if (QLog.isColorLevel()) {
            QLog.d("ODProxy", 2, "handleODJumpAction: schemeStr:" + stringExtra + "pkgName :" + stringExtra2);
        }
        if (stringExtra != null && stringExtra.startsWith("mqqapi://od")) {
            QQAppInterface g16 = g(appRuntime);
            if (g16 == null) {
                QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
                return true;
            }
            ax c16 = bi.c(g16, activity, stringExtra);
            c16.B(stringExtra2);
            c16.b();
            return true;
        }
        return false;
    }

    private boolean p(Activity activity) {
        Bundle bundleExtra = this.f242796a.getBundleExtra("key_params");
        boolean z16 = false;
        if (this.f242796a.getBooleanExtra("fromThirdAppByOpenSDK", false)) {
            Intent intent = new Intent();
            intent.putExtra("key_params", bundleExtra);
            int i3 = bundleExtra.getInt("action");
            z16 = true;
            if (i3 == 3) {
                PublicFragmentActivity.b.a(activity, intent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
            } else if (i3 == 1) {
                PublicFragmentActivity.b.a(activity, intent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
            }
        }
        return z16;
    }

    private boolean q(AppRuntime appRuntime, Activity activity) {
        String stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        String stringExtra2 = this.f242796a.getStringExtra("pkg_name");
        if (stringExtra != null && (stringExtra.startsWith("mqqopensdkapi://bizAgent/") || stringExtra.startsWith("http://qm.qq.com/cgi-bin/") || stringExtra.startsWith("mqq://shop/") || stringExtra.startsWith("mqqapi://wallet/open") || stringExtra.startsWith("mqqmdpass://wallet/modify_pass") || stringExtra.startsWith("mqqapi://qqdataline/openqqdataline") || stringExtra.startsWith("mqqapi://dating/") || stringExtra.startsWith("mqqapi://qlink/openqlink") || stringExtra.startsWith("mqqapi://qqc2b/callc2bphone"))) {
            QQAppInterface g16 = g(appRuntime);
            if (g16 == null) {
                QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
                return false;
            }
            ax c16 = bi.c(g16, activity, stringExtra);
            if (c16 != null) {
                c16.B(stringExtra2);
                c16.b();
                return true;
            }
        }
        return false;
    }

    private boolean r(AppRuntime appRuntime, Activity activity) {
        if (!this.f242796a.getBooleanExtra(QZoneHelper.Constants.KEY_FROM_ALBUM_SHORTCUT, false)) {
            return false;
        }
        Bundle extras = this.f242796a.getExtras();
        QZoneHelper.goQZoneAlbumPhotoList(activity, extras.getString("UploadPhoto.key_album_id"), extras.getLong(QZoneHelper.Constants.KEY_ALBUM_OWNER_UID, 0L), String.valueOf(appRuntime.getLongAccountUin()));
        activity.finish();
        return true;
    }

    private boolean s(AppRuntime appRuntime, Activity activity) {
        String stringExtra = this.f242796a.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        String stringExtra2 = this.f242796a.getStringExtra("pkg_name");
        if (QLog.isColorLevel()) {
            QLog.d("schedule", 2, "handleScheduleJumpAction: schemeStr:" + stringExtra + "pkgName :" + stringExtra2);
        }
        if (stringExtra != null && stringExtra.startsWith("mqqapi://schedule/showDetail?")) {
            QQAppInterface g16 = g(appRuntime);
            if (g16 == null) {
                QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
                return true;
            }
            ax c16 = bi.c(g16, activity, stringExtra);
            c16.B(stringExtra2);
            c16.b();
            return true;
        }
        return false;
    }

    private boolean t(AppRuntime appRuntime, Activity activity, String str, boolean z16) {
        boolean m3 = com.tencent.open.agent.util.c.m(this.f242796a);
        QLog.i("JumpLoginResult", 1, "handleSdkLoginAuthority fromSdkLoginAuthority? " + m3);
        if (!m3) {
            return false;
        }
        this.f242797b = false;
        Intent intent = new Intent("action_login_sucess");
        intent.putExtra("login_success_uin", str);
        intent.putExtra("forbid_quick_login_after", z16);
        activity.sendBroadcast(intent);
        QLog.i("JumpLoginResult", 1, "handleSdkLoginAuthority sendBroadCast. forbidQuickLoginAfter= " + z16);
        this.f242798c.postDelayed(new Runnable(str, z16, activity) { // from class: com.tencent.mobileqq.loginregister.JumpLoginResult.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f242799d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f242800e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Activity f242801f;

            {
                this.f242799d = str;
                this.f242800e = z16;
                this.f242801f = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JumpLoginResult.this, str, Boolean.valueOf(z16), activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("JumpLoginResult", 1, "-->login success(finish after ls), go to AgentActivity, account: " + StringUtil.getSimpleUinForPrint(this.f242799d));
                if (this.f242800e) {
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).finishAllLoginActivity(true);
                } else {
                    this.f242801f.finish();
                }
            }
        }, 1000L);
        ReportController.r(appRuntime, "dc00898", "", "", "0x800BA1D", "0x800BA1D", 0, 0, "", "", "", "");
        return true;
    }

    private boolean u(Activity activity) {
        if (((IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class)).isCommonChannelHandleSwitchOn()) {
            return false;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        zp3.d buildHelper = ((IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class)).buildHelper(qBaseActivity, this.f242796a);
        QLog.d("JumpLoginResult", 1, " handleSyncStatusJumpAction: helper: " + buildHelper);
        if (buildHelper != null && (activity instanceof QBaseActivity)) {
            this.f242796a.putExtra("k_from_login", true);
            return ((IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class)).handleCommonChannelJumpAction(qBaseActivity, this.f242796a);
        }
        QLog.d("JumpLoginResult", 1, " helper == null || !(activity instanceof QBaseActivity)");
        return false;
    }

    private boolean v(Activity activity) {
        Intent intent = this.f242796a;
        if ("webview".equals(intent.getStringExtra("action_name"))) {
            Intent intent2 = new Intent(intent);
            intent2.setClass(activity, QQBrowserActivity.class);
            activity.startActivity(intent2);
            return true;
        }
        return false;
    }

    private void w(Activity activity) {
        if (this.f242796a != null) {
            QLog.d("JumpLoginResult", 1, "intent has bean inited");
        } else {
            this.f242796a = activity.getIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Activity activity, boolean z16) {
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        String stringExtra = this.f242796a.getStringExtra("key_action");
        if (!TextUtils.isEmpty(stringExtra) && (BindGroupActivity.class.getSimpleName().equals(stringExtra) || ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity().equals(stringExtra) || "key_sdk_add_friend".equals(stringExtra) || com.tencent.mobileqq.forward.h.class.getSimpleName().equals(stringExtra) || ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(stringExtra))) {
            aliasIntent.putExtras(this.f242796a.getExtras());
        }
        ((IOpenSdkJumpActionStashApi) QRoute.api(IOpenSdkJumpActionStashApi.class)).passThroughParams(activity, aliasIntent);
        aliasIntent.addFlags(67108864);
        aliasIntent.putExtra("k_from_login", true);
        Bundle extras = this.f242796a.getExtras();
        if (extras != null) {
            if (extras.containsKey("tab_index")) {
                aliasIntent.putExtra("tab_index", this.f242796a.getExtras().getInt("tab_index"));
            }
            if (extras.containsKey(AppConstants.MainTabIndex.MAIN_TAB_ID)) {
                aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, extras.getInt(AppConstants.MainTabIndex.MAIN_TAB_ID));
            }
            if (extras.containsKey("jump_action_from_h5")) {
                aliasIntent.putExtra("jump_action_from_h5", this.f242796a.getExtras().getString("jump_action_from_h5"));
            }
            if (extras.containsKey("package_from_h5")) {
                aliasIntent.putExtra("package_from_h5", this.f242796a.getExtras().getString("package_from_h5"));
            }
            if (extras.containsKey("key_jump_from_open_sdk_common_channel")) {
                String string = extras.getString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
                String string2 = extras.getString("pkg_name");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    aliasIntent.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, string);
                    aliasIntent.putExtra("pkg_name", string2);
                }
            }
        }
        if (z16) {
            aliasIntent.putExtra("loginSuccessAnim", true);
            ((ILoginSuccessAnimApi) QRoute.api(ILoginSuccessAnimApi.class)).setSplashAnimState(true);
        }
        activity.startActivity(aliasIntent);
        if (z16) {
            activity.overridePendingTransition(0, 0);
        } else {
            activity.overridePendingTransition(R.anim.f154680c0, 0);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean a(AppRuntime appRuntime, Activity activity, String str) {
        Intent intent;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, activity, str)).booleanValue();
        }
        try {
            intent = activity.getIntent();
        } catch (Exception e16) {
            QLog.e("JumpLoginResult", 1, "loginSuccess error: " + e16.getMessage());
        }
        if (intent == null) {
            QLog.e("JumpLoginResult", 1, "onLoginSuccess, but intent is null");
            return this.f242797b;
        }
        this.f242796a = intent;
        boolean booleanExtra = intent.getBooleanExtra("IS_ADD_ACCOUNT", false);
        OpenProxy.c().a(str);
        if (booleanExtra) {
            activity.setResult(-1);
            return true;
        }
        if ((intent.getFlags() & 1048576) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!q(appRuntime, activity) && !l(appRuntime, activity)) {
            if (com.tencent.mobileqq.app.parser.y.F(g(appRuntime), activity, this.f242796a)) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpLoginResult", 2, "handleForwardAccountCheckAction scheme from jumpLogin");
                }
            } else if ((z16 || !t(appRuntime, activity, str, false)) && !u(activity) && ((z16 || !h(appRuntime, activity, str)) && !i(activity) && !v(activity) && !o(appRuntime, activity) && !p(activity))) {
                if (this.f242796a.getParcelableExtra(AppConstants.Key.SHORTCUT_JUMP_KEY) != null) {
                    Intent intent2 = (Intent) this.f242796a.getParcelableExtra(AppConstants.Key.SHORTCUT_JUMP_KEY);
                    intent2.setClass(activity, ShortcutRouterActivity.class);
                    activity.startActivity(intent2);
                } else if (this.f242796a.getBooleanExtra("jump_shortcut_dataline", false)) {
                    Intent intent3 = new Intent();
                    intent3.putExtras(this.f242796a.getExtras());
                    intent3.setClass(activity, qfileJumpActivity.class);
                    activity.startActivity(intent3);
                } else if (this.f242796a.getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY") != null) {
                    Intent intent4 = new Intent(activity, (Class<?>) JumpActivity.class);
                    intent4.putExtra("_goto_qlink_when_login_suc_", true);
                    intent4.putExtra("IS_LOGIN_SUC_CALL", true);
                    activity.startActivity(intent4);
                } else if (this.f242796a.getParcelableExtra("QFILE_SHORTCUT_JUMP_KEY") != null) {
                    Intent intent5 = new Intent(activity, (Class<?>) JumpActivity.class);
                    intent5.putExtra("_goto_qfile_when_login_suc_", true);
                    intent5.putExtra("IS_LOGIN_SUC_CALL", true);
                    activity.startActivity(intent5);
                } else if (this.f242796a.getParcelableExtra("qlink_share_intent_data") != null) {
                    Intent intent6 = (Intent) this.f242796a.getParcelableExtra("qlink_share_intent_data");
                    intent6.putExtra("qlink_share_login_suc_flag", true);
                    activity.startActivity(intent6);
                } else if (this.f242796a.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY") != null) {
                    Intent intent7 = (Intent) this.f242796a.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY");
                    Intent intent8 = new Intent(activity, (Class<?>) QQMiniManager.getAppBrandUIClass());
                    intent8.putExtras(intent7);
                    activity.startActivity(intent8);
                } else if (!s(appRuntime, activity) && !n(appRuntime, activity) && !r(appRuntime, activity) && !j(appRuntime, activity)) {
                    activity.setResult(-1);
                    ((ILoginSuccessAnimApi) QRoute.api(ILoginSuccessAnimApi.class)).startLoginAnim(activity, new a(activity));
                    this.f242797b = false;
                }
            }
        }
        return this.f242797b;
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean c(Activity activity, int i3, String str, Bundle bundle, x xVar) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, activity, Integer.valueOf(i3), str, bundle, xVar)).booleanValue();
        }
        QLog.i("JumpLoginResult", 1, "onOpenSdkLoginSuccess loginType=" + i3 + ", uin=" + StringUtil.getSimpleUinForPrint(str));
        if (xVar != null) {
            xVar.hideLoading();
        }
        if (activity == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            OpenProxy.c().a(str);
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            i16 = intent.getIntExtra("key_req_src", 1);
        } else {
            i16 = 1;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("last_account", str);
        intent2.putExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, true);
        if (bundle != null) {
            byte[] byteArray = bundle.getByteArray("st_temp");
            byte[] byteArray2 = bundle.getByteArray("st_temp_key");
            intent2.putExtra("st_temp", byteArray);
            intent2.putExtra("st_temp_key", byteArray2);
        }
        if (i3 == 5 || i3 == 4) {
            intent2.putExtra("fromLoginPhoneNum", true);
        }
        if (i16 == 2 || i16 == 3) {
            intent2.putExtra("ssobundle", bundle);
        }
        activity.setResult(-1, intent2);
        if (xVar != null) {
            xVar.a();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean f(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) str)).booleanValue();
        }
        QLog.d("JumpLoginResult", 1, "onQrCodeLoginSuccess");
        Intent intent = activity.getIntent();
        if (com.tencent.open.agent.util.c.m(intent)) {
            QLog.i("JumpLoginResult", 1, "from main login.");
            Intent intent2 = new Intent("action_login_sucess");
            intent2.putExtra("param_qr_code_url", str);
            intent2.putExtra("param_is_qr_code_login", true);
            activity.sendBroadcast(intent2);
            return true;
        }
        if (intent == null || !intent.getBooleanExtra("is_open_sdk_add_account", false)) {
            return false;
        }
        QLog.i("JumpLoginResult", 1, "is openSdk add account.");
        Intent intent3 = new Intent();
        intent3.putExtra("param_qr_code_url", str);
        intent3.putExtra("param_is_qr_code_login", true);
        activity.setResult(-1, intent3);
        activity.finish();
        return true;
    }

    public void m(QBaseActivity qBaseActivity, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) str);
            return;
        }
        w(qBaseActivity);
        Intent intent = this.f242796a;
        if (intent == null) {
            QLog.e("JumpLoginResult", 1, "handleIMBlockLogin intent is null");
            return;
        }
        if ((intent.getFlags() & 1048576) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("JumpLoginResult", 1, "launchedFromHistory is true, return");
            return;
        }
        QLog.d("JumpLoginResult", 1, "handleSdkLoginAuthority");
        t(qBaseActivity.getAppRuntime(), qBaseActivity, str, true);
        up3.b.a(str);
    }
}
