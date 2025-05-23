package com.tencent.zplan.record.model;

import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u00100\u001a\u00020)\u0012\u0006\u00105\u001a\u000201\u0012\u0006\u0010;\u001a\u000206\u0012\u0006\u0010=\u001a\u00020\u000b\u0012\u0006\u0010B\u001a\u00020>\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010J\u001a\u00020F\u00a2\u0006\u0004\bU\u0010VR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001a\u0010(\u001a\u00020#8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00105\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b\u001b\u00104R\u001a\u0010;\u001a\u0002068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010=\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b<\u0010\r\u001a\u0004\b\f\u0010\u000fR\u001a\u0010B\u001a\u00020>8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010E\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006R\u001a\u0010J\u001a\u00020F8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\b\b\u0010IR\u0014\u0010N\u001a\u00020K8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u001e\u0010T\u001a\u0004\u0018\u00010O8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S\u00a8\u0006W"}, d2 = {"Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "Landroid/os/Parcelable;", "", "d", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "sender", "e", "getReceiver", "receiver", "", "f", "I", "getWidth", "()I", "width", h.F, "getHeight", "height", "Lcom/tencent/zplan/meme/action/MODE;", "i", "Lcom/tencent/zplan/meme/action/MODE;", "c", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/model/BusinessConfig;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/zplan/meme/model/BusinessConfig;", "b", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, BdhLogUtil.LogTag.Tag_Conn, "g", "scene", "Lcom/tencent/zplan/common/model/AppTheme;", "D", "Lcom/tencent/zplan/common/model/AppTheme;", "l", "()Lcom/tencent/zplan/common/model/AppTheme;", "theme", "Lcom/tencent/zplan/meme/Priority;", "E", "Lcom/tencent/zplan/meme/Priority;", "getPriority", "()Lcom/tencent/zplan/meme/Priority;", "setPriority", "(Lcom/tencent/zplan/meme/Priority;)V", "priority", "Lcom/tencent/zplan/common/model/UploadConfig;", UserInfo.SEX_FEMALE, "Lcom/tencent/zplan/common/model/UploadConfig;", "()Lcom/tencent/zplan/common/model/UploadConfig;", "uploadConfig", "Lcom/tencent/zplan/record/model/ExpireConfig;", "G", "Lcom/tencent/zplan/record/model/ExpireConfig;", "getExpireConfig", "()Lcom/tencent/zplan/record/model/ExpireConfig;", "expireConfig", "H", "reqFrom", "", "Z", "getDownloadFromNetIfLocalAbsent", "()Z", "downloadFromNetIfLocalAbsent", "J", "getExtraParams", QQBrowserActivity.APP_PARAM, "Lcom/tencent/zplan/record/model/ReportConfig;", "K", "Lcom/tencent/zplan/record/model/ReportConfig;", "()Lcom/tencent/zplan/record/model/ReportConfig;", "reportConfig", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "a", "()Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "Lcom/tencent/zplan/meme/model/a;", "k", "()Lcom/tencent/zplan/meme/model/a;", "setSenderAvatarCharacterInfo", "(Lcom/tencent/zplan/meme/model/a;)V", "senderAvatarCharacterInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/meme/model/BusinessConfig;ILcom/tencent/zplan/common/model/AppTheme;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/common/model/UploadConfig;Lcom/tencent/zplan/record/model/ExpireConfig;IZLjava/lang/String;Lcom/tencent/zplan/record/model/ReportConfig;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class AbsRecordRequestParams implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata */
    private final int scene;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AppTheme theme;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private volatile Priority priority;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final UploadConfig uploadConfig;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ExpireConfig expireConfig;

    /* renamed from: H, reason: from kotlin metadata */
    private final int reqFrom;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean downloadFromNetIfLocalAbsent;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final String extraParams;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ReportConfig reportConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sender;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String receiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BusinessConfig config;

    public AbsRecordRequestParams(@NotNull String sender, @Nullable String str, int i3, int i16, @NotNull MODE mode, @Nullable BusinessConfig businessConfig, int i17, @NotNull AppTheme theme, @NotNull Priority priority, @NotNull UploadConfig uploadConfig, @NotNull ExpireConfig expireConfig, int i18, boolean z16, @Nullable String str2, @NotNull ReportConfig reportConfig) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(uploadConfig, "uploadConfig");
        Intrinsics.checkNotNullParameter(expireConfig, "expireConfig");
        Intrinsics.checkNotNullParameter(reportConfig, "reportConfig");
        this.sender = sender;
        this.receiver = str;
        this.width = i3;
        this.height = i16;
        this.mode = mode;
        this.config = businessConfig;
        this.scene = i17;
        this.theme = theme;
        this.priority = priority;
        this.uploadConfig = uploadConfig;
        this.expireConfig = expireConfig;
        this.reqFrom = i18;
        this.downloadFromNetIfLocalAbsent = z16;
        this.extraParams = str2;
        this.reportConfig = reportConfig;
    }

    @NotNull
    public abstract MemeZPlanBaseAction a();

    @Nullable
    /* renamed from: b, reason: from getter */
    public BusinessConfig getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String() {
        return this.config;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public MODE getMode() {
        return this.mode;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public ReportConfig getReportConfig() {
        return this.reportConfig;
    }

    /* renamed from: f, reason: from getter */
    public int getReqFrom() {
        return this.reqFrom;
    }

    /* renamed from: g, reason: from getter */
    public int getScene() {
        return this.scene;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public String getSender() {
        return this.sender;
    }

    @Nullable
    /* renamed from: k */
    public abstract AvatarCharacterInfo getSenderAvatarCharacterInfo();

    @NotNull
    /* renamed from: l, reason: from getter */
    public AppTheme getTheme() {
        return this.theme;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public UploadConfig getUploadConfig() {
        return this.uploadConfig;
    }
}
