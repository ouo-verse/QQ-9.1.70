package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0013B#\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/a;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "position", "", "smoothScrollToPosition", "Landroid/content/Context;", "context", "orientation", "", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "d", "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class a extends LinearLayoutManager {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fJ0\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/a$a;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.pay.page.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static final class C8922a extends LinearSmoothScroller {
        public C8922a(@Nullable Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return (boxStart + ((boxEnd - boxStart) / 2)) - (viewStart + ((viewEnd - viewStart) / 2));
        }
    }

    public a(@Nullable Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@NotNull RecyclerView recyclerView, @Nullable RecyclerView.State state, int position) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        try {
            C8922a c8922a = new C8922a(recyclerView.getContext());
            c8922a.setTargetPosition(position);
            startSmoothScroll(c8922a);
        } catch (Exception e16) {
            QLog.i("CenterLayoutManager", 1, "smoothScrollToPosition exception: " + e16.getMessage());
        }
    }
}
