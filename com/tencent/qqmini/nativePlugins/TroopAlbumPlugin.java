package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
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

@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class TroopAlbumPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private QQCustomDialog f346963d;

    /* renamed from: e, reason: collision with root package name */
    Dialog f346964e;

    /* renamed from: h, reason: collision with root package name */
    private RequestEvent f346966h;

    /* renamed from: f, reason: collision with root package name */
    private String f346965f = null;

    /* renamed from: i, reason: collision with root package name */
    private long f346967i = 0;

    /* renamed from: m, reason: collision with root package name */
    private BroadcastReceiver f346968m = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.nativePlugins.TroopAlbumPlugin$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    public class AnonymousClass2 implements WebEventListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f346969d;

        AnonymousClass2(String str) {
            this.f346969d = str;
        }

        @Override // cooperation.qzone.remote.logic.WebEventListener
        public void onWebEvent(String str, Bundle bundle) {
            if (RemoteHandleConst.CMD_TROOP_DOWNLOAD_PHOTO.equals(str)) {
                Bundle bundle2 = bundle.getBundle("data");
                if (bundle2.getBoolean("isOpenVip")) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1

                        /* renamed from: com.tencent.qqmini.nativePlugins.TroopAlbumPlugin$2$1$a */
                        /* loaded from: classes34.dex */
                        class a implements DialogInterface.OnClickListener {
                            a() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                dialogInterface.dismiss();
                            }
                        }

                        /* renamed from: com.tencent.qqmini.nativePlugins.TroopAlbumPlugin$2$1$b */
                        /* loaded from: classes34.dex */
                        class b implements DialogInterface.OnClickListener {
                            b() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                dialogInterface.dismiss();
                                String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
                                Intent intent = new Intent();
                                String string = ((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity().getResources().getString(R.string.gdd);
                                QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.OPEN_VIP);
                                intent.putExtra("aid", "jhan_plxz");
                                intent.putExtra("success_tips", string);
                                intent.putExtra("direct_go", true);
                                QzonePluginProxyActivity.launchPluingActivityForResult(((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity(), account, intent, 4);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TroopAlbumPlugin.this.f346965f = anonymousClass2.f346969d;
                            Activity attachActivity = ((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity();
                            if (TroopAlbumPlugin.this.f346963d == null) {
                                TroopAlbumPlugin.this.f346963d = DialogUtil.createCustomDialog(attachActivity, 230).setTitle(HardCodeUtil.qqStr(R.string.uan)).setMessage(HardCodeUtil.qqStr(R.string.uam)).setPositiveButton(HardCodeUtil.qqStr(R.string.ket), new b()).setNegativeButton(attachActivity.getString(R.string.gmi), new a());
                            }
                            if (TroopAlbumPlugin.this.f346963d.isShowing()) {
                                return;
                            }
                            TroopAlbumPlugin.this.f346963d.show();
                        }
                    });
                    return;
                }
                bundle2.getInt("totalNum");
                int i3 = bundle2.getInt("successNum");
                int i16 = bundle2.getInt("failNum");
                boolean z16 = bundle2.getBoolean("isDownloadCanceled");
                String string = bundle2.getString("path");
                TroopAlbumPlugin troopAlbumPlugin = TroopAlbumPlugin.this;
                troopAlbumPlugin.r(((BaseJsPlugin) troopAlbumPlugin).mMiniAppContext.getAttachActivity(), i3, i16, string, z16);
            }
        }
    }

    /* loaded from: classes34.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("troop_upload".equals(intent.getAction())) {
                if (((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity() == null) {
                    QMLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, "Failed to handle troop_upload, activity is null");
                    return;
                }
                SharedPreferences.Editor edit = ((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).edit();
                JSONObject jSONObject = new JSONObject();
                int intExtra = intent.getIntExtra("count", 0);
                boolean booleanExtra = intent.getBooleanExtra("fail", false);
                try {
                    jSONObject.put("count", intExtra);
                    jSONObject.put("isFail", booleanExtra);
                    if (QLog.isColorLevel()) {
                        QLog.w(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "troopAlbumReceiver" + intExtra + ",isfail" + booleanExtra);
                    }
                    if (booleanExtra) {
                        edit.putBoolean(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, true).apply();
                    } else {
                        edit.putBoolean(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, false).apply();
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                TroopAlbumPlugin.this.sendSubscribeEvent("custom_event_groupAlbum_onGroupAlbumUpload", jSONObject.toString());
                if (intExtra == 0) {
                    edit.putBoolean(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, false).apply();
                    try {
                        ((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity().unregisterReceiver(TroopAlbumPlugin.this.f346968m);
                    } catch (IllegalArgumentException e17) {
                        QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "unregisterReceiver troopAlbumReceiver error!", e17);
                    }
                    TroopAlbumPlugin.this.f346966h = null;
                    return;
                }
                return;
            }
            if ("troop_select".equals(intent.getAction())) {
                QLog.w(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "troop_select recive");
                try {
                    TroopAlbumPlugin.this.f346966h.ok(new JSONObject("{albumid:\"" + intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ID) + "\",albumname:\"" + intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_NAME) + "\",albumcover:\"" + intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_COVER) + "\",albumpermission:" + intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_PERMISSION, 0) + "}"));
                    ((BaseJsPlugin) TroopAlbumPlugin.this).mMiniAppContext.getAttachActivity().unregisterReceiver(TroopAlbumPlugin.this.f346968m);
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f346976d;

        c(String str) {
            this.f346976d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(this.f346976d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    private void A(JSONObject jSONObject, RequestEvent requestEvent) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String optString = jSONObject2.optString("albumname");
        long j3 = jSONObject2.getLong("groupCode");
        String optString2 = jSONObject2.optString("albumid");
        QZoneHelper.forwardMiniToTroopUploadPhoto(this.mMiniAppContext.getAttachActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), !TextUtils.isEmpty(optString2) ? 2 : 1, 1, j3, "", optString2, optString, 7001, 43);
        this.f346966h = requestEvent;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("troop_upload");
        this.mMiniAppContext.getAttachActivity().registerReceiver(this.f346968m, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Activity activity, int i3, int i16, String str, boolean z16) {
        String str2;
        Dialog dialog = this.f346964e;
        if (dialog != null && dialog.isShowing()) {
            this.f346964e.dismiss();
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
            DialogUtil.createCustomDialog(activity, 232).setMessage(str2 + String.format(activity.getString(R.string.gmg), Integer.valueOf(i16))).setNegativeButton(R.string.gml, new d()).show();
            return;
        }
        ToastUtil.a().e(activity.getString(R.string.gmo) + str + HardCodeUtil.qqStr(R.string.uao));
    }

    private void s(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        jSONObject2.optString("albumname");
        jSONObject2.getInt("groupCode");
        jSONObject2.optString("albumid");
        this.mMiniAppContext.getAttachActivity();
    }

    private void t(JSONObject jSONObject) throws JSONException {
        Intent intent = new Intent();
        String jSONObject2 = jSONObject.getJSONObject("data").toString();
        intent.putExtra("photos", jSONObject2);
        RemoteHandleManager.getInstance().addWebEventListener(new AnonymousClass2(jSONObject2));
        if (!NetworkState.isNetSupport()) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.uaj));
        } else if (!NetworkState.isWifiConn()) {
            Activity attachActivity = this.mMiniAppContext.getAttachActivity();
            DialogUtil.createCustomDialog(attachActivity, 230).setTitle(attachActivity.getString(R.string.gmk)).setMessage(attachActivity.getString(R.string.gmm)).setPositiveButton(attachActivity.getString(R.string.gmj), new c(jSONObject2)).setNegativeButton(attachActivity.getString(R.string.gmi), new b()).show();
        } else {
            RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(jSONObject2);
        }
    }

    private void u(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        int optInt = jSONObject2.optInt("categoryType");
        String optString = jSONObject2.optString("categoryId");
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity != null) {
            QZoneHelper.forwardToCategoryAlbum(attachActivity, BaseApplicationImpl.sApplication.getRuntime().getAccount(), optInt, optString, -1);
        }
    }

    private void v() {
        QZoneHelper.UserInfo.getInstance();
        QZoneHelper.forwardToPublishBox(this.mMiniAppContext.getAttachActivity(), null, 0);
    }

    private void w(JSONObject jSONObject) throws JSONException {
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(this.mMiniAppContext.getAttachActivity(), jSONObject.getJSONObject("data").optLong("uin"), false, 0);
    }

    private void x(JSONObject jSONObject, RequestEvent requestEvent) {
        try {
            jSONObject.getJSONObject("data");
            Bundle bundle = new Bundle();
            bundle.putInt("key_personal_album_enter_model", 0);
            bundle.putBoolean(QZoneHelper.QZoneAlbumConstants.KEY_PASS_RESULT_BY_BUNDLE, true);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = BaseApplicationImpl.sApplication.getRuntime().getAccount();
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            QZoneHelper.forwardToPersonalAlbumSelect(this.mMiniAppContext.getAttachActivity(), userInfo, bundle, 100);
            this.f346966h = requestEvent;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("troop_select");
            this.mMiniAppContext.getAttachActivity().registerReceiver(this.f346968m, intentFilter);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "handleQunPickQzoneAlbum,decode param error");
            }
        }
    }

    private void y(JSONObject jSONObject) {
        try {
            boolean z16 = this.mMiniAppContext.getAttachActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).getBoolean(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.IS_EXIT_FAIL_MISSON, false);
            QLog.w(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "isExitFailMission:" + z16);
            if (z16) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("count", 1);
                jSONObject2.put("isFail", true);
                sendSubscribeEvent("custom_event_groupAlbum_onGroupAlbumUpload", jSONObject2.toString());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("troop_upload");
                this.mMiniAppContext.getAttachActivity().registerReceiver(this.f346968m, intentFilter);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "handleQunPickQzoneAlbum,decode param error");
            }
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.DOWNLOAD_GROUP_ALBUM_PHOTO})
    public void groupAlbumDownloadGroupAlbumPhoto(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_downloadGroupAlbumPhoto succeed");
            t(new JSONObject(requestEvent.jsonParams));
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_downloadGroupAlbumPhoto failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.GROUP_UPLOAD_PHOTO})
    public void groupAlbumGroupUploadPhoto(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_groupUploadPhoto succeed");
            A(new JSONObject(requestEvent.jsonParams), requestEvent);
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbumGroupUploadPhoto failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.IMPORT_GROUP_AIO})
    public void groupAlbumImportGroupAIO(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_importGroupAIO succeed");
            s(new JSONObject(requestEvent.jsonParams));
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_importGroupAIO failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.JUMP_CATEGORY_ALBUM})
    public void groupAlbumJumpCategoryAlbum(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_jumpCategoryAlbum succeed");
            u(new JSONObject(requestEvent.jsonParams));
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_jumpCategoryAlbum failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.JUMP_GROUP_ALBUM_SEND_BOX})
    public void groupAlbumJumpGroupAlbumSendBox(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_jumpGroupAlbumSendBox succeed");
            v();
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_jumpGroupAlbumSendBox failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.OPEN_USER_QZONE_HOME})
    public void groupAlbumOpenUserQzoneHome(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_openUserQzoneHome succeed");
            w(new JSONObject(requestEvent.jsonParams));
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_openUserQzoneHome failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.PICK_QZONE_ALBUM})
    public void groupAlbumPickQzoneAlbum(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_pickQzoneAlbum succeed");
            x(new JSONObject(requestEvent.jsonParams), requestEvent);
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_pickQzoneAlbum failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.SHOW_GROUP_PHOTO_BROWSER})
    public void groupAlbumShowGroupPhotoBrowser(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_showGroupPhotoBrowser succeed");
            z(new JSONObject(requestEvent.jsonParams), requestEvent);
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_showGroupPhotoBrowser failed, ", th5);
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.QZONE_ALBUM_START})
    public void groupAlbumStart(RequestEvent requestEvent) {
        try {
            QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 2, "groupAlbum_start succeed");
            y(new JSONObject(requestEvent.jsonParams));
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 1, "groupAlbum_start failed, ", th5);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (this.f346968m == null || this.mMiniAppContext.getAttachActivity() == null) {
            return;
        }
        try {
            this.mMiniAppContext.getAttachActivity().unregisterReceiver(this.f346968m);
        } catch (Throwable unused) {
        }
    }

    private void z(JSONObject jSONObject, RequestEvent requestEvent) throws JSONException {
        if (System.currentTimeMillis() - this.f346967i < 2000) {
            QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.TAG, 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.f346967i));
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String optString = jSONObject2.optString("groupID");
        String optString2 = jSONObject2.optString("albumID");
        String optString3 = jSONObject2.optString("photoID");
        String optString4 = jSONObject2.optString("uin");
        String optString5 = jSONObject2.optString("bigurl");
        long optLong = jSONObject2.optLong("uin");
        int optInt = jSONObject2.optInt(BaseProfileQZoneComponent.KEY_IS_VIDEO);
        int optInt2 = jSONObject2.optInt("orgVideoSize");
        int optInt3 = jSONObject2.optInt("videoWidth");
        int optInt4 = jSONObject2.optInt("videoHeight");
        String optString6 = jSONObject2.optString("videoURL");
        String optString7 = jSONObject2.optString("videoID");
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = optString4;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.bigUrl = optString5;
        photoInfo.uploaduin = optLong;
        photoInfo.albumId = optString2;
        photoInfo.lloc = optString3;
        photoInfo.groupId = optString;
        photoInfo.videoflag = optInt;
        VideoInfo videoInfo = new VideoInfo();
        photoInfo.videodata = videoInfo;
        videoInfo.videoId = optString7;
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = optString5;
        photoInfo.videodata.coverUrl = pictureUrl;
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = optString6;
        VideoInfo videoInfo2 = photoInfo.videodata;
        videoInfo2.originVideoSize = optInt2;
        videoInfo2.videoId = optString7;
        videoInfo2.actionUrl = optString6;
        videoInfo2.videoUrl = videoUrl;
        videoInfo2.width = optInt3;
        videoInfo2.height = optInt4;
        videoInfo2.videoStatus = 5;
        arrayList.add(photoInfo);
        PhotoParam photoParam = new PhotoParam();
        photoParam.albumid = optString2;
        photoParam.cell_id = optString2;
        bundle.putSerializable("picturelist", arrayList);
        bundle.putInt("curindex", 0);
        bundle.putInt("mode", 13);
        bundle.putBoolean("need_clear_cache", true);
        QZoneHelper.launchGroupAlbumGalleryLayer(this.mMiniAppContext.getAttachActivity(), userInfo, bundle, 6);
        this.f346967i = System.currentTimeMillis();
    }
}
