package com.tencent.mobileqq.search.business.contact.viewmodel;

import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$loadWithTimeout$2", f = "ContactsSearchViewmodel.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class ContactsSearchViewmodel$loadWithTimeout$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends T>>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ Function3<String, IPerformanceReportTask, Continuation<? super List<? extends T>>, Object> $loadFunction;
    final /* synthetic */ IPerformanceReportTask $reportTask;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContactsSearchViewmodel$loadWithTimeout$2(Function3<? super String, ? super IPerformanceReportTask, ? super Continuation<? super List<? extends T>>, ? extends Object> function3, String str, IPerformanceReportTask iPerformanceReportTask, Continuation<? super ContactsSearchViewmodel$loadWithTimeout$2> continuation) {
        super(2, continuation);
        this.$loadFunction = function3;
        this.$keyword = str;
        this.$reportTask = iPerformanceReportTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ContactsSearchViewmodel$loadWithTimeout$2(this.$loadFunction, this.$keyword, this.$reportTask, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            Function3<String, IPerformanceReportTask, Continuation<? super List<? extends T>>, Object> function3 = this.$loadFunction;
            String str = this.$keyword;
            IPerformanceReportTask iPerformanceReportTask = this.$reportTask;
            this.label = 1;
            obj = function3.invoke(str, iPerformanceReportTask, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<? extends T>> continuation) {
        return ((ContactsSearchViewmodel$loadWithTimeout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
