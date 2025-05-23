package com.tencent.mobileqq.guild.home.schedule.list;

import com.tencent.mobileqq.guild.home.schedule.ScheduleEntryListAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildHomeScheduleListFragment$initViews$stickyItemDecoration$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeScheduleListFragment$initViews$stickyItemDecoration$1(Object obj) {
        super(1, obj, ScheduleEntryListAdapter.class, "isItemHeader", "isItemHeader(I)Z", 0);
    }

    @NotNull
    public final Boolean invoke(int i3) {
        return Boolean.valueOf(((ScheduleEntryListAdapter) this.receiver).n0(i3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return invoke(num.intValue());
    }
}
