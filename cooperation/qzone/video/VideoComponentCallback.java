package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import java.util.ArrayList;
import qs.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class VideoComponentCallback implements c {
    public static final int BUSINESS_TYPE = 1;
    public static final String KEY_QZONE_NICKNAME = "nickname";
    public static final String KEY_QZONE_UIN = "qzone_uin";
    public static final int REQUEST_VIDEO_TRIM = 1000;
    public static final String RESULT_FINISH_VIDEO_COMPONENT = "finish_video_component";
    public static final String SP_KEY_SUPPORT_TRIM = "support_trim";
    public static final String TAG = "cooperation.qzone.video.VideoComponentCallback";
    private String mRefer;

    public static void launchPublishMoodActivity(Activity activity, int i3, boolean z16, String str, String str2, int i16, int i17, long j3, long j16, long j17, long j18, int i18, Bundle bundle, String str3, String str4, String str5) {
        Intent intent = new Intent("com.tencent.mobileqq.action.publishmood");
        intent.putExtra("qzone_plugin_activity_name", ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
        intent.putExtra(PeakConstants.VIDEO_TYPE, i3);
        intent.putExtra("file_send_path", str);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_PATH, str2);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, i17);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, i16);
        intent.putExtra(PeakConstants.VIDEO_NEED_PROCESS, z16);
        intent.putExtra("start_time", j16);
        intent.putExtra(PeakConstants.VIDEO_TOTAL_DURATION, j3);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, j17 - j16);
        intent.putExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, i18);
        intent.putExtra(PeakConstants.VIDEO_SIZE, j18);
        intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, bundle);
        intent.putExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, str3);
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("refer", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            intent.putExtra(PeakConstants.VIDEO_REFER, str5);
        }
        intent.addFlags(603979776);
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        QzonePluginProxyActivity.setActivityNameToIntent(intent, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        QzonePluginProxyActivity.launchPluingActivityForResult(activity, account, intent, -1);
    }

    private void sendToH5(int i3, boolean z16, String str, String str2, int i16, int i17, long j3, long j16, Bundle bundle, String str3, String str4, boolean z17, int i18, int i19, String str5, String str6, String str7) {
        Intent intent = new Intent(PeakConstants.ACTION_H5_VIDEO_RECORD_CALLBACK);
        intent.putExtra("param.content", str3);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOPATH, str);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOSIZE, j16);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOTYPE, i3);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH, str2);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILHEIGHT, i17);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILWIDTH, i16);
        intent.putExtra("param.duration", j3);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_TOTALDURATION, j3);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_NEEDPROCESS, z16);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_EXTRAS, bundle);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_ID, str4);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, z17);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_NEW_FAKE_VID, str6);
        intent.putExtra("param.source", str7);
        if (i18 >= 0) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i18);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, i19);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, str5);
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    private void sendVideoMood(int i3, boolean z16, String str, String str2, int i16, int i17, long j3, long j16, long j17, long j18, int i18, Bundle bundle, String str3, String str4, String str5, int i19, String str6, ArrayList<String> arrayList, String str7, boolean z17, int i26, int i27, String str8, String str9, String str10, boolean z18, boolean z19, int i28, String str11, QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo, boolean z26, boolean z27) {
        int i29;
        Bundle bundle2 = new Bundle();
        bundle2.putString("param.content", str6);
        bundle2.putInt("param.priv", i19);
        bundle2.putStringArrayList("param.privList", arrayList);
        bundle2.putString(RemoteHandleConst.VIDEO_PARAM_VIDEOPATH, str);
        bundle2.putLong(RemoteHandleConst.VIDEO_PARAM_VIDEOSIZE, j18);
        bundle2.putInt(RemoteHandleConst.VIDEO_PARAM_VIDEOTYPE, i3);
        bundle2.putString(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH, str2);
        bundle2.putInt(RemoteHandleConst.VIDEO_PARAM_THUMBNAILHEIGHT, i17);
        bundle2.putInt(RemoteHandleConst.VIDEO_PARAM_THUMBNAILWIDTH, i16);
        bundle2.putLong(RemoteHandleConst.VIDEO_PARAM_STARTTIME, j16);
        bundle2.putLong("param.duration", j3);
        bundle2.putLong(RemoteHandleConst.VIDEO_PARAM_TOTALDURATION, j3);
        bundle2.putBoolean(RemoteHandleConst.VIDEO_PARAM_NEEDPROCESS, z16);
        bundle2.putBundle(RemoteHandleConst.VIDEO_PARAM_EXTRAS, bundle);
        bundle2.putString(RemoteHandleConst.VIDEO_PARAM_TOPIC_ID, str7);
        bundle2.putBoolean(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, z17);
        bundle2.putString(RemoteHandleConst.VIDEO_PARAM_NEW_FAKE_VID, str9);
        bundle2.putString("param.source", str10);
        bundle2.putBoolean(RemoteHandleConst.VIDEO_PARAM_IS_GENERATE_GIF, z18);
        bundle2.putBoolean(RemoteHandleConst.VIDEO_PARAM_IS_TIMER_DELETE, z19);
        bundle2.putParcelable(RemoteHandleConst.PARAM_QZONE_TOPIC, qzoneVerticalVideoTopicInfo);
        bundle2.putBoolean(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, z26);
        bundle2.putBoolean(RemoteHandleConst.PARAM_FROM_AIO, z27);
        if (qzoneVerticalVideoTopicInfo != null) {
            i29 = qzoneVerticalVideoTopicInfo.hasMusic() ? 213 : 214;
        } else {
            i29 = 200;
        }
        bundle2.putInt("param.uploadEntrance", i29);
        bundle2.putInt(RemoteHandleConst.VIDEO_PARAM_ENTRANCE_SOURCE, SlideShowPhotoListManager.n().l());
        if (i26 >= 0) {
            bundle2.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i26);
            bundle2.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, i27);
            bundle2.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, str8);
        }
        if (i28 >= 0) {
            bundle2.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, i28);
            bundle2.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, str11);
        }
        RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_PUBLISH_VIDEO_MOOD, bundle2, false);
    }

    @Override // qs.c
    public String getRefer() {
        return this.mRefer;
    }

    @Override // qs.c
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onActivityResult");
        }
        if (activity == null || intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("finish_video_component", false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "doFinish=" + booleanExtra);
        }
        if (-1 == i16 && booleanExtra) {
            activity.finish();
        }
    }

    @Override // qs.c
    public void sendClick(Activity activity, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendClick");
        }
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR);
        String stringExtra2 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
        int intExtra = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, -1);
        int intExtra2 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, -1);
        int intExtra3 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, -1);
        int intExtra4 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, -1);
        int intExtra5 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_MAX_BITRATE, -1);
        int intExtra6 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_MIN_BITRATE, -1);
        int intExtra7 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_QMAX, -1);
        int intExtra8 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_QMIN, -1);
        int intExtra9 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_QMAXDIFF, -1);
        int intExtra10 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_REF_FRAME, -1);
        int intExtra11 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_SMOOTH, -1);
        String stringExtra3 = intent.getStringExtra(ShortVideoConstants.VIDEO_TOPIC_ID);
        int intExtra12 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1);
        int intExtra13 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, -1);
        String stringExtra4 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
        int intExtra14 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, -1);
        String stringExtra5 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
        boolean booleanExtra = intent.getBooleanExtra(ShortVideoConstants.VIDEO_TOPIC_SYNC_QZONE, false);
        String stringExtra6 = intent.getStringExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID);
        boolean booleanExtra2 = intent.getBooleanExtra(ShortVideoConstants.VIDEO_IS_GENERATE_GIF, false);
        boolean booleanExtra3 = intent.getBooleanExtra(ShortVideoConstants.VIDEO_MOOD_TIMER_DELETE, false);
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = (QzoneVerticalVideoTopicInfo) intent.getParcelableExtra(ShortVideoConstants.QZONE_VIDEO_TOPIC);
        boolean booleanExtra4 = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, false);
        boolean booleanExtra5 = intent.getBooleanExtra(RemoteHandleConst.PARAM_FROM_AIO, false);
        int intExtra15 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_TOTALTIME_ADJ, 0);
        int intExtra16 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_TIMESTAMP_FIX, 0);
        int intExtra17 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_LOW, 0);
        int intExtra18 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_HIGH, 0);
        int intExtra19 = intent.getIntExtra(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_RATIO, 65537);
        int intExtra20 = intent.getIntExtra(ShortVideoConstants.VIDEO_MOOD_PRIV, -1);
        String stringExtra7 = intent.getStringExtra(ShortVideoConstants.VIDEO_MOOD_CONTENT);
        if (stringExtra7 == null) {
            stringExtra7 = "";
        }
        String str = stringExtra7;
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(ShortVideoConstants.VIDEO_MOOD_PRIVUINLIST);
        boolean booleanExtra6 = intent.getBooleanExtra(ShortVideoConstants.ENABLE_EDIT_VIDEO, false);
        Bundle bundle = new Bundle();
        bundle.putInt(ShortVideoConstants.SV_ENCODE_MAX_BITRATE, intExtra5);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_MIN_BITRATE, intExtra6);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_QMAX, intExtra7);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_QMIN, intExtra8);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_QMAXDIFF, intExtra9);
        bundle.putInt(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, intExtra4);
        int i3 = intExtra3;
        bundle.putInt(ShortVideoConstants.SV_TOTAL_RECORD_TIME, i3);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_TOTALTIME_ADJ, intExtra15);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_TIMESTAMP_FIX, intExtra16);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_LOW, intExtra17);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_HIGH, intExtra18);
        bundle.putInt(ShortVideoConstants.SV_ENCODE_BLESS_AUDIO_START_TIME_RATIO, intExtra19);
        if (QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER.equals(getRefer())) {
            if (i3 < 0) {
                i3 = intent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, -1);
            }
            QLog.i(TAG, 2, "videoCover,record video open video preview activity.totalDuration=" + i3);
            bundle.putInt(ShortVideoConstants.SV_ENCODE_REF_FRAME, intExtra10);
            bundle.putInt(ShortVideoConstants.SV_ENCODE_SMOOTH, intExtra11);
            long j3 = (long) (i3 * 1000);
            QZoneHelper.launchVideoCoverPreviewActivity(activity, 0, null, true, stringExtra, stringExtra2, intExtra, intExtra2, j3, 0L, j3, 0L, intExtra4, bundle, "", "", getRefer(), QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER);
            return;
        }
        if (QZoneVideoCommonUtils.REFER_UPLOAD_VIDEO_FOR_H5.equals(getRefer())) {
            sendToH5(0, true, stringExtra, stringExtra2, intExtra, intExtra2, i3, 0L, bundle, str, stringExtra3, booleanExtra, intExtra12, intExtra13, stringExtra4, stringExtra6, null);
            return;
        }
        if (booleanExtra6) {
            String stringExtra8 = intent.getStringExtra(ShortVideoConstants.FORWARD_SOURCE_TO_QZONE);
            if (ShortVideoConstants.SOURCE_FROM_QUICK_SHOOT.equals(stringExtra8)) {
                stringExtra8 = "value.sourceFromQqQuickShoot";
            }
            long j16 = i3 * 1000;
            sendVideoMood(0, true, stringExtra, stringExtra2, intExtra, intExtra2, j16, 0L, j16, 0L, intExtra4, bundle, "", "", "", intExtra20, str, stringArrayListExtra, stringExtra3, booleanExtra, intExtra12, intExtra13, stringExtra4, stringExtra6, stringExtra8, booleanExtra2, booleanExtra3, intExtra14, stringExtra5, qzoneVerticalVideoTopicInfo, booleanExtra4, booleanExtra5);
            return;
        }
        long j17 = i3;
        launchPublishMoodActivity(activity, 0, true, stringExtra, stringExtra2, intExtra, intExtra2, j17, 0L, j17, 0L, intExtra4, bundle, "", "", "");
    }

    @Override // qs.c
    public void setRefer(String str) {
        this.mRefer = str;
    }
}
