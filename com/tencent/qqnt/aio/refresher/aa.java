package com.tencent.qqnt.aio.refresher;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/aa;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "Lcom/tencent/qqnt/bus/event/n;", "event", "", "p", "Lcom/tencent/qqnt/bus/event/l;", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "c", tl.h.F, "", "j", "com/tencent/qqnt/aio/refresher/aa$b", "Lcom/tencent/qqnt/aio/refresher/aa$b;", "mEventObser", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/external/e;)V", "d", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class aa extends com.tencent.mobileqq.aio.msglist.holder.external.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mEventObser;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/aa$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.aa$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/refresher/aa$b", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements zv3.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aa.this);
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
            if (event instanceof com.tencent.qqnt.bus.event.n) {
                aa.this.p((com.tencent.qqnt.bus.event.n) event);
            } else if (event instanceof com.tencent.qqnt.bus.event.l) {
                aa.this.n((com.tencent.qqnt.bus.event.l) event);
            } else if (event instanceof com.tencent.qqnt.bus.event.m) {
                aa.this.o();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        super(helper);
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
            return;
        }
        b bVar = new b();
        this.mEventObser = bVar;
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.n.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.l.class, bVar);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.m.class, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(com.tencent.qqnt.bus.event.l event) {
        if (b() == 2 && Intrinsics.areEqual(i(), event.a())) {
            e(x.f352022a);
            return;
        }
        QLog.e("MemberLevelRefresher", 1, "[updateShowToggle]: troopUin " + event.a() + " not equal peerUid " + i() + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (b() != 2) {
            QLog.e("MemberLevelRefresher", 1, "[globalUpdate] error!");
        } else {
            QLog.i("MemberLevelRefresher", 1, "[globalUpdate]");
            e(x.f352022a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(com.tencent.qqnt.bus.event.n event) {
        if (b() == 2 && Intrinsics.areEqual(i(), event.j())) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MemberLevelRefresher", 4, "[updateMemberLevelInfo]: event is " + event);
            }
            e(new z(event.c(), new com.tencent.qqnt.aio.nick.f(event.e(), event.h(), event.g(), event.d(), event.a(), event.k(), event.l(), event.f(), event.b(), event.i())));
            return;
        }
        QLog.e("MemberLevelRefresher", 1, "[updateMemberLevelInfo]: troopUin " + event.j() + " not equal peerUid " + i() + " ");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void c(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
        } else {
            Intrinsics.checkNotNullParameter(request, "request");
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.h();
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.n.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.l.class, this.mEventObser);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.m.class, this.mEventObser);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
