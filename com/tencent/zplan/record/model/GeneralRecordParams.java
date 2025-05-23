package com.tencent.zplan.record.model;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b)\u0018\u00002\u00020\u0001B\u00b9\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\f\u0012\u0006\u0010$\u001a\u00020 \u0012\b\b\u0002\u0010&\u001a\u00020\u0017\u0012\b\b\u0002\u0010(\u001a\u00020\u0017\u0012\b\b\u0002\u0010.\u001a\u00020)\u0012\b\b\u0002\u00104\u001a\u00020/\u0012\b\b\u0002\u00107\u001a\u00020\u0017\u0012\b\b\u0002\u0010:\u001a\u00020\u0017\u0012\b\b\u0002\u0010=\u001a\u00020\u0017\u0012\b\b\u0002\u0010E\u001a\u00020>\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010J\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010]\u001a\u00020V\u0012\b\b\u0002\u0010b\u001a\u00020\u0017\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010u\u001a\u00020n\u0012\b\b\u0002\u0010y\u001a\u00020n\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020z\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020z\u0012\t\b\u0002\u0010\u0089\u0001\u001a\u00020z\u0012\t\b\u0002\u0010\u008d\u0001\u001a\u00020z\u0012\t\b\u0002\u0010\u0091\u0001\u001a\u00020z\u0012\t\b\u0002\u0010\u0095\u0001\u001a\u00020z\u0012\t\b\u0002\u0010\u0099\u0001\u001a\u00020z\u0012\u000b\b\u0002\u0010\u00a0\u0001\u001a\u0004\u0018\u00010z\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001b\u0010\u0013\u001a\u00020\u000f8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010&\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u0017\u0010(\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00107\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001aR\u0017\u0010:\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001aR\u0017\u0010=\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b;\u0010\u0018\u001a\u0004\b<\u0010\u001aR\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010I\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010@\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR$\u0010Q\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010U\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010L\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR\"\u0010]\u001a\u00020V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010b\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010\u0018\u001a\u0004\b_\u0010\u001a\"\u0004\b`\u0010aR$\u0010i\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010m\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010d\u001a\u0004\bk\u0010f\"\u0004\bl\u0010hR\"\u0010u\u001a\u00020n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010y\u001a\u00020n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010p\u001a\u0004\bw\u0010r\"\u0004\bx\u0010tR$\u0010\u0081\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R'\u0010\u0085\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0082\u0001\u0010|\u001a\u0005\b\u0083\u0001\u0010~\"\u0006\b\u0084\u0001\u0010\u0080\u0001R'\u0010\u0089\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0086\u0001\u0010|\u001a\u0005\b\u0087\u0001\u0010~\"\u0006\b\u0088\u0001\u0010\u0080\u0001R'\u0010\u008d\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u008a\u0001\u0010|\u001a\u0005\b\u008b\u0001\u0010~\"\u0006\b\u008c\u0001\u0010\u0080\u0001R'\u0010\u0091\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u008e\u0001\u0010|\u001a\u0005\b\u008f\u0001\u0010~\"\u0006\b\u0090\u0001\u0010\u0080\u0001R'\u0010\u0095\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0092\u0001\u0010|\u001a\u0005\b\u0093\u0001\u0010~\"\u0006\b\u0094\u0001\u0010\u0080\u0001R'\u0010\u0099\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0096\u0001\u0010|\u001a\u0005\b\u0097\u0001\u0010~\"\u0006\b\u0098\u0001\u0010\u0080\u0001R+\u0010\u00a0\u0001\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001\u00a8\u0006\u00a3\u0001"}, d2 = {"Lcom/tencent/zplan/record/model/GeneralRecordParams;", "", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "c", "Lcom/tencent/zplan/common/model/UploadConfig;", "g", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "b", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "a", "Lcom/tencent/zplan/record/model/ExpireConfig;", "d", "", "Lcom/tencent/zplan/record/model/Source;", "f", "Lyx4/c;", "Lkotlin/Lazy;", "e", "()Lyx4/c;", "memeProxy", "Lcom/tencent/zplan/record/model/c;", "Lcom/tencent/zplan/record/model/c;", "generalRecordSwitches", "", "I", "getResourceId", "()I", "resourceId", "Ljava/util/List;", "getResourcesIds", "()Ljava/util/List;", "resourcesIds", "Lcom/tencent/zplan/record/a;", "Lcom/tencent/zplan/record/a;", "getScene", "()Lcom/tencent/zplan/record/a;", "scene", "getWidth", "width", "getHeight", "height", "Lcom/tencent/zplan/meme/action/MODE;", h.F, "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/Priority;", "i", "Lcom/tencent/zplan/meme/Priority;", "getPriority", "()Lcom/tencent/zplan/meme/Priority;", "priority", "j", "getReqFrom", "reqFrom", "k", "getBodyType", "bodyType", "l", "getCloudRecordScene", "cloudRecordScene", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getSenderUin", "()Ljava/lang/String;", "setSenderUin", "(Ljava/lang/String;)V", AppConstants.Key.COLUMN_MSG_SENDER_UIN, DomainData.DOMAIN_NAME, "getReceiverUin", "setReceiverUin", "receiverUin", "Lcom/tencent/zplan/meme/model/a;", "o", "Lcom/tencent/zplan/meme/model/a;", "getSenderAvatarCharacterInfo", "()Lcom/tencent/zplan/meme/model/a;", "setSenderAvatarCharacterInfo", "(Lcom/tencent/zplan/meme/model/a;)V", "senderAvatarCharacterInfo", "p", "getReceiverAvatarCharacterInfo", "setReceiverAvatarCharacterInfo", "receiverAvatarCharacterInfo", "Lcom/tencent/zplan/common/model/AppTheme;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/common/model/AppTheme;", "getTheme", "()Lcom/tencent/zplan/common/model/AppTheme;", "setTheme", "(Lcom/tencent/zplan/common/model/AppTheme;)V", "theme", "r", "getBackgroundColor", "setBackgroundColor", "(I)V", "backgroundColor", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/Integer;", "getAaLevel", "()Ljava/lang/Integer;", "setAaLevel", "(Ljava/lang/Integer;)V", "aaLevel", "t", "getAaType", "setAaType", "aaType", "", "u", "J", "getDelayForCloud", "()J", "setDelayForCloud", "(J)V", "delayForCloud", "v", "getDelayForLocal", "setDelayForLocal", "delayForLocal", "", "w", "Z", "getEnableLocalCache", "()Z", "setEnableLocalCache", "(Z)V", "enableLocalCache", HippyTKDListViewAdapter.X, "getEnableLocalRecord", "setEnableLocalRecord", "enableLocalRecord", "y", "getEnableCloudCache", "setEnableCloudCache", "enableCloudCache", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getCheckAppearanceKey", "setCheckAppearanceKey", "checkAppearanceKey", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getNeedCheckUploadConfigRequirement", "setNeedCheckUploadConfigRequirement", "needCheckUploadConfigRequirement", "B", "getEnableCheckExpire", "setEnableCheckExpire", "enableCheckExpire", BdhLogUtil.LogTag.Tag_Conn, "getSaveEachFrame2File", "setSaveEachFrame2File", "saveEachFrame2File", "D", "Ljava/lang/Boolean;", "getSkipHotPatch", "()Ljava/lang/Boolean;", "setSkipHotPatch", "(Ljava/lang/Boolean;)V", "skipHotPatch", "<init>", "(ILjava/util/List;Lcom/tencent/zplan/record/a;IILcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/meme/Priority;IIILjava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/common/model/AppTheme;ILjava/lang/Integer;Ljava/lang/Integer;JJZZZZZZZLjava/lang/Boolean;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class GeneralRecordParams {

    /* renamed from: A, reason: from kotlin metadata */
    private boolean needCheckUploadConfigRequirement;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean enableCheckExpire;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean saveEachFrame2File;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Boolean skipHotPatch;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy memeProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final GeneralRecordSwitches generalRecordSwitches;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int resourceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> resourcesIds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.zplan.record.a scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Priority priority;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int reqFrom;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int bodyType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int cloudRecordScene;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String senderUin;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String receiverUin;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarCharacterInfo senderAvatarCharacterInfo;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarCharacterInfo receiverAvatarCharacterInfo;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AppTheme theme;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int backgroundColor;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer aaLevel;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer aaType;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long delayForCloud;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private long delayForLocal;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean enableLocalCache;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean enableLocalRecord;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean enableCloudCache;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean checkAppearanceKey;

    public GeneralRecordParams(int i3, @NotNull List<Integer> resourcesIds, @NotNull com.tencent.zplan.record.a scene, int i16, int i17, @NotNull MODE mode, @NotNull Priority priority, int i18, int i19, int i26, @NotNull String senderUin, @Nullable String str, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable AvatarCharacterInfo avatarCharacterInfo2, @NotNull AppTheme theme, int i27, @Nullable Integer num, @Nullable Integer num2, long j3, long j16, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, @Nullable Boolean bool) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(resourcesIds, "resourcesIds");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.resourceId = i3;
        this.resourcesIds = resourcesIds;
        this.scene = scene;
        this.width = i16;
        this.height = i17;
        this.mode = mode;
        this.priority = priority;
        this.reqFrom = i18;
        this.bodyType = i19;
        this.cloudRecordScene = i26;
        this.senderUin = senderUin;
        this.receiverUin = str;
        this.senderAvatarCharacterInfo = avatarCharacterInfo;
        this.receiverAvatarCharacterInfo = avatarCharacterInfo2;
        this.theme = theme;
        this.backgroundColor = i27;
        this.aaLevel = num;
        this.aaType = num2;
        this.delayForCloud = j3;
        this.delayForLocal = j16;
        this.enableLocalCache = z16;
        this.enableLocalRecord = z17;
        this.enableCloudCache = z18;
        this.checkAppearanceKey = z19;
        this.needCheckUploadConfigRequirement = z26;
        this.enableCheckExpire = z27;
        this.saveEachFrame2File = z28;
        this.skipHotPatch = bool;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<yx4.c>() { // from class: com.tencent.zplan.record.model.GeneralRecordParams$memeProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yx4.c invoke() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                return (yx4.c) a16;
            }
        });
        this.memeProxy = lazy;
        GeneralRecordSwitches h16 = e().h(scene);
        this.generalRecordSwitches = h16;
        this.senderUin = e().r();
        this.enableCloudCache = h16.getCloudSwitches().getEnableCloudCache();
    }

    private final BusinessConfig c() {
        Boolean bool;
        EngineType v3 = e().v(this.generalRecordSwitches.getRenderSwitches().getEnableFilament());
        int i3 = this.backgroundColor;
        Integer num = this.aaType;
        Integer num2 = this.aaLevel;
        Boolean bool2 = this.skipHotPatch;
        boolean z16 = this.saveEachFrame2File;
        if (v3 instanceof EngineType.Filament) {
            bool = Boolean.TRUE;
        } else {
            bool = null;
        }
        BusinessConfig businessConfig = new BusinessConfig(i3, false, z16, false, null, 0, null, null, num, num2, null, bool2, null, false, bool, this.bodyType, Boolean.valueOf(this.generalRecordSwitches.getRenderSwitches().getDisableGlassesMetallic()), 13562, null);
        businessConfig.G(v3);
        return businessConfig;
    }

    private final UploadConfig g() {
        UploadConfig.UploadTarget uploadTarget;
        boolean enableUploadToCloud = this.generalRecordSwitches.getCloudSwitches().getEnableUploadToCloud();
        if (this.generalRecordSwitches.getCloudSwitches().getUploadToIDC()) {
            uploadTarget = UploadConfig.UploadTarget.IDC;
        } else {
            uploadTarget = UploadConfig.UploadTarget.CDN;
        }
        return new UploadConfig(enableUploadToCloud, uploadTarget, this.checkAppearanceKey, this.needCheckUploadConfigRequirement);
    }

    @NotNull
    public final BatchRecordRequestParams a() {
        Map emptyMap;
        List<Integer> list = this.resourcesIds;
        emptyMap = MapsKt__MapsKt.emptyMap();
        BatchRecordRequestParams batchRecordRequestParams = new BatchRecordRequestParams(list, emptyMap, this.theme, this.senderUin, this.receiverUin, this.width, this.height, this.mode, c(), this.cloudRecordScene, this.priority, g(), d(), this.reqFrom, false, null, null, 114688, null);
        batchRecordRequestParams.z(this.senderAvatarCharacterInfo);
        batchRecordRequestParams.y(this.receiverAvatarCharacterInfo);
        return batchRecordRequestParams;
    }

    @NotNull
    public final SingleRecordRequestParams b() {
        SingleRecordRequestParams singleRecordRequestParams = new SingleRecordRequestParams(this.resourceId, this.senderUin, this.receiverUin, this.width, this.height, this.mode, c(), this.cloudRecordScene, this.theme, this.priority, g(), d(), this.reqFrom, false, null, null, 57344, null);
        singleRecordRequestParams.x(this.senderAvatarCharacterInfo);
        singleRecordRequestParams.w(this.receiverAvatarCharacterInfo);
        return singleRecordRequestParams;
    }

    @NotNull
    public final ExpireConfig d() {
        return new ExpireConfig(this.enableCheckExpire, this.delayForCloud, this.delayForLocal);
    }

    @NotNull
    public final yx4.c e() {
        return (yx4.c) this.memeProxy.getValue();
    }

    @NotNull
    public final List<Source> f() {
        ArrayList arrayList = new ArrayList();
        if (this.enableLocalCache) {
            arrayList.add(Source.LOCAL_CACHE);
        }
        if (this.enableCloudCache) {
            arrayList.add(Source.CLOUD_CACHE);
        }
        if (this.enableLocalRecord) {
            arrayList.add(Source.LOCAL_RECORD);
        }
        return arrayList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GeneralRecordParams(int i3, List list, com.tencent.zplan.record.a aVar, int i16, int i17, MODE mode, Priority priority, int i18, int i19, int i26, String str, String str2, AvatarCharacterInfo avatarCharacterInfo, AvatarCharacterInfo avatarCharacterInfo2, AppTheme appTheme, int i27, Integer num, Integer num2, long j3, long j16, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, Boolean bool, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, aVar, (i28 & 8) != 0 ? 100 : i16, (i28 & 16) != 0 ? 100 : i17, (i28 & 32) != 0 ? MODE.FRAME : mode, (i28 & 64) != 0 ? Priority.LOW : priority, (i28 & 128) != 0 ? 0 : i18, (i28 & 256) != 0 ? -1 : i19, (i28 & 512) != 0 ? 0 : i26, (i28 & 1024) != 0 ? "" : str, (i28 & 2048) != 0 ? null : str2, (i28 & 4096) != 0 ? null : avatarCharacterInfo, (i28 & 8192) != 0 ? null : avatarCharacterInfo2, (i28 & 16384) != 0 ? AppTheme.DAY : appTheme, (32768 & i28) != 0 ? 0 : i27, (65536 & i28) != 0 ? null : num, (131072 & i28) != 0 ? null : num2, (262144 & i28) != 0 ? JoinTimeType.SEVEN_DAY : j3, (524288 & i28) != 0 ? 0L : j16, (1048576 & i28) != 0 ? true : z16, (2097152 & i28) != 0 ? true : z17, (4194304 & i28) != 0 ? false : z18, (8388608 & i28) != 0 ? true : z19, (16777216 & i28) != 0 ? false : z26, (33554432 & i28) != 0 ? false : z27, (67108864 & i28) != 0 ? false : z28, (i28 & 134217728) != 0 ? null : bool);
        List list2;
        List emptyList;
        int i29 = (i28 & 1) != 0 ? 0 : i3;
        if ((i28 & 2) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }
}
