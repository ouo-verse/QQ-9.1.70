package com.tencent.mobileqq.aio.msglist.holder.component.mix;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponentVM;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.utils.av;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/mix/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponentVM;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picMsgElement", "Landroid/view/View;", "imageView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends BaseMixContentComponentVM {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(AIOMsgItem msgItem, MsgElement picMsgElement, View imageView) {
        z.a aVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetAIORichMediaMsgListEvent(msgItem.getMsgRecord()));
        List<AIOMsgItem> list = null;
        if (k3 instanceof z.a) {
            aVar = (z.a) k3;
        } else {
            aVar = null;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        if (aVar != null) {
            list = aVar.a();
        }
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, peekAppRuntime, requireContext, imageView, msgItem, picMsgElement, false, null, list, false, 256, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ac) {
            d.ac acVar = (d.ac) intent;
            C(acVar.b(), acVar.c(), acVar.a());
            return;
        }
        if (intent instanceof d.ao) {
            d.ao aoVar = (d.ao) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(2, new AIOMsgListEvent.SelectEvent(aoVar.a(), aoVar.b(), aoVar.c()), null, 4, null));
            return;
        }
        if (intent instanceof d.p) {
            a.C9495a c9495a = null;
            k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(null));
            if (k3 instanceof a.C9495a) {
                c9495a = (a.C9495a) k3;
            }
            d.p pVar = (d.p) intent;
            boolean z16 = false;
            if (c9495a != null && c9495a.a()) {
                z16 = true;
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
        } else if (intent instanceof p.o) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.SelectAll.f188375d);
        } else {
            super.handleIntent(intent);
        }
    }
}
