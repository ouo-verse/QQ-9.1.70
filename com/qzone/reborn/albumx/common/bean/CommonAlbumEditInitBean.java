package com.qzone.reborn.albumx.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BBW\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u00a2\u0006\u0004\b;\u0010<B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b;\u0010=B\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\u0018\u00a2\u0006\u0004\b;\u0010>B!\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\u0005\u00a2\u0006\u0004\b;\u0010?B1\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u00a2\u0006\u0004\b;\u0010@J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\t\u0010\u0011\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0013\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0014\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0015H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0018H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u0005H\u00c6\u0001R\u0017\u0010\u001d\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u001e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b+\u0010*R\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010(\u001a\u0004\b,\u0010*R\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010(\u001a\u0004\b-\u0010*R\u0017\u0010!\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b!\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\"\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b\"\u00102R\u0017\u0010#\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b#\u00103\u001a\u0004\b4\u00105R\u0017\u0010$\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b$\u00101\u001a\u0004\b6\u00102R\u0017\u0010%\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b%\u00101\u001a\u0004\b7\u00102R\u0017\u0010&\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b&\u00101\u001a\u0004\b&\u00102R\u0014\u00109\u001a\u0002088\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "", "other", "", "equals", "", "hashCode", "", "toString", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "component1", "component2", "component3", "component4", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "component5", "component6", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "component7", "component8", "component9", "component10", "bizId", "albumId", AEEditorConstants.ALBUMNAME, "albumDesc", "albumCover", "isStickTop", "albumInfo", "hasTopRight", "hasDeleteRight", "isEmptyAlbum", "copy", "Ljava/lang/String;", "getBizId", "()Ljava/lang/String;", "getAlbumId", "getAlbumName", "getAlbumDesc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "getAlbumCover", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Z", "()Z", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getHasTopRight", "getHasDeleteRight", "", "serialVersionUID", "J", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;ZLcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;ZZZ)V", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Z)V", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;ZZZ)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumEditInitBean implements Serializable, Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CommonStMedia albumCover;
    private final String albumDesc;
    private final String albumId;
    private final CommonAlbumInfo albumInfo;
    private final String albumName;
    private final String bizId;
    private final boolean hasDeleteRight;
    private final boolean hasTopRight;
    private final boolean isEmptyAlbum;
    private final boolean isStickTop;
    private final long serialVersionUID;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonAlbumEditInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonAlbumEditInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonAlbumEditInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonAlbumEditInitBean[] newArray(int size) {
            return new CommonAlbumEditInitBean[size];
        }

        Companion() {
        }
    }

    public CommonAlbumEditInitBean(String bizId, String albumId, String albumName, String albumDesc, CommonStMedia albumCover, boolean z16, CommonAlbumInfo albumInfo, boolean z17, boolean z18, boolean z19) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(albumDesc, "albumDesc");
        Intrinsics.checkNotNullParameter(albumCover, "albumCover");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.bizId = bizId;
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumDesc = albumDesc;
        this.albumCover = albumCover;
        this.isStickTop = z16;
        this.albumInfo = albumInfo;
        this.hasTopRight = z17;
        this.hasDeleteRight = z18;
        this.isEmptyAlbum = z19;
        this.serialVersionUID = 1521697345242559100L;
    }

    /* renamed from: component1, reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsEmptyAlbum() {
        return this.isEmptyAlbum;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAlbumDesc() {
        return this.albumDesc;
    }

    /* renamed from: component5, reason: from getter */
    public final CommonStMedia getAlbumCover() {
        return this.albumCover;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsStickTop() {
        return this.isStickTop;
    }

    /* renamed from: component7, reason: from getter */
    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getHasTopRight() {
        return this.hasTopRight;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getHasDeleteRight() {
        return this.hasDeleteRight;
    }

    public final CommonAlbumEditInitBean copy(String bizId, String albumId, String albumName, String albumDesc, CommonStMedia albumCover, boolean isStickTop, CommonAlbumInfo albumInfo, boolean hasTopRight, boolean hasDeleteRight, boolean isEmptyAlbum) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(albumDesc, "albumDesc");
        Intrinsics.checkNotNullParameter(albumCover, "albumCover");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        return new CommonAlbumEditInitBean(bizId, albumId, albumName, albumDesc, albumCover, isStickTop, albumInfo, hasTopRight, hasDeleteRight, isEmptyAlbum);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CommonStMedia getAlbumCover() {
        return this.albumCover;
    }

    public final String getAlbumDesc() {
        return this.albumDesc;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final boolean getHasDeleteRight() {
        return this.hasDeleteRight;
    }

    public final boolean getHasTopRight() {
        return this.hasTopRight;
    }

    public int hashCode() {
        return (((((((((this.bizId.hashCode() * 31) + this.albumId.hashCode()) * 31) + this.albumName.hashCode()) * 31) + this.albumDesc.hashCode()) * 31) + k9.a.e(this.albumCover, 0, 1, null).hashCode()) * 31) + c.a(this.isStickTop);
    }

    public final boolean isEmptyAlbum() {
        return this.isEmptyAlbum;
    }

    public final boolean isStickTop() {
        return this.isStickTop;
    }

    public String toString() {
        return "CommonAlbumEditInitBean(bizId=" + this.bizId + ", albumId=" + this.albumId + ", albumName=" + this.albumName + ", albumDesc=" + this.albumDesc + ", albumCover=" + k9.a.e(this.albumCover, 0, 1, null) + ", isStickTop=" + this.isStickTop + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.bizId);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeString(this.albumDesc);
        parcel.writeParcelable(this.albumCover, flags);
        parcel.writeByte(this.isStickTop ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.albumInfo, flags);
        parcel.writeByte(this.hasTopRight ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasDeleteRight ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEmptyAlbum ? (byte) 1 : (byte) 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(CommonAlbumEditInitBean.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean");
        CommonAlbumEditInitBean commonAlbumEditInitBean = (CommonAlbumEditInitBean) other;
        return Intrinsics.areEqual(this.bizId, commonAlbumEditInitBean.bizId) && Intrinsics.areEqual(this.albumId, commonAlbumEditInitBean.albumId) && Intrinsics.areEqual(this.albumName, commonAlbumEditInitBean.albumName) && Intrinsics.areEqual(this.albumDesc, commonAlbumEditInitBean.albumDesc) && Intrinsics.areEqual(k9.a.e(this.albumCover, 0, 1, null), k9.a.e(commonAlbumEditInitBean.albumCover, 0, 1, null)) && this.isStickTop == commonAlbumEditInitBean.isStickTop && this.hasTopRight == commonAlbumEditInitBean.hasTopRight && this.hasDeleteRight == commonAlbumEditInitBean.hasDeleteRight && this.isEmptyAlbum == commonAlbumEditInitBean.isEmptyAlbum && Intrinsics.areEqual(this.albumInfo, commonAlbumEditInitBean.albumInfo);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommonAlbumEditInitBean(Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r0 == null ? new CommonAlbumInfo() : r0, parcel.readByte() != 0, parcel.readByte() != 0, parcel.readByte() != 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        CommonStMedia commonStMedia = (CommonStMedia) parcel.readParcelable(CommonStMedia.class.getClassLoader());
        CommonStMedia commonStMedia2 = commonStMedia == null ? new CommonStMedia() : commonStMedia;
        boolean z16 = parcel.readByte() != 0;
        CommonAlbumInfo commonAlbumInfo = (CommonAlbumInfo) parcel.readParcelable(CommonAlbumInfo.class.getClassLoader());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonAlbumEditInitBean(String bizId, CommonAlbumInfo albumInfo) {
        this(bizId, albumInfo.getAlbumId(), albumInfo.getName(), albumInfo.getDesc(), albumInfo.getCover(), albumInfo.getTopFlag() == 1, albumInfo, false, false, false);
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonAlbumEditInitBean(String bizId, CommonAlbumInfo albumInfo, boolean z16) {
        this(bizId, albumInfo.getAlbumId(), albumInfo.getName(), albumInfo.getDesc(), albumInfo.getCover(), albumInfo.getTopFlag() == 1, albumInfo, false, z16, false);
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonAlbumEditInitBean(String bizId, CommonAlbumInfo albumInfo, boolean z16, boolean z17, boolean z18) {
        this(bizId, albumInfo.getAlbumId(), albumInfo.getName(), albumInfo.getDesc(), albumInfo.getCover(), albumInfo.getTopFlag() == 1, albumInfo, z16, z17, z18);
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
    }
}
