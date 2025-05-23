package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.SceneLifeCycle$onEnterBackground;
import com.tencent.filament.zplanservice.pbjava.SceneLifeCycle$onEnterForeground;
import com.tencent.filament.zplanservice.pbjava.SceneLifeCycle$onPageIn;
import com.tencent.filament.zplanservice.pbjava.SceneLifeCycle$onPageOut;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zk0.a;

@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b*\u0001\u000e\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u001d\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "", "d", "e", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler$N2CEVENT;", "event", "c", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "g", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler$N2CEVENT;", "current", "com/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler$action$1", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler$action$1;", "action", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", h.F, "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", "i", "a", "N2CEVENT", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanFilamentSceneLifeCycleHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private N2CEVENT current;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZPlanFilamentSceneLifeCycleHandler$action$1 action;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler$N2CEVENT;", "", "(Ljava/lang/String;I)V", "OnEnterBackground", "OnEnterForeground", "OnPageIn", "OnPageOut", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum N2CEVENT {
        OnEnterBackground,
        OnEnterForeground,
        OnPageIn,
        OnPageOut
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler$action$1] */
    public ZPlanFilamentSceneLifeCycleHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
        this.current = N2CEVENT.OnPageIn;
        this.action = new tk0.a() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler$action$1
            @Override // tk0.a
            public void call(@NotNull tk0.b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event, a.b.f452693a)) {
                    ZPlanFilamentSceneLifeCycleHandler.this.e();
                } else if (Intrinsics.areEqual(event, a.C11692a.f452692a)) {
                    ZPlanFilamentSceneLifeCycleHandler.this.d();
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c(final N2CEVENT event) {
        SceneLifeCycle$onEnterBackground sceneLifeCycle$onEnterBackground;
        int i3 = e.f106236a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        SceneLifeCycle$onPageOut sceneLifeCycle$onPageOut = new SceneLifeCycle$onPageOut();
                        sceneLifeCycle$onPageOut.scene_address.set(this.sceneId);
                        sceneLifeCycle$onEnterBackground = sceneLifeCycle$onPageOut;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    SceneLifeCycle$onPageIn sceneLifeCycle$onPageIn = new SceneLifeCycle$onPageIn();
                    sceneLifeCycle$onPageIn.scene_address.set(this.sceneId);
                    sceneLifeCycle$onEnterBackground = sceneLifeCycle$onPageIn;
                }
            } else {
                SceneLifeCycle$onEnterForeground sceneLifeCycle$onEnterForeground = new SceneLifeCycle$onEnterForeground();
                sceneLifeCycle$onEnterForeground.scene_address.set(this.sceneId);
                sceneLifeCycle$onEnterBackground = sceneLifeCycle$onEnterForeground;
            }
        } else {
            SceneLifeCycle$onEnterBackground sceneLifeCycle$onEnterBackground2 = new SceneLifeCycle$onEnterBackground();
            sceneLifeCycle$onEnterBackground2.scene_address.set(this.sceneId);
            sceneLifeCycle$onEnterBackground = sceneLifeCycle$onEnterBackground2;
        }
        com.tencent.filament.zplanservice.channel.c.a(MessageChannel.INSTANCE, event, sceneLifeCycle$onEnterBackground, new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler$callN2C$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectSceneLifeCycleHandler", "postMessage event:" + ZPlanFilamentSceneLifeCycleHandler.N2CEVENT.this.name() + " result: " + messageChannelErrorCode$MessageResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        N2CEVENT n2cevent = this.current;
        N2CEVENT n2cevent2 = N2CEVENT.OnEnterBackground;
        if (n2cevent == n2cevent2) {
            return;
        }
        this.current = n2cevent2;
        c(n2cevent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        N2CEVENT n2cevent = this.current;
        N2CEVENT n2cevent2 = N2CEVENT.OnEnterForeground;
        if (n2cevent == n2cevent2) {
            return;
        }
        this.current = n2cevent2;
        c(n2cevent2);
    }

    public final void f() {
        N2CEVENT n2cevent = this.current;
        N2CEVENT n2cevent2 = N2CEVENT.OnPageOut;
        if (n2cevent == n2cevent2) {
            return;
        }
        this.current = n2cevent2;
        c(n2cevent2);
    }

    public final void g() {
        N2CEVENT n2cevent = this.current;
        N2CEVENT n2cevent2 = N2CEVENT.OnPageIn;
        if (n2cevent == n2cevent2) {
            return;
        }
        this.current = n2cevent2;
        c(n2cevent2);
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(a.b.class)), this.action);
        }
        FilamentNativeAppV2305 filamentNativeAppV23052 = this.nativeApp.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(a.C11692a.class)), this.action);
        }
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(a.b.class)), this.action);
        }
        FilamentNativeAppV2305 filamentNativeAppV23052 = this.nativeApp.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(a.C11692a.class)), this.action);
        }
    }
}
