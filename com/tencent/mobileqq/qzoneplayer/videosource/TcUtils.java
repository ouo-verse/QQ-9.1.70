package com.tencent.mobileqq.qzoneplayer.videosource;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCoverUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.report.ReportState;
import com.tencent.oskplayer.util.PassOnVideoType;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TcUtils {
    private static final String SPEED_TAG = "[VideoRate]";
    private static final String TAG = "TcUtils";
    public static int lastError;
    public static volatile int sErrorCode;
    public static com.tencent.mobileqq.qzoneplayer.videosource.b sTcDataSourceUtils;
    public static f sTcVideoDataSource;
    private static int sCallbackOverTime = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoCallbackOverTime", 600000);
    public static List<String> sErrorList = Collections.synchronizedList(new ArrayList());
    public static Map<String, b> sRetryUrlMap = new HashMap();
    private static int LOG_PRINT_LEVEL = 3;
    private HashMap<Integer, Long> trafficMonitor = new HashMap<>(10, 0.75f);
    private HashMap<Integer, a> mTcElementMap = new HashMap<>(16);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f280059a;

        /* renamed from: b, reason: collision with root package name */
        public int f280060b;

        /* renamed from: c, reason: collision with root package name */
        public long f280061c;

        /* renamed from: d, reason: collision with root package name */
        public int f280062d;

        /* renamed from: e, reason: collision with root package name */
        public DataSpec f280063e;

        public b(String str, int i3, long j3, int i16, DataSpec dataSpec) {
            this.f280059a = str;
            this.f280060b = i3;
            this.f280061c = j3;
            this.f280062d = i16;
            this.f280063e = dataSpec;
        }
    }

    public static void setTcDataSourceUtils(com.tencent.mobileqq.qzoneplayer.videosource.b bVar) {
        sTcDataSourceUtils = bVar;
    }

    public static void setTcVideoDataSource(f fVar) {
        sTcVideoDataSource = fVar;
    }

    public void downloadCallBack(final String str) {
        runOnCoverThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.videosource.TcUtils.1
            @Override // java.lang.Runnable
            public void run() {
                TcUtils.this.downloadCallBackAsync(str);
            }
        });
    }

    public void httpproxyReport(String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str : strArr) {
            sb5.append(str);
        }
        FeedVideoEnv.externalFunc.reportTcSDK(sb5.toString());
    }

    public void idKeyReport(String str, String str2, String str3) {
        PlayerUtils.log(4, "idKeyReport", str + ":" + str2 + ":" + str3);
    }

    public void javaUtilLog(int i3, String str, String str2) {
        PlayerUtils.log(i3, str, str2);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f280056a;

        /* renamed from: b, reason: collision with root package name */
        private float f280057b;

        /* renamed from: c, reason: collision with root package name */
        private int f280058c;

        public a(int i3) {
            this.f280056a = i3;
        }

        public int b() {
            return (int) (this.f280057b / this.f280058c);
        }

        public void a(int i3) {
            if (i3 > 0) {
                this.f280057b += i3;
                this.f280058c++;
            }
        }
    }

    public void kvReport(String... strArr) {
        for (String str : strArr) {
            PlayerUtils.log(4, "httpproxy_report", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void downloadCallBackAsync(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i3;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        List<String> list;
        int i16;
        int i17;
        int i18;
        int i19;
        PlayerUtils.log(4, TAG, "downloadCallBack: " + str);
        c a16 = c.a(str);
        if (a16 == null) {
            PlayerUtils.log(4, TAG, "downloadCallBack: tcUtils is null !");
            return;
        }
        lastError = a16.f280079i;
        a aVar = this.mTcElementMap.get(Integer.valueOf(a16.f280072b));
        if (aVar == null) {
            aVar = new a(a16.f280072b);
            this.mTcElementMap.put(Integer.valueOf(a16.f280072b), aVar);
        }
        aVar.a(a16.f280078h);
        if (a16.f280071a == 3) {
            PlayerUtils.log(4, TAG, "[VideoRate]playID:" + aVar.f280056a + " mAverageSpeed:" + aVar.b() + "KB/s");
            if (this.mTcElementMap.size() >= yl2.c.e().h()) {
                int i26 = 0;
                int i27 = 0;
                for (Map.Entry<Integer, a> entry : this.mTcElementMap.entrySet()) {
                    if (entry.getValue().b() > 0) {
                        i27 += entry.getValue().b();
                        i26++;
                    }
                }
                if (i26 != 0) {
                    int i28 = i27 / i26;
                    PlayerUtils.log(4, TAG, "[VideoRate]averageSpeed --- " + i28);
                    yl2.c.e().m(i28);
                }
                this.mTcElementMap.clear();
            }
        }
        String valueOf = String.valueOf(a16.f280072b);
        String uuid = UuidPlayIdMap.getUuid(valueOf);
        if (TextUtils.isEmpty(uuid) || PlayerConfig.g().getVideoReporter() == null || ReportState.REPORT_STATE_REPORTED != PlayerConfig.g().getVideoReporter().getReportState(uuid)) {
            boolean evaluate = !TextUtils.isEmpty(a16.f280085o) ? new PassOnVideoType().evaluate(a16.f280085o) : true;
            if (!evaluate && !TextUtils.isEmpty(a16.f280082l) && sTcVideoDataSource != null && sTcDataSourceUtils != null) {
                if (!sErrorList.contains(a16.f280082l)) {
                    sErrorList.add(a16.f280082l);
                }
                sTcDataSourceUtils.deleteFileOnDisk(a16.f280082l);
            }
            if (evaluate && !TextUtils.isEmpty(a16.f280082l) && sTcVideoDataSource != null) {
                int i29 = a16.f280080j;
                if (i29 != 403) {
                    if (i29 == 416 && sTcDataSourceUtils != null) {
                        PlayerUtils.log(4, TAG, "downloadCallBack: 416, " + a16.f280082l);
                        if (!sErrorList.contains(a16.f280082l)) {
                            sErrorList.add(a16.f280082l);
                        }
                        sTcDataSourceUtils.deleteFileOnDisk(a16.f280082l);
                    }
                } else {
                    if (sRetryUrlMap == null || TextUtils.isEmpty(a16.f280082l)) {
                        return;
                    }
                    sErrorCode = 403;
                    if (sTcDataSourceUtils != null && !sErrorList.contains(a16.f280082l)) {
                        sErrorList.add(a16.f280082l);
                    }
                    PlayerUtils.log(4, TAG, "downloadCallBack: 403 url = " + a16.f280082l + ", video key = " + PlayerUtils.parseVideoKey(a16.f280082l));
                    if (sRetryUrlMap.containsKey(a16.f280082l)) {
                        b bVar = sRetryUrlMap.get(a16.f280082l);
                        bVar.f280060b++;
                        bVar.f280061c = System.currentTimeMillis();
                        sRetryUrlMap.put(a16.f280082l, bVar);
                    } else {
                        sRetryUrlMap.put(a16.f280082l, new b(a16.f280082l, 0, System.currentTimeMillis(), 403, new DataSpec(Uri.parse(a16.f280082l), 0L, 0L, -1L, PlayerUtils.parseVideoKey(a16.f280082l), 0, null)));
                    }
                    Iterator<Map.Entry<String, b>> it = sRetryUrlMap.entrySet().iterator();
                    while (it.hasNext()) {
                        if (System.currentTimeMillis() - it.next().getValue().f280061c > sCallbackOverTime) {
                            it.remove();
                        }
                    }
                }
            }
            int i36 = a16.f280071a;
            if (i36 != 2) {
                str2 = valueOf;
                str3 = TAG;
                str4 = uuid;
                str5 = ",downloadSum=";
                str6 = "VideoTrafficMonitorThreshold";
                str7 = " download finished";
                str8 = "VideoSDKSetting";
                str9 = ",fileSize=";
                if (i36 == 3) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(a16.f280072b);
                    str10 = str7;
                    sb5.append(str10);
                    PlayerUtils.log(4, str3, sb5.toString());
                    this.trafficMonitor.remove(Integer.valueOf(a16.f280072b));
                    FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
                    if (feedVideoExternalFunc != null) {
                        str11 = str6;
                        str12 = str8;
                        i3 = feedVideoExternalFunc.getWnsConfig(str12, str11, 5);
                    } else {
                        str11 = str6;
                        str12 = str8;
                        PlayerUtils.log(6, str3, "VideoTrafficMonitorThreshold error FeedVideoEnv.externalFunc is null");
                        i3 = 5;
                    }
                    long j3 = a16.f280076f;
                    long j16 = a16.f280074d;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("VideoTrafficMonitorThresholdV2=");
                    sb6.append(i3);
                    str13 = str5;
                    sb6.append(str13);
                    sb6.append(j3);
                    str14 = "traffic_monitor_detail";
                    str15 = str9;
                    sb6.append(str15);
                    sb6.append(j16);
                    str16 = "_";
                    PlayerUtils.log(4, str3, sb6.toString());
                    if (j3 <= 0 || j16 <= 0) {
                        str17 = "traffic_monitor_flag";
                    } else {
                        str17 = "traffic_monitor_flag";
                        if (j3 > i3 * j16) {
                            PlayerUtils.log(4, str3, "reportVideoTrafficMonitorThresholdErrorV2,downloadSum=" + j3 + str15 + j16);
                        } else {
                            PlayerUtils.log(4, str3, "reportVideoTrafficMonitorThresholdNormalV2,downloadSum=" + j3 + str15 + j16);
                        }
                    }
                    if (a16.f280071a == 2) {
                        int i37 = a16.f280072b;
                        if (UuidPlayIdMap.isTcPlayIdShouldStopped(i37)) {
                            PlayerUtils.log(6, str3, "playDataId " + str2 + " should stopped");
                            com.tencent.mobileqq.qzoneplayer.videosource.b.b().stopPlay(i37);
                        }
                    }
                    if (a16.f280071a == 3) {
                        long j17 = a16.f280076f;
                        long j18 = a16.f280074d;
                        PlayerUtils.log(4, str3, a16.f280072b + str10);
                        this.trafficMonitor.remove(Integer.valueOf(a16.f280072b));
                        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc2 = FeedVideoEnv.externalFunc;
                        if (feedVideoExternalFunc2 != null) {
                            int wnsConfig = feedVideoExternalFunc2.getWnsConfig(str12, str11, 5);
                            PlayerUtils.log(4, str3, "VideoTrafficMonitorThreshold=" + wnsConfig + str13 + j17 + str15 + j18);
                            try {
                                i18 = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
                            } catch (Throwable unused) {
                                i18 = -2;
                            }
                            if (j17 > 0 && j18 > 0) {
                                if (j17 > wnsConfig * j18) {
                                    if (FeedVideoEnv.externalFunc != null) {
                                        HashMap<String, Object> hashMap = new HashMap<>();
                                        hashMap.put(str17, "video_traffic_err_" + i18);
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append(FeedVideoEnv.externalFunc.getLoginUin());
                                        String str18 = str16;
                                        sb7.append(str18);
                                        sb7.append(j17 / j18);
                                        sb7.append(str18);
                                        sb7.append(i18);
                                        hashMap.put(str14, sb7.toString());
                                        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_TRAFFIC_MONITOR, hashMap);
                                        i17 = 4;
                                        PlayerUtils.log(4, str3, "reportVideoTrafficMonitorThresholdError,downloadSum=" + j17 + str15 + j18);
                                        PlayerUtils.log(i17, str3, "kkUploadVideoTrafficMonitorV2");
                                    }
                                } else if (FeedVideoEnv.externalFunc != null) {
                                    HashMap<String, Object> hashMap2 = new HashMap<>();
                                    hashMap2.put(str17, "video_traffic_ok_" + i18);
                                    FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_TRAFFIC_MONITOR, hashMap2);
                                    i17 = 4;
                                    PlayerUtils.log(4, str3, "reportVideoTrafficMonitorThresholdNormal,downloadSum=" + j17 + str15 + j18);
                                    PlayerUtils.log(i17, str3, "kkUploadVideoTrafficMonitorV2");
                                }
                            }
                        }
                        i17 = 4;
                        PlayerUtils.log(i17, str3, "kkUploadVideoTrafficMonitorV2");
                    }
                    if (PlayerConfig.g().getVideoReporter() != null) {
                        if (!TextUtils.isEmpty(a16.f280086p)) {
                            PlayerConfig.g().getVideoReporter().downloadServerIp("IgnoreVideoUUID", a16.f280086p);
                        }
                        if (a16.f280071a == 2) {
                            i16 = 1;
                            PlayerConfig.g().getVideoReporter().downloadSizeAndDuration(str4, a16.f280076f, a16.f280078h > 0 ? (a16.f280076f * 1000) / (r2 * 1024) : 0L, a16.f280074d, a16.f280077g);
                        } else {
                            i16 = 1;
                        }
                        if (a16.f280071a == i16) {
                            PlayerConfig.g().getVideoReporter().downloadServerCost(str4, a16.f280092v, a16.f280093w, a16.f280094x);
                        }
                    }
                    if (PlayerConfig.g().getVideoReporter() != null || str4 == null || (list = a16.f280084n) == null || list.size() == 0 || a16.f280090t <= 0) {
                        return;
                    }
                    PlayerConfig.g().getVideoReporter().urlRedirectOccurred(str4, PlayerUtils.join(a16.f280084n.iterator(), "|"), a16.f280091u, a16.f280090t);
                    return;
                }
            } else {
                Integer valueOf2 = Integer.valueOf(a16.f280072b);
                Long valueOf3 = Long.valueOf(a16.f280076f);
                Long l3 = this.trafficMonitor.get(valueOf2);
                if (l3 == null) {
                    this.trafficMonitor.put(valueOf2, valueOf3);
                } else {
                    this.trafficMonitor.put(valueOf2, Long.valueOf(l3.longValue() + valueOf3.longValue()));
                }
                FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc3 = FeedVideoEnv.externalFunc;
                if (feedVideoExternalFunc3 == null) {
                    str3 = TAG;
                    PlayerUtils.log(6, str3, "VideoTrafficErrorThresholdNum error FeedVideoEnv.externalFunc is null");
                    str4 = uuid;
                    i19 = 4;
                } else {
                    i19 = feedVideoExternalFunc3.getWnsConfig("VideoSDKSetting", "VideoTrafficErrorThresholdNum", 4);
                    str3 = TAG;
                    str4 = uuid;
                }
                long j19 = a16.f280074d;
                str2 = valueOf;
                str5 = ",downloadSum=";
                str6 = "VideoTrafficMonitorThreshold";
                long longValue = this.trafficMonitor.get(valueOf2).longValue();
                StringBuilder sb8 = new StringBuilder();
                str8 = "VideoSDKSetting";
                sb8.append("playId=");
                sb8.append(valueOf2);
                sb8.append(",fileSize=");
                sb8.append(j19);
                sb8.append(",playIdTotalDownloadSum=");
                sb8.append(longValue);
                sb8.append(",threshold=");
                str9 = ",fileSize=";
                long j26 = i19 * j19;
                sb8.append(j26);
                str7 = " download finished";
                sb8.append(",thresholdNum=");
                sb8.append(i19);
                PlayerUtils.log(4, str3, sb8.toString());
                if (j19 > 0 && longValue > 0 && longValue > j26) {
                    PlayerUtils.log(4, str3, "MaxVideoTrafficErrorThresholdTriggered stop playid=" + valueOf2);
                    com.tencent.mobileqq.qzoneplayer.videosource.b.b().stopPlay(valueOf2.intValue());
                    HashMap<String, Object> hashMap3 = new HashMap<>();
                    hashMap3.put("traffic_monitor_flag", "video_traffic_warn");
                    hashMap3.put("traffic_monitor_detail", FeedVideoEnv.externalFunc.getLoginUin() + "_" + (longValue / j19));
                    FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_TRAFFIC_MONITOR, hashMap3);
                    this.trafficMonitor.remove(Integer.valueOf(a16.f280072b));
                }
            }
            str17 = "traffic_monitor_flag";
            str13 = str5;
            str11 = str6;
            str12 = str8;
            str10 = str7;
            str14 = "traffic_monitor_detail";
            str16 = "_";
            str15 = str9;
            if (a16.f280071a == 2) {
            }
            if (a16.f280071a == 3) {
            }
            if (PlayerConfig.g().getVideoReporter() != null) {
            }
            if (PlayerConfig.g().getVideoReporter() != null) {
            }
        }
    }

    public void runOnCoverThread(Runnable runnable) {
        HandlerThread coverThread;
        if (runnable == null || (coverThread = BaseVideoCoverUtils.getInstance().getCoverThread()) == null || coverThread.getLooper() == null) {
            return;
        }
        Handler handler = new Handler(coverThread.getLooper());
        if (coverThread.getLooper().getThread() != Thread.currentThread()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
