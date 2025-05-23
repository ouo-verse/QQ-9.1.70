package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000f*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptLoader;", "", "()V", "ENGINE_SCRIPT_MAIN_NAME", "", "ENGINE_SCRIPT_OPEN_DATA_NAME", "ENGINE_SCRIPT_WORKER_NAME", "GAME_MAIN_ENTRY_SCRIPT", "GAME_OPEN_DATA_ENTRY_SCRIPT", "GAME_PLUGIN_ENTRY_SCRIPT", "GAME_SUB_PACKAGE_ENTRY_SCRIPT", "GAME_WORKER_ENTRY_SCRIPT", "getEngineScripts", "", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getGameScripts", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getSubPackageScripts", "subPackageScriptPackage", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "getScriptOrNull", "name", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptLoader {

    @NotNull
    public static final String ENGINE_SCRIPT_MAIN_NAME = "QGameAndroid.js";

    @NotNull
    public static final String ENGINE_SCRIPT_OPEN_DATA_NAME = "QGameOpenDataContext.js";

    @NotNull
    public static final String ENGINE_SCRIPT_WORKER_NAME = "QGameWorkerContext.js";

    @NotNull
    public static final String GAME_MAIN_ENTRY_SCRIPT = "game.js";

    @NotNull
    public static final String GAME_OPEN_DATA_ENTRY_SCRIPT = "subContext.js";

    @NotNull
    public static final String GAME_PLUGIN_ENTRY_SCRIPT = "plugin.js";

    @NotNull
    public static final String GAME_SUB_PACKAGE_ENTRY_SCRIPT = "game.js";

    @NotNull
    public static final String GAME_WORKER_ENTRY_SCRIPT = "workers.js";
    public static final ScriptLoader INSTANCE = new ScriptLoader();

    ScriptLoader() {
    }

    private final ScriptFile getScriptOrNull(@NotNull ScriptPackage scriptPackage, String str) {
        try {
            ScriptFile script = scriptPackage.getScript(str);
            if (!script.getValid()) {
                return null;
            }
            return script;
        } catch (TritonException unused) {
            return null;
        }
    }

    @NotNull
    public final Map<ScriptContextType, ScriptFile> getEngineScripts(@NotNull EnginePackage enginePackage) throws TritonException {
        Map<ScriptContextType, ScriptFile> mapOf;
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ScriptContextType.MAIN, enginePackage.getScript(ENGINE_SCRIPT_MAIN_NAME)), TuplesKt.to(ScriptContextType.OPEN_DATA, enginePackage.getScript(ENGINE_SCRIPT_OPEN_DATA_NAME)), TuplesKt.to(ScriptContextType.WORKER, enginePackage.getScript(ENGINE_SCRIPT_WORKER_NAME)));
        return mapOf;
    }

    @NotNull
    public final Map<ScriptContextType, ScriptFile> getGameScripts(@NotNull GamePackage gamePackage) throws TritonException {
        Map<ScriptContextType, ScriptFile> mapOf;
        Intrinsics.checkParameterIsNotNull(gamePackage, "gamePackage");
        Pair[] pairArr = new Pair[3];
        ScriptContextType scriptContextType = ScriptContextType.MAIN;
        ScriptFile script = gamePackage.getScript("game.js");
        if (script.getValid()) {
            pairArr[0] = TuplesKt.to(scriptContextType, script);
            pairArr[1] = TuplesKt.to(ScriptContextType.OPEN_DATA, getScriptOrNull(gamePackage, GAME_OPEN_DATA_ENTRY_SCRIPT));
            pairArr[2] = TuplesKt.to(ScriptContextType.WORKER, getScriptOrNull(gamePackage, GAME_WORKER_ENTRY_SCRIPT));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            return mapOf;
        }
        throw new TritonException("GamePackage don't have valid game.js", ErrorCodes.SCRIPT_LOAD_FAIL, null, 4, null);
    }

    @NotNull
    public final Map<ScriptContextType, ScriptFile> getSubPackageScripts(@NotNull ScriptPackage subPackageScriptPackage) throws TritonException {
        Map<ScriptContextType, ScriptFile> mapOf;
        Intrinsics.checkParameterIsNotNull(subPackageScriptPackage, "subPackageScriptPackage");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(ScriptContextType.MAIN, getScriptOrNull(subPackageScriptPackage, "game.js")));
        return mapOf;
    }
}
