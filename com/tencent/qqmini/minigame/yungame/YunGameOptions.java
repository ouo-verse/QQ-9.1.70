package com.tencent.qqmini.minigame.yungame;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqmini/minigame/yungame/c;", "a", "Lcom/tencent/qqmini/minigame/yungame/c;", "()Lcom/tencent/qqmini/minigame/yungame/c;", "gameInfo", "Lcom/tencent/qqmini/minigame/yungame/a;", "b", "Lcom/tencent/qqmini/minigame/yungame/a;", "getCoverConfig", "()Lcom/tencent/qqmini/minigame/yungame/a;", "coverConfig", "<init>", "(Lcom/tencent/qqmini/minigame/yungame/c;Lcom/tencent/qqmini/minigame/yungame/a;)V", "c", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.minigame.yungame.e, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class YunGameOptions {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final YunGameInfo gameInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final CoverConfig coverConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/e$a;", "", "Lorg/json/JSONObject;", "jsonObj", "Lcom/tencent/qqmini/minigame/yungame/e;", "a", "", "GAME_INFO_OBJ", "Ljava/lang/String;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.yungame.e$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final YunGameOptions a(@NotNull JSONObject jsonObj) {
            YunGameInfo yunGameInfo;
            CoverConfig coverConfig;
            Intrinsics.checkParameterIsNotNull(jsonObj, "jsonObj");
            JSONObject optJSONObject = jsonObj.optJSONObject("gameInfo");
            JSONObject optJSONObject2 = jsonObj.optJSONObject("coverConfig");
            if (optJSONObject != null) {
                yunGameInfo = new YunGameInfo(optJSONObject.optString(VirtualAppProxy.KEY_GAME_ID), optJSONObject.optString("gameName"), optJSONObject.optString("gameData"), optJSONObject.optLong("gameTimeout", 3000L));
            } else {
                yunGameInfo = new YunGameInfo(null, null, null, 0L, 15, null);
            }
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("backgroundSrc");
                Intrinsics.checkExpressionValueIsNotNull(optString, "coverConfigObj.optString(\"backgroundSrc\")");
                String optString2 = optJSONObject2.optString("jumpGuildUrl");
                Intrinsics.checkExpressionValueIsNotNull(optString2, "coverConfigObj.optString(\"jumpGuildUrl\")");
                String optString3 = optJSONObject2.optString("pagUrl");
                Intrinsics.checkExpressionValueIsNotNull(optString3, "coverConfigObj.optString(\"pagUrl\")");
                coverConfig = new CoverConfig(optString, optString2, optString3);
            } else {
                coverConfig = null;
            }
            return new YunGameOptions(yunGameInfo, coverConfig);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public YunGameOptions(@NotNull YunGameInfo gameInfo, @Nullable CoverConfig coverConfig) {
        Intrinsics.checkParameterIsNotNull(gameInfo, "gameInfo");
        this.gameInfo = gameInfo;
        this.coverConfig = coverConfig;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final YunGameInfo getGameInfo() {
        return this.gameInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof YunGameOptions) {
                YunGameOptions yunGameOptions = (YunGameOptions) other;
                if (!Intrinsics.areEqual(this.gameInfo, yunGameOptions.gameInfo) || !Intrinsics.areEqual(this.coverConfig, yunGameOptions.coverConfig)) {
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
        YunGameInfo yunGameInfo = this.gameInfo;
        int i16 = 0;
        if (yunGameInfo != null) {
            i3 = yunGameInfo.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        CoverConfig coverConfig = this.coverConfig;
        if (coverConfig != null) {
            i16 = coverConfig.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "YunGameOptions(gameInfo=" + this.gameInfo + ", coverConfig=" + this.coverConfig + ")";
    }
}
