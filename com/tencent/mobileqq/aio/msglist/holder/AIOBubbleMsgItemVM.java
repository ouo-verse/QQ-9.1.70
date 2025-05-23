package com.tencent.mobileqq.aio.msglist.holder;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.api.list.m;
import com.tencent.aio.data.AIOParam;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.LocationShareMsgItem;
import com.tencent.mobileqq.aio.msg.OnlineFileMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.aj;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J&\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/AIOBubbleMsgItemVM;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/aio/api/list/m;", "Landroid/os/Bundle;", "o", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/msglist/holder/d$l;", "intent", "", "r", "Lcom/tencent/mobileqq/aio/msglist/holder/d$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "B", HippyTKDListViewAdapter.X, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "p", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "y", "Lcom/tencent/aio/data/msglist/a;", "data", "", "position", "", "", "payloads", "j", ReportConstant.COSTREPORT_PREFIX, "g", "k", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mCurrentItem", "<init>", "()V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOBubbleMsgItemVM extends com.tencent.aio.api.list.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f190528f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem mCurrentItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/AIOBubbleMsgItemVM$a;", "", "", "needCatchException$delegate", "Lkotlin/Lazy;", "a", "()Z", "needCatchException", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.AIOBubbleMsgItemVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((Boolean) AIOBubbleMsgItemVM.f190528f.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59020);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOBubbleMsgItemVM$Companion$needCatchException$2.INSTANCE);
        f190528f = lazy;
    }

    public AIOBubbleMsgItemVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean A() {
        return this.mCurrentItem instanceof aj;
    }

    private final boolean B() {
        AIOMsgItem aIOMsgItem = this.mCurrentItem;
        if (!(aIOMsgItem instanceof ShortVideoMsgItem)) {
            return false;
        }
        Intrinsics.checkNotNull(aIOMsgItem, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ShortVideoMsgItem");
        if (((ShortVideoMsgItem) aIOMsgItem).P2()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean n() {
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        if (e16 != 105 && e16 != 104 && e16 != 103 && e16 != 118 && e16 != 201 && e16 != 100 && e16 != 101 && e16 != 8) {
            AIOUtil aIOUtil = AIOUtil.f194084a;
            if (!aIOUtil.r((com.tencent.aio.api.runtime.a) getMContext()) && !aIOUtil.y((com.tencent.aio.api.runtime.a) getMContext())) {
                com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
                if (!bVar.i((com.tencent.aio.api.runtime.a) getMContext()) && !bVar.j((com.tencent.aio.api.runtime.a) getMContext()) && !am.f194110a.j((com.tencent.aio.api.runtime.a) getMContext()) && !v() && !B() && !x() && !u() && !w() && !A() && !t() && !y()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Bundle o() {
        return ((com.tencent.aio.api.runtime.a) getMContext()).g().l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean p(AIOMsgItem msgItem) {
        Long l3;
        if (msgItem != null && !com.tencent.qqnt.aio.msg.d.M(msgItem)) {
            return false;
        }
        a.C9495a c9495a = null;
        if (msgItem != null) {
            l3 = Long.valueOf(msgItem.getMsgId());
        } else {
            l3 = null;
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(l3));
        if (k3 instanceof a.C9495a) {
            c9495a = (a.C9495a) k3;
        }
        if (c9495a == null) {
            return false;
        }
        return c9495a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(d.b intent) {
        MultiSelectEvent.AddSelectMsg addSelectMsg = new MultiSelectEvent.AddSelectMsg(intent.a(), false, 2, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(addSelectMsg);
        intent.c(addSelectMsg.getResult());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(d.l intent) {
        e.g gVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(RobotMsgIntent.GetSupportWideScreen.f188691d);
        if (k3 instanceof e.g) {
            gVar = (e.g) k3;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            intent.b(gVar.a());
        }
    }

    private final boolean t() {
        AIOMsgItem aIOMsgItem = this.mCurrentItem;
        if (aIOMsgItem != null) {
            return com.tencent.qqnt.aio.msg.d.i(aIOMsgItem);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (((com.tencent.mobileqq.aio.msg.ArkMsgItem) r0).s2() != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean u() {
        AIOMsgItem aIOMsgItem = this.mCurrentItem;
        if (aIOMsgItem instanceof ArkMsgItem) {
            Intrinsics.checkNotNull(aIOMsgItem, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ArkMsgItem");
        }
        if (z()) {
            return true;
        }
        return false;
    }

    private final boolean v() {
        AIOMsgItem aIOMsgItem = this.mCurrentItem;
        if (aIOMsgItem instanceof PicMsgItem) {
            Intrinsics.checkNotNull(aIOMsgItem, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.PicMsgItem");
            return com.tencent.mobileqq.aio.utils.d.y((PicMsgItem) aIOMsgItem);
        }
        return false;
    }

    private final boolean w() {
        return this.mCurrentItem instanceof LocationShareMsgItem;
    }

    private final boolean x() {
        return this.mCurrentItem instanceof OnlineFileMsgItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean y() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(su3.c.a(g16)), Integer.valueOf(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()));
    }

    private final boolean z() {
        TemplateMsgItem templateMsgItem;
        AIOMsgItem aIOMsgItem = this.mCurrentItem;
        if (aIOMsgItem instanceof TemplateMsgItem) {
            templateMsgItem = (TemplateMsgItem) aIOMsgItem;
        } else {
            templateMsgItem = null;
        }
        if (templateMsgItem != null) {
            return !com.tencent.mobileqq.aio.msglist.holder.component.template.common.a.f191908a.d(templateMsgItem);
        }
        return false;
    }

    @Override // com.tencent.aio.api.list.m
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            updateUI(AIOMsgItemUIState.ScrollIntoScreen.f190562d);
        }
    }

    @Override // com.tencent.aio.api.list.b
    public void j(@NotNull com.tencent.aio.data.msglist.a data, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, data, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.mCurrentItem = (AIOMsgItem) data;
        try {
            updateUI(new AIOMsgItemUIState.AIOMsgItemState(data, position, payloads, o()));
        } catch (Throwable th5) {
            AIOMsgItem aIOMsgItem = this.mCurrentItem;
            Companion companion = INSTANCE;
            QLog.e("AIOBubbleMsgItemVM", 1, "onBindViewHolder exception. msgItem " + aIOMsgItem + " /n " + companion.a() + " " + th5);
            if (com.tencent.qqnt.util.b.f362976b.isPublicVersion() && companion.a()) {
            } else {
                throw th5;
            }
        }
    }

    @Override // com.tencent.aio.api.list.m
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            updateUI(AIOMsgItemUIState.ScrollOutScreen.f190563d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ap) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
            return;
        }
        if (intent instanceof d.n) {
            ((d.n) intent).b(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof d.r) {
            d.r rVar = (d.r) intent;
            rVar.c(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.h((com.tencent.aio.api.runtime.a) getMContext(), rVar.a()));
            return;
        }
        if (intent instanceof d.b) {
            q((d.b) intent);
            return;
        }
        if (intent instanceof d.ak) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MultiSelectEvent.RemoveSelectMsg(((d.ak) intent).a()));
            return;
        }
        if (intent instanceof d.o) {
            ((d.o) intent).b(am.f194110a.j((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof d.t) {
            d.t tVar = (d.t) intent;
            tVar.c(am.f194110a.h((com.tencent.aio.api.runtime.a) getMContext(), tVar.a()));
            return;
        }
        if (intent instanceof d.c) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.AddClickedMsg(((d.c) intent).a()));
            return;
        }
        if (intent instanceof d.al) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.RemoveMsg(((d.al) intent).a()));
            return;
        }
        if (intent instanceof d.ai) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.RefreshLongShotView.f188368d);
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
        if (intent instanceof d.f) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.CancleSelectEvent.f188283d);
            return;
        }
        if (intent instanceof d.z) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.MsgLeftSwipe(((d.z) intent).a()));
            return;
        }
        if (intent instanceof d.u) {
            ((d.u) intent).b(n());
            return;
        }
        if (intent instanceof d.q) {
            d.q qVar = (d.q) intent;
            qVar.b(p(qVar.a()));
        } else if (intent instanceof d.l) {
            r((d.l) intent);
        }
    }
}
