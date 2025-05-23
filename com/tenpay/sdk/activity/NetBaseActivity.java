package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tenpay.QwLog;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.apilogic.ApiConfigGet;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.util.Utils;
import com.tenpay.view.WalletProgressDialog;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class NetBaseActivity extends TenpayUtilActivity implements Net.NetListener, FakeUrl.FakeListener {
    public static int MAX_RETRY_COUNT = 3;
    public volatile WalletProgressDialog mQQPayLoading;
    protected long mReTryCount;
    protected final String TAG = getClass().getSimpleName();
    protected Handler mHandler = new Handler();
    protected List<ReqParam> mReqs = new ArrayList();
    protected boolean isDismissLoading = true;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ReqParam {
        String baseUrl;

        /* renamed from: bl, reason: collision with root package name */
        TenpayBL f386688bl;
        Map<String, String> data;
        boolean isEncript;
        boolean isShowLoading;
        int loadingHeight;

        public ReqParam(String str, Map<String, String> map, boolean z16, boolean z17, int i3, TenpayBL tenpayBL) {
            this.baseUrl = str;
            this.data = map;
            this.isEncript = z16;
            this.isShowLoading = z17;
            this.loadingHeight = i3;
            this.f386688bl = tenpayBL;
        }
    }

    private void baseBlPros(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("retcode");
        if (!QWalletFakeUrl.hasQWalletFakeProtocal(jSONObject) && !isFinishing()) {
            if (!TextUtils.isEmpty(jSONObject.optString(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP))) {
                return;
            }
            if (getSpecialErrorCode().contains(optString)) {
                QwLog.i("logic layer processed the error code...");
                return;
            }
            QwLog.i("base net show dialog...");
            FakeInfo parseFrom = FakeInfo.parseFrom(str, jSONObject);
            if (parseFrom != null) {
                QQToast.makeText(getContext(), parseFrom.getRetMsg(), 0).show();
                afterShowErrorToast(parseFrom);
                return;
            }
            return;
        }
        QwLog.i("fake url process...");
    }

    private void httpRequestInner(String str, Map<String, String> map, boolean z16, boolean z17, int i3) {
        if (z17) {
            showQQPayLoading(i3);
        }
        NetSender.with(getContext(), str, map, this.mUin).comeFrom(Integer.toString(this.mComeFrom)).encrypt(z16).tokenID(this.mPayTokenId).request(this);
    }

    private boolean inErrorFinishList(FakeInfo fakeInfo) {
        String requestUrl = fakeInfo.getRequestUrl();
        if (requestUrl == null) {
            return false;
        }
        QLog.w(this.TAG, 1, "errorAfterToastFinishList=" + Cgi.errorAfterToastFinishList.toString());
        Iterator<String> it = Cgi.errorAfterToastFinishList.iterator();
        while (it.hasNext()) {
            if (requestUrl.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onBlError$0(FakeInfo fakeInfo, FakeUrlDialogBuilder.BtnIndex btnIndex, Uri uri) {
        return onBlHandleFakeurl(fakeInfo.toOldFakeInfo(), btnIndex.ordinal());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveConfig$1(JSONObject jSONObject) {
        ConfigUtil.saveUserInfoExtend(this.mUin, jSONObject);
    }

    protected void afterShowErrorToast(FakeInfo fakeInfo) {
        if (inErrorFinishList(fakeInfo)) {
            setRetCodeAndErrorMsg(fakeInfo.getRetCode(), fakeInfo.getRetMsg());
            if (this.callback_when_cancel_pay) {
                callBackReceiver();
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void commonBlErrorPros(JSONObject jSONObject, boolean z16) {
        int optInt = jSONObject.optInt("retcode");
        String optString = jSONObject.optString("retmsg");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("err_msg", optString);
        } catch (Exception unused) {
        }
        setRetCodeMsgAndGetBundle(optInt, jSONObject2.toString());
        if (z16) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissQQPayLoading() {
        if (getContext() == null) {
            return;
        }
        synchronized (NetBaseActivity.class) {
            try {
                if (this.mQQPayLoading != null && this.mQQPayLoading.isShowing()) {
                    this.mQQPayLoading.dismiss();
                    this.mQQPayLoading = null;
                }
            } catch (Exception e16) {
                QLog.e(this.TAG, 1, "", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        Handler handler = this.mHandler;
        if (handler != null && Build.VERSION.SDK_INT >= 24) {
            handler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.NetBaseActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    NetBaseActivity.super.finish();
                }
            }, 80L);
        } else {
            super.finish();
        }
    }

    protected List<String> getSpecialErrorCode() {
        return new ArrayList();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void httpRequest(String str, Map<String, String> map) {
        httpRequest(str, map, true);
    }

    public void httpRequestNoEncript(String str, Map<String, String> map) {
        httpRequestInner(str, map, false, true, 0);
    }

    public void httpRequestNoLoading(String str, Map<String, String> map) {
        httpRequestInner(str, map, true, false, 0);
    }

    public void httpRequestWithQQPayLoading(String str, Map<String, String> map, int i3) {
        httpRequestInner(str, map, true, true, i3);
    }

    public void onBlError(String str, JSONObject jSONObject) {
        if (!this.isDismissLoading) {
            return;
        }
        dismissQQPayLoading();
        if (FakeUrlUtils.isUseNewFakeUrl()) {
            QWalletFakeUrlHandler qWalletFakeUrlHandler = new QWalletFakeUrlHandler(getContext(), this.mUin);
            if (FakeUrlUtils.isConfirmRequest(jSONObject)) {
                QLog.i(this.TAG, 1, "UI ignored fakeUrl: " + str);
                return;
            }
            if (qWalletFakeUrlHandler.handle(str, jSONObject, new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.activity.cc
                @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                public final boolean onClickButton(FakeInfo fakeInfo, FakeUrlDialogBuilder.BtnIndex btnIndex, Uri uri) {
                    boolean lambda$onBlError$0;
                    lambda$onBlError$0 = NetBaseActivity.this.lambda$onBlError$0(fakeInfo, btnIndex, uri);
                    return lambda$onBlError$0;
                }
            })) {
                if (Utils.isEmpty(jSONObject.optString("alert_show"))) {
                    com.tencent.mobileqq.qwallet.c.e(jSONObject.optString("alert_show"), "", "", "", "");
                    return;
                }
                return;
            }
            baseBlPros(str, jSONObject);
            return;
        }
        QWalletFakeUrl qWalletFakeUrl = new QWalletFakeUrl(getContext(), this.mUin);
        if (QWalletFakeUrl.ignoredFakeUrl(jSONObject)) {
            QLog.i(this.TAG, 1, "UI ignored fakeUrl: " + str);
            return;
        }
        if (QWalletFakeUrl.hasQWalletFakeProtocal(jSONObject) && qWalletFakeUrl.onFakePros(str, jSONObject, this)) {
            if (Utils.isEmpty(jSONObject.optString("alert_show"))) {
                com.tencent.mobileqq.qwallet.c.e(jSONObject.optString("alert_show"), "", "", "", "");
                return;
            }
            return;
        }
        baseBlPros(str, jSONObject);
    }

    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        QwLog.i(String.format("fake url callback reqUrl = %s\n uri = %s", fakeInfo.reqUrl, fakeInfo.uri));
        if (Cgi.errorFinishList.contains(fakeInfo.reqUrl)) {
            setRetCodeAndErrorMsg(fakeInfo.retcode, fakeInfo.retmsg);
            if (this.callback_when_cancel_pay) {
                callBackReceiver();
            }
            finish();
            return false;
        }
        if (i3 == 1) {
            onNetDlgokClick(fakeInfo.reqUrl, fakeInfo.data);
        }
        return false;
    }

    @Override // cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onClickUrl(String str) {
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Iterator<ReqParam> it = this.mReqs.iterator();
        while (it.hasNext()) {
            TenpayBL tenpayBL = it.next().f386688bl;
            if (tenpayBL != null) {
                tenpayBL.setNetListener(null);
            }
        }
        this.mReqs.clear();
        this.mHandler.removeCallbacksAndMessages(null);
        dismissQQPayLoading();
        super.onDestroy();
    }

    public void onError(String str, JSONObject jSONObject) {
        dismissQQPayLoading();
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_CGI_ONERROR_DIALOG, true)) {
            showErrorDialog(str, jSONObject);
        }
    }

    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("retcode");
        String optString = jSONObject.optString("retmsg");
        if (Cgi.errorFinishList.contains(str)) {
            setRetCodeAndErrorMsg(optInt, optString);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNetLogicPros(String str, JSONObject jSONObject) {
        saveConfig(str, jSONObject);
        if (Cgi.URI_PAY_GATE.equals(str) || Cgi.URL_WALLET_GATE.equals(str)) {
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            new ApiConfigGet(getContext(), new UserInfo(this.mUin, this.mUserNick)).checkCacheVersion(this.mCacheVer);
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    public void onSuccess(String str, JSONObject jSONObject) {
        if (getContext() == null) {
            return;
        }
        dismissQQPayLoading();
        onNetLogicPros(str, jSONObject);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    public void retryRequest(FakeUrl.FakeInfo fakeInfo) {
        Set<String> queryParameterNames;
        if (fakeInfo != null && !TextUtils.isEmpty(fakeInfo.reqUrl)) {
            for (int size = this.mReqs.size() - 1; size >= 0; size--) {
                ReqParam reqParam = this.mReqs.get(size);
                if (reqParam != null && fakeInfo.reqUrl.equals(reqParam.baseUrl)) {
                    if (reqParam.data == null) {
                        reqParam.data = new HashMap();
                    }
                    Uri uri = fakeInfo.uri;
                    if (uri != null && (queryParameterNames = uri.getQueryParameterNames()) != null) {
                        for (String str : queryParameterNames) {
                            reqParam.data.put(str, fakeInfo.uri.getQueryParameter(str));
                        }
                    }
                    httpRequestInner(reqParam.baseUrl, reqParam.data, reqParam.isEncript, reqParam.isShowLoading, reqParam.loadingHeight);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void saveConfig(String str, final JSONObject jSONObject) {
        if (Cgi.URI_PAY_UNIFIED_CONFIG.equals(str)) {
            ConfigUtil.saveUnifiedConfig(jSONObject);
        } else if (Cgi.URL_WALLET_GATE.equals(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.activity.cb
                @Override // java.lang.Runnable
                public final void run() {
                    NetBaseActivity.this.lambda$saveConfig$1(jSONObject);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIsDismissLoading(boolean z16) {
        this.isDismissLoading = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showErrorDialog(final String str, final JSONObject jSONObject) {
        QUIProxy.createCustomDialog(getContext(), 230, null, jSONObject.optString("retmsg"), getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.NetBaseActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                NetBaseActivity.this.onNetDlgokClick(str, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showQQPayLoading(int i3) {
        if (getContext() != null && !isFinishing()) {
            try {
                if (this.mQQPayLoading == null) {
                    this.mQQPayLoading = new WalletProgressDialog(getContext());
                }
                if (!this.mQQPayLoading.isShowing()) {
                    this.mQQPayLoading.setHeight(i3);
                    this.mQQPayLoading.setCancelable(false);
                    this.mQQPayLoading.show();
                }
            } catch (Exception e16) {
                QLog.e(this.TAG, 1, "", e16);
            }
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public void httpRequest(String str, Map<String, String> map, boolean z16) {
        httpRequestInner(str, map, true, z16, 0);
    }

    public void visitFakeUrlJumpBefore(Intent intent, String str) {
    }
}
