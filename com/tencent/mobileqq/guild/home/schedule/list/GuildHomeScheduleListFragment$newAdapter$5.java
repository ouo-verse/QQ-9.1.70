package com.tencent.mobileqq.guild.home.schedule.list;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildHomeScheduleListFragment$newAdapter$5 extends FunctionReferenceImpl implements Function0<JumpGuildParam> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeScheduleListFragment$newAdapter$5(Object obj) {
        super(0, obj, GuildHomeScheduleListFragment.class, "provideJumpGuildParam", "provideJumpGuildParam()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final JumpGuildParam invoke() {
        JumpGuildParam Li;
        Li = ((GuildHomeScheduleListFragment) this.receiver).Li();
        return Li;
    }
}
