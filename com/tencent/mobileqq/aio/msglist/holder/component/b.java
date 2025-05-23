package com.tencent.mobileqq.aio.msglist.holder.component;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.GroupDetailInfoEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent;
import com.tencent.mobileqq.aio.input.blockstate.f;
import com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent;
import com.tencent.mobileqq.aio.input.joinstate.c;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.egg.c;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.mobileqq.vas.menu.IJumpDressUp;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi;
import com.tencent.qqnt.aio.adapter.api.IAIOMenuApi;
import com.tencent.qqnt.aio.adapter.api.IMsgForwardApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.holder.MsgItemEvent;
import com.tencent.qqnt.aio.menu.MenuMsgEvent;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import com.tencent.qqnt.emotion.relatedemo.RelatedEmotionMsgIntent;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msglist/holder/d$k;", "intent", "", "p", "Lcom/tencent/mobileqq/aio/msglist/holder/d$e;", "contextWrapper", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/qqnt/aio/menu/p$r;", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "y", "u", "Lcom/tencent/qqnt/aio/menu/p$g;", "t", "v", "o", "<init>", "()V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class b extends com.tencent.qqnt.aio.baseVM.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59892);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean m() {
        e.g gVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(RobotMsgIntent.GetSupportWideScreen.f188691d);
        if (k3 instanceof e.g) {
            gVar = (e.g) k3;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            return gVar.a();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(d.e contextWrapper) {
        contextWrapper.b((com.tencent.aio.api.runtime.a) getMContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(d.k intent) {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.GetIsTempChat.f188305d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.MsgListResult.GetIsTempChatResult");
        intent.a(((z.f) k3).a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(AIOMsgItem msgItem) {
        int e16;
        if (!r() && (e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()) != 104 && e16 != 113 && e16 != 119) {
            updateUI(AIOMsgItemUIState.LongClickState.f190560d);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgItemEvent.MsgItemLongClickEvent(msgItem));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r() {
        c.a aVar;
        boolean z16;
        boolean z17;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GroupJoinStateIntent.GetJoinState.f189732d);
        f.a aVar2 = null;
        if (k3 instanceof c.a) {
            aVar = (c.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null && !aVar.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        k k16 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GroupBlockStateIntent.GetTroopBlockState.f189333d);
        if (k16 instanceof f.a) {
            aVar2 = (f.a) k16;
        }
        if (aVar2 != null && aVar2.b()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("AIOMsgItemBaseVM", 4, "[isNeedSkipLongClick] isExit:" + z16 + ", isBlock:" + z17);
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(p.r intent) {
        boolean z16;
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        boolean isSupportRevoke = ((IAIOMenuApi) companion.a(IAIOMenuApi.class)).isSupportRevoke((com.tencent.aio.api.runtime.a) getMContext(), intent.a(), u(), intent.b());
        if (com.tencent.mobileqq.aio.utils.d.s(intent.a())) {
            if (isSupportRevoke && ((IAIOAnonymousApi) companion.a(IAIOAnonymousApi.class)).isSupportRevokeAnonymousMsg()) {
                z16 = true;
            } else {
                z16 = false;
            }
            isSupportRevoke = z16;
        }
        intent.c(isSupportRevoke);
    }

    private final void t(p.g intent) {
        intent.b(u());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean u() {
        GroupDetailInfoEvent.IsOwnerOrAdmin isOwnerOrAdmin = new GroupDetailInfoEvent.IsOwnerOrAdmin(false, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(isOwnerOrAdmin);
        return isOwnerOrAdmin.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(AIOMsgItem msgItem) {
        if (msgItem.getMsgRecord().msgType == 17) {
            QRouteApi api = QRoute.api(IMarketFaceTailConfigExt.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMarketFaceTailConfigExt::class.java)");
            IMarketFaceTailConfigExt.a.a((IMarketFaceTailConfigExt) api, QCircleDaTongConstant.ElementParamValue.LONG_PRESS, "add", "4", 102, null, 16, null);
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(msgItem.getMsgId()));
        Contact h16 = AIOUtil.f194084a.h(((com.tencent.aio.api.runtime.a) getMContext()).g().r());
        ArrayList<Contact> arrayList2 = new ArrayList<>();
        arrayList2.add(h16);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.forwardMsg(arrayList, h16, arrayList2, null, new IForwardOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    b.w(i3, str, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int i3, String str, HashMap hashMap) {
        if (i3 != 0) {
            QLog.e("AIOMsgItemBaseVM", 1, "[sendFollowMsg] result=" + i3 + " errMsg=" + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(AIOMsgItem msgItem) {
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        e16.h(new MultiSelectEvent.SetSelectMode(true));
        e16.h(new MultiSelectEvent.AddSelectMsg(msgItem, false, 2, null));
        e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("AIOBubbleMsgItemVM", true));
        e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOBubbleMsgItemVM", false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(AIOMsgItem msgItem) {
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        e16.h(new CreateHelperIntent.CreateHelperRealIntent(3, new LongShotMsgIntent.SetShotMode(true), null, 4, null));
        e16.h(new LongShotMsgIntent.OnlyAddSingleMsg(msgItem));
        e16.h(new AIOMsgListEvent.LongShotModeChangeEvent("AIOBubbleMsgItemVM", true));
        e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOBubbleMsgItemVM", false));
    }

    private final void z(AIOMsgItem msgItem) {
        TemplateMsgItem templateMsgItem;
        QLog.i("AIOMsgItemBaseVM", 1, "[showMsgInfo] msgItem=" + msgItem);
        String str = "msg id:" + msgItem.getMsgId() + " msgSeq:" + msgItem.getMsgRecord().msgSeq + " msg type:" + msgItem.getMsgRecord().msgType + " view type:" + msgItem.getViewType();
        if (msgItem instanceof ArkMsgItem) {
            ArkMsgItem arkMsgItem = (ArkMsgItem) msgItem;
            str = ((Object) str) + ", ark app version = " + arkMsgItem.i2() + ", ark data = " + arkMsgItem.k2();
        }
        if (msgItem instanceof TemplateMsgItem) {
            templateMsgItem = (TemplateMsgItem) msgItem;
        } else {
            templateMsgItem = null;
        }
        if (templateMsgItem != null) {
            str = ((Object) str) + templateMsgItem.j2();
        }
        ClipboardManager clipboardManager = (ClipboardManager) MobileQQ.sMobileQQ.getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText("AIOMsgItemBaseVM", str);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
        }
        Toast.makeText(BaseApplication.getContext(), str, 1).show();
        Toast.makeText(BaseApplication.getContext(), "\u5df2\u62f7\u8d1d\u5230\u7c98\u8d34\u9762\u677f", 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.x) {
            q(((d.x) intent).a());
            return;
        }
        if (intent instanceof d.at) {
            d.at atVar = (d.at) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(1, new AIOMsgListEvent.NormalMenuShowEvent(atVar.b(), atVar.a()), null, 4, null));
            return;
        }
        if (intent instanceof p.j) {
            x(((p.j) intent).a());
            return;
        }
        if (intent instanceof p.m) {
            p.m mVar = (p.m) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.MsgOnClickReplyEvent(mVar.b(), mVar.a(), false, 4, null));
            return;
        }
        if (intent instanceof p.l) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new RelatedEmotionMsgIntent.ShowRelatedEmoPanel(((p.l) intent).a()));
            return;
        }
        if (intent instanceof p.i) {
            y(((p.i) intent).a());
            return;
        }
        if (intent instanceof p.c) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.SingleForwardSelectEvent(((p.c) intent).a()));
            return;
        }
        if (intent instanceof p.d) {
            IMsgForwardApi iMsgForwardApi = (IMsgForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMsgForwardApi.class);
            Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
            p.d dVar = (p.d) intent;
            iMsgForwardApi.forwardText(requireContext, ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c(), dVar.b(), dVar.a());
            return;
        }
        if (intent instanceof p.C9487p) {
            v(((p.C9487p) intent).a());
            return;
        }
        if (intent instanceof p.q) {
            z(((p.q) intent).a());
            return;
        }
        if (intent instanceof p.r) {
            s((p.r) intent);
            return;
        }
        if (intent instanceof p.g) {
            t((p.g) intent);
            return;
        }
        if (intent instanceof d.ah) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgItemExternalRefreshEvent.RefreshEvent(((d.ah) intent).a()));
            return;
        }
        if (intent instanceof p.f) {
            ((p.f) intent).b(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g());
            return;
        }
        if (intent instanceof p.n) {
            p.n nVar = (p.n) intent;
            MenuMsgEvent.RevokeCheck revokeCheck = new MenuMsgEvent.RevokeCheck(nVar.a(), false, i3, null);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(revokeCheck);
            nVar.c(revokeCheck.b());
            return;
        }
        if (intent instanceof p.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MenuMsgEvent.DelCheckEvent(((p.b) intent).a()));
            return;
        }
        if (intent instanceof p.e) {
            ((p.e) intent).b(((com.tencent.aio.api.runtime.a) getMContext()).g().l().getLong("key_peerUin", 0L));
            return;
        }
        if (intent instanceof d.f) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.CancleSelectEvent.f188283d);
            return;
        }
        if (intent instanceof d.n) {
            ((d.n) intent).b(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof d.a) {
            d.a aVar = (d.a) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new BusiAnimationEvent.AddFullScreenView(aVar.a(), aVar.b()));
            return;
        }
        if (intent instanceof d.aj) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new BusiAnimationEvent.RemoveFullScreenView(((d.aj) intent).a()));
            return;
        }
        if (intent instanceof d.s) {
            ((d.s) intent).b(AIOUtil.f194084a.r((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof d.h) {
            n(((d.h) intent).a());
            return;
        }
        if (intent instanceof d.k) {
            p((d.k) intent);
            return;
        }
        if (intent instanceof c.a) {
            c.a aVar2 = (c.a) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new BusiAnimationEvent.AddFullScreenView(aVar2.a(), aVar2.b()));
            return;
        }
        if (intent instanceof c.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new BusiAnimationEvent.RemoveFullScreenView(((c.b) intent).a()));
            return;
        }
        if (intent instanceof p.h) {
            p.h hVar = (p.h) intent;
            long j3 = hVar.a().getMsgRecord().senderUin;
            MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
            IJumpDressUp iJumpDressUp = (IJumpDressUp) QRoute.api(IJumpDressUp.class);
            Context requireContext2 = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "mContext.fragment.requireContext()");
            iJumpDressUp.jumpToDressUp(requireContext2, hVar.a());
            return;
        }
        if (intent instanceof d.l) {
            ((d.l) intent).b(m());
        }
    }
}
