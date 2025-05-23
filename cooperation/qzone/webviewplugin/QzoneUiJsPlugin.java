package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.AssetExtension;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.vip.manager.i;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneUiJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    private static final String LOG_TAG = "QzoneUiJsPlugin";
    private String getVideoCoverCallback;
    private String recordVideoCallback;
    private String uploadVideoCallback;
    private boolean isBroadcastReceiverRegistered = false;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cooperation.qzone.webviewplugin.QzoneUiJsPlugin.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d(QzoneUiJsPlugin.LOG_TAG, 2, action);
            }
            if (PeakConstants.ACTION_TOPIC_VIDEO_FAKE_FEED.equals(action)) {
                if (TextUtils.isEmpty(QzoneUiJsPlugin.this.uploadVideoCallback)) {
                    return;
                }
                String stringExtra = intent.getStringExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_PATH);
                int intExtra = intent.getIntExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_WIDTH, 0);
                int intExtra2 = intent.getIntExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_HEIGHT, 0);
                if (TextUtils.isEmpty(stringExtra)) {
                    QLog.w(QzoneUiJsPlugin.LOG_TAG, 1, "topic video upload, video path is empty");
                    return;
                }
                String encodeBase64File = QzoneDynamicAlbumPlugin.encodeBase64File(stringExtra, intExtra, intExtra2, true);
                if (TextUtils.isEmpty(encodeBase64File)) {
                    QLog.w(QzoneUiJsPlugin.LOG_TAG, 1, "topic video upload pic not exist,imageBase64 empty. path=" + stringExtra);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(QzoneUiJsPlugin.LOG_TAG, 2, "topicUploadVideo base64=data:image/jpg;base64," + encodeBase64File);
                }
                String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_TOPIC_VIDEO_SHUOSHUO_CONTENT);
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                String stringExtra3 = intent.getStringExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("content", stringExtra2);
                    jSONObject2.put("msg", "");
                    jSONObject2.put("base64", "data:image/jpg;base64," + encodeBase64File);
                    jSONObject2.put("timestamp", stringExtra3);
                    jSONObject2.put("isFakeFeed", true);
                    jSONObject.put("data", jSONObject2);
                    QzoneUiJsPlugin qzoneUiJsPlugin = QzoneUiJsPlugin.this;
                    qzoneUiJsPlugin.parentPlugin.callJs(qzoneUiJsPlugin.uploadVideoCallback, jSONObject.toString());
                    return;
                } catch (JSONException e16) {
                    QLog.w(QzoneUiJsPlugin.LOG_TAG, 1, "topicUploadVideo fake feed  callback error", e16);
                    return;
                }
            }
            if (PeakConstants.ACTION_TOPIC_VIDEO_HALF_FAKE_FEED.equals(action)) {
                if (TextUtils.isEmpty(QzoneUiJsPlugin.this.uploadVideoCallback)) {
                    return;
                }
                String stringExtra4 = intent.getStringExtra(PeakConstants.KEY_TOPIC_VIDEO_PUBLISH_MSG);
                String stringExtra5 = intent.getStringExtra(PeakConstants.KEY_TOPIC_VIDEO_TID);
                String stringExtra6 = intent.getStringExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("code", 0);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("msg", stringExtra4);
                    jSONObject4.put("timestamp", stringExtra6);
                    jSONObject4.put(AppConstants.Key.KEY_QZONE_UGCKEY, stringExtra5);
                    jSONObject3.put("data", jSONObject4);
                    QzoneUiJsPlugin qzoneUiJsPlugin2 = QzoneUiJsPlugin.this;
                    qzoneUiJsPlugin2.parentPlugin.callJs(qzoneUiJsPlugin2.uploadVideoCallback, jSONObject3.toString());
                    return;
                } catch (JSONException e17) {
                    QLog.w(QzoneUiJsPlugin.LOG_TAG, 1, "topicUploadVideo half fake feed  callback error", e17);
                    return;
                }
            }
            if (!PeakConstants.ACTION_H5_VIDEO_RECORD_CALLBACK.equals(action) || TextUtils.isEmpty(QzoneUiJsPlugin.this.recordVideoCallback)) {
                return;
            }
            String stringExtra7 = intent.getStringExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH);
            if (TextUtils.isEmpty(stringExtra7)) {
                QLog.e(QzoneUiJsPlugin.LOG_TAG, 1, "recordVideo callback thumbnailPath is empty");
                return;
            }
            String encodeBase64File2 = QzoneDynamicAlbumPlugin.encodeBase64File(stringExtra7, intent.getIntExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILWIDTH, 0), intent.getIntExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILHEIGHT, 0), true);
            if (TextUtils.isEmpty(encodeBase64File2)) {
                QLog.w(QzoneUiJsPlugin.LOG_TAG, 1, "h5 video record pic not exist,imageBase64 empty. thumbnailPath=" + stringExtra7);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(QzoneUiJsPlugin.LOG_TAG, 2, "h5 video record base64=data:image/jpg;base64," + encodeBase64File2);
            }
            String stringExtra8 = intent.getStringExtra("param.content");
            String str = stringExtra8 != null ? stringExtra8 : "";
            boolean booleanExtra = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, false);
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("text", str);
                jSONObject5.put("sync_qzone", booleanExtra ? 1 : 0);
                jSONObject5.put(AssetExtension.SCENE_THUMBNAIL, "data:image/jpg;base64," + encodeBase64File2);
                jSONObject5.put("video_info", QzoneUiJsPlugin.this.convertVideoInfoToJson(intent));
                QzoneUiJsPlugin qzoneUiJsPlugin3 = QzoneUiJsPlugin.this;
                qzoneUiJsPlugin3.parentPlugin.callJs(qzoneUiJsPlugin3.recordVideoCallback, jSONObject5.toString());
            } catch (JSONException e18) {
                QLog.w(QzoneUiJsPlugin.LOG_TAG, 1, "recordVideo callback error", e18);
            }
        }
    };

    private void handleGetVideoCover(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "handleGetVideoCover json=" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("callback");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.getVideoCoverCallback = string;
            final String string2 = jSONObject.getString("timestamp");
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneUiJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    RemoteHandleManager.getInstance().getSender().getFakeFeedVideoCover(string2);
                }
            });
        } catch (JSONException e16) {
            QLog.w(LOG_TAG, 1, "handleGetVideoCover error", e16);
        }
    }

    private void handlePreviewVideo(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "handlePreviewVideo json=" + str);
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("video_info");
            if (optJSONObject == null) {
                QLog.e(LOG_TAG, 1, "handlePreviewVideo video_info is empty");
                return;
            }
            String optString = optJSONObject.optString("videoPath");
            int optInt = optJSONObject.optInt("videoType");
            long optLong = optJSONObject.optLong("startTime");
            long optLong2 = optJSONObject.optLong("duration");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("encodeExtras");
            Bundle bundle = new Bundle();
            if (optJSONObject2 != null) {
                Iterator keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    bundle.putInt(str2, optJSONObject2.optInt(str2));
                }
            }
            if (optInt == 0) {
                QZoneVideoCommonUtils.gotoRecordPreview(this.parentPlugin.mRuntime.a(), optInt, optString, optLong2, bundle);
            } else if (optInt == 1) {
                QZoneHelper.forwardToPreviewLocalView(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), optInt, optString, optLong, optLong2 + optLong);
            }
        } catch (JSONException e16) {
            QLog.w(LOG_TAG, 1, "handlePreviewVideo error", e16);
        }
    }

    private void handleUploadVideo(final String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "handleUploadVideo json=" + str);
        }
        try {
            if (new JSONObject(str).optJSONObject("video_info") == null) {
                QLog.e(LOG_TAG, 1, "handleUploadVideo video_info is empty");
            } else {
                this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneUiJsPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteHandleManager.getInstance().getSender().uploadVideoForH5(str);
                    }
                });
            }
        } catch (JSONException e16) {
            QLog.w(LOG_TAG, 1, "handleUploadVideo error", e16);
        }
    }

    private void registerBroadcast() {
        if (this.isBroadcastReceiverRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PeakConstants.ACTION_TOPIC_VIDEO_FAKE_FEED);
        intentFilter.addAction(PeakConstants.ACTION_TOPIC_VIDEO_HALF_FAKE_FEED);
        intentFilter.addAction(PeakConstants.ACTION_H5_VIDEO_RECORD_CALLBACK);
        this.parentPlugin.mRuntime.a().registerReceiver(this.broadcastReceiver, intentFilter);
        this.isBroadcastReceiverRegistered = true;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QZoneJsConstants.PKGNAME_QZUI.equals(str2) && this.parentPlugin != null) {
            if ("topicUploadVideo".equals(str3) && strArr != null && strArr.length > 0) {
                handleTopicUploadVideo(strArr[0]);
                return true;
            }
            if ("getVideoFaceData".equals(str3) && strArr != null && strArr.length > 0) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                handleGetVideoCover(strArr[0]);
                return true;
            }
            if ("recordVideo".equals(str3) && strArr != null && strArr.length > 0) {
                handleRecordVideo(strArr[0]);
                return true;
            }
            if ("previewVideo".equals(str3) && strArr != null && strArr.length > 0) {
                handlePreviewVideo(strArr[0]);
                return true;
            }
            if ("uploadVideo".equals(str3) && strArr != null && strArr.length > 0) {
                handleUploadVideo(strArr[0]);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        if (this.isBroadcastReceiverRegistered) {
            this.parentPlugin.mRuntime.a().unregisterReceiver(this.broadcastReceiver);
            this.isBroadcastReceiverRegistered = false;
        }
        RemoteHandleManager.getInstance().removeWebEventListener(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject convertVideoInfoToJson(Intent intent) {
        String stringExtra = intent.getStringExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOPATH);
        int intExtra = intent.getIntExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOTYPE, 0);
        String stringExtra2 = intent.getStringExtra("param.content");
        long longExtra = intent.getLongExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOSIZE, 0L);
        String stringExtra3 = intent.getStringExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH);
        long longExtra2 = intent.getLongExtra("param.duration", 0L);
        long longExtra3 = intent.getLongExtra(RemoteHandleConst.VIDEO_PARAM_STARTTIME, 0L);
        long longExtra4 = intent.getLongExtra(RemoteHandleConst.VIDEO_PARAM_TOTALDURATION, 0L);
        boolean booleanExtra = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_NEEDPROCESS, true);
        boolean booleanExtra2 = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, false);
        String stringExtra4 = intent.getStringExtra(RemoteHandleConst.VIDEO_PARAM_NEW_FAKE_VID);
        Bundle bundleExtra = intent.getBundleExtra(RemoteHandleConst.VIDEO_PARAM_EXTRAS);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("videoPath", stringExtra);
            jSONObject.put("videoType", intExtra);
            jSONObject.put("content", stringExtra2);
            jSONObject.put(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, longExtra);
            jSONObject.put("thumbnailPath", stringExtra3);
            jSONObject.put("duration", longExtra2);
            jSONObject.put("totalDuration", longExtra4);
            jSONObject.put("needProcess", booleanExtra);
            jSONObject.put("syncQzone", booleanExtra2);
            jSONObject.put("fakeVid", stringExtra4);
            jSONObject.put("startTime", longExtra3);
            JSONObject jSONObject2 = new JSONObject();
            if (bundleExtra != null) {
                for (String str : bundleExtra.keySet()) {
                    jSONObject2.put(str, bundleExtra.getInt(str));
                }
            }
            jSONObject.put("encodeExtras", jSONObject2);
        } catch (JSONException e16) {
            QLog.w(LOG_TAG, 1, "convertVideoInfoToJson error", e16);
        }
        return jSONObject;
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        String encodeBase64File;
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            QLog.e(LOG_TAG, 1, "call js function,bundle is empty");
            return;
        }
        if (!RemoteHandleConst.CMD_VIDEO_GET_FAKE_FEED_COVER.equals(str) || TextUtils.isEmpty(this.getVideoCoverCallback)) {
            return;
        }
        String string = bundle2.getString(RemoteHandleConst.PARAM_VIDEO_COVER_PATH);
        int i3 = bundle2.getInt(RemoteHandleConst.PARAM_VIDEO_COVER_WIDTH, 0);
        int i16 = bundle2.getInt(RemoteHandleConst.PARAM_VIDEO_COVER_HEIGHT, 0);
        String string2 = bundle2.getString(RemoteHandleConst.PARAM_VIDEO_CLIENT_KEY);
        if (TextUtils.isEmpty(string)) {
            encodeBase64File = "";
        } else {
            encodeBase64File = QzoneDynamicAlbumPlugin.encodeBase64File(string, i3, i16);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msg", "");
            jSONObject2.put("base64", "data:image/jpg;base64," + encodeBase64File);
            jSONObject2.put("timestamp", string2);
            jSONObject2.put("isFakeFeed", true);
            jSONObject.put("data", jSONObject2);
            this.parentPlugin.callJs(this.getVideoCoverCallback, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.w(LOG_TAG, 1, "topicUploadVideo fake feed  callback error", e16);
        }
    }

    private void handleRecordVideo(String str) {
        String str2;
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "handleRecordVideo json=" + str);
        }
        registerBroadcast();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("callback");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.recordVideoCallback = string;
            String optString = jSONObject.optString("ptv_id");
            String optString2 = jSONObject.optString("confirm_btn_text");
            int optInt = jSONObject.optInt("need_input_text", 0);
            int optInt2 = optInt != 0 ? jSONObject.optInt("need_sync_qzone", 0) : 0;
            int optInt3 = jSONObject.optInt("is_original_video", 0);
            int optInt4 = jSONObject.optInt("need_edit_video", 0);
            boolean optBoolean = jSONObject.optBoolean("support_local_video", true);
            JSONObject optJSONObject = jSONObject.optJSONObject("last_video");
            if (optJSONObject != null && optJSONObject.optInt("videoType") == 0) {
                final String optString3 = optJSONObject.optString("videoPath");
                if (!TextUtils.isEmpty(optString3)) {
                    this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneUiJsPlugin.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RemoteHandleManager.getInstance().getSender().deleteTempVideo(optString3);
                        }
                    });
                }
            }
            Intent intent = new Intent();
            boolean optBoolean2 = jSONObject.optBoolean("support_beauty", true);
            boolean optBoolean3 = jSONObject.optBoolean("support_dd", true);
            boolean optBoolean4 = jSONObject.optBoolean("support_filter", true);
            boolean optBoolean5 = jSONObject.optBoolean("dd_category_unfold", false);
            String optString4 = jSONObject.optString("dd_category_name");
            str2 = LOG_TAG;
            try {
                String optString5 = jSONObject.optString("dd_item_id");
                boolean optBoolean6 = jSONObject.optBoolean("filter_category_unfold", false);
                String optString6 = jSONObject.optString("filter_category_name");
                String optString7 = jSONObject.optString("filter_item_id");
                int i3 = optInt2;
                int optInt5 = jSONObject.optInt("force_camera", 0);
                intent.putExtra(PeakConstants.ARG_BEAUTY, optBoolean2);
                intent.putExtra(PeakConstants.ARG_SUPPORT_DD, optBoolean3);
                intent.putExtra(PeakConstants.ARG_SUPPORT_FILTER, optBoolean4);
                intent.putExtra(PeakConstants.ARG_UNFOLD_DD, optBoolean5);
                intent.putExtra(PeakConstants.ARG_DD_CATEGORY_NAME, optString4);
                intent.putExtra(PeakConstants.ARG_DD_ITEM_ID, optString5);
                intent.putExtra(PeakConstants.ARG_UNFOLD_FILTER, optBoolean6);
                intent.putExtra(PeakConstants.ARG_FILTER_CATEGORY_NAME, optString6);
                intent.putExtra(PeakConstants.ARG_FILTER_ITEM_ID, optString7);
                intent.putExtra(PeakConstants.ARG_FORCE_CAMERA, optInt5);
                QZoneVideoCommonUtils.installVideoActivity(this.parentPlugin.mRuntime.a(), QZoneVideoCommonUtils.REFER_UPLOAD_VIDEO_FOR_H5, i.r().z() > 0, optInt > 0, optInt4 > 0, i3 > 0, optInt3 > 0, optBoolean, optString, optString2, intent);
            } catch (JSONException e16) {
                e = e16;
                QLog.w(str2, 1, "handleRecordVideo error", e);
            }
        } catch (JSONException e17) {
            e = e17;
            str2 = LOG_TAG;
        }
    }

    private void handleTopicUploadVideo(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "handleTopicUploadVideo json=" + str);
        }
        registerBroadcast();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("callback");
            if (!TextUtils.isEmpty(string)) {
                this.uploadVideoCallback = string;
            }
            String string2 = jSONObject.getString("topicId");
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            QZoneVideoCommonUtils.installVideoActivity(0L, this.parentPlugin.mRuntime.a(), true, true, PeakConstants.VIDEO_REFER_FROM_MOOD, i.r().z() > 0, true, string2, "ptucamera".equals(jSONObject.optString("shoot")), null, null, null);
        } catch (JSONException e16) {
            QLog.w(LOG_TAG, 1, "topicUploadVideo error", e16);
        }
    }
}
