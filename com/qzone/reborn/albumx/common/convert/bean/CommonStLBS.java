package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \"2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001f\u0010 B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStGPS;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStGPS;", "b", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStGPS;", "g", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStGPS;)V", "gps", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "location", "f", "c", "j", "lbsId", h.F, "a", "address", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStLBS implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonStGPS gps;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String location;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String lbsId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String address;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStLBS$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStLBS> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStLBS createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStLBS(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStLBS[] newArray(int size) {
            return new CommonStLBS[size];
        }

        Companion() {
        }
    }

    public CommonStLBS() {
        this.gps = new CommonStGPS();
        this.location = "";
        this.lbsId = "";
        this.address = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: b, reason: from getter */
    public final CommonStGPS getGps() {
        return this.gps;
    }

    /* renamed from: c, reason: from getter */
    public final String getLbsId() {
        return this.lbsId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final void g(CommonStGPS commonStGPS) {
        Intrinsics.checkNotNullParameter(commonStGPS, "<set-?>");
        this.gps = commonStGPS;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lbsId = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.gps, flags);
        parcel.writeString(this.location);
        parcel.writeString(this.lbsId);
        parcel.writeString(this.address);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStLBS(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CommonStGPS commonStGPS = (CommonStGPS) parcel.readParcelable(CommonStGPS.class.getClassLoader());
        this.gps = commonStGPS == null ? new CommonStGPS() : commonStGPS;
        String readString = parcel.readString();
        this.location = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.lbsId = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.address = readString3 != null ? readString3 : "";
    }
}
