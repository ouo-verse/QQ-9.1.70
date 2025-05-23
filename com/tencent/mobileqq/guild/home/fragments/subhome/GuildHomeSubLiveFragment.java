package com.tencent.mobileqq.guild.home.fragments.subhome;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.home.parts.GuildHomeContentLivePart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeCreateLivePart;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.argus.node.ArgusTag;
import ef1.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
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
@ArgusTag(testConfigKey = "Argus_Guild_Home_Live", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubLiveFragment;", "Lcom/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedAfterPartInit", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onPostThemeChanged", "", "sh", "Lcom/tencent/mobileqq/guild/home/subhome/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/subhome/e;", "activeChannelViewModel", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart;", "G", "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeContentLivePart;", "guildHomeContentLivePart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeCreateLivePart;", "H", "yh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeCreateLivePart;", "guildHomeCreateLivePart", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubLiveFragment extends GuildHomeSubBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.home.subhome.e activeChannelViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeContentLivePart;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeCreateLivePart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f224842a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeSubLiveFragment f224843b;

        public b(ViewModelStoreOwner viewModelStoreOwner, GuildHomeSubLiveFragment guildHomeSubLiveFragment) {
            this.f224842a = viewModelStoreOwner;
            this.f224843b = guildHomeSubLiveFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            long j3;
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f224843b.qh().f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            Bundle arguments = this.f224843b.getArguments();
            if (arguments != null) {
                j3 = arguments.getLong("EXTRA_CATEGORY_ID");
            } else {
                j3 = 0;
            }
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.home.subhome.e(str, j3, this.f224843b.qh(), this.f224843b.rh().getGuildHomePermissionViewModel()), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public GuildHomeSubLiveFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeContentLivePart>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubLiveFragment$guildHomeContentLivePart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeContentLivePart invoke() {
                com.tencent.mobileqq.guild.home.subhome.e eVar;
                Bundle arguments = GuildHomeSubLiveFragment.this.getArguments();
                long j3 = arguments != null ? arguments.getLong("EXTRA_CATEGORY_ID") : 0L;
                FacadeArgsData qh5 = GuildHomeSubLiveFragment.this.qh();
                eVar = GuildHomeSubLiveFragment.this.activeChannelViewModel;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activeChannelViewModel");
                    eVar = null;
                }
                return new GuildHomeContentLivePart(j3, qh5, eVar, GuildHomeSubLiveFragment.this.th());
            }
        });
        this.guildHomeContentLivePart = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeCreateLivePart>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubLiveFragment$guildHomeCreateLivePart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeCreateLivePart invoke() {
                com.tencent.mobileqq.guild.home.subhome.e eVar;
                FacadeArgsData qh5 = GuildHomeSubLiveFragment.this.qh();
                eVar = GuildHomeSubLiveFragment.this.activeChannelViewModel;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activeChannelViewModel");
                    eVar = null;
                }
                return new GuildHomeCreateLivePart(qh5, eVar, GuildHomeSubLiveFragment.this.rh());
            }
        });
        this.guildHomeCreateLivePart = lazy2;
    }

    private final GuildHomeContentLivePart xh() {
        return (GuildHomeContentLivePart) this.guildHomeContentLivePart.getValue();
    }

    private final GuildHomeCreateLivePart yh() {
        return (GuildHomeCreateLivePart) this.guildHomeCreateLivePart.getValue();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(xh(), yh());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eu5;
    }

    @Override // com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubLiveFragment", 1, "onCreate");
        }
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new b(this, this)).get(com.tencent.mobileqq.guild.home.subhome.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.activeChannelViewModel = (com.tencent.mobileqq.guild.home.subhome.e) viewModel;
    }

    @Override // com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubLiveFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        xh().onPostThemeChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        xh().T9();
    }

    @Override // com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubBaseFragment
    @NotNull
    protected String sh() {
        return "Guild.NewHome.subFrag.GuildHomeSubLiveFragment";
    }
}
