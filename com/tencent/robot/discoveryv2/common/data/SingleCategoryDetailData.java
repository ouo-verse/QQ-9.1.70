package com.tencent.robot.discoveryv2.common.data;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000e\u0010\u0018R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u0013\u0010\u001dR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\u0016\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/data/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "categoryId", "", "b", "[B", "e", "()[B", "svrCookie", "c", "f", "svrDataVersion", "d", "Z", "()Z", "haveNextPage", "", "Ls34/b;", "Ljava/util/List;", "()Ljava/util/List;", "recommendRobotList", "", "Ljava/util/Set;", "()Ljava/util/Set;", "recommendRobotUinSet", "<init>", "(Ljava/lang/String;[BLjava/lang/String;ZLjava/util/List;Ljava/util/Set;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.discoveryv2.common.data.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SingleCategoryDetailData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String categoryId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final byte[] svrCookie;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String svrDataVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean haveNextPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<s34.b> recommendRobotList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Set<String> recommendRobotUinSet;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleCategoryDetailData(@NotNull String categoryId, @Nullable byte[] bArr, @NotNull String svrDataVersion, boolean z16, @NotNull List<? extends s34.b> recommendRobotList, @NotNull Set<String> recommendRobotUinSet) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(svrDataVersion, "svrDataVersion");
        Intrinsics.checkNotNullParameter(recommendRobotList, "recommendRobotList");
        Intrinsics.checkNotNullParameter(recommendRobotUinSet, "recommendRobotUinSet");
        this.categoryId = categoryId;
        this.svrCookie = bArr;
        this.svrDataVersion = svrDataVersion;
        this.haveNextPage = z16;
        this.recommendRobotList = recommendRobotList;
        this.recommendRobotUinSet = recommendRobotUinSet;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHaveNextPage() {
        return this.haveNextPage;
    }

    @NotNull
    public final List<s34.b> c() {
        return this.recommendRobotList;
    }

    @NotNull
    public final Set<String> d() {
        return this.recommendRobotUinSet;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final byte[] getSvrCookie() {
        return this.svrCookie;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleCategoryDetailData)) {
            return false;
        }
        SingleCategoryDetailData singleCategoryDetailData = (SingleCategoryDetailData) other;
        if (Intrinsics.areEqual(this.categoryId, singleCategoryDetailData.categoryId) && Intrinsics.areEqual(this.svrCookie, singleCategoryDetailData.svrCookie) && Intrinsics.areEqual(this.svrDataVersion, singleCategoryDetailData.svrDataVersion) && this.haveNextPage == singleCategoryDetailData.haveNextPage && Intrinsics.areEqual(this.recommendRobotList, singleCategoryDetailData.recommendRobotList) && Intrinsics.areEqual(this.recommendRobotUinSet, singleCategoryDetailData.recommendRobotUinSet)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSvrDataVersion() {
        return this.svrDataVersion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.categoryId.hashCode() * 31;
        byte[] bArr = this.svrCookie;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.svrDataVersion.hashCode()) * 31;
        boolean z16 = this.haveNextPage;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode3 + i3) * 31) + this.recommendRobotList.hashCode()) * 31) + this.recommendRobotUinSet.hashCode();
    }

    @NotNull
    public String toString() {
        return "SingleCategoryDetailData(categoryId=" + this.categoryId + ", svrCookie=" + Arrays.toString(this.svrCookie) + ", svrDataVersion=" + this.svrDataVersion + ", haveNextPage=" + this.haveNextPage + ", recommendRobotList=" + this.recommendRobotList + ", recommendRobotUinSet=" + this.recommendRobotUinSet + ")";
    }
}
