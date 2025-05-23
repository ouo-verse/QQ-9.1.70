package com.tencent.mobileqq.guild.quicksearch.calendar;

import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel$loadTargetMonth$1", f = "CalendarSearchViewModel.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {70, 73, 79, 81}, m = "invokeSuspend", n = {QQPermissionConstants.Permission.CALENDAR_GROUP, "calendarList", "i", QQPermissionConstants.Permission.CALENDAR_GROUP, "calendarList", "i", "calendarList"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0"})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel$loadTargetMonth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IntRange $range;
    final /* synthetic */ Calendar $targetMonth;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CalendarSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarSearchViewModel$loadTargetMonth$1(Calendar calendar, IntRange intRange, CalendarSearchViewModel calendarSearchViewModel, Continuation<? super CalendarSearchViewModel$loadTargetMonth$1> continuation) {
        super(2, continuation);
        this.$targetMonth = calendar;
        this.$range = intRange;
        this.this$0 = calendarSearchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CalendarSearchViewModel$loadTargetMonth$1(this.$targetMonth, this.$range, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0162 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0163  */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r10v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.Calendar, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f0 -> B:20:0x00f7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        int first;
        CalendarSearchViewModel$loadTargetMonth$1 calendarSearchViewModel$loadTargetMonth$1;
        Ref.ObjectRef objectRef;
        ArrayList arrayList2;
        int i3;
        MutableStateFlow mutableStateFlow;
        CalendarSearchViewModel$loadTargetMonth$1 calendarSearchViewModel$loadTargetMonth$12;
        List list;
        Object n26;
        MutableStateFlow mutableStateFlow2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        int i17 = 2;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    calendarSearchViewModel$loadTargetMonth$12 = this;
                    if (!list.isEmpty()) {
                        mutableStateFlow2 = calendarSearchViewModel$loadTargetMonth$12.this$0._pageState;
                        CalendarSearchViewModel.PageState pageState = CalendarSearchViewModel.PageState.SUCCESS;
                        calendarSearchViewModel$loadTargetMonth$12.L$0 = null;
                        calendarSearchViewModel$loadTargetMonth$12.label = 4;
                        if (mutableStateFlow2.emit(pageState, calendarSearchViewModel$loadTargetMonth$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                int i18 = this.I$2;
                int i19 = this.I$1;
                int i26 = this.I$0;
                ?? r102 = (List) this.L$2;
                ?? r112 = (List) this.L$1;
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList3 = r112;
                Ref.ObjectRef objectRef3 = objectRef2;
                Object n27 = obj;
                ArrayList arrayList4 = r102;
                int i27 = i26;
                int i28 = i19;
                CalendarSearchViewModel$loadTargetMonth$1 calendarSearchViewModel$loadTargetMonth$13 = this;
                arrayList4.addAll(i18, (Collection) n27);
                objectRef3.element = CalendarExKt.f((Calendar) objectRef3.element);
                calendarSearchViewModel$loadTargetMonth$1 = calendarSearchViewModel$loadTargetMonth$13;
                i3 = i28;
                first = i27;
                arrayList2 = arrayList3;
                objectRef = objectRef3;
                Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "loadTargetMonth: " + first + " " + CalendarExKt.b((Calendar) objectRef.element) + " " + arrayList2.size());
                if (first == i3) {
                    first++;
                    i17 = 2;
                    if (first < 0) {
                        CalendarSearchViewModel calendarSearchViewModel = calendarSearchViewModel$loadTargetMonth$1.this$0;
                        Calendar calendar = (Calendar) objectRef.element;
                        calendarSearchViewModel$loadTargetMonth$1.L$0 = objectRef;
                        calendarSearchViewModel$loadTargetMonth$1.L$1 = arrayList2;
                        calendarSearchViewModel$loadTargetMonth$1.L$2 = arrayList2;
                        calendarSearchViewModel$loadTargetMonth$1.I$0 = first;
                        calendarSearchViewModel$loadTargetMonth$1.I$1 = i3;
                        calendarSearchViewModel$loadTargetMonth$1.label = 1;
                        n26 = calendarSearchViewModel.n2(calendar, calendarSearchViewModel$loadTargetMonth$1);
                        if (n26 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.ObjectRef objectRef4 = objectRef;
                        ArrayList arrayList5 = arrayList2;
                        int i29 = i3;
                        CalendarSearchViewModel$loadTargetMonth$1 calendarSearchViewModel$loadTargetMonth$14 = calendarSearchViewModel$loadTargetMonth$1;
                        arrayList2.addAll((Collection) n26);
                        objectRef4.element = CalendarExKt.h((Calendar) objectRef4.element);
                        arrayList2 = arrayList5;
                        objectRef = objectRef4;
                        i3 = i29;
                        calendarSearchViewModel$loadTargetMonth$1 = calendarSearchViewModel$loadTargetMonth$14;
                        Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "loadTargetMonth: " + first + " " + CalendarExKt.b((Calendar) objectRef.element) + " " + arrayList2.size());
                        if (first == i3) {
                            arrayList = arrayList2;
                            mutableStateFlow = calendarSearchViewModel$loadTargetMonth$1.this$0._calendarFlow;
                            calendarSearchViewModel$loadTargetMonth$1.L$0 = arrayList;
                            calendarSearchViewModel$loadTargetMonth$1.L$1 = null;
                            calendarSearchViewModel$loadTargetMonth$1.L$2 = null;
                            calendarSearchViewModel$loadTargetMonth$1.label = 3;
                            if (mutableStateFlow.emit(arrayList, calendarSearchViewModel$loadTargetMonth$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            calendarSearchViewModel$loadTargetMonth$12 = calendarSearchViewModel$loadTargetMonth$1;
                            list = arrayList;
                            if (!list.isEmpty()) {
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        CalendarSearchViewModel calendarSearchViewModel2 = calendarSearchViewModel$loadTargetMonth$1.this$0;
                        Calendar calendar2 = (Calendar) objectRef.element;
                        calendarSearchViewModel$loadTargetMonth$1.L$0 = objectRef;
                        calendarSearchViewModel$loadTargetMonth$1.L$1 = arrayList2;
                        calendarSearchViewModel$loadTargetMonth$1.L$2 = arrayList2;
                        calendarSearchViewModel$loadTargetMonth$1.I$0 = first;
                        calendarSearchViewModel$loadTargetMonth$1.I$1 = i3;
                        calendarSearchViewModel$loadTargetMonth$1.I$2 = 0;
                        calendarSearchViewModel$loadTargetMonth$1.label = i17;
                        n27 = calendarSearchViewModel2.n2(calendar2, calendarSearchViewModel$loadTargetMonth$1);
                        if (n27 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        arrayList3 = arrayList2;
                        i27 = first;
                        i28 = i3;
                        calendarSearchViewModel$loadTargetMonth$13 = calendarSearchViewModel$loadTargetMonth$1;
                        i18 = 0;
                        objectRef3 = objectRef;
                        arrayList4 = arrayList3;
                        arrayList4.addAll(i18, (Collection) n27);
                        objectRef3.element = CalendarExKt.f((Calendar) objectRef3.element);
                        calendarSearchViewModel$loadTargetMonth$1 = calendarSearchViewModel$loadTargetMonth$13;
                        i3 = i28;
                        first = i27;
                        arrayList2 = arrayList3;
                        objectRef = objectRef3;
                        Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "loadTargetMonth: " + first + " " + CalendarExKt.b((Calendar) objectRef.element) + " " + arrayList2.size());
                        if (first == i3) {
                        }
                    }
                }
            } else {
                int i36 = this.I$1;
                int i37 = this.I$0;
                List list2 = (List) this.L$2;
                ?? r103 = (List) this.L$1;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                first = i37;
                list2.addAll((Collection) obj);
                objectRef5.element = CalendarExKt.h((Calendar) objectRef5.element);
                arrayList2 = r103;
                objectRef = objectRef5;
                i3 = i36;
                calendarSearchViewModel$loadTargetMonth$1 = this;
                Logger.f235387a.d().d("QQGuildInSearchTag.CalendarSearchViewModel", 1, "loadTargetMonth: " + first + " " + CalendarExKt.b((Calendar) objectRef.element) + " " + arrayList2.size());
                if (first == i3) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            Object clone = this.$targetMonth.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
            objectRef6.element = (Calendar) clone;
            arrayList = new ArrayList();
            first = this.$range.getFirst();
            int last = this.$range.getLast();
            if (first <= last) {
                objectRef = objectRef6;
                calendarSearchViewModel$loadTargetMonth$1 = this;
                arrayList2 = arrayList;
                i3 = last;
                if (first < 0) {
                }
            } else {
                calendarSearchViewModel$loadTargetMonth$1 = this;
                mutableStateFlow = calendarSearchViewModel$loadTargetMonth$1.this$0._calendarFlow;
                calendarSearchViewModel$loadTargetMonth$1.L$0 = arrayList;
                calendarSearchViewModel$loadTargetMonth$1.L$1 = null;
                calendarSearchViewModel$loadTargetMonth$1.L$2 = null;
                calendarSearchViewModel$loadTargetMonth$1.label = 3;
                if (mutableStateFlow.emit(arrayList, calendarSearchViewModel$loadTargetMonth$1) != coroutine_suspended) {
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CalendarSearchViewModel$loadTargetMonth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
