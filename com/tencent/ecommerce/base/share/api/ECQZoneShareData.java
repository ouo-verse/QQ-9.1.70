package com.tencent.ecommerce.base.share.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001a\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "title", "b", "desc", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "imageUrls", "d", "e", "shareUrl", "comment", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "f", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "()Lcom/tencent/ecommerce/base/share/api/ShareType;", "shareType", "thirdPartyAppId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/base/share/api/ShareType;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.share.api.d, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECQZoneShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> imageUrls;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String comment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ShareType shareType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String thirdPartyAppId;

    public ECQZoneShareData(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull String str3, @NotNull String str4, @NotNull ShareType shareType, @NotNull String str5) {
        this.title = str;
        this.desc = str2;
        this.imageUrls = list;
        this.shareUrl = str3;
        this.comment = str4;
        this.shareType = shareType;
        this.thirdPartyAppId = str5;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final List<String> c() {
        return this.imageUrls;
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
            if (other instanceof ECQZoneShareData) {
                ECQZoneShareData eCQZoneShareData = (ECQZoneShareData) other;
                if (!Intrinsics.areEqual(this.title, eCQZoneShareData.title) || !Intrinsics.areEqual(this.desc, eCQZoneShareData.desc) || !Intrinsics.areEqual(this.imageUrls, eCQZoneShareData.imageUrls) || !Intrinsics.areEqual(this.shareUrl, eCQZoneShareData.shareUrl) || !Intrinsics.areEqual(this.comment, eCQZoneShareData.comment) || !Intrinsics.areEqual(this.shareType, eCQZoneShareData.shareType) || !Intrinsics.areEqual(this.thirdPartyAppId, eCQZoneShareData.thirdPartyAppId)) {
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
    public final String getThirdPartyAppId() {
        return this.thirdPartyAppId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        String str = this.title;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = i3 * 31;
        String str2 = this.desc;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        List<String> list = this.imageUrls;
        if (list != null) {
            i17 = list.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        String str3 = this.shareUrl;
        if (str3 != null) {
            i18 = str3.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        String str4 = this.comment;
        if (str4 != null) {
            i19 = str4.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        ShareType shareType = this.shareType;
        if (shareType != null) {
            i26 = shareType.hashCode();
        } else {
            i26 = 0;
        }
        int i39 = (i38 + i26) * 31;
        String str5 = this.thirdPartyAppId;
        if (str5 != null) {
            i27 = str5.hashCode();
        }
        return i39 + i27;
    }

    @NotNull
    public String toString() {
        return "ECQZoneShareData(title=" + this.title + ", desc=" + this.desc + ", imageUrls=" + this.imageUrls + ", shareUrl=" + this.shareUrl + ", comment=" + this.comment + ", shareType=" + this.shareType + ", thirdPartyAppId=" + this.thirdPartyAppId + ")";
    }

    public /* synthetic */ ECQZoneShareData(String str, String str2, List list, String str3, String str4, ShareType shareType, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, list, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? ShareType.IMAGE_AND_TEXT_SHARE_TYPE : shareType, (i3 & 64) != 0 ? "" : str5);
    }
}
