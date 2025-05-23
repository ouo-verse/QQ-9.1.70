package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.model.x;
import com.tencent.qqnt.kernel.api.ae;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/mobileqq/search/model/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1", f = "NtGroupLocalInfoSearchEngine.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends x>>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ ae $ntService;
    final /* synthetic */ List<x> $res;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ NtGroupLocalInfoSearchEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1(NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, ae aeVar, String str, List<x> list, Continuation<? super NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ntGroupLocalInfoSearchEngine;
        this.$ntService = aeVar;
        this.$keyword = str;
        this.$res = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1(this.this$0, this.$ntService, this.$keyword, this.$res, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        CoroutineScope coroutineScope;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine = this.this$0;
        ae aeVar = this.$ntService;
        String str = this.$keyword;
        List<x> list = this.$res;
        this.L$0 = ntGroupLocalInfoSearchEngine;
        this.L$1 = aeVar;
        this.L$2 = str;
        this.L$3 = list;
        this.label = 1;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ntGroupLocalInfoSearchEngine.p();
        coroutineScope = ntGroupLocalInfoSearchEngine.scope;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1(ntGroupLocalInfoSearchEngine, aeVar, str, list, safeContinuation, null), 2, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            DebugProbes.probeCoroutineSuspended(this);
        }
        if (orThrow == coroutine_suspended) {
            return coroutine_suspended;
        }
        return orThrow;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<? extends x>> continuation) {
        return ((NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
