package com.tencent.karaoke.audiobasesdk.scorer;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes7.dex */
final /* synthetic */ class DefaultScoreImpl$unInit$1 extends MutablePropertyReference0 {
    DefaultScoreImpl$unInit$1(DefaultScoreImpl defaultScoreImpl) {
        super(defaultScoreImpl);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return DefaultScoreImpl.access$getResult$p((DefaultScoreImpl) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "result";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DefaultScoreImpl.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getResult()Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResult;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((DefaultScoreImpl) this.receiver).result = (ScoreResult) obj;
    }
}
