package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneAlbumJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private static String TAG = "QzoneAlbumJsPlugin";

    private void defaultHandleMethodByBroadcast(WebViewPlugin.b bVar, String[] strArr, String str) {
        try {
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (a16 == null || a16.isFinishing()) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str);
            if (bVar.a() != null) {
                bVar.a().sendBroadcast(intent);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void handleAlbumFacadeCate(WebViewPlugin.b bVar, String[] strArr) {
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Intent intent = new Intent();
            intent.putExtra(QZoneHelper.QzoneAlbumFacadeCateConstants.KEY_ITEM_ID, jSONObject.optInt("item_id"));
            intent.putExtra("key_thumb_url", jSONObject.optString("thumb"));
            intent.putExtra(QZoneHelper.QzoneAlbumFacadeCateConstants.KEY_ITEM_TYPE, jSONObject.optInt("item_type"));
            intent.setAction(QZoneJsConstants.QZoneAlbumSkinJsConstants.ACTION_ALBUM_SKIN_JS_TO_QZONE);
            String optString = jSONObject.optString("callback");
            String optString2 = jSONObject.optString("entry");
            if (TextUtils.isEmpty(optString2)) {
                this.parentPlugin.callJs(optString, "{\"result\":\"false\"}");
                return;
            }
            if (QZoneOptAlbumRequest.FIELD_CMD_CREATE.equals(optString2) || QZoneOptAlbumRequest.FIELD_CMD_EDIT.equals(optString2) || QCircleScheme.AttrQQGroupDetail.PERSONAL.equals(optString2) || "photolist".equals(optString2)) {
                if (bVar.a() != null) {
                    bVar.a().sendBroadcast(intent);
                }
                this.parentPlugin.callJs(optString, "{\"result\":\"true\"}");
                AppInterface b16 = this.parentPlugin.mRuntime.b();
                if (!QCircleScheme.AttrQQGroupDetail.PERSONAL.equals(optString2) || b16 == null) {
                    return;
                }
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = b16.getCurrentAccountUin();
                BaseBusinessAlbumInfo baseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
                baseBusinessAlbumInfo.mAlbumId = jSONObject.optString("albumid");
                baseBusinessAlbumInfo.mUin = b16.getLongAccountUin();
                baseBusinessAlbumInfo.mAlbumType = 0;
                baseBusinessAlbumInfo.isIndividualityAlbum = true;
                QZoneHelper.forwardToPersonalAlbumPhotoList(a16, userInfo, baseBusinessAlbumInfo, -1);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleNotifyShareData(WebViewPlugin.b bVar, String[] strArr) {
        try {
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (a16 == null || a16.isFinishing()) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction(QZoneJsConstants.BROADCAST_ACTION_BLOG_SHARE_DATA);
            if (strArr != null && strArr.length > 0) {
                intent.putExtra(QZoneShareManager.KEY_SAHRE_DATA, strArr[0]);
            }
            if (bVar.a() != null) {
                bVar.a().sendBroadcast(intent);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void handleRefreshAlbumList(WebViewPlugin.b bVar, String[] strArr) {
        defaultHandleMethodByBroadcast(bVar, strArr, QZoneJsConstants.BROADCAST_ACTION_REFRESH_ALBUM_LIST);
    }

    private void handleRefreshPhotoList(WebViewPlugin.b bVar, String[] strArr) {
        defaultHandleMethodByBroadcast(bVar, strArr, QZoneJsConstants.BROADCAST_ACTION_REFRESH_PHOTO_LIST);
    }

    private void handleUpdateAlbumCommentList(WebViewPlugin.b bVar, String[] strArr) {
        try {
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (a16 == null || a16.isFinishing()) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Intent intent = new Intent();
            intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_ALBUM_UPDATE_COMMENT_LIST_COUNT, jSONObject.optInt("count"));
            intent.setAction(QZoneJsConstants.BROADCAST_ACTION_UPDATE_ALBUM_COMMENT_LIST);
            if (bVar.a() != null) {
                bVar.a().sendBroadcast(intent);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_SET_ALBUM_SKIN) && strArr != null && strArr.length >= 1) {
                handleAlbumFacadeCate(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_UPDATE_ALBUM_COMMENT_LIST) && strArr != null && strArr.length > 0) {
                handleUpdateAlbumCommentList(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if ("refreshPhotoList".equalsIgnoreCase(str3)) {
                handleRefreshPhotoList(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if ("RefreshAlbumList".equalsIgnoreCase(str3)) {
                handleRefreshAlbumList(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if ("getBlogArkShareData".equalsIgnoreCase(str3)) {
                handleNotifyShareData(this.parentPlugin.mRuntime, strArr);
                return true;
            }
        }
        return false;
    }
}
