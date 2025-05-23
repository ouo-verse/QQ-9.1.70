package com.tencent.guild.aio.msglist.holder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import fo0.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\n\b\u0016\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J&\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0017J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0006\u0010'\u001a\u00020\u000b\u00a8\u0006,"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/b;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", "p", "Landroid/view/View;", "view", "r", "", "viewType", "", HippyTKDListViewAdapter.X, "t", "u", "", "channelId", "v", "type", "y", "clickedView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/FragmentManager;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "msgSeq", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/data/msglist/a;", "data", "position", "", "", "payloads", "j", "intent", "o", "w", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class b extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {
    private final GuildMsgItem m() {
        com.tencent.aio.data.msglist.a aVar;
        MsgListItemState msgListItemState = (MsgListItemState) getDefaultState().getValue();
        if (msgListItemState != null) {
            aVar = msgListItemState.getData();
        } else {
            aVar = null;
        }
        if (!(aVar instanceof GuildMsgItem)) {
            return null;
        }
        return (GuildMsgItem) aVar;
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
    private final void p() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildBubbleMsgItemVM", false, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(View clickedView) {
        GuildMsgItem m3 = m();
        if (m3 == null) {
            QLog.e("GuildBubbleMsgItemVM", 1, "handleMsgItemContentClick, msgItem == null");
            return;
        }
        String str = m3.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        if (v(str)) {
            QLog.i("GuildBubbleMsgItemVM", 4, "inMultiSelectMode");
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgItemContentViewClickEvent(m3, clickedView));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(View view) {
        z(view);
        GuildMsgItem m3 = m();
        if (m3 == null) {
            return;
        }
        if (u()) {
            QLog.i("GuildBubbleMsgItemVM", 4, "inGlobalNoticeAio");
            return;
        }
        String str = m3.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.guildId");
        String str2 = m3.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "data.msgRecord.channelId");
        int a16 = h.a(str, str2);
        if (!t() && GuildSpeakLimitStatus.INSTANCE.F(a16)) {
            QLog.i("GuildBubbleMsgItemVM", 4, "inDirectMsgAio, and isGuestMode");
            return;
        }
        String str3 = m3.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str3, "data.msgRecord.channelId");
        if (v(str3)) {
            QLog.i("GuildBubbleMsgItemVM", 4, "inMultiSelectMode");
            return;
        }
        if (!y(m3.getViewType()) && !m3.isReviewingMsg()) {
            if (x(m3.getViewType())) {
                QLog.i("GuildBubbleMsgItemVM", 4, "gift msg type");
                return;
            }
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildBubbleMsgItemVM", false));
            FragmentManager n3 = n();
            if (n3 != null) {
                view.setSelected(true);
                QLog.i("GuildBubbleMsgItemVM", 4, "popMsgLongPressMenu for normal channel");
                if (w()) {
                    co0.a.f31161a.d(n3, m3, (com.tencent.aio.api.runtime.a) getMContext(), view);
                    return;
                } else {
                    co0.a.f31161a.f(n3, m3, (com.tencent.aio.api.runtime.a) getMContext(), view);
                    return;
                }
            }
            return;
        }
        QLog.i("GuildBubbleMsgItemVM", 4, "unSupport msg type");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(long msgSeq) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildBubbleMsgItemVM", msgSeq));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean t() {
        return com.tencent.guild.aio.util.ex.a.h((com.tencent.aio.api.runtime.a) getMContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean u() {
        return Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), ((IGuildDirectMsgChannelApi) QRoute.api(IGuildDirectMsgChannelApi.class)).getGlobalNoticeAioFactoryName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean v(String channelId) {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(channelId, com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    private final boolean x(int viewType) {
        if (viewType != 30 && viewType != 31) {
            return false;
        }
        return true;
    }

    private final boolean y(int type) {
        if (type == 71) {
            return true;
        }
        return false;
    }

    private final void z(View v3) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.b(hashMap);
        VideoReport.setElementId(v3, "em_msg_more");
        VideoReport.setElementParams(v3, hashMap);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
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
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.factory.business.holder.msglist.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            p();
            return;
        }
        if (intent instanceof a.d) {
            r(((a.d) intent).getView());
        } else if (intent instanceof a.c) {
            q(((a.c) intent).getBubbleView());
        } else if (intent instanceof a.s) {
            s(((a.s) intent).getMsgSeq());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean w() {
        return Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), qn0.a.class.getName());
    }
}
