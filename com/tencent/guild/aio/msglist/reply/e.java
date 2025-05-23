package com.tencent.guild.aio.msglist.reply;

import android.R;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOSession;
import com.tencent.guild.aio.chosen.fragment.GuildChosenWrapperFragment;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0017J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002H\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/msglist/reply/e;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "rootMsgSeq", "msgSeq", "o", "Landroid/view/View;", "view", ReportConstant.COSTREPORT_PREFIX, "", "t", "", "type", "u", "clickedView", "r", "Lcom/tencent/aio/data/msglist/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/FragmentManager;", DomainData.DOMAIN_NAME, "data", "position", "", "", "payloads", "j", "intent", "p", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {
    private final com.tencent.aio.data.msglist.a m() {
        MsgListItemState msgListItemState = (MsgListItemState) getDefaultState().getValue();
        if (msgListItemState != null) {
            return msgListItemState.getData();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentManager n() {
        FragmentActivity activity;
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 != null && (activity = c16.getActivity()) != null) {
            return activity.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(long rootMsgSeq, long msgSeq) {
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            AIOSession r16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r();
            Contact contact = new Contact();
            contact.peerUid = r16.c().j();
            contact.guildId = r16.c().f();
            contact.chatType = r16.c().e();
            in0.c.b(activity, contact, rootMsgSeq, Long.valueOf(msgSeq), (com.tencent.aio.api.runtime.a) getMContext(), 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildReplyBubbleMsgItemVM", false, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(View clickedView) {
        com.tencent.aio.data.msglist.a m3 = m();
        if (m3 == null) {
            QLog.e("GuildReplyBubbleMsgItemVM", 1, "handleMsgItemContentClick, msgItem == null");
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgItemContentViewClickEvent(m3, clickedView));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(View view) {
        com.tencent.aio.data.msglist.a m3 = m();
        if (m3 == null) {
            return;
        }
        GuildMsgItem guildMsgItem = (GuildMsgItem) m3;
        String str = guildMsgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "data as GuildMsgItem).msgRecord.guildId");
        String str2 = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "data.msgRecord.channelId");
        if (GuildSpeakLimitStatus.INSTANCE.F(fo0.h.a(str, str2))) {
            return;
        }
        String str3 = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str3, "data.msgRecord.channelId");
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(str3, com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        if (t()) {
            QLog.i("GuildReplyBubbleMsgItemVM", 4, "inGlobalNoticeAio");
            return;
        }
        if (GuildMultiMsgManager.INSTANCE.a().i(dVar)) {
            return;
        }
        if (u(m3.getViewType())) {
            QLog.i("GuildReplyBubbleMsgItemVM", 4, "is unSupport msg type");
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildReplyBubbleMsgItemVM", false));
        FragmentManager n3 = n();
        if (n3 != null) {
            if (view != null) {
                view.setSelected(true);
            }
            QLog.i("GuildReplyBubbleMsgItemVM", 4, "popMsgLongPressMenu for normal channel");
            if (n3.findFragmentById(R.id.content) instanceof GuildChosenWrapperFragment) {
                co0.a.f31161a.d(n3, m3, (com.tencent.aio.api.runtime.a) getMContext(), view);
            } else {
                co0.a.f31161a.f(n3, m3, (com.tencent.aio.api.runtime.a) getMContext(), view);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean t() {
        return Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), ((IGuildDirectMsgChannelApi) QRoute.api(IGuildDirectMsgChannelApi.class)).getGlobalNoticeAioFactoryName());
    }

    private final boolean u(int type) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.list.b
    @CallSuper
    public void j(@NotNull com.tencent.aio.data.msglist.a data, int position, @NotNull List<Object> payloads) {
        List mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListCombineEvent(position, data, payloads));
        GuildMultiMsgManager.MultiSelectMode multiSelectMode = new GuildMultiMsgManager.MultiSelectMode(UIUtil.f112434a.y((com.tencent.aio.api.runtime.a) getMContext()));
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) new ArrayList(payloads));
        mutableList.add(multiSelectMode);
        updateUI(new MsgListItemState(data, position, mutableList));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.factory.business.holder.msglist.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            q();
            return;
        }
        if (intent instanceof a.d) {
            s(((a.d) intent).getView());
            return;
        }
        if (intent instanceof a.c) {
            r(((a.c) intent).getBubbleView());
        } else if (intent instanceof a.k) {
            a.k kVar = (a.k) intent;
            o(kVar.getReplayMsgRootSeq(), kVar.getMsgSeq());
        }
    }
}
