package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.proguard.UsedByReflection;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Engine {
    private static final Backend[] sBackendValues = Backend.values();

    @NonNull
    private final EntityManager mEntityManager;

    @NonNull
    private final LightManager mLightManager;
    private long mNativeObject;

    @NonNull
    private final RenderableManager mRenderableManager;

    @NonNull
    private final TransformManager mTransformManager;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Backend {
        DEFAULT,
        OPENGL,
        VULKAN,
        METAL,
        NOOP
    }

    public Engine(long j3) {
        this.mNativeObject = j3;
        this.mTransformManager = new TransformManager(nGetTransformManager(j3));
        this.mLightManager = new LightManager(nGetLightManager(j3));
        this.mRenderableManager = new RenderableManager(nGetRenderableManager(j3));
        this.mEntityManager = new EntityManager(nGetEntityManager(j3));
    }

    private static void assertDestroy(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalStateException("Object couldn't be destroyed (double destroy()?)");
        }
    }

    private void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    @NonNull
    public static Engine create() {
        long nCreateEngine = nCreateEngine(0L, 0L);
        if (nCreateEngine != 0) {
            return new Engine(nCreateEngine);
        }
        throw new IllegalStateException("Couldn't create Engine");
    }

    private static native long nCreateCamera(long j3, int i3);

    private static native long nCreateEngine(long j3, long j16);

    private static native long nCreateFence(long j3);

    private static native long nCreateRenderer(long j3);

    private static native long nCreateScene(long j3);

    private static native long nCreateSwapChain(long j3, Object obj, long j16);

    private static native long nCreateSwapChainFromRawPointer(long j3, long j16, long j17);

    private static native long nCreateSwapChainHeadless(long j3, int i3, int i16, long j16);

    private static native long nCreateView(long j3);

    private static native void nDestroyCameraComponent(long j3, int i3);

    private static native boolean nDestroyColorGrading(long j3, long j16);

    private static native void nDestroyEngine(long j3);

    private static native void nDestroyEntity(long j3, int i3);

    private static native boolean nDestroyFence(long j3, long j16);

    private static native boolean nDestroyIndexBuffer(long j3, long j16);

    private static native boolean nDestroyIndirectLight(long j3, long j16);

    private static native boolean nDestroyMaterial(long j3, long j16);

    private static native boolean nDestroyMaterialInstance(long j3, long j16);

    private static native boolean nDestroyRenderTarget(long j3, long j16);

    private static native boolean nDestroyRenderer(long j3, long j16);

    private static native boolean nDestroyScene(long j3, long j16);

    private static native boolean nDestroySkinningBuffer(long j3, long j16);

    private static native boolean nDestroySkybox(long j3, long j16);

    private static native boolean nDestroyStream(long j3, long j16);

    private static native boolean nDestroySwapChain(long j3, long j16);

    private static native boolean nDestroyTexture(long j3, long j16);

    private static native boolean nDestroyVertexBuffer(long j3, long j16);

    private static native boolean nDestroyView(long j3, long j16);

    private static native void nFlushAndWait(long j3);

    private static native long nGetBackend(long j3);

    private static native long nGetCameraComponent(long j3, int i3);

    private static native long nGetEntityManager(long j3);

    private static native long nGetJobSystem(long j3);

    private static native long nGetLightManager(long j3);

    private static native long nGetRenderableManager(long j3);

    private static native long nGetTransformManager(long j3);

    private static native boolean nIsAutomaticInstancingEnabled(long j3);

    private static native void nSetAutomaticInstancingEnabled(long j3, boolean z16);

    @NonNull
    public Camera createCamera(@Entity int i3) {
        long nCreateCamera = nCreateCamera(getNativeObject(), i3);
        if (nCreateCamera != 0) {
            return new Camera(nCreateCamera, i3);
        }
        throw new IllegalStateException("Couldn't create Camera");
    }

    @NonNull
    public Fence createFence() {
        long nCreateFence = nCreateFence(getNativeObject());
        if (nCreateFence != 0) {
            return new Fence(nCreateFence);
        }
        throw new IllegalStateException("Couldn't create Fence");
    }

    @NonNull
    public Renderer createRenderer() {
        long nCreateRenderer = nCreateRenderer(getNativeObject());
        if (nCreateRenderer != 0) {
            return new Renderer(this, nCreateRenderer);
        }
        throw new IllegalStateException("Couldn't create Renderer");
    }

    @NonNull
    public Scene createScene() {
        long nCreateScene = nCreateScene(getNativeObject());
        if (nCreateScene != 0) {
            return new Scene(nCreateScene);
        }
        throw new IllegalStateException("Couldn't create Scene");
    }

    @NonNull
    public SwapChain createSwapChain(@NonNull Object obj) {
        return createSwapChain(obj, 0L);
    }

    @NonNull
    public SwapChain createSwapChainFromNativeSurface(@NonNull NativeSurface nativeSurface, long j3) {
        long nCreateSwapChainFromRawPointer = nCreateSwapChainFromRawPointer(getNativeObject(), nativeSurface.getNativeObject(), j3);
        if (nCreateSwapChainFromRawPointer != 0) {
            return new SwapChain(nCreateSwapChainFromRawPointer, nativeSurface);
        }
        throw new IllegalStateException("Couldn't create SwapChain");
    }

    @NonNull
    public View createView() {
        long nCreateView = nCreateView(getNativeObject());
        if (nCreateView != 0) {
            return new View(nCreateView);
        }
        throw new IllegalStateException("Couldn't create View");
    }

    public void destroy() {
        nDestroyEngine(getNativeObject());
        clearNativeObject();
    }

    public void destroyCameraComponent(@Entity int i3) {
        nDestroyCameraComponent(getNativeObject(), i3);
    }

    public void destroyColorGrading(@NonNull ColorGrading colorGrading) {
        assertDestroy(nDestroyColorGrading(getNativeObject(), colorGrading.b()));
        colorGrading.a();
    }

    public void destroyEntity(@Entity int i3) {
        nDestroyEntity(getNativeObject(), i3);
    }

    public void destroyFence(@NonNull Fence fence) {
        assertDestroy(nDestroyFence(getNativeObject(), fence.getNativeObject()));
        fence.clearNativeObject();
    }

    public void destroyIndexBuffer(@NonNull IndexBuffer indexBuffer) {
        assertDestroy(nDestroyIndexBuffer(getNativeObject(), indexBuffer.getNativeObject()));
        indexBuffer.clearNativeObject();
    }

    public void destroyIndirectLight(@NonNull IndirectLight indirectLight) {
        assertDestroy(nDestroyIndirectLight(getNativeObject(), indirectLight.getNativeObject()));
        indirectLight.clearNativeObject();
    }

    public void destroyMaterial(@NonNull Material material) {
        assertDestroy(nDestroyMaterial(getNativeObject(), material.getNativeObject()));
        material.clearNativeObject();
    }

    public void destroyMaterialInstance(@NonNull MaterialInstance materialInstance) {
        assertDestroy(nDestroyMaterialInstance(getNativeObject(), materialInstance.getNativeObject()));
        materialInstance.clearNativeObject();
    }

    public void destroyRenderTarget(@NonNull RenderTarget renderTarget) {
        nDestroyRenderTarget(getNativeObject(), renderTarget.getNativeObject());
        renderTarget.clearNativeObject();
    }

    public void destroyRenderer(@NonNull Renderer renderer) {
        assertDestroy(nDestroyRenderer(getNativeObject(), renderer.getNativeObject()));
        renderer.clearNativeObject();
    }

    public void destroyScene(@NonNull Scene scene) {
        assertDestroy(nDestroyScene(getNativeObject(), scene.getNativeObject()));
        scene.clearNativeObject();
    }

    public void destroySkinningBuffer(@NonNull SkinningBuffer skinningBuffer) {
        assertDestroy(nDestroySkinningBuffer(getNativeObject(), skinningBuffer.b()));
        skinningBuffer.a();
    }

    public void destroySkybox(@NonNull Skybox skybox) {
        assertDestroy(nDestroySkybox(getNativeObject(), skybox.getNativeObject()));
        skybox.clearNativeObject();
    }

    public void destroyStream(@NonNull Stream stream) {
        assertDestroy(nDestroyStream(getNativeObject(), stream.getNativeObject()));
        stream.clearNativeObject();
    }

    public void destroySwapChain(@NonNull SwapChain swapChain) {
        assertDestroy(nDestroySwapChain(getNativeObject(), swapChain.getNativeObject()));
        swapChain.clearNativeObject();
    }

    public void destroyTexture(@NonNull Texture texture) {
        assertDestroy(nDestroyTexture(getNativeObject(), texture.getNativeObject()));
        texture.clearNativeObject();
    }

    public void destroyVertexBuffer(@NonNull VertexBuffer vertexBuffer) {
        assertDestroy(nDestroyVertexBuffer(getNativeObject(), vertexBuffer.getNativeObject()));
        vertexBuffer.clearNativeObject();
    }

    public void destroyView(@NonNull View view) {
        assertDestroy(nDestroyView(getNativeObject(), view.getNativeObject()));
        view.clearNativeObject();
    }

    public void enableAccurateTranslations() {
        getTransformManager().setAccurateTranslationsEnabled(true);
    }

    public void flushAndWait() {
        nFlushAndWait(getNativeObject());
    }

    @NonNull
    public Backend getBackend() {
        return sBackendValues[(int) nGetBackend(getNativeObject())];
    }

    @Nullable
    public Camera getCameraComponent(@Entity int i3) {
        long nGetCameraComponent = nGetCameraComponent(getNativeObject(), i3);
        if (nGetCameraComponent == 0) {
            return null;
        }
        return new Camera(nGetCameraComponent, i3);
    }

    @NonNull
    public EntityManager getEntityManager() {
        return this.mEntityManager;
    }

    @NonNull
    public LightManager getLightManager() {
        return this.mLightManager;
    }

    @UsedByReflection("MaterialBuilder.java")
    public long getNativeJobSystem() {
        if (this.mNativeObject != 0) {
            return nGetJobSystem(getNativeObject());
        }
        throw new IllegalStateException("Calling method on destroyed Engine");
    }

    @UsedByReflection("TextureHelper.java")
    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Engine");
    }

    @NonNull
    public RenderableManager getRenderableManager() {
        return this.mRenderableManager;
    }

    @NonNull
    public TransformManager getTransformManager() {
        return this.mTransformManager;
    }

    public boolean isAutomaticInstancingEnabled() {
        return nIsAutomaticInstancingEnabled(getNativeObject());
    }

    public boolean isValid() {
        if (this.mNativeObject != 0) {
            return true;
        }
        return false;
    }

    public void setAutomaticInstancingEnabled(boolean z16) {
        nSetAutomaticInstancingEnabled(getNativeObject(), z16);
    }

    @NonNull
    public SwapChain createSwapChain(@NonNull Object obj, long j3) {
        if (Platform.get().validateSurface(obj)) {
            long nCreateSwapChain = nCreateSwapChain(getNativeObject(), obj, j3);
            if (nCreateSwapChain != 0) {
                return new SwapChain(nCreateSwapChain, obj);
            }
            throw new IllegalStateException("Couldn't create SwapChain");
        }
        throw new IllegalArgumentException("Invalid surface " + obj);
    }

    @NonNull
    public static Engine create(@NonNull Backend backend) {
        long nCreateEngine = nCreateEngine(backend.ordinal(), 0L);
        if (nCreateEngine != 0) {
            return new Engine(nCreateEngine);
        }
        throw new IllegalStateException("Couldn't create Engine");
    }

    @NonNull
    public static Engine create(@NonNull Object obj) {
        if (Platform.get().validateSharedContext(obj)) {
            long nCreateEngine = nCreateEngine(0L, Platform.get().getSharedContextNativeHandle(obj));
            if (nCreateEngine != 0) {
                return new Engine(nCreateEngine);
            }
            throw new IllegalStateException("Couldn't create Engine");
        }
        throw new IllegalArgumentException("Invalid shared context " + obj);
    }

    @NonNull
    public SwapChain createSwapChain(int i3, int i16, long j3) {
        if (i3 >= 0 && i16 >= 0) {
            long nCreateSwapChainHeadless = nCreateSwapChainHeadless(getNativeObject(), i3, i16, j3);
            if (nCreateSwapChainHeadless != 0) {
                return new SwapChain(nCreateSwapChainHeadless, null);
            }
            throw new IllegalStateException("Couldn't create SwapChain");
        }
        throw new IllegalArgumentException("Invalid parameters");
    }
}
