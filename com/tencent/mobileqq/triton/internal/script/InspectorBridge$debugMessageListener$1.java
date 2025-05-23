package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1", "Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "real", "getReal", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "setReal", "(Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;)V", "sendMessageToEngine", "", "message", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class InspectorBridge$debugMessageListener$1 implements InspectorAgent.DebuggerMessageListener {

    @Nullable
    private InspectorAgent.DebuggerMessageListener real = new InspectorAgent.DebuggerMessageListener() { // from class: com.tencent.mobileqq.triton.internal.script.InspectorBridge$debugMessageListener$1$real$1
        @Override // com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener
        public void sendMessageToEngine(@NotNull String message) {
            LifeCycleOwner lifeCycleOwner;
            long j3;
            long j16;
            Intrinsics.checkParameterIsNotNull(message, "message");
            lifeCycleOwner = InspectorBridge$debugMessageListener$1.this.this$0.lifeCycleOwner;
            if (lifeCycleOwner.getEngineState() != EngineState.DESTROYED) {
                try {
                    InspectorBridge.Companion companion = InspectorBridge.INSTANCE;
                    j16 = InspectorBridge$debugMessageListener$1.this.this$0.nativeInstance;
                    companion.sendMessageToEngine(j16, message);
                    Unit unit = Unit.INSTANCE;
                } catch (UnsatisfiedLinkError unused) {
                    InspectorBridge.Companion companion2 = InspectorBridge.INSTANCE;
                    j3 = InspectorBridge$debugMessageListener$1.this.this$0.nativeInstance;
                    companion2.sendMessageToEngine(j3, message);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    };
    final /* synthetic */ InspectorBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InspectorBridge$debugMessageListener$1(InspectorBridge inspectorBridge) {
        this.this$0 = inspectorBridge;
    }

    @Nullable
    public final InspectorAgent.DebuggerMessageListener getReal() {
        return this.real;
    }

    @Override // com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener
    public void sendMessageToEngine(@NotNull String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        InspectorAgent.DebuggerMessageListener debuggerMessageListener = this.real;
        if (debuggerMessageListener != null) {
            debuggerMessageListener.sendMessageToEngine(message);
        }
    }

    public final void setReal(@Nullable InspectorAgent.DebuggerMessageListener debuggerMessageListener) {
        this.real = debuggerMessageListener;
    }
}
