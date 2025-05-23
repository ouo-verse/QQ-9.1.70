package com.tencent.mobileqq.guild.discoveryv2.fragment;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart;
import com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
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
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016B\t\b\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/MyTabFeedsFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needStatusTrans", "needImmersive", "isWrapContent", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/MyTabViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "lazyVM", "D", "Ljava/util/List;", "parts", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", "miscPart", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;)V", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyTabFeedsFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy<List<MyTabViewModel>> lazyVM;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<Part> parts;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/fragment/MyTabFeedsFragment$b", "Lcom/tencent/biz/richframework/part/Part;", "", "action", "", "args", "", "handleBroadcastMessage", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends Part {
        b() {
        }

        @Override // com.tencent.biz.richframework.part.Part
        public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
            if (Intrinsics.areEqual(action, "message_scroll_to_top_position") && (args instanceof ContentMessage.ScrollToPositionMessage)) {
                SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent) args);
            }
        }
    }

    MyTabFeedsFragment(TabMisc tabMisc) {
        Lazy<List<MyTabViewModel>> lazy;
        List<Part> listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends MyTabViewModel>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.MyTabFeedsFragment$lazyVM$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f217425a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f217425a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new MyTabViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
            public final List<? extends MyTabViewModel> invoke() {
                List<? extends MyTabViewModel> listOf2;
                ViewModelStoreOwner viewModelStoreOwner = (TabViewModel) PartFragmentIOCKt.getIocInterface(MyTabFeedsFragment.this, TabViewModel.class);
                if (viewModelStoreOwner == null) {
                    viewModelStoreOwner = MyTabFeedsFragment.this;
                }
                Logger.f235387a.d().i("MyTabFeedsFragment", 1, "vmInit store: " + viewModelStoreOwner);
                c.Companion companion = ef1.c.INSTANCE;
                ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner)).get(MyTabViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                MyTabViewModel myTabViewModel = (MyTabViewModel) viewModel;
                if (viewModelStoreOwner instanceof TabViewModel) {
                    ((TabViewModel) viewModelStoreOwner).P1(myTabViewModel.T1());
                }
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(myTabViewModel);
                return listOf2;
            }
        });
        this.lazyVM = lazy;
        int i3 = 0;
        int i16 = 1;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{tabMisc, new RefreshPart(g.c()), new com.tencent.mobileqq.guild.discoveryv2.content.part.c(), new ContentPart(g.c(), null, 2, 0 == true ? 1 : 0), new com.tencent.mobileqq.guild.discoveryv2.tips.c(i3, i16, 0 == true ? 1 : 0), new PreloadMoreStrategyPart(), new com.tencent.mobileqq.guild.discoveryv2.content.part.f(lazy), new b(), new com.tencent.mobileqq.guild.discoveryv2.content.part.e(i3, i16, 0 == true ? 1 : 0)});
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

    public MyTabFeedsFragment() {
        this(new TabMisc());
    }
}
