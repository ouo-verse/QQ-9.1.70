package com.tencent.mobileqq.wink.flow;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface ApplyMaterialTask {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public enum Status {
        ONGOING,
        SUCCEEDED,
        FAILED
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NonNull Status status, int i3);
    }

    void F1(Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull a aVar);

    void Q(int i3, @NonNull MetaMaterial metaMaterial);

    void Y(int i3, @NonNull MetaMaterial metaMaterial);

    boolean d0(int i3, @NonNull MetaMaterial metaMaterial);

    void g(int i3, @NonNull MetaMaterial metaMaterial);

    void p3(int i3, @NonNull MetaMaterial metaMaterial, @NonNull a aVar);

    boolean z(int i3, @NonNull MetaMaterial metaMaterial);
}
