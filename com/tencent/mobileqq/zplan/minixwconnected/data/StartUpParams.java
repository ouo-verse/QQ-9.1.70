package com.tencent.mobileqq.zplan.minixwconnected.data;

import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\t\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getMainSource", "()Ljava/lang/String;", "mainSource", "b", "getSubSource", "subSource", "c", "friendUin", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "d", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "()Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "modeType", "e", ISchemeApi.KEY_PAGE_DATA, "f", "Z", "()Z", "directExit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/minihome/MapMode;Ljava/lang/String;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minixwconnected.data.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class StartUpParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mainSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String subSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String friendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final MapMode modeType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pageData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean directExit;

    public StartUpParams() {
        this(null, null, null, null, null, false, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDirectExit() {
        return this.directExit;
    }

    /* renamed from: b, reason: from getter */
    public final String getFriendUin() {
        return this.friendUin;
    }

    /* renamed from: c, reason: from getter */
    public final MapMode getModeType() {
        return this.modeType;
    }

    /* renamed from: d, reason: from getter */
    public final String getPageData() {
        return this.pageData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.mainSource.hashCode() * 31;
        String str = this.subSource;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.friendUin;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.modeType.hashCode()) * 31;
        String str3 = this.pageData;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z16 = this.directExit;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "StartUpParams(mainSource=" + this.mainSource + ", subSource=" + this.subSource + ", friendUin=" + this.friendUin + ", modeType=" + this.modeType + ", pageData=" + this.pageData + ", directExit=" + this.directExit + ")";
    }

    public StartUpParams(String mainSource, String str, String str2, MapMode modeType, String str3, boolean z16) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(modeType, "modeType");
        this.mainSource = mainSource;
        this.subSource = str;
        this.friendUin = str2;
        this.modeType = modeType;
        this.pageData = str3;
        this.directExit = z16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartUpParams)) {
            return false;
        }
        StartUpParams startUpParams = (StartUpParams) other;
        return Intrinsics.areEqual(this.mainSource, startUpParams.mainSource) && Intrinsics.areEqual(this.subSource, startUpParams.subSource) && Intrinsics.areEqual(this.friendUin, startUpParams.friendUin) && this.modeType == startUpParams.modeType && Intrinsics.areEqual(this.pageData, startUpParams.pageData) && this.directExit == startUpParams.directExit;
    }

    public /* synthetic */ StartUpParams(String str, String str2, String str3, MapMode mapMode, String str4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? MapMode.GLOBAL : mapMode, (i3 & 16) == 0 ? str4 : null, (i3 & 32) != 0 ? false : z16);
    }
}
