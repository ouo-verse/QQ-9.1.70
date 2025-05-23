package com.tenpay.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tenpay.QwLog;
import com.tenpay.api.FingerPayApi;
import com.tenpay.bank.BindBankModule;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.helper.PayHelper;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QWalletFakeUrl extends FakeUrl {
    public static final String FAKEURL_BINDCARDVERIFY = "bindCardVerify";
    public static final String FAKEURL_BINDNEWCARD = "bindNewCard";
    public static final String FAKEURL_PARAM_FILL_NAME = "fillName";
    public static final String FAKEURL_REGENERATEASKEY = "regenerateASKey";
    public static final String FAKEURL_REGENERATEAUTHKEY = "regenerateAuthKey";
    public static final String FAKEURL_TRANSFERINPUT = "transferInput";
    private static final String TAG = "QWalletFakeUrl";
    private ResultReceiver callback;
    private String uin;
    public static final String FAKEURL_COMFIRM_REQUEST = "confirmRequest";
    private static final List<String> NO_PROS_FAKEURL = Arrays.asList(FAKEURL_COMFIRM_REQUEST);

    public QWalletFakeUrl(Context context, String str) {
        init(context);
        this.uin = str;
    }

    @Keep
    private void bindCardVerify(Uri uri) {
        QwLog.i("start bind card verify...");
        Intent intent = new Intent();
        intent.putExtra("IsShiMing", true);
        if (!TextUtils.isEmpty(this.uin)) {
            intent.putExtra("uin", this.uin);
        }
        String queryParameter = uri.getQueryParameter("showIDCardVerify");
        if (TextUtils.isEmpty(queryParameter)) {
            intent.putExtra("IsIdVerifyValid", true);
        } else {
            intent.putExtra("IsIdVerifyValid", queryParameter.equals("1"));
        }
        Activity activity = this.context;
        if (activity instanceof QPublicFragmentActivity) {
            QPublicBaseFragment fragment = ((QPublicFragmentActivity) activity).getFragment();
            if (fragment instanceof NetBaseActivity) {
                ((NetBaseActivity) fragment).visitFakeUrlJumpBefore(intent, FAKEURL_BINDCARDVERIFY);
            }
        }
        Intent intent2 = this.context.getIntent();
        if (intent2 != null && intent2.hasExtra(SDKCallbackManager.SESSION_RECEIVER)) {
            intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, intent2.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER));
        }
        BindBankModule.INSTANCE.startVerify(this.context, intent);
    }

    @Keep
    private void bindNewCard(Uri uri) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(this.uin)) {
            intent.putExtra("uin", this.uin);
        }
        intent.putExtra("prefillUserInfo", uri.getQueryParameter("prefillUserInfo"));
        intent.putExtra("query_type", uri.getQueryParameter("query_type"));
        Activity activity = this.context;
        if (activity instanceof QPublicFragmentActivity) {
            QPublicBaseFragment fragment = ((QPublicFragmentActivity) activity).getFragment();
            if (fragment instanceof NetBaseActivity) {
                ((NetBaseActivity) fragment).visitFakeUrlJumpBefore(intent, FAKEURL_BINDNEWCARD);
            }
        }
        Intent intent2 = this.context.getIntent();
        if (intent2 != null && intent2.hasExtra(SDKCallbackManager.SESSION_RECEIVER)) {
            intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, intent2.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER));
        }
        BindBankModule.INSTANCE.startWithSwitch(this.context, intent, 3);
    }

    public static boolean hasQWalletFakeProtocal(JSONObject jSONObject) {
        String optString = jSONObject.optString("returl");
        String optString2 = jSONObject.optString(FakeUrl.FAKE_LEFT_URL);
        String optString3 = jSONObject.optString(FakeUrl.FAKE_LBUTTON);
        String optString4 = jSONObject.optString(FakeUrl.FAKE_RBUTTON);
        if ((!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString4)) || (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3))) {
            return true;
        }
        return false;
    }

    @Keep
    private void idCardVerify(Uri uri) {
        QwLog.i("start id Card Verify...");
        IdVerifyModule.startFromFakeUrl(this.context);
    }

    public static boolean ignoredFakeUrl(JSONObject jSONObject) {
        return jSONObject.toString().contains(FAKEURL_COMFIRM_REQUEST);
    }

    public static boolean isConfirmRequest(Uri uri) {
        if (uri != null && TextUtils.equals(uri.getHost(), FAKEURL_COMFIRM_REQUEST)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$regenerateASKey$0() {
        try {
            FingerPayApi.closeFingerPay(this.context, this.uin);
            SoterCore.removeAppGlobalSecureKey();
            SoterWrapperApi.removeAuthKeyByScene(Cgi.scene_FingerPay);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$regenerateAuthKey$1() {
        try {
            FingerPayApi.closeFingerPay(this.context, this.uin);
            SoterWrapperApi.removeAuthKeyByScene(Cgi.scene_FingerPay);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static FakeUrl.FakeInfo parseFakeUrlInfoQWallet(String str, JSONObject jSONObject) {
        FakeUrl.FakeInfo fakeInfo = new FakeUrl.FakeInfo();
        fakeInfo.reqUrl = str;
        fakeInfo.data = jSONObject;
        fakeInfo.retcode = jSONObject.optInt("retcode");
        fakeInfo.retmsg = jSONObject.optString("retmsg");
        fakeInfo.retUrl = jSONObject.optString("returl");
        fakeInfo.leftUrl = jSONObject.optString(FakeUrl.FAKE_LEFT_URL);
        fakeInfo.uri = parseUrlQWallet(fakeInfo.retUrl);
        fakeInfo.leftUri = parseUrlQWallet(fakeInfo.leftUrl);
        Uri uri = fakeInfo.uri;
        if (uri != null) {
            fakeInfo.host = uri.getHost();
        }
        Uri uri2 = fakeInfo.leftUri;
        if (uri2 != null) {
            fakeInfo.leftHost = uri2.getHost();
        }
        return fakeInfo;
    }

    private static Uri parseUrlQWallet(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        if (parse.getScheme() == null) {
            QwLog.i("no scheme...");
            return null;
        }
        return parse;
    }

    @Keep
    private void regenerateASKey(Uri uri) {
        QwLog.i("start re generate ASKey...");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.b
            @Override // java.lang.Runnable
            public final void run() {
                QWalletFakeUrl.this.lambda$regenerateASKey$0();
            }
        }, 128, null, false);
    }

    @Keep
    private void regenerateAuthKey(Uri uri) {
        QwLog.i("start re generate AuthKey...");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.a
            @Override // java.lang.Runnable
            public final void run() {
                QWalletFakeUrl.this.lambda$regenerateAuthKey$1();
            }
        }, 128, null, false);
    }

    @Keep
    private void transferInput(Uri uri) {
        Intent intent;
        QwLog.i("start transfer Input...");
        Intent intent2 = new Intent();
        intent2.putExtra("tag", FAKEURL_TRANSFERINPUT);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IProfileProtocolConst.PARAM_TARGET_UIN, uri.getQueryParameter(IProfileProtocolConst.PARAM_TARGET_UIN));
            jSONObject.put("avoidInput", true);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        intent2.putExtra("extra_data", jSONObject.toString());
        RouteUtils.startActivity(this.context, intent2, "/qwallet/transaction");
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver == null && (intent = this.context.getIntent()) != null && intent.hasExtra(SDKCallbackManager.SESSION_RECEIVER)) {
            resultReceiver = (ResultReceiver) intent.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER);
        }
        if (resultReceiver != null) {
            FakeUrl.FakeInfo fakeInfo = this.fakeInfo;
            resultReceiver.send(fakeInfo.retcode, PayHelper.createResultForError(fakeInfo.retmsg));
        }
        this.context.finish();
    }

    public boolean gotoFakeUrl(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                QwLog.i("error, api has no fake url...");
                return false;
            }
            this.fakeInfo.uri = Uri.parse(str);
            FakeUrl.FakeInfo fakeInfo = this.fakeInfo;
            Uri uri = fakeInfo.uri;
            if (uri != null) {
                fakeInfo.host = uri.getHost();
            }
            return parseFakeUrl(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return false;
        }
    }

    public boolean onApiFakePros(JSONObject jSONObject, FakeUrl.FakeListener fakeListener) {
        QwLog.i("api fake url processing...");
        this.f390853fl = fakeListener;
        return gotoFakeUrl(jSONObject.optString("url"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qwallet.plugin.FakeUrl
    public boolean parseFakeUrl(String str) {
        if (super.parseFakeUrl(str)) {
            QwLog.i("super parsed fake url...");
            return true;
        }
        QwLog.i("parsed host = " + this.fakeInfo.host);
        try {
            getClass().getDeclaredMethod(this.fakeInfo.host, Uri.class).invoke(this, this.fakeInfo.uri);
            return true;
        } catch (Exception e16) {
            QwLog.i("error, no fake url found...");
            QLog.e(TAG, 1, "", e16);
            return false;
        }
    }

    public void setCallback(ResultReceiver resultReceiver) {
        this.callback = resultReceiver;
    }
}
