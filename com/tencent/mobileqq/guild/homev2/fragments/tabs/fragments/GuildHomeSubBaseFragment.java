package com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.c;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.fragments.SharedViewModelStoreOwner;
import com.tencent.mobileqq.guild.base.fragments.f;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0014\u001a\u00020\u00048DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildHomeSubBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/b;", "Lcom/tencent/mobileqq/guild/base/fragments/SharedViewModelStoreOwner;", "", "th", "", "getContentLayoutId", "Landroid/view/View;", "c6", "Landroidx/lifecycle/ViewModelStore;", "p3", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "qh", "()Ljava/lang/String;", "identityString", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "D", "rh", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lmp1/b;", "E", "ph", "()Lmp1/b;", "guildHomeViewModel", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "uh", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "wh", "(Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "reportTask", "G", "sh", "vh", "loadTabTimeCostReportTask", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildHomeSubBaseFragment extends QPublicBaseFragment implements b, SharedViewModelStoreOwner {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy identityString;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy jumpGuildParam;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    protected IPerformanceReportTask reportTask;

    /* renamed from: G, reason: from kotlin metadata */
    protected IPerformanceReportTask loadTabTimeCostReportTask;

    public GuildHomeSubBaseFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment$identityString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return m.b(GuildHomeSubBaseFragment.this);
            }
        });
        this.identityString = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<JumpGuildParam>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment$jumpGuildParam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JumpGuildParam invoke() {
                return c.d(GuildHomeSubBaseFragment.this.requireArguments());
            }
        });
        this.jumpGuildParam = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Object>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment$guildHomeViewModel$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f225740a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeSubBaseFragment f225741b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildHomeSubBaseFragment guildHomeSubBaseFragment) {
                    this.f225740a = viewModelStoreOwner;
                    this.f225741b = guildHomeSubBaseFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new GuildHomeViewModel(this.f225741b.rh()), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class b implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f225742a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeSubBaseFragment f225743b;

                public b(ViewModelStoreOwner viewModelStoreOwner, GuildHomeSubBaseFragment guildHomeSubBaseFragment) {
                    this.f225742a = viewModelStoreOwner;
                    this.f225743b = guildHomeSubBaseFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel(MiscKt.j(this.f225743b.rh())), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
            public final Object invoke() {
                if (GuildHomeSubBaseFragment.this.rh().extras.containsKey("V2")) {
                    Logger logger = Logger.f235387a;
                    String th5 = GuildHomeSubBaseFragment.this.th();
                    if (QLog.isDebugVersion()) {
                        logger.d().d(th5, 1, "use V2 ViewModel");
                    }
                    c.a aVar = ef1.c.f396218a;
                    ViewModelStoreOwner b16 = f.b(GuildHomeSubBaseFragment.this);
                    ViewModel viewModel = new ViewModelProvider(b16, new a(b16, GuildHomeSubBaseFragment.this)).get(GuildHomeViewModel.class);
                    Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                    return viewModel;
                }
                Logger logger2 = Logger.f235387a;
                String th6 = GuildHomeSubBaseFragment.this.th();
                if (QLog.isDebugVersion()) {
                    logger2.d().d(th6, 1, "use Old ViewModel");
                }
                c.a aVar2 = ef1.c.f396218a;
                ViewModelStoreOwner b17 = f.b(GuildHomeSubBaseFragment.this);
                ViewModel viewModel2 = new ViewModelProvider(b17, new b(b17, GuildHomeSubBaseFragment.this)).get(com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return viewModel2;
            }
        });
        this.guildHomeViewModel = lazy3;
    }

    @Nullable
    public View c6() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f9m;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger logger = Logger.f235387a;
        String th5 = th();
        if (QLog.isDebugVersion()) {
            logger.d().d(th5, 1, "onCreateView id\uff1a" + qh() + " savedInstanceState:" + savedInstanceState);
        }
        wh(qw1.b.d(getArguments(), null, 1, null));
        vh(qw1.b.c(getArguments(), "_extra_param_report_task_view_pager_tab"));
    }

    @Override // com.tencent.mobileqq.guild.base.fragments.SharedViewModelStoreOwner
    @NotNull
    public ViewModelStore p3() {
        return f.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final mp1.b ph() {
        return (mp1.b) this.guildHomeViewModel.getValue();
    }

    @NotNull
    protected final String qh() {
        return (String) this.identityString.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JumpGuildParam rh() {
        return (JumpGuildParam) this.jumpGuildParam.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IPerformanceReportTask sh() {
        IPerformanceReportTask iPerformanceReportTask = this.loadTabTimeCostReportTask;
        if (iPerformanceReportTask != null) {
            return iPerformanceReportTask;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadTabTimeCostReportTask");
        return null;
    }

    @NotNull
    public String th() {
        return "GuildHomeSubFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IPerformanceReportTask uh() {
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask != null) {
            return iPerformanceReportTask;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reportTask");
        return null;
    }

    protected final void vh(@NotNull IPerformanceReportTask iPerformanceReportTask) {
        Intrinsics.checkNotNullParameter(iPerformanceReportTask, "<set-?>");
        this.loadTabTimeCostReportTask = iPerformanceReportTask;
    }

    protected final void wh(@NotNull IPerformanceReportTask iPerformanceReportTask) {
        Intrinsics.checkNotNullParameter(iPerformanceReportTask, "<set-?>");
        this.reportTask = iPerformanceReportTask;
    }
}
