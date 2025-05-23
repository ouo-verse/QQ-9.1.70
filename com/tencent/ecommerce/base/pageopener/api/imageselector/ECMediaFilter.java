package com.tencent.ecommerce.base.pageopener.api.imageselector;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/base/pageopener/api/imageselector/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECMediaMimeType;", "a", "Ljava/util/List;", "()Ljava/util/List;", "supportImageType", "<init>", "(Ljava/util/List;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.pageopener.api.imageselector.b, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECMediaFilter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<ECMediaMimeType> supportImageType;

    public ECMediaFilter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<ECMediaMimeType> a() {
        return this.supportImageType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof ECMediaFilter) || !Intrinsics.areEqual(this.supportImageType, ((ECMediaFilter) other).supportImageType)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        List<ECMediaMimeType> list = this.supportImageType;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ECMediaFilter(supportImageType=" + this.supportImageType + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECMediaFilter(@NotNull List<? extends ECMediaMimeType> list) {
        this.supportImageType = list;
    }

    public /* synthetic */ ECMediaFilter(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new ECMediaMimeType[]{ECMediaMimeType.IMAGE_JPEG, ECMediaMimeType.IMAGE_PNG, ECMediaMimeType.IMAGE_HEIF}) : list);
    }
}
