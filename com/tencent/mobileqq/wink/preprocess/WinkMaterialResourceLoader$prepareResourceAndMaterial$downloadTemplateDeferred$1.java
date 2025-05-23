package com.tencent.mobileqq.wink.preprocess;

import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1", f = "WinkMaterialResourceLoader.kt", i = {0}, l = {118}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
/* loaded from: classes21.dex */
public final class WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HashMap<String, Long> $costMap;
    final /* synthetic */ MetaMaterial $material;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1(MetaMaterial metaMaterial, HashMap<String, Long> hashMap, Continuation<? super WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1> continuation) {
        super(2, continuation);
        this.$material = metaMaterial;
        this.$costMap = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1(this.$material, this.$costMap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        long j16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                j3 = this.J$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
            MetaMaterial metaMaterial = this.$material;
            this.J$0 = elapsedRealtime;
            this.label = 1;
            obj = winkMaterialResourceLoader.b(metaMaterial, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = elapsedRealtime;
        }
        Triple triple = (Triple) obj;
        HashMap<String, Long> hashMap = this.$costMap;
        long j17 = 1;
        if (((Boolean) triple.getSecond()).booleanValue()) {
            j16 = 1;
        } else {
            j16 = 0;
        }
        hashMap.put("needDownloadTemplate", Boxing.boxLong(j16));
        HashMap<String, Long> hashMap2 = this.$costMap;
        if (!((Boolean) triple.getThird()).booleanValue()) {
            j17 = 0;
        }
        hashMap2.put("loadMateResult", Boxing.boxLong(j17));
        this.$costMap.put("loadMateTime", Boxing.boxLong(SystemClock.elapsedRealtime() - j3));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMaterialResourceLoader$prepareResourceAndMaterial$downloadTemplateDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
