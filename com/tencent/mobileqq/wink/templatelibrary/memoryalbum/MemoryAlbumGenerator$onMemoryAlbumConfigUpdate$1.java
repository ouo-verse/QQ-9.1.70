package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1", f = "MemoryAlbumGenerator.kt", i = {0, 1}, l = {746, 747, 749}, m = "invokeSuspend", n = {"loadLightDeferred", "mediaList"}, s = {"L$0", "L$0"})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MetaCategory> $it;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1(List<MetaCategory> list, Continuation<? super MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1> continuation) {
        super(2, continuation);
        this.$it = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1(this.$it, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004d A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:7:0x0012, B:8:0x008f, B:15:0x0024, B:16:0x0081, B:20:0x002c, B:21:0x0073, B:26:0x0033, B:28:0x003d, B:30:0x0041, B:35:0x004d, B:37:0x0050), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0050 A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:7:0x0012, B:8:0x008f, B:15:0x0024, B:16:0x0081, B:20:0x002c, B:21:0x0073, B:26:0x0033, B:28:0x003d, B:30:0x0041, B:35:0x004d, B:37:0x0050), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        Object firstOrNull;
        boolean z16;
        Deferred<Unit> g16;
        List list;
        Object r06;
        AtomicBoolean atomicBoolean2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Exception e16) {
            MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
            w53.b.c(memoryAlbumGenerator.c(), "onMemoryAlbumConfigUpdate error " + e16.getMessage());
            memoryAlbumGenerator.b0();
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        atomicBoolean2 = MemoryAlbumGenerator.haveGenerated;
                        atomicBoolean2.set(true);
                        atomicBoolean = MemoryAlbumGenerator.isGenerating;
                        atomicBoolean.set(false);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                MemoryAlbumGenerator memoryAlbumGenerator2 = MemoryAlbumGenerator.f326501a;
                this.L$0 = null;
                this.label = 3;
                r06 = memoryAlbumGenerator2.r0(list, this);
                if (r06 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                atomicBoolean2 = MemoryAlbumGenerator.haveGenerated;
                atomicBoolean2.set(true);
                atomicBoolean = MemoryAlbumGenerator.isGenerating;
                atomicBoolean.set(false);
                return Unit.INSTANCE;
            }
            g16 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.$it);
            MetaCategory metaCategory = (MetaCategory) firstOrNull;
            if (metaCategory != null) {
                ArrayList<MetaMaterial> arrayList = metaCategory.materials;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                    if (!z16) {
                        return Unit.INSTANCE;
                    }
                    g16 = WinkMaterialResourceLoader.f325333a.g(new HashMap<>());
                    MemoryAlbumGenerator memoryAlbumGenerator3 = MemoryAlbumGenerator.f326501a;
                    ArrayList<MetaMaterial> arrayList2 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "item.materials");
                    memoryAlbumGenerator3.s0(arrayList2);
                    this.L$0 = g16;
                    this.label = 1;
                    obj = memoryAlbumGenerator3.t0(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
            atomicBoolean = MemoryAlbumGenerator.isGenerating;
            atomicBoolean.set(false);
            return Unit.INSTANCE;
        }
        List list2 = (List) obj;
        this.L$0 = list2;
        this.label = 2;
        if (g16.await(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = list2;
        MemoryAlbumGenerator memoryAlbumGenerator22 = MemoryAlbumGenerator.f326501a;
        this.L$0 = null;
        this.label = 3;
        r06 = memoryAlbumGenerator22.r0(list, this);
        if (r06 == coroutine_suspended) {
        }
        atomicBoolean2 = MemoryAlbumGenerator.haveGenerated;
        atomicBoolean2.set(true);
        atomicBoolean = MemoryAlbumGenerator.isGenerating;
        atomicBoolean.set(false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MemoryAlbumGenerator$onMemoryAlbumConfigUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
