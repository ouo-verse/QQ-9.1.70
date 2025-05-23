package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneEventTagJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static String ADDFRIENDS = "addfriends";
    public static final String DESC = "desc";
    public static final String ID = "id";
    public static final String JOIN_LIST = "joinList";
    public static final String PIC_URL = "picUrl";
    public static String PKG_NAME = "Qzone";
    private static final String TAG = "QZoneEventTagJsPlugin";
    public static final String TIME = "time";
    public static final String TITLE = "title";
    public static final String TRUNCATE_NUM = "truncateNum";
    public static final String UIN = "uin";
    private String callback;

    private void getHistoryEventTag(String str) {
        try {
            String optString = new JSONObject(str).optString("callback");
            this.callback = optString;
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            RemoteHandleManager.getInstance().getSender().getHistoryEventTag();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getHistoryEventTag error", e16);
        }
    }

    private void openAddFriendActivity(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long j3 = jSONObject.getLong("uin");
            int optInt = jSONObject.optInt("sourceId", 3011);
            int optInt2 = jSONObject.optInt("subSourceId", 21);
            Activity a16 = bVar.a();
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(a16, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(a16, 1, String.valueOf(j3), "", optInt, optInt2, null, null, null, null, null));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void selectEventTag(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            bundle.putString("uin", jSONObject.optString("uin"));
            bundle.putString("time", jSONObject.optString("time"));
            bundle.putString("title", jSONObject.optString("title"));
            bundle.putString("picUrl", jSONObject.optString("picUrl"));
            bundle.putString("id", jSONObject.optString("id"));
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            JSONObject optJSONObject = jSONObject.optJSONObject(JOIN_LIST);
            if (optJSONObject != null) {
                if (optJSONObject.has("names")) {
                    sb5.append(optJSONObject.optString("names"));
                }
                if (optJSONObject.has("middle")) {
                    String optString = optJSONObject.optString("middle");
                    sb5.append(optString);
                    sb6.append(optString);
                }
                if (optJSONObject.has("suffix")) {
                    String optString2 = optJSONObject.optString("suffix");
                    sb5.append(optString2);
                    sb6.append(optString2);
                }
            }
            bundle.putString("desc", sb5.toString());
            bundle.putString(TRUNCATE_NUM, sb6.toString());
            RemoteHandleManager.getInstance().getSender().selectEventTag(bundle);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "selectHistoryEventTag error", e16);
        }
    }

    private void setHistoryEventTag(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("list");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                Bundle bundle = new Bundle();
                bundle.putString("uin", optJSONObject.optString("uin"));
                bundle.putString("time", optJSONObject.optString("time"));
                bundle.putString("title", optJSONObject.optString("title"));
                bundle.putString("picUrl", optJSONObject.optString("picUrl"));
                bundle.putString("id", optJSONObject.optString("id"));
                RemoteHandleManager.getInstance().getSender().setHistoryEventTagData(bundle);
            } else {
                RemoteHandleManager.getInstance().getSender().setHistoryEventTagData(null);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "setHistoryEventTag error", e16);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals(PKG_NAME) && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equals(ADDFRIENDS)) {
                if (strArr != null && strArr.length > 0) {
                    WebViewPlugin webViewPlugin2 = this.parentPlugin;
                    openAddFriendActivity(webViewPlugin2, webViewPlugin2.mRuntime, strArr);
                }
                return true;
            }
            if (QZoneJsConstants.GET_HISTORY_EVENT_TAG.equals(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                getHistoryEventTag(strArr[0]);
                return true;
            }
            if (QZoneJsConstants.SET_HISTORY_EVENT_TAG.equals(str3)) {
                setHistoryEventTag(strArr[0]);
                return true;
            }
            if (QZoneJsConstants.SELECT_EVENT_TAG.equals(str3)) {
                selectEventTag(strArr[0]);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        if (bundle == null || !RemoteHandleConst.CMD_GET_HISTORY_EVENT_TAG.equals(str)) {
            return;
        }
        if (bundle.containsKey("data")) {
            Bundle bundle2 = bundle.getBundle("data");
            if (bundle2 == null) {
                QLog.e(TAG, 1, "call js function,bundle is empty");
                return;
            }
            try {
                ArrayList parcelableArrayList = bundle2.getParcelableArrayList(QZoneShareManager.QZONE_SHARE_EVENT_TAG);
                JSONArray jSONArray = new JSONArray();
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    PublishEventTag publishEventTag = (PublishEventTag) it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("uin", publishEventTag.uin);
                    jSONObject.put("time", publishEventTag.time);
                    jSONObject.put("title", publishEventTag.title);
                    jSONObject.put("picUrl", publishEventTag.picUrl);
                    jSONObject.put("id", publishEventTag.f390868id);
                    jSONArray.mo162put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("list", jSONArray);
                String str2 = this.callback;
                if (str2 != null) {
                    this.parentPlugin.callJs(str2, jSONObject2.toString());
                    return;
                }
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "onWebEvent error", e16);
                return;
            }
        }
        errorCallBack(this.callback);
    }

    private void errorCallBack(String str) {
        if (str == null) {
            return;
        }
        QLog.w(TAG, 1, "errorCallBack error");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            this.parentPlugin.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            QLog.w(TAG, 1, "errorCallBack error", e16);
        }
    }
}
