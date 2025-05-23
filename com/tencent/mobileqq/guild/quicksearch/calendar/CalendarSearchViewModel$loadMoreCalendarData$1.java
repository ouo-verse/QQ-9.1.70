package com.tencent.mobileqq.guild.quicksearch.calendar;

import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$loadMoreCalendarData$1", f = "CalendarSearchViewModel.kt", i = {0, 1}, l = {99, 102, 104}, m = "invokeSuspend", n = {"currentCalendar", "currentCalendar"}, s = {"L$0", "L$0"})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel$loadMoreCalendarData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isUpDirection;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CalendarSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarSearchViewModel$loadMoreCalendarData$1(CalendarSearchViewModel calendarSearchViewModel, boolean z16, Continuation<? super CalendarSearchViewModel$loadMoreCalendarData$1> continuation) {
        super(2, continuation);
        this.this$0 = calendarSearchViewModel;
        this.$isUpDirection = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CalendarSearchViewModel$loadMoreCalendarData$1(this.this$0, this.$isUpDirection, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        MutableStateFlow mutableStateFlow;
        List mutableList;
        Object firstOrNull;
        Calendar a16;
        Object n26;
        List list;
        List list2;
        int i3;
        Object lastOrNull;
        Calendar a17;
        Object n27;
        List list3;
        List list4;
        MutableStateFlow mutableStateFlow2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.isRequesting = false;
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i3 = this.I$0;
                list = (List) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list.addAll(i3, (Collection) obj);
                list3 = list2;
            } else {
                list4 = (List) this.L$1;
                list3 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list4.addAll((Collection) obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            z16 = this.this$0.isRequesting;
            if (!z16) {
                this.this$0.isRequesting = true;
                mutableStateFlow = this.this$0._calendarFlow;
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) mutableStateFlow.getValue());
                if (this.$isUpDirection) {
                    lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) mutableList);
                    com.tencent.mobileqq.guild.home.schedule.models.a aVar = (com.tencent.mobileqq.guild.home.schedule.models.a) lastOrNull;
                    if (aVar != null && (a17 = aVar.a()) != null) {
                        CalendarSearchViewModel calendarSearchViewModel = this.this$0;
                        Calendar h16 = CalendarExKt.h(a17);
                        this.L$0 = mutableList;
                        this.L$1 = mutableList;
                        this.label = 1;
                        n27 = calendarSearchViewModel.n2(h16, this);
                        if (n27 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list3 = mutableList;
                        obj = n27;
                        list4 = list3;
                        list4.addAll((Collection) obj);
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mutableList);
                    com.tencent.mobileqq.guild.home.schedule.models.a aVar2 = (com.tencent.mobileqq.guild.home.schedule.models.a) firstOrNull;
                    if (aVar2 != null && (a16 = aVar2.a()) != null) {
                        CalendarSearchViewModel calendarSearchViewModel2 = this.this$0;
                        Calendar f16 = CalendarExKt.f(a16);
                        this.L$0 = mutableList;
                        this.L$1 = mutableList;
                        this.I$0 = 0;
                        this.label = 2;
                        n26 = calendarSearchViewModel2.n2(f16, this);
                        if (n26 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list = mutableList;
                        list2 = list;
                        obj = n26;
                        i3 = 0;
                        list.addAll(i3, (Collection) obj);
                        list3 = list2;
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        mutableStateFlow2 = this.this$0._calendarFlow;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (mutableStateFlow2.emit(list3, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.isRequesting = false;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CalendarSearchViewModel$loadMoreCalendarData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
