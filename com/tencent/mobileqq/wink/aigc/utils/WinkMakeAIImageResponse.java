package com.tencent.mobileqq.wink.aigc.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tBO\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u000f\u0010 R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b\u0019\u0010\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/utils/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "g", "()Z", "isSuccess", "", "b", "J", "d", "()J", "retCode", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "isRegenerate", "e", "f", "styleID", "materialID", "", "Lcom/tencent/mobileqq/wink/aigc/utils/c$a;", "Ljava/util/List;", "()Ljava/util/List;", "medias", h.F, "shareImageUrl", "<init>", "(ZJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.aigc.utils.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkMakeAIImageResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long retCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String msg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRegenerate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String styleID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String materialID;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Media> medias;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareImageUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/utils/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "imageUrl", "c", "imageUrlWithQRCode", "gender", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aigc.utils.c$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Media {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String imageUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String imageUrlWithQRCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String gender;

        public Media(@NotNull String imageUrl, @NotNull String imageUrlWithQRCode, @NotNull String gender) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(imageUrlWithQRCode, "imageUrlWithQRCode");
            Intrinsics.checkNotNullParameter(gender, "gender");
            this.imageUrl = imageUrl;
            this.imageUrlWithQRCode = imageUrlWithQRCode;
            this.gender = gender;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGender() {
            return this.gender;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getImageUrlWithQRCode() {
            return this.imageUrlWithQRCode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            if (Intrinsics.areEqual(this.imageUrl, media.imageUrl) && Intrinsics.areEqual(this.imageUrlWithQRCode, media.imageUrlWithQRCode) && Intrinsics.areEqual(this.gender, media.gender)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.imageUrl.hashCode() * 31) + this.imageUrlWithQRCode.hashCode()) * 31) + this.gender.hashCode();
        }

        @NotNull
        public String toString() {
            return "Media(imageUrl=" + this.imageUrl + ", imageUrlWithQRCode=" + this.imageUrlWithQRCode + ", gender=" + this.gender + ")";
        }
    }

    public WinkMakeAIImageResponse(boolean z16, long j3, @Nullable String str, boolean z17, @NotNull String styleID, @NotNull String materialID, @NotNull List<Media> medias, @NotNull String shareImageUrl) {
        Intrinsics.checkNotNullParameter(styleID, "styleID");
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        Intrinsics.checkNotNullParameter(medias, "medias");
        Intrinsics.checkNotNullParameter(shareImageUrl, "shareImageUrl");
        this.isSuccess = z16;
        this.retCode = j3;
        this.msg = str;
        this.isRegenerate = z17;
        this.styleID = styleID;
        this.materialID = materialID;
        this.medias = medias;
        this.shareImageUrl = shareImageUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMaterialID() {
        return this.materialID;
    }

    @NotNull
    public final List<Media> b() {
        return this.medias;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: d, reason: from getter */
    public final long getRetCode() {
        return this.retCode;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareImageUrl() {
        return this.shareImageUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkMakeAIImageResponse)) {
            return false;
        }
        WinkMakeAIImageResponse winkMakeAIImageResponse = (WinkMakeAIImageResponse) other;
        if (this.isSuccess == winkMakeAIImageResponse.isSuccess && this.retCode == winkMakeAIImageResponse.retCode && Intrinsics.areEqual(this.msg, winkMakeAIImageResponse.msg) && this.isRegenerate == winkMakeAIImageResponse.isRegenerate && Intrinsics.areEqual(this.styleID, winkMakeAIImageResponse.styleID) && Intrinsics.areEqual(this.materialID, winkMakeAIImageResponse.materialID) && Intrinsics.areEqual(this.medias, winkMakeAIImageResponse.medias) && Intrinsics.areEqual(this.shareImageUrl, winkMakeAIImageResponse.shareImageUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getStyleID() {
        return this.styleID;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isSuccess;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + androidx.fragment.app.a.a(this.retCode)) * 31;
        String str = this.msg;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        boolean z17 = this.isRegenerate;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((((i16 + i3) * 31) + this.styleID.hashCode()) * 31) + this.materialID.hashCode()) * 31) + this.medias.hashCode()) * 31) + this.shareImageUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "WinkMakeAIImageResponse(isSuccess=" + this.isSuccess + ", retCode=" + this.retCode + ", msg=" + this.msg + ", isRegenerate=" + this.isRegenerate + ", styleID=" + this.styleID + ", materialID=" + this.materialID + ", medias=" + this.medias + ", shareImageUrl=" + this.shareImageUrl + ")";
    }
}
