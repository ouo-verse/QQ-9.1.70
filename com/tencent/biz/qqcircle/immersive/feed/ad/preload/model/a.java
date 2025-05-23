package com.tencent.biz.qqcircle.immersive.feed.ad.preload.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.a;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudAdrepull$GetADRePullRsp;
import feedcloud.FeedCloudMeta$AdvertClientInfo;
import feedcloud.FeedCloudMeta$AdvertItem;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static long f85727d = -10008;

    /* renamed from: a, reason: collision with root package name */
    private final MutableLiveData<C0879a> f85728a = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name */
    private String f85729b = "";

    /* renamed from: c, reason: collision with root package name */
    private b f85730c;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0879a {

        /* renamed from: a, reason: collision with root package name */
        private List<e30.b> f85731a;

        /* renamed from: b, reason: collision with root package name */
        private List<e30.b> f85732b;

        /* renamed from: c, reason: collision with root package name */
        private long f85733c;

        /* renamed from: d, reason: collision with root package name */
        private String f85734d;

        /* renamed from: e, reason: collision with root package name */
        private String f85735e;

        public long a() {
            return this.f85733c;
        }

        public String b() {
            return this.f85734d;
        }

        public List<e30.b> c() {
            return this.f85731a;
        }

        public List<e30.b> d() {
            return this.f85732b;
        }

        public String e() {
            return this.f85735e;
        }

        public C0879a f(long j3) {
            this.f85733c = j3;
            return this;
        }

        public C0879a g(String str) {
            this.f85734d = str;
            return this;
        }

        public C0879a h(List<e30.b> list) {
            this.f85731a = list;
            return this;
        }

        public C0879a i(List<e30.b> list) {
            this.f85732b = list;
            return this;
        }

        public C0879a j(String str) {
            this.f85735e = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f85736a;

        /* renamed from: b, reason: collision with root package name */
        private List<e30.b> f85737b;

        public b(a aVar, List<e30.b> list) {
            this.f85736a = new WeakReference<>(aVar);
            this.f85737b = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(a aVar, FeedCloudAdrepull$GetADRePullRsp feedCloudAdrepull$GetADRePullRsp, long j3, String str, String str2, String str3, List list) {
            PBBytesField pBBytesField;
            if (aVar != null && feedCloudAdrepull$GetADRePullRsp != null && (pBBytesField = feedCloudAdrepull$GetADRePullRsp.client_info) != null) {
                aVar.j(j3, str, str2, str3, this.f85737b, list, pBBytesField.get().toByteArray());
            } else {
                RFWLog.e("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[onReceive] change main thread, param is null.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(final a aVar, final FeedCloudAdrepull$GetADRePullRsp feedCloudAdrepull$GetADRePullRsp, final long j3, final String str, final String str2, final String str3) {
            PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
            if (aVar != null && feedCloudAdrepull$GetADRePullRsp != null && (pBRepeatMessageField = feedCloudAdrepull$GetADRePullRsp.feeds) != null) {
                final List f16 = aVar.f(pBRepeatMessageField.get());
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.b.this.c(aVar, feedCloudAdrepull$GetADRePullRsp, j3, str, str2, str3, f16);
                    }
                });
            } else {
                RFWLog.e("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[onReceive] change sub thread, param is null.");
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, final long j3, final String str, Object obj) {
            a aVar;
            final String traceId;
            WeakReference<a> weakReference = this.f85736a;
            if (weakReference == null) {
                aVar = null;
            } else {
                aVar = weakReference.get();
            }
            final a aVar2 = aVar;
            if (aVar2 == null) {
                RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[onReceive] preload model should not be null.");
                return;
            }
            String str2 = "";
            if (baseRequest == null) {
                traceId = "";
            } else {
                traceId = baseRequest.getTraceId();
            }
            if (baseRequest != null) {
                str2 = baseRequest.getCmdName();
            }
            final String str3 = str2;
            if (!z16 || j3 != 0 || !TextUtils.isEmpty(str)) {
                aVar2.i(j3, str, traceId, str3);
            } else {
                if (!(obj instanceof FeedCloudAdrepull$GetADRePullRsp)) {
                    aVar2.i(a.f85727d, "[onReceive] rsp type not is StGetADRepullRsp.", traceId, str3);
                    return;
                }
                final FeedCloudAdrepull$GetADRePullRsp feedCloudAdrepull$GetADRePullRsp = (FeedCloudAdrepull$GetADRePullRsp) obj;
                aVar2.f85729b = feedCloudAdrepull$GetADRePullRsp.attach_info.get();
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.b.this.d(aVar2, feedCloudAdrepull$GetADRePullRsp, j3, str, traceId, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e30.b> f(List<FeedCloudMeta$StFeed> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<FeedCloudMeta$StFeed> it = list.iterator();
            while (it.hasNext()) {
                e30.b bVar = new e30.b(it.next());
                bVar.l(true);
                bVar.p();
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @NonNull
    private static List<FeedCloudMeta$AdvertItem> g(List<e30.b> list) {
        FeedCloudMeta$StFeed g16;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (e30.b bVar : list) {
                if (bVar == null) {
                    g16 = null;
                } else {
                    g16 = bVar.g();
                }
                if (g16 != null) {
                    FeedCloudMeta$AdvertItem feedCloudMeta$AdvertItem = new FeedCloudMeta$AdvertItem();
                    feedCloudMeta$AdvertItem.f398437id.set(new GdtAd(u.e(bVar)).getAId());
                    feedCloudMeta$AdvertItem.feed_id.set(g16.f398449id.get());
                    feedCloudMeta$AdvertItem.transfer.set(g16.recomInfo.clientSealData.get());
                    arrayList.add(feedCloudMeta$AdvertItem);
                }
            }
            return arrayList;
        }
        RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[getReqAdvertItems] source should not be null.");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j3, String str, String str2, String str3) {
        RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[notifyLoadFail] rsp fail, retCode: " + j3 + " | errMsg: " + str + " | traceId: " + str2 + " | cmdName: " + str3);
        C0879a c0879a = new C0879a();
        c0879a.g(str);
        c0879a.f(j3);
        c0879a.j(str2);
        k(c0879a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j3, String str, String str2, String str3, List<e30.b> list, List<e30.b> list2, byte[] bArr) {
        FeedCloudMeta$AdvertClientInfo feedCloudMeta$AdvertClientInfo;
        List<FeedCloudMeta$AdvertItem> list3;
        C0879a c0879a = new C0879a();
        c0879a.f(j3);
        c0879a.g(str);
        c0879a.j(str2);
        int size = RFSafeListUtils.getSize(list2);
        c0879a.i(list2);
        try {
            feedCloudMeta$AdvertClientInfo = new FeedCloudMeta$AdvertClientInfo().mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            RFWLog.e("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[requestSourceResult] client error: ", e16);
            feedCloudMeta$AdvertClientInfo = null;
        }
        if (feedCloudMeta$AdvertClientInfo == null) {
            list3 = new ArrayList<>();
        } else {
            list3 = feedCloudMeta$AdvertClientInfo.items.get();
        }
        int size2 = RFSafeListUtils.getSize(list3);
        int size3 = RFSafeListUtils.getSize(list);
        c0879a.h(list);
        RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[notifyLoadSuccess] preloadSize:" + size + " | originSourceCount: " + size3 + " | advertItemCount: " + size2 + " | attach_info: " + this.f85729b + " | traceId: " + str2 + " | cmdName: " + str3);
        k(c0879a);
    }

    private void k(C0879a c0879a) {
        MutableLiveData<C0879a> h16 = h();
        if (h16 == null) {
            RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[notifyResultChange] live data should not be null.");
        } else {
            h16.postValue(c0879a);
        }
    }

    public MutableLiveData<C0879a> h() {
        return this.f85728a;
    }

    public void l(List<e30.b> list) {
        if (list != null && !list.isEmpty()) {
            List<FeedCloudMeta$AdvertItem> g16 = g(list);
            if (g16 != null && !g16.isEmpty()) {
                this.f85730c = new b(this, list);
                VSNetworkHelper.getInstance().sendRequest(new QFSAdFeedPreloadRequest(g16, this.f85729b), this.f85730c);
                return;
            } else {
                RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[requestSourceResult] advert items should not be null.");
                return;
            }
        }
        RFWLog.d("QASP-QFSAdFeedSourcePreloadModel", RFWLog.USR, "[requestSourceResult] origin source should not be null.");
    }
}
