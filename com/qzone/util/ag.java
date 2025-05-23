package com.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f59773a = QZoneFilePath.THUMB_BASE_PATH;

    /* renamed from: b, reason: collision with root package name */
    private static final String f59774b = QZoneFilePath.VIDEO_COVER_TMP_CACHE_DIR;

    /* renamed from: c, reason: collision with root package name */
    private static String f59775c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkShouldCheck", "\u7f51\u7edc\u65e0\u8fde\u63a5\uff0c\u8bf7\u68c0\u67e5\u4f60\u7684\u7f51\u7edc\u8fde\u63a5");

    /* renamed from: d, reason: collision with root package name */
    private static String f59776d = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastStartLiveVideoFailForErrorParam", "\u53c2\u6570\u9519\u8bef\uff0c\u65e0\u6cd5\u542f\u52a8, mode=");

    /* renamed from: e, reason: collision with root package name */
    private static String f59777e = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastStartLiveVideoFailForErrorVersion", "\u7cfb\u7edf\u7248\u672c\u4e0d\u6ee1\u8db3\u8981\u6c42\uff0c\u65e0\u6cd5\u542f\u52a8\u76f4\u64ad");

    /* renamed from: f, reason: collision with root package name */
    private static String f59778f = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastStartLiveVideoFailForErrorHardware", "\u624b\u673a\u786c\u4ef6\u4e0d\u6ee1\u8db3\u8981\u6c42\uff0c\u65e0\u6cd5\u542f\u52a8\u76f4\u64ad");

    /* renamed from: g, reason: collision with root package name */
    private static String f59779g = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastStartLiveVideoFailForMemory", "SD\u5361\u4e0d\u5b58\u5728\u6216\u624b\u673a\u5185\u5b58\u4e0d\u8db3");

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f59780a;

        /* renamed from: b, reason: collision with root package name */
        public int f59781b;

        /* renamed from: c, reason: collision with root package name */
        public int f59782c;
    }

    public static void A(Activity activity, String str, int i3) {
        Bundle e16 = e(i3);
        e16.putAll(o(str));
        n(activity, PeakConstants.VIDEO_REFER_FROM_MOOD, e16, true, new Object[0]);
    }

    private static void B(Activity activity, boolean z16, String str) {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.R0(Boolean.valueOf(z16));
        qZonePublishMoodInitBean.n0(str);
        Boolean bool = Boolean.TRUE;
        qZonePublishMoodInitBean.w0(bool);
        qZonePublishMoodInitBean.N0(bool);
        qZonePublishMoodInitBean.v0(Boolean.FALSE);
        ho.i.w().c(activity, qZonePublishMoodInitBean);
    }

    public static boolean a(boolean z16) {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_KEY_GUEST_SDKDEF, "14,2147483647");
        if (config != null) {
            String[] split = config.split(",");
            try {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < parseInt || i3 > parseInt2) {
                    QZLog.i("[publish2]QZoneVideoUtils", "guest sdk version restriction");
                    if (z16) {
                        ToastUtil.r(f59777e);
                    }
                    return false;
                }
            } catch (Exception e16) {
                QZLog.e("[publish2]QZoneVideoUtils", 1, e16, new Object[0]);
            }
        }
        int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_KEY_GUEST_MIN_CPU_NUMBER, 1);
        int numberOfCores = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getNumberOfCores();
        if (numberOfCores < config2) {
            QZLog.i("[publish2]QZoneVideoUtils", "guest cpu number restriction serverCpuNumber=" + config2 + " localCpuNumber=" + numberOfCores);
            if (z16) {
                ToastUtil.r(f59778f);
            }
            return false;
        }
        int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_KEY_GUEST_MIN_CPU_FREQ, Integer.MIN_VALUE);
        long cpuMaxFreq = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCpuMaxFreq() / 1024;
        if (cpuMaxFreq < config3) {
            QZLog.i("[publish2]QZoneVideoUtils", "cpu frequency restriction serverCPUFreq=" + config3 + " localCpuFreq=" + cpuMaxFreq);
            if (z16) {
                ToastUtil.r(f59778f);
            }
            return false;
        }
        long config4 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_KEY_GUEST_MIN_RAM, 800);
        QZLog.i("[publish2]QZoneVideoUtils", "server Ram=" + config4);
        long totalMem = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getTotalMem() / 1024;
        if (totalMem >= config4) {
            return true;
        }
        QZLog.i("[publish2]QZoneVideoUtils", "ram restriction serverRam=" + config4 + " localRam=" + totalMem);
        if (z16) {
            ToastUtil.r(f59778f);
        }
        return false;
    }

    public static long c(String str) {
        long j3 = -1;
        if (!new File(str).exists()) {
            if (QZLog.isColorLevel()) {
                QZLog.e("[publish2]QZoneVideoUtils", "Path:" + str + str + ", not exits!");
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(str);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QZLog.isColorLevel()) {
                    QZLog.d("[publish2]QZoneVideoUtils", 2, "getDuration", e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    public static Bitmap d(String str) {
        StringBuilder sb5;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                mediaMetadataRetriever.extractMetadata(9);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 2);
                QZLog.d("[publish2]QZoneVideoUtils", 1, "getFirstFrame  bitmap = " + frameAtTime);
                if (frameAtTime == null) {
                    QLog.d("[publish2]QZoneVideoUtils", 1, "getFirstFrame... bitmap == null option:0");
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 0);
                }
                if (frameAtTime == null) {
                    QLog.d("[publish2]QZoneVideoUtils", 1, "getFirstFrame... bitmap == null option:3");
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 3);
                }
                if (frameAtTime == null) {
                    frameAtTime = k(str);
                    QZLog.d("[publish2]QZoneVideoUtils", 1, "getFirstFrame getVideoThumbnail , bitmap = " + frameAtTime);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e16) {
                    QZLog.e("[publish2]QZoneVideoUtils", "retriever.release error" + e16);
                }
                return frameAtTime;
            } catch (IllegalArgumentException e17) {
                QZLog.e("[publish2]QZoneVideoUtils", "IllegalArgumentException" + e17);
                try {
                    mediaMetadataRetriever.release();
                    return null;
                } catch (RuntimeException e18) {
                    e = e18;
                    sb5 = new StringBuilder();
                    sb5.append("retriever.release error");
                    sb5.append(e);
                    QZLog.e("[publish2]QZoneVideoUtils", sb5.toString());
                    return null;
                }
            } catch (RuntimeException e19) {
                QZLog.e("[publish2]QZoneVideoUtils", "RuntimeException" + e19);
                try {
                    mediaMetadataRetriever.release();
                    return null;
                } catch (RuntimeException e26) {
                    e = e26;
                    sb5 = new StringBuilder();
                    sb5.append("retriever.release error");
                    sb5.append(e);
                    QZLog.e("[publish2]QZoneVideoUtils", sb5.toString());
                    return null;
                }
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e27) {
                QZLog.e("[publish2]QZoneVideoUtils", "retriever.release error" + e27);
            }
            throw th5;
        }
    }

    private static Bundle e(int i3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, true);
        bundle.putInt(PeakConstants.KEY_ENTRY_SOURCE, i3);
        bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, true);
        bundle.putString(AECameraConstants.KEY_CONFIRM_TEXT, l.a(R.string.sca));
        bundle.putInt("UseQQCameraCompression", QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, "UseQQCameraCompression", 2));
        bundle.putDouble(AECameraConstants.KEY_LATITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).b());
        bundle.putDouble(AECameraConstants.KEY_LONGTITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).d());
        return bundle;
    }

    public static String f(String str) {
        a r16 = r(str);
        if (r16 == null) {
            return null;
        }
        return r16.f59780a;
    }

    public static int g(String str, boolean z16) {
        if (!z16) {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_MIN_AVAIL_RAM, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM);
        }
        if ("ultrafast".equalsIgnoreCase(str)) {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM);
        }
        if ("superfast".equalsIgnoreCase(str)) {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_SUPERFAST_AVAIL_RAM, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_SUPERFAST_AVAIL_RAM);
        }
        return "medium".equalsIgnoreCase(str) ? QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_MEDIUM_AVAIL_RAM, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MEDIUM_AVAIL_RAM) : QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            QZLog.e("[publish2]QZoneVideoUtils", 1, "getVideoCover  videoPath == null");
            return null;
        }
        if (!new File(str).exists()) {
            QZLog.e("[publish2]QZoneVideoUtils", 1, "getVideoCover  videoFile no exists");
            return null;
        }
        return u(d(str));
    }

    public static double j(String str, long j3, long j16, boolean z16, boolean z17) {
        double min;
        if (TextUtils.isEmpty(str) || j16 == 0) {
            return 0.0d;
        }
        if (j3 == 0 || j3 < j16) {
            j3 = j16;
        }
        long length = new File(str).length();
        if (!z17) {
            return length;
        }
        if (z16) {
            min = ((length * 1.0d) / j3) * j16;
            if (QZLog.isColorLevel()) {
                QZLog.d("[publish2]QZoneVideoUtils", 2, "getVideoEstimateSize, estimateSize=" + min);
            }
        } else {
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_MAX_BITRATE, 700000);
            String[] split = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NEWPARAM_ALL, "0,1280,2000000|0,1280,2000000|960,700000|960,700000").split("\\|")[0].split(",");
            if (split != null && split.length == 3) {
                if (LoginData.getInstance().getVipLevel() >= Integer.valueOf(split[0]).intValue()) {
                    config = Integer.valueOf(split[2]).intValue();
                }
            }
            min = Math.min((((j16 * 1.0d) / 1000.0d) * config) / 8.0d, length);
            if (QZLog.isColorLevel()) {
                QZLog.d("[publish2]QZoneVideoUtils", 2, "getVideoEstimateSize, totalDuration=" + j3 + ", duration=" + j16 + ", estimateSize=" + min);
            }
        }
        return min;
    }

    private static Bitmap k(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (createVideoThumbnail != null) {
            QZLog.d("[publish2]QZoneVideoUtils", 2, "getVideoThumbnail => success, width=" + createVideoThumbnail.getWidth() + ", height=" + createVideoThumbnail.getHeight() + ", videoPath=" + str + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
        } else {
            QZLog.e("[publish2]QZoneVideoUtils", "getVideoThumbnail => fail,  videoPath=" + str);
        }
        return createVideoThumbnail;
    }

    private static String l(String str) {
        return f59773a + str + ".jpg";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle o(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z16;
        boolean z17;
        Uri parse;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            boolean z18 = false;
            QZLog.d("[publish2]QZoneVideoUtils", 2, "parseTakeVideoParamsFromUrl: url = ", str);
            String str6 = null;
            try {
                parse = Uri.parse(str);
                z17 = parse.getBooleanQueryParameter("widget_category_unfold", false);
                try {
                    str2 = parse.getQueryParameter("widget_category_name");
                } catch (Throwable th5) {
                    th = th5;
                    str2 = null;
                    str3 = null;
                }
                try {
                    str3 = parse.getQueryParameter("widget_item_id");
                } catch (Throwable th6) {
                    th = th6;
                    str3 = null;
                    str4 = str3;
                    str5 = str4;
                    boolean z19 = z18;
                    z18 = z17;
                    z16 = z19;
                    QZLog.e("[publish2]QZoneVideoUtils", "parseTakeVideoParamsFromUrl: getQueryParameter exception", th);
                    boolean z26 = z18;
                    z18 = z16;
                    z17 = z26;
                    if (!z17) {
                    }
                    bundle.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    if (!z18) {
                    }
                    bundle.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    if (!TextUtils.isEmpty(str5)) {
                    }
                    if (!TextUtils.isEmpty(str6)) {
                    }
                    return bundle;
                }
                try {
                    z18 = parse.getBooleanQueryParameter("filter_category_unfold", false);
                    str4 = parse.getQueryParameter("filter_category_name");
                    try {
                        str5 = parse.getQueryParameter("filter_item_id");
                    } catch (Throwable th7) {
                        th = th7;
                        str5 = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    str4 = null;
                    str5 = str4;
                    boolean z192 = z18;
                    z18 = z17;
                    z16 = z192;
                    QZLog.e("[publish2]QZoneVideoUtils", "parseTakeVideoParamsFromUrl: getQueryParameter exception", th);
                    boolean z262 = z18;
                    z18 = z16;
                    z17 = z262;
                    if (!z17) {
                    }
                    bundle.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    if (!z18) {
                    }
                    bundle.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    if (!TextUtils.isEmpty(str5)) {
                    }
                    if (!TextUtils.isEmpty(str6)) {
                    }
                    return bundle;
                }
            } catch (Throwable th9) {
                th = th9;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                z16 = false;
            }
            try {
                str6 = parse.getQueryParameter("force_camera");
            } catch (Throwable th10) {
                th = th10;
                boolean z1922 = z18;
                z18 = z17;
                z16 = z1922;
                QZLog.e("[publish2]QZoneVideoUtils", "parseTakeVideoParamsFromUrl: getQueryParameter exception", th);
                boolean z2622 = z18;
                z18 = z16;
                z17 = z2622;
                if (!z17) {
                }
                bundle.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
                if (!TextUtils.isEmpty(str2)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!z18) {
                }
                bundle.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
                if (!TextUtils.isEmpty(str4)) {
                }
                if (!TextUtils.isEmpty(str5)) {
                }
                if (!TextUtils.isEmpty(str6)) {
                }
                return bundle;
            }
            if (!z17 || !TextUtils.isEmpty(str2)) {
                bundle.putBoolean(PeakConstants.ARG_UNFOLD_DD, true);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(PeakConstants.ARG_DD_CATEGORY_NAME, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(PeakConstants.ARG_DD_ITEM_ID, str3);
            }
            if (!z18 || !TextUtils.isEmpty(str4)) {
                bundle.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, true);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(PeakConstants.ARG_FILTER_CATEGORY_NAME, str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString(PeakConstants.ARG_FILTER_ITEM_ID, str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                try {
                    bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, Integer.parseInt(str6));
                } catch (Throwable th11) {
                    QZLog.e("[publish2]QZoneVideoUtils", "parseTakeVideoParamsFromUrl: parse PeakConstants.ARG_FORCE_CAMERA exception", th11);
                }
            }
        }
        return bundle;
    }

    public static ShuoshuoVideoInfo p(Context context, long j3, String str, long j16, int i3, String str2, int i16, int i17, long j17, long j18, long j19, boolean z16, Bundle bundle) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        int i18;
        String str3;
        if (!new File(str).exists()) {
            QZLog.e("[publish2]QZoneVideoUtils", "Path:" + str + ", not exits!");
            return null;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo2.setVideoOriginalPath(str);
        shuoshuoVideoInfo2.mVideoPath = str;
        shuoshuoVideoInfo2.mSize = j16;
        shuoshuoVideoInfo2.mVideoType = i3;
        if (i3 == 0) {
            shuoshuoVideoInfo2.mIsNew = 1;
            shuoshuoVideoInfo2.mEstimateSize = (500 * j19) / 8;
            shuoshuoVideoInfo = shuoshuoVideoInfo2;
            i18 = 1;
        } else if (i3 == 1) {
            shuoshuoVideoInfo2.mIsNew = 102;
            shuoshuoVideoInfo = shuoshuoVideoInfo2;
            i18 = 1;
            shuoshuoVideoInfo.mEstimateSize = j(str, j19, j18, false, z16);
        } else {
            shuoshuoVideoInfo = shuoshuoVideoInfo2;
            i18 = 1;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "prepareVideoInfos... video coverUrl:";
        objArr[i18] = shuoshuoVideoInfo.mCoverUrl;
        QZLog.d("[publish2]QZoneVideoUtils", i18, objArr);
        if (j3 != -1 && context != null && TextUtils.isEmpty(shuoshuoVideoInfo.mCoverUrl)) {
            a s16 = s(context, j3);
            shuoshuoVideoInfo.mCoverUrl = s16.f59780a;
            int i19 = s16.f59782c;
            if (i19 == 0) {
                i19 = i16;
            }
            shuoshuoVideoInfo.mVideoHeight = i19;
            int i26 = s16.f59781b;
            if (i26 == 0) {
                i26 = i17;
            }
            shuoshuoVideoInfo.mVideoWidth = i26;
        }
        if (TextUtils.isEmpty(shuoshuoVideoInfo.mCoverUrl) || !FileUtils.fileExists(shuoshuoVideoInfo.mCoverUrl)) {
            if (!TextUtils.isEmpty(str2) && FileUtils.fileExists(str2) && i16 > 0 && i17 > 0) {
                shuoshuoVideoInfo.mCoverUrl = str2;
                shuoshuoVideoInfo.mVideoHeight = i16;
                shuoshuoVideoInfo.mVideoWidth = i17;
            } else {
                a r16 = r(str);
                if (r16 != null && (str3 = r16.f59780a) != null) {
                    shuoshuoVideoInfo.mCoverUrl = str3;
                    shuoshuoVideoInfo.mVideoHeight = r16.f59782c;
                    shuoshuoVideoInfo.mVideoWidth = r16.f59781b;
                } else {
                    QZLog.w("[publish2]QZoneVideoUtils", "processThumb fail, videoId:" + j3 + ", videoPath:" + str);
                }
            }
        }
        shuoshuoVideoInfo.mStartTime = j17;
        shuoshuoVideoInfo.mEndTime = j17 + j18;
        shuoshuoVideoInfo.mNeedProcess = z16;
        shuoshuoVideoInfo.mDuration = j18;
        shuoshuoVideoInfo.mTotalDuration = j19;
        shuoshuoVideoInfo.mExtras = bundle;
        x(shuoshuoVideoInfo, i3);
        QZLog.d("[publish2]QZoneVideoUtils", i18, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo.mCoverUrl);
        return shuoshuoVideoInfo;
    }

    public static ShuoshuoVideoInfo q(String str, long j3, int i3, String str2, int i16, int i17, long j16, long j17, long j18, boolean z16, Bundle bundle) {
        return p(null, -1L, str, j3, i3, str2, i16, i17, j16, j17, j18, z16, bundle);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00d2: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:50:0x00d2 */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a r(String str) {
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        a aVar = new a();
        OutputStream outputStream2 = null;
        try {
            try {
                Bitmap d16 = d(str);
                if (d16 == null) {
                    QZLog.e("[publish2]QZoneVideoUtils", "processThumb: create thumbnail fail");
                    return null;
                }
                aVar.f59781b = d16.getWidth();
                aVar.f59782c = d16.getHeight();
                String l3 = l(new File(str).getName());
                if (TextUtils.isEmpty(l3)) {
                    return null;
                }
                FileUtils.createFileIfNotExits(f59773a + ".nomedia");
                File file = new File(l3);
                File file2 = new File(file.getParent());
                if (!file2.exists() || !file2.isDirectory()) {
                    file2.mkdirs();
                }
                if (!file.exists() || !file.isFile()) {
                    file.createNewFile();
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    d16.compress(Bitmap.CompressFormat.JPEG, 50, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[publish2]QZoneVideoUtils", 2, "video thumbnail saved, path=" + l3);
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused) {
                    }
                    aVar.f59780a = l3;
                    return aVar;
                } catch (Exception e16) {
                    e = e16;
                    QZLog.e("[publish2]QZoneVideoUtils", "processThumb failure", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    QZLog.e("[publish2]QZoneVideoUtils", "processThumb OutOfMemoryError", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Exception e18) {
                e = e18;
                bufferedOutputStream = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream2 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    private static a s(Context context, long j3) {
        Cursor cursor;
        String[] strArr = {"_data", "video_id", "height", "width"};
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + j3, null, null);
        } catch (Exception e16) {
            QZLog.e("[publish2]QZoneVideoUtils", "query error:" + e16.toString());
            cursor = null;
        }
        a aVar = new a();
        if (cursor != null && cursor.moveToFirst()) {
            String string = cursor.getString(cursor.getColumnIndex("_data"));
            int i3 = (int) cursor.getLong(cursor.getColumnIndex("height"));
            int i16 = (int) cursor.getLong(cursor.getColumnIndex("width"));
            aVar.f59780a = string;
            aVar.f59782c = i3;
            aVar.f59781b = i16;
        }
        if (cursor != null) {
            cursor.close();
        }
        return aVar;
    }

    private static boolean t(Bitmap bitmap, String str) {
        File file = new File(str);
        if (!file.exists() && bitmap != null) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    if (file.getParentFile() != null && !file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream2);
                        try {
                            bufferedOutputStream2.close();
                            return true;
                        } catch (IOException e16) {
                            QZLog.e("[publish2]QZoneVideoUtils", "saveBitmapToJPG...", e16);
                            return true;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = bufferedOutputStream2;
                        QZLog.e("[publish2]QZoneVideoUtils", "saveBitmapToJPG...", e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e18) {
                                QZLog.e("[publish2]QZoneVideoUtils", "saveBitmapToJPG...", e18);
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e19) {
                                QZLog.e("[publish2]QZoneVideoUtils", "saveBitmapToJPG...", e19);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            QZLog.e("[publish2]QZoneVideoUtils", 1, "saveBitmapToJPG  file.exists() = " + file.exists() + " , " + bitmap);
            return false;
        }
    }

    public static String u(Bitmap bitmap) {
        return v(bitmap, f59774b + File.separator + UUID.randomUUID().toString() + ".jpg");
    }

    public static void x(ShuoshuoVideoInfo shuoshuoVideoInfo, int i3) {
        if (QZonePublishConfig.isUseQCirclePublish()) {
            shuoshuoVideoInfo.mProcessType = 1;
        } else {
            shuoshuoVideoInfo.mProcessType = 0;
        }
    }

    public static ShuoshuoVideoInfo z(Context context, long j3, String str, long j16, int i3, String str2, int i16, int i17, long j17, long j18, long j19, boolean z16, Bundle bundle, boolean z17) {
        if (!new File(str).exists() && z17) {
            QZLog.e("[publish2]QZoneVideoUtils", "Path:" + str + ", not exits!");
            return null;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo.mVideoPath = str;
        shuoshuoVideoInfo.mSize = j16;
        shuoshuoVideoInfo.mVideoType = i3;
        if (i3 == 0) {
            shuoshuoVideoInfo.mIsNew = 1;
            shuoshuoVideoInfo.mEstimateSize = (500 * j19) / 8;
        } else if (i3 == 1) {
            shuoshuoVideoInfo.mIsNew = 102;
            shuoshuoVideoInfo.mEstimateSize = j(str, j19, j18, false, z16);
        }
        shuoshuoVideoInfo.mCoverUrl = str2;
        shuoshuoVideoInfo.mVideoHeight = i16;
        shuoshuoVideoInfo.mVideoWidth = i17;
        shuoshuoVideoInfo.mStartTime = j17;
        shuoshuoVideoInfo.mEndTime = j17 + j18;
        shuoshuoVideoInfo.mNeedProcess = z16;
        shuoshuoVideoInfo.mDuration = j18;
        shuoshuoVideoInfo.mTotalDuration = j19;
        shuoshuoVideoInfo.mExtras = bundle;
        x(shuoshuoVideoInfo, i3);
        QZLog.d("[publish2]QZoneVideoUtils", 1, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo.mCoverUrl);
        return shuoshuoVideoInfo;
    }

    public static void m(Activity activity, String str, Bundle bundle, String str2, boolean z16, Object... objArr) {
        if (bundle != null && !TextUtils.isEmpty(str2)) {
            bundle.putAll(o(str2));
        }
        n(activity, str, bundle, z16, objArr);
    }

    private static String v(Bitmap bitmap, String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            if (t(bitmap, str)) {
                QZLog.e("[publish2]QZoneVideoUtils", 1, "saveBitmapToJPG  return path = " + str);
                return str;
            }
            QZLog.e("[publish2]QZoneVideoUtils", "saveBitmapToJPG error, path:" + str);
            return null;
        }
        QZLog.e("[publish2]QZoneVideoUtils", 1, "saveBitmapToLocal  params error, bmp = " + bitmap + " , path = " + str);
        return null;
    }

    public static void w(ShuoshuoVideoInfo shuoshuoVideoInfo, String str, boolean z16) {
        if (shuoshuoVideoInfo != null) {
            if (shuoshuoVideoInfo.mExtras == null) {
                shuoshuoVideoInfo.mExtras = new Bundle();
            }
            shuoshuoVideoInfo.mExtras.putBoolean(str, z16);
        }
    }

    public static void C(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        shuoshuoVideoInfo.mEstimateSize = j(shuoshuoVideoInfo.mVideoPath, shuoshuoVideoInfo.mTotalDuration, shuoshuoVideoInfo.mDuration, z16, shuoshuoVideoInfo.mNeedProcess);
    }

    public static ShuoshuoVideoInfo b(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return null;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo.setVideoOriginalPath(localMediaInfo.path);
        shuoshuoVideoInfo.mVideoPath = localMediaInfo.path;
        shuoshuoVideoInfo.mSize = localMediaInfo.fileSize;
        shuoshuoVideoInfo.mStartTime = localMediaInfo.mStartTime;
        shuoshuoVideoInfo.mNeedProcess = localMediaInfo.needProcess;
        long j3 = localMediaInfo.mDuration;
        shuoshuoVideoInfo.mDuration = j3;
        long j16 = localMediaInfo.mTotalDuration;
        if (j16 != 0) {
            j3 = j16;
        }
        shuoshuoVideoInfo.mTotalDuration = j3;
        shuoshuoVideoInfo.mCoverUrl = localMediaInfo.thumbnailPath;
        shuoshuoVideoInfo.mProcessMissionID = localMediaInfo.missionID;
        shuoshuoVideoInfo.mVideoWidth = localMediaInfo.mediaWidth;
        shuoshuoVideoInfo.mVideoHeight = localMediaInfo.mediaHeight;
        x(shuoshuoVideoInfo, 0);
        return shuoshuoVideoInfo;
    }

    public static String i(long j3) {
        String str;
        String str2;
        if (j3 < 0) {
            QZLog.e("[publish2]QZoneVideoUtils", "Illegal video duration:" + j3);
            return "";
        }
        int i3 = (int) (j3 / 1000);
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + String.valueOf(i16);
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + String.valueOf(i17);
        }
        return str2 + ":" + str;
    }

    public static void n(Activity activity, String str, Bundle bundle, boolean z16, Object... objArr) {
        String str2;
        String str3;
        String str4;
        boolean z17 = (!z16 || QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_VIDEOEDIT, QzoneConfig.SECONDARY_SUPPORT_EDIT_VIDEO, 1) == 1) ? z16 : false;
        PerfTracer.traceStart(PerfTracer.VIDEO_COMPONENT_PRE_LAUNCH);
        if (objArr != null && objArr.length >= 1) {
            str2 = (String) objArr[0];
            LocalMultiProcConfig.putString(LocalMultiProcConfig.PREFS_NAME_QZ_VIDEO_SETTING, QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, str2);
        } else {
            str2 = "";
        }
        QZoneVideoCommonUtils.VideoSupport recordSupport = QZoneVideoCommonUtils.getRecordSupport();
        QZoneVideoCommonUtils.VideoSupport trimSupport = QZoneVideoCommonUtils.getTrimSupport();
        if (QZLog.isColorLevel()) {
            QZLog.d("[publish2]QZoneVideoUtils", 2, "support record=" + recordSupport.isAvailable() + ", support trim=" + trimSupport.isAvailable());
        }
        if (!recordSupport.isAvailable() && !trimSupport.isAvailable()) {
            if (QZLog.isColorLevel()) {
                QZLog.d("[publish2]QZoneVideoUtils", 2, "qzone video is not supported, jump to publish mood");
            }
            if (recordSupport.getTip() != null && recordSupport.getTip().contains("sd\u5361")) {
                ToastUtil.r(f59779g);
            }
            B(activity, true, str2);
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, "1001", null);
            return;
        }
        Intent intent = new Intent();
        if (bundle != null) {
            String string = bundle.getString("callback");
            String string2 = bundle.getString("dongxiao_id");
            intent.putExtras(bundle);
            str3 = string;
            str4 = string2;
        } else {
            str3 = null;
            str4 = null;
        }
        QZoneVideoCommonUtils.installVideoActivity(LoginData.getInstance().getUin(), activity, recordSupport.isAvailable(), trimSupport.isAvailable(), str, LoginData.getInstance().isQzoneVip(), z17, null, false, str3, str4, intent);
        PerfTracer.traceEnd(PerfTracer.VIDEO_COMPONENT_PRE_LAUNCH);
    }

    public static ShuoshuoVideoInfo y(Context context, long j3, String str, long j16, int i3, String str2, int i16, int i17, long j17, long j18, long j19, boolean z16, Bundle bundle) {
        return z(context, j3, str, j16, i3, str2, i16, i17, j17, j18, j19, z16, bundle, true);
    }
}
