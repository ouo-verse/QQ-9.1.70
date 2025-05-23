package com.tencent.biz.richframework.layoutinflater;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/PreloadResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "isMergeRes", "Z", "()Z", "<init>", "(Landroid/view/View;Z)V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class PreloadResult {
    private final boolean isMergeRes;

    @NotNull
    private final View view;

    public PreloadResult(@NotNull View view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.isMergeRes = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PreloadResult) {
                PreloadResult preloadResult = (PreloadResult) other;
                if (!Intrinsics.areEqual(this.view, preloadResult.view) || this.isMergeRes != preloadResult.isMergeRes) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        View view = this.view;
        if (view != null) {
            i3 = view.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.isMergeRes;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return i16 + i17;
    }

    /* renamed from: isMergeRes, reason: from getter */
    public final boolean getIsMergeRes() {
        return this.isMergeRes;
    }

    @NotNull
    public String toString() {
        return "PreloadResult(view=" + this.view + ", isMergeRes=" + this.isMergeRes + ")";
    }
}
