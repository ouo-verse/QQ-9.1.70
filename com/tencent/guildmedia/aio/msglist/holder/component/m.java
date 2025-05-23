package com.tencent.guildmedia.aio.msglist.holder.component;

import com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.msglist.reply.GuildUpdateReplyMsgOnMsgRevoke;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$JumpToSeqMsg;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/holder/component/m;", "Lcom/tencent/guild/aio/component/combinestyle/GuildMediaItemBaseVM;", "", "msgSeq", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "u", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class m extends GuildMediaItemBaseVM {
    /* JADX WARN: Multi-variable type inference failed */
    private final void z(long msgSeq) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMediaOuterMsgIntent$JumpToSeqMsg(msgSeq));
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof b) {
            z(((b) intent).getMsgSeq());
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM
    public void u(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        super.u(i3);
        if (i3 instanceof GuildUpdateReplyMsgOnMsgRevoke) {
            updateUI(new GuildUpdateReplyMsgUIState(((GuildUpdateReplyMsgOnMsgRevoke) i3).a()));
        } else if (i3 instanceof DeleteGrayTipsMsgIntent) {
            updateUI(new GuildDeleteRevokeMsgUIState(((DeleteGrayTipsMsgIntent) i3).getMsgItem().getMsgRecord().msgSeq));
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM
    @NotNull
    public List<String> y() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildUpdateReplyMsgOnMsgRevoke.class).getQualifiedName());
        return listOf;
    }
}
