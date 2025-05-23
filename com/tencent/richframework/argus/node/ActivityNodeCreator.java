package com.tencent.richframework.argus.node;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/richframework/argus/node/ActivityNodeCreator;", "Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "Lcom/tencent/richframework/argus/node/ActivityNode;", "()V", "canHandle", "", "currentView", "Landroid/view/View;", ParseCommon.CONTAINER, "", "createNode", "nodeView", "getActivity", "Landroid/app/Activity;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ActivityNodeCreator implements ArgusNodeCreator<ActivityNode> {
    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public boolean canHandle(@NotNull View currentView, @Nullable Object container) {
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        if (!(container instanceof Activity) && getActivity(currentView) == null) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Activity getActivity(@NotNull View currentView) {
        Context context;
        View childAt;
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        Context context2 = null;
        if (!Intrinsics.areEqual(currentView.getClass().getName(), "com.android.internal.policy.DecorView")) {
            return null;
        }
        if (!(currentView instanceof ViewGroup)) {
            currentView = null;
        }
        ViewGroup viewGroup = (ViewGroup) currentView;
        if (viewGroup != null && (childAt = viewGroup.getChildAt(0)) != null) {
            context = childAt.getContext();
        } else {
            context = null;
        }
        if (context instanceof Activity) {
            context2 = context;
        }
        return (Activity) context2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    @NotNull
    public ActivityNode createNode(@NotNull View nodeView, @Nullable Object container) {
        Intrinsics.checkNotNullParameter(nodeView, "nodeView");
        if (container instanceof Activity) {
            return new ActivityNode(nodeView, (Activity) container);
        }
        Activity activity = getActivity(nodeView);
        if (activity != null) {
            return new ActivityNode(nodeView, activity);
        }
        throw new UnsupportedOperationException("find blockView:" + nodeView + " container: " + container);
    }
}
