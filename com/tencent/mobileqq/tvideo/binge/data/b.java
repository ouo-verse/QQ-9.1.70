package com.tencent.mobileqq.tvideo.binge.data;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jy2.g;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final LruCache<String, Integer> f304364b = new LruCache<>(100);

    /* renamed from: c, reason: collision with root package name */
    private static final LruCache<String, Long> f304365c = new LruCache<>(100);

    /* renamed from: a, reason: collision with root package name */
    private final TVideoBingeWatchStateOperationViewModel f304366a = new TVideoBingeWatchStateOperationViewModel(new e() { // from class: com.tencent.mobileqq.tvideo.binge.data.a
        @Override // com.tencent.mobileqq.tvideo.binge.data.e
        public final void a(List list, boolean z16) {
            b.this.e(list, z16);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final b f304367a = new b();
    }

    b() {
    }

    public static b d() {
        return a.f304367a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(List list, boolean z16) {
        i(list);
    }

    public void b() {
        QLog.d("TVideoBingeWatchStateCacheManager", 4, QCircleLpReportDc05507.KEY_CLEAR);
        f304364b.evictAll();
        f304365c.evictAll();
    }

    public long c(@NonNull String str) {
        Long l3;
        if (TextUtils.isEmpty(str) || (l3 = f304365c.get(str)) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @TVideoBingeWatchUiState
    public int f(@NonNull String str) {
        QLog.d("TVideoBingeWatchStateCacheManager", 4, "queryCacheUiState:" + str);
        if (!TextUtils.isEmpty(str)) {
            LruCache<String, Integer> lruCache = f304364b;
            if (lruCache.get(str) != null) {
                return lruCache.get(str).intValue();
            }
            return -2;
        }
        return -2;
    }

    public void g(@NonNull List<FeedCloudMeta$StFeed> list) {
        VideoBaseInfo videoBaseInfo;
        QLog.d("TVideoBingeWatchStateCacheManager", 4, "queryCloudUiStateByFeeds");
        if (list.size() != 0 && zt2.e.f453199a.k()) {
            ArrayList arrayList = new ArrayList();
            Iterator<FeedCloudMeta$StFeed> it = list.iterator();
            while (it.hasNext()) {
                Video q16 = g.q(it.next());
                if (q16 != null && (videoBaseInfo = q16.video_base_info) != null) {
                    String str = videoBaseInfo.cid;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.f304366a.S1(arrayList);
                return;
            }
            return;
        }
        QLog.d("TVideoBingeWatchStateCacheManager", 4, "queryCloudUiStateByFeeds fail, not login");
    }

    public void h(@NonNull String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            f304365c.put(str, Long.valueOf(j3));
        }
    }

    public void i(List<TVideoBingeWatchUiData> list) {
        QLog.d("TVideoBingeWatchStateCacheManager", 4, "updateCacheUiState");
        if (list != null && list.size() != 0) {
            for (TVideoBingeWatchUiData tVideoBingeWatchUiData : list) {
                if (tVideoBingeWatchUiData != null && !TextUtils.isEmpty(tVideoBingeWatchUiData.getCid())) {
                    f304364b.put(tVideoBingeWatchUiData.getCid(), Integer.valueOf(tVideoBingeWatchUiData.getUiState()));
                }
            }
        }
    }
}
