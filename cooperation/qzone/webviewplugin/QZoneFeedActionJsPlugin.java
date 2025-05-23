package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.reborn.comment.bean.GroupCommentParam;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.configx.g;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.manager.i;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneFeedActionJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String ACTION_BROADCAST_NOTIFY_INPUT_FONT_SELECT = "FeedActionPanelActivity.font_select";
    public static final String ACTION_BROADCAST_NOTIFY_INPUT_PANEL_CLOSED = "FeedActionPanelActivity.inputpanel_closed";
    public static final String ACTION_CONTENT = "FeedActionPanelActivity.content";
    public static final String ACTION_H5PAY_CALL_BACK = "action_h5pay_callback";
    public static final String ACTION_OPEN_VIP_INFO_SUCC = "openVipInfo";
    public static final String ACTION_PANEL_HEIGHT = "FeedActionPanelActivity.inputpanel_height";
    public static final String ACTION_SWITCH_WEISHI_MEDAL = "hasClickedWeiShiMedelSwitch";
    public static final String FEEDACTION_METHOD_NAMESPACE = "TopicComment";
    public static final String H5PAY_CALLBACK = "H5PayCallBack";
    public static final String H5PAY_CALL_BACK_JSON = "h5pay_callback_json";
    public static final String INPUT_PANEL_HEIGHT = "panel_height";
    public static final String TAG = "QZoneFeedActionJsPlugin";
    public static final String UNIQUE_KEY_FEEDACTION_ACTIVE = "FeedAction#isActiveNew";
    public static String name = "";
    public static boolean sAcceptEncoded = false;
    private boolean acceptEncoded = false;
    private String mSwitchFontCallback;

    private int getTokenThemeMode(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return 1000;
            }
            return 1002;
        }
        return 1001;
    }

    private void handleH5PayCallBackSucess(String str) {
        Activity a16;
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", QZoneJsConstants.METHOD_H5PAY_SUCESS);
        intent.putExtras(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleWriteBlog actionString: " + intent.getAction());
        }
        QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), intent);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("vipType", str);
                jSONObject.put("type", "YellowInfo");
                jSONObject.put("data", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put("*.qzone.qq.com");
                jSONObject3.put("echo", true);
                jSONObject3.put("broadcast", true);
                jSONObject3.put("domains", jSONArray);
                dispatchEvent("openVipInfo", jSONObject, jSONObject3);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest: ", e16);
                }
            }
        }
        if (("normalVip".equals(str) || "highVip".equals(str)) && (a16 = this.parentPlugin.mRuntime.a()) != null) {
            a16.finish();
        }
    }

    private void handleSwitchWeishiMedal(long j3, int i3) {
        RemoteHandleManager.getInstance().getSender().refreshWeishiMedalStatus(j3, i3);
    }

    private void notifyH5FontSelect(Intent intent) {
        if (!TextUtils.isEmpty(this.mSwitchFontCallback) && intent != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("font_id", intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1));
                jSONObject.put("font_type", intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, -1));
                jSONObject.put("font_url", intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL));
                String str = "window." + this.mSwitchFontCallback + "(" + jSONObject.toString() + ");";
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "invoke callback js:" + str);
                }
                this.parentPlugin.mRuntime.e().callJs(str);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        QLog.e(TAG, 1, "notifyH5FontSelect error callback = null");
    }

    private void notifyInputPanelClosed(Intent intent) {
        QLog.d(TAG, 2, "notifyInputPanelClosed");
        try {
            String str = "window." + name + "({event_type:\"PANEL_CLOSED\"});";
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "invoke callback js:" + str);
            }
            this.parentPlugin.mRuntime.e().callJs(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyInputPanelClosed: ", th5);
            }
        }
    }

    private void notifyPanelHeightChanged(Intent intent) {
        int intExtra = intent.getIntExtra("panel_height", -1);
        QLog.d(TAG, 2, "Input FeedActionPanel totalHeight : " + intExtra);
        if (intExtra == -1) {
            return;
        }
        try {
            String str = "window." + name + "(" + ("{event_type:\"HEIGHT_CHANGED\",height:\"" + intExtra + "\"}") + ");";
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "invoke callback js:" + str);
            }
            this.parentPlugin.mRuntime.e().callJs(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyPanelHeightChanged: ", th5);
            }
        }
    }

    private void notifyVipStatusChange(String str) {
        QLog.i("QzoneVip", 1, " notifyVipStatusChange result = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") && "success".equalsIgnoreCase(jSONObject.getString("status"))) {
                String optString = jSONObject.optString("vipType", "");
                if (!TextUtils.isEmpty(optString) && "NOBLE_VIP".equals(optString)) {
                    i.r().c0(2);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void sendH5PayCallBackBroadcast(String str) {
        Intent intent = new Intent("action_h5pay_callback");
        intent.putExtra("h5pay_callback_json", str);
        this.parentPlugin.mRuntime.a().sendBroadcast(intent);
    }

    private void writeContent2H5(Intent intent) {
        if (g.f53821a.b().w0()) {
            handCommentPanelResult(intent);
            return;
        }
        int i3 = 1;
        if (intent == null) {
            QLog.e(TAG, 1, "[writeContent2H5] intent is null");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, false);
        String stringExtra = intent.getStringExtra("contentIntentKey");
        try {
            String encode = this.acceptEncoded ? URLEncoder.encode(stringExtra, "utf-8") : stringExtra;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content", encode);
            if (!booleanExtra) {
                i3 = 0;
            }
            jSONObject.put("privateComment", i3);
            jSONObject.put("font_id", intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1));
            jSONObject.put("font_type", intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, -1));
            jSONObject.put("font_url", intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL));
            String str = "window." + name + "(" + jSONObject.toString() + ");";
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "invoke callback js:" + str);
            }
            this.parentPlugin.mRuntime.e().callJs(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "content:" + stringExtra, th5);
            }
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest \n url: " + str + "\n pkgName:" + str2 + "\n method:" + str3);
        }
        if ("TopicComment".equalsIgnoreCase(str3)) {
            handleFeedActionPanel(strArr);
            return true;
        }
        if (H5PAY_CALLBACK.equalsIgnoreCase(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                MonitorManager.f().j(1, 4, "js \u901a\u77e5native \u9ec4\u94bb\u652f\u4ed8\u7ed3\u679c", "" + strArr[0]);
                sendH5PayCallBackBroadcast(strArr[0]);
                notifyVipStatusChange(strArr[0]);
                if (jSONObject.has("status") && "success".equalsIgnoreCase(jSONObject.getString("status"))) {
                    handleH5PayCallBackSucess(jSONObject.optString("vipType", null));
                    return true;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest: ", e16);
                }
            }
        } else if (ACTION_SWITCH_WEISHI_MEDAL.equalsIgnoreCase(str3)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                if (jSONObject2.has("uin") && jSONObject2.has("ishide")) {
                    handleSwitchWeishiMedal(jSONObject2.getLong("uin"), jSONObject2.getInt("ishide"));
                    return true;
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest: ", e17);
                }
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void initRuntime(WebViewPlugin webViewPlugin) {
        super.initRuntime(webViewPlugin);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        LocalMultiProcConfig.putBool(UNIQUE_KEY_FEEDACTION_ACTIVE, false);
    }

    private void handCommentPanelResult(Intent intent) {
        String str;
        int i3 = 1;
        if (intent == null) {
            QLog.e(TAG, 1, "[handCommentPanelResult] intent is null");
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e(TAG, 1, "[writeContent2H5] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        String inputContent = qZoneCommentPanelResultBean.getInputContent();
        try {
            String encode = this.acceptEncoded ? URLEncoder.encode(inputContent, "utf-8") : inputContent;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content", encode);
            if (!qZoneCommentPanelResultBean.getIsCheckedForwardAndComment()) {
                i3 = 0;
            }
            jSONObject.put("privateComment", i3);
            jSONObject.put("font_id", qZoneCommentPanelResultBean.getFontInfo() != null ? qZoneCommentPanelResultBean.getFontInfo().getId().intValue() : -1);
            jSONObject.put("font_type", qZoneCommentPanelResultBean.getFontInfo() != null ? qZoneCommentPanelResultBean.getFontInfo().getFontFormatType().intValue() : -1);
            if (qZoneCommentPanelResultBean.getFontInfo() != null) {
                str = qZoneCommentPanelResultBean.getFontInfo().getFontUrl();
            } else {
                str = "";
            }
            jSONObject.put("font_url", str);
            String str2 = "window." + name + "(" + jSONObject.toString() + ");";
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "invoke callback js:" + str2);
            }
            this.parentPlugin.mRuntime.e().callJs(str2);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "content:" + inputContent, th5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0170  */
    /* JADX WARN: Type inference failed for: r25v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleFeedActionPanel(String... strArr) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        String str;
        String str2;
        String str3;
        boolean z19;
        String str4;
        int i29;
        String str5;
        String str6;
        String str7;
        String str8;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        boolean z26;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        int i68;
        int i69;
        String str9;
        String str10;
        boolean z37;
        JSONObject jSONObject;
        int i75;
        int i76;
        boolean w06 = g.f53821a.b().w0();
        int i77 = 0;
        if (LocalMultiProcConfig.getBool(UNIQUE_KEY_FEEDACTION_ACTIVE, false) && !w06) {
            QLog.e(TAG, 1, "handleFeedActionPanel feedAction is active");
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            z16 = false;
            z17 = false;
            z18 = false;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            i26 = 0;
            i27 = -1;
            i28 = 2;
            str = "";
            str2 = str;
            str3 = str2;
            z19 = false;
        } else {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str2 = jSONObject.optString("content");
                try {
                    str9 = jSONObject.optString("placeholder");
                    try {
                        i56 = jSONObject.optInt("needEmoticonBtn");
                    } catch (JSONException e16) {
                        e = e16;
                        i56 = 0;
                        i57 = 0;
                    }
                } catch (JSONException e17) {
                    e = e17;
                    i56 = 0;
                    i57 = 0;
                    i58 = 0;
                    i59 = 0;
                    i65 = 0;
                    i66 = 0;
                    i67 = 0;
                    z27 = 0;
                    z28 = false;
                    z29 = false;
                    z36 = false;
                    i68 = -1;
                    i69 = 2;
                    str9 = "";
                    str10 = str9;
                    z37 = z27;
                    if (QLog.isColorLevel()) {
                    }
                    str = str9;
                    i16 = i56;
                    i3 = i57;
                    i17 = i58;
                    i18 = i59;
                    i77 = i65;
                    str3 = str10;
                    i19 = i66;
                    i26 = i67;
                    z16 = z37;
                    z17 = z28;
                    z19 = z29;
                    z18 = z36;
                    i27 = i68;
                    i28 = i69;
                    if (QLog.isDevelopLevel()) {
                    }
                    WebViewPlugin webViewPlugin = this.parentPlugin;
                    int generateRequestCode = QZoneWebViewPlugin.generateRequestCode(webViewPlugin, webViewPlugin.mRuntime, 2);
                    if (!w06) {
                    }
                }
            } catch (JSONException e18) {
                e = e18;
                i56 = 0;
                i57 = 0;
                i58 = 0;
                i59 = 0;
                i65 = 0;
                i66 = 0;
                i67 = 0;
                z27 = 0;
                z28 = false;
                z29 = false;
                z36 = false;
                i68 = -1;
                i69 = 2;
                str2 = "";
                str9 = str2;
            }
            try {
                i57 = jSONObject.optInt("needAtBtn");
            } catch (JSONException e19) {
                e = e19;
                i57 = 0;
                i58 = i57;
                i59 = i58;
                i65 = i59;
                i66 = i65;
                i67 = i66;
                z27 = i67;
                z28 = z27 ? 1 : 0;
                z29 = z28;
                z36 = z29;
                i68 = -1;
                i69 = 2;
                str10 = "";
                z37 = z27;
                if (QLog.isColorLevel()) {
                }
                str = str9;
                i16 = i56;
                i3 = i57;
                i17 = i58;
                i18 = i59;
                i77 = i65;
                str3 = str10;
                i19 = i66;
                i26 = i67;
                z16 = z37;
                z17 = z28;
                z19 = z29;
                z18 = z36;
                i27 = i68;
                i28 = i69;
                if (QLog.isDevelopLevel()) {
                }
                WebViewPlugin webViewPlugin2 = this.parentPlugin;
                int generateRequestCode2 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin2, webViewPlugin2.mRuntime, 2);
                if (!w06) {
                }
            }
            try {
                i58 = jSONObject.optInt("needPrivateBtn");
            } catch (JSONException e26) {
                e = e26;
                i58 = 0;
                i59 = i58;
                i65 = i59;
                i66 = i65;
                i67 = i66;
                z27 = i67;
                z28 = z27 ? 1 : 0;
                z29 = z28;
                z36 = z29;
                i68 = -1;
                i69 = 2;
                str10 = "";
                z37 = z27;
                if (QLog.isColorLevel()) {
                }
                str = str9;
                i16 = i56;
                i3 = i57;
                i17 = i58;
                i18 = i59;
                i77 = i65;
                str3 = str10;
                i19 = i66;
                i26 = i67;
                z16 = z37;
                z17 = z28;
                z19 = z29;
                z18 = z36;
                i27 = i68;
                i28 = i69;
                if (QLog.isDevelopLevel()) {
                }
                WebViewPlugin webViewPlugin22 = this.parentPlugin;
                int generateRequestCode22 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin22, webViewPlugin22.mRuntime, 2);
                if (!w06) {
                }
            }
            try {
                i59 = jSONObject.optInt("isReply");
                try {
                    i65 = jSONObject.optInt("privateCommentStatus");
                } catch (JSONException e27) {
                    e = e27;
                    i65 = 0;
                    i66 = i65;
                    i67 = i66;
                    z27 = i67;
                    z28 = z27 ? 1 : 0;
                    z29 = z28;
                    z36 = z29;
                    i68 = -1;
                    i69 = 2;
                    str10 = "";
                    z37 = z27;
                    if (QLog.isColorLevel()) {
                    }
                    str = str9;
                    i16 = i56;
                    i3 = i57;
                    i17 = i58;
                    i18 = i59;
                    i77 = i65;
                    str3 = str10;
                    i19 = i66;
                    i26 = i67;
                    z16 = z37;
                    z17 = z28;
                    z19 = z29;
                    z18 = z36;
                    i27 = i68;
                    i28 = i69;
                    if (QLog.isDevelopLevel()) {
                    }
                    WebViewPlugin webViewPlugin222 = this.parentPlugin;
                    int generateRequestCode222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin222, webViewPlugin222.mRuntime, 2);
                    if (!w06) {
                    }
                }
                try {
                    name = jSONObject.optString("callback");
                    boolean optBoolean = jSONObject.optBoolean("acceptEncoded");
                    this.acceptEncoded = optBoolean;
                    sAcceptEncoded = optBoolean;
                    str10 = jSONObject.optString(TroopAvatarWallPreviewActivity.KEY_BTN_TEXT);
                    try {
                        i66 = jSONObject.optInt("maxTextLength");
                    } catch (JSONException e28) {
                        e = e28;
                        i66 = 0;
                        i67 = 0;
                    }
                } catch (JSONException e29) {
                    e = e29;
                    i66 = 0;
                    i67 = i66;
                    z27 = i67;
                    z28 = z27 ? 1 : 0;
                    z29 = z28;
                    z36 = z29;
                    i68 = -1;
                    i69 = 2;
                    str10 = "";
                    z37 = z27;
                    if (QLog.isColorLevel()) {
                    }
                    str = str9;
                    i16 = i56;
                    i3 = i57;
                    i17 = i58;
                    i18 = i59;
                    i77 = i65;
                    str3 = str10;
                    i19 = i66;
                    i26 = i67;
                    z16 = z37;
                    z17 = z28;
                    z19 = z29;
                    z18 = z36;
                    i27 = i68;
                    i28 = i69;
                    if (QLog.isDevelopLevel()) {
                    }
                    WebViewPlugin webViewPlugin2222 = this.parentPlugin;
                    int generateRequestCode2222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin2222, webViewPlugin2222.mRuntime, 2);
                    if (!w06) {
                    }
                }
                try {
                    i67 = jSONObject.optInt("groupdId");
                    try {
                        z27 = jSONObject.optBoolean("disableAutoClose");
                    } catch (JSONException e36) {
                        e = e36;
                        i75 = 0;
                        z28 = i75 == true ? 1 : 0;
                        i76 = i75;
                        z29 = z28;
                        z27 = i76;
                        z36 = z29;
                        i68 = -1;
                        i69 = 2;
                        z37 = z27;
                        if (QLog.isColorLevel()) {
                        }
                        str = str9;
                        i16 = i56;
                        i3 = i57;
                        i17 = i58;
                        i18 = i59;
                        i77 = i65;
                        str3 = str10;
                        i19 = i66;
                        i26 = i67;
                        z16 = z37;
                        z17 = z28;
                        z19 = z29;
                        z18 = z36;
                        i27 = i68;
                        i28 = i69;
                        if (QLog.isDevelopLevel()) {
                        }
                        WebViewPlugin webViewPlugin22222 = this.parentPlugin;
                        int generateRequestCode22222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin22222, webViewPlugin22222.mRuntime, 2);
                        if (!w06) {
                        }
                    }
                    try {
                        z28 = jSONObject.optBoolean("catchHeightChange");
                        try {
                            z29 = jSONObject.optBoolean("catchClosePanel");
                            try {
                                z36 = jSONObject.optInt("isFromDIY") == 1;
                            } catch (JSONException e37) {
                                e = e37;
                                z36 = false;
                            }
                        } catch (JSONException e38) {
                            e = e38;
                            z29 = false;
                            z27 = z27;
                            z36 = z29;
                            i68 = -1;
                            i69 = 2;
                            z37 = z27;
                            if (QLog.isColorLevel()) {
                            }
                            str = str9;
                            i16 = i56;
                            i3 = i57;
                            i17 = i58;
                            i18 = i59;
                            i77 = i65;
                            str3 = str10;
                            i19 = i66;
                            i26 = i67;
                            z16 = z37;
                            z17 = z28;
                            z19 = z29;
                            z18 = z36;
                            i27 = i68;
                            i28 = i69;
                            if (QLog.isDevelopLevel()) {
                            }
                            WebViewPlugin webViewPlugin222222 = this.parentPlugin;
                            int generateRequestCode222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin222222, webViewPlugin222222.mRuntime, 2);
                            if (!w06) {
                            }
                        }
                        try {
                            i68 = jSONObject.optInt("curDIYSelectId", -1);
                            try {
                                i69 = jSONObject.optInt("themeMode", 2);
                            } catch (JSONException e39) {
                                e = e39;
                                i69 = 2;
                                z37 = z27;
                                if (QLog.isColorLevel()) {
                                }
                                str = str9;
                                i16 = i56;
                                i3 = i57;
                                i17 = i58;
                                i18 = i59;
                                i77 = i65;
                                str3 = str10;
                                i19 = i66;
                                i26 = i67;
                                z16 = z37;
                                z17 = z28;
                                z19 = z29;
                                z18 = z36;
                                i27 = i68;
                                i28 = i69;
                                if (QLog.isDevelopLevel()) {
                                }
                                WebViewPlugin webViewPlugin2222222 = this.parentPlugin;
                                int generateRequestCode2222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin2222222, webViewPlugin2222222.mRuntime, 2);
                                if (!w06) {
                                }
                            }
                            try {
                                this.mSwitchFontCallback = jSONObject.optString("switchFontCallback");
                                z37 = z27;
                            } catch (JSONException e46) {
                                e = e46;
                                z37 = z27;
                                if (QLog.isColorLevel()) {
                                }
                                str = str9;
                                i16 = i56;
                                i3 = i57;
                                i17 = i58;
                                i18 = i59;
                                i77 = i65;
                                str3 = str10;
                                i19 = i66;
                                i26 = i67;
                                z16 = z37;
                                z17 = z28;
                                z19 = z29;
                                z18 = z36;
                                i27 = i68;
                                i28 = i69;
                                if (QLog.isDevelopLevel()) {
                                }
                                WebViewPlugin webViewPlugin22222222 = this.parentPlugin;
                                int generateRequestCode22222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin22222222, webViewPlugin22222222.mRuntime, 2);
                                if (!w06) {
                                }
                            }
                        } catch (JSONException e47) {
                            e = e47;
                            i68 = -1;
                            i69 = 2;
                            z37 = z27;
                            if (QLog.isColorLevel()) {
                            }
                            str = str9;
                            i16 = i56;
                            i3 = i57;
                            i17 = i58;
                            i18 = i59;
                            i77 = i65;
                            str3 = str10;
                            i19 = i66;
                            i26 = i67;
                            z16 = z37;
                            z17 = z28;
                            z19 = z29;
                            z18 = z36;
                            i27 = i68;
                            i28 = i69;
                            if (QLog.isDevelopLevel()) {
                            }
                            WebViewPlugin webViewPlugin222222222 = this.parentPlugin;
                            int generateRequestCode222222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin222222222, webViewPlugin222222222.mRuntime, 2);
                            if (!w06) {
                            }
                        }
                    } catch (JSONException e48) {
                        e = e48;
                        z28 = false;
                        i76 = z27;
                        z29 = z28;
                        z27 = i76;
                        z36 = z29;
                        i68 = -1;
                        i69 = 2;
                        z37 = z27;
                        if (QLog.isColorLevel()) {
                        }
                        str = str9;
                        i16 = i56;
                        i3 = i57;
                        i17 = i58;
                        i18 = i59;
                        i77 = i65;
                        str3 = str10;
                        i19 = i66;
                        i26 = i67;
                        z16 = z37;
                        z17 = z28;
                        z19 = z29;
                        z18 = z36;
                        i27 = i68;
                        i28 = i69;
                        if (QLog.isDevelopLevel()) {
                        }
                        WebViewPlugin webViewPlugin2222222222 = this.parentPlugin;
                        int generateRequestCode2222222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin2222222222, webViewPlugin2222222222.mRuntime, 2);
                        if (!w06) {
                        }
                    }
                } catch (JSONException e49) {
                    e = e49;
                    i67 = 0;
                    i75 = i67;
                    z28 = i75 == true ? 1 : 0;
                    i76 = i75;
                    z29 = z28;
                    z27 = i76;
                    z36 = z29;
                    i68 = -1;
                    i69 = 2;
                    z37 = z27;
                    if (QLog.isColorLevel()) {
                    }
                    str = str9;
                    i16 = i56;
                    i3 = i57;
                    i17 = i58;
                    i18 = i59;
                    i77 = i65;
                    str3 = str10;
                    i19 = i66;
                    i26 = i67;
                    z16 = z37;
                    z17 = z28;
                    z19 = z29;
                    z18 = z36;
                    i27 = i68;
                    i28 = i69;
                    if (QLog.isDevelopLevel()) {
                    }
                    WebViewPlugin webViewPlugin22222222222 = this.parentPlugin;
                    int generateRequestCode22222222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin22222222222, webViewPlugin22222222222.mRuntime, 2);
                    if (!w06) {
                    }
                }
            } catch (JSONException e56) {
                e = e56;
                i59 = 0;
                i65 = i59;
                i66 = i65;
                i67 = i66;
                z27 = i67;
                z28 = z27 ? 1 : 0;
                z29 = z28;
                z36 = z29;
                i68 = -1;
                i69 = 2;
                str10 = "";
                z37 = z27;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleFeedActionPanel: ", e);
                    z37 = z27;
                }
                str = str9;
                i16 = i56;
                i3 = i57;
                i17 = i58;
                i18 = i59;
                i77 = i65;
                str3 = str10;
                i19 = i66;
                i26 = i67;
                z16 = z37;
                z17 = z28;
                z19 = z29;
                z18 = z36;
                i27 = i68;
                i28 = i69;
                if (QLog.isDevelopLevel()) {
                }
                WebViewPlugin webViewPlugin222222222222 = this.parentPlugin;
                int generateRequestCode222222222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin222222222222, webViewPlugin222222222222.mRuntime, 2);
                if (!w06) {
                }
            }
            str = str9;
            i16 = i56;
            i3 = i57;
            i17 = i58;
            i18 = i59;
            i77 = i65;
            str3 = str10;
            i19 = i66;
            i26 = i67;
            z16 = z37;
            z17 = z28;
            z19 = z29;
            z18 = z36;
            i27 = i68;
            i28 = i69;
        }
        if (QLog.isDevelopLevel()) {
            str4 = UNIQUE_KEY_FEEDACTION_ACTIVE;
            i29 = i77;
            str5 = "isFromDIY";
            str6 = "catchClosePanel";
            str7 = "catchHeightChange";
            str8 = "disableAutoClose";
            i36 = i3;
            i37 = i16;
            i38 = i17;
            i39 = i18;
            i46 = i19;
            i47 = i26;
            z26 = false;
        } else {
            str5 = "isFromDIY";
            StringBuilder sb5 = new StringBuilder();
            str6 = "catchClosePanel";
            sb5.append("handleFeedActionPanel hint is: ");
            sb5.append(str);
            sb5.append("\t autofill:");
            sb5.append(str2);
            sb5.append(",needEmoticonBtn: ");
            i37 = i16;
            sb5.append(i37);
            str7 = "catchHeightChange";
            sb5.append(",needAtBtn: ");
            i36 = i3;
            sb5.append(i36);
            str8 = "disableAutoClose";
            sb5.append(",needPrivateBtn: ");
            i38 = i17;
            sb5.append(i38);
            str4 = UNIQUE_KEY_FEEDACTION_ACTIVE;
            sb5.append(",isReply: ");
            int i78 = i18;
            sb5.append(i78);
            i39 = i78;
            sb5.append(",privateCommentStatus: ");
            sb5.append(i77);
            sb5.append(",maxLen: ");
            int i79 = i19;
            sb5.append(i79);
            i29 = i77;
            sb5.append(",troopid: ");
            i47 = i26;
            sb5.append(i47);
            z26 = false;
            StringBuilder sb6 = new StringBuilder();
            i46 = i79;
            sb6.append(" acceptEncoded:");
            sb6.append(this.acceptEncoded);
            sb6.append(" disableAutoClose:");
            sb6.append(z16);
            sb6.append(" cachePanelHeight:");
            sb6.append(z17);
            sb6.append(" cahcePanelClose:");
            sb6.append(z19);
            QLog.d(TAG, 4, sb5.toString(), sb6.toString());
        }
        WebViewPlugin webViewPlugin2222222222222 = this.parentPlugin;
        int generateRequestCode2222222222222 = QZoneWebViewPlugin.generateRequestCode(webViewPlugin2222222222222, webViewPlugin2222222222222.mRuntime, 2);
        if (!w06) {
            if (i38 == 0) {
                i49 = 1;
                i48 = -1;
            } else {
                i48 = i29;
                i49 = 1;
            }
            QZoneCommentPanelParams params = new QZoneCommentPanelParams.a().d(str2).q(str).k(i37 == i49 ? i49 : z26).i(i36 == i49 ? true : z26).A((i38 == i49 && i48 == i49) ? i49 : i48).s(z18).z(i27).y(generateRequestCode2222222222222).w(getTokenThemeMode(i28)).getParams();
            if (i47 > 0) {
                params.setGroupCommentParam(new GroupCommentParam(i47 + "", ""));
            }
            if (i46 > 0) {
                params.setMaxInputLength(i46);
            }
            ho.i.c().t(params, this.parentPlugin.mRuntime.a());
            return;
        }
        LocalMultiProcConfig.putBool(str4, true);
        Bundle bundle = new Bundle();
        bundle.putBoolean(str8, z16);
        bundle.putBoolean(str7, z17);
        bundle.putBoolean(str6, z19);
        bundle.putBoolean(str5, z18);
        bundle.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i27);
        QZoneHelper.forwardToFeedActionPanel(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), generateRequestCode2222222222222, str, str2, "", "", i29, false, i36, i37, 0, i38, i39, str3, i46, i47, false, "", false, bundle);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (b16 == 2 && i3 == -1) {
            writeContent2H5(intent);
        }
    }
}
