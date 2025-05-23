package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u00132.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\t\u001a\u00020\bH\u0003J\b\u0010\n\u001a\u00020\bH\u0003J\b\u0010\u000b\u001a\u00020\bH\u0003J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/d;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/g;", "", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onStart", "intent", "j", "context", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends BaseVM<g, Object, com.tencent.base.api.runtime.a<BaseParam>> {
    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVM", 1, "[onPause] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_PAUSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVM", 1, "[onResume] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_RESUME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onStart() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVM", 1, "[onResume] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_PAGE_STARTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull g intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVM", 1, "[handleIntent] " + intent);
        if (intent instanceof g.UpdateDragBar) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new MiniAppIntent.UpdateDragBar(((g.UpdateDragBar) intent).getFromDragBar()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVM", 1, "[onCreate] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_CREATE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVM", 1, "[onDestroy] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_DESTROY);
    }
}
