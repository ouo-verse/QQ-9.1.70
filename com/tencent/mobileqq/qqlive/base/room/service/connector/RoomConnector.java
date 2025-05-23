package com.tencent.mobileqq.qqlive.base.room.service.connector;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.base.room.service.event.e;
import com.tencent.mobileqq.qqlive.base.room.service.event.f;
import com.tencent.mobileqq.qqlive.base.room.service.event.g;
import com.tencent.mobileqq.qqlive.base.room.service.event.i;
import com.tencent.mobileqq.qqlive.base.room.service.event.j;
import com.tencent.mobileqq.qqlive.base.room.service.event.k;
import com.tencent.mobileqq.qqlive.base.room.service.event.l;
import com.tencent.mobileqq.qqlive.base.room.service.lifecycle.ActivityLifecycle;
import com.tencent.mobileqq.qqlive.base.room.service.lifecycle.PageLifecycle;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.d;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import fi2.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0014\u0010\n\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\bH\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0004H\u0014J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0014J\b\u0010 \u001a\u00020\u0004H\u0014J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!H\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020#H\u0014J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%H\u0014J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020'H\u0014J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020)H\u0014J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020+H\u0014J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020-H\u0014J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020/H\u0014\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/qqlive/framework/connector/a;", "Lcom/tencent/mobileqq/qqlive/base/room/service/event/a;", "event", "", h.F, "Lcom/tencent/mobileqq/qqlive/base/room/service/event/f;", "t", "", "Lcom/tencent/mobileqq/qqlive/framework/interfaceService/a;", "c", "a", "o", "Lcom/tencent/mobileqq/qqlive/base/room/service/event/l;", "switchToNextEvent", "E", "f", "k", "j", "i", "l", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/os/Bundle;", "arguments", "B", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/base/room/service/event/h;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqlive/base/room/service/event/e;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqlive/base/room/service/event/g;", "v", "Lcom/tencent/mobileqq/qqlive/base/room/service/event/k;", "D", "Lcom/tencent/mobileqq/qqlive/base/room/service/event/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/base/room/service/event/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/base/room/service/event/d;", "p", "Lcom/tencent/mobileqq/qqlive/base/room/service/event/i;", UserInfo.SEX_FEMALE, "Lfi2/b;", "connectorContext", "<init>", "(Lfi2/b;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class RoomConnector extends com.tencent.mobileqq.qqlive.framework.connector.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f271125a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f271126b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30251);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ActivityLifecycle.values().length];
            try {
                iArr[ActivityLifecycle.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActivityLifecycle.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActivityLifecycle.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActivityLifecycle.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ActivityLifecycle.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ActivityLifecycle.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f271125a = iArr;
            int[] iArr2 = new int[PageLifecycle.values().length];
            try {
                iArr2[PageLifecycle.PAGE_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PageLifecycle.PAGE_VIEW_CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PageLifecycle.PAGE_ON_NEW_INTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PageLifecycle.PAGE_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PageLifecycle.PAGE_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PageLifecycle.PAGE_PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PageLifecycle.PAGE_STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[PageLifecycle.PAGE_DESTROY.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[PageLifecycle.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            f271126b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomConnector(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) connectorContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(com.tencent.mobileqq.qqlive.base.room.service.event.a event) {
        switch (a.f271125a[event.c().ordinal()]) {
            case 1:
                f();
                return;
            case 2:
                k();
                return;
            case 3:
                j();
                return;
            case 4:
                i();
                return;
            case 5:
                l();
                return;
            case 6:
                g();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(f event) {
        switch (a.f271126b[event.d().ordinal()]) {
            case 1:
                q();
                return;
            case 2:
                B(event.c());
                return;
            case 3:
                u(event.c());
                return;
            case 4:
                z();
                return;
            case 5:
                y();
                return;
            case 6:
                w();
                return;
            case 7:
                A();
                return;
            case 8:
                r();
                return;
            case 9:
                n();
                return;
            default:
                return;
        }
    }

    protected void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    protected void B(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) arguments);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(@NotNull j event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(@NotNull k event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(@NotNull l switchToNextEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) switchToNextEvent);
        } else {
            Intrinsics.checkNotNullParameter(switchToNextEvent, "switchToNextEvent");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(@NotNull i event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f.a(b().c(), new d(com.tencent.mobileqq.qqlive.base.room.service.event.a.class, new RoomConnector$initEventConnector$1(this))), new d(f.class, new RoomConnector$initEventConnector$2(this))), new d(com.tencent.mobileqq.qqlive.base.room.service.event.h.class, new RoomConnector$initEventConnector$3(this))), new d(e.class, new RoomConnector$initEventConnector$4(this))), new d(g.class, new RoomConnector$initEventConnector$5(this))), new d(k.class, new RoomConnector$initEventConnector$6(this))), new d(j.class, new RoomConnector$initEventConnector$7(this))), new d(com.tencent.mobileqq.qqlive.base.room.service.event.b.class, new RoomConnector$initEventConnector$8(this))), new d(com.tencent.mobileqq.qqlive.base.room.service.event.d.class, new RoomConnector$initEventConnector$9(this))), new d(i.class, new RoomConnector$initEventConnector$10(this))), new d(l.class, new RoomConnector$initEventConnector$11(this)));
            o();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
    @Nullable
    public List<com.tencent.mobileqq.qqlive.framework.interfaceService.a<?>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    protected void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@NotNull com.tencent.mobileqq.qqlive.base.room.service.event.b event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@NotNull com.tencent.mobileqq.qqlive.base.room.service.event.d event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    protected void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    protected void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(@NotNull e event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    protected void u(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) arguments);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@NotNull g event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    protected void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(@NotNull com.tencent.mobileqq.qqlive.base.room.service.event.h event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    protected void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    protected void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }
}
