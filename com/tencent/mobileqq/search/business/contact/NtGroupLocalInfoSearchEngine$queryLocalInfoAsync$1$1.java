package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.model.x;
import com.tencent.qqnt.kernel.api.ae;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1", f = "NtGroupLocalInfoSearchEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ ae $ntService;
    int label;
    final /* synthetic */ NtGroupLocalInfoSearchEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1(NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, ae aeVar, String str, Continuation<? super NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ntGroupLocalInfoSearchEngine;
        this.$ntService = aeVar;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1(this.this$0, this.$ntService, this.$keyword, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.D(this.$ntService, this.$keyword, new Function1<List<? extends x>, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<? extends x> resultList) {
                    Intrinsics.checkNotNullParameter(resultList, "resultList");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends x> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NtGroupLocalInfoSearchEngine$queryLocalInfoAsync$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
