package com.qzone.reborn.intimate.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u001e\u0018\u0000 B2\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b?\u0010@B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b?\u0010AJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010$\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\"\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b2\u0010\u0011R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\"\u0010:\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\r\u001a\u0004\b9\u0010\u000f\"\u0004\b&\u0010\u0011R\"\u0010>\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\r\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "Landroid/os/Parcelable;", "", "k", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "uid", "e", "g", "t", "spaceId", "f", "I", "j", "()I", "u", "(I)V", "spaceType", h.F, "r", "memberStatus", "i", "getMemberCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "memberCode", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getExpirationTime", "()J", "l", "(J)V", "expirationTime", BdhLogUtil.LogTag.Tag_Conn, "getRemainSigning", ReportConstant.COSTREPORT_PREFIX, "remainSigning", "D", "p", "manageAvatarUrl", "E", "c", "o", "mainPageAvatarUrl", UserInfo.SEX_FEMALE, "a", "feedAvatarUrl", "G", "b", DomainData.DOMAIN_NAME, "feedPraiseUrl", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceVipInfoBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int remainSigning;

    /* renamed from: D, reason: from kotlin metadata */
    private String manageAvatarUrl;

    /* renamed from: E, reason: from kotlin metadata */
    private String mainPageAvatarUrl;

    /* renamed from: F, reason: from kotlin metadata */
    private String feedAvatarUrl;

    /* renamed from: G, reason: from kotlin metadata */
    private String feedPraiseUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String uid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String spaceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int spaceType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int memberStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String memberCode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long expirationTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZIntimateSpaceVipInfoBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZIntimateSpaceVipInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZIntimateSpaceVipInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZIntimateSpaceVipInfoBean[] newArray(int size) {
            return new QZIntimateSpaceVipInfoBean[size];
        }

        Companion() {
        }
    }

    public QZIntimateSpaceVipInfoBean() {
        this.uid = "";
        this.spaceId = "";
        this.spaceType = -1;
        this.memberStatus = -1;
        this.memberCode = "";
        this.manageAvatarUrl = "";
        this.mainPageAvatarUrl = "";
        this.feedAvatarUrl = "";
        this.feedPraiseUrl = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getFeedAvatarUrl() {
        return this.feedAvatarUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getFeedPraiseUrl() {
        return this.feedPraiseUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getMainPageAvatarUrl() {
        return this.mainPageAvatarUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getManageAvatarUrl() {
        return this.manageAvatarUrl;
    }

    /* renamed from: f, reason: from getter */
    public final int getMemberStatus() {
        return this.memberStatus;
    }

    /* renamed from: g, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: j, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    public final boolean k() {
        return this.memberStatus == 0;
    }

    public final void l(long j3) {
        this.expirationTime = j3;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedAvatarUrl = str;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedPraiseUrl = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainPageAvatarUrl = str;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.manageAvatarUrl = str;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.memberCode = str;
    }

    public final void r(int i3) {
        this.memberStatus = i3;
    }

    public final void s(int i3) {
        this.remainSigning = i3;
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void u(int i3) {
        this.spaceType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uid);
        parcel.writeString(this.spaceId);
        parcel.writeInt(this.spaceType);
        parcel.writeInt(this.memberStatus);
        parcel.writeString(this.memberCode);
        parcel.writeLong(this.expirationTime);
        parcel.writeInt(this.remainSigning);
        parcel.writeString(this.manageAvatarUrl);
        parcel.writeString(this.mainPageAvatarUrl);
        parcel.writeString(this.feedAvatarUrl);
        parcel.writeString(this.feedPraiseUrl);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceVipInfoBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.uid = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.spaceId = readString2 == null ? "" : readString2;
        this.spaceType = parcel.readInt();
        this.memberStatus = parcel.readInt();
        String readString3 = parcel.readString();
        this.memberCode = readString3 == null ? "" : readString3;
        this.expirationTime = parcel.readLong();
        this.remainSigning = parcel.readInt();
        String readString4 = parcel.readString();
        this.manageAvatarUrl = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.mainPageAvatarUrl = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.feedAvatarUrl = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.feedPraiseUrl = readString7 != null ? readString7 : "";
    }
}
