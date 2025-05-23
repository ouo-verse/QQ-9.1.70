package com.tencent.mobileqq.guild.discoveryv2.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendTabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart;
import com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.argus.node.ArgusTag;
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
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fB\t\b\u0016\u00a2\u0006\u0004\b\u001e\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/RecommendTabFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needStatusTrans", "needImmersive", "isWrapContent", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", "miscPart", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/RecommendTabViewModel;", "D", "Lkotlin/Lazy;", "lazyVM", "E", "Ljava/util/List;", "parts", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;)V", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendTabFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TabMisc miscPart;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy<List<RecommendTabViewModel>> lazyVM;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<Part> parts;

    RecommendTabFragment(TabMisc tabMisc) {
        Lazy<List<RecommendTabViewModel>> lazy;
        List<Part> listOf;
        this.miscPart = tabMisc;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends RecommendTabViewModel>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.RecommendTabFragment$lazyVM$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f217426a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f217426a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new RecommendTabViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
            public final List<? extends RecommendTabViewModel> invoke() {
                List<? extends RecommendTabViewModel> listOf2;
                ViewModelStoreOwner viewModelStoreOwner = (TabViewModel) PartFragmentIOCKt.getIocInterface(RecommendTabFragment.this, TabViewModel.class);
                if (viewModelStoreOwner == null) {
                    viewModelStoreOwner = RecommendTabFragment.this;
                }
                Logger.f235387a.d().i("RecommendTabFragment", 1, "vmInit store: " + viewModelStoreOwner);
                c.Companion companion = ef1.c.INSTANCE;
                ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner)).get(RecommendTabViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                RecommendTabViewModel recommendTabViewModel = (RecommendTabViewModel) viewModel;
                if (viewModelStoreOwner instanceof TabViewModel) {
                    ((TabViewModel) viewModelStoreOwner).P1(recommendTabViewModel.T1());
                }
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(recommendTabViewModel);
                return listOf2;
            }
        });
        this.lazyVM = lazy;
        int i3 = 0;
        int i16 = 1;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{tabMisc, new RefreshPart(g.c()), new com.tencent.mobileqq.guild.discoveryv2.content.part.c(), new ContentPart(g.c(), null, 2, 0 == true ? 1 : 0), new com.tencent.mobileqq.guild.discoveryv2.tips.c(i3, i16, 0 == true ? 1 : 0), new PreloadMoreStrategyPart(), new com.tencent.mobileqq.guild.discoveryv2.content.part.f(lazy), new com.tencent.mobileqq.guild.discoveryv2.content.part.e(i3, i16, 0 == true ? 1 : 0), ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).newGuildFeedFloatCommentContainerPart(17)});
        this.parts = listOf;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        uh1.a.f438959a.d("tabFragment AfterPartInit");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        uh1.a.f438959a.d("tabFragment BeforePartInit");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
    }

    public RecommendTabFragment() {
        this(new TabMisc());
    }
}
