package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\n\u0010\u001c\u001a\u00060\u0018j\u0002`\u0019\u0012\u000e\u0010!\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u001c\u001a\u00060\u0018j\u0002`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\r\u0010\u001bR\u001f\u0010!\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b\u0015\u0010 R\u0019\u0010$\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b\u0012\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "fileId", "b", "Z", "e", "()Z", "isFinishSuccess", "c", "g", "isNeedReUpload", "d", "f", "isInterrupted", "Lcom/tencent/mobileqq/guild/data/g;", "Lcom/tencent/mobileqq/guild/feed/publish/api/InternalLocalMediumModel;", "Lcom/tencent/mobileqq/guild/data/g;", "()Lcom/tencent/mobileqq/guild/data/g;", "localMediumInfo", "Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadTaskInfo;", "Lcom/tencent/mobileqq/guild/data/o;", "()Lcom/tencent/mobileqq/guild/data/o;", "taskInfo", "Ljava/lang/Object;", "()Ljava/lang/Object;", "metaPersistentObject", "<init>", "(Ljava/lang/String;ZZZLcom/tencent/mobileqq/guild/data/g;Lcom/tencent/mobileqq/guild/data/o;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.j, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MediumUploadStateRestoreInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String fileId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFinishSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isNeedReUpload;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isInterrupted;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.guild.data.g localMediumInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final o taskInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object metaPersistentObject;

    public MediumUploadStateRestoreInfo(@NotNull String fileId, boolean z16, boolean z17, boolean z18, @NotNull com.tencent.mobileqq.guild.data.g localMediumInfo, @Nullable o oVar, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(localMediumInfo, "localMediumInfo");
        this.fileId = fileId;
        this.isFinishSuccess = z16;
        this.isNeedReUpload = z17;
        this.isInterrupted = z18;
        this.localMediumInfo = localMediumInfo;
        this.taskInfo = oVar;
        this.metaPersistentObject = obj;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.guild.data.g getLocalMediumInfo() {
        return this.localMediumInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Object getMetaPersistentObject() {
        return this.metaPersistentObject;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final o getTaskInfo() {
        return this.taskInfo;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsFinishSuccess() {
        return this.isFinishSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediumUploadStateRestoreInfo)) {
            return false;
        }
        MediumUploadStateRestoreInfo mediumUploadStateRestoreInfo = (MediumUploadStateRestoreInfo) other;
        if (Intrinsics.areEqual(this.fileId, mediumUploadStateRestoreInfo.fileId) && this.isFinishSuccess == mediumUploadStateRestoreInfo.isFinishSuccess && this.isNeedReUpload == mediumUploadStateRestoreInfo.isNeedReUpload && this.isInterrupted == mediumUploadStateRestoreInfo.isInterrupted && Intrinsics.areEqual(this.localMediumInfo, mediumUploadStateRestoreInfo.localMediumInfo) && Intrinsics.areEqual(this.taskInfo, mediumUploadStateRestoreInfo.taskInfo) && Intrinsics.areEqual(this.metaPersistentObject, mediumUploadStateRestoreInfo.metaPersistentObject)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsInterrupted() {
        return this.isInterrupted;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsNeedReUpload() {
        return this.isNeedReUpload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.fileId.hashCode() * 31;
        boolean z16 = this.isFinishSuccess;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isNeedReUpload;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isInterrupted;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int hashCode3 = (((i19 + i3) * 31) + this.localMediumInfo.hashCode()) * 31;
        o oVar = this.taskInfo;
        int i26 = 0;
        if (oVar == null) {
            hashCode = 0;
        } else {
            hashCode = oVar.hashCode();
        }
        int i27 = (hashCode3 + hashCode) * 31;
        Object obj = this.metaPersistentObject;
        if (obj != null) {
            i26 = obj.hashCode();
        }
        return i27 + i26;
    }

    @NotNull
    public String toString() {
        return "MediumUploadStateRestoreInfo(fileId=" + this.fileId + ", isFinishSuccess=" + this.isFinishSuccess + ", isNeedReUpload=" + this.isNeedReUpload + ", isInterrupted=" + this.isInterrupted + ", localMediumInfo=" + this.localMediumInfo + ", taskInfo=" + this.taskInfo + ", metaPersistentObject=" + this.metaPersistentObject + ")";
    }
}
