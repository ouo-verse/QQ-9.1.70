package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerCommonProxyRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedRecommendReq;
import com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedRecommendRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyReq;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$DeleteFeedReq;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$DeleteFeedRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$DoLikeReq;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$DoLikeRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u000269B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!JA\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u000bJ\u0016\u0010)\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u000eJ)\u00100\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00192\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b3\u00104R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010E\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/a;", "p", "", "extData", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/feed_plaza_svr/feed_plaza_svr/FeedPlazaSvrPB$FeedRecommendRsp;", "v", HippyTKDListViewAdapter.X, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feedId", "", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msg", "feeds", "", ReportConstant.COSTREPORT_PREFIX, "r", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, h.F, "feed", "", "operationType", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$DoLikeRsp;", "l", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$CommentAndReplyRsp;", "i", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openId", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "index", "g", "u", "newFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "isLike", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "commentCount", "y", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "a", "Ljava/util/List;", "feedList", "b", "Ljava/lang/String;", "lastExtData", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerSquareCacheHelper;", "c", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerSquareCacheHelper;", "cacheHelper", "Ljava/util/concurrent/locks/ReentrantLock;", "d", "o", "()Ljava/util/concurrent/locks/ReentrantLock;", "feedListLock", "<init>", "()V", "e", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerFeedRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<FeedPB$Feed> feedList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String lastExtData = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy feedListLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository$b;", "T", "", "", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ZLjava/lang/Object;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final T data;

        public b(boolean z16, T t16) {
            this.isSuccess = z16;
            this.data = t16;
        }

        public final T a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public /* synthetic */ b(boolean z16, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? null : obj);
        }
    }

    public QQStrangerFeedRepository() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSquareCacheHelper>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$cacheHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSquareCacheHelper invoke() {
                return new QQStrangerSquareCacheHelper();
            }
        });
        this.cacheHelper = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$feedListLock$2
            @Override // kotlin.jvm.functions.Function0
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        this.feedListLock = lazy2;
    }

    private final List<FeedPB$Feed> m(String feedId) {
        ReentrantLock o16 = o();
        o16.lock();
        try {
            ArrayList arrayList = new ArrayList();
            int size = this.feedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                FeedPB$Feed feedPB$Feed = this.feedList.get(i3);
                if (Intrinsics.areEqual(u72.a.b(feedPB$Feed), feedId)) {
                    try {
                        FeedPB$Feed feedPB$Feed2 = new FeedPB$Feed();
                        feedPB$Feed2.mergeFrom(feedPB$Feed.toByteArray());
                        this.feedList.set(i3, feedPB$Feed2);
                        arrayList.add(feedPB$Feed2);
                    } catch (Exception e16) {
                        QLog.e("QQStrangerFeedRepository", 1, "filterAndCopy error ", e16);
                    }
                }
            }
            return arrayList;
        } finally {
            o16.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSquareCacheHelper n() {
        return (QQStrangerSquareCacheHelper) this.cacheHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReentrantLock o() {
        return (ReentrantLock) this.feedListLock.getValue();
    }

    private final Flow<QQStrangerFeedResult> p() {
        return FlowKt.flow(new QQStrangerFeedRepository$loadCacheFeedFlow$1(this, null));
    }

    private final Flow<b<FeedPlazaSvrPB$FeedRecommendRsp>> v(String extData) {
        return FlowKt.flow(new QQStrangerFeedRepository$requestFeedsFlow$1(this, extData, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final Object x(String str, Continuation<? super b<FeedPlazaSvrPB$FeedRecommendRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        boolean z16 = false;
        boolean z17 = false;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerFeedRepository", 1, "[RecommendFeed] network is not available");
            cancellableContinuationImpl.resume(new b(false, z17 ? 1 : 0, 2, z16 ? 1 : 0), null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            com.tencent.relation.common.servlet.a businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
            com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? businessHandler : null;
            QLog.d("QQStrangerFeedRepository", 1, "[RecommendFeed] request ext_data=" + str);
            if (aVar != null) {
                FeedPlazaSvrPB$FeedRecommendReq feedPlazaSvrPB$FeedRecommendReq = new FeedPlazaSvrPB$FeedRecommendReq();
                feedPlazaSvrPB$FeedRecommendReq.req_count.set(12);
                feedPlazaSvrPB$FeedRecommendReq.feed_type.set(1);
                feedPlazaSvrPB$FeedRecommendReq.ext_data.set(str);
                Unit unit = Unit.INSTANCE;
                aVar.Z0("QQStranger.FeedPlazaSvr.SsoFeedRecommend", feedPlazaSvrPB$FeedRecommendReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$requestRecommendFeed$2$2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i3, boolean z18, Object obj) {
                        if (z18 && (obj instanceof byte[])) {
                            FeedPlazaSvrPB$FeedRecommendRsp feedPlazaSvrPB$FeedRecommendRsp = new FeedPlazaSvrPB$FeedRecommendRsp();
                            try {
                                feedPlazaSvrPB$FeedRecommendRsp.mergeFrom((byte[]) obj);
                            } catch (Exception e16) {
                                QLog.e("QQStrangerFeedRepository", 1, "[RecommendFeed] mergeFrom error ", e16);
                            }
                            QLog.d("QQStrangerFeedRepository", 1, "[RecommendFeed] response ret_code=" + feedPlazaSvrPB$FeedRecommendRsp.ret_code.get() + " err_msg=" + feedPlazaSvrPB$FeedRecommendRsp.err_msg.get() + " flag_end=" + feedPlazaSvrPB$FeedRecommendRsp.flag_end.get() + " ext_data=" + feedPlazaSvrPB$FeedRecommendRsp.ext_data.get());
                            QQStrangerFeedRepository.this.s("[RecommendFeed]", feedPlazaSvrPB$FeedRecommendRsp.content_feeds.get());
                            if (feedPlazaSvrPB$FeedRecommendRsp.ret_code.get() == 0) {
                                QQStrangerFeedRepository qQStrangerFeedRepository = QQStrangerFeedRepository.this;
                                String str2 = feedPlazaSvrPB$FeedRecommendRsp.ext_data.get();
                                Intrinsics.checkNotNullExpressionValue(str2, "rsp.ext_data.get()");
                                qQStrangerFeedRepository.lastExtData = str2;
                            }
                            cancellableContinuationImpl.resume(new QQStrangerFeedRepository.b<>(feedPlazaSvrPB$FeedRecommendRsp.ret_code.get() == 0, feedPlazaSvrPB$FeedRecommendRsp), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$requestRecommendFeed$2$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerFeedRepository", 1, "[RecommendFeed] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.d("QQStrangerFeedRepository", 1, "[RecommendFeed] response isSuccess=" + z18 + " data=" + obj);
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        cancellableContinuationImpl.resume(new QQStrangerFeedRepository.b<>(r8, defaultConstructorMarker, 2, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$requestRecommendFeed$2$2.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerFeedRepository", 1, "[RecommendFeed] resume exception: ", it);
                            }
                        });
                    }
                });
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void A(String feedId, Integer likeCount, Boolean isLike) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        for (FeedPB$Feed feedPB$Feed : m(feedId)) {
            if (likeCount != null) {
                feedPB$Feed.like_info.count.set(likeCount.intValue());
            }
            if (isLike != null) {
                feedPB$Feed.like_info.my_like.set(isLike.booleanValue() ? 1 : 0);
            }
        }
    }

    public final void g(int index, FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        ReentrantLock o16 = o();
        o16.lock();
        try {
            this.feedList.add(index, feed);
            Unit unit = Unit.INSTANCE;
        } finally {
            o16.unlock();
        }
    }

    public final List<FeedPB$Feed> h() {
        ReentrantLock o16 = o();
        o16.lock();
        try {
            return new ArrayList(this.feedList);
        } finally {
            o16.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(String str, String str2, Continuation<? super b<FeedPB$CommentAndReplyRsp>> continuation) {
        QQStrangerFeedRepository$doCommentFeed$1 qQStrangerFeedRepository$doCommentFeed$1;
        Object coroutine_suspended;
        int i3;
        CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp;
        if (continuation instanceof QQStrangerFeedRepository$doCommentFeed$1) {
            qQStrangerFeedRepository$doCommentFeed$1 = (QQStrangerFeedRepository$doCommentFeed$1) continuation;
            int i16 = qQStrangerFeedRepository$doCommentFeed$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQStrangerFeedRepository$doCommentFeed$1.label = i16 - Integer.MIN_VALUE;
                QQStrangerFeedRepository$doCommentFeed$1 qQStrangerFeedRepository$doCommentFeed$12 = qQStrangerFeedRepository$doCommentFeed$1;
                Object obj = qQStrangerFeedRepository$doCommentFeed$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQStrangerFeedRepository$doCommentFeed$12.label;
                int i17 = 2;
                boolean z16 = false;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerFeedRepository", 1, "[doCommentFeed] request: feedId=" + str + " content=" + str2);
                    QQStrangerCommonProxyRequest qQStrangerCommonProxyRequest = QQStrangerCommonProxyRequest.f245454a;
                    FeedPB$CommentAndReplyReq feedPB$CommentAndReplyReq = new FeedPB$CommentAndReplyReq();
                    feedPB$CommentAndReplyReq.feed_id.set(str);
                    feedPB$CommentAndReplyReq.content.setHasFlag(true);
                    feedPB$CommentAndReplyReq.content.text.set(str2);
                    feedPB$CommentAndReplyReq.visible_to_public.set(true);
                    feedPB$CommentAndReplyReq.is_recommend_comment.set(false);
                    feedPB$CommentAndReplyReq.source.set(2);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = feedPB$CommentAndReplyReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "CommentAndReplyReq().als\u2026          }.toByteArray()");
                    qQStrangerFeedRepository$doCommentFeed$12.label = 1;
                    obj = qQStrangerCommonProxyRequest.a(1, "QQStranger.FeedSvr", "Comment", byteArray, qQStrangerFeedRepository$doCommentFeed$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj;
                DefaultConstructorMarker defaultConstructorMarker = null;
                if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
                    FeedPB$CommentAndReplyRsp feedPB$CommentAndReplyRsp = new FeedPB$CommentAndReplyRsp();
                    try {
                        feedPB$CommentAndReplyRsp.mergeFrom(commonProxyPB$ProxyRsp.biz_buf.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.e("QQStrangerFeedRepository", 1, "[doCommentFeed] mergeFrom error ", e16);
                    }
                    QLog.d("QQStrangerFeedRepository", 1, "[doCommentFeed] response: ret_code=" + feedPB$CommentAndReplyRsp.ret_code.get() + " msg=" + feedPB$CommentAndReplyRsp.f381603msg.get());
                    return new b(true, feedPB$CommentAndReplyRsp);
                }
                return new b(z16, defaultConstructorMarker, i17, defaultConstructorMarker);
            }
        }
        qQStrangerFeedRepository$doCommentFeed$1 = new QQStrangerFeedRepository$doCommentFeed$1(this, continuation);
        QQStrangerFeedRepository$doCommentFeed$1 qQStrangerFeedRepository$doCommentFeed$122 = qQStrangerFeedRepository$doCommentFeed$1;
        Object obj2 = qQStrangerFeedRepository$doCommentFeed$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQStrangerFeedRepository$doCommentFeed$122.label;
        int i172 = 2;
        boolean z162 = false;
        if (i3 != 0) {
        }
        commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(String str, Continuation<? super Integer> continuation) {
        QQStrangerFeedRepository$doDeleteFeed$1 qQStrangerFeedRepository$doDeleteFeed$1;
        Object coroutine_suspended;
        int i3;
        CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp;
        int i16;
        if (continuation instanceof QQStrangerFeedRepository$doDeleteFeed$1) {
            qQStrangerFeedRepository$doDeleteFeed$1 = (QQStrangerFeedRepository$doDeleteFeed$1) continuation;
            int i17 = qQStrangerFeedRepository$doDeleteFeed$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerFeedRepository$doDeleteFeed$1.label = i17 - Integer.MIN_VALUE;
                QQStrangerFeedRepository$doDeleteFeed$1 qQStrangerFeedRepository$doDeleteFeed$12 = qQStrangerFeedRepository$doDeleteFeed$1;
                Object obj = qQStrangerFeedRepository$doDeleteFeed$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQStrangerFeedRepository$doDeleteFeed$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerFeedRepository", 1, "[doDeleteFeed] request: feedId=" + str);
                    QQStrangerCommonProxyRequest qQStrangerCommonProxyRequest = QQStrangerCommonProxyRequest.f245454a;
                    FeedPB$DeleteFeedReq feedPB$DeleteFeedReq = new FeedPB$DeleteFeedReq();
                    feedPB$DeleteFeedReq.feed_id.set(str);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = feedPB$DeleteFeedReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "DeleteFeedReq().also {\n \u2026          }.toByteArray()");
                    qQStrangerFeedRepository$doDeleteFeed$12.label = 1;
                    obj = qQStrangerCommonProxyRequest.a(1, "QQStranger.FeedSvr", "DeleteFeed", byteArray, qQStrangerFeedRepository$doDeleteFeed$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj;
                if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
                    FeedPB$DeleteFeedRsp feedPB$DeleteFeedRsp = new FeedPB$DeleteFeedRsp();
                    try {
                        feedPB$DeleteFeedRsp.mergeFrom(commonProxyPB$ProxyRsp.biz_buf.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.e("QQStrangerFeedRepository", 1, "[doDeleteFeed] mergeFrom error ", e16);
                    }
                    QLog.d("QQStrangerFeedRepository", 1, "[doDeleteFeed] response: ret_code=" + feedPB$DeleteFeedRsp.ret_code.get() + " msg=" + feedPB$DeleteFeedRsp.f381605msg.get());
                    i16 = feedPB$DeleteFeedRsp.ret_code.get();
                } else {
                    i16 = -1;
                }
                return Boxing.boxInt(i16);
            }
        }
        qQStrangerFeedRepository$doDeleteFeed$1 = new QQStrangerFeedRepository$doDeleteFeed$1(this, continuation);
        QQStrangerFeedRepository$doDeleteFeed$1 qQStrangerFeedRepository$doDeleteFeed$122 = qQStrangerFeedRepository$doDeleteFeed$1;
        Object obj2 = qQStrangerFeedRepository$doDeleteFeed$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQStrangerFeedRepository$doDeleteFeed$122.label;
        if (i3 != 0) {
        }
        commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj2;
        if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
        }
        return Boxing.boxInt(i16);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(FeedPB$Feed feedPB$Feed, int i3, Continuation<? super b<FeedPB$DoLikeRsp>> continuation) {
        QQStrangerFeedRepository$doLikeFeed$1 qQStrangerFeedRepository$doLikeFeed$1;
        Object coroutine_suspended;
        int i16;
        CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp;
        if (continuation instanceof QQStrangerFeedRepository$doLikeFeed$1) {
            qQStrangerFeedRepository$doLikeFeed$1 = (QQStrangerFeedRepository$doLikeFeed$1) continuation;
            int i17 = qQStrangerFeedRepository$doLikeFeed$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerFeedRepository$doLikeFeed$1.label = i17 - Integer.MIN_VALUE;
                QQStrangerFeedRepository$doLikeFeed$1 qQStrangerFeedRepository$doLikeFeed$12 = qQStrangerFeedRepository$doLikeFeed$1;
                Object obj = qQStrangerFeedRepository$doLikeFeed$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = qQStrangerFeedRepository$doLikeFeed$12.label;
                boolean z16 = false;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerFeedRepository", 1, "[doLikeFeed] request: feedId=" + u72.a.b(feedPB$Feed) + " openId=" + u72.a.g(feedPB$Feed) + " operationType=" + i3);
                    QQStrangerCommonProxyRequest qQStrangerCommonProxyRequest = QQStrangerCommonProxyRequest.f245454a;
                    FeedPB$DoLikeReq feedPB$DoLikeReq = new FeedPB$DoLikeReq();
                    feedPB$DoLikeReq.oper_type.set(i3);
                    feedPB$DoLikeReq.feed_id.set(u72.a.b(feedPB$Feed));
                    feedPB$DoLikeReq.poster_tid.set(u72.a.g(feedPB$Feed));
                    feedPB$DoLikeReq.account_type.set(0);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = feedPB$DoLikeReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "DoLikeReq().also {\n     \u2026          }.toByteArray()");
                    qQStrangerFeedRepository$doLikeFeed$12.label = 1;
                    obj = qQStrangerCommonProxyRequest.a(1, "QQStranger.FeedSvr", "SsoDoLike", byteArray, qQStrangerFeedRepository$doLikeFeed$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj;
                DefaultConstructorMarker defaultConstructorMarker = null;
                if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
                    FeedPB$DoLikeRsp feedPB$DoLikeRsp = new FeedPB$DoLikeRsp();
                    try {
                        feedPB$DoLikeRsp.mergeFrom(commonProxyPB$ProxyRsp.biz_buf.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.e("QQStrangerFeedRepository", 1, "[doLikeFeed] mergeFrom error ", e16);
                    }
                    QLog.d("QQStrangerFeedRepository", 1, "[doLikeFeed] response: ret_code=" + feedPB$DoLikeRsp.ret_code.get() + " msg=" + feedPB$DoLikeRsp.f381606msg.get());
                    return new b(true, feedPB$DoLikeRsp);
                }
                return new b(z16, defaultConstructorMarker, 2, defaultConstructorMarker);
            }
        }
        qQStrangerFeedRepository$doLikeFeed$1 = new QQStrangerFeedRepository$doLikeFeed$1(this, continuation);
        QQStrangerFeedRepository$doLikeFeed$1 qQStrangerFeedRepository$doLikeFeed$122 = qQStrangerFeedRepository$doLikeFeed$1;
        Object obj2 = qQStrangerFeedRepository$doLikeFeed$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qQStrangerFeedRepository$doLikeFeed$122.label;
        boolean z162 = false;
        if (i16 != 0) {
        }
        commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
        }
    }

    public final List<FeedPB$Feed> r() {
        c cVar = c.f244287a;
        List<FeedPB$Feed> b16 = cVar.b();
        if (b16 != null) {
            cVar.g(null);
            if (!b16.isEmpty()) {
                s("[loadPreloadFeeds]", b16);
                ReentrantLock o16 = o();
                o16.lock();
                try {
                    this.feedList.clear();
                    this.feedList.addAll(b16);
                    o16.unlock();
                    return h();
                } catch (Throwable th5) {
                    o16.unlock();
                    throw th5;
                }
            }
        }
        return null;
    }

    public final Flow<QQStrangerFeedResult> t() {
        final Flow<b<FeedPlazaSvrPB$FeedRecommendRsp>> v3 = v("");
        Flow<QQStrangerFeedResult> flow = new Flow<QQStrangerFeedResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$refreshFeeds$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$refreshFeeds$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244273d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerFeedRepository f244274e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$refreshFeeds$$inlined$map$1$2", f = "QQStrangerFeedRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$refreshFeeds$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerFeedRepository qQStrangerFeedRepository) {
                    this.f244273d = flowCollector;
                    this.f244274e = qQStrangerFeedRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerFeedResult qQStrangerFeedResult;
                    QQStrangerSquareCacheHelper n3;
                    ReentrantLock o16;
                    List list;
                    List list2;
                    List list3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244273d;
                                QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp> bVar2 = bVar;
                                if (bVar2.getIsSuccess() && bVar2.a() != null) {
                                    n3 = this.f244274e.n();
                                    n3.e(bVar2.a());
                                    o16 = this.f244274e.o();
                                    o16.lock();
                                    try {
                                        list = this.f244274e.feedList;
                                        list.clear();
                                        List<FeedPB$Feed> it = bVar2.a().content_feeds.get();
                                        list2 = this.f244274e.feedList;
                                        Intrinsics.checkNotNullExpressionValue(it, "it");
                                        list2.addAll(it);
                                        o16.unlock();
                                        boolean z16 = bVar2.a().flag_end.get() == 1;
                                        list3 = this.f244274e.feedList;
                                        QLog.d("QQStrangerFeedRepository", 1, "[refreshFeeds] feedListSize=" + list3.size() + " noMore=" + z16);
                                        qQStrangerFeedResult = new QQStrangerFeedResult(true, false, this.f244274e.h(), z16, 2, null);
                                    } catch (Throwable th5) {
                                        o16.unlock();
                                        throw th5;
                                    }
                                } else {
                                    qQStrangerFeedResult = new QQStrangerFeedResult(false, false, this.f244274e.h(), false, 10, null);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerFeedResult, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerFeedResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        };
        return this.feedList.isEmpty() ? FlowKt.flattenConcat(FlowKt.flowOf((Object[]) new Flow[]{p(), flow})) : flow;
    }

    public final void u(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        ReentrantLock o16 = o();
        o16.lock();
        try {
            Iterator<FeedPB$Feed> it = this.feedList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(u72.a.b(it.next()), feedId)) {
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            o16.unlock();
        }
    }

    public final void y(String feedId, Integer commentCount) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        for (FeedPB$Feed feedPB$Feed : m(feedId)) {
            if (commentCount != null) {
                feedPB$Feed.comment_count.set(commentCount.intValue());
            }
        }
    }

    public final void z(FeedPB$Feed newFeed) {
        Intrinsics.checkNotNullParameter(newFeed, "newFeed");
        ReentrantLock o16 = o();
        o16.lock();
        try {
            int i3 = 0;
            for (FeedPB$Feed feedPB$Feed : this.feedList) {
                int i16 = i3 + 1;
                if (Intrinsics.areEqual(u72.a.b(feedPB$Feed), u72.a.b(newFeed))) {
                    this.feedList.set(i3, newFeed);
                    QLog.d("QQStrangerFeedRepository", 1, "updateFeed feedId=" + u72.a.b(feedPB$Feed));
                    return;
                }
                i3 = i16;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            o16.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String msg2, List<FeedPB$Feed> feeds) {
        int collectionSizeOrDefault;
        List chunked;
        int size = feeds != null ? feeds.size() : 0;
        if (feeds != null) {
            List<FeedPB$Feed> list = feeds;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(u72.a.b((FeedPB$Feed) it.next()));
            }
            chunked = CollectionsKt___CollectionsKt.chunked(arrayList, 10);
            if (chunked != null) {
                Iterator it5 = chunked.iterator();
                while (it5.hasNext()) {
                    QLog.d("QQStrangerFeedRepository", 1, msg2 + " size:" + size + " feeds:" + ((List) it5.next()));
                }
            }
        }
    }

    public final Flow<QQStrangerFeedResult> q() {
        final Flow w3 = w(this, null, 1, null);
        return new Flow<QQStrangerFeedResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$loadMoreFeeds$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$loadMoreFeeds$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244269d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerFeedRepository f244270e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$loadMoreFeeds$$inlined$map$1$2", f = "QQStrangerFeedRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$loadMoreFeeds$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerFeedRepository qQStrangerFeedRepository) {
                    this.f244269d = flowCollector;
                    this.f244270e = qQStrangerFeedRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x007c A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:29:0x006b, B:31:0x0070, B:36:0x007c, B:37:0x0088), top: B:28:0x006b }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00cf A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    ReentrantLock o16;
                    boolean z16;
                    QQStrangerFeedResult qQStrangerFeedResult;
                    List list;
                    PBUInt32Field pBUInt32Field;
                    PBRepeatMessageField<FeedPB$Feed> pBRepeatMessageField;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244269d;
                                QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp> bVar2 = bVar;
                                FeedPlazaSvrPB$FeedRecommendRsp a16 = bVar2.a();
                                List<FeedPB$Feed> list2 = (a16 == null || (pBRepeatMessageField = a16.content_feeds) == null) ? null : pBRepeatMessageField.get();
                                FeedPlazaSvrPB$FeedRecommendRsp a17 = bVar2.a();
                                boolean z17 = (a17 == null || (pBUInt32Field = a17.flag_end) == null || pBUInt32Field.get() != 1) ? false : true;
                                o16 = this.f244270e.o();
                                o16.lock();
                                try {
                                    List<FeedPB$Feed> list3 = list2;
                                    if (list3 != null && !list3.isEmpty()) {
                                        z16 = false;
                                        if (!z16) {
                                            list = this.f244270e.feedList;
                                            list.addAll(list2);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        QLog.d("QQStrangerFeedRepository", 1, "[loadMoreFeeds] feedListSize=" + (list2 != null ? list2.size() : 0) + " noMore=" + z17);
                                        qQStrangerFeedResult = new QQStrangerFeedResult(bVar2.getIsSuccess(), false, this.f244270e.h(), z17, 2, null);
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(qQStrangerFeedResult, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    z16 = true;
                                    if (!z16) {
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                    if (list2 != null) {
                                    }
                                    QLog.d("QQStrangerFeedRepository", 1, "[loadMoreFeeds] feedListSize=" + (list2 != null ? list2.size() : 0) + " noMore=" + z17);
                                    qQStrangerFeedResult = new QQStrangerFeedResult(bVar2.getIsSuccess(), false, this.f244270e.h(), z17, 2, null);
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(qQStrangerFeedResult, anonymousClass1) == coroutine_suspended) {
                                    }
                                } finally {
                                    o16.unlock();
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerFeedResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        };
    }

    static /* synthetic */ Flow w(QQStrangerFeedRepository qQStrangerFeedRepository, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qQStrangerFeedRepository.lastExtData;
        }
        return qQStrangerFeedRepository.v(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(String str, String str2, String str3, String str4, String str5, Continuation<? super b<FeedPB$CommentAndReplyRsp>> continuation) {
        QQStrangerFeedRepository$doFeedCommentReply$1 qQStrangerFeedRepository$doFeedCommentReply$1;
        Object coroutine_suspended;
        int i3;
        CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp;
        if (continuation instanceof QQStrangerFeedRepository$doFeedCommentReply$1) {
            qQStrangerFeedRepository$doFeedCommentReply$1 = (QQStrangerFeedRepository$doFeedCommentReply$1) continuation;
            int i16 = qQStrangerFeedRepository$doFeedCommentReply$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQStrangerFeedRepository$doFeedCommentReply$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qQStrangerFeedRepository$doFeedCommentReply$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQStrangerFeedRepository$doFeedCommentReply$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerFeedRepository", 1, "[doFeedCommentReply] request: openId=" + str + ", feedId=" + str2 + ", commentId=" + str3 + ", replyId=" + str4 + ", content=" + str5);
                    QQStrangerCommonProxyRequest qQStrangerCommonProxyRequest = QQStrangerCommonProxyRequest.f245454a;
                    FeedPB$CommentAndReplyReq feedPB$CommentAndReplyReq = new FeedPB$CommentAndReplyReq();
                    feedPB$CommentAndReplyReq.target_tid.set(str);
                    feedPB$CommentAndReplyReq.feed_id.set(str2);
                    feedPB$CommentAndReplyReq.comment_id.set(str3);
                    feedPB$CommentAndReplyReq.reply_id.set(str4);
                    feedPB$CommentAndReplyReq.content.setHasFlag(true);
                    feedPB$CommentAndReplyReq.content.text.set(str5);
                    feedPB$CommentAndReplyReq.visible_to_public.set(true);
                    feedPB$CommentAndReplyReq.is_recommend_comment.set(false);
                    feedPB$CommentAndReplyReq.source.set(3);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = feedPB$CommentAndReplyReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "CommentAndReplyReq().als\u2026          }.toByteArray()");
                    qQStrangerFeedRepository$doFeedCommentReply$1.label = 1;
                    obj = qQStrangerCommonProxyRequest.a(1, "QQStranger.FeedSvr", "Comment", byteArray, qQStrangerFeedRepository$doFeedCommentReply$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj;
                DefaultConstructorMarker defaultConstructorMarker = null;
                if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
                    FeedPB$CommentAndReplyRsp feedPB$CommentAndReplyRsp = new FeedPB$CommentAndReplyRsp();
                    try {
                        feedPB$CommentAndReplyRsp.mergeFrom(commonProxyPB$ProxyRsp.biz_buf.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.e("QQStrangerFeedRepository", 1, "[doFeedCommentReply] mergeFrom error ", e16);
                    }
                    QLog.d("QQStrangerFeedRepository", 1, "[doFeedCommentReply] response: ret_code=" + feedPB$CommentAndReplyRsp.ret_code.get() + " msg=" + feedPB$CommentAndReplyRsp.f381603msg.get());
                    return new b(feedPB$CommentAndReplyRsp.ret_code.get() == 0, feedPB$CommentAndReplyRsp);
                }
                return new b(r10, defaultConstructorMarker, 2, defaultConstructorMarker);
            }
        }
        qQStrangerFeedRepository$doFeedCommentReply$1 = new QQStrangerFeedRepository$doFeedCommentReply$1(this, continuation);
        Object obj2 = qQStrangerFeedRepository$doFeedCommentReply$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQStrangerFeedRepository$doFeedCommentReply$1.label;
        if (i3 != 0) {
        }
        commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        if ((commonProxyPB$ProxyRsp == null ? commonProxyPB$ProxyRsp.biz_buf : null) == null) {
        }
    }
}
