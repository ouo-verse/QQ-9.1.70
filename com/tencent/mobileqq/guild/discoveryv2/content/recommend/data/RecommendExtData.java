package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J=\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "", "", "traceId", "", "refreshCnt", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProExtra;", "gProExtra", "", "tianShuAdItem", "index", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "b", "I", "getRefreshCnt", "()I", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProExtra;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProExtra;", "setGProExtra", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProExtra;)V", "d", "[B", "e", "()[B", "g", "(I)V", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qqguildsdk/data/genc/IGProExtra;[BI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.r, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class RecommendExtData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int refreshCnt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private IGProExtra gProExtra;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final byte[] tianShuAdItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int index;

    public RecommendExtData(@NotNull String traceId, int i3, @Nullable IGProExtra iGProExtra, @NotNull byte[] tianShuAdItem, int i16) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(tianShuAdItem, "tianShuAdItem");
        this.traceId = traceId;
        this.refreshCnt = i3;
        this.gProExtra = iGProExtra;
        this.tianShuAdItem = tianShuAdItem;
        this.index = i16;
    }

    public static /* synthetic */ RecommendExtData b(RecommendExtData recommendExtData, String str, int i3, IGProExtra iGProExtra, byte[] bArr, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = recommendExtData.traceId;
        }
        if ((i17 & 2) != 0) {
            i3 = recommendExtData.refreshCnt;
        }
        int i18 = i3;
        if ((i17 & 4) != 0) {
            iGProExtra = recommendExtData.gProExtra;
        }
        IGProExtra iGProExtra2 = iGProExtra;
        if ((i17 & 8) != 0) {
            bArr = recommendExtData.tianShuAdItem;
        }
        byte[] bArr2 = bArr;
        if ((i17 & 16) != 0) {
            i16 = recommendExtData.index;
        }
        return recommendExtData.a(str, i18, iGProExtra2, bArr2, i16);
    }

    @NotNull
    public final RecommendExtData a(@NotNull String traceId, int refreshCnt, @Nullable IGProExtra gProExtra, @NotNull byte[] tianShuAdItem, int index) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(tianShuAdItem, "tianShuAdItem");
        return new RecommendExtData(traceId, refreshCnt, gProExtra, tianShuAdItem, index);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final IGProExtra getGProExtra() {
        return this.gProExtra;
    }

    /* renamed from: d, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final byte[] getTianShuAdItem() {
        return this.tianShuAdItem;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendExtData)) {
            return false;
        }
        RecommendExtData recommendExtData = (RecommendExtData) other;
        if (Intrinsics.areEqual(this.traceId, recommendExtData.traceId) && this.refreshCnt == recommendExtData.refreshCnt && Intrinsics.areEqual(this.gProExtra, recommendExtData.gProExtra) && Intrinsics.areEqual(this.tianShuAdItem, recommendExtData.tianShuAdItem) && this.index == recommendExtData.index) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final void g(int i3) {
        this.index = i3;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.traceId.hashCode() * 31) + this.refreshCnt) * 31;
        IGProExtra iGProExtra = this.gProExtra;
        if (iGProExtra == null) {
            hashCode = 0;
        } else {
            hashCode = iGProExtra.hashCode();
        }
        return ((((hashCode2 + hashCode) * 31) + Arrays.hashCode(this.tianShuAdItem)) * 31) + this.index;
    }

    @NotNull
    public String toString() {
        return "RecommendExtData(traceId=" + this.traceId + ", refreshCnt=" + this.refreshCnt + ", gProExtra=" + this.gProExtra + ", tianShuAdItem=" + Arrays.toString(this.tianShuAdItem) + ", index=" + this.index + ")";
    }

    public /* synthetic */ RecommendExtData(String str, int i3, IGProExtra iGProExtra, byte[] bArr, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i17 & 4) != 0 ? null : iGProExtra, (i17 & 8) != 0 ? new byte[0] : bArr, (i17 & 16) != 0 ? 0 : i16);
    }
}
