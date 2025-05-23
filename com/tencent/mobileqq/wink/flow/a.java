package com.tencent.mobileqq.wink.flow;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class a implements ApplyMaterialTask {
    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void F1(ApplyMaterialTask.Status status, int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        c.e(aVar);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean d0(int i3, @NonNull MetaMaterial metaMaterial) {
        return c.a(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void p3(int i3, @NonNull MetaMaterial metaMaterial, @NonNull ApplyMaterialTask.a aVar) {
        c.f(aVar);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean z(int i3, @NonNull MetaMaterial metaMaterial) {
        return c.b(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public final void Q(int i3, @NonNull MetaMaterial metaMaterial) {
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Y(int i3, @NonNull MetaMaterial metaMaterial) {
    }
}
