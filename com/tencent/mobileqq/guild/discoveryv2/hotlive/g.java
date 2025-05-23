package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "setErrorCode", "(I)V", "errorCode", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "c", "Ljava/util/List;", "()Ljava/util/List;", "hotLives", "d", "traceId", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProRecommendItem> hotLives;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String traceId;

    public g(int i3, @NotNull String errMsg, @NotNull List<IGProRecommendItem> hotLives, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(hotLives, "hotLives");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.errorCode = i3;
        this.errMsg = errMsg;
        this.hotLives = hotLives;
        this.traceId = traceId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final List<IGProRecommendItem> c() {
        return this.hotLives;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (this.errorCode == gVar.errorCode && Intrinsics.areEqual(this.errMsg, gVar.errMsg) && Intrinsics.areEqual(this.hotLives, gVar.hotLives) && Intrinsics.areEqual(this.traceId, gVar.traceId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.errorCode * 31) + this.errMsg.hashCode()) * 31) + this.hotLives.hashCode()) * 31) + this.traceId.hashCode();
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int i3 = this.errorCode;
        String str = this.errMsg;
        String str2 = this.traceId;
        List<IGProRecommendItem> list = this.hotLives;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProRecommendItem iGProRecommendItem : list) {
            arrayList.add(iGProRecommendItem.getItemId() + "-" + iGProRecommendItem.getItemType());
        }
        return "RecommendItemsResult(errorCode=" + i3 + ", errMsg=" + str + ", traceId=" + str2 + "hotLives=" + arrayList;
    }

    public /* synthetic */ g(int i3, String str, List list, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? new ArrayList() : list, (i16 & 8) != 0 ? "" : str2);
    }
}
