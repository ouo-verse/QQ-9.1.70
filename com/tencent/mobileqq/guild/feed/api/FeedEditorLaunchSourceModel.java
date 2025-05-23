package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "scene", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "visitFrom", "c", "pginSourceName", "setActivityId", "(Ljava/lang/String;)V", "activityId", "e", tl.h.F, "sgrpSharePanelPageSource", "g", "(I)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.api.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedEditorLaunchSourceModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String visitFrom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pginSourceName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String activityId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sgrpSharePanelPageSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int requestId;

    public FeedEditorLaunchSourceModel(int i3, @NotNull String visitFrom, @NotNull String pginSourceName) {
        Intrinsics.checkNotNullParameter(visitFrom, "visitFrom");
        Intrinsics.checkNotNullParameter(pginSourceName, "pginSourceName");
        this.scene = i3;
        this.visitFrom = visitFrom;
        this.pginSourceName = pginSourceName;
        this.activityId = "";
        this.sgrpSharePanelPageSource = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPginSourceName() {
        return this.pginSourceName;
    }

    /* renamed from: c, reason: from getter */
    public final int getRequestId() {
        return this.requestId;
    }

    /* renamed from: d, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSgrpSharePanelPageSource() {
        return this.sgrpSharePanelPageSource;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedEditorLaunchSourceModel)) {
            return false;
        }
        FeedEditorLaunchSourceModel feedEditorLaunchSourceModel = (FeedEditorLaunchSourceModel) other;
        if (this.scene == feedEditorLaunchSourceModel.scene && Intrinsics.areEqual(this.visitFrom, feedEditorLaunchSourceModel.visitFrom) && Intrinsics.areEqual(this.pginSourceName, feedEditorLaunchSourceModel.pginSourceName)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getVisitFrom() {
        return this.visitFrom;
    }

    public final void g(int i3) {
        this.requestId = i3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sgrpSharePanelPageSource = str;
    }

    public int hashCode() {
        return (((this.scene * 31) + this.visitFrom.hashCode()) * 31) + this.pginSourceName.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedEditorLaunchSourceModel(scene=" + this.scene + ", visitFrom=" + this.visitFrom + ", pginSourceName=" + this.pginSourceName + ')';
    }
}
