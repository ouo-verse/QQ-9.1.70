package com.tencent.guildmedia.aio.msglist.item.graytips;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.halfpop.BaseBottomSheetDialog;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.halfpop.menu.p;
import com.tencent.guild.aio.halfpop.menu.q;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildmedia.aio.msglist.item.graytips.a;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/graytips/d;", "Lcom/tencent/guild/aio/component/combinestyle/GuildMediaItemBaseVM;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "B", "msg", "G", "D", "", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "u", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", h.F, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends GuildMediaItemBaseVM {
    private final void B(final GuildMsgItem msgItem) {
        String str = msgItem.getMsgRecord().guildId;
        String str2 = msgItem.getMsgRecord().peerUid;
        Boolean isAdmin = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30003, str, str2);
        long j3 = msgItem.getMsgRecord().msgId;
        Intrinsics.checkNotNullExpressionValue(isAdmin, "isAdmin");
        if (isAdmin.booleanValue()) {
            G(msgItem);
            return;
        }
        GProContact gProContact = new GProContact(msgItem.getMsgRecord().chatType, str2, str);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.deleteRecallMsgForLocal(gProContact, j3, new IGuildOperateCallback() { // from class: com.tencent.guildmedia.aio.msglist.item.graytips.c
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str3) {
                    d.C(d.this, msgItem, i3, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(d this$0, GuildMsgItem msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        GuildMediaLogUtil.INSTANCE.c("GuildMediaGrayTipsContentVM", "[handleDeleteMsg] res = " + i3 + ", errMsg = " + str);
        if (y.b(i3)) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new DeleteGrayTipsMsgIntent(msgItem));
        }
    }

    private final void D(GuildMsgItem msgItem) {
        List mutableListOf;
        Contact contact = new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().guildId);
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(msgItem.getMsgRecord().msgId));
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.getRecallMsgsByMsgId(contact, (ArrayList) mutableListOf, new IMsgOperateCallback() { // from class: com.tencent.guildmedia.aio.msglist.item.graytips.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                d.F(d.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(d this$0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMediaLogUtil.INSTANCE.c("GuildMediaGrayTipsContentVM", "[handleReedit] res = " + i3 + ", errMsg = " + str + ", msgList = " + arrayList);
        if (y.b(i3) && arrayList.size() > 0) {
            MsgRecord msgRecord = (MsgRecord) arrayList.get(0);
            j e16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e();
            Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
            e16.h(new GuildMediaRevokeMsgIntent$ReeditIntent(msgRecord));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(GuildMsgItem msg2) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(co0.b.f31162a.a(com.tencent.guild.aio.halfpop.c.f110667a.d(), msg2, (com.tencent.aio.api.runtime.a) getMContext(), false));
            baseBottomSheetDialog.vh(true);
            baseBottomSheetDialog.th(R.drawable.guild_media_aio_msgmenu_bg_dark);
            baseBottomSheetDialog.setCancelable(true);
            q qVar = new q();
            qVar.h(Integer.valueOf(R.drawable.guild_live_top_msg_action_sheet_item_bg));
            qVar.g(0);
            p pVar = new p();
            pVar.e(Integer.valueOf(R.color.bq8));
            pVar.f(Integer.valueOf(R.color.brx));
            baseBottomSheetDialog.xh(new s(pVar, qVar, null, 4, null));
            if (supportFragmentManager.isStateSaved()) {
                QLog.e("BaseBottomSheetDialog", 1, "isStateSaved==true");
            } else {
                baseBottomSheetDialog.show(supportFragmentManager, "BaseBottomSheetDialog");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof a.c) {
            D(((a.c) intent).getMsgItem());
        } else if (intent instanceof a.C1236a) {
            B(((a.C1236a) intent).getMsgItem());
        } else if (intent instanceof a.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMediaOuterMsgIntent$JumpToSeqMsg(((a.b) intent).getMsgSeq()));
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM
    public void u(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof GuildMsgListIntent.UpdateReeditRecallMsgListEvent) {
            updateUI(new GuildRevokeMsgReeditUIState(((GuildMsgListIntent.UpdateReeditRecallMsgListEvent) i3).getMsgRecord()));
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM
    @NotNull
    public List<String> y() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.UpdateReeditRecallMsgListEvent.class).getQualifiedName());
        return listOf;
    }
}
