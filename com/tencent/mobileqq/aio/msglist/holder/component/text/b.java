package com.tencent.mobileqq.aio.msglist.holder.component.text;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.utils.av;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007*\u0001\u0011\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/text/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mobileqq/aio/msglist/holder/d$az;", "B", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "o", "com/tencent/mobileqq/aio/msglist/holder/component/text/b$a", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/text/b$a;", "mAction", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class b extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/text/b$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                b.this.E(i3);
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

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(d.az intent) {
        Object obj;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(Long.valueOf(intent.a().getMsgId())));
        if (k3 instanceof a.C9495a) {
            obj = (a.C9495a) k3;
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        if (!Intrinsics.areEqual(Boolean.valueOf(intent.b()), obj)) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new StreamMsgEvent.UpdateAnimStatus(intent.a().getMsgId(), intent.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof StreamMsgEvent.EndStreamAnim) {
            updateUI(new AIOMsgItemUIState.EndStreamAnimUIState(((StreamMsgEvent.EndStreamAnim) intent).a()));
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.stream.StreamMsgEvent.EndStreamAnim");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
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
        if (intent instanceof d.ao) {
            d.ao aoVar = (d.ao) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(2, new AIOMsgListEvent.SelectEvent(aoVar.a(), aoVar.b(), aoVar.c()), null, 4, null));
            return;
        }
        boolean z16 = true;
        a.C9495a c9495a = null;
        if (intent instanceof d.p) {
            k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(null));
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
        if (intent instanceof d.w) {
            av.g(av.f194117a, (com.tencent.aio.api.runtime.a) getMContext(), ((d.w) intent).a(), false, null, 0L, 28, null);
            return;
        }
        if (intent instanceof d.y) {
            av.g(av.f194117a, (com.tencent.aio.api.runtime.a) getMContext(), ((d.y) intent).a(), true, null, 0L, 24, null);
            return;
        }
        if (intent instanceof p.o) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.SelectAll.f188375d);
            return;
        }
        if (intent instanceof p.a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputAtMsgIntent.InsertAtAllMemberSpan(false, 1, null));
        } else if (intent instanceof d.az) {
            B((d.az) intent);
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        }
    }
}
