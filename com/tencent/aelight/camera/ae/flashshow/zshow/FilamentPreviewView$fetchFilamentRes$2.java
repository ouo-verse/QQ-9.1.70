package com.tencent.aelight.camera.ae.flashshow.zshow;

import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import java.util.ArrayList;
import java.util.Collection;
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
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView$fetchFilamentRes$2", f = "FilamentPreviewView.kt", i = {0, 0}, l = {216}, m = "invokeSuspend", n = {"destination$iv$iv", "startTime"}, s = {"L$0", "J$0"})
/* loaded from: classes32.dex */
final class FilamentPreviewView$fetchFilamentRes$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FilamentPreviewView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentPreviewView$fetchFilamentRes$2(FilamentPreviewView filamentPreviewView, Continuation<? super FilamentPreviewView$fetchFilamentRes$2> continuation) {
        super(2, continuation);
        this.this$0 = filamentPreviewView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FilamentPreviewView$fetchFilamentRes$2 filamentPreviewView$fetchFilamentRes$2 = new FilamentPreviewView$fetchFilamentRes$2(this.this$0, continuation);
        filamentPreviewView$fetchFilamentRes$2.L$0 = obj;
        return filamentPreviewView$fetchFilamentRes$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0079  */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0090 -> B:5:0x0097). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        List mutableListOf;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Iterator it;
        long j3;
        FilamentPreviewView$fetchFilamentRes$2 filamentPreviewView$fetchFilamentRes$2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ms.a.f("FilamentPreviewView", "fetchFilamentRes ");
            long currentTimeMillis = System.currentTimeMillis();
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.c(), null, new FilamentPreviewView$fetchFilamentRes$2$deferredList$1(this.this$0, null), 2, null);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(async$default);
            List list = mutableListOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            it = list.iterator();
            j3 = currentTimeMillis;
            filamentPreviewView$fetchFilamentRes$2 = this;
            if (it.hasNext()) {
            }
        } else if (i3 == 1) {
            long j16 = this.J$0;
            ?? r16 = (Collection) this.L$2;
            Iterator it5 = (Iterator) this.L$1;
            ?? r85 = (Collection) this.L$0;
            ResultKt.throwOnFailure(obj);
            Iterator it6 = it5;
            long j17 = j16;
            ArrayList arrayList2 = r16;
            Object obj2 = coroutine_suspended;
            FilamentPreviewView$fetchFilamentRes$2 filamentPreviewView$fetchFilamentRes$22 = this;
            ArrayList arrayList3 = r85;
            arrayList2.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
            filamentPreviewView$fetchFilamentRes$2 = filamentPreviewView$fetchFilamentRes$22;
            coroutine_suspended = obj2;
            j3 = j17;
            arrayList = arrayList3;
            it = it6;
            if (it.hasNext()) {
                Deferred deferred = (Deferred) it.next();
                filamentPreviewView$fetchFilamentRes$2.L$0 = arrayList;
                filamentPreviewView$fetchFilamentRes$2.L$1 = it;
                filamentPreviewView$fetchFilamentRes$2.L$2 = arrayList;
                filamentPreviewView$fetchFilamentRes$2.J$0 = j3;
                filamentPreviewView$fetchFilamentRes$2.label = 1;
                Object await = deferred.await(filamentPreviewView$fetchFilamentRes$2);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it6 = it;
                j17 = j3;
                arrayList2 = arrayList;
                obj2 = coroutine_suspended;
                filamentPreviewView$fetchFilamentRes$22 = filamentPreviewView$fetchFilamentRes$2;
                obj = await;
                arrayList3 = arrayList2;
                arrayList2.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                filamentPreviewView$fetchFilamentRes$2 = filamentPreviewView$fetchFilamentRes$22;
                coroutine_suspended = obj2;
                j3 = j17;
                arrayList = arrayList3;
                it = it6;
                if (it.hasNext()) {
                    ms.a.f("FilamentPreviewView", "fetchFilamentRes duration " + (System.currentTimeMillis() - j3));
                    return Boxing.boxBoolean(!arrayList.contains(Boxing.boxBoolean(false)));
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FilamentPreviewView$fetchFilamentRes$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
