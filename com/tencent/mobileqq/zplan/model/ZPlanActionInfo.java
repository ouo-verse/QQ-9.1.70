package com.tencent.mobileqq.zplan.model;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\tB\u00ef\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u001b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0004\u0012\b\b\u0002\u0010?\u001a\u00020\u0004\u0012\b\b\u0002\u0010F\u001a\u00020@\u0012\b\b\u0002\u0010I\u001a\u00020\u0002\u0012\b\b\u0002\u0010P\u001a\u00020J\u0012\b\b\u0002\u0010R\u001a\u00020\u0004\u0012\b\b\u0002\u0010T\u001a\u00020\u0004\u0012\b\b\u0002\u0010V\u001a\u00020\u0004\u0012\b\b\u0002\u0010X\u001a\u00020\u0004\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bb\u0010cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0011\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b2\u0010\u0015R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\"\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\n\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\n\u001a\u0004\b#\u0010\f\"\u0004\b>\u0010\u000eR\"\u0010F\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b\t\u0010C\"\u0004\bD\u0010ER\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\"\u0010P\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\b:\u0010M\"\u0004\bN\u0010OR\"\u0010R\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\bQ\u0010\u000eR\"\u0010T\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\bS\u0010\u000eR\"\u0010V\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\n\u001a\u0004\bA\u0010\f\"\u0004\bU\u0010\u000eR\"\u0010X\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\bW\u0010\u000eR$\u0010Z\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u0011\u001a\u0004\b1\u0010\u0013\"\u0004\bY\u0010\u0015R$\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0011\u001a\u0004\bK\u0010\u0013\"\u0004\b[\u0010\u0015R\"\u0010a\u001a\u00020]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010<\u001a\u0004\b^\u0010_\"\u0004\b\n\u0010`\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "f", "()I", "y", "(I)V", "id", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;)V", "name", "c", "k", "D", "originType", "Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "d", "Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "o", "()Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "G", "(Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;)V", "recordType", "e", "getIcon", HippyTKDListViewAdapter.X, "icon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "playerNumber", "g", "getDuration", "r", "duration", tl.h.F, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "maleDefaultUrl", "i", "v", "femaleDefaultUrl", "getIntimateMutualType", "setIntimateMutualType", "intimateMutualType", "getIntimateMutualLevel", "setIntimateMutualLevel", "intimateMutualLevel", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "J", "width", "w", "height", "Lcom/tencent/mobileqq/zplan/model/h;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/model/h;", "()Lcom/tencent/mobileqq/zplan/model/h;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/zplan/model/h;)V", "emo2DInfo", "getStickerInfos", "setStickerInfos", "stickerInfos", "Lcom/tencent/zplan/meme/action/MODE;", "p", "Lcom/tencent/zplan/meme/action/MODE;", "()Lcom/tencent/zplan/meme/action/MODE;", "setPic2DMode", "(Lcom/tencent/zplan/meme/action/MODE;)V", "pic2DMode", "u", "encodeWidth", "t", "encodeHeight", UserInfo.SEX_FEMALE, "position", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "lineNumber", "B", "metadataExtraJson", "H", "stickerIdConf", "", "getTimestamp", "()J", "(J)V", "timestamp", "<init>", "(ILjava/lang/String;ILcom/tencent/mobileqq/zplan/model/ZPlanActionType;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIIILcom/tencent/mobileqq/zplan/model/h;Ljava/lang/String;Lcom/tencent/zplan/meme/action/MODE;IIIILjava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.model.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanActionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int originType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ZPlanActionType recordType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int playerNumber;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int duration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String maleDefaultUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String femaleDefaultUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int intimateMutualType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int intimateMutualLevel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int height;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ZPlanEmo2DInfo emo2DInfo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String stickerInfos;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MODE pic2DMode;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private int encodeWidth;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private int encodeHeight;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private int position;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private int lineNumber;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String metadataExtraJson;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String stickerIdConf;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    public ZPlanActionInfo() {
        this(0, null, 0, null, null, 0, 0, null, null, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, null, null, 4194303, null);
    }

    public final void A(@Nullable String str) {
        this.maleDefaultUrl = str;
    }

    public final void B(@Nullable String str) {
        this.metadataExtraJson = str;
    }

    public final void C(@Nullable String str) {
        this.name = str;
    }

    public final void D(int i3) {
        this.originType = i3;
    }

    public final void E(int i3) {
        this.playerNumber = i3;
    }

    public final void F(int i3) {
        this.position = i3;
    }

    public final void G(@NotNull ZPlanActionType zPlanActionType) {
        Intrinsics.checkNotNullParameter(zPlanActionType, "<set-?>");
        this.recordType = zPlanActionType;
    }

    public final void H(@Nullable String str) {
        this.stickerIdConf = str;
    }

    public final void I(long j3) {
        this.timestamp = j3;
    }

    public final void J(int i3) {
        this.width = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ZPlanEmo2DInfo getEmo2DInfo() {
        return this.emo2DInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getEncodeHeight() {
        return this.encodeHeight;
    }

    /* renamed from: c, reason: from getter */
    public final int getEncodeWidth() {
        return this.encodeWidth;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getFemaleDefaultUrl() {
        return this.femaleDefaultUrl;
    }

    /* renamed from: e, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanActionInfo)) {
            return false;
        }
        ZPlanActionInfo zPlanActionInfo = (ZPlanActionInfo) other;
        if (this.id == zPlanActionInfo.id && Intrinsics.areEqual(this.name, zPlanActionInfo.name) && this.originType == zPlanActionInfo.originType && this.recordType == zPlanActionInfo.recordType && Intrinsics.areEqual(this.icon, zPlanActionInfo.icon) && this.playerNumber == zPlanActionInfo.playerNumber && this.duration == zPlanActionInfo.duration && Intrinsics.areEqual(this.maleDefaultUrl, zPlanActionInfo.maleDefaultUrl) && Intrinsics.areEqual(this.femaleDefaultUrl, zPlanActionInfo.femaleDefaultUrl) && this.intimateMutualType == zPlanActionInfo.intimateMutualType && this.intimateMutualLevel == zPlanActionInfo.intimateMutualLevel && this.width == zPlanActionInfo.width && this.height == zPlanActionInfo.height && Intrinsics.areEqual(this.emo2DInfo, zPlanActionInfo.emo2DInfo) && Intrinsics.areEqual(this.stickerInfos, zPlanActionInfo.stickerInfos) && this.pic2DMode == zPlanActionInfo.pic2DMode && this.encodeWidth == zPlanActionInfo.encodeWidth && this.encodeHeight == zPlanActionInfo.encodeHeight && this.position == zPlanActionInfo.position && this.lineNumber == zPlanActionInfo.lineNumber && Intrinsics.areEqual(this.metadataExtraJson, zPlanActionInfo.metadataExtraJson) && Intrinsics.areEqual(this.stickerIdConf, zPlanActionInfo.stickerIdConf)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: g, reason: from getter */
    public final int getLineNumber() {
        return this.lineNumber;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getMaleDefaultUrl() {
        return this.maleDefaultUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i3 = this.id * 31;
        String str = this.name;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode6 = (((((i3 + hashCode) * 31) + this.originType) * 31) + this.recordType.hashCode()) * 31;
        String str2 = this.icon;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (((((hashCode6 + hashCode2) * 31) + this.playerNumber) * 31) + this.duration) * 31;
        String str3 = this.maleDefaultUrl;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.femaleDefaultUrl;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int hashCode7 = (((((((((((((((((((((((i18 + hashCode4) * 31) + this.intimateMutualType) * 31) + this.intimateMutualLevel) * 31) + this.width) * 31) + this.height) * 31) + this.emo2DInfo.hashCode()) * 31) + this.stickerInfos.hashCode()) * 31) + this.pic2DMode.hashCode()) * 31) + this.encodeWidth) * 31) + this.encodeHeight) * 31) + this.position) * 31) + this.lineNumber) * 31;
        String str5 = this.metadataExtraJson;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i19 = (hashCode7 + hashCode5) * 31;
        String str6 = this.stickerIdConf;
        if (str6 != null) {
            i16 = str6.hashCode();
        }
        return i19 + i16;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getMetadataExtraJson() {
        return this.metadataExtraJson;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: k, reason: from getter */
    public final int getOriginType() {
        return this.originType;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final MODE getPic2DMode() {
        return this.pic2DMode;
    }

    /* renamed from: m, reason: from getter */
    public final int getPlayerNumber() {
        return this.playerNumber;
    }

    /* renamed from: n, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final ZPlanActionType getRecordType() {
        return this.recordType;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final String getStickerIdConf() {
        return this.stickerIdConf;
    }

    /* renamed from: q, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void r(int i3) {
        this.duration = i3;
    }

    public final void s(@NotNull ZPlanEmo2DInfo zPlanEmo2DInfo) {
        Intrinsics.checkNotNullParameter(zPlanEmo2DInfo, "<set-?>");
        this.emo2DInfo = zPlanEmo2DInfo;
    }

    public final void t(int i3) {
        this.encodeHeight = i3;
    }

    @NotNull
    public String toString() {
        return "ZPlanActionInfo(id=" + this.id + ", name=" + this.name + ", originType=" + this.originType + ", recordType=" + this.recordType + ", icon=" + this.icon + ", playerNumber=" + this.playerNumber + ", duration=" + this.duration + ", maleDefaultUrl=" + this.maleDefaultUrl + ", femaleDefaultUrl=" + this.femaleDefaultUrl + ", intimateMutualType=" + this.intimateMutualType + ", intimateMutualLevel=" + this.intimateMutualLevel + ", width=" + this.width + ", height=" + this.height + ", emo2DInfo=" + this.emo2DInfo + ", stickerInfos=" + this.stickerInfos + ", pic2DMode=" + this.pic2DMode + ", encodeWidth=" + this.encodeWidth + ", encodeHeight=" + this.encodeHeight + ", position=" + this.position + ", lineNumber=" + this.lineNumber + ", metadataExtraJson=" + this.metadataExtraJson + ", stickerIdConf=" + this.stickerIdConf + ')';
    }

    public final void u(int i3) {
        this.encodeWidth = i3;
    }

    public final void v(@Nullable String str) {
        this.femaleDefaultUrl = str;
    }

    public final void w(int i3) {
        this.height = i3;
    }

    public final void x(@Nullable String str) {
        this.icon = str;
    }

    public final void y(int i3) {
        this.id = i3;
    }

    public final void z(int i3) {
        this.lineNumber = i3;
    }

    public ZPlanActionInfo(int i3, @Nullable String str, int i16, @NotNull ZPlanActionType recordType, @Nullable String str2, int i17, int i18, @Nullable String str3, @Nullable String str4, int i19, int i26, int i27, int i28, @NotNull ZPlanEmo2DInfo emo2DInfo, @NotNull String stickerInfos, @NotNull MODE pic2DMode, int i29, int i36, int i37, int i38, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(emo2DInfo, "emo2DInfo");
        Intrinsics.checkNotNullParameter(stickerInfos, "stickerInfos");
        Intrinsics.checkNotNullParameter(pic2DMode, "pic2DMode");
        this.id = i3;
        this.name = str;
        this.originType = i16;
        this.recordType = recordType;
        this.icon = str2;
        this.playerNumber = i17;
        this.duration = i18;
        this.maleDefaultUrl = str3;
        this.femaleDefaultUrl = str4;
        this.intimateMutualType = i19;
        this.intimateMutualLevel = i26;
        this.width = i27;
        this.height = i28;
        this.emo2DInfo = emo2DInfo;
        this.stickerInfos = stickerInfos;
        this.pic2DMode = pic2DMode;
        this.encodeWidth = i29;
        this.encodeHeight = i36;
        this.position = i37;
        this.lineNumber = i38;
        this.metadataExtraJson = str5;
        this.stickerIdConf = str6;
    }

    public /* synthetic */ ZPlanActionInfo(int i3, String str, int i16, ZPlanActionType zPlanActionType, String str2, int i17, int i18, String str3, String str4, int i19, int i26, int i27, int i28, ZPlanEmo2DInfo zPlanEmo2DInfo, String str5, MODE mode, int i29, int i36, int i37, int i38, String str6, String str7, int i39, DefaultConstructorMarker defaultConstructorMarker) {
        this((i39 & 1) != 0 ? -1 : i3, (i39 & 2) != 0 ? null : str, (i39 & 4) != 0 ? -1 : i16, (i39 & 8) != 0 ? ZPlanActionType.ACTION : zPlanActionType, (i39 & 16) != 0 ? null : str2, (i39 & 32) != 0 ? 1 : i17, (i39 & 64) != 0 ? 0 : i18, (i39 & 128) != 0 ? null : str3, (i39 & 256) != 0 ? null : str4, (i39 & 512) != 0 ? -1 : i19, (i39 & 1024) != 0 ? -1 : i26, (i39 & 2048) != 0 ? 360 : i27, (i39 & 4096) != 0 ? 360 : i28, (i39 & 8192) != 0 ? new ZPlanEmo2DInfo(null, null, 0, 7, null) : zPlanEmo2DInfo, (i39 & 16384) != 0 ? new String() : str5, (i39 & 32768) != 0 ? MODE.GIF : mode, (i39 & 65536) != 0 ? 360 : i29, (i39 & 131072) == 0 ? i36 : 360, (i39 & 262144) != 0 ? 0 : i37, (i39 & 524288) != 0 ? -1 : i38, (i39 & 1048576) != 0 ? null : str6, (i39 & 2097152) != 0 ? null : str7);
    }
}
