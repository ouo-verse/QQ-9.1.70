package com.tencent.mobileqq.icgame.base.room.service.connector;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.ActivityLifecycle;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.PageLifecycle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import f32.b;
import g32.d;
import g32.f;
import i22.ActivityLifecycleEvent;
import i22.OrientationChangedEvent;
import i22.PageLifecycleEvent;
import i22.e;
import i22.g;
import i22.i;
import i22.j;
import i22.k;
import i22.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0014\u0010\n\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\bH\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0004H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\b\u0010\u001a\u001a\u00020\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001dH\u0014J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001fH\u0014J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!H\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020#H\u0014J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%H\u0014J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020'H\u0014J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020)H\u0014J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020+H\u0014\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/service/connector/RoomConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "Li22/a;", "event", "", h.F, "Li22/f;", "t", "", "Li32/a;", "c", "a", "o", "Li22/l;", "switchToNextEvent", BdhLogUtil.LogTag.Tag_Conn, "f", "k", "j", "i", "l", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", HippyTKDListViewAdapter.X, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", DomainData.DOMAIN_NAME, "Li22/h;", "w", "Li22/e;", ReportConstant.COSTREPORT_PREFIX, "Li22/g;", "u", "Li22/k;", "B", "Li22/j;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Li22/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Li22/d;", "p", "Li22/i;", "D", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class RoomConnector extends com.tencent.mobileqq.icgame.framework.connector.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f237234a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f237235b;

        static {
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
            f237234a = iArr;
            int[] iArr2 = new int[PageLifecycle.values().length];
            try {
                iArr2[PageLifecycle.PAGE_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PageLifecycle.PAGE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PageLifecycle.PAGE_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PageLifecycle.PAGE_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PageLifecycle.PAGE_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PageLifecycle.PAGE_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PageLifecycle.DESTROY.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            f237235b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomConnector(@NotNull b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(ActivityLifecycleEvent event) {
        switch (a.f237234a[event.getLifecycle().ordinal()]) {
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
    public final void t(PageLifecycleEvent event) {
        switch (a.f237235b[event.getPageLifecycle().ordinal()]) {
            case 1:
                q();
                return;
            case 2:
                y();
                return;
            case 3:
                x();
                return;
            case 4:
                v();
                return;
            case 5:
                z();
                return;
            case 6:
                r();
                return;
            case 7:
                n();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(@NotNull j event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(@NotNull k event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(@NotNull l switchToNextEvent) {
        Intrinsics.checkNotNullParameter(switchToNextEvent, "switchToNextEvent");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(@NotNull i event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public final void a() {
        f.a(f.a(f.a(f.a(f.a(f.a(f.a(f.a(f.a(f.a(f.a(getConnectorContext().c(), new d(ActivityLifecycleEvent.class, new RoomConnector$initEventConnector$1(this))), new d(PageLifecycleEvent.class, new RoomConnector$initEventConnector$2(this))), new d(i22.h.class, new RoomConnector$initEventConnector$3(this))), new d(e.class, new RoomConnector$initEventConnector$4(this))), new d(g.class, new RoomConnector$initEventConnector$5(this))), new d(k.class, new RoomConnector$initEventConnector$6(this))), new d(j.class, new RoomConnector$initEventConnector$7(this))), new d(i22.b.class, new RoomConnector$initEventConnector$8(this))), new d(OrientationChangedEvent.class, new RoomConnector$initEventConnector$9(this))), new d(i.class, new RoomConnector$initEventConnector$10(this))), new d(l.class, new RoomConnector$initEventConnector$11(this)));
        o();
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    @Nullable
    public List<i32.a<?>> c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@NotNull i22.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@NotNull OrientationChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(@NotNull e event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@NotNull i22.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    protected void f() {
    }

    protected void g() {
    }

    protected void i() {
    }

    protected void j() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    protected void l() {
    }

    protected void n() {
    }

    public void o() {
    }

    protected void q() {
    }

    protected void r() {
    }

    protected void v() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
    }

    protected void y() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
    }
}
