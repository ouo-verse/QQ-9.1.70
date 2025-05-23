package com.tencent.ecommerce.base.share.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\t\u0010\u001bR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "title", "b", "c", "imageUrl", "desc", "d", "e", "shareUrl", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "()Lcom/tencent/ecommerce/base/share/api/ShareType;", "shareType", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "g", "Z", "()Z", "useQCircleShare", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/base/share/api/ShareType;Landroid/graphics/Bitmap;Z)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.share.api.f, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECWxShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String imageUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ShareType shareType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bitmap bitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean useQCircleShare;

    public ECWxShareData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ShareType shareType, @Nullable Bitmap bitmap, boolean z16) {
        this.title = str;
        this.imageUrl = str2;
        this.desc = str3;
        this.shareUrl = str4;
        this.shareType = shareType;
        this.bitmap = bitmap;
        this.useQCircleShare = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ShareType getShareType() {
        return this.shareType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECWxShareData) {
                ECWxShareData eCWxShareData = (ECWxShareData) other;
                if (!Intrinsics.areEqual(this.title, eCWxShareData.title) || !Intrinsics.areEqual(this.imageUrl, eCWxShareData.imageUrl) || !Intrinsics.areEqual(this.desc, eCWxShareData.desc) || !Intrinsics.areEqual(this.shareUrl, eCWxShareData.shareUrl) || !Intrinsics.areEqual(this.shareType, eCWxShareData.shareType) || !Intrinsics.areEqual(this.bitmap, eCWxShareData.bitmap) || this.useQCircleShare != eCWxShareData.useQCircleShare) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getUseQCircleShare() {
        return this.useQCircleShare;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.title;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        String str2 = this.imageUrl;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str3 = this.desc;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str4 = this.shareUrl;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        ShareType shareType = this.shareType;
        if (shareType != null) {
            i19 = shareType.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            i26 = bitmap.hashCode();
        }
        int i38 = (i37 + i26) * 31;
        boolean z16 = this.useQCircleShare;
        int i39 = z16;
        if (z16 != 0) {
            i39 = 1;
        }
        return i38 + i39;
    }

    @NotNull
    public String toString() {
        return "ECWxShareData(title=" + this.title + ", imageUrl=" + this.imageUrl + ", desc=" + this.desc + ", shareUrl=" + this.shareUrl + ", shareType=" + this.shareType + ", bitmap=" + this.bitmap + ", useQCircleShare=" + this.useQCircleShare + ")";
    }

    public /* synthetic */ ECWxShareData(String str, String str2, String str3, String str4, ShareType shareType, Bitmap bitmap, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? ShareType.IMAGE_AND_TEXT_SHARE_TYPE : shareType, (i3 & 32) != 0 ? null : bitmap, (i3 & 64) != 0 ? true : z16);
    }
}
