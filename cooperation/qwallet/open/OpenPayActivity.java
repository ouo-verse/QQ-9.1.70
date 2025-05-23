package cooperation.qwallet.open;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.open.api.IOpenPayApi;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import qk2.OpenPayConfig;

/* loaded from: classes28.dex */
public class OpenPayActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    protected PayInfo f390831a0;

    private void F2(int i3, String str) {
        PayInfo payInfo = this.f390831a0;
        if (payInfo != null && (payInfo.getBase().getPayFrom() == 4 || (this.f390831a0.o() && this.f390831a0.getBase().getPayFrom() == 2))) {
            ((IOpenPayApi) QRoute.api(IOpenPayApi.class)).callbackOpenPayResult(this, this.f390831a0, i3, str);
        }
        super.finish();
    }

    private boolean G2(PayInfo payInfo) {
        if (!payInfo.a()) {
            String r16 = payInfo.r();
            F2(-1, getString(R.string.f1792738x));
            QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "OpenPayActivity.doCheckOpenPay Parameters error:" + r16);
            return false;
        }
        if (payInfo.getBase().getPayFrom() != 4 || (!TextUtils.isEmpty(payInfo.getApp().getHostPackageName()) && (payInfo.getBase().getPayAppType() != 1 || !TextUtils.isEmpty(payInfo.getCallbackScheme())))) {
            return true;
        }
        F2(-1, getString(R.string.f1792738x));
        QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "OpenPayActivity.doCheckOpenPay -1009");
        return false;
    }

    private void H2(PayInfo payInfo) {
        String str;
        if (!G2(payInfo)) {
            return;
        }
        if (getAppRuntime() == null) {
            F2(-1, getString(R.string.f1792738x));
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, "OpenPayActivity.doOnCreate app == null || bundle == null");
            return;
        }
        String currentAccountUin = getAppRuntime().getCurrentAccountUin();
        String b16 = a.b();
        try {
            str = payInfo.m();
        } catch (Exception e16) {
            QLog.e("Q.qwallet.open.OpenPayActivity", 1, "error msg in qqpay-impl module: ", e16);
            str = "";
        }
        QLog.i("Q.qwallet.open.OpenPayActivity", 1, "loadPluginStart time=" + SystemClock.elapsedRealtime());
        String transaction = payInfo.getTransaction();
        String str2 = "appid#" + payInfo.getAppId() + "|bargainor_id#" + payInfo.getPartnerId() + "|channel#thirdpartapp";
        Bundle bundle = new Bundle();
        bundle.putString("callbackSn", transaction);
        bundle.putString("tokenId", payInfo.getPrepayId());
        bundle.putString("userId", currentAccountUin);
        bundle.putString("userName", b16);
        bundle.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 4);
        bundle.putString("appInfo", str2);
        bundle.putInt("sdkChannel", 1);
        bundle.putString("sdkData", str);
        bundle.putString("packageName", payInfo.getApp().getHostPackageName());
        bundle.putString("callbackScheme", payInfo.getCallbackScheme());
        bundle.putInt("appPayType", payInfo.getBase().getPayAppType());
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 9);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 4);
        QWalletPayBridge.launchForeground(this, bundle);
        finish();
    }

    private void I2(PayInfo payInfo) {
        int i3;
        if (!J2()) {
            F2(-2, getString(R.string.f179673_0));
            return;
        }
        if (!G2(payInfo)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (TextUtils.equals(payInfo.getApp().getHostPackageName(), "com.tencent.mobileqq")) {
            i3 = 2;
        } else {
            i3 = 4;
        }
        bundle.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, i3);
        bundle.putInt("sdkChannel", 1);
        bundle.putParcelable(PayInfo.class.getName(), payInfo);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 4);
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 24);
        QWalletPayBridge.launchForeground(this, bundle);
        finish();
    }

    private boolean J2() {
        try {
            if (((OpenPayConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_WX_OPENPAY_CONFIG, new OpenPayConfig())).getContent().getIsForbidNewVersion() != 1) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, "" + System.currentTimeMillis() + " OpenPayActivity.doOnCreate");
        Bundle extras = super.getIntent().getExtras();
        if (extras == null) {
            F2(-1, getString(R.string.f1792738x));
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, "OpenPayActivity.doOnCreate app == null || bundle == null");
            return true;
        }
        PayInfo payInfo = (PayInfo) extras.getParcelable(PayInfo.class.getName());
        this.f390831a0 = payInfo;
        if (payInfo == null) {
            F2(-1, getString(R.string.f1792738x));
            QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "OpenPayActivity.doOnCreate mPayType error");
            return true;
        }
        if (payInfo.getBase().getPayType() == 1 && this.f390831a0.getBase().getPayPlatform() == 1) {
            if (this.f390831a0.o()) {
                I2(this.f390831a0);
            } else {
                H2(this.f390831a0);
            }
        } else {
            F2(-1, getString(R.string.f1792738x));
            QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "OpenPayActivity.doOnCreate mPayType error");
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
