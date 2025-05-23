package com.tencent.state.square.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u00c6\u0003JC\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u001b\u001a\u00020\u0012J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/data/SquareIntimateInfo;", "", "mutualMarks", "", "Lcom/tencent/state/square/data/SquareMutualMark;", "iconUrl", "", "animUrls", "intimateDatas", "Lcom/tencent/state/square/data/SquareIntimateData;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAnimUrls", "()Ljava/util/List;", "getIconUrl", "()Ljava/lang/String;", "getIntimateDatas", "getMutualMarks", "canUpdate", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "component1", "component2", "component3", "component4", "copy", "equals", "other", "hasIntimate", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareIntimateInfo {
    private final List<String> animUrls;
    private final String iconUrl;
    private final List<SquareIntimateData> intimateDatas;
    private final List<SquareMutualMark> mutualMarks;

    public SquareIntimateInfo(List<SquareMutualMark> mutualMarks, String iconUrl, List<String> animUrls, List<SquareIntimateData> intimateDatas) {
        Intrinsics.checkNotNullParameter(mutualMarks, "mutualMarks");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(animUrls, "animUrls");
        Intrinsics.checkNotNullParameter(intimateDatas, "intimateDatas");
        this.mutualMarks = mutualMarks;
        this.iconUrl = iconUrl;
        this.animUrls = animUrls;
        this.intimateDatas = intimateDatas;
    }

    public final List<SquareMutualMark> component1() {
        return this.mutualMarks;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<String> component3() {
        return this.animUrls;
    }

    public final List<SquareIntimateData> component4() {
        return this.intimateDatas;
    }

    public final SquareIntimateInfo copy(List<SquareMutualMark> mutualMarks, String iconUrl, List<String> animUrls, List<SquareIntimateData> intimateDatas) {
        Intrinsics.checkNotNullParameter(mutualMarks, "mutualMarks");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(animUrls, "animUrls");
        Intrinsics.checkNotNullParameter(intimateDatas, "intimateDatas");
        return new SquareIntimateInfo(mutualMarks, iconUrl, animUrls, intimateDatas);
    }

    public final List<String> getAnimUrls() {
        return this.animUrls;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<SquareIntimateData> getIntimateDatas() {
        return this.intimateDatas;
    }

    public final List<SquareMutualMark> getMutualMarks() {
        return this.mutualMarks;
    }

    public final boolean hasIntimate() {
        return !this.intimateDatas.isEmpty();
    }

    public int hashCode() {
        List<SquareMutualMark> list = this.mutualMarks;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.iconUrl;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<String> list2 = this.animUrls;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<SquareIntimateData> list3 = this.intimateDatas;
        return hashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "SquareIntimateInfo(mutualMarks=" + this.mutualMarks + ", iconUrl=" + this.iconUrl + ", animUrls=" + this.animUrls + ", intimateDatas=" + this.intimateDatas + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareIntimateInfo)) {
            return false;
        }
        SquareIntimateInfo squareIntimateInfo = (SquareIntimateInfo) other;
        return Intrinsics.areEqual(this.mutualMarks, squareIntimateInfo.mutualMarks) && Intrinsics.areEqual(this.iconUrl, squareIntimateInfo.iconUrl) && Intrinsics.areEqual(this.animUrls, squareIntimateInfo.animUrls) && Intrinsics.areEqual(this.intimateDatas, squareIntimateInfo.intimateDatas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SquareIntimateInfo copy$default(SquareIntimateInfo squareIntimateInfo, List list, String str, List list2, List list3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = squareIntimateInfo.mutualMarks;
        }
        if ((i3 & 2) != 0) {
            str = squareIntimateInfo.iconUrl;
        }
        if ((i3 & 4) != 0) {
            list2 = squareIntimateInfo.animUrls;
        }
        if ((i3 & 8) != 0) {
            list3 = squareIntimateInfo.intimateDatas;
        }
        return squareIntimateInfo.copy(list, str, list2, list3);
    }

    public final boolean canUpdate(SquareIntimateInfo item) {
        String joinToString$default;
        String joinToString$default2;
        String joinToString$default3;
        String joinToString$default4;
        String joinToString$default5;
        String joinToString$default6;
        if (item == null || (!Intrinsics.areEqual(this.iconUrl, item.iconUrl))) {
            return true;
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.animUrls, ",", null, null, 0, null, null, 62, null);
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(item.animUrls, ",", null, null, 0, null, null, 62, null);
        if (!Intrinsics.areEqual(joinToString$default, joinToString$default2)) {
            return true;
        }
        joinToString$default3 = CollectionsKt___CollectionsKt.joinToString$default(this.mutualMarks, ",", null, null, 0, null, new Function1<SquareMutualMark, CharSequence>() { // from class: com.tencent.state.square.data.SquareIntimateInfo$canUpdate$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(SquareMutualMark it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 30, null);
        joinToString$default4 = CollectionsKt___CollectionsKt.joinToString$default(item.mutualMarks, ",", null, null, 0, null, new Function1<SquareMutualMark, CharSequence>() { // from class: com.tencent.state.square.data.SquareIntimateInfo$canUpdate$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(SquareMutualMark it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 30, null);
        if (!Intrinsics.areEqual(joinToString$default3, joinToString$default4)) {
            return true;
        }
        joinToString$default5 = CollectionsKt___CollectionsKt.joinToString$default(this.intimateDatas, ",", null, null, 0, null, new Function1<SquareIntimateData, CharSequence>() { // from class: com.tencent.state.square.data.SquareIntimateInfo$canUpdate$3
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(SquareIntimateData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 30, null);
        joinToString$default6 = CollectionsKt___CollectionsKt.joinToString$default(item.intimateDatas, ",", null, null, 0, null, new Function1<SquareIntimateData, CharSequence>() { // from class: com.tencent.state.square.data.SquareIntimateInfo$canUpdate$4
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(SquareIntimateData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 30, null);
        return Intrinsics.areEqual(joinToString$default5, joinToString$default6) ^ true;
    }
}
