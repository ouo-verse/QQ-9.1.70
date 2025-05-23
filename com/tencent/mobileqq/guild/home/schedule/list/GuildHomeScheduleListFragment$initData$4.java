package com.tencent.mobileqq.guild.home.schedule.list;

import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.guild.home.schedule.models.Empty;
import com.tencent.mobileqq.guild.home.schedule.models.ErrorItem;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleLoadingItem;
import com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel;
import com.tencent.mobileqq.guild.home.views.widget.ScheduleRecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment$initData$4", f = "GuildHomeScheduleListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeScheduleListFragment$initData$4 extends SuspendLambda implements Function2<GuildHomeScheduleViewModel.CalendarEntries, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildHomeScheduleListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeScheduleListFragment$initData$4(GuildHomeScheduleListFragment guildHomeScheduleListFragment, Continuation<? super GuildHomeScheduleListFragment$initData$4> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeScheduleListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildHomeScheduleListFragment guildHomeScheduleListFragment) {
        View view;
        guildHomeScheduleListFragment.Ri("liveScheduleEntries update");
        view = guildHomeScheduleListFragment.rightActionLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
            view = null;
        }
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final GuildHomeScheduleListFragment guildHomeScheduleListFragment, List list, boolean z16, boolean z17) {
        ScheduleLoadingItem scheduleLoadingItem;
        List listOf;
        ScheduleLoadingItem scheduleLoadingItem2;
        List listOf2;
        List plus;
        List plus2;
        scheduleLoadingItem = guildHomeScheduleListFragment.loadPrevious;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(scheduleLoadingItem);
        List list2 = null;
        if (!(!z16)) {
            listOf = null;
        }
        if (listOf == null) {
            listOf = CollectionsKt__CollectionsKt.emptyList();
        }
        scheduleLoadingItem2 = guildHomeScheduleListFragment.loadNext;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(scheduleLoadingItem2);
        if (!z17) {
            list2 = listOf2;
        }
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) list);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) list2);
        int i3 = 0;
        for (Object obj : plus2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) obj;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "flowCalendarEntries, submit(delay) -> " + i3 + " " + dVar);
            }
            i3 = i16;
        }
        guildHomeScheduleListFragment.adapterPendingItems = plus2;
        guildHomeScheduleListFragment.adapter.submitList(plus2, new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeScheduleListFragment$initData$4.f(GuildHomeScheduleListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GuildHomeScheduleListFragment guildHomeScheduleListFragment) {
        boolean z16;
        z16 = guildHomeScheduleListFragment.firstPageTargetScrolled;
        if (!z16) {
            guildHomeScheduleListFragment.firstPageTargetScrolled = true;
            guildHomeScheduleListFragment.Qi("adapter.submitList");
            GuildHomeScheduleListFragment.Bi(guildHomeScheduleListFragment, "adapter.submitList", false, false, 6, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeScheduleListFragment$initData$4 guildHomeScheduleListFragment$initData$4 = new GuildHomeScheduleListFragment$initData$4(this.this$0, continuation);
        guildHomeScheduleListFragment$initData$4.L$0 = obj;
        return guildHomeScheduleListFragment$initData$4;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GuildHomeScheduleViewModel.CalendarEntries calendarEntries, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeScheduleListFragment$initData$4) create(calendarEntries, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0130, code lost:
    
        if (r0 == false) goto L58;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        View view;
        boolean z16;
        boolean z17;
        boolean z18;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuildHomeScheduleViewModel.CalendarEntries calendarEntries = (GuildHomeScheduleViewModel.CalendarEntries) this.L$0;
            final List<com.tencent.mobileqq.guild.home.schedule.models.d> c16 = calendarEntries.c();
            final boolean isForwardEnd = calendarEntries.getIsForwardEnd();
            final boolean isBackwardEnd = calendarEntries.getIsBackwardEnd();
            int firstPos = calendarEntries.getFirstPos();
            List<com.tencent.mobileqq.guild.home.schedule.models.d> subList = calendarEntries.c().subList(firstPos, c16.size());
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "flowCalendarEntries, submitList -> " + firstPos + " " + subList.size());
            }
            int i3 = 0;
            int i16 = 0;
            for (Object obj2 : subList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) obj2;
                Logger logger2 = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "flowCalendarEntries, submit -> " + i16 + " " + dVar);
                }
                i16 = i17;
            }
            this.this$0.adapterPendingItems = subList;
            this.this$0.adapter.setItems(subList);
            boolean z19 = true;
            ScheduleRecyclerView scheduleRecyclerView = null;
            if ((!c16.isEmpty()) && (!isBackwardEnd || !isForwardEnd || firstPos > 0)) {
                ScheduleRecyclerView scheduleRecyclerView2 = this.this$0.recyclerView;
                if (scheduleRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    scheduleRecyclerView2 = null;
                }
                final GuildHomeScheduleListFragment guildHomeScheduleListFragment = this.this$0;
                scheduleRecyclerView2.postOnAnimationDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildHomeScheduleListFragment$initData$4.e(GuildHomeScheduleListFragment.this, c16, isBackwardEnd, isForwardEnd);
                    }
                }, 100L);
            }
            if (!c16.isEmpty()) {
                List<com.tencent.mobileqq.guild.home.schedule.models.d> list = c16;
                boolean z26 = list instanceof Collection;
                if (!z26 || !list.isEmpty()) {
                    for (com.tencent.mobileqq.guild.home.schedule.models.d dVar2 : list) {
                        if ((dVar2 instanceof Empty) && !((Empty) dVar2).getNewStyle()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                    if (!z26 || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (((com.tencent.mobileqq.guild.home.schedule.models.d) it.next()) instanceof ErrorItem) {
                                z18 = true;
                                break;
                            }
                        }
                    }
                    z18 = false;
                }
            }
            z19 = false;
            view = this.this$0.btnPickDate;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPickDate");
                view = null;
            }
            if (!z19) {
                i3 = 8;
            }
            view.setVisibility(i3);
            if (!calendarEntries.getFromRefresh()) {
                this.this$0.locateTarget = null;
            } else {
                GuildHomeScheduleListFragment guildHomeScheduleListFragment2 = this.this$0;
                GuildHomeScheduleViewModel guildHomeScheduleViewModel = guildHomeScheduleListFragment2.viewModel;
                if (guildHomeScheduleViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildHomeScheduleViewModel = null;
                }
                guildHomeScheduleListFragment2.locateTarget = guildHomeScheduleViewModel.getBaseDate();
            }
            ScheduleRecyclerView scheduleRecyclerView3 = this.this$0.recyclerView;
            if (scheduleRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                scheduleRecyclerView = scheduleRecyclerView3;
            }
            final GuildHomeScheduleListFragment guildHomeScheduleListFragment3 = this.this$0;
            scheduleRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.k
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeScheduleListFragment$initData$4.d(GuildHomeScheduleListFragment.this);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
