package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b9\u0010:B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b9\u0010;J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "f", "()I", "p", "(I)V", "photoNum", "e", "o", "lbsPhotoNum", "", "J", "j", "()J", "r", "(J)V", "startShootTime", h.F, "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "endShootTime", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "c", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", DomainData.DOMAIN_NAME, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;)V", "lbsInfo", "", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "desc", BdhLogUtil.LogTag.Tag_Conn, "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sceneryName", "", "D", "Z", "k", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "userConfirmed", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonMediaLbsArea implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String sceneryName;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean userConfirmed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int photoNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lbsPhotoNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startShootTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long endShootTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonStLBS lbsInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsArea$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonMediaLbsArea> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonMediaLbsArea createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonMediaLbsArea(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonMediaLbsArea[] newArray(int size) {
            return new CommonMediaLbsArea[size];
        }

        Companion() {
        }
    }

    public CommonMediaLbsArea() {
        this.lbsInfo = new CommonStLBS();
        this.desc = "";
        this.sceneryName = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: b, reason: from getter */
    public final long getEndShootTime() {
        return this.endShootTime;
    }

    /* renamed from: c, reason: from getter */
    public final CommonStLBS getLbsInfo() {
        return this.lbsInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getLbsPhotoNum() {
        return this.lbsPhotoNum;
    }

    /* renamed from: f, reason: from getter */
    public final int getPhotoNum() {
        return this.photoNum;
    }

    /* renamed from: g, reason: from getter */
    public final String getSceneryName() {
        return this.sceneryName;
    }

    /* renamed from: j, reason: from getter */
    public final long getStartShootTime() {
        return this.startShootTime;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getUserConfirmed() {
        return this.userConfirmed;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void m(long j3) {
        this.endShootTime = j3;
    }

    public final void n(CommonStLBS commonStLBS) {
        Intrinsics.checkNotNullParameter(commonStLBS, "<set-?>");
        this.lbsInfo = commonStLBS;
    }

    public final void o(int i3) {
        this.lbsPhotoNum = i3;
    }

    public final void p(int i3) {
        this.photoNum = i3;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sceneryName = str;
    }

    public final void r(long j3) {
        this.startShootTime = j3;
    }

    public final void s(boolean z16) {
        this.userConfirmed = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.photoNum);
        parcel.writeInt(this.lbsPhotoNum);
        parcel.writeLong(this.startShootTime);
        parcel.writeLong(this.endShootTime);
        parcel.writeParcelable(this.lbsInfo, flags);
        parcel.writeString(this.desc);
        parcel.writeString(this.sceneryName);
        parcel.writeByte(this.userConfirmed ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonMediaLbsArea(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.photoNum = parcel.readInt();
        this.lbsPhotoNum = parcel.readInt();
        this.startShootTime = parcel.readLong();
        this.endShootTime = parcel.readLong();
        CommonStLBS commonStLBS = (CommonStLBS) parcel.readParcelable(CommonStLBS.class.getClassLoader());
        this.lbsInfo = commonStLBS == null ? new CommonStLBS() : commonStLBS;
        String readString = parcel.readString();
        this.desc = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.sceneryName = readString2 != null ? readString2 : "";
        this.userConfirmed = parcel.readByte() != 0;
    }
}
