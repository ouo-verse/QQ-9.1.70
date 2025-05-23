package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/PendingBatchPreloadRequest;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextWrf", "Ljava/lang/ref/WeakReference;", "getContextWrf", "()Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "preloadRequest", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "getPreloadRequest", "()Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "preloadCount", "I", "getPreloadCount", "()I", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;I)V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class PendingBatchPreloadRequest {

    @NotNull
    private final WeakReference<Context> contextWrf;
    private final int preloadCount;

    @NotNull
    private final PreloadRequest preloadRequest;

    public PendingBatchPreloadRequest(@NotNull WeakReference<Context> contextWrf, @NotNull PreloadRequest preloadRequest, int i3) {
        Intrinsics.checkNotNullParameter(contextWrf, "contextWrf");
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        this.contextWrf = contextWrf;
        this.preloadRequest = preloadRequest;
        this.preloadCount = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PendingBatchPreloadRequest) {
                PendingBatchPreloadRequest pendingBatchPreloadRequest = (PendingBatchPreloadRequest) other;
                if (!Intrinsics.areEqual(this.contextWrf, pendingBatchPreloadRequest.contextWrf) || !Intrinsics.areEqual(this.preloadRequest, pendingBatchPreloadRequest.preloadRequest) || this.preloadCount != pendingBatchPreloadRequest.preloadCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final WeakReference<Context> getContextWrf() {
        return this.contextWrf;
    }

    public final int getPreloadCount() {
        return this.preloadCount;
    }

    @NotNull
    public final PreloadRequest getPreloadRequest() {
        return this.preloadRequest;
    }

    public int hashCode() {
        int i3;
        WeakReference<Context> weakReference = this.contextWrf;
        int i16 = 0;
        if (weakReference != null) {
            i3 = weakReference.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        PreloadRequest preloadRequest = this.preloadRequest;
        if (preloadRequest != null) {
            i16 = preloadRequest.hashCode();
        }
        return ((i17 + i16) * 31) + this.preloadCount;
    }

    @NotNull
    public String toString() {
        return "PendingBatchPreloadRequest(contextWrf=" + this.contextWrf + ", preloadRequest=" + this.preloadRequest + ", preloadCount=" + this.preloadCount + ")";
    }
}
