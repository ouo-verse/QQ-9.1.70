package com.tencent.mobileqq.guild.home.fragments.subhome;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.fragments.SharedViewModelStoreOwner;
import com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import ef1.c;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u540e\u7eed\u65e7\u7248\u672c\u9891\u9053\u9996\u9875\u6574\u4f53\u4f1a\u4e0b\u6389, \u4f7f\u7528v2\u5305\u4e0b\u7684\u5bf9\u5e94\u9875\u9762")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u001b\u0010\u001b\u001a\u00020\u00168DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/base/fragments/SharedViewModelStoreOwner;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/b;", "Landroid/view/View;", "", "vh", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "sh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "c6", "Landroidx/lifecycle/ViewModelStore;", "p3", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "qh", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lmp1/b;", "D", "rh", "()Lmp1/b;", "guildHomeViewModel", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "E", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "th", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "uh", "(Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "reportTask", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildHomeSubBaseFragment extends QPublicBaseFragment implements SharedViewModelStoreOwner, com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    protected IPerformanceReportTask reportTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubBaseFragment$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildHomeSubBaseFragment.this.vh(v3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    public GuildHomeSubBaseFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FacadeArgsData>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubBaseFragment$facadeArgsData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FacadeArgsData invoke() {
                return com.tencent.mobileqq.guild.base.extension.c.b(GuildHomeSubBaseFragment.this.requireArguments());
            }
        });
        this.facadeArgsData = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Object>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubBaseFragment$guildHomeViewModel$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f224831a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeSubBaseFragment f224832b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildHomeSubBaseFragment guildHomeSubBaseFragment) {
                    this.f224831a = viewModelStoreOwner;
                    this.f224832b = guildHomeSubBaseFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new GuildHomeViewModel(com.tencent.mobileqq.guild.base.extension.c.d(this.f224832b.requireArguments())), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
                final /* synthetic */ ViewModelStoreOwner f224833a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeSubBaseFragment f224834b;

                public b(ViewModelStoreOwner viewModelStoreOwner, GuildHomeSubBaseFragment guildHomeSubBaseFragment) {
                    this.f224833a = viewModelStoreOwner;
                    this.f224834b = guildHomeSubBaseFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel(this.f224834b.qh()), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
                if (GuildHomeSubBaseFragment.this.qh().C.containsKey("V2")) {
                    Logger logger = Logger.f235387a;
                    String sh5 = GuildHomeSubBaseFragment.this.sh();
                    if (QLog.isDebugVersion()) {
                        logger.d().d(sh5, 1, "use V2 ViewModel");
                    }
                    c.Companion companion = ef1.c.INSTANCE;
                    ViewModelStoreOwner b16 = com.tencent.mobileqq.guild.base.fragments.f.b(GuildHomeSubBaseFragment.this);
                    ViewModel viewModel = new ViewModelProvider(b16, new a(b16, GuildHomeSubBaseFragment.this)).get(GuildHomeViewModel.class);
                    Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                    return viewModel;
                }
                Logger logger2 = Logger.f235387a;
                String sh6 = GuildHomeSubBaseFragment.this.sh();
                if (QLog.isDebugVersion()) {
                    logger2.d().d(sh6, 1, "use Old ViewModel");
                }
                c.Companion companion2 = ef1.c.INSTANCE;
                ViewModelStoreOwner b17 = com.tencent.mobileqq.guild.base.fragments.f.b(GuildHomeSubBaseFragment.this);
                ViewModel viewModel2 = new ViewModelProvider(b17, new b(b17, GuildHomeSubBaseFragment.this)).get(com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return viewModel2;
            }
        });
        this.guildHomeViewModel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(View view) {
        ViewGroup viewGroup;
        GuildHomeSubFragmentBehavior guildHomeSubFragmentBehavior = null;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        int i3 = 0;
        ViewGroup.LayoutParams layoutParams = null;
        while (i3 < 10) {
            layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                break;
            }
            ViewParent parent = viewGroup.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                break;
            }
            Logger logger = Logger.f235387a;
            String sh5 = sh();
            if (QLog.isDevelopLevel()) {
                Log.d(sh5, "tryNotifyLayoutChange!(" + i3 + "), view: " + viewGroup);
            }
            i3++;
        }
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            Logger logger2 = Logger.f235387a;
            String sh6 = sh();
            if (QLog.isDevelopLevel()) {
                Log.d(sh6, "tryNotifyLayoutChange success!(" + i3 + "), layoutParams is " + layoutParams);
            }
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof GuildHomeSubFragmentBehavior) {
                guildHomeSubFragmentBehavior = (GuildHomeSubFragmentBehavior) behavior;
            }
            if (guildHomeSubFragmentBehavior != null) {
                guildHomeSubFragmentBehavior.G();
                return;
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        String sh7 = sh();
        if (QLog.isDevelopLevel()) {
            Log.d(sh7, "tryNotifyLayoutChange failed(" + i3 + "), layoutParams is " + layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b
    @Nullable
    public View c6() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Logger logger = Logger.f235387a;
        String sh5 = sh();
        if (QLog.isDebugVersion()) {
            logger.d().d(sh5, 1, "onCreateView id\uff1a" + System.identityHashCode(this) + " savedInstanceState:" + savedInstanceState);
        }
        uh(qw1.b.d(getArguments(), null, 1, null));
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger logger = Logger.f235387a;
        String sh5 = sh();
        if (QLog.isDebugVersion()) {
            logger.d().d(sh5, 1, "onDestroy() id:" + System.identityHashCode(this));
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Logger logger = Logger.f235387a;
        String sh5 = sh();
        if (QLog.isDebugVersion()) {
            logger.d().d(sh5, 1, "onPause() id:" + System.identityHashCode(this));
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Logger logger = Logger.f235387a;
        String sh5 = sh();
        if (QLog.isDebugVersion()) {
            logger.d().d(sh5, 1, "onResume() id\uff1a" + System.identityHashCode(this));
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.addOnAttachStateChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        boolean z16;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        if (contentView == getView()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            String sh5 = sh();
            if (QLog.isDebugVersion()) {
                logger.d().d(sh5, 1, "onViewCreatedBeforePartInit id\uff1a" + System.identityHashCode(this) + " args:" + getArguments() + ", " + getParentFragment());
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.tencent.mobileqq.guild.base.fragments.SharedViewModelStoreOwner
    @NotNull
    public ViewModelStore p3() {
        return com.tencent.mobileqq.guild.base.fragments.f.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FacadeArgsData qh() {
        return (FacadeArgsData) this.facadeArgsData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final mp1.b rh() {
        return (mp1.b) this.guildHomeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String sh() {
        List split$default;
        Object last;
        String logTag = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        split$default = StringsKt__StringsKt.split$default((CharSequence) logTag, new String[]{"."}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        return "GuildHomeSubBaseFragment." + last;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IPerformanceReportTask th() {
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask != null) {
            return iPerformanceReportTask;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reportTask");
        return null;
    }

    protected final void uh(@NotNull IPerformanceReportTask iPerformanceReportTask) {
        Intrinsics.checkNotNullParameter(iPerformanceReportTask, "<set-?>");
        this.reportTask = iPerformanceReportTask;
    }
}
