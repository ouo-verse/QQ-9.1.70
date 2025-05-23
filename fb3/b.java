package fb3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForMultiProcess;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.ui.WxMiniTipUserInfoFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.util.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements IAccountCallback {

    /* renamed from: h, reason: collision with root package name */
    private static WxaInfo f398136h;

    /* renamed from: d, reason: collision with root package name */
    private final c f398137d = new c();

    /* renamed from: e, reason: collision with root package name */
    private int f398138e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f398139f = 0;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("mqq.wxmini.action_show_dialog".equals(intent.getAction())) {
                WxaInfo wxaInfo = (WxaInfo) intent.getParcelableExtra("key_wxa_info");
                String stringExtra = intent.getStringExtra("key_tdi_id");
                intent.getStringExtra("key_account");
                b.g(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), stringExtra);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: fb3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static class C10297b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f398141a = new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f398142a = 3;

        /* renamed from: b, reason: collision with root package name */
        public int f398143b = 3;

        c() {
        }
    }

    b() {
        MobileQQ.sMobileQQ.registerAccountCallback(this);
        h();
        i();
        if (e()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("mqq.wxmini.action_show_dialog");
            MobileQQ.sMobileQQ.registerReceiver(new a(), intentFilter);
        }
    }

    public static b c() {
        return C10297b.f398141a;
    }

    private boolean e() {
        return MobileQQ.sMobileQQ.getQQProcessName().contains(ProcessConstant.WXA_CONTAINER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("applet_appid", str);
        intent.putExtra(StartupReportKey.TID_USERID, str2);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && topActivity.hasWindowFocus()) {
            QPublicFragmentActivity.b.b(topActivity, intent, QPublicTransFragmentActivityForMultiProcess.class, WxMiniTipUserInfoFragment.class);
        } else {
            QLog.i("WxMiniUserInfoDialogMgr", 1, "need show Dialog but act is null or not focus");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final String str, final String str2) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: fb3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(str, str2);
            }
        }, 500L);
    }

    private void h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("WxMiniUserInfoDialogMgr", 1, "refresh but app runtime is null");
            return;
        }
        this.f398138e = com.tencent.mobileqq.wxmini.impl.account.h.c();
        this.f398139f = com.tencent.mobileqq.wxmini.impl.account.h.b();
        QLog.d("WxMiniUserInfoDialogMgr", 1, "current: ", LogUtil.wrapLogUin(peekAppRuntime.getAccount()), " currentTime: ", Integer.valueOf(this.f398138e), " miniOpenTime: ", Integer.valueOf(this.f398139f));
    }

    private void i() {
        try {
            JSONObject jSONObject = new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("wx_mini_user_info_config", ""));
            this.f398137d.f398143b = jSONObject.getInt("config_total_time");
            this.f398137d.f398142a = jSONObject.getInt("config_internal");
        } catch (JSONException unused) {
        }
    }

    private synchronized void j() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.i("WxMiniUserInfoDialogMgr", 1, "saveOpenTime but app runtime is null");
        } else {
            com.tencent.mobileqq.wxmini.impl.account.h.f(this.f398138e);
            com.tencent.mobileqq.wxmini.impl.account.h.e(this.f398139f);
        }
    }

    private static void m(WxaInfo wxaInfo, String str) {
        Intent intent = new Intent("mqq.wxmini.action_show_dialog");
        intent.putExtra("key_wxa_info", wxaInfo);
        intent.putExtra("key_tdi_id", str);
        intent.putExtra("key_account", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        BaseApplication.getContext().sendBroadcast(intent);
        f398136h = wxaInfo;
    }

    public WxaInfo d() {
        return f398136h;
    }

    public void k(WxaInfo wxaInfo) {
        f398136h = wxaInfo;
    }

    public void l(WxaInfo wxaInfo, String str) {
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfoWithAccount = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfoWithAccount("");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("is_user_info_show", false);
        if (bindingWeChatUserInfoWithAccount != null && isSwitchOn) {
            int i3 = this.f398138e;
            if (i3 >= this.f398137d.f398143b) {
                QLog.d("WxMiniUserInfoDialogMgr", 4, "showUserTips, currentTime: ", Integer.valueOf(i3), " configTime:", Integer.valueOf(this.f398137d.f398143b));
                return;
            }
            int i16 = this.f398139f;
            if (i16 < 2147483645) {
                this.f398139f = i16 + 1;
            } else {
                this.f398139f = 1;
            }
            j();
            QLog.d("WxMiniUserInfoDialogMgr", 1, "showUserTips, current: ", Integer.valueOf(this.f398138e), " interval: ", Integer.valueOf(this.f398137d.f398142a), " currentMiniOpenTime: ", Integer.valueOf(this.f398139f));
            long j3 = this.f398137d.f398142a;
            int i17 = this.f398138e;
            if ((j3 * i17) + 1 < this.f398139f) {
                this.f398138e = i17 + 1;
                j();
                m(wxaInfo, str);
                QLog.d("WxMiniUserInfoDialogMgr", 1, "showUserTips is show!");
                return;
            }
            return;
        }
        QLog.d("WxMiniUserInfoDialogMgr", 1, "showUserTips, but user info is null, canShow: ", Boolean.valueOf(isSwitchOn));
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        h();
        i();
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(AppRuntime appRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
    }
}
