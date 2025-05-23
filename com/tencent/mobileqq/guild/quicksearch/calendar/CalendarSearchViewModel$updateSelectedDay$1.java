package com.tencent.mobileqq.guild.quicksearch.calendar;

import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$updateSelectedDay$1", f = "CalendarSearchViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel$updateSelectedDay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Calendar $calendar;
    int label;
    final /* synthetic */ CalendarSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarSearchViewModel$updateSelectedDay$1(CalendarSearchViewModel calendarSearchViewModel, Calendar calendar, Continuation<? super CalendarSearchViewModel$updateSelectedDay$1> continuation) {
        super(2, continuation);
        this.this$0 = calendarSearchViewModel;
        this.$calendar = calendar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CalendarSearchViewModel$updateSelectedDay$1(this.this$0, this.$calendar, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.mobileqq.guild.home.schedule.models.a] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.tencent.mobileqq.guild.home.schedule.models.a$a] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        List mutableList;
        int collectionSizeOrDefault;
        MutableStateFlow mutableStateFlow2;
        Calendar calendar;
        int state;
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
            this.this$0.selectedDay = this.$calendar;
            mutableStateFlow = this.this$0._calendarFlow;
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) mutableStateFlow.getValue());
            List<??> list = mutableList;
            CalendarSearchViewModel calendarSearchViewModel = this.this$0;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (?? r46 : list) {
                if (r46 instanceof a.CalendarDay) {
                    Calendar a16 = r46.a();
                    calendar = calendarSearchViewModel.selectedDay;
                    if (CalendarExKt.e(a16, calendar)) {
                        state = ((a.CalendarDay) r46).getState() | 2;
                    } else {
                        state = ((a.CalendarDay) r46).getState() & (-3);
                    }
                    a.CalendarDay calendarDay = (a.CalendarDay) r46;
                    if (state != calendarDay.getState()) {
                        r46 = a.CalendarDay.INSTANCE.a(r46.a());
                        r46.i(state);
                    } else {
                        r46 = calendarDay;
                    }
                }
                arrayList.add(r46);
            }
            mutableStateFlow2 = this.this$0._calendarFlow;
            this.label = 1;
            if (mutableStateFlow2.emit(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CalendarSearchViewModel$updateSelectedDay$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
