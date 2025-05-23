package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b,\u0010-B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0012\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0016R2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t0\u001cj\b\u0012\u0004\u0012\u00020\t`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b\u0018\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", "getAlbumLbs", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", "b", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;)V", "albumLbs", "", "e", "Ljava/lang/String;", "getStartDescription", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "startDescription", "f", "getEndDescription", "c", "endDescription", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setLbsAreas", "(Ljava/util/ArrayList;)V", "lbsAreas", "", "i", "J", "getStartShootTime", "()J", "(J)V", "startShootTime", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonMediaLbsAreaList implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonMediaLbsArea albumLbs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String startDescription;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String endDescription;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CommonMediaLbsArea> lbsAreas;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long startShootTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonMediaLbsAreaList> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonMediaLbsAreaList createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonMediaLbsAreaList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonMediaLbsAreaList[] newArray(int size) {
            return new CommonMediaLbsAreaList[size];
        }

        Companion() {
        }
    }

    public CommonMediaLbsAreaList() {
        this.albumLbs = new CommonMediaLbsArea();
        this.startDescription = "";
        this.endDescription = "";
        this.lbsAreas = new ArrayList<>();
    }

    public final ArrayList<CommonMediaLbsArea> a() {
        return this.lbsAreas;
    }

    public final void b(CommonMediaLbsArea commonMediaLbsArea) {
        Intrinsics.checkNotNullParameter(commonMediaLbsArea, "<set-?>");
        this.albumLbs = commonMediaLbsArea;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endDescription = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startDescription = str;
    }

    public final void f(long j3) {
        this.startShootTime = j3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.albumLbs, flags);
        parcel.writeString(this.startDescription);
        parcel.writeString(this.endDescription);
        parcel.writeLong(this.startShootTime);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonMediaLbsAreaList(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CommonMediaLbsArea commonMediaLbsArea = (CommonMediaLbsArea) parcel.readParcelable(CommonMediaLbsArea.class.getClassLoader());
        this.albumLbs = commonMediaLbsArea == null ? new CommonMediaLbsArea() : commonMediaLbsArea;
        String readString = parcel.readString();
        this.startDescription = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.endDescription = readString2 != null ? readString2 : "";
        this.startShootTime = parcel.readLong();
    }
}
