package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.ag;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qzonehub.api.IQZoneHelperProxy;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.video.VideoComponentCallback;
import ho.i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import rk.g;

/* loaded from: classes34.dex */
public class QZoneHelperProxyImpl implements IQZoneHelperProxy {
    public static final String ACTION_LAUNCH_PUBLISH_QUEUE = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
    public static final String ACTION_PRELOAD_QUN_ALBUM_FEEDS = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
    public static final String INTENT_QZONE_BOOT_SERVICE = "com.qzone.preview.service.PictureService";
    public static final String INTENT_QZONE_PUBLISHQUEUE_SERVICE = "com.qzone.publish.business.publishqueue.PublishQueueService";
    public static final String TAG = "QZoneHelperProxyImpl";

    /* loaded from: classes34.dex */
    class a extends DialogUtil.DialogOnClickAdapter {
        a() {
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes34.dex */
    class b extends DialogUtil.DialogOnClickAdapter {
        b() {
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public static void forwardToUploadPhoto(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, Activity activity, String str, String str2) {
        Intent intent = new Intent();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZoneHelper.UPLOAD_PHOTO);
        intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, 6);
        Bundle parseUrlParams = parseUrlParams(str2);
        intent.putExtra("IsBack", true);
        if (parseUrlParams.containsKey("albumid")) {
            intent.putExtra("UploadPhoto.key_album_id", parseUrlParams.getString("albumid"));
        }
        if (parseUrlParams.containsKey("albumtitle")) {
            intent.putExtra("UploadPhoto.key_album_name", parseUrlParams.getString("albumtitle"));
        }
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 1);
        intent.putExtras(parseUrlParams);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, str, intent, generateRequestCode(webViewPlugin, bVar, 1));
    }

    public static int generateRequestCode(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, int i3) {
        y d16 = bVar.d(bVar.a());
        return d16 instanceof af ? ((af) d16).switchRequestCode(webViewPlugin, (byte) i3) : i3;
    }

    private static PublishMoodInfo getPublishMoodInfo(String str, String str2, int i3) {
        PublishMoodInfo publishMoodInfo = new PublishMoodInfo();
        ArrayList<PublishMoodInfo.MediaInfo> arrayList = new ArrayList<>();
        PublishMoodInfo.MediaInfo mediaInfo = new PublishMoodInfo.MediaInfo();
        mediaInfo.mPath = str2;
        if (i3 == 4) {
            mediaInfo.mType = 2;
        } else {
            mediaInfo.mType = 1;
        }
        arrayList.add(mediaInfo);
        publishMoodInfo.mText = str;
        publishMoodInfo.mMediaInfo = arrayList;
        return (PublishMoodInfo) ((IMiniAppService) QRoute.api(IMiniAppService.class)).validMoodInfo(publishMoodInfo);
    }

    private boolean isRouteToQzoneTab() {
        return QQTheme.isNowSimpleUI() && QzoneFrame.isQZoneFrameViewEnable();
    }

    public static Bundle parseUrlParams(String str) {
        int indexOf;
        int i3;
        String[] split;
        Bundle bundle = new Bundle();
        if (str != null && (indexOf = str.indexOf(63)) >= 0 && (i3 = indexOf + 1) < str.length()) {
            String substring = str.substring(i3);
            if (!TextUtils.isEmpty(substring) && (split = substring.split(ContainerUtils.FIELD_DELIMITER)) != null) {
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2 != null && split2.length == 2) {
                        try {
                            bundle.putString(split2[0], URLDecoder.decode(split2[1], "UTF-8"));
                        } catch (UnsupportedEncodingException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }
        return bundle;
    }

    private static void publishMood(AppRuntime appRuntime, Activity activity, PublishMoodInfo publishMoodInfo, Intent intent, int i3, boolean z16) {
        if (activity != null && publishMoodInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putString("summary", publishMoodInfo.mText);
            bundle.putBoolean("key_need_save_draft", false);
            bundle.putString("shareSource", intent.getStringExtra("source"));
            bundle.putStringArrayList("images", publishMoodInfo.mAllImageAndVideo);
            bundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", publishMoodInfo.mMediaInfoHashMap);
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE));
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_SCHEME, intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME));
            if (z16) {
                bundle.putInt("key_max_photo_count", 1);
            }
            QZoneShareManager.publishToQzone((QQAppInterface) appRuntime, activity, bundle, null, i3);
            return;
        }
        QLog.i(TAG, 2, "handle moodInfo is null");
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void addQZoneStatis(Intent intent, int i3) {
        switch (i3) {
            case 1:
                intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_QQ_SET_PROFILE);
                return;
            case 2:
                intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_QQ_AVATAR);
                return;
            case 3:
                intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_QQ_QUANZI);
                return;
            case 4:
                intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_QQ_NEARBY);
                return;
            case 5:
                intent.putExtra("refer", "mqqChat");
                return;
            case 6:
                intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_QQ_QUN_SPACE);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void cleanAllQZconfig() {
        com.tencent.common.config.provider.b.a();
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public AppRuntime createQZoneMainRuntime(Context context, String str) {
        PerfTracer.traceStart(PerfTracer.RUNTIME_LOAD_MAIN_RUNTIME);
        if (context == null || str == null) {
            return null;
        }
        QzoneMainRuntime qzoneMainRuntime = new QzoneMainRuntime();
        PerfTracer.traceEnd(PerfTracer.RUNTIME_LOAD_MAIN_RUNTIME);
        return qzoneMainRuntime;
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void createShortcut(AppRuntime appRuntime, Intent intent, String str, Bitmap bitmap) {
        QQUtils.c((QQAppInterface) appRuntime, intent, str, bitmap);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void deleteAllH5Data(AppRuntime appRuntime) {
        ((IPublicAccountJavascriptInterface) QRoute.api(IPublicAccountJavascriptInterface.class)).deleteAllH5Data((AppInterface) appRuntime);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void forwardH5QZone(String str, Context context) {
        String string = LocalMultiProcConfig.getString(QZoneHelper.Constants.KEY_QZH5_URL, "");
        if (TextUtils.isEmpty(string)) {
            string = QZoneHelper.Constants.QZONE_H5_INFOCENTER_URL;
        }
        String str2 = string + "?sid=" + str;
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("plugin_start_time", System.nanoTime());
        intent.putExtra("click_start_time", System.currentTimeMillis());
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
        intent.putExtra("fromQZone", true);
        addSource(intent);
        context.startActivity(intent.putExtra("url", str2));
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void forwardToQzoneVideoCaptureNew(AppRuntime appRuntime, Activity activity, QZoneHelper.UserInfo userInfo, int i3, boolean z16, boolean z17, String str, String str2, boolean z18, boolean z19, String str3, boolean z26, String str4, String str5, boolean z27, boolean z28, boolean z29, boolean z36, String str6, boolean z37, boolean z38, boolean z39, int i16, boolean z46, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("edit_video_type", 10001);
        LocalMultiProcConfig.putBool("support_trim", z16);
        bundle2.putBoolean(ShortVideoConstants.ENABLE_EDIT_VIDEO, z19);
        bundle2.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, true);
        bundle2.putBoolean("is_qzone_vip", z18);
        bundle2.putString("set_user_callback", VideoComponentCallback.TAG);
        bundle2.putBoolean("flow_camera_video_mode", true);
        bundle2.putBoolean("flow_camera_capture_mode", z17);
        bundle2.putString("short_video_refer", str2);
        bundle2.putString("callback", str4);
        bundle2.putString("dongxiao_id", str5);
        bundle2.putString("topic_id", str3);
        bundle2.putBoolean("enter_ptu", z26);
        bundle2.putBoolean(AECameraConstants.KEY_ENABLE_INPUT_TEXT, z27);
        bundle2.putBoolean(AECameraConstants.KEY_ENABLE_PRIV_LIST, z28);
        bundle2.putBoolean("enable_sync_qzone", z29);
        bundle2.putBoolean("enable_origin_video", z36);
        bundle2.putString(AECameraConstants.KEY_CONFIRM_TEXT, str6);
        bundle2.putBoolean(AECameraConstants.KEY_ENABLE_EDIT_BUTTON, z37);
        bundle2.putBoolean("enable_local_button", z38);
        bundle2.putBoolean("is_glance_video", z39);
        if (z17) {
            bundle2.putString("qcamera_photo_filepath", PlusPanelUtils.n(AppConstants.SDCARD_IMG_CAMERA));
            bundle2.putInt(PeakConstants.BUSI_TYPE, 3);
            bundle2.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
            bundle2.putBoolean(PeakConstants.DIRECT_BACK_TO_QZONE, true);
            bundle2.putString(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, activity.getClass().getName());
            bundle2.putString(AECameraConstants.KEY_PIC_CONFIRM_TEXT, HardCodeUtil.qqStr(R.string.f133145b));
        }
        bundle2.putInt(PeakConstants.KEY_ENTRY_SOURCE, i16);
        bundle2.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, z46);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (gm2.b.d()) {
            ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).launch(activity, bundle2);
        } else {
            DialogUtil.createCustomDialog(activity, 230).setMessage(HardCodeUtil.qqStr(R.string.f133185f)).setPositiveButton(R.string.f171151ok, new a()).show();
        }
        activity.overridePendingTransition(R.anim.f155036hc, R.anim.f155033h9);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void forwardToWriteMood(Activity activity, AppRuntime appRuntime, Intent intent, int i3, boolean z16) {
        publishMood(appRuntime, activity, getPublishMoodInfo(intent.getStringExtra("summary"), intent.getStringExtra("filePath"), intent.getIntExtra("reqType", 1)), intent, i3, z16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public Intent getJumpQzoneTabIntent(Context context, Intent intent) {
        intent.setComponent(SplashActivity.getAliasComponent(context));
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183045h);
        intent.putExtra("open_qzone_tab_fragment", true);
        intent.setFlags(335544320);
        return intent;
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public Intent getQQBrowserActivityIntent(Context context) {
        if (BaseApplication.getContext() != null) {
            return new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        }
        return new Intent(context, (Class<?>) QQBrowserActivity.class);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public Intent getQZoneVideoDownloadActivityIntent(Context context) {
        return new Intent(context, (Class<?>) QZoneVideoDownloadActivity.class);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public int getQzoneManagerInQQManagerFactory() {
        return QQManagerFactory.QZONE_MANAGER;
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public QIPCModule getQzoneVideoSoDownloadModule() {
        return QzoneVideoSoDownloadModule.getInstance();
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public int getSendSizeSpecNOR() {
        return 0;
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public int getSendSizeSpecRAW() {
        return 3;
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public Intent getShortcutIntent(Context context) {
        return new Intent(context, (Class<?>) ShortcutGuideActivity.class);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public boolean getSimpleQZoneUISwitch() {
        return com.tencent.mobileqq.simpleui.b.c();
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public boolean isInQZoneEnvironment() {
        return QZoneApiProxy.isInQZoneEnvironment();
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void killQZoneProcess() {
        QZoneDistributedAppCtrl.killQZoneProcess();
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void putQzoneSourceName(Intent intent) {
        intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void putWebViewPluginPackageName(Intent intent) {
        if (ag.f314191a.containsKey("Qzone")) {
            intent.putExtra("insertPluginsArray", new String[]{"Qzone"});
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public int sendRemoteHandleManagerData(String str, Bundle bundle, boolean z16) {
        return RemoteHandleManager.getInstance().sendData(str, bundle, z16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void startTranslucentBrowserActivityForResult(Context context, String str, int i3, Bundle bundle, String str2, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.a().b(R.string.f132854j);
            QLog.w(TAG, 1, "browse url fail:" + str);
            return;
        }
        byte[] bytes = TextUtils.isEmpty(str2) ? null : str2.getBytes();
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("post_data", bytes);
        intent.putExtra("url", str);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.putExtra("isTransparentTitle", true);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, z16);
        intent.setData(Uri.parse(str));
        if (!z17) {
            intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            intent.setFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
        }
    }

    public static final void addSource(Intent intent) {
        if (intent != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_qzone");
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public boolean forwardToQZoneFriendFeedActivity(Context context, Intent intent, boolean z16) {
        try {
            String str = "";
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            }
            if (context == null || !isRouteToQzoneTab()) {
                if (z16 || context == null) {
                    return false;
                }
                if (context instanceof BasePluginActivity) {
                    QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.FRIEND_FEED);
                }
                ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, str, intent, 0);
                return true;
            }
            if ((context instanceof BaseActivity) && (QZoneApiProxy.isInQZoneEnvironment() || !QZoneApiProxy.needShowQzoneFrame((BaseActivity) context, ((BaseActivity) context).app))) {
                return false;
            }
            if (intent == null) {
                intent = new Intent();
            }
            if (context instanceof BasePluginActivity) {
                context = ((BasePluginActivity) context).getOutActivity();
            }
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, str, getJumpQzoneTabIntent(context, intent), 0);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "qzone start error" + th5);
            return false;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void bindQzonePublishQueueService(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        if (appRuntime == null) {
            return;
        }
        Intent publishQueueServiceIntent = QZoneHelper.getPublishQueueServiceIntent(appRuntime.getApp());
        publishQueueServiceIntent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
        publishQueueServiceIntent.setAction("com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE");
        if (QLog.isColorLevel()) {
            QLog.d("QPlugin", 2, "start and bind QzonePublishQueueService");
        }
        appRuntime.getApp().bindService(publishQueueServiceIntent, serviceConnection, 1);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void reportTroopAlbumExp() {
        LpReportInfo_pf00064.allReport(40, 3, 4);
    }

    public static void forwardToWriteMood(Activity activity, AppRuntime appRuntime, String str, String str2, int i3, String str3, int i16, boolean z16) {
        publishMood(appRuntime, activity, getPublishMoodInfo(str, str2, i3), str3, i16, z16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void launchQZoneGroupAlbumGalleryLayer(Activity activity, QZoneHelper.UserInfo userInfo, Bundle bundle, int i3) {
        if (bundle == null || activity == null) {
            return;
        }
        g gVar = new g();
        ImageView imageView = new ImageView(activity);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight()));
        gVar.i(6);
        gVar.l(bundle);
        try {
            gVar.m((ArrayList) bundle.getSerializable("picturelist"));
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, "exception is " + e16);
        }
        gVar.f(imageView);
        gVar.n(userInfo);
        gVar.g(0);
        ((rk.e) i.t(rk.e.class)).u(activity, gVar);
    }

    private static void publishMood(AppRuntime appRuntime, Activity activity, PublishMoodInfo publishMoodInfo, String str, int i3, boolean z16) {
        if (activity != null && publishMoodInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putString("summary", publishMoodInfo.mText);
            bundle.putBoolean("key_need_save_draft", false);
            bundle.putString("shareSource", str);
            bundle.putStringArrayList("images", publishMoodInfo.mAllImageAndVideo);
            bundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", publishMoodInfo.mMediaInfoHashMap);
            if (z16) {
                bundle.putInt("key_max_photo_count", 1);
            }
            QZoneShareManager.publishToQzone((QQAppInterface) appRuntime, activity, bundle, null, i3);
            return;
        }
        QLog.i(TAG, 2, "handle moodInfo is null");
    }

    @Override // com.tencent.qzonehub.api.IQZoneHelperProxy
    public void forwardToQzoneVideoCaptureNew(Activity activity, Bundle bundle, int i3) {
        if (gm2.b.d()) {
            activity.startActivityForResult(((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getLaunchIntent(activity, bundle), i3);
        } else if (!activity.isFinishing()) {
            DialogUtil.createCustomDialog(activity, 230).setMessage(HardCodeUtil.qqStr(R.string.f133185f)).setPositiveButton(R.string.f171151ok, new b()).show();
        }
        activity.overridePendingTransition(R.anim.f155036hc, R.anim.f155033h9);
    }
}
