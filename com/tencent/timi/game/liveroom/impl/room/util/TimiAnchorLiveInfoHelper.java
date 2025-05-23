package com.tencent.timi.game.liveroom.impl.room.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.liveroom.impl.room.util.TimiAnchorLiveInfoHelper;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u000f*\u0001-\u0018\u0000 \t2\u00020\u0001:\u0002\u000b\u0011B/\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020 \u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\"\u00103\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u00102R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u00104\u001a\u0004\b&\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper;", "", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "result", "", "g", "", tl.h.F, "i", "j", "Landroid/view/View;", "a", "Landroid/view/View;", "getParentView", "()Landroid/view/View;", "parentView", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "anchorId", "", "J", "e", "()J", "roomId", "", "d", "I", "()I", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$b;", "Lcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$b;", "getAnchorInfoUpdateListener", "()Lcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$b;", "anchorInfoUpdateListener", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "getRequestRunnable", "()Ljava/lang/Runnable;", "setRequestRunnable", "(Ljava/lang/Runnable;)V", "requestRunnable", "com/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$c", "Lcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$c;", "anchorRoomInfoCallback", "getPeriodTime", "setPeriodTime", "(J)V", "periodTime", "Z", "()Z", "setRunning", "(Z)V", "running", "<init>", "(Landroid/view/View;Ljava/lang/String;JILcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$b;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiAnchorLiveInfoHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View parentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String anchorId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int gameId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b anchorInfoUpdateListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable requestRunnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c anchorRoomInfoCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long periodTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean running;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$b;", "", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "result", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@Nullable GetAnchorRoomInfoRequest.a result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/util/TimiAnchorLiveInfoHelper$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<GetAnchorRoomInfoRequest.a> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GetAnchorRoomInfoRequest.a result) {
            TimiAnchorLiveInfoHelper.this.g(result);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.e("TimiAnchorLiveInfoHelper", "requestAnchorRoomInfo onError " + errorCode + " " + errorMessage + " " + TimiAnchorLiveInfoHelper.this.getRoomId());
        }
    }

    public TimiAnchorLiveInfoHelper(@NotNull View parentView, @NotNull String anchorId, long j3, int i3, @NotNull b anchorInfoUpdateListener) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        Intrinsics.checkNotNullParameter(anchorInfoUpdateListener, "anchorInfoUpdateListener");
        this.parentView = parentView;
        this.anchorId = anchorId;
        this.roomId = j3;
        this.gameId = i3;
        this.anchorInfoUpdateListener = anchorInfoUpdateListener;
        this.requestRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.util.TimiAnchorLiveInfoHelper$requestRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Long longOrNull;
                long j16;
                TimiAnchorLiveInfoHelper.c cVar;
                if (TimiAnchorLiveInfoHelper.this.getRunning()) {
                    GetAnchorRoomInfoRequest getAnchorRoomInfoRequest = GetAnchorRoomInfoRequest.f377853a;
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(TimiAnchorLiveInfoHelper.this.getAnchorId());
                    if (longOrNull != null) {
                        j16 = longOrNull.longValue();
                    } else {
                        j16 = 0;
                    }
                    int gameId = TimiAnchorLiveInfoHelper.this.getGameId();
                    long roomId = TimiAnchorLiveInfoHelper.this.getRoomId();
                    cVar = TimiAnchorLiveInfoHelper.this.anchorRoomInfoCallback;
                    getAnchorRoomInfoRequest.a(j16, gameId, roomId, cVar);
                }
            }
        };
        this.anchorRoomInfoCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(GetAnchorRoomInfoRequest.a result) {
        String str;
        long j3;
        PremadesTeamServerOuterClass$AnchorGameInfo info;
        PBStringField pBStringField;
        Integer num = null;
        if (result != null && (info = result.getInfo()) != null && (pBStringField = info.url) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        long j16 = this.roomId;
        if (result != null) {
            num = Integer.valueOf(result.getPeriod());
        }
        l.i("TimiAnchorLiveInfoHelper", "requestAnchorRoomInfo success roomId =" + j16 + " period= " + num + " ," + isEmpty);
        if (this.running && h(result)) {
            if (result != null) {
                j3 = result.getPeriod();
            } else {
                j3 = 0;
            }
            this.periodTime = j3;
            this.anchorInfoUpdateListener.a(result);
            if (this.periodTime > 0) {
                this.parentView.removeCallbacks(this.requestRunnable);
                this.parentView.postDelayed(this.requestRunnable, this.periodTime + 1000);
            }
        }
    }

    private final boolean h(GetAnchorRoomInfoRequest.a result) {
        if (result == null || this.roomId != result.getRoomId()) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAnchorId() {
        return this.anchorId;
    }

    /* renamed from: d, reason: from getter */
    public final int getGameId() {
        return this.gameId;
    }

    /* renamed from: e, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getRunning() {
        return this.running;
    }

    public final void i() {
        this.running = true;
        this.parentView.removeCallbacks(this.requestRunnable);
        this.parentView.post(this.requestRunnable);
    }

    public final void j() {
        this.running = false;
        this.parentView.removeCallbacks(this.requestRunnable);
    }
}
