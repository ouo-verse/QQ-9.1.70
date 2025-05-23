package com.tencent.mobileqq.wink.picker.core.repository;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016JO\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\n\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "", "", "toString", "albumId", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", "isSuccess", "hasMore", "", "payload", "a", "", "hashCode", "other", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "b", "Ljava/util/List;", "e", "()Ljava/util/List;", "Z", "g", "()Z", "d", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZLjava/util/Map;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class b {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @NotNull
    private final String albumId;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final boolean hasMore;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    @Nullable
    private final Map<String, Object> payload;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull String albumId, @NotNull List<? extends LocalMediaInfo> media, boolean z16, boolean z17, @Nullable Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(media, "media");
        this.albumId = albumId;
        this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String = media;
        this.isSuccess = z16;
        this.hasMore = z17;
        this.payload = map;
    }

    public static /* synthetic */ b b(b bVar, String str, List list, boolean z16, boolean z17, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bVar.albumId;
        }
        if ((i3 & 2) != 0) {
            list = bVar.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String;
        }
        List list2 = list;
        if ((i3 & 4) != 0) {
            z16 = bVar.isSuccess;
        }
        boolean z18 = z16;
        if ((i3 & 8) != 0) {
            z17 = bVar.hasMore;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            map = bVar.payload;
        }
        return bVar.a(str, list2, z18, z19, map);
    }

    @NotNull
    public final b a(@NotNull String albumId, @NotNull List<? extends LocalMediaInfo> r95, boolean isSuccess, boolean hasMore, @Nullable Map<String, Object> payload) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(r95, "media");
        return new b(albumId, r95, isSuccess, hasMore, payload);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final List<LocalMediaInfo> e() {
        return this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.albumId, bVar.albumId) && Intrinsics.areEqual(this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String, bVar.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String) && this.isSuccess == bVar.isSuccess && this.hasMore == bVar.hasMore && Intrinsics.areEqual(this.payload, bVar.payload)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Map<String, Object> f() {
        return this.payload;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.albumId.hashCode() * 31) + this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String.hashCode()) * 31;
        boolean z16 = this.isSuccess;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.hasMore;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        Map<String, Object> map = this.payload;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        return i18 + hashCode;
    }

    @NotNull
    public String toString() {
        return "albumId=" + this.albumId + ", isSuccess=" + this.isSuccess + ", hasMore=" + this.hasMore + ", media.size=" + this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String.size() + ", payload=" + this.payload;
    }

    public /* synthetic */ b(String str, List list, boolean z16, boolean z17, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, z16, z17, (i3 & 16) != 0 ? null : map);
    }
}
