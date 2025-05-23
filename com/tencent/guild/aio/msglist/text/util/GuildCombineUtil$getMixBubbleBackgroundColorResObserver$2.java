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
public /* synthetic */ class GuildCombineUtil$getMixBubbleBackgroundColorResObserver$2 extends FunctionReferenceImpl implements Function1<GuildMsgItem, float[]> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildCombineUtil$getMixBubbleBackgroundColorResObserver$2(Object obj) {
        super(1, obj, GuildCombineUtil.class, "getCombineMsgBackgroundRadii", "getCombineMsgBackgroundRadii(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)[F", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final float[] invoke(@NotNull GuildMsgItem p06) {
        float[] m3;
        Intrinsics.checkNotNullParameter(p06, "p0");
        m3 = ((GuildCombineUtil) this.receiver).m(p06);
        return m3;
    }
}
