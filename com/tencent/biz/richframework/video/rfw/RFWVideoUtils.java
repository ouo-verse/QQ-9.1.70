package com.tencent.biz.richframework.video.rfw;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoUtils {
    public static final List<String> LONG_VALID_LIST;
    public static final long VALID_MAX_TIME;
    public static final long VALID_MAX_TIME_AD;
    public static final long VALID_MAX_TIME_QUIC;
    private static final String VIDEO_CACHE_FILE_PREF;

    static {
        ArrayList arrayList = new ArrayList();
        LONG_VALID_LIST = arrayList;
        arrayList.add("circlevideo-quic.photo.qq.com");
        arrayList.add("circlevideo.photo.qq.com");
        VALID_MAX_TIME = uq3.c.X0("qqcircle", "secondary_qcircle_video_url_valid_time", Integer.valueOf(com.tencent.mobileqq.msf.core.auth.d.f247418d)).intValue();
        VALID_MAX_TIME_QUIC = uq3.c.X0("qqcircle", "secondary_qcircle_video_quic_url_valid_time", 302400000).intValue();
        VALID_MAX_TIME_AD = uq3.c.Z0("qqcircle", "secondary_qcircle_video_ad_url_valid_time", Long.MAX_VALUE).longValue();
        VIDEO_CACHE_FILE_PREF = RFWApplication.getApplication().getExternalCacheDir() + "/superplayer/170303";
    }

    private static boolean businessEnableInterceptor(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions != null && rFWPlayerOptions.getIOC() != null) {
            if (rFWPlayerOptions.getIOC().getPlayerUpperData() == null) {
                return true;
            }
            Object value = rFWPlayerOptions.getIOC().getPlayerUpperData().getValue("RFW_ENABLE_BACKGROUND_PAUSE");
            if (!(value instanceof Boolean)) {
                return true;
            }
            QLog.d(rFWPlayerOptions.tag(), 1, "businessEnableInterceptor value :" + value);
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

    public static boolean checkCacheExist(int i3, String str, String str2) {
        return new File(VIDEO_CACHE_FILE_PREF + i3 + String.format("/%s.mp4", getFileIdWithTapPosition(str, str2))).exists();
    }

    public static boolean checkVideoUrlIsNeedChange(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getQueryParameter("dis_t") != null) {
                if (System.currentTimeMillis() - (Long.parseLong(parse.getQueryParameter("dis_t")) * 1000) <= getValidIntervalTime(str)) {
                    return false;
                }
                return true;
            }
            return o.l();
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static float computeCacheTimeS(int i3, String str, String str2, int i16) {
        if (new File(VIDEO_CACHE_FILE_PREF + i3 + String.format("/%s.mp4", getFileIdWithTapPosition(str, str2))).exists() && i16 != 0) {
            return Math.round((((float) r0.length()) / ((i16 * 1024) / 8)) * 100.0f) / 100.0f;
        }
        return 0.0f;
    }

    public static SuperPlayerVideoInfo createSuperVideoInfo(String str, String str2, List<String> list, String str3, int i3, int i16, RFWPlayerOptions rFWPlayerOptions) {
        String str4;
        String str5 = str2;
        if (!isValidSource(str2, str)) {
            reportUrl(str2, 1);
            int i17 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createSuperVideoInfo error:");
            if (TextUtils.isEmpty(str2)) {
                str5 = "error url";
            }
            sb5.append(str5);
            objArr[0] = sb5.toString();
            RFWLog.d("RFWVideoUtils", i17, objArr);
            return null;
        }
        reportUrl(str2, 2);
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            SuperPlayerVideoInfo createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_XIAOSHIJIE, str);
            createVideoInfoForTVideo.setVideoDurationMs(i3);
            return createVideoInfoForTVideo;
        }
        if (rFWPlayerOptions != null && rFWPlayerOptions.useMD5AsId() && !TextUtils.isEmpty(str2)) {
            String encodeHexStr = MD5Utils.encodeHexStr(str2);
            if (TextUtils.isEmpty(encodeHexStr)) {
                str4 = str5;
            } else {
                str4 = encodeHexStr;
            }
            RFWLog.d("RFWVideoUtils", RFWLog.USR, "createSuperVideoInfo by MD5 fileId:", str4, ", url:", str5);
            return createVideoInfo(str2, list, str3, str4, i3, i16);
        }
        String fileIdWithTapPosition = getFileIdWithTapPosition(str2, str);
        RFWLog.d("RFWVideoUtils", RFWLog.USR, "createSuperVideoInfo fileId:", fileIdWithTapPosition, ", url:", str5);
        return createVideoInfo(str2, list, str3, fileIdWithTapPosition, i3, i16);
    }

    private static SuperPlayerVideoInfo createVideoInfo(String str, List<String> list, String str2, String str3, int i3, int i16) {
        SuperPlayerVideoInfo createVideoInfoForUrl;
        int i17 = 101;
        if (TextUtils.isEmpty(str)) {
            QLog.e("RFWVideoUtils", 1, "createVideoInfo url empty");
            return SuperPlayerFactory.createVideoInfoForUrl("", 101, "");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        if (str.contains(getFlvKey())) {
            i17 = 202;
        } else if (str.contains(getRtmpKey())) {
            i17 = 103;
        } else if ((str.contains(".m3u8") || str.contains(".ts")) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_business_video_format", true)) {
            i17 = 201;
        }
        if (i16 > 0 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_business_video_format", true)) {
            createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl((String[]) arrayList.toArray(new String[arrayList.size()]), i16, str3, "");
        } else {
            createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl((String[]) arrayList.toArray(new String[arrayList.size()]), i17, str3, "");
        }
        createVideoInfoForUrl.setUrlHostList(new ArrayList<>(Arrays.asList(str2)));
        QLog.d("RFWVideoUtils", 1, "createVideoInfo videoUrl: " + createVideoInfoForUrl.getPlayUrl() + "videoDuration:" + i3);
        createVideoInfoForUrl.setVideoDurationMs((long) i3);
        return createVideoInfoForUrl;
    }

    public static boolean enableBackGroundPause(RFWPlayerOptions rFWPlayerOptions) {
        if (uq3.c.t0() && businessEnableInterceptor(rFWPlayerOptions)) {
            return true;
        }
        return false;
    }

    public static String getFileIdWithTapPosition(String str, String str2) {
        try {
            for (String str3 : Uri.parse(str).getPathSegments()) {
                if (str3.contains(".mp4")) {
                    return str3.substring(0, str3.indexOf(".mp4"));
                }
            }
        } catch (Exception e16) {
            QLog.d("RFWVideoUtils", 1, "getFileIdWithTapPosition exception:" + e16);
        }
        if (!TextUtils.isEmpty(str2)) {
            QLog.d("RFWVideoUtils", 1, "getFileIdWithTapPosition return vid" + str2);
            return str2;
        }
        if (!TextUtils.isEmpty(str)) {
            QLog.d("RFWVideoUtils", 1, "getFileIdWithTapPosition return url" + str);
            return str;
        }
        return "";
    }

    private static String getFlvKey() {
        if (o.o()) {
            return ".flv";
        }
        return "flv";
    }

    public static String getLocalCachePath(int i3, String str, String str2) {
        return new File(VIDEO_CACHE_FILE_PREF + i3 + String.format("/%s.mp4", getFileIdWithTapPosition(str, str2))).getPath();
    }

    public static long getPredictSpeedWithOutDownGrade(int i3) {
        RFWPlayerConfig config = RFWPlayerManger.g(i3).getConfig();
        Integer valueOf = Integer.valueOf(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
        if (config != null && RFWPlayerManger.g(i3).getConfig().getSpBandPredictor() != null) {
            long currentPrediction = RFWPlayerManger.g(i3).getConfig().getSpBandPredictor().getCurrentPrediction();
            long lastDownloadAvgSpeed = RFWPlayer.getLastDownloadAvgSpeed();
            if (currentPrediction > 0) {
                return ((float) currentPrediction) * uq3.c.K0();
            }
            if (lastDownloadAvgSpeed > 0) {
                return lastDownloadAvgSpeed;
            }
            return uq3.c.X0("qqcircle", "qqcir_hightLevelThreshold", valueOf).intValue();
        }
        return uq3.c.X0("qqcircle", "qqcir_hightLevelThreshold", valueOf).intValue();
    }

    private static String getRtmpKey() {
        if (o.o()) {
            return ".rtmp";
        }
        return "rtmp";
    }

    public static String getUrlHost(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            QLog.e("RFWVideoUtils", 1, "get host failed: " + str + ", error = " + e16.getMessage());
            return null;
        }
    }

    public static long getValidIntervalTime(String str) {
        long j3 = VALID_MAX_TIME - MiniBoxNoticeInfo.MIN_5;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return j3;
        }
        Uri parse = Uri.parse(str);
        if (parse != null && !TextUtils.isEmpty(parse.getHost())) {
            if (LONG_VALID_LIST.contains(parse.getHost())) {
                return VALID_MAX_TIME_QUIC - MiniBoxNoticeInfo.MIN_5;
            }
            if (isADUrl(str)) {
                return VALID_MAX_TIME_AD - MiniBoxNoticeInfo.MIN_5;
            }
            return j3;
        }
        return j3;
    }

    public static boolean isADUrl(String str) {
        return str.contains("adsmind.gdtimg.com");
    }

    public static boolean isAV1(RFWVideoUrlBean rFWVideoUrlBean) {
        if (rFWVideoUrlBean != null && rFWVideoUrlBean.mVideoEncode == 4) {
            return true;
        }
        return false;
    }

    public static boolean isSpecialError(int i3) {
        if (!"14020003".equals(String.valueOf(i3)) && !"14020004".equals(String.valueOf(i3)) && !"14010017".equals(String.valueOf(i3))) {
            return false;
        }
        return true;
    }

    public static boolean isValidSource(String str, String str2) {
        if (FileUtils.fileExists(str)) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return !TextUtils.isEmpty(str2);
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(host) && !TextUtils.isEmpty(path)) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            RFWLog.d("RFWVideoUtils", RFWLog.USR, e16);
            return false;
        }
    }

    public static int parseSceneIdFromUrl(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 126;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("client_sceneId");
            if (TextUtils.isEmpty(queryParameter)) {
                return 126;
            }
            return Integer.parseInt(queryParameter);
        } catch (Exception e16) {
            QLog.e("RFWVideoUtils", 1, e16, new Object[0]);
            return 126;
        }
    }

    public static void reportUrl(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        QCircleQualityReporter.reportQualityEvent("qcircle_player_error_url", (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("url", String.valueOf(str)), QCircleReportHelper.newEntry("ret_code", String.valueOf(i3))));
    }
}
