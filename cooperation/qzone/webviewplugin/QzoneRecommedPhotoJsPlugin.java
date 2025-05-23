package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneRecommedPhotoJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static final String KEY_RECOMM_CHAT_CACHE_PHOTO = "recommendChatCachePhoto_on";
    private static final String LOG_TAG = "QzoneRecommedPhotoJsPlugin";
    private static final int MEDIA_TYPE_GIF = 3;
    private ConcurrentHashMap<String, String> callbackMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes38.dex */
    public interface OnCallJsBridge {
        void setData(JSONObject jSONObject, Bundle bundle) throws JSONException;
    }

    private String getBase64(String str) {
        if (!TextUtils.isEmpty(str)) {
            return QzoneDynamicAlbumPlugin.encodeBase64File(str, 200, 200, true);
        }
        return "";
    }

    private Bundle getResultBundle(Bundle bundle, String str) {
        if (bundle.containsKey("data")) {
            try {
                Bundle bundle2 = bundle.getBundle("data");
                if (bundle2 == null) {
                    QLog.e(LOG_TAG, 1, "call js function,bundle is empty");
                }
                return bundle2;
            } catch (Exception e16) {
                QLog.w(LOG_TAG, 1, "onWebEvent error", e16);
                errorCallBack(str);
                return null;
            }
        }
        errorCallBack(str);
        return null;
    }

    private void handleGetQuickMakeDynamicStatus(String str) {
        handleRunnable(RemoteHandleConst.CDM_GET_QUICK_MAKE_DYNAMIC_STATUS, str, new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().getQuickMakeDynamicStatus();
            }
        }, true);
    }

    private void handleRunnable(String str, String str2, Runnable runnable, boolean z16) {
        try {
            String optString = new JSONObject(str2).optString("callback");
            if (z16 && TextUtils.isEmpty(optString)) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.callbackMap.put(str, optString);
            }
            this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(runnable);
        } catch (Exception e16) {
            QLog.w(LOG_TAG, 1, "handleRunnable error" + str2, e16);
        }
    }

    private void handleSetQuickMakeDynamicStatus(final String str) {
        handleRunnable(RemoteHandleConst.CDM_SET_QUICK_MAKE_DYNAMIC_STATUS, str, new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Bundle bundle = new Bundle();
                    bundle.putInt("status", jSONObject.optInt("status"));
                    RemoteHandleManager.getInstance().getSender().setQuickMakeDynamicStatus(bundle);
                } catch (Throwable th5) {
                    QLog.w(QzoneRecommedPhotoJsPlugin.LOG_TAG, 1, "handleSetQuickMakeDynamicStatus error", th5);
                }
            }
        }, false);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("enterPhotoEventDetail".equals(str3) && strArr != null && strArr.length > 0) {
            handleForwardToRecommedPhoto(strArr[0]);
            return true;
        }
        if ("getQuickMakeDynamicStatus".equals(str3) && strArr != null && strArr.length > 0) {
            RemoteHandleManager.getInstance().addWebEventListener(this);
            handleGetQuickMakeDynamicStatus(strArr[0]);
            return true;
        }
        if (!"setQuickMakeDynamicStatus".equals(str3) || strArr == null || strArr.length <= 0) {
            return false;
        }
        handleSetQuickMakeDynamicStatus(strArr[0]);
        return true;
    }

    private void handleForwardToRecommedPhoto(String str) {
        try {
            String optString = new JSONObject(str).optString("photoEventID");
            Intent intent = new Intent(QZoneJsConstants.QZoneRecommendPhotoConstants.ACTION_ENTER_TO_QZONE_RECOMMEND_PHOTO);
            intent.putExtra(RemoteHandleConst.FORM_SCHEME_TO_RECOMMEND, true);
            intent.putExtra(RemoteHandleConst.PHOTO_UNIKEY, optString);
            QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), intent, 0);
        } catch (Exception e16) {
            QLog.w(LOG_TAG, 1, "handleForwardToRecommedPhoto error", e16);
        }
    }

    private void errorCallBack(String str) {
        if (str == null) {
            return;
        }
        QLog.w(LOG_TAG, 1, "errorCallBack error");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            this.parentPlugin.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            QLog.w(LOG_TAG, 1, "errorCallBack error", e16);
        }
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str2 = this.callbackMap.get(str);
        if (RemoteHandleConst.CDM_GET_QUICK_MAKE_DYNAMIC_STATUS.equals(str)) {
            callJsBridge(str2, bundle, new OnCallJsBridge() { // from class: cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.3
                @Override // cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.OnCallJsBridge
                public void setData(JSONObject jSONObject, Bundle bundle2) throws JSONException {
                    jSONObject.put("status", bundle2.getInt("status", 1));
                }
            });
        }
    }

    private void callJsBridge(String str, Bundle bundle, OnCallJsBridge onCallJsBridge) {
        Bundle resultBundle;
        if (bundle == null || onCallJsBridge == null || (resultBundle = getResultBundle(bundle, str)) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            onCallJsBridge.setData(jSONObject, resultBundle);
        } catch (Throwable th5) {
            QLog.e(LOG_TAG, 1, "onCallJsBridge.setData error", th5);
        }
        if (str != null) {
            this.parentPlugin.callJs(str, jSONObject.toString());
        }
    }
}
