package com.tencent.richframework.argus.util;

import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.page.PageInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005`\u0006*\u0006\u0012\u0002\b\u00030\u0007\u001a&\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005`\u0006*\u00020\u0002\u00a8\u0006\b"}, d2 = {"getAllVisibleBlockMsg", "", "Lcom/tencent/richframework/argus/page/PageInfo;", "getReportBusinessExtMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "argus-monitor_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class UtilsKt {
    @NotNull
    public static final String getAllVisibleBlockMsg(@Nullable PageInfo pageInfo) {
        Set<ArgusNode<?>> allVisibleNode;
        StringBuilder sb5 = new StringBuilder();
        if (pageInfo != null && (allVisibleNode = pageInfo.getAllVisibleNode()) != null) {
            Iterator<T> it = allVisibleNode.iterator();
            while (it.hasNext()) {
                Object container = ((ArgusNode) it.next()).getContainer();
                if (container != null) {
                    sb5.append(container.getClass().getSimpleName());
                    sb5.append(" ");
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @NotNull
    public static final HashMap<String, Object> getReportBusinessExtMap(@NotNull ArgusNode<?> getReportBusinessExtMap) {
        Intrinsics.checkNotNullParameter(getReportBusinessExtMap, "$this$getReportBusinessExtMap");
        HashMap<String, Object> hashMap = new HashMap<>();
        Object obj = getReportBusinessExtMap.getExtra().get("monitor_report_business_ext_params");
        if (!(obj instanceof HashMap)) {
            obj = null;
        }
        HashMap hashMap2 = (HashMap) obj;
        if (hashMap2 != null) {
            hashMap.putAll(hashMap2);
        }
        return hashMap;
    }

    @NotNull
    public static final HashMap<String, Object> getReportBusinessExtMap(@NotNull PageInfo getReportBusinessExtMap) {
        Intrinsics.checkNotNullParameter(getReportBusinessExtMap, "$this$getReportBusinessExtMap");
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<T> it = getReportBusinessExtMap.getAllVisibleNode().iterator();
        while (it.hasNext()) {
            Object obj = ((ArgusNode) it.next()).getExtra().get("monitor_report_business_ext_params");
            if (!(obj instanceof HashMap)) {
                obj = null;
            }
            HashMap hashMap2 = (HashMap) obj;
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
        }
        return hashMap;
    }
}
