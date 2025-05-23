package com.tencent.richframework.argus.business;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.richframework.QQArgusNode;
import com.tencent.richframework.argus.node.ActivityNode;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.FragmentNode;
import com.tencent.richframework.argus.page.PageInfo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0002J\n\u0010\b\u001a\u00020\u0005*\u00020\u0007J\u0018\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0003J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0003J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/richframework/argus/business/Unified;", "", "", "Lcom/tencent/richframework/argus/node/ArgusNode;", "blockNodeList", "", "unifiedBlockSet", "Lcom/tencent/richframework/argus/page/PageInfo;", QCircleDaTongConstant.ElementParamKey.UNIFIED, "node", "Ljava/lang/Class;", "getBlockClass", "block", "getBlockInfo", "", "filterValidBlock", "<init>", "()V", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class Unified {

    @NotNull
    public static final Unified INSTANCE = new Unified();

    Unified() {
    }

    private final String unifiedBlockSet(Set<? extends ArgusNode<?>> blockNodeList) {
        int collectionSizeOrDefault;
        String joinToString$default;
        String str;
        String str2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(blockNodeList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ArgusNode<?> argusNode : blockNodeList) {
            String str3 = null;
            if (argusNode instanceof ActivityNode) {
                Class<?> blockClass = INSTANCE.getBlockClass(argusNode);
                if (blockClass != null) {
                    str3 = blockClass.getSimpleName();
                }
                if (str3 == null) {
                    str3 = "activityNull";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str3, "getBlockClass(it)?.simpleName ?: ACTIVITY_UNKNOWN");
                }
            } else if (argusNode instanceof FragmentNode) {
                Class<?> blockClass2 = INSTANCE.getBlockClass(argusNode);
                if (blockClass2 != null) {
                    str3 = blockClass2.getSimpleName();
                }
                if (str3 == null) {
                    str3 = "fragmentNull";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str3, "getBlockClass(it)?.simpleName ?: FRAGMENT_UNKNOWN");
                }
            } else {
                Class<?> blockClass3 = INSTANCE.getBlockClass(argusNode);
                if (blockClass3 != null) {
                    str = blockClass3.getSimpleName();
                } else {
                    str = null;
                }
                if (str == null) {
                    View nodeView = argusNode.getNodeView();
                    if (nodeView != null) {
                        str2 = nodeView.getClass().getSimpleName();
                    } else {
                        str2 = null;
                    }
                    Object container = argusNode.getContainer();
                    if (container != null) {
                        str3 = container.getClass().getSimpleName();
                    }
                    str3 = str2 + "(" + str3 + ")";
                } else {
                    str3 = str;
                }
            }
            arrayList.add(str3);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
        return "[" + joinToString$default + "]";
    }

    @NotNull
    public final List<String> filterValidBlock(@NotNull Set<? extends ArgusNode<?>> blockNodeList) {
        String str;
        Intrinsics.checkNotNullParameter(blockNodeList, "blockNodeList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = blockNodeList.iterator();
        while (it.hasNext()) {
            Class<?> blockClass = INSTANCE.getBlockClass((ArgusNode) it.next());
            if (blockClass != null) {
                str = blockClass.getSimpleName();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Nullable
    public final Class<?> getBlockClass(@NotNull ArgusNode<?> node) {
        boolean z16;
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(node, "node");
        boolean z17 = true;
        if (node instanceof ActivityNode) {
            z16 = true;
        } else {
            z16 = node instanceof FragmentNode;
        }
        if (!z16) {
            z17 = node instanceof QQArgusNode;
        }
        if (z17) {
            Object container = node.getContainer();
            if (container == null) {
                return null;
            }
            return container.getClass();
        }
        View nodeView = node.getNodeView();
        if (nodeView != null) {
            obj = nodeView.getTag(R.id.tx6);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return Class.forName(str);
    }

    @Nullable
    public final String getBlockInfo(@NotNull ArgusNode<?> block) {
        Object container;
        Intrinsics.checkNotNullParameter(block, "block");
        if ((!(block instanceof ActivityNode) && !(block instanceof FragmentNode)) || (container = block.getContainer()) == null) {
            return null;
        }
        return container.getClass().getSimpleName() + "@" + container.hashCode();
    }

    @NotNull
    public final String unified(@NotNull PageInfo pageInfo) {
        String str;
        Intrinsics.checkNotNullParameter(pageInfo, "<this>");
        Class<?> blockClass = getBlockClass(pageInfo.getRootNode());
        if (blockClass != null) {
            str = blockClass.getSimpleName();
        } else {
            str = null;
        }
        return str + unifiedBlockSet(pageInfo.getAllVisibleNode());
    }
}
