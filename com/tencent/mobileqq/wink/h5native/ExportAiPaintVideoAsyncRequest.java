package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$ExportAiPaintVideoAsyncRequest", "", "", "component1", "renderReq", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$ExportAiPaintVideoAsyncRequest;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getRenderReq", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$ExportAiPaintVideoAsyncRequest, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ExportAiPaintVideoAsyncRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String renderReq;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$ExportAiPaintVideoAsyncRequest$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$ExportAiPaintVideoAsyncRequest;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$ExportAiPaintVideoAsyncRequest$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ExportAiPaintVideoAsyncRequest fromJsonStr(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            return (ExportAiPaintVideoAsyncRequest) GsonUtils.f384219b.a(jsonStr, ExportAiPaintVideoAsyncRequest.class);
        }

        Companion() {
        }
    }

    public ExportAiPaintVideoAsyncRequest(@NotNull String renderReq) {
        Intrinsics.checkNotNullParameter(renderReq, "renderReq");
        this.renderReq = renderReq;
    }

    public static /* synthetic */ ExportAiPaintVideoAsyncRequest copy$default(ExportAiPaintVideoAsyncRequest exportAiPaintVideoAsyncRequest, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = exportAiPaintVideoAsyncRequest.renderReq;
        }
        return exportAiPaintVideoAsyncRequest.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRenderReq() {
        return this.renderReq;
    }

    @NotNull
    public final ExportAiPaintVideoAsyncRequest copy(@NotNull String renderReq) {
        Intrinsics.checkNotNullParameter(renderReq, "renderReq");
        return new ExportAiPaintVideoAsyncRequest(renderReq);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ExportAiPaintVideoAsyncRequest) && Intrinsics.areEqual(this.renderReq, ((ExportAiPaintVideoAsyncRequest) other).renderReq)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getRenderReq() {
        return this.renderReq;
    }

    public int hashCode() {
        return this.renderReq.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExportAiPaintVideoAsyncRequest(renderReq=" + this.renderReq + ")";
    }
}
