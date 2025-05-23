package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.qzone.reborn.intimate.bean.init.QZIntimateHistoryCalendarCardInitBean;
import com.qzone.reborn.intimate.event.QZIntimateShowSettingDialogEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateRefreshHeaderEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateSpaceDisplayRightEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import im.c;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import yo.d;

/* loaded from: classes38.dex */
public class QZoneIntimateSpaceJsPlugin extends QzoneInternalWebViewPlugin {
    private static final String EVENT_NAME_UPDATE_PRIVACY_STATUS = "QZIntimateSpaceUpdatePrivacyStatus";
    private static final String JSON_ARGS_NAME_CHECK_DATE = "checkDate";
    private static final String JSON_ARGS_NAME_EVENT_NAME = "eventName";
    private static final String JSON_ARGS_NAME_PRODUCT_ID = "product_id";
    private static final String JSON_ARGS_NAME_PRODUCT_NUM = "pay_item";
    private static final String JSON_ARGS_NAME_PRODUCT_TYPE = "product_type";
    private static final String JSON_ARGS_NAME_SERVICE_CODE = "serviceCode";
    private static final String JSON_ARGS_NAME_SERVICE_CODE_DEFAULT = "QMKJXZ";
    private static final String JSON_ARGS_NAME_SERVICE_NAME = "serviceName";
    private static final String JSON_ARGS_NAME_SERVICE_NAME_DEFAULT = "\u661f\u94bb";
    private static final String JSON_ARGS_NAME_SPACE_DISPLAY_RIGHT = "spaceDisplayRight";
    private static final String JSON_ARGS_NAME_SPACE_ID = "spaceId";
    private static final String JSON_ARGS_NAME_URL = "url";
    private static final String JSON_ARGS_NAME_USER_ID = "userId";
    private static final String METHOD_NAME_PAY_FOR_MONTHLY_VIP = "payVipMonthly";
    private static final String METHOD_NAME_POST_EVENT = "postEvent";
    private static final String METHOD_NAME_REFRESH_HOME_HEADER = "refreshHomeHeader";
    private static final String METHOD_NAME_SETTING_PAGE = "showSettingPage";
    private static final String METHOD_NAME_SHOW_CALENDAR_CARD = "showCalendarCard";
    private static final String METHOD_NAME_SHOW_TRANS_WEB_VIEW = "showTransWebView";
    private static final String METHOD_NAME_UPDATE_SPACE_STATUS = "updateSpaceStatus";
    private static final String NAMESPACE = "QZIntimateSpace";
    private static final String TAG = "QZoneIntimateSpaceJsPlugin";

    private Activity getHostActivity() {
        WebViewPlugin.b bVar;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null && (bVar = webViewPlugin.mRuntime) != null && bVar.a() != null) {
            return this.parentPlugin.mRuntime.a();
        }
        return MobileQQ.sMobileQQ.getResumeActivity();
    }

    private void handlePostEvent(WebViewPlugin webViewPlugin, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("eventName");
                String optString2 = jSONObject.optString(JSON_ARGS_NAME_SPACE_ID);
                int optInt = jSONObject.optInt(JSON_ARGS_NAME_SPACE_DISPLAY_RIGHT);
                if (TextUtils.isEmpty(optString)) {
                    QLog.e(TAG, 1, "[handlePostEvent] eventName is empty");
                    return;
                }
                QLog.d(TAG, 1, "[handlePostEvent] eventName = " + optString + ", spaceId = " + optString2 + ", displayRight = " + optInt);
                if (EVENT_NAME_UPDATE_PRIVACY_STATUS.equalsIgnoreCase(optString)) {
                    SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateSpaceDisplayRightEvent(optString2, optInt), true);
                    return;
                }
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "[handlePostEvent] error:", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "[handlePostEvent] args is null or empty");
    }

    private void handleRefreshHomeHeaderEvent(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateRefreshHeaderEvent(new JSONObject(strArr[0]).optString(JSON_ARGS_NAME_SPACE_ID)), true);
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "[handleRefreshHomeHeaderEvent] error:", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "[handleRefreshHomeHeaderEvent] args is null or empty");
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (str2.equals("QZIntimateSpace") && this.parentPlugin != null) {
            if (METHOD_NAME_POST_EVENT.equalsIgnoreCase(str3)) {
                handlePostEvent(this.parentPlugin, strArr);
            } else if (METHOD_NAME_REFRESH_HOME_HEADER.equalsIgnoreCase(str3)) {
                handleRefreshHomeHeaderEvent(strArr);
            } else if (METHOD_NAME_PAY_FOR_MONTHLY_VIP.equalsIgnoreCase(str3)) {
                handlePayForMonthlyVip(strArr);
            } else if (METHOD_NAME_SHOW_CALENDAR_CARD.equalsIgnoreCase(str3)) {
                handleShowHistoryCalendarCard(strArr);
            } else if (METHOD_NAME_SHOW_TRANS_WEB_VIEW.equalsIgnoreCase(str3)) {
                handleShowTransWebView(strArr);
            } else if (METHOD_NAME_SETTING_PAGE.equalsIgnoreCase(str3)) {
                handleShowSettingDialog(strArr);
            }
        }
        return false;
    }

    private void handlePayForMonthlyVip(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString(JSON_ARGS_NAME_USER_ID);
                String optString2 = jSONObject.optString(JSON_ARGS_NAME_SERVICE_NAME);
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = JSON_ARGS_NAME_SERVICE_NAME_DEFAULT;
                }
                String str = optString2;
                String optString3 = jSONObject.optString(JSON_ARGS_NAME_SERVICE_CODE);
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = JSON_ARGS_NAME_SERVICE_CODE_DEFAULT;
                }
                String optString4 = jSONObject.optString("product_id");
                String optString5 = jSONObject.optString(JSON_ARGS_NAME_PRODUCT_TYPE);
                String optString6 = jSONObject.optString(JSON_ARGS_NAME_PRODUCT_NUM);
                c.f407941a.f(getHostActivity(), optString, optString3, str, optString4, optString5, optString6);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[handlePayForMonthlyVip] error:", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "[handlePayForMonthlyVip] args is null or empty");
    }

    private void handleShowHistoryCalendarCard(String[] strArr) {
        Activity resumeActivity;
        WebViewPlugin.b bVar;
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString(JSON_ARGS_NAME_USER_ID);
                String optString2 = jSONObject.optString(JSON_ARGS_NAME_CHECK_DATE);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    QLog.i(TAG, 2, "space id is " + optString + ", check date is " + optString2);
                    QZIntimateHistoryCalendarCardInitBean qZIntimateHistoryCalendarCardInitBean = new QZIntimateHistoryCalendarCardInitBean();
                    qZIntimateHistoryCalendarCardInitBean.setSpaceId(optString);
                    qZIntimateHistoryCalendarCardInitBean.setCheckDate(optString2);
                    WebViewPlugin webViewPlugin = this.parentPlugin;
                    if (webViewPlugin != null && (bVar = webViewPlugin.mRuntime) != null && bVar.a() != null) {
                        resumeActivity = this.parentPlugin.mRuntime.a();
                        i.o().b(resumeActivity, qZIntimateHistoryCalendarCardInitBean);
                        return;
                    }
                    resumeActivity = MobileQQ.sMobileQQ.getResumeActivity();
                    i.o().b(resumeActivity, qZIntimateHistoryCalendarCardInitBean);
                    return;
                }
                QLog.e(TAG, 1, "space id or check date is empty");
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[handleShowHistoryCalendarCard] error:", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "[handleShowHistoryCalendarCard] args is null or empty");
    }

    private void handleShowTransWebView(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                String optString = new JSONObject(strArr[0]).optString("url");
                QLog.e(TAG, 1, "[handleShowTransWebView] schemaUrl is:" + optString);
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                d.o(getHostActivity(), optString, true, 0, 0, -1, false, true);
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "[handleShowTransWebView] error:", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "[handlePostEvent] args is null or empty");
    }

    private void handleShowSettingDialog(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QZIntimateShowSettingDialogEvent(), true);
        } else {
            QLog.e(TAG, 1, "[handleShowSettingDialog] args is null or empty");
        }
    }
}
