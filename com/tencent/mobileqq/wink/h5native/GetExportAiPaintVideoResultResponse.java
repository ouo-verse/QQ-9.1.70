package com.tencent.mobileqq.wink.h5native;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003JA\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001eR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001eR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001e\u00a8\u0006%"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultResponse", "", "", "toJsonStr", "", "component1", "component2", "component3", "component4", "component5", "retCode", "retMsg", AppConstants.Key.KEY_QZONE_VIDEO_URL, "videoUrlWithQrcode", "coverImageBase64", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$GetExportAiPaintVideoResultResponse;", "copy", "toString", "hashCode", "other", "", "equals", "I", "getRetCode", "()I", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "getVideoUrl", "setVideoUrl", "(Ljava/lang/String;)V", "getVideoUrlWithQrcode", "setVideoUrlWithQrcode", "getCoverImageBase64", "setCoverImageBase64", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$GetExportAiPaintVideoResultResponse, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GetExportAiPaintVideoResultResponse {

    @Nullable
    private String coverImageBase64;
    private final int retCode;

    @NotNull
    private final String retMsg;

    @Nullable
    private String videoUrl;

    @Nullable
    private String videoUrlWithQrcode;

    public GetExportAiPaintVideoResultResponse(int i3, @NotNull String retMsg, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
        this.retCode = i3;
        this.retMsg = retMsg;
        this.videoUrl = str;
        this.videoUrlWithQrcode = str2;
        this.coverImageBase64 = str3;
    }

    public static /* synthetic */ GetExportAiPaintVideoResultResponse copy$default(GetExportAiPaintVideoResultResponse getExportAiPaintVideoResultResponse, int i3, String str, String str2, String str3, String str4, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = getExportAiPaintVideoResultResponse.retCode;
        }
        if ((i16 & 2) != 0) {
            str = getExportAiPaintVideoResultResponse.retMsg;
        }
        String str5 = str;
        if ((i16 & 4) != 0) {
            str2 = getExportAiPaintVideoResultResponse.videoUrl;
        }
        String str6 = str2;
        if ((i16 & 8) != 0) {
            str3 = getExportAiPaintVideoResultResponse.videoUrlWithQrcode;
        }
        String str7 = str3;
        if ((i16 & 16) != 0) {
            str4 = getExportAiPaintVideoResultResponse.coverImageBase64;
        }
        return getExportAiPaintVideoResultResponse.copy(i3, str5, str6, str7, str4);
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
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getVideoUrlWithQrcode() {
        return this.videoUrlWithQrcode;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCoverImageBase64() {
        return this.coverImageBase64;
    }

    @NotNull
    public final GetExportAiPaintVideoResultResponse copy(int retCode, @NotNull String retMsg, @Nullable String videoUrl, @Nullable String videoUrlWithQrcode, @Nullable String coverImageBase64) {
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
        return new GetExportAiPaintVideoResultResponse(retCode, retMsg, videoUrl, videoUrlWithQrcode, coverImageBase64);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetExportAiPaintVideoResultResponse)) {
            return false;
        }
        GetExportAiPaintVideoResultResponse getExportAiPaintVideoResultResponse = (GetExportAiPaintVideoResultResponse) other;
        if (this.retCode == getExportAiPaintVideoResultResponse.retCode && Intrinsics.areEqual(this.retMsg, getExportAiPaintVideoResultResponse.retMsg) && Intrinsics.areEqual(this.videoUrl, getExportAiPaintVideoResultResponse.videoUrl) && Intrinsics.areEqual(this.videoUrlWithQrcode, getExportAiPaintVideoResultResponse.videoUrlWithQrcode) && Intrinsics.areEqual(this.coverImageBase64, getExportAiPaintVideoResultResponse.coverImageBase64)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCoverImageBase64() {
        return this.coverImageBase64;
    }

    public final int getRetCode() {
        return this.retCode;
    }

    @NotNull
    public final String getRetMsg() {
        return this.retMsg;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    public final String getVideoUrlWithQrcode() {
        return this.videoUrlWithQrcode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((this.retCode * 31) + this.retMsg.hashCode()) * 31;
        String str = this.videoUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        String str2 = this.videoUrlWithQrcode;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.coverImageBase64;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    public final void setCoverImageBase64(@Nullable String str) {
        this.coverImageBase64 = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    public final void setVideoUrlWithQrcode(@Nullable String str) {
        this.videoUrlWithQrcode = str;
    }

    @Nullable
    public final String toJsonStr() {
        return GsonUtils.f384219b.c(this);
    }

    @NotNull
    public String toString() {
        return "GetExportAiPaintVideoResultResponse(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", videoUrl=" + this.videoUrl + ", videoUrlWithQrcode=" + this.videoUrlWithQrcode + ", coverImageBase64=" + this.coverImageBase64 + ")";
    }

    public /* synthetic */ GetExportAiPaintVideoResultResponse(int i3, String str, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : str3, (i16 & 16) != 0 ? null : str4);
    }
}
