package com.qzone.reborn.groupalbum.reship.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B9\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u0005\u00a2\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b%\u0010'J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "isReshipBySourceBatchId", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "mediaList", "Ljava/util/List;", "getMediaList", "()Ljava/util/List;", "", "sourceBatchId", "J", "getSourceBatchId", "()J", "overLimitNum", "I", "getOverLimitNum", "()I", "<init>", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Ljava/util/List;JI)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipInitBean extends GroupAlbumInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CommonAlbumInfo albumInfo;
    private final String groupId;
    private final List<CommonStMedia> mediaList;
    private final int overLimitNum;
    private final long sourceBatchId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<GroupAlbumReshipInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupAlbumReshipInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupAlbumReshipInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupAlbumReshipInitBean[] newArray(int size) {
            return new GroupAlbumReshipInitBean[size];
        }

        Companion() {
        }
    }

    public /* synthetic */ GroupAlbumReshipInitBean(String str, CommonAlbumInfo commonAlbumInfo, List list, long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? null : commonAlbumInfo, list, j3, i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    @Override // com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean
    public String getGroupId() {
        return this.groupId;
    }

    public final List<CommonStMedia> getMediaList() {
        return this.mediaList;
    }

    public final int getOverLimitNum() {
        return this.overLimitNum;
    }

    public final long getSourceBatchId() {
        return this.sourceBatchId;
    }

    public final boolean isReshipBySourceBatchId() {
        return this.sourceBatchId != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getGroupId());
        parcel.writeParcelable(this.albumInfo, flags);
        parcel.writeTypedList(this.mediaList);
        parcel.writeLong(this.sourceBatchId);
        parcel.writeInt(this.overLimitNum);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumReshipInitBean(String groupId, CommonAlbumInfo commonAlbumInfo, List<CommonStMedia> mediaList, long j3, int i3) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.groupId = groupId;
        this.albumInfo = commonAlbumInfo;
        this.mediaList = mediaList;
        this.sourceBatchId = j3;
        this.overLimitNum = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GroupAlbumReshipInitBean(Parcel parcel) {
        this(r2, r3, r4, parcel.readLong(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        CommonAlbumInfo commonAlbumInfo = (CommonAlbumInfo) parcel.readParcelable(CommonAlbumInfo.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, CommonStMedia.INSTANCE);
        Unit unit = Unit.INSTANCE;
    }
}
