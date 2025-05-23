package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.TritonPlatform;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes23.dex */
final /* synthetic */ class TritonPlatformManager$getTritonPlatform$1 extends MutablePropertyReference0 {
    TritonPlatformManager$getTritonPlatform$1(TritonPlatformManager tritonPlatformManager) {
        super(tritonPlatformManager);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return TritonPlatformManager.access$getPlatform$p((TritonPlatformManager) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "platform";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TritonPlatformManager.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getPlatform()Lcom/tencent/mobileqq/triton/TritonPlatform;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        TritonPlatformManager.platform = (TritonPlatform) obj;
    }
}
