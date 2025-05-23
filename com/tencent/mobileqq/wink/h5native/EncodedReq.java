package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$EncodedReq", "", "", "component1", QCircleWeakNetReporter.KEY_TRACE_ID, "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$EncodedReq;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTraceID", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$EncodedReq, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class EncodedReq {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String traceID;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$EncodedReq$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$EncodedReq;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$EncodedReq$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final EncodedReq fromJsonStr(@Nullable String jsonStr) {
            return (EncodedReq) GsonUtils.f384219b.a(jsonStr, EncodedReq.class);
        }

        Companion() {
        }
    }

    public EncodedReq(@NotNull String traceID) {
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        this.traceID = traceID;
    }

    public static /* synthetic */ EncodedReq copy$default(EncodedReq encodedReq, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = encodedReq.traceID;
        }
        return encodedReq.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTraceID() {
        return this.traceID;
    }

    @NotNull
    public final EncodedReq copy(@NotNull String traceID) {
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        return new EncodedReq(traceID);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof EncodedReq) && Intrinsics.areEqual(this.traceID, ((EncodedReq) other).traceID)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getTraceID() {
        return this.traceID;
    }

    public int hashCode() {
        return this.traceID.hashCode();
    }

    @NotNull
    public String toString() {
        return "EncodedReq(traceID=" + this.traceID + ")";
    }
}
