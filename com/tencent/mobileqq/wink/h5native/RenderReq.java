package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J5\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$RenderReq", "", "", "component1", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PlaceHolder;", "component2", "component3", "component4", "materialID", "placeHolders", QCircleWeakNetReporter.KEY_TRACE_ID, "callback", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$RenderReq;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getMaterialID", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PlaceHolder;", "getPlaceHolders", "()Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PlaceHolder;", "getTraceID", "getCallback", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PlaceHolder;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$RenderReq, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class RenderReq {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String callback;

    @NotNull
    private final String materialID;

    @Nullable
    private final PlaceHolder placeHolders;

    @NotNull
    private final String traceID;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$RenderReq$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$RenderReq;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$RenderReq$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final RenderReq fromJsonStr(@Nullable String jsonStr) {
            return (RenderReq) GsonUtils.f384219b.a(jsonStr, RenderReq.class);
        }

        Companion() {
        }
    }

    public RenderReq(@NotNull String materialID, @Nullable PlaceHolder placeHolder, @NotNull String traceID, @Nullable String str) {
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        this.materialID = materialID;
        this.placeHolders = placeHolder;
        this.traceID = traceID;
        this.callback = str;
    }

    public static /* synthetic */ RenderReq copy$default(RenderReq renderReq, String str, PlaceHolder placeHolder, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = renderReq.materialID;
        }
        if ((i3 & 2) != 0) {
            placeHolder = renderReq.placeHolders;
        }
        if ((i3 & 4) != 0) {
            str2 = renderReq.traceID;
        }
        if ((i3 & 8) != 0) {
            str3 = renderReq.callback;
        }
        return renderReq.copy(str, placeHolder, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMaterialID() {
        return this.materialID;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final PlaceHolder getPlaceHolders() {
        return this.placeHolders;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTraceID() {
        return this.traceID;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final RenderReq copy(@NotNull String materialID, @Nullable PlaceHolder placeHolders, @NotNull String traceID, @Nullable String callback) {
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        return new RenderReq(materialID, placeHolders, traceID, callback);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderReq)) {
            return false;
        }
        RenderReq renderReq = (RenderReq) other;
        if (Intrinsics.areEqual(this.materialID, renderReq.materialID) && Intrinsics.areEqual(this.placeHolders, renderReq.placeHolders) && Intrinsics.areEqual(this.traceID, renderReq.traceID) && Intrinsics.areEqual(this.callback, renderReq.callback)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final String getMaterialID() {
        return this.materialID;
    }

    @Nullable
    public final PlaceHolder getPlaceHolders() {
        return this.placeHolders;
    }

    @NotNull
    public final String getTraceID() {
        return this.traceID;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.materialID.hashCode() * 31;
        PlaceHolder placeHolder = this.placeHolders;
        int i3 = 0;
        if (placeHolder == null) {
            hashCode = 0;
        } else {
            hashCode = placeHolder.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.traceID.hashCode()) * 31;
        String str = this.callback;
        if (str != null) {
            i3 = str.hashCode();
        }
        return hashCode3 + i3;
    }

    @NotNull
    public String toString() {
        return "RenderReq(materialID=" + this.materialID + ", placeHolders=" + this.placeHolders + ", traceID=" + this.traceID + ", callback=" + this.callback + ")";
    }
}
