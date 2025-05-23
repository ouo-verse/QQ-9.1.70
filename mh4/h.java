package mh4;

import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001c\u00a8\u0006!"}, d2 = {"Lmh4/h;", "", "", "c", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "e", "", "i", "d", "o", "Lgh4/c;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "joinListener", "g", "k", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lrr1/i;", "notifyData", "l", "Lgh4/e;", "a", "Lgh4/e;", "mHall", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "mDelayJoinRoomTask", "mDelayExitRoomTask", "<init>", "(Lgh4/e;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.e mHall;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mDelayJoinRoomTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mDelayExitRoomTask;

    public h(@NotNull gh4.e mHall) {
        Intrinsics.checkNotNullParameter(mHall, "mHall");
        this.mHall = mHall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qBaseActivity, "$qBaseActivity");
        com.tencent.timi.game.utils.l.m("ExpandHallGuildUtil_", this$0 + " doing DelayExitRoom task");
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).closeAppChannel(qBaseActivity, new rr1.b(this$0.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String().C));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0, gh4.c joinListener, QBaseActivity qBaseActivity) {
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(joinListener, "$joinListener");
        Intrinsics.checkNotNullParameter(qBaseActivity, "$qBaseActivity");
        long mHallState = this$0.mHall.getMHallState();
        if (mHallState != 3 && mHallState != 4) {
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this$0.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String().H);
            if (K0 != null && (roomInfo = K0.getRoomInfo()) != null) {
                joinListener.onSuccess(roomInfo);
                com.tencent.timi.game.utils.l.h("ExpandHallGuildUtil_", 1, "joinRoom#from room:" + this$0.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String().H + " already exits!");
                return;
            }
            this$0.mHall.getMReporterHelper().T();
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            dVar.f379324a = this$0.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String().H;
            dVar.f379325b = 2;
            dVar.f379326c = 1;
            dVar.f379328e = 5;
            dVar.f379329f = fm4.c.a(this$0.mHall.getMReporterHelper().getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String());
            dVar.f379327d = false;
            dVar.f379330g = 0L;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar = new com.tencent.timi.game.room.impl.util.c();
            cVar.f379322a = 0;
            cVar.f379323b = null;
            ((fm4.g) mm4.b.b(fm4.g.class)).P(qBaseActivity, dVar, cVar, joinListener);
            return;
        }
        com.tencent.timi.game.utils.l.c("ExpandHallGuildUtil_", 1, "already destroyed, give up mDelayJoinRoomTask");
    }

    public final void c() {
        com.tencent.timi.game.utils.l.b("ExpandHallGuildUtil_", this + " clearDelayExitRoomTask ");
        if (this.mDelayExitRoomTask != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.mDelayExitRoomTask;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.removeCallbacks(runnable);
        }
        this.mDelayExitRoomTask = null;
    }

    public final void d() {
        if (this.mDelayJoinRoomTask != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.mDelayJoinRoomTask;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.removeCallbacks(runnable);
        }
        this.mDelayJoinRoomTask = null;
    }

    public final void e(@NotNull final QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        c();
        com.tencent.timi.game.utils.l.b("ExpandHallGuildUtil_", this + " createDelayExitRoomTask ");
        this.mDelayExitRoomTask = new Runnable() { // from class: mh4.g
            @Override // java.lang.Runnable
            public final void run() {
                h.f(h.this, qBaseActivity);
            }
        };
    }

    public final void g(@NotNull final gh4.c<YoloRoomOuterClass$YoloRoomInfo> joinListener, @NotNull final QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(joinListener, "joinListener");
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        d();
        this.mDelayJoinRoomTask = new Runnable() { // from class: mh4.f
            @Override // java.lang.Runnable
            public final void run() {
                h.h(h.this, joinListener, qBaseActivity);
            }
        };
    }

    public final boolean i() {
        if (this.mDelayJoinRoomTask != null) {
            return true;
        }
        return false;
    }

    public final void j() {
        if (this.mHall.O().b(2)) {
            return;
        }
        m();
    }

    public final void k() {
        c();
        d();
    }

    public final void l(@NotNull rr1.i notifyData) {
        Intrinsics.checkNotNullParameter(notifyData, "notifyData");
        if (th4.l.b(notifyData)) {
            com.tencent.timi.game.utils.l.h("ExpandHallGuildUtil_", 1, "onNotify slide in");
            this.mHall.getMReporterHelper().M();
        } else if (th4.l.a(notifyData)) {
            com.tencent.timi.game.utils.l.h("ExpandHallGuildUtil_", 1, "onNotify slide out");
            this.mHall.getMReporterHelper().N();
        }
    }

    public final void m() {
        boolean z16;
        if (this.mHall.getMHallState() == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.h("ExpandHallGuildUtil_", 1, "reportGuildUnreadMsg isJoinSucceed:" + z16);
        if (!z16) {
            return;
        }
        ExpandHallLaunchParam O = this.mHall.O();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return;
        }
        IGuildMsgReadedService iGuildMsgReadedService = (IGuildMsgReadedService) waitAppRuntime.getRuntimeService(IGuildMsgReadedService.class, "");
        String valueOf = String.valueOf(O.f376304h);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(O.C);
        Unit unit = Unit.INSTANCE;
        iGuildMsgReadedService.setMsgReadedAndReport(valueOf, arrayList, 18, false);
        com.tencent.timi.game.utils.l.h("ExpandHallGuildUtil_", 1, "reportGuildUnreadMsg done");
    }

    public final void n() {
        com.tencent.timi.game.utils.l.b("ExpandHallGuildUtil_", this + " triggerDelayExitRoomTask ");
        if (this.mDelayExitRoomTask != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.mDelayExitRoomTask;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.postDelayed(runnable, 1500L);
        }
    }

    public final void o() {
        if (this.mDelayJoinRoomTask != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.mDelayJoinRoomTask;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.post(runnable);
        }
    }
}
