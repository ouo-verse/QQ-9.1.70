package com.tencent.aelight.camera.ae.flashshow.zshow;

import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.zshow.ZShowFilamentPreviewView$fetchLightRes$2", f = "ZShowFilamentPreviewView.kt", i = {0}, l = {345}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$0"})
/* loaded from: classes32.dex */
final class ZShowFilamentPreviewView$fetchLightRes$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZShowFilamentPreviewView$fetchLightRes$2 zShowFilamentPreviewView$fetchLightRes$2 = new ZShowFilamentPreviewView$fetchLightRes$2(continuation);
        zShowFilamentPreviewView$fetchLightRes$2.L$0 = obj;
        return zShowFilamentPreviewView$fetchLightRes$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a7  */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00bc -> B:5:0x00c2). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Deferred async$default4;
        List mutableListOf;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Iterator it;
        ZShowFilamentPreviewView$fetchLightRes$2 zShowFilamentPreviewView$fetchLightRes$2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ms.a.f("ZShowFilamentPreviewView", "fetchLightRes ");
            HashMap hashMap = new HashMap();
            WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.c(), null, new ZShowFilamentPreviewView$fetchLightRes$2$deferredList$1(hashMap, null), 2, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.c(), null, new ZShowFilamentPreviewView$fetchLightRes$2$deferredList$2(hashMap, null), 2, null);
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.c(), null, new ZShowFilamentPreviewView$fetchLightRes$2$deferredList$3(hashMap, null), 2, null);
            async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.c(), null, new ZShowFilamentPreviewView$fetchLightRes$2$deferredList$4(hashMap, null), 2, null);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(async$default, async$default2, async$default3, async$default4);
            List list = mutableListOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            it = list.iterator();
            zShowFilamentPreviewView$fetchLightRes$2 = this;
            if (it.hasNext()) {
            }
        } else if (i3 == 1) {
            ?? r16 = (Collection) this.L$2;
            Iterator it5 = (Iterator) this.L$1;
            ?? r65 = (Collection) this.L$0;
            ResultKt.throwOnFailure(obj);
            Iterator it6 = it5;
            ArrayList arrayList2 = r16;
            Object obj2 = coroutine_suspended;
            ZShowFilamentPreviewView$fetchLightRes$2 zShowFilamentPreviewView$fetchLightRes$22 = this;
            ArrayList arrayList3 = r65;
            arrayList2.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
            zShowFilamentPreviewView$fetchLightRes$2 = zShowFilamentPreviewView$fetchLightRes$22;
            coroutine_suspended = obj2;
            arrayList = arrayList3;
            it = it6;
            if (it.hasNext()) {
                Deferred deferred = (Deferred) it.next();
                zShowFilamentPreviewView$fetchLightRes$2.L$0 = arrayList;
                zShowFilamentPreviewView$fetchLightRes$2.L$1 = it;
                zShowFilamentPreviewView$fetchLightRes$2.L$2 = arrayList;
                zShowFilamentPreviewView$fetchLightRes$2.label = 1;
                Object await = deferred.await(zShowFilamentPreviewView$fetchLightRes$2);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it6 = it;
                arrayList2 = arrayList;
                obj2 = coroutine_suspended;
                zShowFilamentPreviewView$fetchLightRes$22 = zShowFilamentPreviewView$fetchLightRes$2;
                obj = await;
                arrayList3 = arrayList2;
                arrayList2.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                zShowFilamentPreviewView$fetchLightRes$2 = zShowFilamentPreviewView$fetchLightRes$22;
                coroutine_suspended = obj2;
                arrayList = arrayList3;
                it = it6;
                if (it.hasNext()) {
                    ms.a.f("ZShowFilamentPreviewView", "fetchLightRes finish");
                    return Boxing.boxBoolean(!arrayList.contains(Boxing.boxBoolean(false)));
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZShowFilamentPreviewView$fetchLightRes$2(Continuation<? super ZShowFilamentPreviewView$fetchLightRes$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ZShowFilamentPreviewView$fetchLightRes$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
