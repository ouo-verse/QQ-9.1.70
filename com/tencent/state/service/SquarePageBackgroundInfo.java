package com.tencent.state.service;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0001J\u0006\u0010\u0016\u001a\u00020\u0000J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/service/SquarePageBackgroundInfo;", "", "topUrl", "", "backgroundUrl", "gradientArr", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBackgroundUrl", "()Ljava/lang/String;", "setBackgroundUrl", "(Ljava/lang/String;)V", "getGradientArr", "()Ljava/util/List;", "setGradientArr", "(Ljava/util/List;)V", "getTopUrl", "setTopUrl", "component1", "component2", "component3", "copy", "copyDepth", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquarePageBackgroundInfo {
    private String backgroundUrl;
    private List<String> gradientArr;
    private String topUrl;

    public SquarePageBackgroundInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTopUrl() {
        return this.topUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final List<String> component3() {
        return this.gradientArr;
    }

    public final SquarePageBackgroundInfo copy(String topUrl, String backgroundUrl, List<String> gradientArr) {
        Intrinsics.checkNotNullParameter(topUrl, "topUrl");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(gradientArr, "gradientArr");
        return new SquarePageBackgroundInfo(topUrl, backgroundUrl, gradientArr);
    }

    public final SquarePageBackgroundInfo copyDepth() {
        return new SquarePageBackgroundInfo(this.topUrl, this.backgroundUrl, this.gradientArr);
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final List<String> getGradientArr() {
        return this.gradientArr;
    }

    public final String getTopUrl() {
        return this.topUrl;
    }

    public int hashCode() {
        String str = this.topUrl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.backgroundUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.gradientArr;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setBackgroundUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundUrl = str;
    }

    public final void setGradientArr(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.gradientArr = list;
    }

    public final void setTopUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topUrl = str;
    }

    public String toString() {
        return "SquarePageBackgroundInfo(topUrl=" + this.topUrl + ", backgroundUrl=" + this.backgroundUrl + ", gradientArr=" + this.gradientArr + ")";
    }

    public SquarePageBackgroundInfo(String topUrl, String backgroundUrl, List<String> gradientArr) {
        Intrinsics.checkNotNullParameter(topUrl, "topUrl");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(gradientArr, "gradientArr");
        this.topUrl = topUrl;
        this.backgroundUrl = backgroundUrl;
        this.gradientArr = gradientArr;
    }

    public /* synthetic */ SquarePageBackgroundInfo(String str, String str2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new ArrayList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquarePageBackgroundInfo)) {
            return false;
        }
        SquarePageBackgroundInfo squarePageBackgroundInfo = (SquarePageBackgroundInfo) other;
        return Intrinsics.areEqual(this.topUrl, squarePageBackgroundInfo.topUrl) && Intrinsics.areEqual(this.backgroundUrl, squarePageBackgroundInfo.backgroundUrl) && Intrinsics.areEqual(this.gradientArr, squarePageBackgroundInfo.gradientArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SquarePageBackgroundInfo copy$default(SquarePageBackgroundInfo squarePageBackgroundInfo, String str, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squarePageBackgroundInfo.topUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = squarePageBackgroundInfo.backgroundUrl;
        }
        if ((i3 & 4) != 0) {
            list = squarePageBackgroundInfo.gradientArr;
        }
        return squarePageBackgroundInfo.copy(str, str2, list);
    }
}
