package com.tencent.karaoke.audiobasesdk.scorer;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes7.dex */
final /* synthetic */ class DefaultScoreImpl$stop$1 extends MutablePropertyReference0 {
    DefaultScoreImpl$stop$1(DefaultScoreImpl defaultScoreImpl) {
        super(defaultScoreImpl);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return DefaultScoreImpl.access$getScoreHandler$p((DefaultScoreImpl) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "scoreHandler";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DefaultScoreImpl.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getScoreHandler()Landroid/os/Handler;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((DefaultScoreImpl) this.receiver).scoreHandler = (Handler) obj;
    }
}
