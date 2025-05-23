package com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import bo1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.feedsquare.data.h;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildFeedSearchRes;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUnionResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.qqguildsdk.data.genc.eg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ij1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.br;
import wh2.ea;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 R2\u00020\u00012(\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0002:\u0001SB\u0007\u00a2\u0006\u0004\bQ\u0010=J\b\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00050\u00050\u001d*\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010!\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010 \u001a\u00060\bj\u0002`\tH\u0016J\"\u0010#\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010 \u001a\u00060\bj\u0002`\t2\u0006\u0010\"\u001a\u00020\fJ\b\u0010$\u001a\u00020\u0019H\u0014J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\u0016\u0010*\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(R\u001e\u0010/\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105RJ\u0010>\u001a2\u0012.\u0012,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t08j\u0002`9078\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b:\u0010;\u0012\u0004\b<\u0010=R*\u0010C\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u00060\bj\u0002`\t0@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010KRD\u0010P\u001a2\u0012.\u0012,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t08j\u0002`90M8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResult;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchExtraArgs;", "Lkotlinx/coroutines/Job;", "f2", "", "tinyID", "args", "", "keyword", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eg;", "T1", "scheduleGeneration", "Lwh2/ea;", "d2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchRsp;", "rsp", "", "c2", "Z1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUnionResult;", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "j2", "extendArgs", "g2", "channelId", SemanticAttributes.DbSystemValues.H2, "onCleared", FeedManager.LOAD_MORE, "i2", "guildId", "Lwh2/br;", "callback", "U1", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/Cookie;", "i", "[B", "feedCookie", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eg;", "currentSearchRequest", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "maxRunScheduledGeneration", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbo1/a;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResultState;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get_stateFlow$annotations", "()V", "_stateFlow", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Pair;", "E", "Lkotlinx/coroutines/channels/Channel;", "searchRequestChannel", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/Job;", "producerJob", "G", "J", "", "W1", "()Z", "hasMoreData", "Lkotlinx/coroutines/flow/StateFlow;", "X1", "()Lkotlinx/coroutines/flow/StateFlow;", "resultStateFlow", "<init>", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchViewModel extends ViewModel {

    @NotNull
    private static final a H = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicIntegerArray maxRunScheduledGeneration = new AtomicIntegerArray(2);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs>> _stateFlow;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Channel<Pair<String, FeedBatchManageSearchArgs>> searchRequestChannel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Job producerJob;

    /* renamed from: G, reason: from kotlin metadata */
    private long channelId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile byte[] feedCookie;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile eg currentSearchRequest;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel$a;", "", "", "LOAD_MORE_RUN_SCHEDULED_GENERATION", "I", "SEARCH_RUN_SCHEDULED_GENERATION", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FeedBatchManageSearchViewModel() {
        a.b bVar = a.b.f28717a;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
        this._stateFlow = StateFlowKt.MutableStateFlow(bVar);
        this.searchRequestChannel = ChannelKt.Channel$default(1, BufferOverflow.DROP_OLDEST, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final eg T1(long tinyID, FeedBatchManageSearchArgs args, String keyword) {
        eg egVar = new eg();
        egVar.l(tinyID);
        egVar.j(MiscKt.l(args.getContact().getGuildId()));
        egVar.i(args.b());
        egVar.k(keyword);
        if (args.b() == 0) {
            egVar.a().add(Long.valueOf(MiscKt.l(args.getContact().getChannelId())));
        }
        long j3 = this.channelId;
        if (j3 != 0) {
            QLog.d("FeedBatchManagement.Search.ViewModel", 1, "addChannelId" + j3);
            egVar.a().clear();
            egVar.a().add(Long.valueOf(this.channelId));
            this.channelId = 0L;
        }
        return egVar;
    }

    private final void Z1() {
        bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs> value = X1().getValue();
        if (value instanceof a.SuccessState) {
            a.SuccessState successState = (a.SuccessState) value;
            do1.b bVar = new do1.b();
            bVar.e(false);
            bVar.f(4);
            bVar.d(((do1.a) successState.d()).a());
            bVar.g(((do1.a) successState.d()).getTotal());
            Unit unit = Unit.INSTANCE;
            a.SuccessState b16 = a.SuccessState.b(successState, null, null, bVar, 3, null);
            if (!this._stateFlow.compareAndSet(value, b16)) {
                QLog.d("FeedBatchManagement.Search.ViewModel", 1, "onLoadMoreFailed|cas failed, update=" + b16 + ", expect=" + value);
            }
        }
    }

    private final ea a2(final int scheduleGeneration) {
        return new ea() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.a
            @Override // wh2.ea
            public final void a(int i3, String str, IGProGuildSearchRsp iGProGuildSearchRsp) {
                FeedBatchManageSearchViewModel.b2(FeedBatchManageSearchViewModel.this, scheduleGeneration, i3, str, iGProGuildSearchRsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(FeedBatchManageSearchViewModel this$0, int i3, int i16, String str, IGProGuildSearchRsp rsp) {
        IGProUnionResult iGProUnionResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.maxRunScheduledGeneration.get(1) != i3) {
            QLog.i("FeedBatchManagement.Search.ViewModel", 1, "loadMore|inconsistent scheduled generation");
            return;
        }
        if (i16 == 0) {
            if (rsp != null) {
                iGProUnionResult = rsp.getUnionResult();
            } else {
                iGProUnionResult = null;
            }
            if (iGProUnionResult != null) {
                this$0.feedCookie = rsp.getUnionResult().getFeedCookie();
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                this$0.c2(rsp);
                return;
            }
        }
        QLog.e("FeedBatchManagement.Search.ViewModel", 1, "onLoadMore|result" + i16 + ", errMsg=" + str);
        this$0.Z1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c2(IGProGuildSearchRsp rsp) {
        List list;
        bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs> value = X1().getValue();
        if (!(value instanceof a.SuccessState)) {
            QLog.d("FeedBatchManagement.Search.ViewModel", 1, "onLoadMore success, but state isn't success");
            return;
        }
        a.SuccessState successState = (a.SuccessState) value;
        do1.b bVar = new do1.b();
        bVar.e(rsp.getUnionResult().getFeedIsEnd());
        bVar.f(0);
        List list2 = (List) ((do1.a) successState.d()).a();
        if (list2 != null && list != null) {
            IGProUnionResult unionResult = rsp.getUnionResult();
            Intrinsics.checkNotNullExpressionValue(unionResult, "rsp.unionResult");
            list.addAll(j2(unionResult, successState.getKeyword()));
        } else {
            list = null;
        }
        bVar.d(list);
        bVar.g(((do1.a) successState.d()).getTotal());
        Unit unit = Unit.INSTANCE;
        a.SuccessState b16 = a.SuccessState.b(successState, null, null, bVar, 3, null);
        if (!this._stateFlow.compareAndSet(value, b16)) {
            QLog.d("FeedBatchManagement.Search.ViewModel", 1, "onLoadMoreSuccess|CAS, expect=" + value + ", update=" + b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ea d2(final String keyword, final FeedBatchManageSearchArgs args, final int scheduleGeneration) {
        return new ea() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.b
            @Override // wh2.ea
            public final void a(int i3, String str, IGProGuildSearchRsp iGProGuildSearchRsp) {
                FeedBatchManageSearchViewModel.e2(scheduleGeneration, this, keyword, args, i3, str, iGProGuildSearchRsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(int i3, FeedBatchManageSearchViewModel this$0, String keyword, FeedBatchManageSearchArgs args, int i16, String errMsg, IGProGuildSearchRsp iGProGuildSearchRsp) {
        IGProUnionResult iGProUnionResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(keyword, "$keyword");
        Intrinsics.checkNotNullParameter(args, "$args");
        if (i3 != this$0.maxRunScheduledGeneration.get(0)) {
            QLog.i("FeedBatchManagement.Search.ViewModel", 1, "startSearchFeed|inconsistent scheduled generation");
            return;
        }
        if (i16 == 0) {
            if (iGProGuildSearchRsp != null) {
                iGProUnionResult = iGProGuildSearchRsp.getUnionResult();
            } else {
                iGProUnionResult = null;
            }
            if (iGProUnionResult != null) {
                this$0.feedCookie = iGProGuildSearchRsp.getUnionResult().getFeedCookie();
                MutableStateFlow<bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs>> mutableStateFlow = this$0._stateFlow;
                do1.b bVar = new do1.b();
                IGProUnionResult unionResult = iGProGuildSearchRsp.getUnionResult();
                Intrinsics.checkNotNullExpressionValue(unionResult, "rsp.unionResult");
                bVar.d(this$0.j2(unionResult, keyword));
                bVar.e(iGProGuildSearchRsp.getUnionResult().getFeedIsEnd());
                bVar.f(-1);
                bVar.g((int) iGProGuildSearchRsp.getUnionResult().getFeedTotal());
                Unit unit = Unit.INSTANCE;
                mutableStateFlow.setValue(new a.SuccessState(keyword, args, bVar));
                return;
            }
        }
        QLog.e("FeedBatchManagement.Search.ViewModel", 1, "startSearchFeed|result=" + i16 + ", err=" + errMsg);
        MutableStateFlow<bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs>> mutableStateFlow2 = this$0._stateFlow;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        mutableStateFlow2.setValue(new a.ErrorState(keyword, args, i16, errMsg));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Job f2() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        long j3;
        Job launch$default;
        Long longOrNull;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (r0 = iGPSService.getSelfTinyId()) != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), ae.a().b(), null, new FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1(this, j3, null), 2, null);
        return launch$default;
    }

    private final ArrayList<h> j2(IGProUnionResult iGProUnionResult, String str) {
        int i3;
        ArrayList arrayList;
        boolean z16;
        List mutableListOf;
        o c16 = l.c();
        if (c16 == null) {
            return new ArrayList<>();
        }
        ArrayList<IGProGuildFeedSearchRes> guildFeeds = iGProUnionResult.getGuildFeeds();
        if (guildFeeds != null) {
            i3 = guildFeeds.size();
        } else {
            i3 = 0;
        }
        ArrayList<IGProGuildFeedSearchRes> guildFeeds2 = iGProUnionResult.getGuildFeeds();
        if (guildFeeds2 != null) {
            Intrinsics.checkNotNullExpressionValue(guildFeeds2, "guildFeeds");
            arrayList = new ArrayList(i3);
            Iterator<T> it = guildFeeds2.iterator();
            while (it.hasNext()) {
                GProStFeed decodeStFeed = c16.decodeStFeed(((IGProGuildFeedSearchRes) it.next()).getOriContents());
                h hVar = null;
                if (decodeStFeed != null) {
                    String str2 = decodeStFeed.idd;
                    if (str2 != null && str2.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        decodeStFeed = null;
                    }
                    if (decodeStFeed != null) {
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str);
                        hVar = new h(new g(decodeStFeed, "", mutableListOf));
                    }
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
            }
        } else {
            arrayList = new ArrayList();
        }
        return new ArrayList<>(arrayList);
    }

    public final void U1(@NotNull String guildId, @NotNull br callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(guildId));
        bdVar.h(false);
        bdVar.j(false);
        bdVar.i(true);
        ((IGPSService) ch.S0(IGPSService.class, "")).getCategoryChannelInfoListV2(bdVar, callback);
    }

    public boolean W1() {
        bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs> value = X1().getValue();
        if ((value instanceof a.SuccessState) && !((do1.a) ((a.SuccessState) value).d()).getIsFinished()) {
            return true;
        }
        return false;
    }

    @NotNull
    public StateFlow<bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs>> X1() {
        return this._stateFlow;
    }

    public void g2(@NotNull String keyword, @NotNull FeedBatchManageSearchArgs extendArgs) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(extendArgs, "extendArgs");
        QLog.d("FeedBatchManagement.Search.ViewModel", 1, "startSearch|wd.len=" + keyword.length() + ", " + extendArgs);
        this.searchRequestChannel.mo2003trySendJP2dKIU(TuplesKt.to(keyword, extendArgs));
        if (this.producerJob == null) {
            this.producerJob = f2();
        }
    }

    public final void h2(@NotNull String keyword, @NotNull FeedBatchManageSearchArgs extendArgs, long channelId) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(extendArgs, "extendArgs");
        this.channelId = channelId;
        g2(keyword, extendArgs);
    }

    public void i2() {
        MutableStateFlow<bo1.a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs>> mutableStateFlow = this._stateFlow;
        a.b bVar = a.b.f28717a;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
        mutableStateFlow.setValue(bVar);
    }

    public void loadMore() {
        eg egVar;
        AppInterface appInterface;
        if (!W1() || (egVar = this.currentSearchRequest) == null) {
            return;
        }
        eg egVar2 = new eg();
        egVar2.l(egVar.f());
        egVar2.j(egVar.d());
        egVar2.i(egVar.c());
        egVar2.g(new ArrayList<>(egVar.a()));
        egVar2.k(egVar.e());
        egVar2.h(this.feedCookie);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.searchGuildFeeds(egVar2, a2(this.maxRunScheduledGeneration.incrementAndGet(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        SendChannel.DefaultImpls.close$default(this.searchRequestChannel, null, 1, null);
    }
}
