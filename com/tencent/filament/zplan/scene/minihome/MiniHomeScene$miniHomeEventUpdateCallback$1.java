package com.tencent.filament.zplan.scene.minihome;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.c;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/filament/zplan/scene/minihome/MiniHomeScene$miniHomeEventUpdateCallback$1", "Lcom/tencent/filament/zplan/c;", "", "pixels", "", "width", "height", "", "b", "", "timeStatJSONString", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeScene$miniHomeEventUpdateCallback$1 implements c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniHomeScene f105967a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WeakReference f105968b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniHomeScene$miniHomeEventUpdateCallback$1(MiniHomeScene miniHomeScene, WeakReference weakReference) {
        this.f105967a = miniHomeScene;
        this.f105968b = weakReference;
    }

    @Override // com.tencent.filament.zplan.c
    public void a(@NotNull String timeStatJSONString) {
        Intrinsics.checkNotNullParameter(timeStatJSONString, "timeStatJSONString");
        FLog.INSTANCE.i("MiniHomeScene", "miniHomeCallback.onStartUpTimeStatCallback, timeStat: " + timeStatJSONString);
        FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) this.f105968b.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(null, "timeStatReady", timeStatJSONString);
        }
    }

    @Override // com.tencent.filament.zplan.c
    public void b(@NotNull byte[] pixels, int width, int height) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        FLog fLog = FLog.INSTANCE;
        fLog.i("MiniHomeScene", "miniHomeCallback.onPixelsUpdated, pixelsLength: " + pixels.length + ", width: " + width + ", height: " + height);
        FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) this.f105968b.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(null, "onPixelCallback", null);
        }
        if (pixels.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && width != 0 && height != 0) {
            dl0.c cVar = (dl0.c) fl0.a.f399763a.a(dl0.c.class);
            if (cVar == null) {
                fLog.e("MiniHomeScene", "fileProxy is null");
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MiniHomeScene$miniHomeEventUpdateCallback$1$onPixelsUpdated$1(this, pixels, width, height, cVar.b() + "/ZPlanNative/FirstFrameImage/minihome_image_" + String.valueOf(System.nanoTime()) + ".png", null), 3, null);
        }
    }
}
