package com.tencent.biz.qqcircle.immersive.redpacket.bean;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketClipBean;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "localVideoPath", "", "selectStartTime", "", "selectDurationTime", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "needShowSelectStart", "", "needShowThumb", "reportSessionId", "(Ljava/lang/String;JJLjava/lang/String;ZZLjava/lang/String;)V", "getBusinessName", "()Ljava/lang/String;", "getLocalVideoPath", "getNeedShowSelectStart", "()Z", "getNeedShowThumb", "getReportSessionId", "getSelectDurationTime", "()J", "getSelectStartTime", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSRedPacketClipBean extends QCircleInitBean {

    @NotNull
    private final String businessName;

    @NotNull
    private final String localVideoPath;
    private final boolean needShowSelectStart;
    private final boolean needShowThumb;

    @NotNull
    private final String reportSessionId;
    private final long selectDurationTime;
    private final long selectStartTime;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ QFSRedPacketClipBean(String str, long j3, long j16, String str2, boolean z16, boolean z17, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r0, r2, r4, r5, r6, r7);
        String str4;
        long j17 = (i3 & 2) != 0 ? 0L : j3;
        long j18 = (i3 & 4) != 0 ? 2000000L : j16;
        String str5 = (i3 & 8) != 0 ? "redpacket" : str2;
        boolean z18 = (i3 & 16) != 0 ? false : z16;
        boolean z19 = (i3 & 32) == 0 ? z17 : false;
        if ((i3 & 64) != 0) {
            str4 = QCircleNativeSessionManager.g().getSession();
            Intrinsics.checkNotNullExpressionValue(str4, "g().session");
        } else {
            str4 = str3;
        }
    }

    @NotNull
    public final String getBusinessName() {
        return this.businessName;
    }

    @NotNull
    public final String getLocalVideoPath() {
        return this.localVideoPath;
    }

    public final boolean getNeedShowSelectStart() {
        return this.needShowSelectStart;
    }

    public final boolean getNeedShowThumb() {
        return this.needShowThumb;
    }

    @NotNull
    public final String getReportSessionId() {
        return this.reportSessionId;
    }

    public final long getSelectDurationTime() {
        return this.selectDurationTime;
    }

    public final long getSelectStartTime() {
        return this.selectStartTime;
    }

    public QFSRedPacketClipBean(@NotNull String localVideoPath, long j3, long j16, @NotNull String businessName, boolean z16, boolean z17, @NotNull String reportSessionId) {
        Intrinsics.checkNotNullParameter(localVideoPath, "localVideoPath");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(reportSessionId, "reportSessionId");
        this.localVideoPath = localVideoPath;
        this.selectStartTime = j3;
        this.selectDurationTime = j16;
        this.businessName = businessName;
        this.needShowSelectStart = z16;
        this.needShowThumb = z17;
        this.reportSessionId = reportSessionId;
    }
}
