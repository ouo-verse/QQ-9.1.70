package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import androidx.lifecycle.LifecycleObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.h;
import com.tencent.mobileqq.guild.media.thirdapp.container.uistate.GuildMiniViewUIState;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.api.ContainerLoadParams;
import com.tencent.mobileqq.mini.api.IContainerPageNavigator;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.api.IMiniLoadCallback;
import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u001b\u0018\u0000 !2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u001a\u0010\u0015\u001a\u00020\r2\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAlongMiniViewVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/h;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/mini/api/ContainerLoadParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "path", ReportConstant.COSTREPORT_PREFIX, "intent", "p", "context", "r", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$a;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$a;", "miniAppConfig", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAlongMiniViewVM$b", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAlongMiniViewVM$b;", "miniContainerNavCallback", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildStandAlongMiniViewVM extends BaseVM<h, GuildMiniViewUIState, com.tencent.base.api.runtime.a<BaseParam>> implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildOpenContainerLauncher.MiniAppConfig miniAppConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b miniContainerNavCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAlongMiniViewVM$b", "Lcom/tencent/mobileqq/mini/api/IContainerPageNavigator;", "", "path", "", "navigateTo", "navigateBack", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IContainerPageNavigator {
        b() {
        }

        @Override // com.tencent.mobileqq.mini.api.IContainerPageNavigator
        public boolean navigateBack() {
            Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVM", 1, "[navigateBack]");
            GuildStandAlongMiniViewVM.this.updateUI(new GuildMiniViewUIState.RemoveLastMiniView());
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
        @Override // com.tencent.mobileqq.mini.api.IContainerPageNavigator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean navigateTo(@Nullable String path) {
            boolean z16;
            boolean isBlank;
            Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVM", 1, "[navigateTo] path: " + path);
            if (path != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(path);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        GuildStandAlongMiniViewVM.this.s(path);
                        return true;
                    }
                    return true;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    private final ContainerLoadParams m() {
        ContainerLoadParams addDefaultRetryView = new ContainerLoadParams().setAddDefaultRetryView(true);
        GuildOpenContainerLauncher.MiniAppConfig miniAppConfig = this.miniAppConfig;
        if (miniAppConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppConfig");
            miniAppConfig = null;
        }
        ContainerLoadParams loadingCallback = addDefaultRetryView.setAddDefaultLoadingView(miniAppConfig.getUseDefaultLoadingView()).setForceDefaultUIDarkMode(true).setLoadingCallback(new IMiniLoadCallback() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.e
            @Override // com.tencent.mobileqq.mini.api.IMiniLoadCallback
            public final void onLoaded(int i3, String str) {
                GuildStandAlongMiniViewVM.n(i3, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadingCallback, "ContainerLoadParams()\n  \u2026$message\" }\n            }");
        return loadingCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str) {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVM", 1, "[onLoaded] result: code: " + i3 + ", msg: " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int o() {
        GuildOpenContainerLauncher.MiniAppConfig miniAppConfig = this.miniAppConfig;
        GuildOpenContainerLauncher.MiniAppConfig miniAppConfig2 = null;
        if (miniAppConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppConfig");
            miniAppConfig = null;
        }
        if (miniAppConfig.getHeightByDp() > 0.0f) {
            GuildOpenContainerLauncher.MiniAppConfig miniAppConfig3 = this.miniAppConfig;
            if (miniAppConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("miniAppConfig");
            } else {
                miniAppConfig2 = miniAppConfig3;
            }
            return ViewUtils.dpToPx(miniAppConfig2.getHeightByDp());
        }
        float instantScreenHeight = ScreenUtil.getInstantScreenHeight(((com.tencent.base.api.runtime.a) getMContext()).f());
        GuildOpenContainerLauncher.MiniAppConfig miniAppConfig4 = this.miniAppConfig;
        if (miniAppConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppConfig");
        } else {
            miniAppConfig2 = miniAppConfig4;
        }
        return (int) (instantScreenHeight * miniAppConfig2.getHeightRatio());
    }

    private final void q() {
        GuildOpenContainerLauncher.MiniAppConfig miniAppConfig = this.miniAppConfig;
        if (miniAppConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppConfig");
            miniAppConfig = null;
        }
        if (miniAppConfig.getOpenNewPageInSameContainer()) {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).setContainerNavigator(this.miniContainerNavCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s(String path) {
        if (lt1.a.d((com.tencent.base.api.runtime.a) getMContext())) {
            return;
        }
        MiniContainerHolder miniViewContainer = ((IMiniContainer) QRoute.api(IMiniContainer.class)).load(((com.tencent.base.api.runtime.a) getMContext()).f(), ((com.tencent.base.api.runtime.a) getMContext()).d(), path, m());
        Intrinsics.checkNotNullExpressionValue(miniViewContainer, "miniViewContainer");
        updateUI(new GuildMiniViewUIState.UpdateMiniView(miniViewContainer, o()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVM", 1, "[onDestroy] ");
        if (lt1.a.a((com.tencent.base.api.runtime.a) getMContext()).getOpenNewPageInSameContainer()) {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).setContainerNavigator(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull h intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if ((intent instanceof h.NotifyMiniViewSize) && ((h.NotifyMiniViewSize) intent).getSize() == 0) {
            Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVM", 1, "[clearLastMiniView] empty, dismiss dialog");
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(MiniAppIntent.CloseCurrentContainerIntent.INSTANCE);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVM", 1, "[onCreate] ");
        this.miniAppConfig = lt1.a.a(context);
        s(lt1.a.b(context));
        q();
    }
}
