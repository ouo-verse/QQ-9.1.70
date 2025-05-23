package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.filament.Material;
import com.google.android.filament.MaterialInstance;

/* loaded from: classes2.dex */
public interface MaterialProvider {

    /* loaded from: classes2.dex */
    public static class MaterialKey {
        public int alphaMode;
        public int aoUV;
        public int baseColorUV;
        public int clearCoatNormalUV;
        public int clearCoatRoughnessUV;
        public int clearCoatUV;
        public boolean doubleSided;
        public int emissiveUV;
        public boolean enableDiagnostics;
        public boolean hasBaseColorTexture;
        public boolean hasClearCoat;
        public boolean hasClearCoatNormalTexture;
        public boolean hasClearCoatRoughnessTexture;
        public boolean hasClearCoatTexture;
        public boolean hasEmissiveTexture;
        public boolean hasIOR;
        public boolean hasMetallicRoughnessTexture;
        public boolean hasNormalTexture;
        public boolean hasOcclusionTexture;
        public boolean hasSheen;
        public boolean hasSheenColorTexture;
        public boolean hasSheenRoughnessTexture;
        public boolean hasTextureTransforms;
        public boolean hasTransmission;
        public boolean hasTransmissionTexture;
        public boolean hasVertexColors;
        public boolean hasVolumeThicknessTexture;
        public int metallicRoughnessUV;
        public int normalUV;
        public int sheenColorUV;
        public int sheenRoughnessUV;
        public int transmissionUV;
        public boolean unlit;
        public boolean useSpecularGlossiness;
        public int volumeThicknessUV;

        static {
            nGlobalInit();
        }

        private static native void nConstrainMaterial(MaterialKey materialKey, int[] iArr);

        private static native void nGlobalInit();

        public void constrainMaterial(@NonNull @Size(min = 8) int[] iArr) {
            nConstrainMaterial(this, iArr);
        }
    }

    @Nullable
    MaterialInstance createMaterialInstance(MaterialKey materialKey, @NonNull @Size(min = 8) int[] iArr, @Nullable String str, @Nullable String str2);

    void destroy();

    void destroyMaterials();

    @NonNull
    Material[] getMaterials();

    boolean needsDummyData(int i3);
}
