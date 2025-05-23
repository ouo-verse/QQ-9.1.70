package com.tencent.qqnt.aio.refresher;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.api.IAIONickBlockApi;
import com.tencent.qqnt.bus.api.IBusManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/s;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "Lcom/tencent/qqnt/bus/event/j;", "event", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/bus/event/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "c", tl.h.F, "com/tencent/qqnt/aio/refresher/s$b", "Lcom/tencent/qqnt/aio/refresher/s$b;", "mObserver", "Lcom/tencent/qqnt/aio/nick/api/IAIONickBlockApi;", "d", "Lcom/tencent/qqnt/aio/nick/api/IAIONickBlockApi;", "mNickBlockApi", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/external/e;)V", "e", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class s extends com.tencent.mobileqq.aio.msglist.holder.external.c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAIONickBlockApi mNickBlockApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/s$a;", "", "", "CLOSE", "I", "OPEN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.s$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/refresher/s$b", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements zv3.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
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
            if (event instanceof com.tencent.qqnt.bus.event.j) {
                s.this.n((com.tencent.qqnt.bus.event.j) event);
            } else if (event instanceof com.tencent.qqnt.bus.event.i) {
                s.this.m((com.tencent.qqnt.bus.event.i) event);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60496);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        super(helper);
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
            return;
        }
        b bVar = new b();
        this.mObserver = bVar;
        IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
        iBusManager.registerEvent(com.tencent.qqnt.bus.event.j.class, bVar);
        iBusManager.registerEvent(com.tencent.qqnt.bus.event.i.class, bVar);
        this.mNickBlockApi = (IAIONickBlockApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIONickBlockApi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(com.tencent.qqnt.bus.event.i event) {
        if (b() == 2 && Intrinsics.areEqual(i(), event.c())) {
            if (QLog.isColorLevel()) {
                QLog.d("GradeLevelRefresher", 2, "[notifyGradeLevelToggle]: event is " + event);
            }
            e(new t(event.a(), event.b() ? 1 : 0));
            return;
        }
        QLog.e("GradeLevelRefresher", 1, "[notifyGradeLevelUpdate]: troopUin not equal peerId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(com.tencent.qqnt.bus.event.j event) {
        if (b() == 2 && Intrinsics.areEqual(i(), event.e())) {
            QLog.i("GradeLevelRefresher", 1, "[notifyGradeLevelUpdate]: event is " + event);
            e(new u(event.d(), new com.tencent.qqnt.aio.nick.gradelevel.a(event.c(), event.a(), event.b())));
            return;
        }
        QLog.e("GradeLevelRefresher", 1, "[notifyGradeLevelUpdate]: troopUin not equal peerId");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void c(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof r)) {
            return;
        }
        r rVar = (r) request;
        rVar.e(this.mNickBlockApi.getGradeLevelDrawable(rVar.d(), rVar.c(), rVar.b(), 1));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.h();
        IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
        iBusManager.unRegisterEvent(com.tencent.qqnt.bus.event.j.class, this.mObserver);
        iBusManager.unRegisterEvent(com.tencent.qqnt.bus.event.i.class, this.mObserver);
    }
}
