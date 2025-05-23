package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends QAlbumUtil {

    /* renamed from: a, reason: collision with root package name */
    private static long f307689a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f307690b = {0, 3000, 1, 10014};

    public static void a(Intent intent) {
        if (intent.getBooleanExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false)) {
            String stringExtra = intent.getStringExtra(QAlbumConstants.ALBUM_ID);
            String stringExtra2 = intent.getStringExtra(PeakConstants.LAST_ALBUMPATH);
            if (stringExtra2 != null && stringExtra != null) {
                QAlbumUtil.sLastAlbumPath = stringExtra2;
                QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
            }
        }
    }

    public static String b(List<String> list) {
        StringBuilder sb5 = new StringBuilder("_data");
        sb5.append(" IS NOT NULL AND ");
        sb5.append("_size");
        sb5.append(" > 0 ");
        if (list != null && list.size() > 0) {
            sb5.append(" AND (");
            boolean z16 = true;
            for (String str : list) {
                if (!z16) {
                    sb5.append(" OR ");
                } else {
                    z16 = false;
                }
                sb5.append(" ( ");
                sb5 = g("bucket_id", sb5, str);
                sb5.append(" ) ");
            }
            sb5.append(" ) ");
        }
        return sb5.toString();
    }

    public static boolean c(List<String> list, Activity activity, int i3) {
        if (list == null || list.isEmpty() || list.size() < i3) {
            return false;
        }
        QQToast.makeText(activity, String.format(activity.getResources().getString(R.string.h3b), Integer.valueOf(i3)), 0).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return true;
    }

    public static boolean d(Context context, int i3, LocalMediaInfo localMediaInfo, boolean z16) {
        int j3;
        if (localMediaInfo == null) {
            return false;
        }
        boolean z17 = true;
        if (QAlbumUtil.getMediaType(localMediaInfo) != 1) {
            return false;
        }
        if (z16) {
            j3 = l();
        } else {
            j3 = j();
        }
        if (i3 >= j3) {
            if (System.currentTimeMillis() - f307689a > 2000) {
                QQToast.makeText(context, HardCodeUtil.qqStr(R.string.jcy) + j3 + HardCodeUtil.qqStr(R.string.jcz), 0).show();
                f307689a = System.currentTimeMillis();
            }
            z17 = false;
        }
        long videoCanUploadSize = QZoneHelper.getVideoCanUploadSize();
        if (localMediaInfo.fileSize > videoCanUploadSize) {
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.jcx) + (((((float) videoCanUploadSize) / 1024.0f) / 1024.0f) / 1024.0f) + "G\u7684\u89c6\u9891", 0).show();
            z17 = false;
        }
        if (localMediaInfo.mDuration > PeakConstants.QZONE_UPLOAD_PHOTO_ACTIVITY_VIDEO_DURATION_UPPER_LIMIT) {
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.jcw) + 10L + HardCodeUtil.qqStr(R.string.f171574jd0), 0).show();
            return false;
        }
        return z17;
    }

    public static void f() {
        QAlbumUtil.sLastAlbumPhotoCountMap.clear();
        QAlbumUtil.sLastAlbumPath = null;
        QAlbumUtil.sLastAlbumRecordTime = 0L;
        QAlbumUtil.sLastAlbumId = null;
        QAlbumUtil.sLastAlbumName = null;
    }

    private static StringBuilder g(String str, StringBuilder sb5, String str2) {
        sb5.append(str);
        sb5.append(" = ");
        sb5.append(str2);
        return sb5;
    }

    public static String h(Context context) {
        return context.getSharedPreferences(QAlbumUtil.ALBUM_FILE_NAME, 0).getString(QAlbumUtil.ALBUM_KEY_ID, null);
    }

    public static String i(Context context) {
        return context.getSharedPreferences(QAlbumUtil.ALBUM_FILE_NAME, 0).getString(QAlbumUtil.ALBUM_KEY_NAME, null);
    }

    public static int j() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_MAX_COUNT, 50);
    }

    public static float k() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTO_GROUP_LIST_IMAGE_CROP_SPACE_RATIO, 0.25f);
    }

    public static int l() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHUOSHUO_UPLOAD_VIDEO_MAX_COUNT, 10);
    }

    public static boolean m(int i3) {
        for (int i16 : f307690b) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    public static List<LocalMediaInfo> n(Context context, int i3, int i16, MediaFileFilter mediaFileFilter) {
        return QAlbumBaseUtil.queryRecentImages(context, i3, i16, mediaFileFilter, false, 0, null, false);
    }

    public static void o(int i3, int i16) {
        ReportController.o(null, "CliOper", "", "", "0X8009E99", "0X8009E99", 0, 0, i3 + "", i16 + "", "", "");
    }

    public static void p() {
        ReportController.o(null, "CliOper", "", "", "0X8009E98", "0X8009E98", 0, 0, "", "", "", "");
    }

    public static void e() {
    }
}
