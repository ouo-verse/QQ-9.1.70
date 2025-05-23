package com.tencent.mobileqq.guild.inbox.centerpanel.assistant;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildAssistantFragment$mAdapter$2 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildAssistantFragment$mAdapter$2(Object obj) {
        super(2, obj, GuildAssistantFragment.class, "handleJumpTargetGuild", "handleJumpTargetGuild(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String p06, @NotNull String p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildAssistantFragment) this.receiver).Oh(p06, p16);
    }
}
