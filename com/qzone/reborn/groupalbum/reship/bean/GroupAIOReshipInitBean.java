package com.qzone.reborn.groupalbum.reship.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB%\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001cJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "Lcooperation/qzone/model/ForwardGroupAlbumBean;", "date", "Lcooperation/qzone/model/ForwardGroupAlbumBean;", "getDate", "()Lcooperation/qzone/model/ForwardGroupAlbumBean;", IProfileCardConst.KEY_FROM_TYPE, "I", "getFromType", "()I", "<init>", "(Ljava/lang/String;Lcooperation/qzone/model/ForwardGroupAlbumBean;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAIOReshipInitBean extends GroupAlbumInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ForwardGroupAlbumBean date;
    private final int fromType;
    private final String groupId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.reship.bean.GroupAIOReshipInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<GroupAIOReshipInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupAIOReshipInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupAIOReshipInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupAIOReshipInitBean[] newArray(int size) {
            return new GroupAIOReshipInitBean[size];
        }

        Companion() {
        }
    }

    public /* synthetic */ GroupAIOReshipInitBean(String str, ForwardGroupAlbumBean forwardGroupAlbumBean, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? null : forwardGroupAlbumBean, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        ForwardGroupAlbumBean forwardGroupAlbumBean = this.date;
        if (forwardGroupAlbumBean == null) {
            return null;
        }
        String str = forwardGroupAlbumBean.albumId;
        if (str == null || str.length() == 0) {
            return null;
        }
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String str2 = this.date.albumId;
        Intrinsics.checkNotNullExpressionValue(str2, "date.albumId");
        commonAlbumInfo.V(str2);
        String str3 = this.date.albumName;
        Intrinsics.checkNotNullExpressionValue(str3, "date.albumName");
        commonAlbumInfo.m0(str3);
        return commonAlbumInfo;
    }

    public final ForwardGroupAlbumBean getDate() {
        return this.date;
    }

    public final int getFromType() {
        return this.fromType;
    }

    @Override // com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean
    public String getGroupId() {
        return this.groupId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getGroupId());
        parcel.writeParcelable(this.date, flags);
        parcel.writeInt(this.fromType);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAIOReshipInitBean(String groupId, ForwardGroupAlbumBean forwardGroupAlbumBean, int i3) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
        this.date = forwardGroupAlbumBean;
        this.fromType = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GroupAIOReshipInitBean(Parcel parcel) {
        this(r0 == null ? "" : r0, (ForwardGroupAlbumBean) parcel.readParcelable(ForwardGroupAlbumBean.class.getClassLoader()), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
