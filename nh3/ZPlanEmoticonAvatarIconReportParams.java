package nh3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lnh3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "isSelected", "b", "d", "isDressUpUser", "c", "hitCloudCache", "Ljava/lang/String;", "()Ljava/lang/String;", "firstTimeEnter", "pageFrom", "<init>", "(IIILjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: nh3.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZPlanEmoticonAvatarIconReportParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int isSelected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int isDressUpUser;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hitCloudCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String firstTimeEnter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pageFrom;

    public ZPlanEmoticonAvatarIconReportParams(int i3, int i16, int i17, String firstTimeEnter, String pageFrom) {
        Intrinsics.checkNotNullParameter(firstTimeEnter, "firstTimeEnter");
        Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
        this.isSelected = i3;
        this.isDressUpUser = i16;
        this.hitCloudCache = i17;
        this.firstTimeEnter = firstTimeEnter;
        this.pageFrom = pageFrom;
    }

    /* renamed from: a, reason: from getter */
    public final String getFirstTimeEnter() {
        return this.firstTimeEnter;
    }

    /* renamed from: b, reason: from getter */
    public final int getHitCloudCache() {
        return this.hitCloudCache;
    }

    /* renamed from: c, reason: from getter */
    public final String getPageFrom() {
        return this.pageFrom;
    }

    /* renamed from: d, reason: from getter */
    public final int getIsDressUpUser() {
        return this.isDressUpUser;
    }

    /* renamed from: e, reason: from getter */
    public final int getIsSelected() {
        return this.isSelected;
    }

    public int hashCode() {
        return (((((((this.isSelected * 31) + this.isDressUpUser) * 31) + this.hitCloudCache) * 31) + this.firstTimeEnter.hashCode()) * 31) + this.pageFrom.hashCode();
    }

    public String toString() {
        return "ZPlanEmoticonAvatarIconReportParams(isSelected=" + this.isSelected + ", isDressUpUser=" + this.isDressUpUser + ", hitCloudCache=" + this.hitCloudCache + ", firstTimeEnter=" + this.firstTimeEnter + ", pageFrom=" + this.pageFrom + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEmoticonAvatarIconReportParams)) {
            return false;
        }
        ZPlanEmoticonAvatarIconReportParams zPlanEmoticonAvatarIconReportParams = (ZPlanEmoticonAvatarIconReportParams) other;
        return this.isSelected == zPlanEmoticonAvatarIconReportParams.isSelected && this.isDressUpUser == zPlanEmoticonAvatarIconReportParams.isDressUpUser && this.hitCloudCache == zPlanEmoticonAvatarIconReportParams.hitCloudCache && Intrinsics.areEqual(this.firstTimeEnter, zPlanEmoticonAvatarIconReportParams.firstTimeEnter) && Intrinsics.areEqual(this.pageFrom, zPlanEmoticonAvatarIconReportParams.pageFrom);
    }
}
