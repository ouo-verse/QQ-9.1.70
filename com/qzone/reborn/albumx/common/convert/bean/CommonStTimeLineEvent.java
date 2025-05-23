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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 =2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b:\u0010;B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b:\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b(\u0010\u0010R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b\u0019\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010\u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "getType", "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "type", "e", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "title", "f", DomainData.DOMAIN_NAME, "content", h.F, "a", "k", "attachInfo", "", "i", "J", "b", "()J", "l", "(J)V", "beginTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "p", "endTime", BdhLogUtil.LogTag.Tag_Conn, "c", "bindingType", "", "D", "Z", "()Z", "o", "(Z)V", "disable", "E", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "itemCount", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStTimeLineEvent implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int bindingType;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean disable;

    /* renamed from: E, reason: from kotlin metadata */
    private int itemCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String content;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String attachInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long beginTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStTimeLineEvent> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStTimeLineEvent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStTimeLineEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStTimeLineEvent[] newArray(int size) {
            return new CommonStTimeLineEvent[size];
        }

        Companion() {
        }
    }

    public CommonStTimeLineEvent() {
        this.title = "";
        this.content = "";
        this.attachInfo = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    /* renamed from: b, reason: from getter */
    public final long getBeginTime() {
        return this.beginTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getBindingType() {
        return this.bindingType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getDisable() {
        return this.disable;
    }

    /* renamed from: g, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: j, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachInfo = str;
    }

    public final void l(long j3) {
        this.beginTime = j3;
    }

    public final void m(int i3) {
        this.bindingType = i3;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void o(boolean z16) {
        this.disable = z16;
    }

    public final void p(long j3) {
        this.endTime = j3;
    }

    public final void q(int i3) {
        this.itemCount = i3;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void s(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "CommonStTimeLineEvent(type:" + this.type + "| title:" + this.title + "| content:" + this.content + "| attachInfo:" + this.attachInfo + "| beginTime:" + this.beginTime + "| endTime:" + this.endTime + " )";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.attachInfo);
        parcel.writeLong(this.beginTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.bindingType);
        parcel.writeByte(this.disable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.itemCount);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStTimeLineEvent(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.type = parcel.readInt();
        String readString = parcel.readString();
        this.title = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.content = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.attachInfo = readString3 != null ? readString3 : "";
        this.beginTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.bindingType = parcel.readInt();
        this.disable = parcel.readByte() != 0;
        this.itemCount = parcel.readInt();
    }
}
