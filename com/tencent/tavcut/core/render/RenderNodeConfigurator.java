package com.tencent.tavcut.core.render;

import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/render/RenderNodeConfigurator;", "", "()V", "exceptedAddRenderNodes", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "iRenderChainManager", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "addRenderNode", "", "effectNode", "configRenderChainManager", "removeRenderNode", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class RenderNodeConfigurator {
    private final List<BaseEffectNode> exceptedAddRenderNodes = new ArrayList();
    private IRenderChainManager iRenderChainManager;

    public final void addRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        IRenderChainManager iRenderChainManager = this.iRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.addRenderNode(effectNode);
        }
        synchronized (this.exceptedAddRenderNodes) {
            this.exceptedAddRenderNodes.add(effectNode);
        }
    }

    public final void configRenderChainManager(@NotNull IRenderChainManager iRenderChainManager) {
        Intrinsics.checkParameterIsNotNull(iRenderChainManager, "iRenderChainManager");
        this.iRenderChainManager = iRenderChainManager;
        synchronized (this.exceptedAddRenderNodes) {
            if (!this.exceptedAddRenderNodes.isEmpty()) {
                for (BaseEffectNode baseEffectNode : this.exceptedAddRenderNodes) {
                    IRenderChainManager iRenderChainManager2 = this.iRenderChainManager;
                    if (iRenderChainManager2 != null) {
                        iRenderChainManager2.addRenderNode(baseEffectNode);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        IRenderChainManager iRenderChainManager = this.iRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.removeRenderNode(effectNode);
        }
        synchronized (this.exceptedAddRenderNodes) {
            this.exceptedAddRenderNodes.remove(effectNode);
        }
    }
}
