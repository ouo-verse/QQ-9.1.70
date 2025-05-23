package com.tencent.guildlive.aio.msglist.holder.component;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.msglist.reply.GuildUpdateReplyMsgOnMsgRevoke;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$JumpToSeqMsg;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/t;", "Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM;", "", "msgSeq", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "u", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class t extends GuildLiveItemBaseVM {
    /* JADX WARN: Multi-variable type inference failed */
    private final void z(long msgSeq) {
        if (com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()) == FromScene.CHOSEN.ordinal()) {
            FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("guild_live_msg_seq", msgSeq);
                activity.setResult(539100465, intent);
                activity.finish();
                return;
            }
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildLiveOuterMsgIntent$JumpToSeqMsg(msgSeq));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof k) {
            z(((k) intent).getMsgSeq());
        } else if (intent instanceof c) {
            ((c) intent).b(yr0.a.a((com.tencent.aio.api.runtime.a) getMContext()));
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM
    public void u(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        super.u(i3);
        if (i3 instanceof GuildUpdateReplyMsgOnMsgRevoke) {
            updateUI(new GuildUpdateReplyMsgUIState(((GuildUpdateReplyMsgOnMsgRevoke) i3).a()));
        } else if (i3 instanceof DeleteGrayTipsMsgIntent) {
            updateUI(new GuildDeleteRevokeMsgUIState(((DeleteGrayTipsMsgIntent) i3).getMsgItem().getMsgRecord().msgSeq));
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM
    @NotNull
    public List<String> y() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildUpdateReplyMsgOnMsgRevoke.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(DeleteGrayTipsMsgIntent.class).getQualifiedName()});
        return listOf;
    }
}
