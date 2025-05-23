package com.qzone.publish.business.publishqueue.intimate;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.n;
import com.qzone.publish.business.model.intimate.IntimateUploadMediaInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadMediaResult;
import com.qzone.publish.business.model.intimate.IntimateUploadTaskBatchInfo;
import com.qzone.reborn.intimate.request.QZoneIntimatePublishRequest;
import com.qzone.reborn.part.publish.fakefeed.QZoneGetFakeFeedFeature;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;
import qzone.QZIntimateSpaceWriter$StPublishFeedRsp;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StFeedCellCommon;
import qzone.QZoneBaseMeta$StMedia;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002J\u001b\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u001a\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/qzone/publish/business/publishqueue/intimate/PublishFeedUtil;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/qzone/publish/business/publishqueue/intimate/PublishFeedUtil$a;", "publishFeedRsp", "Lqzone/QZIntimateSpaceReader$GetFeedDetailRsp;", "g", "(Lcom/qzone/publish/business/publishqueue/intimate/PublishFeedUtil$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskBatchInfo;", "batchInfo", "", "maxPickCount", "lastPickIndex", "", "Lqzone/QZoneBaseMeta$StMedia;", "j", "Lqzone/QZoneBaseMeta$StFeed;", "stFeed", tl.h.F, "(Lqzone/QZoneBaseMeta$StFeed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lqzone/QZoneBaseCommon$StCommonExt;", "e", "", "f", "Lcom/qzone/publish/business/publishqueue/intimate/c;", "i", "()Lcom/qzone/publish/business/publishqueue/intimate/c;", "batchUtil", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class PublishFeedUtil implements CoroutineScope {

    /* renamed from: e, reason: collision with root package name */
    public static final PublishFeedUtil f51147e = new PublishFeedUtil();

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f51148d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(QZoneCoroutineScopes.f51155a.a()));

    PublishFeedUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QZoneBaseCommon$StCommonExt e() {
        return new QZoneBaseCommon$StCommonExt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(PublishResponse publishResponse, Continuation<? super QZIntimateSpaceReader$GetFeedDetailRsp> continuation) {
        return new QZoneGetFakeFeedFeature().k(publishResponse.getFeedId(), publishResponse.getCreateTime(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed, Continuation<? super PublishResponse> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        RFWLog.i("PublishFeedUtil", RFWLog.USR, "doPublishFeed, size:" + qZoneBaseMeta$StFeed.cell_media.media_items.size());
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimatePublishRequest(qZoneBaseMeta$StFeed, 0, false, f51147e.e(), 4, null), new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c i() {
        d dVar = d.f51164a;
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        return dVar.a(uid);
    }

    private final List<QZoneBaseMeta$StMedia> j(IntimateUploadTaskBatchInfo batchInfo, int maxPickCount, int lastPickIndex) {
        int collectionSizeOrDefault;
        QZoneBaseMeta$StMedia stMedia;
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<IntimateUploadMediaInfo> localMediaList = batchInfo.getUploadParams().getLocalMediaList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(localMediaList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = localMediaList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((IntimateUploadMediaInfo) it.next()).getOriginalPath());
        }
        int i3 = 0;
        for (Object obj : arrayList2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (i3 >= lastPickIndex) {
                break;
            }
            IntimateUploadMediaResult intimateUploadMediaResult = batchInfo.getUploadResultMap().get(str);
            if (intimateUploadMediaResult != null && (stMedia = intimateUploadMediaResult.toStMedia()) != null) {
                arrayList.add(stMedia);
            }
            if (arrayList.size() >= maxPickCount) {
                break;
            }
            i3 = i16;
        }
        return arrayList;
    }

    public final void f(IntimateUploadTaskBatchInfo batchInfo) {
        Intrinsics.checkNotNullParameter(batchInfo, "batchInfo");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new PublishFeedUtil$checkPublishAlbumFeed$1(batchInfo, null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f51148d.getCoroutineContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/publish/business/publishqueue/intimate/PublishFeedUtil$a;", "", "", "c", "", "toString", "", "hashCode", "other", "equals", "a", "Z", "isSuccess", "()Z", "", "b", "J", "getRetCode", "()J", "retCode", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "retMsg", "d", "feedId", "e", WadlProxyConsts.CREATE_TIME, "<init>", "(ZJLjava/lang/String;Ljava/lang/String;J)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.publishqueue.intimate.PublishFeedUtil$a, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class PublishResponse {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long retCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String retMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String feedId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long createTime;

        public PublishResponse(boolean z16, long j3, String retMsg, String feedId, long j16) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.isSuccess = z16;
            this.retCode = j3;
            this.retMsg = retMsg;
            this.feedId = feedId;
            this.createTime = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        public final boolean c() {
            return this.isSuccess && this.retCode == 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((((((r06 * 31) + n.a(this.retCode)) * 31) + this.retMsg.hashCode()) * 31) + this.feedId.hashCode()) * 31) + n.a(this.createTime);
        }

        public String toString() {
            return "PublishResponse(isSuccess=" + this.isSuccess + ", retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PublishResponse)) {
                return false;
            }
            PublishResponse publishResponse = (PublishResponse) other;
            return this.isSuccess == publishResponse.isSuccess && this.retCode == publishResponse.retCode && Intrinsics.areEqual(this.retMsg, publishResponse.retMsg) && Intrinsics.areEqual(this.feedId, publishResponse.feedId) && this.createTime == publishResponse.createTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n\u00a2\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<PublishResponse> f51154a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super PublishResponse> cancellableContinuation) {
            this.f51154a = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String errMsg, Object obj) {
            QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed;
            QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon;
            PBInt64Field pBInt64Field;
            QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed2;
            QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon2;
            PBStringField pBStringField;
            String str = null;
            RFWLog.i("PublishFeedUtil", RFWLog.USR, "doPublishFeed, onReceive, traceId:" + (baseRequest != null ? baseRequest.getTraceId() : null) + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + errMsg);
            QZIntimateSpaceWriter$StPublishFeedRsp qZIntimateSpaceWriter$StPublishFeedRsp = obj instanceof QZIntimateSpaceWriter$StPublishFeedRsp ? (QZIntimateSpaceWriter$StPublishFeedRsp) obj : null;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            if (qZIntimateSpaceWriter$StPublishFeedRsp != null && (qZoneBaseMeta$StFeed2 = qZIntimateSpaceWriter$StPublishFeedRsp.feed) != null && (qZoneBaseMeta$StFeedCellCommon2 = qZoneBaseMeta$StFeed2.cell_common) != null && (pBStringField = qZoneBaseMeta$StFeedCellCommon2.feed_id) != null) {
                str = pBStringField.get();
            }
            PublishResponse publishResponse = new PublishResponse(z16, j3, errMsg, str == null ? "" : str, (qZIntimateSpaceWriter$StPublishFeedRsp == null || (qZoneBaseMeta$StFeed = qZIntimateSpaceWriter$StPublishFeedRsp.feed) == null || (qZoneBaseMeta$StFeedCellCommon = qZoneBaseMeta$StFeed.cell_common) == null || (pBInt64Field = qZoneBaseMeta$StFeedCellCommon.time) == null) ? 0L : pBInt64Field.get());
            if (this.f51154a.isActive()) {
                this.f51154a.resumeWith(Result.m476constructorimpl(publishResponse));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List k(PublishFeedUtil publishFeedUtil, IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 9;
        }
        if ((i17 & 4) != 0) {
            i16 = 9;
        }
        return publishFeedUtil.j(intimateUploadTaskBatchInfo, i3, i16);
    }
}
