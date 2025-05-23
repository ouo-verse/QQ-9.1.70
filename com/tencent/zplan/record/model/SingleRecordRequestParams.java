package com.tencent.zplan.record.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.common.utils.i;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u00a3\u0001\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00101\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\u0004\u0012\u0006\u0010:\u001a\u000205\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010C\u001a\u00020\u0004\u0012\b\b\u0002\u0010I\u001a\u00020D\u0012\b\b\u0002\u0010Q\u001a\u00020J\u0012\b\b\u0002\u0010W\u001a\u00020R\u0012\b\b\u0002\u0010]\u001a\u00020X\u0012\b\b\u0002\u0010`\u001a\u00020\u0004\u0012\b\b\u0002\u0010d\u001a\u00020\b\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010m\u001a\u00020h\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001b\u0010\u0015\u001a\u00020\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001a\u00101\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%R\u001a\u00104\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u0010#\u001a\u0004\b3\u0010%R\u001a\u0010:\u001a\u0002058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010@\u001a\u0004\u0018\u00010;8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010C\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010#\u001a\u0004\bB\u0010%R\u001a\u0010I\u001a\u00020D8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010W\u001a\u00020R8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010]\u001a\u00020X8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010`\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b^\u0010#\u001a\u0004\b_\u0010%R\u001a\u0010d\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\ba\u0010S\u001a\u0004\bb\u0010cR\u001c\u0010g\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\be\u0010(\u001a\u0004\bf\u0010*R\u001a\u0010m\u001a\u00020h8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\u00a8\u0006p"}, d2 = {"Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "L", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "action", "Lcom/tencent/zplan/meme/model/a;", "M", "Lcom/tencent/zplan/meme/model/a;", "k", "()Lcom/tencent/zplan/meme/model/a;", HippyTKDListViewAdapter.X, "(Lcom/tencent/zplan/meme/model/a;)V", "senderAvatarCharacterInfo", "N", "t", "w", "receiverAvatarCharacterInfo", "P", "I", "u", "()I", "resourceId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "j", "()Ljava/lang/String;", "sender", BdhLogUtil.LogTag.Tag_Req, ReportConstant.COSTREPORT_PREFIX, "receiver", ExifInterface.LATITUDE_SOUTH, "getWidth", "width", "T", "getHeight", "height", "Lcom/tencent/zplan/meme/action/MODE;", "U", "Lcom/tencent/zplan/meme/action/MODE;", "c", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "V", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "b", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "W", "g", "scene", "Lcom/tencent/zplan/common/model/AppTheme;", "X", "Lcom/tencent/zplan/common/model/AppTheme;", "l", "()Lcom/tencent/zplan/common/model/AppTheme;", "theme", "Lcom/tencent/zplan/meme/Priority;", "Y", "Lcom/tencent/zplan/meme/Priority;", "r", "()Lcom/tencent/zplan/meme/Priority;", "v", "(Lcom/tencent/zplan/meme/Priority;)V", "priority", "Lcom/tencent/zplan/common/model/UploadConfig;", "Z", "Lcom/tencent/zplan/common/model/UploadConfig;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/zplan/common/model/UploadConfig;", "uploadConfig", "Lcom/tencent/zplan/record/model/ExpireConfig;", "a0", "Lcom/tencent/zplan/record/model/ExpireConfig;", "p", "()Lcom/tencent/zplan/record/model/ExpireConfig;", "expireConfig", "b0", "f", "reqFrom", "c0", "o", "()Z", "downloadFromNetIfLocalAbsent", "d0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QQBrowserActivity.APP_PARAM, "Lcom/tencent/zplan/record/model/ReportConfig;", "e0", "Lcom/tencent/zplan/record/model/ReportConfig;", "e", "()Lcom/tencent/zplan/record/model/ReportConfig;", "reportConfig", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/meme/model/BusinessConfig;ILcom/tencent/zplan/common/model/AppTheme;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/common/model/UploadConfig;Lcom/tencent/zplan/record/model/ExpireConfig;IZLjava/lang/String;Lcom/tencent/zplan/record/model/ReportConfig;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class SingleRecordRequestParams extends AbsRecordRequestParams {
    public static final Parcelable.Creator<SingleRecordRequestParams> CREATOR = new a();

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy action;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private AvatarCharacterInfo senderAvatarCharacterInfo;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private AvatarCharacterInfo receiverAvatarCharacterInfo;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    private final int resourceId;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final String sender;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final String receiver;

    /* renamed from: S, reason: from kotlin metadata */
    private final int width;

    /* renamed from: T, reason: from kotlin metadata */
    private final int height;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private final BusinessConfig config;

    /* renamed from: W, reason: from kotlin metadata */
    private final int scene;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final AppTheme theme;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private volatile Priority priority;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final UploadConfig uploadConfig;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExpireConfig expireConfig;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int reqFrom;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final boolean downloadFromNetIfLocalAbsent;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String extraParams;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReportConfig reportConfig;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a implements Parcelable.Creator<SingleRecordRequestParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SingleRecordRequestParams createFromParcel(@NotNull Parcel in5) {
            BusinessConfig businessConfig;
            boolean z16;
            Intrinsics.checkNotNullParameter(in5, "in");
            int readInt = in5.readInt();
            String readString = in5.readString();
            String readString2 = in5.readString();
            int readInt2 = in5.readInt();
            int readInt3 = in5.readInt();
            MODE mode = (MODE) Enum.valueOf(MODE.class, in5.readString());
            if (in5.readInt() != 0) {
                businessConfig = BusinessConfig.CREATOR.createFromParcel(in5);
            } else {
                businessConfig = null;
            }
            BusinessConfig businessConfig2 = businessConfig;
            int readInt4 = in5.readInt();
            AppTheme appTheme = (AppTheme) Enum.valueOf(AppTheme.class, in5.readString());
            Priority priority = (Priority) Enum.valueOf(Priority.class, in5.readString());
            UploadConfig uploadConfig = (UploadConfig) in5.readParcelable(SingleRecordRequestParams.class.getClassLoader());
            ExpireConfig createFromParcel = ExpireConfig.CREATOR.createFromParcel(in5);
            int readInt5 = in5.readInt();
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new SingleRecordRequestParams(readInt, readString, readString2, readInt2, readInt3, mode, businessConfig2, readInt4, appTheme, priority, uploadConfig, createFromParcel, readInt5, z16, in5.readString(), ReportConfig.CREATOR.createFromParcel(in5));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SingleRecordRequestParams[] newArray(int i3) {
            return new SingleRecordRequestParams[i3];
        }
    }

    public /* synthetic */ SingleRecordRequestParams(int i3, String str, String str2, int i16, int i17, MODE mode, BusinessConfig businessConfig, int i18, AppTheme appTheme, Priority priority, UploadConfig uploadConfig, ExpireConfig expireConfig, int i19, boolean z16, String str3, ReportConfig reportConfig, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i26 & 4) != 0 ? null : str2, i16, i17, mode, (i26 & 64) != 0 ? null : businessConfig, (i26 & 128) != 0 ? 0 : i18, (i26 & 256) != 0 ? AppTheme.DAY : appTheme, (i26 & 512) != 0 ? Priority.LOW : priority, (i26 & 1024) != 0 ? new UploadConfig(false, null, false, false, 15, null) : uploadConfig, (i26 & 2048) != 0 ? new ExpireConfig(false, 0L, 0L, 7, null) : expireConfig, (i26 & 4096) != 0 ? 0 : i19, (i26 & 8192) != 0 ? true : z16, (i26 & 16384) != 0 ? null : str3, (i26 & 32768) != 0 ? new ReportConfig(false, 1, null) : reportConfig);
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @Nullable
    /* renamed from: b, reason: from getter */
    public BusinessConfig getConfig() {
        return this.config;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: c, reason: from getter */
    public MODE getMode() {
        return this.mode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: e, reason: from getter */
    public ReportConfig getReportConfig() {
        return this.reportConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SingleRecordRequestParams) {
                SingleRecordRequestParams singleRecordRequestParams = (SingleRecordRequestParams) other;
                if (this.resourceId != singleRecordRequestParams.resourceId || !Intrinsics.areEqual(getSender(), singleRecordRequestParams.getSender()) || !Intrinsics.areEqual(getReceiver(), singleRecordRequestParams.getReceiver()) || getWidth() != singleRecordRequestParams.getWidth() || getHeight() != singleRecordRequestParams.getHeight() || !Intrinsics.areEqual(getMode(), singleRecordRequestParams.getMode()) || !Intrinsics.areEqual(getConfig(), singleRecordRequestParams.getConfig()) || getScene() != singleRecordRequestParams.getScene() || !Intrinsics.areEqual(getTheme(), singleRecordRequestParams.getTheme()) || !Intrinsics.areEqual(getPriority(), singleRecordRequestParams.getPriority()) || !Intrinsics.areEqual(getUploadConfig(), singleRecordRequestParams.getUploadConfig()) || !Intrinsics.areEqual(getExpireConfig(), singleRecordRequestParams.getExpireConfig()) || getReqFrom() != singleRecordRequestParams.getReqFrom() || getDownloadFromNetIfLocalAbsent() != singleRecordRequestParams.getDownloadFromNetIfLocalAbsent() || !Intrinsics.areEqual(getExtraParams(), singleRecordRequestParams.getExtraParams()) || !Intrinsics.areEqual(getReportConfig(), singleRecordRequestParams.getReportConfig())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    /* renamed from: f, reason: from getter */
    public int getReqFrom() {
        return this.reqFrom;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    /* renamed from: g, reason: from getter */
    public int getScene() {
        return this.scene;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    public int getHeight() {
        return this.height;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36 = this.resourceId * 31;
        String sender = getSender();
        int i37 = 0;
        if (sender != null) {
            i3 = sender.hashCode();
        } else {
            i3 = 0;
        }
        int i38 = (i36 + i3) * 31;
        String receiver = getReceiver();
        if (receiver != null) {
            i16 = receiver.hashCode();
        } else {
            i16 = 0;
        }
        int width = (((((i38 + i16) * 31) + getWidth()) * 31) + getHeight()) * 31;
        MODE mode = getMode();
        if (mode != null) {
            i17 = mode.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (width + i17) * 31;
        BusinessConfig config = getConfig();
        if (config != null) {
            i18 = config.hashCode();
        } else {
            i18 = 0;
        }
        int scene = (((i39 + i18) * 31) + getScene()) * 31;
        AppTheme theme = getTheme();
        if (theme != null) {
            i19 = theme.hashCode();
        } else {
            i19 = 0;
        }
        int i46 = (scene + i19) * 31;
        Priority priority = getPriority();
        if (priority != null) {
            i26 = priority.hashCode();
        } else {
            i26 = 0;
        }
        int i47 = (i46 + i26) * 31;
        UploadConfig uploadConfig = getUploadConfig();
        if (uploadConfig != null) {
            i27 = uploadConfig.hashCode();
        } else {
            i27 = 0;
        }
        int i48 = (i47 + i27) * 31;
        ExpireConfig expireConfig = getExpireConfig();
        if (expireConfig != null) {
            i28 = expireConfig.hashCode();
        } else {
            i28 = 0;
        }
        int reqFrom = (((i48 + i28) * 31) + getReqFrom()) * 31;
        boolean downloadFromNetIfLocalAbsent = getDownloadFromNetIfLocalAbsent();
        int i49 = downloadFromNetIfLocalAbsent;
        if (downloadFromNetIfLocalAbsent) {
            i49 = 1;
        }
        int i56 = (reqFrom + i49) * 31;
        String extraParams = getExtraParams();
        if (extraParams != null) {
            i29 = extraParams.hashCode();
        } else {
            i29 = 0;
        }
        int i57 = (i56 + i29) * 31;
        ReportConfig reportConfig = getReportConfig();
        if (reportConfig != null) {
            i37 = reportConfig.hashCode();
        }
        return i57 + i37;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: j, reason: from getter */
    public String getSender() {
        return this.sender;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @Nullable
    /* renamed from: k, reason: from getter */
    public AvatarCharacterInfo getSenderAvatarCharacterInfo() {
        return this.senderAvatarCharacterInfo;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: l, reason: from getter */
    public AppTheme getTheme() {
        return this.theme;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: m, reason: from getter */
    public UploadConfig getUploadConfig() {
        return this.uploadConfig;
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public MemeZPlanAction a() {
        return (MemeZPlanAction) this.action.getValue();
    }

    /* renamed from: o, reason: from getter */
    public boolean getDownloadFromNetIfLocalAbsent() {
        return this.downloadFromNetIfLocalAbsent;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public ExpireConfig getExpireConfig() {
        return this.expireConfig;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public String getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public Priority getPriority() {
        return this.priority;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public String getReceiver() {
        return this.receiver;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public AvatarCharacterInfo getReceiverAvatarCharacterInfo() {
        return this.receiverAvatarCharacterInfo;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SingleRecordRequestParams(");
        sb5.append("resourceId=" + this.resourceId + ", ");
        sb5.append("sender=" + i.a(getSender()) + ", ");
        sb5.append("receiver=" + i.a(getReceiver()) + ", ");
        sb5.append("width=" + getWidth() + ", ");
        sb5.append("height=" + getHeight() + ", ");
        sb5.append("mode=" + getMode() + ", ");
        sb5.append("scene=" + getScene() + ", ");
        sb5.append("theme:" + getTheme() + ", ");
        sb5.append("reqFrom=" + getReqFrom() + ", ");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("priority:");
        sb6.append(getPriority());
        sb5.append(sb6.toString());
        sb5.append(")");
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "StringBuilder().apply(builderAction).toString()");
        return sb7;
    }

    /* renamed from: u, reason: from getter */
    public final int getResourceId() {
        return this.resourceId;
    }

    public void v(@NotNull Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "<set-?>");
        this.priority = priority;
    }

    public void w(@Nullable AvatarCharacterInfo avatarCharacterInfo) {
        this.receiverAvatarCharacterInfo = avatarCharacterInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.resourceId);
        parcel.writeString(this.sender);
        parcel.writeString(this.receiver);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.mode.name());
        BusinessConfig businessConfig = this.config;
        if (businessConfig != null) {
            parcel.writeInt(1);
            businessConfig.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.scene);
        parcel.writeString(this.theme.name());
        parcel.writeString(this.priority.name());
        parcel.writeParcelable(this.uploadConfig, flags);
        this.expireConfig.writeToParcel(parcel, 0);
        parcel.writeInt(this.reqFrom);
        parcel.writeInt(this.downloadFromNetIfLocalAbsent ? 1 : 0);
        parcel.writeString(this.extraParams);
        this.reportConfig.writeToParcel(parcel, 0);
    }

    public void x(@Nullable AvatarCharacterInfo avatarCharacterInfo) {
        this.senderAvatarCharacterInfo = avatarCharacterInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleRecordRequestParams(int i3, @NotNull String sender, @Nullable String str, int i16, int i17, @NotNull MODE mode, @Nullable BusinessConfig businessConfig, int i18, @NotNull AppTheme theme, @NotNull Priority priority, @NotNull UploadConfig uploadConfig, @NotNull ExpireConfig expireConfig, int i19, boolean z16, @Nullable String str2, @NotNull ReportConfig reportConfig) {
        super(sender, str, i16, i17, mode, businessConfig, i18, theme, priority, uploadConfig, expireConfig, i19, z16, str2, reportConfig);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(uploadConfig, "uploadConfig");
        Intrinsics.checkNotNullParameter(expireConfig, "expireConfig");
        Intrinsics.checkNotNullParameter(reportConfig, "reportConfig");
        this.resourceId = i3;
        this.sender = sender;
        this.receiver = str;
        this.width = i16;
        this.height = i17;
        this.mode = mode;
        this.config = businessConfig;
        this.scene = i18;
        this.theme = theme;
        this.priority = priority;
        this.uploadConfig = uploadConfig;
        this.expireConfig = expireConfig;
        this.reqFrom = i19;
        this.downloadFromNetIfLocalAbsent = z16;
        this.extraParams = str2;
        this.reportConfig = reportConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MemeZPlanAction>() { // from class: com.tencent.zplan.record.model.SingleRecordRequestParams$action$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemeZPlanAction invoke() {
                MemeZPlanAction memeZPlanAction = new MemeZPlanAction(SingleRecordRequestParams.this.getResourceId(), SingleRecordRequestParams.this.getMode().toFrameCount(), SingleRecordRequestParams.this.getWidth(), SingleRecordRequestParams.this.getHeight(), SingleRecordRequestParams.this.getMode(), SingleRecordRequestParams.this.getSender(), SingleRecordRequestParams.this.getReceiver(), String.valueOf(SingleRecordRequestParams.this.getResourceId()), SingleRecordRequestParams.this.getTheme(), null, null, SingleRecordRequestParams.this.getSenderAvatarCharacterInfo(), SingleRecordRequestParams.this.getReceiverAvatarCharacterInfo(), SingleRecordRequestParams.this.getExtraParams(), 1536, null);
                BusinessConfig config = SingleRecordRequestParams.this.getConfig();
                if (config != null) {
                    memeZPlanAction.setConfig(config);
                }
                return memeZPlanAction;
            }
        });
        this.action = lazy;
    }
}
