package com.tencent.filament.zplan.app.impl;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.app.impl.event.ZPlanBusinessTriggerEvent;
import com.tencent.filament.zplan.app.scene.BaseSceneV2308;
import com.tencent.filament.zplan.app.view.FilamentTextureViewV2305;
import com.tencent.filament.zplan.scene.cartoon.CartoonScene;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene;
import com.tencent.filament.zplan.scene.intimateSpace.IntimateSpaceScene;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.filament.zplan.scene.multiCartoon.MultiCartoonScene;
import com.tencent.filament.zplan.scene.pinchface.PinchFaceScene;
import com.tencent.filament.zplan.scene.square.SquareAvatarScene;
import com.tencent.filament.zplan.scene.square.SquareMapScene;
import com.tencent.filament.zplan.scene.square.SquareRecordScene;
import com.tencent.filament.zplan.scene.tofu.TofuScene;
import com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u00104\u001a\u00020/\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J$\u0010\u0013\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020 8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001b\u0010\"R$\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010%\u001a\u0004\b!\u0010&\"\u0004\b'\u0010(R&\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00104\u001a\u00020/8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "Landroid/view/TextureView;", "getView", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "entry", "", "startWithEntry", "pause", "resume", "destroy", "type", "Lsk0/b;", "listener", "addEventListener", "removeEventListener", "data", "dispatchEvent", "Ltk0/b;", "event", "Ltk0/a;", "action", "register", "unregister", "Lcom/tencent/filament/zplan/app/impl/event/ZPlanBusinessTriggerEvent;", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/filament/zplan/app/impl/event/ZPlanBusinessTriggerEvent;", "triggerEvent", "Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305;", "b", "()Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305;", "filamentView", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "()Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "setScene", "(Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;)V", "scene", "", "", "d", "Ljava/util/Map;", "listeners", "Lsk0/a;", "e", "Lsk0/a;", "getConfiguration", "()Lsk0/a;", "configuration", "<init>", "(Lsk0/a;)V", "f", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentNativeAppV2305 implements IFilamentNativeAppV2305 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy triggerEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy filamentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseSceneV2308 scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Set<b>> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final sk0.a configuration;

    public FilamentNativeAppV2305(@NotNull sk0.a configuration) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
        FLog.INSTANCE.i("FilamentNativeAppV2305", "init , " + this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanBusinessTriggerEvent>() { // from class: com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305$triggerEvent$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ZPlanBusinessTriggerEvent invoke() {
                return new ZPlanBusinessTriggerEvent();
            }
        });
        this.triggerEvent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FilamentTextureViewV2305>() { // from class: com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305$filamentView$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplan/app/impl/FilamentNativeAppV2305$filamentView$2$1$listener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "surface", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements TextureView.SurfaceTextureListener {
                a() {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
                    Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
                    FLog.INSTANCE.i("FilamentNativeAppV2305", "onSurfaceTextureAvailable, " + FilamentNativeAppV2305.this);
                    BaseSceneV2308 scene = FilamentNativeAppV2305.this.getScene();
                    if (scene != null) {
                        scene.s(surfaceTexture, width, height);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    FLog fLog = FLog.INSTANCE;
                    fLog.i("FilamentNativeAppV2305", "onSurfaceTextureDestroyed start, " + FilamentNativeAppV2305.this);
                    BaseSceneV2308 scene = FilamentNativeAppV2305.this.getScene();
                    if (scene != null) {
                        scene.t(surface);
                    }
                    fLog.i("FilamentNativeAppV2305", "onSurfaceTextureDestroyed end, " + FilamentNativeAppV2305.this);
                    return false;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
                    Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
                    FLog.INSTANCE.i("FilamentNativeAppV2305", "onSurfaceTextureSizeChanged, " + FilamentNativeAppV2305.this);
                    BaseSceneV2308 scene = FilamentNativeAppV2305.this.getScene();
                    if (scene != null) {
                        scene.u(surfaceTexture, width, height);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    BaseSceneV2308 scene = FilamentNativeAppV2305.this.getScene();
                    if (scene != null) {
                        scene.v(surface);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FilamentTextureViewV2305 invoke() {
                FilamentTextureViewV2305 filamentTextureViewV2305 = new FilamentTextureViewV2305(new FilamentTextureViewV2305.FilamentTextureParamV2305(FilamentNativeAppV2305.this.getConfiguration().getViewContext(), false, FilamentNativeAppV2305.this.getConfiguration().getEnableTouch(), new WeakReference(FilamentNativeAppV2305.this), 2, null));
                FLog.INSTANCE.i("FilamentNativeAppV2305", "FilamentTextureViewV2305 init. " + filamentTextureViewV2305 + ", " + FilamentNativeAppV2305.this);
                filamentTextureViewV2305.setSurfaceTextureListener(new a());
                return filamentTextureViewV2305;
            }
        });
        this.filamentView = lazy2;
        this.listeners = new LinkedHashMap();
    }

    private final ZPlanBusinessTriggerEvent c() {
        return (ZPlanBusinessTriggerEvent) this.triggerEvent.getValue();
    }

    @NotNull
    public final FilamentTextureViewV2305 a() {
        return (FilamentTextureViewV2305) this.filamentView.getValue();
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void addEventListener(@NotNull String type, @NotNull b listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            Set<b> set = this.listeners.get(type);
            if (set == null) {
                set = new LinkedHashSet<>();
                this.listeners.put(type, set);
            }
            set.add(listener);
        }
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final BaseSceneV2308 getScene() {
        return this.scene;
    }

    @Override // com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305
    public void destroy() {
        FLog.INSTANCE.i("FilamentNativeAppV2305", "destroy, " + this);
        BaseSceneV2308 baseSceneV2308 = this.scene;
        if (baseSceneV2308 != null) {
            baseSceneV2308.n();
        }
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void dispatchEvent(@Nullable c spanContext, @NotNull String type, @Nullable String data) {
        List list;
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.listeners) {
            Set<b> set = this.listeners.get(type);
            list = set != null ? CollectionsKt___CollectionsKt.toList(set) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((b) it.next()).handleEvent(spanContext, type, data);
            }
        }
    }

    @Override // com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305
    @NotNull
    public sk0.a getConfiguration() {
        return this.configuration;
    }

    @Override // com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305
    @NotNull
    public TextureView getView() {
        return a();
    }

    @Override // com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305
    public void pause() {
        FLog.INSTANCE.i("FilamentNativeAppV2305", "pause, " + this);
        BaseSceneV2308 baseSceneV2308 = this.scene;
        if (baseSceneV2308 != null) {
            baseSceneV2308.q();
        }
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void register(@NotNull String type, @NotNull tk0.a action) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(action, "action");
        c().b(type, action);
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void removeEventListener(@NotNull String type, @NotNull b listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            Set<b> set = this.listeners.get(type);
            if (set != null) {
                set.remove(listener);
            }
        }
    }

    @Override // com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305
    public void resume() {
        FLog.INSTANCE.i("FilamentNativeAppV2305", "resume, " + this);
        BaseSceneV2308 baseSceneV2308 = this.scene;
        if (baseSceneV2308 != null) {
            baseSceneV2308.r();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305
    public void startWithEntry(@Nullable c spanContext, @NotNull String entry) {
        BaseSceneV2308 baseSceneV2308;
        Intrinsics.checkNotNullParameter(entry, "entry");
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentNativeAppV2305", "startWithEntry:" + entry + ", " + this);
        switch (entry.hashCode()) {
            case -1597682032:
                if (entry.equals("bundle/scenes/intimate_space/main.js")) {
                    baseSceneV2308 = new IntimateSpaceScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case -1529244261:
                if (entry.equals("bundle/scenes/mini_home/main.js")) {
                    baseSceneV2308 = new MiniHomeScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case -924712062:
                if (entry.equals("bundle/scenes/cartoon/main.js")) {
                    baseSceneV2308 = new CartoonScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case -447012798:
                if (entry.equals("bundle/scenes/tofu_avatar/main.js")) {
                    baseSceneV2308 = new TofuScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case -367123268:
                if (entry.equals("bundle/scenes/multi_cartoon/main.js")) {
                    baseSceneV2308 = new MultiCartoonScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case -122787313:
                if (entry.equals("bundle/scenes/square_avatar/main.js")) {
                    baseSceneV2308 = new SquareAvatarScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case 120129097:
                if (entry.equals("bundle/scenes/multi_avatar/main.js")) {
                    baseSceneV2308 = new CoupleAvatarScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case 145946148:
                if (entry.equals("bundle/scenes/square_map/main.js")) {
                    baseSceneV2308 = new SquareMapScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case 426859948:
                if (entry.equals("bundle/scenes/pinch_face/main.js")) {
                    baseSceneV2308 = new PinchFaceScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case 1218383430:
                if (entry.equals("bundle/scenes/mini_home_connect/main.js")) {
                    baseSceneV2308 = new MiniHomeConnectScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case 1707318535:
                if (entry.equals("bundle/scenes/square_record/main.js")) {
                    baseSceneV2308 = new SquareRecordScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            case 1893813966:
                if (entry.equals("bundle/scenes/gltf_viewer/main.js")) {
                    baseSceneV2308 = new GltfViewerScene(spanContext, new WeakReference(this));
                    break;
                }
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
            default:
                fLog.e("FilamentNativeAppV2305", "no such scene, " + this);
                baseSceneV2308 = null;
                break;
        }
        this.scene = baseSceneV2308;
        if (baseSceneV2308 != null) {
            baseSceneV2308.p(spanContext);
        }
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void unregister(@NotNull String type, @NotNull tk0.a action) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(action, "action");
        c().d(type, action);
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void removeEventListener(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.listeners) {
            this.listeners.remove(type);
        }
    }

    @Override // com.tencent.filament.zplan.app.api.IEventTarget
    public void dispatchEvent(@NotNull tk0.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        c().c(event);
    }
}
