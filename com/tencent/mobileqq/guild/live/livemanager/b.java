package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/b;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/b$a;", "", "", "isSupportFlv", "Lcom/tencent/mobileqq/qqlive/api/room/PlayerConfig;", "a", "", "REFERER", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.livemanager.b$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PlayerConfig a(boolean isSupportFlv) {
            PlayerConfig playerConfig = new PlayerConfig();
            boolean b16 = com.tencent.mobileqq.guild.live.config.a.b();
            Logger.f235387a.d().i("QGL.GLiveSdkPlayerConfig.", 1, "useTextureView:" + b16);
            playerConfig.isUseTextureView = b16;
            playerConfig.isZOrderMediaOverlay = true;
            playerConfig.latencyStrategy = AudienceRoomConfig.LiveLatencyStrategy.SPEED_UP;
            if (isSupportFlv) {
                playerConfig.format = AudienceRoomConfig.VideoFormat.FLV;
            } else {
                playerConfig.format = AudienceRoomConfig.VideoFormat.RTMP;
            }
            playerConfig.speedUpRate = 1.2f;
            playerConfig.playerSceneID = 125;
            HashMap hashMap = new HashMap();
            hashMap.put("Referer", "https://qun.qq.com");
            playerConfig.httpHeader = hashMap;
            return playerConfig;
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final PlayerConfig a(boolean z16) {
        return INSTANCE.a(z16);
    }
}
