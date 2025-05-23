package com.qzone.reborn.groupalbum.reship.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B9\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\n\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001e\u0010 J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "albumId", "getAlbumId", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfoList", "Ljava/util/List;", "getAlbumInfoList", "()Ljava/util/List;", "", "hasMore", "Z", "getHasMore", "()Z", "attachInfo", "getAttachInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipSelectInitBean extends GroupAlbumInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String albumId;
    private final List<CommonAlbumInfo> albumInfoList;
    private final String attachInfo;
    private final String groupId;
    private final boolean hasMore;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipSelectInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<GroupAlbumReshipSelectInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupAlbumReshipSelectInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupAlbumReshipSelectInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupAlbumReshipSelectInitBean[] newArray(int size) {
            return new GroupAlbumReshipSelectInitBean[size];
        }

        Companion() {
        }
    }

    public /* synthetic */ GroupAlbumReshipSelectInitBean(String str, String str2, List list, boolean z16, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, list, z16, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final List<CommonAlbumInfo> getAlbumInfoList() {
        return this.albumInfoList;
    }

    public final String getAttachInfo() {
        return this.attachInfo;
    }

    @Override // com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean
    public String getGroupId() {
        return this.groupId;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getGroupId());
        parcel.writeString(this.albumId);
        parcel.writeTypedList(this.albumInfoList);
        parcel.writeByte(this.hasMore ? (byte) 1 : (byte) 0);
        parcel.writeString(this.attachInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumReshipSelectInitBean(String groupId, String str, List<CommonAlbumInfo> albumInfoList, boolean z16, String attachInfo) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumInfoList, "albumInfoList");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.groupId = groupId;
        this.albumId = str;
        this.albumInfoList = albumInfoList;
        this.hasMore = z16;
        this.attachInfo = attachInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GroupAlbumReshipSelectInitBean(Parcel parcel) {
        this(r3, r4, r5, r6, r9 == null ? "" : r9);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, CommonAlbumInfo.INSTANCE);
        Unit unit = Unit.INSTANCE;
        boolean z16 = parcel.readByte() != 0;
        String readString3 = parcel.readString();
    }
}
