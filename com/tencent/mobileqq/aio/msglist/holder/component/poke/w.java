package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.reserve2.Reserve2Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/w;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "onCreate", "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class w extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ao) {
            d.ao aoVar = (d.ao) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(2, new AIOMsgListEvent.SelectEvent(aoVar.a(), aoVar.b(), aoVar.c()), null, 4, null));
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
        if (intent instanceof d.aq) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.SendPokeMsg(((d.aq) intent).a()));
            return;
        }
        if (intent instanceof d.C7328d) {
            d.C7328d c7328d = (d.C7328d) intent;
            AIOMsgListEvent.AddSixView addSixView = new AIOMsgListEvent.AddSixView(c7328d.a());
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(addSixView);
            c7328d.b(addSixView.a());
            return;
        }
        if (intent instanceof d.au) {
            d.au auVar = (d.au) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.StartGreatMoveView(auVar.b(), auVar.d(), auVar.c(), auVar.a()));
            return;
        }
        if (intent instanceof d.ay) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.StartZanView.f188405d);
            return;
        }
        if (intent instanceof d.aw) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.StartHeartView(((d.aw) intent).a()));
            return;
        }
        if (intent instanceof d.av) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.StartHeartBreakView.f188400d);
            return;
        }
        if (intent instanceof d.ax) {
            d.ax axVar = (d.ax) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.StartVasView(axVar.a(), axVar.b()));
        } else {
            if (intent instanceof d.j) {
                AIOMsgEvent.GetFirstUnreadSeqEvent getFirstUnreadSeqEvent = new AIOMsgEvent.GetFirstUnreadSeqEvent(0L, 1, null);
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getFirstUnreadSeqEvent);
                ((d.j) intent).b(getFirstUnreadSeqEvent.a());
                return;
            }
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
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(Reserve2Event.InitPokeAnimationView.f352038d);
    }
}
