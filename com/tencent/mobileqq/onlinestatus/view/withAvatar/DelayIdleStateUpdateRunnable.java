package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R*\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/DelayIdleStateUpdateRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Lmqq/util/WeakReference;", "getRef", "()Lmqq/util/WeakReference;", "a", "(Lmqq/util/WeakReference;)V", "ref", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class DelayIdleStateUpdateRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<RecyclerView> ref;

    public DelayIdleStateUpdateRunnable(@Nullable RecyclerView recyclerView) {
        this.ref = new WeakReference<>(recyclerView);
    }

    public final void a(@NotNull WeakReference<RecyclerView> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.ref = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.ref.get();
        if (recyclerView != null && (recyclerView.getAdapter() instanceof a)) {
            Object adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.view.withAvatar.IOnlineStatusLikeAdapter");
            ((a) adapter).D(recyclerView, 0);
        }
    }
}
