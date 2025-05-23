package com.tencent.guild.aio.util.ex;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "d", "b", "c", "", "a", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)Ljava/lang/String;", "sourceGuildId", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {
    @NotNull
    public static final String a(@NotNull GuildMsgItem guildMsgItem) {
        String guildId;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        QRouteApi api = QRoute.api(IGuildDirectMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildDirectMsgUtilApi::class.java)");
        IGuildDirectMsgUtilApi iGuildDirectMsgUtilApi = (IGuildDirectMsgUtilApi) api;
        if (guildMsgItem.getMsgRecord().directMsgFlag == 1) {
            String str = guildMsgItem.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.channelId");
            if (iGuildDirectMsgUtilApi.hasDirectMsgFlag(str)) {
                String str2 = guildMsgItem.getMsgRecord().channelId;
                Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.channelId");
                guildId = String.valueOf(iGuildDirectMsgUtilApi.getSourceGuildId(str2));
                Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                return guildId;
            }
        }
        guildId = guildMsgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return guildId;
    }

    public static final boolean b(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType == 1) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 5) {
            return false;
        }
        Iterator<MsgElement> it = guildMsgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            GrayTipElement grayTipElement = it.next().grayTipElement;
            if (grayTipElement != null && grayTipElement.revokeElement != null) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (!b(guildMsgItem) && !c(guildMsgItem)) {
            return false;
        }
        return true;
    }
}
