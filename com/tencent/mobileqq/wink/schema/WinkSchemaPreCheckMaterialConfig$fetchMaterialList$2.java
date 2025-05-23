package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2", f = "WinkSchemaPreCheckMaterialConfig.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MetaMaterial>>, Object> {
    final /* synthetic */ String $businessName;
    final /* synthetic */ String $jumpTarget;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2(String str, ConcurrentHashMap<String, String> concurrentHashMap, String str2, Continuation<? super WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2> continuation) {
        super(2, continuation);
        this.$jumpTarget = str;
        this.$keyAttrs = concurrentHashMap;
        this.$businessName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2(this.$jumpTarget, this.$keyAttrs, this.$businessName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MetaMaterial>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MetaMaterial>>) continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r6.equals("7") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
    
        r6 = com.tencent.mobileqq.wink.schema.WinkSchemaPreCheckMaterialConfig.f326295a;
        r1 = r5.$jumpTarget;
        r3 = r5.$keyAttrs;
        r4 = r5.$businessName;
        r5.label = 1;
        r6 = r6.c(r1, r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c7, code lost:
    
        if (r6 != r0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c9, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if (r6.equals("6") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        if (r6.equals("5") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
    
        if (r6.equals("3") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        if (r6.equals("2") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a2, code lost:
    
        if (r6.equals("20") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ac, code lost:
    
        if (r6.equals("19") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        if (r6.equals("15") == false) goto L60;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0032. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List emptyList;
        List emptyList2;
        List emptyList3;
        List emptyList4;
        List emptyList5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String str = this.$jumpTarget;
            int hashCode = str.hashCode();
            if (hashCode != 57) {
                if (hashCode != 1572) {
                    if (hashCode != 1576) {
                        if (hashCode != 1598) {
                            switch (hashCode) {
                                case 48:
                                    if (str.equals("0")) {
                                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                                        return emptyList3;
                                    }
                                    break;
                                case 49:
                                    if (str.equals("1")) {
                                        emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                                        return emptyList4;
                                    }
                                    break;
                                case 52:
                                    if (str.equals("4")) {
                                        emptyList5 = CollectionsKt__CollectionsKt.emptyList();
                                        return emptyList5;
                                    }
                                    break;
                            }
                        }
                    }
                }
            } else if (str.equals("9")) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        return (List) obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<MetaMaterial>> continuation) {
        return ((WinkSchemaPreCheckMaterialConfig$fetchMaterialList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
