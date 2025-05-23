package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.filament.Engine;
import com.google.android.filament.Material;
import com.google.android.filament.MaterialInstance;
import com.google.android.filament.VertexBuffer;
import com.google.android.filament.gltfio.MaterialProvider;

/* loaded from: classes2.dex */
public class UbershaderProvider implements MaterialProvider {

    /* renamed from: b, reason: collision with root package name */
    private static final VertexBuffer.VertexAttribute[] f33062b = VertexBuffer.VertexAttribute.values();

    /* renamed from: a, reason: collision with root package name */
    private long f33063a;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33064a;

        static {
            int[] iArr = new int[VertexBuffer.VertexAttribute.values().length];
            f33064a = iArr;
            try {
                iArr[VertexBuffer.VertexAttribute.UV0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33064a[VertexBuffer.VertexAttribute.UV1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33064a[VertexBuffer.VertexAttribute.COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public UbershaderProvider(Engine engine) {
        this.f33063a = nCreateUbershaderProvider(engine.getNativeObject());
    }

    private static native long nCreateMaterialInstance(long j3, MaterialProvider.MaterialKey materialKey, int[] iArr, String str);

    private static native long nCreateUbershaderProvider(long j3);

    private static native void nDestroyMaterials(long j3);

    private static native void nDestroyUbershaderProvider(long j3);

    private static native int nGetMaterialCount(long j3);

    private static native void nGetMaterials(long j3, long[] jArr);

    @Override // com.google.android.filament.gltfio.MaterialProvider
    @Nullable
    public MaterialInstance createMaterialInstance(MaterialProvider.MaterialKey materialKey, @NonNull @Size(min = 8) int[] iArr, @Nullable String str, @Nullable String str2) {
        long nCreateMaterialInstance = nCreateMaterialInstance(this.f33063a, materialKey, iArr, str);
        if (nCreateMaterialInstance == 0) {
            return null;
        }
        return new MaterialInstance((Engine) null, nCreateMaterialInstance);
    }

    @Override // com.google.android.filament.gltfio.MaterialProvider
    public void destroy() {
        nDestroyUbershaderProvider(this.f33063a);
        this.f33063a = 0L;
    }

    @Override // com.google.android.filament.gltfio.MaterialProvider
    public void destroyMaterials() {
        nDestroyMaterials(this.f33063a);
    }

    @Override // com.google.android.filament.gltfio.MaterialProvider
    @NonNull
    public Material[] getMaterials() {
        int nGetMaterialCount = nGetMaterialCount(this.f33063a);
        Material[] materialArr = new Material[nGetMaterialCount];
        long[] jArr = new long[nGetMaterialCount];
        nGetMaterials(this.f33063a, jArr);
        for (int i3 = 0; i3 < nGetMaterialCount; i3++) {
            materialArr[i3] = new Material(jArr[i3]);
        }
        return materialArr;
    }

    @Override // com.google.android.filament.gltfio.MaterialProvider
    public boolean needsDummyData(int i3) {
        int i16 = a.f33064a[f33062b[i3].ordinal()];
        if (i16 == 1 || i16 == 2 || i16 == 3) {
            return true;
        }
        return false;
    }
}
