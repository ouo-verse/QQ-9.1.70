package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeClass(namespace = Consts.JNI_NAMESPACE)
@NativeProxy(allFields = false, allMethods = false, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u000bH\u0082 J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tR\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;", "", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;)V", "debugMessageListener", "com/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1", "Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1;", "mProxy", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "nativeInstance", "", "nativeCreate", "sendMessageToDebugger", "", "message", "", "setProxy", "proxy", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class InspectorBridge {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "InspectorBridge";
    private final InspectorBridge$debugMessageListener$1 debugMessageListener;
    private final LifeCycleOwner lifeCycleOwner;
    private InspectorAgent mProxy;

    @NativeFieldProxy(setter = false)
    private final long nativeInstance;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0083 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge$Companion;", "", "()V", "TAG", "", "sendMessageToEngine", "", "nativeInstance", "", "message", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void sendMessageToEngine(long nativeInstance, String message) {
            InspectorBridge.sendMessageToEngine(nativeInstance, message);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InspectorBridge(@NotNull LifeCycleOwner lifeCycleOwner) {
        long nativeCreate;
        Intrinsics.checkParameterIsNotNull(lifeCycleOwner, "lifeCycleOwner");
        this.lifeCycleOwner = lifeCycleOwner;
        try {
            nativeCreate = nativeCreate();
        } catch (UnsatisfiedLinkError unused) {
            nativeCreate = nativeCreate();
        }
        this.nativeInstance = nativeCreate;
        this.debugMessageListener = new InspectorBridge$debugMessageListener$1(this);
    }

    private final native long nativeCreate();

    @NativeMethodProxy
    private final void sendMessageToDebugger(String message) {
        try {
            try {
                InspectorAgent inspectorAgent = this.mProxy;
                if (inspectorAgent != null) {
                    inspectorAgent.sendMessageToDebugger(message);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (UnsatisfiedLinkError unused) {
                InspectorAgent inspectorAgent2 = this.mProxy;
                if (inspectorAgent2 != null) {
                    inspectorAgent2.sendMessageToDebugger(message);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        } catch (Throwable th5) {
            Logger.e(TAG, "sendMessageToDebugger", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void sendMessageToEngine(long j3, String str);

    public final void setProxy(@NotNull InspectorAgent proxy) {
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        this.mProxy = proxy;
        proxy.setOnDebuggerMessageListener(this.debugMessageListener);
        this.lifeCycleOwner.observeLifeCycle(new LifeCycle() { // from class: com.tencent.mobileqq.triton.internal.script.InspectorBridge$setProxy$1
            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onDestroy() {
                InspectorAgent inspectorAgent;
                InspectorBridge$debugMessageListener$1 inspectorBridge$debugMessageListener$1;
                inspectorAgent = InspectorBridge.this.mProxy;
                if (inspectorAgent != null) {
                    inspectorAgent.destroy();
                }
                inspectorBridge$debugMessageListener$1 = InspectorBridge.this.debugMessageListener;
                inspectorBridge$debugMessageListener$1.setReal(null);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onFirstFrame() {
                LifeCycle.DefaultImpls.onFirstFrame(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onGameLaunched(@NotNull TritonEngine engine) {
                Intrinsics.checkParameterIsNotNull(engine, "engine");
                LifeCycle.DefaultImpls.onGameLaunched(this, engine);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStart() {
                LifeCycle.DefaultImpls.onStart(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStop() {
                LifeCycle.DefaultImpls.onStop(this);
            }
        });
    }
}
