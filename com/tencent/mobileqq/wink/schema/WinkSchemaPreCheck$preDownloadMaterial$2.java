package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.luggage.wxa.se.i;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preDownloadMaterial$2", f = "WinkSchemaPreCheck.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {i.CTRL_INDEX, 459, LocaleManager.MOBILE_COUNTRY_CODE_CN_INT}, m = "invokeSuspend", n = {"$this$supervisorScope", "startTime", "materialList", "downloadFontDeferredList", "destination$iv$iv", "startTime", "materialList", "destination$iv$iv", "startTime", "downloadMaterialResult"}, s = {"L$0", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "I$0"})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preDownloadMaterial$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MetaMaterial>>, Object> {
    final /* synthetic */ String $businessName;
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ String $jumpTarget;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preDownloadMaterial$2(String str, ConcurrentHashMap<String, String> concurrentHashMap, String str2, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preDownloadMaterial$2> continuation) {
        super(2, continuation);
        this.$jumpTarget = str;
        this.$keyAttrs = concurrentHashMap;
        this.$businessName = str2;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkSchemaPreCheck$preDownloadMaterial$2 winkSchemaPreCheck$preDownloadMaterial$2 = new WinkSchemaPreCheck$preDownloadMaterial$2(this.$jumpTarget, this.$keyAttrs, this.$businessName, this.$costCollector, continuation);
        winkSchemaPreCheck$preDownloadMaterial$2.L$0 = obj;
        return winkSchemaPreCheck$preDownloadMaterial$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MetaMaterial>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MetaMaterial>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x01a6 -> B:7:0x01a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0153 -> B:31:0x0154). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        long currentTimeMillis;
        Object withContext;
        int collectionSizeOrDefault;
        List arrayList;
        int collectionSizeOrDefault2;
        Collection arrayList2;
        int collectionSizeOrDefault3;
        List list;
        Iterator it;
        long j3;
        WinkSchemaPreCheck$preDownloadMaterial$2 winkSchemaPreCheck$preDownloadMaterial$2;
        Deferred async$default;
        Deferred async$default2;
        int i3;
        Collection arrayList3;
        int collectionSizeOrDefault4;
        Iterator it5;
        List list2;
        boolean z16;
        int collectionSizeOrDefault5;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        Continuation continuation = null;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        i3 = this.I$0;
                        j3 = this.J$0;
                        arrayList3 = (Collection) this.L$3;
                        it5 = (Iterator) this.L$2;
                        Collection collection = (Collection) this.L$1;
                        list2 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Object await = obj;
                        winkSchemaPreCheck$preDownloadMaterial$2 = this;
                        arrayList3.add(Boxing.boxBoolean(((Boolean) await).booleanValue()));
                        arrayList3 = collection;
                        if (it5.hasNext()) {
                            Deferred deferred = (Deferred) it5.next();
                            winkSchemaPreCheck$preDownloadMaterial$2.L$0 = list2;
                            winkSchemaPreCheck$preDownloadMaterial$2.L$1 = arrayList3;
                            winkSchemaPreCheck$preDownloadMaterial$2.L$2 = it5;
                            winkSchemaPreCheck$preDownloadMaterial$2.L$3 = arrayList3;
                            winkSchemaPreCheck$preDownloadMaterial$2.L$4 = null;
                            winkSchemaPreCheck$preDownloadMaterial$2.J$0 = j3;
                            winkSchemaPreCheck$preDownloadMaterial$2.I$0 = i3;
                            winkSchemaPreCheck$preDownloadMaterial$2.label = 3;
                            await = deferred.await(winkSchemaPreCheck$preDownloadMaterial$2);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            collection = arrayList3;
                            arrayList3.add(Boxing.boxBoolean(((Boolean) await).booleanValue()));
                            arrayList3 = collection;
                            if (it5.hasNext()) {
                                boolean z17 = !((List) arrayList3).contains(Boxing.boxBoolean(false));
                                if (i3 != 0 && z17) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                List list3 = list2;
                                collectionSizeOrDefault5 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault5);
                                Iterator it6 = list3.iterator();
                                while (it6.hasNext()) {
                                    arrayList4.add(((MetaMaterial) it6.next()).f30533id);
                                }
                                w53.b.f("TAG_WinkSchemaPreCheck", "preDownloadMaterial materialList = " + arrayList4 + ", result = " + z16 + " finish. cost " + (System.currentTimeMillis() - j3));
                                if (i3 == 0) {
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                    return emptyList;
                                }
                                return list2;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    j3 = this.J$0;
                    arrayList2 = (Collection) this.L$4;
                    it = (Iterator) this.L$3;
                    Collection collection2 = (Collection) this.L$2;
                    arrayList = (List) this.L$1;
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Object await2 = obj;
                    winkSchemaPreCheck$preDownloadMaterial$2 = this;
                    arrayList2.add(Boxing.boxBoolean(((Boolean) await2).booleanValue()));
                    arrayList2 = collection2;
                    if (it.hasNext()) {
                        Deferred deferred2 = (Deferred) it.next();
                        winkSchemaPreCheck$preDownloadMaterial$2.L$0 = list;
                        winkSchemaPreCheck$preDownloadMaterial$2.L$1 = arrayList;
                        winkSchemaPreCheck$preDownloadMaterial$2.L$2 = arrayList2;
                        winkSchemaPreCheck$preDownloadMaterial$2.L$3 = it;
                        winkSchemaPreCheck$preDownloadMaterial$2.L$4 = arrayList2;
                        winkSchemaPreCheck$preDownloadMaterial$2.J$0 = j3;
                        winkSchemaPreCheck$preDownloadMaterial$2.label = 2;
                        await2 = deferred2.await(winkSchemaPreCheck$preDownloadMaterial$2);
                        if (await2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection2 = arrayList2;
                        arrayList2.add(Boxing.boxBoolean(((Boolean) await2).booleanValue()));
                        arrayList2 = collection2;
                        if (it.hasNext()) {
                            i3 = !((List) arrayList2).contains(Boxing.boxBoolean(false)) ? 1 : 0;
                            List list4 = arrayList;
                            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                            arrayList3 = new ArrayList(collectionSizeOrDefault4);
                            it5 = list4.iterator();
                            list2 = list;
                            if (it5.hasNext()) {
                            }
                        }
                    }
                }
            } else {
                currentTimeMillis = this.J$0;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            currentTimeMillis = System.currentTimeMillis();
            CoroutineDispatcher c16 = WinkCoroutineScopes.f317652a.c();
            WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1 winkSchemaPreCheck$preDownloadMaterial$2$materialList$1 = new WinkSchemaPreCheck$preDownloadMaterial$2$materialList$1(this.$jumpTarget, this.$keyAttrs, this.$businessName, this.$costCollector, null);
            this.L$0 = coroutineScope;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            withContext = BuildersKt.withContext(c16, winkSchemaPreCheck$preDownloadMaterial$2$materialList$1, this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        long j16 = currentTimeMillis;
        List list5 = (List) withContext;
        List<MetaMaterial> list6 = list5;
        HashMap<String, Object> hashMap = this.$costCollector;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
        Iterator it7 = list6.iterator();
        while (it7.hasNext()) {
            ArrayList arrayList6 = arrayList5;
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.c(), null, new WinkSchemaPreCheck$preDownloadMaterial$2$downloadMaterialDeferredList$1$1((MetaMaterial) it7.next(), hashMap, null), 2, null);
            arrayList6.add(async$default2);
            arrayList5 = arrayList6;
            hashMap = hashMap;
        }
        ArrayList arrayList7 = arrayList5;
        HashMap<String, Object> hashMap2 = this.$costCollector;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
        arrayList = new ArrayList(collectionSizeOrDefault2);
        for (MetaMaterial metaMaterial : list6) {
            CoroutineDispatcher c17 = WinkCoroutineScopes.f317652a.c();
            WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1 winkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1 = new WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1(metaMaterial, hashMap2, continuation);
            List list7 = arrayList;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, c17, null, winkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1, 2, null);
            list7.add(async$default);
            arrayList = list7;
            hashMap2 = hashMap2;
            continuation = null;
        }
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList7, 10);
        arrayList2 = new ArrayList(collectionSizeOrDefault3);
        list = list5;
        it = arrayList7.iterator();
        j3 = j16;
        winkSchemaPreCheck$preDownloadMaterial$2 = this;
        if (it.hasNext()) {
        }
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<MetaMaterial>> continuation) {
        return ((WinkSchemaPreCheck$preDownloadMaterial$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
