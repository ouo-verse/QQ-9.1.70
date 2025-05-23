package com.tencent.icgame.game.liveroom.impl.room.definition;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/definition/a;", "", "", "toString", "", "checkBufferTime", "I", "a", "()I", "setCheckBufferTime", "(I)V", "notifySwitchTime", "c", "setNotifySwitchTime", "tipsShowTime", "d", "setTipsShowTime", "maxDayShowCount", "b", "setMaxDayShowCount", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("check_download_buffer_time")
    private int checkBufferTime = 5000;

    @SerializedName("notify_switch_definition_time")
    private int notifySwitchTime = 1800000;

    @SerializedName("definition_tips_show_time")
    private int tipsShowTime = 7000;

    @SerializedName("max_day_show_count")
    private int maxDayShowCount = 3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/definition/a$a;", "", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/a;", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.definition.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return new a();
        }

        Companion() {
        }
    }

    /* renamed from: a, reason: from getter */
    public final int getCheckBufferTime() {
        return this.checkBufferTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxDayShowCount() {
        return this.maxDayShowCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getNotifySwitchTime() {
        return this.notifySwitchTime;
    }

    /* renamed from: d, reason: from getter */
    public final int getTipsShowTime() {
        return this.tipsShowTime;
    }

    @NotNull
    public String toString() {
        return "DefinitionNotifyTipsConfig{checkBufferTime=" + this.checkBufferTime + ", notifySwitchTime=" + this.notifySwitchTime + ", tipsShowTime=" + this.tipsShowTime + ", maxDayShowCount=" + this.maxDayShowCount + "}";
    }
}
