package com.tencent.mobileqq.qqvideoedit.flow;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ApplyMaterialTask {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public enum Status {
        ONGOING,
        SUCCEEDED,
        FAILED
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(@NonNull Status status, int i3);
    }

    void Q(int i3, @NonNull MetaMaterial metaMaterial);

    void Y(int i3, @NonNull MetaMaterial metaMaterial);

    boolean d0(int i3, @NonNull MetaMaterial metaMaterial);

    void e0(int i3, @NonNull MetaMaterial metaMaterial, @NonNull a aVar);

    void f0(Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull a aVar);

    void g(int i3, @NonNull MetaMaterial metaMaterial);

    boolean z(int i3, @NonNull MetaMaterial metaMaterial);
}
