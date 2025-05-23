package com.tencent.mobileqq.guild.discoveryv2.hotlive.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u00013B\u007f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\t\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u00101\u001a\u00020\u000e\u0012\b\b\u0002\u00104\u001a\u00020\t\u0012\b\b\u0002\u00107\u001a\u00020\t\u00a2\u0006\u0004\b8\u00109B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b8\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010(\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R\u0017\u00101\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\u001dR\u0017\u00104\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0013R\u0017\u00107\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "groupId", "e", "getGroupName", "groupName", "f", "traceId", h.F, "Z", "isRecommend", "()Z", "i", "I", "getPos", "()I", c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getLoadNum", "loadNum", BdhLogUtil.LogTag.Tag_Conn, "getStage", "stage", "D", "b", "pageFrom", "E", "c", "tabTypeValue", UserInfo.SEX_FEMALE, "getHasQuickJoinRed", "hasQuickJoinRed", "G", "a", "appChannel", "H", "getTargetGroupName", "targetGroupName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;IIZLjava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class OpenParam implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private final String stage;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final int pageFrom;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private final int tabTypeValue;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private final boolean hasQuickJoinRed;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final String appChannel;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private final String targetGroupName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRecommend;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pos;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int loadNum;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.hotlive.data.OpenParam$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion implements Parcelable.Creator<OpenParam> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OpenParam createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OpenParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OpenParam[] newArray(int size) {
            return new OpenParam[size];
        }

        Companion() {
        }
    }

    public OpenParam() {
        this(null, null, null, false, 0, 0, null, 0, 0, false, null, null, 4095, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppChannel() {
        return this.appChannel;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageFrom() {
        return this.pageFrom;
    }

    /* renamed from: c, reason: from getter */
    public final int getTabTypeValue() {
        return this.tabTypeValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenParam)) {
            return false;
        }
        OpenParam openParam = (OpenParam) other;
        if (Intrinsics.areEqual(this.groupId, openParam.groupId) && Intrinsics.areEqual(this.groupName, openParam.groupName) && Intrinsics.areEqual(this.traceId, openParam.traceId) && this.isRecommend == openParam.isRecommend && this.pos == openParam.pos && this.loadNum == openParam.loadNum && Intrinsics.areEqual(this.stage, openParam.stage) && this.pageFrom == openParam.pageFrom && this.tabTypeValue == openParam.tabTypeValue && this.hasQuickJoinRed == openParam.hasQuickJoinRed && Intrinsics.areEqual(this.appChannel, openParam.appChannel) && Intrinsics.areEqual(this.targetGroupName, openParam.targetGroupName)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.groupId.hashCode() * 31) + this.groupName.hashCode()) * 31) + this.traceId.hashCode()) * 31;
        boolean z16 = this.isRecommend;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((((((((((hashCode + i16) * 31) + this.pos) * 31) + this.loadNum) * 31) + this.stage.hashCode()) * 31) + this.pageFrom) * 31) + this.tabTypeValue) * 31;
        boolean z17 = this.hasQuickJoinRed;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((hashCode2 + i3) * 31) + this.appChannel.hashCode()) * 31) + this.targetGroupName.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpenParam(groupId=" + this.groupId + ", groupName=" + this.groupName + ", traceId=" + this.traceId + ", isRecommend=" + this.isRecommend + ", pos=" + this.pos + ", loadNum=" + this.loadNum + ", stage=" + this.stage + ", pageFrom=" + this.pageFrom + ", tabTypeValue=" + this.tabTypeValue + ", hasQuickJoinRed=" + this.hasQuickJoinRed + ", appChannel=" + this.appChannel + ", targetGroupName=" + this.targetGroupName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.groupId);
        parcel.writeString(this.groupName);
        parcel.writeString(this.traceId);
        parcel.writeInt(this.isRecommend ? 1 : 0);
        parcel.writeInt(this.pos);
        parcel.writeInt(this.loadNum);
        parcel.writeString(this.stage);
        parcel.writeInt(this.pageFrom);
        parcel.writeInt(this.tabTypeValue);
        parcel.writeInt(this.hasQuickJoinRed ? 1 : 0);
        parcel.writeString(this.appChannel);
        parcel.writeString(this.targetGroupName);
    }

    public OpenParam(@NotNull String groupId, @NotNull String groupName, @NotNull String traceId, boolean z16, int i3, int i16, @NotNull String stage, int i17, int i18, boolean z17, @NotNull String appChannel, @NotNull String targetGroupName) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(appChannel, "appChannel");
        Intrinsics.checkNotNullParameter(targetGroupName, "targetGroupName");
        this.groupId = groupId;
        this.groupName = groupName;
        this.traceId = traceId;
        this.isRecommend = z16;
        this.pos = i3;
        this.loadNum = i16;
        this.stage = stage;
        this.pageFrom = i17;
        this.tabTypeValue = i18;
        this.hasQuickJoinRed = z17;
        this.appChannel = appChannel;
        this.targetGroupName = targetGroupName;
    }

    public /* synthetic */ OpenParam(String str, String str2, String str3, boolean z16, int i3, int i16, String str4, int i17, int i18, boolean z17, String str5, String str6, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? "" : str2, (i19 & 4) != 0 ? "" : str3, (i19 & 8) != 0 ? false : z16, (i19 & 16) != 0 ? 0 : i3, (i19 & 32) != 0 ? 0 : i16, (i19 & 64) != 0 ? "" : str4, (i19 & 128) != 0 ? 0 : i17, (i19 & 256) != 0 ? DiscoverTabType.DEFAULT.getTabType() : i18, (i19 & 512) == 0 ? z17 : false, (i19 & 1024) != 0 ? "" : str5, (i19 & 2048) == 0 ? str6 : "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OpenParam(@NotNull Parcel parcel) {
        this(r4, r5, r6, r0, r8, r9, r10, r11, r12, r13, r14, r1 == null ? "" : r1);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        boolean z16 = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString4 = parcel.readString();
        readString4 = readString4 == null ? "" : readString4;
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        boolean z17 = parcel.readInt() == 1;
        String readString5 = parcel.readString();
        String str4 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
    }
}
