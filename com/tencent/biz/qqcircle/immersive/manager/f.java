package com.tencent.biz.qqcircle.immersive.manager;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.bi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: g, reason: collision with root package name */
    private static volatile f f87219g;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Long> f87220a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Long> f87221b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f87222c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f87223d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f87224e;

    /* renamed from: f, reason: collision with root package name */
    private long f87225f;

    f() {
        i();
    }

    private String b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        String str = null;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StVideo = null;
        } else {
            feedCloudMeta$StVideo = feedCloudMeta$StFeed.video;
        }
        if (feedCloudMeta$StVideo != null) {
            str = feedCloudMeta$StVideo.playUrl.get();
        }
        return r.N(str);
    }

    public static f f() {
        if (f87219g == null) {
            synchronized (f.class) {
                if (f87219g == null) {
                    f87219g = new f();
                }
            }
        }
        return f87219g;
    }

    private void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f87220a.remove(str);
    }

    public void a() {
        this.f87221b.clear();
        this.f87222c.clear();
    }

    public long c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        PBStringField pBStringField;
        long j3;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) == null || (pBStringField = feedCloudMeta$StVideo.playUrl) == null || TextUtils.isEmpty(pBStringField.get())) {
            return 0L;
        }
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2 = feedCloudMeta$StFeed.video;
        if (feedCloudMeta$StVideo2 == null) {
            j3 = 0;
        } else {
            j3 = feedCloudMeta$StVideo2.duration.get();
        }
        if (!f().g(j3)) {
            return 0L;
        }
        String N = r.N(feedCloudMeta$StFeed.video.playUrl.get());
        boolean d16 = bi.d(QCircleApplication.getAPP(), feedCloudMeta$StFeed);
        QLog.d("QFSPlayerPositionHistoryManager", 1, "[getHistoryPlayerProgress] duration: " + j3 + " | hasShouldAutoSlide: " + d16 + " | hasShouldAutoSlide: " + d16);
        return d(d16, j3, N);
    }

    public long d(boolean z16, long j3, String str) {
        long longValue;
        Long l3 = this.f87220a.get(str);
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        if (z16 && this.f87225f + longValue >= j3) {
            longValue = 0;
        }
        if (j3 > 0 && !TextUtils.isEmpty(str)) {
            QLog.d("QFSPlayerPositionHistoryManager", 1, "[getHistoryPosition] isAutoPlayToNext: " + z16 + " | duration: " + j3 + " | playUrlKey: " + str);
        }
        return longValue;
    }

    public Long e(String str) {
        return this.f87221b.get(str);
    }

    public boolean g(long j3) {
        if (o.y()) {
            return true;
        }
        boolean z16 = false;
        if (j3 <= 0) {
            return false;
        }
        long j16 = this.f87224e;
        if (j16 > 0 && j3 >= j16) {
            z16 = true;
        }
        if (this.f87223d != z16) {
            QLog.d("QFSPlayerPositionHistoryManager", 1, "[QPH][isEnabledGlobalHistoryPosition] duration: " + j3 + " | isEnabledGlobalDuration: " + z16);
            this.f87223d = z16;
        }
        return z16;
    }

    public boolean h(String str) {
        return this.f87222c.contains(str);
    }

    public void i() {
        this.f87224e = uq3.c.q1();
        this.f87225f = uq3.c.Y1();
    }

    public void j() {
        this.f87220a.clear();
    }

    public void l(List<e30.b> list) {
        if (list != null && !list.isEmpty()) {
            for (e30.b bVar : list) {
                if (bVar != null) {
                    k(b(bVar.g()));
                }
            }
            QLog.d("QFSPlayerPositionHistoryManager", 1, "[QPH][resetPlayerPositionHistory] remove player position size: " + list.size());
        }
    }

    public void m(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSPlayerPositionHistoryManager", 1, "[QPH][updatePositionHistory] play url key should not be null, end flow.");
        } else {
            this.f87220a.put(str, Long.valueOf(j3));
        }
    }

    public void n(String str, Long l3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f87221b.put(str, l3);
    }

    public void o(String str) {
        this.f87222c.add(str);
    }
}
