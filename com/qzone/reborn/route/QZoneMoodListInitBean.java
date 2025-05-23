package com.qzone.reborn.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u0000 *2\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001aR\"\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b\u0014\u0010\u001aR\"\u0010&\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u001a\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "J", "e", "()J", "uin", "", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "nickName", "f", "c", "refer", h.F, "getBottomBubbleText", "g", "(Ljava/lang/String;)V", "bottomBubbleText", "i", "getBottomBubbleUrl", "j", "bottomBubbleUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getBottomBubbleIcon", "bottomBubbleIcon", BdhLogUtil.LogTag.Tag_Conn, "b", "k", "praiseBubbleText", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneMoodListInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String praiseBubbleText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String nickName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String refer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String bottomBubbleText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String bottomBubbleUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String bottomBubbleIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/route/QZoneMoodListInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.route.QZoneMoodListInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZoneMoodListInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZoneMoodListInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZoneMoodListInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneMoodListInitBean[] newArray(int size) {
            return new QZoneMoodListInitBean[size];
        }

        Companion() {
        }
    }

    public QZoneMoodListInitBean(long j3, String nickName, String refer) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(refer, "refer");
        this.uin = j3;
        this.nickName = nickName;
        this.refer = refer;
        this.bottomBubbleText = "";
        this.bottomBubbleUrl = "";
        this.bottomBubbleIcon = "";
        this.praiseBubbleText = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: b, reason: from getter */
    public final String getPraiseBubbleText() {
        return this.praiseBubbleText;
    }

    /* renamed from: c, reason: from getter */
    public final String getRefer() {
        return this.refer;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bottomBubbleIcon = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bottomBubbleText = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bottomBubbleUrl = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.praiseBubbleText = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.uin);
        parcel.writeString(this.nickName);
        parcel.writeString(this.refer);
        parcel.writeString(this.bottomBubbleText);
        parcel.writeString(this.bottomBubbleUrl);
        parcel.writeString(this.bottomBubbleIcon);
        parcel.writeString(this.praiseBubbleText);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QZoneMoodListInitBean(Parcel parcel) {
        this(r0, r2, r4 == null ? "" : r4);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        long readLong = parcel.readLong();
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        this.bottomBubbleText = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.bottomBubbleUrl = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.bottomBubbleIcon = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.praiseBubbleText = readString6 != null ? readString6 : "";
    }
}
