package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/u;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "B", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "o", "com/tencent/mobileqq/aio/msglist/holder/component/ptt/u$a", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/u$a;", "action", "", "Lkotlin/Pair;", "", tl.h.F, "Ljava/util/List;", "messageList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class u extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, a>> messageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ptt/u$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                u.this.B(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    public u() {
        List<Pair<String, a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        a aVar = new a();
        this.action = aVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.MsgOnRevokeEvent.class)), aVar));
        this.messageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(MsgIntent intent) {
        if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            updateUI(new AIOMsgItemUIState.StopPlayingAudio(((AIOMsgSendEvent.MsgOnRevokeEvent) intent).a()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ad) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOReserve1CreateModelIntent("audio_button", new AIOMsgListEvent.PlayAudio(((d.ad) intent).a())));
            return;
        }
        if (intent instanceof d.ae) {
            d.ae aeVar = (d.ae) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.PttPlayNext(aeVar.a(), aeVar.b()));
            return;
        }
        boolean z16 = true;
        if (intent instanceof d.af) {
            d.af afVar = (d.af) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.PttToastHeadset(afVar.a()));
            if (afVar.a() != null) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTitleEvent.UpdateEarIconEvent(!r9.booleanValue()));
                return;
            }
            return;
        }
        if (intent instanceof d.ao) {
            d.ao aoVar = (d.ao) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(2, new AIOMsgListEvent.SelectEvent(aoVar.a(), aoVar.b(), aoVar.c()), null, 4, null));
            return;
        }
        z.h hVar = null;
        a.C9495a c9495a = null;
        if (intent instanceof d.p) {
            com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(null));
            if (k3 instanceof a.C9495a) {
                c9495a = (a.C9495a) k3;
            }
            d.p pVar = (d.p) intent;
            if (c9495a == null || !c9495a.a()) {
                z16 = false;
            }
            pVar.b(z16);
            return;
        }
        if (intent instanceof d.g) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.DismissSelectMenu(((d.g) intent).a()));
            return;
        }
        if (intent instanceof d.ag) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.ReappearSelectMenu.f188367d);
            return;
        }
        if (intent instanceof p.o) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.SelectAll.f188375d);
            return;
        }
        if (intent instanceof d.ar) {
            d.ar arVar = (d.ar) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.PttSetExpandStatus(arVar.a(), arVar.b()));
            return;
        }
        if (intent instanceof d.i) {
            d.i iVar = (d.i) intent;
            com.tencent.mvi.base.route.k k16 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.PttGetExpandStatus(iVar.a()));
            if (k16 instanceof z.h) {
                hVar = (z.h) k16;
            }
            if (hVar == null || !hVar.a()) {
                z16 = false;
            }
            iVar.c(Boolean.valueOf(z16));
            return;
        }
        if (intent instanceof d.v) {
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e16 != null) {
                e16.h(AIOMsgListEvent.MenuDismissEvent.f188333d);
                return;
            }
            return;
        }
        super.handleIntent(intent);
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            D();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        C();
    }
}
