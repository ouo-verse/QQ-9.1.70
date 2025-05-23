package com.tencent.timi.game.liveroom.impl.room.toparea;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveGetLikeRequest;
import com.tencent.timi.game.sso.request.QQLiveOnlineMetricRequest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0002\u0012\u0014B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/f;", "", "", "roomId", "", "programId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "showGold", "showPraise", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/f$b;", "callback", DomainData.DOMAIN_NAME, "enablePraise", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "J", "b", "Ljava/lang/String;", "c", "metricPollInterval", "d", "likePollInterval", "e", "Z", "f", "g", "hasExitRoom", tl.h.F, "Lcom/tencent/timi/game/liveroom/impl/room/toparea/f$b;", "i", "Ljava/lang/Runnable;", "j", "Ljava/lang/Runnable;", "metricDelayFetchRunnable", "k", "likeDelayFetchRunnable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean showGold;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showPraise;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasExitRoom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long roomId = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String programId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long metricPollInterval = 3;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long likePollInterval = 3;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean enablePraise = true;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable metricDelayFetchRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.d
        @Override // java.lang.Runnable
        public final void run() {
            f.p(f.this);
        }
    };

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable likeDelayFetchRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.e
        @Override // java.lang.Runnable
        public final void run() {
            f.o(f.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/f$b;", "", "", "coin", "", "a", "praise", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(long coin);

        void b(long praise);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/f$c", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lcom/google/protobuf/nano/MessageNano;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ILiveNetRequest.Callback<MessageNano> {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<MessageNano> response) {
            yq4.e eVar;
            Intrinsics.checkNotNullParameter(response, "response");
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("room_info|QQLiveOnlineMetricModelImpl", "fetchOnlineLikeData", "isSuccess = " + response.isSuccess() + ", hasExitRoom:" + f.this.hasExitRoom);
            MessageNano rsp = response.getRsp();
            if (rsp instanceof yq4.e) {
                eVar = (yq4.e) rsp;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                f fVar = f.this;
                long j3 = eVar.f451036b;
                if (j3 > 0) {
                    fVar.likePollInterval = j3;
                }
                companion.i("room_info|QQLiveOnlineMetricModelImpl", "fetchOnlineLikeData", "QQLiveResponse = interval: " + eVar.f451036b + ", " + eVar.f451035a);
                if (!fVar.hasExitRoom && eVar.f451035a != -1) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(fVar.likeDelayFetchRunnable);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(fVar.likeDelayFetchRunnable, fVar.likePollInterval * 1000);
                }
                b bVar = fVar.callback;
                if (bVar != null) {
                    bVar.b(eVar.f451035a);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/f$d", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lcom/google/protobuf/nano/MessageNano;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements ILiveNetRequest.Callback<MessageNano> {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<MessageNano> response) {
            ir4.e eVar;
            Object firstOrNull;
            Object firstOrNull2;
            Intrinsics.checkNotNullParameter(response, "response");
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("room_info|QQLiveOnlineMetricModelImpl", "fetchOnlineMetricData", "isSuccess = " + response.isSuccess() + ", hasExitRoom:" + f.this.hasExitRoom);
            MessageNano rsp = response.getRsp();
            Long l3 = null;
            if (rsp instanceof ir4.e) {
                eVar = (ir4.e) rsp;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                f fVar = f.this;
                long j3 = eVar.f408453b;
                long j16 = 0;
                if (j3 > 0) {
                    fVar.metricPollInterval = j3;
                }
                long j17 = eVar.f408453b;
                ir4.c[] metrics = eVar.f408452a;
                if (metrics != null) {
                    Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                    firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(metrics);
                    ir4.c cVar = (ir4.c) firstOrNull2;
                    if (cVar != null) {
                        l3 = Long.valueOf(cVar.f408448b);
                    }
                }
                companion.i("room_info|QQLiveOnlineMetricModelImpl", "fetchOnlineMetricData", "QueryOnlineMetricRsp = interval: " + j17 + ", " + l3);
                if (!fVar.hasExitRoom && fVar.enablePraise) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(fVar.metricDelayFetchRunnable);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(fVar.metricDelayFetchRunnable, fVar.metricPollInterval * 1000);
                }
                b bVar = fVar.callback;
                if (bVar != null) {
                    ir4.c[] metrics2 = eVar.f408452a;
                    if (metrics2 != null) {
                        Intrinsics.checkNotNullExpressionValue(metrics2, "metrics");
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(metrics2);
                        ir4.c cVar2 = (ir4.c) firstOrNull;
                        if (cVar2 != null) {
                            j16 = cVar2.f408448b;
                        }
                    }
                    bVar.a(j16);
                }
            }
        }
    }

    private final void l(long roomId, String programId) {
        boolean z16;
        this.roomId = roomId;
        this.programId = programId;
        AegisLogger.INSTANCE.i("room_info|QQLiveOnlineMetricModelImpl", "fetchOnlineLikeData", "roomId=" + roomId + ", programId=" + programId + ", hasExitRoom:" + this.hasExitRoom);
        if (roomId != -1) {
            if (programId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !this.hasExitRoom) {
                ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetLikeRequest(roomId, programId), new c());
            }
        }
    }

    private final void m(long roomId, String programId) {
        boolean z16;
        this.roomId = roomId;
        this.programId = programId;
        AegisLogger.INSTANCE.i("room_info|QQLiveOnlineMetricModelImpl", "fetchOnlineMetricData", "roomId=" + roomId + ", programId=" + programId + ", hasExitRoom:" + this.hasExitRoom);
        if (roomId != -1) {
            if (programId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !this.hasExitRoom) {
                ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveOnlineMetricRequest(roomId, programId), new d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(this$0.roomId, this$0.programId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(this$0.roomId, this$0.programId);
    }

    public final void n(long roomId, @NotNull String programId, boolean showGold, boolean showPraise, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.showGold = showGold;
        this.showPraise = showPraise;
        this.hasExitRoom = false;
        if (showGold) {
            m(roomId, programId);
        }
        if (showPraise) {
            l(roomId, programId);
        }
    }

    public final void q() {
        this.hasExitRoom = true;
        this.callback = null;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.likeDelayFetchRunnable);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.metricDelayFetchRunnable);
    }

    public final void r(boolean enablePraise) {
        this.enablePraise = enablePraise;
    }
}
