package com.google.android.filament.gltfio;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FilamentInstance {

    /* renamed from: a, reason: collision with root package name */
    private FilamentAsset f33059a;

    /* renamed from: b, reason: collision with root package name */
    private long f33060b;

    /* renamed from: c, reason: collision with root package name */
    private Animator f33061c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilamentInstance(FilamentAsset filamentAsset, long j3) {
        this.f33059a = filamentAsset;
        this.f33060b = j3;
    }

    private static native void nApplyMaterialVariant(long j3, int i3);

    private static native long nGetAnimator(long j3);

    private static native void nGetEntities(long j3, int[] iArr);

    private static native int nGetEntityCount(long j3);

    private static native int nGetRoot(long j3);
}
