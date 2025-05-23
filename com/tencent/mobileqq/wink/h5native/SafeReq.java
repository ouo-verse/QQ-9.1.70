package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J'\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeReq", "", "", "component1", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeInfo;", "component2", "component3", "busiID", "safeInfo", QCircleWeakNetReporter.KEY_TRACE_ID, "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeReq;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getBusiID", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeInfo;", "getSafeInfo", "()Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeInfo;", "getTraceID", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeInfo;Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$SafeReq, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class SafeReq {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String busiID;

    @NotNull
    private final SafeInfo safeInfo;

    @NotNull
    private final String traceID;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeReq$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeReq;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$SafeReq$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final SafeReq fromJsonStr(@Nullable String jsonStr) {
            return (SafeReq) GsonUtils.f384219b.a(jsonStr, SafeReq.class);
        }

        Companion() {
        }
    }

    public SafeReq(@NotNull String busiID, @NotNull SafeInfo safeInfo, @NotNull String traceID) {
        Intrinsics.checkNotNullParameter(busiID, "busiID");
        Intrinsics.checkNotNullParameter(safeInfo, "safeInfo");
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        this.busiID = busiID;
        this.safeInfo = safeInfo;
        this.traceID = traceID;
    }

    public static /* synthetic */ SafeReq copy$default(SafeReq safeReq, String str, SafeInfo safeInfo, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = safeReq.busiID;
        }
        if ((i3 & 2) != 0) {
            safeInfo = safeReq.safeInfo;
        }
        if ((i3 & 4) != 0) {
            str2 = safeReq.traceID;
        }
        return safeReq.copy(str, safeInfo, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getBusiID() {
        return this.busiID;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final SafeInfo getSafeInfo() {
        return this.safeInfo;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTraceID() {
        return this.traceID;
    }

    @NotNull
    public final SafeReq copy(@NotNull String busiID, @NotNull SafeInfo safeInfo, @NotNull String traceID) {
        Intrinsics.checkNotNullParameter(busiID, "busiID");
        Intrinsics.checkNotNullParameter(safeInfo, "safeInfo");
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        return new SafeReq(busiID, safeInfo, traceID);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafeReq)) {
            return false;
        }
        SafeReq safeReq = (SafeReq) other;
        if (Intrinsics.areEqual(this.busiID, safeReq.busiID) && Intrinsics.areEqual(this.safeInfo, safeReq.safeInfo) && Intrinsics.areEqual(this.traceID, safeReq.traceID)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getBusiID() {
        return this.busiID;
    }

    @NotNull
    public final SafeInfo getSafeInfo() {
        return this.safeInfo;
    }

    @NotNull
    public final String getTraceID() {
        return this.traceID;
    }

    public int hashCode() {
        return (((this.busiID.hashCode() * 31) + this.safeInfo.hashCode()) * 31) + this.traceID.hashCode();
    }

    @NotNull
    public String toString() {
        return "SafeReq(busiID=" + this.busiID + ", safeInfo=" + this.safeInfo + ", traceID=" + this.traceID + ")";
    }
}
