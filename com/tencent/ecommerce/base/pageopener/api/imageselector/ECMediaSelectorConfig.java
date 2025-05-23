package com.tencent.ecommerce.base.pageopener.api.imageselector;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/base/pageopener/api/imageselector/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECTabType;", "a", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECTabType;", "c", "()Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECTabType;", "setMediaTabType", "(Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECTabType;)V", "mediaTabType", "b", "I", "()I", "maxSelectedMediaNum", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "Ljava/util/List;", "()Ljava/util/List;", "alreadySelectedMedia", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/b;", "d", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/b;", "()Lcom/tencent/ecommerce/base/pageopener/api/imageselector/b;", "queryMediaFilter", "<init>", "(Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECTabType;ILjava/util/List;Lcom/tencent/ecommerce/base/pageopener/api/imageselector/b;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.pageopener.api.imageselector.d, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECMediaSelectorConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ECTabType mediaTabType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxSelectedMediaNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<ECMediaInfo> alreadySelectedMedia;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ECMediaFilter queryMediaFilter;

    public ECMediaSelectorConfig() {
        this(null, 0, null, null, 15, null);
    }

    @NotNull
    public final List<ECMediaInfo> a() {
        return this.alreadySelectedMedia;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxSelectedMediaNum() {
        return this.maxSelectedMediaNum;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ECTabType getMediaTabType() {
        return this.mediaTabType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ECMediaFilter getQueryMediaFilter() {
        return this.queryMediaFilter;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECMediaSelectorConfig) {
                ECMediaSelectorConfig eCMediaSelectorConfig = (ECMediaSelectorConfig) other;
                if (!Intrinsics.areEqual(this.mediaTabType, eCMediaSelectorConfig.mediaTabType) || this.maxSelectedMediaNum != eCMediaSelectorConfig.maxSelectedMediaNum || !Intrinsics.areEqual(this.alreadySelectedMedia, eCMediaSelectorConfig.alreadySelectedMedia) || !Intrinsics.areEqual(this.queryMediaFilter, eCMediaSelectorConfig.queryMediaFilter)) {
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
        ECTabType eCTabType = this.mediaTabType;
        int i17 = 0;
        if (eCTabType != null) {
            i3 = eCTabType.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = ((i3 * 31) + this.maxSelectedMediaNum) * 31;
        List<ECMediaInfo> list = this.alreadySelectedMedia;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        ECMediaFilter eCMediaFilter = this.queryMediaFilter;
        if (eCMediaFilter != null) {
            i17 = eCMediaFilter.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "ECMediaSelectorConfig(mediaTabType=" + this.mediaTabType + ", maxSelectedMediaNum=" + this.maxSelectedMediaNum + ", alreadySelectedMedia=" + this.alreadySelectedMedia + ", queryMediaFilter=" + this.queryMediaFilter + ")";
    }

    public ECMediaSelectorConfig(@NotNull ECTabType eCTabType, int i3, @NotNull List<ECMediaInfo> list, @NotNull ECMediaFilter eCMediaFilter) {
        this.mediaTabType = eCTabType;
        this.maxSelectedMediaNum = i3;
        this.alreadySelectedMedia = list;
        this.queryMediaFilter = eCMediaFilter;
    }

    public /* synthetic */ ECMediaSelectorConfig(ECTabType eCTabType, int i3, List list, ECMediaFilter eCMediaFilter, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? ECTabType.ALL_MEDIA : eCTabType, (i16 & 2) != 0 ? Integer.MAX_VALUE : i3, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 8) != 0 ? new ECMediaFilter(null, 1, 0 == true ? 1 : 0) : eCMediaFilter);
    }
}
