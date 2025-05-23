package com.tencent.mobileqq.guild.main.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/c;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Landroid/view/View;", "child", "focused", "", "onRequestChildFocus", "d", "Z", "getSuppressDefaultScrollWhenSameChildRequestFocus", "()Z", "a", "(Z)V", "suppressDefaultScrollWhenSameChildRequestFocus", "", "e", "I", "lastFocusedViewHashCode", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends LinearLayoutManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean suppressDefaultScrollWhenSameChildRequestFocus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastFocusedViewHashCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(boolean z16) {
        this.suppressDefaultScrollWhenSameChildRequestFocus = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onRequestChildFocus(@NotNull RecyclerView parent, @NotNull RecyclerView.State state, @NotNull View child, @Nullable View focused) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(child, "child");
        if (focused == null) {
            this.lastFocusedViewHashCode = 0;
        } else {
            int identityHashCode = System.identityHashCode(focused);
            if (identityHashCode == this.lastFocusedViewHashCode && this.suppressDefaultScrollWhenSameChildRequestFocus) {
                return true;
            }
            this.lastFocusedViewHashCode = identityHashCode;
        }
        return super.onRequestChildFocus(parent, state, child, focused);
    }
}
