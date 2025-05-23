package com.tencent.mobileqq.wink.flow;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class b implements ApplyMaterialTask {
    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public final boolean d0(int i3, @NonNull MetaMaterial metaMaterial) {
        return false;
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void p3(int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        c.f(aVar);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public final boolean z(int i3, @NonNull MetaMaterial metaMaterial) {
        return false;
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public final void Y(int i3, @NonNull MetaMaterial metaMaterial) {
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public final void g(int i3, @NonNull MetaMaterial metaMaterial) {
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public final void F1(ApplyMaterialTask.Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
    }
}
