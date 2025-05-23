package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b\u001a\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "b", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "g", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", "owner", "e", "I", "c", "()I", "j", "(I)V", "shareNums", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "f", "Ljava/util/List;", "()Ljava/util/List;", "k", "(Ljava/util/List;)V", "shareattrs", "", h.F, "Z", "a", "()Z", "(Z)V", "autoJoin", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonShareAlbumMeta implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonStUser owner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int shareNums;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<CommonClientAttr> shareattrs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean autoJoin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonShareAlbumMeta$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonShareAlbumMeta> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonShareAlbumMeta createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonShareAlbumMeta(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonShareAlbumMeta[] newArray(int size) {
            return new CommonShareAlbumMeta[size];
        }

        Companion() {
        }
    }

    public CommonShareAlbumMeta() {
        this.owner = new CommonStUser();
        this.shareattrs = new ArrayList();
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAutoJoin() {
        return this.autoJoin;
    }

    /* renamed from: b, reason: from getter */
    public final CommonStUser getOwner() {
        return this.owner;
    }

    /* renamed from: c, reason: from getter */
    public final int getShareNums() {
        return this.shareNums;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<CommonClientAttr> e() {
        return this.shareattrs;
    }

    public final void f(boolean z16) {
        this.autoJoin = z16;
    }

    public final void g(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.owner = commonStUser;
    }

    public final void j(int i3) {
        this.shareNums = i3;
    }

    public final void k(List<CommonClientAttr> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.shareattrs = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.owner, flags);
        parcel.writeInt(this.shareNums);
        parcel.writeTypedList(this.shareattrs);
        parcel.writeInt(this.autoJoin ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonShareAlbumMeta(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CommonStUser commonStUser = (CommonStUser) parcel.readParcelable(CommonStUser.class.getClassLoader());
        this.owner = commonStUser == null ? new CommonStUser() : commonStUser;
        this.shareNums = parcel.readInt();
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonClientAttr.INSTANCE);
        this.shareattrs = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
        this.autoJoin = parcel.readInt() == 1;
    }
}
