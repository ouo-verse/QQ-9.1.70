package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerBigPicCommentFeedSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerBigPicUpdateLikeFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerDeleteFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerLikeFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerPunishSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerReportFeedSubmitEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareRefreshEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareScrollToTopEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerUnlikeFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedResult;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.MainPageViewBinding;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.matchfriend.reborn.publish.SquareFeedPublishSuccessEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;
import u72.b;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 P2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001QB\u000f\u0012\u0006\u00102\u001a\u00020/\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0016\u0010\u001d\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0002J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016J\u001c\u0010(\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010)\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010*\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,0+j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,`-H\u0016R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R#\u0010E\u001a\n @*\u0004\u0018\u00010?0?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/QQStrangerSquareListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/a;", "result", "", "T9", "aa", "", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feedList", "Z9", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "O9", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/SquareFeedPublishSuccessEvent;", "event", "P9", "feedId", "", "N9", "R9", "L9", "Lkotlin/Function0;", "block", "X9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "drawTime", "D8", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", "viewBinding", "Lt72/d;", "e", "Lt72/d;", "emptyAdapter", "Lt72/a;", "f", "Lt72/a;", "feedListAdapter", "Lx82/b;", tl.h.F, "Lx82/b;", "loadMoreAdapter", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "M9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", "viewModel", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "firstRefresh", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;)V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSquareListPart extends Part implements com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.a, SimpleEventReceiver<SimpleBaseEvent> {
    private static final a D = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final RFWConcatAdapter concatAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MainPageViewBinding viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final t72.d emptyAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private t72.a feedListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private x82.b loadMoreAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean firstRefresh;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/QQStrangerSquareListPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public QQStrangerSquareListPart(MainPageViewBinding viewBinding) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.viewBinding = viewBinding;
        t72.d dVar = new t72.d();
        this.emptyAdapter = dVar;
        this.feedListAdapter = new t72.a();
        this.loadMoreAdapter = new x82.b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSquareViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSquareViewModel invoke() {
                return (QQStrangerSquareViewModel) QQStrangerSquareListPart.this.getViewModel(QQStrangerSquareViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.firstRefresh = true;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        t72.b bVar = new t72.b();
        bVar.setHasStableIds(true);
        Unit unit = Unit.INSTANCE;
        t72.c cVar = new t72.c();
        cVar.setHasStableIds(true);
        t72.f fVar = new t72.f();
        fVar.setHasStableIds(true);
        dVar.setHasStableIds(true);
        t72.a aVar = this.feedListAdapter;
        aVar.setHasStableIds(true);
        x82.b bVar2 = this.loadMoreAdapter;
        bVar2.setHasStableIds(true);
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{bVar, cVar, fVar, dVar, aVar, bVar2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L9() {
        RecyclerView.LayoutManager layoutManager = this.viewBinding.getRecyclerView().getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return 0;
        }
        return linearLayoutManager.findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSquareViewModel M9() {
        return (QQStrangerSquareViewModel) this.viewModel.getValue();
    }

    private final void O9(String eventName, JSONObject data) {
        Integer a16;
        Boolean bool = null;
        String b16 = null;
        bool = null;
        switch (eventName.hashCode()) {
            case -1030828404:
                if (eventName.equals("NearbyFeedLikeStatusChangedEvent")) {
                    QLog.d("QQStrangerSquareListPart", 1, "handleKuiklyEvent " + eventName + " " + data);
                    String b17 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "feedId") : null;
                    Integer a17 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "count") : null;
                    if (data != null && (a16 = com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "isLike")) != null) {
                        bool = Boolean.valueOf(a16.intValue() == 1);
                    }
                    if (b17 == null || b17.length() == 0) {
                        return;
                    }
                    M9().l2(b17, a17, bool);
                    return;
                }
                return;
            case 377991797:
                if (eventName.equals("NBPFeedDeleteEvent")) {
                    QLog.d("QQStrangerSquareListPart", 1, "handleKuiklyEvent " + eventName + " " + data);
                    String b18 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "feedId") : null;
                    if (b18 == null || b18.length() == 0) {
                        return;
                    }
                    M9().g2(b18);
                    return;
                }
                return;
            case 603858797:
                if (eventName.equals("onNearbyProFeedCommentCountChange")) {
                    QLog.d("QQStrangerSquareListPart", 1, "handleKuiklyEvent " + eventName + " " + data);
                    String b19 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "feedId") : null;
                    Integer a18 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "commentCount") : null;
                    if (b19 == null || b19.length() == 0) {
                        return;
                    }
                    M9().j2(b19, a18);
                    return;
                }
                return;
            case 787925760:
                if (eventName.equals("OnGetArticleFeedDetailFirstFeed")) {
                    if (data != null) {
                        try {
                            b16 = com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "first_feed_base64");
                        } catch (Exception e16) {
                            QLog.d("QQStrangerSquareListPart", 1, "update feed exception: ", e16);
                            return;
                        }
                    }
                    FeedPB$Feed feedPB$Feed = new FeedPB$Feed();
                    feedPB$Feed.mergeFrom(Base64.decode(b16, 0));
                    QLog.d("QQStrangerSquareListPart", 1, "handleKuiklyEvent " + eventName + " " + u72.a.b(feedPB$Feed));
                    if (u72.a.b(feedPB$Feed).length() > 0) {
                        M9().k2(feedPB$Feed);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void P9(SquareFeedPublishSuccessEvent event) {
        FeedPB$Feed feed = event.getFeed();
        if (feed != null) {
            M9().M1(0, feed);
        }
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.r
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerSquareListPart.Q9(QQStrangerSquareListPart.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QQStrangerSquareListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewBinding.getRecyclerView().scrollToPosition(0);
    }

    private final void R9() {
        X9(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart$handleScrollToTop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int L9;
                MainPageViewBinding mainPageViewBinding;
                MainPageViewBinding mainPageViewBinding2;
                L9 = QQStrangerSquareListPart.this.L9();
                if (L9 < 12) {
                    mainPageViewBinding2 = QQStrangerSquareListPart.this.viewBinding;
                    mainPageViewBinding2.getRecyclerView().smoothScrollToPosition(0);
                } else {
                    mainPageViewBinding = QQStrangerSquareListPart.this.viewBinding;
                    mainPageViewBinding.getRecyclerView().scrollToPosition(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QQStrangerSquareListPart this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.M9().e2();
        this$0.M9().f2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T9(QQStrangerFeedResult result) {
        int i3;
        List listOf;
        boolean z16;
        List listOf2;
        List listOf3;
        List listOf4;
        Object orNull;
        QLog.d("QQStrangerSquareListPart", 1, "onLoadCompleted isRefresh=" + result.getIsRefresh() + " isSuccess=" + result.getIsSuccess() + " feedListSize=" + result.a().size() + " noMore=" + result.getNoMore() + "  isCacheData=" + result.getIsCacheData());
        Z9(result.a());
        aa(result);
        if (result.getIsRefresh()) {
            if (result.a().isEmpty()) {
                if (this.emptyAdapter.getNUM_BACKGOURND_ICON() != 0) {
                    List<u72.b> items = this.emptyAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "emptyAdapter.items");
                    orNull = CollectionsKt___CollectionsKt.getOrNull(items, 0);
                    if (!Intrinsics.areEqual(orNull, b.C11328b.f438520a)) {
                        z16 = false;
                        if (!result.getIsCacheData() && z16) {
                            t72.d dVar = this.emptyAdapter;
                            listOf4 = CollectionsKt__CollectionsJVMKt.listOf(b.c.f438521a);
                            dVar.setItems(listOf4);
                        } else if (NetworkUtil.isNetworkAvailable()) {
                            t72.d dVar2 = this.emptyAdapter;
                            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(b.d.f438522a);
                            dVar2.setItems(listOf3);
                        } else {
                            t72.d dVar3 = this.emptyAdapter;
                            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(b.a.f438519a);
                            dVar3.setItems(listOf2);
                        }
                    }
                }
                z16 = true;
                if (!result.getIsCacheData()) {
                }
                if (NetworkUtil.isNetworkAvailable()) {
                }
            } else {
                t72.d dVar4 = this.emptyAdapter;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(b.C11328b.f438520a);
                dVar4.setItems(listOf);
            }
            if (!result.getIsCacheData() && this.firstRefresh) {
                this.firstRefresh = false;
                v72.c.c("first_page_request");
                v72.c.d("first_page_request");
                this.viewBinding.f(this);
            }
        }
        if (result.getIsSuccess() || !(!result.a().isEmpty())) {
            return;
        }
        if (NetworkUtil.isNetworkAvailable()) {
            i3 = result.getIsRefresh() ? R.string.x3b : R.string.x2m;
        } else {
            i3 = R.string.x0e;
        }
        QQToast.makeText(getContext(), 1, i3, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X9(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.q
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerSquareListPart.Y9(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(final List<FeedPB$Feed> feedList) {
        QLog.d("QQStrangerSquareListPart", 1, "update feed list " + feedList.size());
        X9(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart$updateFeedList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                t72.a aVar;
                aVar = QQStrangerSquareListPart.this.feedListAdapter;
                aVar.setItems(feedList);
            }
        });
    }

    private final void aa(QQStrangerFeedResult result) {
        if (result.getIsRefresh()) {
            this.viewBinding.getRefreshLayout().finishRefresh();
        } else {
            this.loadMoreAdapter.setLoadState(false, !result.getNoMore());
        }
        this.loadMoreAdapter.j0(!result.a().isEmpty());
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.a
    public void D8(long drawTime) {
        QLog.d("QQStrangerSquareListPart", 4, "drawTime " + drawTime);
        this.viewBinding.f(null);
        v72.c.d("first_page_screen");
        v72.c.c("first_page_screen");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        List listOf;
        super.onInitView(rootView);
        SmartRefreshLayout refreshLayout = this.viewBinding.getRefreshLayout();
        refreshLayout.a(true);
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.l(new r3.h() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.p
            @Override // r3.h
            public final void e(q3.f fVar) {
                QQStrangerSquareListPart.S9(QQStrangerSquareListPart.this, fVar);
            }
        });
        this.viewBinding.getRecyclerView().setAdapter(this.concatAdapter);
        this.loadMoreAdapter.registerLoadMoreListener(new b());
        t72.d dVar = this.emptyAdapter;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b.C11328b.f438520a);
        dVar.setItems(listOf);
        List<FeedPB$Feed> Z1 = M9().Z1();
        if (Z1 != null) {
            Z9(Z1);
        }
        v72.c.a("first_page_request");
        v72.c.h("first_page_request");
        M9().e2();
        M9().f2(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        MutableLiveData<QQStrangerFeedResult> X1 = M9().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QQStrangerFeedResult, Unit> function1 = new Function1<QQStrangerFeedResult, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQStrangerFeedResult qQStrangerFeedResult) {
                invoke2(qQStrangerFeedResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQStrangerFeedResult it) {
                QQStrangerSquareListPart qQStrangerSquareListPart = QQStrangerSquareListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQStrangerSquareListPart.T9(it);
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSquareListPart.W9(Function1.this, obj);
            }
        });
        MutableLiveData<List<FeedPB$Feed>> a26 = M9().a2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends FeedPB$Feed>, Unit> function12 = new Function1<List<? extends FeedPB$Feed>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart$onPartCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends FeedPB$Feed> list) {
                invoke2((List<FeedPB$Feed>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FeedPB$Feed> it) {
                QQStrangerSquareListPart qQStrangerSquareListPart = QQStrangerSquareListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQStrangerSquareListPart.Z9(it);
            }
        };
        a26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSquareListPart.U9(Function1.this, obj);
            }
        });
        MutableLiveData<Pair<String, Integer>> W1 = M9().W1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Pair<? extends String, ? extends Integer>, Unit> function13 = new Function1<Pair<? extends String, ? extends Integer>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart$onPartCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Integer> pair) {
                invoke2((Pair<String, Integer>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, Integer> pair) {
                QQStrangerSquareListPart.this.N9(pair.getFirst(), pair.getSecond().intValue());
            }
        };
        W1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSquareListPart.V9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.d("QQStrangerSquareListPart", 1, "onReceive " + event);
        if (event instanceof QQStrangerSquareScrollToTopEvent) {
            R9();
            return;
        }
        if (event instanceof QQStrangerSquareRefreshEvent) {
            this.viewBinding.getRefreshLayout().h(0, 300, 1.0f, false);
            return;
        }
        if (event instanceof QQStrangerLikeFeedEvent) {
            M9().c2(((QQStrangerLikeFeedEvent) event).getFeed());
            return;
        }
        if (event instanceof QQStrangerUnlikeFeedEvent) {
            M9().i2(((QQStrangerUnlikeFeedEvent) event).getFeed());
            return;
        }
        if (event instanceof QQStrangerDeleteFeedEvent) {
            M9().O1(u72.a.b(((QQStrangerDeleteFeedEvent) event).getFeed()));
            return;
        }
        if (event instanceof QQStrangerPunishSuccessEvent) {
            M9().g2(((QQStrangerPunishSuccessEvent) event).getFeedId());
            return;
        }
        if (event instanceof QQStrangerReportFeedSubmitEvent) {
            M9().g2(((QQStrangerReportFeedSubmitEvent) event).getFeedId());
            return;
        }
        if (event instanceof QQStrangerKuiklyEvent) {
            QQStrangerKuiklyEvent qQStrangerKuiklyEvent = (QQStrangerKuiklyEvent) event;
            O9(qQStrangerKuiklyEvent.getEventName(), qQStrangerKuiklyEvent.getData());
            return;
        }
        if (event instanceof QQStrangerBigPicUpdateLikeFeedEvent) {
            QQStrangerBigPicUpdateLikeFeedEvent qQStrangerBigPicUpdateLikeFeedEvent = (QQStrangerBigPicUpdateLikeFeedEvent) event;
            M9().l2(qQStrangerBigPicUpdateLikeFeedEvent.getFeedId(), Integer.valueOf(qQStrangerBigPicUpdateLikeFeedEvent.getLikeCount()), Boolean.valueOf(qQStrangerBigPicUpdateLikeFeedEvent.isLiked()));
        } else if (event instanceof QQStrangerBigPicCommentFeedSuccessEvent) {
            QQStrangerBigPicCommentFeedSuccessEvent qQStrangerBigPicCommentFeedSuccessEvent = (QQStrangerBigPicCommentFeedSuccessEvent) event;
            M9().j2(qQStrangerBigPicCommentFeedSuccessEvent.getFeedId(), Integer.valueOf(qQStrangerBigPicCommentFeedSuccessEvent.getFeedCommentCount()));
        } else if (event instanceof SquareFeedPublishSuccessEvent) {
            P9((SquareFeedPublishSuccessEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerSquareScrollToTopEvent.class, QQStrangerSquareRefreshEvent.class, QQStrangerLikeFeedEvent.class, QQStrangerUnlikeFeedEvent.class, QQStrangerDeleteFeedEvent.class, QQStrangerPunishSuccessEvent.class, QQStrangerReportFeedSubmitEvent.class, QQStrangerKuiklyEvent.class, QQStrangerBigPicUpdateLikeFeedEvent.class, QQStrangerBigPicCommentFeedSuccessEvent.class, SquareFeedPublishSuccessEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(String feedId, int result) {
        if (result != 0) {
            QQToast.makeText(getContext(), 1, NetworkUtil.isNetworkAvailable() ? R.string.f169690x22 : R.string.x0e, 0).show();
            return;
        }
        QQToast.makeText(getContext(), R.string.f169691x23, 0).show();
        M9().g2(feedId);
        Context context = getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", feedId);
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(context, "NBPFeedDeleteEvent", jSONObject);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/QQStrangerSquareListPart$b", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements ILoadMoreProvider$LoadMoreListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            QQStrangerSquareListPart.this.M9().d2();
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
