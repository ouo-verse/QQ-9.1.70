package com.tencent.mobileqq.guild.quicksearch.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rj\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;", "", "sortName", "", "sortNameInList", "rankType", "", "reportId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;II)V", "getRankType", "()I", "getReportId", "getSortName", "()Ljava/lang/String;", "getSortNameInList", "SMART", "TIME", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum QuickSearchSortType {
    SMART("\u6700\u76f8\u5173", "\u6700\u76f8\u5173", 0, 2),
    TIME("\u65b0\u53d1\u8868", "\u65b0\u53d1\u8868", 2, 1);

    private final int rankType;
    private final int reportId;

    @NotNull
    private final String sortName;

    @NotNull
    private final String sortNameInList;

    QuickSearchSortType(String str, String str2, int i3, int i16) {
        this.sortName = str;
        this.sortNameInList = str2;
        this.rankType = i3;
        this.reportId = i16;
    }

    public final int getRankType() {
        return this.rankType;
    }

    public final int getReportId() {
        return this.reportId;
    }

    @NotNull
    public final String getSortName() {
        return this.sortName;
    }

    @NotNull
    public final String getSortNameInList() {
        return this.sortNameInList;
    }
}
