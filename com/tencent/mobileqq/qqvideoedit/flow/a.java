package com.tencent.mobileqq.qqvideoedit.flow;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a implements ApplyMaterialTask {
    @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
    public boolean d0(int i3, @NonNull MetaMaterial metaMaterial) {
        return b.a(metaMaterial);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
    public void e0(int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        b.f(aVar);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
    public void f0(ApplyMaterialTask.Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        b.e(aVar);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
    public boolean z(int i3, @NonNull MetaMaterial metaMaterial) {
        return b.b(metaMaterial);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
    public final void Q(int i3, @NonNull MetaMaterial metaMaterial) {
    }

    @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask
    public void Y(int i3, @NonNull MetaMaterial metaMaterial) {
    }
}
