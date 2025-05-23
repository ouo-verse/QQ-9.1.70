package com.tencent.qqguild.directmessage.aio.graytips.local.robotblack;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotblack/GuildBlackRobotGrayTipsVM;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "l", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lol3/b;", "intent", "handleIntent", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "d", "Lkotlin/Lazy;", "getGpsService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class GuildBlackRobotGrayTipsVM extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gpsService;

    public GuildBlackRobotGrayTipsVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.GuildBlackRobotGrayTipsVM$gpsService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGPSService invoke() {
                return (IGPSService) ch.S0(IGPSService.class, "");
            }
        });
        this.gpsService = lazy;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            l(((c.a) intent).getMsgItem());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
    }

    private final void l(com.tencent.aio.data.msglist.a msgItem) {
    }
}
