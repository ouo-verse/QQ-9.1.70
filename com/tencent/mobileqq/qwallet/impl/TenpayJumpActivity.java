package com.tencent.mobileqq.qwallet.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.QzoneIPCModule;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "QQ\u652f\u4ed8-\u652f\u4ed8\u4e2d\u8f6c\u9875", path = "/qwallet/tenpay/jump")
/* loaded from: classes16.dex */
public class TenpayJumpActivity extends QBaseActivity {
    private static final int REQUEST_CODE_OPEN_TRANS = 1;
    public static final String TENPAY_SCHEME = "tenpay";
    private String callbackSn;
    private String mAppInfo;
    private String mAuthCode;
    private String mCodeNick;
    private String mCodeUin;
    private int mComeFrom;
    private Context mContext;
    private String mQqSkey;
    private String mQqSkeyType;
    private String mSource;
    private String mUin;
    private String mUrl;
    private String mUserNick;

    @Nullable
    private static JSONObject findStringJSON(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString(str);
        if (optString.length() > 0) {
            try {
                return new JSONObject(optString);
            } catch (Exception e16) {
                QLog.e("qqBaseActivity", 1, "error msg in qqpay-impl module: ", e16);
                return null;
            }
        }
        return null;
    }

    private void gotoTenPayView(JSONObject jSONObject) {
        String str = "";
        jSONObject.optInt("type");
        String optString = jSONObject.optString("trans_uin");
        if (!this.mCodeUin.equals(optString)) {
            showToast(HardCodeUtil.qqStr(R.string.u2n));
            finish();
            return;
        }
        String optString2 = jSONObject.optString("trans_fee");
        jSONObject.optString(AlbumCacheData.CREATE_TIME);
        String targetString = getTargetString(jSONObject.optString(QFSEdgeItem.KEY_EXTEND), "explain=", ContainerUtils.FIELD_DELIMITER);
        String optString3 = jSONObject.optString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        String friendShowName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getFriendShowName(this.mCodeUin);
        if (!TextUtils.isEmpty(friendShowName) && !friendShowName.equals(this.mCodeUin)) {
            optString3 = friendShowName;
        }
        if (TextUtils.isEmpty(optString3) || optString3.equals(this.mCodeUin)) {
            optString3 = this.mCodeNick;
        }
        Intent intent = new Intent();
        intent.putExtra("come_from", this.mComeFrom);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(IProfileProtocolConst.PARAM_TARGET_UIN, optString);
            jSONObject2.put("targetNickname", optString3);
            jSONObject2.put("trans_fee", optString2);
            jSONObject2.put("sign", "");
            jSONObject2.put("source", this.mSource);
            jSONObject2.put("desc", URLDecoder.decode(targetString, "UTF-8"));
        } catch (UnsupportedEncodingException | JSONException e16) {
            QLog.e("qqBaseActivity", 1, "error msg in qqpay-impl module: ", e16);
        }
        intent.putExtra("extra_data", jSONObject2.toString());
        intent.putExtra(j.T0, this.mAppInfo);
        intent.putExtra("callbackSn", this.callbackSn);
        intent.putExtra("fromJump", true);
        intent.putExtra("isJumpToH5", false);
        if (!TextUtils.isEmpty(this.mAuthCode)) {
            str = this.mAuthCode;
        }
        intent.putExtra("authCode", str);
        RouteUtils.startActivityForResult(this.mContext, intent, "/qwallet/transaction", 1);
    }

    private void onOpenTransResult(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("callbackSn", this.callbackSn);
        intent2.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
        if (intent != null) {
            intent2.putExtra("result", intent.getStringExtra("result"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void openTenpayView(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", this.mUin);
            jSONObject.put(HippyHeaderListViewController.VIEW_TAG, str);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, this.mComeFrom);
            jSONObject.put("appInfo", this.mAppInfo);
            jSONObject.put("extra_data", str2);
            PayBridgeActivity.tenpay(this, jSONObject.toString(), 5, "0");
        } catch (Exception e16) {
            sendCallback(-1, null);
            QLog.e("qqBaseActivity", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public void addUploadData(int i3, String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(i3));
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
        int indexOf;
        super.doOnCreate(bundle);
        setProgressBarIndeterminateVisibility(false);
        setRequestedOrientation(1);
        this.mContext = this;
        try {
            this.mUin = getCurrentAccountUinFromRuntime();
            this.mUserNick = getCurrentNickname();
            this.mQqSkeyType = "2";
            this.mComeFrom = getIntent().getIntExtra("come_from", 5);
            this.callbackSn = getIntent().getStringExtra("callbackSn");
            this.mAppInfo = getIntent().getStringExtra(j.T0);
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("extra_data"));
            this.mUrl = jSONObject.optString("url");
            this.mCodeUin = jSONObject.optString("uin");
            this.mCodeNick = jSONObject.optString("name");
            String optString = jSONObject.optString("url");
            int indexOf2 = optString.indexOf("&f=");
            if (indexOf2 > 0 && (indexOf = (optString = optString.substring(indexOf2 + 3)).indexOf(38)) > 0) {
                optString = optString.substring(0, indexOf);
            }
            if (QCircleDaTongConstant.ElementParamValue.WALLET.equals(optString)) {
                this.mSource = "1";
            } else if ("apw".equals(optString)) {
                this.mSource = "2";
            }
            String friendShowName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getFriendShowName(this.mCodeUin);
            if (!TextUtils.isEmpty(friendShowName) && !friendShowName.equals(this.mCodeUin)) {
                this.mCodeNick = friendShowName;
            }
            sendVerifyQrcode();
        } catch (Exception e16) {
            QLog.e("qqBaseActivity", 1, "error msg in qqpay-impl module: ", e16);
        }
        addUploadData(128, "scan.qrcode.loading");
        return true;
    }

    public String getCurrentNickname() {
        AppRuntime appRuntime = QWalletHelperImpl.getAppRuntime();
        if (appRuntime == null) {
            return "";
        }
        if (appRuntime instanceof BaseQQAppInterface) {
            return ((BaseQQAppInterface) appRuntime).getCurrentNickname();
        }
        return appRuntime.getAccount();
    }

    public String getTargetString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(str2) + str2.length();
        int indexOf2 = str.indexOf(str3, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        if (indexOf == -1 || indexOf >= str.length() || indexOf2 == -1) {
            return "";
        }
        return str.substring(indexOf, indexOf2);
    }

    public int getTitleBarHeight(Context context) {
        try {
            return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) (context.getResources().getDisplayMetrics().density * 5.0f));
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i3, int i16, Intent intent) {
        JSONObject jSONObject;
        int i17;
        JSONObject jSONObject2;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            onOpenTransResult(intent);
            return;
        }
        if (intent != null && i16 == -1) {
            String stringExtra = intent.getStringExtra("result");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    jSONObject = new JSONObject(stringExtra);
                } catch (Exception e16) {
                    QLog.e("qqBaseActivity", 1, "error msg in qqpay-impl module: ", e16);
                }
                if (jSONObject == null) {
                    i17 = jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1);
                    jSONObject2 = findStringJSON(jSONObject, "data");
                } else {
                    i17 = -1;
                    jSONObject2 = null;
                }
                if (i17 != 0 && jSONObject2 != null) {
                    if (i3 == 5) {
                        gotoTenPayView(jSONObject2);
                        return;
                    }
                    return;
                } else {
                    sendCallback(-1, null);
                    finish();
                }
            }
            jSONObject = null;
            if (jSONObject == null) {
            }
            if (i17 != 0) {
            }
            sendCallback(-1, null);
            finish();
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
        requestWindowFeature(1);
    }

    public void sendCallback(int i3, Bundle bundle) {
        if (bundle == null) {
            new Bundle();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, i3);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.putExtra("callbackSn", this.callbackSn);
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
        intent.putExtra("result", jSONObject.toString());
        setResult(-1, intent);
    }

    protected void sendVerifyQrcode() {
        JSONObject jSONObject = new JSONObject();
        try {
            Uri parse = Uri.parse(this.mUrl);
            String queryParameter = parse.getQueryParameter("dy");
            String queryParameter2 = parse.getQueryParameter("su");
            String queryParameter3 = parse.getQueryParameter("u");
            String decode = URLDecoder.decode(parse.getQueryParameter(ac.f283467k0));
            jSONObject.put("auth_code", decode);
            if ("1".equals(queryParameter)) {
                if (this.mUin.equals(queryParameter3)) {
                    showToast(HardCodeUtil.qqStr(R.string.u2l));
                    finish();
                    return;
                }
                if (!this.mUin.equals(queryParameter2)) {
                    showToast(HardCodeUtil.qqStr(R.string.u2m));
                    finish();
                    return;
                }
                if (decode.startsWith("*")) {
                    decode = decode.substring(1, decode.length());
                }
                jSONObject.put("tokenId", decode);
                jSONObject.put("dy", "1");
                Bundle bundle = new Bundle();
                bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
                bundle.putString("callbackSn", "0");
                PayBridgeActivity.tenpay(this, 9, bundle);
                com.tencent.mobileqq.qwallet.c.c("scanTransferLimmitQR", 0);
                return;
            }
            this.mAuthCode = decode;
            openTenpayView("verifyqrcode", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void showToast(CharSequence charSequence) {
        if (!isFinishing()) {
            QQToast.makeText(this, charSequence, 0).show(getTitleBarHeight(this.mContext));
        }
    }
}
