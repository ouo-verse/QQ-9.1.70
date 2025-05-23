package com.tencent.biz.richframework.localupload.recommend.scanner;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/scanner/RFWMediaScanResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "isSuccess", "Z", "()Z", "Ljava/util/ArrayList;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaList", "Ljava/util/ArrayList;", "getMediaList", "()Ljava/util/ArrayList;", "<init>", "(ZLjava/util/ArrayList;)V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final /* data */ class RFWMediaScanResult {
    private final boolean isSuccess;

    @NotNull
    private final ArrayList<RFWMediaInfo> mediaList;

    public RFWMediaScanResult() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RFWMediaScanResult)) {
            return false;
        }
        RFWMediaScanResult rFWMediaScanResult = (RFWMediaScanResult) other;
        if (this.isSuccess == rFWMediaScanResult.isSuccess && Intrinsics.areEqual(this.mediaList, rFWMediaScanResult.mediaList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<RFWMediaInfo> getMediaList() {
        return this.mediaList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.mediaList.hashCode();
    }

    /* renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    @NotNull
    public String toString() {
        return "RFWMediaScanResult(isSuccess=" + this.isSuccess + ", mediaList=" + this.mediaList + ")";
    }

    public RFWMediaScanResult(boolean z16, @NotNull ArrayList<RFWMediaInfo> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.isSuccess = z16;
        this.mediaList = mediaList;
    }

    public /* synthetic */ RFWMediaScanResult(boolean z16, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? new ArrayList() : arrayList);
    }
}
