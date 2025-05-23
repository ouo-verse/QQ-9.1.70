package com.tencent.mobileqq.guild.home.schedule.list;

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
public /* synthetic */ class GuildHomeScheduleListFragment$newAdapter$2 extends FunctionReferenceImpl implements Function1<com.tencent.mobileqq.guild.home.schedule.models.d, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeScheduleListFragment$newAdapter$2(Object obj) {
        super(1, obj, GuildHomeScheduleListFragment.class, "onLoadNext", "onLoadNext(Lcom/tencent/mobileqq/guild/home/schedule/models/IScheduleItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.home.schedule.models.d dVar) {
        invoke2(dVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.mobileqq.guild.home.schedule.models.d p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildHomeScheduleListFragment) this.receiver).Ii(p06);
    }
}
