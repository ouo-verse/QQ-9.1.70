package com.tencent.guild.aio.msglist.text.util;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public /* synthetic */ class GuildCombineUtil$getMixBubbleBackgroundColorResObserver$1 extends FunctionReferenceImpl implements Function1<GuildMsgItem, Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildCombineUtil$getMixBubbleBackgroundColorResObserver$1(Object obj) {
        super(1, obj, GuildCombineUtil.class, "getMixBubbleCombineMsgBackgroundRes", "getMixBubbleCombineMsgBackgroundRes(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Integer invoke(@NotNull GuildMsgItem p06) {
        int p16;
        Intrinsics.checkNotNullParameter(p06, "p0");
        p16 = ((GuildCombineUtil) this.receiver).p(p06);
        return Integer.valueOf(p16);
    }
}
