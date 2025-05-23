package com.qzone.reborn.albumx.common.bean;

import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "Lcooperation/qzone/report/lp/LpReportInfo_pf00064;", "b", "Lcooperation/qzone/report/lp/LpReportInfo_pf00064;", "()Lcooperation/qzone/report/lp/LpReportInfo_pf00064;", "info", "<init>", "(Ljava/lang/String;Lcooperation/qzone/report/lp/LpReportInfo_pf00064;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.albumx.common.bean.f, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class CommonPublishMoodBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String filePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final LpReportInfo_pf00064 info;

    public CommonPublishMoodBean(String filePath, LpReportInfo_pf00064 info) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(info, "info");
        this.filePath = filePath;
        this.info = info;
    }

    /* renamed from: a, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: b, reason: from getter */
    public final LpReportInfo_pf00064 getInfo() {
        return this.info;
    }

    public int hashCode() {
        return (this.filePath.hashCode() * 31) + this.info.hashCode();
    }

    public String toString() {
        return "CommonPublishMoodBean(filePath=" + this.filePath + ", info=" + this.info + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonPublishMoodBean)) {
            return false;
        }
        CommonPublishMoodBean commonPublishMoodBean = (CommonPublishMoodBean) other;
        return Intrinsics.areEqual(this.filePath, commonPublishMoodBean.filePath) && Intrinsics.areEqual(this.info, commonPublishMoodBean.info);
    }
}
