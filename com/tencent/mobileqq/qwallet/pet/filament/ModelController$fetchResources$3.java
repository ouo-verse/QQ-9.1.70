package com.tencent.mobileqq.qwallet.pet.filament;

import com.google.android.filament.gltfio.Animator;
import com.google.android.filament.gltfio.FilamentAsset;
import com.google.android.filament.gltfio.ResourceLoader;
import com.tencent.mobileqq.qwallet.pet.data.PetReportBean;
import com.tencent.mobileqq.qwallet.pet.filament.ModelController;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.filament.ModelController$fetchResources$3", f = "ModelController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class ModelController$fetchResources$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilamentAsset $asset;
    final /* synthetic */ ModelController.a $callback;
    final /* synthetic */ HashMap<String, Buffer> $items;
    int label;
    final /* synthetic */ ModelController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelController$fetchResources$3(HashMap<String, Buffer> hashMap, ModelController modelController, FilamentAsset filamentAsset, ModelController.a aVar, Continuation<? super ModelController$fetchResources$3> continuation) {
        super(2, continuation);
        this.$items = hashMap;
        this.this$0 = modelController;
        this.$asset = filamentAsset;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ModelController$fetchResources$3(this.$items, this.this$0, this.$asset, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PetReportBean petReportBean;
        ResourceLoader resourceLoader;
        AtomicBoolean atomicBoolean;
        d dVar;
        ResourceLoader resourceLoader2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            for (Map.Entry<String, Buffer> entry : this.$items.entrySet()) {
                String key = entry.getKey();
                Buffer value = entry.getValue();
                resourceLoader2 = this.this$0.resourceLoader;
                resourceLoader2.addResourceData(key, value);
            }
            petReportBean = this.this$0.reportBean;
            petReportBean.a((int) (System.currentTimeMillis() - currentTimeMillis));
            resourceLoader = this.this$0.resourceLoader;
            resourceLoader.asyncBeginLoad(this.$asset);
            atomicBoolean = this.this$0.isBeginLoad;
            atomicBoolean.set(true);
            dVar = this.this$0.modelAnimator;
            Animator animator = this.$asset.getAnimator();
            Intrinsics.checkNotNullExpressionValue(animator, "asset.animator");
            dVar.c(animator);
            this.$asset.releaseSourceData();
            this.$callback.a();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ModelController$fetchResources$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
