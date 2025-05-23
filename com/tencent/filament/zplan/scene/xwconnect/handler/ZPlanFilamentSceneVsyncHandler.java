package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$OnVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$StartVsync;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0003\n\u000b\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$b;", "callback", "d", "", "data", "c", "a", "b", "e", "", "I", "DEFAULT_NANO_VALUE", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "f", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$b;", "fpsCallback", "", h.F, "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(J)V", "i", "N2C_EVENT", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanFilamentSceneVsyncHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int DEFAULT_NANO_VALUE = 30;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isRunning = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b fpsCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$N2C_EVENT;", "", "(Ljava/lang/String;I)V", "OnVsync", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum N2C_EVENT {
        OnVsync
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$b;", "", "", "fps", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public interface b {
        void a(float fps);
    }

    public ZPlanFilamentSceneVsyncHandler(long j3) {
        this.sceneId = j3;
    }

    public final void a() {
        this.isRunning.set(false);
    }

    public final void b() {
        this.isRunning.set(true);
    }

    public final void c(@NotNull Object data) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        SceneEventVsync$StartVsync sceneEventVsync$StartVsync = (SceneEventVsync$StartVsync) data;
        if (sceneEventVsync$StartVsync.fps.get() <= 0) {
            i3 = this.DEFAULT_NANO_VALUE;
        } else {
            i3 = sceneEventVsync$StartVsync.fps.get();
        }
        b bVar = this.fpsCallback;
        if (bVar != null) {
            bVar.a(i3);
        }
        this.isRunning.set(true);
    }

    public final void d(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.fpsCallback = callback;
    }

    public final void e() {
        if (!this.isRunning.get()) {
            return;
        }
        SceneEventVsync$OnVsync sceneEventVsync$OnVsync = new SceneEventVsync$OnVsync();
        sceneEventVsync$OnVsync.scene_address.set(this.sceneId);
        com.tencent.filament.zplanservice.channel.c.a(MessageChannel.INSTANCE, N2C_EVENT.OnVsync, sceneEventVsync$OnVsync, new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler$update$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
        this.isRunning.set(false);
    }
}
