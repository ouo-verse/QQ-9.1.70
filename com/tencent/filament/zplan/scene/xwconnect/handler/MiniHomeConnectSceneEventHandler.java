package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectSceneEventHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEvent;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n*\u0001\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u0005B\u001d\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectSceneEventHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneEvent;", "req", "", "b", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectSceneEventHandler$action$1", "d", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectSceneEventHandler$action$1;", "action", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "e", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "f", "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", h.F, "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeConnectSceneEventHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectSceneEventHandler$action$1 action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectSceneEventHandler$b;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneEvent;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneEvent;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneEvent;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneEvent;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class b implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SceneEvent req;

        public b(@NotNull SceneEvent req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final SceneEvent getReq() {
            return this.req;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectSceneEventHandler$action$1] */
    public MiniHomeConnectSceneEventHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
        this.action = new tk0.a() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectSceneEventHandler$action$1
            @Override // tk0.a
            public void call(@NotNull tk0.b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof MiniHomeConnectSceneEventHandler.b) {
                    MiniHomeConnectSceneEventHandler.this.b(((MiniHomeConnectSceneEventHandler.b) event).getReq());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(SceneEvent req) {
        req.scene_address.set(this.sceneId);
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectSceneEventHandler", "triggerSceneEvent, sceneAddress: " + req.scene_address.get() + ", uin: " + req.uin.get() + ", event: " + req.scene_event.get());
        MessageChannel.INSTANCE.callN2C("scene.TriggerEvent", req.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectSceneEventHandler$triggerSceneEvent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectSceneEventHandler", "postMessage event:scene.TriggerEvent result: " + messageChannelErrorCode$MessageResponse);
            }
        });
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), this.action);
        }
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), this.action);
        }
    }
}
