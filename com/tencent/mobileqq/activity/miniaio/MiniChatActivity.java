package com.tencent.mobileqq.activity.miniaio;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityBehind;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IHorizontalMiniAIOApi;
import com.tencent.qqnt.aio.api.IMsgForwardNtUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MiniChatActivity extends PublicFragmentActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    static boolean f183451e0;

    /* renamed from: d0, reason: collision with root package name */
    protected m f183452d0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68558);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f183451e0 = false;
        }
    }

    public MiniChatActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183452d0 = new m();
        }
    }

    public static void I2(Bundle bundle) {
        J2(bundle, false, false, false);
    }

    public static void J2(Bundle bundle, boolean z16, boolean z17, boolean z18) {
        QLog.d("mini_msg_MiniChatActivity", 1, "doStartMiniAioFromPush");
        boolean L2 = L2();
        String string = bundle.getString("uin");
        int i3 = bundle.getInt("uintype", 0);
        String string2 = bundle.getString("uinname");
        int i16 = bundle.getInt(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, 0);
        Context topActivity = getTopActivity();
        if (topActivity == null || (topActivity instanceof JumpActivity)) {
            QLog.i("mini_msg_MiniChatActivity", 1, "doStartMiniAioFromPush, top activity not found, context=" + topActivity);
            topActivity = BaseApplication.getContext();
        }
        String string3 = bundle.getString("key_from", "");
        Bundle bundle2 = new Bundle();
        if (!TextUtils.isEmpty(string3)) {
            bundle2.putString("key_from", string3);
        }
        if (b3(L2)) {
            if (z16 || !N2(topActivity, string, i3, bundle2)) {
                com.tencent.mobileqq.activity.aio.l.a0(topActivity, string, i3, string2, bundle2, 1, Z2());
                return;
            }
            return;
        }
        if (L2 && K2()) {
            c3(topActivity, i3, string, string2, i16, z17, z18);
        } else if (!N2(topActivity, string, i3, bundle2)) {
            com.tencent.mobileqq.activity.aio.l.a0(topActivity, string, i3, string2, bundle2, 1, Z2());
        }
    }

    private static boolean K2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_mini_aio_landscape", true);
        }
        return false;
    }

    private static boolean L2() {
        DisplayMetrics displayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
        int i3 = BaseApplicationImpl.getApplication().getResources().getConfiguration().orientation;
        QLog.d("mini_msg_MiniChatActivity", 1, "isAppLandscape orientation=" + i3 + ", width=" + displayMetrics.widthPixels + ", height=" + displayMetrics.heightPixels);
        if (i3 == 1) {
            return false;
        }
        if (i3 == 2 || displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public static boolean M2() {
        return f183451e0;
    }

    private static boolean N2(Context context, String str, int i3, Bundle bundle) {
        String str2;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("push_open_scaleaio_by_jumpactivity_908", true)) {
            return false;
        }
        if (i3 == 0) {
            str2 = "c2c";
        } else if (i3 == 1) {
            str2 = VipFunCallConstants.KEY_GROUP;
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String format = String.format("mqqapi://im/chat?uin=%s&chat_type=%s&src_type=push&version=1&open_type=scalechat", str, str2);
            Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
            intent.putExtras(bundle);
            intent.setData(Uri.parse(format));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit P2(Activity activity, String str, boolean z16, Boolean bool, com.tencent.nt.adapter.session.e eVar) {
        if (!bool.booleanValue()) {
            return Unit.INSTANCE;
        }
        IMsgForwardNtUtil iMsgForwardNtUtil = (IMsgForwardNtUtil) QRoute.api(IMsgForwardNtUtil.class);
        int a16 = eVar.a();
        String b16 = eVar.b();
        if (str == null) {
            str = "";
        }
        iMsgForwardNtUtil.startForwardMiniAIO(activity, a16, b16, str, z16);
        return Unit.INSTANCE;
    }

    public static void Q2(Activity activity, int i3, String str, String str2) {
        R2(activity, i3, str, str2, true);
    }

    public static void R2(Activity activity, int i3, String str, String str2, boolean z16) {
        S2(activity, i3, str, str2, true, 0);
    }

    public static void S2(Activity activity, int i3, String str, String str2, boolean z16, int i16) {
        T2(activity, new Intent(), i3, str, str2, z16, i16);
    }

    public static void T2(Activity activity, Intent intent, int i3, String str, String str2, boolean z16, int i16) {
        com.tencent.mobileqq.activity.aio.l.Z(activity, str, i3, str2, new Bundle(), 0);
    }

    public static void U2(Activity activity, int i3, String str, boolean z16, int i16, long j3, long j16) {
        com.tencent.mobileqq.activity.aio.l.Z(activity, str, i3, "", new Bundle(), 0);
    }

    public static void V2(final Activity activity, int i3, String str, final String str2, final boolean z16) {
        com.tencent.nt.adapter.session.c.j(str, i3, new Function2() { // from class: com.tencent.mobileqq.activity.miniaio.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit P2;
                P2 = MiniChatActivity.P2(activity, str2, z16, (Boolean) obj, (com.tencent.nt.adapter.session.e) obj2);
                return P2;
            }
        });
    }

    public static void W2(Activity activity, Intent intent, int i3) {
        if (activity == null) {
            QLog.d("mini_msg_MiniChatActivity", 1, "openMiniMsgTab activity is null");
            return;
        }
        intent.putExtra(MiniChatConstants.KEY_MINI_FROM, 1);
        intent.putExtra("public_fragment_window_feature", 1);
        boolean L2 = L2();
        boolean booleanExtra = intent.getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_ACTION_SHEET, false);
        QLog.d("mini_msg_MiniChatActivity", 1, "openMiniMsgTab isAppLandscape=" + L2 + ", needActionSheet=" + booleanExtra);
        if (L2 && !booleanExtra && K2()) {
            QLog.d("mini_msg_MiniChatActivity", 1, "openMiniMsgTab start Landscape mini aio.");
            QPublicFragmentActivity.b.e(activity, intent, QPublicTransFragmentActivityBehind.class, ((IHorizontalMiniAIOApi) QRoute.api(IHorizontalMiniAIOApi.class)).getHorizontalMiniaioFragment(), i3);
        } else {
            PublicFragmentActivity.b.d(activity, intent, MiniChatActivity.class, MiniMsgTabFragment.class, i3);
        }
    }

    private static boolean Z2() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("push_notification_half_aio_clear_top");
    }

    private static boolean b3(boolean z16) {
        if (z16) {
            return false;
        }
        return true;
    }

    public static Intent c3(Context context, int i3, String str, String str2, int i16, boolean z16, boolean z17) {
        QLog.d("mini_msg_MiniChatActivity", 1, "startLandscapeMiniAioFromPush");
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("uinname", str2);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, i16);
        intent.putExtra(MiniChatConstants.KEY_MINI_FROM, 2);
        intent.putExtra(MiniChatConstants.MINI_APP_LANDSCAPE, true);
        intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_ACTION_SHEET, false);
        intent.putExtra("public_fragment_window_feature", 1);
        Class<?> horizontalMiniaioFragment = ((IHorizontalMiniAIOApi) QRoute.api(IHorizontalMiniAIOApi.class)).getHorizontalMiniaioFragment();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_open_normal_aio_addnewtask", z16);
        intent.putExtra("key_open_normal_aio_close_mini_aio", z17);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityBehind.class, horizontalMiniaioFragment);
        return intent;
    }

    private static Activity getTopActivity() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        return Foreground.getTopActivity();
    }

    private void setEnterAnim() {
        if (MiniMsgTabFragment.class.getName().equals(getIntent().getStringExtra("public_fragment_class"))) {
            overridePendingTransition(0, 0);
        }
    }

    protected void Y2(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        } else {
            if (bundle == null) {
                return;
            }
            this.f183452d0.d(bundle.getInt(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME));
        }
    }

    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(MiniChatConstants.KEY_MINI_FROM, -1);
        if (intent.getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_FULL_SCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        if (intExtra != 1) {
            if (intExtra != 2 && intExtra != 3 && intExtra != 4 && intExtra != 5) {
                finish();
            }
        } else {
            getWindow().setDimAmount(0.0f);
        }
        boolean booleanExtra = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_LANDSCAPE, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_BG_TRANSPARENT, false);
        if (booleanExtra && !booleanExtra2) {
            findViewById(R.id.content).setBackgroundResource(com.tencent.mobileqq.R.drawable.ch9);
        }
        Y2(intent.getExtras());
        setEnterAnim();
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f183452d0.a(2, getIntent().getExtras());
        this.f183452d0.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f183451e0 = true;
        if (QLog.isColorLevel()) {
            QLog.d("mini_msg_MiniChatActivity", 2, "doOnStart : isForeGround true");
        }
        super.doOnStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f183451e0 = false;
        if (QLog.isColorLevel()) {
            QLog.d("mini_msg_MiniChatActivity", 2, "doOnStop : isForeGround false");
        }
        super.doOnStop();
    }

    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (getIntent().getBooleanExtra(MiniChatConstants.KEY_MINI_NEED_UPDATE_UNREAD, false)) {
            h.v().x();
        }
        getIntent().getIntExtra(MiniChatConstants.KEY_MINI_FROM, 0);
        super.finish();
    }

    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
