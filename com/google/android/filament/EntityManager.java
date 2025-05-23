package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.filament.proguard.UsedByReflection;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EntityManager {
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class Holder {
        static final EntityManager INSTANCE = new EntityManager();

        Holder() {
        }
    }

    @NonNull
    public static EntityManager get() {
        return Holder.INSTANCE;
    }

    private static native int nCreate(long j3);

    private static native void nCreateArray(long j3, int i3, int[] iArr);

    private static native void nDestroy(long j3, int i3);

    private static native void nDestroyArray(long j3, int i3, int[] iArr);

    private static native long nGetEntityManager();

    private static native boolean nIsAlive(long j3, int i3);

    @Entity
    public int create() {
        return nCreate(this.mNativeObject);
    }

    public void destroy(@Entity int i3) {
        nDestroy(this.mNativeObject, i3);
    }

    @UsedByReflection("AssetLoader.java")
    public long getNativeObject() {
        return this.mNativeObject;
    }

    public boolean isAlive(@Entity int i3) {
        return nIsAlive(this.mNativeObject, i3);
    }

    EntityManager() {
        this.mNativeObject = nGetEntityManager();
    }

    @NonNull
    @Entity
    public int[] create(@IntRange(from = 1) int i3) {
        if (i3 >= 1) {
            int[] iArr = new int[i3];
            nCreateArray(this.mNativeObject, i3, iArr);
            return iArr;
        }
        throw new ArrayIndexOutOfBoundsException("n must be at least 1");
    }

    public void destroy(@NonNull @Entity int[] iArr) {
        nDestroyArray(this.mNativeObject, iArr.length, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EntityManager(long j3) {
        nGetEntityManager();
        this.mNativeObject = j3;
    }

    @NonNull
    public int[] create(@NonNull @Entity int[] iArr) {
        nCreateArray(this.mNativeObject, iArr.length, iArr);
        return iArr;
    }
}
