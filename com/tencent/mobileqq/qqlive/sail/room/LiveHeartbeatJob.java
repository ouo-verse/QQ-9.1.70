package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveHeartbeatJob;", "Lkotlinx/coroutines/CoroutineScope;", "", "errCode", "", "errMsg", "", "g", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", tl.h.F, "f", "e", "J", "lastSaveTimeMs", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "heartBeat", "", "I", "heartbeatFailedTimes", "i", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveHeartbeatJob implements CoroutineScope {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f272400d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastSaveTimeMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Job heartBeat;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int heartbeatFailedTimes;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AnchorRoomInfo roomInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveHeartbeatJob$a;", "", "", "SAVE_ROOM_INFO_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.LiveHeartbeatJob$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveHeartbeatJob() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f272400d = CoroutineScopeKt.CoroutineScope(LiveCoroutineScopes.f273421a.b().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new j("Open_Live|heartbeat")));
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, CoroutineStart.LAZY, new LiveHeartbeatJob$heartBeat$1(this, null), 1, null);
        this.heartBeat = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(long errCode, String errMsg) {
        int i3 = this.heartbeatFailedTimes + 1;
        this.heartbeatFailedTimes = i3;
        if (i3 < 5) {
            return;
        }
        AnchorRoomInfo anchorRoomInfo = this.roomInfo;
        if (anchorRoomInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomInfo");
            anchorRoomInfo = null;
        }
        com.tencent.mobileqq.qqlive.report.h.c(anchorRoomInfo.m(), QQLiveReportConstants.Event.E_ANCHOR_HEARTBEAT_FAILED, errMsg, String.valueOf(errCode));
        this.heartbeatFailedTimes = 0;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("Open_Live|LiveHeartbeatJob", "cancel");
            Job.DefaultImpls.cancel$default(this.heartBeat, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f272400d.getCoroutineContext();
    }

    public final void h(@NotNull AnchorRoomInfo roomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) roomInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        AegisLogger.INSTANCE.i("Open_Live|LiveHeartbeatJob", "start");
        this.roomInfo = roomInfo;
        this.heartBeat.invokeOnCompletion(LiveHeartbeatJob$start$1.INSTANCE);
        this.heartBeat.start();
    }
}
