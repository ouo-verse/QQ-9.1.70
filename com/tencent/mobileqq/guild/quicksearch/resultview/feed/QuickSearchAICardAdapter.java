package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.SSESearchConfig;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSAIViewHolder;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0013\u001a\u00020\u0005R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR'\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00030 j\b\u0012\u0004\u0012\u00020\u0003`!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchAICardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAIViewHolder;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "aiSearchInfo", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "getItemCount", "holder", "position", "m0", "getItemViewType", "o0", "p0", "l0", "Lcom/tencent/biz/richframework/part/Part;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/part/Part;", "k0", "()Lcom/tencent/biz/richframework/part/Part;", "part", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "j0", "()Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchViewModel;", "aiSearchViewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataList", "Lmqq/util/WeakReference;", "E", "Lmqq/util/WeakReference;", "weakHolderRef", "<init>", "(Lcom/tencent/biz/richframework/part/Part;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchAICardAdapter extends RecyclerView.Adapter<DSAIViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiSearchViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<IGProGuildSearchAISearchInfo> dataList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WeakReference<DSAIViewHolder> weakHolderRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Part part;

    public QuickSearchAICardAdapter(@NotNull Part part) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(part, "part");
        this.part = part;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DSSearchViewModel>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchAICardAdapter$aiSearchViewModel$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f231730a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f231730a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new DSSearchViewModel(new SSESearchConfig("https://qun.qq.com/qunng/sse/guildsearch/ai/v1/getaicontent", "UVHpopHpgZPlhoXmkJzntKI=", "IN_ONE_GUILD")), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DSSearchViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                Fragment hostFragment = QuickSearchAICardAdapter.this.getPart().getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "part.hostFragment");
                ViewModel viewModel = new ViewModelProvider(hostFragment, new a(hostFragment)).get(DSSearchViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (DSSearchViewModel) viewModel;
            }
        });
        this.aiSearchViewModel = lazy;
        this.dataList = new ArrayList<>();
    }

    private final void i0(IGProGuildSearchAISearchInfo aiSearchInfo) {
        boolean z16;
        if (aiSearchInfo != null) {
            String searchKey = aiSearchInfo.getSearchKey();
            Intrinsics.checkNotNullExpressionValue(searchKey, "aiSearchInfo.searchKey");
            if (searchKey.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.dataList.clear();
                this.dataList.add(aiSearchInfo);
                j0().e2(aiSearchInfo);
                return;
            }
        }
        this.dataList.clear();
        j0().d2();
    }

    private final DSSearchViewModel j0() {
        return (DSSearchViewModel) this.aiSearchViewModel.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 101;
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final Part getPart() {
        return this.part;
    }

    public final void l0() {
        DSAIViewHolder dSAIViewHolder;
        WeakReference<DSAIViewHolder> weakReference = this.weakHolderRef;
        if (weakReference != null && (dSAIViewHolder = weakReference.get()) != null) {
            dSAIViewHolder.h();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull DSAIViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(iGProGuildSearchAISearchInfo, "dataList[position]");
        holder.J(iGProGuildSearchAISearchInfo, j0(), com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this.part));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public DSAIViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eqi, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        DSAIViewHolder dSAIViewHolder = new DSAIViewHolder(view);
        dSAIViewHolder.P(view);
        return dSAIViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull DSAIViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.weakHolderRef = new WeakReference<>(holder);
    }

    public final void p0(@Nullable IGProGuildSearchAISearchInfo aiSearchInfo) {
        i0(aiSearchInfo);
        notifyDataSetChanged();
    }
}
