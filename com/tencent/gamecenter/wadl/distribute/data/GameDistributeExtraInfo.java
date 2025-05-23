package com.tencent.gamecenter.wadl.distribute.data;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B7\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003JE\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\f\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u000f\u0010\u001eR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b \u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeExtraInfo;", "Ljava/io/Serializable;", "", "toString", "", "component1", "component2", "component3", "", "component4", "component5", "component6", "isFromGameCenter", "attaReportData", "gameChannelId", "isSupportSpark", "sparkTaskKey", QQBrowserActivity.APP_PARAM, "copy", "hashCode", "", "other", "equals", "Z", "()Z", "Ljava/lang/String;", "getAttaReportData", "()Ljava/lang/String;", "getGameChannelId", "I", "()I", "getSparkTaskKey", "getExtraParams", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final /* data */ class GameDistributeExtraInfo implements Serializable {

    @NotNull
    public static final String EXTRA_KEY = "gamecenter_game_distribute_extra_info";

    @NotNull
    private final String attaReportData;

    @NotNull
    private final String extraParams;

    @NotNull
    private final String gameChannelId;
    private final boolean isFromGameCenter;
    private final int isSupportSpark;

    @NotNull
    private final String sparkTaskKey;

    public GameDistributeExtraInfo(boolean z16, @NotNull String attaReportData, @NotNull String gameChannelId, int i3, @NotNull String sparkTaskKey, @NotNull String extraParams) {
        Intrinsics.checkNotNullParameter(attaReportData, "attaReportData");
        Intrinsics.checkNotNullParameter(gameChannelId, "gameChannelId");
        Intrinsics.checkNotNullParameter(sparkTaskKey, "sparkTaskKey");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        this.isFromGameCenter = z16;
        this.attaReportData = attaReportData;
        this.gameChannelId = gameChannelId;
        this.isSupportSpark = i3;
        this.sparkTaskKey = sparkTaskKey;
        this.extraParams = extraParams;
    }

    public static /* synthetic */ GameDistributeExtraInfo copy$default(GameDistributeExtraInfo gameDistributeExtraInfo, boolean z16, String str, String str2, int i3, String str3, String str4, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = gameDistributeExtraInfo.isFromGameCenter;
        }
        if ((i16 & 2) != 0) {
            str = gameDistributeExtraInfo.attaReportData;
        }
        String str5 = str;
        if ((i16 & 4) != 0) {
            str2 = gameDistributeExtraInfo.gameChannelId;
        }
        String str6 = str2;
        if ((i16 & 8) != 0) {
            i3 = gameDistributeExtraInfo.isSupportSpark;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            str3 = gameDistributeExtraInfo.sparkTaskKey;
        }
        String str7 = str3;
        if ((i16 & 32) != 0) {
            str4 = gameDistributeExtraInfo.extraParams;
        }
        return gameDistributeExtraInfo.copy(z16, str5, str6, i17, str7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsFromGameCenter() {
        return this.isFromGameCenter;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAttaReportData() {
        return this.attaReportData;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getGameChannelId() {
        return this.gameChannelId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIsSupportSpark() {
        return this.isSupportSpark;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getSparkTaskKey() {
        return this.sparkTaskKey;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final GameDistributeExtraInfo copy(boolean isFromGameCenter, @NotNull String attaReportData, @NotNull String gameChannelId, int isSupportSpark, @NotNull String sparkTaskKey, @NotNull String extraParams) {
        Intrinsics.checkNotNullParameter(attaReportData, "attaReportData");
        Intrinsics.checkNotNullParameter(gameChannelId, "gameChannelId");
        Intrinsics.checkNotNullParameter(sparkTaskKey, "sparkTaskKey");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        return new GameDistributeExtraInfo(isFromGameCenter, attaReportData, gameChannelId, isSupportSpark, sparkTaskKey, extraParams);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameDistributeExtraInfo)) {
            return false;
        }
        GameDistributeExtraInfo gameDistributeExtraInfo = (GameDistributeExtraInfo) other;
        if (this.isFromGameCenter == gameDistributeExtraInfo.isFromGameCenter && Intrinsics.areEqual(this.attaReportData, gameDistributeExtraInfo.attaReportData) && Intrinsics.areEqual(this.gameChannelId, gameDistributeExtraInfo.gameChannelId) && this.isSupportSpark == gameDistributeExtraInfo.isSupportSpark && Intrinsics.areEqual(this.sparkTaskKey, gameDistributeExtraInfo.sparkTaskKey) && Intrinsics.areEqual(this.extraParams, gameDistributeExtraInfo.extraParams)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAttaReportData() {
        return this.attaReportData;
    }

    @NotNull
    public final String getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final String getGameChannelId() {
        return this.gameChannelId;
    }

    @NotNull
    public final String getSparkTaskKey() {
        return this.sparkTaskKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z16 = this.isFromGameCenter;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((r06 * 31) + this.attaReportData.hashCode()) * 31) + this.gameChannelId.hashCode()) * 31) + this.isSupportSpark) * 31) + this.sparkTaskKey.hashCode()) * 31) + this.extraParams.hashCode();
    }

    public final boolean isFromGameCenter() {
        return this.isFromGameCenter;
    }

    public final int isSupportSpark() {
        return this.isSupportSpark;
    }

    @NotNull
    public String toString() {
        return "GameDistributeExtraInfo(isFromGameCenter=" + this.isFromGameCenter + ")";
    }
}
