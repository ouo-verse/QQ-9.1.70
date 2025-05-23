package com.tencent.qqnt.aio.adapter.api.impl;

import com.immersion.stickersampleapp.HapticManager;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOHapticApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOHapticApi;", "()V", "addEffectFromSDCard", "", "effectName", "", "effectPath", "addEffects", "pauseEffect", "effectId", "", "playEffect", "priority", "resumeEffect", "stopEffect", "update", "positionMS", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOHapticApiImpl implements IAIOHapticApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public void addEffectFromSDCard(String effectName, String effectPath) {
        Intrinsics.checkNotNullParameter(effectName, "effectName");
        Intrinsics.checkNotNullParameter(effectPath, "effectPath");
        HapticManager.m().d(effectName, effectPath);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public void addEffects() {
        HapticManager.m().e();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public void pauseEffect(int effectId) {
        HapticManager.m().r(effectId);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public int playEffect(String effectName, int priority) {
        return HapticManager.m().s(effectName, priority);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public void resumeEffect(int effectId) {
        HapticManager.m().u(effectId);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public void stopEffect(int effectId) {
        HapticManager.m().w(effectId);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHapticApi
    public void update(int effectId, int positionMS) {
        HapticManager.m().x(effectId, positionMS);
    }
}
