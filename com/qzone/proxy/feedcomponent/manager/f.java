package com.qzone.proxy.feedcomponent.manager;

import android.content.SharedPreferences;
import android.os.HandlerThread;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.adapter.feedcomponent.k;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.adapter.feedcomponent.t;
import com.qzone.adapter.feedcomponent.u;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface f {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void t(List<BusinessFeedData> list, List<BusinessFeedData> list2);

        void v(List<BusinessFeedData> list, boolean z16, boolean z17, boolean z18, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void d(boolean z16);

        void e(com.qzone.adapter.feedcomponent.c cVar, boolean z16);

        u g(int i3, d dVar, t tVar, c cVar);

        SharedPreferences getSharedPreferences();

        void h(boolean z16);

        void j(com.qzone.adapter.feedcomponent.c cVar, boolean z16, int i3);

        com.qzone.proxy.feedcomponent.manager.d r(e eVar, e.a aVar, int i3, int i16);

        HandlerThread x();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void onFailed(u uVar, s sVar);

        void onSucceed(u uVar, s sVar, com.qzone.adapter.feedcomponent.c cVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f50211a;

        /* renamed from: b, reason: collision with root package name */
        public long f50212b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f50213c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f50214d;

        /* renamed from: e, reason: collision with root package name */
        public String f50215e;

        /* renamed from: f, reason: collision with root package name */
        public String f50216f;

        /* renamed from: g, reason: collision with root package name */
        public HashMap<String, String> f50217g;

        /* renamed from: h, reason: collision with root package name */
        public Map<String, String> f50218h;
    }

    void clearAllCache();

    void clearMemoryCache();

    void close();

    void deleteFeedMemOnly(BusinessFeedData businessFeedData);

    void deleteFeedOnTime(String str, String str2, boolean z16);

    List<BusinessFeedData> getCurrentDatas();

    int getFeedCount();

    k getFeedTimeInfo();

    long getOwnerUin();

    long getUin();

    boolean hasMore();

    void init(e.a aVar, b bVar, a aVar2);

    void onDataChange();

    void preDownloadFeedsPassiveCustomTrack(int i3, int i16);

    void preDownloadFeedsPernalizeDiamondImage(int i3, int i16);

    void preDownloadFeedsPernalizePassivePraise(int i3, int i16);

    void requestFeedDatas(int i3, t tVar, boolean z16);

    void sendInitDataMessage();

    void setSupportIncrementUpdate(boolean z16);

    void setSupportPiece(boolean z16);

    void setUin(long j3, long j16, boolean z16, boolean z17);

    void updateData(BusinessFeedData businessFeedData, boolean z16);
}
