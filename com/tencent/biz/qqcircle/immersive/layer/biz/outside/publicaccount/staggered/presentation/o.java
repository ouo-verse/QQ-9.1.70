package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.QFSPublicAccountFollowUsersManager;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder.QFSPublicAccountStaggeredItemViewFactory;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 D2\u00020\u0001:\u0003EFGB\u0019\u0012\b\u00105\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 J-\u0010*\u001a\u00020\f2%\u0010)\u001a!\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001d0#j\u0002`(J\u0016\u0010-\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+H\u0016J \u0010/\u001a\u00020\f2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010.2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0014\u00100\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+J\b\u00102\u001a\u000201H\u0014R\u0016\u00105\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006H"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o;", "Lcom/tencent/biz/qqcircle/adapter/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "y0", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "z0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateItemViewHolder", "", "onViewAttachedToWindow", "position", "onBindViewHolder", "localPos", "getSpanCount", "getItemCount", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "getViewTypeCount", "getItemViewType", "", "getLogTag", "", "forceRefresh", "x0", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o$b;", "listener", "F0", "Lkotlin/Function1;", "Le30/b;", "Lkotlin/ParameterName;", "name", "feedBlockData", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/Predicate;", "predicate", "B0", "", "list", "setDatas", "", "insertData", "E0", "Lcom/tencent/biz/qqcircle/scrollers/a;", "l0", "G", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "H", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "getOperator", "()Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "I", "Z", "isAutoRefreshing", "J", "Ljava/lang/String;", "autoPlayFeedId", "<init>", "(Landroid/os/Bundle;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "K", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class o extends com.tencent.biz.qqcircle.adapter.e {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int L = ImmersiveUtils.dpToPx(8.0f);

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final Bundle arguments;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final a operator;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isAutoRefreshing;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final String autoPlayFeedId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o$a;", "", "", "a", "spanSpacePx", "I", "b", "()I", "getSpanSpacePx$annotations", "()V", "<init>", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return (DisplayUtil.getScreenWidth() - (b() * 3)) / 2;
        }

        public final int b() {
            return o.L;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o$b;", "", "", ReportConstant.COSTREPORT_PREFIX, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, ICustomDataEditor.STRING_PARAM_9, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void onRefresh();

        void s();

        void s9();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "E", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "l", "()Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "staggeredItemView", "<init>", "(Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QCircleBaseWidgetView<e30.b> staggeredItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull QCircleBaseWidgetView<e30.b> staggeredItemView) {
            super(staggeredItemView);
            Intrinsics.checkNotNullParameter(staggeredItemView, "staggeredItemView");
            this.staggeredItemView = staggeredItemView;
        }

        @NotNull
        public final QCircleBaseWidgetView<e30.b> l() {
            return this.staggeredItemView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@Nullable Bundle bundle, @NotNull a operator) {
        super(bundle);
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.arguments = bundle;
        this.operator = operator;
        this.autoPlayFeedId = ((IQCirclePublicAccountMessageService) QCircleServiceImpl.getAppInterface().getRuntimeService(IQCirclePublicAccountMessageService.class, "")).getAutoPlayFeedId();
    }

    public static final int A0() {
        return INSTANCE.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(final o this$0, Function1 predicate) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(predicate, "$predicate");
        List dataList = this$0.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            e30.b it = (e30.b) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!((Boolean) predicate.invoke(it)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        List dataList2 = this$0.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList2, "dataList");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : dataList2) {
            e30.b it5 = (e30.b) obj2;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (((Boolean) predicate.invoke(it5)).booleanValue()) {
                arrayList2.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        final ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            arrayList3.add(((e30.b) it6.next()).g().f398449id.get());
        }
        this$0.setDatas(arrayList);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.n
            @Override // java.lang.Runnable
            public final void run() {
                o.D0(o.this, arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(o this$0, List removedIdList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(removedIdList, "$removedIdList");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.c.INSTANCE.a(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.c(this$0.z0())).h(removedIdList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(o this$0, b listener, LoadInfo loadInfo, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (this$0.getLoadInfo().isLoadMoreState()) {
            listener.s();
            return;
        }
        if (this$0.getLoadInfo().isRefreshState()) {
            if (this$0.isAutoRefreshing) {
                this$0.isAutoRefreshing = false;
                listener.s9();
            } else {
                listener.onRefresh();
            }
        }
    }

    private final int y0(RecyclerView.ViewHolder holder) {
        if (QFSPublicAccountFollowUsersManager.f86913a.h()) {
            return holder.getItemViewType() - getViewTypeOffsetStart();
        }
        return holder.getItemViewType();
    }

    private final QCircleInitBean z0() {
        Serializable serializable;
        Bundle bundle = this.arguments;
        QCircleInitBean qCircleInitBean = null;
        if (bundle != null) {
            serializable = bundle.getSerializable("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializable;
        }
        if (qCircleInitBean == null) {
            return new QCircleInitBean();
        }
        return qCircleInitBean;
    }

    public final void B0(@NotNull final Function1<? super e30.b, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.l
            @Override // java.lang.Runnable
            public final void run() {
                o.C0(o.this, predicate);
            }
        });
    }

    public final void E0(@NotNull List<e30.b> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        setDatas(list);
        p0();
    }

    public final void F0(@NotNull final b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.m
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                o.H0(o.this, listener, loadInfo, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        FeedCloudMeta$StFeed feed = e30.b.h(getDataList().get(position));
        QFSPublicAccountStaggeredItemViewFactory qFSPublicAccountStaggeredItemViewFactory = QFSPublicAccountStaggeredItemViewFactory.f87123a;
        Intrinsics.checkNotNullExpressionValue(feed, "feed");
        return qFSPublicAccountStaggeredItemViewFactory.a(position, feed, Intrinsics.areEqual(feed.f398449id.get(), this.autoPlayFeedId), com.tencent.biz.qqcircle.immersive.feed.ad.u.h(new GdtAd(com.tencent.biz.qqcircle.immersive.feed.ad.u.e(getDataList().get(position))))).getType();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    protected String getLogTag() {
        return "QFSPublicAccountStaggerAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getSpanCount(int localPos) {
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return QFSPublicAccountStaggeredItemViewFactory.f87123a.c();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void insertData(@Nullable List<e30.b> list, int position) {
        boolean z16;
        List<e30.b> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        for (e30.b bVar : list) {
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.o oVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.o.f86859a;
            String str = bVar.g().f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.sourceData.id.get()");
            oVar.b(str);
        }
        if (position > this.mDataList.size()) {
            this.mDataList.addAll(list2);
        } else {
            this.mDataList.addAll(position, list2);
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.biz.qqcircle.adapter.e
    @NotNull
    protected com.tencent.biz.qqcircle.scrollers.a l0() {
        return new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.p(z0());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ((c) holder).l().setData(getDataList().get(position), position);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new c(QFSPublicAccountStaggeredItemViewFactory.f87123a.b(parent, viewType, this.operator, z0()));
    }

    @Override // com.tencent.biz.qqcircle.adapter.e, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        QCircleBaseWidgetView<e30.b> l3 = ((c) holder).l();
        int y06 = y0(holder);
        ViewGroup.LayoutParams layoutParams2 = l3.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            if (y06 != QFSPublicAccountStaggeredItemViewFactory.ItemType.AUTO_PLAY_VIDEO.getType() && y06 != QFSPublicAccountStaggeredItemViewFactory.ItemType.MASK_AD.getType()) {
                z16 = false;
            } else {
                z16 = true;
            }
            layoutParams.setFullSpan(z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(@NotNull List<e30.b> list) {
        aa aaVar;
        Intrinsics.checkNotNullParameter(list, "list");
        super.setDatas(list);
        BlockMerger blockMerger = getBlockMerger();
        if (blockMerger instanceof aa) {
            aaVar = (aa) blockMerger;
        } else {
            aaVar = null;
        }
        if (aaVar != null) {
            aaVar.k0();
        }
    }

    public final void x0(boolean forceRefresh) {
        this.isAutoRefreshing = !forceRefresh;
        getBlockMerger().onRefreshWithAnim();
        getBlockMerger().setRefreshing(true);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
