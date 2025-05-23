package com.tencent.rmonitor.sla;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b%\u0010\u000fR\u0017\u0010*\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010(\u001a\u0004\b\u0004\u0010)R\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\"\u0010\u0007\u00a8\u0006/"}, d2 = {"Lcom/tencent/rmonitor/sla/h;", "", "", "toString", "a", "Ljava/lang/String;", "getEventCode", "()Ljava/lang/String;", "eventCode", "", "b", "I", "c", "()I", "l", "(I)V", "discardCount", "g", "p", "failCount", "d", "k", ReportConstant.COSTREPORT_PREFIX, "succCount", "e", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "succContentLengthSum", "f", DomainData.DOMAIN_NAME, "failContentLengthSum", "j", "r", "succCostSum", tl.h.F, "o", "failCostSum", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "expiredCount", "Lcom/tencent/rmonitor/sla/c;", "Lcom/tencent/rmonitor/sla/c;", "()Lcom/tencent/rmonitor/sla/c;", "attaEvent", "baseType", QCircleLpReportDc010001.KEY_SUBTYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.rmonitor.sla.h, reason: from toString */
/* loaded from: classes25.dex */
public final class StatisticsEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String eventCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int discardCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int failCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int succCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int succContentLengthSum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int failContentLengthSum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int succCostSum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int failCostSum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int expiredCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AttaEvent attaEvent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String baseType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subType;

    public StatisticsEvent(@NotNull String baseType, @NotNull String subType) {
        Intrinsics.checkParameterIsNotNull(baseType, "baseType");
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        this.baseType = baseType;
        this.subType = subType;
        this.eventCode = "RMRecordReport";
        this.attaEvent = new AttaEvent("RMRecordReport");
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AttaEvent getAttaEvent() {
        return this.attaEvent;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBaseType() {
        return this.baseType;
    }

    /* renamed from: c, reason: from getter */
    public final int getDiscardCount() {
        return this.discardCount;
    }

    /* renamed from: d, reason: from getter */
    public final int getExpiredCount() {
        return this.expiredCount;
    }

    /* renamed from: e, reason: from getter */
    public final int getFailContentLengthSum() {
        return this.failContentLengthSum;
    }

    /* renamed from: f, reason: from getter */
    public final int getFailCostSum() {
        return this.failCostSum;
    }

    /* renamed from: g, reason: from getter */
    public final int getFailCount() {
        return this.failCount;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getSubType() {
        return this.subType;
    }

    /* renamed from: i, reason: from getter */
    public final int getSuccContentLengthSum() {
        return this.succContentLengthSum;
    }

    /* renamed from: j, reason: from getter */
    public final int getSuccCostSum() {
        return this.succCostSum;
    }

    /* renamed from: k, reason: from getter */
    public final int getSuccCount() {
        return this.succCount;
    }

    public final void l(int i3) {
        this.discardCount = i3;
    }

    public final void m(int i3) {
        this.expiredCount = i3;
    }

    public final void n(int i3) {
        this.failContentLengthSum = i3;
    }

    public final void o(int i3) {
        this.failCostSum = i3;
    }

    public final void p(int i3) {
        this.failCount = i3;
    }

    public final void q(int i3) {
        this.succContentLengthSum = i3;
    }

    public final void r(int i3) {
        this.succCostSum = i3;
    }

    public final void s(int i3) {
        this.succCount = i3;
    }

    @NotNull
    public String toString() {
        return "StatisticsEvent(baseType='" + this.baseType + "', subType='" + this.subType + "', eventCode='" + this.eventCode + "', discardCount=" + this.discardCount + ", failCount=" + this.failCount + ", succCount=" + this.succCount + ", succContentLengthSum=" + this.succContentLengthSum + ", failContentLengthSum=" + this.failContentLengthSum + ", succCostSum=" + this.succCostSum + ", failCostSum=" + this.failCostSum + ", expiredCount=" + this.expiredCount + ", )";
    }
}
