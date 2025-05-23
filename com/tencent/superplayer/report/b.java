package com.tencent.superplayer.report;

import com.tencent.mobileqq.videoplatform.QAReport;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static final AtomicLong Q = new AtomicLong();
    public static final AtomicLong R = new AtomicLong();
    public static final AtomicLong S = new AtomicLong();
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* renamed from: c, reason: collision with root package name */
    private int f373931c;

    /* renamed from: d, reason: collision with root package name */
    private String f373932d;

    /* renamed from: e, reason: collision with root package name */
    private String f373933e;

    /* renamed from: f, reason: collision with root package name */
    private int f373934f;

    /* renamed from: g, reason: collision with root package name */
    private long f373935g;

    /* renamed from: h, reason: collision with root package name */
    public long f373936h;

    /* renamed from: i, reason: collision with root package name */
    public float f373937i;

    /* renamed from: j, reason: collision with root package name */
    private long f373938j;

    /* renamed from: k, reason: collision with root package name */
    private long f373939k;

    /* renamed from: l, reason: collision with root package name */
    private long f373940l;

    /* renamed from: m, reason: collision with root package name */
    private long f373941m;

    /* renamed from: n, reason: collision with root package name */
    private long f373942n;

    /* renamed from: o, reason: collision with root package name */
    private long f373943o;

    /* renamed from: p, reason: collision with root package name */
    private long f373944p;

    /* renamed from: q, reason: collision with root package name */
    private long f373945q;

    /* renamed from: r, reason: collision with root package name */
    private int f373946r;

    /* renamed from: s, reason: collision with root package name */
    private int f373947s;

    /* renamed from: t, reason: collision with root package name */
    private int f373948t;

    /* renamed from: u, reason: collision with root package name */
    private int f373949u;

    /* renamed from: v, reason: collision with root package name */
    private int f373950v;

    /* renamed from: w, reason: collision with root package name */
    public int f373951w;

    /* renamed from: x, reason: collision with root package name */
    public int f373952x;

    /* renamed from: y, reason: collision with root package name */
    public int f373953y;

    /* renamed from: z, reason: collision with root package name */
    public int f373954z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f373929a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f373930b = true;
    private List<Integer> J = new ArrayList();
    private List<Integer> K = new ArrayList();
    private List<Integer> L = new ArrayList();
    private Set<Integer> M = new HashSet();
    private long N = 0;
    private long O = 0;
    private long P = 0;

    public b(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, int i3) {
        this.f373931c = superPlayerVideoInfo.getVideoSource();
        this.f373932d = superPlayerVideoInfo.getVid();
        this.f373933e = superPlayerVideoInfo.getPlayUrl();
        this.f373934f = i3;
        long videoDurationMs = superPlayerVideoInfo.getVideoDurationMs();
        this.f373936h = videoDurationMs;
        if (videoDurationMs <= 0) {
            this.f373936h = j3;
        }
    }

    public Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("param_videoSource", String.valueOf(this.f373931c));
        linkedHashMap.put("param_vid", this.f373932d);
        linkedHashMap.put("param_url", this.f373933e);
        linkedHashMap.put("param_uin", SuperPlayerSDKMgr.getUid());
        linkedHashMap.put("param_appId", String.valueOf(SuperPlayerSDKMgr.getPlatform()));
        linkedHashMap.put("param_sdkVersion", String.valueOf(SuperPlayerSDKMgr.getSDKVersion()));
        linkedHashMap.put("param_sceneId", String.valueOf(this.f373934f));
        linkedHashMap.put("param_success", String.valueOf(this.f373930b));
        linkedHashMap.put(QAReport.REPORT_KEY_FILE_SIZE, String.valueOf(this.f373935g));
        linkedHashMap.put("param_totalDownloadedSize", String.valueOf(this.f373938j));
        linkedHashMap.put("param_httpDownloadSize", String.valueOf(this.f373939k));
        linkedHashMap.put("param_httpRepeatedSize", String.valueOf(this.f373940l));
        linkedHashMap.put("param_pcdnDownloadSize", String.valueOf(this.f373941m));
        linkedHashMap.put("param_pcdnRepeatedSize", String.valueOf(this.f373942n));
        linkedHashMap.put("param_p2pDownloadSize", String.valueOf(this.f373943o));
        linkedHashMap.put("param_p2pRepeatedSize", String.valueOf(this.f373944p));
        linkedHashMap.put("param_pcdnRequestSize", String.valueOf(this.f373945q));
        linkedHashMap.put("param_pcdnRequestCount", String.valueOf(this.f373946r));
        linkedHashMap.put("param_pcdnDownloadFailCount", String.valueOf(this.f373947s));
        linkedHashMap.put("param_pcdnDownloadSuccessCount", String.valueOf(this.f373948t));
        linkedHashMap.put("param_avgHttpSpeed", String.valueOf(d.a(this.J)));
        linkedHashMap.put("param_avgPcdnSpeed", String.valueOf(d.a(this.K)));
        linkedHashMap.put("param_avgP2PSpeed", String.valueOf(d.a(this.L)));
        linkedHashMap.put("param_pcdnErrorCount", String.valueOf(this.f373949u));
        linkedHashMap.put("param_pcdnErrorSize", String.valueOf(this.f373950v));
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = this.M.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        linkedHashMap.put("param_pcdnStopReason", sb5.toString());
        linkedHashMap.put("param_natType", String.valueOf(this.f373951w));
        linkedHashMap.put("param_p2pFlag", String.valueOf(this.f373952x));
        linkedHashMap.put("param_maxUploadSpeed", String.valueOf(this.f373953y));
        linkedHashMap.put("param_punchCount", String.valueOf(this.f373954z));
        linkedHashMap.put("param_punchOkCount", String.valueOf(this.A));
        linkedHashMap.put("param_directPunchCount", String.valueOf(this.B));
        linkedHashMap.put("param_directPunchOkCount", String.valueOf(this.C));
        linkedHashMap.put("param_querySeedTimes", String.valueOf(this.D));
        linkedHashMap.put("param_querySeedOkTimes", String.valueOf(this.E));
        linkedHashMap.put("param_hasSeedTimes", String.valueOf(this.F));
        linkedHashMap.put("param_totalSeedCount", String.valueOf(this.G));
        linkedHashMap.put("param_connectedPeerCount", String.valueOf(this.H));
        linkedHashMap.put("param_connectedUploadPeerCount", String.valueOf(this.I));
        linkedHashMap.put("param_duration", String.valueOf(this.f373936h));
        long j3 = this.f373935g;
        if (j3 > 0) {
            long j16 = this.f373936h;
            if (j16 > 0) {
                this.f373937i = ((((float) j3) / 1024.0f) * 8.0f) / (((float) j16) / 1000.0f);
            }
        }
        linkedHashMap.put("param_bitrate", String.valueOf(this.f373937i));
        return linkedHashMap;
    }

    public String b() {
        return "actSPPredownload";
    }

    public void c() {
        if (!this.f373929a) {
            SPBeaconReporter.report(b(), a());
        }
        this.f373929a = true;
    }
}
