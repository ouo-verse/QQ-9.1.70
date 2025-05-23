package com.tencent.mobileqq.guild.profile.myguild;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "", "groupName", "", "isDefaultCollapse", "", AdMetricTag.Report.TYPE, "", "(Ljava/lang/String;ILjava/lang/String;ZI)V", "getGroupName", "()Ljava/lang/String;", "()Z", "getReportType", "()I", "CreatedGroup", "ManagedGroup", "JoinedGroup", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GroupType {
    CreatedGroup("\u6211\u521b\u5efa\u7684\u9891\u9053", true, 1),
    ManagedGroup("\u6211\u7ba1\u7406\u7684\u9891\u9053", true, 2),
    JoinedGroup("\u6211\u52a0\u5165\u7684\u9891\u9053", false, 3);


    @NotNull
    private final String groupName;
    private final boolean isDefaultCollapse;
    private final int reportType;

    GroupType(String str, boolean z16, int i3) {
        this.groupName = str;
        this.isDefaultCollapse = z16;
        this.reportType = i3;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    public final int getReportType() {
        return this.reportType;
    }

    /* renamed from: isDefaultCollapse, reason: from getter */
    public final boolean getIsDefaultCollapse() {
        return this.isDefaultCollapse;
    }
}
