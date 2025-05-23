package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import io.github.landerlyoung.jenny.NativeClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeClass(namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/TTAppAgent;", "", "inspectorBridge", "Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "(Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;)V", "jankCanaryNativeInstance", "", "nativeInstance", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TTAppAgent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int WHAT_JANK_CANARY = 1;
    public static final int WHAT_SCRIPT_MANAGER = 2;
    private final long jankCanaryNativeInstance;
    private final long nativeInstance;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0087 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/TTAppAgent$Companion;", "", "()V", "WHAT_JANK_CANARY", "", "WHAT_SCRIPT_MANAGER", "nativeCreate", "", "inspectorBridge", "Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;", "nativeGetInstance", "nativeInstance", "what", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeCreate(InspectorBridge inspectorBridge) {
            return TTAppAgent.nativeCreate(inspectorBridge);
        }

        @JvmStatic
        public final long nativeGetInstance(long nativeInstance, int what) {
            return TTAppAgent.nativeGetInstance(nativeInstance, what);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TTAppAgent(@NotNull InspectorBridge inspectorBridge, @NotNull ScriptSystem scriptSystem) {
        Intrinsics.checkParameterIsNotNull(inspectorBridge, "inspectorBridge");
        Intrinsics.checkParameterIsNotNull(scriptSystem, "scriptSystem");
        Companion companion = INSTANCE;
        long nativeCreate = companion.nativeCreate(inspectorBridge);
        this.nativeInstance = nativeCreate;
        if (nativeCreate != 0) {
            this.jankCanaryNativeInstance = companion.nativeGetInstance(nativeCreate, 1);
            return;
        }
        throw new TritonInitException("failed to create TTApp", ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long nativeCreate(InspectorBridge inspectorBridge);

    @JvmStatic
    public static final native long nativeGetInstance(long j3, int i3);
}
