package com.tencent.mobileqq.guild.feed.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.UiThreadUtil;
import ef1.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000bH\u0002J\u001c\u0010\u000f\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00020\u000bH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/h;", "Lcom/tencent/mobileqq/guild/feed/adapter/e;", "", "Lij1/g;", "list", "", "setDataList", "", "J0", "N0", "O0", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "L0", "Lij1/h;", "M0", "", "K0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "", "getUniqueKey", "getItemCount", "getVisible", NodeProps.VISIBLE, "S0", "K", "Z", "mIsBlockVisible", "Lcom/tencent/mobileqq/guild/feed/viewmodel/a;", "L", "Lcom/tencent/mobileqq/guild/feed/viewmodel/a;", "cacheViewModel", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "initBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;)V", "M", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends e {

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsBlockVisible;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.viewmodel.a cacheViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f217949a;

        public b(ViewModelStoreOwner viewModelStoreOwner) {
            this.f217949a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.feed.viewmodel.a(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull GuildFeedMainInitBean initBean) {
        super(initBean, 0);
        Intrinsics.checkNotNullParameter(initBean, "initBean");
    }

    private final boolean J0() {
        RecyclerView recyclerView;
        String guildId = this.F.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "mInitBean.guildId");
        String channelId = this.F.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "mInitBean.channelId");
        d d16 = gn1.a.d(guildId, channelId);
        NestScrollRecyclerView nestScrollRecyclerView = null;
        if (d16 != null) {
            recyclerView = d16.i();
        } else {
            recyclerView = null;
        }
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null) {
            nestScrollRecyclerView = blockContainer.getRecyclerView();
        }
        if (recyclerView == nestScrollRecyclerView) {
            return true;
        }
        return false;
    }

    private final void L0(UIStateData<List<ij1.g>> uiStateData) {
        boolean z16 = true;
        Logger.f235387a.d().d("GuildFeedListCacheAdapter", 1, "[handleCacheFeedListUIState] receive list state " + uiStateData.getState());
        if (uiStateData.getData() == null || !(!r0.isEmpty())) {
            z16 = false;
        }
        if (z16 && uiStateData.isCacheData()) {
            List<ij1.g> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            setDataList(data);
        }
    }

    private final void M0(UIStateData<List<ij1.h>> uiStateData) {
        GuildFeedListViewModel guildFeedListViewModel;
        boolean z16 = true;
        Logger.f235387a.d().d("GuildFeedListCacheAdapter", 1, "[handleCacheFeedTopUIState] receive top state " + uiStateData.getState());
        if (uiStateData.getData() == null || !(!r0.isEmpty())) {
            z16 = false;
        }
        if (z16 && uiStateData.isCacheData()) {
            ViewModel viewModel = getViewModel(GuildFeedListViewModel.class);
            MutableLiveData<UIStateData<List<ij1.h>>> mutableLiveData = null;
            if (viewModel instanceof GuildFeedListViewModel) {
                guildFeedListViewModel = (GuildFeedListViewModel) viewModel;
            } else {
                guildFeedListViewModel = null;
            }
            if (guildFeedListViewModel != null) {
                mutableLiveData = guildFeedListViewModel.Z1();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(uiStateData.copy());
            }
        }
    }

    private final void N0() {
        Logger.f235387a.d().d("GuildFeedListCacheAdapter", 1, "[initAsyncViewCacheAndPool]");
        getBlockContainer().getRecyclerView().setRecycledViewPool(GuildFeedCacheRecycleViewPool.INSTANCE.a());
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        String guildId = this.F.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "mInitBean.guildId");
        String channelId = this.F.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "mInitBean.channelId");
        recyclerView.setViewCacheExtension(gn1.a.d(guildId, channelId));
    }

    private final void O0() {
        QBaseActivity qBaseActivity;
        Logger.f235387a.d().d("GuildFeedListCacheAdapter", 1, "[initCacheViewModel] activity " + getActivity());
        Activity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(qBaseActivity, new b(qBaseActivity)).get(com.tencent.mobileqq.guild.feed.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        com.tencent.mobileqq.guild.feed.viewmodel.a aVar = (com.tencent.mobileqq.guild.feed.viewmodel.a) viewModel;
        aVar.r2(this.F);
        MutableLiveData<UIStateData<List<ij1.g>>> feedData = aVar.j();
        Intrinsics.checkNotNullExpressionValue(feedData, "feedData");
        gn1.b.a(feedData, qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.guild.feed.adapter.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.Q0(h.this, (UIStateData) obj);
            }
        });
        MutableLiveData<UIStateData<List<ij1.h>>> feedTopData = aVar.Z1();
        Intrinsics.checkNotNullExpressionValue(feedTopData, "feedTopData");
        gn1.b.a(feedTopData, qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.guild.feed.adapter.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.R0(h.this, (UIStateData) obj);
            }
        });
        this.cacheViewModel = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(h this$0, UIStateData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.L0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(h this$0, UIStateData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.M0(it);
    }

    private final void setDataList(List<? extends ij1.g> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list.subList(0, Math.min(4, list.size())));
        getBlockMerger().notifyItemRangeInserted(getGlobalPosition(0), this.mDataList.size());
    }

    @Nullable
    protected Void K0() {
        return null;
    }

    public final void S0(boolean visible) {
        boolean z16;
        NestScrollRecyclerView recyclerView;
        if (visible == this.mIsBlockVisible) {
            return;
        }
        if (visible && J0()) {
            N0();
            O0();
            z16 = true;
        } else {
            BlockContainer blockContainer = getBlockContainer();
            if (blockContainer != null && (recyclerView = blockContainer.getRecyclerView()) != null) {
                recyclerView.setViewCacheExtension(null);
            }
            String guildId = this.F.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "mInitBean.guildId");
            String channelId = this.F.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "mInitBean.channelId");
            gn1.a.a(guildId, channelId);
            Collection mDataList = this.mDataList;
            Intrinsics.checkNotNullExpressionValue(mDataList, "mDataList");
            if (!mDataList.isEmpty()) {
                getBlockMerger().notifyItemRangeRemoved(getGlobalPosition(0), this.mDataList.size());
            }
            z16 = false;
        }
        this.mIsBlockVisible = z16;
        Logger.f235387a.d().d("GuildFeedListCacheAdapter", 1, "visible " + this.mIsBlockVisible + "  globalPos: " + getGlobalPosition(0));
    }

    @Override // com.tencent.mobileqq.guild.feed.adapter.c, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ DiffUtil.ItemCallback getDiffCallBack() {
        return (DiffUtil.ItemCallback) K0();
    }

    @Override // com.tencent.mobileqq.guild.feed.adapter.e, com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (this.mIsBlockVisible) {
            return this.mDataList.size();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.adapter.e, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int itemViewType = super.getItemViewType(position) + 1000;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedListCacheAdapter", 2, "[getItemViewType], offsetViewType: " + itemViewType + ", position " + position + " ! ");
        }
        return itemViewType;
    }

    @Override // com.tencent.mobileqq.guild.feed.adapter.e, com.tencent.biz.richframework.part.block.MultiViewBlock
    @NotNull
    public String getUniqueKey() {
        return "guild_cache_adapter_unique_key";
    }

    /* renamed from: getVisible, reason: from getter */
    public final boolean getMIsBlockVisible() {
        return this.mIsBlockVisible;
    }

    @Override // com.tencent.mobileqq.guild.feed.adapter.e, androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (UiThreadUtil.isOnUiThread()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[onCreateViewHolder], viewType: " + viewType + "  run on UiThread! ";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedListCacheAdapter", 1, (String) it.next(), null);
            }
        }
        RecyclerView.ViewHolder onCreateViewHolder = super.onCreateViewHolder(parent, viewType - 1000);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder\u2026e.CACHE_ITEM_TYPE_OFFSET)");
        return onCreateViewHolder;
    }

    @Override // com.tencent.mobileqq.guild.feed.adapter.e, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
