package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.common.app.AppInterface;
import com.tencent.luggage.wxa.eg.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {b.C6164b.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ Ref.IntRef $queryId;
    final /* synthetic */ Flow<SearchLocalInfoResult> $resultFlow;
    final /* synthetic */ ArrayList<String> $splitKeywords;
    int label;
    final /* synthetic */ NTFtsMessageSearchEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2(NTFtsMessageSearchEngine nTFtsMessageSearchEngine, Flow<SearchLocalInfoResult> flow, Ref.IntRef intRef, String str, ArrayList<String> arrayList, Continuation<? super NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2> continuation) {
        super(2, continuation);
        this.this$0 = nTFtsMessageSearchEngine;
        this.$resultFlow = flow;
        this.$queryId = intRef;
        this.$keyword = str;
        this.$splitKeywords = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2(this.this$0, this.$resultFlow, this.$queryId, this.$keyword, this.$splitKeywords, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object withTimeoutOrNull;
        List emptyList;
        ReentrantLock reentrantLock;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ArrayList<SearchChatSummaryItem> arrayList;
        int collectionSizeOrDefault;
        ArrayList arrayList2;
        Ref.IntRef intRef;
        y bVar;
        ArrayList<String> arrayList3;
        boolean k3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    withTimeoutOrNull = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1 nTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1 = new NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1(this.$resultFlow, this.$queryId, null);
                this.label = 1;
                withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(6000L, nTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1, this);
                if (withTimeoutOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            SearchLocalInfoResult searchLocalInfoResult = (SearchLocalInfoResult) withTimeoutOrNull;
            QLog.d("NTFtsMessageSearchEngine", 1, "#search finish search");
            if (searchLocalInfoResult == null || (arrayList = searchLocalInfoResult.chatsSummary) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                NTFtsMessageSearchEngine nTFtsMessageSearchEngine = this.this$0;
                ArrayList<SearchChatSummaryItem> arrayList4 = new ArrayList();
                for (Object obj2 : arrayList) {
                    k3 = nTFtsMessageSearchEngine.k(((SearchChatSummaryItem) obj2).chatType);
                    if (k3) {
                        arrayList4.add(obj2);
                    }
                }
                NTFtsMessageSearchEngine nTFtsMessageSearchEngine2 = this.this$0;
                String str = this.$keyword;
                ArrayList<String> arrayList5 = this.$splitKeywords;
                Ref.IntRef intRef2 = this.$queryId;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
                ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault);
                for (SearchChatSummaryItem it : arrayList4) {
                    if (it.chatType == 105) {
                        AppInterface d16 = nTFtsMessageSearchEngine2.d();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        arrayList2 = arrayList6;
                        intRef = intRef2;
                        bVar = new vn2.c(d16, str, null, arrayList5, null, it, intRef2.element);
                        arrayList3 = arrayList5;
                    } else {
                        arrayList2 = arrayList6;
                        intRef = intRef2;
                        AppInterface d17 = nTFtsMessageSearchEngine2.d();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        int i16 = intRef.element;
                        String str2 = it.realKeywords;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.realKeywords");
                        arrayList3 = arrayList5;
                        bVar = new vn2.b(d17, str, null, arrayList5, null, it, i16, str2);
                    }
                    arrayList2.add(bVar);
                    arrayList6 = arrayList2;
                    intRef2 = intRef;
                    arrayList5 = arrayList3;
                }
                emptyList = arrayList6;
            }
            reentrantLock = this.this$0.pendingSearchLock;
            NTFtsMessageSearchEngine nTFtsMessageSearchEngine3 = this.this$0;
            Ref.IntRef intRef3 = this.$queryId;
            reentrantLock.lock();
            try {
                concurrentHashMap = nTFtsMessageSearchEngine3.pendingSearch;
                bl blVar = (bl) concurrentHashMap.get(Boxing.boxInt(intRef3.element));
                if (blVar != null) {
                    blVar.complete(emptyList);
                    concurrentHashMap2 = nTFtsMessageSearchEngine3.pendingSearch;
                    concurrentHashMap2.remove(Boxing.boxInt(intRef3.element));
                    Logger logger = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str3 = "searchAsync flow result, " + intRef3.element;
                    if (str3 instanceof String) {
                        bVar2.a().add(str3);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("NTFtsMessageSearchEngine", 1, (String) it5.next(), null);
                    }
                } else {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar3 = new Logger.b();
                    String str4 = "searchAsync flow result, " + intRef3.element + " can not find future??";
                    if (str4 instanceof String) {
                        bVar3.a().add(str4);
                    }
                    Iterator<T> it6 = bVar3.a().iterator();
                    while (it6.hasNext()) {
                        Logger.f235387a.d().e("NTFtsMessageSearchEngine", 1, (String) it6.next(), null);
                    }
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                QLog.d("NTFtsMessageSearchEngine", 1, "#search finish, data size=" + emptyList.size());
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        } catch (InterruptedException e16) {
            QLog.w("NTFtsMessageSearchEngine", 1, "search but InterruptedException", e16);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
