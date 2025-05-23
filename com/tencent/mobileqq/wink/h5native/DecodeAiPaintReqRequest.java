package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J)\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqRequest", "", "", "component1", "component2", "component3", "safeReq", "encodedReq", "callback", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqRequest;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getSafeReq", "()Ljava/lang/String;", "getEncodedReq", "getCallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$DecodeAiPaintReqRequest, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class DecodeAiPaintReqRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String callback;

    @NotNull
    private final String encodedReq;

    @NotNull
    private final String safeReq;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqRequest$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqRequest;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$DecodeAiPaintReqRequest$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final DecodeAiPaintReqRequest fromJsonStr(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            return (DecodeAiPaintReqRequest) GsonUtils.f384219b.a(jsonStr, DecodeAiPaintReqRequest.class);
        }

        Companion() {
        }
    }

    public DecodeAiPaintReqRequest(@NotNull String safeReq, @NotNull String encodedReq, @Nullable String str) {
        Intrinsics.checkNotNullParameter(safeReq, "safeReq");
        Intrinsics.checkNotNullParameter(encodedReq, "encodedReq");
        this.safeReq = safeReq;
        this.encodedReq = encodedReq;
        this.callback = str;
    }

    public static /* synthetic */ DecodeAiPaintReqRequest copy$default(DecodeAiPaintReqRequest decodeAiPaintReqRequest, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = decodeAiPaintReqRequest.safeReq;
        }
        if ((i3 & 2) != 0) {
            str2 = decodeAiPaintReqRequest.encodedReq;
        }
        if ((i3 & 4) != 0) {
            str3 = decodeAiPaintReqRequest.callback;
        }
        return decodeAiPaintReqRequest.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSafeReq() {
        return this.safeReq;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getEncodedReq() {
        return this.encodedReq;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final DecodeAiPaintReqRequest copy(@NotNull String safeReq, @NotNull String encodedReq, @Nullable String callback) {
        Intrinsics.checkNotNullParameter(safeReq, "safeReq");
        Intrinsics.checkNotNullParameter(encodedReq, "encodedReq");
        return new DecodeAiPaintReqRequest(safeReq, encodedReq, callback);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecodeAiPaintReqRequest)) {
            return false;
        }
        DecodeAiPaintReqRequest decodeAiPaintReqRequest = (DecodeAiPaintReqRequest) other;
        if (Intrinsics.areEqual(this.safeReq, decodeAiPaintReqRequest.safeReq) && Intrinsics.areEqual(this.encodedReq, decodeAiPaintReqRequest.encodedReq) && Intrinsics.areEqual(this.callback, decodeAiPaintReqRequest.callback)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final String getEncodedReq() {
        return this.encodedReq;
    }

    @NotNull
    public final String getSafeReq() {
        return this.safeReq;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.safeReq.hashCode() * 31) + this.encodedReq.hashCode()) * 31;
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
        return "DecodeAiPaintReqRequest(safeReq=" + this.safeReq + ", encodedReq=" + this.encodedReq + ", callback=" + this.callback + ")";
    }
}
