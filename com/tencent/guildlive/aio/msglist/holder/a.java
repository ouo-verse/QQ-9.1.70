package com.tencent.guildlive.aio.msglist.holder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.halfpop.menu.d;
import com.tencent.guild.aio.halfpop.menu.n;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.aio.halfpop.menu.v;
import com.tencent.guild.aio.halfpop.menu.z;
import com.tencent.guild.aio.input.GuildPermissionsChange;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.halfpop.menu.GuildLiveSetAnnounceActionItem;
import com.tencent.guildlive.aio.msglist.GuildLivePushMsgItemViewHolderFactoryProvider;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import fo0.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J8\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u001e\b\u0002\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00190\u00180\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0016\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020 0\u00180\u0017H\u0002J&\u0010%\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u0017J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0002H\u0016\u00a8\u0006,"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/a;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", "viewType", "", "v", "Landroid/view/View;", "view", "", "r", "Lcom/tencent/aio/data/msglist/a;", "p", "Landroidx/fragment/app/FragmentActivity;", DomainData.DOMAIN_NAME, "msg", "w", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "u", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/halfpop/menu/n;", "", "menuList", HippyTKDListViewAdapter.X, "msgItem", "t", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/guild/aio/halfpop/menu/t;", "o", "position", "", "payloads", "j", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "d", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<Class<? extends t>> f112802e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<Class<GuildLiveSetAnnounceActionItem>> f112803f;

    static {
        List<Class<? extends t>> listOf;
        List<Class<GuildLiveSetAnnounceActionItem>> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{d.class, com.tencent.guildlive.aio.halfpop.menu.a.class, v.class, GuildLiveSetAnnounceActionItem.class, z.class});
        f112802e = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(GuildLiveSetAnnounceActionItem.class);
        f112803f = listOf2;
    }

    private final long m(GuildMsgItem data) {
        GrayTipElement grayTipElement;
        EssenceElement essenceElement;
        MsgElement firstTypeElement = data.getFirstTypeElement(8);
        if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null && (essenceElement = grayTipElement.essenceElement) != null) {
            return essenceElement.msgSeq;
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentActivity n() {
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 != null) {
            return c16.getActivity();
        }
        return null;
    }

    private final List<Class<? extends t>> o() {
        if (s()) {
            return f112803f;
        }
        return f112802e;
    }

    private final com.tencent.aio.data.msglist.a p() {
        MsgListItemState msgListItemState = (MsgListItemState) getDefaultState().getValue();
        if (msgListItemState != null) {
            return msgListItemState.getData();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(View view) {
        FragmentActivity n3;
        com.tencent.aio.data.msglist.a p16 = p();
        if (p16 == null) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildLiveMsgItemVM", false));
        if (!v(p16.getViewType())) {
            GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgItemVM", "unSupportViewType type=" + p16.getViewType());
            return;
        }
        if (p16 instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) p16;
            String str = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.guildId");
            String str2 = guildMsgItem.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str2, "data.msgRecord.channelId");
            int a16 = h.a(str, str2);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildPermissionsChange(a16));
            if (GuildSpeakLimitStatus.INSTANCE.F(a16)) {
                GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgItemVM", "inGuestNotInteractive");
                return;
            }
            String str3 = guildMsgItem.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str3, "data.msgRecord.channelId");
            boolean i3 = GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(str3, com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
            if (!((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).guildLiveVideoIsLandScreenState() && !i3 && (n3 = n()) != null) {
                n3.getSupportFragmentManager();
                GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgItemVM", "popMsgLongPressMenu for LiveChannel");
                w(p16, view);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean s() {
        return Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), com.tencent.guildlive.aio.factory.b.class.getName());
    }

    private final boolean t(com.tencent.aio.data.msglist.a msgItem) {
        if (msgItem.getViewType() == 51) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean u(GuildMsgItem data) {
        ArrayList<IGProTopMsg> topMsgList;
        Object lastOrNull;
        if (data == null) {
            return false;
        }
        long m3 = m(data);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        IGProChannelInfo c16 = com.tencent.guild.aio.util.a.c(g16);
        if (c16 == null || (topMsgList = c16.getTopMsgList()) == null) {
            return false;
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) topMsgList);
        IGProTopMsg iGProTopMsg = (IGProTopMsg) lastOrNull;
        if (iGProTopMsg == null) {
            return false;
        }
        long topMsgSeq = iGProTopMsg.getTopMsgSeq();
        if (topMsgSeq <= 0 || m3 != topMsgSeq) {
            return false;
        }
        return true;
    }

    private final boolean v(int viewType) {
        return GuildLivePushMsgItemViewHolderFactoryProvider.f112780a.d().contains(Integer.valueOf(viewType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(com.tencent.aio.data.msglist.a msg2, View view) {
        GuildMsgItem guildMsgItem;
        if (s() && !yr0.a.e((com.tencent.aio.api.runtime.a) getMContext())) {
            QLog.i("GuildLiveMsgItemVM", 1, "isAnnounceMsg, have not announce set permissions.");
            return;
        }
        if (t(msg2)) {
            if (msg2 instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) msg2;
            } else {
                guildMsgItem = null;
            }
            if (u(guildMsgItem) && yr0.a.e((com.tencent.aio.api.runtime.a) getMContext())) {
                x(msg2, view, f112803f);
                return;
            }
            return;
        }
        y(this, msg2, view, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(com.tencent.aio.data.msglist.a msg2, View view, List<? extends Class<? extends n<? extends Object>>> menuList) {
        new ps0.a().a((com.tencent.aio.api.runtime.a) getMContext(), co0.b.b(co0.b.f31162a, menuList, msg2, (com.tencent.aio.api.runtime.a) getMContext(), false, 8, null), view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void y(a aVar, com.tencent.aio.data.msglist.a aVar2, View view, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = aVar.o();
        }
        aVar.x(aVar2, view, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.list.b
    @CallSuper
    public void j(@NotNull com.tencent.aio.data.msglist.a data, int position, @NotNull List<Object> payloads) {
        List mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildMultiMsgManager.MultiSelectMode multiSelectMode = new GuildMultiMsgManager.MultiSelectMode(UIUtil.f112434a.y((com.tencent.aio.api.runtime.a) getMContext()));
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) new ArrayList(payloads));
        mutableList.add(multiSelectMode);
        updateUI(new MsgListItemState(data, position, mutableList));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.factory.business.holder.msglist.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.d) {
            r(((a.d) intent).getView());
        }
    }
}
