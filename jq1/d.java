package jq1;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Ljq1/d;", "Ljq1/e;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "b", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements e {
    @Override // jq1.e
    public boolean a() {
        return true;
    }

    @Override // jq1.e
    @NotNull
    public com.tencent.mobileqq.guild.live.danmu.item.a b(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return new com.tencent.mobileqq.guild.live.danmu.item.d(msgItem);
    }
}
