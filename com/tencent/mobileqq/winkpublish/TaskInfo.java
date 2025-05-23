package com.tencent.mobileqq.winkpublish;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u00a5\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0002\u0010\u001eJ\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\t\u00107\u001a\u00020\u0012H\u00c6\u0003J\t\u00108\u001a\u00020\bH\u00c6\u0003J\t\u00109\u001a\u00020\u000bH\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u00c6\u0003J\t\u0010<\u001a\u00020\u000bH\u00c6\u0003J\t\u0010=\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003J\t\u0010?\u001a\u00020\bH\u00c6\u0003J\t\u0010@\u001a\u00020\bH\u00c6\u0003J\t\u0010A\u001a\u00020\bH\u00c6\u0003J\t\u0010B\u001a\u00020\u000bH\u00c6\u0003J\t\u0010C\u001a\u00020\u000bH\u00c6\u0003J\t\u0010D\u001a\u00020\u000bH\u00c6\u0003J\t\u0010E\u001a\u00020\u0006H\u00c6\u0003J\t\u0010F\u001a\u00020\bH\u00c6\u0003J\t\u0010G\u001a\u00020\u000bH\u00c6\u0003J\u00c5\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\bH\u00c6\u0001J\b\u0010I\u001a\u00020\bH\u0016J\u0013\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010LH\u00d6\u0003J\t\u0010M\u001a\u00020\bH\u00d6\u0001J\u0006\u0010N\u001a\u00020\u0012J\u0006\u0010O\u001a\u00020\u0012J\u0006\u0010P\u001a\u00020\u0012J\u0006\u0010Q\u001a\u00020\u0012J\u0006\u0010R\u001a\u00020\u0012J\u0006\u0010S\u001a\u00020\u0012J\u0006\u0010T\u001a\u00020\u0012J\u0006\u0010U\u001a\u00020\u0012J\t\u0010V\u001a\u00020\u000bH\u00d6\u0001J\u0018\u0010W\u001a\u00020X2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\bH\u0016R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0019\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u001d\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010+R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\"\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "state", "", "type", "missionId", "", "clientKey", "traceId", "aliveTimeMillis", "uploadProgress", "coverUrl", "isTrueUpload", "", "businessType", "feedId", "feedTime", "mediaInfos", "", "Lcom/tencent/mobileqq/winkpublish/MediaInfo;", "errCode", "errMsg", "transParams", "Landroid/os/Bundle;", "exportProgress", "(JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;ZILjava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I)V", "getAliveTimeMillis", "()J", "getBusinessType", "()I", "getClientKey", "()Ljava/lang/String;", "getCoverUrl", "getErrCode", "getErrMsg", "getExportProgress", "getFeedId", "getFeedTime", "()Z", "getMediaInfos", "()Ljava/util/List;", "getMissionId", "getState", "getTaskId", "getTraceId", "getTransParams", "()Landroid/os/Bundle;", "getType", "getUploadProgress", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "isActive", "isCancelled", "isFinish", "isImageTask", "isNetworkWaiting", "isSuccess", "isVideoComment", "isVideoTask", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class TaskInfo implements Parcelable {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_VIDEO = 2;
    private final long aliveTimeMillis;
    private final int businessType;

    @NotNull
    private final String clientKey;

    @NotNull
    private final String coverUrl;

    @NotNull
    private final String errCode;

    @NotNull
    private final String errMsg;
    private final int exportProgress;

    @NotNull
    private final String feedId;
    private final long feedTime;
    private final boolean isTrueUpload;

    @NotNull
    private final List<MediaInfo> mediaInfos;

    @NotNull
    private final String missionId;
    private final int state;
    private final long taskId;

    @NotNull
    private final String traceId;

    @Nullable
    private final Bundle transParams;
    private final int type;
    private final int uploadProgress;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TaskInfo> CREATOR = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/winkpublish/TaskInfo$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<TaskInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TaskInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TaskInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TaskInfo[] newArray(int size) {
            return new TaskInfo[size];
        }
    }

    public TaskInfo(long j3, int i3, int i16, @NotNull String missionId, @NotNull String clientKey, @NotNull String traceId, long j16, int i17, @NotNull String coverUrl, boolean z16, int i18, @NotNull String feedId, long j17, @NotNull List<MediaInfo> mediaInfos, @NotNull String errCode, @NotNull String errMsg, @Nullable Bundle bundle, int i19) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.taskId = j3;
        this.state = i3;
        this.type = i16;
        this.missionId = missionId;
        this.clientKey = clientKey;
        this.traceId = traceId;
        this.aliveTimeMillis = j16;
        this.uploadProgress = i17;
        this.coverUrl = coverUrl;
        this.isTrueUpload = z16;
        this.businessType = i18;
        this.feedId = feedId;
        this.feedTime = j17;
        this.mediaInfos = mediaInfos;
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.transParams = bundle;
        this.exportProgress = i19;
    }

    /* renamed from: component1, reason: from getter */
    public final long getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsTrueUpload() {
        return this.isTrueUpload;
    }

    /* renamed from: component11, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component13, reason: from getter */
    public final long getFeedTime() {
        return this.feedTime;
    }

    @NotNull
    public final List<MediaInfo> component14() {
        return this.mediaInfos;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getErrCode() {
        return this.errCode;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Bundle getTransParams() {
        return this.transParams;
    }

    /* renamed from: component18, reason: from getter */
    public final int getExportProgress() {
        return this.exportProgress;
    }

    /* renamed from: component2, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getClientKey() {
        return this.clientKey;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component7, reason: from getter */
    public final long getAliveTimeMillis() {
        return this.aliveTimeMillis;
    }

    /* renamed from: component8, reason: from getter */
    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final TaskInfo copy(long taskId, int state, int type, @NotNull String missionId, @NotNull String clientKey, @NotNull String traceId, long aliveTimeMillis, int uploadProgress, @NotNull String coverUrl, boolean isTrueUpload, int businessType, @NotNull String feedId, long feedTime, @NotNull List<MediaInfo> mediaInfos, @NotNull String errCode, @NotNull String errMsg, @Nullable Bundle transParams, int exportProgress) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        return new TaskInfo(taskId, state, type, missionId, clientKey, traceId, aliveTimeMillis, uploadProgress, coverUrl, isTrueUpload, businessType, feedId, feedTime, mediaInfos, errCode, errMsg, transParams, exportProgress);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfo)) {
            return false;
        }
        TaskInfo taskInfo = (TaskInfo) other;
        if (this.taskId == taskInfo.taskId && this.state == taskInfo.state && this.type == taskInfo.type && Intrinsics.areEqual(this.missionId, taskInfo.missionId) && Intrinsics.areEqual(this.clientKey, taskInfo.clientKey) && Intrinsics.areEqual(this.traceId, taskInfo.traceId) && this.aliveTimeMillis == taskInfo.aliveTimeMillis && this.uploadProgress == taskInfo.uploadProgress && Intrinsics.areEqual(this.coverUrl, taskInfo.coverUrl) && this.isTrueUpload == taskInfo.isTrueUpload && this.businessType == taskInfo.businessType && Intrinsics.areEqual(this.feedId, taskInfo.feedId) && this.feedTime == taskInfo.feedTime && Intrinsics.areEqual(this.mediaInfos, taskInfo.mediaInfos) && Intrinsics.areEqual(this.errCode, taskInfo.errCode) && Intrinsics.areEqual(this.errMsg, taskInfo.errMsg) && Intrinsics.areEqual(this.transParams, taskInfo.transParams) && this.exportProgress == taskInfo.exportProgress) {
            return true;
        }
        return false;
    }

    public final long getAliveTimeMillis() {
        return this.aliveTimeMillis;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final String getClientKey() {
        return this.clientKey;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getErrCode() {
        return this.errCode;
    }

    @NotNull
    public final String getErrMsg() {
        return this.errMsg;
    }

    public final int getExportProgress() {
        return this.exportProgress;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final long getFeedTime() {
        return this.feedTime;
    }

    @NotNull
    public final List<MediaInfo> getMediaInfos() {
        return this.mediaInfos;
    }

    @NotNull
    public final String getMissionId() {
        return this.missionId;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    @Nullable
    public final Bundle getTransParams() {
        return this.transParams;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = ((((((((((((((((androidx.fragment.app.a.a(this.taskId) * 31) + this.state) * 31) + this.type) * 31) + this.missionId.hashCode()) * 31) + this.clientKey.hashCode()) * 31) + this.traceId.hashCode()) * 31) + androidx.fragment.app.a.a(this.aliveTimeMillis)) * 31) + this.uploadProgress) * 31) + this.coverUrl.hashCode()) * 31;
        boolean z16 = this.isTrueUpload;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((((((a16 + i3) * 31) + this.businessType) * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.feedTime)) * 31) + this.mediaInfos.hashCode()) * 31) + this.errCode.hashCode()) * 31) + this.errMsg.hashCode()) * 31;
        Bundle bundle = this.transParams;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.exportProgress;
    }

    public final boolean isActive() {
        int i3 = this.state;
        if (i3 == 0 || i3 == 1 || i3 == 6) {
            return true;
        }
        return false;
    }

    public final boolean isCancelled() {
        if (this.state == 5) {
            return true;
        }
        return false;
    }

    public final boolean isFinish() {
        if (this.state == 3) {
            return true;
        }
        return false;
    }

    public final boolean isImageTask() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public final boolean isNetworkWaiting() {
        if (this.state == 6) {
            return true;
        }
        return false;
    }

    public final boolean isSuccess() {
        boolean z16;
        if (this.businessType != 1) {
            return false;
        }
        if (!Intrinsics.areEqual("10027", this.errCode)) {
            if (this.feedId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || this.feedTime == 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isTrueUpload() {
        return this.isTrueUpload;
    }

    public final boolean isVideoComment() {
        boolean z16;
        Bundle bundle = this.transParams;
        if (bundle != null && bundle.containsKey(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    public final boolean isVideoTask() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "TaskInfo(taskId=" + this.taskId + ", state=" + this.state + ", type=" + this.type + ", missionId=" + this.missionId + ", clientKey=" + this.clientKey + ", traceId=" + this.traceId + ", aliveTimeMillis=" + this.aliveTimeMillis + ", uploadProgress=" + this.uploadProgress + ", coverUrl=" + this.coverUrl + ", isTrueUpload=" + this.isTrueUpload + ", businessType=" + this.businessType + ", feedId=" + this.feedId + ", feedTime=" + this.feedTime + ", mediaInfos=" + this.mediaInfos + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", transParams=" + this.transParams + ", exportProgress=" + this.exportProgress + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.state);
        parcel.writeInt(this.type);
        parcel.writeString(this.missionId);
        parcel.writeString(this.clientKey);
        parcel.writeString(this.traceId);
        parcel.writeLong(this.aliveTimeMillis);
        parcel.writeInt(this.uploadProgress);
        parcel.writeString(this.coverUrl);
        parcel.writeByte(this.isTrueUpload ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.businessType);
        parcel.writeString(this.feedId);
        parcel.writeLong(this.feedTime);
        parcel.writeTypedList(this.mediaInfos);
        parcel.writeString(this.errCode);
        parcel.writeString(this.errMsg);
        parcel.writeBundle(this.transParams);
        parcel.writeInt(this.exportProgress);
    }

    public /* synthetic */ TaskInfo(long j3, int i3, int i16, String str, String str2, String str3, long j16, int i17, String str4, boolean z16, int i18, String str5, long j17, List list, String str6, String str7, Bundle bundle, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, i16, str, str2, str3, j16, i17, str4, z16, i18, str5, j17, list, (i26 & 16384) != 0 ? "" : str6, (32768 & i26) != 0 ? "" : str7, (65536 & i26) != 0 ? null : bundle, (i26 & 131072) != 0 ? 0 : i19);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TaskInfo(@NotNull Parcel parcel) {
        this(r3, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r19, r20, r1 == null ? "" : r1, parcel.readBundle(Bundle.class.getClassLoader()), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        long readLong = parcel.readLong();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        long readLong2 = parcel.readLong();
        int readInt3 = parcel.readInt();
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        boolean z16 = parcel.readByte() != 0;
        int readInt4 = parcel.readInt();
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        long readLong3 = parcel.readLong();
        List createTypedArrayList = parcel.createTypedArrayList(MediaInfo.INSTANCE);
        List emptyList = createTypedArrayList == null ? CollectionsKt__CollectionsKt.emptyList() : createTypedArrayList;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
    }
}
