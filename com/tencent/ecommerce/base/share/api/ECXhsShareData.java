package com.tencent.ecommerce.base.share.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "imageUrls", "c", "desc", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "()Lcom/tencent/ecommerce/base/share/api/ShareType;", "shareType", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/ecommerce/base/share/api/ShareType;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.share.api.g, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECXhsShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> imageUrls;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ShareType shareType;

    public ECXhsShareData(@NotNull String str, @NotNull List<String> list, @NotNull String str2, @NotNull ShareType shareType) {
        this.title = str;
        this.imageUrls = list;
        this.desc = str2;
        this.shareType = shareType;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final List<String> b() {
        return this.imageUrls;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ShareType getShareType() {
        return this.shareType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECXhsShareData) {
                ECXhsShareData eCXhsShareData = (ECXhsShareData) other;
                if (!Intrinsics.areEqual(this.title, eCXhsShareData.title) || !Intrinsics.areEqual(this.imageUrls, eCXhsShareData.imageUrls) || !Intrinsics.areEqual(this.desc, eCXhsShareData.desc) || !Intrinsics.areEqual(this.shareType, eCXhsShareData.shareType)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.title;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        List<String> list = this.imageUrls;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.desc;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        ShareType shareType = this.shareType;
        if (shareType != null) {
            i18 = shareType.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "ECXhsShareData(title=" + this.title + ", imageUrls=" + this.imageUrls + ", desc=" + this.desc + ", shareType=" + this.shareType + ")";
    }
}
