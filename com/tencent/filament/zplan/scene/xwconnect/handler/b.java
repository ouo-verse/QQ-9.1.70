package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.pbjava.sceneevent.MiniConnectMaskLayerInfo$MaskLayerInfo;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0002\u0005\u0016B\u001d\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/b;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/MiniConnectMaskLayerInfo$MaskLayerInfo;", "req", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "d", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "e", "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", "f", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/b$b;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/MiniConnectMaskLayerInfo$MaskLayerInfo;", "a", "Lcom/tencent/filament/zplanservice/pbjava/sceneevent/MiniConnectMaskLayerInfo$MaskLayerInfo;", "()Lcom/tencent/filament/zplanservice/pbjava/sceneevent/MiniConnectMaskLayerInfo$MaskLayerInfo;", "req", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/sceneevent/MiniConnectMaskLayerInfo$MaskLayerInfo;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.xwconnect.handler.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1119b implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MiniConnectMaskLayerInfo$MaskLayerInfo req;

        public C1119b(@NotNull MiniConnectMaskLayerInfo$MaskLayerInfo req) {
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MiniConnectMaskLayerInfo$MaskLayerInfo getReq() {
            return this.req;
        }
    }

    public b(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
    }

    public final void a(@NotNull MiniConnectMaskLayerInfo$MaskLayerInfo req) {
        Intrinsics.checkNotNullParameter(req, "req");
        FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectMaskLayerHandler", "onMaskLayerReady");
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(new C1119b(req));
        }
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
