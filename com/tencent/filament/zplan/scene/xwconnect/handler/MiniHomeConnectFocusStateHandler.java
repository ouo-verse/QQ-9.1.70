package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneStateChange$EngineStateChangeEvent;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneStateChange$NativeStateChangeEvent;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b*\u0001\u0013\u0018\u0000 %2\u00020\u0001:\u0004&'\u000e\u0005B\u001d\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$NativeStateChangeEvent;", "req", "", "c", "", AdMetricTag.EVENT_NAME, "", "reqData", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/MessageChannelErrorCode$MessageResponse;", "Lcom/tencent/filament/zplanservice/channel/CallbackC2N;", "callbackC2N", "b", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$EngineStateChangeEvent;", "d", "com/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$action$1", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$action$1;", "action", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "e", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "f", "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", h.F, "a", "N2CEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeConnectFocusStateHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectFocusStateHandler$action$1 action;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$N2CEvent;", "", "(Ljava/lang/String;I)V", "getEventName", "", "NativeStateChange", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class N2CEvent {
        private static final /* synthetic */ N2CEvent[] $VALUES;
        public static final N2CEvent NativeStateChange;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$N2CEvent$NativeStateChange;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$N2CEvent;", "getEventName", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes6.dex */
        static final class NativeStateChange extends N2CEvent {
            NativeStateChange(String str, int i3) {
                super(str, i3, null);
            }

            @Override // com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler.N2CEvent
            @NotNull
            public String getEventName() {
                return "xwConnectState.NativeStateChange";
            }
        }

        static {
            NativeStateChange nativeStateChange = new NativeStateChange("NativeStateChange", 0);
            NativeStateChange = nativeStateChange;
            $VALUES = new N2CEvent[]{nativeStateChange};
        }

        N2CEvent(String str, int i3) {
        }

        public static N2CEvent valueOf(String str) {
            return (N2CEvent) Enum.valueOf(N2CEvent.class, str);
        }

        public static N2CEvent[] values() {
            return (N2CEvent[]) $VALUES.clone();
        }

        @NotNull
        public abstract String getEventName();

        public /* synthetic */ N2CEvent(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$b;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$NativeStateChangeEvent;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$NativeStateChangeEvent;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$NativeStateChangeEvent;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$NativeStateChangeEvent;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class b implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SceneStateChange$NativeStateChangeEvent req;

        public b(@NotNull SceneStateChange$NativeStateChangeEvent req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final SceneStateChange$NativeStateChangeEvent getReq() {
            return this.req;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler$c;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$EngineStateChangeEvent;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$EngineStateChangeEvent;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$EngineStateChangeEvent;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/SceneStateChange$EngineStateChangeEvent;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class c implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SceneStateChange$EngineStateChangeEvent req;

        public c(@NotNull SceneStateChange$EngineStateChangeEvent req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final SceneStateChange$EngineStateChangeEvent getReq() {
            return this.req;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler$action$1] */
    public MiniHomeConnectFocusStateHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
        this.action = new tk0.a() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler$action$1
            @Override // tk0.a
            public void call(@NotNull tk0.b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof MiniHomeConnectFocusStateHandler.b) {
                    MiniHomeConnectFocusStateHandler.this.c(((MiniHomeConnectFocusStateHandler.b) event).getReq());
                }
            }
        };
    }

    private final void b(final String eventName, byte[] reqData, final Function1<? super MessageChannelErrorCode$MessageResponse, Unit> callbackC2N) {
        MessageChannel.INSTANCE.callN2C(eventName, reqData, new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler$callN2C$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectFocusStateHandler", "postMessage event:" + eventName + " result: " + messageChannelErrorCode$MessageResponse);
                callbackC2N.invoke(messageChannelErrorCode$MessageResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(SceneStateChange$NativeStateChangeEvent req) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectFocusStateHandler", "nativeStateChange, " + req.get());
        String eventName = N2CEvent.NativeStateChange.getEventName();
        req.scene_address.set(this.sceneId);
        Unit unit = Unit.INSTANCE;
        b(eventName, req.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler$nativeStateChange$2
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

    public final void d(@NotNull SceneStateChange$EngineStateChangeEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectFocusStateHandler", "onEngineStateChange");
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(new c(req));
        }
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
