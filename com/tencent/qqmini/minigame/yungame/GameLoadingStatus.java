package com.tencent.qqmini.minigame.yungame;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B!\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/GameLoadingStatus;", "", "", "isFinish", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "I", "getStatusCode", "()I", "", "statusName", "Ljava/lang/String;", "getStatusName", "()Ljava/lang/String;", "statusDesc", "getStatusDesc", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "Hotpatch_Begin", "Hotpatch_Progress", "Hotpatch_Success", "Hotpatch_Failed", "Resload_Start", "Resload_Success", "Resload_Timeout", "Login_Begin", "Login_Success", "Login_Failed", "SceneRes_Load_Start", "SceneRes_Load_Progress", "SceneRes_Load_Success", "SceneRes_Load_Timeout", "Guide_Finished_When_EnterFarm", "Guide_Not_Finished_When_EnterFarm", "Guide_On_Fram_Guide_Finished", "Main_Progress", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public enum GameLoadingStatus {
    Hotpatch_Begin(1001, "Hotpatch_Begin", "\u70ed\u66f4\u5f00\u59cb"),
    Hotpatch_Progress(1002, "Hotpatch_Progress", "\u70ed\u66f4\u8fc7\u7a0b"),
    Hotpatch_Success(1003, "Hotpatch_Success", "\u70ed\u66f4\u7ed3\u675f"),
    Hotpatch_Failed(1004, "Hotpatch_Failed", "\u70ed\u66f4\u5931\u8d25"),
    Resload_Start(1005, "Resload_Start", "\u8d44\u6e90\u52a0\u8f7d\u5f00\u59cb"),
    Resload_Success(1006, "Resload_Success", "\u8d44\u6e90\u52a0\u8f7d\u6210\u529f"),
    Resload_Timeout(1007, "Resload_Timeout", "\u8d44\u6e90\u52a0\u8f7d\u8d85\u65f6"),
    Login_Begin(1008, "Login_Begin", "\u767b\u5f55\u5f00\u59cb"),
    Login_Success(1009, "Login_Success", "\u767b\u5f55\u5b8c\u6210"),
    Login_Failed(1010, "Login_Failed", "\u767b\u5f55\u5931\u8d25"),
    SceneRes_Load_Start(1011, "SceneRes_Load_Start", "\u573a\u666f\u52a0\u8f7d\u5f00\u59cb"),
    SceneRes_Load_Progress(1012, "SceneRes_Load_Progress", "\u573a\u666f\u52a0\u8f7d\u4e2d"),
    SceneRes_Load_Success(1013, "SceneRes_Load_Success", "\u573a\u666f\u52a0\u8f7d\u5b8c\u6210"),
    SceneRes_Load_Timeout(1014, "SceneRes_Load_Timeout", "\u573a\u666f\u52a0\u8f7d\u8d85\u65f6"),
    Guide_Finished_When_EnterFarm(1015, "Guide_Finished_When_EnterFarm", "\u8fdb\u519c\u573a\u65f6\u5f15\u5bfc\u5df2\u5b8c\u6210"),
    Guide_Not_Finished_When_EnterFarm(1016, "Guide_Not_Finished_When_EnterFarm", "\u8fdb\u519c\u573a\u65f6\u5f15\u5bfc\u672a\u5b8c\u6210"),
    Guide_On_Fram_Guide_Finished(1017, "Guide_On_Fram_Guide_Finished", "\u5b8c\u6210\u519c\u573a\u5f15\u5bfc\u65f6"),
    Main_Progress(1018, "Main_Progress", "\u4e3b\u8fdb\u5ea6\u6d88\u606f");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int statusCode;

    @NotNull
    private final String statusDesc;

    @NotNull
    private final String statusName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/GameLoadingStatus$a;", "", "", "statusName", "Lcom/tencent/qqmini/minigame/yungame/GameLoadingStatus;", "a", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.yungame.GameLoadingStatus$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final GameLoadingStatus a(@NotNull String statusName) {
            Intrinsics.checkParameterIsNotNull(statusName, "statusName");
            for (GameLoadingStatus gameLoadingStatus : GameLoadingStatus.values()) {
                if (Intrinsics.areEqual(gameLoadingStatus.getStatusName(), statusName)) {
                    return gameLoadingStatus;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    GameLoadingStatus(int i3, String str, String str2) {
        this.statusCode = i3;
        this.statusName = str;
        this.statusDesc = str2;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @NotNull
    public final String getStatusDesc() {
        return this.statusDesc;
    }

    @NotNull
    public final String getStatusName() {
        return this.statusName;
    }

    public final boolean isFinish() {
        if (this != Hotpatch_Failed && this != Resload_Timeout && this != Login_Failed && this != SceneRes_Load_Timeout) {
            return false;
        }
        return true;
    }
}
