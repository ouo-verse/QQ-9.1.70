package com.tencent.guild.aio.factory.business.holder.msglist;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/j;", "", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "Lcom/tencent/aio/data/msglist/a;", "msg", "", "includeFileType", "c", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f110625a = new j();

    j() {
    }

    public final void a(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GProContact gProContact = new GProContact();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        gProContact.peerUid = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        gProContact.guildId = com.tencent.guild.aio.util.a.g(g17);
        gProContact.chatType = 4;
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getChannelEventFlow(gProContact);
        }
    }

    public final boolean b(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getViewType() == 50) {
            return true;
        }
        if ((msg2 instanceof GuildMsgItem) && ((GuildMsgItem) msg2).getMsgRecord().msgType == 1) {
            return true;
        }
        return false;
    }

    public final boolean c(@NotNull com.tencent.aio.data.msglist.a msg2, boolean includeFileType) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msg2;
        if (includeFileType) {
            if (msg2.getViewType() != 4 && msg2.getViewType() != 5 && msg2.getViewType() != 11 && msg2.getViewType() != 10 && !guildMsgItem.isMixMsg() && msg2.getViewType() != 8 && msg2.getViewType() != 9 && msg2.getViewType() != 23) {
                return false;
            }
            return true;
        }
        if (msg2.getViewType() != 4 && msg2.getViewType() != 5 && msg2.getViewType() != 11 && msg2.getViewType() != 10 && !guildMsgItem.isMixMsg() && msg2.getViewType() != 23) {
            return false;
        }
        return true;
    }
}
