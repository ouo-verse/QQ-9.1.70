package com.google.android.filament;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Scene {

    @Nullable
    private IndirectLight mIndirectLight;
    private long mNativeObject;

    @Nullable
    private Skybox mSkybox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scene(long j3) {
        this.mNativeObject = j3;
    }

    private static native void nAddEntities(long j3, int[] iArr);

    private static native void nAddEntity(long j3, int i3);

    private static native int nGetLightCount(long j3);

    private static native int nGetRenderableCount(long j3);

    private static native void nRemove(long j3, int i3);

    private static native void nRemoveEntities(long j3, int[] iArr);

    private static native void nSetIndirectLight(long j3, long j16);

    private static native void nSetSkybox(long j3, long j16);

    public void addEntities(@Entity int[] iArr) {
        nAddEntities(getNativeObject(), iArr);
    }

    public void addEntity(@Entity int i3) {
        nAddEntity(getNativeObject(), i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    @Nullable
    public IndirectLight getIndirectLight() {
        return this.mIndirectLight;
    }

    public int getLightCount() {
        return nGetLightCount(getNativeObject());
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Scene");
    }

    public int getRenderableCount() {
        return nGetRenderableCount(getNativeObject());
    }

    @Nullable
    public Skybox getSkybox() {
        return this.mSkybox;
    }

    @Deprecated
    public void remove(@Entity int i3) {
        removeEntity(i3);
    }

    public void removeEntities(@Entity int[] iArr) {
        nRemoveEntities(getNativeObject(), iArr);
    }

    public void removeEntity(@Entity int i3) {
        nRemove(getNativeObject(), i3);
    }

    public void setIndirectLight(@Nullable IndirectLight indirectLight) {
        long j3;
        this.mIndirectLight = indirectLight;
        long nativeObject = getNativeObject();
        IndirectLight indirectLight2 = this.mIndirectLight;
        if (indirectLight2 != null) {
            j3 = indirectLight2.getNativeObject();
        } else {
            j3 = 0;
        }
        nSetIndirectLight(nativeObject, j3);
    }

    public void setSkybox(@Nullable Skybox skybox) {
        long j3;
        this.mSkybox = skybox;
        long nativeObject = getNativeObject();
        Skybox skybox2 = this.mSkybox;
        if (skybox2 != null) {
            j3 = skybox2.getNativeObject();
        } else {
            j3 = 0;
        }
        nSetSkybox(nativeObject, j3);
    }
}
