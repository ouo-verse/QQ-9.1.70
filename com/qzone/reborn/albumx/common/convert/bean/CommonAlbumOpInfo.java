package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "b", "()I", "g", "(I)V", "lastDeleteTime", "e", "a", "f", "lastDeleteCount", "", "Z", "()Z", "k", "(Z)V", "recentlyUpdated", h.F, "c", "j", "prohibitModifyAlbumType", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumOpInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int lastDeleteTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastDeleteCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean recentlyUpdated;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean prohibitModifyAlbumType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonAlbumOpInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonAlbumOpInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonAlbumOpInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonAlbumOpInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonAlbumOpInfo[] newArray(int size) {
            return new CommonAlbumOpInfo[size];
        }

        Companion() {
        }
    }

    public CommonAlbumOpInfo() {
    }

    /* renamed from: a, reason: from getter */
    public final int getLastDeleteCount() {
        return this.lastDeleteCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getLastDeleteTime() {
        return this.lastDeleteTime;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getProhibitModifyAlbumType() {
        return this.prohibitModifyAlbumType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRecentlyUpdated() {
        return this.recentlyUpdated;
    }

    public final void f(int i3) {
        this.lastDeleteCount = i3;
    }

    public final void g(int i3) {
        this.lastDeleteTime = i3;
    }

    public final void j(boolean z16) {
        this.prohibitModifyAlbumType = z16;
    }

    public final void k(boolean z16) {
        this.recentlyUpdated = z16;
    }

    public String toString() {
        return "CommonAlbumOpInfo(lastDeleteTime:" + this.lastDeleteTime + "| lastDeleteCount:" + this.lastDeleteCount + "| recentlyUpdated:" + this.recentlyUpdated + "| prohibitModifyAlbumType:" + this.prohibitModifyAlbumType + "| )";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.lastDeleteTime);
        parcel.writeInt(this.lastDeleteCount);
        parcel.writeInt(this.recentlyUpdated ? 1 : 0);
        parcel.writeInt(this.prohibitModifyAlbumType ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonAlbumOpInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.lastDeleteTime = parcel.readInt();
        this.lastDeleteCount = parcel.readInt();
        this.recentlyUpdated = parcel.readInt() == 1;
        this.prohibitModifyAlbumType = parcel.readInt() == 1;
    }
}
