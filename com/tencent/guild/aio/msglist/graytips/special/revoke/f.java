package com.tencent.guild.aio.msglist.graytips.special.revoke;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.msglist.graytips.special.revoke.GuildRevokeGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.revoke.c;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.aio.util.l;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xp0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0001GB3\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u0010?\u001a\u000208\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J2\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R$\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/f;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "", "tinyId", "", "u", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "revokeElement", ReportConstant.COSTREPORT_PREFIX, "uid", "v", "Lcom/tencent/aio/data/msglist/a;", "mr", "o", "", "res", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "t", "msgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "msg", "w", "Lol3/b;", "intent", "handleIntent", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "getMRevokeElement", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "setMRevokeElement", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;)V", "mRevokeElement", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "getMGuildMsgItem", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "setMGuildMsgItem", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "mGuildMsgItem", "f", "Ljava/lang/String;", "getMGuildId", "()Ljava/lang/String;", "setMGuildId", "(Ljava/lang/String;)V", "mGuildId", "", h.F, "Z", "getMNeedUpdateGrayTipNick", "()Z", "setMNeedUpdateGrayTipNick", "(Z)V", "mNeedUpdateGrayTipNick", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "i", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Ljava/lang/String;Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RevokeElement mRevokeElement;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem mGuildMsgItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedUpdateGrayTipNick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/graytips/special/revoke/f$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "onUserDisplayNameUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            f.this.u(tinyId);
        }
    }

    public /* synthetic */ f(RevokeElement revokeElement, GuildMsgItem guildMsgItem, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : revokeElement, (i3 & 2) != 0 ? null : guildMsgItem, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? false : z16);
    }

    private final void o(com.tencent.aio.data.msglist.a mr5) {
        List mutableListOf;
        Intrinsics.checkNotNull(mr5, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) mr5;
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        Contact contact = new Contact(guildMsgItem.getMsgRecord().chatType, guildMsgItem.getMsgRecord().peerUid, guildMsgItem.getMsgRecord().guildId);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(guildMsgItem.getMsgRecord().msgId));
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.getRecallMsgsByMsgId(contact, (ArrayList) mutableListOf, new IMsgOperateCallback() { // from class: com.tencent.guild.aio.msglist.graytips.special.revoke.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                f.p(f.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(f this$0, int i3, String str, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        this$0.t(i3, str, msgList);
    }

    private final void q(final com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        String str = guildMsgItem.getMsgRecord().guildId;
        String str2 = guildMsgItem.getMsgRecord().peerUid;
        Boolean isAdmin = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30001, str, str2);
        long j3 = guildMsgItem.getMsgRecord().msgId;
        Intrinsics.checkNotNullExpressionValue(isAdmin, "isAdmin");
        if (isAdmin.booleanValue()) {
            w(guildMsgItem);
            return;
        }
        GProContact gProContact = new GProContact(guildMsgItem.getMsgRecord().chatType, str2, str);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.deleteRecallMsgForLocal(gProContact, j3, new IGuildOperateCallback() { // from class: com.tencent.guild.aio.msglist.graytips.special.revoke.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str3) {
                    f.r(f.this, msgItem, i3, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(f this$0, com.tencent.aio.data.msglist.a msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        QLog.d("GuildRevokeGrayTipsVM", 1, "[handleDeleteMsg] res = " + i3 + ", errMsg = " + str);
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new DeleteGrayTipsMsgIntent((GuildMsgItem) msgItem));
    }

    private final void s(GuildMsgItem guildMsgItem, RevokeElement revokeElement) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        String obj;
        String obj2;
        String obj3;
        String obj4;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String str2 = "";
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        this.mGuildId = yp0.a.b(guildMsgItem.getMsgRecord());
        boolean z16 = false;
        if (TextUtils.equals(guildMsgItem.getMsgRecord().senderUid, String.valueOf(revokeElement.operatorTinyId))) {
            if (TextUtils.equals(str, guildMsgItem.getMsgRecord().senderUid)) {
                if (guildMsgItem.getMsgRecord().editable) {
                    obj = l.b(l.f112411a, R.string.f1385409u, null, 2, null).toString();
                    z16 = true;
                    obj2 = "";
                } else {
                    l lVar = l.f112411a;
                    String obj5 = l.b(lVar, R.string.f1385409u, null, 2, null).toString();
                    obj2 = l.b(lVar, R.string.f1502514h, null, 2, null).toString();
                    obj = obj5;
                }
            } else {
                obj = v(String.valueOf(revokeElement.operatorTinyId));
                obj2 = l.b(l.f112411a, R.string.f1502514h, null, 2, null).toString();
            }
        } else {
            if (TextUtils.equals(str, String.valueOf(revokeElement.operatorTinyId))) {
                l lVar2 = l.f112411a;
                obj = l.b(lVar2, R.string.f1385409u, null, 2, null).toString();
                obj3 = v(guildMsgItem.getMsgRecord().senderUid.toString());
                obj4 = l.b(lVar2, R.string.f1502314f, null, 2, null).toString();
            } else {
                String str3 = this.mGuildId;
                String str4 = guildMsgItem.getMsgRecord().channelId;
                Intrinsics.checkNotNullExpressionValue(str4, "guildMsgItem.msgRecord.channelId");
                if (yp0.a.d(str3, str4)) {
                    obj = v(String.valueOf(revokeElement.operatorTinyId));
                } else {
                    obj = l.b(l.f112411a, R.string.f1385209s, null, 2, null).toString();
                }
                if (guildMsgItem.isSelf()) {
                    l lVar3 = l.f112411a;
                    obj3 = l.b(lVar3, R.string.f1385409u, null, 2, null).toString();
                    obj4 = l.b(lVar3, R.string.f1502314f, null, 2, null).toString();
                } else {
                    String str5 = this.mGuildId;
                    String str6 = guildMsgItem.getMsgRecord().channelId;
                    Intrinsics.checkNotNullExpressionValue(str6, "guildMsgItem.msgRecord.channelId");
                    if (yp0.a.d(str5, str6)) {
                        str2 = yp0.a.a(v(guildMsgItem.getMsgRecord().senderUid.toString()));
                        obj2 = l.b(l.f112411a, R.string.f1502314f, null, 2, null).toString();
                        obj = yp0.a.a(obj);
                    } else {
                        obj2 = l.b(l.f112411a, R.string.f1502414g, null, 2, null).toString();
                    }
                }
            }
            obj2 = obj4;
            str2 = obj3;
        }
        QLog.i("GuildRevokeGrayTipsVM", 1, "senderUid: " + guildMsgItem.getMsgRecord().senderUid + ", operatorTinyId: " + revokeElement.operatorTinyId + ", selfTinyId: " + str + ", msgSeq: " + guildMsgItem.getMsgRecord().msgSeq + ", sendType: " + guildMsgItem.getMsgRecord().sendType);
        updateUI(new GuildRevokeGrayTipsUIState.SetRevokeText(obj, str2, obj2, z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(int res, String errMsg, ArrayList<MsgRecord> msgList) {
        if (res == 0 && msgList.size() > 0) {
            MsgRecord msgRecord = msgList.get(0);
            Intrinsics.checkNotNullExpressionValue(msgRecord, "msgList[0]");
            MsgRecord msgRecord2 = msgRecord;
            if (msgRecord2.msgType == 5 && !com.tencent.guild.aio.util.ex.a.l((com.tencent.aio.api.runtime.a) getMContext())) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgSendEvent.MsgOnClickRecallMsgsEvent(msgRecord2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String tinyId) {
        GuildMsgItem guildMsgItem = this.mGuildMsgItem;
        if (guildMsgItem != null && this.mRevokeElement != null) {
            Intrinsics.checkNotNull(guildMsgItem);
            if (!TextUtils.equals(tinyId, guildMsgItem.getMsgRecord().senderUid)) {
                RevokeElement revokeElement = this.mRevokeElement;
                Intrinsics.checkNotNull(revokeElement);
                if (!TextUtils.equals(tinyId, String.valueOf(revokeElement.operatorTinyId))) {
                    return;
                }
            }
            if (this.mNeedUpdateGrayTipNick) {
                GuildMsgItem guildMsgItem2 = this.mGuildMsgItem;
                Intrinsics.checkNotNull(guildMsgItem2);
                RevokeElement revokeElement2 = this.mRevokeElement;
                Intrinsics.checkNotNull(revokeElement2);
                s(guildMsgItem2, revokeElement2);
            }
        }
    }

    private final String v(String uid) {
        this.mNeedUpdateGrayTipNick = true;
        return iq0.a.u(uid, this.mGuildId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(GuildMsgItem msg2) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            co0.a.f31161a.e(supportFragmentManager, msg2, (com.tencent.aio.api.runtime.a) getMContext());
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            c.a aVar = (c.a) intent;
            this.mRevokeElement = aVar.getRevokeElement();
            this.mGuildMsgItem = aVar.getGuildMsgItem();
            s(aVar.getGuildMsgItem(), aVar.getRevokeElement());
            return;
        }
        if (intent instanceof b.C11559b) {
            q(((b.C11559b) intent).getMsgItem());
        } else if (intent instanceof b.a) {
            o(((b.a) intent).getMsgItem());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.observer);
        }
    }

    public f(@Nullable RevokeElement revokeElement, @Nullable GuildMsgItem guildMsgItem, @NotNull String mGuildId, boolean z16) {
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        this.mRevokeElement = revokeElement;
        this.mGuildMsgItem = guildMsgItem;
        this.mGuildId = mGuildId;
        this.mNeedUpdateGrayTipNick = z16;
        this.observer = new b();
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.observer);
        }
    }
}
