package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.as;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.thirdapp.container.uistate.GuildContainerMaskUIState;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\f\u0018\u0000 \u00122.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\n\u001a\u00020\t2\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/a;", "Lcom/tencent/mvi/mvvm/BaseVM;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildContainerMaskUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "context", "", "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/guild/media/thirdapp/container/vm/a$b", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/a$b;", "mThirdAppMaskOpenEvent", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends BaseVM<Object, GuildContainerMaskUIState, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mThirdAppMaskOpenEvent = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/a$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/as;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements o<as> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull as event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerMaskVM", 1, "[onEventReceive] ThirdAppAntiAddictionMaskSwitchEvent: " + event.getCom.tencent.mobileqq.msf.core.f0.c.e.h.g java.lang.String());
            a.this.updateUI(new GuildContainerMaskUIState.UpdateMaskViewVisibility(event.getCom.tencent.mobileqq.msf.core.f0.c.e.h.g java.lang.String()));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerMaskVM", 1, "[onCreate] ");
        j.d().V(as.class, this.mThirdAppMaskOpenEvent);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerMaskVM", 1, "[onDestroy] ");
        j.d().j(as.class, this.mThirdAppMaskOpenEvent);
    }
}
