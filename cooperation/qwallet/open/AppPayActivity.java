package cooperation.qwallet.open;

import a15.a;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.base.MidasPayExt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.QwLog;
import cooperation.qwallet.open.api.IOpenPayApi;
import cooperation.qwallet.open.data.AppPayExt;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qwallet.plugin.IQWalletHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes28.dex */
public class AppPayActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private boolean f390830a0 = false;

    private void F2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = null;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("action");
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("name");
            }
        } catch (JSONException e16) {
            QLog.w("qqBaseActivity", 1, "doBrowserPay error: " + str, e16);
        }
        if (TextUtils.equals(OpenConstants.ApiName.PAY, str2) || TextUtils.equals(OpenConstants.ApiName.PAY_V2, str2)) {
            PayInfo d16 = a.d(this, str);
            d16.getBase().j(com.tencent.mobileqq.base.a.c());
            J2(d16);
        }
        super.finish();
    }

    private void G2(Intent intent, boolean z16) {
        boolean z17;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("_mqqpay_baseapi_apiname");
        if (stringExtra == null) {
            stringExtra = OpenConstants.ApiName.PAY;
        }
        boolean equals = TextUtils.equals(stringExtra, OpenConstants.ApiName.PAY_V2);
        QwLog.i("doOpenPay: isPayV2=" + equals + ", isFromBundledMidas=" + z16);
        if (z16 && !equals) {
            try {
                z17 = ((IOpenPayApi) QRoute.api(IOpenPayApi.class)).launchCompatOpenPay(this, intent);
            } catch (Exception e16) {
                QLog.e("qqBaseActivity", 1, "doOpenPay: ", e16);
                z17 = false;
            }
            if (z17) {
                return;
            }
        }
        PayInfo a16 = a.a(this, intent, stringExtra);
        if (a16 != null) {
            a16.getBase().j(com.tencent.mobileqq.base.a.c());
            J2(a16);
        } else {
            QLog.e("qqBaseActivity", 1, "doOpenPay fail, unkonwn apiName" + stringExtra);
        }
        super.finish();
    }

    private void H2(boolean z16) {
        String str;
        Intent intent = super.getIntent();
        if (intent == null) {
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, System.currentTimeMillis() + " AppPayActivity.doPay intent == null");
            return;
        }
        QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, System.currentTimeMillis() + " AppPayActivity.doPay");
        boolean I2 = I2(intent);
        if (z16 && !getAppRuntime().isLogin() && !I2) {
            Intent intent2 = new Intent();
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(intent);
            RouteUtils.startActivityForResult(this, intent2, RouterConstants.UI_ROUTER_LOGIN, 21);
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, System.currentTimeMillis() + " AppPayActivity.doPay login");
            return;
        }
        String str2 = null;
        try {
            str = intent.getDataString();
        } catch (Exception e16) {
            QLog.e("qqBaseActivity", 1, "AppPayActivity.doPay error: ", e16);
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str.length() > 9) {
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, "AppPayActivity.doPay url:" + str);
            if (OpenConstants.PayApi.OPEN_QQ_PAY_SCHEMA.compareTo(str) == 0) {
                G2(intent, I2);
                return;
            }
            if ("mqqwallet://pubacc_pay/".compareTo(str) == 0) {
                super.finish();
                return;
            }
            int indexOf = str.indexOf("mqqwallet://");
            if (indexOf != -1) {
                try {
                    str2 = new String(i.a(str.substring(indexOf + 12), 0));
                } catch (Exception e17) {
                    QLog.e("qqBaseActivity", 1, "error msg in qqpay-impl module: ", e17);
                }
                if (str2 != null) {
                    F2(str2);
                    return;
                }
            }
            QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "AppPayActivity.doPay url not THIRD_APP:" + str);
            return;
        }
        QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "AppPayActivity.doPay url error:" + str);
        super.finish();
    }

    private boolean I2(Intent intent) {
        String j3 = AppPayExt.j(intent);
        boolean checkParams = new MidasPayExt().fromBundle(intent.getExtras()).checkParams();
        if (TextUtils.equals("com.tencent.mobileqq", j3) && checkParams) {
            return true;
        }
        return false;
    }

    private void J2(PayInfo payInfo) {
        if (payInfo.a()) {
            Intent intent = new Intent(this, (Class<?>) OpenPayActivity.class);
            intent.putExtra(PayInfo.class.getName(), payInfo);
            intent.addFlags(67108864);
            super.startActivity(intent);
        }
    }

    private void K2() {
        String str;
        Intent intent = super.getIntent();
        if (intent != null && !TextUtils.isEmpty(intent.getAction()) && intent.getAction().equals(CommonConstant.ACTION.HWID_SCHEME_URL) && !TextUtils.isEmpty(intent.getScheme()) && intent.getScheme().equals("mqqwallet")) {
            H2(true);
            return;
        }
        if (intent == null) {
            str = "intent is null";
        } else {
            str = ("Scheme:" + intent.getScheme()) + " Action:" + intent.getAction();
        }
        QLog.e(IQWalletHelper.TAG_WALLET_PAY, 1, "AppPayActivity.prePay error, params:" + str);
        super.finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 21) {
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, System.currentTimeMillis() + " AppPayActivity.doOnActivityResult PAY_LOGIN_REQUEST");
            H2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IQWalletTemp iQWalletTemp;
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        try {
            super.doOnCreate(bundle);
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, "" + System.currentTimeMillis() + " AppPayActivity.doOnCreate");
            try {
                iQWalletTemp = (IQWalletTemp) QRoute.api(IQWalletTemp.class);
            } catch (Throwable th5) {
                QLog.e("qqBaseActivity", 1, "doOnCreate|exp:" + th5.getMessage());
            }
            if (!QBaseActivity.mAppForground && this.mCanLock && getAppRuntime().getCurrentAccountUin() != null && iQWalletTemp.getJumpLock(this, getAppRuntime().getCurrentAccountUin())) {
                QLog.i(IQWalletHelper.TAG_WALLET_PAY, 1, "" + System.currentTimeMillis() + " AppPayActivity.doOnCreate getJumpLock");
                this.f390830a0 = true;
                return false;
            }
            K2();
            return false;
        } catch (Exception e16) {
            QLog.e("qqBaseActivity", 1, "doOnCreate|exp:" + e16.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (this.f390830a0 && Math.abs(QBaseActivity.mShowGesture - SystemClock.uptimeMillis()) >= 1000) {
            this.f390830a0 = false;
            K2();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        super.requestWindowFeature(1);
    }
}
