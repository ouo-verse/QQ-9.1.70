package com.tencent.mobileqq.guild.inbox.centerpanel.income;

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
public /* synthetic */ class GuildNoticeIncomeFragment$initListView$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildNoticeIncomeFragment$initListView$1(Object obj) {
        super(1, obj, GuildNoticeIncomeFragment.class, "handleJumpTargetH5", "handleJumpTargetH5(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildNoticeIncomeFragment) this.receiver).Ih(p06);
    }
}
