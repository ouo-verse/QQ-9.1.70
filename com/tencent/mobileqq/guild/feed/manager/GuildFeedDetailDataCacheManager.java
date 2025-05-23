package com.tencent.mobileqq.guild.feed.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.LruCache;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheData;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheResponse;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.util.w;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDetailDataCacheManager {

    /* renamed from: g, reason: collision with root package name */
    private static volatile GuildFeedDetailDataCacheManager f220104g;

    /* renamed from: b, reason: collision with root package name */
    private LruCache<String, Long> f220106b;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.cache.api.collection.a<String, GProStFeed> f220108d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.cache.api.collection.a<String, GProStFeed> f220109e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.cache.api.collection.a<String, GProStFeed> f220110f;

    /* renamed from: a, reason: collision with root package name */
    private final e f220105a = new e();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Long> f220107c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements com.tencent.mobileqq.guild.feed.preload.detail.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.feed.preload.detail.g f220116a;

        b(com.tencent.mobileqq.guild.feed.preload.detail.g gVar) {
            this.f220116a = gVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.preload.detail.g
        public void a(boolean z16, GuildFeedDetailCacheResponse guildFeedDetailCacheResponse) {
            GuildFeedDetailDataCacheManager.this.C(z16, guildFeedDetailCacheResponse);
            com.tencent.mobileqq.guild.feed.preload.detail.g gVar = this.f220116a;
            if (gVar != null) {
                gVar.a(z16, guildFeedDetailCacheResponse);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends LruCache<String, Long> {
        c(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z16, @NonNull String str, @NonNull Long l3, @Nullable Long l16) {
            if (z16) {
                GuildFeedDetailDataCacheManager.this.G(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements Comparator<Map.Entry<String, Long>> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry.getValue().compareTo(entry2.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f220120a;

        /* renamed from: b, reason: collision with root package name */
        public String f220121b;

        e() {
        }
    }

    GuildFeedDetailDataCacheManager() {
        Business business = Business.Guild;
        this.f220108d = new com.tencent.cache.api.collection.a<>(business, "GuildFeedDetailDataCacheManager", 15);
        this.f220109e = new com.tencent.cache.api.collection.a<>(business, "GuildFeedDetailDataCacheManager", 5);
        this.f220110f = new com.tencent.cache.api.collection.a<>(business, "GuildFeedDetailDataCacheManager", 5);
    }

    private long A() {
        return w.b("qqguild", "guild_feed_detail_pre_load_expired_TIME", 86400000L).longValue();
    }

    private int B() {
        return w.a("qqguild", "guild_feed_detail_pre_load_max_count", 100).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z16, GuildFeedDetailCacheResponse guildFeedDetailCacheResponse) {
        QLog.d("GuildFeedDetailDataCacheManager", 1, "handleFeedDetailResponse, isSuccess " + z16 + ", retCode " + guildFeedDetailCacheResponse.getError() + ", costTime " + guildFeedDetailCacheResponse.getCostTime() + ", listSize: " + guildFeedDetailCacheResponse.getCacheList().size());
        if (z16 && !guildFeedDetailCacheResponse.getCacheList().isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedDetailDataCacheManager", 1, "handleFeedDetailResponse, list: " + guildFeedDetailCacheResponse.getCacheList());
            }
            for (GuildFeedDetailCacheData guildFeedDetailCacheData : guildFeedDetailCacheResponse.getCacheList()) {
                String feedId = guildFeedDetailCacheData.getFeedId();
                long lastModifyTime = guildFeedDetailCacheData.getLastModifyTime();
                String v3 = v(feedId, lastModifyTime);
                if (!TextUtils.isEmpty(guildFeedDetailCacheData.getFeedJson())) {
                    f(v3, guildFeedDetailCacheData.getFeedJson());
                } else if (guildFeedDetailCacheData.getFeedContentBean() != null) {
                    i(v3, guildFeedDetailCacheData.getFeedContentBean());
                }
                g(feedId, lastModifyTime);
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFeedDetailDataCacheManager", 1, "removeFeedFromNetLoad, feedDetailKey=" + v3);
                }
            }
        }
    }

    private void D() {
        String[] allKeyArr = bw.L().allKeyArr();
        if (allKeyArr != null && allKeyArr.length != 0) {
            ArrayList<Map.Entry> arrayList = new ArrayList();
            for (String str : allKeyArr) {
                if (str.startsWith("accessTime:")) {
                    long decodeLong = bw.L().decodeLong(str, 0L);
                    if (decodeLong > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - decodeLong;
                        long A = A();
                        String w3 = w(str);
                        if (currentTimeMillis > A) {
                            QLog.d("GuildFeedDetailDataCacheManager", 4, "\u8d85\u8fc7\u8fc7\u671f\u65f6\u95f4\uff0c\u5220\u9664\u7f13\u5b58, expiredTimeMillis=" + A);
                            G(w3);
                        } else {
                            arrayList.add(new AbstractMap.SimpleEntry(w3, Long.valueOf(decodeLong)));
                        }
                    }
                }
            }
            Collections.sort(arrayList, new d());
            for (Map.Entry entry : arrayList) {
                p().put((String) entry.getKey(), (Long) entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        QLog.d("GuildFeedDetailDataCacheManager", 4, "removeFeedDetailJson, feedDetailKey=" + str);
        bw.L().removeKey(str);
        bw.L().removeKey(o(str));
    }

    private void H(String str) {
        QLog.d("GuildFeedDetailDataCacheManager", 4, "setFeedAccessTime, feedDetailKey=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        p().put(str, Long.valueOf(currentTimeMillis));
        bw.L().encodeLong(o(str), currentTimeMillis);
    }

    private void I(List<GuildFeedDetailPreloadParams> list, com.tencent.mobileqq.guild.feed.preload.detail.g gVar) {
        GuildFeedDetailNetTaskManager.k().h(list, new b(gVar));
    }

    @WorkerThread
    private void f(String str, String str2) {
        QLog.d("GuildFeedDetailDataCacheManager", 4, "cacheFeedDetailJson feedDetailKey=" + str);
        bw.L().encodeString(str, str2);
        H(str);
    }

    private void g(String str, long j3) {
        this.f220107c.put(str, Long.valueOf(j3));
    }

    private void h(String str, GProStFeed gProStFeed) {
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildFeedDetailDataCacheManager", 4, "cacheLongFeedDetailBean, feedId =" + str + ", paragraphs: " + gProStFeed.contentWithStyle.paragraphs.size());
        }
        this.f220109e.f(str, gProStFeed);
    }

    private void i(String str, GProStFeed gProStFeed) {
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildFeedDetailDataCacheManager", 4, "cachePreLoadLongFeedDetailBean, feedId =" + str + ", paragraphs: " + gProStFeed.contentWithStyle.paragraphs.size());
        }
        this.f220108d.f(str, gProStFeed);
    }

    private void j(String str, GProStFeed gProStFeed) {
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildFeedDetailDataCacheManager", 4, "cacheShortFeedDetailBean, feedId =" + str + ", paragraphs: " + gProStFeed.contentWithStyle.paragraphs.size());
        }
        this.f220110f.f(str, gProStFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(List<GuildFeedDetailPreloadParams> list, com.tencent.mobileqq.guild.feed.preload.detail.g gVar) {
        Iterator<GuildFeedDetailPreloadParams> it = list.iterator();
        while (it.hasNext()) {
            H(u(it.next()));
        }
        List<GuildFeedDetailPreloadParams> n3 = n(list);
        if (n3.isEmpty()) {
            return;
        }
        I(n3, gVar);
    }

    private List<GuildFeedDetailPreloadParams> n(List<GuildFeedDetailPreloadParams> list) {
        ArrayList arrayList = new ArrayList();
        for (GuildFeedDetailPreloadParams guildFeedDetailPreloadParams : list) {
            if (!E(guildFeedDetailPreloadParams.getFeedId(), guildFeedDetailPreloadParams.getLastModifyTime())) {
                arrayList.add(guildFeedDetailPreloadParams);
            }
        }
        return arrayList;
    }

    private String o(String str) {
        return "accessTime:" + str;
    }

    private LruCache<String, Long> p() {
        if (this.f220106b == null) {
            this.f220106b = new c(B());
            D();
        }
        return this.f220106b;
    }

    private String u(GuildFeedDetailPreloadParams guildFeedDetailPreloadParams) {
        return v(guildFeedDetailPreloadParams.getFeedId(), guildFeedDetailPreloadParams.getLastModifyTime());
    }

    private String w(String str) {
        return str.replaceFirst("accessTime:", "");
    }

    public static GuildFeedDetailDataCacheManager y() {
        if (f220104g == null) {
            synchronized (GuildFeedDetailDataCacheManager.class) {
                if (f220104g == null) {
                    f220104g = new GuildFeedDetailDataCacheManager();
                }
            }
        }
        return f220104g;
    }

    private String z(String str) {
        String[] allKeyArr = bw.L().allKeyArr();
        if (allKeyArr == null || allKeyArr.length == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : allKeyArr) {
            if (str2.startsWith("feedDetail:") && str2.contains(str)) {
                arrayList.add(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFeedDetailDataCacheManager", 1, str + " getLatestFeedDetailCache, feedKey: " + str2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        Collections.sort(arrayList, new a());
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedDetailDataCacheManager", 1, "getLatestFeedDetailCache, decodeString: " + ((String) arrayList.get(0)));
        }
        return bw.L().decodeString((String) arrayList.get(0), "");
    }

    public boolean E(String str, long j3) {
        boolean z16;
        String v3 = v(str, j3);
        if (!((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).isLongFeedNativeSwitchOpen()) {
            z16 = bw.L().containsKey(v3);
        } else if (r(str, j3, false) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedDetailDataCacheManager", 1, "isFeedDetailCacheExist, isExist " + z16 + ", key: " + v3);
        }
        return z16;
    }

    public void F(final String str, final long j3) {
        if (!m()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager.4
            @Override // java.lang.Runnable
            public void run() {
                String v3 = GuildFeedDetailDataCacheManager.this.v(str, j3);
                String decodeString = bw.L().decodeString(v3, null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("preLoadFeedDetailJson, feedDetailKey=");
                sb5.append(v3);
                sb5.append(", isExit: ");
                sb5.append(!TextUtils.isEmpty(decodeString));
                QLog.d("GuildFeedDetailDataCacheManager", 4, sb5.toString());
                if (!TextUtils.isEmpty(decodeString)) {
                    GuildFeedDetailDataCacheManager.this.f220105a.f220120a = v3;
                    GuildFeedDetailDataCacheManager.this.f220105a.f220121b = decodeString;
                }
            }
        });
    }

    public void J(String str, long j3, String str2) {
        String v3 = v(str, j3);
        f(v3, str2);
        g(str, j3);
        e eVar = this.f220105a;
        eVar.f220120a = v3;
        eVar.f220121b = str2;
    }

    public void e(@NonNull GProStFeed gProStFeed) {
        long j3 = gProStFeed.meta.lastModifiedTime;
        if (j3 <= 0) {
            j3 = gProStFeed.createTime;
        }
        String v3 = y().v(gProStFeed.idd, j3);
        if (((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).isLongFeedNativeSwitchOpen() && ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).checkCanPreload(gProStFeed)) {
            h(v3, gProStFeed);
        } else if (TextUtils.equals(gProStFeed.poster.idd, ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId())) {
            j(v3, gProStFeed);
        }
    }

    public void k(String str) {
        boolean z16;
        e eVar = this.f220105a;
        if (eVar == null) {
            QLog.e("GuildFeedDetailDataCacheManager", 1, "deleteCacheByFeedId: mFeedDetailBeanCache is null");
            return;
        }
        if (!TextUtils.isEmpty(eVar.f220120a) && this.f220105a.f220120a.contains(str)) {
            this.f220105a.f220120a = "";
        }
        String[] allKeyArr = bw.L().allKeyArr();
        if (allKeyArr != null && allKeyArr.length != 0) {
            if (!TextUtils.isEmpty(this.f220105a.f220120a) && this.f220105a.f220120a.contains(str)) {
                e eVar2 = this.f220105a;
                eVar2.f220120a = "";
                eVar2.f220121b = "";
            }
            for (String str2 : allKeyArr) {
                if (!str2.startsWith("feedDetail:") && !str2.startsWith("accessTime:")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && str2.contains(str)) {
                    QLog.d("GuildFeedDetailDataCacheManager", 1, "deleteCacheByFeedId: key=" + str2);
                    bw.L().removeKey(str2);
                }
            }
            return;
        }
        QLog.e("GuildFeedDetailDataCacheManager", 1, "deleteLocalCache: MMKV allKeys is null");
    }

    public boolean m() {
        boolean equals = w.c("qqguild", "guild_feed_detail_pre_load_switch", "1").equals("1");
        if (!equals) {
            QLog.d("GuildFeedDetailDataCacheManager", 4, "enablePreLoadFromWNS=false");
        }
        return equals;
    }

    public String q(String str, long j3) {
        if (m() && !TextUtils.isEmpty(str)) {
            if (j3 == 0) {
                j3 = x(str);
            }
            String v3 = v(str, j3);
            if (TextUtils.equals(this.f220105a.f220120a, v3)) {
                return this.f220105a.f220121b;
            }
            String decodeString = bw.L().decodeString(v3, "");
            if (!TextUtils.isEmpty(decodeString)) {
                return decodeString;
            }
            if (!TextUtils.isEmpty(decodeString) || j3 != 0) {
                return "";
            }
            return z(str);
        }
        QLog.e("GuildFeedDetailDataCacheManager", 1, "getFeedDetailCache fail");
        return null;
    }

    public GProStFeed r(String str, long j3, boolean z16) {
        String v3 = v(str, j3);
        GProStFeed e16 = this.f220109e.e(v3);
        if (e16 == null) {
            e16 = this.f220110f.e(v3);
        }
        if (!z16 && e16 == null) {
            e16 = this.f220108d.e(v3);
        }
        if (e16 != null) {
            QLog.d("GuildFeedDetailDataCacheManager", 4, "getFeedDetailFromCache, feedId =" + str + ", imagesize: " + e16.images.size());
        }
        return e16;
    }

    public boolean s(List<GuildFeedDetailPreloadParams> list) {
        return t(list, null);
    }

    public boolean t(final List<GuildFeedDetailPreloadParams> list, final com.tencent.mobileqq.guild.feed.preload.detail.g gVar) {
        if (bl.b(list)) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager.2
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedDetailDataCacheManager.this.l(list, gVar);
            }
        }, 192, null, false);
        return true;
    }

    public String v(String str, long j3) {
        return "feedDetail:" + str + "|" + j3;
    }

    public long x(String str) {
        Map<String, Long> map = this.f220107c;
        if (map != null && map.containsKey(str)) {
            return this.f220107c.get(str).longValue();
        }
        return 0L;
    }
}
