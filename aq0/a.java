package aq0;

import android.text.TextUtils;
import com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem;
import com.tencent.guild.aio.util.z;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import qr0.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J&\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u001a\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u001d"}, d2 = {"Laq0/a;", "", "", "position", "", "Lcom/tencent/aio/data/msglist/a;", "msgDisplayList", "", "status", "", "a", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "", h.F, "msgItem", "c", "displayList", "d", "e", "preMsg", "curMsg", "f", "", "b", TabPreloadItem.TAB_NAME_MESSAGE, "g", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    private final void a(int position, List<? extends com.tencent.aio.data.msglist.a> msgDisplayList, String status) {
        boolean equals$default;
        boolean equals$default2;
        if (!msgDisplayList.isEmpty() && position >= 0 && position < msgDisplayList.size()) {
            com.tencent.aio.data.msglist.a aVar = msgDisplayList.get(position);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
            String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, status, null, 2, null);
            String str = "2";
            if (!TextUtils.isEmpty(extInfoFromExtStr$default)) {
                equals$default = StringsKt__StringsJVMKt.equals$default(extInfoFromExtStr$default, "1", false, 2, null);
                if (!equals$default) {
                    equals$default2 = StringsKt__StringsJVMKt.equals$default(extInfoFromExtStr$default, "2", false, 2, null);
                    if (equals$default2 && !h(status, guildMsgItem)) {
                        Intrinsics.checkNotNull(msgDisplayList, "null cannot be cast to non-null type java.util.concurrent.CopyOnWriteArrayList<com.tencent.aio.data.msglist.IMsgItem>");
                        com.tencent.aio.data.msglist.a cloneNewInstance = guildMsgItem.cloneNewInstance();
                        Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                        ((GuildMsgItem) cloneNewInstance).saveExtInfoToExtStr(status, "1");
                        ((CopyOnWriteArrayList) msgDisplayList).set(position, cloneNewInstance);
                        return;
                    }
                    return;
                }
                if (h(status, guildMsgItem)) {
                    Intrinsics.checkNotNull(msgDisplayList, "null cannot be cast to non-null type java.util.concurrent.CopyOnWriteArrayList<com.tencent.aio.data.msglist.IMsgItem>");
                    com.tencent.aio.data.msglist.a cloneNewInstance2 = guildMsgItem.cloneNewInstance();
                    Intrinsics.checkNotNull(cloneNewInstance2, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    ((GuildMsgItem) cloneNewInstance2).saveExtInfoToExtStr(status, "2");
                    ((CopyOnWriteArrayList) msgDisplayList).set(position, cloneNewInstance2);
                    return;
                }
                return;
            }
            if (!h(status, guildMsgItem)) {
                str = "1";
            }
            guildMsgItem.saveExtInfoToExtStr(status, str);
        }
    }

    private final long b(GuildMsgItem msg2) {
        ReplyElement replyElement;
        ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7 && (replyElement = msgElement.replyElement) != null) {
                Intrinsics.checkNotNullExpressionValue(replyElement, "replyElement");
                Long l3 = replyElement.replayMsgSeq;
                Intrinsics.checkNotNullExpressionValue(l3, "it.replayMsgSeq");
                return l3.longValue();
            }
        }
        return 0L;
    }

    private final void c(int position, com.tencent.aio.data.msglist.a msgItem, List<? extends com.tencent.aio.data.msglist.a> msgDisplayList) {
        e(position, msgItem, msgDisplayList);
        d(position, msgItem, msgDisplayList);
    }

    private final void d(int position, com.tencent.aio.data.msglist.a msgItem, List<? extends com.tencent.aio.data.msglist.a> displayList) {
        boolean z16;
        if (position >= 0) {
            int i3 = position + 1;
            if (displayList.size() > i3) {
                com.tencent.aio.data.msglist.a aVar = displayList.get(i3);
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                if (guildMsgItem.getMsgRecord().msgType != 5 && guildMsgItem.getIsNeedCombine()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                ((GuildMsgItem) msgItem).setIsLastMsgNeedCombine(z16);
            }
            a(position, displayList, "guild_last_msg_combine_status");
        }
    }

    private final void e(int position, com.tencent.aio.data.msglist.a msgItem, List<? extends com.tencent.aio.data.msglist.a> displayList) {
        boolean z16;
        if (position > 0) {
            int i3 = position - 1;
            if (displayList.size() > position) {
                com.tencent.aio.data.msglist.a aVar = displayList.get(i3);
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem2 = (GuildMsgItem) msgItem;
                boolean z17 = false;
                if (guildMsgItem2.getMsgRecord().msgType == 5 || z.f112475a.a(guildMsgItem.getMsgRecord().msgTime, guildMsgItem2.getMsgRecord().msgTime)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (guildMsgItem2.getMsgRecord().msgTime - guildMsgItem.getMsgRecord().msgTime <= 30 && !z16 && guildMsgItem.getMsgRecord().senderUid.equals(guildMsgItem2.getMsgRecord().senderUid)) {
                    z17 = true;
                }
                guildMsgItem2.setIsNeedCombine(z17);
                f(guildMsgItem, guildMsgItem2);
            }
        }
        a(position, displayList, "guild_current_msg_combine_status");
    }

    private final void f(GuildMsgItem preMsg, GuildMsgItem curMsg) {
        if (preMsg != null && curMsg != null) {
            if (preMsg.getMsgRecord().msgType == 5) {
                curMsg.setIsNeedCombine(false);
            }
            if (preMsg instanceof GuildWelcomeMsgItem) {
                curMsg.setIsNeedCombine(false);
            }
            if (d.g(curMsg) || curMsg.getMsgRecord().msgType == 11 || curMsg.getMsgRecord().msgType == 3 || curMsg.getMsgRecord().msgType == 10 || d.g(preMsg) || preMsg.getMsgRecord().msgType == 11 || preMsg.getMsgRecord().msgType == 3 || preMsg.getMsgRecord().msgType == 10) {
                curMsg.setIsNeedCombine(false);
            }
            if (curMsg.getMsgRecord().emojiLikesList.size() > 0 || preMsg.getMsgRecord().emojiLikesList.size() > 0) {
                curMsg.setIsNeedCombine(false);
            }
            if (preMsg.getMsgRecord().msgType != 9 && curMsg.getMsgRecord().msgType == 9) {
                curMsg.setIsNeedCombine(false);
            }
            if (preMsg.getMsgRecord().msgType == 9 && curMsg.getMsgRecord().msgType != 9) {
                curMsg.setIsNeedCombine(false);
            }
            if (preMsg.getMsgRecord().msgType == 9 && curMsg.getMsgRecord().msgType == 9 && curMsg.getIsNeedCombine() && b(preMsg) != b(curMsg)) {
                curMsg.setIsNeedCombine(false);
            }
        }
    }

    private final boolean h(String status, GuildMsgItem msg2) {
        if (Intrinsics.areEqual(status, "guild_current_msg_combine_status")) {
            return msg2.getIsNeedCombine();
        }
        if (Intrinsics.areEqual(status, "guild_last_msg_combine_status")) {
            return msg2.getIsLastMsgNeedCombine();
        }
        return false;
    }

    public final void g(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (msgList.isEmpty()) {
            return;
        }
        int size = msgList.size();
        while (true) {
            size--;
            if (-1 < size) {
                c(size, msgList.get(size), msgList);
            } else {
                return;
            }
        }
    }
}
