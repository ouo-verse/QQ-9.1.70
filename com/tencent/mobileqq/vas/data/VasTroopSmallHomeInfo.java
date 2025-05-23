package com.tencent.mobileqq.vas.data;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", ViewStickEventHelper.IS_SHOW, "()Z", "b", "Ljava/lang/String;", "getAdvIconUrl", "()Ljava/lang/String;", "advIconUrl", "c", "I", "getIntervalTime", "()I", "intervalTime", "<init>", "(ZLjava/lang/String;I)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.data.g, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasTroopSmallHomeInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String advIconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int intervalTime;

    public VasTroopSmallHomeInfo() {
        this(false, null, 0, 7, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasTroopSmallHomeInfo)) {
            return false;
        }
        VasTroopSmallHomeInfo vasTroopSmallHomeInfo = (VasTroopSmallHomeInfo) other;
        if (this.isShow == vasTroopSmallHomeInfo.isShow && Intrinsics.areEqual(this.advIconUrl, vasTroopSmallHomeInfo.advIconUrl) && this.intervalTime == vasTroopSmallHomeInfo.intervalTime) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isShow;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.advIconUrl.hashCode()) * 31) + this.intervalTime;
    }

    @NotNull
    public String toString() {
        return "VasTroopSmallHomeInfo(isShow=" + this.isShow + ", advIconUrl=" + this.advIconUrl + ", intervalTime=" + this.intervalTime + ')';
    }

    public VasTroopSmallHomeInfo(boolean z16, @NotNull String advIconUrl, int i3) {
        Intrinsics.checkNotNullParameter(advIconUrl, "advIconUrl");
        this.isShow = z16;
        this.advIconUrl = advIconUrl;
        this.intervalTime = i3;
    }

    public /* synthetic */ VasTroopSmallHomeInfo(boolean z16, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 24 : i3);
    }
}
