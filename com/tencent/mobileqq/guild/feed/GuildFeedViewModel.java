package com.tencent.mobileqq.guild.feed;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreState;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshState;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshType;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.q;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildPublishReEditEvent;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIndexFeedItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b=\u0010>J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0018H\u0002J\u001c\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010.\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00101\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/GuildFeedViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexRsp;", "rsp", "", "p2", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", "r2", "l2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;", "callback", "m2", "Lcom/tencent/mobileqq/guild/feed/event/GuildPublishReEditEvent;", "event", "o2", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDeleteEvent;", ICustomDataEditor.NUMBER_PARAM_2, "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "observer", "u2", "c2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Lkotlin/collections/ArrayList;", "q2", ICustomDataEditor.STRING_PARAM_2, "H", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;", "getRequest", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;", "I", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "", "J", "Z", "needNotifyContentChange", "", "K", "[B", "svrCookie", "Landroidx/lifecycle/MutableLiveData;", "L", "Landroidx/lifecycle/MutableLiveData;", "feedsNumStrRspLiveData", "M", "isFinished", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;)V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedViewModel extends BaseFeedViewModel {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GProGetFeedsByIndexReq request;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needNotifyContentChange;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private byte[] svrCookie;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> feedsNumStrRspLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFinished;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildPublishReEditEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.GuildFeedViewModel$1", f = "GuildFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.GuildFeedViewModel$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<GuildPublishReEditEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull GuildPublishReEditEvent guildPublishReEditEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(guildPublishReEditEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildFeedViewModel.this.o2((GuildPublishReEditEvent) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDeleteEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.GuildFeedViewModel$2", f = "GuildFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.GuildFeedViewModel$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<GuildFeedDeleteEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull GuildFeedDeleteEvent guildFeedDeleteEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(guildFeedDeleteEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildFeedViewModel.this.n2((GuildFeedDeleteEvent) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public GuildFeedViewModel(@NotNull GProGetFeedsByIndexReq request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.tag = "GuildFeedViewModel";
        this.feedsNumStrRspLiveData = new MutableLiveData<>();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new GuildFeedViewModel$special$$inlined$eventFlow$1(simpleEventBus, null)), new AnonymousClass1(null)), ViewModelKt.getViewModelScope(this));
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new GuildFeedViewModel$special$$inlined$eventFlow$2(simpleEventBus2, null)), new AnonymousClass2(null)), ViewModelKt.getViewModelScope(this));
    }

    private final void l2(GProGetFeedsByIndexRsp rsp) {
        if (rsp.indexItems.size() < 10 && !rsp.isEnd) {
            QLog.i("GuildFeedViewModel", 1, "loadMore size=" + rsp.indexItems.size() + " ");
            B(new LoadMoreArgs(LoadMoreType.TYPE_PRE_LOAD_MORE, "GuildRecentlyViewedViewModel"));
        }
    }

    private final void m2(GProGetFeedsByIndexReq request, IGProGetFeedsByIndexCallback callback) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new GuildFeedViewModel$fetchMVPFeedsFromServerWithTimeout$1(request, callback, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2(GuildFeedDeleteEvent event) {
        for (com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar : S1()) {
            if ((hVar instanceof RecommendAbsFeedData) && Intrinsics.areEqual(((RecommendAbsFeedData) hVar).getIdd(), event.getFeedId())) {
                S1().remove(hVar);
                b2();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2(GuildPublishReEditEvent event) {
        QLog.d("GuildFeedViewModel", 1, "handleGuildPublishReEditEvent event=" + event);
        if (event.getCode() != 0) {
            return;
        }
        for (com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar : S1()) {
            if ((hVar instanceof RecommendAbsFeedData) && Intrinsics.areEqual(((RecommendAbsFeedData) hVar).getIdd(), event.getFeedId())) {
                this.needNotifyContentChange = true;
                c2(new PullToRefreshArgs(PullToRefreshType.TYPE_FIRST_RENDER_FETCH, "GuildFeedViewModelhandleGuildPublishReEditEvent"));
                return;
            }
        }
    }

    private final void p2(LoadMoreArgs loadMoreArgs, int result, String errMsg, GProGetFeedsByIndexRsp rsp) {
        Integer num;
        boolean z16;
        ArrayList<GProIndexFeedItem> arrayList;
        Boolean bool = null;
        if (rsp != null && (arrayList = rsp.indexItems) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        if (rsp != null) {
            bool = Boolean.valueOf(rsp.isEnd);
        }
        QLog.i("GuildFeedViewModel", 1, "handleLoadMoreFromServerComplete result = " + result + " errMsg = " + errMsg + " size = " + num + " isEnd = " + bool);
        if (errMsg == null) {
            errMsg = "";
        }
        ri1.a error = ri1.a.b(result, errMsg);
        if (rsp != null) {
            z16 = rsp.isEnd;
        } else {
            z16 = this.isFinished;
        }
        this.isFinished = z16;
        if (result == 0 && rsp != null) {
            this.svrCookie = rsp.cookie;
            d2(false);
            ArrayList<com.tencent.mobileqq.guild.discoveryv2.content.base.h> q26 = q2(rsp);
            Intrinsics.checkNotNullExpressionValue(error, "error");
            e2(new LoadMoreState(true, error, loadMoreArgs.getLoadMoreType(), q26, rsp.isEnd, null, 32, null));
            return;
        }
        d2(false);
        Intrinsics.checkNotNullExpressionValue(error, "error");
        e2(new LoadMoreState(true, error, loadMoreArgs.getLoadMoreType(), null, this.isFinished, null, 32, null));
    }

    private final void r2(PullToRefreshArgs pullToRefreshArgs, int result, String errMsg, GProGetFeedsByIndexRsp rsp) {
        Integer num;
        ArrayList<GProIndexFeedItem> arrayList;
        String str = errMsg;
        Boolean bool = null;
        if (rsp != null && (arrayList = rsp.indexItems) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        if (rsp != null) {
            bool = Boolean.valueOf(rsp.isEnd);
        }
        QLog.i("GuildFeedViewModel", 1, "handlePullToRefreshFromServerComplete result = " + result + " errMsg = " + str + " size = " + num + " isEnd =" + bool);
        if (str == null) {
            str = "";
        }
        ri1.a error = ri1.a.b(result, str);
        if (result == 0 && rsp != null) {
            S1().clear();
            this.isFinished = rsp.isEnd;
            this.svrCookie = rsp.cookie;
            Intrinsics.checkNotNullExpressionValue(rsp.indexItems, "rsp.indexItems");
            if (!r1.isEmpty()) {
                if (!TextUtils.isEmpty(rsp.totalStr)) {
                    this.feedsNumStrRspLiveData.setValue(rsp.totalStr);
                }
                s2(rsp);
                Intrinsics.checkNotNullExpressionValue(error, "error");
                f2(new PullToRefreshState(true, error, pullToRefreshArgs.getPullToRefreshType(), S1(), rsp.isEnd, null, 32, null));
                if (this.needNotifyContentChange) {
                    QLog.i("GuildFeedViewModel", 1, "pullToRefreshFromServer notifyContentListUpdated");
                    this.needNotifyContentChange = false;
                    b2();
                    return;
                }
                return;
            }
            QLog.i("GuildFeedViewModel", 1, "pullToRefreshFromServer list is null");
            Intrinsics.checkNotNullExpressionValue(error, "error");
            f2(new PullToRefreshState(true, error, pullToRefreshArgs.getPullToRefreshType(), null, true, null, 32, null));
            return;
        }
        QLog.i("GuildFeedViewModel", 1, "pullToRefreshFromServer false");
        Intrinsics.checkNotNullExpressionValue(error, "error");
        f2(new PullToRefreshState(true, error, pullToRefreshArgs.getPullToRefreshType(), null, true, null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(GuildFeedViewModel this$0, LoadMoreArgs loadMoreArgs, int i3, String str, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loadMoreArgs, "$loadMoreArgs");
        this$0.p2(loadMoreArgs, i3, str, gProGetFeedsByIndexRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(GuildFeedViewModel this$0, PullToRefreshArgs pullToRefreshArgs, int i3, String str, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pullToRefreshArgs, "$pullToRefreshArgs");
        this$0.r2(pullToRefreshArgs, i3, str, gProGetFeedsByIndexRsp);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void a2(@NotNull final LoadMoreArgs loadMoreArgs) {
        Intrinsics.checkNotNullParameter(loadMoreArgs, "loadMoreArgs");
        d2(true);
        boolean z16 = this.isFinished;
        if (z16) {
            QLog.d("GuildFeedViewModel", 4, "loadMoreFormServer isFinished=" + z16);
            d2(false);
            ri1.a f16 = ri1.a.f();
            Intrinsics.checkNotNullExpressionValue(f16, "ok()");
            e2(new LoadMoreState(true, f16, loadMoreArgs.getLoadMoreType(), null, true, null, 32, null));
            return;
        }
        GProGetFeedsByIndexReq gProGetFeedsByIndexReq = this.request;
        byte[] bArr = this.svrCookie;
        if (bArr == null) {
            bArr = new byte[0];
        }
        gProGetFeedsByIndexReq.cookie = bArr;
        gProGetFeedsByIndexReq.count = 15;
        QLog.d("GuildFeedViewModel", 1, "loadMoreFormServer request=" + gProGetFeedsByIndexReq);
        m2(this.request, new IGProGetFeedsByIndexCallback() { // from class: com.tencent.mobileqq.guild.feed.f
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback
            public final void onResult(int i3, String str, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
                GuildFeedViewModel.t2(GuildFeedViewModel.this, loadMoreArgs, i3, str, gProGetFeedsByIndexRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void c2(@NotNull final PullToRefreshArgs pullToRefreshArgs) {
        Intrinsics.checkNotNullParameter(pullToRefreshArgs, "pullToRefreshArgs");
        this.isFinished = false;
        GProGetFeedsByIndexReq gProGetFeedsByIndexReq = this.request;
        gProGetFeedsByIndexReq.cookie = new byte[0];
        gProGetFeedsByIndexReq.count = 15;
        QLog.d("GuildFeedViewModel", 1, "pullToRefreshFromServer request=" + gProGetFeedsByIndexReq);
        m2(this.request, new IGProGetFeedsByIndexCallback() { // from class: com.tencent.mobileqq.guild.feed.g
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback
            public final void onResult(int i3, String str, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
                GuildFeedViewModel.v2(GuildFeedViewModel.this, pullToRefreshArgs, i3, str, gProGetFeedsByIndexRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    @NotNull
    public String getTag() {
        return this.tag;
    }

    @NotNull
    public ArrayList<com.tencent.mobileqq.guild.discoveryv2.content.base.h> q2(@NotNull GProGetFeedsByIndexRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        RecommendExtData recommendExtData = new RecommendExtData("", 0, null, null, 0, 28, null);
        ArrayList<com.tencent.mobileqq.guild.discoveryv2.content.base.h> arrayList = new ArrayList<>();
        ArrayList<GProIndexFeedItem> arrayList2 = rsp.indexItems;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.indexItems");
        int i3 = 0;
        for (Object obj : arrayList2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProDataApi iGProDataApi = (IGProDataApi) QRoute.api(IGProDataApi.class);
            GProContentRecommendFeed gProContentRecommendFeed = ((GProIndexFeedItem) obj).recommendFeed;
            Intrinsics.checkNotNullExpressionValue(gProContentRecommendFeed, "it.recommendFeed");
            IGProRecommendContentItem newGProRecommendContentItem = iGProDataApi.newGProRecommendContentItem(1, gProContentRecommendFeed);
            recommendExtData.g(i3);
            com.tencent.mobileqq.guild.discoveryv2.content.base.h d16 = q.d(newGProRecommendContentItem, recommendExtData);
            if (d16 != null) {
                arrayList.add(d16);
            }
            i3 = i16;
        }
        S1().addAll(arrayList);
        l2(rsp);
        return arrayList;
    }

    public void s2(@NotNull GProGetFeedsByIndexRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        RecommendExtData recommendExtData = new RecommendExtData("", 0, null, null, 0, 28, null);
        ArrayList<GProIndexFeedItem> arrayList = rsp.indexItems;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.indexItems");
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProDataApi iGProDataApi = (IGProDataApi) QRoute.api(IGProDataApi.class);
            GProContentRecommendFeed gProContentRecommendFeed = ((GProIndexFeedItem) obj).recommendFeed;
            Intrinsics.checkNotNullExpressionValue(gProContentRecommendFeed, "it.recommendFeed");
            IGProRecommendContentItem newGProRecommendContentItem = iGProDataApi.newGProRecommendContentItem(1, gProContentRecommendFeed);
            recommendExtData.g(i3);
            com.tencent.mobileqq.guild.discoveryv2.content.base.h d16 = q.d(newGProRecommendContentItem, recommendExtData);
            if (d16 != null) {
                S1().add(d16);
            }
            i3 = i16;
        }
        l2(rsp);
    }

    public final void u2(@NotNull LifecycleOwner owner, @NotNull Observer<String> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.feedsNumStrRspLiveData.observe(owner, observer);
    }
}
