package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.emosm.a;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.emoticonview.IEmoStoreWebViewFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public abstract class EmojiUiPlugin extends VasWebviewUiPlugin implements DialogInterface.OnDismissListener {
    public static final String tag = "Q.emoji.web.EmojiUiPlugin";
    protected int loadmode;
    protected String mSelfUin;
    QQProgressDialog progressDialog;
    int mActivityType = 2;
    protected int mSrcFromType = 1;
    protected boolean closeBtnClick = false;
    protected int mEmomallNewTimeFlag = -1;
    HomePageUrlInfo configUrl = new HomePageUrlInfo();
    HomePageLoadInfo homePageUrlInfo = new HomePageLoadInfo();
    String mSid = "";
    long openToOncreateGap = -1;
    long openTogetKeyTimeGap = -1;
    long openToFinishOrErrorGap = -1;
    int processStep = 1;
    boolean bNeedGetKey = false;
    int failcode = 0;
    String errordescription = "";
    String errorUrl = "";
    t mEmojiKeygetOnRemoteResp = new t() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.1
        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            if (QLog.isColorLevel()) {
                QLog.d(EmojiUiPlugin.tag, 2, "onBindedToClient");
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            if (bundle != null && bundle.getInt("respkey", 0) == this.key) {
                String string = bundle.getString("cmd");
                Bundle bundle2 = bundle.getBundle("response");
                int i3 = bundle.getInt("failcode");
                if (string != null && "writeQFaceResult".equals(string)) {
                    int i16 = -1;
                    int i17 = bundle2.getInt("result", -1);
                    String string2 = bundle2.getString("messge");
                    if (i3 != 1000) {
                        string2 = "QFaceResult error";
                    } else {
                        i16 = i17;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.emoji.EmoQFace", 2, "write qface result, result:" + i16 + " msg:" + string2);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class HomePageLoadInfo {
        boolean bUseConfigUrl = false;
        boolean isNeedKey = false;
        String homePageUrl = "";

        public HomePageLoadInfo() {
        }
    }

    /* loaded from: classes20.dex */
    public class HomePageUrlInfo {
        String index = "";
        String detail = "";
        boolean indexSession = false;
        boolean detailSession = false;

        public HomePageUrlInfo() {
        }
    }

    private void dismissProgressDialog() {
        this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                QQProgressDialog qQProgressDialog = EmojiUiPlugin.this.progressDialog;
                if (qQProgressDialog != null) {
                    qQProgressDialog.cancel();
                    EmojiUiPlugin.this.progressDialog = null;
                }
            }
        });
    }

    private void onPayResultCallback(String str, int i3, int i16, int i17, int i18, int i19, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("result", i3);
            jSONObject.put("message", str);
            jSONObject2.put("realSaveNum", i16);
            jSONObject2.put("payChannel", i17);
            jSONObject2.put("payState", i18);
            jSONObject2.put("provideState", i19);
            jSONObject.put("data", jSONObject2);
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "queryEmojiInfo resp to js:" + jSONObject.toString());
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("responseId", str2);
            jSONObject3.put(WebViewPlugin.KEY_RESPONSE, jSONObject);
            String jSONObject4 = jSONObject3.toString();
            this.mRuntime.e().loadUrl("javascript:qqJSBridge.setMessage('" + jSONObject4 + "')");
        } catch (JSONException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void showGetKeyErrorDialog() {
        QQCustomDialogThreeBtns leftButton = DialogUtil.createCustomThreeBtnsDialog(this.activity, 230).setTitle(this.activity.getString(R.string.f170883ax2)).setMessage(this.activity.getString(R.string.f170882ax1)).setLeftButton(this.activity.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        leftButton.setOnDismissListener(this);
        leftButton.setCanceledOnTouchOutside(false);
        leftButton.show();
    }

    private void showProgressDialog() {
        this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                EmojiUiPlugin.this.progressDialog = new QQProgressDialog(EmojiUiPlugin.this.mRuntime.a(), ((QQBrowserActivity) EmojiUiPlugin.this.mRuntime.a()).getTitleBarHeight());
                EmojiUiPlugin.this.progressDialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityCreate() {
        super.OnActivityCreate();
        this.mSelfUin = getInfoIntent().getExtras().getString("selfuin");
        this.mSid = getInfoIntent().getExtras().getString("emojimall_sid");
        getInfoIntent().getExtras().getBoolean("emojimall_qFace", false);
        this.openToOncreateGap = System.currentTimeMillis() - this.startOpenPageTime;
        this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
        this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt(VasWebviewConstants.KEY_MALL_NEW_TIMESTAMP, -1);
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, "emojiactivity oncreate");
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mEmojiKeygetOnRemoteResp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityDestroy() {
        super.OnActivityDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mEmojiKeygetOnRemoteResp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityPause() {
        super.OnActivityPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkOncreateParam(Intent intent) {
        String str;
        if (intent == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.mSelfUin)) {
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "checkOncreateParam activity type:" + this.mActivityType + " selfuin null");
            }
            return false;
        }
        int i3 = this.mSrcFromType;
        if (i3 == 8 || i3 == 4) {
            if (getInfoIntent() != null) {
                str = getInfoIntent().getStringExtra("emojimall_detail_id");
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i(tag, 2, "checkOncreateParam activity type:" + this.mActivityType + "detailid null");
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void closeAllPage() {
        int i3;
        if (this.closeBtnClick && ((i3 = this.mSrcFromType) == 1 || i3 == 6 || i3 == 9 || i3 == 13)) {
            this.closeBtnClick = false;
            Intent intent = new Intent();
            intent.addFlags(536870912);
            intent.putExtra("back_from_emojimall", true);
            intent.setComponent(SplashActivity.getAliasComponent(this.activity));
            this.activity.startActivity(BaseAIOUtils.m(intent, null));
            if (QLog.isDevelopLevel()) {
                QLog.d(tag, 4, "emojimallbaseactivity closeAllPage to chatactivity");
                return;
            }
            return;
        }
        if (this.mSrcFromType == 2) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.activity, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
            activityURIRequest.setFlags(603979776);
            activityURIRequest.extra().putBoolean("back_from_emojimall", true);
            QRoute.startUri(activityURIRequest);
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void doBeforeFinish() {
        closeAllPage();
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    protected boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934593L) {
            uiSetCallBack();
            return false;
        }
        if (j3 == 8589934594L) {
            if (this.activity != null) {
                this.openToFinishOrErrorGap = System.currentTimeMillis() - this.startOpenPageTime;
                this.processStep = 2;
                return false;
            }
            return false;
        }
        if (j3 == 8589934595L && this.activity != null) {
            this.openToFinishOrErrorGap = System.currentTimeMillis() - this.startOpenPageTime;
            this.processStep = 3;
            return false;
        }
        return false;
    }

    protected void getConfigUrl(int i3) {
        if (i3 == 6) {
            this.configUrl.index = IndividuationUrlHelper.getMarketUrl(this.activity, IndividuationUrlHelper.UrlId.MAGIC_PLUS, "");
            HomePageUrlInfo homePageUrlInfo = this.configUrl;
            if (homePageUrlInfo.index == null) {
                homePageUrlInfo.index = IndividuationUrlHelper.getMarketUrl(this.activity, "emoji", "");
            }
            this.configUrl.indexSession = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, "getConfigUrl:index:" + this.configUrl.index + ",detail:" + this.configUrl.detail + "indexsession:" + this.configUrl.indexSession + "detailsession:" + this.configUrl.detailSession);
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public boolean onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "onActivityResult request=" + i3 + " result=" + i16);
        }
        if (i3 == 1 && intent != null && intent.getExtras() != null) {
            a.b b16 = a.b.b(intent.getExtras());
            onPayResultCallback(b16.f204142f, b16.f204137a, b16.f204138b, b16.f204139c, b16.f204140d, b16.f204141e, a.C7495a.b(intent.getExtras()).f204123a);
        } else if (i3 == 4) {
            onPayResultCallback(intent);
        } else if (i3 == 5) {
            onPayResultCallback(intent);
        } else if (i3 == 9) {
            onPayResultCallback(intent);
        } else if (i3 == 6) {
            onPayResultCallback(intent);
        } else if (i3 == 8) {
            onPayResultCallback(intent);
        } else if (i3 == 7) {
            onPayResultCallback(intent);
        } else if (i3 != 201 || intent == null || intent.getExtras() == null) {
            return false;
        }
        return true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.activity.finish();
    }

    public void uiSetCallBack() {
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment != null) {
            webViewFragment.getUIStyleHandler().A(getInfoIntent(), this.homePageUrlInfo.homePageUrl);
            if (webViewFragment.getSwiftTitleUI().f314054i != null && this.mActivityType == 1) {
                int i3 = this.mSrcFromType;
                if (i3 == 1 || i3 == 6 || i3 == 13) {
                    webViewFragment.getSwiftTitleUI().f314054i.setText(R.string.close);
                    webViewFragment.getSwiftTitleUI().f314054i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            EmojiUiPlugin emojiUiPlugin = EmojiUiPlugin.this;
                            emojiUiPlugin.closeBtnClick = true;
                            if (emojiUiPlugin.mRuntime.f() instanceof IEmoStoreWebViewFragment) {
                                IEmoStoreWebViewFragment iEmoStoreWebViewFragment = (IEmoStoreWebViewFragment) EmojiUiPlugin.this.mRuntime.f();
                                iEmoStoreWebViewFragment.reportEmoStorePageCloseClickEvent();
                                EmojiUiPlugin.this.activity.finish();
                                iEmoStoreWebViewFragment.doOnEmoStorePageFinshed(EmojiUiPlugin.this.activity);
                            } else {
                                EmojiUiPlugin.this.activity.finish();
                            }
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                }
            }
        }
    }

    private void onPayResultCallback(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("callbackSn");
            String stringExtra2 = intent.getStringExtra("result");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            jSONObject.put("data", new JSONObject(stringExtra2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("responseId", stringExtra);
            jSONObject2.put(WebViewPlugin.KEY_RESPONSE, jSONObject);
            String jSONObject3 = jSONObject2.toString();
            this.mRuntime.e().loadUrl("javascript:qqJSBridge.setMessage('" + jSONObject3 + "')");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
