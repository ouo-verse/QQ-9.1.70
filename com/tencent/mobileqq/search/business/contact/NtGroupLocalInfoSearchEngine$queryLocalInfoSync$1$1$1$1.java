package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.model.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1", f = "NtGroupLocalInfoSearchEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation<List<? extends x>> $cancelable;
    final /* synthetic */ String $keyword;
    final /* synthetic */ ae $ntService;
    final /* synthetic */ List<x> $res;
    int label;
    final /* synthetic */ NtGroupLocalInfoSearchEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1(NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine, ae aeVar, String str, List<x> list, Continuation<? super List<? extends x>> continuation, Continuation<? super NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1> continuation2) {
        super(2, continuation2);
        this.this$0 = ntGroupLocalInfoSearchEngine;
        this.$ntService = aeVar;
        this.$keyword = str;
        this.$res = list;
        this.$cancelable = continuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1(this.this$0, this.$ntService, this.$keyword, this.$res, this.$cancelable, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine = this.this$0;
            ae aeVar = this.$ntService;
            String str = this.$keyword;
            final List<x> list = this.$res;
            Function1<List<? extends x>, Unit> function1 = new Function1<List<? extends x>, Unit>() { // from class: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends x> list2) {
                    invoke2(list2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<? extends x> updateList) {
                    Intrinsics.checkNotNullParameter(updateList, "updateList");
                    list.addAll(updateList);
                }
            };
            final List<x> list2 = this.$res;
            final NtGroupLocalInfoSearchEngine ntGroupLocalInfoSearchEngine2 = this.this$0;
            final String str2 = this.$keyword;
            final Continuation<List<? extends x>> continuation = this.$cancelable;
            ntGroupLocalInfoSearchEngine.D(aeVar, str, function1, new Function0<Unit>() { // from class: com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z16;
                    Iterator<x> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z16 = false;
                            break;
                        }
                        x next = it.next();
                        if (next instanceof do2.n) {
                            ntGroupLocalInfoSearchEngine2.n((do2.n) next, str2);
                            z16 = true;
                            break;
                        }
                    }
                    if (!z16) {
                        do2.n nVar = new do2.n(ntGroupLocalInfoSearchEngine2.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String(), new ArrayList(), str2, "normal");
                        ntGroupLocalInfoSearchEngine2.n(nVar, str2);
                        if (nVar.getResultListSize() > 0) {
                            list2.add(0, nVar);
                        }
                    }
                    Continuation<List<? extends x>> continuation2 = continuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(list2));
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QQSearch.Local.NtGroupLocalInfoSearchEngine", 2, "groupSearchEngineSearchSync overTime");
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NtGroupLocalInfoSearchEngine$queryLocalInfoSync$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
