package com.tencent.biz.qqcircle.immersive.feed.live.od;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.feed.live.od.QFSODFeedsRequest;
import com.tencent.mobileqq.ilive.pb.LiveRoomList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqlive.api.xsj.IQFSFeedRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSODFeedsRequest {

    /* renamed from: a, reason: collision with root package name */
    private IAegisLogApi f86325a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b, reason: collision with root package name */
    private final long f86326b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudMeta$StFeed f86327c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.live.od.QFSODFeedsRequest$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements IQFSFeedRequest.RequestResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f86328a;

        AnonymousClass1(a aVar) {
            this.f86328a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(byte[] bArr, final a aVar) {
            try {
                LiveRoomList.GetQLiveInfoRsp getQLiveInfoRsp = new LiveRoomList.GetQLiveInfoRsp();
                getQLiveInfoRsp.mergeFrom(bArr);
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed.mergeFrom(getQLiveInfoRsp.feeds.get().toByteArray());
                QFSODFeedsRequest qFSODFeedsRequest = QFSODFeedsRequest.this;
                qFSODFeedsRequest.c(qFSODFeedsRequest.f86327c, feedCloudMeta$StFeed);
                final e30.b bVar = new e30.b(QFSODFeedsRequest.this.f86327c);
                bVar.p();
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.od.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSODFeedsRequest.a.this.a(bVar);
                    }
                });
            } catch (InvalidProtocolBufferMicroException e16) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("QFSODFeedsRequest", "merge exception:" + e16);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.od.QFSODFeedsRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.fail(-1, "\u6570\u636e\u8f6c\u6362\u5f02\u5e38");
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.xsj.IQFSFeedRequest.RequestResultCallback
        public void fail(int i3, String str) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("QFSODFeedsRequest", "error code:" + i3 + " errorMsg:" + str);
            this.f86328a.fail(i3, str);
        }

        @Override // com.tencent.mobileqq.qqlive.api.xsj.IQFSFeedRequest.RequestResultCallback
        public void success(final byte[] bArr) {
            if (bArr.length == 0) {
                this.f86328a.fail(-2, "\u6570\u636e\u4e3a\u7a7a");
                return;
            }
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final a aVar = this.f86328a;
            rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.od.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSODFeedsRequest.AnonymousClass1.this.d(bArr, aVar);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(e30.b bVar);

        void fail(int i3, String str);
    }

    public QFSODFeedsRequest(long j3) {
        this.f86326b = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed2 != null) {
            Map<String, String> f16 = f(feedCloudMeta$StFeed.live.liveExtInfo.get());
            f16.putAll(f(feedCloudMeta$StFeed2.live.liveExtInfo.get()));
            feedCloudMeta$StFeed.live.liveExtInfo.set(g(f16));
            Map<String, ByteStringMicro> e16 = e(feedCloudMeta$StFeed.live.liveBytesExtInfo.get());
            e16.putAll(e(feedCloudMeta$StFeed2.live.liveBytesExtInfo.get()));
            feedCloudMeta$StFeed.live.liveBytesExtInfo.set(d(e16));
            return;
        }
        this.f86325a.w("QFSODFeedsRequest", "merge fail item is null !!oldItem" + feedCloudMeta$StFeed + " newItem:" + feedCloudMeta$StFeed2);
    }

    private List<FeedCloudCommon$BytesEntry> d(Map<String, ByteStringMicro> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ByteStringMicro> entry : map.entrySet()) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set(entry.getKey());
            feedCloudCommon$BytesEntry.value.set(entry.getValue());
            arrayList.add(feedCloudCommon$BytesEntry);
        }
        return arrayList;
    }

    private Map<String, ByteStringMicro> e(List<FeedCloudCommon$BytesEntry> list) {
        HashMap hashMap = new HashMap();
        for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : list) {
            if (!TextUtils.isEmpty(feedCloudCommon$BytesEntry.key.get())) {
                hashMap.put(feedCloudCommon$BytesEntry.key.get(), feedCloudCommon$BytesEntry.value.get());
            }
        }
        return hashMap;
    }

    private Map<String, String> f(List<FeedCloudCommon$Entry> list) {
        HashMap hashMap = new HashMap();
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (!TextUtils.isEmpty(feedCloudCommon$Entry.key.get())) {
                hashMap.put(feedCloudCommon$Entry.key.get(), feedCloudCommon$Entry.value.get());
            }
        }
        return hashMap;
    }

    private List<FeedCloudCommon$Entry> g(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(entry.getKey());
            feedCloudCommon$Entry.value.set(entry.getValue());
            arrayList.add(feedCloudCommon$Entry);
        }
        return arrayList;
    }

    public void h(a aVar) {
        ((IQFSFeedRequest) QRoute.api(IQFSFeedRequest.class)).requestFeed(this.f86326b, new AnonymousClass1(aVar));
    }

    public void i(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f86327c = feedCloudMeta$StFeed;
    }
}
