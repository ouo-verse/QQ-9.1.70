package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.giftdisplay.IVasGiftKuiklyManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.font.FontManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.personalize.QZoneFacadeJsHandleLogic;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizeH5Service;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizeJsHandleLogic;
import cooperation.qzone.webviewplugin.personalize.QZoneZebraAlbumJsHandleLogic;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s4.c;

/* loaded from: classes38.dex */
public class QzonePersonalizeJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private static final String TAG = "QzonePersonalizeJsPlugin";
    private FontInterface.TrueTypeResult mFontResult = new FontInterface.TrueTypeResult() { // from class: cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin.1
        @Override // cooperation.qzone.font.FontInterface.TrueTypeResult, cooperation.qzone.font.FontInterface.FontResult
        public void result(int i3, String str, String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.d(QzonePersonalizeJsPlugin.TAG, 4, "FontInterface.TrueTypeResult font:" + i3 + ", fontPath:" + str);
            }
            if (TextUtils.isEmpty(str)) {
                QzonePersonalizeJsPlugin.this.callJS(str2, -2, "font download failed.");
            } else {
                QzonePersonalizeJsPlugin.this.callJS(str2, 0, "success");
            }
        }
    };
    private IVasGiftKuiklyManager mGiftKuiklyManager;
    private com.tencent.mobileqq.qzonevip.gift.a mGiftManager;

    /* JADX INFO: Access modifiers changed from: private */
    public void callJS(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i3);
            jSONObject.put("msg", str2);
            jSONObject.put("noZip", 0);
            jSONObject.put("noCrossDomain", 1);
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    private void handleCustomTrack(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Bundle bundle = new Bundle();
            bundle.putInt("itemId", jSONObject.getInt("itemid"));
            QLog.i(TAG, 1, "handleCustomTrack  h5set ");
            RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_SET_CUSTOM_TRACK, bundle, false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleCustomTrack  ", e16);
        }
    }

    private static void handleCustomVipSetting(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i3 = jSONObject.getInt("CustomVipId");
            String string = jSONObject.getString("zipUrl");
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.CUSTOM_VIP_SETTING);
            bundle.putInt("CustomVipId", i3);
            bundle.putString("zipUrl", string);
            intent.putExtras(bundle);
            QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleFriendNaviDeco(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.METHOD_SETFRIENDNAVIDECO);
            bundle.putInt("itemId", jSONObject.getInt("itemid"));
            bundle.putString("friendNaviDecoUrl", jSONObject.optString("friendnavidecoresurl", ""));
            bundle.putString("textColor", jSONObject.optString("fontcolor", ""));
            intent.putExtras(bundle);
            QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), intent);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "handleFriendNaviDeco  ", e16);
        }
    }

    private void handleGetDefaultFont(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long optLong = jSONObject.optLong("uin");
            String optString = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "callback is empty.");
                return;
            }
            DefaultFontInfo defaultFont = FontManager.getInstance().getDefaultFont(optLong);
            DefaultSuperFontInfo defaultSuperFont = FontManager.getInstance().getDefaultSuperFont(optLong);
            DefaultBarrageEffectInfo defaultBarrageEffectInfo = FontManager.getInstance().getDefaultBarrageEffectInfo(optLong);
            try {
                JSONObject jSONObject2 = new JSONObject();
                int i3 = -1;
                jSONObject2.put("id", defaultFont == null ? -1 : defaultFont.fontId);
                jSONObject2.put("sparkle_id", defaultSuperFont == null ? -1 : defaultSuperFont.fontId);
                if (defaultBarrageEffectInfo != null) {
                    i3 = defaultBarrageEffectInfo.itemId;
                }
                jSONObject2.put("bubble_iItemId", i3);
                this.parentPlugin.mRuntime.e().callJs(optString, jSONObject2.toString());
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16.getMessage());
            }
        } catch (Exception e17) {
            QLog.e(TAG, 1, e17.getMessage());
        }
    }

    private void handleHighFive(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i3 = jSONObject.getInt("itemId");
            String string = jSONObject.getString(QZoneJsConstants.KEY_HIGH_FIVE_URL);
            String string2 = jSONObject.getString(QZoneJsConstants.KEY_HIGH_FIVE_TEXT);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.METHOD_HIGH_FIVE);
            bundle.putInt("itemId", i3);
            bundle.putString(QZoneJsConstants.KEY_HIGH_FIVE_URL, string);
            bundle.putString(QZoneJsConstants.KEY_HIGH_FIVE_TEXT, string2);
            RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_SET_RESPONSIVE_LIKE, bundle, false);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "handleHighFive  ", e16);
        }
    }

    private void handleNotifyWebviewJsReady() {
        WebViewPlugin.b bVar;
        QLog.i(TAG, 1, "tiantai handleNotifyWebviewJsReady");
        try {
            WebViewPlugin webViewPlugin = this.parentPlugin;
            CustomWebView e16 = (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null) ? null : bVar.e();
            if (e16 == null) {
                QZLog.w(TAG, "tiantai webView == null");
                return;
            }
            e16.setTag(R.id.hsk, Boolean.TRUE);
            QLog.i(TAG, 1, "tiantai webview activity name: " + this.parentPlugin.mRuntime.a().getClass().getSimpleName());
            QZLog.i(TAG, "tiantai \u975e\u5b9a\u5236webview\u76f4\u63a5\u8fd4\u56de");
            notifyWebviewStartAnimation(e16);
        } catch (Exception e17) {
            QLog.w(TAG, 1, "tiantai handleNotifyWebviewJsReady: ", e17);
        }
    }

    private void handlePersonalizeFont(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("id", -1);
            int optInt2 = jSONObject.optInt("download");
            String optString2 = jSONObject.optString("callback");
            if (optInt2 != 0 && TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "url is empty.");
                return;
            }
            if (TextUtils.isEmpty(optString2)) {
                QLog.e(TAG, 1, "callback is empty.");
                return;
            }
            FontInterface.TrueTypeResult trueTypeResult = optInt2 == 0 ? null : this.mFontResult;
            if (!TextUtils.isEmpty(FontManager.getInstance().getTrueTypeFont(optInt, optString, optString2, true, trueTypeResult))) {
                callJS(optString2, 0, "success");
            } else if (trueTypeResult == null) {
                callJS(optString2, -1, "font has not been cached.");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    private static void handlePersonalizeSetting(WebViewPlugin.b bVar, String... strArr) {
        JSONArray jSONArray;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (jSONObject.getInt("success") != 1 || (jSONArray = jSONObject.getJSONArray("uins")) == null || jSONArray.length() <= 0) {
                return;
            }
            if (jSONObject.has("toast") && jSONObject.getBoolean("toast")) {
                QQToast.makeText(bVar.a(), 2, R.string.f170004cn, 0).show();
            }
            long[] jArr = new long[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                jArr[i3] = jSONArray.getLong(i3);
            }
            Intent intent = new Intent();
            intent.putExtra("key_msg_type", 2);
            intent.putExtra("key_friend_list", jArr);
            bVar.a().setResult(-1, intent);
            bVar.a().finish();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handlePreloadFacade(WebViewPlugin.b bVar, String... strArr) {
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", "SetFacade");
        if (strArr != null && strArr.length > 0) {
            try {
                bundle.putInt("showonfridyn", new JSONObject(strArr[0]).getInt("showonfridyn"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        intent.putExtras(bundle);
        QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
    }

    private void handleReserveAdvertise(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Bundle bundle = new Bundle();
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2 != null) {
                String string = jSONObject2.getString("orderid");
                if (!TextUtils.isEmpty(string)) {
                    bundle.putString("orderid", string);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "handleReserveAdvertise  h5set +" + string);
                    }
                    RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_RESERVE_ADVERTISE, bundle, false);
                    return;
                }
                QLog.e(TAG, 1, "@orderAdv orderid  is null  ");
                return;
            }
            QLog.e(TAG, 1, "@orderAdv orderid  is null  ");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "@orderAdv handleReserveAdvertise  ", e16.toString());
        }
    }

    private void handleSetDefaultFont(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long optLong = jSONObject.optLong("uin");
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("id", -1);
            int optInt2 = jSONObject.optInt("formatType");
            if (jSONObject.optInt("sparkle_id", -1) != -1) {
                handleSetDefaultSuperFont(strArr);
            }
            if (jSONObject.optInt("bubble_iItemId", Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                handleSetDefaultCommentBubble(strArr);
            }
            if (optInt < 0) {
                QLog.e(TAG, 1, "font id error , id = " + optInt);
                return;
            }
            if (optInt > 0 && TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "url is empty.");
                return;
            }
            DefaultFontInfo defaultFontInfo = new DefaultFontInfo();
            defaultFontInfo.fontId = optInt;
            defaultFontInfo.formatType = optInt2;
            defaultFontInfo.fontUrl = optString;
            FontManager.getInstance().setDefaultFont(optLong, defaultFontInfo);
            if (optInt > 0) {
                FontManager.getInstance().setDefaultBarrageEffect(optLong, null);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    private void handleSetPlayerDeco(String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.CUSTOM_PLAYER_SETTING);
            bundle.putInt("itemId", jSONObject.getInt("itemId"));
            bundle.putString("playerDecoUrl", jSONObject.optString("playerDecoUrl"));
            bundle.putLong("textColor", jSONObject.optLong("textColor"));
            intent.putExtras(bundle);
            QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), intent);
        } catch (Exception unused) {
            QLog.e(TAG, 1, "parse json error " + strArr[0]);
        }
    }

    private void handleYellowDiamondRedpocket(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            boolean z16 = jSONObject.getBoolean("isGet");
            String string = jSONObject.getString(c.UGCKEY);
            if (z16) {
                Bundle bundle = new Bundle();
                bundle.putString(RemoteHandleConst.PARAM_YELLOWDIAMOND_REDPOCKET_UGCKEY, string);
                RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_GET_YELOOWDIAMOND_REDPOCKET, bundle, false);
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "handleYellowDiamondRedpocket  ", e16);
        }
    }

    public static void notifyWebviewStartAnimation(CustomWebView customWebView) {
        try {
            QZLog.i(TAG, "tiantai notifyWebviewStartAnimation");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", QZoneJsConstants.ACTION_START_ANIMATION);
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put("*.qzone.qq.com");
            jSONObject2.put("echo", true);
            jSONObject2.put("broadcast", true);
            jSONObject2.put("domains", jSONArray);
            QzoneInternalWebViewPlugin.dispatchEventImpl(customWebView, QZoneJsConstants.EVENT_QZ_ROOFTOP, jSONObject, jSONObject2);
            Boolean bool = Boolean.FALSE;
            customWebView.setTag(R.id.hsh, bool);
            customWebView.setTag(R.id.hsk, bool);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "tiantai notifyWebviewStartAnimation: ", e16);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (QZoneJsConstants.isForce(str3)) {
                LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FORCE_REFREASH, true);
                LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FORCE_REFREASH_PASSIVE, true);
            }
            if (QZoneJsConstants.METHOD_UPDATEMALLTIMESTAMP.equalsIgnoreCase(str3)) {
                handleUpdateMallClicktime(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_UPDATEMALLID.equalsIgnoreCase(str3)) {
                onHandleUpdateMallID(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if ("Personalize".equalsIgnoreCase(str3)) {
                handlePersonalizeSetting(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if ("SetFacade".equalsIgnoreCase(str3)) {
                handlePreloadFacade(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.ZEBARALBUM_METHOD_CLEANZEBRANUM)) {
                QZoneZebraAlbumJsHandleLogic.handleCleanZebraNum(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.PERSONALIZE_SWITCH_FINISHED)) {
                QZonePersonalizeJsHandleLogic.handleSwitchFinished(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (str3.equals("openNameplateSucc")) {
                QZoneFacadeJsHandleLogic.handleSetFacadeFinish(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_DOWNLOAD_FONT.equalsIgnoreCase(str3)) {
                handlePersonalizeFont(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_OPEN_CUSTOM_VIP_SUCC.equals(str3)) {
                handleCustomVipSetting(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_SET_DEFAULT_FONT.equals(str3)) {
                handleSetDefaultFont(strArr);
                return true;
            }
            if ("getDefaultFont".equals(str3)) {
                handleGetDefaultFont(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_NAME_SET_PLAYER_DECO.equals(str3)) {
                handleSetPlayerDeco(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_NAME_NOTIFY_WEBVIEW_JS_READY.equals(str3)) {
                handleNotifyWebviewJsReady();
                return true;
            }
            if (QZoneJsConstants.METHOD_OPEN_URL.equals(str3)) {
                hanleOpenWebview(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_REFRESHDECO.equals(str3)) {
                RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_REFRESH_DECO_CUSTOM, null, false);
                return true;
            }
            if (QZoneJsConstants.METHOD_PLAY_GIFT_ANIM.equals(str3)) {
                if (strArr != null && strArr.length == 1 && !TextUtils.isEmpty(strArr[0])) {
                    if (this.mGiftKuiklyManager == null) {
                        this.mGiftKuiklyManager = (IVasGiftKuiklyManager) QRoute.api(IVasGiftKuiklyManager.class);
                    }
                    if (this.mGiftKuiklyManager.ifUseKuikly()) {
                        this.mGiftKuiklyManager.startPlay(strArr[0]);
                    } else {
                        com.tencent.mobileqq.qzonevip.gift.a r16 = com.tencent.mobileqq.qzonevip.gift.a.r();
                        this.mGiftManager = r16;
                        r16.L(strArr[0]);
                    }
                }
                return true;
            }
            if (QZoneJsConstants.METHOD_GETYELLOWDIAMOND_REDPOCKET.equals(str3)) {
                handleYellowDiamondRedpocket(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_SETFRIENDNAVIDECO.equals(str3)) {
                handleFriendNaviDeco(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_HIGH_FIVE.equals(str3)) {
                handleHighFive(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_SET_DIY_DATA.equals(str3)) {
                handleDIYData(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_SET_CUSTOM_TRACK.equals(str3)) {
                handleCustomTrack(strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_RESERVE_ADVERTISE.equals(str3)) {
                handleReserveAdvertise(strArr);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.qzonevip.gift.a aVar = this.mGiftManager;
        if (aVar != null) {
            aVar.onDestroy();
        }
        IVasGiftKuiklyManager iVasGiftKuiklyManager = this.mGiftKuiklyManager;
        if (iVasGiftKuiklyManager != null) {
            iVasGiftKuiklyManager.onDestroy();
        }
    }

    private void handleDIYData(String[] strArr) {
        if (strArr == null || strArr.length != 1) {
            return;
        }
        try {
            String optString = new JSONObject(strArr[0]).optString("data");
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.METHOD_SET_DIY_DATA);
            bundle.putString(QZoneJsConstants.KEY_DIY_LAYOUT_JSON, optString);
            RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_SET_QZONE_DIY_DATA, bundle, false);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "handleDIYData  ", e16);
        }
    }

    private void handleSetDefaultCommentBubble(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long optLong = jSONObject.optLong("uin");
            int optInt = jSONObject.optInt("bubble_iItemId", Integer.MIN_VALUE);
            String optString = jSONObject.optString("bubble_strTextColor");
            String optString2 = jSONObject.optString("bubble_strAndBgUrl");
            String optString3 = jSONObject.optString("bubble_strIosBgUrl");
            String optString4 = jSONObject.optString("bubble_strFrameZip");
            int optInt2 = jSONObject.optInt("bubble_iFrameRate");
            if (optInt == Integer.MIN_VALUE) {
                QLog.e(TAG, 1, "CommentBubble id error , id = " + optInt);
                return;
            }
            DefaultBarrageEffectInfo defaultBarrageEffectInfo = new DefaultBarrageEffectInfo();
            defaultBarrageEffectInfo.itemId = optInt;
            defaultBarrageEffectInfo.jsonStr = DefaultBarrageEffectInfo.toJson(optInt, optString, optString2, optString3, optString4, optInt2);
            FontManager.getInstance().setDefaultBarrageEffect(optLong, defaultBarrageEffectInfo);
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.REFRESH_COMMOM_LIST);
            intent.putExtras(bundle);
            QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), intent);
            if (optInt > 0) {
                FontManager.getInstance().setDefaultFont(optLong, null);
                FontManager.getInstance().setDefaultSuperFont(optLong, null);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void handleSetDefaultSuperFont(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long optLong = jSONObject.optLong("uin");
            int optInt = jSONObject.optInt("sparkle_id");
            String optString = jSONObject.optString("sparkle_json");
            if (optInt < 0) {
                QLog.e(TAG, 1, "font id error , id = " + optInt);
                return;
            }
            DefaultSuperFontInfo defaultSuperFontInfo = new DefaultSuperFontInfo();
            defaultSuperFontInfo.fontId = optInt;
            defaultSuperFontInfo.jsonStr = optString;
            FontManager.getInstance().setDefaultSuperFont(optLong, defaultSuperFontInfo);
            if (optInt > 0) {
                FontManager.getInstance().setDefaultBarrageEffect(optLong, null);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void handleUpdateMallClicktime(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            int i3 = new JSONObject(strArr[0]).getInt("timestamp");
            if (QLog.isColorLevel()) {
                QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallClicktime: " + i3);
            }
            QZonePersonalizeH5Service.updateCTime(Integer.valueOf(i3), Long.valueOf(bVar.b().getLongAccountUin()));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void hanleOpenWebview(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            boolean z16 = jSONObject.optInt("transparent") == 1;
            String optString = jSONObject.optString("url");
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (z16) {
                if (a16 instanceof BasePluginActivity) {
                    QZoneHelper.startTranslucentBrowserActivityForResult(((BasePluginActivity) a16).getOutActivity(), optString, -1, null, null);
                } else {
                    QZoneHelper.startTranslucentBrowserActivityForResult(a16, optString, -1, null, null);
                }
            } else if (a16 instanceof BasePluginActivity) {
                QZoneHelper.forwardToBrowser(((BasePluginActivity) a16).getOutActivity(), optString, -1, null, null);
            } else {
                QZoneHelper.forwardToBrowser(a16, optString, -1, null, null);
            }
        } catch (Exception unused) {
        }
    }

    private static void onHandleUpdateMallID(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallID");
            }
            JSONArray jSONArray = new JSONObject(strArr[0]).getJSONArray("id");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                iArr[i3] = jSONArray.getInt(i3);
            }
            if (length <= 0) {
                return;
            }
            new HashMap();
            Map<Integer, Long> cTime = QZonePersonalizeH5Service.getCTime(Long.valueOf(bVar.b().getLongAccountUin()));
            for (int i16 = 0; i16 < length; i16++) {
                if (!cTime.containsKey(Integer.valueOf(iArr[i16]))) {
                    cTime.put(Integer.valueOf(iArr[i16]), 0L);
                }
            }
            QZonePersonalizeH5Service.setCTime(cTime, Long.valueOf(bVar.b().getLongAccountUin()));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
