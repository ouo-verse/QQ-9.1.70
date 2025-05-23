package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildNoticeViewHolder$bindData$1 extends FunctionReferenceImpl implements Function2<String, Function1<? super IGProGuildInfo, ? extends Unit>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildNoticeViewHolder$bindData$1(Object obj) {
        super(2, obj, GuildNoticeViewHolder.class, "fetchGuildInfoAnyway", "fetchGuildInfoAnyway(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Function1<? super IGProGuildInfo, ? extends Unit> function1) {
        invoke2(str, (Function1<? super IGProGuildInfo, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String p06, @NotNull Function1<? super IGProGuildInfo, Unit> p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildNoticeViewHolder) this.receiver).K(p06, p16);
    }
}
