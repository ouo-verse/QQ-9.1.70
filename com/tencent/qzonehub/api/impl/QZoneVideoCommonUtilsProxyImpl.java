package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QZoneVideoDownloadActivity;

/* loaded from: classes34.dex */
public class QZoneVideoCommonUtilsProxyImpl implements IQZoneVideoCommonUtilsProxy {
    private static final String TAG = "QZoneVideoCommonUtils";
    public static final String TRIM_HW_LOCAL_BLACK_LIST = "GT-N7100|";

    @Override // com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
    public QZoneVideoCommonUtils.VideoSupport getTrimHWSupport() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_ENABLE_HW, 1) != 1) {
            return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_SUPPORT_TRIM_HW, -1) == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimHWSupport() severBlackList");
            }
            return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
        }
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_NEED_LOCAL_BLACK_LIST, 1);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Build.Model=" + DeviceInfoMonitor.getModel());
        }
        if (config > 0 && "GT-N7100|".contains(DeviceInfoMonitor.getModel())) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimHWSupport() localBlackList");
            }
            return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
        }
        int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_MIN_SDK_TRIM_HW, 18);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < config2) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimHWSupport() localSdkVersion=" + i3 + " serverSdkVersion=" + config2);
            }
            return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
        }
        int checkSupportMediaCodecFeature = ShortVideoCodec.checkSupportMediaCodecFeature(BaseApplication.getContext());
        if (!((checkSupportMediaCodecFeature & 1) > 0 && (checkSupportMediaCodecFeature & 2) > 0)) {
            return QZoneVideoCommonUtils.VideoSupport.CodecFeatureBanned;
        }
        return QZoneVideoCommonUtils.VideoSupport.Available;
    }

    @Override // com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
    public void gotoRecordPreview(Activity activity, int i3, String str, long j3, Bundle bundle) {
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) QZoneVideoDownloadActivity.class);
        intent.putExtra("video_type", i3);
        intent.putExtra("file_send_path", str);
        intent.putExtra("preview_video", true);
        intent.putExtra("start_time", 0);
        intent.putExtra("end_time", j3);
        intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, bundle);
        intent.putExtra(PeakConstants.VIDEO_REFER, PeakConstants.VIDEO_REFER_FROM_MOOD);
        activity.startActivity(intent);
    }

    @Override // com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
    public void installVideoActivity(long j3, Activity activity, boolean z16, boolean z17, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "installVideoActivity");
        }
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) QZoneVideoDownloadActivity.class);
        intent.putExtra("support_record", z16);
        intent.putExtra("support_trim", z17);
        intent.putExtra("uin", String.valueOf(j3));
        intent.putExtra("flow_camera_capture_mode", false);
        intent.putExtra(PeakConstants.KEY_ENTRY_SOURCE, 9);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(PeakConstants.VIDEO_REFER, str);
        }
        activity.startActivity(intent);
    }

    @Override // com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
    public void installVideoActivityForOther(long j3, Activity activity, boolean z16, boolean z17, String str, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "installVideoActivityForEditVideo");
        }
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) QZoneVideoDownloadActivity.class);
        intent.putExtra("uin", String.valueOf(j3));
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(PeakConstants.VIDEO_REFER, str);
        }
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
    public void installVideoActivity(long j3, Activity activity, boolean z16, boolean z17, String str, boolean z18, boolean z19, String str2, boolean z26, String str3, String str4, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "installVideoActivity");
        }
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) QZoneVideoDownloadActivity.class);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("support_record", z16);
        intent2.putExtra("support_trim", z17);
        intent2.putExtra("uin", String.valueOf(j3));
        intent2.putExtra("is_qzone_vip", z18);
        intent2.putExtra(ShortVideoConstants.ENABLE_EDIT_VIDEO, z19);
        intent2.putExtra("topicId", str2);
        intent2.putExtra("enterPtu", z26);
        if (!TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "callback:" + str3 + " id:" + str4);
            }
            intent2.putExtra("callback", str3);
            intent2.putExtra("dongxiao_id", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra(PeakConstants.VIDEO_REFER, str);
        }
        activity.startActivity(intent2);
    }

    @Override // com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
    public void installVideoActivity(boolean z16, boolean z17, Activity activity, String str, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, String str2, String str3, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "installVideoActivity");
        }
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) QZoneVideoDownloadActivity.class);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("support_record", z16);
        intent2.putExtra("support_trim", z17);
        intent2.putExtra("uin", "0");
        intent2.putExtra("is_qzone_vip", z18);
        intent2.putExtra(ShortVideoConstants.ENABLE_EDIT_VIDEO, true);
        intent2.putExtra("enterPtu", true);
        intent2.putExtra("enable_local_button", z29);
        intent2.putExtra(AECameraConstants.KEY_ENABLE_EDIT_BUTTON, z26);
        intent2.putExtra("callback", "qzoneOpenDongXiao");
        intent2.putExtra("dongxiao_id", str2);
        intent2.putExtra(AECameraConstants.KEY_ENABLE_PRIV_LIST, false);
        intent2.putExtra(AECameraConstants.KEY_ENABLE_INPUT_TEXT, z19);
        if (z19) {
            intent2.putExtra("enable_sync_qzone", z27);
        }
        intent2.putExtra("enable_origin_video", z28);
        intent2.putExtra(AECameraConstants.KEY_CONFIRM_TEXT, str3);
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra(PeakConstants.VIDEO_REFER, str);
        }
        activity.startActivity(intent2);
    }
}
