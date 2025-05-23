package com.tencent.richframework.compat.immersive;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/richframework/compat/immersive/NavigationBarInfo;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "getViewWeakReference", "()Ljava/lang/ref/WeakReference;", "height", "I", "getHeight", "()I", "setHeight", "(I)V", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class NavigationBarInfo {
    private int height;

    @NotNull
    private final WeakReference<View> viewWeakReference;

    public NavigationBarInfo(@NotNull WeakReference<View> viewWeakReference, int i3) {
        Intrinsics.checkNotNullParameter(viewWeakReference, "viewWeakReference");
        this.viewWeakReference = viewWeakReference;
        this.height = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof NavigationBarInfo) {
                NavigationBarInfo navigationBarInfo = (NavigationBarInfo) other;
                if (!Intrinsics.areEqual(this.viewWeakReference, navigationBarInfo.viewWeakReference) || this.height != navigationBarInfo.height) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final WeakReference<View> getViewWeakReference() {
        return this.viewWeakReference;
    }

    public int hashCode() {
        int i3;
        WeakReference<View> weakReference = this.viewWeakReference;
        if (weakReference != null) {
            i3 = weakReference.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.height;
    }

    @NotNull
    public String toString() {
        return "NavigationBarInfo(viewWeakReference=" + this.viewWeakReference + ", height=" + this.height + ")";
    }
}
