package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1", f = "WinkSchemaPreCheck.kt", i = {0}, l = {com.tencent.luggage.wxa.yd.a.CTRL_INDEX}, m = "invokeSuspend", n = {"fetchMaterialStartTime"}, s = {"J$0"})
/* loaded from: classes21.dex */
final class WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MetaMaterial>>, Object> {
    final /* synthetic */ String $businessName;
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ String $jumpTarget;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1(String str, ConcurrentHashMap<String, String> concurrentHashMap, String str2, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1> continuation) {
        super(2, continuation);
        this.$jumpTarget = str;
        this.$keyAttrs = concurrentHashMap;
        this.$businessName = str2;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1(this.$jumpTarget, this.$keyAttrs, this.$businessName, this.$costCollector, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MetaMaterial>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MetaMaterial>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        int collectionSizeOrDefault;
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
            long currentTimeMillis = System.currentTimeMillis();
            WinkSchemaPreCheckMaterialConfig winkSchemaPreCheckMaterialConfig = WinkSchemaPreCheckMaterialConfig.f326295a;
            String str = this.$jumpTarget;
            ConcurrentHashMap<String, String> concurrentHashMap = this.$keyAttrs;
            String str2 = this.$businessName;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = winkSchemaPreCheckMaterialConfig.b(str, concurrentHashMap, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
        }
        List list = (List) obj;
        long currentTimeMillis2 = System.currentTimeMillis() - j3;
        this.$costCollector.put("resourceList", Boxing.boxLong(currentTimeMillis2));
        List list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((MetaMaterial) it.next()).f30533id);
        }
        w53.b.f("TAG_WinkSchemaPreCheck", "fetchMaterialList finish list = " + arrayList + ". cost " + currentTimeMillis2);
        return list;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<MetaMaterial>> continuation) {
        return ((WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
