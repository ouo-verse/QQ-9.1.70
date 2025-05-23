package com.tencent.mobileqq.guild.feed.gallery.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.gallery.b;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetImmersiveFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetImmersiveFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetImmersiveFeedsCallback;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0012\n\u0002\b\u0015\u0018\u0000 O2\u00020\u0001:\u0002PQB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u000fJ\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u0018J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u0018J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020\u001eR\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\"\u0010G\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010B\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/vm/GuildFeedGalleryViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", ICustomDataEditor.NUMBER_PARAM_2, "Lkotlinx/coroutines/Job;", "d2", "e2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "o2", "stFeed", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "t2", "Lcom/tencent/mobileqq/guild/feed/gallery/vm/GuildFeedGalleryViewModel$b;", "i2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "l2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetImmersiveFeedsRsp;", "g2", "", "getLogTag", "p2", FeedManager.LOAD_MORE, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Ljk1/a;", "j", SemanticAttributes.DbSystemValues.H2, "", "k2", "f2", "bean", "r2", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", ICustomDataEditor.STRING_PARAM_2, "feedId", "q2", "j2", "i", "Landroidx/lifecycle/MutableLiveData;", "mFeedsInitData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFeedsData", BdhLogUtil.LogTag.Tag_Conn, "mFeedLoadMoreFinish", "D", "mFeedRecommendLoadState", "E", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "mFeedInitBean", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/Job;", "fetchDataJob", "G", "fetchMoreDataJob", "H", "Ljava/lang/String;", "mSessionId", "", "I", "[B", "loadMoreAttachInfo", "J", "Z", "m2", "()Z", "setNeedLoadRecommend", "(Z)V", "isNeedLoadRecommend", "K", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "perfStageReportTask", "L", "hasLoadMoreReported", "<init>", "()V", "M", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryViewModel extends BaseViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    private GuildFeedGalleryInitBean mFeedInitBean;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Job fetchDataJob;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Job fetchMoreDataJob;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private byte[] loadMoreAttachInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isNeedLoadRecommend;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask perfStageReportTask;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean hasLoadMoreReported;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<jk1.a> mFeedsInitData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<jk1.a>>> mFeedsData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mFeedLoadMoreFinish = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> mFeedRecommendLoadState = new MutableLiveData<>(0);

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mSessionId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/vm/GuildFeedGalleryViewModel$b;", "T", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "", "a", "J", "()J", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "rsp", "<init>", "(JLjava/lang/String;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class SuspendRsp<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final T rsp;

        public SuspendRsp(long j3, @NotNull String msg2, @Nullable T t16) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.code = j3;
            this.msg = msg2;
            this.rsp = t16;
        }

        /* renamed from: a, reason: from getter */
        public final long getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        public final T c() {
            return this.rsp;
        }

        public final boolean d() {
            if (this.code == 0) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuspendRsp)) {
                return false;
            }
            SuspendRsp suspendRsp = (SuspendRsp) other;
            if (this.code == suspendRsp.code && Intrinsics.areEqual(this.msg, suspendRsp.msg) && Intrinsics.areEqual(this.rsp, suspendRsp.rsp)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int a16 = ((androidx.fragment.app.a.a(this.code) * 31) + this.msg.hashCode()) * 31;
            T t16 = this.rsp;
            if (t16 == null) {
                hashCode = 0;
            } else {
                hashCode = t16.hashCode();
            }
            return a16 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SuspendRsp(code=" + this.code + ", msg=" + this.msg + ", rsp=" + this.rsp + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetImmersiveFeedsRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c implements IGProGetImmersiveFeedsCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<SuspendRsp<GProGetImmersiveFeedsRsp>> f219763a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super SuspendRsp<GProGetImmersiveFeedsRsp>> continuation) {
            this.f219763a = continuation;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetImmersiveFeedsCallback
        public final void onResult(int i3, String errMsg, GProGetImmersiveFeedsRsp gProGetImmersiveFeedsRsp) {
            boolean z16;
            Integer num;
            Integer num2;
            Integer num3;
            String str;
            ArrayList<GProStFeed> arrayList;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Logger.a d16 = Logger.f235387a.d();
            if (gProGetImmersiveFeedsRsp != null && (arrayList = gProGetImmersiveFeedsRsp.feeds) != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            if (gProGetImmersiveFeedsRsp != null) {
                num2 = Integer.valueOf(gProGetImmersiveFeedsRsp.isFinish);
            } else {
                num2 = null;
            }
            if (gProGetImmersiveFeedsRsp != null) {
                num3 = Integer.valueOf(gProGetImmersiveFeedsRsp.isRecommendFinish);
            } else {
                num3 = null;
            }
            if (gProGetImmersiveFeedsRsp != null) {
                str = gProGetImmersiveFeedsRsp.sessionId;
            } else {
                str = null;
            }
            d16.d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[fetchImmersiveFeedsData] isSuccess " + z16 + ", retCode " + i3 + ",  | errMsg " + errMsg + ",  | rsp size: " + num + ",  | isFinish: " + num2 + ",  | is_recommend_finish: " + num3 + ",  | sessionId: " + str);
            Continuation<SuspendRsp<GProGetImmersiveFeedsRsp>> continuation = this.f219763a;
            Result.Companion companion = Result.INSTANCE;
            long j3 = (long) i3;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            if (!z16) {
                gProGetImmersiveFeedsRsp = null;
            }
            continuation.resumeWith(Result.m476constructorimpl(new SuspendRsp(j3, errMsg, gProGetImmersiveFeedsRsp)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n\u00a2\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "isDbCache", "", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedDetailRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class d implements IGProGetFeedDetailCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<SuspendRsp<GProStFeed>> f219764a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super SuspendRsp<GProStFeed>> cancellableContinuation) {
            this.f219764a = cancellableContinuation;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
        public final void onResult(int i3, String errMsg, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
            GProStFeed gProStFeed;
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[fetchFeedDetailData] result:" + i3 + " errMsg:" + errMsg + " isDbCache:" + z16);
            if (this.f219764a.isActive()) {
                CancellableContinuation<SuspendRsp<GProStFeed>> cancellableContinuation = this.f219764a;
                Result.Companion companion = Result.INSTANCE;
                long j3 = i3;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                if (gProStGetFeedDetailRsp != null) {
                    gProStFeed = gProStGetFeedDetailRsp.feed;
                } else {
                    gProStFeed = null;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new SuspendRsp(j3, errMsg, gProStFeed)));
            }
        }
    }

    private final Job d2() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildFeedGalleryViewModel$fetchInitStFeedData$1(this, null), 3, null);
        return launch$default;
    }

    private final Job e2() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildFeedGalleryViewModel$fetchMoreData$1(this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
    
        if (r7 != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g2(Continuation<? super SuspendRsp<GProGetImmersiveFeedsRsp>> continuation) {
        Continuation intercepted;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        Object coroutine_suspended;
        boolean z16;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        GProGetImmersiveFeedsReq gProGetImmersiveFeedsReq = new GProGetImmersiveFeedsReq();
        gProGetImmersiveFeedsReq.from = l2();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mFeedInitBean;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = null;
        if (guildFeedGalleryInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean = null;
        }
        String guildId = guildFeedGalleryInitBean.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "mFeedInitBean.guildId");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        gProGetImmersiveFeedsReq.guildId = j3;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean3 = null;
        }
        String channelId = guildFeedGalleryInitBean3.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "mFeedInitBean.channelId");
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(channelId);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        gProGetImmersiveFeedsReq.channelId = j16;
        gProGetImmersiveFeedsReq.count = 12;
        byte[] bArr = this.loadMoreAttachInfo;
        boolean z17 = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        gProGetImmersiveFeedsReq.attachInfo = bArr;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean4 = null;
        }
        String feedId = guildFeedGalleryInitBean4.getFeedId();
        if (feedId != null) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.mFeedInitBean;
            if (guildFeedGalleryInitBean5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
                guildFeedGalleryInitBean5 = null;
            }
            GuildFeedPublishInfo guildFeedPublishInfo = guildFeedGalleryInitBean5.getGuildFeedPublishInfo();
            if (guildFeedPublishInfo != null && guildFeedPublishInfo.isLocalFeed()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = true;
        if (Boxing.boxBoolean(z17).booleanValue()) {
            feedId = null;
        }
        if (feedId == null) {
            feedId = "";
        }
        gProGetImmersiveFeedsReq.feedId = feedId;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean6 = null;
        }
        gProGetImmersiveFeedsReq.topicId = guildFeedGalleryInitBean6.getTopicId();
        gProGetImmersiveFeedsReq.sessionId = this.mSessionId;
        Logger.a d16 = Logger.f235387a.d();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean7 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean7 = null;
        }
        int immersiveSource = guildFeedGalleryInitBean7.getImmersiveSource();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean8 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean8 = null;
        }
        String guildId2 = guildFeedGalleryInitBean8.getGuildId();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean9 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean9 = null;
        }
        String channelId2 = guildFeedGalleryInitBean9.getChannelId();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean10 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
        } else {
            guildFeedGalleryInitBean2 = guildFeedGalleryInitBean10;
        }
        d16.d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[getImmersiveFeedsRsp] from " + immersiveSource + ", guildId: " + guildId2 + ", channelId: " + channelId2 + "topicId: " + guildFeedGalleryInitBean2.getTopicId() + "sessionId: " + gProGetImmersiveFeedsReq.sessionId);
        o c16 = l.c();
        if (c16 != null) {
            c16.getImmersiveFeeds(gProGetImmersiveFeedsReq, new c(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i2(Continuation<? super SuspendRsp<GProStFeed>> continuation) {
        Continuation intercepted;
        String str;
        String str2;
        int i3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mFeedInitBean;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = null;
        if (guildFeedGalleryInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean = null;
        }
        long d16 = az.d(guildFeedGalleryInitBean.getGuildId(), 0L);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean3 = null;
        }
        long d17 = az.d(guildFeedGalleryInitBean3.getChannelId(), 0L);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean4 = null;
        }
        String feedId = guildFeedGalleryInitBean4.getFeedId();
        if (feedId == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(feedId, "mFeedInitBean.feedId ?: \"\"");
            str = feedId;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean5 = null;
        }
        String posterId = guildFeedGalleryInitBean5.getPosterId();
        if (posterId == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(posterId, "mFeedInitBean.posterId ?: \"\"");
            str2 = posterId;
        }
        GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = new GuildFeedDetailPreloadParams(d16, d17, str, str2, 0L, 0L);
        GProStFeed covertToStFeed = guildFeedDetailPreloadParams.covertToStFeed();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
        } else {
            guildFeedGalleryInitBean2 = guildFeedGalleryInitBean6;
        }
        if (guildFeedGalleryInitBean2.isFromTroop()) {
            i3 = 0;
        } else {
            i3 = 6;
        }
        GProStGetFeedDetailReq gProStGetFeedDetailReq = new GProStGetFeedDetailReq();
        gProStGetFeedDetailReq.from = i3;
        gProStGetFeedDetailReq.detailType = 1;
        gProStGetFeedDetailReq.feedId = covertToStFeed.idd;
        gProStGetFeedDetailReq.createTime = covertToStFeed.createTime;
        gProStGetFeedDetailReq.userId = guildFeedDetailPreloadParams.getUserId();
        gProStGetFeedDetailReq.channelSign = covertToStFeed.channelInfo.sign;
        gProStGetFeedDetailReq.disableReport = true;
        gProStGetFeedDetailReq.contentType = 2;
        o c16 = l.c();
        if (c16 != null) {
            c16.getFeedDetail(gProStGetFeedDetailReq, false, new d(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final int l2() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mFeedInitBean;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = null;
        if (guildFeedGalleryInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean = null;
        }
        guildFeedGalleryInitBean.getImmersiveSource();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
        } else {
            guildFeedGalleryInitBean2 = guildFeedGalleryInitBean3;
        }
        return guildFeedGalleryInitBean2.getImmersiveSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2() {
        Job job = this.fetchMoreDataJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.fetchMoreDataJob = e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2(GProStFeed feed) {
        List<GuildFeedDetailPreloadParams> listOf;
        try {
            GProStChannelSign gProStChannelSign = feed.channelInfo.sign;
            long j3 = gProStChannelSign.guildId;
            long j16 = gProStChannelSign.channelId;
            String str = feed.idd;
            Intrinsics.checkNotNullExpressionValue(str, "feed.idd");
            String str2 = feed.poster.idd;
            Intrinsics.checkNotNullExpressionValue(str2, "feed.poster.idd");
            GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = new GuildFeedDetailPreloadParams(j3, j16, str, str2, feed.createTime, feed.meta.lastModifiedTime);
            GuildFeedDetailDataCacheManager y16 = GuildFeedDetailDataCacheManager.y();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(guildFeedDetailPreloadParams);
            y16.s(listOf);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[preloadFeedDetailForFirstItem] error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, (String) it.next(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedGalleryInitBean t2(GProStFeed stFeed) {
        ArrayList<GuildFeedRichMediaData> d16 = b.d(stFeed);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setEnterPos(0);
        guildFeedGalleryInitBean.setGuildId(String.valueOf(stFeed.channelInfo.sign.guildId));
        guildFeedGalleryInitBean.setChannelId(String.valueOf(stFeed.channelInfo.sign.channelId));
        guildFeedGalleryInitBean.setFeed(stFeed);
        guildFeedGalleryInitBean.setFeedId(stFeed.idd);
        guildFeedGalleryInitBean.setPosterId(stFeed.poster.idd);
        guildFeedGalleryInitBean.setRichMediaDataList(d16);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.mFeedInitBean;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = null;
        if (guildFeedGalleryInitBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean2 = null;
        }
        guildFeedGalleryInitBean.setFromPage(guildFeedGalleryInitBean2.getFromPage());
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean4 = null;
        }
        guildFeedGalleryInitBean.setImmersiveSource(guildFeedGalleryInitBean4.getImmersiveSource());
        GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean5 = null;
        }
        guildFeedGalleryInitBean.setBusinessType(guildFeedGalleryInitBean5.getBusinessType());
        guildFeedGalleryInitBean.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(String.valueOf(stFeed.channelInfo.sign.channelId), stFeed.channelInfo.sign.joinGuildSig, "immersive_feed", "others"));
        GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean6 = null;
        }
        guildFeedGalleryInitBean.setJumpExtraInfo(guildFeedGalleryInitBean6.getJumpExtraInfo());
        GuildFeedGalleryInitBean guildFeedGalleryInitBean7 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean7 = null;
        }
        guildFeedGalleryInitBean.setFeedReportSourceInfo(guildFeedGalleryInitBean7.getFeedReportSourceInfo());
        GuildFeedGalleryInitBean guildFeedGalleryInitBean8 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean8 = null;
        }
        guildFeedGalleryInitBean.setAttrs(guildFeedGalleryInitBean8.getAttrs());
        GuildFeedGalleryInitBean guildFeedGalleryInitBean9 = this.mFeedInitBean;
        if (guildFeedGalleryInitBean9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
        } else {
            guildFeedGalleryInitBean3 = guildFeedGalleryInitBean9;
        }
        guildFeedGalleryInitBean.setTroopUin(guildFeedGalleryInitBean3.getTroopUin());
        guildFeedGalleryInitBean.setSessionId(this.mSessionId);
        return guildFeedGalleryInitBean;
    }

    @NotNull
    public final MutableLiveData<Integer> f2() {
        return this.mFeedRecommendLoadState;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "Guild_Feed_GAL_GuildFeedGalleryViewModel";
    }

    @NotNull
    public final MutableLiveData<jk1.a> h2() {
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[getInitFeedData] ");
        return this.mFeedsInitData;
    }

    @NotNull
    public final MutableLiveData<UIStateData<List<jk1.a>>> j() {
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[getFeedData] ");
        return this.mFeedsData;
    }

    public final boolean j2() {
        return Intrinsics.areEqual(this.mFeedLoadMoreFinish.getValue(), Boolean.TRUE);
    }

    @NotNull
    public final MutableLiveData<Boolean> k2() {
        return this.mFeedLoadMoreFinish;
    }

    public final void loadMore() {
        List emptyList;
        Integer value = this.mFeedRecommendLoadState.getValue();
        if (value == null || value.intValue() != 1) {
            Integer value2 = this.mFeedRecommendLoadState.getValue();
            if (value2 == null || value2.intValue() != 2) {
                Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[loadMore] isLoadFinish[" + this.mFeedLoadMoreFinish.getValue() + "]");
                if (Intrinsics.areEqual(this.mFeedLoadMoreFinish.getValue(), Boolean.TRUE)) {
                    MutableLiveData<UIStateData<List<jk1.a>>> mutableLiveData = this.mFeedsData;
                    UIStateData obtainSuccess = UIStateData.obtainSuccess(false);
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    mutableLiveData.setValue(obtainSuccess.setDataList(emptyList));
                    return;
                }
                Job job = this.fetchMoreDataJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.fetchMoreDataJob = e2();
            }
        }
    }

    /* renamed from: m2, reason: from getter */
    public final boolean getIsNeedLoadRecommend() {
        return this.isNeedLoadRecommend;
    }

    public final void p2() {
        Logger logger = Logger.f235387a;
        logger.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[refreshInitData] ");
        bn bnVar = bn.f223895a;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mFeedInitBean;
        if (guildFeedGalleryInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedInitBean");
            guildFeedGalleryInitBean = null;
        }
        if (bnVar.c(guildFeedGalleryInitBean)) {
            logger.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[refreshInitData]return, because status is publishing or fail !");
            return;
        }
        Job job = this.fetchDataJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.fetchDataJob = d2();
    }

    @NotNull
    public final Job q2(@NotNull String feedId) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildFeedGalleryViewModel$reportRecentViewFeed$1(feedId, null), 3, null);
        return launch$default;
    }

    public final void r2(@NotNull GuildFeedGalleryInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        boolean z16 = true;
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryViewModel", 1, "[refresh] ");
        this.mFeedInitBean = bean;
        if (bean.getImmersiveSource() != 1 && bean.getImmersiveSource() != 2 && bean.getImmersiveSource() != 3 && bean.getImmersiveSource() != 7) {
            z16 = false;
        }
        this.isNeedLoadRecommend = z16;
    }

    public final void s2(@NotNull IPerformanceReportTask reportTask) {
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        this.perfStageReportTask = reportTask;
    }
}
