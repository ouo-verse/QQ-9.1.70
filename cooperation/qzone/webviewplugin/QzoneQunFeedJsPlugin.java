package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ag;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
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
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import ho.i;
import java.util.ArrayList;
import org.json.JSONObject;
import rk.e;
import rk.g;

/* loaded from: classes38.dex */
public class QzoneQunFeedJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String ACTION_HANDLE_QUN_DETAIL_DELETE = "cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete";
    public static final String NAMESPACE = "Qzone";
    public static final String TAG = "QzoneQunFeedJsPlugin";
    private static String pickCallBack = "";
    Dialog mDownloadingDialog;
    private QQCustomDialog openDialog;
    private Handler handler = new Handler();
    private BroadcastReceiver unReadMsgBrocastReceiver = new BroadcastReceiver() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(QZoneHelper.BROADCAST_SYNC_QUN_UNREAD_MESSAGE)) {
                QzoneQunFeedJsPlugin.this.setUnReadMsgNum(intent.getIntExtra(QZoneHelper.ACTION_UNREAD_COUNT, 0));
            }
        }
    };
    long lastClickTime = 0;
    private String cacheArgs = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin$2, reason: invalid class name */
    /* loaded from: classes38.dex */
    public class AnonymousClass2 implements WebEventListener {
        final /* synthetic */ String[] val$args;

        AnonymousClass2(String[] strArr) {
            this.val$args = strArr;
        }

        @Override // cooperation.qzone.remote.logic.WebEventListener
        public void onWebEvent(String str, Bundle bundle) {
            if (RemoteHandleConst.CMD_TROOP_DOWNLOAD_PHOTO.equals(str)) {
                Bundle bundle2 = bundle.getBundle("data");
                boolean z16 = bundle2.getBoolean("isOpenVip");
                String[] strArr = this.val$args;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                if (z16) {
                    QzoneQunFeedJsPlugin.this.handler.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            QzoneQunFeedJsPlugin.this.cacheArgs = anonymousClass2.val$args[0];
                            Activity a16 = QzoneQunFeedJsPlugin.this.parentPlugin.mRuntime.a();
                            if (QzoneQunFeedJsPlugin.this.openDialog == null) {
                                QzoneQunFeedJsPlugin.this.openDialog = DialogUtil.createCustomDialog(a16, 230).setTitle(HardCodeUtil.qqStr(R.string.s76)).setMessage(HardCodeUtil.qqStr(R.string.s7_)).setPositiveButton(HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        dialogInterface.dismiss();
                                        String account = QzoneQunFeedJsPlugin.this.parentPlugin.mRuntime.b().getAccount();
                                        Intent intent = new Intent();
                                        String string = QzoneQunFeedJsPlugin.this.parentPlugin.mRuntime.a().getResources().getString(R.string.gdd);
                                        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.OPEN_VIP);
                                        intent.putExtra("aid", "jhan_plxz");
                                        intent.putExtra("success_tips", string);
                                        intent.putExtra("direct_go", true);
                                        QzonePluginProxyActivity.launchPluingActivityForResult(QzoneQunFeedJsPlugin.this.parentPlugin.mRuntime.a(), account, intent, 4);
                                    }
                                }).setNegativeButton(a16.getString(R.string.gmi), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        dialogInterface.dismiss();
                                    }
                                });
                            }
                            if (QzoneQunFeedJsPlugin.this.openDialog.isShowing()) {
                                return;
                            }
                            QzoneQunFeedJsPlugin.this.openDialog.show();
                        }
                    });
                    return;
                }
                bundle2.getInt("totalNum");
                int i3 = bundle2.getInt("successNum");
                int i16 = bundle2.getInt("failNum");
                boolean z17 = bundle2.getBoolean("isDownloadCanceled");
                QzoneQunFeedJsPlugin.this.alertDownloadErrorCount(i3, i16, bundle2.getString("path"), z17);
            }
        }
    }

    /* loaded from: classes38.dex */
    public static class LoadingDialog extends ReportDialog {
        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(QzoneQunFeedJsPlugin.TAG, 2, e16, new Object[0]);
                }
            }
        }

        public void setTitle(String str) {
            ((TextView) findViewById(R.id.title)).setText(str);
        }

        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
        public void show() {
            try {
                super.show();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(QzoneQunFeedJsPlugin.TAG, 2, e16, new Object[0]);
                }
            }
        }

        @Override // android.app.Dialog
        public void setTitle(int i3) {
            setTitle(i3 == 0 ? null : getContext().getResources().getString(i3));
        }

        LoadingDialog(Context context) {
            super(context, R.style.f174063on);
            setContentView(R.layout.f169003bk1);
            getWindow().setFlags(1024, 2048);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertDownloadErrorCount(int i3, int i16, String str, boolean z16) {
        String str2;
        Activity a16 = this.parentPlugin.mRuntime.a();
        Dialog dialog = this.mDownloadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDownloadingDialog.dismiss();
        }
        if (z16) {
            return;
        }
        if (i16 > 0) {
            if (i3 > 0) {
                str2 = (String.format(a16.getString(R.string.gmn), Integer.valueOf(i3)) + "\uff0c") + str + HardCodeUtil.qqStr(R.string.s7c);
            } else {
                str2 = "";
            }
            DialogUtil.createCustomDialog(a16, 232).setMessage(str2 + String.format(a16.getString(R.string.gmg), Integer.valueOf(i16))).setNegativeButton(R.string.gml, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i17) {
                    dialogInterface.dismiss();
                }
            }).show();
            return;
        }
        ToastUtil.a().e(a16.getString(R.string.gmo) + str + HardCodeUtil.qqStr(R.string.s7b));
    }

    private void cancelDownload(String str) {
        RemoteHandleManager.getInstance().getSender().cancelDownloadTroopPhoto(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDownloadPicture(String str) {
        RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(str);
    }

    private void handleEndQunRedPointNotify(String... strArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleEndQunRedPointNotify");
        }
    }

    private void handleHideTopicComment(String... strArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleHideTopicComment");
        }
    }

    private void handleImportGroupAio(String... strArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleGroupUploadPhoto " + strArr[0]);
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            jSONObject.getInt("groupCode");
            jSONObject.optString("albumid");
            jSONObject.optString("albumname");
            this.parentPlugin.mRuntime.b().getAccount();
            this.parentPlugin.mRuntime.a();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleImportGroupAio,decode param error");
            }
        }
    }

    private void handleQunDetailDelete(String... strArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleQunDetailDelete ");
        }
        try {
            this.parentPlugin.mRuntime.a().sendBroadcast(new Intent("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete"));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleQunDetailDelete exception:" + e16);
            }
        }
    }

    private void handleQunJumpDetail(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleQunJumpDetail " + strArr[0]);
        }
        try {
            String string = new JSONObject(strArr[0]).getString("url");
            Intent intent = new Intent(this.parentPlugin.mRuntime.a(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", string);
            intent.putExtra("fromQZone", true);
            intent.putExtra("injectrecommend", true);
            if (ag.f314191a.containsKey("Qzone")) {
                intent.putExtra("insertPluginsArray", new String[]{"Qzone"});
            }
            intent.putExtra("source_name", this.parentPlugin.mRuntime.a().getString(R.string.ghh));
            intent.setData(Uri.parse(string));
            this.parentPlugin.startActivityForResult(intent, (byte) 0);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleQunJumpDetail,decode param error");
            }
        }
    }

    private boolean isSdcardWorking() {
        return SDCardMountMonitorReceiver.getInstance().isSDCardCanWrite();
    }

    private void registerUnreadMsgReceiver() {
        try {
            this.parentPlugin.mRuntime.a().registerReceiver(this.unReadMsgBrocastReceiver, new IntentFilter(QZoneHelper.BROADCAST_SYNC_QUN_UNREAD_MESSAGE));
        } catch (Exception e16) {
            QLog.w(TAG, 1, "registerUnreadMsgReceiver----", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnReadMsgNum(int i3) {
        WebViewPlugin.b bVar;
        CustomWebView e16;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || (e16 = bVar.e()) == null) {
            return;
        }
        e16.callJs("window.QZQunRedPointInterface.onReceive({data:" + i3 + "});");
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.StartQunRedPointNotify)) {
                handleStartQunRedPointNotify(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.EndQunRedPointNotify)) {
                handleEndQunRedPointNotify(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.GroupUploadPhoto)) {
                handleGroupUploadPhoto(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.QunDownloadPhoto)) {
                handleQunDownloadPhoto(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.GroupQuote)) {
                handleGroupQuote(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.QunDidPickAlbum)) {
                handleQunDidPickAlbum(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.QunPickQzoneAlbum)) {
                handleQunPickQzoneAlbum(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.HideTopicComment)) {
                handleHideTopicComment(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.QunJumpDetail)) {
                handleQunJumpDetail(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.QunDetailDelete)) {
                handleQunDetailDelete(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.ShowGroupPhotoBrowser)) {
                handleShowPhotoList(strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.QZoneQunFeedJsConstants.ImportGroupAio)) {
                handleImportGroupAio(strArr);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void initRuntime(WebViewPlugin webViewPlugin) {
        WebViewPlugin.b bVar;
        super.initRuntime(webViewPlugin);
        registerUnreadMsgReceiver();
        SDCardMountMonitorReceiver.getInstance().registerReceiver();
        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.a() == null) {
            return;
        }
        webViewPlugin.mRuntime.a().setResult(50);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        try {
            this.parentPlugin.mRuntime.a().unregisterReceiver(this.unReadMsgBrocastReceiver);
            SDCardMountMonitorReceiver.getInstance().unregisterReceiver();
        } catch (Exception unused) {
        }
    }

    private void handleGroupUploadPhoto(String... strArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleGroupUploadPhoto " + strArr[0]);
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long j3 = jSONObject.getLong("groupCode");
            String optString = jSONObject.optString("albumid");
            QZoneHelper.forwardMiniToTroopUploadPhoto(this.parentPlugin.mRuntime.a(), this.parentPlugin.mRuntime.b().getAccount(), !TextUtils.isEmpty(optString) ? 2 : 1, 1, j3, "", optString, jSONObject.optString("albumname"), 7001, 43);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleGroupUploadPhoto,decode param error");
            }
        }
    }

    private void handleQunDidPickAlbum(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleQunDidPickAlbum " + strArr[0]);
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String string = jSONObject.getString("albumid");
            String optString = jSONObject.optString("albumname");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("UploadPhoto.key_album_id", string);
            bundle.putString("UploadPhoto.key_album_name", optString);
            intent.putExtras(bundle);
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (a16 == null || a16.isFinishing()) {
                return;
            }
            a16.setResult(-1, intent);
            a16.finish();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleQunDidPickAlbum,decode param error");
            }
        }
    }

    private void handleQunDownloadPhoto(final String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleQunDownloadPhoto " + strArr[0]);
        }
        new Intent().putExtra("photos", strArr[0]);
        RemoteHandleManager.getInstance().addWebEventListener(new AnonymousClass2(strArr));
        if (!isSdcardWorking()) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.s7a));
            return;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.s78));
        } else if (!NetworkState.isWifiConn()) {
            Activity a16 = this.parentPlugin.mRuntime.a();
            DialogUtil.createCustomDialog(a16, 230).setTitle(a16.getString(R.string.gmk)).setMessage(a16.getString(R.string.gmm)).setPositiveButton(a16.getString(R.string.gmj), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    QzoneQunFeedJsPlugin.this.doDownloadPicture(strArr[0]);
                }
            }).setNegativeButton(a16.getString(R.string.gmi), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }).show();
        } else {
            doDownloadPicture(strArr[0]);
        }
    }

    private void handleQunPickQzoneAlbum(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleQunPickQzoneAlbum " + strArr[0]);
        }
        try {
            pickCallBack = new JSONObject(strArr[0]).getString("callback");
            Bundle bundle = new Bundle();
            bundle.putInt("key_personal_album_enter_model", 0);
            bundle.putBoolean(QZoneHelper.QZoneAlbumConstants.KEY_PASS_RESULT_BY_BUNDLE, true);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = this.parentPlugin.mRuntime.b().getCurrentAccountUin();
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            Activity a16 = this.parentPlugin.mRuntime.a();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            QZoneHelper.forwardToPersonalAlbumSelect(a16, userInfo, bundle, QZoneHelperProxyImpl.generateRequestCode(webViewPlugin, webViewPlugin.mRuntime, 6));
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleQunPickQzoneAlbum,decode param error");
            }
        }
    }

    private void handleShowPhotoList(String... strArr) {
        String str;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        long optLong;
        int optInt;
        int optInt2;
        int optInt3;
        int optInt4;
        String optString5;
        String optString6;
        QZoneHelper.UserInfo userInfo;
        Bundle bundle;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleGroupUploadPhoto " + strArr[0]);
        }
        if (System.currentTimeMillis() - this.lastClickTime < 2000) {
            QLog.d(TAG, 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            optString = jSONObject.optString("groupID");
            optString2 = jSONObject.optString("albumID");
            optString3 = jSONObject.optString("photoID");
            String optString7 = jSONObject.optString("uin");
            optString4 = jSONObject.optString("bigurl");
            optLong = jSONObject.optLong("uin");
            optInt = jSONObject.optInt(BaseProfileQZoneComponent.KEY_IS_VIDEO);
            optInt2 = jSONObject.optInt("orgVideoSize");
            optInt3 = jSONObject.optInt("videoWidth");
            optInt4 = jSONObject.optInt("videoHeight");
            optString5 = jSONObject.optString("videoURL");
            optString6 = jSONObject.optString("videoID");
            userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = optString7;
            bundle = new Bundle();
            str = TAG;
        } catch (Exception unused) {
            str = TAG;
        }
        try {
            ArrayList<PhotoInfo> arrayList = new ArrayList<>();
            PhotoInfo photoInfo = new PhotoInfo();
            photoInfo.bigUrl = optString4;
            photoInfo.uploaduin = optLong;
            photoInfo.albumId = optString2;
            photoInfo.lloc = optString3;
            photoInfo.groupId = optString;
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
            photoParam.albumid = optString2;
            photoParam.cell_id = optString2;
            bundle.putSerializable("picturelist", arrayList);
            bundle.putInt("curindex", 0);
            bundle.putInt("mode", 13);
            bundle.putBoolean("need_clear_cache", true);
            g gVar = new g();
            ImageView imageView = new ImageView(this.parentPlugin.mRuntime.a());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight()));
            gVar.i(6);
            gVar.l(bundle);
            gVar.m(arrayList);
            gVar.f(imageView);
            gVar.n(userInfo);
            gVar.g(0);
            ((e) i.t(e.class)).u(this.parentPlugin.mRuntime.a(), gVar);
            this.lastClickTime = System.currentTimeMillis();
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.w(str, 2, "handleGroupUploadPhoto,decode param error");
            }
        }
    }

    private void handleStartQunRedPointNotify(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleStartQunRedPointNotify " + strArr[0]);
        }
        try {
            int groupGroupNewsInfo = ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(this.parentPlugin.mRuntime.b().getAccount(), ITroopSPUtilApi.KEY_ALBUM_MESSAGE, String.valueOf(new JSONObject(strArr[0]).getInt("groupCode")));
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "handleStartQunRedPointNotify data=" + groupGroupNewsInfo);
            }
            setUnReadMsgNum(groupGroupNewsInfo);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleStartQunRedPointNotify,decode param error");
            }
        }
    }

    private void handleGroupQuote(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        int i3 = 4;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleGroupQuote " + strArr[0]);
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i16 = jSONObject.getInt("groupCode");
            String optString = jSONObject.optString("albumid");
            String optString2 = jSONObject.optString("albumname");
            String account = this.parentPlugin.mRuntime.b().getAccount();
            if (TextUtils.isEmpty(optString)) {
                i3 = 3;
            }
            QZoneHelper.forwardToTroopUploadPhoto(this.parentPlugin.mRuntime.a(), account, i3, 4, i16, "", optString, optString2, 7001, 43);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handleGroupUploadPhoto,decode param error");
            }
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (b16 == 4) {
            if (i3 == -1) {
                this.handler.postDelayed(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.6
                    @Override // java.lang.Runnable
                    public void run() {
                        QzoneQunFeedJsPlugin qzoneQunFeedJsPlugin = QzoneQunFeedJsPlugin.this;
                        qzoneQunFeedJsPlugin.doDownloadPicture(qzoneQunFeedJsPlugin.cacheArgs);
                    }
                }, 2000L);
                return;
            }
            return;
        }
        if (b16 != 6 || TextUtils.isEmpty(pickCallBack) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ID);
        String stringExtra2 = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_NAME);
        String stringExtra3 = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_COVER);
        int intExtra = intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_PERMISSION, 0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{albumid:\"");
        sb5.append(stringExtra);
        sb5.append("\",albumname:\"");
        sb5.append(stringExtra2);
        sb5.append("\",albumcover:\"");
        sb5.append(stringExtra3);
        sb5.append("\",albumpermission:");
        sb5.append(intExtra);
        sb5.append("}");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, sb5.toString());
        }
        this.parentPlugin.callJs(pickCallBack, sb5.toString());
    }
}
