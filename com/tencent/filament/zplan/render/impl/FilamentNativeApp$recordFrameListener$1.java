package com.tencent.filament.zplan.render.impl;

import com.google.gson.Gson;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.d;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/render/impl/FilamentNativeApp$recordFrameListener$1", "Lcom/tencent/filament/zplan/d;", "", "pixels", "", "width", "height", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentNativeApp$recordFrameListener$1 implements d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FilamentNativeApp f105867a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilamentNativeApp$recordFrameListener$1(FilamentNativeApp filamentNativeApp) {
        this.f105867a = filamentNativeApp;
    }

    @Override // com.tencent.filament.zplan.d
    public void a(@Nullable byte[] pixels, int width, int height) {
        Integer num;
        IBusinessScene iBusinessScene;
        boolean z16;
        IBusinessScene iBusinessScene2;
        FilamentEventDispatcher t06;
        AtomicBoolean atomicBoolean;
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordFrame. pixels size: ");
        if (pixels != null) {
            num = Integer.valueOf(pixels.length);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(" width: ");
        sb5.append(width);
        sb5.append(", height: ");
        sb5.append(height);
        fLog.i("FilamentNativeApp", sb5.toString());
        this.f105867a.startUpTrack.g();
        vk0.a aVar = this.f105867a.startUpTrack;
        String valueOf = String.valueOf(this.f105867a.appStatus.get());
        iBusinessScene = this.f105867a.scene;
        if (iBusinessScene != null) {
            z16 = iBusinessScene.getNeedRecordFirstFrame();
        } else {
            z16 = false;
        }
        Map<String, String> a16 = aVar.a(valueOf, z16);
        this.f105867a.startUpTrack.l(a16);
        iBusinessScene2 = this.f105867a.scene;
        if (iBusinessScene2 != null) {
            iBusinessScene2.onFirstRenderEnd();
        }
        t06 = this.f105867a.t0();
        String json = new Gson().toJson(a16);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(stepMap)");
        t06.onEvent("onFirstFrameRenderEnd", json);
        atomicBoolean = this.f105867a.hasRecordFrameCallback;
        atomicBoolean.compareAndSet(false, true);
        dl0.c cVar = (dl0.c) fl0.a.f399763a.a(dl0.c.class);
        if (cVar == null) {
            fLog.e("FilamentNativeApp", "fileProxy is null");
            return;
        }
        if ((pixels == null || pixels.length != 0) && width != 0 && height != 0) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentNativeApp$recordFrameListener$1$onRecordFrame$1(this, pixels, width, height, cVar.b() + "/ZPlanNative/FirstFrameImage/image_" + String.valueOf(System.currentTimeMillis()) + ".png", null), 3, null);
        }
    }
}
