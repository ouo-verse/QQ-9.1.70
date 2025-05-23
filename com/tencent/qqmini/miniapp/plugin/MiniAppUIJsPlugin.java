package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class MiniAppUIJsPlugin extends BaseJsPlugin {
    private static final String CONFIG_SPLIT = ",";
    private static final String EVENT_GET_REGION_DATA = "getRegionData";
    public static final String EVENT_PAGE_SCROLL_TO = "scrollWebviewTo";
    public static final String EVENT_SET_BACKGROUND_COLOR = "setBackgroundColor";
    public static final String EVENT_SET_BACKGROUND_TEXT_STYLE = "setBackgroundTextStyle";
    public static final String EVENT_WEBVIEW_INVOKE_APPSERVICE = "onWebInvokeAppService";
    private static final String TAG = "MiniAppUIJsPlugin";
    private static String mCurWhiteListConfig;
    private static String mWhiteHostConfig;
    private static ArrayList<String> needCookieAppIdList;
    private static ArrayList<String> needCookieHostList;
    private InnerWebView innerWebView;

    @JsEvent({EVENT_GET_REGION_DATA})
    public void getRegionData(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", FileUtils.readFileFromAssets(this.mContext, "mini/region"));
            requestEvent.ok(jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "getRegionData exception: ", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"setBackgroundTextStyle", "setBackgroundColor"})
    public void setBackgroundTextStyle(RequestEvent requestEvent) {
        sendNativeViewEvent(requestEvent, 3);
    }
}
