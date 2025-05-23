package com.tencent.mobileqq.guild.quicksearch.calendar;

import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Calendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1", f = "GuildCalendarSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $contentView;
    final /* synthetic */ b $monthSelector;
    int label;
    final /* synthetic */ GuildCalendarSearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1(b bVar, GuildCalendarSearchFragment guildCalendarSearchFragment, View view, Continuation<? super GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1> continuation) {
        super(2, continuation);
        this.$monthSelector = bVar;
        this.this$0 = guildCalendarSearchFragment;
        this.$contentView = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1(this.$monthSelector, this.this$0, this.$contentView, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Map mapOf;
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Calendar t16 = this.$monthSelector.t();
            int i3 = t16.get(1);
            CalendarSearchViewModel calendarSearchViewModel = this.this$0.viewModel;
            CalendarSearchViewModel calendarSearchViewModel2 = null;
            if (calendarSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                calendarSearchViewModel = null;
            }
            if (i3 == calendarSearchViewModel.get_maxEndData().get(1)) {
                int i16 = t16.get(2) + 1;
                CalendarSearchViewModel calendarSearchViewModel3 = this.this$0.viewModel;
                if (calendarSearchViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    calendarSearchViewModel3 = null;
                }
                if (i16 == calendarSearchViewModel3.get_maxEndData().get(2) + 1) {
                    this.this$0.needScrollToEnd = true;
                    CalendarSearchViewModel calendarSearchViewModel4 = this.this$0.viewModel;
                    if (calendarSearchViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        calendarSearchViewModel2 = calendarSearchViewModel4;
                    }
                    calendarSearchViewModel2.p2(t16, new IntRange(-3, -1));
                    View view = this.$contentView;
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "1"));
                    VideoReport.reportEvent("dt_clck", view, mapOf);
                    Logger logger = Logger.f235387a;
                    GuildCalendarSearchFragment guildCalendarSearchFragment = this.this$0;
                    if (QLog.isDevelopLevel()) {
                        String b16 = CalendarExKt.b(t16);
                        z16 = guildCalendarSearchFragment.needScrollToEnd;
                        Log.d("QQGuildInSearchTag.GuildCalendarSearchFragment", "onConfirm " + b16 + " " + z16);
                    }
                    return Unit.INSTANCE;
                }
            }
            this.this$0.needScrollToTop = true;
            CalendarSearchViewModel calendarSearchViewModel5 = this.this$0.viewModel;
            if (calendarSearchViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                calendarSearchViewModel2 = calendarSearchViewModel5;
            }
            calendarSearchViewModel2.p2(t16, new IntRange(1, 3));
            View view2 = this.$contentView;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "1"));
            VideoReport.reportEvent("dt_clck", view2, mapOf);
            Logger logger2 = Logger.f235387a;
            GuildCalendarSearchFragment guildCalendarSearchFragment2 = this.this$0;
            if (QLog.isDevelopLevel()) {
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
