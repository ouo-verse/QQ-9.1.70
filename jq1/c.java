package jq1;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Ljq1/c;", "Ljq1/e;", "", "c", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c implements e {
    private final boolean c() {
        Integer value = GLiveChannelCore.f226698a.t().l().getValue();
        if (value != null && value.intValue() == 2) {
            return true;
        }
        return false;
    }

    @Override // jq1.e
    public boolean a() {
        return c();
    }

    @Override // jq1.e
    @NotNull
    public com.tencent.mobileqq.guild.live.danmu.item.a b(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return new com.tencent.mobileqq.guild.live.danmu.item.c(msgItem);
    }
}
