package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/IReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "reportFeedInfo", "", "setDc5507ReportInfo", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "updateTaskId", "a", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IReportApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/IReportApi$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "feedIndex", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "feedId", "feedAuthorUin", "d", "e", "sealTransfer", "materialInfos", "f", "g", "(Ljava/lang/String;)V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.api.IReportApi$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ReportFeedInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int feedIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedAuthorUin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sealTransfer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String materialInfos;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String taskId;

        public ReportFeedInfo() {
            this(0, null, null, null, null, null, 63, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFeedAuthorUin() {
            return this.feedAuthorUin;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: c, reason: from getter */
        public final int getFeedIndex() {
            return this.feedIndex;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getMaterialInfos() {
            return this.materialInfos;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getSealTransfer() {
            return this.sealTransfer;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportFeedInfo)) {
                return false;
            }
            ReportFeedInfo reportFeedInfo = (ReportFeedInfo) other;
            if (this.feedIndex == reportFeedInfo.feedIndex && Intrinsics.areEqual(this.feedId, reportFeedInfo.feedId) && Intrinsics.areEqual(this.feedAuthorUin, reportFeedInfo.feedAuthorUin) && Intrinsics.areEqual(this.sealTransfer, reportFeedInfo.sealTransfer) && Intrinsics.areEqual(this.materialInfos, reportFeedInfo.materialInfos) && Intrinsics.areEqual(this.taskId, reportFeedInfo.taskId)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.taskId = str;
        }

        public int hashCode() {
            return (((((((((this.feedIndex * 31) + this.feedId.hashCode()) * 31) + this.feedAuthorUin.hashCode()) * 31) + this.sealTransfer.hashCode()) * 31) + this.materialInfos.hashCode()) * 31) + this.taskId.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReportFeedInfo(feedIndex=" + this.feedIndex + ", feedId=" + this.feedId + ", feedAuthorUin=" + this.feedAuthorUin + ", sealTransfer=" + this.sealTransfer + ", materialInfos=" + this.materialInfos + ", taskId=" + this.taskId + ")";
        }

        public ReportFeedInfo(int i3, @NotNull String feedId, @NotNull String feedAuthorUin, @NotNull String sealTransfer, @NotNull String materialInfos, @NotNull String taskId) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(feedAuthorUin, "feedAuthorUin");
            Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
            Intrinsics.checkNotNullParameter(materialInfos, "materialInfos");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            this.feedIndex = i3;
            this.feedId = feedId;
            this.feedAuthorUin = feedAuthorUin;
            this.sealTransfer = sealTransfer;
            this.materialInfos = materialInfos;
            this.taskId = taskId;
        }

        public /* synthetic */ ReportFeedInfo(int i3, String str, String str2, String str3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) == 0 ? str5 : "");
        }
    }

    void setDc5507ReportInfo(@NotNull ReportFeedInfo reportFeedInfo);

    void updateTaskId(@NotNull String taskId);
}
