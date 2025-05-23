package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.SceneTouchEvent$TouchEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b*\u0001\u0013\u0018\u0000 &2\u00020\u0001:\u0002'(B\u001d\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "", "data", "", "c", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", "b", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Z", "pinchEnd", "", "e", "I", "TAP_END_STATE", "com/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler$b", "f", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler$b;", "eventListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", h.F, "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "i", "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "N2CEVENT", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanFilamentSceneTouchHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean pinchEnd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int TAP_END_STATE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b eventListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler$N2CEVENT;", "", "(Ljava/lang/String;I)V", "TouchEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum N2CEVENT {
        TouchEvent
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler$b", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements sk0.b {
        b() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.hashCode() == 1719579098 && type.equals("onTouchEvent")) {
                ZPlanFilamentSceneTouchHandler.this.c(data);
            }
        }
    }

    public ZPlanFilamentSceneTouchHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
        this.TAP_END_STATE = 2;
        this.eventListener = new b();
    }

    private final boolean b(TouchEvent event) {
        TouchEventState state = event.getState();
        TouchEventState touchEventState = TouchEventState.Began;
        if (state == touchEventState) {
            this.pinchEnd = false;
        }
        if (event.getType() == TouchEventType.Pinch && event.getState() == TouchEventState.Ended) {
            this.pinchEnd = true;
        }
        if (!this.pinchEnd || TouchEventType.Pan != event.getType() || event.getState() == touchEventState) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String data) {
        int ordinal;
        ArrayList arrayListOf;
        if (data != null) {
            TouchEvent event = (TouchEvent) new Gson().fromJson(data, TouchEvent.class);
            Intrinsics.checkNotNullExpressionValue(event, "event");
            if (b(event)) {
                return;
            }
            SceneTouchEvent$TouchEvent sceneTouchEvent$TouchEvent = new SceneTouchEvent$TouchEvent();
            sceneTouchEvent$TouchEvent.scene_address.set(this.sceneId);
            sceneTouchEvent$TouchEvent.event_type.set(event.getType().ordinal());
            PBEnumField pBEnumField = sceneTouchEvent$TouchEvent.event_state;
            if (event.getType() == TouchEventType.Tap) {
                ordinal = this.TAP_END_STATE;
            } else {
                ordinal = event.getState().ordinal();
            }
            pBEnumField.set(ordinal);
            PBRepeatField<Float> pBRepeatField = sceneTouchEvent$TouchEvent.locations;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Float.valueOf(event.getLocation().x), Float.valueOf(event.getLocation().y));
            pBRepeatField.set(arrayListOf);
            sceneTouchEvent$TouchEvent.touch_count.set(event.getTouchCount());
            sceneTouchEvent$TouchEvent.scale_factor.set(1);
            Float scale = event.getScale();
            if (scale != null) {
                sceneTouchEvent$TouchEvent.scale.set(scale.floatValue());
            }
            Float velocity = event.getVelocity();
            if (velocity != null) {
                sceneTouchEvent$TouchEvent.velocity.set(velocity.floatValue());
            }
            com.tencent.filament.zplanservice.channel.c.a(MessageChannel.INSTANCE, N2CEVENT.TouchEvent, sceneTouchEvent$TouchEvent, new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneTouchHandler$handleTouchEvent$1
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
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.addEventListener("onTouchEvent", this.eventListener);
        }
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.removeEventListener("onTouchEvent", this.eventListener);
        }
    }
}
