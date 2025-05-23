package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0012J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\u0019\u0010%\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\rH\u00c6\u0003J\t\u0010&\u001a\u00020\u0010H\u00c6\u0003J\t\u0010'\u001a\u00020\u0010H\u00c6\u0003Jk\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\t\u0010-\u001a\u00020.H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "jankTraceLevel", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "userData", "", "Ljava/lang/Class;", "isMute", "", "isWebgl2Enable", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;Lcom/tencent/mobileqq/triton/view/GameView;Lcom/tencent/mobileqq/triton/script/InspectorAgent;Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;Ljava/util/Map;ZZ)V", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "()Z", "getJankTraceLevel", "()Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "getUserData", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class GameLaunchParam {

    @NotNull
    private final GameDataFileSystem dataFileSystem;

    @NotNull
    private final GamePackage gamePackage;

    @NotNull
    private final GameView gameView;

    @Nullable
    private final InspectorAgent inspectorAgent;
    private final boolean isMute;
    private final boolean isWebgl2Enable;

    @NotNull
    private final JankTraceLevel jankTraceLevel;

    @NotNull
    private final Map<Class<?>, Object> userData;

    public GameLaunchParam(@NotNull GamePackage gamePackage, @NotNull GameDataFileSystem dataFileSystem, @NotNull GameView gameView, @Nullable InspectorAgent inspectorAgent, @NotNull JankTraceLevel jankTraceLevel, @NotNull Map<Class<?>, ? extends Object> userData, boolean z16, boolean z17) {
        Intrinsics.checkParameterIsNotNull(gamePackage, "gamePackage");
        Intrinsics.checkParameterIsNotNull(dataFileSystem, "dataFileSystem");
        Intrinsics.checkParameterIsNotNull(gameView, "gameView");
        Intrinsics.checkParameterIsNotNull(jankTraceLevel, "jankTraceLevel");
        Intrinsics.checkParameterIsNotNull(userData, "userData");
        this.gamePackage = gamePackage;
        this.dataFileSystem = dataFileSystem;
        this.gameView = gameView;
        this.inspectorAgent = inspectorAgent;
        this.jankTraceLevel = jankTraceLevel;
        this.userData = userData;
        this.isMute = z16;
        this.isWebgl2Enable = z17;
    }

    public static /* synthetic */ GameLaunchParam copy$default(GameLaunchParam gameLaunchParam, GamePackage gamePackage, GameDataFileSystem gameDataFileSystem, GameView gameView, InspectorAgent inspectorAgent, JankTraceLevel jankTraceLevel, Map map, boolean z16, boolean z17, int i3, Object obj) {
        GamePackage gamePackage2;
        GameDataFileSystem gameDataFileSystem2;
        GameView gameView2;
        InspectorAgent inspectorAgent2;
        JankTraceLevel jankTraceLevel2;
        Map map2;
        boolean z18;
        boolean z19;
        if ((i3 & 1) != 0) {
            gamePackage2 = gameLaunchParam.gamePackage;
        } else {
            gamePackage2 = gamePackage;
        }
        if ((i3 & 2) != 0) {
            gameDataFileSystem2 = gameLaunchParam.dataFileSystem;
        } else {
            gameDataFileSystem2 = gameDataFileSystem;
        }
        if ((i3 & 4) != 0) {
            gameView2 = gameLaunchParam.gameView;
        } else {
            gameView2 = gameView;
        }
        if ((i3 & 8) != 0) {
            inspectorAgent2 = gameLaunchParam.inspectorAgent;
        } else {
            inspectorAgent2 = inspectorAgent;
        }
        if ((i3 & 16) != 0) {
            jankTraceLevel2 = gameLaunchParam.jankTraceLevel;
        } else {
            jankTraceLevel2 = jankTraceLevel;
        }
        if ((i3 & 32) != 0) {
            map2 = gameLaunchParam.userData;
        } else {
            map2 = map;
        }
        if ((i3 & 64) != 0) {
            z18 = gameLaunchParam.isMute;
        } else {
            z18 = z16;
        }
        if ((i3 & 128) != 0) {
            z19 = gameLaunchParam.isWebgl2Enable;
        } else {
            z19 = z17;
        }
        return gameLaunchParam.copy(gamePackage2, gameDataFileSystem2, gameView2, inspectorAgent2, jankTraceLevel2, map2, z18, z19);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final GamePackage getGamePackage() {
        return this.gamePackage;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final GameDataFileSystem getDataFileSystem() {
        return this.dataFileSystem;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final GameView getGameView() {
        return this.gameView;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final InspectorAgent getInspectorAgent() {
        return this.inspectorAgent;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final JankTraceLevel getJankTraceLevel() {
        return this.jankTraceLevel;
    }

    @NotNull
    public final Map<Class<?>, Object> component6() {
        return this.userData;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsMute() {
        return this.isMute;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsWebgl2Enable() {
        return this.isWebgl2Enable;
    }

    @NotNull
    public final GameLaunchParam copy(@NotNull GamePackage gamePackage, @NotNull GameDataFileSystem dataFileSystem, @NotNull GameView gameView, @Nullable InspectorAgent inspectorAgent, @NotNull JankTraceLevel jankTraceLevel, @NotNull Map<Class<?>, ? extends Object> userData, boolean isMute, boolean isWebgl2Enable) {
        Intrinsics.checkParameterIsNotNull(gamePackage, "gamePackage");
        Intrinsics.checkParameterIsNotNull(dataFileSystem, "dataFileSystem");
        Intrinsics.checkParameterIsNotNull(gameView, "gameView");
        Intrinsics.checkParameterIsNotNull(jankTraceLevel, "jankTraceLevel");
        Intrinsics.checkParameterIsNotNull(userData, "userData");
        return new GameLaunchParam(gamePackage, dataFileSystem, gameView, inspectorAgent, jankTraceLevel, userData, isMute, isWebgl2Enable);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GameLaunchParam) {
                GameLaunchParam gameLaunchParam = (GameLaunchParam) other;
                if (!Intrinsics.areEqual(this.gamePackage, gameLaunchParam.gamePackage) || !Intrinsics.areEqual(this.dataFileSystem, gameLaunchParam.dataFileSystem) || !Intrinsics.areEqual(this.gameView, gameLaunchParam.gameView) || !Intrinsics.areEqual(this.inspectorAgent, gameLaunchParam.inspectorAgent) || !Intrinsics.areEqual(this.jankTraceLevel, gameLaunchParam.jankTraceLevel) || !Intrinsics.areEqual(this.userData, gameLaunchParam.userData) || this.isMute != gameLaunchParam.isMute || this.isWebgl2Enable != gameLaunchParam.isWebgl2Enable) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final GameDataFileSystem getDataFileSystem() {
        return this.dataFileSystem;
    }

    @NotNull
    public final GamePackage getGamePackage() {
        return this.gamePackage;
    }

    @NotNull
    public final GameView getGameView() {
        return this.gameView;
    }

    @Nullable
    public final InspectorAgent getInspectorAgent() {
        return this.inspectorAgent;
    }

    @NotNull
    public final JankTraceLevel getJankTraceLevel() {
        return this.jankTraceLevel;
    }

    @NotNull
    public final Map<Class<?>, Object> getUserData() {
        return this.userData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        GamePackage gamePackage = this.gamePackage;
        int i26 = 0;
        if (gamePackage != null) {
            i3 = gamePackage.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        GameDataFileSystem gameDataFileSystem = this.dataFileSystem;
        if (gameDataFileSystem != null) {
            i16 = gameDataFileSystem.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        GameView gameView = this.gameView;
        if (gameView != null) {
            i17 = gameView.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        InspectorAgent inspectorAgent = this.inspectorAgent;
        if (inspectorAgent != null) {
            i18 = inspectorAgent.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        JankTraceLevel jankTraceLevel = this.jankTraceLevel;
        if (jankTraceLevel != null) {
            i19 = jankTraceLevel.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        Map<Class<?>, Object> map = this.userData;
        if (map != null) {
            i26 = map.hashCode();
        }
        int i38 = (i37 + i26) * 31;
        boolean z16 = this.isMute;
        int i39 = 1;
        int i46 = z16;
        if (z16 != 0) {
            i46 = 1;
        }
        int i47 = (i38 + i46) * 31;
        boolean z17 = this.isWebgl2Enable;
        if (!z17) {
            i39 = z17 ? 1 : 0;
        }
        return i47 + i39;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public final boolean isWebgl2Enable() {
        return this.isWebgl2Enable;
    }

    @NotNull
    public String toString() {
        return "GameLaunchParam(gamePackage=" + this.gamePackage + ", dataFileSystem=" + this.dataFileSystem + ", gameView=" + this.gameView + ", inspectorAgent=" + this.inspectorAgent + ", jankTraceLevel=" + this.jankTraceLevel + ", userData=" + this.userData + ", isMute=" + this.isMute + ", isWebgl2Enable=" + this.isWebgl2Enable + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GameLaunchParam(GamePackage gamePackage, GameDataFileSystem gameDataFileSystem, GameView gameView, InspectorAgent inspectorAgent, JankTraceLevel jankTraceLevel, Map map, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(gamePackage, gameDataFileSystem, gameView, r6, r7, r8, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? false : z17);
        Map map2;
        Map emptyMap;
        InspectorAgent inspectorAgent2 = (i3 & 8) != 0 ? null : inspectorAgent;
        JankTraceLevel jankTraceLevel2 = (i3 & 16) != 0 ? JankTraceLevel.NONE : jankTraceLevel;
        if ((i3 & 32) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
    }
}
