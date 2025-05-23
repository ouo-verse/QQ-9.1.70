package com.tencent.mobileqq.jumpcontroller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.av.utils.s;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.jumpcontroller.b;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.mobileqq.pushnotice.message.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.permission.a;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.c;
import com.tencent.qqnt.bean.InviteToTroopParam;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tenpay.sdk.util.QWSoterConstans;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.util.HashMap;
import java.util.List;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes15.dex */
public class JumpControllerInject implements b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JumpActivity f238939d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f238940e;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.jumpcontroller.JumpControllerInject$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class C7954a implements a.b {
            static IPatchRedirector $redirector_;

            C7954a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
            public void allow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("JumpControllerInject", 1, "system share.doShare show self dialog grant");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftGrant", true, 0L, 0L, new HashMap<>(), "");
            }

            @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
            public void reject() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                QLog.i("JumpControllerInject", 1, "system share.doShare show self dialog denied");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftDeny", true, 0L, 0L, new HashMap<>(), "");
                a.this.f238939d.finish();
            }
        }

        a(JumpActivity jumpActivity, boolean z16) {
            this.f238939d = jumpActivity;
            this.f238940e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, JumpControllerInject.this, jumpActivity, Boolean.valueOf(z16));
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            QLog.i("JumpControllerInject", 1, "system share.doShare denied sd grant");
            DialogUtil.showPermissionDialogForStorageWithCallback(this.f238939d, new C7954a());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareDeny", true, 0L, 0L, new HashMap<>(), "");
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            QLog.i("JumpControllerInject", 1, "system share.doShare user grant");
            JumpActivityHelper.W(this.f238939d, this.f238940e);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareGrant", true, 0L, 0L, new HashMap<>(), "");
        }
    }

    public JumpControllerInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public Boolean a(JumpActivity jumpActivity, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) jumpActivity, (Object) uri);
        }
        if (uri != null) {
            try {
                boolean canReadFileFromUri = UriParserPathHelper.canReadFileFromUri(uri, jumpActivity);
                boolean z16 = false;
                QLog.d("JumpControllerInject", 1, "system share.doShareCheckNeedSDPermission() canReadFromUri=", Boolean.valueOf(canReadFileFromUri));
                if (!canReadFileFromUri) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            } catch (Exception e16) {
                QLog.e("JumpControllerInject", 1, "injectCheckSDPermissionWithFP error: " + e16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void b(JumpActivity jumpActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) jumpActivity, (Object) intent);
            return;
        }
        intent.addFlags(524288);
        intent.addFlags(134217728);
        jumpActivity.getActivity().overridePendingTransition(R.anim.f154454a3, 0);
        jumpActivity.finish();
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).startFM(context);
            FileManagerReporter.addData("0X8005533");
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public boolean d(JumpActivity jumpActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) jumpActivity, (Object) intent)).booleanValue();
        }
        if (!df0.a.a().b(String.valueOf(Long.valueOf(intent.getLongExtra("req_share_id", 0L))))) {
            jumpActivity.finish();
            return false;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(jumpActivity);
        aliasIntent.putExtras(intent.getExtras());
        jumpActivity.startActivity(BaseAIOUtils.m(aliasIntent, null));
        return false;
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void e(JumpActivity jumpActivity, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, jumpActivity, Long.valueOf(j3), str);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("is_from_king_moment", true);
        intent.putExtra("king_moment_cover_url", str);
        intent.putExtra("arg_wang_zhe_app_id", j3);
        RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void f(JumpActivity jumpActivity, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, jumpActivity, Long.valueOf(j3), str);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public boolean g(JumpActivity jumpActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) jumpActivity, (Object) str)).booleanValue();
        }
        if (BaseGesturePWDUtil.getJumpLock(jumpActivity, jumpActivity.getAppRuntime().getCurrentAccountUin()) && !BaseGesturePWDUtil.getAppForground(jumpActivity) && !PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(jumpActivity, (QQAppInterface) jumpActivity.getAppRuntime(), str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void h(JumpActivity jumpActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jumpActivity, (Object) intent);
        } else {
            s.h((QQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, intent, 1);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public boolean i(JumpActivity jumpActivity, Intent intent, b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, jumpActivity, intent, aVar)).booleanValue();
        }
        return i.h(jumpActivity, intent, jumpActivity.getAppRuntime(), aVar);
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void j(Intent intent, JumpActivity jumpActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) intent, (Object) jumpActivity);
        } else {
            ForwardBaseOption.startForwardActivity(jumpActivity, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void k(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qBaseActivity);
        } else {
            c.a(qBaseActivity.getAppRuntime());
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public String l(Context context) {
        List<Fragment> fragments;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        if ((context instanceof BaseActivity) && (fragments = ((BaseActivity) context).getSupportFragmentManager().getFragments()) != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment.isVisible()) {
                    String name = fragment.getClass().getName();
                    if (fragment instanceof MainFragment) {
                        name = name + "$" + ((MainFragment) fragment).Rj();
                    }
                    if (fragment instanceof ChatFragment) {
                        ChatFragment chatFragment = (ChatFragment) fragment;
                        if (chatFragment.C != null) {
                            return name + "$" + chatFragment.C.i();
                        }
                        return name;
                    }
                    return name;
                }
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void m(JumpActivity jumpActivity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, jumpActivity, intent, Integer.valueOf(i3));
            return;
        }
        JumpForwardSecurityCheck jumpForwardSecurityCheck = new JumpForwardSecurityCheck(jumpActivity, jumpActivity);
        jumpActivity.showDialog();
        jumpActivity.mBgHandler.post(new Runnable(jumpForwardSecurityCheck, intent, jumpActivity, i3) { // from class: com.tencent.mobileqq.jumpcontroller.JumpControllerInject.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ JumpForwardSecurityCheck f238935d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Intent f238936e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ JumpActivity f238937f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f238938h;

            {
                this.f238935d = jumpForwardSecurityCheck;
                this.f238936e = intent;
                this.f238937f = jumpActivity;
                this.f238938h = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, JumpControllerInject.this, jumpForwardSecurityCheck, intent, jumpActivity, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (this.f238935d.checkContainsPrivateUri(this.f238936e)) {
                        QLog.e("JumpControllerInject", 1, "contains privateUri");
                        this.f238937f.uiHandler.sendEmptyMessage(1);
                        this.f238937f.finish();
                        return;
                    }
                } catch (Throwable unused) {
                }
                JumpForwardSecurityCheck jumpForwardSecurityCheck2 = this.f238935d;
                Intent intent2 = this.f238936e;
                if (!jumpForwardSecurityCheck2.prepareSecurityCheck(intent2, intent2.getAction())) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.arg1 = this.f238938h;
                    obtain.obj = this.f238936e;
                    this.f238937f.uiHandler.sendMessage(obtain);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void n(JumpActivity jumpActivity, boolean z16, Intent intent) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, jumpActivity, Boolean.valueOf(z16), intent);
            return;
        }
        Intent intent2 = jumpActivity.getIntent();
        if (intent2 == null) {
            return;
        }
        int i16 = -1;
        try {
            int intExtra = intent2.getIntExtra(QWSoterConstans.CGI_KEY_BUSI_TYPE, -1);
            i3 = intent2.getIntExtra("verify_type", -1);
            i16 = intExtra;
        } catch (Exception e16) {
            QLog.d("JumpControllerInject", 1, "onWebSecVerifyResult", e16);
            i3 = -1;
        }
        if (intent != null) {
            str = intent.getStringExtra("ticket");
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_SECURITY_VERIFY, 2, String.format("onWebSecVerifyResult, isSuc: %s, busiType: %s, verifyType: %s", Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i3)));
        }
        Parcelable parcelableExtra = intent2.getParcelableExtra("extra_data");
        if (i16 != 0) {
            if (i16 == 1 && (parcelableExtra instanceof InviteToTroopParam)) {
                InviteToTroopParam inviteToTroopParam = (InviteToTroopParam) parcelableExtra;
                if (z16 && !TextUtils.isEmpty(str)) {
                    inviteToTroopParam.verifyType = i3;
                    inviteToTroopParam.verifyToken = str;
                    ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).inviteToGroup(inviteToTroopParam, "JumpControllerInject", true);
                } else {
                    ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).inviteToGroup(inviteToTroopParam, "JumpControllerInject", false);
                }
            }
        } else if (parcelableExtra instanceof JoinTroopParam) {
            JoinTroopParam joinTroopParam = (JoinTroopParam) parcelableExtra;
            if (z16 && !TextUtils.isEmpty(str)) {
                joinTroopParam.m(i3);
                joinTroopParam.l(str);
                z17 = true;
            }
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).joinGroupForSecurityBack(joinTroopParam, z17, "JumpControllerInject");
        }
        jumpActivity.finish();
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public boolean o(JumpActivity jumpActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) jumpActivity, (Object) intent)).booleanValue();
        }
        return ThirdPushNotifyManager.d().i(jumpActivity, intent, jumpActivity.getAppRuntime());
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void p(JumpActivity jumpActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jumpActivity, (Object) intent);
        } else {
            NearbyVideoChatProxyActivity.G2((QQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, intent, ((com.tencent.mobileqq.troop.utils.i) jumpActivity.getAppRuntime().getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).a(), null, 123987);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void q(JumpActivity jumpActivity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, jumpActivity, Boolean.valueOf(z16));
        } else {
            PermissionUtils.requestStorePermission(jumpActivity, 3, new a(jumpActivity, z16));
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void r(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            QQProxyForQlink.P(context, 7, null);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.b
    public void s(JumpActivity jumpActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jumpActivity, (Object) intent);
            return;
        }
        Intent intent2 = new Intent(jumpActivity, (Class<?>) DataMigrationService.class);
        intent2.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
        intent2.putExtras(intent);
        try {
            jumpActivity.startService(intent2);
        } catch (Throwable th5) {
            QLog.e("JumpControllerInject", 1, "mqqdatamigration", th5);
        }
        jumpActivity.finish();
    }
}
