package com.tencent.mobileqq.nearbypro.part.guide;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "b", "()Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "Landroid/view/View;", "Landroid/view/View;", "getMAnchorView", "()Landroid/view/View;", "mAnchorView", "Landroid/content/Context;", "c", "Landroid/content/Context;", "()Landroid/content/Context;", "mContext", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Landroid/content/Context;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.part.guide.f, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NearbyProGuideContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LifecycleOwner mLifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View mAnchorView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Context mContext;

    public NearbyProGuideContext(@NotNull LifecycleOwner mLifecycleOwner, @NotNull View mAnchorView, @NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mLifecycleOwner = mLifecycleOwner;
        this.mAnchorView = mAnchorView;
        this.mContext = mContext;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LifecycleOwner getMLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NearbyProGuideContext)) {
            return false;
        }
        NearbyProGuideContext nearbyProGuideContext = (NearbyProGuideContext) other;
        if (Intrinsics.areEqual(this.mLifecycleOwner, nearbyProGuideContext.mLifecycleOwner) && Intrinsics.areEqual(this.mAnchorView, nearbyProGuideContext.mAnchorView) && Intrinsics.areEqual(this.mContext, nearbyProGuideContext.mContext)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.mLifecycleOwner.hashCode() * 31) + this.mAnchorView.hashCode()) * 31) + this.mContext.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearbyProGuideContext(mLifecycleOwner=" + this.mLifecycleOwner + ", mAnchorView=" + this.mAnchorView + ", mContext=" + this.mContext + ")";
    }
}
