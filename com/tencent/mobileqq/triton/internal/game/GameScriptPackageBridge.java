package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = false, allMethods = true, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/game/GameScriptPackageBridge;", "", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;)V", "getPluginScript", "", "", "pluginName", "(Ljava/lang/String;)[Ljava/lang/String;", "getScript", "name", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class GameScriptPackageBridge {
    private final GamePackage gamePackage;

    public GameScriptPackageBridge(@NotNull GamePackage gamePackage) {
        Intrinsics.checkParameterIsNotNull(gamePackage, "gamePackage");
        this.gamePackage = gamePackage;
    }

    @Nullable
    public final String[] getPluginScript(@NotNull String pluginName) {
        Object obj;
        String[] nativeType;
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        try {
            Iterator<T> it = this.gamePackage.getPlugins().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((GamePluginPackage) obj).getName(), pluginName)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            GamePluginPackage gamePluginPackage = (GamePluginPackage) obj;
            if (gamePluginPackage != null) {
                nativeType = ScriptPackageBridgesKt.toNativeType(gamePluginPackage.getScript("plugin.js"), gamePluginPackage.getId());
                return nativeType;
            }
            return null;
        } catch (TritonException unused) {
            return null;
        }
    }

    @Nullable
    public final String[] getScript(@NotNull String name) {
        String[] nativeType;
        Intrinsics.checkParameterIsNotNull(name, "name");
        try {
            nativeType = ScriptPackageBridgesKt.toNativeType(this.gamePackage.getScript(name), null);
            return nativeType;
        } catch (TritonException unused) {
            return null;
        }
    }
}
