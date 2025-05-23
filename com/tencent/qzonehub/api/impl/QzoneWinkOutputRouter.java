package com.tencent.qzonehub.api.impl;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b93.OutputData;
import com.qzone.preview.service.PictureManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.media.QZoneMediaWrapper;
import cooperation.qzone.util.QZLog;
import ho.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class QzoneWinkOutputRouter implements b93.a {
    private static final String CLS_QZONE_PICTURE_MANAGER = "com.qzone.preview.service.PictureManager";
    private static final String METHOD_REMOVE_PIC = "removeSelectPic";
    public static final String ROUTE_PATH = "/wink/output/qzone";
    public static final String TAG = "QzoneWinkOutputRouter";

    private Intent getFullMediaPickerDataIntent(Bundle bundle, List<LocalMediaInfo> list, HashMap<String, PicInfo> hashMap) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        for (LocalMediaInfo localMediaInfo : list) {
            if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.missionID) && QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                localMediaInfo.path = yk.b.o(localMediaInfo.missionID);
            }
        }
        ArrayList<String> b16 = a.b(list);
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(list));
        intent.putExtra("PhotoConst.WINK_MEDIA_PICKER_PATHS", b16);
        intent.putExtra("PhotoConst.WINK_MEDIA_PICKER_QZONE_PICS", hashMap);
        intent.putExtra("PhotoConst.IS_FROM_WINK_MEDIA_PICKER", true);
        return intent;
    }

    private void handleCaptureResult(Context context, OutputData outputData) {
        QZLog.d(TAG, 1, "[handleCaptureResult]");
        if (context == null) {
            QZLog.w(TAG, 1, "[handleExportResult] no context");
            return;
        }
        if (outputData.e().isEmpty()) {
            QZLog.d(TAG, 1, "[handleExportResult] no medias");
            return;
        }
        Intent intent = new Intent();
        if (outputData.getBundle() != null) {
            intent.putExtras(outputData.getBundle());
        }
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(outputData.e()));
        intent.putExtra("PhotoConst.IS_FROM_CIRCLE_TAKE_PIC", true);
        jumpToActivity(context, intent, false);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    private void handleExportResult(Context context, OutputData outputData) {
        QZLog.d(TAG, 1, "[handleExportResult]");
        if (context == null) {
            QZLog.w(TAG, 1, "[handleExportResult] no context");
            return;
        }
        if (outputData.e().isEmpty()) {
            QZLog.d(TAG, 1, "[handleExportResult] no medias");
            return;
        }
        Intent intent = new Intent();
        if (outputData.getBundle() != null) {
            intent.putExtras(outputData.getBundle());
        }
        ArrayList arrayList = new ArrayList(outputData.e());
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (outputData.d() != null) {
            Iterator<LocalMediaInfo> it = outputData.d().iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().path);
            }
            if (!arrayList.isEmpty() && arrayList.get(0) != null) {
                ((LocalMediaInfo) arrayList.get(0)).mOriginPath = arrayList2;
            }
        }
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, arrayList);
        intent.putExtra("PhotoConst.IS_FROM_CIRCLE_EDIT", true);
        if (intent.getBooleanExtra(QQWinkConstants.QZONE_EDIT, false)) {
            Activity activity = (Activity) context;
            activity.setResult(-1, intent);
            activity.finish();
            return;
        }
        try {
            jumpToActivity(context, intent, false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleExportResult  e = " + e16);
            xe.b.f447841a.d(e16);
        }
    }

    private void handleMediaPickerResult(Context context, OutputData outputData) {
        QZLog.d(TAG, 1, "[handleMediaPickerResult]");
        if (context == null) {
            return;
        }
        List<LocalMediaInfo> e16 = outputData.e();
        if (outputData.getBundle() != null && QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_RECOMMEND.equals(outputData.getBundle().getString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME))) {
            String string = outputData.getBundle().getString(QQWinkConstants.QZONE_RECOMMEND_TEMPLATE_ID);
            QZLog.i(TAG, 1, "[handleMediaPickerResult ] from recommend" + string);
            if (e16.size() == 0) {
                QZLog.i(TAG, 1, "no  selectedMedias");
                return;
            }
            i.y().k(context, string, e16.get(0).path, e16, "", 35);
            if (context instanceof Activity) {
                ((Activity) context).finish();
                return;
            }
            return;
        }
        jumpToActivity(context, getFullMediaPickerDataIntent(outputData.getBundle(), e16, retrievePicInfoMap(e16)), false);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
        ((IWinkAPI) QRoute.api(IWinkAPI.class)).exitWink(true, 0, null);
    }

    private void handlePreviewDelete(Context context, OutputData outputData) {
        QZLog.d(TAG, 1, "[handlePreviewDelete]");
        List<LocalMediaInfo> e16 = outputData.e();
        if (e16 != null && !e16.isEmpty() && e16.get(0) != null) {
            removeSelectMedia(context, e16.get(0).path);
        } else {
            QZLog.w(TAG, 1, "[handlePreviewDelete] no output media");
        }
    }

    public static void removeSelectMedia(Context context, String str) {
        Class<PictureManager> cls;
        if (context == null) {
            return;
        }
        try {
            try {
                cls = PictureManager.class;
                boolean z16 = PictureManager.needDownloadReport;
            } catch (ClassNotFoundException e16) {
                QLog.e(TAG, 1, "ClassNotFoundException error:" + e16);
                cls = null;
            }
            if (cls == null) {
                QLog.e(TAG, 1, "removeSelectMedia load class fail");
            } else {
                cls.getMethod(METHOD_REMOVE_PIC, String.class).invoke(null, str);
            }
        } catch (Exception e17) {
            QLog.e(TAG, 1, "removeSelectMedia error:" + e17);
        }
    }

    private HashMap<String, PicInfo> retrievePicInfoMap(List<LocalMediaInfo> list) {
        HashMap<String, PicInfo> hashMap = new HashMap<>();
        for (LocalMediaInfo localMediaInfo : list) {
            if (isQzoneAlbumMedia(localMediaInfo)) {
                hashMap.put((String) localMediaInfo.extData.get("extDownloadUrl"), transform2PicInfo(localMediaInfo));
            }
        }
        return hashMap;
    }

    private PicInfo transform2PicInfo(LocalMediaInfo localMediaInfo) {
        HashMap<String, Serializable> hashMap;
        PicInfo picInfo = new PicInfo();
        if (localMediaInfo != null && (hashMap = localMediaInfo.extData) != null) {
            picInfo.albumid = (String) hashMap.get("extAlbumId");
            picInfo.pictureid = (String) localMediaInfo.extData.get("extQZonePhotoId");
            picInfo.sloc = (String) localMediaInfo.extData.get("extQZoneMediaSloc");
            picInfo.pic_url = (String) localMediaInfo.extData.get("extDownloadUrl");
            picInfo.picwidth = localMediaInfo.mediaWidth;
            picInfo.picheight = localMediaInfo.mediaHeight;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("WINK_MEDIA_PICKER_SELECT_MEDIA_WIDTH", String.valueOf(localMediaInfo.mediaWidth));
            hashMap2.put("WINK_MEDIA_PICKER_SELECT_MEDIA_HEIGHT", String.valueOf(localMediaInfo.mediaHeight));
            hashMap2.put("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_URL", String.valueOf((String) localMediaInfo.extData.get("extThunbUrl")));
            hashMap2.put("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_WIDTH", String.valueOf(localMediaInfo.thumbWidth));
            hashMap2.put("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO_THUMB_HEIGHT", String.valueOf(localMediaInfo.thumbWidth));
            picInfo.pic_extend = hashMap2;
        }
        return picInfo;
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return false;
    }

    @Override // b93.a
    public void onOutput(Context context, OutputData outputData) {
        long outputPoint = outputData.getOutputPoint();
        QLog.d(TAG, 1, "[onOutput] outputPoint:" + outputPoint);
        if (outputPoint == 1) {
            handleMediaPickerResult(context, outputData);
            return;
        }
        if (outputPoint == 2 || outputPoint == 4) {
            handleExportResult(context, outputData);
            return;
        }
        if (outputPoint == 8 || outputPoint == 16) {
            handleCaptureResult(context, outputData);
        } else if (outputPoint == 32) {
            handlePreviewDelete(context, outputData);
        }
    }

    @Override // b93.a
    public void onBack(Context context, Bundle bundle) {
        QLog.d(TAG, 1, "[onBack]");
    }

    private boolean isQzoneAlbumMedia(LocalMediaInfo localMediaInfo) {
        String str;
        String str2;
        HashMap<String, Serializable> hashMap;
        if (localMediaInfo == null || (hashMap = localMediaInfo.extData) == null) {
            str = null;
            str2 = null;
        } else {
            str = (String) hashMap.get("extQZonePhotoId");
            str2 = (String) localMediaInfo.extData.get("extDownloadUrl");
        }
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    private void jumpToActivity(Context context, Intent intent, boolean z16) {
        if (context == null || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String stringExtra2 = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
        String stringExtra3 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        String stringExtra4 = intent.getStringExtra("public_origin_fragment_class");
        if (!TextUtils.isEmpty(stringExtra4)) {
            intent.putExtra("public_fragment_class", stringExtra4);
        }
        QLog.d(TAG, 1, "jumpToActivity   | initClassName = " + stringExtra + " | destClassName = " + stringExtra2 + " | packageName = " + stringExtra3 + " | originFragmentClass = " + stringExtra4);
        if (intent.getBooleanExtra(QZoneMediaWrapper.IS_FROM_QZONE_ACTIVITY, true)) {
            String stringExtra5 = intent.getStringExtra("PhotoConst.UIN");
            if (!TextUtils.isEmpty(stringExtra2) && !z16) {
                QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra2);
            } else {
                QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra);
            }
            intent.addFlags(603979776);
            QZoneHelper.launchQZone((Activity) context, stringExtra5, intent, -1);
            return;
        }
        intent.setClassName(stringExtra3, stringExtra);
        intent.addFlags(603979776);
        context.startActivity(intent);
    }
}
