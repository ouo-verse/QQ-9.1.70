package in3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\t*\u0001\u001e\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\f0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lin3/b;", "", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "roomId", "", "f", "", "data", "b", "c", "d", "Lin3/a;", "Lh55/b;", "pushCallback", "e", "Lh55/a;", "g", h.F, "Lfp4/c;", "msgInfo", "onPush", "J", "", "Ljava/util/List;", "endLinkScreenCbs", "startLinkScreenCbs", "", "Z", "hasRegisterPush", "in3/b$b", "i", "Lin3/b$b;", "linkScreenPushCallback", "<init>", "(J)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasRegisterPush;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<a<h55.b>> endLinkScreenCbs = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<a<h55.a>> startLinkScreenCbs = new ArrayList();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10543b linkScreenPushCallback = new C10543b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"in3/b$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: in3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10543b implements IQQCmdPushCallback {
        C10543b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.e("PK_Biz|LinkScreenPushImpl", "linkScreenPushCallback", "onFail, errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            b.this.b(data);
        }
    }

    public b(long j3) {
        this.roomId = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(byte[] data) {
        gp4.a c16 = gp4.a.c(data);
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenPushImpl", "handleReceiveLinkScreenPush", "\u6536\u5230cmd: " + c16.f403047a);
        int i3 = c16.f403047a;
        if (i3 != 104) {
            if (i3 == 105) {
                d(c16.f403049c);
                return;
            }
            return;
        }
        c(c16.f403049c);
    }

    private final void c(byte[] data) {
        h55.b bVar = new h55.b();
        MessageNano.mergeFrom(bVar, data);
        Iterator<T> it = this.endLinkScreenCbs.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(bVar);
        }
    }

    private final void d(byte[] data) {
        h55.a aVar = new h55.a();
        MessageNano.mergeFrom(aVar, data);
        Iterator<T> it = this.startLinkScreenCbs.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(aVar);
        }
    }

    private final void f(long roomId) {
        Unit unit;
        synchronized (this) {
            if (!this.hasRegisterPush) {
                f z16 = c.z(c.f272176a, roomId, 0, 2, null);
                if (z16 != null) {
                    z16.p(285, this);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    com.tencent.mobileqq.qqlive.pushadapter.a.a(roomId, 285, this.linkScreenPushCallback);
                }
                this.hasRegisterPush = true;
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public void e(@NotNull a<h55.b> pushCallback) {
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        this.endLinkScreenCbs.add(pushCallback);
        f(this.roomId);
    }

    public void g(@NotNull a<h55.a> pushCallback) {
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        this.startLinkScreenCbs.add(pushCallback);
        f(this.roomId);
    }

    public final void h() {
        f z16 = c.z(c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        com.tencent.mobileqq.qqlive.pushadapter.a.b(this.roomId, this.linkScreenPushCallback);
        this.endLinkScreenCbs.clear();
        this.startLinkScreenCbs.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        h55.b b16 = com.tencent.mobileqq.qqlive.sail.push.a.b(msgInfo);
        if (b16 != null) {
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenPushImpl", "onPush", "AnchorSwitchMic, end link");
            Iterator<T> it = this.endLinkScreenCbs.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(b16);
            }
        }
        h55.a a16 = com.tencent.mobileqq.qqlive.sail.push.a.a(msgInfo);
        if (a16 != null) {
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenPushImpl", "onPush", "AnchorAllowMic, start link");
            Iterator<T> it5 = this.startLinkScreenCbs.iterator();
            while (it5.hasNext()) {
                ((a) it5.next()).a(a16);
            }
        }
    }
}
