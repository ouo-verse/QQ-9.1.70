package com.tencent.zplan.record.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.common.utils.i;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bI\b\u0087\b\u0018\u00002\u00020\u0001B\u00bb\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u00cb\u0001\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u00c6\u0001J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010$\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0005H\u00d6\u0001R\u001b\u00100\u001a\u00020+8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010\f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bM\u0010J\u001a\u0004\bN\u0010LR\u001a\u0010\u000e\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010\u000f\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bT\u0010RR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010\u0013\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b]\u0010P\u001a\u0004\b^\u0010RR\"\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u001a\u0010\u001a\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bm\u0010P\u001a\u0004\bn\u0010RR\u001a\u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bo\u0010_\u001a\u0004\bp\u0010qR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\br\u0010J\u001a\u0004\bs\u0010LR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\u00a8\u0006z"}, d2 = {"Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "", "toString", "", "", "resourcesIds", "", "Lcom/tencent/zplan/meme/model/BusinessConfig;", Constants.Configs.CONFIGS, "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "sender", "receiver", "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", DownloadInfo.spKey_Config, "scene", "Lcom/tencent/zplan/meme/Priority;", "priority", "Lcom/tencent/zplan/common/model/UploadConfig;", "uploadConfig", "Lcom/tencent/zplan/record/model/ExpireConfig;", "expireConfig", "reqFrom", "", "downloadFromNetIfLocalAbsent", QQBrowserActivity.APP_PARAM, "Lcom/tencent/zplan/record/model/ReportConfig;", "reportConfig", DomainData.DOMAIN_NAME, "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "L", "Lkotlin/Lazy;", "p", "()Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "action", "Lcom/tencent/zplan/meme/model/a;", "M", "Lcom/tencent/zplan/meme/model/a;", "k", "()Lcom/tencent/zplan/meme/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/zplan/meme/model/a;)V", "senderAvatarCharacterInfo", "N", "w", "y", "receiverAvatarCharacterInfo", "P", "Ljava/util/List;", HippyTKDListViewAdapter.X, "()Ljava/util/List;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/Map;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/Map;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/zplan/common/model/AppTheme;", "l", "()Lcom/tencent/zplan/common/model/AppTheme;", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "j", "()Ljava/lang/String;", "T", "v", "U", "I", "getWidth", "()I", "V", "getHeight", "W", "Lcom/tencent/zplan/meme/action/MODE;", "c", "()Lcom/tencent/zplan/meme/action/MODE;", "X", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "b", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", "Y", "g", "Z", "Lcom/tencent/zplan/meme/Priority;", "u", "()Lcom/tencent/zplan/meme/Priority;", "setPriority", "(Lcom/tencent/zplan/meme/Priority;)V", "a0", "Lcom/tencent/zplan/common/model/UploadConfig;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/zplan/common/model/UploadConfig;", "b0", "Lcom/tencent/zplan/record/model/ExpireConfig;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/zplan/record/model/ExpireConfig;", "c0", "f", "d0", "r", "()Z", "e0", "t", "f0", "Lcom/tencent/zplan/record/model/ReportConfig;", "e", "()Lcom/tencent/zplan/record/model/ReportConfig;", "<init>", "(Ljava/util/List;Ljava/util/Map;Lcom/tencent/zplan/common/model/AppTheme;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/meme/model/BusinessConfig;ILcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/common/model/UploadConfig;Lcom/tencent/zplan/record/model/ExpireConfig;IZLjava/lang/String;Lcom/tencent/zplan/record/model/ReportConfig;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class BatchRecordRequestParams extends AbsRecordRequestParams {
    public static final Parcelable.Creator<BatchRecordRequestParams> CREATOR = new a();

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
    @NotNull
    private final List<Integer> resourcesIds;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, BusinessConfig> configs;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final AppTheme theme;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final String sender;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private final String receiver;

    /* renamed from: U, reason: from kotlin metadata */
    private final int width;

    /* renamed from: V, reason: from kotlin metadata */
    private final int height;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private final BusinessConfig config;

    /* renamed from: Y, reason: from kotlin metadata */
    private final int scene;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private volatile Priority priority;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UploadConfig uploadConfig;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExpireConfig expireConfig;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final int reqFrom;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final boolean downloadFromNetIfLocalAbsent;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String extraParams;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReportConfig reportConfig;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a implements Parcelable.Creator<BatchRecordRequestParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BatchRecordRequestParams createFromParcel(@NotNull Parcel in5) {
            BusinessConfig businessConfig;
            boolean z16;
            Intrinsics.checkNotNullParameter(in5, "in");
            int readInt = in5.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Integer.valueOf(in5.readInt()));
                readInt--;
            }
            int readInt2 = in5.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            while (readInt2 != 0) {
                linkedHashMap.put(Integer.valueOf(in5.readInt()), BusinessConfig.CREATOR.createFromParcel(in5));
                readInt2--;
            }
            AppTheme appTheme = (AppTheme) Enum.valueOf(AppTheme.class, in5.readString());
            String readString = in5.readString();
            String readString2 = in5.readString();
            int readInt3 = in5.readInt();
            int readInt4 = in5.readInt();
            MODE mode = (MODE) Enum.valueOf(MODE.class, in5.readString());
            if (in5.readInt() != 0) {
                businessConfig = BusinessConfig.CREATOR.createFromParcel(in5);
            } else {
                businessConfig = null;
            }
            BusinessConfig businessConfig2 = businessConfig;
            int readInt5 = in5.readInt();
            Priority priority = (Priority) Enum.valueOf(Priority.class, in5.readString());
            UploadConfig uploadConfig = (UploadConfig) in5.readParcelable(BatchRecordRequestParams.class.getClassLoader());
            ExpireConfig createFromParcel = ExpireConfig.CREATOR.createFromParcel(in5);
            int readInt6 = in5.readInt();
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new BatchRecordRequestParams(arrayList, linkedHashMap, appTheme, readString, readString2, readInt3, readInt4, mode, businessConfig2, readInt5, priority, uploadConfig, createFromParcel, readInt6, z16, in5.readString(), ReportConfig.CREATOR.createFromParcel(in5));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BatchRecordRequestParams[] newArray(int i3) {
            return new BatchRecordRequestParams[i3];
        }
    }

    public /* synthetic */ BatchRecordRequestParams(List list, Map map, AppTheme appTheme, String str, String str2, int i3, int i16, MODE mode, BusinessConfig businessConfig, int i17, Priority priority, UploadConfig uploadConfig, ExpireConfig expireConfig, int i18, boolean z16, String str3, ReportConfig reportConfig, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, map, appTheme, str, (i19 & 16) != 0 ? null : str2, i3, i16, mode, (i19 & 256) != 0 ? null : businessConfig, (i19 & 512) != 0 ? 0 : i17, (i19 & 1024) != 0 ? Priority.LOW : priority, (i19 & 2048) != 0 ? new UploadConfig(false, null, false, false, 15, null) : uploadConfig, (i19 & 4096) != 0 ? new ExpireConfig(false, 0L, 0L, 7, null) : expireConfig, (i19 & 8192) != 0 ? 0 : i18, (i19 & 16384) != 0 ? true : z16, (32768 & i19) != 0 ? null : str3, (i19 & 65536) != 0 ? new ReportConfig(false, 1, null) : reportConfig);
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
            if (other instanceof BatchRecordRequestParams) {
                BatchRecordRequestParams batchRecordRequestParams = (BatchRecordRequestParams) other;
                if (!Intrinsics.areEqual(this.resourcesIds, batchRecordRequestParams.resourcesIds) || !Intrinsics.areEqual(this.configs, batchRecordRequestParams.configs) || !Intrinsics.areEqual(getTheme(), batchRecordRequestParams.getTheme()) || !Intrinsics.areEqual(getSender(), batchRecordRequestParams.getSender()) || !Intrinsics.areEqual(getReceiver(), batchRecordRequestParams.getReceiver()) || getWidth() != batchRecordRequestParams.getWidth() || getHeight() != batchRecordRequestParams.getHeight() || !Intrinsics.areEqual(getMode(), batchRecordRequestParams.getMode()) || !Intrinsics.areEqual(getConfig(), batchRecordRequestParams.getConfig()) || getScene() != batchRecordRequestParams.getScene() || !Intrinsics.areEqual(getPriority(), batchRecordRequestParams.getPriority()) || !Intrinsics.areEqual(getUploadConfig(), batchRecordRequestParams.getUploadConfig()) || !Intrinsics.areEqual(getExpireConfig(), batchRecordRequestParams.getExpireConfig()) || getReqFrom() != batchRecordRequestParams.getReqFrom() || getDownloadFromNetIfLocalAbsent() != batchRecordRequestParams.getDownloadFromNetIfLocalAbsent() || !Intrinsics.areEqual(getExtraParams(), batchRecordRequestParams.getExtraParams()) || !Intrinsics.areEqual(getReportConfig(), batchRecordRequestParams.getReportConfig())) {
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
        int i36;
        int i37;
        List<Integer> list = this.resourcesIds;
        int i38 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i39 = i3 * 31;
        Map<Integer, BusinessConfig> map = this.configs;
        if (map != null) {
            i16 = map.hashCode();
        } else {
            i16 = 0;
        }
        int i46 = (i39 + i16) * 31;
        AppTheme theme = getTheme();
        if (theme != null) {
            i17 = theme.hashCode();
        } else {
            i17 = 0;
        }
        int i47 = (i46 + i17) * 31;
        String sender = getSender();
        if (sender != null) {
            i18 = sender.hashCode();
        } else {
            i18 = 0;
        }
        int i48 = (i47 + i18) * 31;
        String receiver = getReceiver();
        if (receiver != null) {
            i19 = receiver.hashCode();
        } else {
            i19 = 0;
        }
        int width = (((((i48 + i19) * 31) + getWidth()) * 31) + getHeight()) * 31;
        MODE mode = getMode();
        if (mode != null) {
            i26 = mode.hashCode();
        } else {
            i26 = 0;
        }
        int i49 = (width + i26) * 31;
        BusinessConfig config = getConfig();
        if (config != null) {
            i27 = config.hashCode();
        } else {
            i27 = 0;
        }
        int scene = (((i49 + i27) * 31) + getScene()) * 31;
        Priority priority = getPriority();
        if (priority != null) {
            i28 = priority.hashCode();
        } else {
            i28 = 0;
        }
        int i56 = (scene + i28) * 31;
        UploadConfig uploadConfig = getUploadConfig();
        if (uploadConfig != null) {
            i29 = uploadConfig.hashCode();
        } else {
            i29 = 0;
        }
        int i57 = (i56 + i29) * 31;
        ExpireConfig expireConfig = getExpireConfig();
        if (expireConfig != null) {
            i36 = expireConfig.hashCode();
        } else {
            i36 = 0;
        }
        int reqFrom = (((i57 + i36) * 31) + getReqFrom()) * 31;
        boolean downloadFromNetIfLocalAbsent = getDownloadFromNetIfLocalAbsent();
        int i58 = downloadFromNetIfLocalAbsent;
        if (downloadFromNetIfLocalAbsent) {
            i58 = 1;
        }
        int i59 = (reqFrom + i58) * 31;
        String extraParams = getExtraParams();
        if (extraParams != null) {
            i37 = extraParams.hashCode();
        } else {
            i37 = 0;
        }
        int i65 = (i59 + i37) * 31;
        ReportConfig reportConfig = getReportConfig();
        if (reportConfig != null) {
            i38 = reportConfig.hashCode();
        }
        return i65 + i38;
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

    @NotNull
    public final BatchRecordRequestParams n(@NotNull List<Integer> resourcesIds, @NotNull Map<Integer, BusinessConfig> configs, @NotNull AppTheme theme, @NotNull String sender, @Nullable String receiver, int width, int height, @NotNull MODE mode, @Nullable BusinessConfig config, int scene, @NotNull Priority priority, @NotNull UploadConfig uploadConfig, @NotNull ExpireConfig expireConfig, int reqFrom, boolean downloadFromNetIfLocalAbsent, @Nullable String extraParams, @NotNull ReportConfig reportConfig) {
        Intrinsics.checkNotNullParameter(resourcesIds, "resourcesIds");
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(uploadConfig, "uploadConfig");
        Intrinsics.checkNotNullParameter(expireConfig, "expireConfig");
        Intrinsics.checkNotNullParameter(reportConfig, "reportConfig");
        return new BatchRecordRequestParams(resourcesIds, configs, theme, sender, receiver, width, height, mode, config, scene, priority, uploadConfig, expireConfig, reqFrom, downloadFromNetIfLocalAbsent, extraParams, reportConfig);
    }

    @Override // com.tencent.zplan.record.model.AbsRecordRequestParams
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public MemeZPlanBatchAction a() {
        return (MemeZPlanBatchAction) this.action.getValue();
    }

    @NotNull
    public final Map<Integer, BusinessConfig> q() {
        return this.configs;
    }

    /* renamed from: r, reason: from getter */
    public boolean getDownloadFromNetIfLocalAbsent() {
        return this.downloadFromNetIfLocalAbsent;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public ExpireConfig getExpireConfig() {
        return this.expireConfig;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public String getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("BatchRecordRequestParams(");
        sb5.append("resourcesIds=" + this.resourcesIds + ", ");
        sb5.append("theme=" + getTheme() + ", ");
        sb5.append("uin=" + i.a(getSender()) + ", ");
        sb5.append("width=" + getWidth() + ", ");
        sb5.append("height=" + getHeight() + ", ");
        sb5.append("mode=" + getMode() + ", ");
        sb5.append("scene=" + getScene() + ", ");
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

    @NotNull
    /* renamed from: u, reason: from getter */
    public Priority getPriority() {
        return this.priority;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public String getReceiver() {
        return this.receiver;
    }

    @Nullable
    /* renamed from: w, reason: from getter */
    public AvatarCharacterInfo getReceiverAvatarCharacterInfo() {
        return this.receiverAvatarCharacterInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<Integer> list = this.resourcesIds;
        parcel.writeInt(list.size());
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeInt(it.next().intValue());
        }
        Map<Integer, BusinessConfig> map = this.configs;
        parcel.writeInt(map.size());
        for (Map.Entry<Integer, BusinessConfig> entry : map.entrySet()) {
            parcel.writeInt(entry.getKey().intValue());
            entry.getValue().writeToParcel(parcel, 0);
        }
        parcel.writeString(this.theme.name());
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
        parcel.writeString(this.priority.name());
        parcel.writeParcelable(this.uploadConfig, flags);
        this.expireConfig.writeToParcel(parcel, 0);
        parcel.writeInt(this.reqFrom);
        parcel.writeInt(this.downloadFromNetIfLocalAbsent ? 1 : 0);
        parcel.writeString(this.extraParams);
        this.reportConfig.writeToParcel(parcel, 0);
    }

    @NotNull
    public final List<Integer> x() {
        return this.resourcesIds;
    }

    public void y(@Nullable AvatarCharacterInfo avatarCharacterInfo) {
        this.receiverAvatarCharacterInfo = avatarCharacterInfo;
    }

    public void z(@Nullable AvatarCharacterInfo avatarCharacterInfo) {
        this.senderAvatarCharacterInfo = avatarCharacterInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchRecordRequestParams(@NotNull List<Integer> resourcesIds, @NotNull Map<Integer, BusinessConfig> configs, @NotNull AppTheme theme, @NotNull String sender, @Nullable String str, int i3, int i16, @NotNull MODE mode, @Nullable BusinessConfig businessConfig, int i17, @NotNull Priority priority, @NotNull UploadConfig uploadConfig, @NotNull ExpireConfig expireConfig, int i18, boolean z16, @Nullable String str2, @NotNull ReportConfig reportConfig) {
        super(sender, str, i3, i16, mode, businessConfig, i17, theme, priority, uploadConfig, expireConfig, i18, z16, str2, reportConfig);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(resourcesIds, "resourcesIds");
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(uploadConfig, "uploadConfig");
        Intrinsics.checkNotNullParameter(expireConfig, "expireConfig");
        Intrinsics.checkNotNullParameter(reportConfig, "reportConfig");
        this.resourcesIds = resourcesIds;
        this.configs = configs;
        this.theme = theme;
        this.sender = sender;
        this.receiver = str;
        this.width = i3;
        this.height = i16;
        this.mode = mode;
        this.config = businessConfig;
        this.scene = i17;
        this.priority = priority;
        this.uploadConfig = uploadConfig;
        this.expireConfig = expireConfig;
        this.reqFrom = i18;
        this.downloadFromNetIfLocalAbsent = z16;
        this.extraParams = str2;
        this.reportConfig = reportConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MemeZPlanBatchAction>() { // from class: com.tencent.zplan.record.model.BatchRecordRequestParams$action$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemeZPlanBatchAction invoke() {
                MemeZPlanBatchAction memeZPlanBatchAction = new MemeZPlanBatchAction(BatchRecordRequestParams.this.x(), BatchRecordRequestParams.this.getWidth(), BatchRecordRequestParams.this.getHeight(), BatchRecordRequestParams.this.getSender(), BatchRecordRequestParams.this.getMode(), BatchRecordRequestParams.this.getTheme(), false, null, null, BatchRecordRequestParams.this.getSenderAvatarCharacterInfo(), BatchRecordRequestParams.this.getReceiverAvatarCharacterInfo(), TroopInfo.PAY_PRIVILEGE_ALL, null);
                BusinessConfig config = BatchRecordRequestParams.this.getConfig();
                if (config != null) {
                    memeZPlanBatchAction.setConfig(config);
                }
                return memeZPlanBatchAction;
            }
        });
        this.action = lazy;
    }
}
