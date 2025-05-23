package cooperation.qzone.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationH5;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneMediaWrapper {
    public static final int DEFAULT_IMAGE_SIZE = 8388608;
    public static final String INTENT_IMAGE_SIZE_LIMIT = "imageSizeLimit";
    public static final String IS_FROM_QZONE_ACTIVITY = "is_from_qzone_activity";
    public static int MEDIA_TYPE_IMAGE = 0;
    public static final int NUMBER_1 = 1;
    private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
    private static final String TAG = "QZoneMediaApiPlugin-QZoneMediaWrapper";

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class PickConfig {
        public boolean needHeif = false;
        public int maxNum = 1;
        public int imageSizeLimit = 8388608;
        public int mediaType = QZoneMediaWrapper.MEDIA_TYPE_IMAGE;
    }

    private static Config.a getDefaultConfigBuilder() {
        Config.a aVar = new Config.a();
        aVar.k(true);
        return aVar;
    }

    public static Bundle getJumpBundle(Activity activity, QZoneMediaBusiness qZoneMediaBusiness) {
        Bundle bundle = new Bundle();
        QLog.d(TAG, 1, "getJumpBundle mediaBusiness\uff1a" + qZoneMediaBusiness);
        bundle.putString("app_key", "0AND0MWZXR4U3RVU");
        bundle.putString("xsj_ref_pgid", qZoneMediaBusiness.getBusinessName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putBoolean(IS_FROM_QZONE_ACTIVITY, false);
        bundle.putString("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 3L);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, true);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        QzonePluginProxyActivity.toExActivityWithResult(bundle);
        return bundle;
    }

    private static Config.a getPicConfigBuilder() {
        Config.a defaultConfigBuilder = getDefaultConfigBuilder();
        MediaFilter.a aVar = new MediaFilter.a();
        aVar.f(getPicSupportTypeList());
        defaultConfigBuilder.n(aVar.a());
        defaultConfigBuilder.o(aVar.a());
        defaultConfigBuilder.i(TabType.ONLY_IMAGE);
        return defaultConfigBuilder;
    }

    private static List<MediaMimeType> getPicSupportTypeList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediaMimeType.IMAGE_PNG);
        arrayList.add(MediaMimeType.IMAGE_WEBP);
        arrayList.add(MediaMimeType.IMAGE_GIF);
        arrayList.add(MediaMimeType.IMAGE_HEIF);
        arrayList.add(MediaMimeType.IMAGE_JPEG);
        return arrayList;
    }

    private static void jumpQQBasePicker(Activity activity, PickConfig pickConfig, WebViewPlugin webViewPlugin) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_CLASS_NAME);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(QAlbumConstants.SHOW_GIF_TYPE_ICON, true);
        intent.putExtra("NEED_HEIF", pickConfig.needHeif);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationH5.F);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", pickConfig.maxNum);
        if (pickConfig.maxNum == 1) {
            intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        }
        intent.putExtra("imageSizeLimit", pickConfig.imageSizeLimit);
        ao.c(webViewPlugin, intent, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, webViewPlugin.mRuntime.f());
    }

    public static ArrayList<String> getImagePathsFromQCircle(Intent intent) {
        ArrayList<LocalMediaInfo> mediaListFromQCircle;
        if (intent == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            mediaListFromQCircle = getMediaListFromQCircle(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getImagePathsFromQCircle error" + e16);
        }
        if (mediaListFromQCircle == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < mediaListFromQCircle.size(); i3++) {
            LocalMediaInfo localMediaInfo = mediaListFromQCircle.get(i3);
            if (localMediaInfo != null) {
                arrayList.add(localMediaInfo.path);
            }
        }
        return arrayList;
    }

    public static ArrayList<LocalMediaInfo> getMediaListFromQCircle(Intent intent) throws Exception {
        if (intent == null) {
            return new ArrayList<>();
        }
        return (ArrayList) intent.getSerializableExtra(QQWinkConstants.INPUT_MEDIA);
    }

    public static boolean isFromQCirclePicker(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("PhotoConst.IS_FROM_WINK_MEDIA_PICKER", false);
    }

    public static void goSelectPhoto(PickConfig pickConfig, QZoneMediaBusiness qZoneMediaBusiness, WebViewPlugin webViewPlugin) {
        if (pickConfig == null || webViewPlugin == null) {
            return;
        }
        if (pickConfig.mediaType != MEDIA_TYPE_IMAGE) {
            QZLog.i(TAG, "mediaType != MEDIA_TYPE_IMAGE");
            return;
        }
        Activity a16 = webViewPlugin.mRuntime.a();
        int i3 = pickConfig.maxNum;
        if (QZonePublishConfig.isUseQCirclePublish()) {
            WebViewProvider f16 = webViewPlugin.mRuntime.f();
            Bundle jumpBundle = getJumpBundle(f16.getHostActivity(), qZoneMediaBusiness);
            int switchRequestCode = f16.switchRequestCode(webViewPlugin, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
            jumpBundle.putString("keyAction", "actionSelectPicture");
            jumpBundle.putInt("requestCode", switchRequestCode);
            Config.a picConfigBuilder = getPicConfigBuilder();
            picConfigBuilder.j(i3);
            picConfigBuilder.i(TabType.ONLY_IMAGE);
            jumpBundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", picConfigBuilder.a());
            jumpBundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, i3, false, 0, 0, ""));
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(a16, jumpBundle);
            return;
        }
        jumpQQBasePicker(a16, pickConfig, webViewPlugin);
    }
}
