package com.tencent.qqnt.aio.refresher;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi;
import com.tencent.qqnt.bus.api.IBusManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0014\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/ag;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "", "troopUin", "memberUin", "honorStr", "", "richFlag", "", ReportConstant.COSTREPORT_PREFIX, "uin", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "u", "t", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "c", tl.h.F, "com/tencent/qqnt/aio/refresher/ag$b", "Lcom/tencent/qqnt/aio/refresher/ag$b;", "mEventObser", "Lcom/tencent/qqnt/aio/mutualmark/api/IAIOMutualMaskApi;", "d", "Lcom/tencent/qqnt/aio/mutualmark/api/IAIOMutualMaskApi;", "mMutualApi", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/external/e;)V", "f", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ag extends com.tencent.mobileqq.aio.msglist.holder.external.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mEventObser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAIOMutualMaskApi mMutualApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/ag$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.ag$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/refresher/ag$b", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements zv3.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ag.this);
            }
        }

        @Override // zv3.c
        public void B5(@NotNull zv3.a event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof com.tencent.qqnt.bus.event.r) {
                com.tencent.qqnt.bus.event.r rVar = (com.tencent.qqnt.bus.event.r) event;
                ag.this.s(rVar.d(), rVar.b(), rVar.a(), rVar.c());
                return;
            }
            if (event instanceof com.tencent.qqnt.bus.event.o) {
                ag.this.v(((com.tencent.qqnt.bus.event.o) event).a());
                return;
            }
            if (event instanceof com.tencent.qqnt.bus.event.p) {
                ag.this.q();
                return;
            }
            if (event instanceof com.tencent.qqnt.bus.event.q) {
                ag.this.r(((com.tencent.qqnt.bus.event.q) event).a());
            } else if (event instanceof com.tencent.qqnt.bus.event.t) {
                ag.this.u(((com.tencent.qqnt.bus.event.t) event).a());
            } else if (event instanceof com.tencent.qqnt.bus.event.s) {
                ag.this.t();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        super(helper);
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
            return;
        }
        b bVar = new b();
        this.mEventObser = bVar;
        this.mMutualApi = (IAIOMutualMaskApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOMutualMaskApi.class);
        this.mAIOContext = helper.a();
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.o.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.r.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.p.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.q.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.t.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.s.class, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (b() != 2) {
            return;
        }
        QLog.i("MutualMaskRefresher", 1, "[notifyUpdate]: ");
        this.mAIOContext.e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
        this.mAIOContext.e().h(MsgItemExternalRefreshEvent.ForceRefreshMutualMask.f192379d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String uin) {
        if (b() == 2 && Intrinsics.areEqual(i(), uin)) {
            QLog.i("MutualMaskRefresher", 1, "[notifyGroup]: uin is " + uin);
            q();
            return;
        }
        QLog.i("MutualMaskRefresher", 1, "[notifyGroup]: error! " + uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String troopUin, String memberUin, String honorStr, byte richFlag) {
        String str;
        if (b() == 2 && Intrinsics.areEqual(i(), troopUin)) {
            if (QLog.isColorLevel()) {
                QLog.i("MutualMaskRefresher", 2, "[notifyGroupMutualMaskUpdate]: uin is " + memberUin + ", honorStr is " + honorStr + ", richFlag is " + ((int) richFlag));
            }
            e(new af(memberUin, new com.tencent.qqnt.aio.msg.e(honorStr, richFlag)));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (memberUin.equals(str)) {
                this.mAIOContext.e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        if (b() != 2) {
            return;
        }
        this.mAIOContext.e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String uin) {
        if (b() == 2 && Intrinsics.areEqual(i(), uin)) {
            QLog.i("MutualMaskRefresher", 1, "[notifyLuckyCharUpdate]: uin is " + uin);
            this.mAIOContext.e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String uin) {
        if (!Intrinsics.areEqual(i(), uin)) {
            if (QLog.isColorLevel()) {
                QLog.e("MutualMaskRefresher", 2, "[notifyMutualMaskUpdate] error! : uin is " + uin);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MutualMaskRefresher", 2, "[notifyMutualMaskUpdate]: uin is " + uin);
        }
        this.mAIOContext.e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void c(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof ae)) {
            return;
        }
        ae aeVar = (ae) request;
        aeVar.e(this.mMutualApi.getDrawable(aeVar.d(), aeVar.b(), aeVar.a(), aeVar.c()));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.h();
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.o.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.r.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.p.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.q.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.t.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.s.class, this.mEventObser);
    }
}
