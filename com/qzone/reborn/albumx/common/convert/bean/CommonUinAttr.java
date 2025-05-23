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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u0000 82\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\"\u0010,\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\n\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000e\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "k", "()I", "t", "(I)V", "status", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "nick", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "priv", h.F, "j", ReportConstant.COSTREPORT_PREFIX, "shareAlbumid", "", "i", "J", "a", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "addTime", "g", "r", "qa", BdhLogUtil.LogTag.Tag_Conn, "c", "o", "joinTime", "D", "l", "u", "total", "E", "b", DomainData.DOMAIN_NAME, "familyRole", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonUinAttr implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long joinTime;

    /* renamed from: D, reason: from kotlin metadata */
    private int total;

    /* renamed from: E, reason: from kotlin metadata */
    private int familyRole;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String nick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int priv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String shareAlbumid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long addTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String qa;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonUinAttr$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonUinAttr> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonUinAttr createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonUinAttr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonUinAttr[] newArray(int size) {
            return new CommonUinAttr[size];
        }

        Companion() {
        }
    }

    public CommonUinAttr() {
        this.nick = "";
        this.shareAlbumid = "";
        this.qa = "";
    }

    /* renamed from: a, reason: from getter */
    public final long getAddTime() {
        return this.addTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getFamilyRole() {
        return this.familyRole;
    }

    /* renamed from: c, reason: from getter */
    public final long getJoinTime() {
        return this.joinTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: f, reason: from getter */
    public final int getPriv() {
        return this.priv;
    }

    /* renamed from: g, reason: from getter */
    public final String getQa() {
        return this.qa;
    }

    /* renamed from: j, reason: from getter */
    public final String getShareAlbumid() {
        return this.shareAlbumid;
    }

    /* renamed from: k, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: l, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final void m(long j3) {
        this.addTime = j3;
    }

    public final void n(int i3) {
        this.familyRole = i3;
    }

    public final void o(long j3) {
        this.joinTime = j3;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final void q(int i3) {
        this.priv = i3;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qa = str;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareAlbumid = str;
    }

    public final void t(int i3) {
        this.status = i3;
    }

    public final void u(int i3) {
        this.total = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.status);
        parcel.writeString(this.nick);
        parcel.writeInt(this.priv);
        parcel.writeString(this.shareAlbumid);
        parcel.writeLong(this.addTime);
        parcel.writeString(this.qa);
        parcel.writeLong(this.joinTime);
        parcel.writeInt(this.total);
        parcel.writeInt(this.familyRole);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonUinAttr(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.status = parcel.readInt();
        String readString = parcel.readString();
        this.nick = readString == null ? "" : readString;
        this.priv = parcel.readInt();
        String readString2 = parcel.readString();
        this.shareAlbumid = readString2 == null ? "" : readString2;
        this.addTime = parcel.readLong();
        String readString3 = parcel.readString();
        this.qa = readString3 != null ? readString3 : "";
        this.joinTime = parcel.readLong();
        this.total = parcel.readInt();
        this.familyRole = parcel.readInt();
    }
}
