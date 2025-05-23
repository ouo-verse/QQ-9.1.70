package com.tencent.mobileqq.guild.home.schedule.list;

import com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildHomeScheduleListFragment$newAdapter$4 extends FunctionReferenceImpl implements Function1<ScheduleInfoItem, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeScheduleListFragment$newAdapter$4(Object obj) {
        super(1, obj, GuildHomeScheduleListFragment.class, "onClickScheduleItem", "onClickScheduleItem(Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScheduleInfoItem scheduleInfoItem) {
        invoke2(scheduleInfoItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ScheduleInfoItem p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildHomeScheduleListFragment) this.receiver).Gi(p06);
    }
}
