package com.tencent.mobileqq.guild.aisearch.history;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u0012\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/f;", "Lcom/tencent/mobileqq/guild/aisearch/history/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "sessionId", "b", "getFirstMsgId", "firstMsgId", "c", "e", "summary", "", "J", "()J", "queryTime", "f", "(Ljava/lang/String;)V", "groupTitle", "I", "()I", "g", "(I)V", "reportPosition", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.history.f, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class AIChatHistorySessionItem extends g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String firstMsgId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String summary;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long queryTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String groupTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int reportPosition;

    public /* synthetic */ AIChatHistorySessionItem(String str, String str2, String str3, long j3, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j3, str4, (i16 & 32) != 0 ? 0 : i3);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGroupTitle() {
        return this.groupTitle;
    }

    /* renamed from: b, reason: from getter */
    public final long getQueryTime() {
        return this.queryTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getReportPosition() {
        return this.reportPosition;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIChatHistorySessionItem)) {
            return false;
        }
        AIChatHistorySessionItem aIChatHistorySessionItem = (AIChatHistorySessionItem) other;
        if (Intrinsics.areEqual(this.sessionId, aIChatHistorySessionItem.sessionId) && Intrinsics.areEqual(this.firstMsgId, aIChatHistorySessionItem.firstMsgId) && Intrinsics.areEqual(this.summary, aIChatHistorySessionItem.summary) && this.queryTime == aIChatHistorySessionItem.queryTime && Intrinsics.areEqual(this.groupTitle, aIChatHistorySessionItem.groupTitle) && this.reportPosition == aIChatHistorySessionItem.reportPosition) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupTitle = str;
    }

    public final void g(int i3) {
        this.reportPosition = i3;
    }

    public int hashCode() {
        return (((((((((this.sessionId.hashCode() * 31) + this.firstMsgId.hashCode()) * 31) + this.summary.hashCode()) * 31) + androidx.fragment.app.a.a(this.queryTime)) * 31) + this.groupTitle.hashCode()) * 31) + this.reportPosition;
    }

    @NotNull
    public String toString() {
        return "AIChatHistorySessionItem(sessionId=" + this.sessionId + ", firstMsgId=" + this.firstMsgId + ", summary=" + this.summary + ", queryTime=" + this.queryTime + ", groupTitle=" + this.groupTitle + ", reportPosition=" + this.reportPosition + ")";
    }

    public AIChatHistorySessionItem(@NotNull String sessionId, @NotNull String firstMsgId, @NotNull String summary, long j3, @NotNull String groupTitle, int i3) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstMsgId, "firstMsgId");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(groupTitle, "groupTitle");
        this.sessionId = sessionId;
        this.firstMsgId = firstMsgId;
        this.summary = summary;
        this.queryTime = j3;
        this.groupTitle = groupTitle;
        this.reportPosition = i3;
    }
}
