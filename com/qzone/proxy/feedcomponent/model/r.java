package com.qzone.proxy.feedcomponent.model;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes39.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    private static volatile r f50421b;

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f50422c = new ConcurrentLinkedQueue<>();

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, Long> f50423d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, a> f50424e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public static int f50425f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static int f50426g = 4;

    /* renamed from: h, reason: collision with root package name */
    public static int f50427h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static int f50428i = 4;

    /* renamed from: j, reason: collision with root package name */
    public static int f50429j = 1;

    /* renamed from: k, reason: collision with root package name */
    public static int f50430k = 1000;

    /* renamed from: a, reason: collision with root package name */
    private b f50431a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void a() {
            QZLog.i("TencentVideoUtil", "remove requesr url");
            if (r.f50423d == null || r.f50423d.isEmpty()) {
                return;
            }
            Iterator it = r.f50423d.keySet().iterator();
            while (it.hasNext()) {
                String obj = it.next().toString();
                if (System.currentTimeMillis() - ((Long) r.f50423d.get(obj)).longValue() >= r.f50430k) {
                    if (!TextUtils.isEmpty(obj) && r.f50424e != null && r.f50424e.containsKey(obj)) {
                        QZLog.i("TencentVideoUtil", "already request vid map contains = " + obj);
                        r.f50422c.add((a) r.f50424e.get(obj));
                        r.f50424e.remove(obj);
                    }
                    it.remove();
                }
            }
            if (r.f50422c != null && !r.f50422c.isEmpty()) {
                removeMessages(1);
                sendMessageDelayed(obtainMessage(1), 10L);
            }
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2), r.f50430k);
        }

        public void b() {
            if (r.f50422c == null || r.f50422c.size() <= 0) {
                return;
            }
            a aVar = (a) r.f50422c.poll();
            if (aVar != null && com.tencent.mobileqq.qzoneplayer.video.s.g().j(aVar.f50432a)) {
                if (r.f50423d != null && !r.f50423d.isEmpty() && r.f50423d.containsKey(aVar.f50433b)) {
                    QZLog.i("TencentVideoUtil", "already request safe url vid = " + aVar.f50433b + ", url = " + aVar.f50432a);
                    if (r.f50424e != null) {
                        r.f50424e.put(aVar.f50433b, aVar);
                    }
                } else {
                    QZLog.i("TencentVideoUtil", "magi request safe url vid = " + aVar.f50433b + ", url = " + aVar.f50432a);
                    com.qzone.adapter.feedcomponent.i.H().z0(aVar.f50432a, aVar.f50433b, aVar.f50434c, aVar.f50435d, com.tencent.mobileqq.qzoneplayer.video.s.g());
                    if (r.f50423d == null || !r.f50423d.isEmpty()) {
                        if (r.f50423d != null) {
                            r.f50423d.put(aVar.f50433b, Long.valueOf(System.currentTimeMillis()));
                        }
                    } else {
                        r.f50423d.put(aVar.f50433b, Long.valueOf(System.currentTimeMillis()));
                        removeMessages(2);
                        sendMessageDelayed(obtainMessage(2), r.f50430k);
                    }
                }
            }
            if (r.f50422c.size() > 0) {
                removeMessages(1);
                sendMessageDelayed(obtainMessage(1), 10L);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                b();
            } else {
                if (i3 != 2) {
                    return;
                }
                a();
            }
        }
    }

    r() {
        h();
        f50425f = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_REQUEST_SAFE_URL_FEEDS, 2);
        f50426g = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_CHECK_FEEDS, 3);
        f50427h = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_REQUEST_SAFE_URL_RECOMMEND, 2);
        f50428i = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_CHECK_RECOMMEND, 3);
        f50429j = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_REQUEST_SAFE_URL_RESPONSE_RECOMMEND, 0);
        f50430k = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_REQUEST_SAFE_URL_REMOVE_TIME, 1000);
    }

    public static r e() {
        if (f50421b == null) {
            synchronized (r.class) {
                if (f50421b == null) {
                    f50421b = new r();
                }
            }
        }
        return f50421b;
    }

    private b h() {
        if (this.f50431a == null) {
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
            HandlerThread realTimeThread = feedVideoExternalFunc != null ? feedVideoExternalFunc.getRealTimeThread() : null;
            if (realTimeThread != null) {
                this.f50431a = new b(realTimeThread.getLooper());
            }
        }
        return this.f50431a;
    }

    public synchronized void d(List<a> list) {
        if (f50422c != null) {
            for (a aVar : list) {
                if (!f50422c.contains(aVar)) {
                    f50422c.add(aVar);
                }
            }
            if (h() != null && f50422c.size() > 0) {
                h().sendEmptyMessage(1);
            }
        }
    }

    public void f(List<VideoPlayInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        QZLog.i("TencentVideoUtil", "getVideoPlayInfoSafeUrl list size = " + list.size() + "request feeds = " + f50425f);
        int size = list.size();
        int i3 = f50425f;
        if (size < i3) {
            i3 = list.size();
        }
        Iterator<VideoPlayInfo> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i3) {
            VideoPlayInfo next = it.next();
            if (next != null && next.orgwebsite == 1) {
                String realSegmentUrl = next.segmentVideoInfo.getRealSegmentUrl(4, 0);
                if (TextUtils.isEmpty(realSegmentUrl)) {
                    realSegmentUrl = next.segmentVideoInfo.getDefaultUrl();
                }
                arrayList.add(new a(realSegmentUrl, next.videoId, null, next.videoPlayScene));
            }
        }
        if (arrayList.size() > 0) {
            d(arrayList);
        }
    }

    public void g(String str, String str2, String str3) {
        QZLog.i("TencentVideoUtil", "sdk magi request safe url vid = " + str2 + ", url = " + str);
        ArrayList arrayList = new ArrayList();
        r e16 = e();
        Objects.requireNonNull(e16);
        arrayList.add(new a(str, str2, null, str3));
        d(arrayList);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f50432a;

        /* renamed from: b, reason: collision with root package name */
        public String f50433b;

        /* renamed from: c, reason: collision with root package name */
        public String f50434c;

        /* renamed from: d, reason: collision with root package name */
        public String f50435d;

        public a(String str, String str2, String str3, String str4) {
            this.f50432a = str;
            this.f50433b = str2;
            this.f50434c = str3;
            this.f50435d = str4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                String parseVideoKey = PlayerUtils.parseVideoKey(this.f50432a);
                String parseVideoKey2 = PlayerUtils.parseVideoKey(((a) obj).f50432a);
                if (!TextUtils.isEmpty(parseVideoKey) && parseVideoKey.equals(parseVideoKey2)) {
                    return true;
                }
            }
            return false;
        }
    }
}
