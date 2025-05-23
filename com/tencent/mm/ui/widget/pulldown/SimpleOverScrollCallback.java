package com.tencent.mm.ui.widget.pulldown;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.widget.pulldown.IOverScrollCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "overScroll", "Landroid/view/View;", "child", "", "scrollDirection", "", "canScroll", "getMaxFlingOffset", "", "getDampingFactor", "getMinFlingVelocity", "offset", "", "onOffsetChanged", "onSpringBack", "onStopSpringingBack", "a", "I", "mMinFlingVelocity", "<init>", "()V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SimpleOverScrollCallback implements IOverScrollCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int mMinFlingVelocity;

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public boolean canScroll(@NotNull IOverScroll overScroll, @NotNull View child, @IOverScrollCallback.ScrollDirection int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return true;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public float getDampingFactor(@NotNull IOverScroll overScroll, @NotNull View child, @IOverScrollCallback.ScrollDirection int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        float abs = (Math.abs(overScroll.getOffset(child)) * 1.0f) / child.getHeight();
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        return nestedBounceParam.getMinDampingFactor() + ((nestedBounceParam.getMaxDampingFactor() - nestedBounceParam.getMinDampingFactor()) * abs);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public int getMaxFlingOffset(@NotNull IOverScroll overScroll, @NotNull View child, @IOverScrollCallback.ScrollDirection int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        if (scrollDirection != 2 && scrollDirection != 8) {
            return (-child.getHeight()) / 10;
        }
        return child.getHeight() / 10;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public int getMinFlingVelocity(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.mMinFlingVelocity <= 0) {
            this.mMinFlingVelocity = ViewConfiguration.get(child.getContext()).getScaledMinimumFlingVelocity() * 15;
        }
        return this.mMinFlingVelocity;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public void onOffsetChanged(@NotNull IOverScroll overScroll, @NotNull View child, int offset) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public boolean onSpringBack(@NotNull IOverScroll overScroll, @NotNull View child) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return false;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public void onStopSpringingBack(@NotNull IOverScroll overScroll, @NotNull View child) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
    }
}
