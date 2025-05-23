package com.tencent.qqmini.minigame.yungame;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getCallbackId", "()I", "setCallbackId", "(I)V", "callbackId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", VirtualAppProxy.KEY_GAME_ID, "c", "getGameName", "setGameName", "gameName", "d", "getGameData", "setGameData", "gameData", "", "e", "J", "getGameTimeout", "()J", "setGameTimeout", "(J)V", "gameTimeout", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.minigame.yungame.c, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class YunGameInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int callbackId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String gameId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String gameName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String gameData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long gameTimeout;

    public YunGameInfo() {
        this(null, null, null, 0L, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getGameId() {
        return this.gameId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof YunGameInfo) {
                YunGameInfo yunGameInfo = (YunGameInfo) other;
                if (!Intrinsics.areEqual(this.gameId, yunGameInfo.gameId) || !Intrinsics.areEqual(this.gameName, yunGameInfo.gameName) || !Intrinsics.areEqual(this.gameData, yunGameInfo.gameData) || this.gameTimeout != yunGameInfo.gameTimeout) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.gameId;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.gameName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.gameData;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        int i26 = (i19 + i17) * 31;
        long j3 = this.gameTimeout;
        return i26 + ((int) (j3 ^ (j3 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "YunGameInfo(gameId=" + this.gameId + ", gameName=" + this.gameName + ", gameData=" + this.gameData + ", gameTimeout=" + this.gameTimeout + ")";
    }

    public YunGameInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, long j3) {
        this.gameId = str;
        this.gameName = str2;
        this.gameData = str3;
        this.gameTimeout = j3;
        this.callbackId = -1;
    }

    public /* synthetic */ YunGameInfo(String str, String str2, String str3, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) == 0 ? str3 : null, (i3 & 8) != 0 ? 3000L : j3);
    }
}
