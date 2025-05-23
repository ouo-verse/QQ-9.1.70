package com.tencent.mobileqq.qqlive.sail.util;

import android.os.SystemClock;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.base.coroutine.QQLiveCoroutineScopes;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.model.d;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0006\u0010\r\u001a\u00020\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/util/RoomHeartBeatReporter;", "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/a;", "Lkotlinx/coroutines/Job;", "g", "", "l", "", "i", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "room", "a", "stop", "", "j", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "b", "Lkotlinx/coroutines/Job;", "heartBeatJob", "", "c", "J", "lastHeartBeatTime", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", h.F, "()Lcom/tencent/mobileqq/qqlive/sail/model/d;", "roomInfo", "k", "()Z", "isFloatWindow", "<init>", "()V", "d", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RoomHeartBeatReporter implements com.tencent.mobileqq.qqlive.widget.floatwindow.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f room;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job heartBeatJob;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastHeartBeatTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/util/RoomHeartBeatReporter$a;", "", "", "HEART_BEAT_INTERVAL", "J", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.util.RoomHeartBeatReporter$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RoomHeartBeatReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lastHeartBeatTime = Long.MAX_VALUE;
        }
    }

    private final Job g() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QQLiveCoroutineScopes.f270996a.c().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new RoomHeartBeatReporter$createHeartBeatJob$1(this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d h() {
        f fVar = this.room;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        d h16 = h();
        if (h16 instanceof AnchorRoomInfo) {
            return "Open_Live|RoomHeartBeatReporter";
        }
        if (h16 instanceof AudienceRoomInfo) {
            return "Audience|RoomHeartBeatReporter";
        }
        return "unknown|RoomHeartBeatReporter";
    }

    private final boolean k() {
        AudienceRoomInfo audienceRoomInfo;
        d h16 = h();
        WindowMode windowMode = null;
        if (h16 instanceof AudienceRoomInfo) {
            audienceRoomInfo = (AudienceRoomInfo) h16;
        } else {
            audienceRoomInfo = null;
        }
        if (audienceRoomInfo != null) {
            windowMode = audienceRoomInfo.v();
        }
        if (windowMode == WindowMode.FLOAT) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        long coerceAtLeast;
        String str;
        AnchorRoomInfo anchorRoomInfo;
        d h16 = h();
        if (h16 != null) {
            if (j()) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - this.lastHeartBeatTime, 0L);
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isColorLevel()) {
                    companion.i(i(), "reportHeartBeat", "roomId=" + h16.getRoomId() + ", isFloatWindow=" + k() + ", timeLong=" + coerceAtLeast);
                }
                com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
                QQLiveDaTongParams f16 = aVar.f(h16.getRoomId());
                if (companion.isDevelopLevel()) {
                    companion.d(i(), "reportHeartBeat", "roomId=" + h16.getRoomId() + ", programId=" + f16.b());
                }
                String str2 = "0";
                if (BaseGesturePWDUtil.isAppOnForeground(BaseApplication.context)) {
                    str = "0";
                } else {
                    str = "1";
                }
                f16.g(str);
                if (k()) {
                    str2 = "1";
                }
                f16.C(str2);
                f16.J(String.valueOf(coerceAtLeast));
                if (h16 instanceof AnchorRoomInfo) {
                    anchorRoomInfo = (AnchorRoomInfo) h16;
                } else {
                    anchorRoomInfo = null;
                }
                if (anchorRoomInfo != null) {
                    f16.O(anchorRoomInfo.r().n().c());
                    f16.E(String.valueOf(anchorRoomInfo.r().m()));
                }
                aVar.i("ev_qqlive_heartbeat", f16.a());
                this.lastHeartBeatTime = SystemClock.elapsedRealtime();
                return;
            }
            AegisLogger.INSTANCE.i(i(), "reportHeartBeat", "roomId=" + h16.getRoomId() + ", room is not entered");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.floatwindow.a
    public void a(@Nullable f room) {
        d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) room);
            return;
        }
        if (room != null && (b16 = room.b()) != null) {
            d h16 = h();
            boolean z16 = false;
            if (h16 != null && b16.getRoomId() == h16.getRoomId()) {
                z16 = true;
            }
            if (z16) {
                AegisLogger.INSTANCE.i(i(), "start", "roomId=" + b16.getRoomId() + ", already started");
                return;
            }
            this.room = room;
            AegisLogger.INSTANCE.i(i(), "start", "roomId=" + b16.getRoomId());
            l();
            Job job = this.heartBeatJob;
            DisposableHandle disposableHandle = null;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job g16 = g();
            this.heartBeatJob = g16;
            if (g16 != null) {
                disposableHandle = g16.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.util.RoomHeartBeatReporter$start$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomHeartBeatReporter.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th5) {
                        String i3;
                        d h17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) th5);
                            return;
                        }
                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                        i3 = RoomHeartBeatReporter.this.i();
                        h17 = RoomHeartBeatReporter.this.h();
                        companion.i(i3, "jobCompleted", "roomId=" + (h17 != null ? Long.valueOf(h17.getRoomId()) : null));
                        RoomHeartBeatReporter.this.l();
                        RoomHeartBeatReporter.this.room = null;
                    }
                });
            }
            if (disposableHandle != null) {
                return;
            }
        }
        AegisLogger.INSTANCE.w(i(), "start", "invalid room info");
        Unit unit = Unit.INSTANCE;
    }

    public final boolean j() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        d h16 = h();
        if (h16 != null) {
            j3 = h16.e();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.floatwindow.a
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        d h16 = h();
        if (h16 != null) {
            AegisLogger.INSTANCE.i(i(), "stop", "roomId=" + h16.getRoomId());
        }
        Job job = this.heartBeatJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
