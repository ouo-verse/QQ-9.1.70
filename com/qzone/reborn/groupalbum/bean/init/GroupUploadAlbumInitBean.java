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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B7\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b-\u0010/J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "spaceType", "I", "getSpaceType", "()I", "", "isLaunchSelectPhotoPage", "Z", "()Z", "setLaunchSelectPhotoPage", "(Z)V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", IProfileCardConst.KEY_FROM_TYPE, "getFromType", "insertSpacePage", "getInsertSpacePage", "setInsertSpacePage", "(I)V", "adId", "getAdId", "setAdId", "(Ljava/lang/String;)V", "fromArk", "getFromArk", "setFromArk", "<init>", "(Ljava/lang/String;IZLcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupUploadAlbumInitBean extends GroupAlbumInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String adId;
    private CommonAlbumInfo albumInfo;
    private boolean fromArk;
    private final int fromType;
    private final String groupId;
    private int insertSpacePage;
    private boolean isLaunchSelectPhotoPage;
    private final int spaceType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<GroupUploadAlbumInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupUploadAlbumInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupUploadAlbumInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupUploadAlbumInitBean[] newArray(int size) {
            return new GroupUploadAlbumInitBean[size];
        }

        Companion() {
        }
    }

    public /* synthetic */ GroupUploadAlbumInitBean(String str, int i3, boolean z16, CommonAlbumInfo commonAlbumInfo, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i17 & 4) != 0 ? true : z16, (i17 & 8) != 0 ? null : commonAlbumInfo, (i17 & 16) != 0 ? 0 : i16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final boolean getFromArk() {
        return this.fromArk;
    }

    public final int getFromType() {
        return this.fromType;
    }

    @Override // com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean
    public String getGroupId() {
        return this.groupId;
    }

    public final int getInsertSpacePage() {
        return this.insertSpacePage;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    /* renamed from: isLaunchSelectPhotoPage, reason: from getter */
    public final boolean getIsLaunchSelectPhotoPage() {
        return this.isLaunchSelectPhotoPage;
    }

    public final void setAdId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void setAlbumInfo(CommonAlbumInfo commonAlbumInfo) {
        this.albumInfo = commonAlbumInfo;
    }

    public final void setFromArk(boolean z16) {
        this.fromArk = z16;
    }

    public final void setInsertSpacePage(int i3) {
        this.insertSpacePage = i3;
    }

    public final void setLaunchSelectPhotoPage(boolean z16) {
        this.isLaunchSelectPhotoPage = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getGroupId());
        parcel.writeInt(this.spaceType);
        parcel.writeByte(this.isLaunchSelectPhotoPage ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.albumInfo, flags);
        parcel.writeInt(this.fromType);
        parcel.writeInt(this.insertSpacePage);
        parcel.writeString(this.adId);
        parcel.writeByte(this.fromArk ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupUploadAlbumInitBean(String groupId, int i3, boolean z16, CommonAlbumInfo commonAlbumInfo, int i16) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
        this.spaceType = i3;
        this.isLaunchSelectPhotoPage = z16;
        this.albumInfo = commonAlbumInfo;
        this.fromType = i16;
        this.adId = "";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GroupUploadAlbumInitBean(Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readInt(), parcel.readByte() != 0, (CommonAlbumInfo) parcel.readParcelable(CommonAlbumInfo.class.getClassLoader()), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.insertSpacePage = parcel.readInt();
        String readString2 = parcel.readString();
        this.adId = readString2 != null ? readString2 : "";
        this.fromArk = parcel.readByte() != 0;
    }
}
