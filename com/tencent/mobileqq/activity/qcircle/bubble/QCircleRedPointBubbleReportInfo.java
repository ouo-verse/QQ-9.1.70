package com.tencent.mobileqq.activity.qcircle.bubble;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "dcRedPointType", "c", "dtRedPointType", "e", "redDotReportExt", "d", "lastRedDotReportExt", "f", "tabTipWording", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.activity.qcircle.bubble.f, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class QCircleRedPointBubbleReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dcRedPointType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dtRedPointType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String redDotReportExt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String lastRedDotReportExt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabTipWording;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    public QCircleRedPointBubbleReportInfo(@NotNull String dcRedPointType, @NotNull String dtRedPointType, @NotNull String redDotReportExt, @NotNull String lastRedDotReportExt, @NotNull String tabTipWording, @NotNull String content) {
        Intrinsics.checkNotNullParameter(dcRedPointType, "dcRedPointType");
        Intrinsics.checkNotNullParameter(dtRedPointType, "dtRedPointType");
        Intrinsics.checkNotNullParameter(redDotReportExt, "redDotReportExt");
        Intrinsics.checkNotNullParameter(lastRedDotReportExt, "lastRedDotReportExt");
        Intrinsics.checkNotNullParameter(tabTipWording, "tabTipWording");
        Intrinsics.checkNotNullParameter(content, "content");
        this.dcRedPointType = dcRedPointType;
        this.dtRedPointType = dtRedPointType;
        this.redDotReportExt = redDotReportExt;
        this.lastRedDotReportExt = lastRedDotReportExt;
        this.tabTipWording = tabTipWording;
        this.content = content;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDcRedPointType() {
        return this.dcRedPointType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDtRedPointType() {
        return this.dtRedPointType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getLastRedDotReportExt() {
        return this.lastRedDotReportExt;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getRedDotReportExt() {
        return this.redDotReportExt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCircleRedPointBubbleReportInfo)) {
            return false;
        }
        QCircleRedPointBubbleReportInfo qCircleRedPointBubbleReportInfo = (QCircleRedPointBubbleReportInfo) other;
        if (Intrinsics.areEqual(this.dcRedPointType, qCircleRedPointBubbleReportInfo.dcRedPointType) && Intrinsics.areEqual(this.dtRedPointType, qCircleRedPointBubbleReportInfo.dtRedPointType) && Intrinsics.areEqual(this.redDotReportExt, qCircleRedPointBubbleReportInfo.redDotReportExt) && Intrinsics.areEqual(this.lastRedDotReportExt, qCircleRedPointBubbleReportInfo.lastRedDotReportExt) && Intrinsics.areEqual(this.tabTipWording, qCircleRedPointBubbleReportInfo.tabTipWording) && Intrinsics.areEqual(this.content, qCircleRedPointBubbleReportInfo.content)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTabTipWording() {
        return this.tabTipWording;
    }

    public int hashCode() {
        return (((((((((this.dcRedPointType.hashCode() * 31) + this.dtRedPointType.hashCode()) * 31) + this.redDotReportExt.hashCode()) * 31) + this.lastRedDotReportExt.hashCode()) * 31) + this.tabTipWording.hashCode()) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "QCircleRedPointBubbleReportInfo(dcRedPointType=" + this.dcRedPointType + ", dtRedPointType=" + this.dtRedPointType + ", redDotReportExt=" + this.redDotReportExt + ", lastRedDotReportExt=" + this.lastRedDotReportExt + ", tabTipWording=" + this.tabTipWording + ", content=" + this.content + ")";
    }
}
