package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.emosm.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.IPayLogic;

@RoutePage(desc = "\u652f\u4ed8sdk\u6865\u6881activity", path = RouterConstants.UI_ROUTER_PAY_BRIDGE)
/* loaded from: classes9.dex */
public class PayBridgeActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    private static final String PAY_BRIDGE_LAUNCH_CLASS = "PayBridgeActivity_pay_bridge_launch_class";
    private static final String PAY_BRIDGE_LAUNCH_TIME = "PayBridgeActivity_pay_bridge_launch_time";
    public static final String TAG = "Q.qwallet.pay.PayBridgeActivity";
    public boolean mIsPluginLoaded;
    protected boolean mIsResume;
    protected long mLastResumeTime;
    private final ql2.a mMonitor;
    private IPayLogic payLogic;

    public PayBridgeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsResume = false;
        this.mIsPluginLoaded = false;
        this.mMonitor = new ql2.c();
    }

    public static Intent createLaunchIntent(Context context) {
        Intent intent = new Intent(context, (Class<?>) PayBridgeActivity.class);
        intent.putExtra(PAY_BRIDGE_LAUNCH_TIME, ql2.d.a());
        intent.putExtra(PAY_BRIDGE_LAUNCH_CLASS, context.getClass().getCanonicalName());
        return intent;
    }

    private void fixStatusBar() {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        getWindow().addFlags(67108864);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.qui_common_bg_bottom_standard));
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        ImmersiveUtils.setNavigationBarIconColor(getWindow(), true ^ QQTheme.isNowThemeIsNight());
    }

    private String getJson() {
        if (getIntent() != null) {
            getIntent().getStringExtra(ark.ARKMETADATA_JSON);
            return null;
        }
        return null;
    }

    private int getRequestCode() {
        if (getIntent() == null) {
            return -1;
        }
        return getIntent().getIntExtra("pay_requestcode", -1);
    }

    public static boolean isPaying() {
        return ((IPayLogic) QRoute.api(IPayLogic.class)).isPaying();
    }

    public static Bundle newPay(AppInterface appInterface, Activity activity, ResultReceiver resultReceiver, int i3, Bundle bundle) {
        return ((IPayLogic) QRoute.api(IPayLogic.class)).newPay(appInterface, activity, resultReceiver, i3, bundle);
    }

    public static boolean startEmojimallPay(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startEmojimallPaycallbackid:" + str + "appid:" + str2 + "userId:" + str3 + "userKey:" + str4 + "zoneId:" + str5 + "pf:" + str6 + "pfKey:" + str7 + "tokenUrl:" + str8 + "drmInfo:" + str9);
        }
        if (activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str8)) {
            return false;
        }
        Intent createLaunchIntent = createLaunchIntent(activity);
        createLaunchIntent.putExtras(new a.C7495a(str, str2, str3, str4, "uin", "skey", str5, str6, str7, str8, str9).a());
        createLaunchIntent.putExtra("pay_requestcode", 1);
        createLaunchIntent.addFlags(67108864);
        createLaunchIntent.addFlags(536870912);
        activity.startActivityForResult(createLaunchIntent, 1);
        return true;
    }

    public static boolean startGoldCharge(Activity activity, Bundle bundle, int i3) {
        if (activity != null && bundle != null) {
            Intent createLaunchIntent = createLaunchIntent(activity);
            createLaunchIntent.putExtras(bundle);
            activity.startActivityForResult(createLaunchIntent, i3);
            return true;
        }
        return false;
    }

    public static boolean startOpenQQReaderVip(Activity activity, Bundle bundle, int i3) {
        if (activity != null && bundle != null) {
            Intent createLaunchIntent = createLaunchIntent(activity);
            createLaunchIntent.putExtras(bundle);
            activity.startActivityForResult(createLaunchIntent, i3);
            return true;
        }
        return false;
    }

    public static boolean startTenpay(Context context, int i3, Bundle bundle) {
        if (context != null && bundle != null) {
            Intent createLaunchIntent = createLaunchIntent(context);
            createLaunchIntent.putExtras(bundle);
            createLaunchIntent.putExtra("pay_requestcode", i3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "PayBridgeActivity tenpay startActivity and request=" + bundle.toString() + ",requestCode=" + i3);
            }
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(createLaunchIntent, i3);
                return true;
            }
            createLaunchIntent.addFlags(268435456);
            context.startActivity(createLaunchIntent);
            return true;
        }
        return false;
    }

    public static boolean tenpay(Activity activity, String str, int i3, String str2) {
        if (activity == null || str == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, str);
        bundle.putString("callbackSn", str2);
        return tenpay(activity, i3, bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            dispatchTouchEvent = ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            if (motionEvent.getAction() == 1 && this.mIsResume && !isFinishing()) {
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                long j3 = this.mLastResumeTime;
                if (serverTimeMillis > j3 && serverTimeMillis - j3 > 10000) {
                    VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "PayBridge", "click.mobileqq", "isPluginloaded=" + this.mIsPluginLoaded + "&reqcode=" + getRequestCode() + "&json=" + getJson(), 0, null);
                    this.payLogic.end();
                }
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnActivityResult@" + hashCode() + " requestCode: " + i3 + ", resultCode: " + i16 + ", data: " + intent);
        }
        IPayLogic iPayLogic = this.payLogic;
        if (iPayLogic != null) {
            iPayLogic.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        long now = this.mMonitor.now();
        Intent intent = getIntent();
        if (intent != null) {
            long longExtra = intent.getLongExtra(PAY_BRIDGE_LAUNCH_TIME, now);
            String stringExtra = intent.getStringExtra(PAY_BRIDGE_LAUNCH_CLASS);
            if (stringExtra == null) {
                stringExtra = "unknown";
            }
            this.mMonitor.addReportParam(1, Long.valueOf(now - longExtra));
            this.mMonitor.addReportParam(0, stringExtra);
        }
        try {
            fixStatusBar();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        super.doOnCreate(bundle);
        QLog.i(TAG, 1, "doOnCreate@" + hashCode());
        if (bundle != null && bundle.containsKey("save_instance_logic_tag")) {
            QLog.i(TAG, 1, "doOnCreate from reboot@" + hashCode());
            IPayLogic logic = ((IPayLogic) QRoute.api(IPayLogic.class)).getLogic(bundle.getInt("save_instance_logic_tag"));
            this.payLogic = logic;
            if (logic != null && logic.tryDoOnActivityResult(this)) {
                return false;
            }
            finish();
            return false;
        }
        IPayLogic iPayLogic = (IPayLogic) QRoute.api(IPayLogic.class);
        this.payLogic = iPayLogic;
        if (!iPayLogic.init(getIntent(), getAppRuntime(), this)) {
            this.payLogic.end();
            return false;
        }
        this.payLogic.exec();
        ql2.a aVar = this.mMonitor;
        aVar.addReportParam(2, Long.valueOf(aVar.now() - now));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        long now = this.mMonitor.now();
        QLog.i(TAG, 1, "doOnDestroy@" + hashCode());
        super.doOnDestroy();
        IPayLogic iPayLogic = this.payLogic;
        if (iPayLogic != null) {
            iPayLogic.onDestroy();
        }
        ql2.a aVar = this.mMonitor;
        aVar.addReportParam(7, Long.valueOf(aVar.now() - now));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        long now = this.mMonitor.now();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnPause@" + hashCode());
        }
        super.doOnPause();
        ql2.a aVar = this.mMonitor;
        aVar.addReportParam(5, Long.valueOf(aVar.now() - now));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnRestoreInstanceState@" + hashCode());
        }
        super.doOnRestoreInstanceState(bundle);
        this.payLogic.doOnRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        long now = this.mMonitor.now();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnResume@" + hashCode());
        }
        this.mIsResume = true;
        this.mLastResumeTime = NetConnInfoCenter.getServerTimeMillis();
        super.doOnResume();
        ql2.a aVar = this.mMonitor;
        aVar.addReportParam(4, Long.valueOf(aVar.now() - now));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnSaveInstanceState@" + hashCode());
        }
        super.doOnSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putInt("save_instance_logic_tag", this.payLogic.getTag());
        }
        this.payLogic.doOnSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long now = this.mMonitor.now();
        super.doOnStart();
        ql2.a aVar = this.mMonitor;
        aVar.addReportParam(3, Long.valueOf(aVar.now() - now));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        long now = this.mMonitor.now();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnStop@" + hashCode());
        }
        super.doOnStop();
        ql2.a aVar = this.mMonitor;
        aVar.addReportParam(6, Long.valueOf(aVar.now() - now));
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        try {
            requestWindowFeature(1);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "requestWindowFeature error", th5);
        }
    }

    public static boolean tenpay(Activity activity, int i3, Bundle bundle) {
        return tenpay(activity, i3, bundle, (ResultReceiver) null);
    }

    public static boolean tenpay(Activity activity, int i3, Bundle bundle, ResultReceiver resultReceiver) {
        if (activity == null || bundle == null) {
            return false;
        }
        if (resultReceiver != null) {
            bundle.putParcelable("receiver", resultReceiver);
        }
        Intent createLaunchIntent = createLaunchIntent(activity);
        createLaunchIntent.putExtras(bundle);
        createLaunchIntent.putExtra("pay_requestcode", i3);
        com.tencent.mobileqq.qwallet.utils.f.b(TAG, "tenpay startActivity and request=" + bundle + ",requestCode=" + i3);
        activity.startActivityForResult(createLaunchIntent, i3);
        return true;
    }
}
