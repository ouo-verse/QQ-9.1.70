package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.filament.zplan.data.RenderSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "needOnScreen", "Lcom/tencent/filament/zplan/data/RenderSize;", "b", "Lcom/tencent/filament/zplan/data/RenderSize;", "c", "()Lcom/tencent/filament/zplan/data/RenderSize;", "onScreenRenderSize", "offScreenRenderSize", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "UGCId", "<init>", "(ZLcom/tencent/filament/zplan/data/RenderSize;Lcom/tencent/filament/zplan/data/RenderSize;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.h, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class FilamentInitParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needOnScreen;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final RenderSize onScreenRenderSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final RenderSize offScreenRenderSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String UGCId;

    public FilamentInitParams(boolean z16, RenderSize renderSize, RenderSize offScreenRenderSize, String UGCId) {
        Intrinsics.checkNotNullParameter(offScreenRenderSize, "offScreenRenderSize");
        Intrinsics.checkNotNullParameter(UGCId, "UGCId");
        this.needOnScreen = z16;
        this.onScreenRenderSize = renderSize;
        this.offScreenRenderSize = offScreenRenderSize;
        this.UGCId = UGCId;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedOnScreen() {
        return this.needOnScreen;
    }

    /* renamed from: b, reason: from getter */
    public final RenderSize getOffScreenRenderSize() {
        return this.offScreenRenderSize;
    }

    /* renamed from: c, reason: from getter */
    public final RenderSize getOnScreenRenderSize() {
        return this.onScreenRenderSize;
    }

    /* renamed from: d, reason: from getter */
    public final String getUGCId() {
        return this.UGCId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.needOnScreen;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        RenderSize renderSize = this.onScreenRenderSize;
        return ((((i3 + (renderSize == null ? 0 : renderSize.hashCode())) * 31) + this.offScreenRenderSize.hashCode()) * 31) + this.UGCId.hashCode();
    }

    public String toString() {
        return "FilamentInitParams(needOnScreen=" + this.needOnScreen + ", onScreenRenderSize=" + this.onScreenRenderSize + ", offScreenRenderSize=" + this.offScreenRenderSize + ", UGCId=" + this.UGCId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentInitParams)) {
            return false;
        }
        FilamentInitParams filamentInitParams = (FilamentInitParams) other;
        return this.needOnScreen == filamentInitParams.needOnScreen && Intrinsics.areEqual(this.onScreenRenderSize, filamentInitParams.onScreenRenderSize) && Intrinsics.areEqual(this.offScreenRenderSize, filamentInitParams.offScreenRenderSize) && Intrinsics.areEqual(this.UGCId, filamentInitParams.UGCId);
    }
}
