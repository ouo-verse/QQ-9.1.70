package com.qzone.reborn.groupalbum.bean.init;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001cJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", IProfileCardConst.KEY_FROM_TYPE, "I", "getFromType", "()I", "<init>", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupChatHistoryMediaSelectInitBean extends GroupAlbumInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CommonAlbumInfo albumInfo;
    private final int fromType;
    private final String groupId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.bean.init.GroupChatHistoryMediaSelectInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<GroupChatHistoryMediaSelectInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupChatHistoryMediaSelectInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupChatHistoryMediaSelectInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupChatHistoryMediaSelectInitBean[] newArray(int size) {
            return new GroupChatHistoryMediaSelectInitBean[size];
        }

        Companion() {
        }
    }

    public /* synthetic */ GroupChatHistoryMediaSelectInitBean(String str, CommonAlbumInfo commonAlbumInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? null : commonAlbumInfo, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final int getFromType() {
        return this.fromType;
    }

    @Override // com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean
    public String getGroupId() {
        return this.groupId;
    }

    public final void setAlbumInfo(CommonAlbumInfo commonAlbumInfo) {
        this.albumInfo = commonAlbumInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getGroupId());
        parcel.writeParcelable(this.albumInfo, flags);
        parcel.writeInt(this.fromType);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatHistoryMediaSelectInitBean(String groupId, CommonAlbumInfo commonAlbumInfo, int i3) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
        this.albumInfo = commonAlbumInfo;
        this.fromType = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GroupChatHistoryMediaSelectInitBean(Parcel parcel) {
        this(r0 == null ? "" : r0, (CommonAlbumInfo) parcel.readParcelable(CommonAlbumInfo.class.getClassLoader()), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
