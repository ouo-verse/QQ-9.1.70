package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.WinkInitManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2", f = "WinkSchemaPreCheck.kt", i = {0, 0, 0}, l = {550}, m = "invokeSuspend", n = {"essentialAIAgents", "destination$iv$iv", "startTime"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ List<MetaMaterial> $materials;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2(List<MetaMaterial> list, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2> continuation) {
        super(2, continuation);
        this.$materials = list;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2 winkSchemaPreCheck$preCheckMaterialEssentialBundle$2 = new WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2(this.$materials, this.$costCollector, continuation);
        winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.L$0 = obj;
        return winkSchemaPreCheck$preCheckMaterialEssentialBundle$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x014e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0168 -> B:5:0x0169). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        int collectionSizeOrDefault;
        Collection arrayList;
        int collectionSizeOrDefault2;
        Iterator it;
        long j3;
        Set set;
        WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2 winkSchemaPreCheck$preCheckMaterialEssentialBundle$2;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                j3 = this.J$0;
                arrayList = (Collection) this.L$3;
                it = (Iterator) this.L$2;
                Collection collection = (Collection) this.L$1;
                set = (Set) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object await = obj;
                winkSchemaPreCheck$preCheckMaterialEssentialBundle$2 = this;
                arrayList.add(Boxing.boxBoolean(((Boolean) await).booleanValue()));
                arrayList = collection;
                if (it.hasNext()) {
                    Deferred deferred = (Deferred) it.next();
                    winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.L$0 = set;
                    winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.L$1 = arrayList;
                    winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.L$2 = it;
                    winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.L$3 = arrayList;
                    winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.J$0 = j3;
                    winkSchemaPreCheck$preCheckMaterialEssentialBundle$2.label = 1;
                    await = deferred.await(winkSchemaPreCheck$preCheckMaterialEssentialBundle$2);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    collection = arrayList;
                    arrayList.add(Boxing.boxBoolean(((Boolean) await).booleanValue()));
                    arrayList = collection;
                    if (it.hasNext()) {
                        boolean z17 = !((List) arrayList).contains(Boxing.boxBoolean(false));
                        w53.b.f("TAG_WinkSchemaPreCheck", "preCheckMaterialEssentialRes essentialAIAgents = " + set + ", result = " + z17 + " finish. cost " + (System.currentTimeMillis() - j3));
                        return Boxing.boxBoolean(z17);
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.$materials.isEmpty()) {
                w53.b.c("TAG_WinkSchemaPreCheck", "preCheckMaterialEssentialRes finish materials is empty. cost " + (System.currentTimeMillis() - currentTimeMillis));
                return Boxing.boxBoolean(true);
            }
            if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE.agentType)) {
                w53.b.c("TAG_WinkSchemaPreCheck", "preCheckMaterialEssentialRes finish no aeResBase require. cost " + (System.currentTimeMillis() - currentTimeMillis));
                return Boxing.boxBoolean(true);
            }
            WinkInitManager.Companion companion = WinkInitManager.INSTANCE;
            if (companion.a().d() && companion.a().c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                w53.b.c("TAG_WinkSchemaPreCheck", "preCheckMaterialEssentialRes lightInitResult error. cost " + (System.currentTimeMillis() - currentTimeMillis));
                return Boxing.boxBoolean(false);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it5 = this.$materials.iterator();
            while (it5.hasNext()) {
                linkedHashSet.addAll(j73.a.f409615a.f((MetaMaterial) it5.next()));
            }
            HashMap<String, Object> hashMap = this.$costCollector;
            int i16 = 10;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedHashSet, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it6 = linkedHashSet.iterator();
            while (it6.hasNext()) {
                ArrayList arrayList3 = arrayList2;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.c(), null, new WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2$aiBundleDeferredList$1$1((String) it6.next(), hashMap, null), 2, null);
                arrayList3.add(async$default);
                i16 = 10;
                arrayList2 = arrayList3;
            }
            ArrayList arrayList4 = arrayList2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, i16);
            arrayList = new ArrayList(collectionSizeOrDefault2);
            it = arrayList4.iterator();
            j3 = currentTimeMillis;
            set = linkedHashSet;
            winkSchemaPreCheck$preCheckMaterialEssentialBundle$2 = this;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
