package com.tencent.richframework.argus.node;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/richframework/argus/node/ActivityNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Landroid/app/Activity;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "(Landroid/view/View;Landroid/app/Activity;)V", "activityClassName", "", "isSelfVisible", "", "()Z", "getContainerDesc", ParseCommon.CONTAINER, "toString", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ActivityNode extends ArgusNode<Activity> {
    private final String activityClassName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNode(@NotNull View rootView, @NotNull Activity activity) {
        super(rootView, activity);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        this.activityClassName = name;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    @NotNull
    public String getContainerDesc(@Nullable Activity container) {
        return "Activity";
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        Lifecycle lifecycle;
        ComponentCallbacks2 componentCallbacks2 = getContainerWrf().get();
        Lifecycle.State state = null;
        if (!(componentCallbacks2 instanceof LifecycleOwner)) {
            componentCallbacks2 = null;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) componentCallbacks2;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            state = lifecycle.getCurrentState();
        }
        if (state == Lifecycle.State.RESUMED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    @NotNull
    public String toString() {
        return "ActivityNode(container=" + getContainer() + ')';
    }
}
