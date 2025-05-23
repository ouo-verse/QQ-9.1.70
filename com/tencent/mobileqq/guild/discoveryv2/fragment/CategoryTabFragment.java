package com.tencent.mobileqq.guild.discoveryv2.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.adapters.GuildSubTabFragmentAdapter;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.model.CategoryTabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019B\t\b\u0016\u00a2\u0006\u0004\b\u0018\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/CategoryTabFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getTabId", "getContentLayoutId", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "assembleParts", "", "needStatusTrans", "needImmersive", "isWrapContent", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", "miscPart", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/CategoryTabViewModel;", "D", "Lkotlin/Lazy;", "lazyVM", "E", "Ljava/util/List;", "parts", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;)V", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CategoryTabFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TabMisc miscPart;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy<List<CategoryTabViewModel>> lazyVM;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<MVPFeedsPart> parts;

    CategoryTabFragment(TabMisc tabMisc) {
        Lazy<List<CategoryTabViewModel>> lazy;
        List<MVPFeedsPart> listOf;
        this.miscPart = tabMisc;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends CategoryTabViewModel>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.CategoryTabFragment$lazyVM$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f217420a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ CategoryTabFragment f217421b;

                public a(ViewModelStoreOwner viewModelStoreOwner, CategoryTabFragment categoryTabFragment) {
                    this.f217420a = viewModelStoreOwner;
                    this.f217421b = categoryTabFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    int tabId;
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                    tabId = this.f217421b.getTabId();
                    TimedValue timedValue = new TimedValue(new CategoryTabViewModel(tabId), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends CategoryTabViewModel> invoke() {
                List<? extends CategoryTabViewModel> listOf2;
                ViewModelStoreOwner viewModelStoreOwner = (TabViewModel) PartFragmentIOCKt.getIocInterface(CategoryTabFragment.this, TabViewModel.class);
                if (viewModelStoreOwner == null) {
                    viewModelStoreOwner = CategoryTabFragment.this;
                }
                Logger.f235387a.d().i("CategoryTabFragment", 1, "vmInit store: " + viewModelStoreOwner);
                TabViewModel.Companion companion = TabViewModel.INSTANCE;
                c.Companion companion2 = ef1.c.INSTANCE;
                ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner, CategoryTabFragment.this)).get(CategoryTabViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(companion.b((BaseFeedViewModel) viewModel, viewModelStoreOwner));
                return listOf2;
            }
        });
        this.lazyVM = lazy;
        int i3 = 0;
        int i16 = 1;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MVPFeedsPart[]{tabMisc, new RefreshPart(g.c()), new com.tencent.mobileqq.guild.discoveryv2.content.part.c(), new ContentPart(g.c(), null, 2, 0 == true ? 1 : 0), new com.tencent.mobileqq.guild.discoveryv2.tips.c(i3, i16, 0 == true ? 1 : 0), new PreloadMoreStrategyPart(), new com.tencent.mobileqq.guild.discoveryv2.content.part.f(lazy), new com.tencent.mobileqq.guild.discoveryv2.content.part.e(i3, i16, 0 == true ? 1 : 0)});
        this.parts = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTabId() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        GuildSubTabFragmentAdapter.SubTabData subTabData = null;
        if (arguments.containsKey("subTabData")) {
            Parcelable parcelable = arguments.getParcelable("subTabData");
            if (parcelable instanceof GuildSubTabFragmentAdapter.SubTabData) {
                subTabData = (GuildSubTabFragmentAdapter.SubTabData) parcelable;
            }
        }
        Logger.f235387a.d().d("CategoryTabFragment", 1, "[getTabId] subTabData " + subTabData);
        if (subTabData != null) {
            return subTabData.getTabId();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<MVPFeedsPart> assembleParts() {
        return this.parts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ekx;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    public CategoryTabFragment() {
        this(new TabMisc());
    }
}
