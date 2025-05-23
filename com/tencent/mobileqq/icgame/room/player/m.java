package com.tencent.mobileqq.icgame.room.player;

import android.view.View;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/player/m;", "Lcom/tencent/mobileqq/icgame/room/player/k;", "", "roomId", "Lcom/tencent/mobileqq/icgame/api/room/ILiveTPPlayerRoom;", "c", "", "url", "", "b", "Landroid/view/View;", "view", "a", "pause", "resume", "stop", "", "degree", "setVideoRotation", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class m implements k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    public m() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
    }

    private final ILiveTPPlayerRoom c(long roomId) {
        IAudienceRoom y16 = ((fu0.c) qx0.a.b(fu0.c.class)).y(roomId);
        if (y16 instanceof ILiveTPPlayerRoom) {
            return (ILiveTPPlayerRoom) y16;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    @Override // com.tencent.mobileqq.icgame.room.player.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable String url, @Nullable View view) {
        long j3;
        Long longOrNull;
        if (url != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "startPlay, roomId " + j3);
        ILiveTPPlayerRoom c16 = c(j3);
        if (c16 != null) {
            c16.startPlay("");
            Unit unit = Unit.INSTANCE;
            this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "startPlay, roomId " + j3 + " success");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.mobileqq.icgame.room.player.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@Nullable String url) {
        long j3;
        Long longOrNull;
        if (url != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "prepareWithCurrent, roomId " + j3);
        ILiveTPPlayerRoom c16 = c(j3);
        if (c16 != null) {
            c16.preloadWithCurrentUrl();
            Unit unit = Unit.INSTANCE;
            this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "prepareWithCurrent, roomId " + j3 + " success");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.mobileqq.icgame.room.player.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pause(@Nullable String url) {
        long j3;
        Long longOrNull;
        if (url != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "pause, roomId " + j3);
        ILiveTPPlayerRoom c16 = c(j3);
        if (c16 != null) {
            c16.pause();
            Unit unit = Unit.INSTANCE;
            this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "pause, roomId " + j3 + " success");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.mobileqq.icgame.room.player.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resume(@Nullable String url) {
        long j3;
        Long longOrNull;
        if (url != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "resume, roomId " + j3);
        ILiveTPPlayerRoom c16 = c(j3);
        if (c16 != null) {
            c16.play();
            Unit unit = Unit.INSTANCE;
            this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "resume, roomId " + j3 + " success");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.mobileqq.icgame.room.player.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void stop(@Nullable String url) {
        long j3;
        Long longOrNull;
        if (url != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "stop, roomId " + j3);
        ILiveTPPlayerRoom c16 = c(j3);
        if (c16 != null) {
            c16.pause();
            Unit unit = Unit.INSTANCE;
            this.mAegisLog.i("ICGameMiniSdkVideoPlayer", 1, "stop, roomId " + j3 + " success");
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.k
    public void setVideoRotation(int degree) {
    }
}
