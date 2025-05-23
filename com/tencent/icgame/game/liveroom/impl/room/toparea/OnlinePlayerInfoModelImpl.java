package com.tencent.icgame.game.liveroom.impl.room.toparea;

import android.os.Handler;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.icgame.game.liveroom.impl.room.toparea.OnlinePlayerInfoModelImpl;
import com.tencent.icgame.game.sso.request.ICGameOnlinePlayerRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0002\u000e\u0010B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl;", "", "", "i", "", "roomId", "", "programId", "", "g", "j", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl$b;", "callback", h.F, "a", "J", "b", "Ljava/lang/String;", "c", "pollInterval", "d", "Z", "hasExitRoom", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl$b;", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "onlineInfoDelayFetchRunnable", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class OnlinePlayerInfoModelImpl {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasExitRoom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long roomId = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String programId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long pollInterval = 3;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable onlineInfoDelayFetchRunnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.toparea.c
        @Override // java.lang.Runnable
        public final void run() {
            OnlinePlayerInfoModelImpl.k(OnlinePlayerInfoModelImpl.this);
        }
    };

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/toparea/OnlinePlayerInfoModelImpl$b;", "", "", "roomId", WidgetCacheConstellationData.NUM, "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a(long roomId, long num);
    }

    private final void g(final long roomId, String programId) {
        this.roomId = roomId;
        this.programId = programId;
        rt0.a.INSTANCE.k("ICGameRoom_info|ICGameRoomOnlineInfoModelImpl", "fetchOnlineMetricData", "roomId=" + roomId + ", programId=" + programId + ", hasExitRoom:" + this.hasExitRoom);
        if (!i()) {
            return;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new ICGameOnlinePlayerRequest(roomId, programId), new Function1<QQLiveResponse<dp4.b>, Unit>() { // from class: com.tencent.icgame.game.liveroom.impl.room.toparea.OnlinePlayerInfoModelImpl$fetchOnlineInfoData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<dp4.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<dp4.b> response) {
                boolean i3;
                long j3;
                Runnable runnable;
                long j16;
                OnlinePlayerInfoModelImpl.b bVar;
                Intrinsics.checkNotNullParameter(response, "response");
                i3 = OnlinePlayerInfoModelImpl.this.i();
                if (i3) {
                    if (!response.isFailed() && response.getRsp() != null) {
                        dp4.b rsp = response.getRsp();
                        Intrinsics.checkNotNull(rsp, "null cannot be cast to non-null type com.tencent.trpcprotocol.icggame.room_live_info.room_live_info.nano.BatchGetRoomLiveDataRsp");
                        dp4.b bVar2 = rsp;
                        dp4.d[] dVarArr = bVar2.f394534a;
                        if (dVarArr != null) {
                            Intrinsics.checkNotNullExpressionValue(dVarArr, "resp.list");
                            OnlinePlayerInfoModelImpl onlinePlayerInfoModelImpl = OnlinePlayerInfoModelImpl.this;
                            for (dp4.d dVar : dVarArr) {
                                rt0.a.INSTANCE.k("ICGameRoom_info|ICGameRoomOnlineInfoModelImpl", "fetchOnlineInfoData", "roomId:" + dVar.f394540a + " playNum:" + dVar.f394541b);
                                bVar = onlinePlayerInfoModelImpl.callback;
                                if (bVar != null) {
                                    bVar.a(dVar.f394540a, dVar.f394541b);
                                }
                            }
                        }
                        long j17 = bVar2.f394535b;
                        if (j17 > 0) {
                            OnlinePlayerInfoModelImpl.this.pollInterval = j17;
                        }
                    } else {
                        rt0.a.INSTANCE.h("ICGameRoom_info|ICGameRoomOnlineInfoModelImpl", "fetchOnlineInfoData", "fail! roomId=" + roomId + " response code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                    }
                    j3 = OnlinePlayerInfoModelImpl.this.pollInterval;
                    if (j3 <= 0) {
                        OnlinePlayerInfoModelImpl.this.pollInterval = 3L;
                    }
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    runnable = OnlinePlayerInfoModelImpl.this.onlineInfoDelayFetchRunnable;
                    j16 = OnlinePlayerInfoModelImpl.this.pollInterval;
                    uIHandlerV2.postDelayed(runnable, j16 * 1000);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        boolean z16;
        if (this.roomId != -1) {
            if (this.programId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !this.hasExitRoom) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(OnlinePlayerInfoModelImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(this$0.roomId, this$0.programId);
    }

    public final void h(long roomId, @NotNull String programId, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        g(roomId, programId);
    }

    public final void j() {
        this.hasExitRoom = true;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.onlineInfoDelayFetchRunnable);
        this.callback = null;
    }
}
