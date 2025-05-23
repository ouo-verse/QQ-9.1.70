package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = false, allMethods = true, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/game/EngineScriptPackageBridge;", "", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;)V", "getScript", "", "", "name", "(Ljava/lang/String;)[Ljava/lang/String;", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineScriptPackageBridge {
    private final ScriptPackage enginePackage;

    public EngineScriptPackageBridge(@NotNull ScriptPackage enginePackage) {
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        this.enginePackage = enginePackage;
    }

    @Nullable
    public final String[] getScript(@NotNull String name) {
        String[] nativeType;
        Intrinsics.checkParameterIsNotNull(name, "name");
        try {
            nativeType = ScriptPackageBridgesKt.toNativeType(this.enginePackage.getScript(name), null);
            return nativeType;
        } catch (TritonException unused) {
            return null;
        }
    }
}
