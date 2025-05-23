package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.VertexBuffer;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RenderableManager {
    private static final String LOG_TAG = "Filament";
    private static final VertexBuffer.VertexAttribute[] sVertexAttributeValues = VertexBuffer.VertexAttribute.values();
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final BuilderFinalizer mFinalizer;
        private final long mNativeBuilder;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class BuilderFinalizer {
            private final long mNativeObject;

            BuilderFinalizer(long j3) {
                this.mNativeObject = j3;
            }

            public void finalize() {
                try {
                    super.finalize();
                } catch (Throwable unused) {
                }
                RenderableManager.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder(@IntRange(from = 1) int i3) {
            long nCreateBuilder = RenderableManager.nCreateBuilder(i3);
            this.mNativeBuilder = nCreateBuilder;
            this.mFinalizer = new BuilderFinalizer(nCreateBuilder);
        }

        @NonNull
        public Builder blendOrder(@IntRange(from = 0) int i3, @IntRange(from = 0, to = 32767) int i16) {
            RenderableManager.nBuilderBlendOrder(this.mNativeBuilder, i3, i16);
            return this;
        }

        @NonNull
        public Builder boundingBox(@NonNull Box box) {
            RenderableManager.nBuilderBoundingBox(this.mNativeBuilder, box.getCenter()[0], box.getCenter()[1], box.getCenter()[2], box.getHalfExtent()[0], box.getHalfExtent()[1], box.getHalfExtent()[2]);
            return this;
        }

        public void build(@NonNull Engine engine, @Entity int i3) {
            if (RenderableManager.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject(), i3)) {
                return;
            }
            throw new IllegalStateException("Couldn't create Renderable component for entity " + i3 + ", see log.");
        }

        @NonNull
        public Builder castShadows(boolean z16) {
            RenderableManager.nBuilderCastShadows(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder culling(boolean z16) {
            RenderableManager.nBuilderCulling(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder enableSkinningBuffers(boolean z16) {
            RenderableManager.nEnableSkinningBuffers(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder geometry(@IntRange(from = 0) int i3, @NonNull PrimitiveType primitiveType, @NonNull VertexBuffer vertexBuffer, @NonNull IndexBuffer indexBuffer, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @IntRange(from = 0) int i19) {
            RenderableManager.nBuilderGeometry(this.mNativeBuilder, i3, primitiveType.getValue(), vertexBuffer.getNativeObject(), indexBuffer.getNativeObject(), i16, i17, i18, i19);
            return this;
        }

        @NonNull
        public Builder globalBlendOrderEnabled(@IntRange(from = 0) int i3, boolean z16) {
            RenderableManager.nBuilderGlobalBlendOrderEnabled(this.mNativeBuilder, i3, z16);
            return this;
        }

        @NonNull
        public Builder instances(@IntRange(from = 1, to = 65535) int i3) {
            RenderableManager.nBuilderInstances(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder layerMask(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16) {
            RenderableManager.nBuilderLayerMask(this.mNativeBuilder, i3 & 255, i16 & 255);
            return this;
        }

        @NonNull
        public Builder lightChannel(@IntRange(from = 0, to = 7) int i3, boolean z16) {
            RenderableManager.nBuilderLightChannel(this.mNativeBuilder, i3, z16);
            return this;
        }

        @NonNull
        public Builder material(@IntRange(from = 0) int i3, @NonNull MaterialInstance materialInstance) {
            RenderableManager.nBuilderMaterial(this.mNativeBuilder, i3, materialInstance.getNativeObject());
            return this;
        }

        @NonNull
        public Builder morphing(@IntRange(from = 0, to = 255) int i3) {
            RenderableManager.nBuilderMorphing(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder priority(@IntRange(from = 0, to = 7) int i3) {
            RenderableManager.nBuilderPriority(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder receiveShadows(boolean z16) {
            RenderableManager.nBuilderReceiveShadows(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder screenSpaceContactShadows(boolean z16) {
            RenderableManager.nBuilderScreenSpaceContactShadows(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder skinning(SkinningBuffer skinningBuffer, @IntRange(from = 0, to = 255) int i3, int i16) {
            RenderableManager.nBuilderSkinningBuffer(this.mNativeBuilder, skinningBuffer != null ? skinningBuffer.b() : 0L, i3, i16);
            return this;
        }

        @NonNull
        public Builder morphing(@IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @NonNull MorphTargetBuffer morphTargetBuffer, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18) {
            RenderableManager.nBuilderSetMorphTargetBufferAt(this.mNativeBuilder, i3, i16, morphTargetBuffer.a(), i17, i18);
            return this;
        }

        @NonNull
        public Builder geometry(@IntRange(from = 0) int i3, @NonNull PrimitiveType primitiveType, @NonNull VertexBuffer vertexBuffer, @NonNull IndexBuffer indexBuffer, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17) {
            RenderableManager.nBuilderGeometry(this.mNativeBuilder, i3, primitiveType.getValue(), vertexBuffer.getNativeObject(), indexBuffer.getNativeObject(), i16, i17);
            return this;
        }

        @NonNull
        public Builder skinning(@IntRange(from = 0, to = 255) int i3) {
            RenderableManager.nBuilderSkinning(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder morphing(@IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @NonNull MorphTargetBuffer morphTargetBuffer) {
            RenderableManager.nBuilderSetMorphTargetBufferAt(this.mNativeBuilder, i3, i16, morphTargetBuffer.a(), 0, morphTargetBuffer.b());
            return this;
        }

        @NonNull
        public Builder skinning(@IntRange(from = 0, to = 255) int i3, @NonNull Buffer buffer) {
            if (RenderableManager.nBuilderSkinningBones(this.mNativeBuilder, i3, buffer, buffer.remaining()) >= 0) {
                return this;
            }
            throw new BufferOverflowException();
        }

        @NonNull
        public Builder geometry(@IntRange(from = 0) int i3, @NonNull PrimitiveType primitiveType, @NonNull VertexBuffer vertexBuffer, @NonNull IndexBuffer indexBuffer) {
            RenderableManager.nBuilderGeometry(this.mNativeBuilder, i3, primitiveType.getValue(), vertexBuffer.getNativeObject(), indexBuffer.getNativeObject());
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum PrimitiveType {
        POINTS(0),
        LINES(1),
        LINE_STRIP(3),
        TRIANGLES(4),
        TRIANGLE_STRIP(5);

        private final int mType;

        PrimitiveType(int i3) {
            this.mType = i3;
        }

        int getValue() {
            return this.mType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderableManager(long j3) {
        this.mNativeObject = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderBlendOrder(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderBoundingBox(long j3, float f16, float f17, float f18, float f19, float f26, float f27);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nBuilderBuild(long j3, long j16, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderCastShadows(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderCulling(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderGeometry(long j3, int i3, int i16, long j16, long j17);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderGeometry(long j3, int i3, int i16, long j16, long j17, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderGeometry(long j3, int i3, int i16, long j16, long j17, int i17, int i18, int i19, int i26);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderGlobalBlendOrderEnabled(long j3, int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderInstances(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderLayerMask(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderLightChannel(long j3, int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderMaterial(long j3, int i3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderMorphing(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderPriority(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderReceiveShadows(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderScreenSpaceContactShadows(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderSetMorphTargetBufferAt(long j3, int i3, int i16, long j16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderSkinning(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nBuilderSkinningBones(long j3, int i3, Buffer buffer, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderSkinningBuffer(long j3, long j16, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nCreateBuilder(int i3);

    private static native void nDestroy(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nEnableSkinningBuffers(long j3, boolean z16);

    private static native void nGetAxisAlignedBoundingBox(long j3, int i3, float[] fArr, float[] fArr2);

    private static native int nGetEnabledAttributesAt(long j3, int i3, int i16);

    private static native int nGetInstance(long j3, int i3);

    private static native boolean nGetLightChannel(long j3, int i3, int i16);

    private static native long nGetMaterialInstanceAt(long j3, int i3, int i16);

    private static native int nGetMorphTargetCount(long j3, int i3);

    private static native int nGetPrimitiveCount(long j3, int i3);

    private static native boolean nHasComponent(long j3, int i3);

    private static native boolean nIsShadowCaster(long j3, int i3);

    private static native boolean nIsShadowReceiver(long j3, int i3);

    private static native void nSetAxisAlignedBoundingBox(long j3, int i3, float f16, float f17, float f18, float f19, float f26, float f27);

    private static native void nSetBlendOrderAt(long j3, int i3, int i16, int i17);

    private static native int nSetBonesAsMatrices(long j3, int i3, Buffer buffer, int i16, int i17, int i18);

    private static native int nSetBonesAsQuaternions(long j3, int i3, Buffer buffer, int i16, int i17, int i18);

    private static native void nSetCastShadows(long j3, int i3, boolean z16);

    private static native void nSetCulling(long j3, int i3, boolean z16);

    private static native void nSetGeometryAt(long j3, int i3, int i16, int i17, long j16, long j17, int i18, int i19);

    private static native void nSetGlobalBlendOrderEnabledAt(long j3, int i3, int i16, boolean z16);

    private static native void nSetLayerMask(long j3, int i3, int i16, int i17);

    private static native void nSetLightChannel(long j3, int i3, int i16, boolean z16);

    private static native void nSetMaterialInstanceAt(long j3, int i3, int i16, long j16);

    private static native void nSetMorphTargetBufferAt(long j3, int i3, int i16, int i17, long j16, int i18, int i19);

    private static native void nSetMorphWeights(long j3, int i3, float[] fArr, int i16);

    private static native void nSetPriority(long j3, int i3, int i16);

    private static native void nSetReceiveShadows(long j3, int i3, boolean z16);

    private static native void nSetScreenSpaceContactShadows(long j3, int i3, boolean z16);

    private static native void nSetSkinningBuffer(long j3, int i3, long j16, int i16, int i17);

    public void destroy(@Entity int i3) {
        nDestroy(this.mNativeObject, i3);
    }

    @NonNull
    public Box getAxisAlignedBoundingBox(@EntityInstance int i3, @Nullable Box box) {
        if (box == null) {
            box = new Box();
        }
        nGetAxisAlignedBoundingBox(this.mNativeObject, i3, box.getCenter(), box.getHalfExtent());
        return box;
    }

    public Set<VertexBuffer.VertexAttribute> getEnabledAttributesAt(@EntityInstance int i3, @IntRange(from = 0) int i16) {
        int nGetEnabledAttributesAt = nGetEnabledAttributesAt(this.mNativeObject, i3, i16);
        EnumSet noneOf = EnumSet.noneOf(VertexBuffer.VertexAttribute.class);
        VertexBuffer.VertexAttribute[] vertexAttributeArr = sVertexAttributeValues;
        for (int i17 = 0; i17 < vertexAttributeArr.length; i17++) {
            if (((1 << i17) & nGetEnabledAttributesAt) != 0) {
                noneOf.add(vertexAttributeArr[i17]);
            }
        }
        return Collections.unmodifiableSet(noneOf);
    }

    @EntityInstance
    public int getInstance(@Entity int i3) {
        return nGetInstance(this.mNativeObject, i3);
    }

    public boolean getLightChannel(@EntityInstance int i3, @IntRange(from = 0, to = 7) int i16) {
        return nGetLightChannel(this.mNativeObject, i3, i16);
    }

    @NonNull
    public MaterialInstance getMaterialInstanceAt(@EntityInstance int i3, @IntRange(from = 0) int i16) {
        return new MaterialInstance(nGetMaterialInstanceAt(this.mNativeObject, i3, i16));
    }

    @IntRange(from = 0)
    public int getMorphTargetCount(@EntityInstance int i3) {
        return nGetMorphTargetCount(this.mNativeObject, i3);
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    @IntRange(from = 0)
    public int getPrimitiveCount(@EntityInstance int i3) {
        return nGetPrimitiveCount(this.mNativeObject, i3);
    }

    public boolean hasComponent(@Entity int i3) {
        return nHasComponent(this.mNativeObject, i3);
    }

    public boolean isShadowCaster(@EntityInstance int i3) {
        return nIsShadowCaster(this.mNativeObject, i3);
    }

    public boolean isShadowReceiver(@EntityInstance int i3) {
        return nIsShadowReceiver(this.mNativeObject, i3);
    }

    public void setAxisAlignedBoundingBox(@EntityInstance int i3, @NonNull Box box) {
        nSetAxisAlignedBoundingBox(this.mNativeObject, i3, box.getCenter()[0], box.getCenter()[1], box.getCenter()[2], box.getHalfExtent()[0], box.getHalfExtent()[1], box.getHalfExtent()[2]);
    }

    public void setBlendOrderAt(@EntityInstance int i3, @IntRange(from = 0) int i16, @IntRange(from = 0, to = 65535) int i17) {
        nSetBlendOrderAt(this.mNativeObject, i3, i16, i17);
    }

    public void setBonesAsMatrices(@EntityInstance int i3, @NonNull Buffer buffer, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0) int i17) {
        if (nSetBonesAsMatrices(this.mNativeObject, i3, buffer, buffer.remaining(), i16, i17) >= 0) {
        } else {
            throw new BufferOverflowException();
        }
    }

    public void setBonesAsQuaternions(@EntityInstance int i3, @NonNull Buffer buffer, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0) int i17) {
        if (nSetBonesAsQuaternions(this.mNativeObject, i3, buffer, buffer.remaining(), i16, i17) >= 0) {
        } else {
            throw new BufferOverflowException();
        }
    }

    public void setCastShadows(@EntityInstance int i3, boolean z16) {
        nSetCastShadows(this.mNativeObject, i3, z16);
    }

    public void setCulling(@EntityInstance int i3, boolean z16) {
        nSetCulling(this.mNativeObject, i3, z16);
    }

    public void setGeometryAt(@EntityInstance int i3, @IntRange(from = 0) int i16, @NonNull PrimitiveType primitiveType, @NonNull VertexBuffer vertexBuffer, @NonNull IndexBuffer indexBuffer, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18) {
        nSetGeometryAt(this.mNativeObject, i3, i16, primitiveType.getValue(), vertexBuffer.getNativeObject(), indexBuffer.getNativeObject(), i17, i18);
    }

    public void setGlobalBlendOrderEnabledAt(@EntityInstance int i3, @IntRange(from = 0) int i16, boolean z16) {
        nSetGlobalBlendOrderEnabledAt(this.mNativeObject, i3, i16, z16);
    }

    public void setLayerMask(@EntityInstance int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17) {
        nSetLayerMask(this.mNativeObject, i3, i16, i17);
    }

    public void setLightChannel(@EntityInstance int i3, @IntRange(from = 0, to = 7) int i16, boolean z16) {
        nSetLightChannel(this.mNativeObject, i3, i16, z16);
    }

    public void setMaterialInstanceAt(@EntityInstance int i3, @IntRange(from = 0) int i16, @NonNull MaterialInstance materialInstance) {
        int requiredAttributesAsInt = materialInstance.getMaterial().getRequiredAttributesAsInt();
        if ((nGetEnabledAttributesAt(this.mNativeObject, i3, i16) & requiredAttributesAsInt) != requiredAttributesAsInt) {
            Platform.get().warn("setMaterialInstanceAt() on primitive " + i16 + " of Renderable at " + i3 + ": declared attributes " + getEnabledAttributesAt(i3, i16) + " do no satisfy required attributes " + materialInstance.getMaterial().getRequiredAttributes());
        }
        nSetMaterialInstanceAt(this.mNativeObject, i3, i16, materialInstance.getNativeObject());
    }

    public void setMorphTargetBufferAt(@EntityInstance int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @NonNull MorphTargetBuffer morphTargetBuffer, @IntRange(from = 0) int i18, @IntRange(from = 0) int i19) {
        nSetMorphTargetBufferAt(this.mNativeObject, i3, i16, i17, morphTargetBuffer.a(), i18, i19);
    }

    public void setMorphWeights(@EntityInstance int i3, @NonNull float[] fArr, @IntRange(from = 0) int i16) {
        nSetMorphWeights(this.mNativeObject, i3, fArr, i16);
    }

    public void setPriority(@EntityInstance int i3, @IntRange(from = 0, to = 7) int i16) {
        nSetPriority(this.mNativeObject, i3, i16);
    }

    public void setReceiveShadows(@EntityInstance int i3, boolean z16) {
        nSetReceiveShadows(this.mNativeObject, i3, z16);
    }

    public void setScreenSpaceContactShadows(@EntityInstance int i3, boolean z16) {
        nSetScreenSpaceContactShadows(this.mNativeObject, i3, z16);
    }

    public void setSkinningBuffer(@EntityInstance int i3, @NonNull SkinningBuffer skinningBuffer, int i16, int i17) {
        nSetSkinningBuffer(this.mNativeObject, i3, skinningBuffer.b(), i16, i17);
    }

    public void setGeometryAt(@EntityInstance int i3, @IntRange(from = 0) int i16, @NonNull PrimitiveType primitiveType, @NonNull VertexBuffer vertexBuffer, @NonNull IndexBuffer indexBuffer) {
        nSetGeometryAt(this.mNativeObject, i3, i16, primitiveType.getValue(), vertexBuffer.getNativeObject(), indexBuffer.getNativeObject(), 0, indexBuffer.getIndexCount());
    }

    public void setMorphTargetBufferAt(@EntityInstance int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @NonNull MorphTargetBuffer morphTargetBuffer) {
        nSetMorphTargetBufferAt(this.mNativeObject, i3, i16, i17, morphTargetBuffer.a(), 0, morphTargetBuffer.b());
    }
}
