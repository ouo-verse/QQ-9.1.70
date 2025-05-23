package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.animator.FeedDefaultItemAnimator;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.s;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u000f\u0012\u0006\u00104\u001a\u00020%\u00a2\u0006\u0004\b5\u00106J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u001c\u0010\n\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J$\u0010\r\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J*\u0010\u0015\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J*\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J*\u0010\u0019\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J$\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020#H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R0\u00103\u001a\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0004\u0012\u00020\b\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListAdapterWorker;", "Lbk1/a$a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "uiStateData", "", HippyTKDListViewAdapter.X, "y", "Lvi1/h;", "listScrollerApi", "B", "listUIOperationApi", "", "oldItemCount", UserInfo.SEX_FEMALE, "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "result", "D", "readonlyList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/a;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "w", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "E", "Lbk1/a$b;", "c", "Lvi1/e;", tl.h.F, "", "d", "Ljava/lang/String;", "logTag", "e", "Landroidx/recyclerview/widget/RecyclerView;", "", "f", "Z", "lockUpdateList", "g", "updateListWhenUnLock", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "observeFeedDataAction", "prefixLogTag", "<init>", "(Ljava/lang/String;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class DefaultFeedListAdapterWorker extends a.AbstractC0131a<GuildFeedSquareListAdapter, Object> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean lockUpdateList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean updateListWhenUnLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super UIStateData<List<ij1.g>>, Unit> observeFeedDataAction;

    public DefaultFeedListAdapterWorker(@NotNull String prefixLogTag) {
        Intrinsics.checkNotNullParameter(prefixLogTag, "prefixLogTag");
        this.logTag = prefixLogTag + ".DefaultFeedListAdapterWorker";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(boolean z16, DefaultFeedListAdapterWorker this$0, UIStateData uiStateData, vi1.h listScrollerApi) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uiStateData, "$uiStateData");
        Intrinsics.checkNotNullParameter(listScrollerApi, "$listScrollerApi");
        RecyclerView recyclerView = null;
        if (z16) {
            RecyclerView recyclerView2 = this$0.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            FeedDefaultItemAnimator feedDefaultItemAnimator = new FeedDefaultItemAnimator(Boolean.TRUE);
            feedDefaultItemAnimator.setAddDuration(250L);
            feedDefaultItemAnimator.setMoveDuration(250L);
            feedDefaultItemAnimator.setSupportsChangeAnimations(false);
            recyclerView.setItemAnimator(feedDefaultItemAnimator);
        } else {
            RecyclerView recyclerView3 = this$0.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setItemAnimator(null);
        }
        if (uiStateData.getPos() >= 0) {
            listScrollerApi.B1(uiStateData.getPos());
        }
        uiStateData.setPos(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(UIStateData<List<ij1.g>> uiStateData, vi1.h listScrollerApi) {
        int collectionSizeOrDefault;
        List emptyList;
        List<ij1.g> mutableList;
        if (uiStateData.getState() == 2) {
            QLog.d(this.logTag, 1, "handleNetSuccessRsp: load data from cache");
            uiStateData.setMsg("");
        }
        if (uiStateData.getData() == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
            uiStateData.setDataList(mutableList);
        }
        QLog.i(this.logTag, 1, "handleNetSuccessRsp: uiStateData.getData()" + uiStateData.getData().size());
        int num_backgournd_icon = b().getNUM_BACKGOURND_ICON();
        if (uiStateData.getIsLoadMore()) {
            GuildFeedSquareListAdapter b16 = b();
            List<ij1.g> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            List<ij1.g> list = data;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mobileqq.guild.feed.feedsquare.data.h((ij1.g) it.next()));
            }
            b16.setItems(arrayList);
        }
        F(listScrollerApi, uiStateData, num_backgournd_icon);
    }

    private final void C(List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h> readonlyList, UIStateData<List<ij1.g>> uiStateData) {
        d().getMessenger().h(new FeedSectionListPartMsgIntent.OnFeedListDifferCompleteMsgIntent(d().d(), uiStateData.isCacheData(), v(readonlyList, uiStateData)));
    }

    private final void D(UIStateData<List<ij1.g>> uiStateData, List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h> result) {
        d().getMessenger().h(new FeedSectionListPartMsgIntent.OnFeedListLoadedMsgIntent(d().d(), uiStateData.isCacheData(), v(result, uiStateData)));
    }

    private final void F(final vi1.h listUIOperationApi, final UIStateData<List<ij1.g>> uiStateData, int oldItemCount) {
        boolean z16;
        int collectionSizeOrDefault;
        List<ij1.g> data = uiStateData.getData();
        List<ij1.g> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        List<ij1.g> list2 = data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.mobileqq.guild.feed.feedsquare.data.h((ij1.g) it.next()));
        }
        if (uiStateData.getState() == 3) {
            QLog.i(this.logTag, 1, "[setDataList] handleNetSuccessRsp: isEnd[" + uiStateData.getIsFinish() + "]");
        }
        this.lockUpdateList = false;
        this.updateListWhenUnLock = false;
        b().setItems(arrayList, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.d
            @Override // java.lang.Runnable
            public final void run() {
                DefaultFeedListAdapterWorker.G(DefaultFeedListAdapterWorker.this, arrayList, uiStateData, listUIOperationApi);
            }
        });
        D(uiStateData, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final DefaultFeedListAdapterWorker this$0, List result, UIStateData uiStateData, vi1.h listUIOperationApi) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(uiStateData, "$uiStateData");
        Intrinsics.checkNotNullParameter(listUIOperationApi, "$listUIOperationApi");
        RecyclerView recyclerView = this$0.recyclerView;
        final RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(null);
        this$0.C(result, uiStateData);
        if (!uiStateData.getIsLoadMore()) {
            RecyclerView recyclerView3 = this$0.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(recyclerView2, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker$setDataList$lambda$8$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    Logger logger = Logger.f235387a;
                    str = this$0.logTag;
                    logger.d().i(str, 1, "onPreDraw id:" + System.identityHashCode(this$0));
                }
            }), "OneShotPreDrawListener.add(this) { action(this) }");
            if (uiStateData.getPos() >= 0) {
                listUIOperationApi.B1(uiStateData.getPos());
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.e
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultFeedListAdapterWorker.H();
                }
            }, 400L);
            Logger.f235387a.d().i(this$0.logTag, 1, "Guild Performance guild independent page data notify");
        }
        uiStateData.setPos(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
        VideoReport.traverseExposure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.a v(List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h> readonlyList, UIStateData<List<ij1.g>> uiStateData) {
        return new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.a(readonlyList, uiStateData.getIsFinish(), uiStateData.getIsLoadMore(), uiStateData.isLoading(), readonlyList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(UIStateData<List<ij1.g>> uiStateData) {
        b().setItems(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final UIStateData<List<ij1.g>> uiStateData, final vi1.h listScrollerApi) {
        int collectionSizeOrDefault;
        if (this.lockUpdateList) {
            Logger.f235387a.d().i(this.logTag, 1, "handleFeedChangeRsp is lockUpdateList return");
            this.updateListWhenUnLock = true;
            return;
        }
        final boolean a16 = s.a(uiStateData, UIStateDataUtils.InsertType.PublishFeed);
        if (a16) {
            this.lockUpdateList = true;
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d().getLifecycleOwner()), null, null, new DefaultFeedListAdapterWorker$handleFeedChangeRsp$2(this, null), 3, null);
        }
        uiStateData.setExtraByte(new byte[0]);
        List<ij1.g> data = uiStateData.getData();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.canScrollVertically(-1) && uiStateData.getPos() >= 0) {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setItemAnimator(null);
            listScrollerApi.B1(uiStateData.getPos());
        }
        GuildFeedSquareListAdapter b16 = b();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        List<ij1.g> list = data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.mobileqq.guild.feed.feedsquare.data.h((ij1.g) it.next()));
        }
        b16.setItems(arrayList, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.c
            @Override // java.lang.Runnable
            public final void run() {
                DefaultFeedListAdapterWorker.A(a16, this, uiStateData, listScrollerApi);
            }
        });
    }

    @Override // bk1.a.AbstractC0131a
    @NotNull
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public GuildFeedSquareListAdapter f(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(config, "config");
        GuildFeedSquareListAdapter guildFeedSquareListAdapter = new GuildFeedSquareListAdapter(new GuildFeedSquareItemDiffCallback(), config.b(yj1.d.class));
        guildFeedSquareListAdapter.setHasStableIds(true);
        return guildFeedSquareListAdapter;
    }

    @Override // bk1.a.AbstractC0131a
    @Nullable
    public a.b<GuildFeedSquareListAdapter, Object> c() {
        return new DefaultFeedListWorkerDelegate();
    }

    @Override // bk1.a.AbstractC0131a
    public void h(@NotNull final vi1.e listUIOperationApi) {
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        super.h(listUIOperationApi);
        this.observeFeedDataAction = new Function1<UIStateData<List<ij1.g>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker$work$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<ij1.g>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull UIStateData<List<ij1.g>> uiStateData) {
                String str;
                Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
                str = DefaultFeedListAdapterWorker.this.logTag;
                com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<? extends Object> d16 = DefaultFeedListAdapterWorker.this.d().d();
                int state = uiStateData.getState();
                List<ij1.g> data = uiStateData.getData();
                Integer valueOf = data != null ? Integer.valueOf(data.size()) : null;
                QLog.d(str, 1, "handlerUiStatus, section:" + d16 + " state[" + state + "], size[" + valueOf + "],  loadMore[" + uiStateData.getIsLoadMore() + "], isFinish[" + uiStateData.getIsFinish() + "], isCache[" + uiStateData.isCacheData() + "], pos: " + uiStateData.getPos());
                int state2 = uiStateData.getState();
                if (state2 == 0) {
                    DefaultFeedListAdapterWorker.this.x(uiStateData);
                    return;
                }
                if (state2 == 2 || state2 == 3) {
                    DefaultFeedListAdapterWorker.this.B(uiStateData, listUIOperationApi);
                    return;
                }
                if (state2 == 4) {
                    DefaultFeedListAdapterWorker.this.y(uiStateData);
                } else if (state2 == 6 || state2 == 7 || state2 == 8) {
                    DefaultFeedListAdapterWorker.this.z(uiStateData, listUIOperationApi);
                }
            }
        };
        MutableLiveData<UIStateData<List<ij1.g>>> j3 = d().getVmApi().j();
        LifecycleOwner lifecycleOwner = d().getLifecycleOwner();
        final Function1<UIStateData<List<ij1.g>>, Unit> function1 = new Function1<UIStateData<List<ij1.g>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker$work$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<ij1.g>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<ij1.g>> uiStateData) {
                Function1 function12;
                function12 = DefaultFeedListAdapterWorker.this.observeFeedDataAction;
                if (function12 != null) {
                    Intrinsics.checkNotNullExpressionValue(uiStateData, "uiStateData");
                    function12.invoke(uiStateData);
                }
            }
        };
        j3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DefaultFeedListAdapterWorker.I(Function1.this, obj);
            }
        });
    }

    public final void w(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(UIStateData<List<ij1.g>> uiStateData) {
    }
}
