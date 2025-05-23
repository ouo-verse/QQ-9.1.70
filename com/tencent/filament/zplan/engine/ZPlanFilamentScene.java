package com.tencent.filament.zplan.engine;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0019\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0082 J\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0011\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0082 J9\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0082 J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J.\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR$\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "", "", "funcName", "", "a", "", "f", "Lcom/tencent/filament/zplan/engine/CppSceneEnum;", "scene", "", "nCreateScene", "nativeObject", "configJsonString", "nInitScene", "nGetSceneHandle", "nDestroyScene", "", "viewWidth", "viewHeight", "Landroid/view/Surface;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "cppShouldRetain", "nAttach", "e", "c", "b", "J", "<set-?>", "d", "()J", WadlProxyConsts.SCENE_ID, "viewerThreadId", "cppScene", "<init>", "(JLcom/tencent/filament/zplan/engine/CppSceneEnum;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanFilamentScene {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long nativeObject;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long sceneId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long viewerThreadId;

    public ZPlanFilamentScene(long j3, @NotNull CppSceneEnum cppScene) {
        Intrinsics.checkNotNullParameter(cppScene, "cppScene");
        this.viewerThreadId = j3;
        long nCreateScene = nCreateScene(cppScene);
        this.nativeObject = nCreateScene;
        this.sceneId = nGetSceneHandle(nCreateScene);
    }

    private final void a(String funcName) {
        f();
    }

    private final boolean f() {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        if (currentThread.getId() == this.viewerThreadId) {
            return true;
        }
        return false;
    }

    private final native void nAttach(long nativeObject, int viewWidth, int viewHeight, Surface surface, SurfaceTexture surfaceTexture, boolean cppShouldRetain);

    private final native long nCreateScene(CppSceneEnum scene);

    private final native void nDestroyScene(long nativeObject);

    private final native long nGetSceneHandle(long nativeObject);

    private final native void nInitScene(long nativeObject, String configJsonString);

    public final void b(int viewWidth, int viewHeight, @NotNull Surface surface, @NotNull SurfaceTexture surfaceTexture, boolean cppShouldRetain) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        a("attach");
        long j3 = this.nativeObject;
        if (0 == j3) {
            return;
        }
        nAttach(j3, viewWidth, viewHeight, surface, surfaceTexture, cppShouldRetain);
    }

    public final void c() {
        a("destroy");
        long j3 = this.nativeObject;
        if (0 == j3) {
            return;
        }
        nDestroyScene(j3);
        this.nativeObject = 0L;
        this.sceneId = 0L;
    }

    /* renamed from: d, reason: from getter */
    public final long getSceneId() {
        return this.sceneId;
    }

    public final void e() {
        nInitScene(this.nativeObject, FilamentFeatureUtil.f106409g.G());
    }
}
