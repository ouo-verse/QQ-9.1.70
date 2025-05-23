package com.qzone.reborn.publish.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\u0018\u0000 42\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b1\u00102B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b1\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b \u0010\u000fR$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000f\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "title", "e", "b", "l", "desc", "f", "I", "c", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "descTruncateNum", h.F, "p", AudienceReportConst.PROTOCOL, "i", "o", "picUrl", "getId", DomainData.DOMAIN_NAME, "id", BdhLogUtil.LogTag.Tag_Conn, "j", ReportConstant.COSTREPORT_PREFIX, "uin", "D", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "time", "E", "a", "k", "advId", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishTagBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String uin;

    /* renamed from: D, reason: from kotlin metadata */
    private String time;

    /* renamed from: E, reason: from kotlin metadata */
    private String advId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int descTruncateNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String protocol;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String picUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String id;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/publish/bean/QZonePublishTagBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.publish.bean.QZonePublishTagBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZonePublishTagBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZonePublishTagBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZonePublishTagBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZonePublishTagBean[] newArray(int size) {
            return new QZonePublishTagBean[size];
        }

        Companion() {
        }
    }

    public QZonePublishTagBean() {
    }

    /* renamed from: a, reason: from getter */
    public final String getAdvId() {
        return this.advId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: c, reason: from getter */
    public final int getDescTruncateNum() {
        return this.descTruncateNum;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: f, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* renamed from: g, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    /* renamed from: j, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void k(String str) {
        this.advId = str;
    }

    public final void l(String str) {
        this.desc = str;
    }

    public final void m(int i3) {
        this.descTruncateNum = i3;
    }

    public final void n(String str) {
        this.id = str;
    }

    public final void o(String str) {
        this.picUrl = str;
    }

    public final void p(String str) {
        this.protocol = str;
    }

    public final void q(String str) {
        this.time = str;
    }

    public final void r(String str) {
        this.title = str;
    }

    public final void s(String str) {
        this.uin = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeInt(this.descTruncateNum);
        parcel.writeString(this.protocol);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.id);
        parcel.writeString(this.uin);
        parcel.writeString(this.time);
        parcel.writeString(this.advId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZonePublishTagBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.descTruncateNum = parcel.readInt();
        this.protocol = parcel.readString();
        this.picUrl = parcel.readString();
        this.id = parcel.readString();
        this.uin = parcel.readString();
        this.time = parcel.readString();
        this.advId = parcel.readString();
    }
}
