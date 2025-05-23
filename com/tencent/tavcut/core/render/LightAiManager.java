package com.tencent.tavcut.core.render;

import com.tencent.tavcut.core.render.log.TavLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.MovieConfig;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/tavcut/core/render/LightAiManager;", "", "()V", "SHORT_EDGE_LENGTH", "", "agentLevel", "Ljava/util/concurrent/ConcurrentHashMap;", "", "agentPath", "clearAiPath", "", "hasAiPathRegistered", "", "agent", "path", "registerAiPath", "level", "setup3DAgentPath", "movieConfig", "Lorg/light/MovieConfig;", "setupAgentPath", "setupMovieConfig", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightAiManager {
    private static final int SHORT_EDGE_LENGTH = 180;
    public static final LightAiManager INSTANCE = new LightAiManager();
    private static final ConcurrentHashMap<String, String> agentPath = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> agentLevel = new ConcurrentHashMap<>();

    LightAiManager() {
    }

    public final void clearAiPath() {
        agentPath.clear();
    }

    public final boolean hasAiPathRegistered(@NotNull String agent, @NotNull String path) {
        Intrinsics.checkParameterIsNotNull(agent, "agent");
        Intrinsics.checkParameterIsNotNull(path, "path");
        return Intrinsics.areEqual(agentPath.get(agent), path);
    }

    public final void registerAiPath(@NotNull String agent, @NotNull String path) {
        Intrinsics.checkParameterIsNotNull(agent, "agent");
        Intrinsics.checkParameterIsNotNull(path, "path");
        agentPath.put(agent, path);
    }

    public final void setup3DAgentPath(@Nullable MovieConfig movieConfig) {
        for (Map.Entry<String, String> entry : agentPath.entrySet()) {
            TavLogger.d(LightAiManagerKt.TAG, "setup3DAgentPath ai path set agentName: " + entry.getKey() + " agentPath: " + entry.getValue());
            if (Intrinsics.areEqual("Ace_3d_Engine", entry.getKey())) {
                ConcurrentHashMap<String, String> concurrentHashMap = agentLevel;
                if (concurrentHashMap.containsKey(entry.getKey())) {
                    if (movieConfig != null) {
                        movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey(), concurrentHashMap.get(entry.getKey()));
                    }
                } else if (movieConfig != null) {
                    movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey());
                }
            }
        }
    }

    public final void setupAgentPath(@Nullable MovieConfig movieConfig) {
        for (Map.Entry<String, String> entry : agentPath.entrySet()) {
            TavLogger.d(LightAiManagerKt.TAG, "ai path set agentName: " + entry.getKey() + " agentPath: " + entry.getValue());
            ConcurrentHashMap<String, String> concurrentHashMap = agentLevel;
            if (concurrentHashMap.containsKey(entry.getKey())) {
                if (movieConfig != null) {
                    movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey(), concurrentHashMap.get(entry.getKey()));
                }
            } else if (movieConfig != null) {
                movieConfig.setLightAIModelPath(entry.getValue(), entry.getKey());
            }
        }
    }

    public final void setupMovieConfig(@NotNull MovieConfig movieConfig) {
        Intrinsics.checkParameterIsNotNull(movieConfig, "movieConfig");
        movieConfig.setSyncMode(true);
        movieConfig.setDetectShorterEdgeLength(180, "");
        movieConfig.setBGMusicHidden(false);
    }

    public final void registerAiPath(@NotNull String agent, @NotNull String path, @NotNull String level) {
        Intrinsics.checkParameterIsNotNull(agent, "agent");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(level, "level");
        agentPath.put(agent, path);
        agentLevel.put(agent, level);
    }
}
