package com.tencent.mobileqq.qzoneplayer.report;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlaybackReportInfo;
import com.tencent.mobileqq.qzoneplayer.videosource.TcUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.report.ReportState;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoReporter implements IVideoReporter {

    /* renamed from: r0, reason: collision with root package name */
    private static int f279470r0 = 1;

    /* renamed from: s0, reason: collision with root package name */
    private static boolean f279471s0 = PlayerConfig.g().isIResearchEnabled();

    /* renamed from: t0, reason: collision with root package name */
    private static int f279472t0;

    /* renamed from: u0, reason: collision with root package name */
    private static int f279473u0;
    private long A;
    private long B;
    private long C;
    private long D;
    private long E;
    private long H;
    private String I;
    private String J;
    private long K;
    private long L;
    private long M;
    private long N;
    private long O;
    private long P;
    private long Q;

    /* renamed from: d, reason: collision with root package name */
    private long f279480d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f279482e;

    /* renamed from: f, reason: collision with root package name */
    private long f279484f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f279486g;

    /* renamed from: h, reason: collision with root package name */
    private long f279488h;

    /* renamed from: h0, reason: collision with root package name */
    private volatile VideoPlaybackReportInfo f279489h0;

    /* renamed from: i, reason: collision with root package name */
    private long f279490i;

    /* renamed from: i0, reason: collision with root package name */
    private int f279491i0;

    /* renamed from: j, reason: collision with root package name */
    private long f279492j;

    /* renamed from: k, reason: collision with root package name */
    private String f279494k;

    /* renamed from: l, reason: collision with root package name */
    private String f279496l;

    /* renamed from: m, reason: collision with root package name */
    private int f279498m;

    /* renamed from: m0, reason: collision with root package name */
    private c f279499m0;

    /* renamed from: n, reason: collision with root package name */
    private String f279500n;

    /* renamed from: n0, reason: collision with root package name */
    private com.tencent.mobileqq.qzoneplayer.report.a f279501n0;

    /* renamed from: o, reason: collision with root package name */
    private String f279502o;

    /* renamed from: p, reason: collision with root package name */
    private int f279504p;

    /* renamed from: q, reason: collision with root package name */
    private long f279506q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f279508r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f279509s;

    /* renamed from: t, reason: collision with root package name */
    private long f279510t;

    /* renamed from: u, reason: collision with root package name */
    private long f279511u;

    /* renamed from: v, reason: collision with root package name */
    private long f279512v;

    /* renamed from: w, reason: collision with root package name */
    private int f279513w;

    /* renamed from: x, reason: collision with root package name */
    private int f279514x;

    /* renamed from: y, reason: collision with root package name */
    private int f279515y;

    /* renamed from: z, reason: collision with root package name */
    private long f279516z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f279474a = false;

    /* renamed from: b, reason: collision with root package name */
    private ReportState f279476b = ReportState.REPORT_STATE_NONE;

    /* renamed from: c, reason: collision with root package name */
    private int f279478c = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "maxVideoFirstBufferOverTime", 40000);
    private long F = -1;
    private long G = -1;
    private long R = 0;
    private long S = 0;
    private long T = 0;
    private long U = -1;
    private long V = 0;
    private boolean W = false;
    private List<Pair<Long, Long>> X = new ArrayList();
    private List<Pair<Long, Long>> Y = new ArrayList();
    private List<Pair<Long, Long>> Z = new LinkedList();

    /* renamed from: a0, reason: collision with root package name */
    private List<Pair<Long, Long>> f279475a0 = new LinkedList();

    /* renamed from: b0, reason: collision with root package name */
    private ArrayList<Map<String, String>> f279477b0 = new ArrayList<>();

    /* renamed from: c0, reason: collision with root package name */
    private ArrayList<Map<String, String>> f279479c0 = new ArrayList<>();

    /* renamed from: d0, reason: collision with root package name */
    private Map<String, String> f279481d0 = new HashMap();

    /* renamed from: e0, reason: collision with root package name */
    private List<Pair<Integer, Long>> f279483e0 = new ArrayList();

    /* renamed from: f0, reason: collision with root package name */
    private List<Pair<Long, String>> f279485f0 = new ArrayList();

    /* renamed from: g0, reason: collision with root package name */
    private List<Pair<Integer, Integer>> f279487g0 = new ArrayList();

    /* renamed from: j0, reason: collision with root package name */
    private long f279493j0 = -1;

    /* renamed from: k0, reason: collision with root package name */
    private long f279495k0 = -1;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f279497l0 = false;

    /* renamed from: o0, reason: collision with root package name */
    private Map<String, Long> f279503o0 = new HashMap();

    /* renamed from: p0, reason: collision with root package name */
    private String f279505p0 = "";

    /* renamed from: q0, reason: collision with root package name */
    private Map<String, Object> f279507q0 = new HashMap(4, 0.75f);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public enum DecoderErrType {
        ILLEGAL_STATE,
        INIT,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f279517a;

        static {
            int[] iArr = new int[ReportState.values().length];
            f279517a = iArr;
            try {
                iArr[ReportState.REPORT_STATE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f279517a[ReportState.REPORT_STATE_PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f279517a[ReportState.REPORT_STATE_MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f279517a[ReportState.REPORT_STATE_REPORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f279517a[ReportState.REPORT_STATE_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f279518a;

        /* renamed from: b, reason: collision with root package name */
        public String f279519b;

        /* renamed from: c, reason: collision with root package name */
        public String f279520c;

        /* renamed from: d, reason: collision with root package name */
        public long f279521d;

        /* renamed from: e, reason: collision with root package name */
        public long f279522e;

        /* renamed from: f, reason: collision with root package name */
        public long f279523f;

        /* renamed from: g, reason: collision with root package name */
        public long f279524g;

        /* renamed from: h, reason: collision with root package name */
        public int f279525h;

        /* renamed from: i, reason: collision with root package name */
        public int f279526i;

        /* renamed from: j, reason: collision with root package name */
        public int f279527j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f279528k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f279529l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f279530m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f279531n;

        /* renamed from: o, reason: collision with root package name */
        public Map<String, String> f279532o;

        /* renamed from: p, reason: collision with root package name */
        public Object f279533p;

        public b() {
        }

        public b(long j3, long j16, long j17) {
            this.f279521d = j3;
            this.f279522e = j16;
            this.f279523f = j17;
        }

        public b(String str, long j3, long j16, int i3, boolean z16) {
            this.f279518a = str;
            this.f279521d = j3;
            this.f279522e = j16;
            this.f279525h = i3;
            this.f279528k = z16;
        }

        public b(String str, int i3) {
            this.f279518a = str;
            this.f279525h = i3;
        }

        public b(String str, long j3, long j16, long j17, long j18, boolean z16) {
            this.f279518a = str;
            this.f279521d = j3;
            this.f279522e = j16;
            this.f279523f = j17;
            this.f279524g = j18;
            this.f279528k = z16;
        }

        public b(String str, String str2, long j3, long j16, int i3, boolean z16) {
            this.f279518a = str;
            this.f279519b = str2;
            this.f279521d = j3;
            this.f279522e = j16;
            this.f279525h = i3;
            this.f279528k = z16;
        }

        public b(String str, String str2, String str3, long j3, long j16, int i3, boolean z16, boolean z17, boolean z18, boolean z19, int i16) {
            this.f279518a = str;
            this.f279519b = str2;
            this.f279520c = str3;
            this.f279521d = j3;
            this.f279522e = j16;
            this.f279525h = i3;
            this.f279528k = z16;
            this.f279529l = z17;
            this.f279530m = z18;
            this.f279531n = z19;
            this.f279526i = i16;
        }

        public b(String str) {
            this.f279518a = str;
        }

        public b(String str, boolean z16) {
            this.f279518a = str;
            this.f279528k = z16;
        }

        public b(String str, String str2) {
            this.f279518a = str;
            this.f279519b = str2;
        }

        public b(String str, int i3, long j3, int i16, String str2) {
            this.f279518a = str;
            this.f279525h = i3;
            this.f279521d = j3;
            this.f279527j = i16;
            this.f279519b = str2;
        }

        public b(Map<String, String> map) {
            this.f279532o = map;
        }

        public b(Object obj) {
            this.f279533p = obj;
        }

        public b(String str, String str2, Object obj) {
            this.f279518a = str;
            this.f279519b = str2;
            this.f279533p = obj;
        }
    }

    public VideoReporter(com.tencent.mobileqq.qzoneplayer.report.a aVar, long j3) {
        HandlerThread handlerThread = new HandlerThread("VideoReporter");
        handlerThread.start();
        this.f279499m0 = new c(handlerThread.getLooper());
        if (aVar != null) {
            this.f279501n0 = aVar;
        }
        this.f279480d = j3;
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String str, long j3) {
        PlayerUtils.log(3, "VideoReporter", "doJustReportVideoEventToDC00321: stoppedPosition=" + j3);
        if (r1(str, "doJustReportVideoEventToDC00321")) {
            J(this.G, j3);
            this.H = j3;
            B1();
            this.f279514x = 0;
            if (this.f279489h0 != null) {
                if (!TextUtils.isEmpty(this.f279489h0.f279935h) && (this.f279489h0.f279935h.equals("1") || this.f279489h0.f279935h.equals("2") || this.f279489h0.f279935h.equals("3"))) {
                    this.f279489h0.f279935h = "4";
                } else if (!this.f279489h0.f279935h.equals("11")) {
                    this.f279489h0.f279935h = "1";
                }
            }
            this.G = j3;
            this.Y.clear();
            this.f279475a0.clear();
        }
    }

    private void A1() {
        PlayerUtils.log(3, "VideoReporter", "reportVideoEventListToMta: size=" + this.f279477b0.size());
        Iterator<Map<String, String>> it = this.f279477b0.iterator();
        while (it.hasNext()) {
            Map<String, String> next = it.next();
            HashMap hashMap = new HashMap();
            for (String str : next.keySet()) {
                if (I1(str)) {
                    hashMap.put(str, next.get(str));
                }
            }
            this.f279501n0.g(next.get("event_id"), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(String str) {
        PlayerUtils.log(3, "VideoReporter", "doLoopPlayVideo: mAnyStartPlayPosition=" + this.F + ", mVideoDuration=" + this.f279506q);
        if (r1(str, "doLoopPlayVideo")) {
            this.f279483e0.add(new Pair<>(11, Long.valueOf(System.currentTimeMillis())));
            I(this.F, this.f279506q);
            J(this.G, this.f279506q);
            this.F = 0L;
            this.G = 0L;
        }
    }

    private void B1() {
        String str;
        String str2;
        String str3;
        PlayerUtils.log(3, "VideoReporter", "reportVideoEventToDc00321()");
        if (this.f279489h0 == null) {
            PlayerUtils.log(3, "VideoReporter", "reportVideoEventToDc00321: ignore - mVideoPlaybackReportInfo is null");
            return;
        }
        if (this.f279489h0.f279933e0) {
            PlayerUtils.log(3, "VideoReporter", "reportVideoEventToDc00321: ignore - videoPlaybackReportInfo shield321VVReport");
            return;
        }
        if (i1() == 0 && Long.valueOf(m1()).longValue() == 0) {
            PlayerUtils.log(3, "VideoReporter", "reportVideoEventToDc00321: ignore - video_play_time && video_solo_time is 0");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile_type", X0());
        String str4 = "2";
        hashMap.put("device", "2");
        hashMap.put("refer", this.f279489h0.K);
        String str5 = "1";
        if (!this.f279489h0.f279934f) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("is_original", str);
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_TOTAL_TIME, o1());
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_PLAY_TIME, String.valueOf(i1()));
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_SOLO_TIME, m1());
        if (this.f279489h0.f279931d0) {
            str2 = "25";
        } else {
            str2 = this.f279489h0.f279935h;
        }
        hashMap.put("video_play_scene", str2);
        hashMap.put("video_sources", this.f279489h0.f279936i);
        if (this.f279489h0.f279932e) {
            str4 = "1";
        }
        hashMap.put("is_auto_play", str4);
        hashMap.put(QCircleLpReportDc05494.KEY_PHOTOCUBAGE, this.f279489h0.C);
        hashMap.put("width", this.f279489h0.D);
        hashMap.put("height", this.f279489h0.E);
        hashMap.put("vid", this.f279489h0.f279930d);
        hashMap.put("author_uin", this.f279489h0.G);
        String str6 = "0";
        if (this.f279514x <= 0) {
            str5 = "0";
        }
        hashMap.put("is_video_seek", str5);
        hashMap.put("repost_uin", this.f279489h0.H);
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_ID, String.valueOf(this.f279492j));
        hashMap.put("shuoshuoid", this.f279489h0.I);
        hashMap.put("seq", a1() + "");
        hashMap.put("write_from", this.f279489h0.J);
        hashMap.put("extendinfo", this.f279489h0.F);
        String str7 = this.f279489h0.f279929c0;
        if (FeedVideoEnv.externalFunc != null) {
            str6 = FeedVideoEnv.externalFunc.getLoginUin() + "";
        }
        hashMap.put("uid", str6);
        String str8 = this.f279494k;
        if (str8 == null) {
            str8 = "";
        }
        hashMap.put("download_url", str8);
        if (this.S == 0) {
            str3 = "200";
        } else {
            str3 = this.S + "";
        }
        hashMap.put("status_code", str3);
        hashMap.put("header_error", this.T + "");
        hashMap.put("download_size", this.K + "");
        hashMap.put(QCircleWeakNetReporter.KEY_COST, this.N + "");
        hashMap.put("download_start_time", this.U + "");
        Object obj = this.f279507q0.get("ExtraDataKeyPlayUrl");
        String str9 = this.f279494k;
        if (obj instanceof String) {
            str9 = (String) obj;
        }
        hashMap.put("play_url", str9);
        hashMap.put("errcode", this.V + "");
        hashMap.put(PlayParamConst.ParamKey.PLAY_START_TIME, this.f279488h + "");
        this.f279501n0.h(5, "3", this.f279489h0.f279936i, str7, hashMap, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String str, int i3, int i16) {
        PlayerUtils.log(3, "VideoReporter", "doMediaPlayerOnInfo: what=" + i3 + ", extra=" + i16);
        if (r1(str, "doMediaPlayerOnInfo")) {
            this.f279487g0.add(new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    private void C1() {
        this.f279501n0.a(this.f279500n, this.f279484f, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(String str, long j3) {
        if (r1(str, "doPreLoadOccurred")) {
            this.f279483e0.add(new Pair<>(5, Long.valueOf(System.currentTimeMillis())));
            if (j3 > this.f279512v) {
                this.f279512v = j3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("skey", str);
        hashMap.put("cur_rate", String.valueOf(i3));
        this.f279501n0.f("8", "11", "101", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(String str, int i3) {
        if (r1(str, "doPrepareAdvVideoReportInfo")) {
            this.f279491i0 = i3;
        }
    }

    private void E1() {
        v1();
        if (this.f279479c0.isEmpty()) {
            return;
        }
        w1();
        this.f279501n0.b(l0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Object obj) {
        PlayerUtils.log(3, "VideoReporter", "doPrepareReportForDc00321: videoPlaybackReportInfo=" + obj);
        if (obj == null) {
            PlayerUtils.log(3, "VideoReporter", "doPrepareReportForDc00321: ignore - videoPlaybackReportInfo is null");
        } else if (!(obj instanceof VideoPlaybackReportInfo)) {
            PlayerUtils.log(3, "VideoReporter", "doPrepareReportForDc00321: ignore - videoPlaybackReportInfo isn't instance of VideoPlaybackReportInfo");
        } else {
            this.f279489h0 = (VideoPlaybackReportInfo) obj;
        }
    }

    private boolean F1(ReportState reportState) {
        PlayerUtils.log(3, "VideoReporter", "setReportState: mReportState=" + this.f279476b + ", nextState=" + reportState);
        int i3 = a.f279517a[reportState.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4) {
                ReportState reportState2 = this.f279476b;
                if (reportState2 != ReportState.REPORT_STATE_PREPARED && reportState2 != ReportState.REPORT_STATE_MODIFIED) {
                    this.f279476b = ReportState.REPORT_STATE_ERROR;
                    return false;
                }
            } else if (i3 != 5) {
                this.f279476b = ReportState.REPORT_STATE_ERROR;
                return false;
            }
        }
        this.f279476b = reportState;
        return true;
    }

    private void G() {
        PlayerUtils.log(3, "VideoReporter", "addFinalVideoEvents()");
        Z(this.f279512v > 0);
        d0("video_preload_time_consuming", this.f279512v);
        d0("video_hotlink_protection", this.A);
        d0("video_update_vkey", this.B);
        d0("video_download_dns_resolve_timecost", this.O);
        d0("video_download_recv_first_timecost", this.Q);
        d0("video_download_connect_timecost", this.P);
        S();
        d0("video_buffer_time_consuming", this.f279516z);
        W();
        X();
        e0();
        if (!this.f279509s) {
            long h16 = h1();
            this.f279510t = h16;
            d0("video_first_play", h16);
            this.f279509s = true;
        }
        d0("video_play_time_duration", h1());
        V();
        Q();
        R();
        P();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(String str, long j3, boolean z16) {
        PlayerUtils.log(3, "VideoReporter", "doProgressBarSeekingBegin: mAnyStartPlayPosition=" + this.F + ", seekStartPosition=" + j3 + ", addTimeRange=" + z16);
        if (r1(str, "doProgressBarSeekingBegin")) {
            this.f279483e0.add(new Pair<>(18, Long.valueOf(System.currentTimeMillis())));
            if (j3 >= 0 && j3 <= 36000000 && z16) {
                I(this.F, j3);
                J(this.G, j3);
            }
            this.f279514x++;
            PlayerUtils.log(3, "VideoReporter", "doProgressBarSeekingBegin: mSeekCount=" + this.f279514x);
        }
    }

    private void H(long j3) {
        Map<String, String> T0 = T0();
        if (T0 != null) {
            String str = "1";
            T0.put("ret_code", "1");
            T0.put("time_cost", Math.min(TTL.MAX_VALUE, j3) + "");
            Map<String, Object> map = this.f279507q0;
            if (map != null && map.get("ExtraDataKeyHLSStreamInfo") != null) {
                T0.put("client_video_stream", "2");
            } else {
                T0.put("client_video_stream", "1");
            }
            if (this.f279491i0 != -1) {
                str = "2";
            }
            T0.put("client_video_type", str);
            if (this.f279489h0 == null || this.f279489h0.f279928b0 <= 0) {
                return;
            }
            T0.put("client_video_type", (this.f279489h0.f279928b0 + 2) + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(String str, long j3) {
        PlayerUtils.log(3, "VideoReporter", "doProgressBarSeekingEnd: mAnyStartPlayPosition=" + this.F + ", seekEndPosition=" + j3);
        if (r1(str, "doProgressBarSeekingEnd")) {
            this.f279483e0.add(new Pair<>(81, Long.valueOf(System.currentTimeMillis())));
            if (j3 > 36000000) {
                PlayerUtils.log(6, "VideoReporter", "doProgressBarSeekingEnd: ignore - seekEndPosition is more than MAX_VIDEO_TIME_IN_MS(36000000)");
                return;
            }
            this.F = j3;
            if (this.f279491i0 >= 0) {
                this.f279493j0 = j3;
            }
            this.G = j3;
        }
    }

    private void H1(long j3, String str, boolean z16, boolean z17) {
        if (!z16) {
            if (j3 > 0 && this.f279503o0.containsKey(this.f279502o)) {
                this.f279482e = !z17;
                if (z17) {
                    this.f279492j = this.f279503o0.get(this.f279502o).longValue();
                    PlayerUtils.log(4, "VideoReporter", "setVideoPlayId: [OLD] source=" + str + ", startPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
                } else {
                    this.f279492j = this.f279503o0.get(this.f279502o).longValue();
                    PlayerUtils.log(4, "VideoReporter", "setVideoPlayId: [OLD] source=" + str + ", startPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
                }
            } else {
                this.f279492j = Z0();
                PlayerUtils.log(4, "VideoReporter", "setVideoPlayId: [NEW] source=" + str + ", startPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
            }
        } else {
            this.f279492j = Z0();
            PlayerUtils.log(4, "VideoReporter", "setVideoPlayId: [NEW] source=" + str + ", startPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
        }
        Iterator<Map<String, String>> it = this.f279477b0.iterator();
        while (it.hasNext()) {
            it.next().put("video_play_id", String.valueOf(this.f279492j));
        }
    }

    private void I(long j3, long j16) {
        PlayerUtils.log(4, "VideoReporter", "addPlayTimeRange: start=" + j3 + ", end=" + j16);
        if (j3 >= 0 && j3 <= j16) {
            K(j3, j16);
            M(j3, j16);
        } else {
            PlayerUtils.log(6, "VideoReporter", "addPlayTimeRange: wrong time range");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(String str, boolean z16) {
        if (r1(str, "realPlayVideo")) {
            if (z16) {
                this.f279486g = true;
                PlayerUtils.log(4, "VideoReporter", "isFirstTimeRealPlayStart=true");
            }
            this.f279484f = System.currentTimeMillis();
            PlayerUtils.log(4, "VideoReporter", "doRealPlayVideo()");
        }
    }

    private boolean I1(String str) {
        return "time_cost".equals(str) || "ret_code".equals(str) || "video_url".equals(str) || "video_play_id".equals(str) || "refer".equals(str) || "rate".equals(str) || "buffer_occurred".equals(str) || "buffer_count".equals(str) || "seek_count".equals(str) || "total_time".equals(str) || "preload_occurred".equals(str) || AEEditorConstants.VIDEO_RESOLUTION.equals(str) || "link_redirect_count".equals(str);
    }

    private void J(long j3, long j16) {
        PlayerUtils.log(4, "VideoReporter", "addPlayTimeRangeForDC00321: start=" + j3 + ", end=" + j16);
        if (j3 >= 0 && j16 >= 0 && j3 <= j16) {
            L(j3, j16);
            N(j3, j16);
        } else {
            PlayerUtils.log(6, "VideoReporter", "addPlayTimeRangeForDC00321: wrong time range");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(String str, int i3) {
        PlayerUtils.log(4, "VideoReporter", "doReportPreloadOccured: videoUuid=" + str + ",hasCache=" + i3);
        Map<String, String> i06 = i0("video_preload_occurred_new");
        i06.put("ret_code", String.valueOf(i3));
        this.f279477b0.add(i06);
    }

    private void K(long j3, long j16) {
        s1(this.X, "addToVideoPlayTimeRangeList(before): ");
        this.X.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
        s1(this.X, "addToVideoPlayTimeRangeList(after): ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(String str, String str2, Object obj) {
        PlayerUtils.log(3, "VideoReporter", "setReporterData: dataKey=" + str2);
        if ("ExtraDataKeyVideoActivity".equals(str2) || r1(str, "setReporterData")) {
            this.f279507q0.put(str2, obj);
        }
    }

    private String K1() {
        long j3 = this.L;
        return String.valueOf(j3 > 0 ? ((float) this.K) / ((float) j3) : 0.0f);
    }

    private void L(long j3, long j16) {
        s1(this.Y, "addToVideoPlayTimeRangeListForDC00321(before): ");
        this.Y.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
        s1(this.Y, "addToVideoPlayTimeRangeListForDC00321(after): ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(String str, long j3, long j16) {
        PlayerUtils.log(3, "VideoReporter", "doSetVideoDurationAndStartPlayPosition: videoDuration=" + j3 + ", startPlayPosition=" + j16);
        if (r1(str, "doSetVideoDurationAndStartPlayPosition")) {
            this.f279483e0.add(new Pair<>(3, Long.valueOf(System.currentTimeMillis())));
            if (j3 > 0 && j3 <= 36000000) {
                this.f279506q = j3;
            }
            if (j16 < 0 || j16 > this.f279506q) {
                return;
            }
            this.F = j16;
            if (this.f279491i0 >= 0) {
                this.f279493j0 = j16;
            }
            this.G = j16;
            G1(j16, "doSetVideoDurationAndStartPlayPosition");
        }
    }

    private void M(long j3, long j16) {
        s1(this.Z, "addToVideoSoloPlayTimeRangeList(before): ");
        for (Pair<Long, Long> pair : this.Z) {
            if (((Long) pair.first).longValue() <= j3 && ((Long) pair.second).longValue() >= j16) {
                PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: already contained [start=" + j3 + ", end=" + j16 + "]");
                return;
            }
        }
        Iterator<Pair<Long, Long>> it = this.Z.iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            if (j3 <= ((Long) next.first).longValue() && j16 >= ((Long) next.second).longValue()) {
                PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: remove [start=" + next.first + ", end=" + next.second + "]");
                it.remove();
            }
        }
        for (Pair<Long, Long> pair2 : this.Z) {
            if (j3 >= ((Long) pair2.first).longValue() && j3 <= ((Long) pair2.second).longValue()) {
                j3 = ((Long) pair2.second).longValue();
            }
            if (j16 >= ((Long) pair2.first).longValue() && j16 <= ((Long) pair2.second).longValue()) {
                j16 = ((Long) pair2.first).longValue();
            }
        }
        if (j3 >= 0 && j3 <= j16) {
            PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: add [start=" + j3 + ", end=" + j16 + "]");
            this.Z.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
            s1(this.Z, "addToVideoSoloPlayTimeRangeList(after): ");
            return;
        }
        PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(String str, long j3, long j16) {
        PlayerUtils.log(3, "VideoReporter", "doSetVideoResolution: videoWidth=" + j3 + ", videoHeight=" + j16);
        if (r1(str, "doSetVideoResolution")) {
            this.f279483e0.add(new Pair<>(4, Long.valueOf(System.currentTimeMillis())));
            b0(j3, j16);
        }
    }

    private void N(long j3, long j16) {
        s1(this.f279475a0, "addToVideoSoloPlayTimeRangeListForDC00321(before): ");
        for (Pair<Long, Long> pair : this.f279475a0) {
            if (((Long) pair.first).longValue() <= j3 && ((Long) pair.second).longValue() >= j16) {
                PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: already contained [start=" + j3 + ", end=" + j16 + "]");
                return;
            }
        }
        Iterator<Pair<Long, Long>> it = this.f279475a0.iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            if (j3 <= ((Long) next.first).longValue() && j16 >= ((Long) next.second).longValue()) {
                PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: remove [start=" + next.first + ", end=" + next.second + "]");
                it.remove();
            }
        }
        for (Pair<Long, Long> pair2 : this.f279475a0) {
            if (j3 >= ((Long) pair2.first).longValue() && j3 <= ((Long) pair2.second).longValue()) {
                j3 = ((Long) pair2.second).longValue();
            }
            if (j16 >= ((Long) pair2.first).longValue() && j16 <= ((Long) pair2.second).longValue()) {
                j16 = ((Long) pair2.first).longValue();
            }
        }
        if (j3 >= 0 && j3 <= j16) {
            PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: add [start=" + j3 + ", end=" + j16 + "]");
            this.f279475a0.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
            s1(this.f279475a0, "addToVideoSoloPlayTimeRangeList(after): ");
            return;
        }
        PlayerUtils.log(3, "VideoReporter", "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(String str) {
        PlayerUtils.log(4, "VideoReporter", "doSetVideoUuid: videoUuid=" + str);
        if (TextUtils.isEmpty(str)) {
            PlayerUtils.log(3, "VideoReporter", "doSetVideoUuid: ignore - videoUuid is empty");
        } else if (!F1(ReportState.REPORT_STATE_MODIFIED)) {
            PlayerUtils.log(6, "VideoReporter", "doSetVideoUuid: wrong state");
        } else {
            this.f279496l = str;
        }
    }

    private void O(int i3) {
        Map<String, String> i06 = i0("video_buffer_percent");
        i06.put("rate", String.valueOf(i3));
        i06.put("attach_info", "httpDownloadSize=" + this.K + "|dataFromCacheSize=" + this.M + "|fileSize=" + this.L + "|videoDuration=" + this.f279506q + "|videoPlayPosition=" + this.H);
        if (this.N == 0) {
            i06.put("client_cache_state", "1");
        } else {
            i06.put("client_cache_state", "0");
        }
        this.f279477b0.add(i06);
    }

    private void P() {
        Map<String, String> i06 = i0("video_download_ret");
        i06.put("ret_code", String.valueOf(this.R));
        if (!TextUtils.isEmpty(this.I)) {
            i06.put("server_ip", this.I);
        }
        if (p1()) {
            i06.put("attach_info", e1() + "@" + Y0() + "," + b1());
        }
        this.f279477b0.add(i06);
    }

    private void Q() {
        Map<String, String> i06 = i0("video_download_size");
        i06.put("attach_info", String.valueOf(V0()) + "@" + b1());
        this.f279477b0.add(i06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(String str, boolean z16) {
        if (r1(str, "doUpdatePlayScreenState") && this.f279489h0 != null) {
            this.f279489h0.f279931d0 = z16;
        }
    }

    private void R() {
        float W0 = W0();
        Map<String, String> i06 = i0("video_download_speed");
        i06.put("attach_info", String.valueOf(W0) + "@" + b1());
        com.tencent.mobileqq.qzoneplayer.report.b.c().a(W0);
        this.f279477b0.add(i06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(String str, String str2, long j3, long j16) {
        PlayerUtils.log(4, "VideoReporter", "doUrlRedirectOccurred: videoUuid=" + str + ", domainListStr=" + str2 + ", duration=" + j3 + ", redirectCount=" + j16);
        if (r1(str, "doUrlRedirectOccurred")) {
            this.f279483e0.add(new Pair<>(7, Long.valueOf(System.currentTimeMillis())));
            if (j3 <= 0) {
                PlayerUtils.log(3, "VideoReporter", "doUrlRedirectOccurred: ignore - duration is less than or equal to 0");
                return;
            }
            if (j16 <= 0) {
                PlayerUtils.log(3, "VideoReporter", "doUrlRedirectOccurred: ignore - redirectCount is less than or equal to 0");
                return;
            }
            if (this.C < j3) {
                this.C = j3;
            }
            PlayerUtils.log(3, "VideoReporter", "doUrlRedirectOccurred: mUrlRedirectTimeCost=" + this.C);
            T(j3, str2);
            U(j16);
        }
    }

    private void S() {
        String str;
        Map<String, String> i06 = i0("video_first_buffer_occurred");
        if (this.f279515y > 0) {
            str = "1";
        } else {
            str = "0";
        }
        i06.put("buffer_occurred", str);
        this.f279477b0.add(i06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(String str, long j3) {
        PlayerUtils.log(3, "VideoReporter", "doVKeyUpdateOccurred: videoUuid=" + str + ", duration=" + j3 + ", mVKeyUpdateTimeCost=" + this.B);
        if (r1(str, "doVKeyUpdateOccurred")) {
            this.f279483e0.add(new Pair<>(6, Long.valueOf(System.currentTimeMillis())));
            if (j3 <= 0) {
                PlayerUtils.log(3, "VideoReporter", "doVKeyUpdateOccurred: ignore - duration is less than or equal to 0");
            } else if (j3 > this.B) {
                this.B = j3;
            }
        }
    }

    private void T(long j3, String str) {
        Map<String, String> i06 = i0("video_link_redirect");
        i06.put("time_cost", J1(j3));
        i06.put("attach_info", str);
        this.f279477b0.add(i06);
    }

    private Map<String, String> T0() {
        Iterator<Map<String, String>> it = this.f279477b0.iterator();
        while (it.hasNext()) {
            Map<String, String> next = it.next();
            if (next.get("event_id").equals(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY)) {
                return next;
            }
        }
        return null;
    }

    private void U(long j3) {
        Map<String, String> i06 = i0("video_link_redirect_occur_times");
        i06.put("link_redirect_count", String.valueOf(j3));
        this.f279477b0.add(i06);
    }

    private void V() {
        Map<String, String> i06 = i0("video_play_complete_rate");
        i06.put("rate", String.valueOf(c1()));
        if (p1()) {
            i06.put("attach_info", j1() + "@" + b1());
        }
        this.f279477b0.add(i06);
    }

    private float V0() {
        return (((float) this.K) / 1024.0f) / 1024.0f;
    }

    private void W() {
        Map<String, String> i06 = i0("video_play_occur_buffer_times");
        i06.put("buffer_count", String.valueOf(this.f279515y));
        this.f279477b0.add(i06);
    }

    private float W0() {
        long j3 = this.N;
        if (j3 <= 0) {
            return 0.0f;
        }
        return (((float) this.K) / 1024.0f) / (((float) j3) / 1000.0f);
    }

    private void X() {
        Map<String, String> i06 = i0("video_seek_occur_times");
        i06.put("seek_count", String.valueOf(this.f279514x));
        this.f279477b0.add(i06);
    }

    private String X0() {
        return Build.BRAND + "_" + Build.DEVICE + "_" + Build.DISPLAY + "_" + Build.HARDWARE + "_" + Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel() + "_" + Build.PRODUCT;
    }

    private void Y() {
        Map<String, String> i06 = i0("video_play_ret");
        i06.put("ret_code", String.valueOf(this.V));
        if (p1()) {
            i06.put("attach_info", g1() + "@" + Y0() + "," + b1() + "," + this.f279505p0);
        }
        this.f279477b0.add(i06);
    }

    private String Y0() {
        boolean isNetworkAvailable = FeedVideoEnv.externalFunc.isNetworkAvailable(PlayerConfig.g().getAppContext());
        int networkType = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
        return "NetworkInfo: isConnected=" + isNetworkAvailable + ", connectionType=" + networkType + ", connectionTypeStr=" + PlayerUtils.getConnectionTypeStr(networkType);
    }

    private void Z(boolean z16) {
        String str;
        Map<String, String> i06 = i0("video_preload_occurred");
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        i06.put("preload_occurred", str);
        this.f279477b0.add(i06);
    }

    public static long Z0() {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) << 32;
        int i3 = f279472t0;
        long j3 = currentTimeMillis | i3;
        f279472t0 = i3 + 1;
        return j3;
    }

    private void a0() {
        Map<String, String> i06 = i0("video_real_start");
        i06.put("time_cost", String.valueOf(this.f279484f - this.f279488h));
        this.f279477b0.add(i06);
    }

    public static int a1() {
        int i3 = f279473u0 + 1;
        f279473u0 = i3;
        return i3;
    }

    private void b0(long j3, long j16) {
        Map<String, String> i06 = i0(AEEditorConstants.VIDEO_RESOLUTION);
        i06.put(AEEditorConstants.VIDEO_RESOLUTION, String.valueOf(j3) + HippyTKDListViewAdapter.X + String.valueOf(j16));
        this.f279477b0.add(i06);
    }

    private String b1() {
        return "uuid=" + this.f279496l + ",reporter=20160419";
    }

    private void c0(boolean z16) {
        String str;
        Map<String, String> i06 = i0(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
        if (z16) {
            str = ShortVideoConstants.IS_AUTO_PLAY;
        } else {
            str = "user_click";
        }
        i06.put("refer", str);
        i06.put("attach_info", n1() + "@" + b1());
        if (this.f279504p == 406 && this.f279489h0 != null) {
            i06.put(s4.c.CELLID, this.f279489h0.I);
            i06.put("hostUIN", this.f279489h0.G);
        }
        this.f279477b0.add(i06);
    }

    private float c1() {
        if (this.f279506q <= 0) {
            return -1.0f;
        }
        return (((float) k1()) * 100.0f) / ((float) this.f279506q);
    }

    private void d0(String str, long j3) {
        Map<String, String> i06 = i0(str);
        i06.put("time_cost", J1(j3));
        if (this.N == 0) {
            i06.put("client_cache_state", "1");
        } else {
            i06.put("client_cache_state", "0");
        }
        if (this.f279507q0.get("ExtraDataKeyVideoActivity") != null) {
            i06.put("refer", (String) this.f279507q0.get("ExtraDataKeyVideoActivity"));
        }
        this.f279477b0.add(i06);
    }

    private String d1() {
        int indexOf;
        if (TextUtils.isEmpty(this.f279494k) || (indexOf = this.f279494k.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER)) == -1) {
            return "";
        }
        int i3 = indexOf + 3;
        int indexOf2 = this.f279494k.indexOf(47, i3);
        if (indexOf2 == -1) {
            return this.f279494k.substring(i3);
        }
        return this.f279494k.substring(i3, indexOf2);
    }

    private void e0() {
        Map<String, String> i06 = i0(QCircleLpReportDc05507.KEY_VIDEO_TOTAL_TIME);
        i06.put("total_time", J1(this.f279506q));
        this.f279477b0.add(i06);
    }

    private String e1() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.f279485f0.size(); i3++) {
            Pair<Long, String> pair = this.f279485f0.get(i3);
            if (i3 > 0) {
                sb5.append(',');
            }
            sb5.append(pair.first);
            sb5.append(':');
            sb5.append((String) pair.second);
        }
        String sb6 = sb5.toString();
        PlayerUtils.log(3, "VideoReporter", "getVideoDownloadResultListStr: " + sb6);
        return sb6;
    }

    private boolean f0() {
        return this.R == 0 && this.V == 0 && h1() <= 0;
    }

    private String f1() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        if (this.f279508r) {
            str = ShortVideoConstants.IS_AUTO_PLAY;
        } else {
            str = "user_click";
        }
        sb5.append(str);
        sb5.append(",");
        sb5.append(J1(this.A));
        sb5.append(",");
        sb5.append(J1(this.B));
        sb5.append(",");
        sb5.append(J1(this.C));
        sb5.append(",");
        sb5.append(J1(this.f279510t));
        sb5.append(",");
        sb5.append(J1(h1()));
        sb5.append(",");
        sb5.append(J1(this.f279506q));
        sb5.append(",");
        sb5.append(c1());
        sb5.append(",");
        sb5.append(this.V);
        sb5.append(",");
        sb5.append(J1(this.f279511u));
        sb5.append(",");
        sb5.append(J1(this.f279512v));
        sb5.append(",");
        if (this.f279515y > 0) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        sb5.append(str2);
        sb5.append(",");
        sb5.append(J1(this.f279516z));
        sb5.append(",");
        sb5.append(this.f279515y);
        sb5.append(",");
        sb5.append(this.f279514x);
        sb5.append(",");
        sb5.append(this.f279513w);
        sb5.append(",,");
        sb5.append(this.f279501n0.getUin());
        sb5.append(",");
        sb5.append(this.f279501n0.getNetworkType());
        sb5.append(",,");
        sb5.append(this.f279501n0.getQua());
        sb5.append(",");
        sb5.append(d1());
        sb5.append(",");
        sb5.append(this.f279504p);
        sb5.append(",");
        sb5.append(this.f279500n);
        String sb6 = sb5.toString();
        PlayerUtils.log(3, "VideoReporter", "getVideoEventBossValue: bossValue=" + sb6);
        return sb6;
    }

    private void g0() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String str = "Timezone:" + timeZone.getDisplayName(false, 0) + ",id:" + timeZone.getID();
            PlayerUtils.log(4, "VideoReporter", "timezone=" + str);
            if (TextUtils.isEmpty(str) || str.contains("Shanghai") || str.contains(CountrySelectView.NAME_CHINA)) {
                return;
            }
            f279470r0 = 2;
        } catch (Throwable th5) {
            PlayerUtils.log(6, "VideoReporter", th5.toString());
        }
    }

    private String g1() {
        StringBuilder sb5 = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = new Date();
        for (int i3 = 0; i3 < this.f279483e0.size(); i3++) {
            Pair<Integer, Long> pair = this.f279483e0.get(i3);
            if (i3 > 0) {
                sb5.append(',');
            }
            date.setTime(((Long) pair.second).longValue());
            sb5.append(simpleDateFormat.format(date));
            sb5.append(':');
            sb5.append(com.tencent.mobileqq.qzoneplayer.report.c.a(((Integer) pair.first).intValue()));
        }
        String sb6 = sb5.toString();
        PlayerUtils.log(3, "VideoReporter", "getVideoOperationTimestampListStr: " + sb6);
        return sb6;
    }

    private void h0(String str) {
        PlayerUtils.log(3, "VideoReporter", "clear() from " + str);
        this.f279486g = false;
        this.f279488h = 0L;
        this.f279490i = 0L;
        this.f279492j = 0L;
        this.f279494k = null;
        this.f279496l = null;
        this.f279498m = 0;
        this.f279500n = null;
        this.f279502o = null;
        this.f279504p = 0;
        this.f279506q = 0L;
        this.f279508r = false;
        this.f279509s = false;
        this.f279510t = 0L;
        this.f279511u = 0L;
        this.f279512v = 0L;
        this.f279513w = 0;
        this.f279514x = 0;
        this.f279515y = 0;
        this.f279516z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = -1L;
        this.G = -1L;
        this.H = 0L;
        this.I = null;
        this.J = null;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.S = 0L;
        this.T = 0L;
        this.U = -1L;
        this.V = 0L;
        this.X.clear();
        this.Y.clear();
        this.Z.clear();
        this.f279475a0.clear();
        this.f279477b0.clear();
        this.f279479c0.clear();
        this.f279483e0.clear();
        this.f279485f0.clear();
        this.f279487g0.clear();
        this.f279489h0 = null;
        this.f279505p0 = "";
        this.f279491i0 = -1;
        this.f279493j0 = -1L;
        this.f279495k0 = -1L;
        this.f279497l0 = false;
        this.f279482e = false;
        this.f279484f = 0L;
        this.f279507q0.clear();
    }

    private long h1() {
        long j3 = 0;
        for (Pair<Long, Long> pair : this.X) {
            j3 += ((Long) pair.second).longValue() - ((Long) pair.first).longValue();
        }
        return j3;
    }

    private Map<String, String> i0(String str) {
        String str2;
        Object obj;
        Object obj2;
        HashMap hashMap = new HashMap();
        hashMap.put("host_uin", String.valueOf(this.f279501n0.getUin()));
        hashMap.put("qua", this.f279501n0.getQua());
        hashMap.put("network_type", String.valueOf(this.f279501n0.getNetworkType()));
        hashMap.put("client_time", String.valueOf(System.currentTimeMillis()));
        hashMap.put("event_id", str);
        hashMap.put("video_url", this.f279494k);
        hashMap.put("video_play_id", String.valueOf(this.f279492j));
        int i3 = this.f279498m;
        if (i3 != 0) {
            hashMap.put("appid", String.valueOf(i3));
        } else {
            hashMap.put("appid", String.valueOf(this.f279501n0.c(this.f279504p)));
        }
        String str3 = "0";
        if (this.f279489h0 == null) {
            str2 = "0";
        } else {
            str2 = this.f279489h0.J;
        }
        hashMap.put("write_from", str2);
        String str4 = "2";
        if (this.f279491i0 != -1) {
            obj = "2";
        } else {
            obj = "1";
        }
        hashMap.put("client_video_type", obj);
        if (this.f279489h0 != null && this.f279489h0.f279928b0 > 0) {
            hashMap.put("client_video_type", (this.f279489h0.f279928b0 + 2) + "");
        }
        Map<String, Object> map = this.f279507q0;
        if (map != null && map.get("ExtraDataKeyHLSStreamInfo") != null) {
            hashMap.put("client_video_stream", "2");
        } else {
            hashMap.put("client_video_stream", "1");
        }
        Map<String, Object> map2 = this.f279507q0;
        if (map2 != null) {
            if (map2.get("ExtraDataKeyH265StreamInfo") == null) {
                str4 = "1";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            if (this.f279507q0.get("ExtraDataKeyVideoRate") != null) {
                obj2 = this.f279507q0.get("ExtraDataKeyVideoRate");
            } else {
                obj2 = "750";
            }
            sb5.append(obj2);
            hashMap.put("video_encode_type", sb5.toString() + f279470r0);
        } else {
            hashMap.put("video_encode_type", "1");
        }
        hashMap.put("key_model", DeviceInfoMonitor.getModel());
        hashMap.put("key_manufacturer", Build.MANUFACTURER);
        hashMap.put("key_download_ret", K1());
        if (this.W) {
            str3 = "1";
        }
        hashMap.put("key_player_type", str3);
        if (this.f279489h0 != null) {
            hashMap.put("extendinfo", this.f279489h0.F);
        }
        Map<String, Object> map3 = this.f279507q0;
        if (map3 != null && map3.get("ExtraDataKeyVideoActivity") != null) {
            hashMap.put("refer", (String) this.f279507q0.get("ExtraDataKeyVideoActivity"));
        }
        return hashMap;
    }

    private long i1() {
        t1(this.Y, "getVideoPlayTimeForDC00321", 4);
        long j3 = 0;
        for (Pair<Long, Long> pair : this.Y) {
            j3 += ((Long) pair.second).longValue() - ((Long) pair.first).longValue();
        }
        return j3;
    }

    private Map<String, String> j0() {
        HashMap hashMap = new HashMap();
        hashMap.put("boss", f1());
        return hashMap;
    }

    private String j1() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.f279487g0.size(); i3++) {
            Pair<Integer, Integer> pair = this.f279487g0.get(i3);
            if (i3 > 0) {
                sb5.append(',');
            }
            sb5.append(pair.first);
            sb5.append(':');
            sb5.append(pair.second);
        }
        String sb6 = sb5.toString();
        PlayerUtils.log(3, "VideoReporter", "mVideoPlayerInfoList: " + sb6);
        return sb6;
    }

    private ArrayList<Map<String, String>> k0() {
        ArrayList<Map<String, String>> arrayList = this.f279477b0;
        this.f279477b0 = new ArrayList<>();
        return arrayList;
    }

    private long k1() {
        long j3 = 0;
        for (Pair<Long, Long> pair : this.Z) {
            j3 += ((Long) pair.second).longValue() - ((Long) pair.first).longValue();
        }
        return j3;
    }

    private ArrayList<Map<String, String>> l0() {
        ArrayList<Map<String, String>> arrayList = this.f279479c0;
        this.f279479c0 = new ArrayList<>();
        return arrayList;
    }

    private long l1() {
        t1(this.f279475a0, "getVideoSoloPlayTimeForDC00321", 4);
        long j3 = 0;
        for (Pair<Long, Long> pair : this.f279475a0) {
            j3 += ((Long) pair.second).longValue() - ((Long) pair.first).longValue();
        }
        return j3;
    }

    private Map<String, String> m0() {
        HashMap hashMap = new HashMap();
        hashMap.put("video_play_id", String.valueOf(this.f279492j));
        hashMap.put("video_url", this.f279494k);
        return hashMap;
    }

    private String m1() {
        long j3 = this.H;
        if (j3 >= 0) {
            return String.valueOf(j3);
        }
        return String.valueOf(l1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str, long j3) {
        PlayerUtils.log(3, "VideoReporter", "doAddVideoPlayTimeRange: stoppedPosition=" + j3);
        if (r1(str, "doAddVideoPlayTimeRange")) {
            this.f279483e0.add(new Pair<>(10, Long.valueOf(System.currentTimeMillis())));
            long j16 = this.F;
            if (j3 <= j16) {
                PlayerUtils.log(6, "VideoReporter", "doAddVideoPlayTimeRange: ignore - stoppedPosition is less than or equal to mAnyStartPlayPosition(" + this.F + ")");
                return;
            }
            if (j3 > 36000000) {
                PlayerUtils.log(6, "VideoReporter", "doAddVideoPlayTimeRange: ignore - stoppedPosition is more than MAX_VIDEO_TIME_IN_MS(36000000)");
                return;
            }
            I(j16, j3);
            J(this.G, j3);
            this.F = j3;
            this.G = j3;
        }
    }

    private String n1() {
        String str = "appid:" + this.f279504p + ",videoid:" + this.f279500n + ",model:" + DeviceInfoMonitor.getModel() + ",manufacturer:" + Build.MANUFACTURER + ",sdk=" + Build.VERSION.SDK_INT;
        PlayerUtils.log(3, "VideoReporter", "getVideoStartPlayEventAttachInfo: " + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Map<String, String> map) {
        PlayerUtils.log(3, "VideoReporter", "doAddVideoVisibilityEvent: videoVisibilityEvent=" + map);
        if (!F1(ReportState.REPORT_STATE_MODIFIED)) {
            PlayerUtils.log(6, "VideoReporter", "doAddVideoVisibilityEvent: wrong state");
        } else if (map == null) {
            PlayerUtils.log(3, "VideoReporter", "doAddVideoVisibilityEvent: ignore - videoVisibilityEvent is null");
        } else {
            this.f279479c0.add(map);
        }
    }

    private String o1() {
        if (this.f279489h0 != null && !TextUtils.isEmpty(this.f279489h0.f279937m) && !this.f279489h0.N) {
            return this.f279489h0.f279937m;
        }
        return String.valueOf(this.f279506q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str, boolean z16) {
        if (r1(str, "doBufferingBegin")) {
            this.f279483e0.add(new Pair<>(19, Long.valueOf(System.currentTimeMillis())));
            if (!z16 && this.f279515y == 0) {
                this.f279510t = h1();
                PlayerUtils.log(4, "VideoReporter", "doBufferingBegin(EVENT_VIDEO_FIRST_PLAY): mFirstPlayTime=" + this.f279510t);
                d0("video_first_play", this.f279510t);
                this.f279509s = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.D = currentTimeMillis;
            this.E = currentTimeMillis;
            PlayerUtils.log(4, "VideoReporter", "doBufferingBegin: mBufferingStartTimestamp=" + this.D + ", isFirstTime=" + z16);
        }
    }

    private boolean p1() {
        return (this.V == 0 && this.R == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str, boolean z16) {
        PlayerUtils.log(4, "VideoReporter", "doBufferingEnd: mBufferingStartTimestamp=" + this.D + ", isFirstTime=" + z16);
        if (r1(str, "doBufferingEnd")) {
            this.f279483e0.add(new Pair<>(91, Long.valueOf(System.currentTimeMillis())));
            if (this.D <= 0) {
                PlayerUtils.log(6, "VideoReporter", "doBufferingEnd: ignore - not start");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.D;
            PlayerUtils.log(4, "VideoReporter", "doBufferingEnd: duration=" + currentTimeMillis);
            if (z16) {
                this.f279511u = Math.min(this.f279478c, Math.max(1L, currentTimeMillis));
                PlayerUtils.log(4, "VideoReporter", "mVideoFirstBufferTimeConsuming = " + this.f279511u + "; mMaxVideoFirstBufferOvertime = " + this.f279478c);
                d0("video_first_buffer_time_consuming", this.f279511u);
                FeedVideoEnv.externalFunc.isDebugVersion();
            } else if (this.f279514x <= 0 && this.f279507q0.get("ExtraDataKeySwitchSurface") == null) {
                if (this.f279486g) {
                    PlayerUtils.log(4, "VideoReporter", "doBufferingEnd: add");
                    this.f279515y++;
                    this.f279516z += currentTimeMillis;
                } else {
                    PlayerUtils.log(4, "VideoReporter", "doBufferingEnd: play not started");
                }
            }
            PlayerUtils.log(4, "VideoReporter", "doBufferingEnd: mBufferingCount=" + this.f279515y + ", mBufferingTime=" + this.f279516z);
            this.D = 0L;
        }
    }

    private boolean q1(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f279496l)) {
            return false;
        }
        return str.equals(this.f279496l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String str) {
        PlayerUtils.log(4, "VideoReporter", "doCancelPlayVideo()");
        if (r1(str, "doCancelPlayVideo")) {
            h0("doCancelPlayVideo");
        }
    }

    private boolean r1(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            PlayerUtils.log(4, "VideoReporter", str2 + ": ignore - videoUuid is empty");
            return false;
        }
        if (str.equals("IgnoreVideoUUID")) {
            PlayerUtils.log(5, "VideoReporter", str2 + ": videoUuid is marked as valid by force");
            return true;
        }
        if (!q1(str)) {
            PlayerUtils.log(4, "VideoReporter", str2 + ": ignore - not current video videoUuid, current=" + this.f279496l + ", input=" + str);
            return false;
        }
        if (F1(ReportState.REPORT_STATE_MODIFIED)) {
            return true;
        }
        PlayerUtils.log(6, "VideoReporter", str2 + ": wrong state");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(String str) {
        PlayerUtils.log(4, "VideoReporter", "doCompletePlayVideo: mVideoDuration=" + this.f279506q);
        if (r1(str, "doCompletePlayVideo")) {
            this.f279483e0.add(new Pair<>(13, Long.valueOf(System.currentTimeMillis())));
            if (this.f279491i0 >= 0) {
                this.f279497l0 = true;
            }
            U0(str, this.f279506q, 100, 0, 0L, false, "doCompletePlayVideo", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(String str, long j3, Object obj) {
        String str2;
        PlayerUtils.log(4, "VideoReporter", "doDownloadResult: videoUuid=" + str + ", retCode=" + j3 + ", detail=" + obj);
        if (obj instanceof Map) {
            Map map = (Map) obj;
            long longValue = map.get(AdMetricTag.RESPONSE_CODE) != null ? ((Long) map.get(AdMetricTag.RESPONSE_CODE)).longValue() : 0L;
            long longValue2 = map.get("subRetCode") != null ? ((Long) map.get("subRetCode")).longValue() : 0L;
            if (map.get("message") instanceof String) {
                str2 = (String) map.get("message");
            } else {
                str2 = "";
            }
            if (longValue == 4) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("detail", map);
                hashMap.put("retCode", Long.valueOf(j3));
                hashMap.put("subRetCode", Long.valueOf(longValue2));
                FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_INTERNAL_ERROR, hashMap);
            }
            if (r1(str, "doDownloadResult")) {
                this.f279483e0.add(new Pair<>(12, Long.valueOf(System.currentTimeMillis())));
                this.f279485f0.add(new Pair<>(Long.valueOf(j3), str2));
                if (j3 != 0) {
                    this.f279513w++;
                }
                this.S = longValue;
                this.T = longValue2;
                this.R = j3;
            }
        }
    }

    private void t1(List<Pair<Long, Long>> list, String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        for (Pair<Long, Long> pair : list) {
            sb5.append("[");
            sb5.append(pair.first);
            sb5.append(", ");
            sb5.append(pair.second);
            sb5.append("] ");
        }
        PlayerUtils.log(i3, "VideoReporter", str + sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(long j3, long j16, long j17) {
        PlayerUtils.log(4, "VideoReporter", "doDownloadServerCost()");
        this.O = j3;
        this.P = j16;
        this.Q = j17;
    }

    private void u1() {
        if (FeedVideoEnv.externalFunc.isDebugVersion()) {
            PlayerUtils.log(3, "VideoReporter", "printVideoEventList: mVideoPlayId=" + this.f279492j + ", size=" + this.f279477b0.size());
            for (int i3 = 0; i3 < this.f279477b0.size(); i3++) {
                PlayerUtils.log(3, "VideoReporter", "printVideoEventList: " + i3 + " -> " + this.f279477b0.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str, String str2) {
        PlayerUtils.log(3, "VideoReporter", "doDownloadServerIp: videoUuid=" + str + ", serverIp=" + str2);
        this.J = str2;
        if (r1(str, "doDownloadServerIp")) {
            if (TextUtils.isEmpty(str2)) {
                PlayerUtils.log(3, "VideoReporter", "doDownloadServerIp: ignore - serverIp is empty");
            } else {
                this.f279483e0.add(new Pair<>(20, Long.valueOf(System.currentTimeMillis())));
                this.I = str2;
            }
        }
    }

    private void v1() {
        PlayerUtils.log(3, "VideoReporter", "printVideoVisibilityEventList: size=" + this.f279479c0.size());
        for (int i3 = 0; i3 < this.f279479c0.size(); i3++) {
            PlayerUtils.log(3, "VideoReporter", "printVideoVisibilityEventList: " + i3 + " -> " + this.f279479c0.get(i3));
        }
    }

    private void w1() {
        String str;
        PlayerUtils.log(3, "VideoReporter", "processVideoVisibilityEventList: videoPlayTime=" + h1() + ", videoSoloPlayTime=" + k1() + ", mVideoDuration=" + this.f279506q + ", videoCompleteRate=" + c1());
        Iterator<Map<String, String>> it = this.f279479c0.iterator();
        while (it.hasNext()) {
            Map<String, String> next = it.next();
            if (this.f279508r) {
                str = "2";
            } else {
                str = "3";
            }
            next.put(TVKDataBinder.KEY_REPORT_TYPE, str);
            next.put("rate", String.valueOf(c1()));
            next.put("total_time", J1(this.f279506q));
        }
    }

    private void x1() {
        String str;
        Map<String, String> map = this.f279481d0;
        if (map != null) {
            if (this.f279497l0) {
                str = "1";
            } else {
                str = "0";
            }
            map.put("adv_video_complete_state", str);
            this.f279481d0.put("adv_start_position", String.valueOf(this.f279493j0));
            this.f279481d0.put("adv_stop_position", String.valueOf(this.f279495k0));
            this.f279501n0.e(this.f279481d0, this.f279491i0, this.f279508r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String str) {
        PlayerUtils.log(4, "VideoReporter", "doFirstRender: mBufferingStartForFirstRender=" + this.E);
        if (this.E <= 0) {
            PlayerUtils.log(6, "VideoReporter", "mBufferingStartForFirstRender: ignore - not start");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.E;
        PlayerUtils.log(4, "VideoReporter", "doBufferingEnd: duration=" + currentTimeMillis);
        long min = Math.min((long) this.f279478c, Math.max(1L, currentTimeMillis));
        PlayerUtils.log(4, "VideoReporter", "firstRenderTime = " + min + "; mMaxVideoFirstBufferOvertime = " + this.f279478c);
        d0(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER, min);
    }

    private void y1() {
        String str;
        String str2;
        PlayerUtils.log(3, "VideoReporter", "reportLiveReplayEventToDc00321()");
        if (this.f279489h0 == null) {
            PlayerUtils.log(3, "VideoReporter", "reportLiveReplayEventToDc00321: ignore - mVideoPlaybackReportInfo is null");
            return;
        }
        if (i1() == 0 && Long.valueOf(m1()).longValue() == 0) {
            PlayerUtils.log(3, "VideoReporter", "reportLiveReplayEventToDc00321: ignore - video_play_time && video_solo_time is 0");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile_type", X0());
        String str3 = "2";
        hashMap.put("device", "2");
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_TOTAL_TIME, o1());
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_PLAY_TIME, String.valueOf(i1()));
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_SOLO_TIME, m1());
        if (this.f279489h0.f279931d0) {
            str = "25";
        } else {
            str = this.f279489h0.f279935h;
        }
        hashMap.put("video_play_scene", str);
        hashMap.put("video_sources", this.f279489h0.f279936i);
        String str4 = "1";
        if (this.f279489h0.f279932e) {
            str3 = "1";
        }
        hashMap.put("is_auto_play", str3);
        hashMap.put(QCircleLpReportDc05494.KEY_PHOTOCUBAGE, this.f279489h0.C);
        hashMap.put("width", this.f279489h0.D);
        hashMap.put("height", this.f279489h0.E);
        hashMap.put("vid", this.f279489h0.f279930d);
        hashMap.put("feeds_type", this.f279489h0.F);
        hashMap.put("author_uin", this.f279489h0.P);
        hashMap.put("stay_time", String.valueOf(System.currentTimeMillis() - this.f279489h0.Q));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_ID, this.f279489h0.R);
        hashMap.put("shuoshuoid", this.f279489h0.I);
        if (this.f279514x <= 0) {
            str4 = "0";
        }
        hashMap.put("is_video_seek", str4);
        hashMap.put("seq", this.f279489h0.Z);
        hashMap.put(QCircleLpReportDc05507.KEY_FEED_URL, this.f279489h0.S);
        hashMap.put("repost_uin", this.f279489h0.T);
        hashMap.put("video_play_source", this.f279489h0.U);
        hashMap.put("live_user_type", this.f279489h0.V);
        hashMap.put("live_state", this.f279489h0.W);
        hashMap.put("live_page", this.f279489h0.X);
        hashMap.put("live_source", this.f279489h0.Y);
        hashMap.put("s_vid", this.f279489h0.f279927a0);
        String str5 = this.f279489h0.f279929c0;
        com.tencent.mobileqq.qzoneplayer.report.a aVar = this.f279501n0;
        if (this.f279489h0.N) {
            str2 = "10";
        } else {
            str2 = "7";
        }
        aVar.h(5, "3", str2, str5, hashMap, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(long j3) {
        PlayerUtils.log(4, "VideoReporter", "doGetSafeUrlOccurred: mGetSafeUrlTimeCost=" + this.A + ", duration=" + j3 + ", mReportState=" + this.f279476b);
        this.f279483e0.add(new Pair<>(1, Long.valueOf(System.currentTimeMillis())));
        if (j3 <= 0) {
            PlayerUtils.log(6, "VideoReporter", "doGetSafeUrlOccurred: ignore - duration is less than or equal to 0");
        } else {
            this.A = j3;
        }
    }

    private void z1() {
        u1();
        A1();
        this.f279501n0.d(k0(), j0(), "video_habo_report_result", m0(), "ret_code");
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void addVideoPlayTimeRange(String str, long j3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 15;
        obtain.obj = new b(str, j3, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void addVideoVisibilityEvent(Map<String, String> map) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 7;
        obtain.obj = new b(map);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void bufferingBegin(String str, boolean z16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 13;
        obtain.obj = new b(str, 0L, 0L, 0, z16);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void bufferingEnd(String str, boolean z16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 14;
        obtain.obj = new b(str, 0L, 0L, 0, z16);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void cancelPlayVideo(String str) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 24;
        obtain.obj = new b(str, 0L, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void completePlayVideo(String str) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 21;
        obtain.obj = new b(str, 0L, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void downloadResult(String str, long j3, Map<String, Object> map) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 20;
        b bVar = new b();
        bVar.f279518a = str;
        bVar.f279521d = j3;
        bVar.f279533p = map;
        obtain.obj = bVar;
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void downloadServerCost(String str, long j3, long j16, long j17) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 26;
        obtain.obj = new b(j3, j16, j17);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void downloadServerIp(String str, String str2) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 18;
        obtain.obj = new b(str, str2);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void failPlayVideo(String str, int i3, long j3, int i16, String str2) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 23;
        obtain.obj = new b(str, i3, j3, i16, str2);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public long getLocalStoreTotalCountLimit() {
        return this.f279501n0.getLocalStoreTotalCountLimit();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public ReportState getReportState(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(this.f279496l)) {
            return null;
        }
        return this.f279476b;
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void getSafeUrlOccurred(long j3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 1;
        obtain.obj = new b((String) null, j3, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void justReportVideoEventToDc00321(String str, long j3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 27;
        obtain.obj = new b(str, j3, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void loopPlayVideo(String str) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 17;
        obtain.obj = new b(str, 0L, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void mediaPlayerOnInfo(String str, int i3, int i16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 16;
        obtain.obj = new b(str, i3, i16, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void preLoadOccurred(String str, long j3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 8;
        obtain.obj = new b(str, j3, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void prepareAdvVideoReportInfo(String str, int i3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 29;
        obtain.obj = new b(str, i3);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void prepareReportForDc00321(Object obj) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 4;
        obtain.obj = new b(obj);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void progressBarSeekingBegin(String str, long j3, boolean z16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 11;
        obtain.obj = new b(str, j3, 0L, 0, z16);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void progressBarSeekingEnd(String str, long j3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 12;
        obtain.obj = new b(str, j3, 0L, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void realPlayVideo(String str, boolean z16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 25;
        obtain.obj = new b(str, z16);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void reportDecreaseRate(String str, int i3) {
        PlayerUtils.log(4, "VideoReport", "reportDecreaseRate");
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 32;
        obtain.obj = new b(str, i3);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void reportFirstRender(String str) {
        PlayerUtils.log(4, "VideoReport", "reportFirstRender");
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 31;
        obtain.obj = new b(str, 0);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void reportPreloadOccured(String str, boolean z16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 33;
        obtain.obj = new b(str, z16 ? 1 : 0);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void reportVideoDecodeScore(int i3) {
        this.f279501n0.i(PlayerUtils.getMobileDetailInfo(), i3);
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void setExtraData(String str, String str2, Object obj) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 28;
        obtain.obj = new b(str, str2, obj);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void setVideoDurationAndStartPlayPosition(String str, long j3, long j16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 5;
        obtain.obj = new b(str, j3, j16, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void setVideoResolution(String str, long j3, long j16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 6;
        obtain.obj = new b(str, j3, j16, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void setVideoUuid(String str) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 3;
        obtain.obj = new b(str);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void startPlayVideo(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18) {
        startPlayVideo(str, str2, j3, j16, z16, str3, i3, z17, z18, 0);
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void stopPlayVideo(String str, long j3, int i3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 22;
        obtain.obj = new b(str, j3, i3, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void updatePlayScreenState(String str, boolean z16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 30;
        obtain.obj = new b(str, z16);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void vKeyUpdateOccurred(String str, long j3) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 9;
        obtain.obj = new b(str, j3, 0L, 0, false);
        obtain.sendToTarget();
    }

    public void w0(String str, long j3, long j16, long j17, long j18) {
        PlayerUtils.log(4, "VideoReporter", "doDownloadSizeAndDuration: videoUuid=" + str + ", size=" + j3 + ", duration=" + j16 + ", fileSize=" + j17);
        if (r1(str, "doDownloadSizeAndDuration")) {
            if (j17 > 0) {
                this.L = j17;
            }
            this.M += j18;
            if (j3 <= 0 || j16 <= 0) {
                return;
            }
            if (this.U <= 0) {
                this.U = System.currentTimeMillis();
            }
            this.K += j3;
            this.N += j16;
        }
    }

    private void s1(List<Pair<Long, Long>> list, String str) {
        t1(list, str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str, int i3, long j3, int i16, String str2) {
        PlayerUtils.log(4, "VideoReporter", "doFailPlayVideo: what=" + i3 + ", extra=" + j3);
        if (r1(str, "doFailPlayVideo")) {
            this.f279483e0.add(new Pair<>(15, Long.valueOf(System.currentTimeMillis())));
            U0(str, -2L, i16, i3, j3, true, "doFailPlayVideo", str2);
        }
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void downloadSizeAndDuration(String str, long j3, long j16, long j17, long j18) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 19;
        obtain.obj = new b(str, j3, j16, j17, j18, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void startPlayVideo(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18, int i16) {
        startPlayVideo(str, str2, j3, j16, z16, str3, i3, z17, z18, i16, false);
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void urlRedirectOccurred(String str, String str2, long j3, long j16) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 10;
        obtain.obj = new b(str, str2, j3, j16, 0, false);
        obtain.sendToTarget();
    }

    @Override // com.tencent.oskplayer.report.IVideoReporter
    public void startPlayVideo(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18, int i16, boolean z19) {
        Message obtain = Message.obtain(this.f279499m0);
        obtain.what = 2;
        obtain.obj = new b(str, str2, str3, j3, j16, i3, z16, z17, z18, z19, i16);
        obtain.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            switch (message.what) {
                case 1:
                    VideoReporter.this.z0(bVar.f279521d);
                    return;
                case 2:
                    VideoReporter.this.O0(bVar.f279518a, bVar.f279519b, bVar.f279521d, bVar.f279522e, bVar.f279528k, bVar.f279520c, bVar.f279525h, bVar.f279529l, bVar.f279530m, bVar.f279531n, bVar.f279526i);
                    return;
                case 3:
                    VideoReporter.this.N0(bVar.f279518a);
                    return;
                case 4:
                    VideoReporter.this.F0(bVar.f279533p);
                    return;
                case 5:
                    VideoReporter.this.L0(bVar.f279518a, bVar.f279521d, bVar.f279522e);
                    return;
                case 6:
                    VideoReporter.this.M0(bVar.f279518a, bVar.f279521d, bVar.f279522e);
                    return;
                case 7:
                    VideoReporter.this.o0(bVar.f279532o);
                    return;
                case 8:
                    VideoReporter.this.D0(bVar.f279518a, bVar.f279521d);
                    return;
                case 9:
                    VideoReporter.this.S0(bVar.f279518a, bVar.f279521d);
                    return;
                case 10:
                    VideoReporter.this.R0(bVar.f279518a, bVar.f279519b, bVar.f279521d, bVar.f279522e);
                    return;
                case 11:
                    VideoReporter.this.G0(bVar.f279518a, bVar.f279521d, bVar.f279528k);
                    return;
                case 12:
                    VideoReporter.this.H0(bVar.f279518a, bVar.f279521d);
                    return;
                case 13:
                    VideoReporter.this.p0(bVar.f279518a, bVar.f279528k);
                    return;
                case 14:
                    VideoReporter.this.q0(bVar.f279518a, bVar.f279528k);
                    return;
                case 15:
                    VideoReporter.this.n0(bVar.f279518a, bVar.f279521d);
                    return;
                case 16:
                    VideoReporter.this.C0(bVar.f279518a, bVar.f279525h, bVar.f279526i);
                    return;
                case 17:
                    VideoReporter.this.B0(bVar.f279518a);
                    return;
                case 18:
                    VideoReporter.this.v0(bVar.f279518a, bVar.f279519b);
                    return;
                case 19:
                    VideoReporter.this.w0(bVar.f279518a, bVar.f279521d, bVar.f279522e, bVar.f279523f, bVar.f279524g);
                    return;
                case 20:
                    VideoReporter.this.t0(bVar.f279518a, bVar.f279521d, bVar.f279533p);
                    return;
                case 21:
                    VideoReporter.this.s0(bVar.f279518a);
                    return;
                case 22:
                    VideoReporter.this.P0(bVar.f279518a, bVar.f279521d, (int) bVar.f279522e);
                    return;
                case 23:
                    VideoReporter.this.x0(bVar.f279518a, bVar.f279525h, bVar.f279521d, bVar.f279527j, bVar.f279519b);
                    return;
                case 24:
                    VideoReporter.this.r0(bVar.f279518a);
                    return;
                case 25:
                    VideoReporter.this.I0(bVar.f279518a, bVar.f279528k);
                    return;
                case 26:
                    VideoReporter.this.u0(bVar.f279521d, bVar.f279522e, bVar.f279523f);
                    return;
                case 27:
                    VideoReporter.this.A0(bVar.f279518a, bVar.f279521d);
                    return;
                case 28:
                    VideoReporter.this.K0(bVar.f279518a, bVar.f279519b, bVar.f279533p);
                    return;
                case 29:
                    VideoReporter.this.E0(bVar.f279518a, bVar.f279525h);
                    return;
                case 30:
                    VideoReporter.this.Q0(bVar.f279518a, bVar.f279528k);
                    return;
                case 31:
                    VideoReporter.this.y0(bVar.f279518a);
                    return;
                case 32:
                    VideoReporter.this.D1(bVar.f279518a, bVar.f279525h);
                    return;
                case 33:
                    VideoReporter.this.J0(bVar.f279518a, bVar.f279525h);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(String str, long j3, int i3) {
        long j16 = j3;
        PlayerUtils.log(4, "VideoReporter", "doStopPlayVideo: playPosition=" + j16);
        if (r1(str, "doStopPlayVideo")) {
            this.f279483e0.add(new Pair<>(14, Long.valueOf(System.currentTimeMillis())));
            long j17 = -1;
            if (j16 <= this.F) {
                PlayerUtils.log(6, "VideoReporter", "doStopPlayVideo: ignore - playPosition is less than or equal to mAnyStartPlayPosition(" + this.F + ")");
                j16 = -1L;
            }
            if (j16 > 36000000) {
                PlayerUtils.log(6, "VideoReporter", "doStopPlayVideo: ignore - playPosition is more than MAX_VIDEO_TIME_IN_MS(36000000)");
            } else {
                j17 = j16;
            }
            U0(str, j17, i3, 0, 0L, false, "doStopPlayVideo", null);
        }
    }

    private void G1(long j3, String str) {
        if (j3 > 0 && this.f279503o0.containsKey(this.f279502o)) {
            this.f279492j = this.f279503o0.get(this.f279502o).longValue();
            PlayerUtils.log(3, "VideoReporter", "setVideoPlayId: [OLD] source=" + str + ", startPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
        } else {
            this.f279492j = Z0();
            PlayerUtils.log(3, "VideoReporter", "setVideoPlayId: [NEW] source=" + str + ", startPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
        }
        Iterator<Map<String, String>> it = this.f279477b0.iterator();
        while (it.hasNext()) {
            it.next().put("video_play_id", String.valueOf(this.f279492j));
        }
    }

    private String J1(double d16) {
        return String.valueOf(d16 / 1000.0d);
    }

    private void U0(String str, long j3, int i3, int i16, long j16, boolean z16, String str2, String str3) {
        String str4;
        Object obj;
        this.f279490i = System.currentTimeMillis() - this.f279488h;
        this.H = j3;
        if (z16) {
            this.V = PlayerUtils.getPlayVideoRetCode(i16, j16, str3);
        } else {
            this.V = 0L;
        }
        String mobileDetailInfo = PlayerUtils.getMobileDetailInfo();
        if (!TextUtils.isEmpty(mobileDetailInfo)) {
            mobileDetailInfo = mobileDetailInfo.replace(Typography.amp, ':');
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("finishPlayVideo: , videoUuid=");
        sb5.append(str);
        sb5.append(", playPosition=");
        sb5.append(j3);
        sb5.append(", bufferPercent=");
        sb5.append(i3);
        sb5.append(", what=");
        sb5.append(i16);
        sb5.append(", extra=");
        sb5.append(j16);
        sb5.append(", mPlayRetCode=");
        sb5.append(this.V);
        sb5.append(", isPlayerError=");
        sb5.append(z16);
        sb5.append(", source=");
        sb5.append(str2);
        sb5.append(", svrip=");
        sb5.append(this.I);
        sb5.append(", downloadResult=");
        sb5.append(this.R);
        sb5.append(", mVideoPlayProcessDuration=");
        sb5.append(this.f279490i);
        sb5.append(", mobileDetail=");
        sb5.append(mobileDetailInfo);
        sb5.append(", isH265Stream=");
        if (this.f279507q0.get("ExtraDataKeyH265StreamInfo") != null) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        sb5.append(str4);
        sb5.append(", downloadLastError=");
        sb5.append(TcUtils.lastError);
        String sb6 = sb5.toString();
        this.f279505p0 = sb6;
        PlayerUtils.log(4, "VideoReporter", sb6);
        I(this.F, j3);
        J(this.G, j3);
        if (f0()) {
            PlayerUtils.log(6, "VideoReporter", "finishPlayVideo: ignore - not valid video play");
            if (this.f279489h0 != null && this.f279489h0.M) {
                int i17 = this.f279489h0.f279928b0;
            } else {
                B1();
            }
        } else if (d.c().b(this.f279494k, this.V)) {
            PlayerUtils.log(6, "VideoReporter", "finishPlayVideo: same mPlayRetCode" + this.V + "within one minute of the same videoUrl =" + this.f279494k);
        } else if (d.c().b(this.f279494k, this.R)) {
            PlayerUtils.log(6, "VideoReporter", "finishPlayVideo: same mDownloadRetCode" + this.R + "within one minute of the same videoUrl =" + this.f279494k);
        } else {
            if (this.f279482e) {
                if (this.f279484f == 0) {
                    return;
                }
                if (System.currentTimeMillis() - this.f279484f > this.f279480d) {
                    this.f279492j = Z0();
                    PlayerUtils.log(4, "VideoReporter", "setVideoPlayId: [NEW_TWICE] source=" + str2 + ", endPlayPosition=" + j3 + ", mVideoPlayId=" + this.f279492j);
                    Iterator<Map<String, String>> it = this.f279477b0.iterator();
                    while (it.hasNext()) {
                        it.next().put("video_play_id", String.valueOf(this.f279492j));
                    }
                }
            }
            G();
            O(i3);
            a0();
            H(j3);
            z1();
            if (f279471s0 && this.f279489h0 != null && this.f279489h0.L) {
                C1();
            }
            if (this.f279489h0 != null && this.f279489h0.M) {
                if (this.f279489h0.f279928b0 == 0) {
                    y1();
                }
            } else {
                B1();
            }
            if (this.f279491i0 >= 0) {
                this.f279495k0 = j3;
                x1();
            }
            if (this.f279507q0.get("ExtraDataKeyH265StreamInfo") != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("video_source", this.f279507q0.get("ExtraDataKeyVideoSource"));
                hashMap.put("video_host", this.f279507q0.get("ExtraDataKeyVideoHost"));
                hashMap.put("video_filename", PlayerUtils.parseVideoFileName((String) this.f279507q0.get("ExtraDataKeyH265StreamInfo")));
                hashMap.put("video_first_buffer_time_cost", Long.valueOf(this.f279511u));
                hashMap.put("video_buffering_count", Integer.valueOf(this.f279515y));
                hashMap.put("video_play_ret", Long.valueOf(this.V));
                FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PLAY_H265_VIDEO, hashMap);
            } else if (this.f279507q0.get("ExtraDataKeyHLSStreamInfo") != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("video_source", this.f279507q0.get("ExtraDataKeyVideoSource"));
                hashMap2.put("video_host", this.f279507q0.get("ExtraDataKeyVideoHost"));
                hashMap2.put("video_filename", PlayerUtils.parseVideoFileName((String) this.f279507q0.get("ExtraDataKeyHLSStreamInfo")));
                hashMap2.put("video_first_buffer_time_cost", Long.valueOf(this.f279511u));
                hashMap2.put("video_buffering_count", Integer.valueOf(this.f279515y));
                hashMap2.put("video_play_ret", Long.valueOf(this.V));
                FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PLAY_HLS_VIDEO, hashMap2);
            }
            if (this.f279507q0.get("ExtraDataKeyPlayerType") != null) {
                HashMap<String, Object> hashMap3 = new HashMap<>();
                hashMap3.put("video_player_type", this.f279507q0.get("ExtraDataKeyPlayerType"));
                hashMap3.put("video_source", this.f279507q0.get("ExtraDataKeyVideoSource"));
                hashMap3.put("video_host", d1());
                hashMap3.put("video_url", this.f279494k);
                hashMap3.put("video_first_buffer_time_cost", Long.valueOf(this.f279511u));
                hashMap3.put("video_buffering_count", Integer.valueOf(this.f279515y));
                hashMap3.put("video_play_ret", Long.valueOf(this.V));
                hashMap3.put("video_decoder_name", this.f279507q0.get("ExtraDataKeyVideoDecoderName"));
                hashMap3.put("video_decoder_err_type", this.f279507q0.get("ExtraDataKeyVideoDecoderErrType"));
                FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PLAYER_TYPE, hashMap3);
            }
            if (this.f279507q0.get("ExtraDataKeyVideoActivity") != null) {
                HashMap<String, Object> hashMap4 = new HashMap<>();
                obj = this.f279507q0.get("ExtraDataKeyVideoActivity");
                hashMap4.put("video_player_refer", obj);
                hashMap4.put("video_player_type", this.f279507q0.get("ExtraDataKeyPlayerType"));
                hashMap4.put("video_first_buffer_time_cost", Long.valueOf(this.f279511u));
                hashMap4.put("video_buffering_count", Integer.valueOf(this.f279515y));
                hashMap4.put("video_play_ret", Long.valueOf(this.V));
                FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_ACTIVITY, hashMap4);
            } else {
                obj = null;
            }
            HashMap<String, Object> hashMap5 = new HashMap<>();
            if (this.f279507q0.get("ExtraDataKeyH265StreamInfo") != null) {
                hashMap5.put("video_type", "stream_h265");
            } else if (this.f279507q0.get("ExtraDataKeyHLSStreamInfo") != null) {
                hashMap5.put("video_type", "stream_hls");
            } else if (this.f279507q0.get("ExtraDataKeyOtherStreamInfo") != null) {
                hashMap5.put("video_type", "stream_other");
            } else if (this.f279507q0.get("ExtraDataKeyNoStreamInfo") != null) {
                hashMap5.put("video_type", "stream_no");
            } else {
                hashMap5.put("video_type", "stream_unknown");
            }
            FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_TYPE, hashMap5);
            HashMap<String, Object> hashMap6 = new HashMap<>();
            if (this.f279507q0.get("ExtraDataKeyEncH265StreamInfo") != null) {
                hashMap6.put("enc_type", "enc_h265");
            } else if (this.f279507q0.get("ExtraDataKeyEncH264StreamInfo") != null) {
                hashMap6.put("enc_type", "enc_h264");
            } else {
                hashMap6.put("enc_type", "enc_unknown");
            }
            FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_VIDEO_ENC, hashMap6);
            if (!"vertical".equals(obj)) {
                E1();
            }
        }
        this.f279503o0.put(this.f279502o, Long.valueOf(this.f279492j));
        UuidPlayIdMap.deleteItem(str);
        h0(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18, boolean z19, int i16) {
        long j17;
        long j18;
        long j19;
        long j26 = j3;
        PlayerUtils.log(4, "VideoReporter", "doStartPlayVideo: videoUrl=" + str2 + ", videoDuration=" + j26 + ", playPosition=" + j16 + ", isAutoPlay=" + z16 + ", videoId=" + str3 + ", feedsAppId=" + i3 + ", isHeroPlayer = " + z19);
        if (!F1(ReportState.REPORT_STATE_PREPARED)) {
            PlayerUtils.log(6, "VideoReporter", "doStartPlayVideo: wrong state");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            F1(ReportState.REPORT_STATE_ERROR);
            PlayerUtils.log(6, "VideoReporter", "doStartPlayVideo: videoUrl is empty");
            return;
        }
        if (j26 < 0 || j26 > 36000000) {
            PlayerUtils.log(3, "VideoReporter", "doStartPlayVideo: assign 0 to videoDuration");
            j26 = 0;
        }
        if (j16 < 0 || j16 > j26) {
            PlayerUtils.log(3, "VideoReporter", "doStartPlayVideo: assign 0 to playPosition");
            j17 = 0;
        } else {
            j17 = j16;
        }
        if (this.f279494k != null) {
            this.f279483e0.add(new Pair<>(16, Long.valueOf(System.currentTimeMillis())));
            long j27 = this.H;
            if (j27 > 0) {
                j18 = j26;
                j19 = j17;
                U0(null, j27, 0, 0, 0L, false, "doStartPlayVideo", null);
            } else {
                j18 = j26;
                j19 = j17;
                U0(null, -1L, 0, 0, 0L, false, "doStartPlayVideo", null);
            }
        } else {
            j18 = j26;
            j19 = j17;
        }
        this.f279483e0.add(new Pair<>(2, Long.valueOf(System.currentTimeMillis())));
        this.f279488h = System.currentTimeMillis();
        this.f279494k = str2;
        this.f279506q = j18;
        long j28 = j19;
        this.F = j28;
        this.G = j28;
        if (this.f279491i0 >= 0) {
            this.f279493j0 = j28;
        }
        this.f279498m = i16;
        this.f279508r = z16;
        this.f279500n = str3;
        this.f279502o = str;
        this.f279504p = i3;
        this.W = z19;
        H1(j28, "doStartPlayVideo", z17, z18);
        c0(z16);
    }
}
