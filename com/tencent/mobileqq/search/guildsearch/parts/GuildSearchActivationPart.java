package com.tencent.mobileqq.search.guildsearch.parts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.guildsearch.GuildSearchEntryViewModel;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryItemDelegate;
import com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryTipsItemDelegate;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u000b*\u0002\u001f#\u0018\u0000 )2\u00020\u0001:\u0006*+,\u0014\u0018\u001cB\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "C9", "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$c;", "e", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$c;", "entryListAdapter", "Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel;", "f", "Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel;", "viewModel", "com/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$h", tl.h.F, "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$h;", "scrollListener", "com/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$g", "i", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$g;", "listController", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "c", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildSearchActivationPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c entryListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildSearchEntryViewModel viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h scrollListener = new h();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g listController = new g();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$b;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends AdapterDelegatesManager<List<? extends ListBaseData>> {
        public b() {
            addDelegate(new SearchHistoryItemDelegate());
            addDelegate(new SearchHistoryTipsItemDelegate());
            addDelegate(new com.tencent.mobileqq.search.guildsearch.activation.delegate.e());
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$c;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$f;", "diffCallback", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$b;", "delegatesManager", "<init>", "(Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$f;Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$b;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends AsyncListDifferDelegationAdapter<ListBaseData> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull f diffCallback, @NotNull b delegatesManager) {
            super(diffCallback, delegatesManager);
            Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
            Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
        }

        @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onBindViewHolder(holder, position);
        }

        @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            RecyclerView.ViewHolder onCreateViewHolder = super.onCreateViewHolder(parent, viewType);
            Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
            return onCreateViewHolder;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$d;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "topMargin", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int topMargin = ViewUtils.dip2px(16.0f);

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getAdapter() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, this.topMargin, 0, 0);
            view.setLayoutParams(layoutParams2);
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "d", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "a", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface e {
        void a(@NotNull ListBaseData.ShowAllHistoryData item);

        void b(@NotNull ListBaseData.OperationHotSearchItemData item);

        void c(@NotNull ListBaseData.SearchHistoryData item);

        void d(@NotNull ListBaseData.SearchHistoryData item);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$f;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "p0", "p1", "", "b", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends DiffUtil.ItemCallback<ListBaseData> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull ListBaseData p06, @NotNull ListBaseData p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull ListBaseData p06, @NotNull ListBaseData p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06.c(), p16.c());
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$g", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "d", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "a", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g implements e {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(GuildSearchActivationPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.broadcastMessage("scroll_to_top", "onHistoryItemClick");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(GuildSearchActivationPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.broadcastMessage("scroll_to_top", "onOperationHotItemClick");
        }

        @Override // com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart.e
        public void a(@NotNull ListBaseData.ShowAllHistoryData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            GuildSearchEntryViewModel guildSearchEntryViewModel = null;
            if (item.getDataType() == 3) {
                GuildSearchEntryViewModel guildSearchEntryViewModel2 = GuildSearchActivationPart.this.viewModel;
                if (guildSearchEntryViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    guildSearchEntryViewModel = guildSearchEntryViewModel2;
                }
                guildSearchEntryViewModel.d2(1);
                return;
            }
            GuildSearchEntryViewModel guildSearchEntryViewModel3 = GuildSearchActivationPart.this.viewModel;
            if (guildSearchEntryViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildSearchEntryViewModel3 = null;
            }
            guildSearchEntryViewModel3.a2();
            GuildSearchEntryViewModel guildSearchEntryViewModel4 = GuildSearchActivationPart.this.viewModel;
            if (guildSearchEntryViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildSearchEntryViewModel = guildSearchEntryViewModel4;
            }
            guildSearchEntryViewModel.d2(0);
        }

        @Override // com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart.e
        public void b(@NotNull ListBaseData.OperationHotSearchItemData item) {
            String str;
            Intrinsics.checkNotNullParameter(item, "item");
            String word = item.getWord();
            if (word == null) {
                str = "";
            } else {
                str = word;
            }
            SearchDetailFragment.Companion.NetSearchPageParam netSearchPageParam = new SearchDetailFragment.Companion.NetSearchPageParam(str, "", 29, 13, false, 3L, "", System.currentTimeMillis(), "", null, null, 0, 3584, null);
            SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
            Context context = GuildSearchActivationPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.d(context, netSearchPageParam, "");
            final GuildSearchActivationPart guildSearchActivationPart = GuildSearchActivationPart.this;
            C11736d.b(50, new Runnable() { // from class: com.tencent.mobileqq.search.guildsearch.parts.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildSearchActivationPart.g.h(GuildSearchActivationPart.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart.e
        public void c(@NotNull ListBaseData.SearchHistoryData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            SearchDetailFragment.Companion.NetSearchPageParam netSearchPageParam = new SearchDetailFragment.Companion.NetSearchPageParam(item.getKeyWord(), "", 28, 13, false, 3L, "", System.currentTimeMillis(), "", null, null, 0, 3584, null);
            SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
            Context context = GuildSearchActivationPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.d(context, netSearchPageParam, "");
            final GuildSearchActivationPart guildSearchActivationPart = GuildSearchActivationPart.this;
            C11736d.b(50, new Runnable() { // from class: com.tencent.mobileqq.search.guildsearch.parts.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildSearchActivationPart.g.g(GuildSearchActivationPart.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart.e
        public void d(@NotNull ListBaseData.SearchHistoryData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            GuildSearchEntryViewModel guildSearchEntryViewModel = GuildSearchActivationPart.this.viewModel;
            if (guildSearchEntryViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildSearchEntryViewModel = null;
            }
            guildSearchEntryViewModel.b2(item);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$h", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "d", "I", "currentScrollState", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class h extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int currentScrollState;

        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            int i3 = this.currentScrollState;
            if (i3 != newState && i3 == 1) {
                GuildSearchActivationPart.this.broadcastMessage("MESSAGE_ON_LIST_SCROLL", Integer.valueOf(i3));
            }
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
            this.currentScrollState = newState;
        }
    }

    private final void C9(View rootView) {
        View findViewById = rootView.findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.list)");
        this.recyclerView = (RecyclerView) findViewById;
        this.entryListAdapter = new c(new f(), new b());
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        c cVar = this.entryListAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryListAdapter");
            cVar = null;
        }
        recyclerView3.setAdapter(cVar);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setHasFixedSize(true);
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView6 = null;
        }
        recyclerView6.addItemDecoration(new d());
        RecyclerView recyclerView7 = this.recyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView7 = null;
        }
        recyclerView7.addOnScrollListener(this.scrollListener);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView8 = this.recyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView8;
        }
        g16.registerIoc(recyclerView2, this.listController, e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "scroll_to_top")) {
            Logger.f235387a.d().i("QQSearch.Local.Guild.GuildSearchActivationPart", 1, "receive message " + args);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        C9(rootView);
        ViewModel viewModel = getViewModel("GuildSearchEntryViewModel", GuildSearchEntryViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(\"GuildSearc\u2026tryViewModel::class.java)");
        GuildSearchEntryViewModel guildSearchEntryViewModel = (GuildSearchEntryViewModel) viewModel;
        this.viewModel = guildSearchEntryViewModel;
        GuildSearchEntryViewModel guildSearchEntryViewModel2 = null;
        if (guildSearchEntryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSearchEntryViewModel = null;
        }
        guildSearchEntryViewModel.W1();
        GuildSearchEntryViewModel guildSearchEntryViewModel3 = this.viewModel;
        if (guildSearchEntryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildSearchEntryViewModel2 = guildSearchEntryViewModel3;
        }
        MediatorLiveData<List<ListBaseData>> T1 = guildSearchEntryViewModel2.T1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final GuildSearchActivationPart$onInitView$1 guildSearchActivationPart$onInitView$1 = new GuildSearchActivationPart$onInitView$1(this);
        T1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.guildsearch.parts.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSearchActivationPart.D9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        g16.unregisterSingleIoc(recyclerView, e.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        GuildSearchEntryViewModel guildSearchEntryViewModel = this.viewModel;
        if (guildSearchEntryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSearchEntryViewModel = null;
        }
        guildSearchEntryViewModel.Z1();
    }
}
