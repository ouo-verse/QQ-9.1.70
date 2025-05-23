package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class IndividuationPlugin extends VasWebviewJsPlugin {
    public static final String BusinessName = "individuation";
    public static final String Business_Activity = "0";
    public static final String Business_Bubble = "200";
    public static final String Business_ChagBg = "500";
    public static final String Business_ColorRing = "900";
    public static final String Business_Emoji = "100";
    public static final String Business_Emoji_Detail = "101";
    public static final String Business_Font = "300";
    public static final String Business_Pendant = "400";
    public static final String Business_Profilecard = "700";
    public static final String Business_Suit = "800";
    public static final String Business_Theme = "600";
    public static final String Business_funcall = "1000";
    public static final String Method_IsSupportFont = "isSupportFont";
    public static final String Method_OpenPage = "openPage";
    public static final String Method_setRightButton = "setRightButton";
    public static final int RIGHTBUTTON_TYPE_FONT = 2;
    public static final int RIGHTBUTTON_TYPE_WEB = 1;
    public static final int RequestCode_ThemeMall = 0;
    public static final byte Start_Activity_Request_Code_ChatBg = 1;
    public static final String TAG = "IndividuationPlugin";
    protected Activity mActivity;
    private BrowserAppInterface mBrowserApp;

    protected void getFontType(JSONObject jSONObject, String str) {
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(Method_IsSupportFont, str, this.mOnRemoteResp.key, new Bundle()), false, true);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BusinessName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleJsRequest, url=" + str + ",pkgName=" + str2 + ",method=" + str3);
        }
        if (str == null || !BusinessName.equals(str2) || str3 == null) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (Method_OpenPage.equals(str3)) {
            if (TextUtils.isEmpty(optString)) {
                optString = "";
            }
            openPage(jsonFromJSBridge, optString);
        } else if (Method_IsSupportFont.equals(str3)) {
            if (TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "callback id is null, so return");
                return true;
            }
            getFontType(jsonFromJSBridge, optString);
        } else if (Method_setRightButton.equals(str3)) {
            setRightButton(jsonFromJSBridge);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "No such method: " + str3 + ", url=" + str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mActivity = this.mRuntime.a();
        this.mBrowserApp = (BrowserAppInterface) this.mRuntime.b();
    }

    protected void openPage(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("business");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "openPage, business=" + string);
            }
            if (Business_Theme.equals(string)) {
                ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_ENGINE, 150, 1, BaseApplicationImpl.IS_SUPPORT_THEME ? 1 : -40, ThemeUtil.getUserCurrentThemeId(this.mRuntime.b()), ThemeUtil.getUserCurrentThemeVersion(this.mRuntime.b()), "2", "");
                if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
                    QQToast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(R.string.i0b), 0).show();
                    return;
                }
                if (!Utils.B()) {
                    QQToast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(R.string.h9v), 0).show();
                    return;
                }
                Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, false);
                Activity activity = this.mActivity;
                VasWebviewUtil.openQQBrowserWithoutAD(activity, IndividuationUrlHelper.getMarketUrl(activity, "theme", IndividuationUrlHelper.AdTag.INDIVIDUATION_THEME_ADTAG), 32L, intent, true, 0);
                return;
            }
            if ("500".equals(string)) {
                Intent intent2 = new Intent();
                intent2.putExtra("bg_replace_entrance", 8);
                intent2.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.mActivity.getString(R.string.button_back));
                intent2.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent2.putExtra("show_right_close_button", false);
                intent2.putExtra("url", IndividuationUrlHelper.getMarketUrl(this.mActivity, "background", ""));
                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent2.putExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, true);
                VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), IndividuationUrlHelper.getMarketUrl(this.mRuntime.a(), "background", ""), 33554432L, intent2, true, 1);
                ReportController.o(null, "CliOper", "", "", "0X8004E0D", "0X8004E0D", 0, 0, "", "", "", "");
                return;
            }
            if ("200".equals(string)) {
                Intent intent3 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent3.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, false);
                Activity activity2 = this.mActivity;
                VasWebviewUtil.openQQBrowserWithoutAD(activity2, IndividuationUrlHelper.getMarketUrl(activity2, "bubble", IndividuationUrlHelper.AdTag.INDIVIDUATION_BUBBLE_ADTAG), 64L, intent3, false, -1);
                return;
            }
            if ("100".equals(string)) {
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("openEmojiMall", str, this.mOnRemoteResp.key, new Bundle()), true, true);
                return;
            }
            if ("101".equals(string)) {
                String string2 = jSONObject.getString("detailId");
                Bundle bundle = new Bundle();
                bundle.putString("pkgId", string2);
                bundle.putBoolean("isQFace", false);
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("openEmojiDetail", str, this.mOnRemoteResp.key, bundle), true, true);
                return;
            }
            if (Business_Pendant.equals(string)) {
                if (!Utils.B()) {
                    QQToast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(R.string.h9v), 0).show();
                    return;
                }
                Intent intent4 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent4.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent4.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent4.putExtra("show_right_close_button", false);
                intent4.putExtra("url", IndividuationUrlHelper.getMarketUrl(this.mActivity, IndividuationUrlHelper.UrlId.PENDANT_HOME, ""));
                intent4.putExtra("business", 512L);
                intent4.putExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, true);
                VasWebviewUtil.insertVasWbPluginToIntent(512L, intent4);
                intent4.putExtra("isShowAd", false);
                this.mActivity.startActivity(intent4);
                ReportController.o(null, "CliOper", "", "", "PendantMarket", "WebEntrance", 0, 0, "", "", "", "");
                return;
            }
            if (Business_Font.equals(string)) {
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("openFontSetting", str, this.mOnRemoteResp.key, new Bundle()), true, true);
                return;
            }
            if (Business_Profilecard.equals(string)) {
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("openProfileCard", str, this.mOnRemoteResp.key, new Bundle()), true, true);
                return;
            }
            if (Business_Suit.equals(string)) {
                Intent intent5 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent5.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent5.putExtra("show_right_close_button", false);
                intent5.putExtra("startOpenPageTime", System.currentTimeMillis());
                VasNtCommonReporter.getHistoryFeature("suit_home").report(false);
                Activity activity3 = this.mActivity;
                VasWebviewUtil.openQQBrowserWithoutAD(activity3, IndividuationUrlHelper.getMarketUrl(activity3, IndividuationUrlHelper.UrlId.SUIT_HOME, IndividuationUrlHelper.AdTag.INDIVIDUATION_SUIT_ADTAG), 262144L, intent5, false, -1);
                return;
            }
            if ("900".equals(string)) {
                Intent intent6 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent6.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent6.putExtra("show_right_close_button", false);
                intent6.putExtra("startOpenPageTime", System.currentTimeMillis());
                Activity activity4 = this.mActivity;
                VasWebviewUtil.openQQBrowserWithoutAD(activity4, IndividuationUrlHelper.getMarketUrl(activity4, IndividuationUrlHelper.UrlId.RING_HOME, "mvip.gongneng.anroid.individuation.web"), 4194304L, intent6, false, -1);
                return;
            }
            if ("0".equals(string)) {
                Intent intent7 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                String replace = URLDecoder.decode(jSONObject.getString("detailId"), "UTF-8").replace("{uin}", this.mBrowserApp.getCurrentAccountUin()).replace("{client}", "androidQQ").replace("{version}", AppSetting.f99554n).replace("{platformId}", "2").replace("{device}", Build.DEVICE).replace("{system}", Build.VERSION.RELEASE).replace("{systemInt}", Integer.toString(Build.VERSION.SDK_INT)).replace("{adtag}", "mvip.gongneng.anroid.individuation.web").replace("{updateFlag}", "false").replace("{density}", ThemeUtil.getThemeDensity(this.mBrowserApp.getApplication().getApplicationContext()));
                intent7.putExtra("url", replace);
                VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, replace, -1L, intent7, false, -1);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Unknown business: " + string);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
        }
    }

    public void setRightButton(JSONObject jSONObject) {
        String str;
        WebViewFragment webViewFragment;
        try {
            int i3 = jSONObject.has("type") ? jSONObject.getInt("type") : -1;
            String str2 = "";
            if (!jSONObject.has("text")) {
                str = "";
            } else {
                str = jSONObject.getString("text");
            }
            if (jSONObject.has("url")) {
                str2 = jSONObject.getString("url");
            }
            if ((i3 != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && i3 == 2 && (webViewFragment = (WebViewFragment) this.mRuntime.f()) != null) {
                TextView textView = webViewFragment.getSwiftTitleUI().C;
                textView.setVisibility(0);
                textView.setText(R.string.cxr);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent(IndividuationPlugin.this.mActivity, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                        intent.putExtra("show_right_close_button", false);
                        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                        VasWebviewUtil.openQQBrowserWithoutAD(IndividuationPlugin.this.mActivity, IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.MY_FONT), 67108864L, intent, false, -1);
                        ReportController.o(null, "CliOper", "", "", "font_switch", "clk_swtich", 0, 0, "", "", "", "");
                    }
                });
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i3 = bundle.getInt("respkey", 0);
        String string = bundle.getString("cmd");
        String string2 = bundle.getString("callbackid");
        Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
        Bundle bundle3 = bundle.getBundle("response");
        if (bundle3 == null || i3 != this.mOnRemoteResp.key || string == null) {
            return;
        }
        if ("openProfileCard".equals(string)) {
            bundle3.getInt(QAdRewardDefine$VideoParams.ISCACHE, 1);
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", this.mRuntime.b().getAccount());
            intent.putExtra("isShowAd", false);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", IndividuationUrlHelper.getMarketUrl(this.mActivity, IndividuationUrlHelper.UrlId.CARD_HOME, "inside.myIndividuationWeb"));
            this.mActivity.startActivity(intent);
            return;
        }
        if ("openEmojiMall".equals(string)) {
            EmojiHomeUiPlugin.openEmojiHomePage2(this.mActivity, this.mBrowserApp.getCurrentAccountUin(), 3, bundle3.getString("curChatUin"), bundle3.getInt("curChatType", 0));
            return;
        }
        if ("openEmojiDetail".equals(string)) {
            String string3 = bundle3.getString("curChatUin");
            EmojiHomeUiPlugin.openEmojiDetailPage2(this.mActivity, this.mBrowserApp.getCurrentAccountUin(), 4, bundle2.getString("pkgId"), Boolean.valueOf(bundle2.getBoolean("isQFace")).booleanValue(), bundle3.getInt("curChatType", 0), string3);
            return;
        }
        if ("openFontSetting".equals(string)) {
            if (bundle3.getBoolean("feature")) {
                Intent intent2 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent2.putExtra("show_right_close_button", false);
                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                Activity activity = this.mActivity;
                VasWebviewUtil.openQQBrowserWithoutAD(activity, IndividuationUrlHelper.getMarketUrl(activity, "font", ""), 4096L, intent2, false, -1);
                return;
            }
            this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) ChatTextSizeSettingActivity.class));
            return;
        }
        if (Method_IsSupportFont.equals(string)) {
            boolean z16 = bundle3.getBoolean("feature");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z16 ? 1 : 0);
                super.callJs(string2, jSONObject.toString());
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        super.onResponse(bundle);
    }
}
