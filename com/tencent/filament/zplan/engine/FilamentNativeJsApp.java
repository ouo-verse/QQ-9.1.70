package com.tencent.filament.zplan.engine;

import android.view.Surface;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.engine.js.FilamentJsPluginEngine;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b&\u0010'J-\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0082 J\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0082 J\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0082 J#\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0082 J!\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0082 J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0082 J\u0011\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0082 J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/tencent/filament/zplan/engine/FilamentNativeJsApp;", "", "", "jsBundle", "jsBundleFolder", "", "jniGlobalDispatcher", "jniGlobalPluginEngine", "nCreateApp", "nativeApp", "Landroid/view/Surface;", "nativeWindow", "", "nAttach", "entry", "nStartWithEntry", "event", "data", "nDispatch", "nDestroy", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "eventObject", "nGetGlobalEventObject", "Lcom/tencent/filament/zplan/engine/js/FilamentJsPluginEngine;", EnginePathProvider.ENGINE_DIR, "nGetGlobalPluginEngine", "a", "J", "nativeObject", "b", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "eventDispatcher", "c", "Lcom/tencent/filament/zplan/engine/js/FilamentJsPluginEngine;", "pluginEngine", "d", "jniGlobalEventDispatcher", "e", "<init>", "()V", "f", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentNativeJsApp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long nativeObject;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FilamentEventDispatcher eventDispatcher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final FilamentJsPluginEngine pluginEngine;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long jniGlobalEventDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long jniGlobalPluginEngine;

    public FilamentNativeJsApp() {
        FilamentEventDispatcher filamentEventDispatcher = new FilamentEventDispatcher();
        this.eventDispatcher = filamentEventDispatcher;
        FilamentJsPluginEngine filamentJsPluginEngine = new FilamentJsPluginEngine(new WeakReference(this));
        this.pluginEngine = filamentJsPluginEngine;
        this.jniGlobalEventDispatcher = nGetGlobalEventObject(filamentEventDispatcher);
        this.jniGlobalPluginEngine = nGetGlobalPluginEngine(filamentJsPluginEngine);
    }

    private final native void nAttach(long nativeApp, Surface nativeWindow);

    private final native long nCreateApp(String jsBundle, String jsBundleFolder, long jniGlobalDispatcher, long jniGlobalPluginEngine);

    private final native void nDestroy(long nativeApp, long jniGlobalDispatcher, long jniGlobalPluginEngine);

    private final native void nDispatch(long nativeApp, String event, String data);

    private final native long nGetGlobalEventObject(FilamentEventDispatcher eventObject);

    private final native long nGetGlobalPluginEngine(FilamentJsPluginEngine engine);

    private final native void nStartWithEntry(long nativeApp, String entry);

    public final void a(@NotNull String event, @Nullable String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        long j3 = this.nativeObject;
        if (j3 == 0) {
            FLog.INSTANCE.e("FilamentNativeJsApp", "nativeObject == 0");
        } else {
            nDispatch(j3, event, data);
        }
    }
}
