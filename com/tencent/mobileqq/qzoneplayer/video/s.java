package com.tencent.mobileqq.qzoneplayer.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.model.VideoDecoderType;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes35.dex */
public class s implements i {

    /* renamed from: h, reason: collision with root package name */
    private static volatile s f280030h;

    /* renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<String, b> f280031i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, CountDownLatch> f280032j = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private int f280035c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f280036d;

    /* renamed from: e, reason: collision with root package name */
    private String f280037e;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f280033a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f280034b = 0;

    /* renamed from: f, reason: collision with root package name */
    public Handler f280038f = new a(Looper.getMainLooper());

    /* renamed from: g, reason: collision with root package name */
    private long f280039g = System.currentTimeMillis();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            s.this.c((c) message.obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f280053a;

        /* renamed from: b, reason: collision with root package name */
        public int f280054b;
    }

    s() {
        this.f280035c = 8000;
        this.f280036d = new ArrayList();
        this.f280037e = "qzvv.video.qq.com;";
        this.f280035c = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoChangeCkeyOverTime", 8000);
        String wnsConfig = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "tcVideoOriginUrl", "qzvv.video.qq.com;");
        this.f280037e = wnsConfig;
        if (!TextUtils.isEmpty(wnsConfig)) {
            this.f280036d = Arrays.asList(this.f280037e.split(";"));
        }
        PlayerUtils.log(4, "VideoUrlCallback", "[VideoUrlCallback] mGetSafeUrlStartTimestamp=" + this.f280039g);
    }

    private boolean d(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && (list = this.f280036d) != null && list.size() > 0) {
            Iterator<String> it = this.f280036d.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e(int i3) {
        SegmentVideoInfo.StreamInfo streamInfo;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (f280031i != null) {
            PlayerUtils.log(4, "VideoUrlCallback", "clearIllegalUrl begin, type = " + i3 + ", map.size = " + f280031i.size());
            Iterator<Map.Entry<String, b>> it = f280031i.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, b> next = it.next();
                b value = next != null ? next.getValue() : null;
                if (value != null && (streamInfo = value.f280050j) != null && (arrayList = streamInfo.segmentInfos) != null && arrayList.size() > 0) {
                    String str = value.f280050j.segmentInfos.get(0).url;
                    String c16 = t.c(str);
                    if (i3 != 1) {
                        if (i3 == 2 && PlayerUtils.isIPV4Address(c16)) {
                            it.remove();
                            PlayerUtils.log(4, "VideoUrlCallback", "tvk_log safe url remove, url = " + str);
                        }
                    } else if (PlayerUtils.isIPV6(c16)) {
                        it.remove();
                        PlayerUtils.log(4, "VideoUrlCallback", "tvk_log safe url remove, url = " + str);
                    }
                }
            }
        }
    }

    public static s g() {
        if (f280030h == null) {
            synchronized (s.class) {
                if (f280030h == null) {
                    f280030h = new s();
                }
            }
        }
        return f280030h;
    }

    /* JADX WARN: Finally extract failed */
    private void m(String str) {
        StringBuilder sb5;
        Map<String, CountDownLatch> map;
        if (TextUtils.isEmpty(str) || f280032j.containsKey(str)) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        f280032j.put(str, countDownLatch);
        try {
            try {
                countDownLatch.await(this.f280035c, TimeUnit.MILLISECONDS);
                map = f280032j;
            } catch (InterruptedException e16) {
                PlayerUtils.log(4, "VideoUrlCallback", "ErrorCallbackRunnable exception = " + e16.toString());
                Map<String, CountDownLatch> map2 = f280032j;
                if (map2 == null || map2.isEmpty() || !f280032j.containsKey(str)) {
                    return;
                } else {
                    sb5 = new StringBuilder();
                }
            }
            if (map == null || map.isEmpty() || !f280032j.containsKey(str)) {
                return;
            }
            sb5 = new StringBuilder();
            sb5.append("error url map size = ");
            sb5.append(f280032j.size());
            sb5.append(", oldUrl = ");
            sb5.append(str);
            PlayerUtils.log(4, "VideoUrlCallback", sb5.toString());
            f280032j.remove(str);
        } catch (Throwable th5) {
            Map<String, CountDownLatch> map3 = f280032j;
            if (map3 != null && !map3.isEmpty() && f280032j.containsKey(str)) {
                PlayerUtils.log(4, "VideoUrlCallback", "error url map size = " + f280032j.size() + ", oldUrl = " + str);
                f280032j.remove(str);
            }
            throw th5;
        }
    }

    public synchronized void f(String str) {
        Map<String, CountDownLatch> map;
        CountDownLatch countDownLatch;
        if (!TextUtils.isEmpty(str) && (map = f280032j) != null && !map.isEmpty() && f280032j.containsKey(str) && (countDownLatch = f280032j.get(str)) != null) {
            countDownLatch.countDown();
            this.f280033a = 3;
            PlayerUtils.log(4, "VideoUrlCallback", "error callback countdown by outside");
        }
    }

    public int i() {
        if (this.f280034b == 0) {
            this.f280034b = PlayerConfig.g().getVideoVkeyTimeOut() * 60 * 1000;
        }
        return this.f280034b;
    }

    public boolean j(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = f280031i;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return true;
        }
        String parseVideoKey = PlayerUtils.parseVideoKey(str);
        if (TextUtils.isEmpty(parseVideoKey) || !f280031i.containsKey(parseVideoKey)) {
            return true;
        }
        b bVar = f280031i.get(parseVideoKey);
        if (bVar != null && System.currentTimeMillis() - bVar.f280041a.longValue() > i()) {
            f280031i.remove(parseVideoKey);
            return true;
        }
        if (bVar == null || bVar.f280043c != SafeUrlState.URL_STATE_FAIL) {
            return false;
        }
        f280031i.remove(parseVideoKey);
        return true;
    }

    public void l(boolean z16) {
        PlayerUtils.log(4, "VideoUrlCallback", "tvk_log network changed connected = " + z16 + ",  currentNetType = " + t.b());
        if (z16) {
            e(PlayerConfig.g().getIPStackType());
        }
    }

    public void c(c cVar) {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (cVar != null) {
            String parseVideoKey = PlayerUtils.parseVideoKey(cVar.f280053a);
            if (TextUtils.isEmpty(parseVideoKey)) {
                return;
            }
            b bVar = f280031i.get(parseVideoKey);
            if (bVar != null) {
                SegmentVideoInfo.StreamInfo streamInfo = bVar.f280050j;
                if (streamInfo != null && (arrayList = streamInfo.segmentInfos) != null) {
                    new l(bVar.f280043c, arrayList, bVar.f280044d, bVar.f280048h, bVar.f280047g, bVar.f280046f, cVar.f280053a, bVar.f280049i, bVar.f280051k);
                    return;
                } else {
                    new l(bVar.f280043c, new SegmentVideoInfo.StreamInfo(cVar.f280053a, 1).segmentInfos, bVar.f280044d, bVar.f280048h, bVar.f280047g, bVar.f280046f, cVar.f280053a, bVar.f280049i, bVar.f280051k);
                    return;
                }
            }
            Handler handler = this.f280038f;
            if (handler != null) {
                int i3 = cVar.f280054b;
                if (i3 < 4) {
                    cVar.f280054b = i3 + 1;
                    handler.removeMessages(1);
                    Handler handler2 = this.f280038f;
                    handler2.sendMessageDelayed(handler2.obtainMessage(1, cVar), 1000L);
                    return;
                }
                new l(SafeUrlState.URL_STATE_TIMEOUT, new SegmentVideoInfo.StreamInfo(cVar.f280053a, 1).segmentInfos, 0, 0, false, 0, cVar.f280053a, 0, false);
            }
        }
    }

    private boolean k(SegmentVideoInfo.StreamInfo streamInfo) {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (streamInfo == null || (arrayList = streamInfo.segmentInfos) == null || arrayList.size() == 0) {
            return false;
        }
        String str = streamInfo.segmentInfos.get(0).url;
        String c16 = t.c(str);
        PlayerUtils.log(4, "VideoUrlCallback", "currentNetType = " + t.b() + ", isSegmentInfoMatchCurrentNetType playUrl = " + str);
        int iPStackType = PlayerConfig.g().getIPStackType();
        boolean z16 = true;
        if (iPStackType == 1) {
            z16 = true ^ PlayerUtils.isIPV6(c16);
            if (!z16) {
                PlayerUtils.log(4, "VideoUrlCallback", "current type = 1, no match playUrl = " + str);
            }
        } else if (iPStackType == 2 && !((z16 = true ^ PlayerUtils.isIPV4Address(c16)))) {
            PlayerUtils.log(4, "VideoUrlCallback", "current type = 2, no match playUrl = " + str);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.i
    public void a(String str, boolean z16, String str2, int i3, int i16) {
        SafeUrlState safeUrlState;
        b bVar;
        PlayerUtils.log(4, "VideoUrlCallback", " old url =" + str + ", response url=" + str2 + ", retCode = " + i3 + ", detailCode = " + i16);
        if (this.f280039g != 0) {
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().getSafeUrlOccurred(System.currentTimeMillis() - this.f280039g);
            }
            this.f280039g = 0L;
        }
        int i17 = i3 != 62 ? i3 != 80 ? 1371 : 1375 : 1376;
        if (f280031i != null) {
            String parseVideoKey = PlayerUtils.parseVideoKey(str);
            if (TextUtils.isEmpty(parseVideoKey)) {
                return;
            }
            if (f280031i.containsKey(parseVideoKey) && (bVar = f280031i.get(parseVideoKey)) != null && bVar.f280043c == SafeUrlState.URL_STATE_FAIL) {
                f280031i.remove(parseVideoKey);
            }
            if (f280031i.containsKey(parseVideoKey) || i3 == 0) {
                return;
            }
            ConcurrentHashMap<String, b> concurrentHashMap = f280031i;
            long currentTimeMillis = System.currentTimeMillis();
            if (z16) {
                safeUrlState = SafeUrlState.URL_STATE_SUCCESS;
            } else {
                safeUrlState = SafeUrlState.URL_STATE_FAIL;
            }
            concurrentHashMap.put(parseVideoKey, new b(currentTimeMillis, str, safeUrlState, i3, 6, i17, i16));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l h(String str, boolean z16) {
        l lVar;
        int i3;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList2;
        if (f280031i != null && !TextUtils.isEmpty(str)) {
            String parseVideoKey = PlayerUtils.parseVideoKey(str);
            if (!TextUtils.isEmpty(parseVideoKey)) {
                b bVar = f280031i.get(parseVideoKey);
                if (bVar != null && bVar.f280043c == SafeUrlState.URL_STATE_FAIL && bVar.f280044d == 85) {
                    PlayerUtils.log(4, "VideoUrlCallback", "error url = " + str + ", retCode == 85");
                    if (z16) {
                        PlayerUtils.log(4, "VideoUrlCallback", "safeUrlLock url=" + str);
                        m(str);
                        PlayerUtils.log(4, "VideoUrlCallback", "unLock safeUrlLock url=" + str);
                    }
                    bVar = f280031i.get(parseVideoKey);
                } else if (bVar == null && d(str)) {
                    PlayerUtils.log(4, "VideoUrlCallback", "timeout error url = " + str);
                    if (z16) {
                        PlayerUtils.log(4, "VideoUrlCallback", "safeUrlLock url=" + str);
                        m(str);
                        PlayerUtils.log(4, "VideoUrlCallback", "unLock safeUrlLock url=" + str);
                    }
                    bVar = f280031i.get(parseVideoKey);
                }
                if (bVar != null) {
                    SegmentVideoInfo.StreamInfo streamInfo = bVar.f280050j;
                    if (streamInfo != null && (arrayList2 = streamInfo.segmentInfos) != null) {
                        lVar = new l(bVar.f280043c, arrayList2, bVar.f280044d, bVar.f280048h, bVar.f280047g, bVar.f280046f, str, bVar.f280049i, bVar.f280051k);
                    } else {
                        lVar = new l(bVar.f280043c, new SegmentVideoInfo.StreamInfo(str, 1).segmentInfos, bVar.f280044d, bVar.f280048h, bVar.f280047g, bVar.f280046f, str, bVar.f280049i, bVar.f280051k);
                    }
                    if (lVar != null) {
                        SegmentVideoInfo.StreamInfo streamInfo2 = new SegmentVideoInfo.StreamInfo(str, 1);
                        if (!TextUtils.isEmpty(str) && !d(str)) {
                            PlayerUtils.log(4, "VideoUrlCallback", "return old url = " + str);
                            lVar = new l(SafeUrlState.URL_STATE_SUCCESS, streamInfo2.segmentInfos, 0, 0, false, 0, str, 0, false);
                            i3 = 0;
                        } else {
                            i3 = 0;
                            if (this.f280033a == 3) {
                                lVar = new l(SafeUrlState.URL_STATE_INTERRUPT, streamInfo2.segmentInfos, 0, 0, false, 0, str, 0, false);
                                this.f280033a = 0;
                            } else {
                                lVar = new l(SafeUrlState.URL_STATE_TIMEOUT, streamInfo2.segmentInfos, 0, 0, false, 0, str, 0, false);
                            }
                        }
                    } else {
                        i3 = 0;
                    }
                    arrayList = lVar.f280002b;
                    if (arrayList != null && arrayList.size() > 0) {
                        PlayerUtils.log(4, "VideoUrlCallback", "tvk_log finally play url = " + lVar.f280002b.get(i3).url);
                    }
                    return lVar;
                }
            }
        }
        lVar = null;
        if (lVar != null) {
        }
        arrayList = lVar.f280002b;
        if (arrayList != null) {
            PlayerUtils.log(4, "VideoUrlCallback", "tvk_log finally play url = " + lVar.f280002b.get(i3).url);
        }
        return lVar;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.i
    public void b(String str, boolean z16, SegmentVideoInfo.StreamInfo streamInfo, String[] strArr, boolean z17, int i3, boolean z18) {
        SafeUrlState safeUrlState;
        Map<String, CountDownLatch> map;
        CountDownLatch countDownLatch;
        PlayerUtils.log(4, "VideoUrlCallback", "[onResponseUrlSegment] flag = " + z16 + "oldUrl = " + str + ", mGetSafeUrlStartTimestamp=" + this.f280039g);
        if (this.f280039g != 0) {
            if (PlayerConfig.g().getVideoReporter() != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f280039g;
                PlayerUtils.log(4, "VideoUrlCallback", "[onResponseUrlSegment] duration=" + currentTimeMillis);
                PlayerConfig.g().getVideoReporter().getSafeUrlOccurred(currentTimeMillis);
            }
            this.f280039g = 0L;
        }
        if (!z16 || streamInfo == null) {
            return;
        }
        PlayerUtils.log(4, "VideoUrlCallback", "flag = " + z16 + "segment size = " + streamInfo.segmentInfos.size());
        if (z18) {
            streamInfo.setDecoderTypeSuggest(VideoDecoderType.DecoderType.H265_SW);
        } else {
            streamInfo.setDecoderTypeSuggest(VideoDecoderType.DecoderType.H264);
        }
        if (f280031i != null) {
            String parseVideoKey = PlayerUtils.parseVideoKey(str);
            if (!TextUtils.isEmpty(parseVideoKey)) {
                if (f280031i.containsKey(parseVideoKey)) {
                    f280031i.remove(parseVideoKey);
                }
                k(streamInfo);
                ConcurrentHashMap<String, b> concurrentHashMap = f280031i;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (z16) {
                    safeUrlState = SafeUrlState.URL_STATE_SUCCESS;
                } else {
                    safeUrlState = SafeUrlState.URL_STATE_FAIL;
                }
                concurrentHashMap.put(parseVideoKey, new b(currentTimeMillis2, str, safeUrlState, z17, i3, streamInfo, z18));
                if (!TextUtils.isEmpty(str) && (map = f280032j) != null && !map.isEmpty() && f280032j.containsKey(str) && (countDownLatch = f280032j.get(str)) != null) {
                    countDownLatch.countDown();
                    PlayerUtils.log(4, "VideoUrlCallback", "error callback countdown");
                }
            }
        }
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList = streamInfo.segmentInfos;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (streamInfo.segmentInfos.size() == 1) {
            if (streamInfo.segmentInfos.get(0) != null) {
                p.b(streamInfo.segmentInfos.get(0).url, strArr);
                PlayerUtils.log(4, "VideoUrlCallback", "tvk_log get safe url = " + streamInfo.segmentInfos.get(0).url);
                return;
            }
            return;
        }
        if (streamInfo.segmentInfos.size() > 1) {
            for (int i16 = 0; i16 < streamInfo.segmentInfos.size(); i16++) {
                if (streamInfo.segmentInfos.get(i16) != null) {
                    p.b(streamInfo.segmentInfos.get(i16).url, strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Long f280041a;

        /* renamed from: b, reason: collision with root package name */
        public String f280042b;

        /* renamed from: c, reason: collision with root package name */
        public SafeUrlState f280043c;

        /* renamed from: d, reason: collision with root package name */
        public int f280044d;

        /* renamed from: e, reason: collision with root package name */
        public int f280045e;

        /* renamed from: f, reason: collision with root package name */
        public int f280046f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f280047g;

        /* renamed from: h, reason: collision with root package name */
        public int f280048h;

        /* renamed from: i, reason: collision with root package name */
        public int f280049i;

        /* renamed from: j, reason: collision with root package name */
        public SegmentVideoInfo.StreamInfo f280050j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f280051k;

        public b(long j3, String str, SafeUrlState safeUrlState, int i3, int i16, int i17, int i18) {
            this.f280044d = 0;
            this.f280046f = 0;
            this.f280047g = false;
            this.f280048h = 0;
            this.f280049i = 0;
            this.f280051k = false;
            this.f280041a = Long.valueOf(j3);
            this.f280042b = str;
            this.f280043c = safeUrlState;
            this.f280044d = i3;
            this.f280045e = i16;
            this.f280046f = i17;
            this.f280049i = i18;
        }

        public b(long j3, String str, SafeUrlState safeUrlState, boolean z16, int i3, SegmentVideoInfo.StreamInfo streamInfo, boolean z17) {
            this.f280044d = 0;
            this.f280046f = 0;
            this.f280047g = false;
            this.f280048h = 0;
            this.f280049i = 0;
            this.f280051k = false;
            this.f280041a = Long.valueOf(j3);
            this.f280042b = str;
            this.f280043c = safeUrlState;
            this.f280047g = z16;
            this.f280048h = i3;
            this.f280050j = streamInfo;
            this.f280051k = z17;
        }
    }
}
