package cooperation.qzone.statistic;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AccManager {
    private static final String CMD_CALL_MUSIC = "qzonenewservice.call.music";
    private static final String CMD_JUMP_QZONE = "qzonenewservice.to.qzone";
    private static final String CMD_JUMP_QZONE_FROMQQ = "qzonenewservice.qq.to.qzone";
    private static final String CMD_JUMP_QZONE_WAP = "qzonenewservice.to.qzonewap";
    private static final String CMD_JUMP_QZONE_WAP_FROMQQ = "qzonenewservice.qq.to.qzonewap";
    private static final String CMD_KEY_POINT = "qzonenewservice.debug.keypoint";
    private static final String CMD_LAUNCH = "qzonenewservice.launchtime";
    private static final String CMD_OUTBOX = "qzonenewservice.opBox";
    private static final String CMD_QZLOG_EMAIL = "QZLog.email";
    public static final String CMD_QZONE_FEEDVIDEO_PLAY = "Qzone.FeedVideo.Play";
    private static final String CMD_QZONE_FEED_STICKER_GET_REPORT = "Feeds.getStickerGif";
    public static final String CMD_QZONE_FORWARD_REPORT = "QzoneNewService.forwardReport";
    private static final String CMD_QZONE_MUSIC_SDK_PLAY = "QzoneNewService.MusicSdkPlay";
    public static final String CMD_QZONE_NICKNAME = "Qzone.emptynickname";
    private static final String CMD_QZONE_OPNEVIP = "qzonenewservice.openvip";
    public static final String CMD_QZONE_PREDOWNLOAD = "QzoneNewService.predownload";
    private static final String CMD_QZONE_WAP_WEBERROR = "qzonenewservice.qzonewap.weberror";
    public static final String CMD_QZONE_WIFI_IMAGE_PREDOWN_CACHE_HIT = "QzoneNewService.hit_feedimage";
    public static final String CMD_QZONE_WIFI_IMAGE_PREDOWN_SUSPEND = "QzoneNewService.suspend_predownload";
    private static final String CMD_REFRESH = "qzonenewservice.refresh";
    private static final String CMD_REFRESH_MORE = "qzonenewservice.refresh.more";
    private static final String CMD_TRAFFICDATA_DAY = "qzonenewservice.traffic.day";
    public static final String CMD_WNS_INTERNAL_CRASH_RELATED_SERVERIP = "wns.internal.crashRelatedServerIP";
    public static final String PREFIX_ACTIVITY_SWITCH = "QZoneAPPInQQ.activiySwitch.";
    public static final int RESULT_CODE_FORWARD_REPORT = 900103;
    private static final int seqEnd = 1000000;
    private static final AtomicInteger seqFactory = new AtomicInteger(0);
    private static final int seqStart = 0;

    public static void createStatistic(String str, int i3, String str2, int i16) {
        createStatistic(str, i3, str2, i16, 0, null);
    }

    public static synchronized int getNextSeq() {
        int incrementAndGet;
        synchronized (AccManager.class) {
            AtomicInteger atomicInteger = seqFactory;
            incrementAndGet = atomicInteger.incrementAndGet();
            if (incrementAndGet > 1000000) {
                atomicInteger.set(0);
            }
        }
        return incrementAndGet;
    }

    public static void jumpQZoneWap(String str) {
        createStatistic(CMD_JUMP_QZONE_WAP, 1100006, str, 1);
    }

    public static void reportActivitySwitch(String str, int i3) {
        createStatistic(PREFIX_ACTIVITY_SWITCH + str, 0, i3, null, QZoneConfigHelper.K(), 0, null);
    }

    public static void reportCallMusic(String str) {
        createStatistic(CMD_CALL_MUSIC, 0, str, 1);
    }

    public static void reportCrashRelatedServerIP(int i3, String str) {
        createStatistic(CMD_WNS_INTERNAL_CRASH_RELATED_SERVERIP, i3, str, 1);
    }

    public static void reportFeedVideoPlay(int i3, String str) {
        createStatistic(CMD_QZONE_FEEDVIDEO_PLAY, i3, str, 1);
    }

    public static void reportForward(int i3) {
        createStatistic(CMD_QZONE_FORWARD_REPORT, i3, null, 1);
    }

    public static void reportGetSticker(int i3, String str) {
        createStatistic(CMD_QZONE_FEED_STICKER_GET_REPORT, i3, str, 1);
    }

    public static void reportImagePredownCacheHitRate(float f16, String str) {
        createStatistic(CMD_QZONE_WIFI_IMAGE_PREDOWN_CACHE_HIT, (int) (f16 * 100.0f), str, 1);
        QZLog.i("QZLog[reportImagePredownCacheHitRate]", 1, str);
    }

    public static void reportImagePredownSuccessRate(int i3, int i16) {
        if (i16 == 0) {
            return;
        }
        int i17 = (int) (((i3 * 1.0f) / i16) * 100.0f);
        String str = "successRate=" + i17 + "(" + i3 + "/" + i16 + ")";
        createStatistic(CMD_QZONE_WIFI_IMAGE_PREDOWN_SUSPEND, i17, str, 1);
        QZLog.i("QZLog[FeedsImagePreDownloader]", 1, str);
    }

    public static void reportJumpQZone(String str) {
        createStatistic(CMD_JUMP_QZONE, 1100003, str, 1);
    }

    public static void reportMusicSDKPlay(int i3, String str) {
        createStatistic(CMD_QZONE_MUSIC_SDK_PLAY, i3, str, 1);
    }

    public static void reportOpenQZoneVipResult(int i3, String str) {
        createStatistic(CMD_QZONE_OPNEVIP, i3 + 1300000, str, 1);
    }

    public static void reportOutboxResult(int i3, int i16, String str, String str2) {
        String str3 = "";
        if (i3 == 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("errorCode = ");
            sb5.append(i16);
            sb5.append(", msg = ");
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            str3 = sb5.toString();
        }
        createStatistic(CMD_OUTBOX, i3, str3, 0, 5, str2);
    }

    public static void reportTimeWithRefresh(String str, boolean z16) {
        createStatistic(CMD_REFRESH, 0, null, !z16 ? 1 : 0, 1, str);
    }

    public static void reportTimeWithRefreshMore(String str, boolean z16) {
        createStatistic(CMD_REFRESH_MORE, 0, null, !z16 ? 1 : 0, 1, str);
    }

    public static void reportTimeWithStep(String str, boolean z16) {
        createStatistic(CMD_LAUNCH, 0, null, !z16 ? 1 : 0, 1, str);
    }

    private static void createStatistic(String str, int i3, String str2, int i16, int i17, String str3) {
        if (MobileQQ.sMobileQQ == null) {
            return;
        }
        long longAccountUin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getLongAccountUin() != 0 ? ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getLongAccountUin() : 0L;
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.CommandId, str);
        statistic.setValue(WnsKeys.APN, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAPN());
        statistic.setValue(WnsKeys.Sequence, Integer.valueOf(getNextSeq()));
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(longAccountUin));
        statistic.setValue(WnsKeys.Qua, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        if (str2 != null) {
            statistic.setValue(WnsKeys.Detail, str2);
        }
        if (i16 > 0) {
            statistic.setValue(WnsKeys.Frequency, Integer.valueOf(i16));
        }
        if (i17 > 0) {
            statistic.setValue(WnsKeys.DType, Integer.valueOf(i17));
            statistic.setValue(WnsKeys.ODetails, str3);
        }
        statisticCollector.put(statistic);
        if (i16 == 1) {
            statisticCollector.forceReport();
        }
    }

    private static void createStatistic(String str, int i3, int i16, String str2, int i17, int i18, String str3) {
        if (MobileQQ.sMobileQQ == null) {
            return;
        }
        long longAccountUin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getLongAccountUin() != 0 ? ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getLongAccountUin() : 0L;
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.CommandId, str);
        statistic.setValue(WnsKeys.APN, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAPN());
        statistic.setValue(WnsKeys.Sequence, Integer.valueOf(getNextSeq()));
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(longAccountUin));
        statistic.setValue(WnsKeys.Qua, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        statistic.setValue(WnsKeys.TimeCost, Integer.valueOf(i16));
        if (str2 != null) {
            statistic.setValue(WnsKeys.Detail, str2);
        }
        if (i17 > 0) {
            statistic.setValue(WnsKeys.Frequency, Integer.valueOf(i17));
        }
        if (i18 > 0) {
            statistic.setValue(WnsKeys.DType, Integer.valueOf(i18));
            statistic.setValue(WnsKeys.ODetails, str3);
        }
        statisticCollector.put(statistic);
        if (i17 == 1) {
            statisticCollector.forceReport();
        }
    }
}
