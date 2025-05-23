package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/DTReportParam;", "Ljava/io/Serializable;", "pageId", "", "elementAllId", "elementPartId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getElementAllId", "()Ljava/lang/String;", "getElementPartId", "getPageId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class DTReportParam implements Serializable {

    @NotNull
    private final String elementAllId;

    @NotNull
    private final String elementPartId;

    @NotNull
    private final String pageId;

    public DTReportParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DTReportParam copy$default(DTReportParam dTReportParam, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dTReportParam.pageId;
        }
        if ((i3 & 2) != 0) {
            str2 = dTReportParam.elementAllId;
        }
        if ((i3 & 4) != 0) {
            str3 = dTReportParam.elementPartId;
        }
        return dTReportParam.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getElementAllId() {
        return this.elementAllId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getElementPartId() {
        return this.elementPartId;
    }

    @NotNull
    public final DTReportParam copy(@NotNull String pageId, @NotNull String elementAllId, @NotNull String elementPartId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elementAllId, "elementAllId");
        Intrinsics.checkNotNullParameter(elementPartId, "elementPartId");
        return new DTReportParam(pageId, elementAllId, elementPartId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DTReportParam)) {
            return false;
        }
        DTReportParam dTReportParam = (DTReportParam) other;
        if (Intrinsics.areEqual(this.pageId, dTReportParam.pageId) && Intrinsics.areEqual(this.elementAllId, dTReportParam.elementAllId) && Intrinsics.areEqual(this.elementPartId, dTReportParam.elementPartId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getElementAllId() {
        return this.elementAllId;
    }

    @NotNull
    public final String getElementPartId() {
        return this.elementPartId;
    }

    @NotNull
    public final String getPageId() {
        return this.pageId;
    }

    public int hashCode() {
        return (((this.pageId.hashCode() * 31) + this.elementAllId.hashCode()) * 31) + this.elementPartId.hashCode();
    }

    @NotNull
    public String toString() {
        return "DTReportParam(pageId=" + this.pageId + ", elementAllId=" + this.elementAllId + ", elementPartId=" + this.elementPartId + ")";
    }

    public DTReportParam(@NotNull String pageId, @NotNull String elementAllId, @NotNull String elementPartId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elementAllId, "elementAllId");
        Intrinsics.checkNotNullParameter(elementPartId, "elementPartId");
        this.pageId = pageId;
        this.elementAllId = elementAllId;
        this.elementPartId = elementPartId;
    }

    public /* synthetic */ DTReportParam(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
