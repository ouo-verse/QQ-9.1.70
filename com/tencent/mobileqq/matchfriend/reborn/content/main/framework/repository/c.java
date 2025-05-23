package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedRecommendRsp;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/c;", "", "", "f", "e", "c", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "b", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "getPreloadSignalInfo", "()Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "setPreloadSignalInfo", "(Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;)V", "preloadSignalInfo", "", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "Ljava/util/List;", "()Ljava/util/List;", "g", "(Ljava/util/List;)V", "preloadFeedList", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f244287a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static SignalPlazaSvrPB$SignalInfo preloadSignalInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static List<FeedPB$Feed> preloadFeedList;

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        c cVar = f244287a;
        cVar.f();
        cVar.e();
    }

    private final void e() {
        PBRepeatMessageField<FeedPB$Feed> pBRepeatMessageField;
        FeedPlazaSvrPB$FeedRecommendRsp c16 = new QQStrangerSquareCacheHelper().c();
        preloadFeedList = (c16 == null || (pBRepeatMessageField = c16.content_feeds) == null) ? null : pBRepeatMessageField.get();
        QLog.d("QQStrangerSquarePreloader", 1, "preload feed");
    }

    private final void f() {
        preloadSignalInfo = com.tencent.mobileqq.matchfriend.reborn.content.signal.b.f244871a.b();
        QLog.d("QQStrangerSquarePreloader", 1, "preload signal");
    }

    public final List<FeedPB$Feed> b() {
        return preloadFeedList;
    }

    public final void g(List<FeedPB$Feed> list) {
        preloadFeedList = list;
    }

    public final void c() {
        preloadSignalInfo = null;
        preloadFeedList = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d();
            }
        }, 64, null, true);
    }
}
