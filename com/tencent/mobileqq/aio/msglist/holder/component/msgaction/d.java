package com.tencent.mobileqq.aio.msglist.holder.component.msgaction;

import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msglist.holder.component.msgaction.c;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/c$a;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "msgId", "", "l", "o", DomainData.DOMAIN_NAME, "<init>", "()V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean l(long msgId) {
        a.C9495a c9495a;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(Long.valueOf(msgId)));
        if (k3 instanceof a.C9495a) {
            c9495a = (a.C9495a) k3;
        } else {
            c9495a = null;
        }
        if (c9495a != null) {
            return c9495a.a();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(c.a intent) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORecommendMsgVM", 4, "[handleClickIntent]: " + intent.a().label);
        }
        AIORecommendMsgInject.f191165a.c((com.tencent.aio.api.runtime.a) getMContext(), intent.b(), intent.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean o() {
        if (com.tencent.mobileqq.aio.a.b((com.tencent.aio.api.runtime.a) getMContext()) || com.tencent.mobileqq.aio.a.a((com.tencent.aio.api.runtime.a) getMContext()) || ((IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class)).isLittleAssistant(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            m((c.a) intent);
            return;
        }
        if (intent instanceof c.C7310c) {
            c.C7310c c7310c = (c.C7310c) intent;
            c7310c.c(l(c7310c.a()));
            return;
        }
        if (intent instanceof c.e) {
            ((c.e) intent).b(o());
            return;
        }
        if (intent instanceof c.b) {
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e16 != null) {
                e16.h(AIOMsgListEvent.MenuDismissEvent.f188333d);
                return;
            }
            return;
        }
        if (intent instanceof c.d) {
            ((c.d) intent).a(AIOUtil.f194084a.c((com.tencent.aio.api.runtime.a) getMContext()));
        }
    }
}
