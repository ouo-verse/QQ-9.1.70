package com.tencent.filament.zplan.scene.xwconnect.handler;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneStartupParam$StartupParam;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zk0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u001d\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/d;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "d", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "e", "J", "a", "()J", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/ref/WeakReference;J)V", "f", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class d implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/scene/xwconnect/handler/d$b", "Lzk0/c$a;", "Lzk0/c$b;", "param", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements c.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplanservice.channel.a f106235b;

        b(com.tencent.filament.zplanservice.channel.a aVar) {
            this.f106235b = aVar;
        }

        @Override // zk0.c.a
        public void a(@NotNull c.Param param) {
            Intrinsics.checkNotNullParameter(param, "param");
            FLog.INSTANCE.i("ConnectHandler_MiniHomeConnectSceneStartupHandler", "handleStartup param=" + param);
            SceneStartupParam$StartupParam sceneStartupParam$StartupParam = new SceneStartupParam$StartupParam();
            sceneStartupParam$StartupParam.scene_address.set(d.this.getSceneId());
            sceneStartupParam$StartupParam.center_uin.set(param.getCenterUin());
            sceneStartupParam$StartupParam.is_focus.set(param.getIsFocus());
            sceneStartupParam$StartupParam.action_id.set(param.getActionId());
            sceneStartupParam$StartupParam.action_uin.set(param.getActionUin());
            sceneStartupParam$StartupParam.max_characters.set(param.getMaxCharacters());
            sceneStartupParam$StartupParam.fps.set(param.getFps());
            sceneStartupParam$StartupParam.can_show_flower.set(param.getCanShowFlower());
            com.tencent.filament.zplanservice.channel.handler.a.e(this.f106235b, sceneStartupParam$StartupParam);
        }
    }

    public d(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.nativeApp = nativeApp;
        this.sceneId = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getSceneId() {
        return this.sceneId;
    }

    public final void b(@NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        b bVar = new b(callbackN2C);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(new c.StartupParam(bVar));
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
