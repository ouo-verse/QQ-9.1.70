package com.tencent.tavcut.core.render.rendernode;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0010\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/NodeOrderUtils;", "", "()V", "defaultOrderConfig", "Ljava/util/HashMap;", "", "", "getDefaultOrderConfig", "()Ljava/util/HashMap;", "index", "configNodeOrder", "", "clazz", "Ljava/lang/Class;", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "getOrderConfigByScene", "renderScene", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class NodeOrderUtils {
    public static final NodeOrderUtils INSTANCE;

    @NotNull
    private static final HashMap<String, Integer> defaultOrderConfig;
    private static int index;

    static {
        NodeOrderUtils nodeOrderUtils = new NodeOrderUtils();
        INSTANCE = nodeOrderUtils;
        defaultOrderConfig = new HashMap<>();
        nodeOrderUtils.configNodeOrder(LightRenderNode.class);
    }

    NodeOrderUtils() {
    }

    public final void configNodeOrder(@NotNull Class<? extends BaseEffectNode> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        HashMap<String, Integer> hashMap = defaultOrderConfig;
        String simpleName = clazz.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "clazz.simpleName");
        int i3 = index;
        index = i3 + 1;
        hashMap.put(simpleName, Integer.valueOf(i3));
    }

    @NotNull
    public final HashMap<String, Integer> getDefaultOrderConfig() {
        return defaultOrderConfig;
    }

    @NotNull
    public final HashMap<String, Integer> getOrderConfigByScene(int renderScene) {
        return defaultOrderConfig;
    }
}
