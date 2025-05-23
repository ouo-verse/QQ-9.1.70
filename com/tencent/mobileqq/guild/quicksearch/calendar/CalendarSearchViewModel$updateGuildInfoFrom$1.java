package com.tencent.mobileqq.guild.quicksearch.calendar;

import com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$updateGuildInfoFrom$1", f = "CalendarSearchViewModel.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel$updateGuildInfoFrom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ CalendarSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarSearchViewModel$updateGuildInfoFrom$1(CalendarSearchViewModel calendarSearchViewModel, String str, Continuation<? super CalendarSearchViewModel$updateGuildInfoFrom$1> continuation) {
        super(2, continuation);
        this.this$0 = calendarSearchViewModel;
        this.$from = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CalendarSearchViewModel$updateGuildInfoFrom$1(this.this$0, this.$from, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
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
            mutableStateFlow = this.this$0._pageState;
            CalendarSearchViewModel.PageState pageState = CalendarSearchViewModel.PageState.FINISH;
            this.label = 1;
            if (mutableStateFlow.emit(pageState, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Logger logger = Logger.f235387a;
        String str = this.$from;
        logger.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "updateGuildInfoFrom " + str);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CalendarSearchViewModel$updateGuildInfoFrom$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
