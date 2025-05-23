package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class TroopAlbumPlugin implements NativePlugin {
    public static final String DOWNLOAD_GROUP_ALBUM_PHOTO = "groupAlbum_downloadGroupAlbumPhoto";
    public static final String GROUP_UPLOAD_PHOTO = "groupAlbum_groupUploadPhoto";
    public static final String IMPORT_GROUP_AIO = "groupAlbum_importGroupAIO";
    public static final String IS_EXIT_FAIL_MISSON = "is_exit_fail_misson";
    public static final String JUMP_CATEGORY_ALBUM = "groupAlbum_jumpCategoryAlbum";
    public static final String JUMP_GROUP_ALBUM_SEND_BOX = "groupAlbum_jumpGroupAlbumSendBox";
    public static final String OPEN_USER_QZONE_HOME = "groupAlbum_openUserQzoneHome";
    public static final String PICK_QZONE_ALBUM = "groupAlbum_pickQzoneAlbum";
    public static final String QZONE_ALBUM_START = "groupAlbum_start";
    public static String REFER = "famous";
    public static final String SHOW_GROUP_PHOTO_BROWSER = "groupAlbum_showGroupPhotoBrowser";
    public static final String TAG = "TroopAlbumPlugin";
    Dialog mDownloadingDialog;
    private QQCustomDialog openDialog;
    private JSContext troopAlbumJsContext;
    private Handler handler = new Handler();
    private String cacheArgs = null;
    private long lastClickTime = 0;
    private BroadcastReceiver mTroopUploadReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            JSContext jSContext;
            if (!"troop_upload".equals(intent.getAction()) || (jSContext = TroopAlbumPlugin.this.troopAlbumJsContext) == null) {
                return;
            }
            SharedPreferences.Editor edit = jSContext.getActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).edit();
            JSONObject jSONObject = new JSONObject();
            int intExtra = intent.getIntExtra("count", 0);
            boolean booleanExtra = intent.getBooleanExtra("fail", false);
            try {
                jSONObject.put("count", intExtra);
                jSONObject.put("isFail", booleanExtra);
                if (QLog.isColorLevel()) {
                    QLog.w(TroopAlbumPlugin.TAG, 2, "troopAlbumReceiver" + intExtra + ",isfail" + booleanExtra);
                }
                if (booleanExtra) {
                    edit.putBoolean(TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, true).apply();
                } else {
                    edit.putBoolean(TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, false).apply();
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            jSContext.callJs("custom_event_groupAlbum_onGroupAlbumUpload", jSONObject);
            if (intExtra == 0) {
                edit.putBoolean(TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, false).apply();
                try {
                    jSContext.getActivity().unregisterReceiver(TroopAlbumPlugin.this.mTroopUploadReceiver);
                } catch (IllegalArgumentException e17) {
                    QLog.i(TroopAlbumPlugin.TAG, 2, e17.getMessage());
                }
                TroopAlbumPlugin.this.troopAlbumJsContext = null;
            }
        }
    };
    private BroadcastReceiver mTroopSelectReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("troop_select".equals(intent.getAction())) {
                QLog.w(TroopAlbumPlugin.TAG, 2, "troop_select recive");
                try {
                    TroopAlbumPlugin.this.troopAlbumJsContext.evaluateCallback(true, new JSONObject("{albumid:\"" + intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ID) + "\",albumname:\"" + intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_NAME) + "\",albumcover:\"" + intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_COVER) + "\",albumpermission:" + intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_PERMISSION, 0) + "}"), "");
                    TroopAlbumPlugin.this.troopAlbumJsContext.getActivity().unregisterReceiver(TroopAlbumPlugin.this.mTroopSelectReceiver);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin$3, reason: invalid class name */
    /* loaded from: classes33.dex */
    public class AnonymousClass3 implements WebEventListener {
        final /* synthetic */ JSContext val$jsContext;
        final /* synthetic */ String val$jsonString;

        AnonymousClass3(String str, JSContext jSContext) {
            this.val$jsonString = str;
            this.val$jsContext = jSContext;
        }

        @Override // cooperation.qzone.remote.logic.WebEventListener
        public void onWebEvent(String str, Bundle bundle) {
            if (RemoteHandleConst.CMD_TROOP_DOWNLOAD_PHOTO.equals(str)) {
                Bundle bundle2 = bundle.getBundle("data");
                if (bundle2.getBoolean("isOpenVip")) {
                    TroopAlbumPlugin.this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TroopAlbumPlugin.this.cacheArgs = anonymousClass3.val$jsonString;
                            Activity activity = AnonymousClass3.this.val$jsContext.getActivity();
                            if (TroopAlbumPlugin.this.openDialog == null) {
                                TroopAlbumPlugin.this.openDialog = DialogUtil.createCustomDialog(activity, 230).setTitle(HardCodeUtil.qqStr(R.string.uan)).setMessage(HardCodeUtil.qqStr(R.string.uam)).setPositiveButton(HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.3.1.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        dialogInterface.dismiss();
                                        String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
                                        Intent intent = new Intent();
                                        String string = AnonymousClass3.this.val$jsContext.getActivity().getResources().getString(R.string.gdd);
                                        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.OPEN_VIP);
                                        intent.putExtra("aid", "jhan_plxz");
                                        intent.putExtra("success_tips", string);
                                        intent.putExtra("direct_go", true);
                                        QzonePluginProxyActivity.launchPluingActivityForResult(AnonymousClass3.this.val$jsContext.getActivity(), account, intent, 4);
                                    }
                                }).setNegativeButton(activity.getString(R.string.gmi), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.3.1.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        dialogInterface.dismiss();
                                    }
                                });
                            }
                            if (TroopAlbumPlugin.this.openDialog.isShowing()) {
                                return;
                            }
                            TroopAlbumPlugin.this.openDialog.show();
                        }
                    });
                    return;
                }
                bundle2.getInt("totalNum");
                int i3 = bundle2.getInt("successNum");
                int i16 = bundle2.getInt("failNum");
                boolean z16 = bundle2.getBoolean("isDownloadCanceled");
                TroopAlbumPlugin.this.alertDownloadErrorCount(this.val$jsContext.getActivity(), i3, i16, bundle2.getString("path"), z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertDownloadErrorCount(Activity activity, int i3, int i16, String str, boolean z16) {
        String str2;
        Dialog dialog = this.mDownloadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDownloadingDialog.dismiss();
        }
        if (z16) {
            return;
        }
        if (i16 > 0) {
            if (i3 > 0) {
                str2 = (String.format(activity.getString(R.string.gmn), Integer.valueOf(i3)) + "\uff0c") + str + HardCodeUtil.qqStr(R.string.uap);
            } else {
                str2 = "";
            }
            DialogUtil.createCustomDialog(activity, 232).setMessage(str2 + String.format(activity.getString(R.string.gmg), Integer.valueOf(i16))).setNegativeButton(R.string.gml, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i17) {
                    dialogInterface.dismiss();
                }
            }).show();
            return;
        }
        ToastUtil.a().e(activity.getString(R.string.gmo) + str + HardCodeUtil.qqStr(R.string.uao));
    }

    private void handleChatAio(JSONObject jSONObject, JSContext jSContext) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        jSONObject2.optString("albumname");
        jSONObject2.getInt("groupCode");
        jSONObject2.optString("albumid");
        jSContext.getActivity();
    }

    private void handleDownloadPic(JSONObject jSONObject, JSContext jSContext) throws JSONException {
        Intent intent = new Intent();
        final String jSONObject2 = jSONObject.getJSONObject("data").toString();
        intent.putExtra("photos", jSONObject2);
        RemoteHandleManager.getInstance().addWebEventListener(new AnonymousClass3(jSONObject2, jSContext));
        if (!isSdcardWorking()) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.uak));
            return;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.uaj));
        } else if (!NetworkState.isWifiConn()) {
            Activity activity = jSContext.getActivity();
            DialogUtil.createCustomDialog(activity, 230).setTitle(activity.getString(R.string.gmk)).setMessage(activity.getString(R.string.gmm)).setPositiveButton(activity.getString(R.string.gmj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(jSONObject2);
                }
            }).setNegativeButton(activity.getString(R.string.gmi), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }).show();
        } else {
            RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(jSONObject2);
        }
    }

    private void handleJumpCategoryAlbum(JSONObject jSONObject, JSContext jSContext) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        int optInt = jSONObject2.optInt("categoryType");
        String optString = jSONObject2.optString("categoryId");
        Activity activity = jSContext.getActivity();
        if (activity != null) {
            QZoneHelper.forwardToCategoryAlbum(activity, BaseApplicationImpl.sApplication.getRuntime().getAccount(), optInt, optString, -1);
        }
    }

    private void handleJumpToPublishBox(JSContext jSContext) {
        QZoneHelper.UserInfo.getInstance();
        QZoneHelper.forwardToPublishBox(jSContext.getActivity(), null, 0);
    }

    private void handleJumpToQzone(JSONObject jSONObject, JSContext jSContext) throws JSONException {
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(jSContext.getActivity(), jSONObject.getJSONObject("data").optLong("uin"), false, 0);
    }

    private void handleQunDidPickAlbum(JSONObject jSONObject, JSContext jSContext) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("key_personal_album_enter_model", 0);
            bundle.putBoolean(QZoneHelper.QZoneAlbumConstants.KEY_PASS_RESULT_BY_BUNDLE, true);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = BaseApplicationImpl.sApplication.getRuntime().getAccount();
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            QZoneHelper.forwardToPersonalAlbumSelect(jSContext.getActivity(), userInfo, bundle, 100);
            this.troopAlbumJsContext = jSContext;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("troop_select");
            jSContext.getActivity().registerReceiver(this.mTroopSelectReceiver, intentFilter);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleQunPickQzoneAlbum,decode param error");
            }
        }
    }

    private void handleQunStartAlbum(JSONObject jSONObject, JSContext jSContext) {
        try {
            boolean z16 = jSContext.getActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).getBoolean(IS_EXIT_FAIL_MISSON, false);
            QLog.w(TAG, 2, "isExitFailMission:" + z16);
            if (z16) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("count", 1);
                jSONObject2.put("isFail", true);
                jSContext.callJs("custom_event_groupAlbum_onGroupAlbumUpload", jSONObject2);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleQunPickQzoneAlbum,decode param error");
            }
        }
    }

    private void handleUploadPhoto(JSONObject jSONObject, JSContext jSContext) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String optString = jSONObject2.optString("albumname");
        long j3 = jSONObject2.getLong("groupCode");
        String optString2 = jSONObject2.optString("albumid");
        int i3 = !TextUtils.isEmpty(optString2) ? 2 : 1;
        if (TextUtils.isEmpty(optString2)) {
            QLog.d(TAG, 1, "handleUploadPhoto  init  mAlbumId is null!");
        }
        QZoneHelper.forwardMiniToTroopUploadPhoto(jSContext.getActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i3, 1, j3, "", optString2, optString, 7001, 43);
        this.troopAlbumJsContext = jSContext;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("troop_upload");
        jSContext.getActivity().registerReceiver(this.mTroopUploadReceiver, intentFilter);
    }

    private boolean isSdcardWorking() {
        return SDCardMountMonitorReceiver.getInstance().isSDCardCanWrite();
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, jSONObject.toString());
                }
                String optString = jSONObject.optString("api_name");
                if (optString.equals(GROUP_UPLOAD_PHOTO)) {
                    handleUploadPhoto(jSONObject, jSContext);
                    return;
                }
                if (optString.equals(OPEN_USER_QZONE_HOME)) {
                    handleJumpToQzone(jSONObject, jSContext);
                    return;
                }
                if (optString.equals(IMPORT_GROUP_AIO)) {
                    handleChatAio(jSONObject, jSContext);
                    return;
                }
                if (optString.equals(SHOW_GROUP_PHOTO_BROWSER)) {
                    handleShowPhotoList(jSONObject, jSContext);
                    return;
                }
                if (optString.equals(JUMP_GROUP_ALBUM_SEND_BOX)) {
                    handleJumpToPublishBox(jSContext);
                    return;
                }
                if (optString.equals(DOWNLOAD_GROUP_ALBUM_PHOTO)) {
                    handleDownloadPic(jSONObject, jSContext);
                    return;
                }
                if (optString.equals(JUMP_CATEGORY_ALBUM)) {
                    handleJumpCategoryAlbum(jSONObject, jSContext);
                } else if (optString.equals(PICK_QZONE_ALBUM)) {
                    handleQunDidPickAlbum(jSONObject, jSContext);
                } else if (optString.equals(QZONE_ALBUM_START)) {
                    handleQunStartAlbum(jSONObject, jSContext);
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "handleGroupUploadPhoto,decode param error");
                }
            }
        }
    }

    private void handleShowPhotoList(JSONObject jSONObject, JSContext jSContext) throws JSONException {
        if (System.currentTimeMillis() - this.lastClickTime < 2000) {
            QLog.d(TAG, 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        int i3 = jSONObject2.getInt("groupID");
        String optString = jSONObject2.optString("albumID");
        String optString2 = jSONObject2.optString("photoID");
        String optString3 = jSONObject2.optString("uin");
        String optString4 = jSONObject2.optString("bigurl");
        long optLong = jSONObject2.optLong("uin");
        int optInt = jSONObject2.optInt(BaseProfileQZoneComponent.KEY_IS_VIDEO);
        int optInt2 = jSONObject2.optInt("orgVideoSize");
        int optInt3 = jSONObject2.optInt("videoWidth");
        int optInt4 = jSONObject2.optInt("videoHeight");
        String optString5 = jSONObject2.optString("videoURL");
        String optString6 = jSONObject2.optString("videoID");
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = optString3;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.bigUrl = optString4;
        photoInfo.uploaduin = optLong;
        photoInfo.albumId = optString;
        photoInfo.lloc = optString2;
        photoInfo.appid = i3;
        photoInfo.videoflag = optInt;
        VideoInfo videoInfo = new VideoInfo();
        photoInfo.videodata = videoInfo;
        videoInfo.videoId = optString6;
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = optString4;
        photoInfo.videodata.coverUrl = pictureUrl;
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = optString5;
        VideoInfo videoInfo2 = photoInfo.videodata;
        videoInfo2.originVideoSize = optInt2;
        videoInfo2.videoId = optString6;
        videoInfo2.actionUrl = optString5;
        videoInfo2.videoUrl = videoUrl;
        videoInfo2.width = optInt3;
        videoInfo2.height = optInt4;
        videoInfo2.videoStatus = 5;
        arrayList.add(photoInfo);
        PhotoParam photoParam = new PhotoParam();
        photoParam.albumid = optString;
        photoParam.cell_id = optString;
        bundle.putSerializable("picturelist", arrayList);
        bundle.putInt("curindex", 0);
        bundle.putInt("mode", 13);
        bundle.putBoolean("need_clear_cache", true);
        QZoneHelper.forwardToPictureViewer(jSContext.getActivity(), userInfo, bundle, 6);
        this.lastClickTime = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
