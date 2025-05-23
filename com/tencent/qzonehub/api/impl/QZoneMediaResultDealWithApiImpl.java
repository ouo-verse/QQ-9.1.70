package com.tencent.qzonehub.api.impl;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qzonehub.api.IQZoneMediaResultDealWithApi;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneMediaResultDealWithApiImpl implements IQZoneMediaResultDealWithApi {
    private static final String CLS_QZONE_PICTURE_MANAGER = "com.qzone.preview.service.PictureManager";
    private static final String METHOD_REMOVE_PIC = "removeSelectPic";
    private static final String TAG = "QZoneMediaResultDealWithApiImpl";

    private Intent getFullMediaPickerDataIntent(Intent intent, List<LocalMediaInfo> list, HashMap<String, PicInfo> hashMap, PublishEventTag publishEventTag) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent);
        }
        ArrayList<String> b16 = a.b(list);
        intent2.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(list));
        intent2.putExtra("PhotoConst.WINK_MEDIA_PICKER_PATHS", b16);
        intent2.putExtra("PhotoConst.WINK_MEDIA_PICKER_QZONE_PICS", hashMap);
        intent2.putExtra("PhotoConst.IS_FROM_WINK_MEDIA_PICKER", true);
        if (publishEventTag != null) {
            intent2.putExtra(QZoneShareManager.QZONE_SHARE_EVENT_TAG, publishEventTag);
        }
        return intent2;
    }

    @Override // com.tencent.qzonehub.api.IQZoneMediaResultDealWithApi
    public void commitMediaToDestPage(Activity activity, IQZoneMediaResultDealWithApi.CommitMediaConfig commitMediaConfig) {
        QZLog.d(TAG, 1, "commitMediaToDestPage " + commitMediaConfig + ",activity = " + activity);
        if (activity == null || commitMediaConfig == null) {
            return;
        }
        Intent fullMediaPickerDataIntent = getFullMediaPickerDataIntent(commitMediaConfig.dataBundle, commitMediaConfig.selectedMediaList, commitMediaConfig.qzonePicList, commitMediaConfig.eventTag);
        String str = QZoneHelper.getLongAccountUin() + "";
        if (TextUtils.isEmpty(commitMediaConfig.destPageName)) {
            return;
        }
        QzonePluginProxyActivity.setActivityNameToIntent(fullMediaPickerDataIntent, commitMediaConfig.destPageName);
        fullMediaPickerDataIntent.addFlags(603979776);
        QZoneHelper.launchQZone(activity, str, fullMediaPickerDataIntent, commitMediaConfig.requestCode);
    }
}
