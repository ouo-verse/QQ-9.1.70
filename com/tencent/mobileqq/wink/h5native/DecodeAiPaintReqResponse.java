package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J)\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqResponse", "", "", "toJsonStr", "", "component1", "component2", "component3", "retCode", "retMsg", "decodedReq", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$DecodeAiPaintReqResponse;", "copy", "toString", "hashCode", "other", "", "equals", "I", "getRetCode", "()I", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "getDecodedReq", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$DecodeAiPaintReqResponse, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class DecodeAiPaintReqResponse {

    @Nullable
    private final String decodedReq;
    private final int retCode;

    @NotNull
    private final String retMsg;

    public DecodeAiPaintReqResponse(int i3, @NotNull String retMsg, @Nullable String str) {
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
        this.retCode = i3;
        this.retMsg = retMsg;
        this.decodedReq = str;
    }

    public static /* synthetic */ DecodeAiPaintReqResponse copy$default(DecodeAiPaintReqResponse decodeAiPaintReqResponse, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = decodeAiPaintReqResponse.retCode;
        }
        if ((i16 & 2) != 0) {
            str = decodeAiPaintReqResponse.retMsg;
        }
        if ((i16 & 4) != 0) {
            str2 = decodeAiPaintReqResponse.decodedReq;
        }
        return decodeAiPaintReqResponse.copy(i3, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getRetMsg() {
        return this.retMsg;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDecodedReq() {
        return this.decodedReq;
    }

    @NotNull
    public final DecodeAiPaintReqResponse copy(int retCode, @NotNull String retMsg, @Nullable String decodedReq) {
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
        return new DecodeAiPaintReqResponse(retCode, retMsg, decodedReq);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecodeAiPaintReqResponse)) {
            return false;
        }
        DecodeAiPaintReqResponse decodeAiPaintReqResponse = (DecodeAiPaintReqResponse) other;
        if (this.retCode == decodeAiPaintReqResponse.retCode && Intrinsics.areEqual(this.retMsg, decodeAiPaintReqResponse.retMsg) && Intrinsics.areEqual(this.decodedReq, decodeAiPaintReqResponse.decodedReq)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getDecodedReq() {
        return this.decodedReq;
    }

    public final int getRetCode() {
        return this.retCode;
    }

    @NotNull
    public final String getRetMsg() {
        return this.retMsg;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.retCode * 31) + this.retMsg.hashCode()) * 31;
        String str = this.decodedReq;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @Nullable
    public final String toJsonStr() {
        return GsonUtils.f384219b.c(this);
    }

    @NotNull
    public String toString() {
        return "DecodeAiPaintReqResponse(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", decodedReq=" + this.decodedReq + ")";
    }

    public /* synthetic */ DecodeAiPaintReqResponse(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? null : str2);
    }
}
