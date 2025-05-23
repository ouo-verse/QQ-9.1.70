package com.tencent.richframework.argus.business.performance.report;

import com.tencent.richframework.argus.node.NodePO;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u00a8\u0006\u0003"}, d2 = {"getBlockMsg", "", "Lcom/tencent/richframework/argus/node/NodePO;", "qq-argus-kit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PagePerformanceEventInterceptorKt {
    @NotNull
    public static final String getBlockMsg(@Nullable NodePO nodePO) {
        String str;
        List<NodePO> children;
        StringBuilder sb5 = new StringBuilder();
        if (nodePO != null) {
            str = nodePO.getContainerClass();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(" ");
        if (nodePO != null && (children = nodePO.getChildren()) != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                sb5.append(getBlockMsg((NodePO) it.next()));
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }
}
