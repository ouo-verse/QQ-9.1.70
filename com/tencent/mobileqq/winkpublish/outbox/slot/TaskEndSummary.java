package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010'\u001a\u00020\tH\u00c6\u0003J\t\u0010(\u001a\u00020\fH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003Jq\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J\t\u0010/\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/TaskEndSummary;", "", "phoneLevel", "", "costTimeMillis", "", "uploadTaskType", "runTimes", "isTruePublish", "", "isVideoTask", "feedId", "", "videoSummary", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/VideoSummary;", "uploadCoverType", "upSource", "(IJIIZZLjava/lang/String;Lcom/tencent/mobileqq/winkpublish/outbox/slot/VideoSummary;ILjava/lang/String;)V", "getCostTimeMillis", "()J", "getFeedId", "()Ljava/lang/String;", "()Z", "getPhoneLevel", "()I", "getRunTimes", "getUpSource", "getUploadCoverType", "getUploadTaskType", "getVideoSummary", "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/VideoSummary;", "setVideoSummary", "(Lcom/tencent/mobileqq/winkpublish/outbox/slot/VideoSummary;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class TaskEndSummary {
    private final long costTimeMillis;
    private final String feedId;
    private final boolean isTruePublish;
    private final boolean isVideoTask;
    private final int phoneLevel;
    private final int runTimes;
    private final String upSource;
    private final int uploadCoverType;
    private final int uploadTaskType;
    private VideoSummary videoSummary;

    public TaskEndSummary(int i3, long j3, int i16, int i17, boolean z16, boolean z17, String feedId, VideoSummary videoSummary, int i18, String str) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.phoneLevel = i3;
        this.costTimeMillis = j3;
        this.uploadTaskType = i16;
        this.runTimes = i17;
        this.isTruePublish = z16;
        this.isVideoTask = z17;
        this.feedId = feedId;
        this.videoSummary = videoSummary;
        this.uploadCoverType = i18;
        this.upSource = str;
    }

    /* renamed from: component1, reason: from getter */
    public final int getPhoneLevel() {
        return this.phoneLevel;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUpSource() {
        return this.upSource;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCostTimeMillis() {
        return this.costTimeMillis;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUploadTaskType() {
        return this.uploadTaskType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRunTimes() {
        return this.runTimes;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsTruePublish() {
        return this.isTruePublish;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsVideoTask() {
        return this.isVideoTask;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component8, reason: from getter */
    public final VideoSummary getVideoSummary() {
        return this.videoSummary;
    }

    /* renamed from: component9, reason: from getter */
    public final int getUploadCoverType() {
        return this.uploadCoverType;
    }

    public final TaskEndSummary copy(int phoneLevel, long costTimeMillis, int uploadTaskType, int runTimes, boolean isTruePublish, boolean isVideoTask, String feedId, VideoSummary videoSummary, int uploadCoverType, String upSource) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return new TaskEndSummary(phoneLevel, costTimeMillis, uploadTaskType, runTimes, isTruePublish, isVideoTask, feedId, videoSummary, uploadCoverType, upSource);
    }

    public final long getCostTimeMillis() {
        return this.costTimeMillis;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final int getPhoneLevel() {
        return this.phoneLevel;
    }

    public final int getRunTimes() {
        return this.runTimes;
    }

    public final String getUpSource() {
        return this.upSource;
    }

    public final int getUploadCoverType() {
        return this.uploadCoverType;
    }

    public final int getUploadTaskType() {
        return this.uploadTaskType;
    }

    public final VideoSummary getVideoSummary() {
        return this.videoSummary;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((((this.phoneLevel * 31) + d.a(this.costTimeMillis)) * 31) + this.uploadTaskType) * 31) + this.runTimes) * 31;
        boolean z16 = this.isTruePublish;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (a16 + i3) * 31;
        boolean z17 = this.isVideoTask;
        int hashCode = (((i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.feedId.hashCode()) * 31;
        VideoSummary videoSummary = this.videoSummary;
        int hashCode2 = (((hashCode + (videoSummary == null ? 0 : videoSummary.hashCode())) * 31) + this.uploadCoverType) * 31;
        String str = this.upSource;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isTruePublish() {
        return this.isTruePublish;
    }

    public final boolean isVideoTask() {
        return this.isVideoTask;
    }

    public final void setVideoSummary(VideoSummary videoSummary) {
        this.videoSummary = videoSummary;
    }

    public String toString() {
        return "TaskEndSummary(phoneLevel=" + this.phoneLevel + ", costTimeMillis=" + this.costTimeMillis + ", uploadTaskType=" + this.uploadTaskType + ", runTimes=" + this.runTimes + ", isTruePublish=" + this.isTruePublish + ", isVideoTask=" + this.isVideoTask + ", feedId=" + this.feedId + ", videoSummary=" + this.videoSummary + ", uploadCoverType=" + this.uploadCoverType + ", upSource=" + this.upSource + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskEndSummary)) {
            return false;
        }
        TaskEndSummary taskEndSummary = (TaskEndSummary) other;
        return this.phoneLevel == taskEndSummary.phoneLevel && this.costTimeMillis == taskEndSummary.costTimeMillis && this.uploadTaskType == taskEndSummary.uploadTaskType && this.runTimes == taskEndSummary.runTimes && this.isTruePublish == taskEndSummary.isTruePublish && this.isVideoTask == taskEndSummary.isVideoTask && Intrinsics.areEqual(this.feedId, taskEndSummary.feedId) && Intrinsics.areEqual(this.videoSummary, taskEndSummary.videoSummary) && this.uploadCoverType == taskEndSummary.uploadCoverType && Intrinsics.areEqual(this.upSource, taskEndSummary.upSource);
    }

    public /* synthetic */ TaskEndSummary(int i3, long j3, int i16, int i17, boolean z16, boolean z17, String str, VideoSummary videoSummary, int i18, String str2, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? AEOfflineConfig.getPhonePerfLevel() : i3, j3, i16, i17, z16, z17, str, (i19 & 128) != 0 ? null : videoSummary, i18, (i19 & 512) != 0 ? null : str2);
    }
}
