package com.tencent.mobileqq.nearbypro.map.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.map.part.PreloadPart$preloadMarkerView$1", f = "PreloadPart.kt", i = {0}, l = {56}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
/* loaded from: classes15.dex */
public final class PreloadPart$preloadMarkerView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PreloadPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPart$preloadMarkerView$1(PreloadPart preloadPart, Continuation<? super PreloadPart$preloadMarkerView$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PreloadPart$preloadMarkerView$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0058 -> B:5:0x005f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List H9;
        Iterator it;
        PreloadPart preloadPart;
        PreloadPart$preloadMarkerView$1 preloadPart$preloadMarkerView$1;
        Object J9;
        HashMap hashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                InflateConfig inflateConfig = (InflateConfig) this.L$2;
                Iterator it5 = (Iterator) this.L$1;
                PreloadPart preloadPart2 = (PreloadPart) this.L$0;
                ResultKt.throwOnFailure(obj);
                PreloadPart preloadPart3 = preloadPart2;
                Iterator it6 = it5;
                InflateConfig inflateConfig2 = inflateConfig;
                Object obj2 = coroutine_suspended;
                PreloadPart$preloadMarkerView$1 preloadPart$preloadMarkerView$12 = this;
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList != null) {
                    hashMap = preloadPart3.markerCacheViewMap;
                    hashMap.put(Boxing.boxInt(inflateConfig2.getInflateId()), arrayList);
                }
                preloadPart$preloadMarkerView$1 = preloadPart$preloadMarkerView$12;
                coroutine_suspended = obj2;
                it = it6;
                preloadPart = preloadPart3;
                if (it.hasNext()) {
                    InflateConfig inflateConfig3 = (InflateConfig) it.next();
                    preloadPart$preloadMarkerView$1.L$0 = preloadPart;
                    preloadPart$preloadMarkerView$1.L$1 = it;
                    preloadPart$preloadMarkerView$1.L$2 = inflateConfig3;
                    preloadPart$preloadMarkerView$1.label = 1;
                    J9 = preloadPart.J9(inflateConfig3, preloadPart$preloadMarkerView$1);
                    if (J9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    preloadPart$preloadMarkerView$12 = preloadPart$preloadMarkerView$1;
                    obj = J9;
                    preloadPart3 = preloadPart;
                    it6 = it;
                    inflateConfig2 = inflateConfig3;
                    obj2 = obj3;
                    ArrayList arrayList2 = (ArrayList) obj;
                    if (arrayList2 != null) {
                    }
                    preloadPart$preloadMarkerView$1 = preloadPart$preloadMarkerView$12;
                    coroutine_suspended = obj2;
                    it = it6;
                    preloadPart = preloadPart3;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            H9 = this.this$0.H9();
            PreloadPart preloadPart4 = this.this$0;
            it = H9.iterator();
            preloadPart = preloadPart4;
            preloadPart$preloadMarkerView$1 = this;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PreloadPart$preloadMarkerView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
