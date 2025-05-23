package com.tencent.mobileqq.wink.h5native;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.videocut.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013B_\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003Js\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001bH\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\"R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b$\u0010\"R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b%\u0010\"R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b)\u0010\"R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b0\u0010\"\u00a8\u00064"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishVideoRequest", "", "", "component1", "component2", "component3", "component4", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishDataReport;", "component5", "component6", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishTeamInfo;", "component7", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishQzoneInfo;", "component8", "component9", AppConstants.Key.KEY_QZONE_VIDEO_URL, "content", "material_id", "publisher_schema", "data_report", "taskid", "team_info", "qzone_info", "callback", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishVideoRequest;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getVideoUrl", "()Ljava/lang/String;", "getContent", "getMaterial_id", "getPublisher_schema", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishDataReport;", "getData_report", "()Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishDataReport;", "getTaskid", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishTeamInfo;", "getTeam_info", "()Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishTeamInfo;", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishQzoneInfo;", "getQzone_info", "()Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishQzoneInfo;", "getCallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishDataReport;Ljava/lang/String;Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishTeamInfo;Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishQzoneInfo;Ljava/lang/String;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PublishVideoRequest, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PublishVideoRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String callback;

    @Nullable
    private final String content;

    @Nullable
    private final PublishDataReport data_report;

    @Nullable
    private final String material_id;

    @Nullable
    private final String publisher_schema;

    @Nullable
    private final PublishQzoneInfo qzone_info;

    @Nullable
    private final String taskid;

    @Nullable
    private final PublishTeamInfo team_info;

    @NotNull
    private final String videoUrl;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishVideoRequest$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishVideoRequest;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PublishVideoRequest$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PublishVideoRequest fromJsonStr(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            return (PublishVideoRequest) GsonUtils.f384219b.a(jsonStr, PublishVideoRequest.class);
        }

        Companion() {
        }
    }

    public PublishVideoRequest(@NotNull String videoUrl, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable PublishDataReport publishDataReport, @Nullable String str4, @Nullable PublishTeamInfo publishTeamInfo, @Nullable PublishQzoneInfo publishQzoneInfo, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.videoUrl = videoUrl;
        this.content = str;
        this.material_id = str2;
        this.publisher_schema = str3;
        this.data_report = publishDataReport;
        this.taskid = str4;
        this.team_info = publishTeamInfo;
        this.qzone_info = publishQzoneInfo;
        this.callback = str5;
    }

    public static /* synthetic */ PublishVideoRequest copy$default(PublishVideoRequest publishVideoRequest, String str, String str2, String str3, String str4, PublishDataReport publishDataReport, String str5, PublishTeamInfo publishTeamInfo, PublishQzoneInfo publishQzoneInfo, String str6, int i3, Object obj) {
        String str7;
        String str8;
        String str9;
        String str10;
        PublishDataReport publishDataReport2;
        String str11;
        PublishTeamInfo publishTeamInfo2;
        PublishQzoneInfo publishQzoneInfo2;
        String str12;
        if ((i3 & 1) != 0) {
            str7 = publishVideoRequest.videoUrl;
        } else {
            str7 = str;
        }
        if ((i3 & 2) != 0) {
            str8 = publishVideoRequest.content;
        } else {
            str8 = str2;
        }
        if ((i3 & 4) != 0) {
            str9 = publishVideoRequest.material_id;
        } else {
            str9 = str3;
        }
        if ((i3 & 8) != 0) {
            str10 = publishVideoRequest.publisher_schema;
        } else {
            str10 = str4;
        }
        if ((i3 & 16) != 0) {
            publishDataReport2 = publishVideoRequest.data_report;
        } else {
            publishDataReport2 = publishDataReport;
        }
        if ((i3 & 32) != 0) {
            str11 = publishVideoRequest.taskid;
        } else {
            str11 = str5;
        }
        if ((i3 & 64) != 0) {
            publishTeamInfo2 = publishVideoRequest.team_info;
        } else {
            publishTeamInfo2 = publishTeamInfo;
        }
        if ((i3 & 128) != 0) {
            publishQzoneInfo2 = publishVideoRequest.qzone_info;
        } else {
            publishQzoneInfo2 = publishQzoneInfo;
        }
        if ((i3 & 256) != 0) {
            str12 = publishVideoRequest.callback;
        } else {
            str12 = str6;
        }
        return publishVideoRequest.copy(str7, str8, str9, str10, publishDataReport2, str11, publishTeamInfo2, publishQzoneInfo2, str12);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMaterial_id() {
        return this.material_id;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPublisher_schema() {
        return this.publisher_schema;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final PublishDataReport getData_report() {
        return this.data_report;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTaskid() {
        return this.taskid;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final PublishTeamInfo getTeam_info() {
        return this.team_info;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final PublishQzoneInfo getQzone_info() {
        return this.qzone_info;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    public final PublishVideoRequest copy(@NotNull String videoUrl, @Nullable String content, @Nullable String material_id, @Nullable String publisher_schema, @Nullable PublishDataReport data_report, @Nullable String taskid, @Nullable PublishTeamInfo team_info, @Nullable PublishQzoneInfo qzone_info, @Nullable String callback) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        return new PublishVideoRequest(videoUrl, content, material_id, publisher_schema, data_report, taskid, team_info, qzone_info, callback);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishVideoRequest)) {
            return false;
        }
        PublishVideoRequest publishVideoRequest = (PublishVideoRequest) other;
        if (Intrinsics.areEqual(this.videoUrl, publishVideoRequest.videoUrl) && Intrinsics.areEqual(this.content, publishVideoRequest.content) && Intrinsics.areEqual(this.material_id, publishVideoRequest.material_id) && Intrinsics.areEqual(this.publisher_schema, publishVideoRequest.publisher_schema) && Intrinsics.areEqual(this.data_report, publishVideoRequest.data_report) && Intrinsics.areEqual(this.taskid, publishVideoRequest.taskid) && Intrinsics.areEqual(this.team_info, publishVideoRequest.team_info) && Intrinsics.areEqual(this.qzone_info, publishVideoRequest.qzone_info) && Intrinsics.areEqual(this.callback, publishVideoRequest.callback)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCallback() {
        return this.callback;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final PublishDataReport getData_report() {
        return this.data_report;
    }

    @Nullable
    public final String getMaterial_id() {
        return this.material_id;
    }

    @Nullable
    public final String getPublisher_schema() {
        return this.publisher_schema;
    }

    @Nullable
    public final PublishQzoneInfo getQzone_info() {
        return this.qzone_info;
    }

    @Nullable
    public final String getTaskid() {
        return this.taskid;
    }

    @Nullable
    public final PublishTeamInfo getTeam_info() {
        return this.team_info;
    }

    @NotNull
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8 = this.videoUrl.hashCode() * 31;
        String str = this.content;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode8 + hashCode) * 31;
        String str2 = this.material_id;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.publisher_schema;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        PublishDataReport publishDataReport = this.data_report;
        if (publishDataReport == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = publishDataReport.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str4 = this.taskid;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        PublishTeamInfo publishTeamInfo = this.team_info;
        if (publishTeamInfo == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = publishTeamInfo.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        PublishQzoneInfo publishQzoneInfo = this.qzone_info;
        if (publishQzoneInfo == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = publishQzoneInfo.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str5 = this.callback;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return i28 + i3;
    }

    @NotNull
    public String toString() {
        return "PublishVideoRequest(videoUrl=" + this.videoUrl + ", content=" + this.content + ", material_id=" + this.material_id + ", publisher_schema=" + this.publisher_schema + ", data_report=" + this.data_report + ", taskid=" + this.taskid + ", team_info=" + this.team_info + ", qzone_info=" + this.qzone_info + ", callback=" + this.callback + ")";
    }
}
