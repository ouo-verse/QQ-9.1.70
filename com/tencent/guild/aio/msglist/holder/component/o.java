package com.tencent.guild.aio.msglist.holder.component;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.halfpop.BaseBottomSheetDialog;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/o;", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "l", "j", "intent", "handleIntent", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class o extends com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void j(GuildMsgItem msgItem) {
        if (msgItem.getMsgRecord().msgType == 3) {
            Logger.f235387a.d().i("GuildBubbleMsgStatusComponentVM", 1, "ChannelAIOMsgService, cancelSendMsg msgId = " + msgItem.getMsgId());
            ChannelAIOMsgService.f112613a.g(msgItem.getMsgId(), ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e());
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgSendEvent.CancelSendVideoMsg(msgItem.getMsgId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(GuildMsgItem msgItem) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(co0.b.f31162a.a(com.tencent.guild.aio.halfpop.c.f110667a.g(), msgItem, (com.tencent.aio.api.runtime.a) getMContext(), false));
            baseBottomSheetDialog.setCancelable(true);
            baseBottomSheetDialog.vh(true);
            if (supportFragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(supportFragmentManager, "BaseBottomSheetDialog");
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.i) {
            l(((a.i) intent).getMsgItem());
        } else if (intent instanceof a.h) {
            j(((a.h) intent).getMsgItem());
        }
    }
}
