package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventCallback$SceneCallbackEvent;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.pb.MessageMicro;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\n\u001a\u00020\tR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/c;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "", "uin", "", "c", "b", "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "d", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "<init>", "(Ljava/lang/ref/WeakReference;)V", "e", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class c implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    public c(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
    }

    private final void b(long uin) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectSceneClickHandler", "handleCreateMiniXW");
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(new b.OnClickCreateMiniXW(uin));
        }
    }

    private final void c(long uin) {
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectSceneClickHandler", "handleGift");
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(new b.OnClickGift(uin));
        }
    }

    public final void a(@NotNull MessageMicro<?> pbField, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Intrinsics.checkNotNullParameter(pbField, "pbField");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        SceneEventCallback$SceneCallbackEvent sceneEventCallback$SceneCallbackEvent = (SceneEventCallback$SceneCallbackEvent) pbField;
        int i3 = sceneEventCallback$SceneCallbackEvent.scene_event.get();
        if (i3 != 0) {
            if (i3 == 1) {
                b(sceneEventCallback$SceneCallbackEvent.uin.get());
                callbackN2C.a(null);
                return;
            }
            return;
        }
        c(sceneEventCallback$SceneCallbackEvent.uin.get());
        callbackN2C.a(null);
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
    }
}
