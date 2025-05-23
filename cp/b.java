package cp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.util.PerfTracer;
import ho.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static void a(Activity activity, String str, String str2, int i3, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
        bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        bundle.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, i3);
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 50);
        bundle.putString("PhotoConst.UIN", LoginData.getInstance().getUinString());
        bundle.putString("uin", LoginData.getInstance().getUinString());
        bundle.putInt("uintype", 0);
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT);
        bundle.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, TextUtils.isEmpty(config) ? 1048576000L : Long.valueOf(config).longValue());
        if (!TextUtils.isEmpty(str3) && str3.contains(PeakConstants.VIDEO_REFER_FROM_MOOD)) {
            bundle.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION, QZoneHelper.getVideoCanUploadLimitMs());
        }
        bundle.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, QZoneHelper.getVideoCanCompressLimitMs());
        bundle.putBoolean(PeakConstants.IS_PREVIEW_VIDEO, false);
        bundle.putBoolean("cleartop", true);
        bundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str2);
        bundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
        bundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        bundle.putString(PeakConstants.VIDEO_REFER, str3);
        if (activity.getIntent() != null) {
            bundle.putBoolean(PeakConstants.SHOW_MAGIC_USE_PASTER, activity.getIntent().getBooleanExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, false));
        }
        Intent intent = new Intent("com.tencent.mobileqq.action.takephoto");
        if (QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER.equals(str3)) {
            intent.putExtra(PeakConstants.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION, QZoneHelper.getVideoCoverLimitMs());
        }
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void b(Activity activity, int i3, boolean z16, String str, String str2, int i16, int i17, long j3, long j16, long j17, long j18, String str3, String str4, String str5) {
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
        intent.putExtra(PeakConstants.VIDEO_SIZE, j18);
        intent.putExtra("from_plugin", "QZoneVideoPlugin");
        intent.putExtra("uin", LoginData.getInstance().getUinString());
        intent.putExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, str3);
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("refer", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            intent.putExtra(PeakConstants.VIDEO_REFER, str5);
        }
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        intent.addFlags(603979776);
        activity.startActivity(intent);
    }

    public static void c(Activity activity, int i3, boolean z16, String str, String str2, int i16, int i17, long j3, long j16, long j17, long j18, String str3, String str4, String str5) {
        Intent intent = new Intent("com.tencent.mobileqq.action.publishmood");
        intent.putExtra("qzone_plugin_activity_name", QZoneHelper.UPLOAD_PHOTO);
        intent.putExtra(PeakConstants.EDIT_VIDEO_FOR_QZONE_UPLOAD_PHOTO_ACTIVITY, true);
        intent.putExtra(PeakConstants.VIDEO_TYPE, i3);
        intent.putExtra("file_send_path", str);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_PATH, str2);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, i17);
        intent.putExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, i16);
        intent.putExtra(PeakConstants.VIDEO_NEED_PROCESS, z16);
        intent.putExtra("start_time", j16);
        intent.putExtra(PeakConstants.VIDEO_TOTAL_DURATION, j3);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, j17 - j16);
        intent.putExtra(PeakConstants.VIDEO_SIZE, j18);
        intent.putExtra("from_plugin", "QZoneVideoPlugin");
        intent.putExtra("uin", LoginData.getInstance().getUinString());
        intent.putExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, str3);
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("refer", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            intent.putExtra(PeakConstants.VIDEO_REFER, str5);
        }
        intent.addFlags(603979776);
        if (lc.b.d()) {
            i.x().l(activity, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), intent);
        } else {
            i.w().h(activity, new QZonePublishMoodInitBean(System.currentTimeMillis()), intent);
        }
    }
}
