package com.tencent.guildlive.aio.msglist.item.graytips;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.halfpop.BaseBottomSheetDialog;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.halfpop.menu.p;
import com.tencent.guild.aio.halfpop.menu.q;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM;
import com.tencent.guildlive.aio.msglist.item.graytips.a;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
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
import java.util.Iterator;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/graytips/e;", "Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM;", "", "msgSeq", "", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", BdhLogUtil.LogTag.Tag_Conn, "msg", "K", "H", "", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "u", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends GuildLiveItemBaseVM {
    private final void C(final GuildMsgItem msgItem) {
        String str = msgItem.getMsgRecord().guildId;
        String str2 = msgItem.getMsgRecord().peerUid;
        Boolean isAdmin = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30004, str, str2);
        long j3 = msgItem.getMsgRecord().msgId;
        Intrinsics.checkNotNullExpressionValue(isAdmin, "isAdmin");
        if (isAdmin.booleanValue()) {
            K(msgItem);
            return;
        }
        GProContact gProContact = new GProContact(msgItem.getMsgRecord().chatType, str2, str);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.deleteRecallMsgForLocal(gProContact, j3, new IGuildOperateCallback() { // from class: com.tencent.guildlive.aio.msglist.item.graytips.c
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str3) {
                    e.D(e.this, msgItem, i3, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void D(e this$0, GuildMsgItem msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveGrayTipsContentVM", "[handleDeleteMsg] res = " + i3 + ", errMsg = " + str);
        if (y.b(i3)) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new DeleteGrayTipsMsgIntent(msgItem));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(final long msgSeq) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(msgSeq));
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        iMsgService.getMsgsBySeqs(new Contact(4, b16, com.tencent.guild.aio.util.a.g(g17)), arrayList, new IMsgOperateCallback() { // from class: com.tencent.guildlive.aio.msglist.item.graytips.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList2) {
                e.G(e.this, msgSeq, i3, str, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(e this$0, long j3, int i3, String str, ArrayList msgList) {
        Object obj;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            GuildLiveLogUtil.INSTANCE.d("GuildLiveGrayTipsContentVM", "[handleJumpExcellentSourceMsg] result: " + i3 + ", errMsg, " + str);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        Iterator it = msgList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgRecord) obj).msgSeq == j3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgRecord msgRecord = (MsgRecord) obj;
        if (msgRecord != null) {
            z16 = com.tencent.guild.aio.util.ex.d.a(msgRecord);
        } else {
            z16 = false;
        }
        if (z16) {
            g.c(0, R.string.f152991aw);
        } else {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new GuildLiveOuterMsgIntent$JumpToSeqMsg(j3));
        }
    }

    private final void H(GuildMsgItem msgItem) {
        List mutableListOf;
        Contact contact = new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().guildId);
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(msgItem.getMsgRecord().msgId));
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.getRecallMsgsByMsgId(contact, (ArrayList) mutableListOf, new IMsgOperateCallback() { // from class: com.tencent.guildlive.aio.msglist.item.graytips.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                e.J(e.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void J(e this$0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveGrayTipsContentVM", "[handleReedit] res = " + i3 + ", errMsg = " + str + ", msgList = " + arrayList);
        if (y.b(i3) && arrayList.size() > 0) {
            MsgRecord msgRecord = (MsgRecord) arrayList.get(0);
            j e16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e();
            Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
            e16.h(new GuildLiveRevokeMsgIntent$ReeditIntent(msgRecord));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(GuildMsgItem msg2) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            BaseBottomSheetDialog baseBottomSheetDialog = new BaseBottomSheetDialog();
            baseBottomSheetDialog.yh(co0.b.f31162a.a(com.tencent.guild.aio.halfpop.c.f110667a.d(), msg2, (com.tencent.aio.api.runtime.a) getMContext(), false));
            baseBottomSheetDialog.vh(true);
            baseBottomSheetDialog.th(R.drawable.guild_live_aio_msgmenu_bg);
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

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof a.c) {
            H(((a.c) intent).getMsgItem());
        } else if (intent instanceof a.C1227a) {
            C(((a.C1227a) intent).getMsgItem());
        } else if (intent instanceof a.b) {
            F(((a.b) intent).getMsgSeq());
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM
    public void u(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof GuildMsgListIntent.UpdateReeditRecallMsgListEvent) {
            updateUI(new GuildRevokeMsgReeditUIState(((GuildMsgListIntent.UpdateReeditRecallMsgListEvent) i3).getMsgRecord()));
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM
    @NotNull
    public List<String> y() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.UpdateReeditRecallMsgListEvent.class).getQualifiedName());
        return listOf;
    }
}
