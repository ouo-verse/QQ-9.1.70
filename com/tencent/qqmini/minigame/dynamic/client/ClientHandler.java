package com.tencent.qqmini.minigame.dynamic.client;

import android.util.ArrayMap;
import com.tencent.qqmini.minigame.dynamic.DynamicCore;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JQ\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00012+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0016R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/client/ClientHandler;", "", "", "pluginName", "Lcom/tencent/qqmini/minigame/dynamic/client/b;", "e", "d", "moduleName", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/qqmini/minigame/dynamic/client/ClientCallback;", "callback", "c", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqmini/minigame/dynamic/DynamicCore;", "a", "Ljava/lang/ref/WeakReference;", "dynamicCoreRef", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "b", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "clientModuleRegistryWRLock", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "clientModuleRegistry", "core", "<init>", "(Lcom/tencent/qqmini/minigame/dynamic/DynamicCore;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class ClientHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<DynamicCore> dynamicCoreRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReentrantReadWriteLock clientModuleRegistryWRLock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, b> clientModuleRegistry;

    public ClientHandler(@NotNull DynamicCore core) {
        Intrinsics.checkParameterIsNotNull(core, "core");
        this.clientModuleRegistryWRLock = new ReentrantReadWriteLock();
        this.clientModuleRegistry = new ArrayMap<>();
        this.dynamicCoreRef = new WeakReference<>(core);
    }

    private final b d(final String pluginName) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        a.c(this.clientModuleRegistryWRLock, new Function0<Unit>() { // from class: com.tencent.qqmini.minigame.dynamic.client.ClientHandler$clientModuleWithName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [T, com.tencent.qqmini.minigame.dynamic.client.b] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayMap arrayMap;
                Ref.ObjectRef objectRef2 = objectRef;
                arrayMap = ClientHandler.this.clientModuleRegistry;
                objectRef2.element = (b) arrayMap.get(pluginName);
            }
        });
        return (b) objectRef.element;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.qqmini.minigame.dynamic.client.b] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, com.tencent.qqmini.minigame.dynamic.client.b] */
    private final b e(final String pluginName) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? d16 = d(pluginName);
        objectRef.element = d16;
        if (((b) d16) == null) {
            a.d(this.clientModuleRegistryWRLock, new Function0<Unit>() { // from class: com.tencent.qqmini.minigame.dynamic.client.ClientHandler$getClientModule$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WeakReference weakReference;
                    ArrayMap arrayMap;
                    DynamicCore dynamicCore;
                    Ref.ObjectRef objectRef2 = objectRef;
                    weakReference = ClientHandler.this.dynamicCoreRef;
                    objectRef2.element = (weakReference == null || (dynamicCore = (DynamicCore) weakReference.get()) == null) ? 0 : dynamicCore.i(pluginName);
                    arrayMap = ClientHandler.this.clientModuleRegistry;
                    arrayMap.put(pluginName, (b) objectRef.element);
                }
            });
            objectRef.element = d(pluginName);
        }
        return (b) objectRef.element;
    }

    @Nullable
    public Object c(@NotNull String moduleName, @NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(moduleName, "moduleName");
        Intrinsics.checkParameterIsNotNull(method, "method");
        b e16 = e(moduleName);
        if (e16 != null) {
            return e16.call(method, params, callback);
        }
        return null;
    }
}
