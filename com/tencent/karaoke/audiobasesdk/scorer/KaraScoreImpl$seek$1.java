package com.tencent.karaoke.audiobasesdk.scorer;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes7.dex */
final /* synthetic */ class KaraScoreImpl$seek$1 extends MutablePropertyReference0 {
    KaraScoreImpl$seek$1(KaraScoreImpl karaScoreImpl) {
        super(karaScoreImpl);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return KaraScoreImpl.access$getScoreResult$p((KaraScoreImpl) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "scoreResult";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(KaraScoreImpl.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getScoreResult()Lcom/tencent/karaoke/audiobasesdk/scorer/KaraScoreResult;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((KaraScoreImpl) this.receiver).scoreResult = (KaraScoreResult) obj;
    }
}
