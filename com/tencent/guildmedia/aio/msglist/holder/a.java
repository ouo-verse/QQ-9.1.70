package com.tencent.guildmedia.aio.msglist.holder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.halfpop.menu.d;
import com.tencent.guild.aio.halfpop.menu.n;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.aio.halfpop.menu.z;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildmedia.aio.halfpop.menu.GuildMediaSetAnnounceActionItem;
import com.tencent.guildmedia.aio.msglist.GuildMediaItemViewHolderFactoryProvider;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fH\u0002J2\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a0\u0019H\u0002J\u001e\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001b0\u001a0\u0019H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J&\u0010&\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0$H\u0017J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0002H\u0016\u00a8\u0006-"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/holder/a;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", "viewType", "", "w", "Landroid/view/View;", "view", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "p", "Lcom/tencent/aio/data/msglist/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/fragment/app/FragmentActivity;", DomainData.DOMAIN_NAME, "msg", HippyTKDListViewAdapter.X, "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/halfpop/menu/n;", "menus", "y", "", "o", "msgItem", "u", "t", "position", "", "payloads", "j", "intent", "r", "<init>", "()V", "d", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<Class<? extends t>> f113077e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<Class<GuildMediaSetAnnounceActionItem>> f113078f;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final List<Class<? extends t>> f113079h;

    static {
        List<Class<? extends t>> listOf;
        List<Class<GuildMediaSetAnnounceActionItem>> listOf2;
        List<Class<? extends t>> listOf3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{d.class, com.tencent.guildmedia.aio.halfpop.menu.a.class, GuildMediaSetAnnounceActionItem.class, z.class});
        f113077e = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(GuildMediaSetAnnounceActionItem.class);
        f113078f = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{d.class, z.class});
        f113079h = listOf3;
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

    private final List<Class<? extends n<? extends Object>>> o() {
        if (t()) {
            return f113078f;
        }
        if (!((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).curChannelHasInputPermission()) {
            GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgItemVM", "curChannelHasInputPermission is false.");
            return f113079h;
        }
        return f113077e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String p(GuildMsgItem data) {
        if (StringUtil.isEmpty(data.getMsgRecord().guildId)) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            return com.tencent.guild.aio.util.a.g(g16);
        }
        String str = data.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.guildId");
        return str;
    }

    private final com.tencent.aio.data.msglist.a q() {
        MsgListItemState msgListItemState = (MsgListItemState) getDefaultState().getValue();
        if (msgListItemState != null) {
            return msgListItemState.getData();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(View view) {
        FragmentActivity n3;
        AppInterface appInterface;
        boolean z16;
        com.tencent.aio.data.msglist.a q16 = q();
        if (q16 == null) {
            return;
        }
        if (!w(q16.getViewType())) {
            GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgItemVM", "unSupportViewType type=" + q16.getViewType());
            return;
        }
        if (q16 instanceof GuildMsgItem) {
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
                z16 = iGPSService.isGuest(p((GuildMsgItem) q16));
            } else {
                z16 = false;
            }
            if (z16) {
                GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgItemVM", "inGuestNotInteractive");
                return;
            }
        }
        String str = ((GuildMsgItem) q16).getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "data as GuildMsgItem).msgRecord.channelId");
        if (!GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(str, com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))) && (n3 = n()) != null) {
            n3.getSupportFragmentManager();
            GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgItemVM", "popMsgLongPressMenu for LiveChannel");
            x(q16, view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean t() {
        return Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), com.tencent.guildmedia.aio.factory.b.class.getName());
    }

    private final boolean u(com.tencent.aio.data.msglist.a msgItem) {
        if (msgItem.getViewType() == 51) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean v(GuildMsgItem data) {
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

    private final boolean w(int viewType) {
        return GuildMediaItemViewHolderFactoryProvider.f113065a.d().contains(Integer.valueOf(viewType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(com.tencent.aio.data.msglist.a msg2, View view) {
        GuildMsgItem guildMsgItem;
        if (t() && !vs0.a.f((com.tencent.aio.api.runtime.a) getMContext())) {
            QLog.i("GuildMediaMsgItemVM", 1, "isAnnounceMsg, have not announce set permissions.");
            return;
        }
        if (u(msg2)) {
            if (msg2 instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) msg2;
            } else {
                guildMsgItem = null;
            }
            if (v(guildMsgItem) && vs0.a.f((com.tencent.aio.api.runtime.a) getMContext())) {
                y(msg2, view, f113078f);
                return;
            }
            return;
        }
        y(msg2, view, o());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(com.tencent.aio.data.msglist.a msg2, View view, List<? extends Class<? extends n<?>>> menus) {
        new ct0.a().a((com.tencent.aio.api.runtime.a) getMContext(), co0.b.b(co0.b.f31162a, menus, msg2, (com.tencent.aio.api.runtime.a) getMContext(), false, 8, null), view);
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
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.factory.business.holder.msglist.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.d) {
            s(((a.d) intent).getView());
        }
    }
}
