package com.tencent.richframework.argus.business;

import com.tencent.cache.api.d;
import com.tencent.richframework.QQArgusNode;
import com.tencent.richframework.argus.node.ArgusMergeNode;
import com.tencent.richframework.argus.node.ArgusNode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/richframework/argus/node/ArgusNode;", "Lcom/tencent/cache/api/d;", "getPageArgus", "qq-argus-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MonitorKt {
    @Nullable
    public static final d getPageArgus(@NotNull ArgusNode<?> argusNode) {
        d dVar;
        Boolean bool;
        Class<?> blockClass;
        Intrinsics.checkNotNullParameter(argusNode, "<this>");
        Object obj = argusNode.getExtra().get("PAGE_ARGUS");
        if (obj instanceof d) {
            dVar = (d) obj;
        } else {
            dVar = null;
        }
        if (dVar == null) {
            Object obj2 = argusNode.getExtra().get("HASH_GENERATE");
            if (obj2 instanceof Boolean) {
                bool = (Boolean) obj2;
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return null;
            }
            if (argusNode instanceof ArgusMergeNode) {
                Iterator<T> it = ((ArgusMergeNode) argusNode).getInnerNodes().iterator();
                while (it.hasNext()) {
                    ArgusNode argusNode2 = (ArgusNode) it.next();
                    if (argusNode2 instanceof QQArgusNode) {
                        dVar = ((QQArgusNode) argusNode2).getPageArgus();
                    }
                }
            } else if (argusNode instanceof QQArgusNode) {
                dVar = ((QQArgusNode) argusNode).getPageArgus();
            }
            if (dVar == null && (blockClass = Unified.INSTANCE.getBlockClass(argusNode)) != null) {
                dVar = Monitor.INSTANCE.getPageArgusByAnnotation(blockClass);
            }
            if (dVar != null) {
                dVar.d(Unified.INSTANCE.getBlockInfo(argusNode));
                argusNode.getExtra().put("PAGE_ARGUS", dVar);
            }
            argusNode.getExtra().put("HASH_GENERATE", Boolean.TRUE);
        }
        return dVar;
    }
}
