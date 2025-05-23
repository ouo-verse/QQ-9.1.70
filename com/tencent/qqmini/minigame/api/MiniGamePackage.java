package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0096\u0001R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u000bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniGamePackage;", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "gamePackage", "webgl2Config", "", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;Z)V", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "getEnvironment", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "gameConfig", "", "getGameConfig", "()Ljava/lang/String;", "id", "getId", "name", "getName", "optionConfig", "", "", "getOptionConfig", "()Ljava/util/Map;", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "getOrientation", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "getPlugins", "()Ljava/util/List;", "version", "getVersion", "getWebgl2Config", "()Z", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "getSubpackage", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MiniGamePackage implements GamePackage {
    private final /* synthetic */ GamePackage $$delegate_0;
    private final boolean webgl2Config;

    public MiniGamePackage(@NotNull GamePackage gamePackage, boolean z16) {
        Intrinsics.checkParameterIsNotNull(gamePackage, "gamePackage");
        this.$$delegate_0 = gamePackage;
        this.webgl2Config = z16;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public GamePackage.Environment getEnvironment() {
        return this.$$delegate_0.getEnvironment();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public String getGameConfig() {
        return this.$$delegate_0.getGameConfig();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public String getId() {
        return this.$$delegate_0.getId();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public String getName() {
        return this.$$delegate_0.getName();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public Map<String, Object> getOptionConfig() {
        return this.$$delegate_0.getOptionConfig();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public GamePackage.Orientation getOrientation() {
        return this.$$delegate_0.getOrientation();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public List<GamePluginPackage> getPlugins() {
        return this.$$delegate_0.getPlugins();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
    @NotNull
    public ScriptFile getScript(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return this.$$delegate_0.getScript(name);
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    public void getSubpackage(@NotNull String name, @NotNull GamePackage.SubpackageListener callback) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.$$delegate_0.getSubpackage(name, callback);
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
    @NotNull
    public String getVersion() {
        return this.$$delegate_0.getVersion();
    }

    public final boolean getWebgl2Config() {
        return this.webgl2Config;
    }

    public /* synthetic */ MiniGamePackage(GamePackage gamePackage, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(gamePackage, (i3 & 2) != 0 ? false : z16);
    }
}
