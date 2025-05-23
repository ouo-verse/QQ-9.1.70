package com.tencent.mobileqq.vas.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\t\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getGameInfo", "", "troopUin", "", "uin", "callback", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$ResultCallback;", "GameInfo", "ResultCallback", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ITroopGameInfo extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$GameInfo;", "", "gradeLevel", "", "gameCardSwitch", "", "(IZ)V", "getGameCardSwitch", "()Z", "getGradeLevel", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final /* data */ class GameInfo {
        private final boolean gameCardSwitch;
        private final int gradeLevel;

        public GameInfo(int i3, boolean z16) {
            this.gradeLevel = i3;
            this.gameCardSwitch = z16;
        }

        public static /* synthetic */ GameInfo copy$default(GameInfo gameInfo, int i3, boolean z16, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = gameInfo.gradeLevel;
            }
            if ((i16 & 2) != 0) {
                z16 = gameInfo.gameCardSwitch;
            }
            return gameInfo.copy(i3, z16);
        }

        /* renamed from: component1, reason: from getter */
        public final int getGradeLevel() {
            return this.gradeLevel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getGameCardSwitch() {
            return this.gameCardSwitch;
        }

        @NotNull
        public final GameInfo copy(int gradeLevel, boolean gameCardSwitch) {
            return new GameInfo(gradeLevel, gameCardSwitch);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GameInfo)) {
                return false;
            }
            GameInfo gameInfo = (GameInfo) other;
            if (this.gradeLevel == gameInfo.gradeLevel && this.gameCardSwitch == gameInfo.gameCardSwitch) {
                return true;
            }
            return false;
        }

        public final boolean getGameCardSwitch() {
            return this.gameCardSwitch;
        }

        public final int getGradeLevel() {
            return this.gradeLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.gradeLevel * 31;
            boolean z16 = this.gameCardSwitch;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "GameInfo(gradeLevel=" + this.gradeLevel + ", gameCardSwitch=" + this.gameCardSwitch + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$ResultCallback;", "", "onGetASync", "", "info", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$GameInfo;", "onGetSync", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface ResultCallback {
        void onGetASync(@NotNull GameInfo info);

        void onGetSync(@NotNull GameInfo info);
    }

    void getGameInfo(@NotNull String troopUin, @NotNull String uin, @NotNull ResultCallback callback);
}
