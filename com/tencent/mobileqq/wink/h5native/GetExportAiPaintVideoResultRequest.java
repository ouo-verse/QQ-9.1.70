package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u001f\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultRequest", "", "", "component1", "component2", "safeReq", "callback", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultRequest;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getSafeReq", "()Ljava/lang/String;", "getCallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$GetExportAiPaintVideoResultRequest, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GetExportAiPaintVideoResultRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String callback;

    @NotNull
    private final String safeReq;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultRequest$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultRequest;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$GetExportAiPaintVideoResultRequest$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GetExportAiPaintVideoResultRequest fromJsonStr(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            return (GetExportAiPaintVideoResultRequest) GsonUtils.f384219b.a(jsonStr, GetExportAiPaintVideoResultRequest.class);
        }

        Companion() {
        }
    }

    public GetExportAiPaintVideoResultRequest(@NotNull String safeReq, @Nullable String str) {
        Intrinsics.checkNotNullParameter(safeReq, "safeReq");
        this.safeReq = safeReq;
        this.callback = str;
    }

    public static /* synthetic */ GetExportAiPaintVideoResultRequest copy$default(GetExportAiPaintVideoResultRequest getExportAiPaintVideoResultRequest, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = getExportAiPaintVideoResultRequest.safeReq;
        }
        if ((i3 & 2) != 0) {
            str2 = getExportAiPaintVideoResultRequest.callback;
        }
        return getExportAiPaintVideoResultRequest.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSafeReq() {
        return this.safeReq;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final GetExportAiPaintVideoResultRequest copy(@NotNull String safeReq, @Nullable String callback) {
        Intrinsics.checkNotNullParameter(safeReq, "safeReq");
        return new GetExportAiPaintVideoResultRequest(safeReq, callback);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetExportAiPaintVideoResultRequest)) {
            return false;
        }
        GetExportAiPaintVideoResultRequest getExportAiPaintVideoResultRequest = (GetExportAiPaintVideoResultRequest) other;
        if (Intrinsics.areEqual(this.safeReq, getExportAiPaintVideoResultRequest.safeReq) && Intrinsics.areEqual(this.callback, getExportAiPaintVideoResultRequest.callback)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final String getSafeReq() {
        return this.safeReq;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.safeReq.hashCode() * 31;
        String str = this.callback;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "GetExportAiPaintVideoResultRequest(safeReq=" + this.safeReq + ", callback=" + this.callback + ")";
    }
}
