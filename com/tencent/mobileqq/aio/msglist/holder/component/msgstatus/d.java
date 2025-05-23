package com.tencent.mobileqq.aio.msglist.holder.component.msgstatus;

import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.a;
import com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgstatus/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgstatus/c$c;", "intent", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgstatus/c$a;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "<init>", "()V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgstatus/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62072);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
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
    private final void l(c.a intent) {
        QLog.d("AIOMsgStatusVM", 1, "cancelSendingMsg, msgId=" + intent.a().getMsgId());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.CancelSendingMsg(intent.a().getMsgId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(c.C7312c intent) {
        a.C7242a c7242a;
        boolean z16 = true;
        QLog.d("AIOMsgStatusVM", 1, "resendMsg");
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgSendEvent.GetInterceptResendEvent(intent.a()));
        if (k3 instanceof a.C7242a) {
            c7242a = (a.C7242a) k3;
        } else {
            c7242a = null;
        }
        if (c7242a == null || !c7242a.a()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).reSendMsg((com.tencent.aio.api.runtime.a) getMContext(), intent.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof c.C7312c) {
            n((c.C7312c) intent);
        } else if (intent instanceof c.a) {
            l((c.a) intent);
        } else if (intent instanceof c.b) {
            ((c.b) intent).b(com.tencent.mobileqq.aio.a.a((com.tencent.aio.api.runtime.a) getMContext()));
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(reuse));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            super.onCreate(context, reuse);
        }
    }
}
